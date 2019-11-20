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
    private a det = new a();

    public b() {
        aCr();
    }

    private void aCr() {
        File[] listFiles;
        File file = new File(i.dfd);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.qJ(file2.getName());
                    dVar.bA(qG(file2.getAbsolutePath()));
                    dVar.bB(m.qT(file2.getName()));
                    this.det.a(dVar);
                }
            }
            Collections.sort(this.det.aCo(), new AccessTimeComparator());
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
            if (this.det != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.det.aCq()) {
                        dVar = null;
                        break;
                    }
                    d ls = this.det.ls((this.det.aCq() - 1) - i);
                    if (ls != null && ls.getFileName() != null && ls.getFileName().equals(qV)) {
                        dVar = ls;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.det.b(dVar);
                } else {
                    dVar = new d();
                    dVar.qJ(qV);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                q(qV, currentTimeMillis2);
                dVar.bA(currentTimeMillis2);
                dVar.bB(m.qT(qV));
                this.det.a(dVar);
                j.au(TAG, "total cache size: " + ((this.det.aCp() / 1024) / 1024) + "M list size " + this.det.aCq());
                if (this.det.aCp() > 629145600) {
                    while (this.det.aCp() > 524288000 && this.det.aCq() > 2 && aCs()) {
                    }
                    aCu();
                }
                if (m.aCK() < 314572800) {
                    while (m.aCK() < 419430400 && this.det.aCq() > 2 && aCs()) {
                    }
                    aCu();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aCs() {
        d ls = this.det.ls(0);
        if (ls == null || !(e.aCz().qK(ls.getFileName()) || e.aCz().qM(ls.getFileName()))) {
            this.det.remove(0);
            if (ls != null) {
                File file = new File(i.dfe + ls.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.u(file);
            }
            return true;
        }
        return false;
    }

    private void q(String str, long j) {
        File file = new File(i.dfe + str);
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

    public void aCt() {
        if (this.det != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.det.aCq() - 2; i++) {
                d ls = this.det.ls(i);
                if (ls != null) {
                    if (currentTimeMillis - ls.aCx() < 86400000) {
                        break;
                    }
                    arrayList.add(ls);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aCz().qK(dVar.getFileName()) && !e.aCz().qM(dVar.getFileName()))) {
                    this.det.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.dfe + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.u(file);
                    }
                }
            }
            aCu();
        }
    }

    private void qI(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.dfe + str + "/completed");
                    File file2 = new File(i.dfe + str + "/segments");
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
        if (this.det != null) {
            while (this.det.aCq() > 0 && aCs()) {
            }
            aCu();
        }
    }

    private void aCu() {
        File[] listFiles;
        File file = new File(i.dfd);
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
