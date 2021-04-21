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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.httpNet.NetWorkParam;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.google.gson.Gson;
import d.b.c.e.p.k;
import d.b.j0.g0.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EasterEggH5Service extends Service {
    public static String KEY_URL = "url";
    public EasterEggBridge eggBridge;
    public d.b.j0.d3.l0.a jsBridge;
    public d.b.j0.g0.g.a mHttpRule;
    public d.b.j0.g0.g.b mSocketRule;
    public BaseWebView mWebView;
    public d.b.j0.g0.d model;
    public String mUrl = null;
    public BdUniqueId mTag = BdUniqueId.gen();
    public Gson gson = new Gson();
    public d.b.j0.g0.c onHitEventListener = new a();
    public CustomMessageListener onSearchEventListener = new b(2921345);
    public CustomMessageListener onWriteReadListener = new c(2921344);

    /* loaded from: classes4.dex */
    public class a implements d.b.j0.g0.c {
        public a() {
        }

        @Override // d.b.j0.g0.c
        public void a(String str, String str2, String str3) {
            if (EasterEggH5Service.this.mWebView != null) {
                EasterEggH5Service easterEggH5Service = EasterEggH5Service.this;
                easterEggH5Service.loadJsUrl(easterEggH5Service.mWebView, "receiveEvent", str2, str3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String a2 = EasterEggH5Service.this.mHttpRule != null ? EasterEggH5Service.this.mHttpRule.a("reindeer_search") : null;
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("content", customResponsedMessage.getData());
                        EasterEggH5Service.this.onHitEventListener.a("reindeer_search", EasterEggH5Service.this.gson.toJson(a2), EasterEggH5Service.this.gson.toJson(jSONObject.toString()));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NetWorkParam) {
                NetWorkParam netWorkParam = (NetWorkParam) customResponsedMessage.getData();
                String a2 = EasterEggH5Service.this.mHttpRule != null ? EasterEggH5Service.this.mHttpRule.a(netWorkParam.mUrl) : null;
                if (a2 != null) {
                    HashMap hashMap = new HashMap();
                    if (!ListUtils.isEmpty(netWorkParam.mPostData)) {
                        for (int i = 0; i < netWorkParam.mPostData.size(); i++) {
                            if (netWorkParam.mPostData.get(i) != null) {
                                hashMap.put(netWorkParam.mPostData.get(i).getName(), netWorkParam.mPostData.get(i).getValue());
                            }
                        }
                    }
                    EasterEggH5Service.this.onHitEventListener.a(netWorkParam.mUrl, EasterEggH5Service.this.gson.toJson(a2), EasterEggH5Service.this.gson.toJson(EasterEggH5Service.this.gson.toJson(hashMap)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public d() {
        }

        @Override // d.b.j0.g0.d.b
        public void a(boolean z, d.b.j0.g0.e.a aVar) {
            if (z && aVar != null && !k.isEmpty(aVar.a()) && aVar.c()) {
                if (EasterEggH5Service.this.mWebView != null) {
                    EasterEggH5Service.this.mWebView.loadUrl(aVar.a());
                }
                HashMap<String, String> b2 = aVar.b();
                if (b2 != null) {
                    EasterEggH5Service.this.mHttpRule.d(b2);
                    EasterEggH5Service.this.mSocketRule.d(b2);
                    return;
                }
                return;
            }
            EasterEggH5Service.this.stopSelf();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends WebViewClient {
        public e() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.j0.d3.l0.c {
        public f() {
        }

        @Override // d.b.j0.d3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            return EasterEggH5Service.this.jsBridge != null && EasterEggH5Service.this.jsBridge.b(EasterEggH5Service.this.mWebView, str, jsPromptResult);
        }
    }

    private void initListenerAndRule() {
        this.onSearchEventListener.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.onSearchEventListener);
        this.onWriteReadListener.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.onWriteReadListener);
        d.b.j0.g0.g.a aVar = new d.b.j0.g0.g.a(0);
        this.mHttpRule = aVar;
        aVar.c(this.onHitEventListener);
        MessageManager.getInstance().addMessageRule(this.mHttpRule);
        d.b.j0.g0.g.b bVar = new d.b.j0.g0.g.b(0);
        this.mSocketRule = bVar;
        bVar.c(this.onHitEventListener);
        MessageManager.getInstance().addMessageRule(this.mSocketRule);
    }

    private void initWebView() {
        try {
            this.mWebView = new BaseWebView(this);
            this.jsBridge = new d.b.j0.d3.l0.a();
            this.mWebView.initCommonJsBridge(this);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mWebView.getSettings().setMixedContentMode(0);
            }
            this.mWebView.setWebViewClient(new e());
            EasterEggBridge easterEggBridge = new EasterEggBridge();
            this.eggBridge = easterEggBridge;
            this.jsBridge.a(easterEggBridge);
            this.mWebView.setOnJsPromptCallback(new f());
        } catch (Throwable th) {
            d.b.i0.r.z.a.a("img", -1L, 0, "easteregg_error", 0, th.getClass().getName(), "", "");
            TbadkCoreApplication.getInst().onLowMemory();
            stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadJsUrl(WebView webView, String str, String... strArr) {
        if (k.isEmpty(str)) {
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
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        initWebView();
        initListenerAndRule();
        d.b.j0.g0.d dVar = new d.b.j0.g0.d();
        this.model = dVar;
        dVar.d(new d());
        this.model.e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d.b.j0.g0.d dVar = this.model;
        if (dVar != null) {
            dVar.c();
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

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(KEY_URL);
            this.mUrl = stringExtra;
            if (!k.isEmpty(stringExtra)) {
                this.mWebView.loadUrl(this.mUrl);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
