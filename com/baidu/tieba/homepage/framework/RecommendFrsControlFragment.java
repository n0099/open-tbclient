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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private String bZZ;
    private com.baidu.tbadk.h.a dwY;
    private ScrollFragmentTabHost ebE;
    private c ebF;
    private PbHistoryCacheModel ebG;
    private boolean ebM;
    private Boolean ebH = null;
    private boolean mIsFirst = true;
    private int ebI = -1;
    private NoNetworkView.a cTN = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.ebE.aBb();
            }
        }
    };
    private CustomMessageListener ebJ = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.u(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.ebE != null && RecommendFrsControlFragment.this.ebE.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.ebE.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener ebK = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.ebE != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.ebE.getCurrentTabType() == 0) {
                            boolean aBc = RecommendFrsControlFragment.this.ebE.aBc();
                            if (!isPrimary) {
                                TiebaStatic.log(new ak("c12350").s("obj_type", aBc ? 1 : 0));
                            }
                            if (aBc && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.ebE.aBb();
                            }
                        } else if (RecommendFrsControlFragment.this.ebE.getCurrentTabType() == 3 && !RecommendFrsControlFragment.this.isPrimary()) {
                            ak akVar = new ak("c12478");
                            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                            TiebaStatic.log(akVar);
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.ebE.aBb();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.ebE.aBb();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ebE.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ebE.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener ebL = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.ebE != null && RecommendFrsControlFragment.this.ebE.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                ak akVar = new ak("c12478");
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                TiebaStatic.log(akVar);
            }
        }
    };
    private CustomMessageListener ebN = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.ebM = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.ebM) {
                    RecommendFrsControlFragment.this.ebF.gu(false);
                }
            }
        }
    };
    private b ebO = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tieba.homepage.framework.b
        public void bN(int i, int i2) {
            RecommendFrsControlFragment.this.ebF.y(1, i, 1, i2);
            if (j.ow()) {
                TiebaStatic.log(new ak("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void M(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.ebF.y(2, i2, i, i3);
            if (j.ow()) {
                TiebaStatic.log(new ak("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aAT() {
        }
    };
    private c.a ebP = new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        @Override // com.baidu.tieba.homepage.concern.c.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.ebF.mh("");
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void mg(String str) {
            RecommendFrsControlFragment.this.ebF.mh(str);
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void B(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.mIsFirst) {
                    RecommendFrsControlFragment.this.ebE.setShowConcernRedTip(false);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.ebE.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.mIsFirst = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.ebF.gu(false);
            }
        }
    };
    private CustomMessageListener ebQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apO && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.dwY == null) {
                this.dwY = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.dwY.gp(updateAttentionMessage.getData().toUid);
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
            this.bZZ = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
            if (!StringUtils.isNull(this.bZZ)) {
                this.ebI = 3;
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
            }
            String dataString = getActivity().getIntent().getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("com.baidu.tieba://videosquare") && this.ebE != null && this.ebE.getVideoRecommendIndex() >= 0) {
                this.ebE.C(this.ebE.getVideoRecommendIndex(), false);
            }
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.ebE != null && this.ebI > 0) {
                this.ebE.getCurrentTabType();
                int videoRecommendIndex = this.ebE.getVideoRecommendIndex();
                if (videoRecommendIndex < 0) {
                    this.ebI = -1;
                    return;
                } else {
                    this.ebE.C(videoRecommendIndex, false);
                    this.ebI = -1;
                }
            }
        } else {
            VoiceManager cq = com.baidu.tieba.tbadkCore.voice.b.cq(getActivity());
            if (cq != null) {
                cq.stopPlay();
            }
        }
        if (this.ebE != null) {
            this.ebE.setPrimary(isPrimary());
            this.ebE.aBf();
            this.ebE.setVideoThreadId(this.bZZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.ebE.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        iO();
        this.ebE = (ScrollFragmentTabHost) getView().findViewById(d.g.recommend_frs_tab_host);
        this.ebE.a(getPageContext(), this.cTN);
        this.ebE.a(getChildFragmentManager(), this.ebO, this.ebP);
        this.ebE.setPageUniqueId(getUniqueId());
        this.ebE.aAD();
        this.ebM = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        a.aAS().setCreateTime(System.currentTimeMillis() - a.aAS().oB(1));
        if (TbadkCoreApplication.isLogin() && this.ebE.getCurrentIndex() != 0) {
            this.ebF.gu(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aAS().e(System.currentTimeMillis(), 1);
        registerListener(this.ebK);
        registerListener(this.ebQ);
        registerListener(this.ebN);
        registerListener(this.ebL);
        registerListener(this.ebJ);
        aAU();
    }

    private void aAU() {
        this.ebG = new PbHistoryCacheModel(getPageContext());
        this.ebG.setUniqueId(getUniqueId());
        this.ebG.a(new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
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
        this.ebG.ML();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dwY != null) {
            this.dwY.destory();
        }
        this.ebE.onDestroy();
        if (this.ebG != null) {
            this.ebG.cancelLoadData();
            this.ebG.cancelMessage();
        }
    }

    private void iO() {
        this.ebF = new c(getPageContext(), getUniqueId());
        this.ebF.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.ebE.aBe()) {
                    RecommendFrsControlFragment.this.ebE.l(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.ebE.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.ebE.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void gw(boolean z) {
                if (RecommendFrsControlFragment.this.ebE != null) {
                    RecommendFrsControlFragment.this.ebE.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ebF));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ebE != null) {
            this.ebE.onChangeSkinType(i);
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
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                            this.ebE.aBb();
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
        if (this.ebE != null) {
            this.ebE.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ebH == null) {
            this.ebH = Boolean.valueOf(i.wB().wH());
        } else {
            r0 = this.ebH.booleanValue() != i.wB().wH();
            this.ebH = Boolean.valueOf(i.wB().wH());
        }
        if (r0) {
            this.ebE.XM();
        }
        if (this.ebE != null) {
            this.ebE.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Nq() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Nr() {
                return com.baidu.tbadk.pageStayDuration.e.Nv().Nx();
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
        if (this.ebE != null) {
            return this.ebE.getCurrentPageKey();
        }
        return null;
    }
}
