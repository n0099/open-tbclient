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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.a.g;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.easterEgg.e;
import com.google.gson.Gson;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class EasterEggH5Service extends Service {
    private static String KEY_URL = "url";
    private a eggBridge;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private com.baidu.tieba.easterEgg.c.a mHttpRule;
    private com.baidu.tieba.easterEgg.c.b mSocketRule;
    private BaseWebView mWebView;
    private e model;
    private String mUrl = null;
    private BdUniqueId mTag = BdUniqueId.gen();
    private Gson gson = new Gson();
    private d onHitEventListener = new d() { // from class: com.baidu.tieba.easterEgg.EasterEggH5Service.1
        @Override // com.baidu.tieba.easterEgg.d
        public void ao(String str, String str2, String str3) {
            if (EasterEggH5Service.this.mWebView != null) {
                EasterEggH5Service.this.loadJsUrl(EasterEggH5Service.this.mWebView, "receiveEvent", str2, str3);
            }
        }
    };
    private CustomMessageListener onSearchEventListener = new CustomMessageListener(CmdConfigCustom.CMD_TURN_TAB_LOC) { // from class: com.baidu.tieba.easterEgg.EasterEggH5Service.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            if (customResponsedMessage.getData() instanceof String) {
                if (EasterEggH5Service.this.mHttpRule != null) {
                    str = EasterEggH5Service.this.mHttpRule.Ed("reindeer_search");
                } else {
                    str = null;
                }
                if (str != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("content", customResponsedMessage.getData());
                        EasterEggH5Service.this.onHitEventListener.ao("reindeer_search", EasterEggH5Service.this.gson.toJson(str), EasterEggH5Service.this.gson.toJson(jSONObject.toString()));
                    } catch (JSONException e) {
                    }
                }
            }
        }
    };
    private CustomMessageListener onWriteReadListener = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.easterEgg.EasterEggH5Service.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            if (customResponsedMessage.getData() instanceof g) {
                g gVar = (g) customResponsedMessage.getData();
                if (EasterEggH5Service.this.mHttpRule != null) {
                    str = EasterEggH5Service.this.mHttpRule.Ed(gVar.mUrl);
                } else {
                    str = null;
                }
                if (str != null) {
                    HashMap hashMap = new HashMap();
                    if (!w.isEmpty(gVar.mPostData)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= gVar.mPostData.size()) {
                                break;
                            }
                            if (gVar.mPostData.get(i2) != null) {
                                hashMap.put(gVar.mPostData.get(i2).getName(), gVar.mPostData.get(i2).getValue());
                            }
                            i = i2 + 1;
                        }
                    }
                    EasterEggH5Service.this.onHitEventListener.ao(gVar.mUrl, EasterEggH5Service.this.gson.toJson(str), EasterEggH5Service.this.gson.toJson(EasterEggH5Service.this.gson.toJson(hashMap)));
                }
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra(KEY_URL);
            if (!ar.isEmpty(this.mUrl)) {
                this.mWebView.loadUrl(this.mUrl);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        initWebView();
        initListenerAndRule();
        this.model = new e();
        this.model.a(new e.a() { // from class: com.baidu.tieba.easterEgg.EasterEggH5Service.4
            @Override // com.baidu.tieba.easterEgg.e.a
            public void a(boolean z, com.baidu.tieba.easterEgg.a.a aVar) {
                if (z && aVar != null && !ar.isEmpty(aVar.bQB()) && aVar.isOpen()) {
                    if (EasterEggH5Service.this.mWebView != null) {
                        EasterEggH5Service.this.mWebView.loadUrl(aVar.bQB());
                    }
                    HashMap<String, String> bQA = aVar.bQA();
                    if (bQA != null) {
                        EasterEggH5Service.this.mHttpRule.H(bQA);
                        EasterEggH5Service.this.mSocketRule.H(bQA);
                        return;
                    }
                    return;
                }
                EasterEggH5Service.this.stopSelf();
            }
        });
        this.model.startLoad();
    }

    private void initListenerAndRule() {
        this.onSearchEventListener.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.onSearchEventListener);
        this.onWriteReadListener.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.onWriteReadListener);
        this.mHttpRule = new com.baidu.tieba.easterEgg.c.a(0);
        this.mHttpRule.a(this.onHitEventListener);
        MessageManager.getInstance().addMessageRule(this.mHttpRule);
        this.mSocketRule = new com.baidu.tieba.easterEgg.c.b(0);
        this.mSocketRule.a(this.onHitEventListener);
        MessageManager.getInstance().addMessageRule(this.mSocketRule);
    }

    private void initWebView() {
        try {
            this.mWebView = new BaseWebView(this);
            this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
            this.mWebView.initCommonJsBridge(this);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mWebView.getSettings().setMixedContentMode(0);
            }
            this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.easterEgg.EasterEggH5Service.5
                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                }
            });
            this.eggBridge = new a();
            this.jsBridge.a(this.eggBridge);
            this.mWebView.setOnJsPromptCallback(new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.EasterEggH5Service.6
                @Override // com.baidu.tieba.tbadkCore.e.c
                public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                    return EasterEggH5Service.this.jsBridge != null && EasterEggH5Service.this.jsBridge.a(str, jsPromptResult);
                }
            });
        } catch (Throwable th) {
            com.baidu.tbadk.core.d.a.a("img", -1L, 0, "easteregg_error", 0, th.getClass().getName(), "", "");
            TbadkCoreApplication.getInst().onLowMemory();
            stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadJsUrl(WebView webView, String str, String... strArr) {
        if (!ar.isEmpty(str)) {
            String str2 = "javascript:" + str + "(";
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    str2 = str2 + strArr[i];
                    if (i != strArr.length - 1) {
                        str2 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    }
                }
            }
            String str3 = str2 + ")";
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript(str3, null);
            } else {
                webView.loadUrl(str3);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.model != null) {
            this.model.onDestroy();
        }
        if (this.eggBridge != null) {
            this.eggBridge.clearListener();
        }
        MessageManager.getInstance().removeMessageRule(this.mHttpRule);
        MessageManager.getInstance().removeMessageRule(this.mSocketRule);
        MessageManager.getInstance().unRegisterListener(this.mTag);
        super.onDestroy();
    }
}
