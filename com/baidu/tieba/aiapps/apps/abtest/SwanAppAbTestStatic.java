package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.a.v2.q0;
import c.a.q0.j0.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.event.PrivacyPolicyEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.List;
/* loaded from: classes7.dex */
public class SwanAppAbTestStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49369a;

    /* renamed from: b  reason: collision with root package name */
    public static i f49370b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends i<PrivacyPolicyEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(PrivacyPolicyEvent privacyPolicyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, privacyPolicyEvent)) == null) {
                if (privacyPolicyEvent == null) {
                    return true;
                }
                SwanAppAbTestStatic.c();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements CustomMessageTask.CustomRunnable<String> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && !StringUtils.isNull(customMessage.getData())) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        l.L(TbadkCoreApplication.getInst(), R.string.ai_apps_not_support);
                        return null;
                    }
                    if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK_map_v5_4_4.so"))) {
                        RequestParams requestParams = new RequestParams();
                        requestParams.setRunType(c.a.e.j.d.f2895a);
                        requestParams.setRunNode("aps");
                        requestParams.addChannel(new c.a.e.j.c("com.baidu.tieba.soloader.libbaidumap", (DefaultDownloadCallback) null));
                        PmsManager.getInstance().execute(requestParams);
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START);
                    statisticItem.param("obj_id", customMessage.getData());
                    TiebaStatic.log(statisticItem);
                    Uri parse = Uri.parse(customMessage.getData());
                    SwanAppAbTestStatic.d(parse);
                    SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            PopupWindow a2;
            Activity b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof c.a.q0.a.h) && (a2 = c.a.r0.v.b.a.a((c.a.q0.a.h) customResponsedMessage.getData())) != null && (b2 = c.a.e.a.b.g().b()) != null && b2.getWindow() != null) {
                try {
                    a2.showAtLocation(b2.getWindow().getDecorView(), 17, 0, 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                String str2 = "";
                if (strArr != null && strArr.length != 0) {
                    String str3 = strArr[0];
                    Uri parse = Uri.parse(str3);
                    if (!StringUtils.isNull(str3) && str3.startsWith("tiebaclient:")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str3));
                        if (str3.contains("tbcfrom=web_search")) {
                            try {
                                String substring = str3.substring(19);
                                str = substring.substring(0, substring.lastIndexOf(47));
                                if (parse != null) {
                                    try {
                                        str2 = parse.getQueryParameter("swanName");
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", str).param("obj_source", "web_search").param("obj_name", str2));
                                        return 0;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str = "";
                            }
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", str).param("obj_source", "web_search").param("obj_name", str2));
                        }
                        return 0;
                    } else if (str3.contains("wap.beeplaying.com")) {
                        return 2;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends GetUserInfoCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                    c.a.p0.a.k2.g.h.a().putString("bd_box_display_name", getUserInfoResult.displayname);
                    c.a.p0.a.k2.g.h.a().putString("bd_box_uid", getUserInfoResult.uid);
                    c.a.p0.a.k2.g.h.a().putString("bd_box_avatar_url", getUserInfoResult.portraitHttps);
                    c.a.p0.a.k2.g.h.a().putString("bd_box_bduss", SapiAccountManager.getInstance().getSession().bduss);
                    c.a.p0.a.k2.g.h.a().putString("bd_box_ptoken", SapiAccountManager.getInstance().getSession().getPtoken());
                    c.a.r0.v.b.b.a.l().y(getUserInfoResult);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i2) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                try {
                    SapiAccountManager.getInstance().getConfignation();
                } catch (Exception unused) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
                }
                if (!SapiAccountManager.getInstance().isLogin()) {
                    c.a.r0.v.b.b.a.l().y(null);
                }
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new a(this), SapiAccountManager.getInstance().getSession().bduss);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String a2 = c.a.p0.a.l.a();
                long f2 = c.a.p0.a.m2.b.f(0);
                long f3 = c.a.p0.a.m2.b.f(1);
                TbadkCoreApplication.getInst().setSdk_ver(a2);
                TbadkCoreApplication.getInst().setFramework_ver(Long.toString(f2));
                TbadkCoreApplication.getInst().setSwan_game_ver(Long.toString(f3));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements c.a.r.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r.c
        /* renamed from: a */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bundle) == null) {
            }
        }

        @Override // c.a.r.c
        public void onError(int i2, Throwable th, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, th, bundle) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.e.o.b.b.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(194486384, "Lcom/baidu/tieba/aiapps/apps/abtest/SwanAppAbTestStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(194486384, "Lcom/baidu/tieba/aiapps/apps/abtest/SwanAppAbTestStatic;");
                return;
            }
        }
        f49370b = new a();
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            c();
        } else {
            c.a.q0.j0.h.f().m(PrivacyPolicyEvent.class, f49370b, BdUniqueId.gen());
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new c(2921377));
        UrlManager.getInstance().addListener(new d());
        TbadkCoreApplication.getInst().RegisterIntent(AiAppGuideActivityConfig.class, AiAppGuideActivity.class);
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_BROWSE_HISTORY));
        MessageManager.getInstance().registerListener(new e(2921410));
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921512, new f());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    public SwanAppAbTestStatic() {
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

    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f49369a) {
            return;
        }
        f49369a = true;
        SwanAppInitHelper.initModules(TbadkCoreApplication.getInst(), false);
        if (Build.VERSION.SDK_INT <= 21 || TbadkCoreApplication.getInst().isRemoteProcess()) {
            return;
        }
        c.a.r0.v.b.k.a.b();
        if (ProcessUtils.isMainProcess() && !Fresco.hasBeenInitialized()) {
            Fresco.initialize(AppRuntime.getAppContext());
        }
        c.a.r0.v.b.b.a.l().q(TbadkCoreApplication.getInst());
        c.a.r0.v.b.j.c.a().b(TbadkCoreApplication.getInst());
        c.a.r.b.e(TbadkCoreApplication.getInst()).m(new g());
        q0.Y(new h(), 3000L);
    }

    public static void d(Uri uri) {
        List<String> pathSegments;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, uri) == null) || uri == null || (pathSegments = uri.getPathSegments()) == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY);
        httpMessage.addParam("swan_app_key", pathSegments.get(0));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
