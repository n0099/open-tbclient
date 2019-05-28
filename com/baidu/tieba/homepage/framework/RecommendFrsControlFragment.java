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
    private String dqr;
    private ScrollFragmentTabHost fZB;
    private c fZC;
    private boolean fZM;
    private com.baidu.tbadk.k.a fpq;
    private Boolean fZD = null;
    private boolean fZE = true;
    private boolean fZF = false;
    private NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.fZB.bty();
            }
        }
    };
    private s.a fZG = new s.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
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
    private CustomMessageListener fZH = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.fZB != null && RecommendFrsControlFragment.this.fZB.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.fZB.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener fZI = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.bAO != null) {
                if (!RecommendFrsControlFragment.this.bto() || RecommendFrsControlFragment.this.bAO.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.fZF) {
                    if (!RecommendFrsControlFragment.this.bto() && RecommendFrsControlFragment.this.bAO.isOpen()) {
                        RecommendFrsControlFragment.this.bAO.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.bAO.open();
            }
        }
    };
    private CustomMessageListener fZJ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.fZB != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.fZB.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.abp().dC(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.fZB.bty();
                            return;
                        } else if (RecommendFrsControlFragment.this.fZB.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.fZB.getCurrentTabType() == 0) {
                                boolean btz = RecommendFrsControlFragment.this.fZB.btz();
                                TiebaStatic.log(new am("c12350").P("obj_type", btz ? 1 : 0));
                                if (btz) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.fZB.bty();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.fZB.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.fZB.getCurrentTabType() == 4) {
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
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.fZB.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener fZK = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.fZB != null && RecommendFrsControlFragment.this.fZB.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener fZL = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.fZF = true;
                        if (RecommendFrsControlFragment.this.bAO != null && RecommendFrsControlFragment.this.bAO.isOpen()) {
                            RecommendFrsControlFragment.this.bAO.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.fZF = false;
                    if (RecommendFrsControlFragment.this.bAO != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bto() && !RecommendFrsControlFragment.this.bAO.isOpen()) {
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
                    RecommendFrsControlFragment.this.fZM = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.fZM) {
                    RecommendFrsControlFragment.this.fZC.kW(false);
                }
            }
        }
    };
    private b fZN = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void K(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.fZC.d(1, i, i2, 1, i3);
            if (j.jG()) {
                TiebaStatic.log(new am("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.fZC.d(2, i2, i3, i, i4);
            if (j.jG()) {
                TiebaStatic.log(new am("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void btn() {
        }
    };
    private ConcernPageView.a fZO = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.fZC.xq("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void xp(String str) {
            RecommendFrsControlFragment.this.fZC.xq(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void M(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.fZB.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.fZE) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.fZE = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.fZC.kW(false);
            }
        }
    };
    private CustomMessageListener fZP = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
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
            if (this.fpq == null) {
                this.fpq = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.fpq.qk(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fZB = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.fZB.setDrawingCacheEnabled(false);
        return this.fZB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.fZB != null) {
            if (isPrimary()) {
                n.YJ().dq(true);
            } else {
                n.YJ().dq(false);
            }
            if (getActivity().getIntent() != null) {
                this.dqr = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dqr) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.fZB.setCurrentTab(this.fZB.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.fZB.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.fZB.setCurrentTab(5);
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
            this.fZB.setPrimary(isPrimary());
            this.fZB.btD();
            this.fZB.setVideoThreadId(this.dqr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.fZB != null) {
            this.fZB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dV();
        this.fZB.a(getPageContext(), this.eCl);
        this.fZB.a(getChildFragmentManager(), this.fZN, this.fZO);
        this.fZB.setScrollShadow(true);
        this.fZB.setPageUniqueId(getUniqueId());
        this.fZB.btw();
        this.fZM = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.fZB.getCurrentTabType() != 0) {
            this.fZC.kW(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.btm().setCreateTime(System.currentTimeMillis() - a.btm().tp(1));
        this.fZB.btF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.btm().k(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.fZJ);
        registerListener(this.fZP);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.fZK);
        registerListener(this.fZH);
        registerListener(this.fZI);
        registerListener(this.fZL);
        this.bAO = new s(getContext(), this.fZG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fpq != null) {
            this.fpq.destory();
        }
        this.fZB.onDestroy();
    }

    private void dV() {
        this.fZC = new c(getPageContext(), getUniqueId());
        this.fZC.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.fZB.btC()) {
                    RecommendFrsControlFragment.this.fZB.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.fZB.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.fZB.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void kZ(boolean z) {
                if (RecommendFrsControlFragment.this.fZB != null) {
                    RecommendFrsControlFragment.this.fZB.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.fZC));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fZB != null) {
            this.fZB.onChangeSkinType(i);
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
                            this.fZB.bty();
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
        if (this.fZB != null) {
            this.fZB.setPrimary(isPrimary());
        }
        if (this.bAO != null && this.bAO.isOpen()) {
            this.bAO.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fZD == null) {
            this.fZD = Boolean.valueOf(i.abb().abf());
        } else {
            r0 = this.fZD.booleanValue() != i.abb().abf();
            this.fZD = Boolean.valueOf(i.abb().abf());
        }
        if (r0) {
            this.fZB.aIG();
        }
        if (this.fZB != null) {
            this.fZB.setPrimary(isPrimary());
            this.fZB.onResume();
        }
        if (this.bAO != null && bto() && !this.bAO.isOpen() && !this.fZF) {
            this.bAO.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bto() {
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
            this.fZB.btG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.fZB != null) {
            return this.fZB.getCurrentPageKey();
        }
        return null;
    }
}
