package com.baidu.tieba.VideoCache;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private b aPR = new b();

    public c() {
        KI();
    }

    private void KI() {
        File[] listFiles;
        File file = new File(l.aQA);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    f fVar = new f();
                    fVar.gT(file2.getName());
                    fVar.ap(gQ(file2.getAbsolutePath()));
                    fVar.aq(q.hd(file2.getName()));
                    this.aPR.a(fVar);
                }
            }
            Collections.sort(this.aPR.KF(), new a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gQ(String str) {
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

    public void gR(String str) {
        f fVar;
        String hf = q.hf(str);
        if (hf != null && !hf.isEmpty()) {
            gS(hf);
            if (this.aPR != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aPR.KH()) {
                        fVar = null;
                        break;
                    }
                    f fK = this.aPR.fK((this.aPR.KH() - 1) - i);
                    if (fK != null && fK.getFileName() != null && fK.getFileName().equals(hf)) {
                        fVar = fK;
                        break;
                    }
                    i++;
                }
                if (fVar != null) {
                    this.aPR.b(fVar);
                } else {
                    fVar = new f();
                    fVar.gT(hf);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(hf, currentTimeMillis2);
                fVar.ap(currentTimeMillis2);
                fVar.aq(q.hd(hf));
                this.aPR.a(fVar);
                m.log(TAG, "total cache size: " + ((this.aPR.KG() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aPR.KH());
                if (this.aPR.KG() > 629145600) {
                    while (this.aPR.KG() > 524288000 && this.aPR.KH() > 2 && KJ()) {
                    }
                    KL();
                }
                if (q.KY() < 314572800) {
                    while (q.KY() < 419430400 && this.aPR.KH() > 2 && KJ()) {
                    }
                    KL();
                }
                m.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean KJ() {
        f fK = this.aPR.fK(0);
        if (fK == null || !(g.KO().gU(fK.getFileName()) || g.KO().gW(fK.getFileName()))) {
            this.aPR.remove(0);
            if (fK != null) {
                File file = new File(String.valueOf(l.aQB) + fK.getFileName());
                m.log(TAG, "delete file " + file.getName());
                q.w(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(l.aQB) + str);
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

    public void KK() {
        if (this.aPR != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aPR.KH() - 2; i++) {
                f fK = this.aPR.fK(i);
                if (fK != null) {
                    if (currentTimeMillis - fK.KM() < 86400000) {
                        break;
                    }
                    arrayList.add(fK);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f fVar = (f) arrayList.get(i2);
                if (fVar == null || (!g.KO().gU(fVar.getFileName()) && !g.KO().gW(fVar.getFileName()))) {
                    this.aPR.b(fVar);
                    if (fVar != null) {
                        File file = new File(String.valueOf(l.aQB) + fVar.getFileName());
                        m.log(TAG, "delete expired file " + fVar.getFileName());
                        q.w(file);
                    }
                }
            }
            KL();
        }
    }

    private void gS(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(l.aQB) + str + "/completed");
            File file2 = new File(String.valueOf(l.aQB) + str + "/segments");
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
        if (this.aPR != null) {
            while (this.aPR.KH() > 0 && KJ()) {
            }
            KL();
        }
    }

    private void KL() {
        File[] listFiles;
        File file = new File(l.aQA);
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
