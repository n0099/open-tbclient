package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MonitorWebView a;
    public dm6 b;
    public cm6 c;

    public gn6() {
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
            dm6 dm6Var = this.b;
            if (dm6Var != null) {
                c(dm6Var);
            }
            cm6 cm6Var = this.c;
            if (cm6Var != null) {
                b(cm6Var);
            }
        }
    }

    public void b(@NonNull cm6 cm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cm6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.c = cm6Var;
            } else if (monitorWebView.q >= 2) {
                cm6Var.onPageFinished(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageFinishedListener(cm6Var);
            } else {
                monitorWebView.setOnPageFinishedListener(cm6Var);
            }
        }
    }

    public void c(@NonNull dm6 dm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dm6Var) == null) {
            MonitorWebView monitorWebView = this.a;
            if (monitorWebView == null) {
                this.b = dm6Var;
            } else if (monitorWebView.q >= 1) {
                dm6Var.d(monitorWebView, monitorWebView.getUrl());
                this.a.setOnPageStartedListener(dm6Var);
            } else {
                monitorWebView.setOnPageStartedListener(dm6Var);
            }
        }
    }
}
