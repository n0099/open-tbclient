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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private String ccp;
    private com.baidu.tbadk.h.a dEF;
    private c ehA;
    private PbHistoryCacheModel ehB;
    private boolean ehI;
    private ScrollFragmentTabHost ehz;
    private Boolean ehC = null;
    private boolean ehD = true;
    private int ehE = -1;
    private NoNetworkView.a dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.ehz.aCC();
            }
        }
    };
    private CustomMessageListener ehF = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.v(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.ehz != null && RecommendFrsControlFragment.this.ehz.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.ehz.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener ehG = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.ehz != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.ehz.getCurrentTabType() == 0) {
                            boolean aCD = RecommendFrsControlFragment.this.ehz.aCD();
                            if (!isPrimary) {
                                TiebaStatic.log(new ak("c12350").s("obj_type", aCD ? 1 : 0));
                            }
                            if (aCD && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                RecommendFrsControlFragment.this.ehz.aCC();
                            }
                        } else if (RecommendFrsControlFragment.this.ehz.getCurrentTabType() == 3 && !RecommendFrsControlFragment.this.isPrimary()) {
                            ak akVar = new ak("c12478");
                            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                            TiebaStatic.log(akVar);
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.ehz.aCC();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.ehz.aCC();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ehz.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ehz.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener ehH = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.ehz != null && RecommendFrsControlFragment.this.ehz.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                ak akVar = new ak("c12478");
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                TiebaStatic.log(akVar);
            }
        }
    };
    private CustomMessageListener ehJ = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.ehI = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.ehI) {
                    RecommendFrsControlFragment.this.ehA.gP(false);
                }
            }
        }
    };
    private b ehK = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.framework.b
        public void bL(int i, int i2) {
            RecommendFrsControlFragment.this.ehA.y(1, i, 1, i2);
            if (j.ox()) {
                TiebaStatic.log(new ak("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void N(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.ehA.y(2, i2, i, i3);
            if (j.ox()) {
                TiebaStatic.log(new ak("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aCu() {
        }
    };
    private c.a ehL = new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        @Override // com.baidu.tieba.homepage.concern.c.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.ehA.mD("");
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void mC(String str) {
            RecommendFrsControlFragment.this.ehA.mD(str);
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void C(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.ehD) {
                    RecommendFrsControlFragment.this.ehz.setShowConcernRedTip(false);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.ehz.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.ehD = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.ehA.gP(false);
            }
        }
    };
    private CustomMessageListener ehM = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apH && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
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
            if (this.dEF == null) {
                this.dEF = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.dEF.gI(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (getActivity().getIntent() != null) {
            this.ccp = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
            if (!StringUtils.isNull(this.ccp)) {
                this.ehE = 3;
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
            }
            String dataString = getActivity().getIntent().getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("com.baidu.tieba://videosquare") && this.ehz != null && this.ehz.getVideoRecommendIndex() >= 0) {
                this.ehz.H(this.ehz.getVideoRecommendIndex(), false);
            }
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.ehz != null && this.ehE > 0) {
                this.ehz.getCurrentTabType();
                int videoRecommendIndex = this.ehz.getVideoRecommendIndex();
                if (videoRecommendIndex < 0) {
                    this.ehE = -1;
                    return;
                } else {
                    this.ehz.H(videoRecommendIndex, false);
                    this.ehE = -1;
                }
            }
        } else {
            VoiceManager cm = com.baidu.tieba.tbadkCore.voice.b.cm(getActivity());
            if (cm != null) {
                cm.stopPlay();
            }
        }
        if (this.ehz != null) {
            this.ehz.setPrimary(isPrimary());
            this.ehz.aCG();
            this.ehz.setVideoThreadId(this.ccp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.ehz.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        iO();
        this.ehz = (ScrollFragmentTabHost) getView().findViewById(d.g.recommend_frs_tab_host);
        this.ehz.a(getPageContext(), this.dbo);
        this.ehz.a(getChildFragmentManager(), this.ehK, this.ehL);
        this.ehz.setPageUniqueId(getUniqueId());
        this.ehz.aCe();
        this.ehI = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        a.aCt().setCreateTime(System.currentTimeMillis() - a.aCt().ow(1));
        if (TbadkCoreApplication.isLogin() && this.ehz.getCurrentIndex() != 0) {
            this.ehA.gP(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aCt().e(System.currentTimeMillis(), 1);
        registerListener(this.ehG);
        registerListener(this.ehM);
        registerListener(this.ehJ);
        registerListener(this.ehH);
        registerListener(this.ehF);
        aCv();
    }

    private void aCv() {
        this.ehB = new PbHistoryCacheModel(getPageContext());
        this.ehB.setUniqueId(getUniqueId());
        this.ehB.a(new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> readCacheMessage) {
                if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && (readCacheRespMsg.getData() instanceof List)) {
                    com.baidu.tieba.tbadkCore.util.c godFeedReadHistory = TbadkCoreApplication.getInst().getGodFeedReadHistory();
                    for (com.baidu.tieba.myCollection.baseHistory.a aVar : readCacheRespMsg.getData()) {
                        if (aVar != null && !StringUtils.isNull(aVar.getThreadId()) && godFeedReadHistory != null) {
                            godFeedReadHistory.a(aVar.getThreadId(), aVar);
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> writeCacheMessage) {
            }
        });
        this.ehB.Nh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEF != null) {
            this.dEF.destory();
        }
        this.ehz.onDestroy();
        if (this.ehB != null) {
            this.ehB.cancelLoadData();
            this.ehB.cancelMessage();
        }
    }

    private void iO() {
        this.ehA = new c(getPageContext(), getUniqueId());
        this.ehA.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.ehz.aCF()) {
                    RecommendFrsControlFragment.this.ehz.n(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.ehz.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.ehz.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void gR(boolean z) {
                if (RecommendFrsControlFragment.this.ehz != null) {
                    RecommendFrsControlFragment.this.ehz.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ehA));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ehz != null) {
            this.ehz.onChangeSkinType(i);
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
                            this.ehz.aCC();
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
        if (this.ehz != null) {
            this.ehz.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ehC == null) {
            this.ehC = Boolean.valueOf(i.xo().xu());
        } else {
            r0 = this.ehC.booleanValue() != i.xo().xu();
            this.ehC = Boolean.valueOf(i.xo().xu());
        }
        if (r0) {
            this.ehz.XL();
        }
        if (this.ehz != null) {
            this.ehz.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean NM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NN() {
                return com.baidu.tbadk.pageStayDuration.e.NR().NT();
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
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.ehz != null) {
            return this.ehz.getCurrentPageKey();
        }
        return null;
    }
}
