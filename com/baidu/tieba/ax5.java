package com.baidu.tieba;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class ax5 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public static final Pattern b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947630571, "Lcom/baidu/tieba/ax5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947630571, "Lcom/baidu/tieba/ax5;");
                return;
            }
        }
        a = Pattern.compile("http[s]?://tieba\\.baidu\\.com/f(.*)&jump_tieba_native=1(.*)");
        b = Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1");
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Date date = new Date(SharedPrefHelper.getInstance().getLong("show_login_dialog_strategy_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date2 = new Date(currentTimeMillis);
            SharedPrefHelper.getInstance().putLong("show_login_dialog_strategy_key", currentTimeMillis);
            return !TimeHelper.isSameDay(date, date2);
        }
        return invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (di.isEmpty(str)) {
                return false;
            }
            return a.matcher(str.toLowerCase()).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (di.isEmpty(str)) {
                return false;
            }
            return b.matcher(str.toLowerCase()).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (di.isEmpty(str)) {
                return false;
            }
            return "person".equalsIgnoreCase(Uri.parse(str).getAuthority());
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!b(str) && !c(str) && !d(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
