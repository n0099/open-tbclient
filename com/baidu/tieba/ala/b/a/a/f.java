package com.baidu.tieba.ala.b.a.a;

import android.content.Context;
import android.os.Build;
import java.io.File;
/* loaded from: classes9.dex */
public class f {
    public static void j(Context context, File file) {
        bSy().j(context, file);
    }

    public static boolean k(Context context, File file) {
        return bSy().k(context, file);
    }

    private static a bSy() {
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
