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
import com.baidu.tbadk.core.util.bd;
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
/* loaded from: classes16.dex */
public class RecommendFrsControlFragment extends BaseFragment implements g {
    private v dJb;
    private ScrollFragmentTabHost itQ;
    private c itR;
    private boolean iuc;
    private Boolean itS = null;
    private boolean itT = true;
    private boolean itU = false;
    private NoNetworkView.a fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.itQ.getCurrentTabType() != 1) {
                RecommendFrsControlFragment.this.itQ.clS();
            }
        }
    };
    private v.a itV = new v.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
        @Override // com.baidu.tbadk.BdToken.v.a
        public void aRj() {
            if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.dJb != null) {
                if (l.isNetOk()) {
                    RecommendFrsControlFragment.this.dJb.hd(true);
                    RecommendFrsControlFragment.this.dJb.aRi();
                    if (TbSingleton.getInstance().getShakeData() != null && TbSingleton.getInstance().getShakeData().bei() != null) {
                        bd.baV().b(RecommendFrsControlFragment.this.getPageContext(), new String[]{TbSingleton.getInstance().getShakeData().bei()});
                    }
                    TiebaStatic.log(new ap("c13394").dn("obj_type", "1"));
                    return;
                }
                l.showToast(RecommendFrsControlFragment.this.getContext(), R.string.neterror);
                TiebaStatic.log(new ap("c13394").dn("obj_type", "2"));
            }
        }
    };
    private CustomMessageListener itW = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_HOME_PAGE_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 2);
            if (RecommendFrsControlFragment.this.itQ != null && RecommendFrsControlFragment.this.itQ.getCurrentTabType() != 0) {
                RecommendFrsControlFragment.this.itQ.setCurrentTab(0);
            }
        }
    };
    private CustomMessageListener itX = new CustomMessageListener(2921445) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.a.d.aRN()) {
                if (RecommendFrsControlFragment.this.itQ != null && RecommendFrsControlFragment.this.itQ.getCurrentTabType() != 6) {
                    RecommendFrsControlFragment.this.itQ.setFakeClickCurrentTab(6);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.e.b.q(RecommendFrsControlFragment.this.getPageContext().getPageActivity(), 20);
        }
    };
    private CustomMessageListener itY = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewGodData newGodData;
            if (RecommendFrsControlFragment.this.dJb != null) {
                if (!RecommendFrsControlFragment.this.clH() || RecommendFrsControlFragment.this.dJb.isOpen() || !RecommendFrsControlFragment.this.isResumed() || RecommendFrsControlFragment.this.itU) {
                    if (!RecommendFrsControlFragment.this.clH() && RecommendFrsControlFragment.this.dJb.isOpen()) {
                        RecommendFrsControlFragment.this.dJb.close();
                    }
                } else {
                    RecommendFrsControlFragment.this.dJb.open();
                }
            }
            if (RecommendFrsControlFragment.this.isPrimary() && (newGodData = TbSingleton.getInstance().getNewGodData()) != null) {
                com.baidu.tbadk.util.v.bmO().b(1, newGodData);
            }
        }
    };
    private CustomMessageListener itZ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && RecommendFrsControlFragment.this.itQ != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    if (((Integer) data).intValue() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.itQ.getCurrentTabType() == 1) {
                            com.baidu.tbadk.core.bigday.b.aTD().hu(true);
                        }
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.itQ.clS();
                            return;
                        } else if (RecommendFrsControlFragment.this.itQ.getCurrentTabType() == 0) {
                            boolean clT = RecommendFrsControlFragment.this.itQ.clT();
                            TiebaStatic.log(new ap("c12350").ah("obj_type", clT ? 1 : 0));
                            if (clT) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.itQ.clS();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    com.baidu.tbadk.core.bigday.b.aTD().hu(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                }
            }
        }
    };
    private CustomMessageListener iua = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener iub = new CustomMessageListener(2921392) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    if (((Boolean) data).booleanValue()) {
                        RecommendFrsControlFragment.this.itU = true;
                        if (RecommendFrsControlFragment.this.dJb != null && RecommendFrsControlFragment.this.dJb.isOpen()) {
                            RecommendFrsControlFragment.this.dJb.close();
                            return;
                        }
                        return;
                    }
                    RecommendFrsControlFragment.this.itU = false;
                    if (RecommendFrsControlFragment.this.dJb != null && RecommendFrsControlFragment.this.isResumed() && RecommendFrsControlFragment.this.clH() && !RecommendFrsControlFragment.this.dJb.isOpen()) {
                        RecommendFrsControlFragment.this.dJb.open();
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
                    RecommendFrsControlFragment.this.iuc = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.iuc) {
                    RecommendFrsControlFragment.this.itR.oV(false);
                }
            }
        }
    };
    private b iud = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void O(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.itR.e(1, i, i2, 1, i3);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ap("c11032").ah("obj_source", 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void A(int i, int i2, int i3, int i4) {
            RecommendFrsControlFragment.this.itR.e(2, i2, i3, i, i4);
            if (j.isNetworkAvailableForImmediately()) {
                TiebaStatic.log(new ap("c11032").ah("obj_source", 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void clG() {
        }
    };
    private ConcernPageView.a iue = new ConcernPageView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.itR.GL("");
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void GK(String str) {
            RecommendFrsControlFragment.this.itR.GL(str);
        }

        @Override // com.baidu.tieba.homepage.concern.ConcernPageView.a
        public void Y(boolean z, boolean z2) {
            if (z) {
                RecommendFrsControlFragment.this.itQ.setShowConcernRedTip(false);
                if (RecommendFrsControlFragment.this.itT) {
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
                RecommendFrsControlFragment.this.itT = false;
            } else if (z2) {
                RecommendFrsControlFragment.this.itR.oV(false);
            }
        }
    };
    private CustomMessageListener iuf = new CustomMessageListener(2921455) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendFrsControlFragment.this.itQ != null && RecommendFrsControlFragment.this.itQ.getCurrentTabType() == 1) {
                RecommendFrsControlFragment.this.itQ.clS();
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
        this.itQ = (ScrollFragmentTabHost) layoutInflater.inflate(R.layout.recommend_frs_control, (ViewGroup) null);
        this.itQ.setDrawingCacheEnabled(false);
        return this.itQ;
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
        if (this.itQ != null) {
            if (isPrimary()) {
                n.aQD().ha(true);
                this.itQ.cmb();
            } else {
                n.aQD().ha(false);
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
                this.itQ.setVideoThreadId(str);
                this.itQ.setCurrentTab(this.itQ.getVideoRecommendIndex(), false);
            }
            Intent intent = getActivity().getIntent();
            if (isPrimary() && intent != null) {
                if ("com.baidu.tieba://deeplink?jump=new_hot_topic_list".equals(intent.getDataString())) {
                    this.itQ.setCurrentTab(5);
                    intent.setData(null);
                } else {
                    int intExtra2 = intent.getIntExtra("locate_type", 0);
                    String stringExtra = intent.getStringExtra("sub_tab_name");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(f.dGo)) {
                        intExtra2 = 16;
                    }
                    if (intExtra2 == 2 && !TextUtils.isEmpty(stringExtra)) {
                        this.itQ.setCurrentTab(stringExtra);
                        intent.removeExtra("locate_type");
                        intent.removeExtra("sub_tab_name");
                    } else if (intExtra2 == 16) {
                        if (this.itQ.getCurrentTabType() != 5) {
                            TiebaStatic.log(new ap("c13888"));
                        }
                        this.itQ.setCurrentTab(5);
                        intent.putExtra("locate_type", 0);
                    } else if (intExtra2 == 2) {
                        this.itQ.setCurrentTab(1);
                        intent.putExtra("locate_type", 0);
                    }
                }
            }
            if (isPrimary() && getActivity() != null && getActivity().getIntent() != null && ((intExtra = getActivity().getIntent().getIntExtra("locate_type", 0)) == 17 || intExtra == 18 || intExtra == 19)) {
                this.itQ.setCurrentTab(6);
                getActivity().getIntent().putExtra("locate_type", 0);
            }
            if (isPrimary()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            } else {
                VoiceManager fu = com.baidu.tieba.tbadkCore.voice.b.fu(getActivity());
                if (fu != null) {
                    fu.stopPlay();
                }
            }
            this.itQ.setPrimary(isPrimary());
            this.itQ.cma();
            if (isPrimary()) {
                String str3 = "";
                if (getActivity() != null && getActivity().getIntent() != null) {
                    str3 = getActivity().getIntent().getStringExtra(f.dGk);
                    getActivity().getIntent().removeExtra(f.dGk);
                }
                if (!LoginConstants.SMS_LOGIN.equals(str3)) {
                    NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                    if (newGodData != null) {
                        com.baidu.tbadk.util.v.bmO().b(1, newGodData);
                        return;
                    }
                    return;
                } else if (TbadkCoreApplication.isLogin() && getActivity() != null && getActivity().getIntent() != null) {
                    String stringExtra2 = getActivity().getIntent().getStringExtra(f.dGl);
                    if (!StringUtils.isNull(stringExtra2)) {
                        NewGodData newGodData2 = new NewGodData();
                        newGodData2.setFieldId(stringExtra2);
                        com.baidu.tbadk.util.v.bmO().a(5, newGodData2, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            com.baidu.tbadk.util.v.bmO().removeCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.itQ != null) {
            this.itQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BE();
        this.itQ.a(getPageContext(), this.fqT);
        this.itQ.a(getChildFragmentManager(), this.iud, this.iue);
        this.itQ.setScrollShadow(true);
        this.itQ.setPageUniqueId(getUniqueId());
        this.itQ.clQ();
        this.iuc = TbadkCoreApplication.isLogin();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin() && this.itQ.getCurrentTabType() != 0) {
            this.itR.oV(System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L));
        }
        a.clF().setCreateTime(System.currentTimeMillis() - a.clF().xh(1));
        this.itQ.cmc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        a.clF().o(System.currentTimeMillis(), 1);
        super.onCreate(bundle);
        registerListener(this.itZ);
        registerListener(this.mBackGroundSwitchListener);
        registerListener(this.iua);
        registerListener(this.itW);
        registerListener(this.itX);
        registerListener(this.itY);
        registerListener(this.iub);
        registerListener(this.iuf);
        this.dJb = new v(getContext(), this.itV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.itQ.onDestroy();
    }

    private void BE() {
        this.itR = new c(getPageContext(), getUniqueId());
        this.itR.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.itQ.clZ()) {
                    RecommendFrsControlFragment.this.itQ.x(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void b(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.itQ.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.itQ.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void oX(boolean z) {
                if (RecommendFrsControlFragment.this.itQ != null) {
                    RecommendFrsControlFragment.this.itQ.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.itR));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.itQ != null) {
            this.itQ.onChangeSkinType(i);
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
                            this.itQ.clS();
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
        if (this.itQ != null) {
            this.itQ.setPrimary(isPrimary());
        }
        if (this.dJb != null && this.dJb.isOpen()) {
            this.dJb.close();
        }
        com.baidu.tbadk.util.v.bmO().removeCallbacks();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.itS == null) {
            this.itS = Boolean.valueOf(k.aTv().isShowImages());
        } else {
            r0 = this.itS.booleanValue() != k.aTv().isShowImages();
            this.itS = Boolean.valueOf(k.aTv().isShowImages());
        }
        if (r0) {
            this.itQ.bxR();
        }
        if (this.itQ != null) {
            this.itQ.setPrimary(isPrimary());
            this.itQ.onResume();
        }
        if (this.dJb != null && clH() && !this.dJb.isOpen() && !this.itU) {
            this.dJb.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clH() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        z shakeData = TbSingleton.getInstance().getShakeData();
        if (shakeData == null) {
            shakeData = new z();
        }
        if (shakeData.getStartTime() == Long.MAX_VALUE || shakeData.getEndTime() == 0 || StringUtils.isNull(shakeData.bei())) {
            try {
                shakeData.parserJson(new JSONObject(com.baidu.tbadk.core.sharedPref.b.aZP().getString("shake_data", "{}")));
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
                return com.baidu.tbadk.m.e.blm().getMaxCostFromServer();
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
            this.itQ.cmd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.itQ != null) {
            return this.itQ.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void z(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("sub_locate_type", 0);
            if (this.itQ != null) {
                this.itQ.setCurrentTab(intExtra);
            }
        }
    }
}
