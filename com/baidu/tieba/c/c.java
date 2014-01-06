package com.baidu.tieba.c;

import com.baidu.tieba.data.emotions.EmotionGroupData;
import com.baidu.tieba.data.emotions.l;
import com.baidu.tieba.util.bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class c implements f {
    @Override // com.baidu.tieba.c.f
    public void a(String str, String str2) {
        l.a().b();
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.c.f
    public void a(String str, String str2, int i, String str3) {
        if (i != 3) {
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=5, 86=4, 87=4, 88=4] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.c.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(a aVar) {
        FileInputStream fileInputStream;
        if (aVar == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(aVar.e());
            try {
                try {
                    int a = com.baidu.tieba.data.emotions.j.a().a(aVar.a(), fileInputStream);
                    EmotionGroupData a2 = com.baidu.tieba.data.emotions.j.a().a(aVar.a());
                    if (a2 == null) {
                        if (a == 0) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return false;
                                } catch (IOException e) {
                                    bo.c("download:after load::error:" + e.getMessage());
                                    return false;
                                }
                            }
                            return false;
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
                        com.baidu.tieba.data.emotions.j.a().a(a2);
                    }
                    com.baidu.tieba.data.emotions.j.a().a(aVar.n(), a2);
                    aVar.d((String) null);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            bo.c("download:after load::error:" + e2.getMessage());
                        }
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    bo.c("download:after load::error:" + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (IOException e4) {
                            bo.c("download:after load::error:" + e4.getMessage());
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
                        bo.c("download:after load::error:" + e5.getMessage());
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

    @Override // com.baidu.tieba.c.f
    public void b(a aVar) {
        if (aVar != null) {
            d.a().a(aVar);
        }
    }

    @Override // com.baidu.tieba.c.f
    public boolean c(a aVar) {
        if (aVar == null) {
            return false;
        }
        EmotionGroupData a = com.baidu.tieba.data.emotions.j.a().a(aVar.a());
        if (a != null && com.baidu.tieba.data.emotions.d.a(aVar.a())) {
            com.baidu.tieba.data.emotions.j.a().a(aVar.n(), a);
            aVar.d((String) null);
            return false;
        }
        return true;
    }
}
