package com.baidu.tieba.ala.b.a.a;

import java.io.File;
/* loaded from: classes4.dex */
public class d extends c {
    @Override // com.baidu.tieba.ala.b.a.a.c
    protected Class bOf() {
        try {
            return Class.forName("dalvik.system.DexPathList$NativeLibraryElement");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.tieba.ala.b.a.a.c
    protected Object b(Class cls, File file) {
        return com.baidu.tieba.ala.b.a.b.b.b(cls, new Class[]{File.class}, new Object[]{file});
    }
}
