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
    private a aTY = new a();

    public b() {
        KV();
    }

    private void KV() {
        File[] listFiles;
        File file = new File(j.aUG);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gE(file2.getName());
                    eVar.an(gB(file2.getAbsolutePath()));
                    eVar.ao(o.gO(file2.getName()));
                    this.aTY.a(eVar);
                }
            }
            Collections.sort(this.aTY.KS(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gB(String str) {
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
                            TiebaStatic.log(new as("c12028").Z("errormsg", "获取缓存文件的Access时间出现异常").Z("error", e.getMessage()).Z("name", file.getAbsolutePath()));
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

    public void gC(String str) {
        e eVar;
        String gQ = o.gQ(str);
        if (gQ != null && !gQ.isEmpty()) {
            gD(gQ);
            if (this.aTY != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aTY.KU()) {
                        eVar = null;
                        break;
                    }
                    e fH = this.aTY.fH((this.aTY.KU() - 1) - i);
                    if (fH != null && fH.getFileName() != null && fH.getFileName().equals(gQ)) {
                        eVar = fH;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aTY.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gE(gQ);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(gQ, currentTimeMillis2);
                eVar.an(currentTimeMillis2);
                eVar.ao(o.gO(gQ));
                this.aTY.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aTY.KT() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aTY.KU());
                if (this.aTY.KT() > 629145600) {
                    while (this.aTY.KT() > 524288000 && this.aTY.KU() > 2 && KW()) {
                    }
                    KY();
                }
                if (o.Ll() < 314572800) {
                    while (o.Ll() < 419430400 && this.aTY.KU() > 2 && KW()) {
                    }
                    KY();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean KW() {
        e fH = this.aTY.fH(0);
        if (fH == null || !(f.Lb().gF(fH.getFileName()) || f.Lb().gH(fH.getFileName()))) {
            this.aTY.remove(0);
            if (fH != null) {
                File file = new File(String.valueOf(j.aUH) + fH.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.w(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(String.valueOf(j.aUH) + str);
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
            TiebaStatic.log(new as("c12028").Z("errormsg", "修改缓存文件的Access时间出现异常").Z("error", e.getMessage()).Z("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void KX() {
        if (this.aTY != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aTY.KU() - 2; i++) {
                e fH = this.aTY.fH(i);
                if (fH != null) {
                    if (currentTimeMillis - fH.KZ() < 86400000) {
                        break;
                    }
                    arrayList.add(fH);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.Lb().gF(eVar.getFileName()) && !f.Lb().gH(eVar.getFileName()))) {
                    this.aTY.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aUH) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.w(file);
                    }
                }
            }
            KY();
        }
    }

    private void gD(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aUH) + str + "/completed");
            File file2 = new File(String.valueOf(j.aUH) + str + "/segments");
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
        if (this.aTY != null) {
            while (this.aTY.KU() > 0 && KW()) {
            }
            KY();
        }
    }

    private void KY() {
        File[] listFiles;
        File file = new File(j.aUG);
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
