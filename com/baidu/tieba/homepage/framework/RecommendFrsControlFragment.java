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
    private n btE;
    private String dfN;
    private com.baidu.tbadk.k.a eZt;
    private ScrollFragmentTabHost fIS;
    private c fIT;
    private boolean fJd;
    private Boolean fIU = null;
    private boolean fIV = true;
    private boolean fIW = false;
    private NoNetworkView.a emQ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.fIS.bmc();
            }
        }
    };
    private n.a fIX = new n.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.n.a
        public void UA() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.btE != null) {
                if (l.lo()) {
                    RecommendFrsControlFragment.this.btE.cY(true);
                    RecommendFrsControlFragment.this.btE.Uz();
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
    private CustomMessageListener fIY = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.fIS != null && RecommendFrsControlFragment.this.fIS.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.fIS.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener fIZ = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.btE != null) {
                if (!RecommendFrsControlFragment.this.blT() || RecommendFrsControlFragment.this.btE.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.fIW) {
                    if (!RecommendFrsControlFragment.this.blT() && RecommendFrsControlFragment.this.btE.isOpen()) {
                        RecommendFrsControlFragment.this.btE.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.btE.open();
            }
        }
    };
    private CustomMessageListener fJa = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.fIS != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.fIS.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.WM().dh(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.fIS.bmc();
                            return;
                        } else if (RecommendFrsControlFragment.this.fIS.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.fIS.getCurrentTabType() == 0) {
                                boolean bmd = RecommendFrsControlFragment.this.fIS.bmd();
                                TiebaStatic.log(new am("c12350").T("obj_type", bmd ? 1 : 0));
                                if (bmd) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.fIS.bmc();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.fIS.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.fIS.getCurrentTabType() == 4) {
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
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.fIS.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener fJb = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.fIS != null && RecommendFrsControlFragment.this.fIS.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener fJc = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.fIW = true;
                        if (RecommendFrsControlFragment.this.btE != null && RecommendFrsControlFragment.this.btE.isOpen()) {
                            RecommendFrsControlFragment.this.btE.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.fIW = false;
                    if (RecommendFrsControlFragment.this.btE != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.blT() && !RecommendFrsControlFragment.this.btE.isOpen()) {
                        RecommendFrsControlFragment.this.btE.open();
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
                    RecommendFrsControlFragment.this.fJd = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.fJd) {
                    RecommendFrsControlFragment.this.fIT.kh(false);
                }
            }
        }
    };
    private b fJe = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void J(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.fIT.d(1, i, i2, 1, i3);
            if (j.kM()) {
                TiebaStatic.log(new am("c11032").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.fIT.d(2, i2, i3, i, i4);
            if (j.kM()) {
                TiebaStatic.log(new am("c11032").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void blS() {
        }
    };
    private ConcernPageView.a fJf = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.fIT.we("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void wd(String str) {
            RecommendFrsControlFragment.this.fIT.we(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void N(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.fIS.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.fIV) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.fIV = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.fIT.kh(false);
            }
        }
    };
    private CustomMessageListener fJg = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
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
            if (this.eZt == null) {
                this.eZt = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.eZt.pb(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fIS = (ScrollFragmentTabHost) layoutInflater.inflate(d.h.recommend_frs_control, (ViewGroup) null);
        this.fIS.setDrawingCacheEnabled(false);
        return this.fIS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.fIS != null) {
            if (getActivity().getIntent() != null) {
                this.dfN = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dfN) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.fIS.setCurrentTab(this.fIS.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.fIS.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.fIS.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager ex = com.baidu.tieba.tbadkCore.voice.b.ex(getActivity());
                if (ex != null) {
                    ex.stopPlay();
                }
            }
            this.fIS.setPrimary(isPrimary());
            this.fIS.bmh();
            this.fIS.setVideoThreadId(this.dfN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.fIS != null) {
            this.fIS.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
        this.fIS.a(getPageContext(), this.emQ);
        this.fIS.a(getChildFragmentManager(), this.fJe, this.fJf);
        this.fIS.setScrollShadow(true);
        this.fIS.setPageUniqueId(getUniqueId());
        this.fIS.bma();
        this.fJd = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.fIS.getCurrentTabType() != 0) {
            this.fIT.kh(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.blR().setCreateTime(System.currentTimeMillis() - a.blR().sm(1));
        this.fIS.bmj();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.blR().m(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.fJa);
        registerListener(this.fJg);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.fJb);
        registerListener(this.fIY);
        registerListener(this.fIZ);
        registerListener(this.fJc);
        this.btE = new n(getContext(), this.fIX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eZt != null) {
            this.eZt.destory();
        }
        this.fIS.onDestroy();
    }

    private void fb() {
        this.fIT = new c(getPageContext(), getUniqueId());
        this.fIT.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.fIS.bmg()) {
                    RecommendFrsControlFragment.this.fIS.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.fIS.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.fIS.c(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void kk(boolean z) {
                if (RecommendFrsControlFragment.this.fIS != null) {
                    RecommendFrsControlFragment.this.fIS.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.fIT));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fIS != null) {
            this.fIS.onChangeSkinType(i);
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
                            this.fIS.bmc();
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
        if (this.fIS != null) {
            this.fIS.setPrimary(isPrimary());
        }
        if (this.btE != null && this.btE.isOpen()) {
            this.btE.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fIU == null) {
            this.fIU = Boolean.valueOf(i.Wy().WC());
        } else {
            r0 = this.fIU.booleanValue() != i.Wy().WC();
            this.fIU = Boolean.valueOf(i.Wy().WC());
        }
        if (r0) {
            this.fIS.aCu();
        }
        if (this.fIS != null) {
            this.fIS.setPrimary(isPrimary());
            this.fIS.onResume();
        }
        if (this.btE != null && blT() && !this.btE.isOpen() && !this.fIW) {
            this.btE.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blT() {
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
            public boolean aoL() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoM() {
                return com.baidu.tbadk.pageStayDuration.e.aoQ().aoT();
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
            this.fIS.bmk();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fIS != null) {
            return this.fIS.getCurrentPageKey();
        }
        return null;
    }
}
