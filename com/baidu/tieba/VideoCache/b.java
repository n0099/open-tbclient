package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
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
    private a baI = new a();

    public b() {
        LU();
    }

    private void LU() {
        File[] listFiles;
        File file = new File(i.bbu);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hC(file2.getName());
                    dVar.setAccessTime(hz(file2.getAbsolutePath()));
                    dVar.au(m.hM(file2.getName()));
                    this.baI.a(dVar);
                }
            }
            Collections.sort(this.baI.LR(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hz(String str) {
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
                        TiebaStatic.log(new al("c12028").ac("errormsg", "获取缓存文件的Access时间出现异常").ac("error", e.getMessage()).ac("name", file.getAbsolutePath()));
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

    public void hA(String str) {
        d dVar;
        String hO = m.hO(str);
        if (hO != null && !hO.isEmpty()) {
            hB(hO);
            if (this.baI != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.baI.LT()) {
                        dVar = null;
                        break;
                    }
                    d gi = this.baI.gi((this.baI.LT() - 1) - i);
                    if (gi != null && gi.getFileName() != null && gi.getFileName().equals(hO)) {
                        dVar = gi;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.baI.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hC(hO);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hO, currentTimeMillis2);
                dVar.setAccessTime(currentTimeMillis2);
                dVar.au(m.hM(hO));
                this.baI.a(dVar);
                j.au(TAG, "total cache size: " + ((this.baI.LS() / 1024) / 1024) + "M list size " + this.baI.LT());
                if (this.baI.LS() > 629145600) {
                    while (this.baI.LS() > 524288000 && this.baI.LT() > 2 && LV()) {
                    }
                    LX();
                }
                if (m.Mm() < 314572800) {
                    while (m.Mm() < 419430400 && this.baI.LT() > 2 && LV()) {
                    }
                    LX();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean LV() {
        d gi = this.baI.gi(0);
        if (gi == null || !(e.Mb().hD(gi.getFileName()) || e.Mb().hF(gi.getFileName()))) {
            this.baI.remove(0);
            if (gi != null) {
                File file = new File(i.bbv + gi.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bbv + str);
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
            TiebaStatic.log(new al("c12028").ac("errormsg", "修改缓存文件的Access时间出现异常").ac("error", e.getMessage()).ac("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void LW() {
        if (this.baI != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.baI.LT() - 2; i++) {
                d gi = this.baI.gi(i);
                if (gi != null) {
                    if (currentTimeMillis - gi.getAccessTime() < 86400000) {
                        break;
                    }
                    arrayList.add(gi);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Mb().hD(dVar.getFileName()) && !e.Mb().hF(dVar.getFileName()))) {
                    this.baI.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bbv + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            LX();
        }
    }

    private void hB(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bbv + str + "/completed");
                    File file2 = new File(i.bbv + str + "/segments");
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
        if (this.baI != null) {
            while (this.baI.LT() > 0 && LV()) {
            }
            LX();
        }
    }

    private void LX() {
        File[] listFiles;
        File file = new File(i.bbu);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.y(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.y(file2);
                    }
                }
            }
        }
    }
}
