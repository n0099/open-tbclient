package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.PopupWindow;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import com.facebook.drawee.backends.pipeline.Fresco;
import d.b.c.e.p.l;
import d.b.g0.a.i2.k0;
import d.b.h0.f0.i;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanAppAbTestStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14342a = false;

    /* renamed from: b  reason: collision with root package name */
    public static i f14343b = new a();

    /* loaded from: classes4.dex */
    public static class a extends i<PrivacyPolicyEvent> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.f0.b
        /* renamed from: a */
        public boolean onEvent(PrivacyPolicyEvent privacyPolicyEvent) {
            if (privacyPolicyEvent == null) {
                return true;
            }
            SwanAppAbTestStatic.c();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage != null && !StringUtils.isNull(customMessage.getData())) {
                if (Build.VERSION.SDK_INT <= 21) {
                    l.K(TbadkCoreApplication.getInst(), R.string.ai_apps_not_support);
                    return null;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START);
                statisticItem.param("obj_id", customMessage.getData());
                TiebaStatic.log(statisticItem);
                if (d.b.c.a.b.f().b() != null) {
                    Uri parse = Uri.parse(customMessage.getData());
                    SwanAppAbTestStatic.d(parse);
                    SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse);
                } else {
                    Uri parse2 = Uri.parse(customMessage.getData());
                    SwanAppAbTestStatic.d(parse2);
                    SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse2);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public c(int i) {
            super(i);
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
            if ((customResponsedMessage.getData() instanceof d.b.h0.a.g) && (a2 = d.b.i0.s.b.a.a((d.b.h0.a.g) customResponsedMessage.getData())) != null && (b2 = d.b.c.a.b.f().b()) != null && b2.getWindow() != null) {
                try {
                    a2.showAtLocation(b2.getWindow().getDecorView(), 17, 0, 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            String str;
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
    }

    /* loaded from: classes4.dex */
    public static class e extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a extends GetUserInfoCallback {
            public a(e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                d.b.g0.a.a2.g.h.a().putString("bd_box_display_name", getUserInfoResult.displayname);
                d.b.g0.a.a2.g.h.a().putString("bd_box_uid", getUserInfoResult.uid);
                d.b.g0.a.a2.g.h.a().putString("bd_box_avatar_url", getUserInfoResult.portraitHttps);
                d.b.g0.a.a2.g.h.a().putString("bd_box_bduss", SapiAccountManager.getInstance().getSession().bduss);
                d.b.g0.a.a2.g.h.a().putString("bd_box_ptoken", SapiAccountManager.getInstance().getSession().getPtoken());
                d.b.i0.s.b.b.a.l().y(getUserInfoResult);
            }
        }

        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                SapiAccountManager.getInstance().getConfignation();
            } catch (Exception unused) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
            }
            if (!SapiAccountManager.getInstance().isLogin()) {
                d.b.i0.s.b.b.a.l().y(null);
            }
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new a(this), SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            String a2 = d.b.g0.a.l.a();
            String f2 = d.b.g0.a.b2.b.f(0);
            String f3 = d.b.g0.a.b2.b.f(1);
            TbadkCoreApplication.getInst().setSdk_ver(a2);
            TbadkCoreApplication.getInst().setFramework_ver(f2);
            TbadkCoreApplication.getInst().setSwan_game_ver(f3);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements d.b.p.c<String> {
        @Override // d.b.p.c
        public void b(int i, Throwable th, Bundle bundle) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.p.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.d.j.c.b.a();
        }
    }

    static {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            c();
        } else {
            d.b.h0.f0.h.f().m(PrivacyPolicyEvent.class, f14343b, BdUniqueId.gen());
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

    public static void c() {
        if (f14342a) {
            return;
        }
        f14342a = true;
        SwanAppInitHelper.initModules(TbadkCoreApplication.getInst(), false);
        if (Build.VERSION.SDK_INT <= 21 || TbadkCoreApplication.getInst().isRemoteProcess()) {
            return;
        }
        d.b.i0.s.b.n.a.b();
        if (ProcessUtils.isMainProcess() && !Fresco.hasBeenInitialized()) {
            Fresco.initialize(AppRuntime.getAppContext());
        }
        d.b.i0.s.b.b.a.l().q(TbadkCoreApplication.getInst());
        d.b.i0.s.b.m.c.a().b(TbadkCoreApplication.getInst());
        d.b.p.b.d(TbadkCoreApplication.getInst()).j(new g());
        k0.U(new h(), 3000L);
    }

    public static void d(Uri uri) {
        List<String> pathSegments;
        if (uri == null || (pathSegments = uri.getPathSegments()) == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY);
        httpMessage.addParam("swan_app_key", pathSegments.get(0));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
