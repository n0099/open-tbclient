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
    private a aXt = new a();

    public b() {
        KS();
    }

    private void KS() {
        File[] listFiles;
        File file = new File(i.aYa);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hm(file2.getName());
                    dVar.aq(hj(file2.getAbsolutePath()));
                    dVar.ar(m.hw(file2.getName()));
                    this.aXt.a(dVar);
                }
            }
            Collections.sort(this.aXt.KP(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hj(String str) {
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

    public void hk(String str) {
        d dVar;
        String hy = m.hy(str);
        if (hy != null && !hy.isEmpty()) {
            hl(hy);
            if (this.aXt != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aXt.KR()) {
                        dVar = null;
                        break;
                    }
                    d gl = this.aXt.gl((this.aXt.KR() - 1) - i);
                    if (gl != null && gl.getFileName() != null && gl.getFileName().equals(hy)) {
                        dVar = gl;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.aXt.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hm(hy);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hy, currentTimeMillis2);
                dVar.aq(currentTimeMillis2);
                dVar.ar(m.hw(hy));
                this.aXt.a(dVar);
                j.au(TAG, "total cache size: " + ((this.aXt.KQ() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aXt.KR());
                if (this.aXt.KQ() > 629145600) {
                    while (this.aXt.KQ() > 524288000 && this.aXt.KR() > 2 && KT()) {
                    }
                    KV();
                }
                if (m.Li() < 314572800) {
                    while (m.Li() < 419430400 && this.aXt.KR() > 2 && KT()) {
                    }
                    KV();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean KT() {
        d gl = this.aXt.gl(0);
        if (gl == null || !(e.KY().hn(gl.getFileName()) || e.KY().hp(gl.getFileName()))) {
            this.aXt.remove(0);
            if (gl != null) {
                File file = new File(i.aYb + gl.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.aYb + str);
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

    public void KU() {
        if (this.aXt != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aXt.KR() - 2; i++) {
                d gl = this.aXt.gl(i);
                if (gl != null) {
                    if (currentTimeMillis - gl.KW() < 86400000) {
                        break;
                    }
                    arrayList.add(gl);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.KY().hn(dVar.getFileName()) && !e.KY().hp(dVar.getFileName()))) {
                    this.aXt.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.aYb + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            KV();
        }
    }

    private void hl(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.aYb + str + "/completed");
                    File file2 = new File(i.aYb + str + "/segments");
                    if (file.exists()) {
                        j.au(TAG, "delete segments");
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
        if (this.aXt != null) {
            while (this.aXt.KR() > 0 && KT()) {
            }
            KV();
        }
    }

    private void KV() {
        File[] listFiles;
        File file = new File(i.aYa);
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
