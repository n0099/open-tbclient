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
    private a ewR = new a();

    public b() {
        bfh();
    }

    private void bfh() {
        File[] listFiles;
        File file = new File(i.exC);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cS(xC(file2.getAbsolutePath()));
                    dVar.cT(m.xO(file2.getName()));
                    this.ewR.a(dVar);
                }
            }
            Collections.sort(this.ewR.bfe(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long xC(String str) {
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
                        TiebaStatic.log(new an("c12028").cI("errormsg", "获取缓存文件的Access时间出现异常").cI(BdStatsConstant.StatsType.ERROR, e.getMessage()).cI("name", file.getAbsolutePath()));
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

    public void xD(String str) {
        d dVar;
        String xQ = m.xQ(str);
        if (xQ != null && !xQ.isEmpty()) {
            xE(xQ);
            if (this.ewR != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.ewR.bfg()) {
                        dVar = null;
                        break;
                    }
                    d om = this.ewR.om((this.ewR.bfg() - 1) - i);
                    if (om != null && om.getFileName() != null && om.getFileName().equals(xQ)) {
                        dVar = om;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.ewR.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(xQ);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                u(xQ, currentTimeMillis2);
                dVar.cS(currentTimeMillis2);
                dVar.cT(m.xO(xQ));
                this.ewR.a(dVar);
                j.D(TAG, "total cache size: " + ((this.ewR.bff() / 1024) / 1024) + "M list size " + this.ewR.bfg());
                if (this.ewR.bff() > 629145600) {
                    while (this.ewR.bff() > 524288000 && this.ewR.bfg() > 2 && bfi()) {
                    }
                    bfk();
                }
                if (m.bfz() < 314572800) {
                    while (m.bfz() < 419430400 && this.ewR.bfg() > 2 && bfi()) {
                    }
                    bfk();
                }
                j.D(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean bfi() {
        d om = this.ewR.om(0);
        if (om == null || !(e.bfp().xF(om.getFileName()) || e.bfp().xH(om.getFileName()))) {
            this.ewR.remove(0);
            if (om != null) {
                File file = new File(i.exD + om.getFileName());
                j.D(TAG, "delete file " + file.getName());
                m.J(file);
            }
            return true;
        }
        return false;
    }

    private void u(String str, long j) {
        File file = new File(i.exD + str);
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
            TiebaStatic.log(new an("c12028").cI("errormsg", "修改缓存文件的Access时间出现异常").cI(BdStatsConstant.StatsType.ERROR, e.getMessage()).cI("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void bfj() {
        if (this.ewR != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.ewR.bfg() - 2; i++) {
                d om = this.ewR.om(i);
                if (om != null) {
                    if (currentTimeMillis - om.bfn() < 86400000) {
                        break;
                    }
                    arrayList.add(om);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.bfp().xF(dVar.getFileName()) && !e.bfp().xH(dVar.getFileName()))) {
                    this.ewR.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.exD + dVar.getFileName());
                        j.D(TAG, "delete expired file " + dVar.getFileName());
                        m.J(file);
                    }
                }
            }
            bfk();
        }
    }

    private void xE(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.exD + str + "/completed");
                    File file2 = new File(i.exD + str + "/segments");
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
        if (this.ewR != null) {
            while (this.ewR.bfg() > 0 && bfi()) {
            }
            bfk();
        }
    }

    private void bfk() {
        File[] listFiles;
        File file = new File(i.exC);
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
