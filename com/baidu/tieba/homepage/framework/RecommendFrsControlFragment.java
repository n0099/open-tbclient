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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.BdToken.t;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private t bUE;
    private com.baidu.tbadk.k.a fvO;
    private ScrollFragmentTabHost ggF;
    private c ggG;
    private String ggK;
    private boolean ggR;
    private Boolean ggH = null;
    private boolean ggI = true;
    private boolean ggJ = false;
    private NoNetworkView.a eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.ggF.btI();
            }
        }
    };
    private t.a ggL = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.t.a
        public void aeL() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.bUE != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.bUE.dN(true);
                    RecommendFrsControlFragment.this.bUE.aeK();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().app() != null) {
                        ba.amQ().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().app()});
                    }
                    TiebaStatic.log(new an("c13394").bS("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").bS("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener ggM = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.f.b.m(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.ggF != null && RecommendFrsControlFragment.this.ggF.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.ggF.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener ggN = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.bUE != null) {
                if (!RecommendFrsControlFragment.this.btx() || RecommendFrsControlFragment.this.bUE.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.ggJ) {
                    if (!RecommendFrsControlFragment.this.btx() && RecommendFrsControlFragment.this.bUE.isOpen()) {
                        RecommendFrsControlFragment.this.bUE.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.bUE.open();
            }
        }
    };
    private CustomMessageListener ggO = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.ggF != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.ggF.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.agy().dW(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.ggF.btI();
                            return;
                        } else if (RecommendFrsControlFragment.this.ggF.getCurrentTabType() != 2) {
                            if (RecommendFrsControlFragment.this.ggF.getCurrentTabType() == 0) {
                                boolean btJ = RecommendFrsControlFragment.this.ggF.btJ();
                                TiebaStatic.log(new an("c12350").O("obj_type", btJ ? 1 : 0));
                                if (btJ) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                    RecommendFrsControlFragment.this.ggF.btI();
                                    return;
                                }
                                return;
                            } else if (RecommendFrsControlFragment.this.ggF.getCurrentTabType() != 3) {
                                if (RecommendFrsControlFragment.this.ggF.getCurrentTabType() == 4) {
                                    TiebaStatic.log(new an("c13172").O("obj_type", 3));
                                    return;
                                }
                                return;
                            } else {
                                TiebaStatic.log(new an("c12478").bS("obj_source", "1"));
                                return;
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.agy().dW(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                    if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.ggF.getCurrentTabType() == 2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener ggP = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.ggF != null && RecommendFrsControlFragment.this.ggF.getCurrentTabType() == 3 && RecommendFrsControlFragment.this.isPrimary()) {
                TiebaStatic.log(new an("c12478").bS("obj_source", "1"));
            }
        }
    };
    private CustomMessageListener ggQ = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.ggJ = true;
                        if (RecommendFrsControlFragment.this.bUE != null && RecommendFrsControlFragment.this.bUE.isOpen()) {
                            RecommendFrsControlFragment.this.bUE.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.ggJ = false;
                    if (RecommendFrsControlFragment.this.bUE != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.btx() && !RecommendFrsControlFragment.this.bUE.isOpen()) {
                        RecommendFrsControlFragment.this.bUE.open();
                    }
                }
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.ggR = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.ggR) {
                    RecommendFrsControlFragment.this.ggG.kY(false);
                }
            }
        }
    };
    private b ggS = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        @Override // com.baidu.tieba.homepage.framework.b
        public void L(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.ggG.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").O("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.ggG.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").O("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void btw() {
        }
    };
    private ConcernPageView.a ggT = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.ggG.wQ("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void wP(String str) {
            RecommendFrsControlFragment.this.ggG.wQ(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void S(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.ggF.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.ggI) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.ggI = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.ggG.kY(false);
            }
        }
    };
    private CustomMessageListener ggU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
            if (this.fvO == null) {
                this.fvO = new com.baidu.tbadk.k.a(getPageContext());
            }
            this.fvO.pT(updateAttentionMessage.getData().toUid);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ggF = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.ggF.setDrawingCacheEnabled(false);
        return this.ggF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.ggF != null) {
            if (isPrimary()) {
                n.aey().dM(true);
            } else {
                n.aey().dM(false);
            }
            if (getActivity().getIntent() != null) {
                this.ggK = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str = getActivity().getIntent().getDataString();
            } else {
                str = null;
            }
            if ((!StringUtils.isNull(this.ggK) && isPrimary()) || (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.ggF.setCurrentTab(this.ggF.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.ggF.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.ggF.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager ee = com.baidu.tieba.tbadkCore.voice.b.ee(getActivity());
                if (ee != null) {
                    ee.stopPlay();
                }
            }
            this.ggF.setPrimary(isPrimary());
            this.ggF.btN();
            this.ggF.setVideoThreadId(this.ggK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.ggF != null) {
            this.ggF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dv();
        this.ggF.a(getPageContext(), this.eRC);
        this.ggF.a(getChildFragmentManager(), this.ggS, this.ggT);
        this.ggF.setScrollShadow(true);
        this.ggF.setPageUniqueId(getUniqueId());
        this.ggF.btG();
        this.ggR = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.ggF.getCurrentTabType() != 0) {
            this.ggG.kY(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.btv().setCreateTime(System.currentTimeMillis() - a.btv().sI(1));
        this.ggF.btP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.btv().m(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.ggO);
        registerListener(this.ggU);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.ggP);
        registerListener(this.ggM);
        registerListener(this.ggN);
        registerListener(this.ggQ);
        this.bUE = new t(getContext(), this.ggL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fvO != null) {
            this.fvO.destory();
        }
        this.ggF.onDestroy();
    }

    private void dv() {
        this.ggG = new c(getPageContext(), getUniqueId());
        this.ggG.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.ggF.btM()) {
                    RecommendFrsControlFragment.this.ggF.u(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.ggF.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.ggF.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void lb(boolean z) {
                if (RecommendFrsControlFragment.this.ggF != null) {
                    RecommendFrsControlFragment.this.ggF.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ggG));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ggF != null) {
            this.ggF.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                            this.ggF.btI();
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
        if (this.ggF != null) {
            this.ggF.setPrimary(isPrimary());
        }
        if (this.bUE != null && this.bUE.isOpen()) {
            this.bUE.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ggH == null) {
            this.ggH = Boolean.valueOf(i.agq().isShowImages());
        } else {
            r0 = this.ggH.booleanValue() != i.agq().isShowImages();
            this.ggH = Boolean.valueOf(i.agq().isShowImages());
        }
        if (r0) {
            this.ggF.aKh();
        }
        if (this.ggF != null) {
            this.ggF.setPrimary(isPrimary());
            this.ggF.onResume();
        }
        if (this.bUE != null && btx() && !this.bUE.isOpen() && !this.ggJ) {
            this.bUE.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btx() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        v shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new v();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.app())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.alR().getString("shake_data", "{}")));
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
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int getMaxCost() {
                return com.baidu.tbadk.o.e.awz().getMaxCostFromServer();
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
            this.ggF.btQ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.ggF != null) {
            return this.ggF.getCurrentPageKey();
        }
        return null;
    }
}
