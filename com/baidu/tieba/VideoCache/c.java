package com.baidu.tieba.VideoCache;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private b aMB = new b();

    public c() {
        Js();
    }

    private void Js() {
        File[] listFiles;
        File file = new File(l.aNk);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    f fVar = new f();
                    fVar.gL(file2.getName());
                    fVar.aq(gI(file2.getAbsolutePath()));
                    fVar.ar(q.gV(file2.getName()));
                    this.aMB.a(fVar);
                }
            }
            Collections.sort(this.aMB.Jp(), new a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gI(String str) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        long j = 0;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        FileInputStream fileInputStream2 = null;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(str) + "/accesstime");
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
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
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
                        fileInputStream = fileInputStream2;
                        dataInputStream2 = dataInputStream;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (dataInputStream2 != null) {
                            try {
                                dataInputStream2.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataInputStream2 = dataInputStream;
                    if (fileInputStream != null) {
                    }
                    if (dataInputStream2 != null) {
                    }
                    throw th;
                }
            }
        }
        return j;
    }

    public void gJ(String str) {
        f fVar;
        String gX = q.gX(str);
        if (gX != null && !gX.isEmpty()) {
            gK(gX);
            if (this.aMB != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aMB.Jr()) {
                        fVar = null;
                        break;
                    }
                    f fG = this.aMB.fG((this.aMB.Jr() - 1) - i);
                    if (fG != null && fG.getFileName() != null && fG.getFileName().equals(gX)) {
                        fVar = fG;
                        break;
                    }
                    i++;
                }
                if (fVar != null) {
                    this.aMB.b(fVar);
                } else {
                    fVar = new f();
                    fVar.gL(gX);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(gX, currentTimeMillis2);
                fVar.aq(currentTimeMillis2);
                fVar.ar(q.gV(gX));
                this.aMB.a(fVar);
                m.log(TAG, "total cache size: " + ((this.aMB.Jq() / 1024) / 1024) + "M list size " + this.aMB.Jr());
                if (this.aMB.Jq() > 629145600) {
                    while (this.aMB.Jq() > 524288000 && this.aMB.Jr() > 2 && Jt()) {
                    }
                    Jv();
                }
                if (q.JI() < 314572800) {
                    while (q.JI() < 419430400 && this.aMB.Jr() > 2 && Jt()) {
                    }
                    Jv();
                }
                m.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Jt() {
        f fG = this.aMB.fG(0);
        if (fG == null || !(g.Jy().gM(fG.getFileName()) || g.Jy().gO(fG.getFileName()))) {
            this.aMB.remove(0);
            if (fG != null) {
                File file = new File(String.valueOf(l.aNl) + fG.getFileName());
                m.log(TAG, "delete file " + file.getName());
                q.w(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(l.aNl) + str);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(String.valueOf(file.getAbsolutePath()) + "/accesstime")));
            bufferedWriter.write(new StringBuilder(String.valueOf(j)).toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Ju() {
        if (this.aMB != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aMB.Jr() - 2; i++) {
                f fG = this.aMB.fG(i);
                if (fG != null) {
                    if (currentTimeMillis - fG.Jw() < 86400000) {
                        break;
                    }
                    arrayList.add(fG);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f fVar = (f) arrayList.get(i2);
                if (fVar == null || (!g.Jy().gM(fVar.getFileName()) && !g.Jy().gO(fVar.getFileName()))) {
                    this.aMB.b(fVar);
                    if (fVar != null) {
                        File file = new File(String.valueOf(l.aNl) + fVar.getFileName());
                        m.log(TAG, "delete expired file " + fVar.getFileName());
                        q.w(file);
                    }
                }
            }
            Jv();
        }
    }

    private void gK(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(l.aNl) + str + "/completed");
            File file2 = new File(String.valueOf(l.aNl) + str + "/segments");
            if (file.exists()) {
                m.log(TAG, "delete segments");
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
    }

    public void clearCache() {
        if (this.aMB != null) {
            while (this.aMB.Jr() > 0 && Jt()) {
            }
            Jv();
        }
    }

    private void Jv() {
        File[] listFiles;
        File file = new File(l.aNk);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        q.w(file2);
                    } else if (!new File(String.valueOf(file2.getAbsolutePath()) + "/accesstime").exists()) {
                        q.w(file2);
                    }
                }
            }
        }
    }
}
