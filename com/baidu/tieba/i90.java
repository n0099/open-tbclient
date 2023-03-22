package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class i90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, int i) {
        InterceptResult invokeLI;
        String string;
        Float valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i)) == null) {
            if (i < 0) {
                return "";
            }
            long j = i;
            if (j < 10000) {
                return i + context.getString(R.string.obfuscated_res_0x7f0f0acb);
            }
            if (j < 100000000) {
                string = context.getString(R.string.obfuscated_res_0x7f0f0ac8);
                valueOf = Float.valueOf(i / 10000.0f);
            } else {
                string = context.getString(R.string.obfuscated_res_0x7f0f0ac2);
                valueOf = Float.valueOf(i / 1.0E8f);
            }
            DecimalFormat decimalFormat = new DecimalFormat("####.#");
            return decimalFormat.format(valueOf) + string;
        }
        return (String) invokeLI.objValue;
    }

    public static String j(String str, String... strArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, strArr)) == null) {
            if (strArr == null) {
                return str;
            }
            HashSet hashSet = new HashSet(Uri.parse(str).getQueryParameterNames());
            for (String str2 : strArr) {
                hashSet.remove(str2);
            }
            StringBuilder sb = new StringBuilder();
            if (str.contains("?")) {
                sb.append(str.substring(0, str.indexOf("?")));
            } else {
                sb.append(str);
            }
            sb.append("?");
            if (hashSet.size() > 0 && (indexOf = str.indexOf("&")) > 0) {
                sb.append(str.substring(indexOf));
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static int b(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f)) == null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static float c(Resources resources, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, resources, f)) == null) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }
        return invokeLF.floatValue;
    }

    public static int i(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65544, null, context, f)) == null) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo d(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            } catch (SecurityException e) {
                e.printStackTrace();
                connectivityManager = null;
            }
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            NetworkInfo d = d(context);
            if (d != null && d.isConnectedOrConnecting()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            NetworkInfo d = d(context);
            if (d != null && d.isAvailable() && d.getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, view2, i, i2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int measuredWidth = view2.getMeasuredWidth() + i3;
            int measuredHeight = view2.getMeasuredHeight() + i4;
            if (i2 < i4 || i2 > measuredHeight || i < i3 || i > measuredWidth) {
                return false;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }
}
