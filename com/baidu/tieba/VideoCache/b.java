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
    private a bOM = new a();

    public b() {
        SQ();
    }

    private void SQ() {
        File[] listFiles;
        File file = new File(i.bPy);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hz(file2.getName());
                    dVar.aC(hw(file2.getAbsolutePath()));
                    dVar.aD(m.hJ(file2.getName()));
                    this.bOM.a(dVar);
                }
            }
            Collections.sort(this.bOM.SN(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hw(String str) {
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
                        TiebaStatic.log(new ak("c12028").aa("errormsg", "获取缓存文件的Access时间出现异常").aa("error", e.getMessage()).aa("name", file.getAbsolutePath()));
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

    public void hx(String str) {
        d dVar;
        String hL = m.hL(str);
        if (hL != null && !hL.isEmpty()) {
            hy(hL);
            if (this.bOM != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bOM.SP()) {
                        dVar = null;
                        break;
                    }
                    d jn = this.bOM.jn((this.bOM.SP() - 1) - i);
                    if (jn != null && jn.getFileName() != null && jn.getFileName().equals(hL)) {
                        dVar = jn;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bOM.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hz(hL);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hL, currentTimeMillis2);
                dVar.aC(currentTimeMillis2);
                dVar.aD(m.hJ(hL));
                this.bOM.a(dVar);
                j.at(TAG, "total cache size: " + ((this.bOM.SO() / 1024) / 1024) + "M list size " + this.bOM.SP());
                if (this.bOM.SO() > 629145600) {
                    while (this.bOM.SO() > 524288000 && this.bOM.SP() > 2 && SR()) {
                    }
                    ST();
                }
                if (m.Tj() < 314572800) {
                    while (m.Tj() < 419430400 && this.bOM.SP() > 2 && SR()) {
                    }
                    ST();
                }
                j.at(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean SR() {
        d jn = this.bOM.jn(0);
        if (jn == null || !(e.SY().hA(jn.getFileName()) || e.SY().hC(jn.getFileName()))) {
            this.bOM.remove(0);
            if (jn != null) {
                File file = new File(i.bPz + jn.getFileName());
                j.at(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bPz + str);
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
            TiebaStatic.log(new ak("c12028").aa("errormsg", "修改缓存文件的Access时间出现异常").aa("error", e.getMessage()).aa("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void SS() {
        if (this.bOM != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bOM.SP() - 2; i++) {
                d jn = this.bOM.jn(i);
                if (jn != null) {
                    if (currentTimeMillis - jn.SW() < 86400000) {
                        break;
                    }
                    arrayList.add(jn);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.SY().hA(dVar.getFileName()) && !e.SY().hC(dVar.getFileName()))) {
                    this.bOM.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bPz + dVar.getFileName());
                        j.at(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            ST();
        }
    }

    private void hy(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bPz + str + "/completed");
                    File file2 = new File(i.bPz + str + "/segments");
                    if (file.exists()) {
                        j.at(TAG, "delete segments");
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
        if (this.bOM != null) {
            while (this.bOM.SP() > 0 && SR()) {
            }
            ST();
        }
    }

    private void ST() {
        File[] listFiles;
        File file = new File(i.bPy);
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
