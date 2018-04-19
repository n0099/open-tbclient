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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private String bmp;
    private com.baidu.tbadk.h.a cXB;
    private ScrollFragmentTabHost dCf;
    private c dCg;
    private PbHistoryCacheModel dCh;
    private boolean dCo;
    private Boolean dCi = null;
    private boolean dCj = true;
    private int dCk = -1;
    private NoNetworkView.a ctg = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.dCf.axA();
            }
        }
    };
    private CustomMessageListener dCl = new CustomMessageListener(2921323) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.g(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.dCf != null && RecommendFrsControlFragment.this.dCf.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.dCf.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener dCm = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.dCf != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        if (RecommendFrsControlFragment.this.dCf.getCurrentTabType() == 0) {
                            boolean axB = RecommendFrsControlFragment.this.dCf.axB();
                            if (!isPrimary) {
                                TiebaStatic.log(new al("c12350").r("obj_type", axB ? 1 : 0));
                            }
                            if (axB && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                                RecommendFrsControlFragment.this.dCf.axA();
                            }
                        } else if (RecommendFrsControlFragment.this.dCf.getCurrentTabType() == 3 && !RecommendFrsControlFragment.this.isPrimary()) {
                            al alVar = new al("c12478");
                            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                            TiebaStatic.log(alVar);
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.dCf.axA();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.dCf.axA();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dCf.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dCf.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921041, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener dCn = new CustomMessageListener(2921308) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.dCf != null && RecommendFrsControlFragment.this.dCf.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                al alVar = new al("c12478");
                alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                TiebaStatic.log(alVar);
            }
        }
    };
    private CustomMessageListener dCp = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.dCo = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.dCo) {
                    RecommendFrsControlFragment.this.dCg.gp(false);
                }
            }
        }
    };
    private b dCq = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.framework.b
        public void aN(int i, int i2) {
            RecommendFrsControlFragment.this.dCg.r(1, i, 1, i2);
            if (j.gD()) {
                TiebaStatic.log(new al("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void B(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.dCg.r(2, i2, i, i3);
            if (j.gD()) {
                TiebaStatic.log(new al("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void axr() {
        }
    };
    private ConcernPageView.a dCr = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.dCg.mG("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void mF(String str) {
            RecommendFrsControlFragment.this.dCg.mG(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void y(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.dCj) {
                    RecommendFrsControlFragment.this.dCf.setShowConcernRedTip(false);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.dCf.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                }
                RecommendFrsControlFragment.this.dCj = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.dCg.gp(false);
            }
        }
    };
    private CustomMessageListener dCs = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Aj && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
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
            if (this.cXB == null) {
                this.cXB = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.cXB.gz(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (getActivity().getIntent() != null) {
            this.bmp = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
            if (!StringUtils.isNull(this.bmp)) {
                this.dCk = 3;
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
            }
            String dataString = getActivity().getIntent().getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("com.baidu.tieba://videosquare") && this.dCf != null && this.dCf.getVideoRecommendIndex() >= 0) {
                this.dCf.setCurrentTab(this.dCf.getVideoRecommendIndex(), false);
            }
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.dCf != null && this.dCk > 0) {
                this.dCf.getCurrentTabType();
                int videoRecommendIndex = this.dCf.getVideoRecommendIndex();
                if (videoRecommendIndex < 0) {
                    this.dCk = -1;
                    return;
                } else {
                    this.dCf.setCurrentTab(videoRecommendIndex, false);
                    this.dCk = -1;
                }
            }
        } else {
            VoiceManager ca = com.baidu.tieba.tbadkCore.voice.b.ca(getActivity());
            if (ca != null) {
                ca.stopPlay();
            }
        }
        if (this.dCf != null) {
            this.dCf.setPrimary(isPrimary());
            this.dCf.axE();
            this.dCf.setVideoThreadId(this.bmp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.dCf.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aS();
        this.dCf = (ScrollFragmentTabHost) getView().findViewById(d.g.recommend_frs_tab_host);
        this.dCf.a(getPageContext(), this.ctg);
        this.dCf.a(getChildFragmentManager(), this.dCq, this.dCr);
        this.dCf.setPageUniqueId(getUniqueId());
        this.dCf.axa();
        this.dCo = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.dCf.getCurrentIndex() != 0) {
            this.dCg.gp(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
        a.axq().setCreateTime(System.currentTimeMillis() - a.axq().lV(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.axq().f(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.dCm);
        registerListener(this.dCs);
        registerListener(this.dCp);
        registerListener(this.dCn);
        registerListener(this.dCl);
        axs();
    }

    private void axs() {
        this.dCh = new PbHistoryCacheModel(getPageContext());
        this.dCh.setUniqueId(getUniqueId());
        this.dCh.a(new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
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
        this.dCh.FJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cXB != null) {
            this.cXB.destory();
        }
        this.dCf.onDestroy();
        if (this.dCh != null) {
            this.dCh.cancelLoadData();
            this.dCh.cancelMessage();
        }
    }

    private void aS() {
        this.dCg = new c(getPageContext(), getUniqueId());
        this.dCg.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.dCf.axD()) {
                    RecommendFrsControlFragment.this.dCf.o(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.dCf.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.dCf.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void gr(boolean z) {
                if (RecommendFrsControlFragment.this.dCf != null) {
                    RecommendFrsControlFragment.this.dCf.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.dCg));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dCf != null) {
            this.dCf.onChangeSkinType(i);
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
                            this.dCf.axA();
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
        if (this.dCf != null) {
            this.dCf.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dCi == null) {
            this.dCi = Boolean.valueOf(i.pY().qe());
        } else {
            r0 = this.dCi.booleanValue() != i.pY().qe();
            this.dCi = Boolean.valueOf(i.pY().qe());
        }
        if (r0) {
            this.dCf.Ql();
        }
        if (this.dCf != null) {
            this.dCf.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Go() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Gp() {
                return com.baidu.tbadk.pageStayDuration.e.Gt().Gv();
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
        if (this.dCf != null) {
            return this.dCf.getCurrentPageKey();
        }
        return null;
    }
}
