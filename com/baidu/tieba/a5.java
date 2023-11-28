package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class a5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static BdPageContext<?> a(Context context) {
        InterceptResult invokeL;
        Field b;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context instanceof MutableContextWrapper) {
                context = ((MutableContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Application) || context == null) {
                return null;
            }
            if (context instanceof BdPageContext) {
                return (BdPageContext) context;
            }
            if (context instanceof BdPageContextSupport) {
                return ((BdPageContextSupport) context).getPageContext();
            }
            if (!b5.a.a() || (b = jd.b(context.getClass(), z4.class)) == null || (a = jd.a(context, b)) == null || !(a instanceof z4) || !(a instanceof BdPageContextSupport)) {
                return null;
            }
            return ((BdPageContextSupport) a).getPageContext();
        }
        return (BdPageContext) invokeL.objValue;
    }

    public static BdPageContextSupport<?> b(Context context) {
        InterceptResult invokeL;
        Field b;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context instanceof MutableContextWrapper) {
                context = ((MutableContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Application) || context == null) {
                return null;
            }
            if (context instanceof BdPageContextSupport) {
                return (BdPageContextSupport) context;
            }
            if (!b5.a.a() || (b = jd.b(context.getClass(), z4.class)) == null || (a = jd.a(context, b)) == null || !(a instanceof z4) || !(a instanceof BdPageContextSupport)) {
                return null;
            }
            return (BdPageContextSupport) a;
        }
        return (BdPageContextSupport) invokeL.objValue;
    }

    public static z4 c(Context context) {
        InterceptResult invokeL;
        Field b;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context instanceof MutableContextWrapper) {
                context = ((MutableContextWrapper) context).getBaseContext();
            }
            if ((context instanceof Application) || context == null) {
                return null;
            }
            if (context instanceof z4) {
                return (z4) context;
            }
            if (context instanceof BdPageContextSupport) {
                BdPageContextSupport bdPageContextSupport = (BdPageContextSupport) context;
                if (bdPageContextSupport.getPageContext() == null) {
                    return null;
                }
                Object orignalPage = bdPageContextSupport.getPageContext().getOrignalPage();
                if (orignalPage instanceof z4) {
                    return (z4) orignalPage;
                }
            }
            if (!b5.a.a() || (b = jd.b(context.getClass(), z4.class)) == null || (a = jd.a(context, b)) == null || !(a instanceof z4)) {
                return null;
            }
            return (z4) a;
        }
        return (z4) invokeL.objValue;
    }
}
