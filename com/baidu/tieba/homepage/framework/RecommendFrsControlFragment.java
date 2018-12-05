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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private String bPH;
    private com.baidu.tbadk.i.a dIw;
    private ScrollFragmentTabHost esT;
    private c esU;
    private boolean eta;
    private Boolean esV = null;
    private boolean esW = true;
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.esT.aKM();
            }
        }
    };
    private CustomMessageListener esX = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.k(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.esT != null && RecommendFrsControlFragment.this.esT.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.esT.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener esY = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.esT != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.esT.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.xS().aX(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.esT.aKM();
                            return;
                        } else if (RecommendFrsControlFragment.this.esT.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.esT.getCurrentTabType() == 0) {
                                boolean aKN = RecommendFrsControlFragment.this.esT.aKN();
                                TiebaStatic.log(new am("c12350").x("obj_type", aKN ? 1 : 0));
                                if (aKN) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.esT.aKM();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.esT.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.esT.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new am("c13172").x("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new am("c12478").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.xS().aX(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.esT.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener esZ = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.esT != null && RecommendFrsControlFragment.this.esT.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.eta = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.eta) {
                    RecommendFrsControlFragment.this.esU.hK(false);
                }
            }
        }
    };
    private b etb = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tieba.homepage.framework.b
        public void G(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.esU.c(1, i, i2, 1, i3);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void r(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.esU.c(2, i2, i3, i, i4);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aKC() {
        }
    };
    private ConcernPageView.a etd = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.esU.ph("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void pg(String str) {
            RecommendFrsControlFragment.this.esU.ph(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void G(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.esT.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.esW) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.esW = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.esU.hK(false);
            }
        }
    };
    private CustomMessageListener ete = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
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
            if (this.dIw == null) {
                this.dIw = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.dIw.hZ(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.esT = (ScrollFragmentTabHost) layoutInflater.inflate(e.h.recommend_frs_control, (ViewGroup) null);
        this.esT.setDrawingCacheEnabled(false);
        return this.esT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.esT != null) {
            String str = null;
            if (getActivity().getIntent() != null) {
                this.bPH = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            }
            if ((!StringUtils.isNull(this.bPH) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.esT.setCurrentTab(this.esT.getVideoRecommendIndex(), false);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", AiAppsUBCStatistic.TYPE_CLICK);
            } else {
                VoiceManager db = com.baidu.tieba.tbadkCore.voice.b.db(getActivity());
                if (db != null) {
                    db.stopPlay();
                }
            }
            this.esT.setPrimary(isPrimary());
            this.esT.aKR();
            this.esT.setVideoThreadId(this.bPH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.esT != null) {
            this.esT.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fc();
        this.esT.a(getPageContext(), this.cZk);
        this.esT.a(getChildFragmentManager(), this.etb, this.etd);
        this.esT.setPageUniqueId(getUniqueId());
        this.esT.aKK();
        this.eta = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.esT.getCurrentTabType() != 0) {
            this.esU.hK(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.aKB().setCreateTime(System.currentTimeMillis() - a.aKB().op(1));
        this.esT.aKT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.aKB().h(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.esY);
        registerListener(this.ete);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.esZ);
        registerListener(this.esX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dIw != null) {
            this.dIw.destory();
        }
        this.esT.onDestroy();
    }

    private void fc() {
        this.esU = new c(getPageContext(), getUniqueId());
        this.esU.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.esT.aKQ()) {
                    RecommendFrsControlFragment.this.esT.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.esT.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.esT.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void hN(boolean z) {
                if (RecommendFrsControlFragment.this.esT != null) {
                    RecommendFrsControlFragment.this.esT.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.esU));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.esT != null) {
            this.esT.onChangeSkinType(i);
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
                            this.esT.aKM();
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
        if (this.esT != null) {
            this.esT.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.esV == null) {
            this.esV = Boolean.valueOf(i.xE().xI());
        } else {
            r0 = this.esV.booleanValue() != i.xE().xI();
            this.esV = Boolean.valueOf(i.xE().xI());
        }
        if (r0) {
            this.esT.aaW();
        }
        if (this.esT != null) {
            this.esT.setPrimary(isPrimary());
            this.esT.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean OM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int ON() {
                return com.baidu.tbadk.pageStayDuration.e.OR().OT();
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
            this.esT.aKU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.esT != null) {
            return this.esT.getCurrentPageKey();
        }
        return null;
    }
}
