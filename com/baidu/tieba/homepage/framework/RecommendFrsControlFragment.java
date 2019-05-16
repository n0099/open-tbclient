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
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.BdToken.s;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private s bAO;
    private String dqq;
    private ScrollFragmentTabHost fZA;
    private c fZB;
    private boolean fZL;
    private com.baidu.tbadk.k.a fpp;
    private Boolean fZC = null;
    private boolean fZD = true;
    private boolean fZE = false;
    private NoNetworkView.a eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.fZA.btv();
            }
        }
    };
    private s.a fZF = new s.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.s.a
        public void YT() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.bAO != null) {
                if (l.ki()) {
                    RecommendFrsControlFragment.this.bAO.dr(true);
                    RecommendFrsControlFragment.this.bAO.YS();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().alv() != null) {
                        ba.aiz().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().alv()});
                    }
                    TiebaStatic.log(new am("c13394").bT("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new am("c13394").bT("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener fZG = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.fZA != null && RecommendFrsControlFragment.this.fZA.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.fZA.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener fZH = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.bAO != null) {
                if (!RecommendFrsControlFragment.this.btl() || RecommendFrsControlFragment.this.bAO.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.fZE) {
                    if (!RecommendFrsControlFragment.this.btl() && RecommendFrsControlFragment.this.bAO.isOpen()) {
                        RecommendFrsControlFragment.this.bAO.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.bAO.open();
            }
        }
    };
    private CustomMessageListener fZI = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.fZA != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.fZA.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.abp().dC(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.fZA.btv();
                            return;
                        } else if (RecommendFrsControlFragment.this.fZA.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.fZA.getCurrentTabType() == 0) {
                                boolean btw = RecommendFrsControlFragment.this.fZA.btw();
                                TiebaStatic.log(new am("c12350").P("obj_type", btw ? 1 : 0));
                                if (btw) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.fZA.btv();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.fZA.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.fZA.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new am("c13172").P("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new am("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.abp().dC(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.fZA.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener fZJ = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.fZA != null && RecommendFrsControlFragment.this.fZA.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener fZK = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.fZE = true;
                        if (RecommendFrsControlFragment.this.bAO != null && RecommendFrsControlFragment.this.bAO.isOpen()) {
                            RecommendFrsControlFragment.this.bAO.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.fZE = false;
                    if (RecommendFrsControlFragment.this.bAO != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.btl() && !RecommendFrsControlFragment.this.bAO.isOpen()) {
                        RecommendFrsControlFragment.this.bAO.open();
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
                    RecommendFrsControlFragment.this.fZL = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.fZL) {
                    RecommendFrsControlFragment.this.fZB.kW(false);
                }
            }
        }
    };
    private b fZM = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void K(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.fZB.d(1, i, i2, 1, i3);
            if (j.jG()) {
                TiebaStatic.log(new am("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.fZB.d(2, i2, i3, i, i4);
            if (j.jG()) {
                TiebaStatic.log(new am("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void btk() {
        }
    };
    private ConcernPageView.a fZN = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.fZB.xq("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void xp(String str) {
            RecommendFrsControlFragment.this.fZB.xq(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void M(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.fZA.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.fZD) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.fZD = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.fZB.kW(false);
            }
        }
    };
    private CustomMessageListener fZO = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Hi && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
            if (this.fpp == null) {
                this.fpp = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.fpp.qk(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fZA = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.fZA.setDrawingCacheEnabled(false);
        return this.fZA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.fZA != null) {
            if (isPrimary()) {
                n.YJ().dq(true);
            } else {
                n.YJ().dq(false);
            }
            if (getActivity().getIntent() != null) {
                this.dqq = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dqq) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.fZA.setCurrentTab(this.fZA.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.fZA.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.fZA.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager em = com.baidu.tieba.tbadkCore.voice.b.em(getActivity());
                if (em != null) {
                    em.stopPlay();
                }
            }
            this.fZA.setPrimary(isPrimary());
            this.fZA.btA();
            this.fZA.setVideoThreadId(this.dqq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.fZA != null) {
            this.fZA.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dV();
        this.fZA.a(getPageContext(), this.eCk);
        this.fZA.a(getChildFragmentManager(), this.fZM, this.fZN);
        this.fZA.setScrollShadow(true);
        this.fZA.setPageUniqueId(getUniqueId());
        this.fZA.btt();
        this.fZL = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.fZA.getCurrentTabType() != 0) {
            this.fZB.kW(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.btj().setCreateTime(System.currentTimeMillis() - a.btj().tp(1));
        this.fZA.btC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.btj().k(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.fZI);
        registerListener(this.fZO);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.fZJ);
        registerListener(this.fZG);
        registerListener(this.fZH);
        registerListener(this.fZK);
        this.bAO = new s(getContext(), this.fZF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fpp != null) {
            this.fpp.destory();
        }
        this.fZA.onDestroy();
    }

    private void dV() {
        this.fZB = new c(getPageContext(), getUniqueId());
        this.fZB.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.fZA.btz()) {
                    RecommendFrsControlFragment.this.fZA.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.fZA.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.fZA.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void kZ(boolean z) {
                if (RecommendFrsControlFragment.this.fZA != null) {
                    RecommendFrsControlFragment.this.fZA.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.fZB));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fZA != null) {
            this.fZA.onChangeSkinType(i);
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
                            this.fZA.btv();
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
        if (this.fZA != null) {
            this.fZA.setPrimary(isPrimary());
        }
        if (this.bAO != null && this.bAO.isOpen()) {
            this.bAO.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fZC == null) {
            this.fZC = Boolean.valueOf(i.abb().abf());
        } else {
            r0 = this.fZC.booleanValue() != i.abb().abf();
            this.fZC = Boolean.valueOf(i.abb().abf());
        }
        if (r0) {
            this.fZA.aID();
        }
        if (this.fZA != null) {
            this.fZA.setPrimary(isPrimary());
            this.fZA.onResume();
        }
        if (this.bAO != null && btl() && !this.bAO.isOpen() && !this.fZE) {
            this.bAO.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btl() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        u shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new u();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.alv())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.agM().getString("shake_data", "{}")));
                TbSingleton.getInstance().setShakeData(shakeData);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return currentTimeMillis > shakeData.getStartTime() && currentTimeMillis < shakeData.getEndTime();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tbadk.o.b
            public boolean atL() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int atM() {
                return com.baidu.tbadk.o.e.atQ().atT();
            }

            @Override // com.baidu.tbadk.o.b
            public boolean a(com.baidu.tbadk.o.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (!z) {
            this.fZA.btD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.fZA != null) {
            return this.fZA.getCurrentPageKey();
        }
        return null;
    }
}
