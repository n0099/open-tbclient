package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.forumtest.ForumTestActivity;
import com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity;
import com.baidu.tieba.enterForum.model.EnterForumAdModel;
import com.baidu.tieba.enterForum.model.EnterForumAdResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpTestCloseMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketTestCloseMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static com.baidu.adp.lib.guide.c gGE;
    private static EnterForumModel iIJ;
    public static EnterForumAdModel iIK;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = new EnterForumTabFragment();
        cVar.type = 1;
        cVar.textResId = R.string.enter_forum;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWBOTH;
        cVar.animationResId = R.raw.lottie_tab_forum;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c fragmentTabStructure;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                        EnterForumDelegateStatic.iIK.loadAd();
                    }
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (fragmentTabStructure = enterForumDelegateStatic.getFragmentTabStructure()) != null && !fragmentTabStructure.frag.isAdded()) {
                        fragmentTabStructure.frag.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(3);
        MessageManager.getInstance().registerListener(customMessageListener);
        if (l.isMainThread()) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_TOPIC_TIP_DISMISS) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                    if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_TIP_SHOW + TbadkCoreApplication.getCurrentAccount(), false) && com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_ATTENTION_CHECK_COUNT + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EnterForumDelegateStatic.am((Activity) customResponsedMessage.getData());
                            }
                        });
                    }
                }
            });
        }
        TbadkCoreApplication.getInst().RegisterIntent(ForumTestActivityConfig.class, ForumTestActivity.class);
        cvT();
        cvU();
        cvV();
        cvW();
        cvX();
        cvZ();
        TbadkCoreApplication.getInst().RegisterIntent(HotUserRankActivityConfig.class, HotUserRankActivity.class);
        cvY();
        cwb();
        cvR();
        cvS();
        cwa();
        cwc();
    }

    private static void cvR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921479, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                com.baidu.tieba.enterForum.b.a.cvJ().cvK();
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cvS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921483, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.11
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(2921483, com.baidu.tieba.enterForum.b.a.cvJ().cvL());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.enterForum.b.a.cvJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void am(final Activity activity) {
        com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_ATTENTION_CHECK_COUNT + TbadkCoreApplication.getCurrentAccount(), com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_ATTENTION_CHECK_COUNT + TbadkCoreApplication.getCurrentAccount(), 0) + 1);
        af.a(new ae<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.12
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ae
            public Boolean doInBackground() {
                aa aaVar = new aa();
                aaVar.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                aaVar.addPostData("uid", TbadkCoreApplication.getCurrentAccount());
                String postNetData = aaVar.postNetData();
                if (aaVar.isNetSuccess() && aaVar.getServerErrorCode() == 0) {
                    try {
                        return Boolean.valueOf(new JSONObject(postNetData).optInt("live_bar_concerned", 0) == 1);
                    } catch (JSONException e) {
                        return false;
                    }
                }
                return false;
            }
        }, new m<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    EnterForumDelegateStatic.an(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void an(final Activity activity) {
        if (gGE != null) {
            gGE.dismiss();
        }
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.14
            @Override // java.lang.Runnable
            public void run() {
                if (EnterForumDelegateStatic.gGE != null) {
                    EnterForumDelegateStatic.gGE.dismiss();
                }
            }
        };
        com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
        dVar.ab(true);
        dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.15
            @Override // com.baidu.adp.lib.guide.d.a
            public void onShown() {
            }

            @Override // com.baidu.adp.lib.guide.d.a
            public void onDismiss() {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_TIP_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                com.baidu.adp.lib.guide.c unused = EnterForumDelegateStatic.gGE = null;
                handler.removeCallbacks(runnable);
            }
        });
        dVar.y(activity.getWindow().getDecorView()).an(20).ac(false);
        dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.16
            @Override // com.baidu.adp.lib.guide.b
            public View getView(LayoutInflater layoutInflater) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, R.layout.enter_forum_ufan_tip, null);
                TextView textView = (TextView) bubbleLayout.findViewById(R.id.enter_forum_ufan_guide_tv);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.16.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EnterForumDelegateStatic.gGE.dismiss();
                    }
                });
                ap.setViewTextColor(textView, R.color.CAM_X0101);
                bubbleLayout.Lc(ap.getColor(R.color.cp_link_tip_a_alpha95));
                return bubbleLayout;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getAnchor() {
                return 4;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getFitPosition() {
                return 16;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getXOffset() {
                return l.getEquipmentDensity(activity) > 0.0f ? (int) ((activity.getResources().getDimensionPixelSize(R.dimen.ds52) * 2) / l.getEquipmentDensity(activity)) : activity.getResources().getDimensionPixelSize(R.dimen.ds52);
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getYOffset() {
                int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.ds46) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (UtilHelper.getVirtualBarHeight(activity) > 0 || MenuKeyUtils.hasSmartBar()) {
                    dimensionPixelSize -= l.getDimens(activity, R.dimen.ds20);
                }
                if (l.getEquipmentDensity(activity) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / l.getEquipmentDensity(activity));
                }
                return dimensionPixelSize;
            }
        });
        gGE = dVar.lF();
        gGE.show(activity);
        handler.postDelayed(runnable, 5000L);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        return this.mIndicator;
    }

    private static void cvT() {
        com.baidu.tieba.tbadkCore.d.c.dNY();
        if (iIJ == null) {
            iIJ = new EnterForumModel(null);
            iIJ.a(new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2
                @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
                public void a(EnterForumModel.a aVar) {
                    g cvd = aVar.iLU.cvd();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = cvd.cvz().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getName());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(CmdConfigCustom.CMD_ENTER_FORUM_INFO, arrayList));
                }
            });
        }
        if (iIK == null) {
            iIK = new EnterForumAdModel();
            iIK.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj instanceof com.baidu.tieba.enterForum.data.b) {
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && EnterForumDelegateStatic.iIJ.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        EnterForumDelegateStatic.iIJ.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        EnterForumDelegateStatic.iIJ.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                    if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                        EnterForumDelegateStatic.iIJ.pU(true);
                    } else {
                        EnterForumDelegateStatic.iIJ.pT(true);
                    }
                }
            }
        });
    }

    private static void cvU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.c.c> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA, new d());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cvV() {
        com.baidu.tieba.tbadkCore.a.a.a(309630, ResponseSocketRecommendMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309630, CmdConfigHttp.CMD_RECOMMEND_FORUM, TbConfig.URL_ENTER_RECOMMEND_FORUM, ResponseHttpRecommendMessage.class, false, false, true, false);
    }

    private static void cvW() {
        com.baidu.tieba.tbadkCore.a.a.a(309633, ResponseSocketTestCloseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309633, CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE, TbConfig.URL_RECOMMEND_FORUM_TEST_CLOSE, ResponseHttpTestCloseMessage.class, false, false, true, false);
    }

    private static void cvX() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST, TbConfig.URL_ENTER_FORUM_AD, EnterForumAdResponsedMessage.class, false, false, true, false);
    }

    private static void cvY() {
        com.baidu.tieba.tbadkCore.a.a.a(309651, TabFeedListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309651, CmdConfigHttp.CMD_TAB_FEED_LIST, TbConfig.URL_TAB_FEED_LIST, TabFeedListHttpResponsedMessage.class, false, false, true, false);
    }

    private static void cvZ() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, 1002400, Config.FORUM_RECOMMEND, forumRecommendHttpResponseMessage.class, false, false, false, false);
    }

    private static void cwa() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HISTORY_FORUM, RecentlyVisitedForumSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HISTORY_FORUM, 1003394, Config.GET_HISTORY_FORUM, RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.c(1003395, Config.DELETE_HISTORY_FORUM, null, false, false, false, false);
    }

    private static void cwb() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("unidispatch/hotuserrank")) {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(tbPageContext.getPageActivity());
                    hotUserRankActivityConfig.setUri(Uri.parse(lowerCase));
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                    return 0;
                }
                return 3;
            }
        });
    }

    private static void cwc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921519, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
                String data = customMessage.getData();
                VisitedForumData visitedForumData = new VisitedForumData();
                visitedForumData.setForumId(data);
                com.baidu.tieba.enterForum.b.a.cvJ().c(visitedForumData);
                TiebaStatic.log(new ar("c13005").dR("fid", data));
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.enterForum.b.a.cvJ();
    }
}
