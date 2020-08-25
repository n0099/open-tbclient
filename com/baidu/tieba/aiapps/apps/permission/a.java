package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class a {
    private static List<String> ftu = null;

    @TargetApi(23)
    public static void eD(Context context) {
        if (!eE(context)) {
            eF(context);
            ((Activity) context).requestPermissions((String[]) ftu.toArray(new String[ftu.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean eE(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void eF(Context context) {
        if (ftu == null) {
            ftu = new ArrayList();
        } else {
            ftu.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ftu.add("android.permission.WRITE_EXTERNAL_STORAGE");
            ftu.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!eE(context)) {
                eD(context);
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
