package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    private static List<String> geX = null;

    @TargetApi(23)
    public static void fw(Context context) {
        if (!fx(context)) {
            fy(context);
            ((Activity) context).requestPermissions((String[]) geX.toArray(new String[geX.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean fx(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void fy(Context context) {
        if (geX == null) {
            geX = new ArrayList();
        } else {
            geX.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            geX.add("android.permission.WRITE_EXTERNAL_STORAGE");
            geX.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!fx(context)) {
                fw(context);
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
