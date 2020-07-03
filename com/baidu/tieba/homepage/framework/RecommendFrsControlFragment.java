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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private v dDe;
    private ScrollFragmentTabHost inM;
    private c inN;
    private boolean inY;
    private Boolean inO = null;
    private boolean inP = true;
    private boolean inQ = false;
    private NoNetworkView.a flL = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.inM.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.inM.cis();
            }
        }
    };
    private v.a inR = new v.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.v.a
        public void aNv() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dDe != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.dDe.gI(true);
                    RecommendFrsControlFragment.this.dDe.aNu();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bal() != null) {
                        bc.aWU().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bal()});
                    }
                    TiebaStatic.log(new ao("c13394").dk("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), (int) R.string.neterror);
                TiebaStatic.log(new ao("c13394").dk("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener inS = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.inM != null && RecommendFrsControlFragment.this.inM.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.inM.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener inT = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.a.d.aNV()) {
                if (RecommendFrsControlFragment.this.inM != null && RecommendFrsControlFragment.this.inM.getCurrentTabType() != 6) {
                    RecommendFrsControlFragment.this.inM.setFakeClickCurrentTab(6);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 20);
        }
    };
    private CustomMessageListener inU = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.dDe != null) {
                if (!RecommendFrsControlFragment.this.cih() || RecommendFrsControlFragment.this.dDe.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.inQ) {
                    if (!RecommendFrsControlFragment.this.cih() && RecommendFrsControlFragment.this.dDe.isOpen()) {
                        RecommendFrsControlFragment.this.dDe.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.dDe.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                com.baidu.tbadk.util.v.biU().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener inV = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.inM != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.inM.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.aPI().gQ(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.inM.cis();
                            return;
                        } else if (RecommendFrsControlFragment.this.inM.getCurrentTabType() == 0) {
                            boolean cit = RecommendFrsControlFragment.this.inM.cit();
                            TiebaStatic.log(new ao("c12350").ag("obj_type", cit ? 1 : 0));
                            if (cit) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.inM.cis();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.aPI().gQ(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener inW = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener inX = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.inQ = true;
                        if (RecommendFrsControlFragment.this.dDe != null && RecommendFrsControlFragment.this.dDe.isOpen()) {
                            RecommendFrsControlFragment.this.dDe.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.inQ = false;
                    if (RecommendFrsControlFragment.this.dDe != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cih() && !RecommendFrsControlFragment.this.dDe.isOpen()) {
                        RecommendFrsControlFragment.this.dDe.open();
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
                    RecommendFrsControlFragment.this.inY = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.inY) {
                    RecommendFrsControlFragment.this.inN.oq(false);
                }
            }
        }
    };
    private b inZ = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void P(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.inN.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ao("c11032").ag("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void z(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.inN.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ao("c11032").ag("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cig() {
        }
    };
    private ConcernPageView.a ioa = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.inN.FZ("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void FY(String str) {
            RecommendFrsControlFragment.this.inN.FZ(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void X(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.inM.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.inP) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.inP = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.inN.oq(false);
            }
        }
    };
    private CustomMessageListener iob = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.inM != null && RecommendFrsControlFragment.this.inM.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.inM.cis();
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
        this.inM = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.inM.setDrawingCacheEnabled(false);
        return this.inM;
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
        if (this.inM != null) {
            if (isPrimary()) {
                n.aMP().gF(true);
                this.inM.ciz();
            } else {
                n.aMP().gF(false);
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
                this.inM.setVideoThreadId(str);
                this.inM.setCurrentTab(this.inM.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.inM.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.dAs)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.inM.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        this.inM.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.inM.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.inM.setCurrentTab(6);
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
            this.inM.setPrimary(isPrimary());
            this.inM.ciy();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.dAo);
                    getActivity().getIntent().removeExtra(f.dAo);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        com.baidu.tbadk.util.v.biU().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.dAp);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        com.baidu.tbadk.util.v.biU().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            com.baidu.tbadk.util.v.biU().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.inM != null) {
            this.inM.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bc();
        this.inM.a(getPageContext(), this.flL);
        this.inM.a(getChildFragmentManager(), this.inZ, this.ioa);
        this.inM.setScrollShadow(true);
        this.inM.setPageUniqueId(getUniqueId());
        this.inM.ciq();
        this.inY = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.inM.getCurrentTabType() != 0) {
            this.inN.oq(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aVP().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cif().setCreateTime(System.currentTimeMillis() - a.cif().wP(1));
        this.inM.ciA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cif().n(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.inV);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.inW);
        registerListener(this.inS);
        registerListener(this.inT);
        registerListener(this.inU);
        registerListener(this.inX);
        registerListener(this.iob);
        this.dDe = new v(getContext(), this.inR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.inM.onDestroy();
    }

    private void Bc() {
        this.inN = new c(getPageContext(), getUniqueId());
        this.inN.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.inM.cix()) {
                    RecommendFrsControlFragment.this.inM.x(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.inM.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.inM.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void os(boolean z) {
                if (RecommendFrsControlFragment.this.inM != null) {
                    RecommendFrsControlFragment.this.inM.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.inN));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.inM != null) {
            this.inM.onChangeSkinType(i);
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
                            this.inM.cis();
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
        if (this.inM != null) {
            this.inM.setPrimary(isPrimary());
        }
        if (this.dDe != null && this.dDe.isOpen()) {
            this.dDe.close();
        }
        com.baidu.tbadk.util.v.biU().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.inO == null) {
            this.inO = Boolean.valueOf(k.aPA().isShowImages());
        } else {
            r0 = this.inO.booleanValue() != k.aPA().isShowImages();
            this.inO = Boolean.valueOf(k.aPA().isShowImages());
        }
        if (r0) {
            this.inM.buH();
        }
        if (this.inM != null) {
            this.inM.setPrimary(isPrimary());
            this.inM.onResume();
        }
        if (this.dDe != null && cih() && !this.dDe.isOpen() && !this.inQ) {
            this.dDe.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cih() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new z();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bal())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aVP().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bhB().getMaxCostFromServer();
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
            this.inM.ciB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.inM != null) {
            return this.inM.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void z(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.inM != null) {
                this.inM.setCurrentTab(intExtra);
            }
        }
    }
}
