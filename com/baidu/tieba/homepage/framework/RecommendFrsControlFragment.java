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
import com.baidu.tbadk.BdToken.w;
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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private ScrollFragmentTabHost kcG;
    private c kcH;
    private boolean kcS;
    private w mShakeController;
    private Boolean kcI = null;
    private boolean kcJ = true;
    private boolean kcK = false;
    private NoNetworkView.a gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.kcG.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.kcG.cPE();
            }
        }
    };
    private w.a kcL = new w.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tbadk.BdToken.w.a
        public void biu() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.mShakeController != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.mShakeController.iZ(true);
                    RecommendFrsControlFragment.this.mShakeController.bit();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bwy() != null) {
                        bf.bsV().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bwy()});
                    }
                    TiebaStatic.log(new ar("c13394").dR("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new ar("c13394").dR("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener jhG = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (RecommendFrsControlFragment.this.kcG != null && RecommendFrsControlFragment.this.kcG.getCurrentTabType() != 0) {
                    RecommendFrsControlFragment.this.kcG.setCurrentTab(0);
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener kcM = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.B(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.kcG != null && RecommendFrsControlFragment.this.kcG.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.kcG.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener kcN = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.kcG != null && RecommendFrsControlFragment.this.kcG.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.kcG.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener kcO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.mShakeController != null) {
                if (!RecommendFrsControlFragment.this.cPp() || RecommendFrsControlFragment.this.mShakeController.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.kcK) {
                    if (!RecommendFrsControlFragment.this.cPp() && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                        RecommendFrsControlFragment.this.mShakeController.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.mShakeController.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                x.bFC().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener kcP = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.kcG != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.kcG.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.blb().jp(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.kcG.cPE();
                            return;
                        } else if (RecommendFrsControlFragment.this.kcG.getCurrentTabType() == 0) {
                            boolean cPG = RecommendFrsControlFragment.this.kcG.cPG();
                            TiebaStatic.log(new ar("c12350").ap("obj_type", cPG ? 1 : 0));
                            if (cPG) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.kcG.cPE();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.blb().jp(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                }
            }
        }
    };
    private CustomMessageListener kcQ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener kcR = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.kcK = true;
                        if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                            RecommendFrsControlFragment.this.mShakeController.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.kcK = false;
                    if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cPp() && !RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                        RecommendFrsControlFragment.this.mShakeController.open();
                    }
                }
            }
        }
    };
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.kcS = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.kcS) {
                    RecommendFrsControlFragment.this.kcH.rZ(false);
                }
            }
        }
    };
    private b kcT = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.framework.b
        public void a(int i, com.baidu.tbadk.util.c cVar, int i2) {
            RecommendFrsControlFragment.this.kcH.a(1, i, cVar, 1, i2);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ar("c11032").ap("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void a(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
            RecommendFrsControlFragment.this.kcH.a(2, i2, cVar, i, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ar("c11032").ap("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cPo() {
        }
    };
    private ConcernPageView.a kcU = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void b(com.baidu.tbadk.util.c cVar) {
            RecommendFrsControlFragment.this.kcH.c("", cVar);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void b(String str, com.baidu.tbadk.util.c cVar) {
            RecommendFrsControlFragment.this.kcH.c(str, cVar);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ai(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.kcG.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.kcJ) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.kcJ = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.kcH.rZ(false);
            }
        }
    };
    private CustomMessageListener kcV = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.kcG != null && RecommendFrsControlFragment.this.kcG.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.kcG.cPE();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kcG = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.kcG.setDrawingCacheEnabled(false);
        return this.kcG;
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
        if (this.kcG != null) {
            if (isPrimary()) {
                n.bhP().iX(true);
                this.kcG.cPO();
            } else {
                n.bhP().iX(false);
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
                this.kcG.setVideoThreadId(str);
                this.kcG.setCurrentTab(this.kcG.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.kcG.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.eEc)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.kcG.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.kcG.getCurrentTabType() != 5) {
                            TiebaStatic.log(new ar("c13888"));
                        }
                        this.kcG.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.kcG.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.kcG.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager gY = com.baidu.tieba.tbadkCore.voice.b.gY(getActivity());
                if (gY != null) {
                    gY.stopPlay();
                }
            }
            this.kcG.setPrimary(isPrimary());
            this.kcG.cPN();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.eDY);
                    getActivity().getIntent().removeExtra(f.eDY);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        x.bFC().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.eDZ);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        x.bFC().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.bFC().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.kcG != null) {
            this.kcG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
        this.kcG.a(getPageContext(), this.gxZ);
        this.kcG.a(getChildFragmentManager(), this.kcT, this.kcU);
        this.kcG.setScrollShadow(false);
        this.kcG.setPageUniqueId(getUniqueId());
        this.kcG.cPC();
        this.kcS = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.kcG.getCurrentTabType() != 0) {
            this.kcH.rZ(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cPn().setCreateTime(System.currentTimeMillis() - a.cPn().By(1));
        com.baidu.tbadk.n.l.bEl().eM(System.currentTimeMillis() - a.cPn().By(1));
        if (com.baidu.tbadk.a.d.bjg()) {
            this.kcG.cPQ();
        } else {
            this.kcG.cPP();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cPn().B(System.currentTimeMillis(), 1);
        com.baidu.tbadk.n.l.bEl().eP(System.currentTimeMillis());
        super.onCreate(bundle);
        registerListener(this.kcP);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.kcQ);
        this.jhG.setSelfListener(true);
        this.jhG.setTag(getPageContext().getUniqueId());
        registerListener(this.jhG);
        registerListener(this.kcM);
        registerListener(this.kcN);
        registerListener(this.kcO);
        registerListener(this.kcR);
        registerListener(this.kcV);
        this.mShakeController = new w(getContext(), this.kcL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jhG);
        this.kcG.onDestroy();
    }

    private void initModel() {
        this.kcH = new c(getPageContext(), getUniqueId());
        this.kcH.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.kcG.cPM()) {
                    RecommendFrsControlFragment.this.kcG.z(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.kcG.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.kcG.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void sc(boolean z) {
                if (RecommendFrsControlFragment.this.kcG != null) {
                    RecommendFrsControlFragment.this.kcG.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.kcH));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kcG != null) {
            ap.setBackgroundColor(this.kcG, R.color.CAM_X0202);
            this.kcG.onChangeSkinType(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                            this.kcG.cPE();
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.kcG != null) {
            this.kcG.setPrimary(isPrimary());
            this.kcG.cPR();
        }
        if (this.mShakeController != null && this.mShakeController.isOpen()) {
            this.mShakeController.close();
        }
        x.bFC().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.kcI == null) {
            this.kcI = Boolean.valueOf(k.bkT().isShowImages());
        } else {
            r0 = this.kcI.booleanValue() != k.bkT().isShowImages();
            this.kcI = Boolean.valueOf(k.bkT().isShowImages());
        }
        if (r0) {
            this.kcG.bSq();
        }
        if (this.kcG != null) {
            this.kcG.setPrimary(isPrimary());
            this.kcG.onResume();
        }
        if (this.mShakeController != null && cPp() && !this.mShakeController.isOpen() && !this.kcK) {
            this.mShakeController.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPp() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ad shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ad();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bwy())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.brQ().getString("shake_data", "{}")));
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
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bDS().getMaxCostFromServer();
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
            this.kcG.cPR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.kcG != null) {
            return this.kcG.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void C(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.kcG != null) {
                this.kcG.setCurrentTab(intExtra);
            }
        }
    }
}
