package com.baidu.tieba.d;

import com.baidu.tieba.data.emotions.EmotionGroupData;
import com.baidu.tieba.data.emotions.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class c implements f {
    @Override // com.baidu.tieba.d.f
    public final void a(a aVar) {
        l.a().b();
        try {
            File file = new File(aVar.e());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.d.f
    public final void a(a aVar, int i) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=4, 87=4, 88=4] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.d.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(a aVar) {
        FileInputStream fileInputStream;
        if (aVar == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(aVar.e());
            try {
                try {
                    com.baidu.tieba.data.emotions.j.a();
                    int a = com.baidu.tieba.data.emotions.j.a(aVar.a(), fileInputStream);
                    EmotionGroupData a2 = com.baidu.tieba.data.emotions.j.a().a(aVar.a());
                    if (a2 == null) {
                        if (a == 0) {
                            try {
                                fileInputStream.close();
                                return false;
                            } catch (IOException e) {
                                com.baidu.adp.lib.util.e.e("download:after load::error:" + e.getMessage());
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
                        com.baidu.tieba.data.emotions.j.a();
                        com.baidu.tieba.data.emotions.j.a(a2);
                    }
                    com.baidu.tieba.data.emotions.j.a();
                    com.baidu.tieba.data.emotions.j.a(aVar.n(), a2);
                    aVar.e((String) null);
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        com.baidu.adp.lib.util.e.e("download:after load::error:" + e2.getMessage());
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    com.baidu.adp.lib.util.e.e("download:after load::error:" + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (IOException e4) {
                            com.baidu.adp.lib.util.e.e("download:after load::error:" + e4.getMessage());
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
                        com.baidu.adp.lib.util.e.e("download:after load::error:" + e5.getMessage());
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

    @Override // com.baidu.tieba.d.f
    public final void c(a aVar) {
        if (aVar != null) {
            d.a();
            d.a(aVar);
        }
    }

    @Override // com.baidu.tieba.d.f
    public final boolean d(a aVar) {
        if (aVar == null) {
            return false;
        }
        EmotionGroupData a = com.baidu.tieba.data.emotions.j.a().a(aVar.a());
        if (a != null && com.baidu.tieba.data.emotions.d.a(aVar.a())) {
            com.baidu.tieba.data.emotions.j.a();
            com.baidu.tieba.data.emotions.j.a(aVar.n(), a);
            aVar.e((String) null);
            return false;
        }
        return true;
    }
}
