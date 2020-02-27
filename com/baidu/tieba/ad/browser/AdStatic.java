package com.baidu.tieba.ad.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdTbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.NewAdTbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity;
import com.baidu.tieba.ad.download.broadcast.AppNotificationReceiver;
import com.baidu.tieba.recapp.h;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class AdStatic {
    public static boolean cKE = true;

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AdTbWebViewActivityConfig.class, AdTbWebViewActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewAdTbWebViewActivityConfig.class, NewAdTbWebViewActivity.class);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tieba.ad.browser.AdStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    d.initCookie(TbadkCoreApplication.getInst());
                }
            }
        });
        h.c cVar = new h.c() { // from class: com.baidu.tieba.ad.browser.AdStatic.2
            @Override // com.baidu.tieba.recapp.h.c
            public int b(Context context, String str, String str2, boolean z, h.d dVar, boolean z2) {
                if (z2) {
                    AdStatic.c(context, str2, null, false, true, true, true);
                    return 0;
                }
                AdStatic.a(context, str2, str, z, true, true, true);
                return 0;
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        TbadkCoreApplication.getInst().registerReceiver(new AppNotificationReceiver(), intentFilter);
        com.baidu.tieba.ad.a.aXX().a(cVar);
        SwitchManager.getInstance().addSwitchData(new com.baidu.adp.lib.featureSwitch.b("switch_mbaidu_startup", 1, null));
        azu();
        azv();
        azw();
    }

    private static void azu() {
        com.baidu.tieba.ad.a.aXX().a(new h.a() { // from class: com.baidu.tieba.ad.browser.AdStatic.3
            @Override // com.baidu.tieba.recapp.h.a
            public int d(Context context, String[] strArr) {
                Bundle parserQuery;
                if (context == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                str.toLowerCase();
                String str2 = strArr.length > 2 ? strArr[2] : null;
                String str3 = strArr.length > 1 ? strArr[1] : null;
                if (str.startsWith("tel:")) {
                    UtilHelper.callPhone(context, str.substring(4));
                    return 0;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    String substring = str.substring(4);
                    String str4 = "";
                    if (str.contains("body=")) {
                        str4 = ag.getMatchStringFromURL(str, "body=");
                        substring = substring.substring(0, substring.indexOf("?") - 1);
                    }
                    UtilHelper.smsTo(context, substring, str4);
                    return 0;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                    d.startExternWebActivity(context, str);
                    return 1;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_FINISH_THIS_PAGE) && (context instanceof Activity)) {
                    ((Activity) context).finish();
                    return 1;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.TBEAN_TOAST) && (context instanceof Activity)) {
                    UtilHelper.showToast(context, (int) R.string.buy_sucess);
                    ((Activity) context).finish();
                    return 0;
                } else if (str.startsWith("tieba://focusforum")) {
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    return 0;
                } else if (str.startsWith("baiduxiuba://")) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(str));
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return 0;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE, ag.getMatchStringFromURL(str, "bindid=")));
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                    return 1;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (parserQuery = ag.parserQuery(str)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(parserQuery.getString("path"))) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_YINJIN_CHANGE));
                    return 0;
                } else {
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                        AdStatic.c(context, d.parseWebViewUrl(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str2), null, false, true, true, true);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                        AdStatic.c(context, d.parseWebViewUrl(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str2), null, false, true, true, true);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TOPIC)) {
                        AdStatic.c(context, str3, str.substring(6), false, true, true, false);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_ZB)) {
                        AdStatic.c(context, str.substring(3), context.getString(R.string.photo_live_tips), false, true, false, false);
                    } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                        return 3;
                    } else {
                        String substring2 = str.substring(5);
                        if (!TextUtils.isEmpty(substring2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_RANK, new ForumRankActivityConfig(context, substring2, str2)));
                        }
                    }
                    return 3;
                }
            }
        });
    }

    private static String getRealUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
        boolean z = !TextUtils.isEmpty(checkUrl) && str.startsWith(checkUrl);
        boolean startsWith = str.startsWith("http://tieba.baidu.com/mo/q/checkurl?url=");
        if (z || startsWith) {
            if (z) {
                str2 = str.substring(checkUrl.length());
            } else if (!startsWith) {
                str2 = null;
            } else {
                str2 = str.substring("http://tieba.baidu.com/mo/q/checkurl?url=".length());
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return URLDecoder.decode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    private static String sg(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
        if (checkUrl == null) {
            checkUrl = "http://tieba.baidu.com/mo/q/checkurl?url=";
        } else if (checkUrl.trim().length() == 0) {
            return str;
        }
        if (!str.startsWith(checkUrl)) {
            return checkUrl + sh(str);
        }
        return str;
    }

    public static String sh(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = new String(str.getBytes(), "UTF-8");
            try {
                return URLEncoder.encode(str2, "UTF-8");
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        TiebaStatic.eventStat(context, "url_1", null);
        String realUrl = getRealUrl(str);
        if (!wT(realUrl) && aXY() && wV(GlobalConstants.SEARCHBOX_PACKAGE_NAME) && wU(realUrl) && cKE) {
            TiebaStatic.eventStat(context, "url_2", null);
            b(context, str, str2, z, z2, z3, z4);
            return;
        }
        c(context, str, str2, z, z2, z3, z4);
    }

    private static boolean wT(String str) {
        return str != null;
    }

    private static boolean aXY() {
        return SwitchManager.getInstance().findType("switch_mbaidu_startup") == 1;
    }

    private static boolean wU(String str) {
        return str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || !str.contains("://");
    }

    private static boolean wV(String str) {
        try {
            PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(str, 1);
            if (packageInfo == null) {
                return false;
            }
            return str.equals(packageInfo.packageName);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static void b(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String parseWebViewUrl = d.parseWebViewUrl(str, null);
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(parseWebViewUrl));
        intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        try {
            TbadkCoreApplication.getInst().startActivity(intent);
            TiebaStatic.eventStat(context, "url_3", null);
        } catch (Exception e) {
            BdLog.e(e);
            c(context, str, str2, z, z2, z3, z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        d.startWebActivity(context, false, sg(str), str2);
    }

    private static void azv() {
        com.baidu.tieba.ad.a.aXX().a(new h.a() { // from class: com.baidu.tieba.ad.browser.AdStatic.4
            @Override // com.baidu.tieba.recapp.h.a
            public int d(Context context, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                    return !AdStatic.a(context, parse, null, false) ? 3 : 0;
                } else if ("pb".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter = parse.getQueryParameter("tId");
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = parse.getQueryParameter("tId".toLowerCase());
                    }
                    String queryParameter2 = parse.getQueryParameter("view_type");
                    if (queryParameter == null || queryParameter.length() <= 0) {
                        return 3;
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(context);
                    if (queryParameter2 != null && (queryParameter2.equals("2") || queryParameter2.equals("3"))) {
                        pbActivityConfig.createViewTypeCfg(queryParameter, Boolean.valueOf(queryParameter2.equals("2")).booleanValue(), Boolean.valueOf(queryParameter2.equals("3") ? false : true).booleanValue(), "lego");
                        pbActivityConfig.setVideo_source("frs");
                    } else {
                        pbActivityConfig.createNormalCfg(queryParameter, null, "lego");
                    }
                    String queryParameter3 = parse.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        pbActivityConfig.setPreLoad(queryParameter3);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                    return 0;
                } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter4 = parse.getQueryParameter("kw");
                    if (queryParameter4 == null || queryParameter4.length() <= 0) {
                        return 3;
                    }
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(queryParameter4, "lego");
                    createNormalCfg.setCallFrom(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    return 0;
                } else if (AlbumActivityConfig.FROM_PERSON.equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter5 = parse.getQueryParameter("uid");
                    String queryParameter6 = parse.getQueryParameter(BdStatsConstant.StatsKey.UNAME);
                    if (queryParameter5 == null || queryParameter5.length() <= 0 || queryParameter6 == null || queryParameter6.length() <= 0) {
                        return 3;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, queryParameter5, queryParameter6)));
                    return 0;
                } else if ("topic".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter7 = parse.getQueryParameter("topic_id");
                    String queryParameter8 = parse.getQueryParameter("topic_name");
                    if (queryParameter7 != null && queryParameter8 != null) {
                        HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(context);
                        hotTopicActivityConfig.createNormalConfig(queryParameter7, queryParameter8, null);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicActivityConfig));
                        return 1;
                    } else if (queryParameter7 != null) {
                        HotTopicActivityConfig hotTopicActivityConfig2 = new HotTopicActivityConfig(context);
                        hotTopicActivityConfig2.createNormalConfig(queryParameter7, null, null);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicActivityConfig2));
                        return 1;
                    } else {
                        return 3;
                    }
                } else {
                    return 3;
                }
            }
        });
    }

    private static void azw() {
        com.baidu.tieba.ad.a.aXX().a(new h.a() { // from class: com.baidu.tieba.ad.browser.AdStatic.5
            @Override // com.baidu.tieba.recapp.h.a
            public int d(Context context, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                String str2 = null;
                if (str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#")) {
                    int indexOf = str.indexOf("page/", 0) + "page/".length();
                    int indexOf2 = str.indexOf("?", 0);
                    if (indexOf > "page/".length() && indexOf2 > indexOf) {
                        str2 = str.substring(indexOf, indexOf2);
                    }
                    return (indexOf2 <= -1 || !AdStatic.a(context, Uri.parse(new StringBuilder().append(UrlSchemaHelper.SCHEMA_TYPE_LEGO).append(str.substring(indexOf2 + 1)).toString()), str2, false)) ? 3 : 0;
                } else if (str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#")) {
                    int indexOf3 = str.indexOf("page/", 0) + "page/".length();
                    int indexOf4 = str.indexOf("?", 0);
                    if (indexOf3 > "page/".length() && indexOf4 > indexOf3) {
                        str2 = str.substring(indexOf3, indexOf4);
                    }
                    return (indexOf4 <= -1 || !AdStatic.a(context, Uri.parse(new StringBuilder().append(UrlSchemaHelper.SCHEMA_TYPE_LEGO).append(str.substring(indexOf4 + 1)).toString()), str2, true)) ? 3 : 0;
                } else {
                    return 3;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Context context, Uri uri, String str, boolean z) {
        int i;
        int i2;
        int i3;
        String str2;
        int i4;
        if (context == null || uri == null) {
            return false;
        }
        if (str == null || str.length() == 0) {
            str = uri.getQueryParameter("page_id");
        }
        String queryParameter = uri.getQueryParameter("page_type");
        String queryParameter2 = uri.getQueryParameter(LegoListActivityConfig.ITEM_ID);
        String queryParameter3 = uri.getQueryParameter("rn");
        String queryParameter4 = uri.getQueryParameter("params");
        String queryParameter5 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
        String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.NEXT_PAGE);
        String queryParameter7 = uri.getQueryParameter("lego_version");
        String queryParameter8 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
        String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
        String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
        String queryParameter11 = uri.getQueryParameter("source");
        String str3 = TextUtils.isEmpty(queryParameter11) ? "unknown" : queryParameter11;
        if ((!z || si(queryParameter7)) && str != null && queryParameter != null && str.length() > 0 && queryParameter.length() > 0) {
            try {
                int parseInt = Integer.parseInt(queryParameter);
                try {
                    long parseLong = Long.parseLong(str);
                    try {
                        i = Integer.parseInt(queryParameter3);
                    } catch (Exception e) {
                        i = 20;
                    }
                    try {
                        i2 = Integer.parseInt(queryParameter8);
                    } catch (Exception e2) {
                        i2 = 0;
                    }
                    try {
                        i3 = Integer.parseInt(queryParameter9);
                    } catch (Exception e3) {
                        i3 = 0;
                    }
                    if (i3 != 1) {
                        str2 = "";
                    } else {
                        str2 = uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO);
                    }
                    try {
                        i4 = Integer.parseInt(queryParameter10);
                    } catch (Exception e4) {
                        i4 = 0;
                    }
                    LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(context).createNormalCfg(parseLong, parseInt, queryParameter2, i2, i, queryParameter4);
                    createNormalCfg.addLandingPageParams(str2, queryParameter5, queryParameter6, i3, i4, str3);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_LEGO_LIST, createNormalCfg));
                    return true;
                } catch (Exception e5) {
                    return false;
                }
            } catch (Exception e6) {
                return false;
            }
        }
        return false;
    }

    private static boolean si(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "1.0.0";
        }
        return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
    }
}
