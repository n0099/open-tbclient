package com.baidu.tieba;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.session.XRSessionAnchor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes4.dex */
public final class e7a extends ArCoreApk {
    public static /* synthetic */ Interceptable $ic;
    public static final e7a h;
    public transient /* synthetic */ FieldHolder $fh;
    public Exception a;
    public ArCoreApk.Availability b;
    public boolean c;
    public k7a d;
    public boolean e;
    public boolean f;
    public int g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688634, "Lcom/baidu/tieba/e7a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688634, "Lcom/baidu/tieba/e7a;");
                return;
            }
        }
        h = new e7a();
    }

    public e7a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e7a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return h;
        }
        return (e7a) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Exception exc = this.a;
                if (this.d != null) {
                    this.d.a();
                    this.d = null;
                }
            }
        }
    }

    public static /* synthetic */ boolean f(e7a e7aVar, boolean z) {
        e7aVar.c = false;
        return false;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(XRSessionAnchor.apkinfo, 4);
                int i = packageInfo.versionCode;
                if (i == 0) {
                    if (packageInfo.services != null) {
                        if (packageInfo.services.length == 0) {
                        }
                    }
                    return -1;
                }
                return i;
            } catch (PackageManager.NameNotFoundException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final synchronized k7a e(Context context) {
        InterceptResult invokeL;
        k7a k7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            synchronized (this) {
                if (this.d == null) {
                    k7a k7aVar2 = new k7a((byte) 0);
                    k7aVar2.d(context.getApplicationContext());
                    this.d = k7aVar2;
                }
                k7aVar = this.d;
            }
            return k7aVar;
        }
        return (k7a) invokeL.objValue;
    }

    public final boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            l(context);
            if (k(context) != 0 && k(context) < this.g) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            l(context);
            return this.f;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.ar.core.ArCoreApk
    public final ArCoreApk.Availability a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (!i()) {
                return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
            }
            try {
                if (h(context)) {
                    g();
                    return d7a.c(context);
                }
                synchronized (this) {
                    if ((this.b == null || this.b.isUnknown()) && !this.c) {
                        this.c = true;
                        d7a d7aVar = new d7a(this);
                        if (h(context)) {
                            d7aVar.a(ArCoreApk.Availability.SUPPORTED_INSTALLED);
                        } else if (k(context) != -1) {
                            d7aVar.a(ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD);
                        } else if (j(context)) {
                            d7aVar.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                        } else {
                            e(context).e(context, d7aVar);
                        }
                    }
                    if (this.b != null) {
                        return this.b;
                    }
                    if (this.c) {
                        return ArCoreApk.Availability.UNKNOWN_CHECKING;
                    }
                    Log.e("ARCore-ArCoreApk", "request not running but result is null?");
                    return ArCoreApk.Availability.UNKNOWN_ERROR;
                }
            } catch (FatalException e) {
                Log.e("ARCore-ArCoreApk", "Error while checking app details and ARCore status", e);
                return ArCoreApk.Availability.UNKNOWN_ERROR;
            }
        }
        return (ArCoreApk.Availability) invokeL.objValue;
    }

    public final synchronized void l(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this) {
                if (this.e) {
                    return;
                }
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                try {
                    Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
                    if (bundle.containsKey(XRSessionAnchor.apkinfo)) {
                        this.f = bundle.getString(XRSessionAnchor.apkinfo).equals("required");
                        if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                            this.g = bundle.getInt("com.google.ar.core.min_apk_version");
                            try {
                                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                                String canonicalName = InstallActivity.class.getCanonicalName();
                                int length = activityInfoArr.length;
                                boolean z = false;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        break;
                                    } else if (canonicalName.equals(activityInfoArr[i].name)) {
                                        z = true;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (!z) {
                                    String valueOf = String.valueOf(canonicalName);
                                    if (valueOf.length() != 0) {
                                        str = "Application manifest must contain activity ".concat(valueOf);
                                    } else {
                                        str = new String("Application manifest must contain activity ");
                                    }
                                    throw new FatalException(str);
                                }
                                this.e = true;
                                return;
                            } catch (PackageManager.NameNotFoundException e) {
                                throw new FatalException("Could not load application package info", e);
                            }
                        }
                        throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
                    }
                    throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new FatalException("Could not load application package metadata", e2);
                }
            }
        }
    }
}
