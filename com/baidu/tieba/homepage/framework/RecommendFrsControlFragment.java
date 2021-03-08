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
    private ScrollFragmentTabHost keX;
    private c keY;
    private boolean kfj;
    private w mShakeController;
    private Boolean keZ = null;
    private boolean kfa = true;
    private boolean kfb = false;
    private NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.keX.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.keX.cPS();
            }
        }
    };
    private w.a kfc = new w.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.tbadk.BdToken.w.a
        public void biw() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.mShakeController != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.mShakeController.iZ(true);
                    RecommendFrsControlFragment.this.mShakeController.biv();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bwB() != null) {
                        bf.bsY().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bwB()});
                    }
                    TiebaStatic.log(new ar("c13394").dR("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new ar("c13394").dR("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener jjE = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (RecommendFrsControlFragment.this.keX != null && RecommendFrsControlFragment.this.keX.getCurrentTabType() != 0) {
                    RecommendFrsControlFragment.this.keX.setCurrentTab(0);
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener kfd = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.B(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.keX != null && RecommendFrsControlFragment.this.keX.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.keX.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener kfe = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.keX != null && RecommendFrsControlFragment.this.keX.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.keX.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener kff = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.mShakeController != null) {
                if (!RecommendFrsControlFragment.this.cPD() || RecommendFrsControlFragment.this.mShakeController.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.kfb) {
                    if (!RecommendFrsControlFragment.this.cPD() && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                        RecommendFrsControlFragment.this.mShakeController.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.mShakeController.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                x.bFG().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener kfg = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.keX != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.keX.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.bld().jp(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.keX.cPS();
                            return;
                        } else if (RecommendFrsControlFragment.this.keX.getCurrentTabType() == 0) {
                            boolean cPU = RecommendFrsControlFragment.this.keX.cPU();
                            TiebaStatic.log(new ar("c12350").aq("obj_type", cPU ? 1 : 0));
                            if (cPU) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.keX.cPS();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.bld().jp(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                }
            }
        }
    };
    private CustomMessageListener kfh = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener kfi = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.kfb = true;
                        if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.mShakeController.isOpen()) {
                            RecommendFrsControlFragment.this.mShakeController.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.kfb = false;
                    if (RecommendFrsControlFragment.this.mShakeController != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cPD() && !RecommendFrsControlFragment.this.mShakeController.isOpen()) {
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
                    RecommendFrsControlFragment.this.kfj = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.kfj) {
                    RecommendFrsControlFragment.this.keY.rZ(false);
                }
            }
        }
    };
    private b kfk = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.framework.b
        public void a(int i, com.baidu.tbadk.util.c cVar, int i2) {
            RecommendFrsControlFragment.this.keY.a(1, i, cVar, 1, i2);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ar("c11032").aq("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void a(int i, int i2, com.baidu.tbadk.util.c cVar, int i3) {
            RecommendFrsControlFragment.this.keY.a(2, i2, cVar, i, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ar("c11032").aq("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cPC() {
        }
    };
    private ConcernPageView.a kfl = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void b(com.baidu.tbadk.util.c cVar) {
            RecommendFrsControlFragment.this.keY.c("", cVar);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void b(String str, com.baidu.tbadk.util.c cVar) {
            RecommendFrsControlFragment.this.keY.c(str, cVar);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ai(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.keX.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.kfa) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.kfa = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.keY.rZ(false);
            }
        }
    };
    private CustomMessageListener kfm = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.keX != null && RecommendFrsControlFragment.this.keX.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.keX.cPS();
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
        this.keX = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.keX.setDrawingCacheEnabled(false);
        return this.keX;
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
        if (this.keX != null) {
            if (isPrimary()) {
                n.bhR().iX(true);
                this.keX.cQc();
            } else {
                n.bhR().iX(false);
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
                this.keX.setVideoThreadId(str);
                this.keX.setCurrentTab(this.keX.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.keX.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.eFD)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.keX.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.keX.getCurrentTabType() != 5) {
                            TiebaStatic.log(new ar("c13888"));
                        }
                        this.keX.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.keX.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.keX.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager gX = com.baidu.tieba.tbadkCore.voice.b.gX(getActivity());
                if (gX != null) {
                    gX.stopPlay();
                }
            }
            this.keX.setPrimary(isPrimary());
            this.keX.cQb();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.eFz);
                    getActivity().getIntent().removeExtra(f.eFz);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        x.bFG().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.eFA);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        x.bFG().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.bFG().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.keX != null) {
            this.keX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
        this.keX.a(getPageContext(), this.gzW);
        this.keX.a(getChildFragmentManager(), this.kfk, this.kfl);
        this.keX.setScrollShadow(false);
        this.keX.setPageUniqueId(getUniqueId());
        this.keX.cPQ();
        this.kfj = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.keX.getCurrentTabType() != 0) {
            this.keY.rZ(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brR().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cPB().setCreateTime(System.currentTimeMillis() - a.cPB().BB(1));
        com.baidu.tbadk.n.l.bEp().eM(System.currentTimeMillis() - a.cPB().BB(1));
        if (com.baidu.tbadk.a.d.bji()) {
            this.keX.cQe();
        } else {
            this.keX.cQd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cPB().B(System.currentTimeMillis(), 1);
        com.baidu.tbadk.n.l.bEp().eP(System.currentTimeMillis());
        super.onCreate(bundle);
        registerListener(this.kfg);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.kfh);
        this.jjE.setSelfListener(true);
        this.jjE.setTag(getPageContext().getUniqueId());
        registerListener(this.jjE);
        registerListener(this.kfd);
        registerListener(this.kfe);
        registerListener(this.kff);
        registerListener(this.kfi);
        registerListener(this.kfm);
        this.mShakeController = new w(getContext(), this.kfc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jjE);
        this.keX.onDestroy();
    }

    private void initModel() {
        this.keY = new c(getPageContext(), getUniqueId());
        this.keY.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.keX.cQa()) {
                    RecommendFrsControlFragment.this.keX.z(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.keX.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.keX.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void sc(boolean z) {
                if (RecommendFrsControlFragment.this.keX != null) {
                    RecommendFrsControlFragment.this.keX.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.keY));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.keX != null) {
            ap.setBackgroundColor(this.keX, R.color.CAM_X0202);
            this.keX.onChangeSkinType(i);
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
                            this.keX.cPS();
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
        if (this.keX != null) {
            this.keX.setPrimary(isPrimary());
            this.keX.cQf();
        }
        if (this.mShakeController != null && this.mShakeController.isOpen()) {
            this.mShakeController.close();
        }
        x.bFG().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.keZ == null) {
            this.keZ = Boolean.valueOf(k.bkV().isShowImages());
        } else {
            r0 = this.keZ.booleanValue() != k.bkV().isShowImages();
            this.keZ = Boolean.valueOf(k.bkV().isShowImages());
        }
        if (r0) {
            this.keX.bSD();
        }
        if (this.keX != null) {
            this.keX.setPrimary(isPrimary());
            this.keX.onResume();
        }
        if (this.mShakeController != null && cPD() && !this.mShakeController.isOpen() && !this.kfb) {
            this.mShakeController.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPD() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ad shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ad();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bwB())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.brR().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.bDW().getMaxCostFromServer();
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
            this.keX.cQf();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.keX != null) {
            return this.keX.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void C(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.keX != null) {
                this.keX.setCurrentTab(intExtra);
            }
        }
    }
}
