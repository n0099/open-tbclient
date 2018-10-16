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
    private a bvb = new a();

    public b() {
        TM();
    }

    private void TM() {
        File[] listFiles;
        File file = new File(i.bvL);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    d dVar = new d();
                    dVar.iS(file2.getName());
                    dVar.aH(iP(file2.getAbsolutePath()));
                    dVar.aI(m.jc(file2.getName()));
                    this.bvb.a(dVar);
                }
            }
            Collections.sort(this.bvb.TJ(), new AccessTimeComparator());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long iP(String str) {
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

    public void iQ(String str) {
        d dVar;
        String je = m.je(str);
        if (je != null && !je.isEmpty()) {
            iR(je);
            if (this.bvb != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (i >= this.bvb.TL()) {
                        dVar = null;
                        break;
                    }
                    d gW = this.bvb.gW((this.bvb.TL() - 1) - i);
                    if (gW != null && gW.getFileName() != null && gW.getFileName().equals(je)) {
                        dVar = gW;
                        break;
                    }
                    i++;
                }
                if (dVar != null) {
                    this.bvb.b(dVar);
                } else {
                    dVar = new d();
                    dVar.iS(je);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                i(je, currentTimeMillis2);
                dVar.aH(currentTimeMillis2);
                dVar.aI(m.jc(je));
                this.bvb.a(dVar);
                j.log(TAG, "total cache size: " + ((this.bvb.TK() / 1024) / 1024) + "M list size " + this.bvb.TL());
                if (this.bvb.TK() > 629145600) {
                    while (this.bvb.TK() > 524288000 && this.bvb.TL() > 2 && TN()) {
                    }
                    TP();
                }
                if (m.Uf() < 314572800) {
                    while (m.Uf() < 419430400 && this.bvb.TL() > 2 && TN()) {
                    }
                    TP();
                }
                j.log(TAG, "adjust coast time " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private boolean TN() {
        d gW = this.bvb.gW(0);
        if (gW == null || !(e.TU().iT(gW.getFileName()) || e.TU().iV(gW.getFileName()))) {
            this.bvb.remove(0);
            if (gW != null) {
                File file = new File(i.bvM + gW.getFileName());
                j.log(TAG, "delete file " + file.getName());
                m.E(file);
            }
            return true;
        }
        return false;
    }

    private void i(String str, long j) {
        File file = new File(i.bvM + str);
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

    public void TO() {
        if (this.bvb != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.bvb.TL() - 2; i++) {
                d gW = this.bvb.gW(i);
                if (gW != null) {
                    if (currentTimeMillis - gW.TS() < 86400000) {
                        break;
                    }
                    arrayList.add(gW);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = (d) arrayList.get(i2);
                if (dVar == null || (!e.TU().iT(dVar.getFileName()) && !e.TU().iV(dVar.getFileName()))) {
                    this.bvb.b(dVar);
                    if (dVar != null) {
                        File file = new File(i.bvM + dVar.getFileName());
                        j.log(TAG, "delete expired file " + dVar.getFileName());
                        m.E(file);
                    }
                }
            }
            TP();
        }
    }

    private void iR(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    File file = new File(i.bvM + str + "/completed");
                    File file2 = new File(i.bvM + str + "/segments");
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
        if (this.bvb != null) {
            while (this.bvb.TL() > 0 && TN()) {
            }
            TP();
        }
    }

    private void TP() {
        File[] listFiles;
        File file = new File(i.bvL);
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
