package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    private static List<String> fXd = null;

    @TargetApi(23)
    public static void eQ(Context context) {
        if (!eR(context)) {
            eS(context);
            ((Activity) context).requestPermissions((String[]) fXd.toArray(new String[fXd.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean eR(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void eS(Context context) {
        if (fXd == null) {
            fXd = new ArrayList();
        } else {
            fXd.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            fXd.add("android.permission.WRITE_EXTERNAL_STORAGE");
            fXd.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!eR(context)) {
                eQ(context);
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
