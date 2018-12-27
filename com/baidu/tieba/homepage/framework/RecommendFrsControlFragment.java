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
    private String bPK;
    private com.baidu.tbadk.i.a dLk;
    private ScrollFragmentTabHost evK;
    private c evL;
    private boolean evR;
    private Boolean evM = null;
    private boolean evN = true;
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.evK.aLA();
            }
        }
    };
    private CustomMessageListener evO = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.k(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.evK != null && RecommendFrsControlFragment.this.evK.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.evK.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener evP = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.evK != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.evK.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.xS().aX(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.evK.aLA();
                            return;
                        } else if (RecommendFrsControlFragment.this.evK.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.evK.getCurrentTabType() == 0) {
                                boolean aLB = RecommendFrsControlFragment.this.evK.aLB();
                                TiebaStatic.log(new am("c12350").x("obj_type", aLB ? 1 : 0));
                                if (aLB) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.evK.aLA();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.evK.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.evK.getCurrentTabType() == 4) {
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
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.evK.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener evQ = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.evK != null && RecommendFrsControlFragment.this.evK.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
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
                    RecommendFrsControlFragment.this.evR = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.evR) {
                    RecommendFrsControlFragment.this.evL.hN(false);
                }
            }
        }
    };
    private b evS = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tieba.homepage.framework.b
        public void G(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.evL.c(1, i, i2, 1, i3);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void r(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.evL.c(2, i2, i3, i, i4);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aLr() {
        }
    };
    private ConcernPageView.a evT = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.evL.pk("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void pj(String str) {
            RecommendFrsControlFragment.this.evL.pk(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void G(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.evK.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.evN) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.evN = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.evL.hN(false);
            }
        }
    };
    private CustomMessageListener evU = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
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
            if (this.dLk == null) {
                this.dLk = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.dLk.ia(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.evK = (ScrollFragmentTabHost) layoutInflater.inflate(e.h.recommend_frs_control, (ViewGroup) null);
        this.evK.setDrawingCacheEnabled(false);
        return this.evK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.evK != null) {
            String str = null;
            if (getActivity().getIntent() != null) {
                this.bPK = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            }
            if ((!StringUtils.isNull(this.bPK) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.evK.setCurrentTab(this.evK.getVideoRecommendIndex(), false);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", AiAppsUBCStatistic.TYPE_CLICK);
            } else {
                VoiceManager db = com.baidu.tieba.tbadkCore.voice.b.db(getActivity());
                if (db != null) {
                    db.stopPlay();
                }
            }
            this.evK.setPrimary(isPrimary());
            this.evK.aLE();
            this.evK.setVideoThreadId(this.bPK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.evK != null) {
            this.evK.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fc();
        this.evK.a(getPageContext(), this.dcc);
        this.evK.a(getChildFragmentManager(), this.evS, this.evT);
        this.evK.setPageUniqueId(getUniqueId());
        this.evK.aLy();
        this.evR = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.evK.getCurrentTabType() != 0) {
            this.evL.hN(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.aLq().setCreateTime(System.currentTimeMillis() - a.aLq().oC(1));
        this.evK.aLG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.aLq().h(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.evP);
        registerListener(this.evU);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.evQ);
        registerListener(this.evO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLk != null) {
            this.dLk.destory();
        }
        this.evK.onDestroy();
    }

    private void fc() {
        this.evL = new c(getPageContext(), getUniqueId());
        this.evL.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.evK.aLD()) {
                    RecommendFrsControlFragment.this.evK.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.evK.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.evK.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void hQ(boolean z) {
                if (RecommendFrsControlFragment.this.evK != null) {
                    RecommendFrsControlFragment.this.evK.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.evL));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.evK != null) {
            this.evK.onChangeSkinType(i);
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
                            this.evK.aLA();
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
        if (this.evK != null) {
            this.evK.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.evM == null) {
            this.evM = Boolean.valueOf(i.xE().xI());
        } else {
            r0 = this.evM.booleanValue() != i.xE().xI();
            this.evM = Boolean.valueOf(i.xE().xI());
        }
        if (r0) {
            this.evK.aaY();
        }
        if (this.evK != null) {
            this.evK.setPrimary(isPrimary());
            this.evK.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean ON() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int OO() {
                return com.baidu.tbadk.pageStayDuration.e.OS().OU();
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
            this.evK.aLH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.evK != null) {
            return this.evK.getCurrentPageKey();
        }
        return null;
    }
}
