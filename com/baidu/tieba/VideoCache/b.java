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
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a aSm = new a();

    public b() {
        JE();
    }

    private void JE() {
        File[] listFiles;
        File file = new File(j.aSS);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    e eVar = new e();
                    eVar.gB(file2.getName());
                    eVar.ao(gy(file2.getAbsolutePath()));
                    eVar.ap(o.gL(file2.getName()));
                    this.aSm.a(eVar);
                }
            }
            Collections.sort(this.aSm.JB(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gy(String str) {
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

    public void gz(String str) {
        e eVar;
        String gN = o.gN(str);
        if (gN != null && !gN.isEmpty()) {
            gA(gN);
            if (this.aSm != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.aSm.JD()) {
                        eVar = null;
                        break;
                    }
                    e fH = this.aSm.fH((this.aSm.JD() - 1) - i);
                    if (fH != null && fH.getFileName() != null && fH.getFileName().equals(gN)) {
                        eVar = fH;
                        break;
                    }
                    i++;
                }
                if (eVar != null) {
                    this.aSm.b(eVar);
                } else {
                    eVar = new e();
                    eVar.gB(gN);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(gN, currentTimeMillis2);
                eVar.ao(currentTimeMillis2);
                eVar.ap(o.gL(gN));
                this.aSm.a(eVar);
                k.log(TAG, "total cache size: " + ((this.aSm.JC() / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT) + "M list size " + this.aSm.JD());
                if (this.aSm.JC() > 629145600) {
                    while (this.aSm.JC() > 524288000 && this.aSm.JD() > 2 && JF()) {
                    }
                    JH();
                }
                if (o.JU() < 314572800) {
                    while (o.JU() < 419430400 && this.aSm.JD() > 2 && JF()) {
                    }
                    JH();
                }
                k.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean JF() {
        e fH = this.aSm.fH(0);
        if (fH == null || !(f.JK().gC(fH.getFileName()) || f.JK().gE(fH.getFileName()))) {
            this.aSm.remove(0);
            if (fH != null) {
                File file = new File(String.valueOf(j.aST) + fH.getFileName());
                k.log(TAG, "delete file " + file.getName());
                o.x(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(String.valueOf(j.aST) + str);
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

    public void JG() {
        if (this.aSm != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.aSm.JD() - 2; i++) {
                e fH = this.aSm.fH(i);
                if (fH != null) {
                    if (currentTimeMillis - fH.JI() < 86400000) {
                        break;
                    }
                    arrayList.add(fH);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = (e) arrayList.get(i2);
                if (eVar == null || (!f.JK().gC(eVar.getFileName()) && !f.JK().gE(eVar.getFileName()))) {
                    this.aSm.b(eVar);
                    if (eVar != null) {
                        File file = new File(String.valueOf(j.aST) + eVar.getFileName());
                        k.log(TAG, "delete expired file " + eVar.getFileName());
                        o.x(file);
                    }
                }
            }
            JH();
        }
    }

    private void gA(String str) {
        File[] listFiles;
        if (str != null && !str.isEmpty()) {
            File file = new File(String.valueOf(j.aST) + str + "/completed");
            File file2 = new File(String.valueOf(j.aST) + str + "/segments");
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
        if (this.aSm != null) {
            while (this.aSm.JD() > 0 && JF()) {
            }
            JH();
        }
    }

    private void JH() {
        File[] listFiles;
        File file = new File(j.aSS);
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
