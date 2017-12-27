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
    private a bOv = new a();

    public b() {
        Ta();
    }

    private void Ta() {
        File[] listFiles;
        File file = new File(i.bPj);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hq(file2.getName());
                    dVar.aC(hn(file2.getAbsolutePath()));
                    dVar.aD(m.hA(file2.getName()));
                    this.bOv.a(dVar);
                }
            }
            Collections.sort(this.bOv.SX(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hn(String str) {
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

    public void ho(String str) {
        d dVar;
        String hC = m.hC(str);
        if (hC != null && !hC.isEmpty()) {
            hp(hC);
            if (this.bOv != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bOv.SZ()) {
                        dVar = null;
                        break;
                    }
                    d jr = this.bOv.jr((this.bOv.SZ() - 1) - i);
                    if (jr != null && jr.getFileName() != null && jr.getFileName().equals(hC)) {
                        dVar = jr;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bOv.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hq(hC);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hC, currentTimeMillis2);
                dVar.aC(currentTimeMillis2);
                dVar.aD(m.hA(hC));
                this.bOv.a(dVar);
                j.au(TAG, "total cache size: " + ((this.bOv.SY() / 1024) / 1024) + "M list size " + this.bOv.SZ());
                if (this.bOv.SY() > 629145600) {
                    while (this.bOv.SY() > 524288000 && this.bOv.SZ() > 2 && Tb()) {
                    }
                    Td();
                }
                if (m.Tt() < 314572800) {
                    while (m.Tt() < 419430400 && this.bOv.SZ() > 2 && Tb()) {
                    }
                    Td();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Tb() {
        d jr = this.bOv.jr(0);
        if (jr == null || !(e.Ti().hr(jr.getFileName()) || e.Ti().ht(jr.getFileName()))) {
            this.bOv.remove(0);
            if (jr != null) {
                File file = new File(i.bPk + jr.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.z(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bPk + str);
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

    public void Tc() {
        if (this.bOv != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bOv.SZ() - 2; i++) {
                d jr = this.bOv.jr(i);
                if (jr != null) {
                    if (currentTimeMillis - jr.Tg() < 86400000) {
                        break;
                    }
                    arrayList.add(jr);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Ti().hr(dVar.getFileName()) && !e.Ti().ht(dVar.getFileName()))) {
                    this.bOv.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bPk + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.z(file);
                    }
                }
            }
            Td();
        }
    }

    private void hp(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bPk + str + "/completed");
                    File file2 = new File(i.bPk + str + "/segments");
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
        if (this.bOv != null) {
            while (this.bOv.SZ() > 0 && Tb()) {
            }
            Td();
        }
    }

    private void Td() {
        File[] listFiles;
        File file = new File(i.bPj);
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
