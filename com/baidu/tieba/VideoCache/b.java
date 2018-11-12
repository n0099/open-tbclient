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
    private a bvM = new a();

    public b() {
        TV();
    }

    private void TV() {
        File[] listFiles;
        File file = new File(i.bww);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.iU(file2.getName());
                    dVar.aJ(iR(file2.getAbsolutePath()));
                    dVar.aK(m.je(file2.getName()));
                    this.bvM.a(dVar);
                }
            }
            Collections.sort(this.bvM.TS(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long iR(String str) {
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
                        TiebaStatic.log(new am("c12028").ax("errormsg", "获取缓存文件的Access时间出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).ax("name", file.getAbsolutePath()));
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

    public void iS(String str) {
        d dVar;
        String jg = m.jg(str);
        if (jg != null && !jg.isEmpty()) {
            iT(jg);
            if (this.bvM != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bvM.TU()) {
                        dVar = null;
                        break;
                    }
                    d hj = this.bvM.hj((this.bvM.TU() - 1) - i);
                    if (hj != null && hj.getFileName() != null && hj.getFileName().equals(jg)) {
                        dVar = hj;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bvM.b(dVar);
                } else {
                    dVar = new d();
                    dVar.iU(jg);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                i(jg, currentTimeMillis2);
                dVar.aJ(currentTimeMillis2);
                dVar.aK(m.je(jg));
                this.bvM.a(dVar);
                j.log(TAG, "total cache size: " + ((this.bvM.TT() / 1024) / 1024) + "M list size " + this.bvM.TU());
                if (this.bvM.TT() > 629145600) {
                    while (this.bvM.TT() > 524288000 && this.bvM.TU() > 2 && TW()) {
                    }
                    TY();
                }
                if (m.Uo() < 314572800) {
                    while (m.Uo() < 419430400 && this.bvM.TU() > 2 && TW()) {
                    }
                    TY();
                }
                j.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean TW() {
        d hj = this.bvM.hj(0);
        if (hj == null || !(e.Ud().iV(hj.getFileName()) || e.Ud().iX(hj.getFileName()))) {
            this.bvM.remove(0);
            if (hj != null) {
                File file = new File(i.bwx + hj.getFileName());
                j.log(TAG, "delete file " + file.getName());
                m.E(file);
            }
            return true;
        }
        return false;
    }

    private void i(String str, long j) {
        File file = new File(i.bwx + str);
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
            TiebaStatic.log(new am("c12028").ax("errormsg", "修改缓存文件的Access时间出现异常").ax(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, e.getMessage()).ax("name", file2.getAbsolutePath()));
            e.printStackTrace();
        }
    }

    public void TX() {
        if (this.bvM != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bvM.TU() - 2; i++) {
                d hj = this.bvM.hj(i);
                if (hj != null) {
                    if (currentTimeMillis - hj.Ub() < 86400000) {
                        break;
                    }
                    arrayList.add(hj);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.Ud().iV(dVar.getFileName()) && !e.Ud().iX(dVar.getFileName()))) {
                    this.bvM.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bwx + dVar.getFileName());
                        j.log(TAG, "delete expired file " + dVar.getFileName());
                        m.E(file);
                    }
                }
            }
            TY();
        }
    }

    private void iT(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bwx + str + "/completed");
                    File file2 = new File(i.bwx + str + "/segments");
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
        if (this.bvM != null) {
            while (this.bvM.TU() > 0 && TW()) {
            }
            TY();
        }
    }

    private void TY() {
        File[] listFiles;
        File file = new File(i.bww);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (!file2.isDirectory()) {
                        m.E(file2);
                    } else if (!new File(file2.getAbsolutePath() + "/accesstime").exists()) {
                        m.E(file2);
                    }
                }
            }
        }
    }
}
