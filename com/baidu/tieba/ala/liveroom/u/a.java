package com.baidu.tieba.ala.liveroom.u;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static boolean eA(Context context) {
        ActivityManager activityManager;
        ComponentName componentName;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            return (runningTasks == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || componentName.getPackageName().equals(context.getPackageName())) ? false : true;
        }
        return false;
    }
}
