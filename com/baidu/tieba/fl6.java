package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MonitorWebView a;
    public yj6 b;
    public xj6 c;

    public fl6() {
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
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void a(@NonNull MonitorWebView monitorWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, monitorWebView) == null) {
            this.a = monitorWebView;
            yj6 yj6Var = this.b;
            if (yj6Var != null) {
                c(yj6Var);
            }
            xj6 xj6Var = this.c;
            if (xj6Var != null) {
                b(xj6Var);
            }
        }
    }

    public void b(@NonNull xj6 xj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xj6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.c = xj6Var;
            } else if (monitorWebView.v >= 2) {
                xj6Var.onPageFinished(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageFinishedListener(xj6Var);
            } else {
                monitorWebView.setOnPageFinishedListener(xj6Var);
            }
        }
    }

    public void c(@NonNull yj6 yj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yj6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.b = yj6Var;
            } else if (monitorWebView.v >= 1) {
                yj6Var.a(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageStartedListener(yj6Var);
            } else {
                monitorWebView.setOnPageStartedListener(yj6Var);
            }
        }
    }
}
