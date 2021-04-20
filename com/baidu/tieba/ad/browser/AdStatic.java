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
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.ad.download.broadcast.AppNotificationReceiver;
import d.b.h0.z0.n0;
import d.b.i0.s2.l;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class AdStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14167a = true;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null) {
                return;
            }
            d.b.i0.o.c.a.c(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements l.c {
        @Override // d.b.i0.s2.l.c
        public int a(Context context, String str, String str2, boolean z, l.d dVar, boolean z2, Bundle bundle) {
            if (z2) {
                AdStatic.p(context, str2, null, bundle);
                return 0;
            }
            AdStatic.q(context, str2, str, bundle);
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements l.a {
        @Override // d.b.i0.s2.l.a
        public int a(Context context, String[] strArr) {
            Bundle i;
            if (context != null && strArr != null && strArr.length != 0) {
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
                }
                String str4 = "";
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    String substring = str.substring(4);
                    if (str.contains("body=")) {
                        str4 = n0.c(str, "body=");
                        substring = substring.substring(0, substring.indexOf("?") - 1);
                    }
                    UtilHelper.smsTo(context, substring, str4);
                    return 0;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                    d.b.i0.o.c.a.f(context, str);
                    return 1;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_FINISH_THIS_PAGE) && (context instanceof Activity)) {
                    ((Activity) context).finish();
                    return 1;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.TBEAN_TOAST) && (context instanceof Activity)) {
                    UtilHelper.showToast(context, R.string.buy_sucess);
                    ((Activity) context).finish();
                    return 0;
                } else if (str.startsWith("tieba://focusforum")) {
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    return 0;
                } else if (str.startsWith("baiduxiuba://")) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(str));
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    context.startActivity(intent);
                    return 0;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001359, n0.c(str, "bindid=")));
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                    return 1;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (i = n0.i(str)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(i.getString("path"))) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001372));
                    return 0;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                    AdStatic.p(context, d.b.i0.o.c.a.d(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str2), null, null);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    AdStatic.p(context, d.b.i0.o.c.a.d(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str2), null, null);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TOPIC)) {
                    AdStatic.p(context, str3, str.substring(6), null);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_ZB)) {
                    AdStatic.p(context, str.substring(3), context.getString(R.string.photo_live_tips), null);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                    String substring2 = str.substring(5);
                    if (!TextUtils.isEmpty(substring2)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(context, substring2, str2)));
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements l.a {
        @Override // d.b.i0.s2.l.a
        public int a(Context context, String[] strArr) {
            if (strArr != null && strArr[0] != null) {
                Uri parse = Uri.parse(strArr[0]);
                if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                    return AdStatic.d(context, parse, null, false) ? 0 : 3;
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
                        pbActivityConfig.createViewTypeCfg(queryParameter, Boolean.valueOf(queryParameter2.equals("2")).booleanValue(), Boolean.valueOf(!queryParameter2.equals("3")).booleanValue(), "lego");
                        pbActivityConfig.setVideo_source("frs");
                    } else {
                        pbActivityConfig.createNormalCfg(queryParameter, null, "lego");
                    }
                    String queryParameter3 = parse.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        pbActivityConfig.setPreLoad(queryParameter3);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return 0;
                } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter4 = parse.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                    if (queryParameter4 == null || queryParameter4.length() <= 0) {
                        return 3;
                    }
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(queryParameter4, "lego");
                    createNormalCfg.setCallFrom(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    return 0;
                } else if ("person".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter5 = parse.getQueryParameter("uid");
                    String queryParameter6 = parse.getQueryParameter("uname");
                    if (queryParameter5 == null || queryParameter5.length() <= 0 || queryParameter6 == null || queryParameter6.length() <= 0) {
                        return 3;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, queryParameter5, queryParameter6)));
                    return 0;
                } else if ("topic".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter7 = parse.getQueryParameter("topic_id");
                    String queryParameter8 = parse.getQueryParameter(IntentConfig.TOPIC_NAME);
                    if (queryParameter7 != null && queryParameter8 != null) {
                        HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(context);
                        hotTopicActivityConfig.createNormalConfig(queryParameter7, queryParameter8, null);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicActivityConfig));
                        return 1;
                    } else if (queryParameter7 != null) {
                        HotTopicActivityConfig hotTopicActivityConfig2 = new HotTopicActivityConfig(context);
                        hotTopicActivityConfig2.createNormalConfig(queryParameter7, null, null);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicActivityConfig2));
                        return 1;
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements l.a {
        @Override // d.b.i0.s2.l.a
        public int a(Context context, String[] strArr) {
            if (strArr != null && strArr[0] != null) {
                String str = strArr[0];
                String str2 = null;
                if (str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#")) {
                    int indexOf = str.indexOf("page/") + 5;
                    int indexOf2 = str.indexOf("?");
                    if (indexOf > 5 && indexOf2 > indexOf) {
                        str2 = str.substring(indexOf, indexOf2);
                    }
                    if (indexOf2 > -1) {
                        if (AdStatic.d(context, Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_LEGO + str.substring(indexOf2 + 1)), str2, false)) {
                            return 0;
                        }
                    }
                    return 3;
                } else if (str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#")) {
                    int indexOf3 = str.indexOf("page/") + 5;
                    int indexOf4 = str.indexOf("?");
                    if (indexOf3 > 5 && indexOf4 > indexOf3) {
                        str2 = str.substring(indexOf3, indexOf4);
                    }
                    if (indexOf4 > -1) {
                        if (AdStatic.d(context, Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_LEGO + str.substring(indexOf4 + 1)), str2, true)) {
                            return 0;
                        }
                    }
                }
            }
            return 3;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AdWebViewActivityConfig.class, AdWebViewActivity.class);
        MessageManager.getInstance().registerListener(2005016, new a(0));
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addDataScheme("package");
        TbadkCoreApplication.getInst().registerReceiver(new AppNotificationReceiver(), intentFilter);
        d.b.i0.o.a.l().o(bVar);
        SwitchManager.getInstance().addSwitchData(new d.b.c.e.f.b("switch_mbaidu_startup", 1, null));
        l();
        m();
        n();
    }

    public static boolean d(Context context, Uri uri, String str, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (context == null || uri == null) {
            return false;
        }
        String queryParameter = (str == null || str.length() == 0) ? uri.getQueryParameter("page_id") : str;
        String queryParameter2 = uri.getQueryParameter("page_type");
        String queryParameter3 = uri.getQueryParameter(LegoListActivityConfig.ITEM_ID);
        String queryParameter4 = uri.getQueryParameter("rn");
        String queryParameter5 = uri.getQueryParameter("params");
        String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
        String queryParameter7 = uri.getQueryParameter(LegoListActivityConfig.NEXT_PAGE);
        String queryParameter8 = uri.getQueryParameter("lego_version");
        String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
        String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
        String queryParameter11 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
        String queryParameter12 = uri.getQueryParameter("source");
        if (TextUtils.isEmpty(queryParameter12)) {
            queryParameter12 = "unknown";
        }
        String str2 = queryParameter12;
        if ((!z || j(queryParameter8)) && queryParameter != null && queryParameter2 != null && queryParameter.length() > 0 && queryParameter2.length() > 0) {
            try {
                int parseInt = Integer.parseInt(queryParameter2);
                long parseLong = Long.parseLong(queryParameter);
                try {
                    i = Integer.parseInt(queryParameter4);
                } catch (Exception unused) {
                    i = 20;
                }
                try {
                    i2 = Integer.parseInt(queryParameter9);
                } catch (Exception unused2) {
                    i2 = 0;
                }
                try {
                    i3 = Integer.parseInt(queryParameter10);
                } catch (Exception unused3) {
                    i3 = 0;
                }
                String queryParameter13 = i3 == 1 ? uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO) : "";
                try {
                    i4 = Integer.parseInt(queryParameter11);
                } catch (Exception unused4) {
                    i4 = 0;
                }
                LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(context).createNormalCfg(parseLong, parseInt, queryParameter3, i2, i, queryParameter5);
                createNormalCfg.addLandingPageParams(queryParameter13, queryParameter6, queryParameter7, i3, i4, str2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2016447, createNormalCfg));
                return true;
            } catch (Exception unused5) {
                return false;
            }
        }
        return false;
    }

    public static boolean e() {
        return SwitchManager.getInstance().findType("switch_mbaidu_startup") == 1;
    }

    public static boolean f(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || !str.contains("://");
    }

    public static boolean g(String str) {
        return str != null;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
        String str2 = null;
        boolean z = !TextUtils.isEmpty(checkUrl) && str.startsWith(checkUrl);
        boolean startsWith = str.startsWith("http://tieba.baidu.com/mo/q/checkurl?url=");
        if (z || startsWith) {
            if (z) {
                str2 = str.substring(checkUrl.length());
            } else if (startsWith) {
                str2 = str.substring(41);
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            try {
                return URLDecoder.decode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static boolean i(String str) {
        try {
            PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(str, 1);
            if (packageInfo == null) {
                return false;
            }
            return str.equals(packageInfo.packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.VERSION_NAME;
        }
        return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
    }

    public static String k(String str) {
        return str;
    }

    public static void l() {
        d.b.i0.o.a.l().e(new c());
    }

    public static void m() {
        d.b.i0.o.a.l().e(new d());
    }

    public static void n() {
        d.b.i0.o.a.l().e(new e());
    }

    public static void o(Context context, String str, String str2, Bundle bundle) {
        String d2 = d.b.i0.o.c.a.d(str, null);
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.setData(Uri.parse(d2));
        intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        try {
            TbadkCoreApplication.getInst().startActivity(intent);
            TiebaStatic.eventStat(context, "url_3", null);
        } catch (Exception e2) {
            BdLog.e(e2);
            p(context, str, str2, bundle);
        }
    }

    public static void p(Context context, String str, String str2, Bundle bundle) {
        k(str);
        d.b.i0.o.c.a.g(context, str, str2, bundle);
    }

    public static void q(Context context, String str, String str2, Bundle bundle) {
        TiebaStatic.eventStat(context, "url_1", null);
        String h2 = h(str);
        if (!g(h2) && e() && i("com.baidu.searchbox") && f(h2) && f14167a) {
            TiebaStatic.eventStat(context, "url_2", null);
            o(context, str, str2, bundle);
            return;
        }
        p(context, str, str2, bundle);
    }
}
