package com.baidu.tieba.aiapps.apps.d;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieSyncManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements IAiAppConfigIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public boolean isDebug() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public boolean isRemoteDebug() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getAiAppsCommonAiUrl() {
        return getHostForHttps() + "/ma/ai";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getLowVersionUpgradePageUrl() {
        return getHostForHttps() + "/ma/tips";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getAiAppsResetUrl() {
        return getHostForHttps() + "/ma/reset";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getRecommendProductsUrl() {
        return getHostForHttps() + "/smtapp/ad/auto";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getRecommendSimilarUrl() {
        return getHostForHttps() + "/smtapp/ad/similar";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getHostForHttps() {
        return c.getHost();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getAiAppsUpdateUrl() {
        return getHostForHttps() + "/ma/update";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getAiAppFormIdUrl() {
        return getHostForHttps() + "/ma/formid/new";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public long getServerTimeDelta() {
        return 0L;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public CookieManager getCookieManager(boolean z, boolean z2) {
        return new CookieManager() { // from class: com.baidu.tieba.aiapps.apps.d.a.1
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

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getCommitId() {
        return AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getBuildTime() {
        return AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public boolean disableJsPromptS() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public void initMobstat() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getZeusVersion(Context context) {
        return AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc
    public String getHostName() {
        return b.getHostName();
    }
}
