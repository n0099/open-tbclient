package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class ei0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements ci0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ ci0 c;

        public a(WeakReference weakReference, Intent intent, ci0 ci0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference, intent, ci0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.b = intent;
            this.c = ci0Var;
        }

        @Override // com.baidu.tieba.ci0
        public void onResult(boolean z) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z && (context = (Context) this.a.get()) != null) {
                    s31.d(context, this.b);
                }
                ci0 ci0Var = this.c;
                if (ci0Var != null) {
                    ci0Var.onResult(z);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947735165, "Lcom/baidu/tieba/ei0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947735165, "Lcom/baidu/tieba/ei0;");
                return;
            }
        }
        a = Boolean.FALSE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2, ci0 ci0Var, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, ci0Var, Boolean.valueOf(z)}) == null) {
            WeakReference weakReference = new WeakReference(context);
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (z && !di0.a(context, str)) {
                    z2 = false;
                    if (!z2) {
                        if (z) {
                            xh0.a().b(str, str2, new a(weakReference, intent, ci0Var));
                            return;
                        }
                        s31.d(context, intent);
                        if (ci0Var != null) {
                            ci0Var.onResult(true);
                            return;
                        }
                        return;
                    } else if (ci0Var != null) {
                        ci0Var.onResult(false);
                        return;
                    } else {
                        return;
                    }
                }
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                int i = 0;
                z2 = false;
                while (true) {
                    if (i >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo = (ResolveInfo) v01.d(queryIntentActivities, i);
                    if (resolveInfo != null) {
                        String str3 = resolveInfo.activityInfo.packageName;
                        if (TextUtils.equals(str3, str2)) {
                            intent.setPackage(str3);
                            z2 = true;
                            break;
                        }
                        z2 = true;
                    }
                    i++;
                }
                if (!z2) {
                }
            } catch (Exception unused) {
                if (ci0Var != null) {
                    ci0Var.onResult(false);
                }
            }
        }
    }

    public static boolean b(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                String str2 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                try {
                    context.startActivity(intent2);
                    z = true;
                } catch (Exception unused) {
                }
            }
            if (a.booleanValue() && !z) {
                Log.e("OpenAppUtils", "openAppByPkgName: " + str + "  failed");
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
