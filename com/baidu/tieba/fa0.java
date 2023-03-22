package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.spswitch.utils.SoftInputSharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fa0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SharedPreferences a;
    public transient /* synthetic */ FieldHolder $fh;

    public fa0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            return c(context).getInt(SoftInputSharedPreferences.KEY_SOFITNPUT_HEIGHT, i);
        }
        return invokeLI.intValue;
    }

    public static boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i)) == null) {
            return c(context).edit().putInt(SoftInputSharedPreferences.KEY_SOFITNPUT_HEIGHT, i).commit();
        }
        return invokeLI.booleanValue;
    }

    public static SharedPreferences c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null) {
                synchronized (fa0.class) {
                    if (a == null) {
                        a = context.getSharedPreferences("live_feed_search_softinput", 0);
                    }
                }
            }
            return a;
        }
        return (SharedPreferences) invokeL.objValue;
    }
}
