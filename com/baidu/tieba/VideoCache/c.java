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
    private b aNL = new b();

    public c() {
        Ke();
    }

    private void Ke() {
        File[] listFiles;
        File file = new File(l.aOu);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    f fVar = new f();
                    fVar.gS(file2.getName());
                    fVar.ar(gP(file2.getAbsolutePath()));
                    fVar.as(q.hc(file2.getName()));
                    this.aNL.a(fVar);
                }
            }
            Collections.sort(this.aNL.Kb(), new a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gP(String str) {
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

    public void gQ(String str) {
        f fVar;
        String he = q.he(str);
        if (he != null && !he.isEmpty()) {
            gR(he);
            if (this.aNL != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aNL.Kd()) {
                        fVar = null;
                        break;
                    }
                    f fK = this.aNL.fK((this.aNL.Kd() - 1) - i);
                    if (fK != null && fK.getFileName() != null && fK.getFileName().equals(he)) {
                        fVar = fK;
                        break;
                    }
                    i++;
                }
                if (fVar != null) {
                    this.aNL.b(fVar);
                } else {
                    fVar = new f();
                    fVar.gS(he);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(he, currentTimeMillis2);
                fVar.ar(currentTimeMillis2);
                fVar.as(q.hc(he));
                this.aNL.a(fVar);
                m.log(TAG, "total cache size: " + ((this.aNL.Kc() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aNL.Kd());
                if (this.aNL.Kc() > 629145600) {
                    while (this.aNL.Kc() > 524288000 && this.aNL.Kd() > 2 && Kf()) {
                    }
                    Kh();
                }
                if (q.Ku() < 314572800) {
                    while (q.Ku() < 419430400 && this.aNL.Kd() > 2 && Kf()) {
                    }
                    Kh();
                }
                m.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Kf() {
        f fK = this.aNL.fK(0);
        if (fK == null || !(g.Kk().gT(fK.getFileName()) || g.Kk().gV(fK.getFileName()))) {
            this.aNL.remove(0);
            if (fK != null) {
                File file = new File(String.valueOf(l.aOv) + fK.getFileName());
                m.log(TAG, "delete file " + file.getName());
                q.w(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(l.aOv) + str);
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

    public void Kg() {
        if (this.aNL != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aNL.Kd() - 2; i++) {
                f fK = this.aNL.fK(i);
                if (fK != null) {
                    if (currentTimeMillis - fK.Ki() < 86400000) {
                        break;
                    }
                    arrayList.add(fK);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f fVar = (f) arrayList.get(i2);
                if (fVar == null || (!g.Kk().gT(fVar.getFileName()) && !g.Kk().gV(fVar.getFileName()))) {
                    this.aNL.b(fVar);
                    if (fVar != null) {
                        File file = new File(String.valueOf(l.aOv) + fVar.getFileName());
                        m.log(TAG, "delete expired file " + fVar.getFileName());
                        q.w(file);
                    }
                }
            }
            Kh();
        }
    }

    private void gR(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(l.aOv) + str + "/completed");
            File file2 = new File(String.valueOf(l.aOv) + str + "/segments");
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
        if (this.aNL != null) {
            while (this.aNL.Kd() > 0 && Kf()) {
            }
            Kh();
        }
    }

    private void Kh() {
        File[] listFiles;
        File file = new File(l.aOu);
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
