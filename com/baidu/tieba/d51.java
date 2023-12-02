package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.NadNativeBrowserView;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.c51;
import com.baidu.tieba.k61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class d51 implements c51.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c51.a
    public void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    @Override // com.baidu.tieba.c51.a
    public boolean b(HashMap<String, String> hashMap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap, i)) == null) {
            return true;
        }
        return invokeLI.booleanValue;
    }

    public d51() {
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

    @Override // com.baidu.tieba.c51.a
    public AbsNadBrowserView c(Context context, m61 m61Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, m61Var, i)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            p61.c(context, "创建native内核browserView");
            return new NadNativeBrowserView(context);
        }
        return (AbsNadBrowserView) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.c51.a
    public void d(Context context, boolean z, int i, k61.b listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), listener}) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    WebView.setDataDirectorySuffix(p11.a());
                }
                CookieSyncManager.createInstance(context);
                listener.a();
            } catch (Exception e) {
                listener.b();
                p61.d(e);
            }
        }
    }
}
