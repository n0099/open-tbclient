package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private a cLg = new a();

    public b() {
        avw();
    }

    private void avw() {
        File[] listFiles;
        File file = new File(i.cLQ);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.qo(file2.getName());
                    dVar.bt(ql(file2.getAbsolutePath()));
                    dVar.bu(m.qy(file2.getName()));
                    this.cLg.a(dVar);
                }
            }
            Collections.sort(this.cLg.avt(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long ql(String str) {
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
                        TiebaStatic.log(new am("c12028").bJ("errormsg", "获取缓存文件的Access时间出现异常").bJ("error", e.getMessage()).bJ("name", file.getAbsolutePath()));
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

    public void qm(String str) {
        d dVar;
        String qA = m.qA(str);
        if (qA != null && !qA.isEmpty()) {
            qn(qA);
            if (this.cLg != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.cLg.avv()) {
                        dVar = null;
                        break;
                    }
                    d ln = this.cLg.ln((this.cLg.avv() - 1) - i);
                    if (ln != null && ln.getFileName() != null && ln.getFileName().equals(qA)) {
                        dVar = ln;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.cLg.b(dVar);
                } else {
                    dVar = new d();
                    dVar.qo(qA);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                l(qA, currentTimeMillis2);
                dVar.bt(currentTimeMillis2);
                dVar.bu(m.qy(qA));
                this.cLg.a(dVar);
                j.as(TAG, "total cache size: " + ((this.cLg.avu() / 1024) / 1024) + "M list size " + this.cLg.avv());
                if (this.cLg.avu() > 629145600) {
                    while (this.cLg.avu() > 524288000 && this.cLg.avv() > 2 && avx()) {
                    }
                    avz();
                }
                if (m.avP() < 314572800) {
                    while (m.avP() < 419430400 && this.cLg.avv() > 2 && avx()) {
                    }
                    avz();
                }
                j.as(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean avx() {
        d ln = this.cLg.ln(0);
        if (ln == null || !(e.avE().qp(ln.getFileName()) || e.avE().qr(ln.getFileName()))) {
            this.cLg.remove(0);
            if (ln != null) {
                File file = new File(i.cLR + ln.getFileName());
                j.as(TAG, "delete file " + file.getName());
                m.O(file);
            }
            return true;
        }
        return false;
    }

    private void l(String str, long j) {
        File file = new File(i.cLR + str);
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
            TiebaStatic.log(new am("c12028").bJ("errormsg", "修改缓存文件的Access时间出现异常").bJ("error", e.getMessage()).bJ("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void avy() {
        if (this.cLg != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.cLg.avv() - 2; i++) {
                d ln = this.cLg.ln(i);
                if (ln != null) {
                    if (currentTimeMillis - ln.avC() < 86400000) {
                        break;
                    }
                    arrayList.add(ln);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.avE().qp(dVar.getFileName()) && !e.avE().qr(dVar.getFileName()))) {
                    this.cLg.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.cLR + dVar.getFileName());
                        j.as(TAG, "delete expired file " + dVar.getFileName());
                        m.O(file);
                    }
                }
            }
            avz();
        }
    }

    private void qn(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.cLR + str + "/completed");
                    File file2 = new File(i.cLR + str + "/segments");
                    if (file.exists()) {
                        j.as(TAG, "delete segments");
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
        if (this.cLg != null) {
            while (this.cLg.avv() > 0 && avx()) {
            }
            avz();
        }
    }

    private void avz() {
        File[] listFiles;
        File file = new File(i.cLQ);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.O(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.O(file2);
                    }
                }
            }
        }
    }
}
