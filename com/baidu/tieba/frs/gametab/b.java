package com.baidu.tieba.frs.gametab;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class b implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FragmentTabHost bbc;
    private g csA;
    private ad csB;
    private FrsActivity csu;
    private f csv;
    private FrameLayout csw;
    private com.baidu.tieba.write.b csx;
    private Animation csy;
    private Animation csz;
    private String mForumName;
    private boolean csC = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a csD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.csC && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.csC = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener csE = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.csC && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aOW() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aOW().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener csF = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.ahT();
                } else if (b.this.bbc != null) {
                    b.this.bbc.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener csG = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.ahU();
                } else if (b.this.bbc != null) {
                    b.this.bbc.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.csu = frsActivity;
    }

    public void h(Bundle bundle) {
        this.csD.getHttpMessageListener().setPriority(-1);
        this.csD.getSocketMessageListener().setPriority(-1);
        this.csu.registerListener(this.csD);
        this.csu.registerListener(this.csE);
        if (bundle == null) {
            this.mForumName = this.csu.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        i(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void i(Bundle bundle) {
        if (this.csv == null) {
            this.csv = new f();
            this.csv.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.csu.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.csv);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (u.u(gVar.brd()) > 0) {
            this.csA = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aL(b.this.csA.brd());
                }
            });
        } else if (this.bbc != null) {
            this.csw.removeView(this.bbc);
            this.bbc = null;
            this.csB = null;
            i(null);
        }
    }

    private boolean ahO() {
        FragmentManager supportFragmentManager = this.csu.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.csv).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<FrsTabInfo> list) {
        if (this.bbc == null && ahO()) {
            aM(list);
        }
    }

    private void aM(List<FrsTabInfo> list) {
        if (!u.v(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.b.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        b.this.ahQ();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.csu.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.csu.getResources().getString(d.l.home_write);
            builder.tab_type = 0;
            int u = u.u(arrayList);
            if (u > 4) {
                arrayList = arrayList.subList(0, 4);
                arrayList.add(2, builder.build(false));
            } else if (u < 2) {
                arrayList.add(builder.build(false));
            } else {
                arrayList.add(u / 2, builder.build(false));
            }
            this.csB = new ad(this.csu.getActivity(), arrayList);
            if (aey() != null) {
                this.csB.setForumId(aey().getForumId());
                this.csB.setForumName(aey().getForumName());
                if (aey().afm() != null && aey().afm().aOW() != null) {
                    this.csB.setForumGameLabel(aey().afm().aOW().getForumGameLabel());
                }
            }
            new c(this.csv).a(this.csB);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.csB));
        }
    }

    private void ahP() {
        int ahV = ahV();
        if (ahV >= 0) {
            a(this.csv, ahV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahQ() {
        if (this.csB != null) {
            this.csB.agc();
            if (!u.v(this.csB.agd())) {
                ahP();
                if (this.bbc == null) {
                    this.bbc = new FragmentTabHost(this.csu.getActivity());
                    this.bbc.setClipChildren(false);
                    this.bbc.setClipToPadding(false);
                    this.bbc.setup(this.csu.getSupportFragmentManager());
                    this.bbc.setShouldDrawIndicatorLine(false);
                    this.bbc.setShouldDrawTopLine(true);
                    this.bbc.g(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bbc.aB(true);
                    this.bbc.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.csw = new FrameLayout(this.csu.getActivity());
                    this.csw.setClipChildren(false);
                    this.csw.setClipToPadding(false);
                    this.csw.addView(this.bbc);
                    this.csu.setContentView(this.csw);
                    this.bbc.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.9
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void f(int i, boolean z) {
                            b.this.a(b.this.bbc.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean g(int i, boolean z) {
                            FragmentTabHost.c cB = b.this.bbc.cB(i);
                            if (cB.mType != 99) {
                                TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cB)));
                                return true;
                            }
                            b.this.ahR();
                            TiebaStatic.log(new aj("c12342").r("obj_locate", b.this.b(b.this.bbc.cB(b.this.bbc.getCurrentTabIndex()))));
                            TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cB)));
                            return false;
                        }
                    });
                } else {
                    this.bbc.reset();
                }
                List<com.baidu.tbadk.mainTab.b> agd = this.csB.agd();
                List<FrsTabInfo> agb = this.csB.agb();
                if (agb.size() == agd.size()) {
                    int size = agb.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = agd.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = agb.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EP(), bVar.aS(this.csu.getActivity()), null);
                            } else {
                                a(bVar, bVar.EP(), bVar.aS(this.csu.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : agd) {
                        a(bVar2, bVar2.EP(), bVar2.aS(this.csu.getActivity()), null);
                    }
                }
                this.bbc.ut();
                this.bbc.cz(1);
                this.bbc.aA(true);
                this.bbc.setViewPagerScrollable(false);
                int ahV = ahV();
                if (ahV >= 0) {
                    this.bbc.setCurrentTab(ahV);
                } else {
                    this.bbc.setCurrentTab(0);
                }
                this.csF.setSelfListener(true);
                this.csu.registerListener(this.csF);
                this.csG.setSelfListener(true);
                this.csu.registerListener(this.csG);
                this.bbc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(FragmentTabHost.c cVar) {
        if (cVar.mType == 4) {
            return 1;
        }
        if (cVar.mType == 1) {
            return 2;
        }
        if (cVar.mType == 2) {
            return 3;
        }
        if (cVar.mType == 3) {
            return 4;
        }
        return cVar.mType == 99 ? 5 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar afl;
        if ((fragment instanceof com.baidu.tieba.frs.aj) && this.csA != null && this.csA.aOW() != null && (afl = ((com.baidu.tieba.frs.aj) fragment).afl()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.csA.aOW().getName(), 5, true, true) + this.csu.getActivity().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) u.c(this.csB.agb(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            afl.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeb = cVar.aGr;
            cVar2.mType = cVar.type;
            if (cVar.aGx == com.baidu.tbadk.mainTab.c.aGu && cVar.type == 99) {
                fragmentTabIndicator.M(9, -((int) this.csu.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                fragmentTabIndicator.setText(str);
            } else {
                fragmentTabIndicator.setText(cVar.aGs);
            }
            fragmentTabIndicator.setTextSize(0, this.csu.getResources().getDimension(d.f.ds30));
            fragmentTabIndicator.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aGt);
            fragmentTabIndicator.setContentTvTopMargin(this.csu.getResources().getDimensionPixelSize(d.f.ds2));
            fragmentTabIndicator.dr(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.aea = fragmentTabIndicator;
            cVar2.aec = bVar;
            this.bbc.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.csv instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.csv.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fG(int i) {
        if (this.csv instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.csv.fG(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.csv instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.csv.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.csv != null) {
            this.csv.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bbc == null) {
            this.csv.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bbc.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bbc == null) {
            this.csv.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bbc.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bbc == null) {
            this.csv.onChangeSkinType(i);
            return;
        }
        this.bbc.aA(true);
        this.bbc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bbc != null && this.csx != null && this.csx.isShowing()) {
                this.csx.bxw();
            } else if (this.csv != null && this.csv.isAdded()) {
                if (this.csv.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.csv.closeActivity();
            } else {
                return this.csu.a(i, keyEvent);
            }
            return false;
        }
        return this.csu.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bbc == null) {
            this.csv.onActivityResult(i, i2, intent);
        } else {
            this.bbc.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bbc == null) {
            return this.csv.getVoiceManager();
        }
        Fragment currentFragment = this.bbc.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ahR() {
        if (!ahS()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.csx == null) {
                this.csx = new com.baidu.tieba.write.b(this.csu.getPageContext(), this.csw);
                this.csx.sK("1");
            }
            this.csx.a(this.csv.afq());
            this.csx.mY(false);
        }
    }

    public boolean ahS() {
        String fixedText;
        if (this.csv == null || !this.csv.isAdded() || this.csv.getPageContext() == null) {
            return false;
        }
        i afm = this.csv.afm();
        if (afm == null) {
            return false;
        }
        if (aw.aN(this.csv.getPageContext().getPageActivity())) {
            AntiData qh = afm.qh();
            if (qh != null) {
                if (a(qh.getBlock_stat(), qh.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qh.getIfpost() == 0 && !StringUtils.isNull(qh.getForbid_info())) {
                    String forbid_info = qh.getForbid_info();
                    if (al.dT(forbid_info) > 14) {
                        forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.csv.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                    b.P(1.25f);
                    b.tp();
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.csv.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.csv.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tp();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.csv.getPageContext().getPageActivity());
        aVar.cN(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.csv.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(al.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    at.vV().c(b.this.csv.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.csv.getPageContext()).th();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahT() {
        if (this.bbc != null) {
            final FrameLayout tabWrapper = this.bbc.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.csy == null) {
                    this.csy = AnimationUtils.loadAnimation(this.csu.getActivity(), d.a.frs_pull_up_refresh_in);
                    this.csy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.2
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            tabWrapper.setVisibility(0);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            tabWrapper.clearAnimation();
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
                tabWrapper.clearAnimation();
                tabWrapper.startAnimation(this.csy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahU() {
        if (this.bbc != null) {
            final FrameLayout tabWrapper = this.bbc.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.csz == null) {
                    this.csz = AnimationUtils.loadAnimation(this.csu.getActivity(), d.a.frs_pull_up_refresh_out);
                    this.csz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            tabWrapper.setVisibility(8);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            tabWrapper.clearAnimation();
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
                tabWrapper.clearAnimation();
                tabWrapper.startAnimation(this.csz);
            }
        }
    }

    private int ahV() {
        if (this.csB == null) {
            return -1;
        }
        int u = u.u(this.csB.agb());
        for (int i = 0; i < u; i++) {
            if (this.csB.agb().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f aey() {
        return this.csv;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aez() {
        if (this.bbc == null) {
            if (this.csv instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.csv).aez();
            }
        } else {
            Fragment currentFragment = this.bbc.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aez();
            }
        }
        return null;
    }
}
