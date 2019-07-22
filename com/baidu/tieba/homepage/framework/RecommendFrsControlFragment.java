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
import com.baidu.tbadk.BdToken.t;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
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
    private t bBL;
    private String dsA;
    private com.baidu.tbadk.k.a fup;
    private ScrollFragmentTabHost geB;
    private c geC;
    private boolean geM;
    private Boolean geD = null;
    private boolean geE = true;
    private boolean geF = false;
    private NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.geB.bvC();
            }
        }
    };
    private t.a geG = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.t.a
        public void ZS() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.bBL != null) {
                if (l.kt()) {
                    RecommendFrsControlFragment.this.bBL.dw(true);
                    RecommendFrsControlFragment.this.bBL.ZR();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().amA() != null) {
                        bb.ajC().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().amA()});
                    }
                    TiebaStatic.log(new an("c13394").bT("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").bT("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener geH = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.f.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.geB != null && RecommendFrsControlFragment.this.geB.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.geB.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener geI = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.bBL != null) {
                if (!RecommendFrsControlFragment.this.bvr() || RecommendFrsControlFragment.this.bBL.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.geF) {
                    if (!RecommendFrsControlFragment.this.bvr() && RecommendFrsControlFragment.this.bBL.isOpen()) {
                        RecommendFrsControlFragment.this.bBL.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.bBL.ZP();
            }
        }
    };
    private CustomMessageListener geJ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.geB != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.geB.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.aco().dG(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.geB.bvC();
                            return;
                        } else if (RecommendFrsControlFragment.this.geB.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.geB.getCurrentTabType() == 0) {
                                boolean bvD = RecommendFrsControlFragment.this.geB.bvD();
                                TiebaStatic.log(new an("c12350").P("obj_type", bvD ? 1 : 0));
                                if (bvD) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.geB.bvC();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.geB.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.geB.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new an("c13172").P("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new an("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.aco().dG(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.geB.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener geK = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.geB != null && RecommendFrsControlFragment.this.geB.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new an("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener geL = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.geF = true;
                        if (RecommendFrsControlFragment.this.bBL != null && RecommendFrsControlFragment.this.bBL.isOpen()) {
                            RecommendFrsControlFragment.this.bBL.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.geF = false;
                    if (RecommendFrsControlFragment.this.bBL != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bvr() && !RecommendFrsControlFragment.this.bBL.isOpen()) {
                        RecommendFrsControlFragment.this.bBL.ZP();
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
                    RecommendFrsControlFragment.this.geM = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.geM) {
                    RecommendFrsControlFragment.this.geC.lh(false);
                }
            }
        }
    };
    private b geN = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void L(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.geC.d(1, i, i2, 1, i3);
            if (j.jQ()) {
                TiebaStatic.log(new an("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void v(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.geC.d(2, i2, i3, i, i4);
            if (j.jQ()) {
                TiebaStatic.log(new an("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bvq() {
        }
    };
    private ConcernPageView.a geO = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.geC.xX("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void xW(String str) {
            RecommendFrsControlFragment.this.geC.xX(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void P(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.geB.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.geE) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.geE = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.geC.lh(false);
            }
        }
    };
    private CustomMessageListener geP = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Hs && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
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
            if (this.fup == null) {
                this.fup = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.fup.qA(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.geB = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.geB.setDrawingCacheEnabled(false);
        return this.geB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.geB != null) {
            if (isPrimary()) {
                n.ZF().dv(true);
            } else {
                n.ZF().dv(false);
            }
            if (getActivity().getIntent() != null) {
                this.dsA = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dsA) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.geB.setCurrentTab(this.geB.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.geB.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.geB.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager en = com.baidu.tieba.tbadkCore.voice.b.en(getActivity());
                if (en != null) {
                    en.stopPlay();
                }
            }
            this.geB.setPrimary(isPrimary());
            this.geB.bvH();
            this.geB.setVideoThreadId(this.dsA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.geB != null) {
            this.geB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ec();
        this.geB.a(getPageContext(), this.eHh);
        this.geB.a(getChildFragmentManager(), this.geN, this.geO);
        this.geB.setScrollShadow(true);
        this.geB.setPageUniqueId(getUniqueId());
        this.geB.bvA();
        this.geM = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.geB.getCurrentTabType() != 0) {
            this.geC.lh(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.bvp().setCreateTime(System.currentTimeMillis() - a.bvp().tH(1));
        this.geB.bvJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bvp().k(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.geJ);
        registerListener(this.geP);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.geK);
        registerListener(this.geH);
        registerListener(this.geI);
        registerListener(this.geL);
        this.bBL = new t(getContext(), this.geG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fup != null) {
            this.fup.destory();
        }
        this.geB.onDestroy();
    }

    private void ec() {
        this.geC = new c(getPageContext(), getUniqueId());
        this.geC.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.geB.bvG()) {
                    RecommendFrsControlFragment.this.geB.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.geB.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.geB.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void lk(boolean z) {
                if (RecommendFrsControlFragment.this.geB != null) {
                    RecommendFrsControlFragment.this.geB.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.geC));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.geB != null) {
            this.geB.onChangeSkinType(i);
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
                            this.geB.bvC();
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
        if (this.geB != null) {
            this.geB.setPrimary(isPrimary());
        }
        if (this.bBL != null && this.bBL.isOpen()) {
            this.bBL.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.geD == null) {
            this.geD = Boolean.valueOf(i.aca().ace());
        } else {
            r0 = this.geD.booleanValue() != i.aca().ace();
            this.geD = Boolean.valueOf(i.aca().ace());
        }
        if (r0) {
            this.geB.aKh();
        }
        if (this.geB != null) {
            this.geB.setPrimary(isPrimary());
            this.geB.onResume();
        }
        if (this.bBL != null && bvr() && !this.bBL.isOpen() && !this.geF) {
            this.bBL.ZP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvr() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        u shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new u();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.amA())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.ahO().getString("shake_data", "{}")));
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
            public boolean auT() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int auU() {
                return com.baidu.tbadk.o.e.auZ().avc();
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
            this.geB.bvK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.geB != null) {
            return this.geB.getCurrentPageKey();
        }
        return null;
    }
}
