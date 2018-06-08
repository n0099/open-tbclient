package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private a biT = new a();

    public b() {
        Pt();
    }

    private void Pt() {
        File[] listFiles;
        File file = new File(i.bjF);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.ia(file2.getName());
                    dVar.setAccessTime(hX(file2.getAbsolutePath()));
                    dVar.ay(m.il(file2.getName()));
                    this.biT.a(dVar);
                }
            }
            Collections.sort(this.biT.Pq(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hX(String str) {
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
                        TiebaStatic.log(new am("c12028").ah("errormsg", "获取缓存文件的Access时间出现异常").ah("error", e.getMessage()).ah("name", file.getAbsolutePath()));
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

    public void hY(String str) {
        d dVar;
        String in = m.in(str);
        if (in != null && !in.isEmpty()) {
            hZ(in);
            if (this.biT != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.biT.Ps()) {
                        dVar = null;
                        break;
                    }
                    d gj = this.biT.gj((this.biT.Ps() - 1) - i);
                    if (gj != null && gj.getFileName() != null && gj.getFileName().equals(in)) {
                        dVar = gj;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.biT.b(dVar);
                } else {
                    dVar = new d();
                    dVar.ia(in);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(in, currentTimeMillis2);
                dVar.setAccessTime(currentTimeMillis2);
                dVar.ay(m.il(in));
                this.biT.a(dVar);
                j.aB(TAG, "total cache size: " + ((this.biT.Pr() / 1024) / 1024) + "M list size " + this.biT.Ps());
                if (this.biT.Pr() > 629145600) {
                    while (this.biT.Pr() > 524288000 && this.biT.Ps() > 2 && Pu()) {
                    }
                    Pw();
                }
                if (m.PL() < 314572800) {
                    while (m.PL() < 419430400 && this.biT.Ps() > 2 && Pu()) {
                    }
                    Pw();
                }
                j.aB(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Pu() {
        d gj = this.biT.gj(0);
        if (gj == null || !(e.PA().ib(gj.getFileName()) || e.PA().ie(gj.getFileName()))) {
            this.biT.remove(0);
            if (gj != null) {
                File file = new File(i.bjG + gj.getFileName());
                j.aB(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bjG + str);
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
            TiebaStatic.log(new am("c12028").ah("errormsg", "修改缓存文件的Access时间出现异常").ah("error", e.getMessage()).ah("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void Pv() {
        if (this.biT != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.biT.Ps() - 2; i++) {
                d gj = this.biT.gj(i);
                if (gj != null) {
                    if (currentTimeMillis - gj.getAccessTime() < 86400000) {
                        break;
                    }
                    arrayList.add(gj);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.PA().ib(dVar.getFileName()) && !e.PA().ie(dVar.getFileName()))) {
                    this.biT.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bjG + dVar.getFileName());
                        j.aB(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            Pw();
        }
    }

    private void hZ(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bjG + str + "/completed");
                    File file2 = new File(i.bjG + str + "/segments");
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
        if (this.biT != null) {
            while (this.biT.Ps() > 0 && Pu()) {
            }
            Pw();
        }
    }

    private void Pw() {
        File[] listFiles;
        File file = new File(i.bjF);
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
