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
    private a cTs = new a();

    public b() {
        aAF();
    }

    private void aAF() {
        File[] listFiles;
        File file = new File(i.cUc);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.rx(file2.getName());
                    dVar.bI(ru(file2.getAbsolutePath()));
                    dVar.bJ(m.rH(file2.getName()));
                    this.cTs.a(dVar);
                }
            }
            Collections.sort(this.cTs.aAC(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long ru(String str) {
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
                        TiebaStatic.log(new am("c12028").bT("errormsg", "获取缓存文件的Access时间出现异常").bT("error", e.getMessage()).bT("name", file.getAbsolutePath()));
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

    public void rv(String str) {
        d dVar;
        String rJ = m.rJ(str);
        if (rJ != null && !rJ.isEmpty()) {
            rw(rJ);
            if (this.cTs != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.cTs.aAE()) {
                        dVar = null;
                        break;
                    }
                    d mc = this.cTs.mc((this.cTs.aAE() - 1) - i);
                    if (mc != null && mc.getFileName() != null && mc.getFileName().equals(rJ)) {
                        dVar = mc;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.cTs.b(dVar);
                } else {
                    dVar = new d();
                    dVar.rx(rJ);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                m(rJ, currentTimeMillis2);
                dVar.bI(currentTimeMillis2);
                dVar.bJ(m.rH(rJ));
                this.cTs.a(dVar);
                j.am(TAG, "total cache size: " + ((this.cTs.aAD() / 1024) / 1024) + "M list size " + this.cTs.aAE());
                if (this.cTs.aAD() > 629145600) {
                    while (this.cTs.aAD() > 524288000 && this.cTs.aAE() > 2 && aAG()) {
                    }
                    aAI();
                }
                if (m.aAY() < 314572800) {
                    while (m.aAY() < 419430400 && this.cTs.aAE() > 2 && aAG()) {
                    }
                    aAI();
                }
                j.am(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean aAG() {
        d mc = this.cTs.mc(0);
        if (mc == null || !(e.aAN().ry(mc.getFileName()) || e.aAN().rA(mc.getFileName()))) {
            this.cTs.remove(0);
            if (mc != null) {
                File file = new File(i.cUd + mc.getFileName());
                j.am(TAG, "delete file " + file.getName());
                m.I(file);
            }
            return true;
        }
        return false;
    }

    private void m(String str, long j) {
        File file = new File(i.cUd + str);
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
            TiebaStatic.log(new am("c12028").bT("errormsg", "修改缓存文件的Access时间出现异常").bT("error", e.getMessage()).bT("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void aAH() {
        if (this.cTs != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.cTs.aAE() - 2; i++) {
                d mc = this.cTs.mc(i);
                if (mc != null) {
                    if (currentTimeMillis - mc.aAL() < 86400000) {
                        break;
                    }
                    arrayList.add(mc);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.aAN().ry(dVar.getFileName()) && !e.aAN().rA(dVar.getFileName()))) {
                    this.cTs.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.cUd + dVar.getFileName());
                        j.am(TAG, "delete expired file " + dVar.getFileName());
                        m.I(file);
                    }
                }
            }
            aAI();
        }
    }

    private void rw(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.cUd + str + "/completed");
                    File file2 = new File(i.cUd + str + "/segments");
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
        if (this.cTs != null) {
            while (this.cTs.aAE() > 0 && aAG()) {
            }
            aAI();
        }
    }

    private void aAI() {
        File[] listFiles;
        File file = new File(i.cUc);
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
