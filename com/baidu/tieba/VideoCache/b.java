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
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a bkY = new a();

    public b() {
        PW();
    }

    private void PW() {
        File[] listFiles;
        File file = new File(i.blK);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.ic(file2.getName());
                    dVar.aB(hZ(file2.getAbsolutePath()));
                    dVar.aC(m.in(file2.getName()));
                    this.bkY.a(dVar);
                }
            }
            Collections.sort(this.bkY.PT(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hZ(String str) {
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
                        TiebaStatic.log(new an("c12028").af("errormsg", "获取缓存文件的Access时间出现异常").af("error", e.getMessage()).af("name", file.getAbsolutePath()));
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

    public void ia(String str) {
        d dVar;
        String ip = m.ip(str);
        if (ip != null && !ip.isEmpty()) {
            ib(ip);
            if (this.bkY != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bkY.PV()) {
                        dVar = null;
                        break;
                    }
                    d gp = this.bkY.gp((this.bkY.PV() - 1) - i);
                    if (gp != null && gp.getFileName() != null && gp.getFileName().equals(ip)) {
                        dVar = gp;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bkY.b(dVar);
                } else {
                    dVar = new d();
                    dVar.ic(ip);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(ip, currentTimeMillis2);
                dVar.aB(currentTimeMillis2);
                dVar.aC(m.in(ip));
                this.bkY.a(dVar);
                j.ax(TAG, "total cache size: " + ((this.bkY.PU() / 1024) / 1024) + "M list size " + this.bkY.PV());
                if (this.bkY.PU() > 629145600) {
                    while (this.bkY.PU() > 524288000 && this.bkY.PV() > 2 && PX()) {
                    }
                    PZ();
                }
                if (m.Qp() < 314572800) {
                    while (m.Qp() < 419430400 && this.bkY.PV() > 2 && PX()) {
                    }
                    PZ();
                }
                j.ax(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean PX() {
        d gp = this.bkY.gp(0);
        if (gp == null || !(e.Qe().ie(gp.getFileName()) || e.Qe().ig(gp.getFileName()))) {
            this.bkY.remove(0);
            if (gp != null) {
                File file = new File(i.blL + gp.getFileName());
                j.ax(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.blL + str);
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
            TiebaStatic.log(new an("c12028").af("errormsg", "修改缓存文件的Access时间出现异常").af("error", e.getMessage()).af("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void PY() {
        if (this.bkY != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bkY.PV() - 2; i++) {
                d gp = this.bkY.gp(i);
                if (gp != null) {
                    if (currentTimeMillis - gp.Qc() < 86400000) {
                        break;
                    }
                    arrayList.add(gp);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Qe().ie(dVar.getFileName()) && !e.Qe().ig(dVar.getFileName()))) {
                    this.bkY.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.blL + dVar.getFileName());
                        j.ax(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            PZ();
        }
    }

    private void ib(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.blL + str + "/completed");
                    File file2 = new File(i.blL + str + "/segments");
                    if (file.exists()) {
                        j.ax(TAG, "delete segments");
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
        if (this.bkY != null) {
            while (this.bkY.PV() > 0 && PX()) {
            }
            PZ();
        }
    }

    private void PZ() {
        File[] listFiles;
        File file = new File(i.blK);
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
