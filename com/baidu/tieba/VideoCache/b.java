package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
    private a bQH = new a();

    public b() {
        Ty();
    }

    private void Ty() {
        File[] listFiles;
        File file = new File(i.bRt);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hI(file2.getName());
                    dVar.aC(hF(file2.getAbsolutePath()));
                    dVar.aD(m.hS(file2.getName()));
                    this.bQH.a(dVar);
                }
            }
            Collections.sort(this.bQH.Tv(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hF(String str) {
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
                        TiebaStatic.log(new ak("c12028").ab("errormsg", "获取缓存文件的Access时间出现异常").ab("error", e.getMessage()).ab("name", file.getAbsolutePath()));
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

    public void hG(String str) {
        d dVar;
        String hU = m.hU(str);
        if (hU != null && !hU.isEmpty()) {
            hH(hU);
            if (this.bQH != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bQH.Tx()) {
                        dVar = null;
                        break;
                    }
                    d jj = this.bQH.jj((this.bQH.Tx() - 1) - i);
                    if (jj != null && jj.getFileName() != null && jj.getFileName().equals(hU)) {
                        dVar = jj;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bQH.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hI(hU);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hU, currentTimeMillis2);
                dVar.aC(currentTimeMillis2);
                dVar.aD(m.hS(hU));
                this.bQH.a(dVar);
                j.au(TAG, "total cache size: " + ((this.bQH.Tw() / 1024) / 1024) + "M list size " + this.bQH.Tx());
                if (this.bQH.Tw() > 629145600) {
                    while (this.bQH.Tw() > 524288000 && this.bQH.Tx() > 2 && Tz()) {
                    }
                    TB();
                }
                if (m.TR() < 314572800) {
                    while (m.TR() < 419430400 && this.bQH.Tx() > 2 && Tz()) {
                    }
                    TB();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Tz() {
        d jj = this.bQH.jj(0);
        if (jj == null || !(e.TG().hJ(jj.getFileName()) || e.TG().hL(jj.getFileName()))) {
            this.bQH.remove(0);
            if (jj != null) {
                File file = new File(i.bRu + jj.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bRu + str);
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
            TiebaStatic.log(new ak("c12028").ab("errormsg", "修改缓存文件的Access时间出现异常").ab("error", e.getMessage()).ab("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void TA() {
        if (this.bQH != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bQH.Tx() - 2; i++) {
                d jj = this.bQH.jj(i);
                if (jj != null) {
                    if (currentTimeMillis - jj.TE() < 86400000) {
                        break;
                    }
                    arrayList.add(jj);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.TG().hJ(dVar.getFileName()) && !e.TG().hL(dVar.getFileName()))) {
                    this.bQH.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bRu + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            TB();
        }
    }

    private void hH(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bRu + str + "/completed");
                    File file2 = new File(i.bRu + str + "/segments");
                    if (file.exists()) {
                        j.au(TAG, "delete segments");
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
        if (this.bQH != null) {
            while (this.bQH.Tx() > 0 && Tz()) {
            }
            TB();
        }
    }

    private void TB() {
        File[] listFiles;
        File file = new File(i.bRt);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.z(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.z(file2);
                    }
                }
            }
        }
    }
}
