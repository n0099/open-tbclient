package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a bkt = new a();

    public b() {
        PQ();
    }

    private void PQ() {
        File[] listFiles;
        File file = new File(i.ble);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.ig(file2.getName());
                    dVar.setAccessTime(ic(file2.getAbsolutePath()));
                    dVar.az(m.iq(file2.getName()));
                    this.bkt.a(dVar);
                }
            }
            Collections.sort(this.bkt.PN(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long ic(String str) {
        DataInputStream dataInputStream;
        FileInputStream fileInputStream;
        long j = 0;
        FileInputStream fileInputStream2 = null;
        if (str != null && !str.isEmpty()) {
            File file = new File(str + "/accesstime");
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        dataInputStream = new DataInputStream(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        dataInputStream = null;
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = null;
                        fileInputStream2 = fileInputStream;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = null;
                }
                try {
                    j = Long.parseLong(dataInputStream.readLine());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileInputStream2 = fileInputStream;
                    try {
                        TiebaStatic.log(new an("c12028").ah("errormsg", "获取缓存文件的Access时间出现异常").ah("error", e.getMessage()).ah("name", file.getAbsolutePath()));
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return j;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    throw th;
                }
            }
        }
        return j;
    }

    public void ie(String str) {
        d dVar;
        String is = m.is(str);
        if (is != null && !is.isEmpty()) {
            m15if(is);
            if (this.bkt != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bkt.PP()) {
                        dVar = null;
                        break;
                    }
                    d gk = this.bkt.gk((this.bkt.PP() - 1) - i);
                    if (gk != null && gk.getFileName() != null && gk.getFileName().equals(is)) {
                        dVar = gk;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bkt.b(dVar);
                } else {
                    dVar = new d();
                    dVar.ig(is);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(is, currentTimeMillis2);
                dVar.setAccessTime(currentTimeMillis2);
                dVar.az(m.iq(is));
                this.bkt.a(dVar);
                j.aB(TAG, "total cache size: " + ((this.bkt.PO() / 1024) / 1024) + "M list size " + this.bkt.PP());
                if (this.bkt.PO() > 629145600) {
                    while (this.bkt.PO() > 524288000 && this.bkt.PP() > 2 && PR()) {
                    }
                    PT();
                }
                if (m.Qi() < 314572800) {
                    while (m.Qi() < 419430400 && this.bkt.PP() > 2 && PR()) {
                    }
                    PT();
                }
                j.aB(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean PR() {
        d gk = this.bkt.gk(0);
        if (gk == null || !(e.PX().ih(gk.getFileName()) || e.PX().ij(gk.getFileName()))) {
            this.bkt.remove(0);
            if (gk != null) {
                File file = new File(i.blf + gk.getFileName());
                j.aB(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.blf + str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.getAbsolutePath() + "/accesstime");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
            bufferedWriter.write(j + "");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            TiebaStatic.log(new an("c12028").ah("errormsg", "修改缓存文件的Access时间出现异常").ah("error", e.getMessage()).ah("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void PS() {
        if (this.bkt != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bkt.PP() - 2; i++) {
                d gk = this.bkt.gk(i);
                if (gk != null) {
                    if (currentTimeMillis - gk.getAccessTime() < 86400000) {
                        break;
                    }
                    arrayList.add(gk);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.PX().ih(dVar.getFileName()) && !e.PX().ij(dVar.getFileName()))) {
                    this.bkt.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.blf + dVar.getFileName());
                        j.aB(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            PT();
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m15if(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.blf + str + "/completed");
                    File file2 = new File(i.blf + str + "/segments");
                    if (file.exists()) {
                        j.aB(TAG, "delete segments");
                        if (file2 != null && file2.exists() && file2.listFiles() != null) {
                            for (File file3 : file2.listFiles()) {
                                if (file3 != null && file3.exists()) {
                                    file3.delete();
                                }
                            }
                            file2.delete();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clearCache() {
        if (this.bkt != null) {
            while (this.bkt.PP() > 0 && PR()) {
            }
            PT();
        }
    }

    private void PT() {
        File[] listFiles;
        File file = new File(i.ble);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.y(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.y(file2);
                    }
                }
            }
        }
    }
}
