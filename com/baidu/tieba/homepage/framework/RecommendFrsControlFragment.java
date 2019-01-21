package com.baidu.tieba.homepage.framework;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private n amY;
    private String bQw;
    private com.baidu.tbadk.i.a dLU;
    private boolean ewC;
    private ScrollFragmentTabHost ewr;
    private c ews;
    private Boolean ewt = null;
    private boolean ewu = true;
    private boolean ewv = false;
    private NoNetworkView.a dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.ewr.aLZ();
            }
        }
    };
    private n.a eww = new n.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.n.a
        public void vZ() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.amY != null) {
                if (l.ll()) {
                    RecommendFrsControlFragment.this.amY.aP(true);
                    RecommendFrsControlFragment.this.amY.vY();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().Hg() != null) {
                        ay.Es().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().Hg()});
                    }
                    TiebaStatic.log(new am("c13394").aB("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), e.j.neterror);
                TiebaStatic.log(new am("c13394").aB("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener ewx = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.k(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.ewr != null && RecommendFrsControlFragment.this.ewr.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.ewr.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener ewy = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.amY != null) {
                if (!RecommendFrsControlFragment.this.aLQ() || RecommendFrsControlFragment.this.amY.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.ewv) {
                    if (!RecommendFrsControlFragment.this.aLQ() && RecommendFrsControlFragment.this.amY.isOpen()) {
                        RecommendFrsControlFragment.this.amY.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.amY.open();
            }
        }
    };
    private CustomMessageListener ewz = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.ewr != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.ewr.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.yf().aY(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.ewr.aLZ();
                            return;
                        } else if (RecommendFrsControlFragment.this.ewr.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.ewr.getCurrentTabType() == 0) {
                                boolean aMa = RecommendFrsControlFragment.this.ewr.aMa();
                                TiebaStatic.log(new am("c12350").y("obj_type", aMa ? 1 : 0));
                                if (aMa) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.ewr.aLZ();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.ewr.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.ewr.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new am("c13172").y("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new am("c12478").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.yf().aY(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ewr.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener ewA = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.ewr != null && RecommendFrsControlFragment.this.ewr.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener ewB = new CustomMessageListener(2921390) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.ewv = true;
                        if (RecommendFrsControlFragment.this.amY != null && RecommendFrsControlFragment.this.amY.isOpen()) {
                            RecommendFrsControlFragment.this.amY.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.ewv = false;
                    if (RecommendFrsControlFragment.this.amY != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.aLQ() && !RecommendFrsControlFragment.this.amY.isOpen()) {
                        RecommendFrsControlFragment.this.amY.open();
                    }
                }
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.ewC = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.ewC) {
                    RecommendFrsControlFragment.this.ews.hN(false);
                }
            }
        }
    };
    private b ewD = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void G(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.ews.c(1, i, i2, 1, i3);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void r(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.ews.c(2, i2, i3, i, i4);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aLP() {
        }
    };
    private ConcernPageView.a ewE = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.ews.pA("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void pz(String str) {
            RecommendFrsControlFragment.this.ews.pA(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void G(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.ewr.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.ewu) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.ewu = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.ews.hN(false);
            }
        }
    };
    private CustomMessageListener ewF = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jr && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(2001406);
            setData(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.dLU == null) {
                this.dLU = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.dLU.ip(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ewr = (ScrollFragmentTabHost) layoutInflater.inflate(e.h.recommend_frs_control, (ViewGroup) null);
        this.ewr.setDrawingCacheEnabled(false);
        return this.ewr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.ewr != null) {
            String str = null;
            if (getActivity().getIntent() != null) {
                this.bQw = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            }
            if ((!StringUtils.isNull(this.bQw) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.ewr.setCurrentTab(this.ewr.getVideoRecommendIndex(), false);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", AiAppsUBCStatistic.TYPE_CLICK);
                if (this.ewr != null && this.ewr.aMh()) {
                    TiebaStatic.log("c13392");
                }
            } else {
                VoiceManager db = com.baidu.tieba.tbadkCore.voice.b.db(getActivity());
                if (db != null) {
                    db.stopPlay();
                }
            }
            this.ewr.setPrimary(isPrimary());
            this.ewr.aMd();
            this.ewr.setVideoThreadId(this.bQw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.ewr != null) {
            this.ewr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fc();
        this.ewr.a(getPageContext(), this.dcQ);
        this.ewr.a(getChildFragmentManager(), this.ewD, this.ewE);
        this.ewr.setPageUniqueId(getUniqueId());
        this.ewr.aLX();
        this.ewC = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.ewr.getCurrentTabType() != 0) {
            this.ews.hN(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.aLO().setCreateTime(System.currentTimeMillis() - a.aLO().oD(1));
        this.ewr.aMf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.aLO().h(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.ewz);
        registerListener(this.ewF);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.ewA);
        registerListener(this.ewx);
        registerListener(this.ewy);
        registerListener(this.ewB);
        this.amY = new n(getContext(), this.eww);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLU != null) {
            this.dLU.destory();
        }
        this.ewr.onDestroy();
    }

    private void fc() {
        this.ews = new c(getPageContext(), getUniqueId());
        this.ews.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.ewr.aMc()) {
                    RecommendFrsControlFragment.this.ewr.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.ewr.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.ewr.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void hQ(boolean z) {
                if (RecommendFrsControlFragment.this.ewr != null) {
                    RecommendFrsControlFragment.this.ewr.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ews));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ewr != null) {
            this.ewr.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                        if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                            this.ewr.aLZ();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ewr != null) {
            this.ewr.setPrimary(isPrimary());
        }
        if (this.amY != null && this.amY.isOpen()) {
            this.amY.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ewt == null) {
            this.ewt = Boolean.valueOf(i.xR().xV());
        } else {
            r0 = this.ewt.booleanValue() != i.xR().xV();
            this.ewt = Boolean.valueOf(i.xR().xV());
        }
        if (r0) {
            this.ewr.abv();
        }
        if (this.ewr != null) {
            this.ewr.setPrimary(isPrimary());
            this.ewr.onResume();
        }
        if (this.amY != null && aLQ() && !this.amY.isOpen() && !this.ewv) {
            this.amY.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLQ() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        u shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new u();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.Hg())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("shake_data", "{}")));
                TbSingleton.getInstance().setShakeData(shakeData);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return currentTimeMillis > shakeData.getStartTime() && currentTimeMillis < shakeData.getEndTime();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Pf() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Pg() {
                return com.baidu.tbadk.pageStayDuration.e.Pk().Pm();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (!z) {
            this.ewr.aMg();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.ewr != null) {
            return this.ewr.getCurrentPageKey();
        }
        return null;
    }
}
