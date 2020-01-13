package com.baidu.tieba.VideoCache;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes7.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a dSo = new a();

    public b() {
        aUG();
    }

    private void aUG() {
        File[] listFiles;
        File file = new File(i.dSY);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.ch(vU(file2.getAbsolutePath()));
                    dVar.ci(m.wg(file2.getName()));
                    this.dSo.a(dVar);
                }
            }
            Collections.sort(this.dSo.aUD(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long vU(String str) {
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
                        TiebaStatic.log(new an("c12028").cp("errormsg", "获取缓存文件的Access时间出现异常").cp(BdStatsConstant.StatsType.ERROR, e.getMessage()).cp("name", file.getAbsolutePath()));
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

    public void vV(String str) {
        d dVar;
        String wi = m.wi(str);
        if (wi != null && !wi.isEmpty()) {
            vW(wi);
            if (this.dSo != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.dSo.aUF()) {
                        dVar = null;
                        break;
                    }
                    d nG = this.dSo.nG((this.dSo.aUF() - 1) - i);
                    if (nG != null && nG.getFileName() != null && nG.getFileName().equals(wi)) {
                        dVar = nG;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.dSo.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(wi);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                t(wi, currentTimeMillis2);
                dVar.ch(currentTimeMillis2);
                dVar.ci(m.wg(wi));
                this.dSo.a(dVar);
                j.aK(TAG, "total cache size: " + ((this.dSo.aUE() / 1024) / 1024) + "M list size " + this.dSo.aUF());
                if (this.dSo.aUE() > 629145600) {
                    while (this.dSo.aUE() > 524288000 && this.dSo.aUF() > 2 && aUH()) {
                    }
                    aUJ();
                }
                if (m.aUX() < 314572800) {
                    while (m.aUX() < 419430400 && this.dSo.aUF() > 2 && aUH()) {
                    }
                    aUJ();
                }
                j.aK(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aUH() {
        d nG = this.dSo.nG(0);
        if (nG == null || !(e.aUN().vX(nG.getFileName()) || e.aUN().vZ(nG.getFileName()))) {
            this.dSo.remove(0);
            if (nG != null) {
                File file = new File(i.dSZ + nG.getFileName());
                j.aK(TAG, "delete file " + file.getName());
                m.H(file);
            }
            return true;
        }
        return false;
    }

    private void t(String str, long j) {
        File file = new File(i.dSZ + str);
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
            TiebaStatic.log(new an("c12028").cp("errormsg", "修改缓存文件的Access时间出现异常").cp(BdStatsConstant.StatsType.ERROR, e.getMessage()).cp("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aUI() {
        if (this.dSo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.dSo.aUF() - 2; i++) {
                d nG = this.dSo.nG(i);
                if (nG != null) {
                    if (currentTimeMillis - nG.aUM() < 86400000) {
                        break;
                    }
                    arrayList.add(nG);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aUN().vX(dVar.getFileName()) && !e.aUN().vZ(dVar.getFileName()))) {
                    this.dSo.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.dSZ + dVar.getFileName());
                        j.aK(TAG, "delete expired file " + dVar.getFileName());
                        m.H(file);
                    }
                }
            }
            aUJ();
        }
    }

    private void vW(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.dSZ + str + "/completed");
                    File file2 = new File(i.dSZ + str + "/segments");
                    if (file.exists()) {
                        j.aK(TAG, "delete segments");
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
        if (this.dSo != null) {
            while (this.dSo.aUF() > 0 && aUH()) {
            }
            aUJ();
        }
    }

    private void aUJ() {
        File[] listFiles;
        File file = new File(i.dSY);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.H(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.H(file2);
                    }
                }
            }
        }
    }
}
