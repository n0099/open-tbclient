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
/* loaded from: classes4.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a cUP = new a();

    public b() {
        aBU();
    }

    private void aBU() {
        File[] listFiles;
        File file = new File(i.cVz);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.rO(file2.getName());
                    dVar.bJ(rL(file2.getAbsolutePath()));
                    dVar.bK(m.rY(file2.getName()));
                    this.cUP.a(dVar);
                }
            }
            Collections.sort(this.cUP.aBR(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long rL(String str) {
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
                        TiebaStatic.log(new an("c12028").bT("errormsg", "获取缓存文件的Access时间出现异常").bT("error", e.getMessage()).bT("name", file.getAbsolutePath()));
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

    public void rM(String str) {
        d dVar;
        String sa = m.sa(str);
        if (sa != null && !sa.isEmpty()) {
            rN(sa);
            if (this.cUP != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.cUP.aBT()) {
                        dVar = null;
                        break;
                    }
                    d mj = this.cUP.mj((this.cUP.aBT() - 1) - i);
                    if (mj != null && mj.getFileName() != null && mj.getFileName().equals(sa)) {
                        dVar = mj;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.cUP.b(dVar);
                } else {
                    dVar = new d();
                    dVar.rO(sa);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                m(sa, currentTimeMillis2);
                dVar.bJ(currentTimeMillis2);
                dVar.bK(m.rY(sa));
                this.cUP.a(dVar);
                j.am(TAG, "total cache size: " + ((this.cUP.aBS() / 1024) / 1024) + "M list size " + this.cUP.aBT());
                if (this.cUP.aBS() > 629145600) {
                    while (this.cUP.aBS() > 524288000 && this.cUP.aBT() > 2 && aBV()) {
                    }
                    aBX();
                }
                if (m.aCn() < 314572800) {
                    while (m.aCn() < 419430400 && this.cUP.aBT() > 2 && aBV()) {
                    }
                    aBX();
                }
                j.am(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aBV() {
        d mj = this.cUP.mj(0);
        if (mj == null || !(e.aCc().rP(mj.getFileName()) || e.aCc().rR(mj.getFileName()))) {
            this.cUP.remove(0);
            if (mj != null) {
                File file = new File(i.cVA + mj.getFileName());
                j.am(TAG, "delete file " + file.getName());
                m.I(file);
            }
            return true;
        }
        return false;
    }

    private void m(String str, long j) {
        File file = new File(i.cVA + str);
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
            TiebaStatic.log(new an("c12028").bT("errormsg", "修改缓存文件的Access时间出现异常").bT("error", e.getMessage()).bT("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aBW() {
        if (this.cUP != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.cUP.aBT() - 2; i++) {
                d mj = this.cUP.mj(i);
                if (mj != null) {
                    if (currentTimeMillis - mj.aCa() < 86400000) {
                        break;
                    }
                    arrayList.add(mj);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aCc().rP(dVar.getFileName()) && !e.aCc().rR(dVar.getFileName()))) {
                    this.cUP.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.cVA + dVar.getFileName());
                        j.am(TAG, "delete expired file " + dVar.getFileName());
                        m.I(file);
                    }
                }
            }
            aBX();
        }
    }

    private void rN(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.cVA + str + "/completed");
                    File file2 = new File(i.cVA + str + "/segments");
                    if (file.exists()) {
                        j.am(TAG, "delete segments");
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
        if (this.cUP != null) {
            while (this.cUP.aBT() > 0 && aBV()) {
            }
            aBX();
        }
    }

    private void aBX() {
        File[] listFiles;
        File file = new File(i.cVz);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.I(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.I(file2);
                    }
                }
            }
        }
    }
}
