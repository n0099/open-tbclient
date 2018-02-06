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
    private String ccz;
    private com.baidu.tbadk.h.a dEO;
    private boolean ehE;
    private ScrollFragmentTabHost ehv;
    private c ehw;
    private PbHistoryCacheModel ehx;
    private Boolean ehy = null;
    private boolean ehz = true;
    private int ehA = -1;
    private NoNetworkView.a dbx = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.ehv.aCC();
            }
        }
    };
    private CustomMessageListener ehB = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.v(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.ehv != null && RecommendFrsControlFragment.this.ehv.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.ehv.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener ehC = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.ehv != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.ehv.getCurrentTabType() == 0) {
                            boolean aCD = RecommendFrsControlFragment.this.ehv.aCD();
                            if (!isPrimary) {
                                TiebaStatic.log(new ak("c12350").s("obj_type", aCD ? 1 : 0));
                            }
                            if (aCD && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                RecommendFrsControlFragment.this.ehv.aCC();
                            }
                        } else if (RecommendFrsControlFragment.this.ehv.getCurrentTabType() == 3 && !RecommendFrsControlFragment.this.isPrimary()) {
                            ak akVar = new ak("c12478");
                            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                            TiebaStatic.log(akVar);
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.ehv.aCC();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.ehv.aCC();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ehv.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ehv.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener ehD = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.ehv != null && RecommendFrsControlFragment.this.ehv.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                ak akVar = new ak("c12478");
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                TiebaStatic.log(akVar);
            }
        }
    };
    private CustomMessageListener ehF = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.ehE = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.ehE) {
                    RecommendFrsControlFragment.this.ehw.gK(false);
                }
            }
        }
    };
    private b ehG = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.framework.b
        public void bL(int i, int i2) {
            RecommendFrsControlFragment.this.ehw.y(1, i, 1, i2);
            if (j.ox()) {
                TiebaStatic.log(new ak("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void N(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.ehw.y(2, i2, i, i3);
            if (j.ox()) {
                TiebaStatic.log(new ak("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aCu() {
        }
    };
    private c.a ehH = new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        @Override // com.baidu.tieba.homepage.concern.c.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.ehw.mD("");
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void mC(String str) {
            RecommendFrsControlFragment.this.ehw.mD(str);
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void C(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.ehz) {
                    RecommendFrsControlFragment.this.ehv.setShowConcernRedTip(false);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.ehv.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.ehz = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.ehw.gK(false);
            }
        }
    };
    private CustomMessageListener ehI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apP && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
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
            if (this.dEO == null) {
                this.dEO = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.dEO.gI(updateAttentionMessage.getData().toUid);
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
            this.ccz = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
            if (!StringUtils.isNull(this.ccz)) {
                this.ehA = 3;
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
            }
            String dataString = getActivity().getIntent().getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("com.baidu.tieba://videosquare") && this.ehv != null && this.ehv.getVideoRecommendIndex() >= 0) {
                this.ehv.H(this.ehv.getVideoRecommendIndex(), false);
            }
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.ehv != null && this.ehA > 0) {
                this.ehv.getCurrentTabType();
                int videoRecommendIndex = this.ehv.getVideoRecommendIndex();
                if (videoRecommendIndex < 0) {
                    this.ehA = -1;
                    return;
                } else {
                    this.ehv.H(videoRecommendIndex, false);
                    this.ehA = -1;
                }
            }
        } else {
            VoiceManager cm = com.baidu.tieba.tbadkCore.voice.b.cm(getActivity());
            if (cm != null) {
                cm.stopPlay();
            }
        }
        if (this.ehv != null) {
            this.ehv.setPrimary(isPrimary());
            this.ehv.aCG();
            this.ehv.setVideoThreadId(this.ccz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.ehv.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        iO();
        this.ehv = (ScrollFragmentTabHost) getView().findViewById(d.g.recommend_frs_tab_host);
        this.ehv.a(getPageContext(), this.dbx);
        this.ehv.a(getChildFragmentManager(), this.ehG, this.ehH);
        this.ehv.setPageUniqueId(getUniqueId());
        this.ehv.aCe();
        this.ehE = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        a.aCt().setCreateTime(System.currentTimeMillis() - a.aCt().ov(1));
        if (TbadkCoreApplication.isLogin() && this.ehv.getCurrentIndex() != 0) {
            this.ehw.gK(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aCt().e(System.currentTimeMillis(), 1);
        registerListener(this.ehC);
        registerListener(this.ehI);
        registerListener(this.ehF);
        registerListener(this.ehD);
        registerListener(this.ehB);
        aCv();
    }

    private void aCv() {
        this.ehx = new PbHistoryCacheModel(getPageContext());
        this.ehx.setUniqueId(getUniqueId());
        this.ehx.a(new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
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
        this.ehx.Nh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEO != null) {
            this.dEO.destory();
        }
        this.ehv.onDestroy();
        if (this.ehx != null) {
            this.ehx.cancelLoadData();
            this.ehx.cancelMessage();
        }
    }

    private void iO() {
        this.ehw = new c(getPageContext(), getUniqueId());
        this.ehw.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.ehv.aCF()) {
                    RecommendFrsControlFragment.this.ehv.n(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.ehv.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.ehv.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void gM(boolean z) {
                if (RecommendFrsControlFragment.this.ehv != null) {
                    RecommendFrsControlFragment.this.ehv.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ehw));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ehv != null) {
            this.ehv.onChangeSkinType(i);
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
                            this.ehv.aCC();
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
        if (this.ehv != null) {
            this.ehv.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ehy == null) {
            this.ehy = Boolean.valueOf(i.xo().xu());
        } else {
            r0 = this.ehy.booleanValue() != i.xo().xu();
            this.ehy = Boolean.valueOf(i.xo().xu());
        }
        if (r0) {
            this.ehv.XL();
        }
        if (this.ehv != null) {
            this.ehv.setPrimary(isPrimary());
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
        if (this.ehv != null) {
            return this.ehv.getCurrentPageKey();
        }
        return null;
    }
}
