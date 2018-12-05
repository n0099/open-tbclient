package com.baidu.tieba.VideoCache;

import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
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
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private a bzj = new a();

    public b() {
        Vb();
    }

    private void Vb() {
        File[] listFiles;
        File file = new File(i.bzT);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.jm(file2.getName());
                    dVar.aQ(jj(file2.getAbsolutePath()));
                    dVar.aR(m.jw(file2.getName()));
                    this.bzj.a(dVar);
                }
            }
            Collections.sort(this.bzj.UY(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long jj(String str) {
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
                        TiebaStatic.log(new am("c12028").aA("errormsg", "获取缓存文件的Access时间出现异常").aA(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).aA("name", file.getAbsolutePath()));
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

    public void jk(String str) {
        d dVar;
        String jy = m.jy(str);
        if (jy != null && !jy.isEmpty()) {
            jl(jy);
            if (this.bzj != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bzj.Va()) {
                        dVar = null;
                        break;
                    }
                    d hx = this.bzj.hx((this.bzj.Va() - 1) - i);
                    if (hx != null && hx.getFileName() != null && hx.getFileName().equals(jy)) {
                        dVar = hx;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bzj.b(dVar);
                } else {
                    dVar = new d();
                    dVar.jm(jy);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                j(jy, currentTimeMillis2);
                dVar.aQ(currentTimeMillis2);
                dVar.aR(m.jw(jy));
                this.bzj.a(dVar);
                j.log(TAG, "total cache size: " + ((this.bzj.UZ() / 1024) / 1024) + "M list size " + this.bzj.Va());
                if (this.bzj.UZ() > 629145600) {
                    while (this.bzj.UZ() > 524288000 && this.bzj.Va() > 2 && Vc()) {
                    }
                    Ve();
                }
                if (m.Vu() < 314572800) {
                    while (m.Vu() < 419430400 && this.bzj.Va() > 2 && Vc()) {
                    }
                    Ve();
                }
                j.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean Vc() {
        d hx = this.bzj.hx(0);
        if (hx == null || !(e.Vj().jn(hx.getFileName()) || e.Vj().jp(hx.getFileName()))) {
            this.bzj.remove(0);
            if (hx != null) {
                File file = new File(i.bzU + hx.getFileName());
                j.log(TAG, "delete file " + file.getName());
                m.F(file);
            }
            return true;
        }
        return false;
    }

    private void j(String str, long j) {
        File file = new File(i.bzU + str);
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
            TiebaStatic.log(new am("c12028").aA("errormsg", "修改缓存文件的Access时间出现异常").aA(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).aA("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void Vd() {
        if (this.bzj != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bzj.Va() - 2; i++) {
                d hx = this.bzj.hx(i);
                if (hx != null) {
                    if (currentTimeMillis - hx.Vh() < 86400000) {
                        break;
                    }
                    arrayList.add(hx);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Vj().jn(dVar.getFileName()) && !e.Vj().jp(dVar.getFileName()))) {
                    this.bzj.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bzU + dVar.getFileName());
                        j.log(TAG, "delete expired file " + dVar.getFileName());
                        m.F(file);
                    }
                }
            }
            Ve();
        }
    }

    private void jl(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bzU + str + "/completed");
                    File file2 = new File(i.bzU + str + "/segments");
                    if (file.exists()) {
                        j.log(TAG, "delete segments");
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
        if (this.bzj != null) {
            while (this.bzj.Va() > 0 && Vc()) {
            }
            Ve();
        }
    }

    private void Ve() {
        File[] listFiles;
        File file = new File(i.bzT);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.F(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.F(file2);
                    }
                }
            }
        }
    }
}
