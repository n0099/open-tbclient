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
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a aPi = new a();

    public b() {
        Kb();
    }

    private void Kb() {
        File[] listFiles;
        File file = new File(j.aPR);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gO(file2.getName());
                    eVar.ao(gL(file2.getAbsolutePath()));
                    eVar.ap(o.gY(file2.getName()));
                    this.aPi.a(eVar);
                }
            }
            Collections.sort(this.aPi.JY(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gL(String str) {
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

    public void gM(String str) {
        e eVar;
        String ha = o.ha(str);
        if (ha != null && !ha.isEmpty()) {
            gN(ha);
            if (this.aPi != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aPi.Ka()) {
                        eVar = null;
                        break;
                    }
                    e fJ = this.aPi.fJ((this.aPi.Ka() - 1) - i);
                    if (fJ != null && fJ.getFileName() != null && fJ.getFileName().equals(ha)) {
                        eVar = fJ;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aPi.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gO(ha);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(ha, currentTimeMillis2);
                eVar.ao(currentTimeMillis2);
                eVar.ap(o.gY(ha));
                this.aPi.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aPi.JZ() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aPi.Ka());
                if (this.aPi.JZ() > 629145600) {
                    while (this.aPi.JZ() > 524288000 && this.aPi.Ka() > 2 && Kc()) {
                    }
                    Ke();
                }
                if (o.Kr() < 314572800) {
                    while (o.Kr() < 419430400 && this.aPi.Ka() > 2 && Kc()) {
                    }
                    Ke();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Kc() {
        e fJ = this.aPi.fJ(0);
        if (fJ == null || !(f.Kh().gP(fJ.getFileName()) || f.Kh().gR(fJ.getFileName()))) {
            this.aPi.remove(0);
            if (fJ != null) {
                File file = new File(String.valueOf(j.aPS) + fJ.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.w(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(j.aPS) + str);
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

    public void Kd() {
        if (this.aPi != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aPi.Ka() - 2; i++) {
                e fJ = this.aPi.fJ(i);
                if (fJ != null) {
                    if (currentTimeMillis - fJ.Kf() < 86400000) {
                        break;
                    }
                    arrayList.add(fJ);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.Kh().gP(eVar.getFileName()) && !f.Kh().gR(eVar.getFileName()))) {
                    this.aPi.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aPS) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.w(file);
                    }
                }
            }
            Ke();
        }
    }

    private void gN(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aPS) + str + "/completed");
            File file2 = new File(String.valueOf(j.aPS) + str + "/segments");
            if (file.exists()) {
                k.log(TAG, "delete segments");
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
        if (this.aPi != null) {
            while (this.aPi.Ka() > 0 && Kc()) {
            }
            Ke();
        }
    }

    private void Ke() {
        File[] listFiles;
        File file = new File(j.aPR);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        o.w(file2);
                    } else if (!new File(String.valueOf(file2.getAbsolutePath()) + "/accesstime").exists()) {
                        o.w(file2);
                    }
                }
            }
        }
    }
}
