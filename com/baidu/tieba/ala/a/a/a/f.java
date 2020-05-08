package com.baidu.tieba.ala.a.a.a;

import android.content.Context;
import android.os.Build;
import java.io.File;
/* loaded from: classes3.dex */
public class f {
    public static void g(Context context, File file) {
        bnd().g(context, file);
    }

    public static boolean h(Context context, File file) {
        return bnd().h(context, file);
    }

    private static a bnd() {
        if (Build.VERSION.SDK_INT >= 26) {
            return new d();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new c();
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new b();
        }
        return new e();
    }
}
