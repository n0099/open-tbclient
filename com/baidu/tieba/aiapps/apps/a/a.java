package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.u.b.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    private static CookieManager cRd;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Object cRe = new Object();

    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0260a {
        void a(b bVar);

        void b(b bVar);

        void onFinish();

        void onStart();
    }

    /* loaded from: classes4.dex */
    public static class b {
        public String cRi;
        public Map<String, String> cRj;
        public int mErrCode;
        public String mErrMsg;
    }

    public static String dB(Context context) {
        return ProcessUtils.isMainProcess() ? dD(context) : dC(context);
    }

    public static String dC(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, com.baidu.tieba.aiapps.apps.a.b.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String dD(Context context) {
        return !ayb() ? "" : TbadkCoreApplication.getCurrentBduss();
    }

    public static String dE(Context context) {
        if (com.baidu.swan.apps.ae.b.IX() == null) {
            return "";
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add("uid");
        return a(context, treeSet).get("uid");
    }

    public static String bl(Context context) {
        return !ayb() ? "" : TbadkCoreApplication.getCurrentAccount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Context context, String str, String str2) {
        return !ayb() ? str2 : SapiAccountManager.getInstance().getSession(str);
    }

    public static Map<String, String> a(Context context, @NonNull Set<String> set) {
        HashMap hashMap = new HashMap();
        for (String str : set) {
            hashMap.put(str, "");
        }
        return j(context, hashMap);
    }

    public static Map<String, String> j(Context context, @NonNull Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                String value = entry.getValue();
                if (TextUtils.isEmpty(value)) {
                    value = "";
                }
                bundle.putString(key, value);
            }
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, c.class, bundle);
        HashMap hashMap = new HashMap(map);
        if (callOnMainWithContentProvider.isOk()) {
            for (String str : callOnMainWithContentProvider.mResult.keySet()) {
                String str2 = map.get(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                hashMap.put(str, callOnMainWithContentProvider.mResult.getString(str, str2));
            }
        }
        return hashMap;
    }

    public static void a(Activity activity, com.baidu.swan.apps.an.c.a<Bundle> aVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            a((Context) activity, aVar, strArr);
        } else {
            a(aVar, strArr);
        }
    }

    public static void a(final com.baidu.swan.apps.an.c.a<Bundle> aVar, String... strArr) {
        if (strArr == null || strArr.length < 1) {
            aVar.D(null);
            return;
        }
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX == null) {
            aVar.D(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a BR = IX.BR();
        if (BR == null) {
            aVar.D(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("key_param_tpl_list", strArr);
        BR.a(bundle, d.class, new com.baidu.swan.apps.process.b.b.c.b() { // from class: com.baidu.tieba.aiapps.apps.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.b.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle2 = null;
                if (bVar.getResult() != null) {
                    if (a.DEBUG) {
                        Log.d("AccountUtils", "get stoken : result " + bVar.getResult());
                    }
                    bundle2 = bVar.getResult().getBundle("key_result_stokent");
                } else if (a.DEBUG) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                com.baidu.swan.apps.an.c.a.this.D(bundle2);
            }

            @Override // com.baidu.swan.apps.process.b.b.c.b, com.baidu.swan.apps.process.b.b.c.a
            public long getTimeoutMillis() {
                return StatisticConfig.MIN_UPLOAD_INTERVAL;
            }
        });
    }

    public static void a(Context context, final com.baidu.swan.apps.an.c.a<Bundle> aVar, @Nullable String... strArr) {
        if (!ayb()) {
            throw new IllegalStateException("must call in MainProcess");
        }
        a(new InterfaceC0260a() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.tieba.aiapps.apps.a.a.InterfaceC0260a
            public void a(b bVar) {
                if (bVar.mErrCode != 0 || bVar.cRj == null) {
                    com.baidu.swan.apps.an.c.a.this.D(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : bVar.cRj.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                com.baidu.swan.apps.an.c.a.this.D(bundle);
            }

            @Override // com.baidu.tieba.aiapps.apps.a.a.InterfaceC0260a
            public void b(b bVar) {
                com.baidu.swan.apps.an.c.a.this.D(null);
            }

            @Override // com.baidu.tieba.aiapps.apps.a.a.InterfaceC0260a
            public void onStart() {
            }

            @Override // com.baidu.tieba.aiapps.apps.a.a.InterfaceC0260a
            public void onFinish() {
            }
        }, dB(context), strArr == null ? Collections.emptyList() : Arrays.asList(strArr));
    }

    private static void a(final InterfaceC0260a interfaceC0260a, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                if (InterfaceC0260a.this != null) {
                    b bVar = new b();
                    if (getTplStokenResult != null) {
                        bVar.cRj = getTplStokenResult.tplStokenMap;
                        bVar.mErrCode = getTplStokenResult.getResultCode();
                        bVar.mErrMsg = getTplStokenResult.getResultMsg();
                        if (getTplStokenResult.failureType != null) {
                            bVar.cRi = getTplStokenResult.failureType.name();
                        }
                    }
                    InterfaceC0260a.this.a(bVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (InterfaceC0260a.this != null) {
                    b bVar = new b();
                    if (getTplStokenResult != null) {
                        bVar.cRj = getTplStokenResult.tplStokenMap;
                        bVar.mErrCode = getTplStokenResult.getResultCode();
                        bVar.mErrMsg = getTplStokenResult.getResultMsg();
                        if (getTplStokenResult.failureType != null) {
                            bVar.cRi = getTplStokenResult.failureType.name();
                        }
                    }
                    InterfaceC0260a.this.b(bVar);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                if (InterfaceC0260a.this != null) {
                    InterfaceC0260a.this.onStart();
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                if (InterfaceC0260a.this != null) {
                    InterfaceC0260a.this.onFinish();
                }
            }
        }, str, list);
    }

    public static boolean dF(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, f.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static boolean bk(Context context) {
        if (ayb()) {
            return TbadkCoreApplication.isLogin();
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static void a(Activity activity, com.baidu.swan.apps.a.a aVar) {
        a(activity, AlbumActivityConfig.FROM_AIAPPS, aVar);
    }

    public static void a(Activity activity, String str, com.baidu.swan.apps.a.a aVar) {
        a(activity, str, false, aVar);
    }

    public static void a(Activity activity, String str, boolean z, final com.baidu.swan.apps.a.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("key_login_source", str);
        bundle.putBoolean("key_login_force", z);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, g.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.5
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (com.baidu.swan.apps.a.a.this != null) {
                    if (!delegateResult.isOk()) {
                        com.baidu.swan.apps.a.a.this.onResult(-1);
                        return;
                    }
                    int i = delegateResult.mResult.getInt("result_code", -1);
                    com.baidu.swan.apps.a.a.this.onResult(i);
                    a.lG(i);
                }
            }
        });
    }

    public static void b(Activity activity, String str, final com.baidu.swan.apps.a.a aVar) {
        if (!ayb()) {
            aVar.onResult(-1);
            return;
        }
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(activity, true, -1);
        loginActivityConfig.getIntent().putExtra("close", true);
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921362) { // from class: com.baidu.tieba.aiapps.apps.a.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    aVar.onResult(((Integer) customResponsedMessage.getData()).intValue());
                    Log.e("ssss", String.valueOf(customResponsedMessage.getData()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lG(int i) {
        boolean z = i == 0;
        String str = "";
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            str = IX.getAppKey();
        }
        com.baidu.swan.apps.statistic.c.f(z, str);
    }

    private static boolean ayb() {
        return ProcessUtils.isMainProcess();
    }

    public static void a(String str, final c.a aVar) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.u.a.CV().Dt()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.tieba.aiapps.apps.a.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(com.baidu.swan.c.e.m(response.body().byteStream()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    com.baidu.swan.apps.console.c.e("AccountUtils", "Response is null");
                    c.a.this.aS(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    c.a.this.aS(true);
                } else {
                    c.a.this.aS(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                c.a.this.k(exc);
            }
        });
    }

    public static CookieManager Dp() {
        if (cRd == null) {
            synchronized (cRe) {
                if (cRd == null) {
                    cRd = new CookieManager() { // from class: com.baidu.tieba.aiapps.apps.a.a.8
                        @Override // com.baidu.searchbox.http.cookie.CookieManager
                        public boolean shouldAcceptCookie(String str, String str2) {
                            return true;
                        }

                        @Override // com.baidu.searchbox.http.cookie.CookieManager
                        public boolean shouldSendCookie(String str, String str2) {
                            return true;
                        }

                        @Override // com.baidu.searchbox.http.cookie.CookieManager
                        public void storeCookie(String str, List<String> list) {
                            try {
                                android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
                                StringBuilder sb = new StringBuilder();
                                for (String str2 : list) {
                                    sb.append(str2).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                }
                                cookieManager.setCookie(str, sb.toString());
                                if (Build.VERSION.SDK_INT >= 21) {
                                    cookieManager.flush();
                                } else {
                                    CookieSyncManager.createInstance(TbadkCoreApplication.getInst()).startSync();
                                }
                            } catch (Throwable th) {
                                BdLog.e(th);
                            }
                        }

                        @Override // com.baidu.searchbox.http.cookie.CookieManager
                        public String getCookie(String str) {
                            try {
                                android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
                                if (cookieManager == null) {
                                    return null;
                                }
                                return cookieManager.getCookie(str);
                            } catch (Throwable th) {
                                try {
                                    BdLog.e(th);
                                    return null;
                                } catch (Throwable th2) {
                                    BdLog.e(th2);
                                    return "";
                                }
                            }
                        }
                    };
                }
            }
        }
        return cRd;
    }

    public static void a(final Activity activity, JSONObject jSONObject) {
        JSONObject ae = com.baidu.swan.apps.setting.oauth.c.ae(jSONObject);
        if (ae != null && activity != null) {
            int optInt = ae.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
            final String optString = ae.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = ae.optJSONObject("tipoption");
                final String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.a.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.c(activity, optString2, optString);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Activity activity, String str, String str2) {
        new e.a(activity).d(str).gd(str2).a(new com.baidu.swan.apps.view.b.a()).bR(true).c(activity.getString(d.j.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.c(activity, "key_login_source", (com.baidu.swan.apps.a.a) null);
            }
        }).d(activity.getString(d.j.aiapps_login_refuse), null).Iu();
    }

    public static void c(Activity activity, String str, com.baidu.swan.apps.a.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            b(activity, str, aVar);
        } else {
            a(activity, str, aVar);
        }
    }
}
