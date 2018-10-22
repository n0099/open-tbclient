package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.AiAppsCookieManager;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppStreamUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    public static String cf(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, c.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getBduss(Context context) {
        return !Wl() ? "" : TbadkCoreApplication.getCurrentBduss();
    }

    public static String cg(Context context) {
        AiApp aiApp = AiApp.get();
        if (aiApp == null) {
            return "";
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add("uid");
        return aiApp.getAccount().getSessions(context, treeSet).get("uid");
    }

    public static String getUid(Context context) {
        return !Wl() ? "" : TbadkCoreApplication.getCurrentAccount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSession(Context context, String str, String str2) {
        return !Wl() ? str2 : SapiAccountManager.getInstance().getSession(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle f(Context context, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("key_list", arrayList);
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.class, bundle);
        if (callOnMainWithContentProvider.isOk()) {
            return callOnMainWithContentProvider.mResult;
        }
        return null;
    }

    public static String getPortraitUrl() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentPortrait())) {
            return "";
        }
        return TbConfig.PHOTO_BIG_ADDRESS + TbadkCoreApplication.getCurrentPortrait();
    }

    public static String Wk() {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(TbadkCoreApplication.getInst(), e.class, null);
        if (!callOnMainWithContentProvider.isOk() || callOnMainWithContentProvider.mResult == null) {
            return null;
        }
        return callOnMainWithContentProvider.mResult.getString("result");
    }

    public static String ch(Context context) {
        if (Wl()) {
            return TbadkCoreApplication.getCurrentAccountNameShow();
        }
        return null;
    }

    public static void a(Activity activity, final TypedCallback<Bundle> typedCallback, String... strArr) {
        Bundle bundle = new Bundle();
        bundle.putStringArray("param_tpl_list", strArr);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, g.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.a.b.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                TypedCallback.this.onCallback(delegateResult.isOk() ? delegateResult.mResult : null);
            }
        });
    }

    public static void a(Context context, final TypedCallback<Bundle> typedCallback, @Nullable String... strArr) {
        if (!Wl()) {
            throw new IllegalStateException("must call in MainProcess");
        }
        if (strArr == null) {
            strArr = new String[]{OAuthDef.TPL};
        }
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.tieba.aiapps.apps.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                if (getTplStokenResult == null) {
                    TypedCallback.this.onCallback(null);
                    return;
                }
                Map<String, String> map = getTplStokenResult.tplStokenMap;
                if (map == null || map.size() <= 0) {
                    if (TypedCallback.this != null) {
                        TypedCallback.this.onCallback(null);
                        return;
                    }
                    return;
                }
                String str = map.get(OAuthDef.TPL);
                if (StringUtils.isNULL(str)) {
                    if (TypedCallback.this != null) {
                        TypedCallback.this.onCallback(null);
                        return;
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(OAuthDef.TPL, str);
                TypedCallback.this.onCallback(bundle);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (TypedCallback.this != null) {
                    TypedCallback.this.onCallback(null);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, getBduss(TbadkCoreApplication.getInst()), Arrays.asList(strArr));
    }

    public static boolean ci(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, i.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static boolean isLogin(Context context) {
        if (Wl()) {
            return TbadkCoreApplication.isLogin();
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static void a(Activity activity, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        a(activity, AlbumActivityConfig.FROM_AIAPPS, onAiAppLoginResultListener);
    }

    public static void a(Activity activity, String str, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        a(activity, str, false, onAiAppLoginResultListener);
    }

    public static void a(Activity activity, String str, boolean z, final OnAiAppLoginResultListener onAiAppLoginResultListener) {
        Bundle bundle = new Bundle();
        bundle.putString("key_login_source", str);
        bundle.putBoolean("key_login_force", z);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, j.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.a.b.3
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (OnAiAppLoginResultListener.this != null) {
                    if (!delegateResult.isOk()) {
                        OnAiAppLoginResultListener.this.onResult(-1);
                        return;
                    }
                    int i = delegateResult.mResult.getInt("result_code", -1);
                    OnAiAppLoginResultListener.this.onResult(i);
                    b.hn(i);
                }
            }
        });
    }

    public static void login(Activity activity, String str, final OnAiAppLoginResultListener onAiAppLoginResultListener) {
        if (!Wl()) {
            onAiAppLoginResultListener.onResult(-1);
            return;
        }
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(activity, true, -1);
        loginActivityConfig.getIntent().putExtra("close", true);
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921362) { // from class: com.baidu.tieba.aiapps.apps.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    onAiAppLoginResultListener.onResult(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        });
    }

    public static void a(Activity activity, int i, String str, final OnAiAppLoginResultListener onAiAppLoginResultListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_login_mode", i);
        bundle.putString("key_login_source", str);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, k.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.a.b.5
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (OnAiAppLoginResultListener.this != null) {
                    if (!delegateResult.isOk()) {
                        OnAiAppLoginResultListener.this.onResult(-1);
                        return;
                    }
                    int i2 = delegateResult.mResult.getInt("result_code", -1);
                    OnAiAppLoginResultListener.this.onResult(i2);
                    b.hn(i2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(int i) {
        boolean z = i == 0;
        String str = "";
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            str = aiApp.getAppKey();
        }
        AiAppsUBCStatistic.onLogin(z, str);
    }

    public static void thirdLogin(Activity activity, int i, String str, OnAiAppLoginResultListener onAiAppLoginResultListener) {
    }

    private static boolean Wl() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void developerAuthentication(String str, final IAiAppAccountIoc.CheckDeveloperCallback checkDeveloperCallback) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(new AiAppsCookieManager(false)).addUrlParam(AiAppsApsUtils.APP_KEY, str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.tieba.aiapps.apps.a.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(AiAppStreamUtils.streamToString(response.body().byteStream()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    AiAppsLog.e("AccountUtils", "Response is null");
                    IAiAppAccountIoc.CheckDeveloperCallback.this.onCheckSuccess(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    IAiAppAccountIoc.CheckDeveloperCallback.this.onCheckSuccess(true);
                } else {
                    IAiAppAccountIoc.CheckDeveloperCallback.this.onCheckSuccess(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                IAiAppAccountIoc.CheckDeveloperCallback.this.onCheckFail(exc);
            }
        });
    }

    public static void developerAuthentication(IAiAppAccountIoc.CheckDeveloperCallback checkDeveloperCallback) {
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            developerAuthentication(aiApp.getAppKey(), checkDeveloperCallback);
        }
    }
}
