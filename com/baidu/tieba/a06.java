package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a06 {
    public static /* synthetic */ Interceptable $ic;
    public static a06 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, zz5> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947561410, "Lcom/baidu/tieba/a06;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947561410, "Lcom/baidu/tieba/a06;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements nda {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lda a;
        public final /* synthetic */ WebView b;

        public a(a06 a06Var, lda ldaVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a06Var, ldaVar, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ldaVar;
            this.b = webView;
        }

        @Override // com.baidu.tieba.nda
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                lda ldaVar = this.a;
                if (ldaVar != null) {
                    return ldaVar.c(this.b, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public a06() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static a06 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (a06.class) {
                    if (b == null) {
                        b = new a06();
                    }
                }
            }
            return b;
        }
        return (a06) invokeV.objValue;
    }

    public zz5 a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.a.size() >= 8) {
                f();
            }
            zz5 zz5Var = new zz5();
            BridgeWebView bridgeWebView = new BridgeWebView(new MutableContextWrapper(context));
            bridgeWebView.setBackgroundColor(R.color.transparent);
            b06.b(bridgeWebView);
            lda ldaVar = new lda();
            ldaVar.a(new CommonTbJsBridge(context, bridgeWebView));
            wx4 wx4Var = new wx4();
            wx4Var.b(new a(this, ldaVar, bridgeWebView));
            bridgeWebView.setWebChromeClient(wx4Var);
            zz5Var.a = bridgeWebView;
            zz5Var.b = str;
            zz5Var.c = 0;
            this.a.put(str, zz5Var);
            return zz5Var;
        }
        return (zz5) invokeLL.objValue;
    }

    public zz5 c(Activity activity, String str) {
        InterceptResult invokeLL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) {
            zz5 zz5Var = this.a.get(str);
            if (zz5Var != null && (webView = zz5Var.a) != null) {
                ((MutableContextWrapper) webView.getContext()).setBaseContext(activity);
                this.a.remove(str);
                return zz5Var;
            }
            return null;
        }
        return (zz5) invokeLL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.a.containsKey(str) && this.a.get(str) != null && this.a.get(str).a()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long j = 0;
            String str = null;
            for (String str2 : this.a.keySet()) {
                zz5 zz5Var = this.a.get(str2);
                if (zz5Var != null) {
                    if (zz5Var.d < j) {
                        str = zz5Var.b;
                    }
                    j = zz5Var.d;
                }
            }
            if (str != null) {
                this.a.remove(str);
            }
        }
    }
}
