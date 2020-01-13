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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.dynamic.FrsDynamicHttpResponseMessage;
import com.baidu.tieba.frs.dynamic.FrsDynamicSocketResponsedMessage;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.webkit.internal.ETAG;
import java.net.URLDecoder;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes7.dex */
public class FrsActivityStatic {
    public static boolean gls = true;
    public static boolean glt = true;
    public static String forumName = "";
    public static final CustomMessageListener glu = new CustomMessageListener(CmdConfigCustom.MSG_NEW) { // from class: com.baidu.tieba.frs.FrsActivityStatic.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue == 1 || intValue == 4 || intValue == 3 || intValue == 2) {
                    FrsActivityStatic.glt = true;
                    FrsActivityStatic.gls = true;
                    return;
                }
                FrsActivityStatic.glt = false;
                FrsActivityStatic.gls = false;
            }
        }
    };
    private static final CustomMessageListener glv = new CustomMessageListener(CmdConfigCustom.MSG_READ) { // from class: com.baidu.tieba.frs.FrsActivityStatic.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                int i = com.baidu.adp.lib.f.b.toInt(customResponsedMessage.getData().toString(), 1);
                if (i == 1 || i == 0) {
                    FrsActivityStatic.glt = false;
                    FrsActivityStatic.gls = false;
                }
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        bBL();
        bBG();
        bBH();
        bBI();
        bBJ();
        bBK();
        LocationModel.cKk();
        bBO();
        bBM();
        bBP();
        MessageManager.getInstance().registerListener(glu);
        MessageManager.getInstance().registerListener(glv);
        bBN();
    }

    private static void bBG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.1
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

    private static void bBH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.4
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

    private static void bBI() {
        ba.aEt().a(new ba.a() { // from class: com.baidu.tieba.frs.FrsActivityStatic.5
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
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
                int i2 = com.baidu.adp.lib.f.b.toInt(com.baidu.tbadk.util.ag.getMatchStringFromURL(lowerCase, "call_from="), 0);
                if (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                    if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                        substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
                    } else {
                        substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring("http://tieba.baidu.com/f?".length()) : null;
                    }
                    if (substring != null) {
                        String[] split = substring.split(ETAG.ITEM_SEPARATOR);
                        int i3 = 0;
                        while (true) {
                            if (i3 >= split.length) {
                                z = false;
                                str = null;
                                break;
                            } else if (split[i3] == null || !split[i3].startsWith("kw=")) {
                                i3++;
                            } else {
                                str = split[i3].substring(3);
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
                    i = com.baidu.adp.lib.f.b.toInt(com.baidu.tbadk.util.ag.getMatchStringFromURL(lowerCase, "default_tab_id="), 0);
                } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
                    str2 = lowerCase.substring(4);
                    z = true;
                    z2 = false;
                } else if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                    str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
                    z = false;
                    z2 = true;
                } else if (lowerCase.contains("jump_tieba_native=1") && lowerCase.contains("kw=")) {
                    str2 = com.baidu.tbadk.util.ag.getMatchStringFromURL(lowerCase, "kw=");
                    if (!TextUtils.isEmpty(str2)) {
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3);
                        if (i2 > 0) {
                            createNormalCfg.setCallFrom(i2);
                        } else {
                            createNormalCfg.setCallFrom(12);
                        }
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                        return 0;
                    }
                    z = false;
                    z2 = false;
                } else if (!lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_GAME_FRS_TAB)) {
                    return 3;
                } else {
                    String matchStringFromURL = com.baidu.tbadk.util.ag.getMatchStringFromURL(lowerCase, "kw=");
                    z2 = false;
                    i = com.baidu.adp.lib.f.b.toInt(com.baidu.tbadk.util.ag.getMatchStringFromURL(lowerCase, "tab_id="), 0);
                    str2 = matchStringFromURL;
                    z = false;
                }
                if (!TextUtils.isEmpty(str2)) {
                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3);
                    if (i != 0) {
                        createNormalCfg2.setDefaultGameTabId(i);
                    }
                    if (i2 > 0) {
                        createNormalCfg2.setCallFrom(i2);
                    } else {
                        createNormalCfg2.setCallFrom(12);
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                    return 1;
                } else if (z2 && !TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.f.f.startService(TbadkCoreApplication.getInst(), com.baidu.tieba.frs.f.i.aS(TbadkCoreApplication.getInst(), str2));
                    com.baidu.tieba.frs.f.h.bQ(2, 2);
                    return 1;
                } else if (z) {
                    tbPageContext.showToast((int) R.string.page_not_found);
                    return 1;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void bBJ() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_KV_CACHE_SUCC) { // from class: com.baidu.tieba.frs.FrsActivityStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                    if (com.baidu.tieba.recapp.r.cAV().cAP() != null) {
                        com.baidu.tieba.recapp.r.cAV().cAP().cAH();
                    }
                    if (com.baidu.tieba.recapp.r.cAV().cAQ() != null) {
                        com.baidu.tieba.recapp.r.cAV().cAQ().cAI();
                    }
                }
            }
        });
    }

    private static void bBK() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE) { // from class: com.baidu.tieba.frs.FrsActivityStatic.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    com.baidu.tieba.frs.f.g.clearAll();
                }
            }
        });
    }

    public static void bBL() {
        com.baidu.tbadk.ala.b.awm().a(1, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.frs.FrsActivityStatic.10
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dE = com.baidu.tbadk.ala.c.dE(context);
                if (dE != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.am.setViewTextColor(dE, (int) R.color.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), 0);
                    layoutParams.gravity = 16;
                    dE.setLayoutParams(layoutParams);
                }
                return dE;
            }
        });
    }

    public static void bBM() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_PAGE, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001703, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.FRS_ADDRESS, CmdConfigSocket.CMD_FRS_PAGE));
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
                com.baidu.tbadk.util.ah.a(com.baidu.tieba.tbadkCore.l.WIRE, FrsPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void bBN() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_FRS_LOAD_MORE, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001704, com.baidu.tieba.tbadkCore.a.a.bv(FrsLoadMoreModel.LOAD_MORE_URL, CmdConfigSocket.CMD_FRS_LOAD_MORE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bBO() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<h> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof TbPageContext)) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, new m(customMessage.getData(), n.goX));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void bBP() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_DYNAMIC, FrsDynamicSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003398, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.FRS_DYNAMIC_ADDRESS, CmdConfigSocket.CMD_FRS_DYNAMIC));
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
                com.baidu.tbadk.util.ah.a(com.baidu.tieba.frs.dynamic.a.WIRE, StarTrendsResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }
}
