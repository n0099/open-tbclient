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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.tbadk.BdToken.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class SwanAppAbTestStatic {
    public static int cRc = 0;

    static {
        axW();
        CustomMessageTask customMessageTask = new CustomMessageTask(2921361, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(final CustomMessage<String> customMessage) {
                if (customMessage != null && !StringUtils.isNULL(customMessage.getData())) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        l.showToast(TbadkCoreApplication.getInst(), d.j.ai_apps_not_support);
                        return null;
                    }
                    Activity fU = com.baidu.adp.base.a.fT().fU();
                    if (fU != null) {
                        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
                        aVar.adN();
                        aVar.e(fU, "android.permission.WRITE_EXTERNAL_STORAGE");
                        aVar.a(new a.InterfaceC0227a() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.1.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0227a
                            public void adO() {
                                SchemeRouter.invokeSchemeForInner(TbadkCoreApplication.getInst(), Uri.parse((String) customMessage.getData()));
                            }
                        });
                        aVar.Y(fU);
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
        MessageManager.getInstance().registerListener(new CustomMessageListener(2921377) { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                onMessage2((CustomResponsedMessage) customResponsedMessage);
            }

            /* renamed from: onMessage  reason: avoid collision after fix types in other method */
            public void onMessage2(CustomResponsedMessage customResponsedMessage) {
                PopupWindow a;
                Activity fU;
                if ((customResponsedMessage.getData() instanceof g) && (a = com.baidu.tieba.aiapps.apps.d.a((g) customResponsedMessage.getData())) != null && (fU = com.baidu.adp.base.a.fT().fU()) != null && fU.getWindow() != null) {
                    try {
                        a.showAtLocation(fU.getWindow().getDecorView(), 17, 0, 0);
                    } catch (Exception e) {
                    }
                }
            }
        });
        ba.adA().a(new ba.a() { // from class: com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
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
                                TiebaStatic.log(new am("c13274").bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(VideoPlayActivityConfig.OBJ_ID, str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "web_search").bJ("obj_name", str3));
                                return 0;
                            }
                        }
                    } catch (Exception e3) {
                        str = "";
                        e = e3;
                    }
                    TiebaStatic.log(new am("c13274").bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(VideoPlayActivityConfig.OBJ_ID, str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "web_search").bJ("obj_name", str3));
                }
                return 0;
            }
        });
    }

    private static void axW() {
        com.baidu.tieba.aiapps.apps.c.a(TbadkCoreApplication.getInst(), true);
        if (Build.VERSION.SDK_INT > 21 && !TbadkCoreApplication.getInst().isRemoteProcess()) {
            com.baidu.tieba.aiapps.apps.b.axQ();
        }
    }
}
