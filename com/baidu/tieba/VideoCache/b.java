package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
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
    private a aVV = new a();

    public b() {
        Ko();
    }

    private void Ko() {
        File[] listFiles;
        File file = new File(i.aWB);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hj(file2.getName());
                    dVar.aq(hg(file2.getAbsolutePath()));
                    dVar.ar(m.ht(file2.getName()));
                    this.aVV.a(dVar);
                }
            }
            Collections.sort(this.aVV.Kl(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hg(String str) {
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
                        TiebaStatic.log(new aj("c12028").aa("errormsg", "获取缓存文件的Access时间出现异常").aa("error", e.getMessage()).aa("name", file.getAbsolutePath()));
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

    public void hh(String str) {
        d dVar;
        String hv = m.hv(str);
        if (hv != null && !hv.isEmpty()) {
            hi(hv);
            if (this.aVV != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aVV.Kn()) {
                        dVar = null;
                        break;
                    }
                    d fO = this.aVV.fO((this.aVV.Kn() - 1) - i);
                    if (fO != null && fO.getFileName() != null && fO.getFileName().equals(hv)) {
                        dVar = fO;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.aVV.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hj(hv);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                h(hv, currentTimeMillis2);
                dVar.aq(currentTimeMillis2);
                dVar.ar(m.ht(hv));
                this.aVV.a(dVar);
                j.log(TAG, "total cache size: " + ((this.aVV.Km() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aVV.Kn());
                if (this.aVV.Km() > 629145600) {
                    while (this.aVV.Km() > 524288000 && this.aVV.Kn() > 2 && Kp()) {
                    }
                    Kr();
                }
                if (m.KD() < 314572800) {
                    while (m.KD() < 419430400 && this.aVV.Kn() > 2 && Kp()) {
                    }
                    Kr();
                }
                j.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Kp() {
        d fO = this.aVV.fO(0);
        if (fO == null || !(e.Ku().hk(fO.getFileName()) || e.Ku().hm(fO.getFileName()))) {
            this.aVV.remove(0);
            if (fO != null) {
                File file = new File(i.aWC + fO.getFileName());
                j.log(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void h(String str, long j) {
        File file = new File(i.aWC + str);
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
            TiebaStatic.log(new aj("c12028").aa("errormsg", "修改缓存文件的Access时间出现异常").aa("error", e.getMessage()).aa("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void Kq() {
        if (this.aVV != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aVV.Kn() - 2; i++) {
                d fO = this.aVV.fO(i);
                if (fO != null) {
                    if (currentTimeMillis - fO.Ks() < 86400000) {
                        break;
                    }
                    arrayList.add(fO);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Ku().hk(dVar.getFileName()) && !e.Ku().hm(dVar.getFileName()))) {
                    this.aVV.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.aWC + dVar.getFileName());
                        j.log(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            Kr();
        }
    }

    private void hi(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.aWC + str + "/completed");
                    File file2 = new File(i.aWC + str + "/segments");
                    if (file.exists()) {
                        j.log(TAG, "delete segments");
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
        if (this.aVV != null) {
            while (this.aVV.Kn() > 0 && Kp()) {
            }
            Kr();
        }
    }

    private void Kr() {
        File[] listFiles;
        File file = new File(i.aWB);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.z(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.z(file2);
                    }
                }
            }
        }
    }
}
