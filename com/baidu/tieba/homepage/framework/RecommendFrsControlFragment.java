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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private ScrollFragmentTabHost jVf;
    private c jVg;
    private boolean jVr;
    private w mShakeController;
    private Boolean jVh = null;
    private boolean jVi = true;
    private boolean jVj = false;
    private NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.jVf.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.jVf.cNH();
            }
        }
    };
    private w.a jVk = new w.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tbadk.BdToken.w.a
        public void bih() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.mShakeController != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.mShakeController.iX(true);
                    RecommendFrsControlFragment.this.mShakeController.big();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bwg() != null) {
                        be.bsB().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bwg()});
                    }
                    TiebaStatic.log(new aq("c13394").dW("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new aq("c13394").dW("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener jca = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (RecommendFrsControlFragment.this.jVf != null && RecommendFrsControlFragment.this.jVf.getCurrentTabType() != 0) {
                    RecommendFrsControlFragment.this.jVf.setCurrentTab(0);
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jVl = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.B(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.jVf != null && RecommendFrsControlFragment.this.jVf.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.jVf.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener jVm = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.jVf != null && RecommendFrsControlFragment.this.jVf.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.jVf.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener jVn = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.mShakeController != null) {
                if (!RecommendFrsControlFragment.this.cNt() || RecommendFrsControlFragment.this.mShakeController.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.jVj) {
                    if (!RecommendFrsControlFragment.this.cNt() && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                        RecommendFrsControlFragment.this.mShakeController.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.mShakeController.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                v.bFj().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener jVo = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.jVf != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.jVf.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.bkJ().jn(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.jVf.cNH();
                            return;
                        } else if (RecommendFrsControlFragment.this.jVf.getCurrentTabType() == 0) {
                            boolean cNJ = RecommendFrsControlFragment.this.jVf.cNJ();
                            TiebaStatic.log(new aq("c12350").an("obj_type", cNJ ? 1 : 0));
                            if (cNJ) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.jVf.cNH();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.bkJ().jn(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                }
            }
        }
    };
    private CustomMessageListener jVp = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener jVq = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.jVj = true;
                        if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                            RecommendFrsControlFragment.this.mShakeController.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.jVj = false;
                    if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cNt() && !RecommendFrsControlFragment.this.mShakeController.isOpen()) {
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
                    RecommendFrsControlFragment.this.jVr = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.jVr) {
                    RecommendFrsControlFragment.this.jVg.rN(false);
                }
            }
        }
    };
    private b jVs = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.framework.b
        public void U(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.jVg.f(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").an("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void H(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.jVg.f(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").an("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cNs() {
        }
    };
    private ConcernPageView.a jVt = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.jVg.Li("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void Lb(String str) {
            RecommendFrsControlFragment.this.jVg.Li(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ai(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.jVf.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.jVi) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.jVi = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.jVg.rN(false);
            }
        }
    };
    private CustomMessageListener jVu = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.jVf != null && RecommendFrsControlFragment.this.jVf.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.jVf.cNH();
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
        this.jVf = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.jVf.setDrawingCacheEnabled(false);
        return this.jVf;
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
        if (this.jVf != null) {
            if (isPrimary()) {
                n.bhC().iV(true);
                this.jVf.cNR();
            } else {
                n.bhC().iV(false);
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
                this.jVf.setVideoThreadId(str);
                this.jVf.setCurrentTab(this.jVf.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.jVf.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.eBW)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.jVf.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.jVf.getCurrentTabType() != 5) {
                            TiebaStatic.log(new aq("c13888"));
                        }
                        this.jVf.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.jVf.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.jVf.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager gV = com.baidu.tieba.tbadkCore.voice.b.gV(getActivity());
                if (gV != null) {
                    gV.stopPlay();
                }
            }
            this.jVf.setPrimary(isPrimary());
            this.jVf.cNQ();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.eBS);
                    getActivity().getIntent().removeExtra(f.eBS);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        v.bFj().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.eBT);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        v.bFj().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            v.bFj().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.jVf != null) {
            this.jVf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
        this.jVf.a(getPageContext(), this.gvp);
        this.jVf.a(getChildFragmentManager(), this.jVs, this.jVt);
        this.jVf.setScrollShadow(false);
        this.jVf.setPageUniqueId(getUniqueId());
        this.jVf.cNF();
        this.jVr = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.jVf.getCurrentTabType() != 0) {
            this.jVg.rN(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brx().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cNr().setCreateTime(System.currentTimeMillis() - a.cNr().Bi(1));
        com.baidu.tbadk.n.l.bDT().eG(System.currentTimeMillis() - a.cNr().Bi(1));
        if (com.baidu.tbadk.a.d.biU()) {
            this.jVf.cNT();
        } else {
            this.jVf.cNS();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cNr().D(System.currentTimeMillis(), 1);
        com.baidu.tbadk.n.l.bDT().eJ(System.currentTimeMillis());
        super.onCreate(bundle);
        registerListener(this.jVo);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.jVp);
        this.jca.setSelfListener(true);
        this.jca.setTag(getPageContext().getUniqueId());
        registerListener(this.jca);
        registerListener(this.jVl);
        registerListener(this.jVm);
        registerListener(this.jVn);
        registerListener(this.jVq);
        registerListener(this.jVu);
        this.mShakeController = new w(getContext(), this.jVk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jca);
        this.jVf.onDestroy();
    }

    private void initModel() {
        this.jVg = new c(getPageContext(), getUniqueId());
        this.jVg.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.jVf.cNP()) {
                    RecommendFrsControlFragment.this.jVf.z(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.jVf.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.jVf.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void rQ(boolean z) {
                if (RecommendFrsControlFragment.this.jVf != null) {
                    RecommendFrsControlFragment.this.jVf.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.jVg));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jVf != null) {
            ao.setBackgroundColor(this.jVf, R.color.CAM_X0202);
            this.jVf.onChangeSkinType(i);
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
                            this.jVf.cNH();
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
        if (this.jVf != null) {
            this.jVf.setPrimary(isPrimary());
            this.jVf.cNU();
        }
        if (this.mShakeController != null && this.mShakeController.isOpen()) {
            this.mShakeController.close();
        }
        v.bFj().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jVh == null) {
            this.jVh = Boolean.valueOf(k.bkB().isShowImages());
        } else {
            r0 = this.jVh.booleanValue() != k.bkB().isShowImages();
            this.jVh = Boolean.valueOf(k.bkB().isShowImages());
        }
        if (r0) {
            this.jVf.bRN();
        }
        if (this.jVf != null) {
            this.jVf.setPrimary(isPrimary());
            this.jVf.onResume();
        }
        if (this.mShakeController != null && cNt() && !this.mShakeController.isOpen() && !this.jVj) {
            this.mShakeController.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cNt() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ad shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ad();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bwg())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.brx().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bDA().getMaxCostFromServer();
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
            this.jVf.cNU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.jVf != null) {
            return this.jVf.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void C(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.jVf != null) {
                this.jVf.setCurrentTab(intExtra);
            }
        }
    }
}
