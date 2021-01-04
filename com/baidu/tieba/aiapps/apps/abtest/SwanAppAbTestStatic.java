package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.PopupWindow;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.c;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mutiprocess.event.PrivacyPolicyEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mutiprocess.h;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.a;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import java.util.List;
/* loaded from: classes9.dex */
public class SwanAppAbTestStatic {
    public static String Tag = "tag";
    private static boolean gnr = false;
    private static h gns = new h<PrivacyPolicyEvent>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(PrivacyPolicyEvent privacyPolicyEvent) {
            if (privacyPolicyEvent != null) {
                SwanAppAbTestStatic.bQi();
            }
            return true;
        }
    };

    static {
        if (ad.bvY()) {
            bQi();
        } else {
            g.bGF().a(PrivacyPolicyEvent.class, gns, BdUniqueId.gen());
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null && !StringUtils.isNull(customMessage.getData())) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.ai_apps_not_support);
                    } else {
                        aq aqVar = new aq("c13606");
                        aqVar.dX("obj_id", customMessage.getData());
                        TiebaStatic.log(aqVar);
                        if (b.kC().currentActivity() != null) {
                            Uri parse = Uri.parse(customMessage.getData());
                            SwanAppAbTestStatic.y(parse);
                            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse);
                        } else {
                            Uri parse2 = Uri.parse(customMessage.getData());
                            SwanAppAbTestStatic.y(parse2);
                            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse2);
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921377) { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.3
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                onMessage2((CustomResponsedMessage) customResponsedMessage);
            }

            /* renamed from: onMessage  reason: avoid collision after fix types in other method */
            public void onMessage2(CustomResponsedMessage customResponsedMessage) {
                PopupWindow a2;
                Activity currentActivity;
                if ((customResponsedMessage.getData() instanceof com.baidu.tbadk.BdToken.g) && (a2 = a.a((com.baidu.tbadk.BdToken.g) customResponsedMessage.getData())) != null && (currentActivity = b.kC().currentActivity()) != null && currentActivity.getWindow() != null) {
                    try {
                        a2.showAtLocation(currentActivity.getWindow().getDecorView(), 17, 0, 0);
                    } catch (Exception e) {
                    }
                }
            }
        });
        be.bwu().a(new be.a() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.4
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                Uri parse = Uri.parse(str);
                if (StringUtils.isNull(str) || !str.startsWith("tiebaclient:")) {
                    return str.contains("wap.beeplaying.com") ? 2 : 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                if (str.contains("tbcfrom=web_search")) {
                    String str2 = "";
                    String str3 = "";
                    try {
                        String substring = str.substring("tiebaclient://swan/".length());
                        str2 = substring.substring(0, substring.lastIndexOf(47));
                        if (parse != null) {
                            str3 = parse.getQueryParameter("swanName");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    TiebaStatic.log(new aq("c13274").dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_id", str2).dX("obj_source", "web_search").dX("obj_name", str3));
                }
                return 0;
            }
        });
        TbadkCoreApplication.getInst().RegisterIntent(AiAppGuideActivityConfig.class, AiAppGuideActivity.class);
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_BROWSE_HISTORY));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921410) { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                try {
                    SapiAccountManager.getInstance().getConfignation();
                } catch (Exception e) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
                }
                if (!SapiAccountManager.getInstance().isLogin()) {
                    com.baidu.tieba.aiapps.apps.a.a.bQj().a((GetUserInfoResult) null);
                }
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        com.baidu.swan.apps.storage.c.h.aPH().putString("bd_box_display_name", getUserInfoResult.displayname);
                        com.baidu.swan.apps.storage.c.h.aPH().putString("bd_box_uid", getUserInfoResult.uid);
                        com.baidu.swan.apps.storage.c.h.aPH().putString("bd_box_avatar_url", getUserInfoResult.portraitHttps);
                        com.baidu.swan.apps.storage.c.h.aPH().putString("bd_box_bduss", SapiAccountManager.getInstance().getSession().bduss);
                        com.baidu.swan.apps.storage.c.h.aPH().putString("bd_box_ptoken", SapiAccountManager.getInstance().getSession().getPtoken());
                        com.baidu.tieba.aiapps.apps.a.a.bQj().a(getUserInfoResult);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, SapiAccountManager.getInstance().getSession().bduss);
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921512, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                String version = c.getVersion();
                String le = com.baidu.swan.apps.swancore.b.le(0);
                String le2 = com.baidu.swan.apps.swancore.b.le(1);
                TbadkCoreApplication.getInst().setSdk_ver(version);
                TbadkCoreApplication.getInst().setFramework_ver(le);
                TbadkCoreApplication.getInst().setSwan_game_ver(le2);
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bQi() {
        if (!gnr) {
            gnr = true;
            SwanAppInitHelper.initModules(TbadkCoreApplication.getInst(), false);
            if (Build.VERSION.SDK_INT > 21 && !TbadkCoreApplication.getInst().isRemoteProcess()) {
                com.baidu.tieba.aiapps.apps.i.a.bQW();
                if (ProcessUtils.isMainProcess() && !com.facebook.drawee.a.a.c.euL()) {
                    com.facebook.drawee.a.a.c.initialize(AppRuntime.getAppContext());
                }
                com.baidu.tieba.aiapps.apps.a.a.bQj().init(TbadkCoreApplication.getInst());
                com.baidu.tieba.aiapps.apps.share.c.bQU().fT(TbadkCoreApplication.getInst());
                com.baidu.helios.b.ak(TbadkCoreApplication.getInst()).b(new com.baidu.helios.c<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.helios.c
                    /* renamed from: b */
                    public void a(String str, Bundle bundle) {
                    }

                    @Override // com.baidu.helios.c
                    public void a(int i, Throwable th, Bundle bundle) {
                    }
                });
                ak.c(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.facade.requred.webview.b.aUy();
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Uri uri) {
        List<String> pathSegments;
        if (uri != null && (pathSegments = uri.getPathSegments()) != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", pathSegments.get(0));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
