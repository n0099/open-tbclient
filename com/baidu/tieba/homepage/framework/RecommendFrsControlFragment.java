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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.exoplayer2.Format;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private t cKC;
    private ScrollFragmentTabHost gYZ;
    private c gZa;
    private boolean gZk;
    private Boolean gZb = null;
    private boolean gZc = true;
    private boolean gZd = false;
    private NoNetworkView.a fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.gYZ.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.gYZ.bNF();
            }
        }
    };
    private t.a gZe = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        @Override // com.baidu.tbadk.BdToken.t.a
        public void ayk() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cKC != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.cKC.fl(true);
                    RecommendFrsControlFragment.this.cKC.ayj();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().aJA() != null) {
                        ba.aGG().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().aJA()});
                    }
                    TiebaStatic.log(new an("c13394").cy("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").cy("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener gZf = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.v(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.gYZ != null && RecommendFrsControlFragment.this.gYZ.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.gYZ.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener gZg = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.cKC != null) {
                if (!RecommendFrsControlFragment.this.bNv() || RecommendFrsControlFragment.this.cKC.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.gZd) {
                    if (!RecommendFrsControlFragment.this.bNv() && RecommendFrsControlFragment.this.cKC.isOpen()) {
                        RecommendFrsControlFragment.this.cKC.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.cKC.open();
            }
        }
    };
    private CustomMessageListener gZh = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.gYZ != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.gYZ.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.azW().ft(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.gYZ.bNF();
                            return;
                        } else if (RecommendFrsControlFragment.this.gYZ.getCurrentTabType() == 0) {
                            boolean bNG = RecommendFrsControlFragment.this.gYZ.bNG();
                            TiebaStatic.log(new an("c12350").X("obj_type", bNG ? 1 : 0));
                            if (bNG) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.gYZ.bNF();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.azW().ft(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener gZi = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener gZj = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.gZd = true;
                        if (RecommendFrsControlFragment.this.cKC != null && RecommendFrsControlFragment.this.cKC.isOpen()) {
                            RecommendFrsControlFragment.this.cKC.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.gZd = false;
                    if (RecommendFrsControlFragment.this.cKC != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bNv() && !RecommendFrsControlFragment.this.cKC.isOpen()) {
                        RecommendFrsControlFragment.this.cKC.open();
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
                    RecommendFrsControlFragment.this.gZk = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.gZk) {
                    RecommendFrsControlFragment.this.gZa.mz(false);
                }
            }
        }
    };
    private b gZl = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        @Override // com.baidu.tieba.homepage.framework.b
        public void M(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.gZa.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").X("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void y(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.gZa.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").X("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bNu() {
        }
    };
    private ConcernPageView.a gZm = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.gZa.Cf("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void Ce(String str) {
            RecommendFrsControlFragment.this.gZa.Cf(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void T(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.gYZ.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.gZc) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.gZc = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.gZa.mz(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gYZ = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.gYZ.setDrawingCacheEnabled(false);
        return this.gYZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.gYZ != null) {
            if (isPrimary()) {
                n.axX().fk(true);
            } else {
                n.axX().fk(false);
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
                this.gYZ.setVideoThreadId(str);
                this.gYZ.setCurrentTab(this.gYZ.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.gYZ.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.gYZ.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fx = com.baidu.tieba.tbadkCore.voice.b.fx(getActivity());
                if (fx != null) {
                    fx.stopPlay();
                }
            }
            this.gYZ.setPrimary(isPrimary());
            this.gYZ.bNK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.gYZ != null) {
            this.gYZ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dQ();
        this.gYZ.a(getPageContext(), this.fYY);
        this.gYZ.a(getChildFragmentManager(), this.gZl, this.gZm);
        this.gYZ.setScrollShadow(true);
        this.gYZ.setPageUniqueId(getUniqueId());
        this.gYZ.bND();
        this.gZk = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.gYZ.getCurrentTabType() != 0) {
            this.gZa.mz(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aFD().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.bNt().setCreateTime(System.currentTimeMillis() - a.bNt().uW(1));
        this.gYZ.bNM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bNt().n(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.gZh);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.gZi);
        registerListener(this.gZf);
        registerListener(this.gZg);
        registerListener(this.gZj);
        this.cKC = new t(getContext(), this.gZe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gYZ.onDestroy();
    }

    private void dQ() {
        this.gZa = new c(getPageContext(), getUniqueId());
        this.gZa.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.gYZ.bNJ()) {
                    RecommendFrsControlFragment.this.gYZ.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.gYZ.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.gYZ.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void mB(boolean z) {
                if (RecommendFrsControlFragment.this.gYZ != null) {
                    RecommendFrsControlFragment.this.gYZ.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.gZa));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gYZ != null) {
            this.gYZ.onChangeSkinType(i);
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
                            this.gYZ.bNF();
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
        if (this.gYZ != null) {
            this.gYZ.setPrimary(isPrimary());
        }
        if (this.cKC != null && this.cKC.isOpen()) {
            this.cKC.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gZb == null) {
            this.gZb = Boolean.valueOf(i.azO().isShowImages());
        } else {
            r0 = this.gZb.booleanValue() != i.azO().isShowImages();
            this.gZb = Boolean.valueOf(i.azO().isShowImages());
        }
        if (r0) {
            this.gYZ.bdr();
        }
        if (this.gYZ != null) {
            this.gYZ.setPrimary(isPrimary());
            this.gYZ.onResume();
        }
        if (this.cKC != null && bNv() && !this.cKC.isOpen() && !this.gZd) {
            this.cKC.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNv() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        w shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new w();
        }
        if (shakeData.getStartTime() == Format.OFFSET_SAMPLE_RELATIVE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.aJA())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aFD().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.aQY().getMaxCostFromServer();
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
            this.gYZ.bNN();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.gYZ != null) {
            return this.gYZ.getCurrentPageKey();
        }
        return null;
    }
}
