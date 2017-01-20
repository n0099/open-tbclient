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
    private a aOl = new a();

    public b() {
        Kq();
    }

    private void Kq() {
        File[] listFiles;
        File file = new File(j.aOU);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gP(file2.getName());
                    eVar.an(gM(file2.getAbsolutePath()));
                    eVar.ao(o.gZ(file2.getName()));
                    this.aOl.a(eVar);
                }
            }
            Collections.sort(this.aOl.Kn(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gM(String str) {
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

    public void gN(String str) {
        e eVar;
        String hb = o.hb(str);
        if (hb != null && !hb.isEmpty()) {
            gO(hb);
            if (this.aOl != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aOl.Kp()) {
                        eVar = null;
                        break;
                    }
                    e fN = this.aOl.fN((this.aOl.Kp() - 1) - i);
                    if (fN != null && fN.getFileName() != null && fN.getFileName().equals(hb)) {
                        eVar = fN;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aOl.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gP(hb);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(hb, currentTimeMillis2);
                eVar.an(currentTimeMillis2);
                eVar.ao(o.gZ(hb));
                this.aOl.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aOl.Ko() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aOl.Kp());
                if (this.aOl.Ko() > 629145600) {
                    while (this.aOl.Ko() > 524288000 && this.aOl.Kp() > 2 && Kr()) {
                    }
                    Kt();
                }
                if (o.KG() < 314572800) {
                    while (o.KG() < 419430400 && this.aOl.Kp() > 2 && Kr()) {
                    }
                    Kt();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Kr() {
        e fN = this.aOl.fN(0);
        if (fN == null || !(f.Kw().gQ(fN.getFileName()) || f.Kw().gS(fN.getFileName()))) {
            this.aOl.remove(0);
            if (fN != null) {
                File file = new File(String.valueOf(j.aOV) + fN.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.w(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(j.aOV) + str);
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

    public void Ks() {
        if (this.aOl != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aOl.Kp() - 2; i++) {
                e fN = this.aOl.fN(i);
                if (fN != null) {
                    if (currentTimeMillis - fN.Ku() < 86400000) {
                        break;
                    }
                    arrayList.add(fN);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.Kw().gQ(eVar.getFileName()) && !f.Kw().gS(eVar.getFileName()))) {
                    this.aOl.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aOV) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.w(file);
                    }
                }
            }
            Kt();
        }
    }

    private void gO(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aOV) + str + "/completed");
            File file2 = new File(String.valueOf(j.aOV) + str + "/segments");
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
        if (this.aOl != null) {
            while (this.aOl.Kp() > 0 && Kr()) {
            }
            Kt();
        }
    }

    private void Kt() {
        File[] listFiles;
        File file = new File(j.aOU);
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
