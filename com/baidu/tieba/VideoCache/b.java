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
    private a aXd = new a();

    public b() {
        KJ();
    }

    private void KJ() {
        File[] listFiles;
        File file = new File(i.aXK);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.he(file2.getName());
                    dVar.aq(hb(file2.getAbsolutePath()));
                    dVar.ar(m.ho(file2.getName()));
                    this.aXd.a(dVar);
                }
            }
            Collections.sort(this.aXd.KG(), new AccessTimeComparator());
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
                        TiebaStatic.log(new ak("c12028").ac("errormsg", "获取缓存文件的Access时间出现异常").ac("error", e.getMessage()).ac("name", file.getAbsolutePath()));
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
            if (this.aXd != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aXd.KI()) {
                        dVar = null;
                        break;
                    }
                    d gc = this.aXd.gc((this.aXd.KI() - 1) - i);
                    if (gc != null && gc.getFileName() != null && gc.getFileName().equals(hq)) {
                        dVar = gc;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.aXd.b(dVar);
                } else {
                    dVar = new d();
                    dVar.he(hq);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hq, currentTimeMillis2);
                dVar.aq(currentTimeMillis2);
                dVar.ar(m.ho(hq));
                this.aXd.a(dVar);
                j.av(TAG, "total cache size: " + ((this.aXd.KH() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aXd.KI());
                if (this.aXd.KH() > 629145600) {
                    while (this.aXd.KH() > 524288000 && this.aXd.KI() > 2 && KK()) {
                    }
                    KM();
                }
                if (m.KZ() < 314572800) {
                    while (m.KZ() < 419430400 && this.aXd.KI() > 2 && KK()) {
                    }
                    KM();
                }
                j.av(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean KK() {
        d gc = this.aXd.gc(0);
        if (gc == null || !(e.KP().hf(gc.getFileName()) || e.KP().hh(gc.getFileName()))) {
            this.aXd.remove(0);
            if (gc != null) {
                File file = new File(i.aXL + gc.getFileName());
                j.av(TAG, "delete file " + file.getName());
                m.A(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.aXL + str);
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
            TiebaStatic.log(new ak("c12028").ac("errormsg", "修改缓存文件的Access时间出现异常").ac("error", e.getMessage()).ac("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void KL() {
        if (this.aXd != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aXd.KI() - 2; i++) {
                d gc = this.aXd.gc(i);
                if (gc != null) {
                    if (currentTimeMillis - gc.KN() < 86400000) {
                        break;
                    }
                    arrayList.add(gc);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.KP().hf(dVar.getFileName()) && !e.KP().hh(dVar.getFileName()))) {
                    this.aXd.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.aXL + dVar.getFileName());
                        j.av(TAG, "delete expired file " + dVar.getFileName());
                        m.A(file);
                    }
                }
            }
            KM();
        }
    }

    private void hd(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.aXL + str + "/completed");
                    File file2 = new File(i.aXL + str + "/segments");
                    if (file.exists()) {
                        j.av(TAG, "delete segments");
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
        if (this.aXd != null) {
            while (this.aXd.KI() > 0 && KK()) {
            }
            KM();
        }
    }

    private void KM() {
        File[] listFiles;
        File file = new File(i.aXK);
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
