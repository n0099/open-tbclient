package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes3.dex */
public class bu9 implements ArCoreApk.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cu9 a;

    public bu9(cu9 cu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cu9Var;
    }

    public static Uri b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new Uri.Builder().scheme("content").authority("com.google.ar.core.services.arcorecontentprovider").path(str).build();
        }
        return (Uri) invokeL.objValue;
    }

    public static ArCoreApk.Availability c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (d(context) != null) {
                    return ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD;
                }
                return ArCoreApk.Availability.SUPPORTED_INSTALLED;
            } catch (UnavailableDeviceNotCompatibleException unused) {
                return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
            } catch (UnavailableUserDeclinedInstallationException | RuntimeException unused2) {
                return ArCoreApk.Availability.UNKNOWN_ERROR;
            }
        }
        return (ArCoreApk.Availability) invokeL.objValue;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, availability) == null) {
            synchronized (this.a) {
                cu9.c(this.a, availability);
                cu9.f(this.a, false);
            }
        }
    }

    public static PendingIntent d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                Bundle call = context.getContentResolver().call(b(""), "getSetupIntent", context.getPackageName(), (Bundle) null);
                if (call == null) {
                    return null;
                }
                PendingIntent pendingIntent = (PendingIntent) call.getParcelable(IntentData.KEY);
                if (pendingIntent != null) {
                    return pendingIntent;
                }
                String string = call.getString("exceptionType", "");
                if (string.isEmpty()) {
                    return null;
                }
                if (!string.equals(UnavailableDeviceNotCompatibleException.class.getName())) {
                    if (!string.equals(UnavailableUserDeclinedInstallationException.class.getName())) {
                        Class<? extends U> asSubclass = Class.forName(string).asSubclass(RuntimeException.class);
                        String string2 = call.getString("exceptionText", null);
                        if (string2 != null) {
                            throw ((RuntimeException) asSubclass.getConstructor(String.class).newInstance(string2));
                        }
                        throw ((RuntimeException) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    throw new UnavailableUserDeclinedInstallationException();
                }
                throw new UnavailableDeviceNotCompatibleException();
            } catch (ReflectiveOperationException | RuntimeException e) {
                Log.i("ARCore-SetupContentResolver", "Post-install failed", e);
                return null;
            }
        }
        return (PendingIntent) invokeL.objValue;
    }
}
