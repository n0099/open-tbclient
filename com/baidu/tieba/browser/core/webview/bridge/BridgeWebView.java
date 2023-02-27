package com.baidu.tieba.browser.core.webview.bridge;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.be6;
import com.baidu.tieba.browser.core.webview.scroll.NestedScrollWebView;
import com.baidu.tieba.fe6;
import com.baidu.tieba.kc6;
import com.baidu.tieba.wb6;
import com.baidu.tieba.xb6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BridgeWebView extends NestedScrollWebView implements be6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wb6 t;
    public final List<Pair<String, String>> u;
    public final kc6 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgeWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new ArrayList();
        this.v = new kc6();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new ArrayList();
        this.v = new kc6();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.u = new ArrayList();
        this.v = new kc6();
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            super.setWebChromeClient(this.v);
            if (this.t == null) {
                xb6 g = xb6.g(this);
                this.t = g;
                g.b();
            }
        }
    }

    @Override // com.baidu.tieba.browser.core.webview.base.BaseWebView, com.baidu.tieba.browser.core.webview.monitor.MonitorWebView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            fe6.a().b(this.u);
            this.t.a();
            this.u.clear();
            super.c();
        }
    }

    @Override // com.baidu.tieba.browser.core.webview.base.BaseWebView, com.baidu.tieba.browser.core.webview.monitor.MonitorWebView
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.b();
            super.d();
        }
    }

    @Override // com.baidu.tieba.be6
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.u.add(Pair.create(str, str2));
        }
    }

    @Override // com.baidu.tieba.browser.core.webview.base.BaseWebView, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webChromeClient) == null) {
            this.v.b(webChromeClient);
        }
    }
}
