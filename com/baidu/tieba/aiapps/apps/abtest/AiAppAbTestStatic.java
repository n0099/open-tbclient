package com.baidu.tieba.aiapps.apps.abtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.pyramid.runtime.multiprocess.f;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener;
import com.baidu.searchbox.ng.ai.apps.env.AiAppEnv;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreControl;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.tbadk.BdToken.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tieba.aiapps.apps.p.d;
import com.baidu.tieba.e;
import com.baidu.ubc.q;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes4.dex */
public class AiAppAbTestStatic {
    public static int bFe = 0;

    static {
        Xx();
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(final CustomMessage<String> customMessage) {
                if (customMessage != null && !StringUtils.isNULL(customMessage.getData())) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        l.showToast(TbadkCoreApplication.getInst(), e.j.ai_apps_not_support);
                        return null;
                    }
                    Activity fX = com.baidu.adp.base.a.fW().fX();
                    if (fX != null) {
                        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
                        aVar.Et();
                        aVar.c(fX, "android.permission.WRITE_EXTERNAL_STORAGE");
                        aVar.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.1.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0160a
                            public void Eu() {
                                if (AiAppAbTestStatic.bFe == 0) {
                                    try {
                                        BdSailorWebView bdSailorWebView = new BdSailorWebView(TbadkCoreApplication.getInst());
                                        AiAppAbTestStatic.bFe = 1;
                                        bdSailorWebView.destroy();
                                    } catch (Exception e) {
                                        AiAppAbTestStatic.bFe = -1;
                                        return;
                                    }
                                }
                                if (AiAppAbTestStatic.bFe < 0) {
                                    l.showToast(TbadkCoreApplication.getInst(), e.j.ai_apps_not_support);
                                    return;
                                }
                                SchemeRouter.invokeSchemeForInner(TbadkCoreApplication.getInst(), Uri.parse((String) customMessage.getData()));
                            }
                        });
                        aVar.A(fX);
                        return null;
                    }
                    if (AiAppAbTestStatic.bFe == 0) {
                        try {
                            BdSailorWebView bdSailorWebView = new BdSailorWebView(TbadkCoreApplication.getInst());
                            AiAppAbTestStatic.bFe = 1;
                            bdSailorWebView.destroy();
                        } catch (Exception e) {
                            AiAppAbTestStatic.bFe = -1;
                        }
                    }
                    if (AiAppAbTestStatic.bFe < 0) {
                        l.showToast(TbadkCoreApplication.getInst(), e.j.ai_apps_not_support);
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921377) { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                onMessage2((CustomResponsedMessage) customResponsedMessage);
            }

            /* renamed from: onMessage  reason: avoid collision after fix types in other method */
            public void onMessage2(CustomResponsedMessage customResponsedMessage) {
                PopupWindow a;
                Activity fX;
                if ((customResponsedMessage.getData() instanceof g) && (a = com.baidu.tieba.aiapps.apps.b.a((g) customResponsedMessage.getData())) != null && (fX = com.baidu.adp.base.a.fW().fX()) != null && fX.getWindow() != null) {
                    try {
                        a.showAtLocation(fX.getWindow().getDecorView(), 17, 0, 0);
                    } catch (Exception e) {
                    }
                }
            }
        });
        ay.Ef().a(new ay.a() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.3
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
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
                                TiebaStatic.log(new am("c13274").aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(VideoPlayActivityConfig.OBJ_ID, str).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "web_search").aA("obj_name", str3));
                                return 0;
                            }
                        }
                    } catch (Exception e3) {
                        str = "";
                        e = e3;
                    }
                    TiebaStatic.log(new am("c13274").aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(VideoPlayActivityConfig.OBJ_ID, str).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "web_search").aA("obj_name", str3));
                }
                return 0;
            }
        });
    }

    private static void Xx() {
        AppRuntimeInit.onApplicationattachBaseContext(TbadkCoreApplication.getInst());
        f.onApplicationattachBaseContext(TbadkCoreApplication.getInst());
        if (Build.VERSION.SDK_INT > 21 && !TbadkCoreApplication.getInst().isRemoteProcess()) {
            b.Xy();
            f.a(new d());
            if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
                q.bSk();
            }
            WebViewFactory.initOnAppStart(TbadkCoreApplication.getInst(), true, false);
            NgWebViewInitHelper.getInstance().initBWebkit();
            com.facebook.drawee.a.a.c.initialize(TbadkCoreApplication.getInst());
            PresetSwanCoreControl.setNeedUpdateFlag(true);
            NgWebViewInitHelper.getInstance().addInitListener(new NgWebViewInitListener() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.4
                @Override // com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener
                public void onInitFinished() {
                    AiAppEnv.get().initIfNecessary();
                }
            });
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.aiapps.apps.abtest.AiAppAbTestStatic.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.tieba.aiapps.apps.a.start();
                    return null;
                }
            }.execute(new Void[0]);
        }
    }
}
