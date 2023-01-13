package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class hd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Intent a(Context context) {
        InterceptResult invokeL;
        List<ResolveInfo> queryIntentActivities;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("baidu.intent.action.account.AUTH_WIDGET_FOR_CASHIER"), 32);
            } catch (Throwable th) {
                id1.d(th);
            }
            if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    String str = resolveInfo.activityInfo.permission;
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    Intent intent = new Intent("baidu.intent.action.account.AUTH_WIDGET_FOR_CASHIER");
                    intent.setClassName(((ComponentInfo) activityInfo).packageName, ((ComponentInfo) activityInfo).name);
                    if (Build.VERSION.SDK_INT > 11) {
                        intent.addFlags(32);
                    }
                    if (TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) == 0) {
                        if (intent.getComponent() != null && context.getPackageName().equals(intent.getComponent().getPackageName())) {
                            return intent;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }
}
