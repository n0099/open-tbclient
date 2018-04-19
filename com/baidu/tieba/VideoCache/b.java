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
    private a baH = new a();

    public b() {
        LW();
    }

    private void LW() {
        File[] listFiles;
        File file = new File(i.bbt);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.hB(file2.getName());
                    dVar.setAccessTime(hy(file2.getAbsolutePath()));
                    dVar.au(m.hL(file2.getName()));
                    this.baH.a(dVar);
                }
            }
            Collections.sort(this.baH.LT(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hy(String str) {
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

    public void hz(String str) {
        d dVar;
        String hN = m.hN(str);
        if (hN != null && !hN.isEmpty()) {
            hA(hN);
            if (this.baH != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.baH.LV()) {
                        dVar = null;
                        break;
                    }
                    d gh = this.baH.gh((this.baH.LV() - 1) - i);
                    if (gh != null && gh.getFileName() != null && gh.getFileName().equals(hN)) {
                        dVar = gh;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.baH.b(dVar);
                } else {
                    dVar = new d();
                    dVar.hB(hN);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                g(hN, currentTimeMillis2);
                dVar.setAccessTime(currentTimeMillis2);
                dVar.au(m.hL(hN));
                this.baH.a(dVar);
                j.au(TAG, "total cache size: " + ((this.baH.LU() / 1024) / 1024) + "M list size " + this.baH.LV());
                if (this.baH.LU() > 629145600) {
                    while (this.baH.LU() > 524288000 && this.baH.LV() > 2 && LX()) {
                    }
                    LZ();
                }
                if (m.Mo() < 314572800) {
                    while (m.Mo() < 419430400 && this.baH.LV() > 2 && LX()) {
                    }
                    LZ();
                }
                j.au(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean LX() {
        d gh = this.baH.gh(0);
        if (gh == null || !(e.Md().hC(gh.getFileName()) || e.Md().hE(gh.getFileName()))) {
            this.baH.remove(0);
            if (gh != null) {
                File file = new File(i.bbu + gh.getFileName());
                j.au(TAG, "delete file " + file.getName());
                m.y(file);
            }
            return true;
        }
        return false;
    }

    private void g(String str, long j) {
        File file = new File(i.bbu + str);
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

    public void LY() {
        if (this.baH != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.baH.LV() - 2; i++) {
                d gh = this.baH.gh(i);
                if (gh != null) {
                    if (currentTimeMillis - gh.getAccessTime() < 86400000) {
                        break;
                    }
                    arrayList.add(gh);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Md().hC(dVar.getFileName()) && !e.Md().hE(dVar.getFileName()))) {
                    this.baH.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bbu + dVar.getFileName());
                        j.au(TAG, "delete expired file " + dVar.getFileName());
                        m.y(file);
                    }
                }
            }
            LZ();
        }
    }

    private void hA(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bbu + str + "/completed");
                    File file2 = new File(i.bbu + str + "/segments");
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
        if (this.baH != null) {
            while (this.baH.LV() > 0 && LX()) {
            }
            LZ();
        }
    }

    private void LZ() {
        File[] listFiles;
        File file = new File(i.bbt);
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
