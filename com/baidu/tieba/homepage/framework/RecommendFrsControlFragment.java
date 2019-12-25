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
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.exoplayer2.Format;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private t cGk;
    private boolean gTB;
    private ScrollFragmentTabHost gTq;
    private c gTr;
    private Boolean gTs = null;
    private boolean gTt = true;
    private boolean gTu = false;
    private NoNetworkView.a fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.gTq.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.gTq.bKU();
            }
        }
    };
    private t.a gTv = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
        @Override // com.baidu.tbadk.BdToken.t.a
        public void avC() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cGk != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.cGk.eZ(true);
                    RecommendFrsControlFragment.this.cGk.avB();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().aGM() != null) {
                        ba.aEa().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().aGM()});
                    }
                    TiebaStatic.log(new an("c13394").cp("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").cp("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener gTw = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.v(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.gTq != null && RecommendFrsControlFragment.this.gTq.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.gTq.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener gTx = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.cGk != null) {
                if (!RecommendFrsControlFragment.this.bKK() || RecommendFrsControlFragment.this.cGk.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.gTu) {
                    if (!RecommendFrsControlFragment.this.bKK() && RecommendFrsControlFragment.this.cGk.isOpen()) {
                        RecommendFrsControlFragment.this.cGk.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.cGk.open();
            }
        }
    };
    private CustomMessageListener gTy = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.gTq != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.gTq.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.axn().fh(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.gTq.bKU();
                            return;
                        } else if (RecommendFrsControlFragment.this.gTq.getCurrentTabType() == 0) {
                            boolean bKV = RecommendFrsControlFragment.this.gTq.bKV();
                            TiebaStatic.log(new an("c12350").Z("obj_type", bKV ? 1 : 0));
                            if (bKV) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.gTq.bKU();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.axn().fh(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener gTz = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener gTA = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.gTu = true;
                        if (RecommendFrsControlFragment.this.cGk != null && RecommendFrsControlFragment.this.cGk.isOpen()) {
                            RecommendFrsControlFragment.this.cGk.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.gTu = false;
                    if (RecommendFrsControlFragment.this.cGk != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bKK() && !RecommendFrsControlFragment.this.cGk.isOpen()) {
                        RecommendFrsControlFragment.this.cGk.open();
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
                    RecommendFrsControlFragment.this.gTB = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.gTB) {
                    RecommendFrsControlFragment.this.gTr.mm(false);
                }
            }
        }
    };
    private b gTC = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        @Override // com.baidu.tieba.homepage.framework.b
        public void L(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.gTr.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").Z("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void y(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.gTr.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").Z("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bKJ() {
        }
    };
    private ConcernPageView.a gTD = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.gTr.BE("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void BD(String str) {
            RecommendFrsControlFragment.this.gTr.BE(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void R(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.gTq.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.gTt) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.gTt = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.gTr.mm(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gTq = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.gTq.setDrawingCacheEnabled(false);
        return this.gTq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.gTq != null) {
            if (isPrimary()) {
                n.avp().eY(true);
            } else {
                n.avp().eY(false);
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
                this.gTq.setVideoThreadId(str);
                this.gTq.setCurrentTab(this.gTq.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.gTq.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.gTq.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fw = com.baidu.tieba.tbadkCore.voice.b.fw(getActivity());
                if (fw != null) {
                    fw.stopPlay();
                }
            }
            this.gTq.setPrimary(isPrimary());
            this.gTq.bKZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.gTq != null) {
            this.gTq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dP();
        this.gTq.a(getPageContext(), this.fTz);
        this.gTq.a(getChildFragmentManager(), this.gTC, this.gTD);
        this.gTq.setScrollShadow(true);
        this.gTq.setPageUniqueId(getUniqueId());
        this.gTq.bKS();
        this.gTB = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.gTq.getCurrentTabType() != 0) {
            this.gTr.mm(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aCY().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.bKI().setCreateTime(System.currentTimeMillis() - a.bKI().uL(1));
        this.gTq.bLb();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bKI().n(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.gTy);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.gTz);
        registerListener(this.gTw);
        registerListener(this.gTx);
        registerListener(this.gTA);
        this.cGk = new t(getContext(), this.gTv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gTq.onDestroy();
    }

    private void dP() {
        this.gTr = new c(getPageContext(), getUniqueId());
        this.gTr.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.gTq.bKY()) {
                    RecommendFrsControlFragment.this.gTq.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.gTq.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.gTq.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void mo(boolean z) {
                if (RecommendFrsControlFragment.this.gTq != null) {
                    RecommendFrsControlFragment.this.gTq.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.gTr));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gTq != null) {
            this.gTq.onChangeSkinType(i);
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
                            this.gTq.bKU();
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
        if (this.gTq != null) {
            this.gTq.setPrimary(isPrimary());
        }
        if (this.cGk != null && this.cGk.isOpen()) {
            this.cGk.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gTs == null) {
            this.gTs = Boolean.valueOf(i.axf().isShowImages());
        } else {
            r0 = this.gTs.booleanValue() != i.axf().isShowImages();
            this.gTs = Boolean.valueOf(i.axf().isShowImages());
        }
        if (r0) {
            this.gTq.baE();
        }
        if (this.gTq != null) {
            this.gTq.setPrimary(isPrimary());
            this.gTq.onResume();
        }
        if (this.cGk != null && bKK() && !this.cGk.isOpen() && !this.gTu) {
            this.cGk.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKK() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        v shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new v();
        }
        if (shakeData.getStartTime() == Format.OFFSET_SAMPLE_RELATIVE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.aGM())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aCY().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.aOm().getMaxCostFromServer();
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
            this.gTq.bLc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.gTq != null) {
            return this.gTq.getCurrentPageKey();
        }
        return null;
    }
}
