package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a aUK = new a();

    public b() {
        KJ();
    }

    private void KJ() {
        File[] listFiles;
        File file = new File(j.aVq);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gG(file2.getName());
                    eVar.ao(gD(file2.getAbsolutePath()));
                    eVar.ap(o.gQ(file2.getName()));
                    this.aUK.a(eVar);
                }
            }
            Collections.sort(this.aUK.KG(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gD(String str) {
        DataInputStream dataInputStream;
        long j = 0;
        FileInputStream fileInputStream = null;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(str) + "/accesstime");
            if (file.exists()) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        dataInputStream = new DataInputStream(fileInputStream2);
                    } catch (Exception e) {
                        e = e;
                        dataInputStream = null;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = null;
                        fileInputStream = fileInputStream2;
                    }
                    try {
                        j = Long.parseLong(dataInputStream.readLine());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream = fileInputStream2;
                        try {
                            TiebaStatic.log(new as("c12028").aa("errormsg", "获取缓存文件的Access时间出现异常").aa("error", e.getMessage()).aa("name", file.getAbsolutePath()));
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            return j;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (dataInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                    dataInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    dataInputStream = null;
                }
            }
        }
        return j;
    }

    public void gE(String str) {
        e eVar;
        String gS = o.gS(str);
        if (gS != null && !gS.isEmpty()) {
            gF(gS);
            if (this.aUK != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aUK.KI()) {
                        eVar = null;
                        break;
                    }
                    e fH = this.aUK.fH((this.aUK.KI() - 1) - i);
                    if (fH != null && fH.getFileName() != null && fH.getFileName().equals(gS)) {
                        eVar = fH;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aUK.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gG(gS);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(gS, currentTimeMillis2);
                eVar.ao(currentTimeMillis2);
                eVar.ap(o.gQ(gS));
                this.aUK.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aUK.KH() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aUK.KI());
                if (this.aUK.KH() > 629145600) {
                    while (this.aUK.KH() > 524288000 && this.aUK.KI() > 2 && KK()) {
                    }
                    KM();
                }
                if (o.KZ() < 314572800) {
                    while (o.KZ() < 419430400 && this.aUK.KI() > 2 && KK()) {
                    }
                    KM();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean KK() {
        e fH = this.aUK.fH(0);
        if (fH == null || !(f.KP().gH(fH.getFileName()) || f.KP().gJ(fH.getFileName()))) {
            this.aUK.remove(0);
            if (fH != null) {
                File file = new File(String.valueOf(j.aVr) + fH.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.x(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(j.aVr) + str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/accesstime");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
            bufferedWriter.write(new StringBuilder(String.valueOf(j)).toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            TiebaStatic.log(new as("c12028").aa("errormsg", "修改缓存文件的Access时间出现异常").aa("error", e.getMessage()).aa("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void KL() {
        if (this.aUK != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aUK.KI() - 2; i++) {
                e fH = this.aUK.fH(i);
                if (fH != null) {
                    if (currentTimeMillis - fH.KN() < 86400000) {
                        break;
                    }
                    arrayList.add(fH);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.KP().gH(eVar.getFileName()) && !f.KP().gJ(eVar.getFileName()))) {
                    this.aUK.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aVr) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.x(file);
                    }
                }
            }
            KM();
        }
    }

    private void gF(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aVr) + str + "/completed");
            File file2 = new File(String.valueOf(j.aVr) + str + "/segments");
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
        if (this.aUK != null) {
            while (this.aUK.KI() > 0 && KK()) {
            }
            KM();
        }
    }

    private void KM() {
        File[] listFiles;
        File file = new File(j.aVq);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        o.x(file2);
                    } else if (!new File(String.valueOf(file2.getAbsolutePath()) + "/accesstime").exists()) {
                        o.x(file2);
                    }
                }
            }
        }
    }
}
