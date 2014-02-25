package com.baidu.tieba.d;

import com.baidu.tieba.data.emotions.EmotionGroupData;
import com.baidu.tieba.data.emotions.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class c implements f {
    @Override // com.baidu.tieba.d.f
    public void a(a aVar) {
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
    public void a(a aVar, int i, String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=4, 86=4, 87=4, 88=4] */
    @Override // com.baidu.tieba.d.f
    public boolean b(a aVar) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            if (aVar == null) {
                return false;
            }
            try {
                fileInputStream = new FileInputStream(aVar.e());
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
                                    com.baidu.adp.lib.util.f.e("download:after load::error:" + e.getMessage());
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
                    aVar.e((String) null);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            com.baidu.adp.lib.util.f.e("download:after load::error:" + e2.getMessage());
                        }
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
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        com.baidu.adp.lib.util.f.e("download:after load::error:" + e6.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tieba.d.f
    public void c(a aVar) {
        if (aVar != null) {
            d.a().a(aVar);
        }
    }

    @Override // com.baidu.tieba.d.f
    public boolean d(a aVar) {
        if (aVar == null) {
            return false;
        }
        EmotionGroupData a = com.baidu.tieba.data.emotions.j.a().a(aVar.a());
        if (a != null && com.baidu.tieba.data.emotions.d.a(aVar.a())) {
            com.baidu.tieba.data.emotions.j.a().a(aVar.n(), a);
            aVar.e((String) null);
            return false;
        }
        return true;
    }
}
