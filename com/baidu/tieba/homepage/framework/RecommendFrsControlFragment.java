package com.baidu.tieba.homepage.framework;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.BdToken.v;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private v euQ;
    private ScrollFragmentTabHost jyb;
    private c jyc;
    private boolean jyn;
    private Boolean jyd = null;
    private boolean jye = true;
    private boolean jyf = false;
    private NoNetworkView.a ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.jyb.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.jyb.cJx();
            }
        }
    };
    private v.a jyg = new v.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.v.a
        public void bhn() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.euQ != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.euQ.ip(true);
                    RecommendFrsControlFragment.this.euQ.bhm();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().buP() != null) {
                        be.brr().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().buP()});
                    }
                    TiebaStatic.log(new aq("c13394").dR("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new aq("c13394").dR("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener jyh = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.r(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.jyb != null && RecommendFrsControlFragment.this.jyb.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.jyb.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener jyi = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.jyb != null && RecommendFrsControlFragment.this.jyb.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.jyb.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener jyj = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.euQ != null) {
                if (!RecommendFrsControlFragment.this.cJj() || RecommendFrsControlFragment.this.euQ.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.jyf) {
                    if (!RecommendFrsControlFragment.this.cJj() && RecommendFrsControlFragment.this.euQ.isOpen()) {
                        RecommendFrsControlFragment.this.euQ.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.euQ.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                w.bDN().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener jyk = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.jyb != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.jyb.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.bjP().iG(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.jyb.cJx();
                            return;
                        } else if (RecommendFrsControlFragment.this.jyb.getCurrentTabType() == 0) {
                            boolean cJz = RecommendFrsControlFragment.this.jyb.cJz();
                            TiebaStatic.log(new aq("c12350").al("obj_type", cJz ? 1 : 0));
                            if (cJz) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.jyb.cJx();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.bjP().iG(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                }
            }
        }
    };
    private CustomMessageListener jyl = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener jym = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.jyf = true;
                        if (RecommendFrsControlFragment.this.euQ != null && RecommendFrsControlFragment.this.euQ.isOpen()) {
                            RecommendFrsControlFragment.this.euQ.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.jyf = false;
                    if (RecommendFrsControlFragment.this.euQ != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cJj() && !RecommendFrsControlFragment.this.euQ.isOpen()) {
                        RecommendFrsControlFragment.this.euQ.open();
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
                    RecommendFrsControlFragment.this.jyn = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.jyn) {
                    RecommendFrsControlFragment.this.jyc.qQ(false);
                }
            }
        }
    };
    private b jyo = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void R(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.jyc.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").al("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void B(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.jyc.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").al("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cJi() {
        }
    };
    private ConcernPageView.a jyp = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.jyc.LI("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void LB(String str) {
            RecommendFrsControlFragment.this.jyc.LI(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ag(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.jyb.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.jye) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.jye = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.jyc.qQ(false);
            }
        }
    };
    private CustomMessageListener jyq = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.jyb != null && RecommendFrsControlFragment.this.jyb.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.jyb.cJx();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jyb = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.jyb.setDrawingCacheEnabled(false);
        return this.jyb;
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
        if (this.jyb != null) {
            if (isPrimary()) {
                n.bgH().im(true);
                this.jyb.cJH();
            } else {
                n.bgH().im(false);
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
                this.jyb.setVideoThreadId(str);
                this.jyb.setCurrentTab(this.jyb.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.jyb.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.erY)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.jyb.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.jyb.getCurrentTabType() != 5) {
                            TiebaStatic.log(new aq("c13888"));
                        }
                        this.jyb.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.jyb.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.jyb.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fV = com.baidu.tieba.tbadkCore.voice.b.fV(getActivity());
                if (fV != null) {
                    fV.stopPlay();
                }
            }
            this.jyb.setPrimary(isPrimary());
            this.jyb.cJG();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.erU);
                    getActivity().getIntent().removeExtra(f.erU);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        w.bDN().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.erV);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        w.bDN().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            w.bDN().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.jyb != null) {
            this.jyb.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Jz();
        this.jyb.a(getPageContext(), this.ghG);
        this.jyb.a(getChildFragmentManager(), this.jyo, this.jyp);
        this.jyb.setScrollShadow(true);
        this.jyb.setPageUniqueId(getUniqueId());
        this.jyb.cJv();
        this.jyn = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.jyb.getCurrentTabType() != 0) {
            this.jyc.qQ(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bqh().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cJh().setCreateTime(System.currentTimeMillis() - a.cJh().Bo(1));
        if (com.baidu.tbadk.a.d.bid()) {
            this.jyb.cJJ();
        } else {
            this.jyb.cJI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cJh().z(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.jyk);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.jyl);
        registerListener(this.jyh);
        registerListener(this.jyi);
        registerListener(this.jyj);
        registerListener(this.jym);
        registerListener(this.jyq);
        this.euQ = new v(getContext(), this.jyg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jyb.onDestroy();
    }

    private void Jz() {
        this.jyc = new c(getPageContext(), getUniqueId());
        this.jyc.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.jyb.cJF()) {
                    RecommendFrsControlFragment.this.jyb.y(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.jyb.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.jyb.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void qT(boolean z) {
                if (RecommendFrsControlFragment.this.jyb != null) {
                    RecommendFrsControlFragment.this.jyb.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.jyc));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jyb != null) {
            this.jyb.onChangeSkinType(i);
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
                            this.jyb.cJx();
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
        if (this.jyb != null) {
            this.jyb.setPrimary(isPrimary());
            this.jyb.cJK();
        }
        if (this.euQ != null && this.euQ.isOpen()) {
            this.euQ.close();
        }
        w.bDN().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jyd == null) {
            this.jyd = Boolean.valueOf(k.bjH().isShowImages());
        } else {
            r0 = this.jyd.booleanValue() != k.bjH().isShowImages();
            this.jyd = Boolean.valueOf(k.bjH().isShowImages());
        }
        if (r0) {
            this.jyb.bPV();
        }
        if (this.jyb != null) {
            this.jyb.setPrimary(isPrimary());
            this.jyb.onResume();
        }
        if (this.euQ != null && cJj() && !this.euQ.isOpen() && !this.jyf) {
            this.euQ.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJj() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ad shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ad();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.buP())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.bqh().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bCg().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (!z) {
            this.jyb.cJK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.jyb != null) {
            return this.jyb.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void B(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.jyb != null) {
                this.jyb.setCurrentTab(intExtra);
            }
        }
    }
}
