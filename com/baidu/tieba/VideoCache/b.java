package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
    private a aXq = new a();

    public b() {
        KP();
    }

    private void KP() {
        File[] listFiles;
        File file = new File(i.aXX);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hf(file2.getName());
                    dVar.ap(hc(file2.getAbsolutePath()));
                    dVar.aq(m.hp(file2.getName()));
                    this.aXq.a(dVar);
                }
            }
            Collections.sort(this.aXq.KM(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hc(String str) {
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
                        TiebaStatic.log(new ak("c12028").ad("errormsg", "获取缓存文件的Access时间出现异常").ad("error", e.getMessage()).ad("name", file.getAbsolutePath()));
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

    public void hd(String str) {
        d dVar;
        String hr = m.hr(str);
        if (hr != null && !hr.isEmpty()) {
            he(hr);
            if (this.aXq != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aXq.KO()) {
                        dVar = null;
                        break;
                    }
                    d gd = this.aXq.gd((this.aXq.KO() - 1) - i);
                    if (gd != null && gd.getFileName() != null && gd.getFileName().equals(hr)) {
                        dVar = gd;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.aXq.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hf(hr);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hr, currentTimeMillis2);
                dVar.ap(currentTimeMillis2);
                dVar.aq(m.hp(hr));
                this.aXq.a(dVar);
                j.aw(TAG, "total cache size: " + ((this.aXq.KN() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aXq.KO());
                if (this.aXq.KN() > 629145600) {
                    while (this.aXq.KN() > 524288000 && this.aXq.KO() > 2 && KQ()) {
                    }
                    KS();
                }
                if (m.Lf() < 314572800) {
                    while (m.Lf() < 419430400 && this.aXq.KO() > 2 && KQ()) {
                    }
                    KS();
                }
                j.aw(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean KQ() {
        d gd = this.aXq.gd(0);
        if (gd == null || !(e.KV().hg(gd.getFileName()) || e.KV().hi(gd.getFileName()))) {
            this.aXq.remove(0);
            if (gd != null) {
                File file = new File(i.aXY + gd.getFileName());
                j.aw(TAG, "delete file " + file.getName());
                m.A(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.aXY + str);
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
            TiebaStatic.log(new ak("c12028").ad("errormsg", "修改缓存文件的Access时间出现异常").ad("error", e.getMessage()).ad("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void KR() {
        if (this.aXq != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aXq.KO() - 2; i++) {
                d gd = this.aXq.gd(i);
                if (gd != null) {
                    if (currentTimeMillis - gd.KT() < 86400000) {
                        break;
                    }
                    arrayList.add(gd);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.KV().hg(dVar.getFileName()) && !e.KV().hi(dVar.getFileName()))) {
                    this.aXq.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.aXY + dVar.getFileName());
                        j.aw(TAG, "delete expired file " + dVar.getFileName());
                        m.A(file);
                    }
                }
            }
            KS();
        }
    }

    private void he(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.aXY + str + "/completed");
                    File file2 = new File(i.aXY + str + "/segments");
                    if (file.exists()) {
                        j.aw(TAG, "delete segments");
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
        if (this.aXq != null) {
            while (this.aXq.KO() > 0 && KQ()) {
            }
            KS();
        }
    }

    private void KS() {
        File[] listFiles;
        File file = new File(i.aXX);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.A(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.A(file2);
                    }
                }
            }
        }
    }
}
