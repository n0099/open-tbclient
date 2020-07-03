package com.baidu.tieba.VideoCache;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes9.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a eVW = new a();

    public b() {
        bnS();
    }

    private void bnS() {
        File[] listFiles;
        File file = new File(i.eWG);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cW(zE(file2.getAbsolutePath()));
                    dVar.cX(m.zQ(file2.getName()));
                    this.eVW.a(dVar);
                }
            }
            Collections.sort(this.eVW.bnP(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long zE(String str) {
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
                        TiebaStatic.log(new ao("c12028").dk("errormsg", "获取缓存文件的Access时间出现异常").dk(BdStatsConstant.StatsType.ERROR, e.getMessage()).dk("name", file.getAbsolutePath()));
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

    public void zF(String str) {
        d dVar;
        String zS = m.zS(str);
        if (zS != null && !zS.isEmpty()) {
            zG(zS);
            if (this.eVW != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.eVW.bnR()) {
                        dVar = null;
                        break;
                    }
                    d pu = this.eVW.pu((this.eVW.bnR() - 1) - i);
                    if (pu != null && pu.getFileName() != null && pu.getFileName().equals(zS)) {
                        dVar = pu;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.eVW.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(zS);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                t(zS, currentTimeMillis2);
                dVar.cW(currentTimeMillis2);
                dVar.cX(m.zQ(zS));
                this.eVW.a(dVar);
                j.D(TAG, "total cache size: " + ((this.eVW.bnQ() / 1024) / 1024) + "M list size " + this.eVW.bnR());
                if (this.eVW.bnQ() > 629145600) {
                    while (this.eVW.bnQ() > 524288000 && this.eVW.bnR() > 2 && bnT()) {
                    }
                    bnV();
                }
                if (m.bok() < 314572800) {
                    while (m.bok() < 419430400 && this.eVW.bnR() > 2 && bnT()) {
                    }
                    bnV();
                }
                j.D(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean bnT() {
        d pu = this.eVW.pu(0);
        if (pu == null || !(e.boa().zH(pu.getFileName()) || e.boa().zJ(pu.getFileName()))) {
            this.eVW.remove(0);
            if (pu != null) {
                File file = new File(i.eWH + pu.getFileName());
                j.D(TAG, "delete file " + file.getName());
                m.O(file);
            }
            return true;
        }
        return false;
    }

    private void t(String str, long j) {
        File file = new File(i.eWH + str);
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
            TiebaStatic.log(new ao("c12028").dk("errormsg", "修改缓存文件的Access时间出现异常").dk(BdStatsConstant.StatsType.ERROR, e.getMessage()).dk("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void bnU() {
        if (this.eVW != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.eVW.bnR() - 2; i++) {
                d pu = this.eVW.pu(i);
                if (pu != null) {
                    if (currentTimeMillis - pu.bnY() < 86400000) {
                        break;
                    }
                    arrayList.add(pu);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.boa().zH(dVar.getFileName()) && !e.boa().zJ(dVar.getFileName()))) {
                    this.eVW.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.eWH + dVar.getFileName());
                        j.D(TAG, "delete expired file " + dVar.getFileName());
                        m.O(file);
                    }
                }
            }
            bnV();
        }
    }

    private void zG(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.eWH + str + "/completed");
                    File file2 = new File(i.eWH + str + "/segments");
                    if (file.exists()) {
                        j.D(TAG, "delete segments");
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
        if (this.eVW != null) {
            while (this.eVW.bnR() > 0 && bnT()) {
            }
            bnV();
        }
    }

    private void bnV() {
        File[] listFiles;
        File file = new File(i.eWG);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.O(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.O(file2);
                    }
                }
            }
        }
    }
}
