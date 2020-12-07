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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private boolean jMG;
    private ScrollFragmentTabHost jMu;
    private c jMv;
    private v mShakeController;
    private Boolean jMw = null;
    private boolean jMx = true;
    private boolean jMy = false;
    private NoNetworkView.a gpx = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.jMu.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.jMu.cOr();
            }
        }
    };
    private v.a jMz = new v.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.v.a
        public void bjL() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.mShakeController != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.mShakeController.iG(true);
                    RecommendFrsControlFragment.this.mShakeController.bjK();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bxF() != null) {
                        bf.bua().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bxF()});
                    }
                    TiebaStatic.log(new ar("c13394").dY("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new ar("c13394").dY("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener jMA = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.A(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.jMu != null && RecommendFrsControlFragment.this.jMu.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.jMu.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener jMB = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.jMu != null && RecommendFrsControlFragment.this.jMu.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.jMu.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener jMC = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.mShakeController != null) {
                if (!RecommendFrsControlFragment.this.cOd() || RecommendFrsControlFragment.this.mShakeController.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.jMy) {
                    if (!RecommendFrsControlFragment.this.cOd() && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                        RecommendFrsControlFragment.this.mShakeController.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.mShakeController.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                w.bGH().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener jMD = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.jMu != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.jMu.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.bmd().iW(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.jMu.cOr();
                            return;
                        } else if (RecommendFrsControlFragment.this.jMu.getCurrentTabType() == 0) {
                            boolean cOt = RecommendFrsControlFragment.this.jMu.cOt();
                            TiebaStatic.log(new ar("c12350").al("obj_type", cOt ? 1 : 0));
                            if (cOt) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.jMu.cOr();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.bmd().iW(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                }
            }
        }
    };
    private CustomMessageListener jME = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener jMF = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.jMy = true;
                        if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                            RecommendFrsControlFragment.this.mShakeController.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.jMy = false;
                    if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cOd() && !RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                        RecommendFrsControlFragment.this.mShakeController.open();
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
                    RecommendFrsControlFragment.this.jMG = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.jMG) {
                    RecommendFrsControlFragment.this.jMv.ru(false);
                }
            }
        }
    };
    private b jMH = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void S(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.jMv.f(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ar("c11032").al("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void G(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.jMv.f(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ar("c11032").al("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cOc() {
        }
    };
    private ConcernPageView.a jMI = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.jMv.Mq("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void Mj(String str) {
            RecommendFrsControlFragment.this.jMv.Mq(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ag(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.jMu.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.jMx) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.jMx = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.jMv.ru(false);
            }
        }
    };
    private CustomMessageListener jMJ = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.jMu != null && RecommendFrsControlFragment.this.jMu.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.jMu.cOr();
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
        this.jMu = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.jMu.setDrawingCacheEnabled(false);
        return this.jMu;
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
        if (this.jMu != null) {
            if (isPrimary()) {
                n.bjf().iE(true);
                this.jMu.cOB();
            } else {
                n.bjf().iE(false);
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
                this.jMu.setVideoThreadId(str);
                this.jMu.setCurrentTab(this.jMu.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.jMu.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.exs)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.jMu.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.jMu.getCurrentTabType() != 5) {
                            TiebaStatic.log(new ar("c13888"));
                        }
                        this.jMu.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.jMu.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.jMu.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager gF = com.baidu.tieba.tbadkCore.voice.b.gF(getActivity());
                if (gF != null) {
                    gF.stopPlay();
                }
            }
            this.jMu.setPrimary(isPrimary());
            this.jMu.cOA();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.exo);
                    getActivity().getIntent().removeExtra(f.exo);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        w.bGH().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.exp);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        w.bGH().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            w.bGH().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.jMu != null) {
            this.jMu.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        KR();
        this.jMu.a(getPageContext(), this.gpx);
        this.jMu.a(getChildFragmentManager(), this.jMH, this.jMI);
        this.jMu.setScrollShadow(false);
        this.jMu.setPageUniqueId(getUniqueId());
        this.jMu.cOp();
        this.jMG = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.jMu.getCurrentTabType() != 0) {
            this.jMv.ru(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cOb().setCreateTime(System.currentTimeMillis() - a.cOb().CB(1));
        m.bFp().eG(System.currentTimeMillis() - a.cOb().CB(1));
        if (com.baidu.tbadk.a.d.bkz()) {
            this.jMu.cOD();
        } else {
            this.jMu.cOC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cOb().B(System.currentTimeMillis(), 1);
        m.bFp().eJ(System.currentTimeMillis());
        super.onCreate(bundle);
        registerListener(this.jMD);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.jME);
        registerListener(this.jMA);
        registerListener(this.jMB);
        registerListener(this.jMC);
        registerListener(this.jMF);
        registerListener(this.jMJ);
        this.mShakeController = new v(getContext(), this.jMz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jMu.onDestroy();
    }

    private void KR() {
        this.jMv = new c(getPageContext(), getUniqueId());
        this.jMv.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.jMu.cOz()) {
                    RecommendFrsControlFragment.this.jMu.z(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.jMu.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.jMu.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void rx(boolean z) {
                if (RecommendFrsControlFragment.this.jMu != null) {
                    RecommendFrsControlFragment.this.jMu.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.jMv));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jMu != null) {
            if (!com.baidu.tbadk.a.d.bkA()) {
                ap.setBackgroundColor(this.jMu, R.color.CAM_X0202);
            } else {
                ap.setBackgroundColor(this.jMu, R.color.CAM_X0204);
            }
            this.jMu.onChangeSkinType(i);
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
                            this.jMu.cOr();
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
        if (this.jMu != null) {
            this.jMu.setPrimary(isPrimary());
            this.jMu.cOE();
        }
        if (this.mShakeController != null && this.mShakeController.isOpen()) {
            this.mShakeController.close();
        }
        w.bGH().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jMw == null) {
            this.jMw = Boolean.valueOf(k.blV().isShowImages());
        } else {
            r0 = this.jMw.booleanValue() != k.blV().isShowImages();
            this.jMw = Boolean.valueOf(k.blV().isShowImages());
        }
        if (r0) {
            this.jMu.bSZ();
        }
        if (this.jMu != null) {
            this.jMu.setPrimary(isPrimary());
            this.jMu.onResume();
        }
        if (this.mShakeController != null && cOd() && !this.mShakeController.isOpen() && !this.jMy) {
            this.mShakeController.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOd() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ad shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ad();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bxF())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.bsO().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bEZ().getMaxCostFromServer();
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
            this.jMu.cOE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.jMu != null) {
            return this.jMu.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void B(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.jMu != null) {
                this.jMu.setCurrentTab(intExtra);
            }
        }
    }
}
