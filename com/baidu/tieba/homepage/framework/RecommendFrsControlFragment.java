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
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private t djU;
    private ScrollFragmentTabHost hJV;
    private c hJW;
    private boolean hKh;
    private Boolean hJX = null;
    private boolean hJY = true;
    private boolean hJZ = false;
    private NoNetworkView.a gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.hJV.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.hJV.bYu();
            }
        }
    };
    private t.a hKa = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        @Override // com.baidu.tbadk.BdToken.t.a
        public void aGy() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.djU != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.djU.gj(true);
                    RecommendFrsControlFragment.this.djU.aGx();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().aSb() != null) {
                        ba.aOY().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().aSb()});
                    }
                    TiebaStatic.log(new an("c13394").cI("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").cI("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener hKb = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.hJV != null && RecommendFrsControlFragment.this.hJV.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.hJV.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener hKc = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.hJV != null && RecommendFrsControlFragment.this.hJV.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.hJV.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener hKd = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.djU != null) {
                if (!RecommendFrsControlFragment.this.bYk() || RecommendFrsControlFragment.this.djU.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.hJZ) {
                    if (!RecommendFrsControlFragment.this.bYk() && RecommendFrsControlFragment.this.djU.isOpen()) {
                        RecommendFrsControlFragment.this.djU.close();
                        return;
                    }
                    return;
                }
                RecommendFrsControlFragment.this.djU.open();
            }
        }
    };
    private CustomMessageListener hKe = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.hJV != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.hJV.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.aIm().gr(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.hJV.bYu();
                            return;
                        } else if (RecommendFrsControlFragment.this.hJV.getCurrentTabType() == 0) {
                            boolean bYv = RecommendFrsControlFragment.this.hJV.bYv();
                            TiebaStatic.log(new an("c12350").af("obj_type", bYv ? 1 : 0));
                            if (bYv) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.hJV.bYu();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.aIm().gr(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener hKf = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener hKg = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.hJZ = true;
                        if (RecommendFrsControlFragment.this.djU != null && RecommendFrsControlFragment.this.djU.isOpen()) {
                            RecommendFrsControlFragment.this.djU.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.hJZ = false;
                    if (RecommendFrsControlFragment.this.djU != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.bYk() && !RecommendFrsControlFragment.this.djU.isOpen()) {
                        RecommendFrsControlFragment.this.djU.open();
                    }
                }
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.hKh = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.hKh) {
                    RecommendFrsControlFragment.this.hJW.nJ(false);
                }
            }
        }
    };
    private b hKi = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void P(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.hJW.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").af("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void y(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.hJW.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").af("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void bYj() {
        }
    };
    private ConcernPageView.a hKj = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.hJW.DN("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void DM(String str) {
            RecommendFrsControlFragment.this.hJW.DN(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void T(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.hJV.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.hJY) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.hJY = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.hJW.nJ(false);
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
        this.hJV = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.hJV.setDrawingCacheEnabled(false);
        return this.hJV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        String str;
        String str2;
        int intExtra;
        super.onPrimary();
        if (isAdded()) {
            TbSingleton.getInstance().setIsRecommendPage(isPrimary());
        }
        if (this.hJV != null) {
            if (isPrimary()) {
                n.aGl().gi(true);
            } else {
                n.aGl().gi(false);
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
                this.hJV.setVideoThreadId(str);
                this.hJV.setCurrentTab(this.hJV.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.hJV.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.hJV.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.hJV.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fo = com.baidu.tieba.tbadkCore.voice.b.fo(getActivity());
                if (fo != null) {
                    fo.stopPlay();
                }
            }
            this.hJV.setPrimary(isPrimary());
            this.hJV.bYz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.hJV != null) {
            this.hJV.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        zq();
        this.hJV.a(getPageContext(), this.gGl);
        this.hJV.a(getChildFragmentManager(), this.hKi, this.hKj);
        this.hJV.setScrollShadow(true);
        this.hJV.setPageUniqueId(getUniqueId());
        this.hJV.bYs();
        this.hKh = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.hJV.getCurrentTabType() != 0) {
            this.hJW.nJ(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNV().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.bYi().setCreateTime(System.currentTimeMillis() - a.bYi().vB(1));
        this.hJV.bYB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.bYi().n(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.hKe);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.hKf);
        registerListener(this.hKb);
        registerListener(this.hKc);
        registerListener(this.hKd);
        registerListener(this.hKg);
        this.djU = new t(getContext(), this.hKa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hJV.onDestroy();
    }

    private void zq() {
        this.hJW = new c(getPageContext(), getUniqueId());
        this.hJW.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.hJV.bYy()) {
                    RecommendFrsControlFragment.this.hJV.v(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.hJV.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.hJV.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void nL(boolean z) {
                if (RecommendFrsControlFragment.this.hJV != null) {
                    RecommendFrsControlFragment.this.hJV.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.hJW));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hJV != null) {
            this.hJV.onChangeSkinType(i);
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
                            this.hJV.bYu();
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
        if (this.hJV != null) {
            this.hJV.setPrimary(isPrimary());
        }
        if (this.djU != null && this.djU.isOpen()) {
            this.djU.close();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hJX == null) {
            this.hJX = Boolean.valueOf(i.aIe().isShowImages());
        } else {
            r0 = this.hJX.booleanValue() != i.aIe().isShowImages();
            this.hJX = Boolean.valueOf(i.aIe().isShowImages());
        }
        if (r0) {
            this.hJV.bmn();
        }
        if (this.hJV != null) {
            this.hJV.setPrimary(isPrimary());
            this.hJV.onResume();
        }
        if (this.djU != null && bYk() && !this.djU.isOpen() && !this.hJZ) {
            this.djU.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYk() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        w shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new w();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.aSb())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aNV().getString("shake_data", "{}")));
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
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.aZm().getMaxCostFromServer();
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
            this.hJV.bYC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.hJV != null) {
            return this.hJV.getCurrentPageKey();
        }
        return null;
    }
}
