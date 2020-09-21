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
/* loaded from: classes21.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private v dUx;
    private ScrollFragmentTabHost iQM;
    private c iQN;
    private boolean iQY;
    private Boolean iQO = null;
    private boolean iQP = true;
    private boolean iQQ = false;
    private NoNetworkView.a fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.iQM.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.iQM.cAj();
            }
        }
    };
    private v.a iQR = new v.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.v.a
        public void bam() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dUx != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.dUx.hx(true);
                    RecommendFrsControlFragment.this.dUx.bal();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bnM() != null) {
                        be.bkp().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bnM()});
                    }
                    TiebaStatic.log(new aq("c13394").dF("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new aq("c13394").dF("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener iQS = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.r(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.iQM != null && RecommendFrsControlFragment.this.iQM.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.iQM.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener iQT = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.iQM != null && RecommendFrsControlFragment.this.iQM.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.iQM.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener iQU = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.dUx != null) {
                if (!RecommendFrsControlFragment.this.czX() || RecommendFrsControlFragment.this.dUx.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.iQQ) {
                    if (!RecommendFrsControlFragment.this.czX() && RecommendFrsControlFragment.this.dUx.isOpen()) {
                        RecommendFrsControlFragment.this.dUx.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.dUx.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                w.bwL().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener iQV = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.iQM != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.iQM.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.bcO().hO(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.iQM.cAj();
                            return;
                        } else if (RecommendFrsControlFragment.this.iQM.getCurrentTabType() == 0) {
                            boolean cAk = RecommendFrsControlFragment.this.iQM.cAk();
                            TiebaStatic.log(new aq("c12350").ai("obj_type", cAk ? 1 : 0));
                            if (cAk) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.iQM.cAj();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.bcO().hO(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener iQW = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener iQX = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.iQQ = true;
                        if (RecommendFrsControlFragment.this.dUx != null && RecommendFrsControlFragment.this.dUx.isOpen()) {
                            RecommendFrsControlFragment.this.dUx.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.iQQ = false;
                    if (RecommendFrsControlFragment.this.dUx != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.czX() && !RecommendFrsControlFragment.this.dUx.isOpen()) {
                        RecommendFrsControlFragment.this.dUx.open();
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
                    RecommendFrsControlFragment.this.iQY = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.iQY) {
                    RecommendFrsControlFragment.this.iQN.pJ(false);
                }
            }
        }
    };
    private b iQZ = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void P(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.iQN.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").ai("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void A(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.iQN.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").ai("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void czW() {
        }
    };
    private ConcernPageView.a iRa = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.iQN.Ke("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void JZ(String str) {
            RecommendFrsControlFragment.this.iQN.Ke(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ae(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.iQM.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.iQP) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.iQP = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.iQN.pJ(false);
            }
        }
    };
    private CustomMessageListener iRb = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.iQM != null && RecommendFrsControlFragment.this.iQM.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.iQM.cAj();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iQM = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.iQM.setDrawingCacheEnabled(false);
        return this.iQM;
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
        if (this.iQM != null) {
            if (isPrimary()) {
                n.aZG().hu(true);
                this.iQM.cAs();
            } else {
                n.aZG().hu(false);
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
                this.iQM.setVideoThreadId(str);
                this.iQM.setCurrentTab(this.iQM.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.iQM.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.dRG)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.iQM.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.iQM.getCurrentTabType() != 5) {
                            TiebaStatic.log(new aq("c13888"));
                        }
                        this.iQM.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.iQM.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.iQM.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fN = com.baidu.tieba.tbadkCore.voice.b.fN(getActivity());
                if (fN != null) {
                    fN.stopPlay();
                }
            }
            this.iQM.setPrimary(isPrimary());
            this.iQM.cAr();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.dRC);
                    getActivity().getIntent().removeExtra(f.dRC);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        w.bwL().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.dRD);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        w.bwL().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            w.bwL().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.iQM != null) {
            this.iQM.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        HI();
        this.iQM.a(getPageContext(), this.fFF);
        this.iQM.a(getChildFragmentManager(), this.iQZ, this.iRa);
        this.iQM.setScrollShadow(true);
        this.iQM.setPageUniqueId(getUniqueId());
        this.iQM.cAh();
        this.iQY = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.iQM.getCurrentTabType() != 0) {
            this.iQN.pJ(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.czV().setCreateTime(System.currentTimeMillis() - a.czV().Ac(1));
        if (com.baidu.tbadk.a.d.bbc()) {
            this.iQM.cAu();
        } else {
            this.iQM.cAt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.czV().r(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.iQV);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.iQW);
        registerListener(this.iQS);
        registerListener(this.iQT);
        registerListener(this.iQU);
        registerListener(this.iQX);
        registerListener(this.iRb);
        this.dUx = new v(getContext(), this.iQR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.iQM.onDestroy();
    }

    private void HI() {
        this.iQN = new c(getPageContext(), getUniqueId());
        this.iQN.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.iQM.cAq()) {
                    RecommendFrsControlFragment.this.iQM.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.iQM.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.iQM.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void pM(boolean z) {
                if (RecommendFrsControlFragment.this.iQM != null) {
                    RecommendFrsControlFragment.this.iQM.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.iQN));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iQM != null) {
            this.iQM.onChangeSkinType(i);
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
                            this.iQM.cAj();
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
        if (this.iQM != null) {
            this.iQM.setPrimary(isPrimary());
            this.iQM.cAv();
        }
        if (this.dUx != null && this.dUx.isOpen()) {
            this.dUx.close();
        }
        w.bwL().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iQO == null) {
            this.iQO = Boolean.valueOf(k.bcG().isShowImages());
        } else {
            r0 = this.iQO.booleanValue() != k.bcG().isShowImages();
            this.iQO = Boolean.valueOf(k.bcG().isShowImages());
        }
        if (r0) {
            this.iQM.bIh();
        }
        if (this.iQM != null) {
            this.iQM.setPrimary(isPrimary());
            this.iQM.onResume();
        }
        if (this.dUx != null && czX() && !this.dUx.isOpen() && !this.iQQ) {
            this.dUx.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czX() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ad shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ad();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bnM())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.bjf().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bve().getMaxCostFromServer();
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
            this.iQM.cAv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.iQM != null) {
            return this.iQM.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void B(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.iQM != null) {
                this.iQM.setCurrentTab(intExtra);
            }
        }
    }
}
