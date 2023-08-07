package com.baidu.tieba.ad.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.AdWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.m46;
import com.baidu.tieba.r46;
import com.baidu.tieba.ye;
import com.baidu.tieba.yw9;
import com.baidu.tieba.zv5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public class AdStatic {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? str != null : invokeL.booleanValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? str : (String) invokeL.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null) {
                return;
            }
            r46.c(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements yw9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yw9.c
        public int a(Context context, String str, String str2, boolean z, yw9.d dVar, boolean z2, Bundle bundle) {
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

    /* loaded from: classes5.dex */
    public static class c implements yw9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yw9.a
        public int a(Context context, String[] strArr) {
            InterceptResult invokeLL;
            String str;
            String str2;
            Bundle parserQuery;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
                if (context != null && strArr != null && strArr.length != 0) {
                    String str3 = strArr[0];
                    if (StringUtils.isNull(str3)) {
                        return 3;
                    }
                    if (strArr.length > 2) {
                        str = strArr[2];
                    } else {
                        str = null;
                    }
                    if (strArr.length > 1) {
                        str2 = strArr[1];
                    } else {
                        str2 = null;
                    }
                    if (str3.startsWith("tel:")) {
                        UtilHelper.callPhone(context, str3.substring(4));
                        return 0;
                    }
                    String str4 = "";
                    if (str3.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                        String substring = str3.substring(4);
                        if (str3.contains("body=")) {
                            str4 = WebviewHelper.getMatchStringFromURL(str3, "body=");
                            substring = substring.substring(0, substring.indexOf("?") - 1);
                        }
                        UtilHelper.smsTo(context, substring, str4);
                        return 0;
                    } else if (str3.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                        r46.f(context, str3);
                        return 1;
                    } else if (str3.contains(UrlSchemaHelper.SCHEMA_TYPE_FINISH_THIS_PAGE) && (context instanceof Activity)) {
                        ((Activity) context).finish();
                        return 1;
                    } else if (str3.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str3.contains(UrlSchemaHelper.TBEAN_TOAST) && (context instanceof Activity)) {
                        UtilHelper.showToast(context, (int) R.string.buy_sucess);
                        ((Activity) context).finish();
                        return 0;
                    } else if (str3.startsWith("tieba://focusforum")) {
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        return 0;
                    } else if (str3.startsWith("baiduxiuba://")) {
                        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse(str3));
                        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        context.startActivity(intent);
                        return 0;
                    } else if (str3.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str3.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001359, WebviewHelper.getMatchStringFromURL(str3, "bindid=")));
                        if (context instanceof Activity) {
                            ((Activity) context).finish();
                        }
                        return 1;
                    } else if (str3.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str3.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (parserQuery = WebviewHelper.parserQuery(str3)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(parserQuery.getString("path"))) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001372));
                        return 0;
                    } else if (!str3.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                        if (!str3.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                            if (!str3.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TOPIC)) {
                                if (!str3.startsWith(UrlSchemaHelper.SCHEMA_TYPE_ZB)) {
                                    if (str3.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                                        String substring2 = str3.substring(5);
                                        if (!TextUtils.isEmpty(substring2)) {
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(context, substring2, str)));
                                        }
                                    }
                                } else {
                                    AdStatic.p(context, str3.substring(3), context.getString(R.string.photo_live_tips), null);
                                }
                            } else {
                                AdStatic.p(context, str2, str3.substring(6), null);
                            }
                        } else {
                            AdStatic.p(context, r46.d(str3.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str), null, null);
                        }
                    } else {
                        AdStatic.p(context, r46.d(str3.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str), null, null);
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements yw9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yw9.a
        public int a(Context context, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
                if (strArr != null && strArr[0] != null) {
                    Uri parse = Uri.parse(strArr[0]);
                    if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                        if (!AdStatic.d(context, parse, null, false)) {
                            return 3;
                        }
                        return 0;
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
                        String queryParameter8 = parse.getQueryParameter("topic_name");
                        String queryParameter9 = parse.getQueryParameter("is_video_topic");
                        if (queryParameter7 != null && queryParameter8 != null) {
                            if (!StringHelper.equals(queryParameter9, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                if (context instanceof BaseActivity) {
                                    zv5.f(((BaseActivity) context).getPageContext(), queryParameter7, queryParameter8);
                                } else {
                                    HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(context);
                                    hotTopicActivityConfig.createNormalConfig(queryParameter7, queryParameter8, queryParameter9, null);
                                    hotTopicActivityConfig.start();
                                }
                            } else {
                                HotTopicActivityConfig hotTopicActivityConfig2 = new HotTopicActivityConfig(context);
                                hotTopicActivityConfig2.createNormalConfig(queryParameter7, queryParameter8, queryParameter9, null);
                                hotTopicActivityConfig2.start();
                            }
                            return 1;
                        } else if (queryParameter7 != null) {
                            if (!StringHelper.equals(queryParameter9, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                if (context instanceof BaseActivity) {
                                    zv5.f(((BaseActivity) context).getPageContext(), queryParameter7, null);
                                } else {
                                    HotTopicActivityConfig hotTopicActivityConfig3 = new HotTopicActivityConfig(context);
                                    hotTopicActivityConfig3.createNormalConfig(queryParameter7, queryParameter8, queryParameter9, null);
                                    hotTopicActivityConfig3.start();
                                }
                            } else {
                                HotTopicActivityConfig hotTopicActivityConfig4 = new HotTopicActivityConfig(context);
                                hotTopicActivityConfig4.createNormalConfig(queryParameter7, null, queryParameter9, null);
                                hotTopicActivityConfig4.start();
                            }
                            return 1;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements yw9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yw9.a
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
        a = TbConfig.TIEBA_ADDRESS + "mo/q/checkurl?url=";
        b = true;
        TbadkCoreApplication.getInst().RegisterIntent(AdWebViewActivityConfig.class, AdWebViewActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AdBrowserActivityConfig.class, AdBrowserActivity.class);
        MessageManager.getInstance().registerListener(2005016, new a(0));
        m46.l().o(new b());
        SwitchManager.getInstance().addSwitchData(new ye("switch_mbaidu_startup", 1, null));
        l();
        m();
        n();
    }

    public AdStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (SwitchManager.getInstance().findType("switch_mbaidu_startup") == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            m46.l().e(new c());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            m46.l().e(new d());
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            m46.l().e(new e());
        }
    }

    public static void p(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, context, str, str2, bundle) == null) {
            k(str);
            r46.g(context, str, str2, bundle);
        }
    }

    public static boolean d(Context context, Uri uri, String str, boolean z) {
        InterceptResult invokeCommon;
        String queryParameter;
        int i;
        int i2;
        int i3;
        String str2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, uri, str, Boolean.valueOf(z)})) == null) {
            if (context == null || uri == null) {
                return false;
            }
            if (str != null && str.length() != 0) {
                queryParameter = str;
            } else {
                queryParameter = uri.getQueryParameter(LegoListActivityConfig.PAGE_ID);
            }
            String queryParameter2 = uri.getQueryParameter("page_type");
            String queryParameter3 = uri.getQueryParameter("item_id");
            String queryParameter4 = uri.getQueryParameter("rn");
            String queryParameter5 = uri.getQueryParameter("params");
            String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
            String queryParameter7 = uri.getQueryParameter("next_page");
            String queryParameter8 = uri.getQueryParameter("lego_version");
            String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
            String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
            String queryParameter11 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
            String queryParameter12 = uri.getQueryParameter("source");
            if (TextUtils.isEmpty(queryParameter12)) {
                queryParameter12 = "unknown";
            }
            String str3 = queryParameter12;
            if ((z && !j(queryParameter8)) || queryParameter == null || queryParameter2 == null || queryParameter.length() <= 0 || queryParameter2.length() <= 0) {
                return false;
            }
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
                if (i3 == 1) {
                    str2 = uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO);
                } else {
                    str2 = "";
                }
                try {
                    i4 = Integer.parseInt(queryParameter11);
                } catch (Exception unused4) {
                    i4 = 0;
                }
                LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(context).createNormalCfg(parseLong, parseInt, queryParameter3, i2, i, queryParameter5);
                createNormalCfg.addLandingPageParams(str2, queryParameter6, queryParameter7, i3, i4, str3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2016447, createNormalCfg));
                return true;
            } catch (Exception unused5) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!str.startsWith("http://") && !str.startsWith("https://") && str.contains("://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
            if (TbConfig.getLegoLibVersion().compareTo(str) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
            String str2 = null;
            if (!TextUtils.isEmpty(checkUrl) && str.startsWith(checkUrl)) {
                z = true;
            } else {
                z = false;
            }
            boolean startsWith = str.startsWith(a);
            if (z || startsWith) {
                if (z) {
                    str2 = str.substring(checkUrl.length());
                } else if (startsWith) {
                    str2 = str.substring(a.length());
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

    public static void o(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, context, str, str2, bundle) == null) {
            String d2 = r46.d(str, null);
            Intent intent = new Intent();
            intent.setAction(IntentConstants.ACTION_VIEW);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setData(Uri.parse(d2));
            intent.putExtra(IntentConstants.Browser.EXTRA_URL_NEW_WINDOW, true);
            try {
                TbadkCoreApplication.getInst().startActivity(intent);
                TiebaStatic.eventStat(context, "url_3", null);
            } catch (Exception e2) {
                BdLog.e(e2);
                p(context, str, str2, bundle);
            }
        }
    }

    public static void q(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65554, null, context, str, str2, bundle) == null) {
            TiebaStatic.eventStat(context, "url_1", null);
            String h = h(str);
            if (!g(h) && e() && i("com.baidu.searchbox") && f(h) && b) {
                TiebaStatic.eventStat(context, "url_2", null);
                o(context, str, str2, bundle);
                return;
            }
            p(context, str, str2, bundle);
        }
    }
}
