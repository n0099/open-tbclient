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
/* loaded from: classes4.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a dfk = new a();

    public b() {
        aCt();
    }

    private void aCt() {
        File[] listFiles;
        File file = new File(i.dfU);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.qJ(file2.getName());
                    dVar.bB(qG(file2.getAbsolutePath()));
                    dVar.bC(m.qT(file2.getName()));
                    this.dfk.a(dVar);
                }
            }
            Collections.sort(this.dfk.aCq(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long qG(String str) {
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
                        TiebaStatic.log(new an("c12028").bS("errormsg", "获取缓存文件的Access时间出现异常").bS(BdStatsConstant.StatsType.ERROR, e.getMessage()).bS("name", file.getAbsolutePath()));
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

    public void qH(String str) {
        d dVar;
        String qV = m.qV(str);
        if (qV != null && !qV.isEmpty()) {
            qI(qV);
            if (this.dfk != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.dfk.aCs()) {
                        dVar = null;
                        break;
                    }
                    d lt = this.dfk.lt((this.dfk.aCs() - 1) - i);
                    if (lt != null && lt.getFileName() != null && lt.getFileName().equals(qV)) {
                        dVar = lt;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.dfk.b(dVar);
                } else {
                    dVar = new d();
                    dVar.qJ(qV);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                q(qV, currentTimeMillis2);
                dVar.bB(currentTimeMillis2);
                dVar.bC(m.qT(qV));
                this.dfk.a(dVar);
                j.au(TAG, "total cache size: " + ((this.dfk.aCr() / 1024) / 1024) + "M list size " + this.dfk.aCs());
                if (this.dfk.aCr() > 629145600) {
                    while (this.dfk.aCr() > 524288000 && this.dfk.aCs() > 2 && aCu()) {
                    }
                    aCw();
                }
                if (m.aCM() < 314572800) {
                    while (m.aCM() < 419430400 && this.dfk.aCs() > 2 && aCu()) {
                    }
                    aCw();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aCu() {
        d lt = this.dfk.lt(0);
        if (lt == null || !(e.aCB().qK(lt.getFileName()) || e.aCB().qM(lt.getFileName()))) {
            this.dfk.remove(0);
            if (lt != null) {
                File file = new File(i.dfV + lt.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.u(file);
            }
            return true;
        }
        return false;
    }

    private void q(String str, long j) {
        File file = new File(i.dfV + str);
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
            TiebaStatic.log(new an("c12028").bS("errormsg", "修改缓存文件的Access时间出现异常").bS(BdStatsConstant.StatsType.ERROR, e.getMessage()).bS("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aCv() {
        if (this.dfk != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.dfk.aCs() - 2; i++) {
                d lt = this.dfk.lt(i);
                if (lt != null) {
                    if (currentTimeMillis - lt.aCz() < 86400000) {
                        break;
                    }
                    arrayList.add(lt);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aCB().qK(dVar.getFileName()) && !e.aCB().qM(dVar.getFileName()))) {
                    this.dfk.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.dfV + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.u(file);
                    }
                }
            }
            aCw();
        }
    }

    private void qI(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.dfV + str + "/completed");
                    File file2 = new File(i.dfV + str + "/segments");
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
        if (this.dfk != null) {
            while (this.dfk.aCs() > 0 && aCu()) {
            }
            aCw();
        }
    }

    private void aCw() {
        File[] listFiles;
        File file = new File(i.dfU);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.u(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.u(file2);
                    }
                }
            }
        }
    }
}
