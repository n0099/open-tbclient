package com.baidu.tieba.ala.b.a.a;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.io.File;
/* loaded from: classes4.dex */
public class e implements a {
    @Override // com.baidu.tieba.ala.b.a.a.a
    public void i(Context context, File file) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        String[] strArr = (String[]) com.baidu.tieba.ala.b.a.b.b.getFieldValue(pathClassLoader, "mLibPaths");
        if (strArr != null) {
            com.baidu.tieba.ala.b.a.b.b.a(pathClassLoader, "mLibPaths", com.baidu.tieba.ala.b.a.b.a.a(String.class, strArr, file.getAbsolutePath()));
        }
    }

    @Override // com.baidu.tieba.ala.b.a.a.a
    public boolean j(Context context, File file) {
        return com.baidu.tieba.ala.b.a.b.a.a((String[]) com.baidu.tieba.ala.b.a.b.b.getFieldValue((PathClassLoader) context.getClassLoader(), "mLibPaths"), file.getAbsolutePath());
    }
}
