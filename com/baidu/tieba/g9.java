package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class g9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof a9) {
                return (a9) context;
            }
            if (context instanceof b9) {
                return ((b9) context).getPageContext();
            }
            Field b = zh.b(context.getClass(), f9.class);
            if (b == null || (a = zh.a(context, b)) == null || !(a instanceof f9) || !(a instanceof b9)) {
                return null;
            }
            return ((b9) a).getPageContext();
        }
        return (a9) invokeL.objValue;
    }

    public static f9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof f9) {
                return (f9) context;
            }
            if (context instanceof b9) {
                Object orignalPage = ((b9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof f9) {
                    return (f9) orignalPage;
                }
            }
            Field b = zh.b(context.getClass(), f9.class);
            if (b == null || (a = zh.a(context, b)) == null || !(a instanceof f9)) {
                return null;
            }
            return (f9) a;
        }
        return (f9) invokeL.objValue;
    }

    public static b9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof b9) {
                return (b9) context;
            }
            Field b = zh.b(context.getClass(), f9.class);
            if (b == null || (a = zh.a(context, b)) == null || !(a instanceof f9) || !(a instanceof b9)) {
                return null;
            }
            return (b9) a;
        }
        return (b9) invokeL.objValue;
    }
}
