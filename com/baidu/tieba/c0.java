package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;
import com.android.support.appcompat.storage.permission.GrantPermissionActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, a0> a;

    public c0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static c0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (c0.class) {
                    if (b == null) {
                        b = new c0();
                    }
                }
            }
            return b;
        }
        return (c0) invokeV.objValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void a(String str, a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, a0Var) == null) {
            if (this.a.containsKey(str)) {
                this.a.remove(str);
            }
            this.a.put(str, a0Var);
        }
    }

    public a0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a.containsKey(str)) {
                return this.a.get(str);
            }
            return null;
        }
        return (a0) invokeL.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.containsKey(str)) {
            this.a.remove(str);
        }
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(Context context, IntentSender intentSender, Uri uri, ContentValues contentValues, String str, String[] strArr, z zVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, intentSender, uri, contentValues, str, strArr, zVar, Integer.valueOf(i)}) == null) {
            a0.a aVar = new a0.a();
            aVar.h(uri);
            aVar.i(contentValues);
            aVar.j(str);
            aVar.f(strArr);
            aVar.e(zVar);
            aVar.g(System.currentTimeMillis());
            i(context, aVar.b(), intentSender, i, zVar);
        }
    }

    public void h(Context context, IntentSender intentSender, Uri uri, String str, CancellationSignal cancellationSignal, z zVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, intentSender, uri, str, cancellationSignal, zVar, Integer.valueOf(i)}) == null) {
            a0.a aVar = new a0.a();
            aVar.h(uri);
            aVar.d(str);
            aVar.c(cancellationSignal);
            aVar.e(zVar);
            aVar.g(System.currentTimeMillis());
            i(context, aVar.b(), intentSender, i, zVar);
        }
    }

    public final void i(Context context, a0 a0Var, IntentSender intentSender, int i, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, a0Var, intentSender, Integer.valueOf(i), zVar}) == null) {
            if (!d(context)) {
                zVar.onFailed(3);
                Log.e("MediaFileProcessor", "showPermissionPage: 应用处于后台， 禁止申请弹窗");
                return;
            }
            String valueOf = String.valueOf(a0Var.j);
            b().a(valueOf, a0Var);
            GrantPermissionActivity.b(context, intentSender, i, valueOf);
        }
    }
}
