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
    private FragmentTabHost bcn;
    private FrsActivity cvJ;
    private f cvK;
    private FrameLayout cvL;
    private com.baidu.tieba.write.b cvM;
    private Animation cvN;
    private Animation cvO;
    private g cvP;
    private ad cvQ;
    private String mForumName;
    private boolean cvR = false;
    private Handler mHandler = new Handler();
    private com.baidu.adp.framework.listener.a cvS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g gVar = null;
            if (!b.this.cvR && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    gVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    gVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (gVar != null) {
                    b.this.cvR = true;
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cvT = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!b.this.cvR && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                if (gVar.aPO() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aPO().getName())) {
                    b.this.c(gVar);
                }
            }
        }
    };
    private CustomMessageListener cvU = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB) { // from class: com.baidu.tieba.frs.gametab.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.aiI();
                } else if (b.this.bcn != null) {
                    b.this.bcn.getTabWrapper().setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener cvV = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB) { // from class: com.baidu.tieba.frs.gametab.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.this.aiJ();
                } else if (b.this.bcn != null) {
                    b.this.bcn.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.cvJ = frsActivity;
    }

    public void h(Bundle bundle) {
        this.cvS.getHttpMessageListener().setPriority(-1);
        this.cvS.getSocketMessageListener().setPriority(-1);
        this.cvJ.registerListener(this.cvS);
        this.cvJ.registerListener(this.cvT);
        if (bundle == null) {
            this.mForumName = this.cvJ.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        i(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void i(Bundle bundle) {
        if (this.cvK == null) {
            this.cvK = new f();
            this.cvK.setArguments(bundle);
        }
        FragmentTransaction beginTransaction = this.cvJ.getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.cvK);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (u.u(gVar.brS()) > 0) {
            this.cvP = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aO(b.this.cvP.brS());
                }
            });
        } else if (this.bcn != null) {
            this.cvL.removeView(this.bcn);
            this.bcn = null;
            this.cvQ = null;
            i(null);
        }
    }

    private boolean aiD() {
        FragmentManager supportFragmentManager = this.cvJ.getSupportFragmentManager();
        try {
            supportFragmentManager.beginTransaction().remove(this.cvK).commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(List<FrsTabInfo> list) {
        if (this.bcn == null && aiD()) {
            aP(list);
        }
    }

    private void aP(List<FrsTabInfo> list) {
        if (!u.v(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.b.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        b.this.aiF();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            this.cvJ.registerListener(customMessageListener);
            List arrayList = new ArrayList(list);
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.cvJ.getResources().getString(d.l.home_write);
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
            this.cvQ = new ad(this.cvJ.getActivity(), arrayList);
            if (aeY() != null) {
                this.cvQ.setForumId(aeY().getForumId());
                this.cvQ.setForumName(aeY().getForumName());
                if (aeY().afN() != null && aeY().afN().aPO() != null) {
                    this.cvQ.setForumGameLabel(aeY().afN().aPO().getForumGameLabel());
                }
            }
            new c(this.cvK).a(this.cvQ);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cvQ));
        }
    }

    private void aiE() {
        int aiK = aiK();
        if (aiK >= 0) {
            a(this.cvK, aiK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiF() {
        if (this.cvQ != null) {
            this.cvQ.agE();
            if (!u.v(this.cvQ.agF())) {
                aiE();
                if (this.bcn == null) {
                    this.bcn = new FragmentTabHost(this.cvJ.getActivity());
                    this.bcn.setClipChildren(false);
                    this.bcn.setClipToPadding(false);
                    this.bcn.setup(this.cvJ.getSupportFragmentManager());
                    this.bcn.setShouldDrawIndicatorLine(false);
                    this.bcn.setShouldDrawTopLine(true);
                    this.bcn.h(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bcn.aB(true);
                    this.bcn.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.cvL = new FrameLayout(this.cvJ.getActivity());
                    this.cvL.setClipChildren(false);
                    this.cvL.setClipToPadding(false);
                    this.cvL.addView(this.bcn);
                    this.cvJ.setContentView(this.cvL);
                    this.bcn.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.9
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void f(int i, boolean z) {
                            b.this.a(b.this.bcn.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean g(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cD = b.this.bcn.cD(i);
                            if (b.this.cvP != null && b.this.cvP.aPO() != null) {
                                str = b.this.cvP.aPO().getId();
                            }
                            if (cD.mType != 99) {
                                TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cD)).aa("fid", str));
                                return true;
                            }
                            b.this.aiG();
                            TiebaStatic.log(new aj("c12342").r("obj_locate", b.this.b(b.this.bcn.cD(b.this.bcn.getCurrentTabIndex()))).aa("fid", str));
                            TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cD)).aa("fid", str));
                            return false;
                        }
                    });
                } else {
                    this.bcn.reset();
                }
                List<com.baidu.tbadk.mainTab.b> agF = this.cvQ.agF();
                List<FrsTabInfo> agD = this.cvQ.agD();
                if (agD.size() == agF.size()) {
                    int size = agD.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = agF.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = agD.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EX(), bVar.aT(this.cvJ.getActivity()), null);
                            } else {
                                a(bVar, bVar.EX(), bVar.aT(this.cvJ.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : agF) {
                        a(bVar2, bVar2.EX(), bVar2.aT(this.cvJ.getActivity()), null);
                    }
                }
                this.bcn.uD();
                this.bcn.cB(1);
                this.bcn.aA(true);
                this.bcn.setViewPagerScrollable(false);
                int aiK = aiK();
                if (aiK >= 0) {
                    this.bcn.setCurrentTab(aiK);
                } else {
                    this.bcn.setCurrentTab(0);
                }
                this.cvU.setSelfListener(true);
                this.cvJ.registerListener(this.cvU);
                this.cvV.setSelfListener(true);
                this.cvJ.registerListener(this.cvV);
                this.bcn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        NavigationBar afM;
        if ((fragment instanceof com.baidu.tieba.frs.aj) && this.cvP != null && this.cvP.aPO() != null && (afM = ((com.baidu.tieba.frs.aj) fragment).afM()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cvP.aPO().getName(), 5, true, true) + TbadkCoreApplication.getInst().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) u.c(this.cvQ.agD(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            afM.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.afy = cVar.aHH;
            if (cVar2.afy.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cvP.aPO().getName());
                bundle.putString("from", "game_frs");
                bundle.putString("fid", this.cvP.aPO().getId());
                cVar2.afy.setArguments(bundle);
            } else {
                cVar2.afy.getArguments().putString("fid", this.cvP.aPO().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHN == com.baidu.tbadk.mainTab.c.aHK && cVar.type == 99) {
                fragmentTabIndicator.N(9, -((int) this.cvJ.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                fragmentTabIndicator.setText(str);
            } else {
                fragmentTabIndicator.setText(cVar.aHI);
            }
            fragmentTabIndicator.setTextSize(0, this.cvJ.getResources().getDimension(d.f.ds30));
            fragmentTabIndicator.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aHJ);
            fragmentTabIndicator.setContentTvTopMargin(this.cvJ.getResources().getDimensionPixelSize(d.f.ds2));
            fragmentTabIndicator.dt(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.afx = fragmentTabIndicator;
            cVar2.afz = bVar;
            this.bcn.a(cVar2);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.cvK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cvK.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fI(int i) {
        if (this.cvK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.cvK.fI(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cvK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.cvK.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.cvK != null) {
            this.cvK.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.bcn == null) {
            this.cvK.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bcn.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bcn == null) {
            this.cvK.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bcn.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bcn == null) {
            this.cvK.onChangeSkinType(i);
            return;
        }
        this.bcn.aA(true);
        this.bcn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bcn != null && this.cvM != null && this.cvM.isShowing()) {
                this.cvM.byl();
            } else if (this.cvK != null && this.cvK.isAdded()) {
                if (this.cvK.onKeyDown(i, keyEvent)) {
                    return true;
                }
                this.cvK.closeActivity();
            } else {
                return this.cvJ.a(i, keyEvent);
            }
            return false;
        }
        return this.cvJ.a(i, keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bcn == null) {
            this.cvK.onActivityResult(i, i2, intent);
        } else {
            this.bcn.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bcn == null) {
            return this.cvK.getVoiceManager();
        }
        Fragment currentFragment = this.bcn.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aiG() {
        if (!aiH()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cvM == null) {
                this.cvM = new com.baidu.tieba.write.b(this.cvJ.getPageContext(), this.cvL);
                this.cvM.sR("1");
            }
            this.cvM.a(this.cvK.afS());
            this.cvM.nb(false);
        }
    }

    public boolean aiH() {
        String fixedText;
        if (this.cvK == null || !this.cvK.isAdded() || this.cvK.getPageContext() == null) {
            return false;
        }
        i afN = this.cvK.afN();
        if (afN == null) {
            return false;
        }
        if (aw.aO(this.cvK.getPageContext().getPageActivity())) {
            AntiData qr = afN.qr();
            if (qr != null) {
                if (a(qr.getBlock_stat(), qr.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qr.getIfpost() == 0 && !StringUtils.isNull(qr.getForbid_info())) {
                    String forbid_info = qr.getForbid_info();
                    if (al.dZ(forbid_info) > 14) {
                        forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cvK.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cvK.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cvK.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tz();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cvK.getPageContext().getPageActivity());
        aVar.cT(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cvK.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.b.10
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
                    at.wf().c(b.this.cvK.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cvK.getPageContext()).tr();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        if (this.bcn != null) {
            final FrameLayout tabWrapper = this.bcn.getTabWrapper();
            if (tabWrapper.getVisibility() != 0) {
                if (this.cvN == null) {
                    this.cvN = AnimationUtils.loadAnimation(this.cvJ.getActivity(), d.a.frs_pull_up_refresh_in);
                    this.cvN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.2
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
                tabWrapper.startAnimation(this.cvN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        if (this.bcn != null) {
            final FrameLayout tabWrapper = this.bcn.getTabWrapper();
            if (tabWrapper.getVisibility() == 0) {
                if (this.cvO == null) {
                    this.cvO = AnimationUtils.loadAnimation(this.cvJ.getActivity(), d.a.frs_pull_up_refresh_out);
                    this.cvO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.gametab.b.3
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
                tabWrapper.startAnimation(this.cvO);
            }
        }
    }

    private int aiK() {
        if (this.cvQ == null) {
            return -1;
        }
        int u = u.u(this.cvQ.agD());
        for (int i = 0; i < u; i++) {
            if (this.cvQ.agD().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f aeY() {
        return this.cvK;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aeZ() {
        if (this.bcn == null) {
            if (this.cvK instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cvK).aeZ();
            }
        } else {
            Fragment currentFragment = this.bcn.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aeZ();
            }
        }
        return null;
    }
}
