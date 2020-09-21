package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private static List<String> fwJ = null;

    @TargetApi(23)
    public static void eJ(Context context) {
        if (!eK(context)) {
            eL(context);
            ((Activity) context).requestPermissions((String[]) fwJ.toArray(new String[fwJ.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean eK(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void eL(Context context) {
        if (fwJ == null) {
            fwJ = new ArrayList();
        } else {
            fwJ.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            fwJ.add("android.permission.WRITE_EXTERNAL_STORAGE");
            fwJ.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!eK(context)) {
                eJ(context);
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
