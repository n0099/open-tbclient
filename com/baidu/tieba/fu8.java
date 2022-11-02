package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fu8 {
    public static /* synthetic */ Interceptable $ic;
    public static fu8 b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Application application);

        void b(Context context);

        void c(Context context, WebView webView, WebChromeClient webChromeClient);

        void d(Context context, String str, boolean z);
    }

    public fu8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c();
    }

    public static fu8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (fu8.class) {
                    if (b == null) {
                        b = new fu8();
                    }
                }
            }
            return b;
        }
        return (fu8) invokeV.objValue;
    }

    public final a c() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (e() && (runTask = MessageManager.getInstance().runTask(2156671, a.class)) != null) {
                return (a) runTask.getData();
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ky4.k().l("pref_key_stat_sdk_enable", 1) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a(Context context) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.b(context);
        }
    }

    public void d(Application application) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, application) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.a(application);
        }
    }

    public void f(Context context, String str, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048580, this, context, str, z) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.d(context, str, z);
        }
    }

    public void g(Context context, WebView webView, WebChromeClient webChromeClient) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, context, webView, webChromeClient) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.c(context, webView, webChromeClient);
        }
    }
}
