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
import com.baidu.tieba.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, z> a;

    public b0() {
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

    public static b0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (b0.class) {
                    if (b == null) {
                        b = new b0();
                    }
                }
            }
            return b;
        }
        return (b0) invokeV.objValue;
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

    public void a(String str, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, zVar) == null) {
            if (this.a.containsKey(str)) {
                this.a.remove(str);
            }
            this.a.put(str, zVar);
        }
    }

    public z c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a.containsKey(str)) {
                return this.a.get(str);
            }
            return null;
        }
        return (z) invokeL.objValue;
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

    public void g(Context context, IntentSender intentSender, Uri uri, ContentValues contentValues, String str, String[] strArr, y yVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, intentSender, uri, contentValues, str, strArr, yVar, Integer.valueOf(i)}) == null) {
            z.a aVar = new z.a();
            aVar.h(uri);
            aVar.i(contentValues);
            aVar.j(str);
            aVar.f(strArr);
            aVar.e(yVar);
            aVar.g(System.currentTimeMillis());
            i(context, aVar.b(), intentSender, i, yVar);
        }
    }

    public void h(Context context, IntentSender intentSender, Uri uri, String str, CancellationSignal cancellationSignal, y yVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, intentSender, uri, str, cancellationSignal, yVar, Integer.valueOf(i)}) == null) {
            z.a aVar = new z.a();
            aVar.h(uri);
            aVar.d(str);
            aVar.c(cancellationSignal);
            aVar.e(yVar);
            aVar.g(System.currentTimeMillis());
            i(context, aVar.b(), intentSender, i, yVar);
        }
    }

    public final void i(Context context, z zVar, IntentSender intentSender, int i, y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, zVar, intentSender, Integer.valueOf(i), yVar}) == null) {
            if (!d(context)) {
                yVar.onFailed(3);
                Log.e("MediaFileProcessor", "showPermissionPage: 应用处于后台， 禁止申请弹窗");
                return;
            }
            String valueOf = String.valueOf(zVar.j);
            b().a(valueOf, zVar);
            GrantPermissionActivity.b(context, intentSender, i, valueOf);
        }
    }
}
