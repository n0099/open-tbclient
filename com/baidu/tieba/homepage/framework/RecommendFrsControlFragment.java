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
    private n btK;
    private String dfO;
    private com.baidu.tbadk.k.a eZf;
    private ScrollFragmentTabHost fIF;
    private c fIG;
    private boolean fIQ;
    private Boolean fIH = null;
    private boolean fII = true;
    private boolean fIJ = false;
    private NoNetworkView.a emz = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.fIF.blY();
            }
        }
    };
    private n.a fIK = new n.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.n.a
        public void Ux() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.btK != null) {
                if (l.lo()) {
                    RecommendFrsControlFragment.this.btK.cY(true);
                    RecommendFrsControlFragment.this.btK.Uw();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().agw() != null) {
                        ba.adA().c(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().agw()});
                    }
                    TiebaStatic.log(new am("c13394").bJ("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), d.j.neterror);
                TiebaStatic.log(new am("c13394").bJ("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener fIL = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.o(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.fIF != null && RecommendFrsControlFragment.this.fIF.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.fIF.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener fIM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.btK != null) {
                if (!RecommendFrsControlFragment.this.blP() || RecommendFrsControlFragment.this.btK.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.fIJ) {
                    if (!RecommendFrsControlFragment.this.blP() && RecommendFrsControlFragment.this.btK.isOpen()) {
                        RecommendFrsControlFragment.this.btK.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.btK.open();
            }
        }
    };
    private CustomMessageListener fIN = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.fIF != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.fIF.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.WJ().dh(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.fIF.blY();
                            return;
                        } else if (RecommendFrsControlFragment.this.fIF.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.fIF.getCurrentTabType() == 0) {
                                boolean blZ = RecommendFrsControlFragment.this.fIF.blZ();
                                TiebaStatic.log(new am("c12350").T("obj_type", blZ ? 1 : 0));
                                if (blZ) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                    RecommendFrsControlFragment.this.fIF.blY();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.fIF.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.fIF.getCurrentTabType() == 4) {
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
                    com.baidu.tbadk.core.bigday.b.WJ().dh(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.fIF.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener fIO = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.fIF != null && RecommendFrsControlFragment.this.fIF.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new am("c12478").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
            }
        }
    };
    private CustomMessageListener fIP = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.fIJ = true;
                        if (RecommendFrsControlFragment.this.btK != null && RecommendFrsControlFragment.this.btK.isOpen()) {
                            RecommendFrsControlFragment.this.btK.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.fIJ = false;
                    if (RecommendFrsControlFragment.this.btK != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.blP() && !RecommendFrsControlFragment.this.btK.isOpen()) {
                        RecommendFrsControlFragment.this.btK.open();
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
                    RecommendFrsControlFragment.this.fIQ = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.fIQ) {
                    RecommendFrsControlFragment.this.fIG.kh(false);
                }
            }
        }
    };
    private b fIR = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void J(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.fIG.d(1, i, i2, 1, i3);
            if (j.kM()) {
                TiebaStatic.log(new am("c11032").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.fIG.d(2, i2, i3, i, i4);
            if (j.kM()) {
                TiebaStatic.log(new am("c11032").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void blO() {
        }
    };
    private ConcernPageView.a fIS = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.fIG.wb("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void wa(String str) {
            RecommendFrsControlFragment.this.fIG.wb(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void L(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.fIF.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.fII) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.fII = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.fIG.kh(false);
            }
        }
    };
    private CustomMessageListener fIT = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
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
            if (this.eZf == null) {
                this.eZf = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.eZf.pc(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fIF = (ScrollFragmentTabHost) layoutInflater.inflate(d.h.recommend_frs_control, (ViewGroup) null);
        this.fIF.setDrawingCacheEnabled(false);
        return this.fIF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.fIF != null) {
            if (getActivity().getIntent() != null) {
                this.dfO = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.dfO) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.fIF.setCurrentTab(this.fIF.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.fIF.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.fIF.setCurrentTab(5);
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
            this.fIF.setPrimary(isPrimary());
            this.fIF.bmd();
            this.fIF.setVideoThreadId(this.dfO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.fIF != null) {
            this.fIF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
        this.fIF.a(getPageContext(), this.emz);
        this.fIF.a(getChildFragmentManager(), this.fIR, this.fIS);
        this.fIF.setScrollShadow(true);
        this.fIF.setPageUniqueId(getUniqueId());
        this.fIF.blW();
        this.fIQ = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.fIF.getCurrentTabType() != 0) {
            this.fIG.kh(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.blN().setCreateTime(System.currentTimeMillis() - a.blN().si(1));
        this.fIF.bmf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.blN().m(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.fIN);
        registerListener(this.fIT);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.fIO);
        registerListener(this.fIL);
        registerListener(this.fIM);
        registerListener(this.fIP);
        this.btK = new n(getContext(), this.fIK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eZf != null) {
            this.eZf.destory();
        }
        this.fIF.onDestroy();
    }

    private void fb() {
        this.fIG = new c(getPageContext(), getUniqueId());
        this.fIG.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.fIF.bmc()) {
                    RecommendFrsControlFragment.this.fIF.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.fIF.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.fIF.c(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void kk(boolean z) {
                if (RecommendFrsControlFragment.this.fIF != null) {
                    RecommendFrsControlFragment.this.fIF.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.fIG));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fIF != null) {
            this.fIF.onChangeSkinType(i);
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
                            this.fIF.blY();
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
        if (this.fIF != null) {
            this.fIF.setPrimary(isPrimary());
        }
        if (this.btK != null && this.btK.isOpen()) {
            this.btK.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fIH == null) {
            this.fIH = Boolean.valueOf(i.Wv().Wz());
        } else {
            r0 = this.fIH.booleanValue() != i.Wv().Wz();
            this.fIH = Boolean.valueOf(i.Wv().Wz());
        }
        if (r0) {
            this.fIF.aCq();
        }
        if (this.fIF != null) {
            this.fIF.setPrimary(isPrimary());
            this.fIF.onResume();
        }
        if (this.btK != null && blP() && !this.btK.isOpen() && !this.fIJ) {
            this.btK.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blP() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        u shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new u();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.agw())) {
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
            public boolean aoH() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoI() {
                return com.baidu.tbadk.pageStayDuration.e.aoM().aoP();
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
            this.fIF.bmg();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fIF != null) {
            return this.fIF.getCurrentPageKey();
        }
        return null;
    }
}
