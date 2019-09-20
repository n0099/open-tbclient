package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.u.b.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.R;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes4.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar);

        void onFinish();

        void onStart();
    }

    /* loaded from: classes4.dex */
    public static class b {
        public String dcY;
        public Map<String, String> dcZ;
        public int mErrCode;
        public String mErrMsg;
    }

    public static String o(Context context, String str, String str2) {
        return com.baidu.swan.apps.storage.b.f.Ob().getString(str, str2);
    }

    public static Map<String, String> a(Context context, @NonNull Set<String> set) {
        HashMap hashMap = new HashMap();
        for (String str : set) {
            hashMap.put(str, "");
        }
        return j(context, hashMap);
    }

    public static String dl(Context context) {
        return ProcessUtils.isMainProcess() ? dn(context) : dm(context);
    }

    public static String dm(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String dn(Context context) {
        return !aFe() ? "" : TbadkCoreApplication.getCurrentBduss();
    }

    /* renamed from: do  reason: not valid java name */
    public static String m20do(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, i.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String aE(Context context) {
        return !aFe() ? "" : TbadkCoreApplication.getCurrentAccount();
    }

    public static String dp(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, f.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String dq(Context context) {
        return !aFe() ? "" : TbadkCoreApplication.getInst().getCuidGalaxy2();
    }

    public static boolean dr(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, k.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static boolean aD(Context context) {
        if (aFe()) {
            return TbadkCoreApplication.isLogin();
        }
        return false;
    }

    public static void a(Activity activity, boolean z, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            a(activity, bundle, aVar);
        } else {
            b(activity, z, bundle, aVar);
        }
    }

    public static void b(Activity activity, boolean z, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("key_login_force", z);
        bundle2.putBundle("key_login_params", bundle);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, l.class, bundle2, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.a.c.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (com.baidu.swan.apps.a.a.this != null) {
                    if (!delegateResult.isOk()) {
                        com.baidu.swan.apps.a.a.this.onResult(-1);
                        return;
                    }
                    com.baidu.swan.apps.a.a.this.onResult(delegateResult.mResult.getInt("result_code", -1));
                }
            }
        });
    }

    public static void a(Context context, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        int i;
        if (!aFe()) {
            aVar.onResult(-1);
            return;
        }
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
        loginActivityConfig.getIntent().putExtra("close", true);
        if (bundle != null && (i = bundle.getInt("key_login_mode", 1)) > 1) {
            if (i == 4) {
                i = 1;
            }
            loginActivityConfig.setIsFromAiapp(true);
            loginActivityConfig.setThirdPartyLoginForResult(i, "");
        }
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921362) { // from class: com.baidu.tieba.aiapps.apps.a.c.2
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

    private static boolean aFe() {
        return ProcessUtils.isMainProcess();
    }

    public static void a(com.baidu.swan.apps.a.c cVar) {
        com.baidu.tieba.aiapps.apps.a.a.aFc().a(cVar);
    }

    public static void a(String str, final c.a aVar) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.u.a.EL().Fj()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.tieba.aiapps.apps.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(c.c(response.body().byteStream(), Xml.Encoding.UTF_8.toString()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    com.baidu.swan.apps.console.c.e("AccountUtils", "Response is null");
                    c.a.this.aX(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    c.a.this.aX(true);
                } else {
                    c.a.this.aX(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                c.a.this.k(exc);
            }
        });
    }

    public static void b(final Activity activity, JSONObject jSONObject) {
        JSONObject af = com.baidu.swan.apps.setting.oauth.c.af(jSONObject);
        if (af != null && activity != null) {
            int optInt = af.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
            final String optString = af.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = af.optJSONObject("tipoption");
                final String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.a.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            c.c(activity, optString2, optString);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Activity activity, String str, String str2) {
        new g.a(activity).d(str).gE(str2).a(new com.baidu.swan.apps.view.b.a()).ce(true).c(activity.getString(R.string.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.a.c.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.a(activity, true, null, null);
            }
        }).d(activity.getString(R.string.aiapps_login_refuse), null).LB();
    }

    public static String c(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                com.baidu.swan.c.a.c(inputStream);
            } finally {
                com.baidu.swan.c.a.c(inputStream);
            }
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
        }
        return sb.toString();
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
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, g.class, bundle);
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

    public static void a(Context context, com.baidu.swan.apps.an.d.a<Bundle> aVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            b(context, aVar, strArr);
        } else {
            a(aVar, strArr);
        }
    }

    public static void a(final com.baidu.swan.apps.an.d.a<Bundle> aVar, String... strArr) {
        if (strArr == null || strArr.length < 1) {
            aVar.D(null);
            return;
        }
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null) {
            aVar.D(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a DE = Mh.DE();
        if (DE == null) {
            aVar.D(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("key_param_tpl_list", strArr);
        DE.a(bundle, h.class, new com.baidu.swan.apps.process.b.b.c.b() { // from class: com.baidu.tieba.aiapps.apps.a.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.b.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.b.b.a.b bVar) {
                if (c.DEBUG) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle2 = null;
                if (bVar.getResult() != null) {
                    if (c.DEBUG) {
                        Log.d("AccountUtils", "get stoken : result " + bVar.getResult());
                    }
                    bundle2 = bVar.getResult().getBundle("key_result_stokent");
                } else if (c.DEBUG) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                com.baidu.swan.apps.an.d.a.this.D(bundle2);
            }

            @Override // com.baidu.swan.apps.process.b.b.c.b, com.baidu.swan.apps.process.b.b.c.a
            public long getTimeoutMillis() {
                return StatisticConfig.MIN_UPLOAD_INTERVAL;
            }
        });
    }

    public static void b(Context context, final com.baidu.swan.apps.an.d.a<Bundle> aVar, @Nullable String... strArr) {
        if (!aFe()) {
            throw new IllegalStateException("must call in MainProcess");
        }
        a(new a() { // from class: com.baidu.tieba.aiapps.apps.a.c.7
            @Override // com.baidu.tieba.aiapps.apps.a.c.a
            public void a(b bVar) {
                if (bVar.mErrCode != 0 || bVar.dcZ == null) {
                    com.baidu.swan.apps.an.d.a.this.D(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : bVar.dcZ.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                com.baidu.swan.apps.an.d.a.this.D(bundle);
            }

            @Override // com.baidu.tieba.aiapps.apps.a.c.a
            public void b(b bVar) {
                com.baidu.swan.apps.an.d.a.this.D(null);
            }

            @Override // com.baidu.tieba.aiapps.apps.a.c.a
            public void onStart() {
            }

            @Override // com.baidu.tieba.aiapps.apps.a.c.a
            public void onFinish() {
            }
        }, dl(context), strArr == null ? Collections.emptyList() : Arrays.asList(strArr));
    }

    private static void a(final a aVar, String str, List<String> list) {
        if (!TextUtils.isEmpty(str)) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.tieba.aiapps.apps.a.c.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (a.this != null) {
                        b bVar = new b();
                        if (getTplStokenResult != null) {
                            bVar.dcZ = getTplStokenResult.tplStokenMap;
                            bVar.mErrCode = getTplStokenResult.getResultCode();
                            bVar.mErrMsg = getTplStokenResult.getResultMsg();
                            if (getTplStokenResult.failureType != null) {
                                bVar.dcY = getTplStokenResult.failureType.name();
                            }
                        }
                        a.this.a(bVar);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    if (a.this != null) {
                        b bVar = new b();
                        if (getTplStokenResult != null) {
                            bVar.dcZ = getTplStokenResult.tplStokenMap;
                            bVar.mErrCode = getTplStokenResult.getResultCode();
                            bVar.mErrMsg = getTplStokenResult.getResultMsg();
                            if (getTplStokenResult.failureType != null) {
                                bVar.dcY = getTplStokenResult.failureType.name();
                            }
                        }
                        a.this.b(bVar);
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    if (a.this != null) {
                        a.this.onStart();
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    if (a.this != null) {
                        a.this.onFinish();
                    }
                }
            }, str, list);
        }
    }

    public static String ds(Context context) {
        return !ProcessUtils.isMainProcess() ? dt(context) : getZid(context);
    }

    public static String dt(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getZid(Context context) {
        long j = 0;
        if (DEBUG) {
            j = System.currentTimeMillis();
        }
        String gz = FH.gz(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(gz) && gz.contains("|")) {
            if (DEBUG) {
                throw new RuntimeException("getZid zid contains | zid:" + gz);
            }
            gz = null;
        }
        if (DEBUG) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.w("AccountUtils", "getZid start:" + j + ",end:" + currentTimeMillis + ",totalTime:" + (currentTimeMillis - j) + ";zid:" + gz);
        }
        return gz;
    }
}
