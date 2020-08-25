package com.baidu.tieba.frs;

import android.content.Context;
import android.net.Uri;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceSocketResponseMessage;
import com.baidu.tieba.frs.achievement.AchievementActivity;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.frs.dynamic.FrsDynamicHttpResponseMessage;
import com.baidu.tieba.frs.dynamic.FrsDynamicSocketResponsedMessage;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.frs.movearea.FrsMoveAreaResMsg;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.webkit.internal.ETAG;
import java.net.URLDecoder;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes16.dex */
public class FrsActivityStatic {
    public static boolean hRV = true;
    public static boolean hRW = true;
    public static String forumName = "";
    public static final CustomMessageListener hRX = new CustomMessageListener(CmdConfigCustom.MSG_NEW) { // from class: com.baidu.tieba.frs.FrsActivityStatic.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue == 1 || intValue == 4 || intValue == 3 || intValue == 2) {
                    FrsActivityStatic.hRW = true;
                    FrsActivityStatic.hRV = true;
                    return;
                }
                FrsActivityStatic.hRW = false;
                FrsActivityStatic.hRV = false;
            }
        }
    };
    private static final CustomMessageListener hRY = new CustomMessageListener(CmdConfigCustom.MSG_READ) { // from class: com.baidu.tieba.frs.FrsActivityStatic.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                int i = com.baidu.adp.lib.f.b.toInt(customResponsedMessage.getData().toString(), 1);
                if (i == 1 || i == 0) {
                    FrsActivityStatic.hRW = false;
                    FrsActivityStatic.hRV = false;
                }
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        clo();
        clj();
        clk();
        cll();
        clm();
        cln();
        LocationModel.dxo();
        clr();
        clp();
        cls();
        clu();
        MessageManager.getInstance().registerListener(hRX);
        MessageManager.getInstance().registerListener(hRY);
        clq();
        clt();
        bFx();
        clv();
    }

    private static void clj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    int requestCode = customMessage.getData().getRequestCode();
                    if (requestCode == 0) {
                        customMessage.getData().startActivity(FrsActivity.class);
                    } else {
                        customMessage.getData().startActivityForResult(requestCode, FrsActivity.class);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        TbadkApplication.getInst().RegisterIntent(AchievementActivityConfig.class, AchievementActivity.class);
    }

    private static void clk() {
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

    private static void cll() {
        com.baidu.tbadk.core.util.be.bju().a(new be.a() { // from class: com.baidu.tieba.frs.FrsActivityStatic.5
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String substring;
                boolean z;
                boolean z2;
                String str;
                int i = 0;
                if (strArr == null || strArr[0] == null || tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                String str2 = strArr.length > 1 ? strArr[1] : null;
                int i2 = com.baidu.adp.lib.f.b.toInt(com.baidu.tbadk.util.ai.getMatchStringFromURL(lowerCase, "call_from="), 0);
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
                            r1 = URLDecoder.decode(str);
                        }
                    } else {
                        z = false;
                    }
                    z2 = false;
                    i = com.baidu.adp.lib.f.b.toInt(com.baidu.tbadk.util.ai.getMatchStringFromURL(lowerCase, "default_tab_id="), 0);
                } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
                    r1 = lowerCase.substring(4);
                    z = true;
                    z2 = false;
                } else if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                    r1 = lowerCase.substring("com.baidu.tieba://?tname=".length());
                    z = false;
                    z2 = true;
                } else if (lowerCase.contains("jump_tieba_native=1") && lowerCase.contains("kw=")) {
                    r1 = com.baidu.tbadk.util.ai.getMatchStringFromURL(lowerCase, "kw=");
                    if (!TextUtils.isEmpty(r1)) {
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r1, str2);
                        if (i2 > 0) {
                            createNormalCfg.setCallFrom(i2);
                        } else {
                            createNormalCfg.setCallFrom(12);
                        }
                        if (lowerCase.contains(TbConfig.WEB_VIEW_NEED_FRESH)) {
                            createNormalCfg.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
                        }
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                        return 0;
                    }
                    z = false;
                    z2 = false;
                } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_GAME_FRS_TAB)) {
                    String matchStringFromURL = com.baidu.tbadk.util.ai.getMatchStringFromURL(lowerCase, "kw=");
                    z2 = false;
                    i = com.baidu.adp.lib.f.b.toInt(com.baidu.tbadk.util.ai.getMatchStringFromURL(lowerCase, "tab_id="), 0);
                    r1 = matchStringFromURL;
                    z = false;
                } else if (lowerCase.contains("com.baidu.tieba://unidispatch/frs?kw=")) {
                    Uri parse = Uri.parse(lowerCase);
                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parse != null ? parse.getQueryParameter("kw") : null, str2);
                    if (lowerCase.contains("achievement")) {
                        createNormalCfg2.setAchievementUrl(lowerCase);
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                    return 0;
                } else {
                    return 3;
                }
                if (!TextUtils.isEmpty(r1)) {
                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r1, str2);
                    if (i != 0) {
                        createNormalCfg3.setDefaultGameTabId(i);
                    }
                    if (i2 > 0) {
                        createNormalCfg3.setCallFrom(i2);
                    } else {
                        createNormalCfg3.setCallFrom(12);
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                    return 1;
                } else if (z2 && !TextUtils.isEmpty(r1)) {
                    com.baidu.adp.lib.f.f.startService(TbadkCoreApplication.getInst(), com.baidu.tieba.frs.f.i.aF(TbadkCoreApplication.getInst(), r1));
                    com.baidu.tieba.frs.f.h.cu(2, 2);
                    return 1;
                } else if (z) {
                    tbPageContext.showToast(R.string.page_not_found);
                    return 1;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void clm() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_KV_CACHE_SUCC) { // from class: com.baidu.tieba.frs.FrsActivityStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                    if (com.baidu.tieba.recapp.r.dnh().dnb() != null) {
                        com.baidu.tieba.recapp.r.dnh().dnb().dmT();
                    }
                    if (com.baidu.tieba.recapp.r.dnh().dnc() != null) {
                        com.baidu.tieba.recapp.r.dnh().dnc().dmU();
                    }
                }
            }
        });
    }

    private static void cln() {
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

    public static void clo() {
        com.baidu.tbadk.ala.b.bar().a(1, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.frs.FrsActivityStatic.10
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dO = com.baidu.tbadk.ala.c.dO(context);
                if (dO != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(dO, R.color.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds8), 0);
                    layoutParams.gravity = 16;
                    dO.setLayoutParams(layoutParams);
                }
                return dO;
            }
        });
    }

    public static void clp() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_PAGE, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001703, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.FRS_ADDRESS, CmdConfigSocket.CMD_FRS_PAGE));
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
                com.baidu.tbadk.util.aj.a(com.baidu.tieba.tbadkCore.m.WIRE, FrsPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void clq() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_FRS_LOAD_MORE, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001704, com.baidu.tieba.tbadkCore.a.a.bH(FrsLoadMoreModel.LOAD_MORE_URL, CmdConfigSocket.CMD_FRS_LOAD_MORE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void clr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof TbPageContext)) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, new r(customMessage.getData(), s.hWl));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void cls() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_DYNAMIC, FrsDynamicSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003398, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.FRS_DYNAMIC_ADDRESS, CmdConfigSocket.CMD_FRS_DYNAMIC));
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
                com.baidu.tbadk.util.aj.a(com.baidu.tieba.frs.dynamic.a.WIRE, StarTrendsResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void clt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_MOVE_AREA, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_MOVE_AREA);
        tbHttpMessageTask.setResponsedClass(FrsMoveAreaResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bFx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_RECOMMEND, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_RECOMMEND);
        tbHttpMessageTask.setResponsedClass(FrsRecommendResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void clu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
        tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void clv() {
        com.baidu.tieba.tbadkCore.a.a.a(309667, GetLiveHorseRaceSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309667, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, TbConfig.URL_FRS_LIVE_HORSERACE_LIST, GetLiveHorseRaceHttpResponseMessage.class, true, false, true, false);
    }
}
