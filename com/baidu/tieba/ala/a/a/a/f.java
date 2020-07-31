package com.baidu.tieba.ala.a.a.a;

import android.content.Context;
import android.os.Build;
import java.io.File;
/* loaded from: classes4.dex */
public class f {
    public static void i(Context context, File file) {
        byI().i(context, file);
    }

    public static boolean j(Context context, File file) {
        return byI().j(context, file);
    }

    private static a byI() {
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
