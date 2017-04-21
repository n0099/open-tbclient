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
/* loaded from: classes.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a aUp = new a();

    public b() {
        Lv();
    }

    private void Lv() {
        File[] listFiles;
        File file = new File(j.aUV);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gI(file2.getName());
                    eVar.an(gF(file2.getAbsolutePath()));
                    eVar.ao(o.gS(file2.getName()));
                    this.aUp.a(eVar);
                }
            }
            Collections.sort(this.aUp.Ls(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gF(String str) {
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

    public void gG(String str) {
        e eVar;
        String gU = o.gU(str);
        if (gU != null && !gU.isEmpty()) {
            gH(gU);
            if (this.aUp != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aUp.Lu()) {
                        eVar = null;
                        break;
                    }
                    e fK = this.aUp.fK((this.aUp.Lu() - 1) - i);
                    if (fK != null && fK.getFileName() != null && fK.getFileName().equals(gU)) {
                        eVar = fK;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aUp.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gI(gU);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(gU, currentTimeMillis2);
                eVar.an(currentTimeMillis2);
                eVar.ao(o.gS(gU));
                this.aUp.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aUp.Lt() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aUp.Lu());
                if (this.aUp.Lt() > 629145600) {
                    while (this.aUp.Lt() > 524288000 && this.aUp.Lu() > 2 && Lw()) {
                    }
                    Ly();
                }
                if (o.LL() < 314572800) {
                    while (o.LL() < 419430400 && this.aUp.Lu() > 2 && Lw()) {
                    }
                    Ly();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Lw() {
        e fK = this.aUp.fK(0);
        if (fK == null || !(f.LB().gJ(fK.getFileName()) || f.LB().gL(fK.getFileName()))) {
            this.aUp.remove(0);
            if (fK != null) {
                File file = new File(String.valueOf(j.aUW) + fK.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.x(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(j.aUW) + str);
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

    public void Lx() {
        if (this.aUp != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aUp.Lu() - 2; i++) {
                e fK = this.aUp.fK(i);
                if (fK != null) {
                    if (currentTimeMillis - fK.Lz() < 86400000) {
                        break;
                    }
                    arrayList.add(fK);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.LB().gJ(eVar.getFileName()) && !f.LB().gL(eVar.getFileName()))) {
                    this.aUp.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aUW) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.x(file);
                    }
                }
            }
            Ly();
        }
    }

    private void gH(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aUW) + str + "/completed");
            File file2 = new File(String.valueOf(j.aUW) + str + "/segments");
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
        if (this.aUp != null) {
            while (this.aUp.Lu() > 0 && Lw()) {
            }
            Ly();
        }
    }

    private void Ly() {
        File[] listFiles;
        File file = new File(j.aUV);
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
