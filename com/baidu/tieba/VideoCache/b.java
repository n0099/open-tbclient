package com.baidu.tieba.VideoCache;

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
    private a cVP = new a();

    public b() {
        aCk();
    }

    private void aCk() {
        File[] listFiles;
        File file = new File(i.cWz);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.rZ(file2.getName());
                    dVar.bM(rW(file2.getAbsolutePath()));
                    dVar.bN(m.sj(file2.getName()));
                    this.cVP.a(dVar);
                }
            }
            Collections.sort(this.cVP.aCh(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long rW(String str) {
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
                        TiebaStatic.log(new an("c12028").bT("errormsg", "获取缓存文件的Access时间出现异常").bT("error", e.getMessage()).bT("name", file.getAbsolutePath()));
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

    public void rX(String str) {
        d dVar;
        String sl = m.sl(str);
        if (sl != null && !sl.isEmpty()) {
            rY(sl);
            if (this.cVP != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.cVP.aCj()) {
                        dVar = null;
                        break;
                    }
                    d mo = this.cVP.mo((this.cVP.aCj() - 1) - i);
                    if (mo != null && mo.getFileName() != null && mo.getFileName().equals(sl)) {
                        dVar = mo;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.cVP.b(dVar);
                } else {
                    dVar = new d();
                    dVar.rZ(sl);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                o(sl, currentTimeMillis2);
                dVar.bM(currentTimeMillis2);
                dVar.bN(m.sj(sl));
                this.cVP.a(dVar);
                j.am(TAG, "total cache size: " + ((this.cVP.aCi() / 1024) / 1024) + "M list size " + this.cVP.aCj());
                if (this.cVP.aCi() > 629145600) {
                    while (this.cVP.aCi() > 524288000 && this.cVP.aCj() > 2 && aCl()) {
                    }
                    aCn();
                }
                if (m.aCD() < 314572800) {
                    while (m.aCD() < 419430400 && this.cVP.aCj() > 2 && aCl()) {
                    }
                    aCn();
                }
                j.am(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aCl() {
        d mo = this.cVP.mo(0);
        if (mo == null || !(e.aCs().sa(mo.getFileName()) || e.aCs().sc(mo.getFileName()))) {
            this.cVP.remove(0);
            if (mo != null) {
                File file = new File(i.cWA + mo.getFileName());
                j.am(TAG, "delete file " + file.getName());
                m.I(file);
            }
            return true;
        }
        return false;
    }

    private void o(String str, long j) {
        File file = new File(i.cWA + str);
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
            TiebaStatic.log(new an("c12028").bT("errormsg", "修改缓存文件的Access时间出现异常").bT("error", e.getMessage()).bT("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aCm() {
        if (this.cVP != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.cVP.aCj() - 2; i++) {
                d mo = this.cVP.mo(i);
                if (mo != null) {
                    if (currentTimeMillis - mo.aCq() < 86400000) {
                        break;
                    }
                    arrayList.add(mo);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aCs().sa(dVar.getFileName()) && !e.aCs().sc(dVar.getFileName()))) {
                    this.cVP.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.cWA + dVar.getFileName());
                        j.am(TAG, "delete expired file " + dVar.getFileName());
                        m.I(file);
                    }
                }
            }
            aCn();
        }
    }

    private void rY(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.cWA + str + "/completed");
                    File file2 = new File(i.cWA + str + "/segments");
                    if (file.exists()) {
                        j.am(TAG, "delete segments");
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
        if (this.cVP != null) {
            while (this.cVP.aCj() > 0 && aCl()) {
            }
            aCn();
        }
    }

    private void aCn() {
        File[] listFiles;
        File file = new File(i.cWz);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.I(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.I(file2);
                    }
                }
            }
        }
    }
}
