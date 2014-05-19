package com.baidu.tieba.faceshop;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.lib.e.f {
    @Override // com.baidu.adp.lib.e.f
    public Object a(String str, com.baidu.adp.lib.e.e eVar) {
        com.baidu.tbadk.core.util.e eVar2;
        if (eVar != null && (eVar2 = (com.baidu.tbadk.core.util.e) eVar.a("ImageAsyncTaskInfo")) != null) {
            com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
            if (c != null) {
                eVar2.i = c;
            }
            return c;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.f
    public Object a(String str, com.baidu.adp.lib.e.d dVar) {
        com.baidu.adp.widget.a.a a;
        com.baidu.adp.lib.e.e a2 = dVar.a();
        if (a2 != null && ((com.baidu.tbadk.editortool.ab) a2.a("AsyncImageLoader")) != null) {
            com.baidu.tbadk.core.util.e eVar = (com.baidu.tbadk.core.util.e) a2.a("ImageAsyncTaskInfo");
            String str2 = (String) a2.a("em_group_id");
            String str3 = (String) a2.a("em_sharp_text");
            Boolean bool = (Boolean) a2.a("em_load_gif");
            if (eVar == null || str3 == null || bool == null) {
                return null;
            }
            if (eVar.n) {
                return null;
            }
            if (bool.booleanValue()) {
                a = com.baidu.tbadk.editortool.ac.a().b(str2, str3);
            } else {
                a = com.baidu.tbadk.editortool.ac.a().a(str2, str3);
            }
            eVar.i = a;
            return a;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.f
    public Object b(String str, com.baidu.adp.lib.e.d dVar) {
        com.baidu.adp.lib.e.e a = dVar.a();
        if (a == null || ((com.baidu.tbadk.editortool.ab) a.a("AsyncImageLoader")) == null) {
            return null;
        }
        com.baidu.tbadk.core.util.e eVar = (com.baidu.tbadk.core.util.e) a.a("ImageAsyncTaskInfo");
        String str2 = (String) a.a("em_group_id");
        String str3 = (String) a.a("em_sharp_text");
        Boolean bool = (Boolean) a.a("em_load_gif");
        String str4 = (String) a.a("em_img_url");
        if (str2 == null || eVar == null || str3 == null || bool == null || str4 == null || eVar.n) {
            return null;
        }
        eVar.a = new com.baidu.tbadk.core.util.a.e();
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a2 = eVar.a.a(str4, false);
        if (a2 == null || !eVar.a.b()) {
            if (!eVar.n) {
                com.baidu.tbadk.core.log.a.b(com.baidu.tbadk.core.log.k.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(eVar.a.g), String.valueOf(eVar.a.h) + ":" + eVar.a.e, "IS_CDN=true|download error"));
            }
            return null;
        } else if (eVar.n) {
            return null;
        } else {
            synchronized (com.baidu.tbadk.core.util.g.a) {
                if (eVar.n) {
                    return null;
                }
                if (bool.booleanValue()) {
                    String a3 = e.a(str3, bool.booleanValue());
                    String a4 = com.baidu.tbadk.editortool.ac.a().a(str3, bool.booleanValue());
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a2);
                    if (e.a(str2, a3, byteArrayInputStream)) {
                        e.a(str2, a3, a4);
                    }
                    com.baidu.tbadk.core.util.m.a((InputStream) byteArrayInputStream);
                    eVar.i = com.baidu.tbadk.editortool.ac.a().b(str2, str3);
                    if (eVar.i == null) {
                        if (!eVar.n) {
                            com.baidu.tbadk.core.log.a.b(com.baidu.tbadk.core.log.k.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(eVar.a.g), String.valueOf(eVar.a.h) + ":" + eVar.a.e, "IS_CDN=true|gif decode error"));
                        }
                        return null;
                    }
                } else {
                    com.baidu.tbadk.imageManager.e.a().c(80000);
                    eVar.e = com.baidu.tbadk.core.util.g.a(a2);
                    if (eVar.e == null) {
                        if (!eVar.n) {
                            com.baidu.tbadk.core.log.a.b(com.baidu.tbadk.core.log.k.a(str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(eVar.a.g), String.valueOf(eVar.a.h) + ":" + eVar.a.e, "IS_CDN=true|decode error"));
                        }
                        return null;
                    } else if (eVar.n) {
                        return null;
                    } else {
                        eVar.i = new com.baidu.adp.widget.a.a(eVar.e, eVar.h, str4);
                        com.baidu.tbadk.editortool.ac.a().a(str3, eVar.i, false);
                    }
                }
                if (eVar.n) {
                    return null;
                }
                dVar.a(eVar);
                if (eVar.n) {
                    return null;
                }
                if (!bool.booleanValue()) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(a2);
                    try {
                        e.a(str2, com.baidu.tbadk.editortool.ac.a().a(str3, bool.booleanValue()), byteArrayInputStream2);
                        com.baidu.tbadk.core.util.m.a((InputStream) byteArrayInputStream2);
                    } catch (Throwable th) {
                        com.baidu.tbadk.core.util.m.a((InputStream) byteArrayInputStream2);
                    }
                }
                return eVar.i;
            }
        }
    }
}
