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
import com.baidu.tbadk.core.util.am;
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
    private String buK;
    private boolean dOB;
    private ScrollFragmentTabHost dOu;
    private c dOv;
    private com.baidu.tbadk.h.a dhW;
    private Boolean dOw = null;
    private boolean dOx = true;
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.dOu.aCt();
            }
        }
    };
    private CustomMessageListener dOy = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.g(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.dOu != null && RecommendFrsControlFragment.this.dOu.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.dOu.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener dOz = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.dOu != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.dOu.aCt();
                        } else if (RecommendFrsControlFragment.this.dOu.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.dOu.getCurrentTabType() == 0) {
                                boolean aCu = RecommendFrsControlFragment.this.dOu.aCu();
                                TiebaStatic.log(new am("c12350").r("obj_type", aCu ? 1 : 0));
                                if (aCu) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.dOu.aCt();
                                }
                            } else if (RecommendFrsControlFragment.this.dOu.getCurrentTabType() == 3) {
                                TiebaStatic.log(new am("c12478").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dOu.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener dOA = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.dOu != null && RecommendFrsControlFragment.this.dOu.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener dOC = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.dOB = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.dOB) {
                    RecommendFrsControlFragment.this.dOv.gw(false);
                }
            }
        }
    };
    private b dOD = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tieba.homepage.framework.b
        public void aO(int i, int i2) {
            RecommendFrsControlFragment.this.dOv.r(1, i, 1, i2);
            if (j.jr()) {
                TiebaStatic.log(new am("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void B(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.dOv.r(2, i2, i, i3);
            if (j.jr()) {
                TiebaStatic.log(new am("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aCl() {
        }
    };
    private ConcernPageView.a dOE = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.dOv.nu("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void nt(String str) {
            RecommendFrsControlFragment.this.dOv.nu(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void y(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.dOu.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.dOx) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.dOx = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.dOv.gw(false);
            }
        }
    };
    private CustomMessageListener dOF = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
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
            if (this.dhW == null) {
                this.dhW = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.dhW.gX(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dOu = (ScrollFragmentTabHost) layoutInflater.inflate(d.i.recommend_frs_control, (ViewGroup) null);
        this.dOu.setDrawingCacheEnabled(false);
        return this.dOu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.dOu != null) {
            String str = null;
            if (getActivity().getIntent() != null) {
                this.buK = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            }
            if ((!StringUtils.isNull(this.buK) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.dOu.setCurrentTab(this.dOu.getVideoRecommendIndex(), false);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager cl = com.baidu.tieba.tbadkCore.voice.b.cl(getActivity());
                if (cl != null) {
                    cl.stopPlay();
                }
            }
            this.dOu.setPrimary(isPrimary());
            this.dOu.aCx();
            this.dOu.setVideoThreadId(this.buK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.dOu.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dG();
        this.dOu.a(getPageContext(), this.cCR);
        this.dOu.a(getChildFragmentManager(), this.dOD, this.dOE);
        this.dOu.setPageUniqueId(getUniqueId());
        this.dOu.aBR();
        this.dOB = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.dOu.getCurrentIndex() != 0) {
            this.dOv.gw(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.aCk().setCreateTime(System.currentTimeMillis() - a.aCk().mg(1));
        this.dOu.aCy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.aCk().e(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.dOz);
        registerListener(this.dOF);
        registerListener(this.dOC);
        registerListener(this.dOA);
        registerListener(this.dOy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dhW != null) {
            this.dhW.destory();
        }
        this.dOu.onDestroy();
    }

    private void dG() {
        this.dOv = new c(getPageContext(), getUniqueId());
        this.dOv.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.dOu.aCw()) {
                    RecommendFrsControlFragment.this.dOu.o(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.dOu.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.dOu.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void gy(boolean z) {
                if (RecommendFrsControlFragment.this.dOu != null) {
                    RecommendFrsControlFragment.this.dOu.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.dOv));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dOu != null) {
            this.dOu.onChangeSkinType(i);
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
                            this.dOu.aCt();
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
        if (this.dOu != null) {
            this.dOu.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dOw == null) {
            this.dOw = Boolean.valueOf(i.tt().tz());
        } else {
            r0 = this.dOw.booleanValue() != i.tt().tz();
            this.dOw = Boolean.valueOf(i.tt().tz());
        }
        if (r0) {
            this.dOu.TG();
        }
        if (this.dOu != null) {
            this.dOu.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean JU() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int JV() {
                return com.baidu.tbadk.pageStayDuration.e.JZ().Kb();
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
            this.dOu.aCz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dOu != null) {
            return this.dOu.getCurrentPageKey();
        }
        return null;
    }
}
