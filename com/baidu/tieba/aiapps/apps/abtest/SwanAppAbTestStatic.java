package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.widget.PopupWindow;
import com.baidu.adp.base.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.BdToken.g;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.facebook.drawee.a.a.c;
import java.util.List;
/* loaded from: classes10.dex */
public class SwanAppAbTestStatic {
    static {
        aXn();
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null && !StringUtils.isNull(customMessage.getData())) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.ai_apps_not_support);
                    } else {
                        an anVar = new an("c13606");
                        anVar.cp("obj_id", customMessage.getData());
                        TiebaStatic.log(anVar);
                        if (a.eG().currentActivity() != null) {
                            Uri parse = Uri.parse(customMessage.getData());
                            SwanAppAbTestStatic.q(parse);
                            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse);
                        } else {
                            Uri parse2 = Uri.parse(customMessage.getData());
                            SwanAppAbTestStatic.q(parse2);
                            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse2);
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921377) { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                onMessage2((CustomResponsedMessage) customResponsedMessage);
            }

            /* renamed from: onMessage  reason: avoid collision after fix types in other method */
            public void onMessage2(CustomResponsedMessage customResponsedMessage) {
                PopupWindow a;
                Activity currentActivity;
                if ((customResponsedMessage.getData() instanceof g) && (a = com.baidu.tieba.aiapps.apps.a.a((g) customResponsedMessage.getData())) != null && (currentActivity = a.eG().currentActivity()) != null && currentActivity.getWindow() != null) {
                    try {
                        a.showAtLocation(currentActivity.getWindow().getDecorView(), 17, 0, 0);
                    } catch (Exception e) {
                    }
                }
            }
        });
        ba.aEt().a(new ba.a() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String str;
                Exception e;
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str2 = strArr[0];
                Uri parse = Uri.parse(str2);
                if (StringUtils.isNull(str2) || !str2.startsWith("tiebaclient:")) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str2));
                if (str2.contains("tbcfrom=web_search")) {
                    String str3 = "";
                    try {
                        String substring = str2.substring("tiebaclient://swan/".length());
                        str = substring.substring(0, substring.lastIndexOf(47));
                        if (parse != null) {
                            try {
                                str3 = parse.getQueryParameter("swanName");
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_id", str).cp("obj_source", "web_search").cp("obj_name", str3));
                                return 0;
                            }
                        }
                    } catch (Exception e3) {
                        str = "";
                        e = e3;
                    }
                    TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_id", str).cp("obj_source", "web_search").cp("obj_name", str3));
                }
                return 0;
            }
        });
        TbadkCoreApplication.getInst().RegisterIntent(AiAppGuideActivityConfig.class, AiAppGuideActivity.class);
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_BROWSE_HISTORY));
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921410) { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!SapiAccountManager.getInstance().isLogin()) {
                    com.baidu.tieba.aiapps.apps.a.a.aXo().a((GetUserInfoResult) null);
                }
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        h.adb().putString("bd_box_display_name", getUserInfoResult.displayname);
                        h.adb().putString("bd_box_uid", getUserInfoResult.uid);
                        h.adb().putString("bd_box_avatar_url", getUserInfoResult.portraitHttps);
                        h.adb().putString("bd_box_bduss", SapiAccountManager.getInstance().getSession().bduss);
                        h.adb().putString("bd_box_ptoken", SapiAccountManager.getInstance().getSession().getPtoken());
                        com.baidu.tieba.aiapps.apps.a.a.aXo().a(getUserInfoResult);
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
    }

    private static void aXn() {
        SwanAppInitHelper.initModules(TbadkCoreApplication.getInst(), false);
        if (Build.VERSION.SDK_INT > 21 && !TbadkCoreApplication.getInst().isRemoteProcess()) {
            com.baidu.tieba.aiapps.apps.n.a.aYT();
            if (ProcessUtils.isMainProcess() && !c.dkm()) {
                c.initialize(AppRuntime.getAppContext());
            }
            com.baidu.tieba.aiapps.apps.a.a.aXo().init(TbadkCoreApplication.getInst());
            com.baidu.tieba.aiapps.apps.share.c.aYR().eB(TbadkCoreApplication.getInst());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Uri uri) {
        List<String> pathSegments;
        if (uri != null && (pathSegments = uri.getPathSegments()) != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", pathSegments.get(0));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
