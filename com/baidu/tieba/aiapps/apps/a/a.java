package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.browser.BrowserType;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.SwanNative;
import com.baidu.searchbox.ng.ai.apps.account.AiAppAccountStatusChangedListener;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements IAiAppAccountIoc {
    private static String bBL = " swan/1.6";
    private final List<AiAppAccountStatusChangedListener> bBM = new LinkedList();
    private String bBN = null;

    public a() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.aiapps.apps.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean isNULL = StringUtils.isNULL(a.this.getUid(TbadkCoreApplication.getInst()));
                synchronized (a.this.bBM) {
                    for (AiAppAccountStatusChangedListener aiAppAccountStatusChangedListener : a.this.bBM) {
                        aiAppAccountStatusChangedListener.onLoginStatusChanged(isNULL, !isNULL);
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void login(Activity activity, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            b.login(activity, AlbumActivityConfig.FROM_AIAPPS, onAiAppLoginResultListener);
        } else {
            b.a(activity, onAiAppLoginResultListener);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void login(Activity activity, String str, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            b.login(activity, str, onAiAppLoginResultListener);
        } else {
            b.a(activity, str, onAiAppLoginResultListener);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void login(Activity activity, String str, boolean z, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            b.login(activity, str, onAiAppLoginResultListener);
        } else {
            b.a(activity, str, z, onAiAppLoginResultListener);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void thirdLogin(Activity activity, int i, String str, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            b.thirdLogin(activity, i, str, onAiAppLoginResultListener);
        } else {
            b.a(activity, i, str, onAiAppLoginResultListener);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public boolean isLogin(Context context) {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? b.isLogin(context) : b.cf(context);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getBduss(Context context) {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? b.getBduss(context) : b.cc(context);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public Map<String, String> getSessions(Context context, @NonNull Map<String, String> map) {
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
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, f.class, bundle);
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

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getSession(Context context, String str, String str2) {
        return b.getSession(context, str, str2);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public Bundle getUserInfo(Context context, String str) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_uid", str);
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, h.class, bundle2);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult : bundle;
        }
        return bundle;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public Bundle getLoginInfo(Context context, ArrayList<String> arrayList) {
        return b.f(context, arrayList);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void getTplStoken(Activity activity, TypedCallback<Bundle> typedCallback, @Nullable String... strArr) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            b.a((Context) activity, typedCallback, strArr);
        } else {
            b.a(activity, typedCallback, strArr);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getUid(Context context) {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? b.getUid(context) : b.cd(context);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getCuid(Context context) {
        return TbadkCoreApplication.getInst().getCuid();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getEnCuid() {
        if (this.bBN == null && !StringUtils.isNULL(getUid(TbadkCoreApplication.getInst()))) {
            this.bBN = new String(Base64Encoder.B64Encode(getCuid(TbadkCoreApplication.getInst()).getBytes()));
        }
        return this.bBN;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getPortraitUrl() {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? b.getPortraitUrl() : b.Wu();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void developerAuthentication(IAiAppAccountIoc.CheckDeveloperCallback checkDeveloperCallback) {
        b.developerAuthentication(checkDeveloperCallback);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void developerAuthentication(String str, IAiAppAccountIoc.CheckDeveloperCallback checkDeveloperCallback) {
        b.developerAuthentication(str, checkDeveloperCallback);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String processUrl(String str) {
        return com.baidu.tieba.aiapps.apps.d.c.ke(str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public List<String> getAuthorizedDomains(Context context) {
        return SapiUtils.getAuthorizedDomains(context);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String buildBDUSSCookie(String str, String str2) {
        return SapiUtils.buildBDUSSCookie(str, str2);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getAccountCookieStr(String str, String str2, String str3, long j) {
        return str2 + ETAG.EQUAL + str3 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "domain=" + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "path=/;max-age=" + j + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void setCookieManualWithBdussOperate(String str, String str2, boolean z, String str3) {
        try {
            CookieManager.getInstance().setCookie(str, str2);
            if (z) {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.createInstance(TbadkCoreApplication.getInst()).sync();
                }
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public void addLoginStatusChangedListener(AiAppAccountStatusChangedListener aiAppAccountStatusChangedListener) {
        if (aiAppAccountStatusChangedListener != null) {
            synchronized (this.bBM) {
                if (!this.bBM.contains(aiAppAccountStatusChangedListener)) {
                    this.bBM.add(aiAppAccountStatusChangedListener);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public boolean enableHttpAndPort(Context context) {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getDeviceInfo() {
        return com.baidu.tieba.aiapps.apps.d.c.getDeviceInfo();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getIMEI() {
        return TbadkCoreApplication.getInst().getImei();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getAndroidId() {
        return Settings.Secure.getString(TbadkCoreApplication.getInst().getContentResolver(), "android_id");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getModel() {
        return com.baidu.tieba.aiapps.apps.d.c.Xh();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getWifiInfo() {
        try {
            return ((WifiManager) TbadkCoreApplication.getInst().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String getHostApiKey() {
        return "flFqXclepWs7RdugAszy9eERL7G5dS0I";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc
    public String processUserAgent(String str, BrowserType browserType) {
        if (str != null && browserType != null) {
            switch (browserType) {
                case AI_APPS_MASTER:
                case AI_APPS_SLAVE:
                case AI_APPS_WEBVIEW:
                case AI_APPS_ADLANDING:
                    str = str + bBL;
                    break;
            }
            String str2 = "host/" + com.baidu.tieba.aiapps.apps.d.b.getHostName();
            return str.replaceFirst("(^.*$)", "$1 " + (str2 + " " + ("hostVersion/" + getVersionName(AppRuntime.getAppContext())) + " " + (SwanNative.getName() + "/" + SwanNative.getVersion()) + " (Baidu; P1 " + getOSVersion() + ")"));
        }
        return str;
    }

    private String getOSVersion() {
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            return "0.0";
        }
        return str.replace(BaseRequestAction.SPLITE, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    private String getVersionName(Context context) {
        return TbadkCoreApplication.getInst().getVersionName();
    }
}
