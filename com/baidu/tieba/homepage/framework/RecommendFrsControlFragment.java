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
    private String bLS;
    private com.baidu.tbadk.i.a dBX;
    private ScrollFragmentTabHost elY;
    private c elZ;
    private boolean emf;
    private Boolean ema = null;
    private boolean emb = true;
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.elY.aIV();
            }
        }
    };
    private CustomMessageListener emc = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.k(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.elY != null && RecommendFrsControlFragment.this.elY.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.elY.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener emd = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.elY != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.elY.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.wO().aW(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.elY.aIV();
                            return;
                        } else if (RecommendFrsControlFragment.this.elY.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.elY.getCurrentTabType() == 0) {
                                boolean aIW = RecommendFrsControlFragment.this.elY.aIW();
                                TiebaStatic.log(new am("c12350").x("obj_type", aIW ? 1 : 0));
                                if (aIW) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.elY.aIV();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.elY.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.elY.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new am("c13172").x("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new am("c12478").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.wO().aW(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.elY.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener eme = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.elY != null && RecommendFrsControlFragment.this.elY.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
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
                    RecommendFrsControlFragment.this.emf = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.emf) {
                    RecommendFrsControlFragment.this.elZ.hI(false);
                }
            }
        }
    };
    private b emg = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tieba.homepage.framework.b
        public void aZ(int i, int i2) {
            RecommendFrsControlFragment.this.elZ.r(1, i, 1, i2);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void G(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.elZ.r(2, i2, i, i3);
            if (j.kK()) {
                TiebaStatic.log(new am("c11032").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aIL() {
        }
    };
    private ConcernPageView.a emh = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.elZ.oF("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void oE(String str) {
            RecommendFrsControlFragment.this.elZ.oF(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void G(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.elY.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.emb) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.emb = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.elZ.hI(false);
            }
        }
    };
    private CustomMessageListener emi = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
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
            if (this.dBX == null) {
                this.dBX = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.dBX.hI(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.elY = (ScrollFragmentTabHost) layoutInflater.inflate(e.h.recommend_frs_control, (ViewGroup) null);
        this.elY.setDrawingCacheEnabled(false);
        return this.elY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.elY != null) {
            String str = null;
            if (getActivity().getIntent() != null) {
                this.bLS = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            }
            if ((!StringUtils.isNull(this.bLS) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.elY.setCurrentTab(this.elY.getVideoRecommendIndex(), false);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", AiAppsUBCStatistic.TYPE_CLICK);
            } else {
                VoiceManager cX = com.baidu.tieba.tbadkCore.voice.b.cX(getActivity());
                if (cX != null) {
                    cX.stopPlay();
                }
            }
            this.elY.setPrimary(isPrimary());
            this.elY.aJa();
            this.elY.setVideoThreadId(this.bLS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.elY != null) {
            this.elY.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fc();
        this.elY.a(getPageContext(), this.cSD);
        this.elY.a(getChildFragmentManager(), this.emg, this.emh);
        this.elY.setPageUniqueId(getUniqueId());
        this.elY.aIT();
        this.emf = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.elY.getCurrentTabType() != 0) {
            this.elZ.hI(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.aIK().setCreateTime(System.currentTimeMillis() - a.aIK().nV(1));
        this.elY.aJc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.aIK().h(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.emd);
        registerListener(this.emi);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.eme);
        registerListener(this.emc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dBX != null) {
            this.dBX.destory();
        }
        this.elY.onDestroy();
    }

    private void fc() {
        this.elZ = new c(getPageContext(), getUniqueId());
        this.elZ.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.elY.aIZ()) {
                    RecommendFrsControlFragment.this.elY.u(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.elY.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.elY.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void hL(boolean z) {
                if (RecommendFrsControlFragment.this.elY != null) {
                    RecommendFrsControlFragment.this.elY.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.elZ));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.elY != null) {
            this.elY.onChangeSkinType(i);
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
                            this.elY.aIV();
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
        if (this.elY != null) {
            this.elY.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ema == null) {
            this.ema = Boolean.valueOf(i.wA().wE());
        } else {
            r0 = this.ema.booleanValue() != i.wA().wE();
            this.ema = Boolean.valueOf(i.wA().wE());
        }
        if (r0) {
            this.elY.ZQ();
        }
        if (this.elY != null) {
            this.elY.setPrimary(isPrimary());
            this.elY.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean NI() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NJ() {
                return com.baidu.tbadk.pageStayDuration.e.NN().NP();
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
            this.elY.aJd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.elY != null) {
            return this.elY.getCurrentPageKey();
        }
        return null;
    }
}
