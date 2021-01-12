package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static List<String> gjF = null;

    @TargetApi(23)
    public static void fO(Context context) {
        if (!fP(context)) {
            fQ(context);
            ((Activity) context).requestPermissions((String[]) gjF.toArray(new String[gjF.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean fP(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void fQ(Context context) {
        if (gjF == null) {
            gjF = new ArrayList();
        } else {
            gjF.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            gjF.add("android.permission.WRITE_EXTERNAL_STORAGE");
            gjF.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!fP(context)) {
                fO(context);
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
