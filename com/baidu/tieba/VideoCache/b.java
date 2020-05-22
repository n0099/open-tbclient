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
    private a eLz = new a();

    public b() {
        blr();
    }

    private void blr() {
        File[] listFiles;
        File file = new File(i.eMj);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cU(zl(file2.getAbsolutePath()));
                    dVar.cV(m.zx(file2.getName()));
                    this.eLz.a(dVar);
                }
            }
            Collections.sort(this.eLz.blo(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long zl(String str) {
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
                        TiebaStatic.log(new an("c12028").dh("errormsg", "获取缓存文件的Access时间出现异常").dh(BdStatsConstant.StatsType.ERROR, e.getMessage()).dh("name", file.getAbsolutePath()));
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

    public void zm(String str) {
        d dVar;
        String zz = m.zz(str);
        if (zz != null && !zz.isEmpty()) {
            zn(zz);
            if (this.eLz != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.eLz.blq()) {
                        dVar = null;
                        break;
                    }
                    d oT = this.eLz.oT((this.eLz.blq() - 1) - i);
                    if (oT != null && oT.getFileName() != null && oT.getFileName().equals(zz)) {
                        dVar = oT;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.eLz.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(zz);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                t(zz, currentTimeMillis2);
                dVar.cU(currentTimeMillis2);
                dVar.cV(m.zx(zz));
                this.eLz.a(dVar);
                j.D(TAG, "total cache size: " + ((this.eLz.blp() / 1024) / 1024) + "M list size " + this.eLz.blq());
                if (this.eLz.blp() > 629145600) {
                    while (this.eLz.blp() > 524288000 && this.eLz.blq() > 2 && bls()) {
                    }
                    blu();
                }
                if (m.blJ() < 314572800) {
                    while (m.blJ() < 419430400 && this.eLz.blq() > 2 && bls()) {
                    }
                    blu();
                }
                j.D(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean bls() {
        d oT = this.eLz.oT(0);
        if (oT == null || !(e.blz().zo(oT.getFileName()) || e.blz().zq(oT.getFileName()))) {
            this.eLz.remove(0);
            if (oT != null) {
                File file = new File(i.eMk + oT.getFileName());
                j.D(TAG, "delete file " + file.getName());
                m.N(file);
            }
            return true;
        }
        return false;
    }

    private void t(String str, long j) {
        File file = new File(i.eMk + str);
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
            TiebaStatic.log(new an("c12028").dh("errormsg", "修改缓存文件的Access时间出现异常").dh(BdStatsConstant.StatsType.ERROR, e.getMessage()).dh("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void blt() {
        if (this.eLz != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.eLz.blq() - 2; i++) {
                d oT = this.eLz.oT(i);
                if (oT != null) {
                    if (currentTimeMillis - oT.blx() < 86400000) {
                        break;
                    }
                    arrayList.add(oT);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.blz().zo(dVar.getFileName()) && !e.blz().zq(dVar.getFileName()))) {
                    this.eLz.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.eMk + dVar.getFileName());
                        j.D(TAG, "delete expired file " + dVar.getFileName());
                        m.N(file);
                    }
                }
            }
            blu();
        }
    }

    private void zn(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.eMk + str + "/completed");
                    File file2 = new File(i.eMk + str + "/segments");
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
        if (this.eLz != null) {
            while (this.eLz.blq() > 0 && bls()) {
            }
            blu();
        }
    }

    private void blu() {
        File[] listFiles;
        File file = new File(i.eMj);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.N(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.N(file2);
                    }
                }
            }
        }
    }
}
