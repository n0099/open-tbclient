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
    private a aUI = new a();

    public b() {
        Ki();
    }

    private void Ki() {
        File[] listFiles;
        File file = new File(i.aVo);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.he(file2.getName());
                    dVar.aq(hb(file2.getAbsolutePath()));
                    dVar.ar(m.ho(file2.getName()));
                    this.aUI.a(dVar);
                }
            }
            Collections.sort(this.aUI.Kf(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hb(String str) {
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

    public void hc(String str) {
        d dVar;
        String hq = m.hq(str);
        if (hq != null && !hq.isEmpty()) {
            hd(hq);
            if (this.aUI != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aUI.Kh()) {
                        dVar = null;
                        break;
                    }
                    d fM = this.aUI.fM((this.aUI.Kh() - 1) - i);
                    if (fM != null && fM.getFileName() != null && fM.getFileName().equals(hq)) {
                        dVar = fM;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.aUI.b(dVar);
                } else {
                    dVar = new d();
                    dVar.he(hq);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hq, currentTimeMillis2);
                dVar.aq(currentTimeMillis2);
                dVar.ar(m.ho(hq));
                this.aUI.a(dVar);
                j.log(TAG, "total cache size: " + ((this.aUI.Kg() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aUI.Kh());
                if (this.aUI.Kg() > 629145600) {
                    while (this.aUI.Kg() > 524288000 && this.aUI.Kh() > 2 && Kj()) {
                    }
                    Kl();
                }
                if (m.Ky() < 314572800) {
                    while (m.Ky() < 419430400 && this.aUI.Kh() > 2 && Kj()) {
                    }
                    Kl();
                }
                j.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Kj() {
        d fM = this.aUI.fM(0);
        if (fM == null || !(e.Ko().hf(fM.getFileName()) || e.Ko().hh(fM.getFileName()))) {
            this.aUI.remove(0);
            if (fM != null) {
                File file = new File(i.aVp + fM.getFileName());
                j.log(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.aVp + str);
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

    public void Kk() {
        if (this.aUI != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aUI.Kh() - 2; i++) {
                d fM = this.aUI.fM(i);
                if (fM != null) {
                    if (currentTimeMillis - fM.Km() < 86400000) {
                        break;
                    }
                    arrayList.add(fM);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Ko().hf(dVar.getFileName()) && !e.Ko().hh(dVar.getFileName()))) {
                    this.aUI.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.aVp + dVar.getFileName());
                        j.log(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            Kl();
        }
    }

    private void hd(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.aVp + str + "/completed");
                    File file2 = new File(i.aVp + str + "/segments");
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
        if (this.aUI != null) {
            while (this.aUI.Kh() > 0 && Kj()) {
            }
            Kl();
        }
    }

    private void Kl() {
        File[] listFiles;
        File file = new File(i.aVo);
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
