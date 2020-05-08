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
    private a ewW = new a();

    public b() {
        bff();
    }

    private void bff() {
        File[] listFiles;
        File file = new File(i.exH);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cS(xF(file2.getAbsolutePath()));
                    dVar.cT(m.xR(file2.getName()));
                    this.ewW.a(dVar);
                }
            }
            Collections.sort(this.ewW.bfc(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long xF(String str) {
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

    public void xG(String str) {
        d dVar;
        String xT = m.xT(str);
        if (xT != null && !xT.isEmpty()) {
            xH(xT);
            if (this.ewW != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.ewW.bfe()) {
                        dVar = null;
                        break;
                    }
                    d om = this.ewW.om((this.ewW.bfe() - 1) - i);
                    if (om != null && om.getFileName() != null && om.getFileName().equals(xT)) {
                        dVar = om;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.ewW.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(xT);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                u(xT, currentTimeMillis2);
                dVar.cS(currentTimeMillis2);
                dVar.cT(m.xR(xT));
                this.ewW.a(dVar);
                j.D(TAG, "total cache size: " + ((this.ewW.bfd() / 1024) / 1024) + "M list size " + this.ewW.bfe());
                if (this.ewW.bfd() > 629145600) {
                    while (this.ewW.bfd() > 524288000 && this.ewW.bfe() > 2 && bfg()) {
                    }
                    bfi();
                }
                if (m.bfx() < 314572800) {
                    while (m.bfx() < 419430400 && this.ewW.bfe() > 2 && bfg()) {
                    }
                    bfi();
                }
                j.D(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean bfg() {
        d om = this.ewW.om(0);
        if (om == null || !(e.bfn().xI(om.getFileName()) || e.bfn().xK(om.getFileName()))) {
            this.ewW.remove(0);
            if (om != null) {
                File file = new File(i.exI + om.getFileName());
                j.D(TAG, "delete file " + file.getName());
                m.J(file);
            }
            return true;
        }
        return false;
    }

    private void u(String str, long j) {
        File file = new File(i.exI + str);
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

    public void bfh() {
        if (this.ewW != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.ewW.bfe() - 2; i++) {
                d om = this.ewW.om(i);
                if (om != null) {
                    if (currentTimeMillis - om.bfl() < 86400000) {
                        break;
                    }
                    arrayList.add(om);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.bfn().xI(dVar.getFileName()) && !e.bfn().xK(dVar.getFileName()))) {
                    this.ewW.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.exI + dVar.getFileName());
                        j.D(TAG, "delete expired file " + dVar.getFileName());
                        m.J(file);
                    }
                }
            }
            bfi();
        }
    }

    private void xH(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.exI + str + "/completed");
                    File file2 = new File(i.exI + str + "/segments");
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
        if (this.ewW != null) {
            while (this.ewW.bfe() > 0 && bfg()) {
            }
            bfi();
        }
    }

    private void bfi() {
        File[] listFiles;
        File file = new File(i.exH);
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
