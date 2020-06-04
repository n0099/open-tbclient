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
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.BdToken.t;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private t dxY;
    private ScrollFragmentTabHost hZl;
    private c hZm;
    private boolean hZx;
    private Boolean hZn = null;
    private boolean hZo = true;
    private boolean hZp = false;
    private NoNetworkView.a faB = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.hZl.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.hZl.ceW();
            }
        }
    };
    private t.a hZq = new t.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.t.a
        public void aLR() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dxY != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.dxY.gB(true);
                    RecommendFrsControlFragment.this.dxY.aLQ();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().aYg() != null) {
                        ba.aVa().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().aYg()});
                    }
                    TiebaStatic.log(new an("c13394").dh("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new an("c13394").dh("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener hZr = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.hZl != null && RecommendFrsControlFragment.this.hZl.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.hZl.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener hZs = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.a.d.aMs()) {
                if (RecommendFrsControlFragment.this.hZl != null && RecommendFrsControlFragment.this.hZl.getCurrentTabType() != 6) {
                    RecommendFrsControlFragment.this.hZl.setFakeClickCurrentTab(6);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 20);
        }
    };
    private CustomMessageListener hZt = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.dxY != null) {
                if (!RecommendFrsControlFragment.this.ceM() || RecommendFrsControlFragment.this.dxY.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.hZp) {
                    if (!RecommendFrsControlFragment.this.ceM() && RecommendFrsControlFragment.this.dxY.isOpen()) {
                        RecommendFrsControlFragment.this.dxY.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.dxY.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                v.bgH().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener hZu = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.hZl != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.hZl.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.aNY().gJ(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.hZl.ceW();
                            return;
                        } else if (RecommendFrsControlFragment.this.hZl.getCurrentTabType() == 0) {
                            boolean ceX = RecommendFrsControlFragment.this.hZl.ceX();
                            TiebaStatic.log(new an("c12350").ag("obj_type", ceX ? 1 : 0));
                            if (ceX) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.hZl.ceW();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.aNY().gJ(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener hZv = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener hZw = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.hZp = true;
                        if (RecommendFrsControlFragment.this.dxY != null && RecommendFrsControlFragment.this.dxY.isOpen()) {
                            RecommendFrsControlFragment.this.dxY.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.hZp = false;
                    if (RecommendFrsControlFragment.this.dxY != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.ceM() && !RecommendFrsControlFragment.this.dxY.isOpen()) {
                        RecommendFrsControlFragment.this.dxY.open();
                    }
                }
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.hZx = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.hZx) {
                    RecommendFrsControlFragment.this.hZm.of(false);
                }
            }
        }
    };
    private b hZy = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void P(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.hZm.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").ag("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void z(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.hZm.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new an("c11032").ag("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void ceL() {
        }
    };
    private ConcernPageView.a hZz = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.hZm.Fz("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void Fy(String str) {
            RecommendFrsControlFragment.this.hZm.Fz(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void W(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.hZl.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.hZo) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.hZo = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.hZm.of(false);
            }
        }
    };
    private CustomMessageListener hZA = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.hZl != null && RecommendFrsControlFragment.this.hZl.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.hZl.ceW();
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
        this.hZl = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.hZl.setDrawingCacheEnabled(false);
        return this.hZl;
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
        if (this.hZl != null) {
            if (isPrimary()) {
                n.aLE().gA(true);
                this.hZl.cfc();
            } else {
                n.aLE().gA(false);
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
                this.hZl.setVideoThreadId(str);
                this.hZl.setCurrentTab(this.hZl.getVideoRecommendIndex(), false);
            }
            if (isPrimary() && getActivity().getIntent() != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(getActivity().getIntent().getDataString())) {
                    this.hZl.setCurrentTab(5);
                    getActivity().getIntent().setData(null);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 16) {
                    this.hZl.setCurrentTab(5);
                    getActivity().getIntent().putExtra("locate_type", 0);
                } else if (getActivity().getIntent().getIntExtra("locate_type", 0) == 2) {
                    this.hZl.setCurrentTab(1);
                    getActivity().getIntent().putExtra("locate_type", 0);
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.hZl.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fr = com.baidu.tieba.tbadkCore.voice.b.fr(getActivity());
                if (fr != null) {
                    fr.stopPlay();
                }
            }
            this.hZl.setPrimary(isPrimary());
            this.hZl.cfb();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.dvE);
                    getActivity().getIntent().removeExtra(f.dvE);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        v.bgH().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra = getActivity().getIntent().getStringExtra(f.dvF);
                    if (!StringUtils.isNull(stringExtra)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra);
                        v.bgH().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            v.bgH().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.hZl != null) {
            this.hZl.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        AC();
        this.hZl.a(getPageContext(), this.faB);
        this.hZl.a(getChildFragmentManager(), this.hZy, this.hZz);
        this.hZl.setScrollShadow(true);
        this.hZl.setPageUniqueId(getUniqueId());
        this.hZl.ceU();
        this.hZx = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.hZl.getCurrentTabType() != 0) {
            this.hZm.of(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.ceK().setCreateTime(System.currentTimeMillis() - a.ceK().wj(1));
        this.hZl.cfe();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.ceK().n(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.hZu);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.hZv);
        registerListener(this.hZr);
        registerListener(this.hZs);
        registerListener(this.hZt);
        registerListener(this.hZw);
        registerListener(this.hZA);
        this.dxY = new t(getContext(), this.hZq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hZl.onDestroy();
    }

    private void AC() {
        this.hZm = new c(getPageContext(), getUniqueId());
        this.hZm.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.hZl.cfa()) {
                    RecommendFrsControlFragment.this.hZl.x(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.hZl.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.hZl.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void oh(boolean z) {
                if (RecommendFrsControlFragment.this.hZl != null) {
                    RecommendFrsControlFragment.this.hZl.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.hZm));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hZl != null) {
            this.hZl.onChangeSkinType(i);
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
                            this.hZl.ceW();
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
        if (this.hZl != null) {
            this.hZl.setPrimary(isPrimary());
        }
        if (this.dxY != null && this.dxY.isOpen()) {
            this.dxY.close();
        }
        v.bgH().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hZn == null) {
            this.hZn = Boolean.valueOf(k.aNQ().isShowImages());
        } else {
            r0 = this.hZn.booleanValue() != k.aNQ().isShowImages();
            this.hZn = Boolean.valueOf(k.aNQ().isShowImages());
        }
        if (r0) {
            this.hZl.brL();
        }
        if (this.hZl != null) {
            this.hZl.setPrimary(isPrimary());
            this.hZl.onResume();
        }
        if (this.dxY != null && ceM() && !this.dxY.isOpen() && !this.hZp) {
            this.dxY.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceM() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        x shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new x();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.aYg())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aTX().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bfv().getMaxCostFromServer();
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
            this.hZl.cff();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.hZl != null) {
            return this.hZl.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void z(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.hZl != null) {
                this.hZl.setCurrentTab(intExtra);
            }
        }
    }
}
