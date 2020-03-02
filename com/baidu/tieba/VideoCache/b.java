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
/* loaded from: classes9.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a dWu = new a();

    public b() {
        aWY();
    }

    private void aWY() {
        File[] listFiles;
        File file = new File(i.dXe);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cl(wo(file2.getAbsolutePath()));
                    dVar.cm(m.wA(file2.getName()));
                    this.dWu.a(dVar);
                }
            }
            Collections.sort(this.dWu.aWV(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long wo(String str) {
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
                        TiebaStatic.log(new an("c12028").cy("errormsg", "获取缓存文件的Access时间出现异常").cy(BdStatsConstant.StatsType.ERROR, e.getMessage()).cy("name", file.getAbsolutePath()));
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

    public void wp(String str) {
        d dVar;
        String wC = m.wC(str);
        if (wC != null && !wC.isEmpty()) {
            wq(wC);
            if (this.dWu != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.dWu.aWX()) {
                        dVar = null;
                        break;
                    }
                    d nX = this.dWu.nX((this.dWu.aWX() - 1) - i);
                    if (nX != null && nX.getFileName() != null && nX.getFileName().equals(wC)) {
                        dVar = nX;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.dWu.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(wC);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                t(wC, currentTimeMillis2);
                dVar.cl(currentTimeMillis2);
                dVar.cm(m.wA(wC));
                this.dWu.a(dVar);
                j.z(TAG, "total cache size: " + ((this.dWu.aWW() / 1024) / 1024) + "M list size " + this.dWu.aWX());
                if (this.dWu.aWW() > 629145600) {
                    while (this.dWu.aWW() > 524288000 && this.dWu.aWX() > 2 && aWZ()) {
                    }
                    aXb();
                }
                if (m.aXp() < 314572800) {
                    while (m.aXp() < 419430400 && this.dWu.aWX() > 2 && aWZ()) {
                    }
                    aXb();
                }
                j.z(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aWZ() {
        d nX = this.dWu.nX(0);
        if (nX == null || !(e.aXf().wr(nX.getFileName()) || e.aXf().wt(nX.getFileName()))) {
            this.dWu.remove(0);
            if (nX != null) {
                File file = new File(i.dXf + nX.getFileName());
                j.z(TAG, "delete file " + file.getName());
                m.J(file);
            }
            return true;
        }
        return false;
    }

    private void t(String str, long j) {
        File file = new File(i.dXf + str);
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
            TiebaStatic.log(new an("c12028").cy("errormsg", "修改缓存文件的Access时间出现异常").cy(BdStatsConstant.StatsType.ERROR, e.getMessage()).cy("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aXa() {
        if (this.dWu != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.dWu.aWX() - 2; i++) {
                d nX = this.dWu.nX(i);
                if (nX != null) {
                    if (currentTimeMillis - nX.aXe() < 86400000) {
                        break;
                    }
                    arrayList.add(nX);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aXf().wr(dVar.getFileName()) && !e.aXf().wt(dVar.getFileName()))) {
                    this.dWu.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.dXf + dVar.getFileName());
                        j.z(TAG, "delete expired file " + dVar.getFileName());
                        m.J(file);
                    }
                }
            }
            aXb();
        }
    }

    private void wq(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.dXf + str + "/completed");
                    File file2 = new File(i.dXf + str + "/segments");
                    if (file.exists()) {
                        j.z(TAG, "delete segments");
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
        if (this.dWu != null) {
            while (this.dWu.aWX() > 0 && aWZ()) {
            }
            aXb();
        }
    }

    private void aXb() {
        File[] listFiles;
        File file = new File(i.dXe);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.J(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.J(file2);
                    }
                }
            }
        }
    }
}
