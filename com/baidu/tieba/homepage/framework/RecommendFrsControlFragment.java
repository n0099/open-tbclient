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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private t bCj;
    private String dus;
    private com.baidu.tbadk.k.a fwB;
    private ScrollFragmentTabHost ghi;
    private c ghj;
    private boolean ght;
    private Boolean ghk = null;
    private boolean ghl = true;
    private boolean ghm = false;
    private NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.ghi.bwD();
            }
        }
    };
    private t.a ghn = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.t.a
        public void ZW() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.bCj != null) {
                if (l.kt()) {
                    RecommendFrsControlFragment.this.bCj.dw(true);
                    RecommendFrsControlFragment.this.bCj.ZV();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().amO() != null) {
                        ba.ajK().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().amO()});
                    }
                    TiebaStatic.log(new an("c13394").bT("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").bT("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener gho = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.f.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.ghi != null && RecommendFrsControlFragment.this.ghi.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.ghi.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener ghp = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.bCj != null) {
                if (!RecommendFrsControlFragment.this.bws() || RecommendFrsControlFragment.this.bCj.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.ghm) {
                    if (!RecommendFrsControlFragment.this.bws() && RecommendFrsControlFragment.this.bCj.isOpen()) {
                        RecommendFrsControlFragment.this.bCj.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.bCj.ZT();
            }
        }
    };
    private CustomMessageListener ghq = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.ghi != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.ghi.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.acs().dG(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.ghi.bwD();
                            return;
                        } else if (RecommendFrsControlFragment.this.ghi.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.ghi.getCurrentTabType() == 0) {
                                boolean bwE = RecommendFrsControlFragment.this.ghi.bwE();
                                TiebaStatic.log(new an("c12350").P("obj_type", bwE ? 1 : 0));
                                if (bwE) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.ghi.bwD();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.ghi.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.ghi.getCurrentTabType() == 4) {
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
                    com.baidu.tbadk.core.bigday.b.acs().dG(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ghi.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener ghr = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.ghi != null && RecommendFrsControlFragment.this.ghi.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new an("c12478").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener ghs = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.ghm = true;
                        if (RecommendFrsControlFragment.this.bCj != null && RecommendFrsControlFragment.this.bCj.isOpen()) {
                            RecommendFrsControlFragment.this.bCj.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.ghm = false;
                    if (RecommendFrsControlFragment.this.bCj != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bws() && !RecommendFrsControlFragment.this.bCj.isOpen()) {
                        RecommendFrsControlFragment.this.bCj.ZT();
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
                    RecommendFrsControlFragment.this.ght = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.ght) {
                    RecommendFrsControlFragment.this.ghj.lk(false);
                }
            }
        }
    };
    private b ghu = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void M(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.ghj.d(1, i, i2, 1, i3);
            if (j.jQ()) {
                TiebaStatic.log(new an("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void y(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.ghj.d(2, i2, i3, i, i4);
            if (j.jQ()) {
                TiebaStatic.log(new an("c11032").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bwr() {
        }
    };
    private ConcernPageView.a ghv = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.ghj.yx("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void yw(String str) {
            RecommendFrsControlFragment.this.ghj.yx(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void P(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.ghi.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.ghl) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.ghl = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.ghj.lk(false);
            }
        }
    };
    private CustomMessageListener ghw = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
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
            if (this.fwB == null) {
                this.fwB = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.fwB.qL(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ghi = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.ghi.setDrawingCacheEnabled(false);
        return this.ghi;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.ghi != null) {
            if (isPrimary()) {
                n.ZJ().dv(true);
            } else {
                n.ZJ().dv(false);
            }
            if (getActivity().getIntent() != null) {
                this.dus = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dus) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.ghi.setCurrentTab(this.ghi.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.ghi.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.ghi.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager ep = com.baidu.tieba.tbadkCore.voice.b.ep(getActivity());
                if (ep != null) {
                    ep.stopPlay();
                }
            }
            this.ghi.setPrimary(isPrimary());
            this.ghi.bwI();
            this.ghi.setVideoThreadId(this.dus);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.ghi != null) {
            this.ghi.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ec();
        this.ghi.a(getPageContext(), this.eIX);
        this.ghi.a(getChildFragmentManager(), this.ghu, this.ghv);
        this.ghi.setScrollShadow(true);
        this.ghi.setPageUniqueId(getUniqueId());
        this.ghi.bwB();
        this.ght = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.ghi.getCurrentTabType() != 0) {
            this.ghj.lk(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.bwq().setCreateTime(System.currentTimeMillis() - a.bwq().tN(1));
        this.ghi.bwK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bwq().k(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.ghq);
        registerListener(this.ghw);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.ghr);
        registerListener(this.gho);
        registerListener(this.ghp);
        registerListener(this.ghs);
        this.bCj = new t(getContext(), this.ghn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fwB != null) {
            this.fwB.destory();
        }
        this.ghi.onDestroy();
    }

    private void ec() {
        this.ghj = new c(getPageContext(), getUniqueId());
        this.ghj.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.ghi.bwH()) {
                    RecommendFrsControlFragment.this.ghi.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.ghi.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.ghi.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void ln(boolean z) {
                if (RecommendFrsControlFragment.this.ghi != null) {
                    RecommendFrsControlFragment.this.ghi.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ghj));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ghi != null) {
            this.ghi.onChangeSkinType(i);
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
                            this.ghi.bwD();
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
        if (this.ghi != null) {
            this.ghi.setPrimary(isPrimary());
        }
        if (this.bCj != null && this.bCj.isOpen()) {
            this.bCj.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ghk == null) {
            this.ghk = Boolean.valueOf(i.ace().aci());
        } else {
            r0 = this.ghk.booleanValue() != i.ace().aci();
            this.ghk = Boolean.valueOf(i.ace().aci());
        }
        if (r0) {
            this.ghi.aKN();
        }
        if (this.ghi != null) {
            this.ghi.setPrimary(isPrimary());
            this.ghi.onResume();
        }
        if (this.bCj != null && bws() && !this.bCj.isOpen() && !this.ghm) {
            this.bCj.ZT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bws() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        v shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new v();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.amO())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.ahU().getString("shake_data", "{}")));
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
            public boolean avh() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int avi() {
                return com.baidu.tbadk.o.e.avn().avq();
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
            this.ghi.bwL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.ghi != null) {
            return this.ghi.getCurrentPageKey();
        }
        return null;
    }
}
