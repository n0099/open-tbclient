package com.baidu.tieba.ala.b.a.a;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b implements a {
    @Override // com.baidu.tieba.ala.b.a.a.a
    public void i(Context context, File file) {
        Object fieldValue = com.baidu.tieba.ala.b.a.b.b.getFieldValue(context.getClassLoader(), "pathList");
        Object fieldValue2 = com.baidu.tieba.ala.b.a.b.b.getFieldValue(fieldValue, "nativeLibraryDirectories");
        if (fieldValue2 instanceof File[]) {
            com.baidu.tieba.ala.b.a.b.b.b(fieldValue, "nativeLibraryDirectories", com.baidu.tieba.ala.b.a.b.a.b(File.class, (File[]) fieldValue2, file));
        } else {
            ((ArrayList) fieldValue2).add(file);
        }
    }

    @Override // com.baidu.tieba.ala.b.a.a.a
    public boolean j(Context context, File file) {
        Object fieldValue = com.baidu.tieba.ala.b.a.b.b.getFieldValue(com.baidu.tieba.ala.b.a.b.b.getFieldValue(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
        if (fieldValue instanceof File[]) {
            return com.baidu.tieba.ala.b.a.b.a.c((File[]) fieldValue, file);
        }
        return ((ArrayList) fieldValue).contains(file);
    }
}
