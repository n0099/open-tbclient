package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.tbadk.BdToken.g;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AiAppGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.c;
import com.baidu.tieba.aiapps.apps.d;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanAppAbTestStatic {
    static {
        aFk();
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(final CustomMessage<String> customMessage) {
                if (customMessage != null && !StringUtils.isNull(customMessage.getData())) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.ai_apps_not_support);
                    } else {
                        Activity currentActivity = com.baidu.adp.base.a.em().currentActivity();
                        if (currentActivity != null) {
                            com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
                            aVar.clearRequestPermissionList();
                            aVar.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            aVar.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.1.1
                                @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0284a
                                public void onPermissionsGranted() {
                                    Uri parse = Uri.parse((String) customMessage.getData());
                                    SwanAppAbTestStatic.o(parse);
                                    SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse);
                                }
                            });
                            aVar.startRequestPermission(currentActivity);
                        } else {
                            Uri parse = Uri.parse(customMessage.getData());
                            SwanAppAbTestStatic.o(parse);
                            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), parse);
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
                if ((customResponsedMessage.getData() instanceof g) && (a = d.a((g) customResponsedMessage.getData())) != null && (currentActivity = com.baidu.adp.base.a.em().currentActivity()) != null && currentActivity.getWindow() != null) {
                    try {
                        a.showAtLocation(currentActivity.getWindow().getDecorView(), 17, 0, 0);
                    } catch (Exception e) {
                    }
                }
            }
        });
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.3
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
                                TiebaStatic.log(new an("c13274").bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_id", str).bS("obj_source", "web_search").bS("obj_name", str3));
                                return 0;
                            }
                        }
                    } catch (Exception e3) {
                        str = "";
                        e = e3;
                    }
                    TiebaStatic.log(new an("c13274").bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_id", str).bS("obj_source", "web_search").bS("obj_name", str3));
                }
                return 0;
            }
        });
        TbadkCoreApplication.getInst().RegisterIntent(AiAppGuideActivityConfig.class, AiAppGuideActivity.class);
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_BROWSE_HISTORY));
    }

    private static void aFk() {
        c.a(TbadkCoreApplication.getInst(), true);
        if (Build.VERSION.SDK_INT > 21 && !TbadkCoreApplication.getInst().isRemoteProcess()) {
            com.baidu.tieba.aiapps.apps.b.aFe();
            com.baidu.tieba.aiapps.apps.a.a.aFm().init(TbadkCoreApplication.getInst());
            com.baidu.tieba.aiapps.apps.share.c.aIo().di(TbadkCoreApplication.getInst());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(Uri uri) {
        List<String> pathSegments;
        if (uri != null && (pathSegments = uri.getPathSegments()) != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", pathSegments.get(0));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
