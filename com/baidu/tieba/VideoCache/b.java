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
    private a baL = new a();

    public b() {
        LB();
    }

    private void LB() {
        File[] listFiles;
        File file = new File(i.bby);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.ho(file2.getName());
                    dVar.au(hl(file2.getAbsolutePath()));
                    dVar.av(m.hy(file2.getName()));
                    this.baL.a(dVar);
                }
            }
            Collections.sort(this.baL.Ly(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hl(String str) {
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

    public void hm(String str) {
        d dVar;
        String hA = m.hA(str);
        if (hA != null && !hA.isEmpty()) {
            hn(hA);
            if (this.baL != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.baL.LA()) {
                        dVar = null;
                        break;
                    }
                    d gs = this.baL.gs((this.baL.LA() - 1) - i);
                    if (gs != null && gs.getFileName() != null && gs.getFileName().equals(hA)) {
                        dVar = gs;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.baL.b(dVar);
                } else {
                    dVar = new d();
                    dVar.ho(hA);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hA, currentTimeMillis2);
                dVar.au(currentTimeMillis2);
                dVar.av(m.hy(hA));
                this.baL.a(dVar);
                j.av(TAG, "total cache size: " + ((this.baL.Lz() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.baL.LA());
                if (this.baL.Lz() > 629145600) {
                    while (this.baL.Lz() > 524288000 && this.baL.LA() > 2 && LC()) {
                    }
                    LE();
                }
                if (m.LU() < 314572800) {
                    while (m.LU() < 419430400 && this.baL.LA() > 2 && LC()) {
                    }
                    LE();
                }
                j.av(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean LC() {
        d gs = this.baL.gs(0);
        if (gs == null || !(e.LJ().hp(gs.getFileName()) || e.LJ().hr(gs.getFileName()))) {
            this.baL.remove(0);
            if (gs != null) {
                File file = new File(i.bbz + gs.getFileName());
                j.av(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bbz + str);
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

    public void LD() {
        if (this.baL != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.baL.LA() - 2; i++) {
                d gs = this.baL.gs(i);
                if (gs != null) {
                    if (currentTimeMillis - gs.LH() < 86400000) {
                        break;
                    }
                    arrayList.add(gs);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.LJ().hp(dVar.getFileName()) && !e.LJ().hr(dVar.getFileName()))) {
                    this.baL.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bbz + dVar.getFileName());
                        j.av(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            LE();
        }
    }

    private void hn(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bbz + str + "/completed");
                    File file2 = new File(i.bbz + str + "/segments");
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
        if (this.baL != null) {
            while (this.baL.LA() > 0 && LC()) {
            }
            LE();
        }
    }

    private void LE() {
        File[] listFiles;
        File file = new File(i.bby);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.y(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.y(file2);
                    }
                }
            }
        }
    }
}
