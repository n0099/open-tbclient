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
    private a bld = new a();

    public b() {
        Qc();
    }

    private void Qc() {
        File[] listFiles;
        File file = new File(i.blP);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.ie(file2.getName());
                    dVar.aB(ia(file2.getAbsolutePath()));
                    dVar.aC(m.io(file2.getName()));
                    this.bld.a(dVar);
                }
            }
            Collections.sort(this.bld.PZ(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long ia(String str) {
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
                        TiebaStatic.log(new an("c12028").ae("errormsg", "获取缓存文件的Access时间出现异常").ae("error", e.getMessage()).ae("name", file.getAbsolutePath()));
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

    public void ib(String str) {
        d dVar;
        String iq = m.iq(str);
        if (iq != null && !iq.isEmpty()) {
            ic(iq);
            if (this.bld != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bld.Qb()) {
                        dVar = null;
                        break;
                    }
                    d go = this.bld.go((this.bld.Qb() - 1) - i);
                    if (go != null && go.getFileName() != null && go.getFileName().equals(iq)) {
                        dVar = go;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bld.b(dVar);
                } else {
                    dVar = new d();
                    dVar.ie(iq);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(iq, currentTimeMillis2);
                dVar.aB(currentTimeMillis2);
                dVar.aC(m.io(iq));
                this.bld.a(dVar);
                j.ax(TAG, "total cache size: " + ((this.bld.Qa() / 1024) / 1024) + "M list size " + this.bld.Qb());
                if (this.bld.Qa() > 629145600) {
                    while (this.bld.Qa() > 524288000 && this.bld.Qb() > 2 && Qd()) {
                    }
                    Qf();
                }
                if (m.Qv() < 314572800) {
                    while (m.Qv() < 419430400 && this.bld.Qb() > 2 && Qd()) {
                    }
                    Qf();
                }
                j.ax(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Qd() {
        d go = this.bld.go(0);
        if (go == null || !(e.Qk().m15if(go.getFileName()) || e.Qk().ih(go.getFileName()))) {
            this.bld.remove(0);
            if (go != null) {
                File file = new File(i.blQ + go.getFileName());
                j.ax(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.blQ + str);
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
            TiebaStatic.log(new an("c12028").ae("errormsg", "修改缓存文件的Access时间出现异常").ae("error", e.getMessage()).ae("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void Qe() {
        if (this.bld != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bld.Qb() - 2; i++) {
                d go = this.bld.go(i);
                if (go != null) {
                    if (currentTimeMillis - go.Qi() < 86400000) {
                        break;
                    }
                    arrayList.add(go);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Qk().m15if(dVar.getFileName()) && !e.Qk().ih(dVar.getFileName()))) {
                    this.bld.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.blQ + dVar.getFileName());
                        j.ax(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            Qf();
        }
    }

    private void ic(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.blQ + str + "/completed");
                    File file2 = new File(i.blQ + str + "/segments");
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
        if (this.bld != null) {
            while (this.bld.Qb() > 0 && Qd()) {
            }
            Qf();
        }
    }

    private void Qf() {
        File[] listFiles;
        File file = new File(i.blP);
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
