package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.dynamic.FrsDynamicHttpResponseMessage;
import com.baidu.tieba.frs.dynamic.FrsDynamicSocketResponsedMessage;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import java.net.URLDecoder;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes2.dex */
public class FrsActivityStatic {
    public static boolean dgT = true;
    public static boolean dgU = true;
    public static String forumName = "";
    public static final CustomMessageListener dgV = new CustomMessageListener(2012111) { // from class: com.baidu.tieba.frs.FrsActivityStatic.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue == 1 || intValue == 4 || intValue == 3 || intValue == 2) {
                    FrsActivityStatic.dgU = true;
                    FrsActivityStatic.dgT = true;
                    return;
                }
                FrsActivityStatic.dgU = false;
                FrsActivityStatic.dgT = false;
            }
        }
    };
    private static final CustomMessageListener dgW = new CustomMessageListener(2012112) { // from class: com.baidu.tieba.frs.FrsActivityStatic.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                int g = com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), 1);
                if (g == 1 || g == 0) {
                    FrsActivityStatic.dgU = false;
                    FrsActivityStatic.dgT = false;
                }
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        asX();
        asS();
        asT();
        asU();
        asV();
        asW();
        LocationModel.bxM();
        ata();
        asY();
        atb();
        MessageManager.getInstance().registerListener(dgV);
        MessageManager.getInstance().registerListener(dgW);
        asZ();
        com.baidu.tieba.frs.FrsHotTopic.a.atP();
    }

    private static void asS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(FrsActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void asT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(FrsActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void asU() {
        ay.zG().a(new ay.a() { // from class: com.baidu.tieba.frs.FrsActivityStatic.5
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                String substring;
                boolean z;
                boolean z2;
                String str;
                String str2 = null;
                int i = 0;
                if (strArr == null || strArr[0] == null || tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                String str3 = strArr.length > 1 ? strArr[1] : null;
                if (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                    if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                        substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
                    } else {
                        substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring("http://tieba.baidu.com/f?".length()) : null;
                    }
                    if (substring != null) {
                        String[] split = substring.split("&");
                        int i2 = 0;
                        while (true) {
                            if (i2 >= split.length) {
                                z = false;
                                str = null;
                                break;
                            } else if (split[i2] == null || !split[i2].startsWith("kw=")) {
                                i2++;
                            } else {
                                str = split[i2].substring(3);
                                z = true;
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str2 = URLDecoder.decode(str);
                        }
                    } else {
                        z = false;
                    }
                    z2 = false;
                } else if (lowerCase.startsWith("frs:")) {
                    str2 = lowerCase.substring(4);
                    z = true;
                    z2 = false;
                } else if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                    str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
                    z = false;
                    z2 = true;
                } else if (lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kw=")) {
                    str2 = com.baidu.tbadk.util.aa.ax(lowerCase, "kw=");
                    if (!TextUtils.isEmpty(str2)) {
                        tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
                        return 0;
                    }
                    z = false;
                    z2 = false;
                } else if (!lowerCase.startsWith("tblaunch://tieba.baidu.com/f?")) {
                    return 3;
                } else {
                    String ax = com.baidu.tbadk.util.aa.ax(lowerCase, "kw=");
                    z2 = false;
                    i = com.baidu.adp.lib.g.b.g(com.baidu.tbadk.util.aa.ax(lowerCase, "tab_id="), 0);
                    str2 = ax;
                    z = false;
                }
                if (!TextUtils.isEmpty(str2)) {
                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3);
                    if (i != 0) {
                        createNormalCfg.setDefaultGameTabId(i);
                    }
                    tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg));
                    return 1;
                } else if (z2 && !TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.g.f.e(TbadkCoreApplication.getInst(), com.baidu.tieba.frs.f.i.ac(TbadkCoreApplication.getInst(), str2));
                    com.baidu.tieba.frs.f.h.aM(2, 2);
                    return 1;
                } else if (z) {
                    tbPageContext.showToast(d.k.page_not_found);
                    return 1;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void asV() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001012) { // from class: com.baidu.tieba.frs.FrsActivityStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                    com.baidu.tieba.frs.smartsort.a.ayI().ayK();
                    if (com.baidu.tieba.recapp.r.boj().bod() != null) {
                        com.baidu.tieba.recapp.r.boj().bod().bnU();
                    }
                    if (com.baidu.tieba.recapp.r.boj().boe() != null) {
                        com.baidu.tieba.recapp.r.boj().boe().bnV();
                    }
                }
            }
        });
    }

    private static void asW() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016501) { // from class: com.baidu.tieba.frs.FrsActivityStatic.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    com.baidu.tieba.frs.f.g.clearAll();
                }
            }
        });
    }

    public static void asX() {
        com.baidu.tbadk.ala.b.rM().a(1, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.frs.FrsActivityStatic.10
            @Override // com.baidu.tbadk.ala.d
            public View aA(Context context) {
                TextView az = com.baidu.tbadk.ala.c.az(context);
                if (az != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.al.h(az, d.C0141d.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds8), 0, com.baidu.adp.lib.util.l.e(context, d.e.ds8), 0);
                    layoutParams.gravity = 16;
                    az.setLayoutParams(layoutParams);
                }
                return az;
            }
        });
    }

    public static void asY() {
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aN(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.11
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.ab.a(com.baidu.tieba.tbadkCore.i.WIRE, FrsPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void asZ() {
        com.baidu.tieba.tbadkCore.a.a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, com.baidu.tieba.tbadkCore.a.a.aN(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ata() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921336, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<f> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof TbPageContext)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921336, new j(customMessage.getData(), k.djW));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void atb() {
        com.baidu.tieba.tbadkCore.a.a.a(309602, FrsDynamicSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_DYNAMIC, com.baidu.tieba.tbadkCore.a.a.aN(TbConfig.FRS_DYNAMIC_ADDRESS, 309602));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsDynamicHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.ab.a(com.baidu.tieba.frs.dynamic.b.WIRE, StarTrendsResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }
}
