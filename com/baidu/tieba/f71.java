package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.NadNativeBrowserView;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.e71;
import com.baidu.tieba.m81;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class f71 implements e71.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.e71.a
    public boolean a(HashMap<String, String> hashMap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, hashMap, i)) == null) {
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.e71.a
    public void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public f71() {
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

    @Override // com.baidu.tieba.e71.a
    public AbsNadBrowserView c(Context context, o81 o81Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, o81Var, i)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            r81.c(context, "创建native内核browserView");
            return new NadNativeBrowserView(context);
        }
        return (AbsNadBrowserView) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.e71.a
    public void d(Context context, boolean z, int i, m81.b listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), listener}) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    WebView.setDataDirectorySuffix(w31.a());
                }
                CookieSyncManager.createInstance(context);
                listener.a();
            } catch (Exception e) {
                listener.b();
                r81.d(e);
            }
        }
    }
}
