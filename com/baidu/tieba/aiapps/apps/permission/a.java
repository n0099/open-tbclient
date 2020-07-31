package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class a {
    private static List<String> fhW = null;

    @TargetApi(23)
    public static void ev(Context context) {
        if (!ew(context)) {
            ex(context);
            ((Activity) context).requestPermissions((String[]) fhW.toArray(new String[fhW.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean ew(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void ex(Context context) {
        if (fhW == null) {
            fhW = new ArrayList();
        } else {
            fhW.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            fhW.add("android.permission.WRITE_EXTERNAL_STORAGE");
            fhW.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!ew(context)) {
                ev(context);
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
