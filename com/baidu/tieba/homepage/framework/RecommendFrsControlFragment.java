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
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private v dSj;
    private ScrollFragmentTabHost iIf;
    private c iIg;
    private boolean iIr;
    private Boolean iIh = null;
    private boolean iIi = true;
    private boolean iIj = false;
    private NoNetworkView.a fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.iIf.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.iIf.cwB();
            }
        }
    };
    private v.a iIk = new v.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.v.a
        public void aZz() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dSj != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.dSj.hz(true);
                    RecommendFrsControlFragment.this.dSj.aZy();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bmS() != null) {
                        be.bju().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bmS()});
                    }
                    TiebaStatic.log(new aq("c13394").dD("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new aq("c13394").dD("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener iIl = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.r(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.iIf != null && RecommendFrsControlFragment.this.iIf.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.iIf.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener iIm = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.iIf != null && RecommendFrsControlFragment.this.iIf.getCurrentTabType() != 6) {
                RecommendFrsControlFragment.this.iIf.setFakeClickCurrentTab(6);
            }
        }
    };
    private CustomMessageListener iIn = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.dSj != null) {
                if (!RecommendFrsControlFragment.this.cwq() || RecommendFrsControlFragment.this.dSj.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.iIj) {
                    if (!RecommendFrsControlFragment.this.cwq() && RecommendFrsControlFragment.this.dSj.isOpen()) {
                        RecommendFrsControlFragment.this.dSj.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.dSj.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                com.baidu.tbadk.util.v.bvB().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener iIo = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.iIf != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.iIf.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.bbU().hQ(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.iIf.cwB();
                            return;
                        } else if (RecommendFrsControlFragment.this.iIf.getCurrentTabType() == 0) {
                            boolean cwC = RecommendFrsControlFragment.this.iIf.cwC();
                            TiebaStatic.log(new aq("c12350").ai("obj_type", cwC ? 1 : 0));
                            if (cwC) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.iIf.cwB();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.bbU().hQ(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener iIp = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener iIq = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.iIj = true;
                        if (RecommendFrsControlFragment.this.dSj != null && RecommendFrsControlFragment.this.dSj.isOpen()) {
                            RecommendFrsControlFragment.this.dSj.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.iIj = false;
                    if (RecommendFrsControlFragment.this.dSj != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.cwq() && !RecommendFrsControlFragment.this.dSj.isOpen()) {
                        RecommendFrsControlFragment.this.dSj.open();
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
                    RecommendFrsControlFragment.this.iIr = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.iIr) {
                    RecommendFrsControlFragment.this.iIg.pA(false);
                }
            }
        }
    };
    private b iIs = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void N(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.iIg.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").ai("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void A(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.iIg.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new aq("c11032").ai("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void cwp() {
        }
    };
    private ConcernPageView.a iIt = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.iIg.JB("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void JA(String str) {
            RecommendFrsControlFragment.this.iIg.JB(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void ac(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.iIf.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.iIi) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.iIi = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.iIg.pA(false);
            }
        }
    };
    private CustomMessageListener iIu = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.iIf != null && RecommendFrsControlFragment.this.iIf.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.iIf.cwB();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iIf = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.iIf.setDrawingCacheEnabled(false);
        return this.iIf;
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
        if (this.iIf != null) {
            if (isPrimary()) {
                n.aYT().hw(true);
                this.iIf.cwK();
            } else {
                n.aYT().hw(false);
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
                this.iIf.setVideoThreadId(str);
                this.iIf.setCurrentTab(this.iIf.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.iIf.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.dPw)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.iIf.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.iIf.getCurrentTabType() != 5) {
                            TiebaStatic.log(new aq("c13888"));
                        }
                        this.iIf.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.iIf.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.iIf.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fH = com.baidu.tieba.tbadkCore.voice.b.fH(getActivity());
                if (fH != null) {
                    fH.stopPlay();
                }
            }
            this.iIf.setPrimary(isPrimary());
            this.iIf.cwJ();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.dPs);
                    getActivity().getIntent().removeExtra(f.dPs);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        com.baidu.tbadk.util.v.bvB().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.dPt);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        com.baidu.tbadk.util.v.bvB().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            com.baidu.tbadk.util.v.bvB().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.iIf != null) {
            this.iIf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Hh();
        this.iIf.a(getPageContext(), this.fCp);
        this.iIf.a(getChildFragmentManager(), this.iIs, this.iIt);
        this.iIf.setScrollShadow(true);
        this.iIf.setPageUniqueId(getUniqueId());
        this.iIf.cwz();
        this.iIr = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.iIf.getCurrentTabType() != 0) {
            this.iIg.pA(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.cwo().setCreateTime(System.currentTimeMillis() - a.cwo().zB(1));
        this.iIf.cwL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.cwo().o(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.iIo);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.iIp);
        registerListener(this.iIl);
        registerListener(this.iIm);
        registerListener(this.iIn);
        registerListener(this.iIq);
        registerListener(this.iIu);
        this.dSj = new v(getContext(), this.iIk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.iIf.onDestroy();
    }

    private void Hh() {
        this.iIg = new c(getPageContext(), getUniqueId());
        this.iIg.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.iIf.cwI()) {
                    RecommendFrsControlFragment.this.iIf.w(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.iIf.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.iIf.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void pC(boolean z) {
                if (RecommendFrsControlFragment.this.iIf != null) {
                    RecommendFrsControlFragment.this.iIf.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.iIg));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iIf != null) {
            this.iIf.onChangeSkinType(i);
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
                            this.iIf.cwB();
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
        if (this.iIf != null) {
            this.iIf.setPrimary(isPrimary());
        }
        if (this.dSj != null && this.dSj.isOpen()) {
            this.dSj.close();
        }
        com.baidu.tbadk.util.v.bvB().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iIh == null) {
            this.iIh = Boolean.valueOf(k.bbM().isShowImages());
        } else {
            r0 = this.iIh.booleanValue() != k.bbM().isShowImages();
            this.iIh = Boolean.valueOf(k.bbM().isShowImages());
        }
        if (r0) {
            this.iIf.bGQ();
        }
        if (this.iIf != null) {
            this.iIf.setPrimary(isPrimary());
            this.iIf.onResume();
        }
        if (this.dSj != null && cwq() && !this.dSj.isOpen() && !this.iIj) {
            this.dSj.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwq() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ac shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new ac();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bmS())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.bik().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.btZ().getMaxCostFromServer();
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
            this.iIf.cwM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.iIf != null) {
            return this.iIf.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void B(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.iIf != null) {
                this.iIf.setCurrentTab(intExtra);
            }
        }
    }
}
