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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private n btG;
    private String dfJ;
    private com.baidu.tbadk.k.a eZs;
    private ScrollFragmentTabHost fIR;
    private c fIS;
    private boolean fJc;
    private Boolean fIT = null;
    private boolean fIU = true;
    private boolean fIV = false;
    private NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.fIR.bmb();
            }
        }
    };
    private n.a fIW = new n.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.n.a
        public void UA() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.btG != null) {
                if (l.lo()) {
                    RecommendFrsControlFragment.this.btG.cY(true);
                    RecommendFrsControlFragment.this.btG.Uz();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().agz() != null) {
                        ba.adD().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().agz()});
                    }
                    TiebaStatic.log(new am("c13394").bJ("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), d.j.neterror);
                TiebaStatic.log(new am("c13394").bJ("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener fIX = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.fIR != null && RecommendFrsControlFragment.this.fIR.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.fIR.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener fIY = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.btG != null) {
                if (!RecommendFrsControlFragment.this.blS() || RecommendFrsControlFragment.this.btG.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.fIV) {
                    if (!RecommendFrsControlFragment.this.blS() && RecommendFrsControlFragment.this.btG.isOpen()) {
                        RecommendFrsControlFragment.this.btG.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.btG.open();
            }
        }
    };
    private CustomMessageListener fIZ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.fIR != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.fIR.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.WM().dh(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.fIR.bmb();
                            return;
                        } else if (RecommendFrsControlFragment.this.fIR.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.fIR.getCurrentTabType() == 0) {
                                boolean bmc = RecommendFrsControlFragment.this.fIR.bmc();
                                TiebaStatic.log(new am("c12350").T("obj_type", bmc ? 1 : 0));
                                if (bmc) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.fIR.bmb();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.fIR.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.fIR.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new am("c13172").T("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new am("c12478").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.WM().dh(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.fIR.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener fJa = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.fIR != null && RecommendFrsControlFragment.this.fIR.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener fJb = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.fIV = true;
                        if (RecommendFrsControlFragment.this.btG != null && RecommendFrsControlFragment.this.btG.isOpen()) {
                            RecommendFrsControlFragment.this.btG.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.fIV = false;
                    if (RecommendFrsControlFragment.this.btG != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.blS() && !RecommendFrsControlFragment.this.btG.isOpen()) {
                        RecommendFrsControlFragment.this.btG.open();
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
                    RecommendFrsControlFragment.this.fJc = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.fJc) {
                    RecommendFrsControlFragment.this.fIS.kh(false);
                }
            }
        }
    };
    private b fJd = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void J(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.fIS.d(1, i, i2, 1, i3);
            if (j.kM()) {
                TiebaStatic.log(new am("c11032").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.fIS.d(2, i2, i3, i, i4);
            if (j.kM()) {
                TiebaStatic.log(new am("c11032").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void blR() {
        }
    };
    private ConcernPageView.a fJe = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.fIS.wc("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void wb(String str) {
            RecommendFrsControlFragment.this.fIS.wc(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void N(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.fIR.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.fIU) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.fIU = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.fIS.kh(false);
            }
        }
    };
    private CustomMessageListener fJf = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
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
            if (this.eZs == null) {
                this.eZs = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.eZs.pb(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fIR = (ScrollFragmentTabHost) layoutInflater.inflate(d.h.recommend_frs_control, (ViewGroup) null);
        this.fIR.setDrawingCacheEnabled(false);
        return this.fIR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.fIR != null) {
            if (getActivity().getIntent() != null) {
                this.dfJ = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dfJ) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.fIR.setCurrentTab(this.fIR.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.fIR.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.fIR.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager ew = com.baidu.tieba.tbadkCore.voice.b.ew(getActivity());
                if (ew != null) {
                    ew.stopPlay();
                }
            }
            this.fIR.setPrimary(isPrimary());
            this.fIR.bmg();
            this.fIR.setVideoThreadId(this.dfJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.fIR != null) {
            this.fIR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
        this.fIR.a(getPageContext(), this.emM);
        this.fIR.a(getChildFragmentManager(), this.fJd, this.fJe);
        this.fIR.setScrollShadow(true);
        this.fIR.setPageUniqueId(getUniqueId());
        this.fIR.blZ();
        this.fJc = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.fIR.getCurrentTabType() != 0) {
            this.fIS.kh(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.blQ().setCreateTime(System.currentTimeMillis() - a.blQ().sm(1));
        this.fIR.bmi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.blQ().m(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.fIZ);
        registerListener(this.fJf);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.fJa);
        registerListener(this.fIX);
        registerListener(this.fIY);
        registerListener(this.fJb);
        this.btG = new n(getContext(), this.fIW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eZs != null) {
            this.eZs.destory();
        }
        this.fIR.onDestroy();
    }

    private void fb() {
        this.fIS = new c(getPageContext(), getUniqueId());
        this.fIS.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.fIR.bmf()) {
                    RecommendFrsControlFragment.this.fIR.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.fIR.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.fIR.c(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void kk(boolean z) {
                if (RecommendFrsControlFragment.this.fIR != null) {
                    RecommendFrsControlFragment.this.fIR.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.fIS));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fIR != null) {
            this.fIR.onChangeSkinType(i);
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
                            this.fIR.bmb();
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
        if (this.fIR != null) {
            this.fIR.setPrimary(isPrimary());
        }
        if (this.btG != null && this.btG.isOpen()) {
            this.btG.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fIT == null) {
            this.fIT = Boolean.valueOf(i.Wy().WC());
        } else {
            r0 = this.fIT.booleanValue() != i.Wy().WC();
            this.fIT = Boolean.valueOf(i.Wy().WC());
        }
        if (r0) {
            this.fIR.aCt();
        }
        if (this.fIR != null) {
            this.fIR.setPrimary(isPrimary());
            this.fIR.onResume();
        }
        if (this.btG != null && blS() && !this.btG.isOpen() && !this.fIV) {
            this.btG.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blS() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        u shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new u();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.agz())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("shake_data", "{}")));
                TbSingleton.getInstance().setShakeData(shakeData);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return currentTimeMillis > shakeData.getStartTime() && currentTimeMillis < shakeData.getEndTime();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean aoK() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoL() {
                return com.baidu.tbadk.pageStayDuration.e.aoP().aoS();
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
            this.fIR.bmj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fIR != null) {
            return this.fIR.getCurrentPageKey();
        }
        return null;
    }
}
