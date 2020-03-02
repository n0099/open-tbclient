package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.forumtest.ForumTestActivity;
import com.baidu.tieba.enterForum.model.EnterForumAdModel;
import com.baidu.tieba.enterForum.model.EnterForumAdResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpTestCloseMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketTestCloseMessage;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static com.baidu.adp.lib.guide.c eqX;
    private static EnterForumModel fUJ;
    public static EnterForumAdModel fUK;

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
                        EnterForumDelegateStatic.fUK.loadAd();
                    }
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (fragmentTabStructure = enterForumDelegateStatic.getFragmentTabStructure()) != null && !fragmentTabStructure.frag.isAdded()) {
                        fragmentTabStructure.frag.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
        if (l.isMainThread()) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_TOPIC_TIP_DISMISS) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                    if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_TIP_SHOW + TbadkCoreApplication.getCurrentAccount(), false) && com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_ATTENTION_CHECK_COUNT + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                        com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EnterForumDelegateStatic.al((Activity) customResponsedMessage.getData());
                            }
                        });
                    }
                }
            });
        }
        TbadkCoreApplication.getInst().RegisterIntent(ForumTestActivityConfig.class, ForumTestActivity.class);
        bye();
        byf();
        byg();
        byh();
        byi();
        byj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void al(final Activity activity) {
        com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_ATTENTION_CHECK_COUNT + TbadkCoreApplication.getCurrentAccount(), com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_ATTENTION_CHECK_COUNT + TbadkCoreApplication.getCurrentAccount(), 0) + 1);
        ac.a(new ab<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ab
            public Boolean doInBackground() {
                x xVar = new x();
                xVar.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                xVar.addPostData("uid", TbadkCoreApplication.getCurrentAccount());
                String postNetData = xVar.postNetData();
                if (xVar.isNetSuccess() && xVar.getServerErrorCode() == 0) {
                    try {
                        return Boolean.valueOf(new JSONObject(postNetData).optInt("live_bar_concerned", 0) == 1);
                    } catch (JSONException e) {
                        return false;
                    }
                }
                return false;
            }
        }, new com.baidu.tbadk.util.l<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    EnterForumDelegateStatic.am(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void am(final Activity activity) {
        if (eqX != null) {
            eqX.dismiss();
        }
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.8
            @Override // java.lang.Runnable
            public void run() {
                if (EnterForumDelegateStatic.eqX != null) {
                    EnterForumDelegateStatic.eqX.dismiss();
                }
            }
        };
        com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
        dVar.E(true);
        dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.9
            @Override // com.baidu.adp.lib.guide.d.a
            public void onShown() {
            }

            @Override // com.baidu.adp.lib.guide.d.a
            public void onDismiss() {
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_TIP_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                com.baidu.adp.lib.guide.c unused = EnterForumDelegateStatic.eqX = null;
                handler.removeCallbacks(runnable);
            }
        });
        dVar.y(activity.getWindow().getDecorView()).M(20).F(false);
        dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.10
            @Override // com.baidu.adp.lib.guide.b
            public View getView(LayoutInflater layoutInflater) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, R.layout.enter_forum_ufan_tip, null);
                TextView textView = (TextView) bubbleLayout.findViewById(R.id.enter_forum_ufan_guide_tv);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.10.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EnterForumDelegateStatic.eqX.dismiss();
                    }
                });
                am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                bubbleLayout.DX(am.getColor(R.color.cp_link_tip_a_alpha95));
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
        eqX = dVar.fI();
        eqX.show(activity);
        handler.postDelayed(runnable, 5000L);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        return this.mIndicator;
    }

    private static void bye() {
        com.baidu.tieba.tbadkCore.d.c.cLu();
        if (fUJ == null) {
            fUJ = new EnterForumModel(null);
            fUJ.a(new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.11
                @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
                public void a(EnterForumModel.a aVar) {
                    g bxH = aVar.fWz.bxH();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = bxH.bxZ().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getName());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(CmdConfigCustom.CMD_ENTER_FORUM_INFO, arrayList));
                }
            });
        }
        if (fUK == null) {
            fUK = new EnterForumAdModel();
            fUK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.12
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof com.baidu.tieba.enterForum.data.a) {
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && EnterForumDelegateStatic.fUJ.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        EnterForumDelegateStatic.fUJ.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        EnterForumDelegateStatic.fUJ.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                    if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                        EnterForumDelegateStatic.fUJ.kH(true);
                    } else {
                        EnterForumDelegateStatic.fUJ.kG(true);
                    }
                }
            }
        });
    }

    private static void byf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.c.a> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA, new d());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void byg() {
        com.baidu.tieba.tbadkCore.a.a.a(309630, ResponseSocketRecommendMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309630, CmdConfigHttp.CMD_RECOMMEND_FORUM, TbConfig.URL_ENTER_RECOMMEND_FORUM, ResponseHttpRecommendMessage.class, false, false, true, false);
    }

    private static void byh() {
        com.baidu.tieba.tbadkCore.a.a.a(309633, ResponseSocketTestCloseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309633, CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE, TbConfig.URL_RECOMMEND_FORUM_TEST_CLOSE, ResponseHttpTestCloseMessage.class, false, false, true, false);
    }

    private static void byi() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST, TbConfig.URL_ENTER_FORUM_AD, EnterForumAdResponsedMessage.class, false, false, true, false);
    }

    private static void byj() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, forumRecommendSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FORUM_RECOMMEND, 1002400, Config.FORUM_RECOMMEND, forumRecommendHttpResponseMessage.class, false, false, false, false);
    }
}
