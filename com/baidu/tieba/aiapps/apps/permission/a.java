package com.baidu.tieba.aiapps.apps.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static List<String> ebM = null;

    @TargetApi(23)
    public static void ey(Context context) {
        if (!ez(context)) {
            eA(context);
            ((Activity) context).requestPermissions((String[]) ebM.toArray(new String[ebM.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }

    @TargetApi(23)
    public static boolean ez(Context context) {
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(23)
    private static void eA(Context context) {
        if (ebM == null) {
            ebM = new ArrayList();
        } else {
            ebM.clear();
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ebM.add("android.permission.WRITE_EXTERNAL_STORAGE");
            ebM.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean a(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!ez(context)) {
                ey(context);
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
