package com.baidu.tieba.easterEgg;

import android.app.Service;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.IBinder;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.mp8;
import com.baidu.tieba.op8;
import com.baidu.tieba.r96;
import com.baidu.tieba.s96;
import com.baidu.tieba.t96;
import com.baidu.tieba.wi;
import com.baidu.tieba.x96;
import com.baidu.tieba.y96;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EasterEggH5Service extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static String KEY_URL = "url";
    public transient /* synthetic */ FieldHolder $fh;
    public EasterEggBridge eggBridge;
    public Gson gson;
    public mp8 jsBridge;
    public x96 mHttpRule;
    public y96 mSocketRule;
    public BdUniqueId mTag;
    public String mUrl;
    public BaseWebView mWebView;
    public s96 model;
    public r96 onHitEventListener;
    public CustomMessageListener onSearchEventListener;
    public CustomMessageListener onWriteReadListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(509847468, "Lcom/baidu/tieba/easterEgg/EasterEggH5Service;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(509847468, "Lcom/baidu/tieba/easterEgg/EasterEggH5Service;");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements r96 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggH5Service a;

        public a(EasterEggH5Service easterEggH5Service) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggH5Service};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggH5Service;
        }

        @Override // com.baidu.tieba.r96
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) && this.a.mWebView != null) {
                EasterEggH5Service easterEggH5Service = this.a;
                easterEggH5Service.loadJsUrl(easterEggH5Service.mWebView, "receiveEvent", str2, str3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggH5Service a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EasterEggH5Service easterEggH5Service, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggH5Service, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggH5Service;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof String)) {
                if (this.a.mHttpRule != null) {
                    str = this.a.mHttpRule.a("reindeer_search");
                } else {
                    str = null;
                }
                if (str != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("content", customResponsedMessage.getData());
                        this.a.onHitEventListener.a("reindeer_search", this.a.gson.toJson(str), this.a.gson.toJson(jSONObject.toString()));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggH5Service a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EasterEggH5Service easterEggH5Service, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggH5Service, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggH5Service;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof HttpRequest)) {
                HttpRequest httpRequest = (HttpRequest) customResponsedMessage.getData();
                if (this.a.mHttpRule != null) {
                    str = this.a.mHttpRule.a(httpRequest.mUrl);
                } else {
                    str = null;
                }
                if (str != null) {
                    HashMap hashMap = new HashMap();
                    if (!ListUtils.isEmpty(httpRequest.mPostData)) {
                        for (int i = 0; i < httpRequest.mPostData.size(); i++) {
                            if (httpRequest.mPostData.get(i) != null) {
                                hashMap.put(httpRequest.mPostData.get(i).getName(), httpRequest.mPostData.get(i).getValue());
                            }
                        }
                    }
                    this.a.onHitEventListener.a(httpRequest.mUrl, this.a.gson.toJson(str), this.a.gson.toJson(this.a.gson.toJson(hashMap)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements s96.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggH5Service a;

        public d(EasterEggH5Service easterEggH5Service) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggH5Service};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggH5Service;
        }

        @Override // com.baidu.tieba.s96.b
        public void a(boolean z, t96 t96Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, t96Var) == null) {
                if (z && t96Var != null && !wi.isEmpty(t96Var.a()) && t96Var.c()) {
                    if (this.a.mWebView != null) {
                        this.a.mWebView.loadUrl(t96Var.a());
                    }
                    HashMap<String, String> b = t96Var.b();
                    if (b != null) {
                        this.a.mHttpRule.c(b);
                        this.a.mSocketRule.c(b);
                        return;
                    }
                    return;
                }
                this.a.stopSelf();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggH5Service a;

        public e(EasterEggH5Service easterEggH5Service) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggH5Service};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggH5Service;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) && sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements op8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EasterEggH5Service a;

        public f(EasterEggH5Service easterEggH5Service) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {easterEggH5Service};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = easterEggH5Service;
        }

        @Override // com.baidu.tieba.op8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.jsBridge != null && this.a.jsBridge.b(this.a.mWebView, str, jsPromptResult)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public EasterEggH5Service() {
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
        this.mUrl = null;
        this.mTag = BdUniqueId.gen();
        this.gson = new Gson();
        this.onHitEventListener = new a(this);
        this.onSearchEventListener = new b(this, 2921345);
        this.onWriteReadListener = new c(this, 2921344);
    }

    private void initListenerAndRule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.onSearchEventListener.setTag(this.mTag);
            MessageManager.getInstance().registerListener(this.onSearchEventListener);
            this.onWriteReadListener.setTag(this.mTag);
            MessageManager.getInstance().registerListener(this.onWriteReadListener);
            x96 x96Var = new x96(0);
            this.mHttpRule = x96Var;
            x96Var.b(this.onHitEventListener);
            MessageManager.getInstance().addMessageRule(this.mHttpRule);
            y96 y96Var = new y96(0);
            this.mSocketRule = y96Var;
            y96Var.b(this.onHitEventListener);
            MessageManager.getInstance().addMessageRule(this.mSocketRule);
        }
    }

    private void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                this.mWebView = new BaseWebView(this);
                this.jsBridge = new mp8();
                this.mWebView.initCommonJsBridge(this);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mWebView.getSettings().setMixedContentMode(0);
                }
                this.mWebView.setWebViewClient(new e(this));
                EasterEggBridge easterEggBridge = new EasterEggBridge();
                this.eggBridge = easterEggBridge;
                this.jsBridge.a(easterEggBridge);
                this.mWebView.setOnJsPromptCallback(new f(this));
            } catch (Throwable th) {
                zx4.a("img", -1L, 0, "easteregg_error", 0, th.getClass().getName(), "", "");
                TbadkCoreApplication.getInst().onLowMemory();
                stopSelf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadJsUrl(WebView webView, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65547, this, webView, str, strArr) != null) || wi.isEmpty(str)) {
            return;
        }
        String str2 = "javascript:" + str + "(";
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                str2 = str2 + strArr[i];
                if (i != strArr.length - 1) {
                    str2 = str2 + ",";
                }
            }
        }
        String str3 = str2 + SmallTailInfo.EMOTION_SUFFIX;
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(str3, null);
        } else {
            webView.loadUrl(str3);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            initWebView();
            initListenerAndRule();
            s96 s96Var = new s96();
            this.model = s96Var;
            s96Var.d(new d(this));
            this.model.e();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            s96 s96Var = this.model;
            if (s96Var != null) {
                s96Var.c();
            }
            EasterEggBridge easterEggBridge = this.eggBridge;
            if (easterEggBridge != null) {
                easterEggBridge.clearListener();
            }
            MessageManager.getInstance().removeMessageRule(this.mHttpRule);
            MessageManager.getInstance().removeMessageRule(this.mSocketRule);
            MessageManager.getInstance().unRegisterListener(this.mTag);
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(KEY_URL);
                this.mUrl = stringExtra;
                if (!wi.isEmpty(stringExtra)) {
                    this.mWebView.loadUrl(this.mUrl);
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
