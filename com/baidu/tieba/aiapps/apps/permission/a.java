package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static List<String> gom = null;

    @TargetApi(23)
    public static void fQ(Context context) {
        if (!fR(context)) {
            fS(context);
            ((Activity) context).requestPermissions((String[]) gom.toArray(new String[gom.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean fR(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void fS(Context context) {
        if (gom == null) {
            gom = new ArrayList();
        } else {
            gom.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            gom.add("android.permission.WRITE_EXTERNAL_STORAGE");
            gom.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!fR(context)) {
                fQ(context);
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
