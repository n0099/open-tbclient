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
    private a aVC = new a();

    public b() {
        Kx();
    }

    private void Kx() {
        File[] listFiles;
        File file = new File(i.aWj);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hi(file2.getName());
                    dVar.ap(hf(file2.getAbsolutePath()));
                    dVar.aq(m.hs(file2.getName()));
                    this.aVC.a(dVar);
                }
            }
            Collections.sort(this.aVC.Ku(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hf(String str) {
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

    public void hg(String str) {
        d dVar;
        String hu = m.hu(str);
        if (hu != null && !hu.isEmpty()) {
            hh(hu);
            if (this.aVC != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aVC.Kw()) {
                        dVar = null;
                        break;
                    }
                    d fP = this.aVC.fP((this.aVC.Kw() - 1) - i);
                    if (fP != null && fP.getFileName() != null && fP.getFileName().equals(hu)) {
                        dVar = fP;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.aVC.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hi(hu);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hu, currentTimeMillis2);
                dVar.ap(currentTimeMillis2);
                dVar.aq(m.hs(hu));
                this.aVC.a(dVar);
                j.aw(TAG, "total cache size: " + ((this.aVC.Kv() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aVC.Kw());
                if (this.aVC.Kv() > 629145600) {
                    while (this.aVC.Kv() > 524288000 && this.aVC.Kw() > 2 && Ky()) {
                    }
                    KA();
                }
                if (m.KN() < 314572800) {
                    while (m.KN() < 419430400 && this.aVC.Kw() > 2 && Ky()) {
                    }
                    KA();
                }
                j.aw(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Ky() {
        d fP = this.aVC.fP(0);
        if (fP == null || !(e.KD().hj(fP.getFileName()) || e.KD().hl(fP.getFileName()))) {
            this.aVC.remove(0);
            if (fP != null) {
                File file = new File(i.aWk + fP.getFileName());
                j.aw(TAG, "delete file " + file.getName());
                m.B(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.aWk + str);
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

    public void Kz() {
        if (this.aVC != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aVC.Kw() - 2; i++) {
                d fP = this.aVC.fP(i);
                if (fP != null) {
                    if (currentTimeMillis - fP.KB() < 86400000) {
                        break;
                    }
                    arrayList.add(fP);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.KD().hj(dVar.getFileName()) && !e.KD().hl(dVar.getFileName()))) {
                    this.aVC.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.aWk + dVar.getFileName());
                        j.aw(TAG, "delete expired file " + dVar.getFileName());
                        m.B(file);
                    }
                }
            }
            KA();
        }
    }

    private void hh(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.aWk + str + "/completed");
                    File file2 = new File(i.aWk + str + "/segments");
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
        if (this.aVC != null) {
            while (this.aVC.Kw() > 0 && Ky()) {
            }
            KA();
        }
    }

    private void KA() {
        File[] listFiles;
        File file = new File(i.aWj);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.B(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.B(file2);
                    }
                }
            }
        }
    }
}
