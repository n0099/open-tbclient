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
import c.a.q0.d1.t0;
import c.a.r0.h3.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes10.dex */
public class AdStatic {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.r0.v.f.a.c(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.h3.l.c
        public int a(Context context, String str, String str2, boolean z, l.d dVar, boolean z2, Bundle bundle) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) {
                if (z2) {
                    AdStatic.p(context, str2, null, bundle);
                    return 0;
                }
                AdStatic.q(context, str2, str, bundle);
                return 0;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.h3.l.a
        public int a(Context context, String[] strArr) {
            InterceptResult invokeLL;
            Bundle i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
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
                            str4 = t0.c(str, "body=");
                            substring = substring.substring(0, substring.indexOf("?") - 1);
                        }
                        UtilHelper.smsTo(context, substring, str4);
                        return 0;
                    } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                        c.a.r0.v.f.a.f(context, str);
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
                        intent.setFlags(268435456);
                        context.startActivity(intent);
                        return 0;
                    } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001359, t0.c(str, "bindid=")));
                        if (context instanceof Activity) {
                            ((Activity) context).finish();
                        }
                        return 1;
                    } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (i2 = t0.i(str)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(i2.getString("path"))) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001372));
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                        AdStatic.p(context, c.a.r0.v.f.a.d(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str2), null, null);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                        AdStatic.p(context, c.a.r0.v.f.a.d(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str2), null, null);
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
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.h3.l.a
        public int a(Context context, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
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
                        String queryParameter9 = parse.getQueryParameter("is_video_topic");
                        if (queryParameter7 != null && queryParameter8 != null) {
                            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(context);
                            hotTopicActivityConfig.createNormalConfig(queryParameter7, queryParameter8, queryParameter9, null);
                            hotTopicActivityConfig.start();
                            return 1;
                        } else if (queryParameter7 != null) {
                            HotTopicActivityConfig hotTopicActivityConfig2 = new HotTopicActivityConfig(context);
                            hotTopicActivityConfig2.createNormalConfig(queryParameter7, null, queryParameter9, null);
                            hotTopicActivityConfig2.start();
                            return 1;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.h3.l.a
        public int a(Context context, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
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
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1228564603, "Lcom/baidu/tieba/ad/browser/AdStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1228564603, "Lcom/baidu/tieba/ad/browser/AdStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(AdWebViewActivityConfig.class, AdWebViewActivity.class);
        MessageManager.getInstance().registerListener(2005016, new a(0));
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addDataScheme("package");
        TbadkCoreApplication.getInst().registerReceiver(new AppNotificationReceiver(), intentFilter);
        c.a.r0.v.b.l().o(bVar);
        SwitchManager.getInstance().addSwitchData(new c.a.d.f.f.b("switch_mbaidu_startup", 1, null));
        l();
        m();
        n();
    }

    public AdStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean d(Context context, Uri uri, String str, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, uri, str, Boolean.valueOf(z)})) == null) {
            if (context == null || uri == null) {
                return false;
            }
            String queryParameter = (str == null || str.length() == 0) ? uri.getQueryParameter("page_id") : str;
            String queryParameter2 = uri.getQueryParameter("page_type");
            String queryParameter3 = uri.getQueryParameter("item_id");
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
                        i2 = Integer.parseInt(queryParameter4);
                    } catch (Exception unused) {
                        i2 = 20;
                    }
                    try {
                        i3 = Integer.parseInt(queryParameter9);
                    } catch (Exception unused2) {
                        i3 = 0;
                    }
                    try {
                        i4 = Integer.parseInt(queryParameter10);
                    } catch (Exception unused3) {
                        i4 = 0;
                    }
                    String queryParameter13 = i4 == 1 ? uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO) : "";
                    try {
                        i5 = Integer.parseInt(queryParameter11);
                    } catch (Exception unused4) {
                        i5 = 0;
                    }
                    LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(context).createNormalCfg(parseLong, parseInt, queryParameter3, i3, i2, queryParameter5);
                    createNormalCfg.addLandingPageParams(queryParameter13, queryParameter6, queryParameter7, i4, i5, str2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016447, createNormalCfg));
                    return true;
                } catch (Exception unused5) {
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? SwitchManager.getInstance().findType("switch_mbaidu_startup") == 1 : invokeV.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? str.startsWith("http://") || str.startsWith("https://") || !str.contains("://") : invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? str != null : invokeL.booleanValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "1.0.0";
            }
            return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
        }
        return invokeL.booleanValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? str : (String) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            c.a.r0.v.b.l().e(new c());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            c.a.r0.v.b.l().e(new d());
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            c.a.r0.v.b.l().e(new e());
        }
    }

    public static void o(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, context, str, str2, bundle) == null) {
            String d2 = c.a.r0.v.f.a.d(str, null);
            Intent intent = new Intent();
            intent.setAction("com.baidu.searchbox.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
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
    }

    public static void p(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, context, str, str2, bundle) == null) {
            k(str);
            c.a.r0.v.f.a.g(context, str, str2, bundle);
        }
    }

    public static void q(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65554, null, context, str, str2, bundle) == null) {
            TiebaStatic.eventStat(context, "url_1", null);
            String h2 = h(str);
            if (!g(h2) && e() && i("com.baidu.searchbox") && f(h2) && a) {
                TiebaStatic.eventStat(context, "url_2", null);
                o(context, str, str2, bundle);
                return;
            }
            p(context, str, str2, bundle);
        }
    }
}
