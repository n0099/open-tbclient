package com.baidu.tieba.faceshop;

import com.baidu.tbadk.editortool.EmotionGroupData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class e implements com.baidu.tieba.download.b {
    @Override // com.baidu.tieba.download.b
    public final void d(com.baidu.tieba.download.a aVar) {
        com.baidu.tbadk.editortool.ab.a().b();
        try {
            File file = new File(aVar.e());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.download.b
    public final void a(com.baidu.tieba.download.a aVar, int i) {
        if (i != 3) {
            try {
                File file = new File(aVar.e());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=4, 89=4, 90=4] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.download.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(com.baidu.tieba.download.a aVar) {
        FileInputStream fileInputStream;
        if (aVar == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(aVar.e());
            try {
                try {
                    c.a();
                    int a = c.a(aVar.a(), fileInputStream);
                    EmotionGroupData a2 = com.baidu.tbadk.editortool.v.a().a(aVar.a());
                    if (a2 == null) {
                        if (a == 0) {
                            try {
                                fileInputStream.close();
                                return false;
                            } catch (IOException e) {
                                com.baidu.adp.lib.util.f.e("download:after load::error:" + e.getMessage());
                                return false;
                            }
                        }
                        a2 = new EmotionGroupData();
                        a2.setBytesLength((int) aVar.i());
                        a2.setBytesReceived((int) aVar.h());
                        a2.setDownloadUrl(aVar.d());
                        a2.setGroupId(aVar.a());
                        a2.setEmotionsCount(a);
                        a2.setHeight(aVar.k());
                        a2.setWidth(aVar.j());
                        a2.setDownloadTime(System.currentTimeMillis());
                        a2.setGroupDesc(aVar.c());
                        a2.setGroupName(aVar.b());
                        a2.setStatus(1);
                        com.baidu.tbadk.editortool.v.a();
                        com.baidu.tbadk.editortool.v.a(a2);
                    }
                    com.baidu.tbadk.editortool.v.a();
                    com.baidu.tbadk.editortool.v.a(aVar.n(), a2);
                    aVar.e((String) null);
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        com.baidu.adp.lib.util.f.e("download:after load::error:" + e2.getMessage());
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.util.f.e("download:after load::error:" + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (IOException e4) {
                            com.baidu.adp.lib.util.f.e("download:after load::error:" + e4.getMessage());
                            return false;
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        com.baidu.adp.lib.util.f.e("download:after load::error:" + e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    @Override // com.baidu.tieba.download.b
    public final void a(com.baidu.tieba.download.a aVar) {
        if (aVar != null) {
            f.a();
            f.a(aVar);
        }
    }

    @Override // com.baidu.tieba.download.b
    public final boolean b(com.baidu.tieba.download.a aVar) {
        if (aVar == null) {
            return false;
        }
        EmotionGroupData a = com.baidu.tbadk.editortool.v.a().a(aVar.a());
        if (a != null && d.a(aVar.a())) {
            com.baidu.tbadk.editortool.v.a();
            com.baidu.tbadk.editortool.v.a(aVar.n(), a);
            aVar.e((String) null);
            return false;
        }
        return true;
    }
}
