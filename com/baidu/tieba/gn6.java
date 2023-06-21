package com.baidu.tieba;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class gn6 extends cn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bj6<cj6> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn6(bj6<cj6> bj6Var) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bj6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((WebChromeClient) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bj6Var;
    }

    @Override // com.baidu.tieba.cn6, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
            super.onProgressChanged(webView, i);
            cj6 call = this.b.call();
            if (call != null) {
                call.f(webView, i);
            }
        }
    }
}
