package com.baidu.tieba.ala.b.a.a;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.io.File;
/* loaded from: classes10.dex */
public class e implements a {
    @Override // com.baidu.tieba.ala.b.a.a.a
    public void j(Context context, File file) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        String[] strArr = (String[]) com.baidu.tieba.ala.b.a.b.b.getFieldValue(pathClassLoader, "mLibPaths");
        if (strArr != null) {
            com.baidu.tieba.ala.b.a.b.b.b(pathClassLoader, "mLibPaths", com.baidu.tieba.ala.b.a.b.a.b(String.class, strArr, file.getAbsolutePath()));
        }
    }

    @Override // com.baidu.tieba.ala.b.a.a.a
    public boolean k(Context context, File file) {
        return com.baidu.tieba.ala.b.a.b.a.c((String[]) com.baidu.tieba.ala.b.a.b.b.getFieldValue((PathClassLoader) context.getClassLoader(), "mLibPaths"), file.getAbsolutePath());
    }
}
