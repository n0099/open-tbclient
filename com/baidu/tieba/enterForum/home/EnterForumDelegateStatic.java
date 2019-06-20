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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes4.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static com.baidu.adp.lib.guide.c drd;
    private static EnterForumModel eRO;
    public static EnterForumAdModel eRP;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c asJ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.cwo = new EnterForumTabFragment();
        cVar.type = 1;
        cVar.bVW = R.string.enter_forum;
        cVar.cwu = com.baidu.tbadk.mainTab.c.cws;
        cVar.kF = R.raw.enter_forum;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c asK;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
                    if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                        EnterForumDelegateStatic.eRP.loadAd();
                    }
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(enterForumDelegateStatic);
                    if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (asK = enterForumDelegateStatic.asK()) != null && !asK.cwo.isAdded()) {
                        asK.cwo.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
        if (l.kh()) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2921341) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                    if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false) && com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                        com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EnterForumDelegateStatic.aj((Activity) customResponsedMessage.getData());
                            }
                        });
                    }
                }
            });
        }
        TbadkCoreApplication.getInst().RegisterIntent(ForumTestActivityConfig.class, ForumTestActivity.class);
        bdA();
        bdB();
        bdC();
        bdD();
        bdE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aj(final Activity activity) {
        com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) + 1);
        aa.a(new z<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                x xVar = new x();
                xVar.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                xVar.o("uid", TbadkCoreApplication.getCurrentAccount());
                String ahe = xVar.ahe();
                if (xVar.ahF() && xVar.ahG() == 0) {
                    try {
                        return Boolean.valueOf(new JSONObject(ahe).optInt("live_bar_concerned", 0) == 1);
                    } catch (JSONException e) {
                        return false;
                    }
                }
                return false;
            }
        }, new k<Boolean>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    EnterForumDelegateStatic.ak(activity);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ak(final Activity activity) {
        if (drd != null) {
            drd.dismiss();
        }
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.8
            @Override // java.lang.Runnable
            public void run() {
                if (EnterForumDelegateStatic.drd != null) {
                    EnterForumDelegateStatic.drd.dismiss();
                }
            }
        };
        com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
        dVar.T(true);
        dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.9
            @Override // com.baidu.adp.lib.guide.d.a
            public void onShown() {
            }

            @Override // com.baidu.adp.lib.guide.d.a
            public void onDismiss() {
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
                com.baidu.adp.lib.guide.c unused = EnterForumDelegateStatic.drd = null;
                handler.removeCallbacks(runnable);
            }
        });
        dVar.y(activity.getWindow().getDecorView()).X(20).U(false);
        dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.10
            @Override // com.baidu.adp.lib.guide.b
            public View a(LayoutInflater layoutInflater) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(activity, R.layout.enter_forum_ufan_tip, null);
                TextView textView = (TextView) bubbleLayout.findViewById(R.id.enter_forum_ufan_guide_tv);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.10.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EnterForumDelegateStatic.drd.dismiss();
                    }
                });
                al.j(textView, R.color.cp_btn_a);
                bubbleLayout.BX(al.getColor(R.color.cp_link_tip_a_alpha95));
                return bubbleLayout;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int hJ() {
                return 4;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int hK() {
                return 16;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getXOffset() {
                return l.ai(activity) > 0.0f ? (int) ((activity.getResources().getDimensionPixelSize(R.dimen.ds52) * 2) / l.ai(activity)) : activity.getResources().getDimensionPixelSize(R.dimen.ds52);
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getYOffset() {
                int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.ds46) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (UtilHelper.getVirtualBarHeight(activity) > 0 || MenuKeyUtils.hasSmartBar()) {
                    dimensionPixelSize -= l.g(activity, R.dimen.ds20);
                }
                if (l.ai(activity) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / l.ai(activity));
                }
                return dimensionPixelSize;
            }
        });
        drd = dVar.hL();
        drd.n(activity);
        handler.postDelayed(runnable, 5000L);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cO(Context context) {
        this.cwa = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        return this.cwa;
    }

    private static void bdA() {
        com.baidu.tieba.tbadkCore.d.c.cmR();
        if (eRO == null) {
            eRO = new EnterForumModel(null);
            eRO.a(new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.11
                @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
                public void a(EnterForumModel.a aVar) {
                    g bdd = aVar.eTD.bdd();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = bdd.bdw().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getName());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(2001329, arrayList));
                }
            });
        }
        if (eRP == null) {
            eRP = new EnterForumAdModel();
            eRP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.12
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (obj instanceof com.baidu.tieba.enterForum.data.a) {
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && EnterForumDelegateStatic.eRO.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        EnterForumDelegateStatic.eRO.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        EnterForumDelegateStatic.eRO.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001323) { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                    if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                        EnterForumDelegateStatic.eRO.jg(true);
                    } else {
                        EnterForumDelegateStatic.eRO.jf(true);
                    }
                }
            }
        });
    }

    private static void bdB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016562, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.enterForum.home.EnterForumDelegateStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.c.a> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016562, new d());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bdC() {
        com.baidu.tieba.tbadkCore.a.a.a(309630, ResponseSocketRecommendMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309630, CmdConfigHttp.CMD_RECOMMEND_FORUM, TbConfig.URL_ENTER_RECOMMEND_FORUM, ResponseHttpRecommendMessage.class, false, false, true, false);
    }

    private static void bdD() {
        com.baidu.tieba.tbadkCore.a.a.a(309633, ResponseSocketTestCloseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309633, CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE, TbConfig.URL_RECOMMEND_FORUM_TEST_CLOSE, ResponseHttpTestCloseMessage.class, false, false, true, false);
    }

    private static void bdE() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST, TbConfig.URL_ENTER_FORUM_AD, EnterForumAdResponsedMessage.class, false, false, true, false);
    }
}
