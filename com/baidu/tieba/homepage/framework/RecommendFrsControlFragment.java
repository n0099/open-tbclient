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
import com.baidu.tbadk.core.h;
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
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private String bdH;
    private ScrollFragmentTabHost cWU;
    private c cWV;
    private PbHistoryCacheModel cWW;
    private boolean cXb;
    private com.baidu.tbadk.h.a cqz;
    private Boolean cWX = null;
    private boolean mIsFirst = true;
    private int cWY = -1;
    private NoNetworkView.a bOC = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aL(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.cWU.aph();
            }
        }
    };
    private CustomMessageListener cWZ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.cWU != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.cWU.getCurrentTabType() == 0) {
                            boolean api = RecommendFrsControlFragment.this.cWU.api();
                            if (!isPrimary) {
                                TiebaStatic.log(new ak("c12350").r("obj_type", api ? 1 : 0));
                            }
                            if (api && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.cWU.aph();
                            }
                        } else if (RecommendFrsControlFragment.this.cWU.getCurrentTabType() == 3 && !RecommendFrsControlFragment.this.isPrimary()) {
                            ak akVar = new ak("c12478");
                            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                            TiebaStatic.log(akVar);
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.cWU.aph();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.cWU.aph();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cWU.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cWU.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener cXa = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.cWU != null && RecommendFrsControlFragment.this.cWU.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                ak akVar = new ak("c12478");
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                TiebaStatic.log(akVar);
            }
        }
    };
    private CustomMessageListener cXc = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.cXb = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.cXb) {
                    RecommendFrsControlFragment.this.cWV.aoX();
                }
            }
        }
    };
    private b cXd = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tieba.homepage.framework.b
        public void aN(int i, int i2) {
            RecommendFrsControlFragment.this.cWV.o(1, i, 1, i2);
            if (j.gV()) {
                TiebaStatic.log(new ak("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void z(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.cWV.o(2, i2, i, i3);
            if (j.gV()) {
                TiebaStatic.log(new ak("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aoZ() {
        }
    };
    private c.a cXe = new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tieba.homepage.concern.c.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.cWV.lp("");
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void lo(String str) {
            RecommendFrsControlFragment.this.cWV.lp(str);
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void y(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.mIsFirst) {
                    RecommendFrsControlFragment.this.cWU.setShowConcernRedTip(false);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.cWU.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.mIsFirst = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.cWV.aoX();
            }
        }
    };
    private CustomMessageListener cXf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BZ && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
            if (this.cqz == null) {
                this.cqz = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.cqz.fY(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.j.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (getActivity().getIntent() != null) {
            this.bdH = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
            if (!StringUtils.isNull(this.bdH)) {
                this.cWY = 3;
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
            }
        }
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cWU != null && this.cWY > 0) {
                this.cWU.getCurrentTabType();
                int videoRecommendIndex = this.cWU.getVideoRecommendIndex();
                if (videoRecommendIndex < 0) {
                    this.cWY = -1;
                    return;
                } else {
                    this.cWU.p(videoRecommendIndex, false);
                    this.cWY = -1;
                }
            }
        } else {
            VoiceManager bY = com.baidu.tieba.tbadkCore.voice.b.bY(getActivity());
            if (bY != null) {
                bY.stopPlay();
            }
        }
        if (this.cWU != null) {
            this.cWU.setPrimary(isPrimary());
            this.cWU.apl();
            this.cWU.setVideoThreadId(this.bdH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.cWU.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.cWU = (ScrollFragmentTabHost) getView().findViewById(d.h.recommend_frs_tab_host);
        this.cWU.a(getPageContext(), this.bOC);
        this.cWU.a(getChildFragmentManager(), this.cXd, this.cXe);
        this.cWU.setPageUniqueId(getUniqueId());
        this.cWU.aoG();
        this.cXb = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        a.aoY().setCreateTime(System.currentTimeMillis() - a.aoY().kN(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aoY().c(System.currentTimeMillis(), 1);
        registerListener(this.cWZ);
        registerListener(this.cXf);
        registerListener(this.cXc);
        registerListener(this.cXa);
        apa();
    }

    private void apa() {
        this.cWW = new PbHistoryCacheModel(getPageContext());
        this.cWW.setUniqueId(getUniqueId());
        this.cWW.a(new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
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
        this.cWW.EG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.homepage.framework.a.a.apm().onDestory();
        if (this.cqz != null) {
            this.cqz.destory();
        }
        this.cWU.onDestroy();
        if (this.cWW != null) {
            this.cWW.cancelLoadData();
            this.cWW.cancelMessage();
        }
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.apm().n(getUniqueId());
        this.cWV = new c(getPageContext(), getUniqueId());
        this.cWV.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.cWU.apk()) {
                    RecommendFrsControlFragment.this.cWU.g(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.cWU.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.cWU.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void fB(boolean z) {
                if (RecommendFrsControlFragment.this.cWU != null) {
                    RecommendFrsControlFragment.this.cWU.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cWV));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cWU != null) {
            this.cWU.onChangeSkinType(i);
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
                            this.cWU.aph();
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
        if (this.cWU != null) {
            this.cWU.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cWX == null) {
            this.cWX = Boolean.valueOf(h.oM().oS());
        } else {
            r0 = this.cWX.booleanValue() != h.oM().oS();
            this.cWX = Boolean.valueOf(h.oM().oS());
        }
        if (r0) {
            this.cWU.aoF();
        }
        if (this.cWU != null) {
            this.cWU.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Fl() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Fm() {
                return com.baidu.tbadk.pageStayDuration.e.Fr().Ft();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cWU != null) {
            return this.cWU.getCurrentPageKey();
        }
        return null;
    }
}
