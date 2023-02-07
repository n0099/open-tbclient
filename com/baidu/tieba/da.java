package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class da {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static x9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof x9) {
                return (x9) context;
            }
            if (context instanceof y9) {
                return ((y9) context).getPageContext();
            }
            Field b = vi.b(context.getClass(), ca.class);
            if (b == null || (a = vi.a(context, b)) == null || !(a instanceof ca) || !(a instanceof y9)) {
                return null;
            }
            return ((y9) a).getPageContext();
        }
        return (x9) invokeL.objValue;
    }

    public static ca c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof ca) {
                return (ca) context;
            }
            if (context instanceof y9) {
                Object orignalPage = ((y9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof ca) {
                    return (ca) orignalPage;
                }
            }
            Field b = vi.b(context.getClass(), ca.class);
            if (b == null || (a = vi.a(context, b)) == null || !(a instanceof ca)) {
                return null;
            }
            return (ca) a;
        }
        return (ca) invokeL.objValue;
    }

    public static y9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof y9) {
                return (y9) context;
            }
            Field b = vi.b(context.getClass(), ca.class);
            if (b == null || (a = vi.a(context, b)) == null || !(a instanceof ca) || !(a instanceof y9)) {
                return null;
            }
            return (y9) a;
        }
        return (y9) invokeL.objValue;
    }
}
