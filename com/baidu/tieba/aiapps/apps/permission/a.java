package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static List<String> gmA = null;

    @TargetApi(23)
    public static void fN(Context context) {
        if (!fO(context)) {
            fP(context);
            ((Activity) context).requestPermissions((String[]) gmA.toArray(new String[gmA.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean fO(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void fP(Context context) {
        if (gmA == null) {
            gmA = new ArrayList();
        } else {
            gmA.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            gmA.add("android.permission.WRITE_EXTERNAL_STORAGE");
            gmA.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!fO(context)) {
                fN(context);
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
