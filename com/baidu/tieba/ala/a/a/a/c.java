package com.baidu.tieba.ala.a.a.a;

import android.content.Context;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes3.dex */
public class c implements a {
    @Override // com.baidu.tieba.ala.a.a.a.a
    public void i(Context context, File file) {
        Object fieldValue = com.baidu.tieba.ala.a.a.b.b.getFieldValue(context.getClassLoader(), "pathList");
        Class bvy = bvy();
        if (bvy != null) {
            Object[] objArr = (Object[]) com.baidu.tieba.ala.a.a.b.b.getFieldValue(fieldValue, "nativeLibraryPathElements");
            Object a = a(bvy, file);
            if (objArr != null && a != null) {
                com.baidu.tieba.ala.a.a.b.b.a(fieldValue, "nativeLibraryPathElements", com.baidu.tieba.ala.a.a.b.a.a(bvy, objArr, a));
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.a.a.a
    public boolean j(Context context, File file) {
        Object fieldValue = com.baidu.tieba.ala.a.a.b.b.getFieldValue(context.getClassLoader(), "pathList");
        if (bvy() != null) {
            for (Object obj : (Object[]) com.baidu.tieba.ala.a.a.b.b.getFieldValue(fieldValue, "nativeLibraryPathElements")) {
                if (obj.toString().contains(file.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected Class bvy() {
        try {
            return Class.forName("dalvik.system.DexPathList$Element");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Object a(Class cls, File file) {
        return com.baidu.tieba.ala.a.a.b.b.a(cls, new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, true, null, null});
    }
}
