package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a bOD = new a();

    public b() {
        SO();
    }

    private void SO() {
        File[] listFiles;
        File file = new File(i.bPq);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hr(file2.getName());
                    dVar.aC(ho(file2.getAbsolutePath()));
                    dVar.aD(m.hB(file2.getName()));
                    this.bOD.a(dVar);
                }
            }
            Collections.sort(this.bOD.SL(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long ho(String str) {
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
                        TiebaStatic.log(new ak("c12028").ab("errormsg", "获取缓存文件的Access时间出现异常").ab("error", e.getMessage()).ab("name", file.getAbsolutePath()));
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

    public void hp(String str) {
        d dVar;
        String hD = m.hD(str);
        if (hD != null && !hD.isEmpty()) {
            hq(hD);
            if (this.bOD != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bOD.SN()) {
                        dVar = null;
                        break;
                    }
                    d jn = this.bOD.jn((this.bOD.SN() - 1) - i);
                    if (jn != null && jn.getFileName() != null && jn.getFileName().equals(hD)) {
                        dVar = jn;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bOD.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hr(hD);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hD, currentTimeMillis2);
                dVar.aC(currentTimeMillis2);
                dVar.aD(m.hB(hD));
                this.bOD.a(dVar);
                j.au(TAG, "total cache size: " + ((this.bOD.SM() / 1024) / 1024) + "M list size " + this.bOD.SN());
                if (this.bOD.SM() > 629145600) {
                    while (this.bOD.SM() > 524288000 && this.bOD.SN() > 2 && SP()) {
                    }
                    SR();
                }
                if (m.Th() < 314572800) {
                    while (m.Th() < 419430400 && this.bOD.SN() > 2 && SP()) {
                    }
                    SR();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean SP() {
        d jn = this.bOD.jn(0);
        if (jn == null || !(e.SW().hs(jn.getFileName()) || e.SW().hu(jn.getFileName()))) {
            this.bOD.remove(0);
            if (jn != null) {
                File file = new File(i.bPr + jn.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bPr + str);
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
            TiebaStatic.log(new ak("c12028").ab("errormsg", "修改缓存文件的Access时间出现异常").ab("error", e.getMessage()).ab("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void SQ() {
        if (this.bOD != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bOD.SN() - 2; i++) {
                d jn = this.bOD.jn(i);
                if (jn != null) {
                    if (currentTimeMillis - jn.SU() < 86400000) {
                        break;
                    }
                    arrayList.add(jn);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.SW().hs(dVar.getFileName()) && !e.SW().hu(dVar.getFileName()))) {
                    this.bOD.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bPr + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            SR();
        }
    }

    private void hq(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bPr + str + "/completed");
                    File file2 = new File(i.bPr + str + "/segments");
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
        if (this.bOD != null) {
            while (this.bOD.SN() > 0 && SP()) {
            }
            SR();
        }
    }

    private void SR() {
        File[] listFiles;
        File file = new File(i.bPq);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.z(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.z(file2);
                    }
                }
            }
        }
    }
}
