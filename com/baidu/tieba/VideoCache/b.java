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
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a dSf = new a();

    public b() {
        aUm();
    }

    private void aUm() {
        File[] listFiles;
        File file = new File(i.dSP);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.setFileName(file2.getName());
                    dVar.cc(vQ(file2.getAbsolutePath()));
                    dVar.cd(m.wc(file2.getName()));
                    this.dSf.a(dVar);
                }
            }
            Collections.sort(this.dSf.aUj(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long vQ(String str) {
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

    public void vR(String str) {
        d dVar;
        String we = m.we(str);
        if (we != null && !we.isEmpty()) {
            vS(we);
            if (this.dSf != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.dSf.aUl()) {
                        dVar = null;
                        break;
                    }
                    d nG = this.dSf.nG((this.dSf.aUl() - 1) - i);
                    if (nG != null && nG.getFileName() != null && nG.getFileName().equals(we)) {
                        dVar = nG;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.dSf.b(dVar);
                } else {
                    dVar = new d();
                    dVar.setFileName(we);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                t(we, currentTimeMillis2);
                dVar.cc(currentTimeMillis2);
                dVar.cd(m.wc(we));
                this.dSf.a(dVar);
                j.aJ(TAG, "total cache size: " + ((this.dSf.aUk() / 1024) / 1024) + "M list size " + this.dSf.aUl());
                if (this.dSf.aUk() > 629145600) {
                    while (this.dSf.aUk() > 524288000 && this.dSf.aUl() > 2 && aUn()) {
                    }
                    aUp();
                }
                if (m.aUD() < 314572800) {
                    while (m.aUD() < 419430400 && this.dSf.aUl() > 2 && aUn()) {
                    }
                    aUp();
                }
                j.aJ(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aUn() {
        d nG = this.dSf.nG(0);
        if (nG == null || !(e.aUt().vT(nG.getFileName()) || e.aUt().vV(nG.getFileName()))) {
            this.dSf.remove(0);
            if (nG != null) {
                File file = new File(i.dSQ + nG.getFileName());
                j.aJ(TAG, "delete file " + file.getName());
                m.H(file);
            }
            return true;
        }
        return false;
    }

    private void t(String str, long j) {
        File file = new File(i.dSQ + str);
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

    public void aUo() {
        if (this.dSf != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.dSf.aUl() - 2; i++) {
                d nG = this.dSf.nG(i);
                if (nG != null) {
                    if (currentTimeMillis - nG.aUs() < 86400000) {
                        break;
                    }
                    arrayList.add(nG);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aUt().vT(dVar.getFileName()) && !e.aUt().vV(dVar.getFileName()))) {
                    this.dSf.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.dSQ + dVar.getFileName());
                        j.aJ(TAG, "delete expired file " + dVar.getFileName());
                        m.H(file);
                    }
                }
            }
            aUp();
        }
    }

    private void vS(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.dSQ + str + "/completed");
                    File file2 = new File(i.dSQ + str + "/segments");
                    if (file.exists()) {
                        j.aJ(TAG, "delete segments");
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
        if (this.dSf != null) {
            while (this.dSf.aUl() > 0 && aUn()) {
            }
            aUp();
        }
    }

    private void aUp() {
        File[] listFiles;
        File file = new File(i.dSP);
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
