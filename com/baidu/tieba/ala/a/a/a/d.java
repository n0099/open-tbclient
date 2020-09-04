package com.baidu.tieba.ala.a.a.a;

import java.io.File;
/* loaded from: classes4.dex */
public class d extends c {
    @Override // com.baidu.tieba.ala.a.a.a.c
    protected Class bHL() {
        try {
            return Class.forName("dalvik.system.DexPathList$NativeLibraryElement");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.tieba.ala.a.a.a.c
    protected Object a(Class cls, File file) {
        return com.baidu.tieba.ala.a.a.b.b.a(cls, new Class[]{File.class}, new Object[]{file});
    }
}
