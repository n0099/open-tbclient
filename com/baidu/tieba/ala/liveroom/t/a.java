package com.baidu.tieba.ala.liveroom.t;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static boolean eH(Context context) {
        ComponentName componentName;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager == null) {
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        return (runningTasks == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || componentName.getPackageName().equals(context.getPackageName())) ? false : true;
    }
}
