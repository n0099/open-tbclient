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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private String bwL;
    private boolean dVE;
    private ScrollFragmentTabHost dVx;
    private c dVy;
    private com.baidu.tbadk.i.a dmK;
    private Boolean dVz = null;
    private boolean dVA = true;
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.dVx.aDV();
            }
        }
    };
    private CustomMessageListener dVB = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.h(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.dVx != null && RecommendFrsControlFragment.this.dVx.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.dVx.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener dVC = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.dVx != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.dVx.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.tv().am(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.dVx.aDV();
                            return;
                        } else if (RecommendFrsControlFragment.this.dVx.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.dVx.getCurrentTabType() == 0) {
                                boolean aDW = RecommendFrsControlFragment.this.dVx.aDW();
                                TiebaStatic.log(new an("c12350").r("obj_type", aDW ? 1 : 0));
                                if (aDW) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.dVx.aDV();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.dVx.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.dVx.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new an("c13172").r("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new an("c12478").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.tv().am(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dVx.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener dVD = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.dVx != null && RecommendFrsControlFragment.this.dVx.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new an("c12478").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener dVF = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.dVE = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.dVE) {
                    RecommendFrsControlFragment.this.dVy.gI(false);
                }
            }
        }
    };
    private b dVG = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tieba.homepage.framework.b
        public void aQ(int i, int i2) {
            RecommendFrsControlFragment.this.dVy.q(1, i, 1, i2);
            if (j.js()) {
                TiebaStatic.log(new an("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void B(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.dVy.q(2, i2, i, i3);
            if (j.js()) {
                TiebaStatic.log(new an("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aDL() {
        }
    };
    private ConcernPageView.a dVH = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.dVy.nt("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ns(String str) {
            RecommendFrsControlFragment.this.dVy.nt(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void B(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.dVx.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.dVA) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.dVA = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.dVy.gI(false);
            }
        }
    };
    private CustomMessageListener dVI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Gp && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
            if (this.dmK == null) {
                this.dmK = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.dmK.gX(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dVx = (ScrollFragmentTabHost) layoutInflater.inflate(d.h.recommend_frs_control, (ViewGroup) null);
        this.dVx.setDrawingCacheEnabled(false);
        return this.dVx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.dVx != null) {
            String str = null;
            if (getActivity().getIntent() != null) {
                this.bwL = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            }
            if ((!StringUtils.isNull(this.bwL) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.dVx.setCurrentTab(this.dVx.getVideoRecommendIndex(), false);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager ck = com.baidu.tieba.tbadkCore.voice.b.ck(getActivity());
                if (ck != null) {
                    ck.stopPlay();
                }
            }
            this.dVx.setPrimary(isPrimary());
            this.dVx.aEa();
            this.dVx.setVideoThreadId(this.bwL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.dVx != null) {
            this.dVx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dE();
        this.dVx.a(getPageContext(), this.cDq);
        this.dVx.a(getChildFragmentManager(), this.dVG, this.dVH);
        this.dVx.setPageUniqueId(getUniqueId());
        this.dVx.aDT();
        this.dVE = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.dVx.getCurrentTabType() != 0) {
            this.dVy.gI(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.aDK().setCreateTime(System.currentTimeMillis() - a.aDK().mB(1));
        this.dVx.aEc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.aDK().e(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.dVC);
        registerListener(this.dVI);
        registerListener(this.dVF);
        registerListener(this.dVD);
        registerListener(this.dVB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dmK != null) {
            this.dmK.destory();
        }
        this.dVx.onDestroy();
    }

    private void dE() {
        this.dVy = new c(getPageContext(), getUniqueId());
        this.dVy.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.dVx.aDZ()) {
                    RecommendFrsControlFragment.this.dVx.o(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.dVx.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.dVx.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void gL(boolean z) {
                if (RecommendFrsControlFragment.this.dVx != null) {
                    RecommendFrsControlFragment.this.dVx.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.dVy));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dVx != null) {
            this.dVx.onChangeSkinType(i);
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
                            this.dVx.aDV();
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
        if (this.dVx != null) {
            this.dVx.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dVz == null) {
            this.dVz = Boolean.valueOf(i.te().tk());
        } else {
            r0 = this.dVz.booleanValue() != i.te().tk();
            this.dVz = Boolean.valueOf(i.te().tk());
        }
        if (r0) {
            this.dVx.Ui();
        }
        if (this.dVx != null) {
            this.dVx.setPrimary(isPrimary());
            this.dVx.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Kh() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Ki() {
                return com.baidu.tbadk.pageStayDuration.e.Km().Ko();
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
            this.dVx.aEd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dVx != null) {
            return this.dVx.getCurrentPageKey();
        }
        return null;
    }
}
