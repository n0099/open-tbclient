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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.exoplayer2.Format;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes7.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private t cGw;
    private ScrollFragmentTabHost gWK;
    private c gWL;
    private boolean gWV;
    private Boolean gWM = null;
    private boolean gWN = true;
    private boolean gWO = false;
    private NoNetworkView.a fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.gWK.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.gWK.bLZ();
            }
        }
    };
    private t.a gWP = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        @Override // com.baidu.tbadk.BdToken.t.a
        public void avV() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cGw != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.cGw.fe(true);
                    RecommendFrsControlFragment.this.cGw.avU();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().aHf() != null) {
                        ba.aEt().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().aHf()});
                    }
                    TiebaStatic.log(new an("c13394").cp("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").cp("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener gWQ = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.v(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.gWK != null && RecommendFrsControlFragment.this.gWK.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.gWK.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener gWR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.cGw != null) {
                if (!RecommendFrsControlFragment.this.bLP() || RecommendFrsControlFragment.this.cGw.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.gWO) {
                    if (!RecommendFrsControlFragment.this.bLP() && RecommendFrsControlFragment.this.cGw.isOpen()) {
                        RecommendFrsControlFragment.this.cGw.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.cGw.open();
            }
        }
    };
    private CustomMessageListener gWS = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.gWK != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.gWK.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.axG().fm(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.gWK.bLZ();
                            return;
                        } else if (RecommendFrsControlFragment.this.gWK.getCurrentTabType() == 0) {
                            boolean bMa = RecommendFrsControlFragment.this.gWK.bMa();
                            TiebaStatic.log(new an("c12350").Z("obj_type", bMa ? 1 : 0));
                            if (bMa) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.gWK.bLZ();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.axG().fm(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener gWT = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener gWU = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.gWO = true;
                        if (RecommendFrsControlFragment.this.cGw != null && RecommendFrsControlFragment.this.cGw.isOpen()) {
                            RecommendFrsControlFragment.this.cGw.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.gWO = false;
                    if (RecommendFrsControlFragment.this.cGw != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bLP() && !RecommendFrsControlFragment.this.cGw.isOpen()) {
                        RecommendFrsControlFragment.this.cGw.open();
                    }
                }
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.gWV = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.gWV) {
                    RecommendFrsControlFragment.this.gWL.mx(false);
                }
            }
        }
    };
    private b gWW = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        @Override // com.baidu.tieba.homepage.framework.b
        public void L(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.gWL.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").Z("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void y(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.gWL.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").Z("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bLO() {
        }
    };
    private ConcernPageView.a gWX = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.gWL.BO("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void BN(String str) {
            RecommendFrsControlFragment.this.gWL.BO(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void R(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.gWK.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.gWN) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.gWN = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.gWL.mx(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gWK = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.gWK.setDrawingCacheEnabled(false);
        return this.gWK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.gWK != null) {
            if (isPrimary()) {
                n.avI().fd(true);
            } else {
                n.avI().fd(false);
            }
            if (getActivity().getIntent() != null) {
                str = getActivity().getIntent().getStringExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID);
                str2 = getActivity().getIntent().getDataString();
            } else {
                str = null;
                str2 = null;
            }
            if ((!StringUtils.isNull(str) && isPrimary()) || (!StringUtils.isNull(str2) && str2.startsWith("com.baidu.tieba://videosquare"))) {
                getActivity().getIntent().putExtra(MainTabActivityConfig.VIDEOTHREAD_ON_SQUARE_ID, "");
                this.gWK.setVideoThreadId(str);
                this.gWK.setCurrentTab(this.gWK.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.gWK.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.gWK.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
                if (TbSingleton.getInstance().isShowNewYearSkin() && UtilHelper.canUseStyleImmersiveSticky()) {
                    UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
                }
            } else {
                VoiceManager fx = com.baidu.tieba.tbadkCore.voice.b.fx(getActivity());
                if (fx != null) {
                    fx.stopPlay();
                }
                if (TbSingleton.getInstance().isShowNewYearSkin() && UtilHelper.canUseStyleImmersiveSticky()) {
                    UtilHelper.changeStatusBarIconAndTextColor(TbadkCoreApplication.getInst().getSkinType() == 4 || TbadkCoreApplication.getInst().getSkinType() == 1, getActivity());
                }
            }
            this.gWK.setPrimary(isPrimary());
            this.gWK.bMf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.gWK != null) {
            this.gWK.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dP();
        this.gWK.a(getPageContext(), this.fWI);
        this.gWK.a(getChildFragmentManager(), this.gWW, this.gWX);
        this.gWK.setScrollShadow(true);
        this.gWK.setPageUniqueId(getUniqueId());
        this.gWK.bLX();
        this.gWV = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.gWK.getCurrentTabType() != 0) {
            this.gWL.mx(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.bLN().setCreateTime(System.currentTimeMillis() - a.bLN().uQ(1));
        this.gWK.bMh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bLN().n(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.gWS);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.gWT);
        registerListener(this.gWQ);
        registerListener(this.gWR);
        registerListener(this.gWU);
        this.cGw = new t(getContext(), this.gWP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gWK.onDestroy();
    }

    private void dP() {
        this.gWL = new c(getPageContext(), getUniqueId());
        this.gWL.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.gWK.bMe()) {
                    RecommendFrsControlFragment.this.gWK.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.gWK.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.gWK.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void mz(boolean z) {
                if (RecommendFrsControlFragment.this.gWK != null) {
                    RecommendFrsControlFragment.this.gWK.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.gWL));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gWK != null) {
            this.gWK.onChangeSkinType(i);
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
                            this.gWK.bLZ();
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
        if (this.gWK != null) {
            this.gWK.setPrimary(isPrimary());
        }
        if (this.cGw != null && this.cGw.isOpen()) {
            this.cGw.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gWM == null) {
            this.gWM = Boolean.valueOf(i.axy().isShowImages());
        } else {
            r0 = this.gWM.booleanValue() != i.axy().isShowImages();
            this.gWM = Boolean.valueOf(i.axy().isShowImages());
        }
        if (r0) {
            this.gWK.baZ();
        }
        if (this.gWK != null) {
            this.gWK.setPrimary(isPrimary());
            this.gWK.onResume();
        }
        if (this.cGw != null && bLP() && !this.cGw.isOpen() && !this.gWO) {
            this.cGw.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLP() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        v shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new v();
        }
        if (shakeData.getStartTime() == Format.OFFSET_SAMPLE_RELATIVE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.aHf())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aDr().getString("shake_data", "{}")));
                TbSingleton.getInstance().setShakeData(shakeData);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return currentTimeMillis > shakeData.getStartTime() && currentTimeMillis < shakeData.getEndTime();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.aOF().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean a(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (!z) {
            this.gWK.bMi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.gWK != null) {
            return this.gWK.getCurrentPageKey();
        }
        return null;
    }
}
