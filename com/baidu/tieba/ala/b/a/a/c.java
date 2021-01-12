package com.baidu.tieba.ala.b.a.a;

import android.content.Context;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes9.dex */
public class c implements a {
    @Override // com.baidu.tieba.ala.b.a.a.a
    public void j(Context context, File file) {
        Object fieldValue = com.baidu.tieba.ala.b.a.b.b.getFieldValue(context.getClassLoader(), "pathList");
        Class bSx = bSx();
        if (bSx != null) {
            Object[] objArr = (Object[]) com.baidu.tieba.ala.b.a.b.b.getFieldValue(fieldValue, "nativeLibraryPathElements");
            Object b2 = b(bSx, file);
            if (objArr != null && b2 != null) {
                com.baidu.tieba.ala.b.a.b.b.b(fieldValue, "nativeLibraryPathElements", com.baidu.tieba.ala.b.a.b.a.b(bSx, objArr, b2));
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.a.a.a
    public boolean k(Context context, File file) {
        Object fieldValue = com.baidu.tieba.ala.b.a.b.b.getFieldValue(context.getClassLoader(), "pathList");
        if (bSx() != null) {
            for (Object obj : (Object[]) com.baidu.tieba.ala.b.a.b.b.getFieldValue(fieldValue, "nativeLibraryPathElements")) {
                if (obj.toString().contains(file.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected Class bSx() {
        try {
            return Class.forName("dalvik.system.DexPathList$Element");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Object b(Class cls, File file) {
        return com.baidu.tieba.ala.b.a.b.b.b(cls, new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, true, null, null});
    }
}
