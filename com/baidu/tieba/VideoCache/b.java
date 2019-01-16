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
    private a bzZ = new a();

    public b() {
        Vz();
    }

    private void Vz() {
        File[] listFiles;
        File file = new File(i.bAJ);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.jD(file2.getName());
                    dVar.aR(jA(file2.getAbsolutePath()));
                    dVar.aS(m.jN(file2.getName()));
                    this.bzZ.a(dVar);
                }
            }
            Collections.sort(this.bzZ.Vw(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long jA(String str) {
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
                        TiebaStatic.log(new am("c12028").aB("errormsg", "获取缓存文件的Access时间出现异常").aB(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).aB("name", file.getAbsolutePath()));
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

    public void jB(String str) {
        d dVar;
        String jP = m.jP(str);
        if (jP != null && !jP.isEmpty()) {
            jC(jP);
            if (this.bzZ != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bzZ.Vy()) {
                        dVar = null;
                        break;
                    }
                    d hy = this.bzZ.hy((this.bzZ.Vy() - 1) - i);
                    if (hy != null && hy.getFileName() != null && hy.getFileName().equals(jP)) {
                        dVar = hy;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bzZ.b(dVar);
                } else {
                    dVar = new d();
                    dVar.jD(jP);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                j(jP, currentTimeMillis2);
                dVar.aR(currentTimeMillis2);
                dVar.aS(m.jN(jP));
                this.bzZ.a(dVar);
                j.log(TAG, "total cache size: " + ((this.bzZ.Vx() / 1024) / 1024) + "M list size " + this.bzZ.Vy());
                if (this.bzZ.Vx() > 629145600) {
                    while (this.bzZ.Vx() > 524288000 && this.bzZ.Vy() > 2 && VA()) {
                    }
                    VC();
                }
                if (m.VS() < 314572800) {
                    while (m.VS() < 419430400 && this.bzZ.Vy() > 2 && VA()) {
                    }
                    VC();
                }
                j.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean VA() {
        d hy = this.bzZ.hy(0);
        if (hy == null || !(e.VH().jE(hy.getFileName()) || e.VH().jG(hy.getFileName()))) {
            this.bzZ.remove(0);
            if (hy != null) {
                File file = new File(i.bAK + hy.getFileName());
                j.log(TAG, "delete file " + file.getName());
                m.G(file);
            }
            return true;
        }
        return false;
    }

    private void j(String str, long j) {
        File file = new File(i.bAK + str);
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
            TiebaStatic.log(new am("c12028").aB("errormsg", "修改缓存文件的Access时间出现异常").aB(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).aB("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void VB() {
        if (this.bzZ != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bzZ.Vy() - 2; i++) {
                d hy = this.bzZ.hy(i);
                if (hy != null) {
                    if (currentTimeMillis - hy.VF() < 86400000) {
                        break;
                    }
                    arrayList.add(hy);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.VH().jE(dVar.getFileName()) && !e.VH().jG(dVar.getFileName()))) {
                    this.bzZ.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bAK + dVar.getFileName());
                        j.log(TAG, "delete expired file " + dVar.getFileName());
                        m.G(file);
                    }
                }
            }
            VC();
        }
    }

    private void jC(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bAK + str + "/completed");
                    File file2 = new File(i.bAK + str + "/segments");
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
        if (this.bzZ != null) {
            while (this.bzZ.Vy() > 0 && VA()) {
            }
            VC();
        }
    }

    private void VC() {
        File[] listFiles;
        File file = new File(i.bAJ);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.G(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.G(file2);
                    }
                }
            }
        }
    }
}
