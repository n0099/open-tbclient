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
/* loaded from: classes6.dex */
public class ht5 {
    public static /* synthetic */ Interceptable $ic;
    public static ht5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, gt5> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947835264, "Lcom/baidu/tieba/ht5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947835264, "Lcom/baidu/tieba/ht5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ffa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dfa a;
        public final /* synthetic */ WebView b;

        public a(ht5 ht5Var, dfa dfaVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht5Var, dfaVar, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dfaVar;
            this.b = webView;
        }

        @Override // com.baidu.tieba.ffa
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                dfa dfaVar = this.a;
                if (dfaVar != null) {
                    return dfaVar.c(this.b, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public ht5() {
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

    public static ht5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ht5.class) {
                    if (b == null) {
                        b = new ht5();
                    }
                }
            }
            return b;
        }
        return (ht5) invokeV.objValue;
    }

    public gt5 a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.a.size() >= 8) {
                f();
            }
            gt5 gt5Var = new gt5();
            BridgeWebView bridgeWebView = new BridgeWebView(new MutableContextWrapper(context));
            bridgeWebView.setBackgroundColor(R.color.transparent);
            it5.b(bridgeWebView);
            dfa dfaVar = new dfa();
            dfaVar.a(new CommonTbJsBridge(context, bridgeWebView));
            kr4 kr4Var = new kr4();
            kr4Var.b(new a(this, dfaVar, bridgeWebView));
            bridgeWebView.setWebChromeClient(kr4Var);
            gt5Var.a = bridgeWebView;
            gt5Var.b = str;
            gt5Var.c = 0;
            this.a.put(str, gt5Var);
            return gt5Var;
        }
        return (gt5) invokeLL.objValue;
    }

    public gt5 c(Activity activity, String str) {
        InterceptResult invokeLL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) {
            gt5 gt5Var = this.a.get(str);
            if (gt5Var != null && (webView = gt5Var.a) != null) {
                ((MutableContextWrapper) webView.getContext()).setBaseContext(activity);
                this.a.remove(str);
                return gt5Var;
            }
            return null;
        }
        return (gt5) invokeLL.objValue;
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
                gt5 gt5Var = this.a.get(str2);
                if (gt5Var != null) {
                    if (gt5Var.d < j) {
                        str = gt5Var.b;
                    }
                    j = gt5Var.d;
                }
            }
            if (str != null) {
                this.a.remove(str);
            }
        }
    }
}
