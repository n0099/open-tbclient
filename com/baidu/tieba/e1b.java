package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.ContextThemeWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class e1b {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682899, "Lcom/baidu/tieba/e1b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682899, "Lcom/baidu/tieba/e1b;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        @JvmStatic
        public final TbWebView a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                if (context instanceof MutableContextWrapper) {
                    MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context;
                    mutableContextWrapper.setBaseContext(new ContextThemeWrapper(mutableContextWrapper.getBaseContext(), (int) R.style.obfuscated_res_0x7f100457));
                    return new TbWebView(context);
                }
                return new TbWebView(new ContextThemeWrapper(context, (int) R.style.obfuscated_res_0x7f100457));
            }
            return (TbWebView) invokeL.objValue;
        }

        @JvmStatic
        public final Context b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                if (context instanceof MutableContextWrapper) {
                    MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context;
                    mutableContextWrapper.setBaseContext(new ContextThemeWrapper(mutableContextWrapper.getBaseContext(), (int) R.style.obfuscated_res_0x7f100457));
                    return context;
                }
                return new ContextThemeWrapper(context, (int) R.style.obfuscated_res_0x7f100457);
            }
            return (Context) invokeL.objValue;
        }
    }
}
