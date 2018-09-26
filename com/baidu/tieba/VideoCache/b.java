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
    private a bqS = new a();

    public b() {
        RQ();
    }

    private void RQ() {
        File[] listFiles;
        File file = new File(i.brD);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.iF(file2.getName());
                    dVar.aF(iC(file2.getAbsolutePath()));
                    dVar.aG(m.iP(file2.getName()));
                    this.bqS.a(dVar);
                }
            }
            Collections.sort(this.bqS.RN(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long iC(String str) {
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
                        TiebaStatic.log(new am("c12028").al("errormsg", "获取缓存文件的Access时间出现异常").al("error", e.getMessage()).al("name", file.getAbsolutePath()));
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

    public void iD(String str) {
        d dVar;
        String iR = m.iR(str);
        if (iR != null && !iR.isEmpty()) {
            iE(iR);
            if (this.bqS != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bqS.RP()) {
                        dVar = null;
                        break;
                    }
                    d gO = this.bqS.gO((this.bqS.RP() - 1) - i);
                    if (gO != null && gO.getFileName() != null && gO.getFileName().equals(iR)) {
                        dVar = gO;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bqS.b(dVar);
                } else {
                    dVar = new d();
                    dVar.iF(iR);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(iR, currentTimeMillis2);
                dVar.aF(currentTimeMillis2);
                dVar.aG(m.iP(iR));
                this.bqS.a(dVar);
                j.aF(TAG, "total cache size: " + ((this.bqS.RO() / 1024) / 1024) + "M list size " + this.bqS.RP());
                if (this.bqS.RO() > 629145600) {
                    while (this.bqS.RO() > 524288000 && this.bqS.RP() > 2 && RR()) {
                    }
                    RT();
                }
                if (m.Sj() < 314572800) {
                    while (m.Sj() < 419430400 && this.bqS.RP() > 2 && RR()) {
                    }
                    RT();
                }
                j.aF(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean RR() {
        d gO = this.bqS.gO(0);
        if (gO == null || !(e.RY().iG(gO.getFileName()) || e.RY().iI(gO.getFileName()))) {
            this.bqS.remove(0);
            if (gO != null) {
                File file = new File(i.brE + gO.getFileName());
                j.aF(TAG, "delete file " + file.getName());
                m.E(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(i.brE + str);
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
            TiebaStatic.log(new am("c12028").al("errormsg", "修改缓存文件的Access时间出现异常").al("error", e.getMessage()).al("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void RS() {
        if (this.bqS != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bqS.RP() - 2; i++) {
                d gO = this.bqS.gO(i);
                if (gO != null) {
                    if (currentTimeMillis - gO.RW() < 86400000) {
                        break;
                    }
                    arrayList.add(gO);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.RY().iG(dVar.getFileName()) && !e.RY().iI(dVar.getFileName()))) {
                    this.bqS.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.brE + dVar.getFileName());
                        j.aF(TAG, "delete expired file " + dVar.getFileName());
                        m.E(file);
                    }
                }
            }
            RT();
        }
    }

    private void iE(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.brE + str + "/completed");
                    File file2 = new File(i.brE + str + "/segments");
                    if (file.exists()) {
                        j.aF(TAG, "delete segments");
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
        if (this.bqS != null) {
            while (this.bqS.RP() > 0 && RR()) {
            }
            RT();
        }
    }

    private void RT() {
        File[] listFiles;
        File file = new File(i.brD);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.E(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.E(file2);
                    }
                }
            }
        }
    }
}
