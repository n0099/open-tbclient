package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
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
    private a aTF = new a();

    public b() {
        Kc();
    }

    private void Kc() {
        File[] listFiles;
        File file = new File(j.aUl);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gY(file2.getName());
                    eVar.ap(gV(file2.getAbsolutePath()));
                    eVar.aq(o.hi(file2.getName()));
                    this.aTF.a(eVar);
                }
            }
            Collections.sort(this.aTF.JZ(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gV(String str) {
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
                            TiebaStatic.log(new au("c12028").Z("errormsg", "获取缓存文件的Access时间出现异常").Z("error", e.getMessage()).Z("name", file.getAbsolutePath()));
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

    public void gW(String str) {
        e eVar;
        String hk = o.hk(str);
        if (hk != null && !hk.isEmpty()) {
            gX(hk);
            if (this.aTF != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aTF.Kb()) {
                        eVar = null;
                        break;
                    }
                    e fJ = this.aTF.fJ((this.aTF.Kb() - 1) - i);
                    if (fJ != null && fJ.getFileName() != null && fJ.getFileName().equals(hk)) {
                        eVar = fJ;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aTF.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gY(hk);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hk, currentTimeMillis2);
                eVar.ap(currentTimeMillis2);
                eVar.aq(o.hi(hk));
                this.aTF.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aTF.Ka() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aTF.Kb());
                if (this.aTF.Ka() > 629145600) {
                    while (this.aTF.Ka() > 524288000 && this.aTF.Kb() > 2 && Kd()) {
                    }
                    Kf();
                }
                if (o.Ks() < 314572800) {
                    while (o.Ks() < 419430400 && this.aTF.Kb() > 2 && Kd()) {
                    }
                    Kf();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Kd() {
        e fJ = this.aTF.fJ(0);
        if (fJ == null || !(f.Ki().gZ(fJ.getFileName()) || f.Ki().hb(fJ.getFileName()))) {
            this.aTF.remove(0);
            if (fJ != null) {
                File file = new File(String.valueOf(j.aUm) + fJ.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(String.valueOf(j.aUm) + str);
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
            TiebaStatic.log(new au("c12028").Z("errormsg", "修改缓存文件的Access时间出现异常").Z("error", e.getMessage()).Z("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void Ke() {
        if (this.aTF != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aTF.Kb() - 2; i++) {
                e fJ = this.aTF.fJ(i);
                if (fJ != null) {
                    if (currentTimeMillis - fJ.Kg() < 86400000) {
                        break;
                    }
                    arrayList.add(fJ);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.Ki().gZ(eVar.getFileName()) && !f.Ki().hb(eVar.getFileName()))) {
                    this.aTF.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aUm) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.z(file);
                    }
                }
            }
            Kf();
        }
    }

    private void gX(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aUm) + str + "/completed");
            File file2 = new File(String.valueOf(j.aUm) + str + "/segments");
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
        if (this.aTF != null) {
            while (this.aTF.Kb() > 0 && Kd()) {
            }
            Kf();
        }
    }

    private void Kf() {
        File[] listFiles;
        File file = new File(j.aUl);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        o.z(file2);
                    } else if (!new File(String.valueOf(file2.getAbsolutePath()) + "/accesstime").exists()) {
                        o.z(file2);
                    }
                }
            }
        }
    }
}
