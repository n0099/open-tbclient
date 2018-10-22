package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.pyramid.runtime.multiprocess.g;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener;
import com.baidu.searchbox.ng.ai.apps.env.AiAppEnv;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreControl;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.aiapps.apps.abtest.msg.DecryptCodeHttpRespMsg;
import com.baidu.tieba.aiapps.apps.abtest.msg.DecryptCodeReqMsg;
import com.baidu.tieba.aiapps.apps.abtest.msg.DecryptCodeSocketRespMsg;
import com.baidu.tieba.aiapps.apps.q.d;
import com.baidu.tieba.e;
import com.baidu.ubc.q;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes4.dex */
public class AiAppAbTestStatic {
    static {
        AppRuntimeInit.onApplicationattachBaseContext(TbadkCoreApplication.getInst());
        b.Wg();
        g.onApplicationattachBaseContext(TbadkCoreApplication.getInst());
        g.a(new d());
        if (com.baidu.pyramid.runtime.multiprocess.a.uh()) {
            q.bPP();
        }
        WebViewFactory.initOnAppStart(TbadkCoreApplication.getInst(), true, false);
        NgWebViewInitHelper.getInstance().initBWebkit();
        com.facebook.drawee.a.a.c.initialize(TbadkCoreApplication.getInst());
        PresetSwanCoreControl.setNeedUpdateFlag(true);
        NgWebViewInitHelper.getInstance().addInitListener(new NgWebViewInitListener() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.1
            @Override // com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener
            public void onInitFinished() {
                AiAppEnv.get().initIfNecessary();
            }
        });
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tieba.aiapps.apps.a.start();
                return null;
            }
        }.execute(new Void[0]);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(final CustomMessage<String> customMessage) {
                if (customMessage != null && !StringUtils.isNULL(customMessage.getData())) {
                    Activity fX = com.baidu.adp.base.a.fW().fX();
                    if (fX != null) {
                        if (Build.VERSION.SDK_INT <= 21) {
                            l.showToast(fX, e.j.ai_apps_not_support);
                            return null;
                        }
                        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
                        aVar.Di();
                        aVar.c(fX, "android.permission.WRITE_EXTERNAL_STORAGE");
                        aVar.a(new a.InterfaceC0126a() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0126a
                            public void Dj() {
                                SchemeRouter.invokeSchemeForInner(TbadkCoreApplication.getInst(), Uri.parse((String) customMessage.getData()));
                            }
                        });
                        aVar.z(fX);
                        return null;
                    }
                    SchemeRouter.invokeSchemeForInner(TbadkCoreApplication.getInst(), Uri.parse(customMessage.getData()));
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921377) { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                    decryptCodeReqMsg.setCode((String) customResponsedMessage.getData());
                    MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_DECRYPT_AI_APP_CODE, 309626) { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.5
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                PopupWindow a;
                Activity fX;
                com.baidu.tieba.aiapps.apps.abtest.msg.a aVar = null;
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    aVar = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    aVar = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                }
                if (aVar != null && (a = com.baidu.tieba.aiapps.apps.b.a(aVar)) != null && (fX = com.baidu.adp.base.a.fW().fX()) != null && fX.getWindow() != null) {
                    try {
                        a.showAtLocation(fX.getWindow().getDecorView(), 17, 0, 0);
                    } catch (Exception e) {
                    }
                }
            }
        });
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DECRYPT_AI_APP_CODE, com.baidu.tieba.tbadkCore.a.a.aT(TbConfig.DECRYPT_AI_APP_CODE, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        ay.CU().a(new ay.a() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.6
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.startsWith("tiebaclient:")) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                if (str.contains("tbcfrom=web_search")) {
                    String str2 = "";
                    try {
                        String substring = str.substring("tiebaclient://swan/".length());
                        str2 = substring.substring(0, substring.lastIndexOf(47));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    TiebaStatic.log(new am("c13274").ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(VideoPlayActivityConfig.OBJ_ID, str2).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "web_search"));
                }
                return 0;
            }
        });
    }
}
