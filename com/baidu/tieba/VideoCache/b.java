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
    private a dWX = new a();

    public b() {
        aXd();
    }

    private void aXd() {
        File[] listFiles;
        File file = new File(i.dXH);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cl(wp(file2.getAbsolutePath()));
                    dVar.cm(m.wB(file2.getName()));
                    this.dWX.a(dVar);
                }
            }
            Collections.sort(this.dWX.aXa(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long wp(String str) {
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
                        TiebaStatic.log(new an("c12028").cx("errormsg", "获取缓存文件的Access时间出现异常").cx(BdStatsConstant.StatsType.ERROR, e.getMessage()).cx("name", file.getAbsolutePath()));
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

    public void wq(String str) {
        d dVar;
        String wD = m.wD(str);
        if (wD != null && !wD.isEmpty()) {
            wr(wD);
            if (this.dWX != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.dWX.aXc()) {
                        dVar = null;
                        break;
                    }
                    d nZ = this.dWX.nZ((this.dWX.aXc() - 1) - i);
                    if (nZ != null && nZ.getFileName() != null && nZ.getFileName().equals(wD)) {
                        dVar = nZ;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.dWX.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(wD);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                t(wD, currentTimeMillis2);
                dVar.cl(currentTimeMillis2);
                dVar.cm(m.wB(wD));
                this.dWX.a(dVar);
                j.z(TAG, "total cache size: " + ((this.dWX.aXb() / 1024) / 1024) + "M list size " + this.dWX.aXc());
                if (this.dWX.aXb() > 629145600) {
                    while (this.dWX.aXb() > 524288000 && this.dWX.aXc() > 2 && aXe()) {
                    }
                    aXg();
                }
                if (m.aXu() < 314572800) {
                    while (m.aXu() < 419430400 && this.dWX.aXc() > 2 && aXe()) {
                    }
                    aXg();
                }
                j.z(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aXe() {
        d nZ = this.dWX.nZ(0);
        if (nZ == null || !(e.aXk().ws(nZ.getFileName()) || e.aXk().wu(nZ.getFileName()))) {
            this.dWX.remove(0);
            if (nZ != null) {
                File file = new File(i.dXI + nZ.getFileName());
                j.z(TAG, "delete file " + file.getName());
                m.J(file);
            }
            return true;
        }
        return false;
    }

    private void t(String str, long j) {
        File file = new File(i.dXI + str);
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
            TiebaStatic.log(new an("c12028").cx("errormsg", "修改缓存文件的Access时间出现异常").cx(BdStatsConstant.StatsType.ERROR, e.getMessage()).cx("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aXf() {
        if (this.dWX != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.dWX.aXc() - 2; i++) {
                d nZ = this.dWX.nZ(i);
                if (nZ != null) {
                    if (currentTimeMillis - nZ.aXj() < 86400000) {
                        break;
                    }
                    arrayList.add(nZ);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aXk().ws(dVar.getFileName()) && !e.aXk().wu(dVar.getFileName()))) {
                    this.dWX.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.dXI + dVar.getFileName());
                        j.z(TAG, "delete expired file " + dVar.getFileName());
                        m.J(file);
                    }
                }
            }
            aXg();
        }
    }

    private void wr(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.dXI + str + "/completed");
                    File file2 = new File(i.dXI + str + "/segments");
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
        if (this.dWX != null) {
            while (this.dWX.aXc() > 0 && aXe()) {
            }
            aXg();
        }
    }

    private void aXg() {
        File[] listFiles;
        File file = new File(i.dXH);
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
