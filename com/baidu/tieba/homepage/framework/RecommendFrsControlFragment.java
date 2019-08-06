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
    private String dsH;
    private com.baidu.tbadk.k.a fuO;
    private boolean gfC;
    private ScrollFragmentTabHost gfr;
    private c gfs;
    private Boolean gft = null;
    private boolean gfu = true;
    private boolean gfv = false;
    private NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.gfr.bvP();
            }
        }
    };
    private t.a gfw = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.t.a
        public void ZS() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.bBL != null) {
                if (l.kt()) {
                    RecommendFrsControlFragment.this.bBL.dw(true);
                    RecommendFrsControlFragment.this.bBL.ZR();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().amC() != null) {
                        bb.ajE().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().amC()});
                    }
                    TiebaStatic.log(new an("c13394").bT("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").bT("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener gfx = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.f.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.gfr != null && RecommendFrsControlFragment.this.gfr.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.gfr.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener gfy = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.bBL != null) {
                if (!RecommendFrsControlFragment.this.bvE() || RecommendFrsControlFragment.this.bBL.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.gfv) {
                    if (!RecommendFrsControlFragment.this.bvE() && RecommendFrsControlFragment.this.bBL.isOpen()) {
                        RecommendFrsControlFragment.this.bBL.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.bBL.ZP();
            }
        }
    };
    private CustomMessageListener gfz = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.gfr != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.gfr.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.aco().dG(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.gfr.bvP();
                            return;
                        } else if (RecommendFrsControlFragment.this.gfr.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.gfr.getCurrentTabType() == 0) {
                                boolean bvQ = RecommendFrsControlFragment.this.gfr.bvQ();
                                TiebaStatic.log(new an("c12350").P("obj_type", bvQ ? 1 : 0));
                                if (bvQ) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.gfr.bvP();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.gfr.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.gfr.getCurrentTabType() == 4) {
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
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.gfr.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener gfA = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.gfr != null && RecommendFrsControlFragment.this.gfr.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new an("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener gfB = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.gfv = true;
                        if (RecommendFrsControlFragment.this.bBL != null && RecommendFrsControlFragment.this.bBL.isOpen()) {
                            RecommendFrsControlFragment.this.bBL.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.gfv = false;
                    if (RecommendFrsControlFragment.this.bBL != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bvE() && !RecommendFrsControlFragment.this.bBL.isOpen()) {
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
                    RecommendFrsControlFragment.this.gfC = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.gfC) {
                    RecommendFrsControlFragment.this.gfs.lh(false);
                }
            }
        }
    };
    private b gfD = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void L(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.gfs.d(1, i, i2, 1, i3);
            if (j.jQ()) {
                TiebaStatic.log(new an("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void v(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.gfs.d(2, i2, i3, i, i4);
            if (j.jQ()) {
                TiebaStatic.log(new an("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bvD() {
        }
    };
    private ConcernPageView.a gfE = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.gfs.xY("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void xX(String str) {
            RecommendFrsControlFragment.this.gfs.xY(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void P(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.gfr.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.gfu) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.gfu = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.gfs.lh(false);
            }
        }
    };
    private CustomMessageListener gfF = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
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
            if (this.fuO == null) {
                this.fuO = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.fuO.qA(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gfr = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.gfr.setDrawingCacheEnabled(false);
        return this.gfr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.gfr != null) {
            if (isPrimary()) {
                n.ZF().dv(true);
            } else {
                n.ZF().dv(false);
            }
            if (getActivity().getIntent() != null) {
                this.dsH = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dsH) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.gfr.setCurrentTab(this.gfr.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.gfr.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.gfr.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager eo = com.baidu.tieba.tbadkCore.voice.b.eo(getActivity());
                if (eo != null) {
                    eo.stopPlay();
                }
            }
            this.gfr.setPrimary(isPrimary());
            this.gfr.bvU();
            this.gfr.setVideoThreadId(this.dsH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.gfr != null) {
            this.gfr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ec();
        this.gfr.a(getPageContext(), this.eHo);
        this.gfr.a(getChildFragmentManager(), this.gfD, this.gfE);
        this.gfr.setScrollShadow(true);
        this.gfr.setPageUniqueId(getUniqueId());
        this.gfr.bvN();
        this.gfC = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.gfr.getCurrentTabType() != 0) {
            this.gfs.lh(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.bvC().setCreateTime(System.currentTimeMillis() - a.bvC().tJ(1));
        this.gfr.bvW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bvC().k(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.gfz);
        registerListener(this.gfF);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.gfA);
        registerListener(this.gfx);
        registerListener(this.gfy);
        registerListener(this.gfB);
        this.bBL = new t(getContext(), this.gfw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fuO != null) {
            this.fuO.destory();
        }
        this.gfr.onDestroy();
    }

    private void ec() {
        this.gfs = new c(getPageContext(), getUniqueId());
        this.gfs.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.gfr.bvT()) {
                    RecommendFrsControlFragment.this.gfr.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.gfr.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.gfr.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void lk(boolean z) {
                if (RecommendFrsControlFragment.this.gfr != null) {
                    RecommendFrsControlFragment.this.gfr.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.gfs));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gfr != null) {
            this.gfr.onChangeSkinType(i);
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
                            this.gfr.bvP();
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
        if (this.gfr != null) {
            this.gfr.setPrimary(isPrimary());
        }
        if (this.bBL != null && this.bBL.isOpen()) {
            this.bBL.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gft == null) {
            this.gft = Boolean.valueOf(i.aca().ace());
        } else {
            r0 = this.gft.booleanValue() != i.aca().ace();
            this.gft = Boolean.valueOf(i.aca().ace());
        }
        if (r0) {
            this.gfr.aKj();
        }
        if (this.gfr != null) {
            this.gfr.setPrimary(isPrimary());
            this.gfr.onResume();
        }
        if (this.bBL != null && bvE() && !this.bBL.isOpen() && !this.gfv) {
            this.bBL.ZP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvE() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        u shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new u();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.amC())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("shake_data", "{}")));
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
            public boolean auV() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int auW() {
                return com.baidu.tbadk.o.e.avb().ave();
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
            this.gfr.bvX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.gfr != null) {
            return this.gfr.getCurrentPageKey();
        }
        return null;
    }
}
