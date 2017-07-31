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
    private FragmentTabHost bcm;
    private FrsActivity ctF;
    private f ctG;
    private FrameLayout ctH;
    private com.baidu.tieba.write.b ctI;
    private Animation ctJ;
    private Animation ctK;
    private g ctL;
    private ad ctM;
    private String mForumName;
    private boolean ctN = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a ctO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.ctN && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.ctN = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener ctP = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.ctN && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aPh() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aPh().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener ctQ = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.aib();
                } else if (b.this.bcm != null) {
                    b.this.bcm.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener ctR = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.aic();
                } else if (b.this.bcm != null) {
                    b.this.bcm.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.ctF = frsActivity;
    }

    public void h(Bundle bundle) {
        this.ctO.getHttpMessageListener().setPriority(-1);
        this.ctO.getSocketMessageListener().setPriority(-1);
        this.ctF.registerListener(this.ctO);
        this.ctF.registerListener(this.ctP);
        if (bundle == null) {
            this.mForumName = this.ctF.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        i(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void i(Bundle bundle) {
        if (this.ctG == null) {
            this.ctG = new f();
            this.ctG.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.ctF.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.ctG);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (u.u(gVar.brk()) > 0) {
            this.ctL = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aL(b.this.ctL.brk());
                }
            });
        } else if (this.bcm != null) {
            this.ctH.removeView(this.bcm);
            this.bcm = null;
            this.ctM = null;
            i(null);
        }
    }

    private boolean ahW() {
        FragmentManager supportFragmentManager = this.ctF.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.ctG).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<FrsTabInfo> list) {
        if (this.bcm == null && ahW()) {
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
                        b.this.ahY();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.ctF.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.ctF.getResources().getString(d.l.home_write);
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
            this.ctM = new ad(this.ctF.getActivity(), arrayList);
            if (aeD() != null) {
                this.ctM.setForumId(aeD().getForumId());
                this.ctM.setForumName(aeD().getForumName());
                if (aeD().afr() != null && aeD().afr().aPh() != null) {
                    this.ctM.setForumGameLabel(aeD().afr().aPh().getForumGameLabel());
                }
            }
            new c(this.ctG).a(this.ctM);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.ctM));
        }
    }

    private void ahX() {
        int aid = aid();
        if (aid >= 0) {
            a(this.ctG, aid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahY() {
        if (this.ctM != null) {
            this.ctM.agj();
            if (!u.v(this.ctM.agk())) {
                ahX();
                if (this.bcm == null) {
                    this.bcm = new FragmentTabHost(this.ctF.getActivity());
                    this.bcm.setClipChildren(false);
                    this.bcm.setClipToPadding(false);
                    this.bcm.setup(this.ctF.getSupportFragmentManager());
                    this.bcm.setShouldDrawIndicatorLine(false);
                    this.bcm.setShouldDrawTopLine(true);
                    this.bcm.h(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bcm.aB(true);
                    this.bcm.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.ctH = new FrameLayout(this.ctF.getActivity());
                    this.ctH.setClipChildren(false);
                    this.ctH.setClipToPadding(false);
                    this.ctH.addView(this.bcm);
                    this.ctF.setContentView(this.ctH);
                    this.bcm.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.9
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void f(int i, boolean z) {
                            b.this.a(b.this.bcm.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean g(int i, boolean z) {
                            FragmentTabHost.c cD = b.this.bcm.cD(i);
                            if (cD.mType != 99) {
                                TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cD)));
                                return true;
                            }
                            b.this.ahZ();
                            TiebaStatic.log(new aj("c12342").r("obj_locate", b.this.b(b.this.bcm.cD(b.this.bcm.getCurrentTabIndex()))));
                            TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cD)));
                            return false;
                        }
                    });
                } else {
                    this.bcm.reset();
                }
                List<com.baidu.tbadk.mainTab.b> agk = this.ctM.agk();
                List<FrsTabInfo> agi = this.ctM.agi();
                if (agi.size() == agk.size()) {
                    int size = agi.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = agk.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = agi.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EX(), bVar.aT(this.ctF.getActivity()), null);
                            } else {
                                a(bVar, bVar.EX(), bVar.aT(this.ctF.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : agk) {
                        a(bVar2, bVar2.EX(), bVar2.aT(this.ctF.getActivity()), null);
                    }
                }
                this.bcm.uD();
                this.bcm.cB(1);
                this.bcm.aA(true);
                this.bcm.setViewPagerScrollable(false);
                int aid = aid();
                if (aid >= 0) {
                    this.bcm.setCurrentTab(aid);
                } else {
                    this.bcm.setCurrentTab(0);
                }
                this.ctQ.setSelfListener(true);
                this.ctF.registerListener(this.ctQ);
                this.ctR.setSelfListener(true);
                this.ctF.registerListener(this.ctR);
                this.bcm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        NavigationBar afq;
        if ((fragment instanceof com.baidu.tieba.frs.aj) && this.ctL != null && this.ctL.aPh() != null && (afq = ((com.baidu.tieba.frs.aj) fragment).afq()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.ctL.aPh().getName(), 5, true, true) + this.ctF.getActivity().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) u.c(this.ctM.agi(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            afq.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.afw = cVar.aHG;
            cVar2.mType = cVar.type;
            if (cVar.aHM == com.baidu.tbadk.mainTab.c.aHJ && cVar.type == 99) {
                fragmentTabIndicator.N(9, -((int) this.ctF.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                fragmentTabIndicator.setText(str);
            } else {
                fragmentTabIndicator.setText(cVar.aHH);
            }
            fragmentTabIndicator.setTextSize(0, this.ctF.getResources().getDimension(d.f.ds30));
            fragmentTabIndicator.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aHI);
            fragmentTabIndicator.setContentTvTopMargin(this.ctF.getResources().getDimensionPixelSize(d.f.ds2));
            fragmentTabIndicator.dt(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.afv = fragmentTabIndicator;
            cVar2.afx = bVar;
            this.bcm.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.ctG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.ctG.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fI(int i) {
        if (this.ctG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.ctG.fI(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.ctG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.ctG.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.ctG != null) {
            this.ctG.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bcm == null) {
            this.ctG.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bcm.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bcm == null) {
            this.ctG.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bcm.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bcm == null) {
            this.ctG.onChangeSkinType(i);
            return;
        }
        this.bcm.aA(true);
        this.bcm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bcm != null && this.ctI != null && this.ctI.isShowing()) {
                this.ctI.bxD();
            } else if (this.ctG != null && this.ctG.isAdded()) {
                if (this.ctG.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.ctG.closeActivity();
            } else {
                return this.ctF.a(i, keyEvent);
            }
            return false;
        }
        return this.ctF.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bcm == null) {
            this.ctG.onActivityResult(i, i2, intent);
        } else {
            this.bcm.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bcm == null) {
            return this.ctG.getVoiceManager();
        }
        Fragment currentFragment = this.bcm.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ahZ() {
        if (!aia()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.ctI == null) {
                this.ctI = new com.baidu.tieba.write.b(this.ctF.getPageContext(), this.ctH);
                this.ctI.sP("1");
            }
            this.ctI.a(this.ctG.afv());
            this.ctI.mY(false);
        }
    }

    public boolean aia() {
        String fixedText;
        if (this.ctG == null || !this.ctG.isAdded() || this.ctG.getPageContext() == null) {
            return false;
        }
        i afr = this.ctG.afr();
        if (afr == null) {
            return false;
        }
        if (aw.aO(this.ctG.getPageContext().getPageActivity())) {
            AntiData qr = afr.qr();
            if (qr != null) {
                if (a(qr.getBlock_stat(), qr.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qr.getIfpost() == 0 && !StringUtils.isNull(qr.getForbid_info())) {
                    String forbid_info = qr.getForbid_info();
                    if (al.dZ(forbid_info) > 14) {
                        forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.ctG.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                    b.P(1.25f);
                    b.tz();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.ctG.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.ctG.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tz();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ctG.getPageContext().getPageActivity());
        aVar.cT(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.ctG.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.10
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
                    at.wf().c(b.this.ctG.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.ctG.getPageContext()).tr();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aib() {
        if (this.bcm != null) {
            final FrameLayout tabWrapper = this.bcm.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.ctJ == null) {
                    this.ctJ = AnimationUtils.loadAnimation(this.ctF.getActivity(), d.a.frs_pull_up_refresh_in);
                    this.ctJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.2
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
                tabWrapper.startAnimation(this.ctJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aic() {
        if (this.bcm != null) {
            final FrameLayout tabWrapper = this.bcm.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.ctK == null) {
                    this.ctK = AnimationUtils.loadAnimation(this.ctF.getActivity(), d.a.frs_pull_up_refresh_out);
                    this.ctK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
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
                tabWrapper.startAnimation(this.ctK);
            }
        }
    }

    private int aid() {
        if (this.ctM == null) {
            return -1;
        }
        int u = u.u(this.ctM.agi());
        for (int i = 0; i < u; i++) {
            if (this.ctM.agi().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f aeD() {
        return this.ctG;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aeE() {
        if (this.bcm == null) {
            if (this.ctG instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.ctG).aeE();
            }
        } else {
            Fragment currentFragment = this.bcm.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aeE();
            }
        }
        return null;
    }
}
