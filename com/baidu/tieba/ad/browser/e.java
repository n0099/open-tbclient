package com.baidu.tieba.ad.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.AdTbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ao;
import com.baidu.webkit.internal.ETAG;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String ah(String str, String str2) {
        String str3;
        if (!str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://".concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void b(Context context, boolean z, String str, String str2) {
        a(context, str2, str, true, true, true, true, z);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        vG();
        try {
            if (!StringUtils.isNull(str2)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AdTbWebViewActivityConfig(context, str, z5 ? appendVersionCode(appendCuidParam(str2)) : str2, z, z2, z3)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void af(Context context, String str) {
        String appendVersionCode = appendVersionCode(appendCuidParam(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(appendVersionCode));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static String appendCuidParam(String str) {
        if (!ao.isEmpty(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            if (!UtilHelper.isNativeAdURL(str)) {
                sb.append("cuid=");
                sb.append(TbadkCoreApplication.getInst().getCuid());
                sb.append("&cuid_galaxy2=");
                sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                sb.append("&cuid_gid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGid());
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (ao.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? str + "&_client_version=" + TbConfig.getVersion() : str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00b3 -> B:33:0x001c). Please submit an issue!!! */
    public static void bo(Context context) {
        CookieManager cookieManager;
        a.b dJ = com.baidu.tbadk.core.a.a.wF().dJ(TbadkCoreApplication.getCurrentBduss());
        try {
            CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager != null) {
            if (dJ != null) {
                cookieManager.setAcceptCookie(true);
                cookieManager.setCookie("baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + "; domain=.baidu.com; cuid_galaxy2=" + TbadkCoreApplication.getInst().getCuidGalaxy2() + "; cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(c)) {
                    sb.append("STOKEN=").append(c).append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.removeAllCookies(null);
                        CookieManager.getInstance().flush();
                    } else {
                        cookieManager.removeAllCookie();
                        CookieSyncManager.createInstance(context);
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    private static void vG() {
        new ag("open_webview", true).start();
    }
}
