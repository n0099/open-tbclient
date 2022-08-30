package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public final class ew2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile ew2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<a> a;
    public Set<String> b;

    /* loaded from: classes4.dex */
    public interface a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748681, "Lcom/baidu/tieba/ew2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748681, "Lcom/baidu/tieba/ew2;");
                return;
            }
        }
        c = kh1.a;
    }

    public ew2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        this.b = new HashSet();
    }

    @NonNull
    public static int[] b(@NonNull Activity activity, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, strArr)) == null) {
            if (strArr == null || strArr.length == 0) {
                return new int[0];
            }
            int[] iArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                iArr[i] = uh4.a(activity, strArr[i]) ? 0 : -1;
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public static ew2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (ew2.class) {
                    if (d == null) {
                        d = new ew2();
                    }
                }
            }
            return d;
        }
        return (ew2) invokeV.objValue;
    }

    @Nullable
    public static String d(@NonNull Activity activity, @NonNull String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, strArr)) == null) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (!uh4.a(activity, str) && (ie4.f(activity, str) || !e(str))) {
                    return str;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            i93 a2 = o93.a();
            return a2.getBoolean("first#" + str, false);
        }
        return invokeL.booleanValue;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            i93 a2 = o93.a();
            a2.putBoolean("first#" + str, true);
        }
    }

    public final boolean a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.b.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, i, strArr, iArr) == null) {
            boolean z = !a(strArr);
            if (Build.VERSION.SDK_INT >= 23) {
                h(activity, strArr, iArr);
            }
            a aVar = this.a.get(i);
            if (aVar != null) {
                this.a.remove(i);
                if ((aVar instanceof zv2) && z) {
                    aVar = ((zv2) aVar).s();
                }
                aVar.onRequestPermissionsResult(i, strArr, iArr);
            }
            if (c) {
                Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
                StringBuilder sb = new StringBuilder();
                sb.append("onRequestPermissionsResult grantResults: ");
                sb.append(Arrays.toString(iArr));
                Log.d("SwanAppPermission", sb.toString());
            }
        }
    }

    @RequiresApi(api = 23)
    public final void h(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, strArr, iArr) == null) || Build.VERSION.SDK_INT < 23 || activity == null || (length = strArr.length) != iArr.length || length <= 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            String str = strArr[i];
            if (!TextUtils.isEmpty(str) && i2 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                this.b.add(str);
            }
        }
    }

    @TargetApi(23)
    public void requestPermissions(Activity activity, int i, @NonNull String[] strArr, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048579, this, activity, i, strArr, aVar) == null) || aVar == null || activity == null) {
            return;
        }
        String d2 = d(activity, strArr);
        if (d2 != null) {
            this.a.put(i, aVar);
            activity.requestPermissions(strArr, i);
            g(d2);
        } else {
            aVar.onRequestPermissionsResult(i, strArr, b(activity, strArr));
        }
        if (c) {
            Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i + " permissions: " + Arrays.toString(strArr));
        }
    }
}
