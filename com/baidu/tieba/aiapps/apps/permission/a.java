package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a {
    private static List<String> fdp = null;

    @TargetApi(23)
    public static void eq(Context context) {
        if (!er(context)) {
            es(context);
            ((Activity) context).requestPermissions((String[]) fdp.toArray(new String[fdp.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean er(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void es(Context context) {
        if (fdp == null) {
            fdp = new ArrayList();
        } else {
            fdp.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            fdp.add("android.permission.WRITE_EXTERNAL_STORAGE");
            fdp.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!er(context)) {
                eq(context);
                return true;
            } else if (context instanceof PermissionActivity) {
                ((Activity) context).finish();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
