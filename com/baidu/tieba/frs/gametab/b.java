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
    private FragmentTabHost bco;
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
                if (gVar.aPJ() != null && b.this.mForumName != null && b.this.mForumName.equals(gVar.aPJ().getName())) {
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
                    b.this.aiC();
                } else if (b.this.bco != null) {
                    b.this.bco.getTabWrapper().setVisibility(0);
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
                    b.this.aiD();
                } else if (b.this.bco != null) {
                    b.this.bco.getTabWrapper().setVisibility(8);
                }
            }
        }
    };

    public b(FrsActivity frsActivity) {
        this.cvJ = frsActivity;
    }

    public void init(Bundle bundle) {
        this.cvS.getHttpMessageListener().setPriority(-1);
        this.cvS.getSocketMessageListener().setPriority(-1);
        this.cvJ.registerListener(this.cvS);
        this.cvJ.registerListener(this.cvT);
        if (bundle == null) {
            this.mForumName = this.cvJ.getIntent().getStringExtra("name");
        } else {
            this.mForumName = bundle.getString("name");
        }
        h(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
    }

    private void h(Bundle bundle) {
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
        if (u.u(gVar.brL()) > 0) {
            this.cvP = gVar;
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aO(b.this.cvP.brL());
                }
            });
        } else if (this.bco != null) {
            this.cvL.removeView(this.bco);
            this.bco = null;
            this.cvQ = null;
            h((Bundle) null);
        }
    }

    private boolean aix() {
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
        if (this.bco == null && aix()) {
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
                        b.this.aiz();
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
            if (aeS() != null) {
                this.cvQ.setForumId(aeS().getForumId());
                this.cvQ.setForumName(aeS().getForumName());
                if (aeS().afH() != null && aeS().afH().aPJ() != null) {
                    this.cvQ.setForumGameLabel(aeS().afH().aPJ().getForumGameLabel());
                }
            }
            new c(this.cvK).a(this.cvQ);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.cvQ));
        }
    }

    private void aiy() {
        int aiE = aiE();
        if (aiE >= 0) {
            a(this.cvK, aiE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiz() {
        if (this.cvQ != null) {
            this.cvQ.agy();
            if (!u.v(this.cvQ.agz())) {
                aiy();
                if (this.bco == null) {
                    this.bco = new FragmentTabHost(this.cvJ.getActivity());
                    this.bco.setClipChildren(false);
                    this.bco.setClipToPadding(false);
                    this.bco.setup(this.cvJ.getSupportFragmentManager());
                    this.bco.setShouldDrawIndicatorLine(false);
                    this.bco.setShouldDrawTopLine(true);
                    this.bco.h(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
                    this.bco.aB(true);
                    this.bco.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.cvL = new FrameLayout(this.cvJ.getActivity());
                    this.cvL.setClipChildren(false);
                    this.cvL.setClipToPadding(false);
                    this.cvL.addView(this.bco);
                    this.cvJ.setContentView(this.cvL);
                    this.bco.setOnTabSelectionListener(new FragmentTabHost.b() { // from class: com.baidu.tieba.frs.gametab.b.9
                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public void f(int i, boolean z) {
                            b.this.a(b.this.bco.getCurrentFragment(), i);
                        }

                        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
                        public boolean g(int i, boolean z) {
                            String str = null;
                            FragmentTabHost.c cD = b.this.bco.cD(i);
                            if (b.this.cvP != null && b.this.cvP.aPJ() != null) {
                                str = b.this.cvP.aPJ().getId();
                            }
                            if (cD.mType != 99) {
                                TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cD)).aa("fid", str));
                                return true;
                            }
                            b.this.aiA();
                            TiebaStatic.log(new aj("c12342").r("obj_locate", b.this.b(b.this.bco.cD(b.this.bco.getCurrentTabIndex()))).aa("fid", str));
                            TiebaStatic.log(new aj("c12334").r("obj_locate", b.this.b(cD)).aa("fid", str));
                            return false;
                        }
                    });
                } else {
                    this.bco.reset();
                }
                List<com.baidu.tbadk.mainTab.b> agz = this.cvQ.agz();
                List<FrsTabInfo> agx = this.cvQ.agx();
                if (agx.size() == agz.size()) {
                    int size = agx.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = agz.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = agx.get(i);
                            if (frsTabInfo == null || TextUtils.isEmpty(frsTabInfo.tab_name)) {
                                a(bVar, bVar.EX(), bVar.aT(this.cvJ.getActivity()), null);
                            } else {
                                a(bVar, bVar.EX(), bVar.aT(this.cvJ.getActivity()), frsTabInfo.tab_name);
                            }
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : agz) {
                        a(bVar2, bVar2.EX(), bVar2.aT(this.cvJ.getActivity()), null);
                    }
                }
                this.bco.uE();
                this.bco.cB(1);
                this.bco.aA(true);
                this.bco.setViewPagerScrollable(false);
                int aiE = aiE();
                if (aiE >= 0) {
                    this.bco.setCurrentTab(aiE);
                } else {
                    this.bco.setCurrentTab(0);
                }
                this.cvU.setSelfListener(true);
                this.cvJ.registerListener(this.cvU);
                this.cvV.setSelfListener(true);
                this.cvJ.registerListener(this.cvV);
                this.bco.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        NavigationBar afG;
        if ((fragment instanceof com.baidu.tieba.frs.aj) && this.cvP != null && this.cvP.aPJ() != null && (afG = ((com.baidu.tieba.frs.aj) fragment).afG()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.cvP.aPJ().getName(), 5, true, true) + TbadkCoreApplication.getInst().getString(d.l.forum));
            FrsTabInfo frsTabInfo = (FrsTabInfo) u.c(this.cvQ.agx(), i);
            if (frsTabInfo != null) {
                sb.append(" · ");
                sb.append(frsTabInfo.tab_name);
            }
            afG.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.afy = cVar.aHI;
            if (cVar2.afy.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", this.cvP.aPJ().getName());
                bundle.putString("from", "game_frs");
                bundle.putString("fid", this.cvP.aPJ().getId());
                cVar2.afy.setArguments(bundle);
            } else {
                cVar2.afy.getArguments().putString("fid", this.cvP.aPJ().getId());
            }
            cVar2.mType = cVar.type;
            if (cVar.aHO == com.baidu.tbadk.mainTab.c.aHL && cVar.type == 99) {
                fragmentTabIndicator.N(9, -((int) this.cvJ.getResources().getDimension(d.f.ds12)));
            } else if (!TextUtils.isEmpty(str)) {
                fragmentTabIndicator.setText(str);
            } else {
                fragmentTabIndicator.setText(cVar.aHJ);
            }
            fragmentTabIndicator.setTextSize(0, this.cvJ.getResources().getDimension(d.f.ds30));
            fragmentTabIndicator.setTextColorResId(d.e.s_game_frs_tabbar_text_color);
            fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aHK);
            fragmentTabIndicator.setContentTvTopMargin(this.cvJ.getResources().getDimensionPixelSize(d.f.ds2));
            fragmentTabIndicator.dt(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.afx = fragmentTabIndicator;
            cVar2.afz = bVar;
            this.bco.a(cVar2);
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
        if (this.bco == null) {
            this.cvK.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.bco.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.bco == null) {
            this.cvK.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.bco.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bco == null) {
            this.cvK.onChangeSkinType(i);
            return;
        }
        this.bco.aA(true);
        this.bco.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bco != null && this.cvM != null && this.cvM.isShowing()) {
                this.cvM.byd();
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
        if (this.bco == null) {
            this.cvK.onActivityResult(i, i2, intent);
        } else {
            this.bco.getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bco == null) {
            return this.cvK.getVoiceManager();
        }
        Fragment currentFragment = this.bco.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aiA() {
        if (!aiB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
            if (this.cvM == null) {
                this.cvM = new com.baidu.tieba.write.b(this.cvJ.getPageContext(), this.cvL);
                this.cvM.sW("1");
            }
            this.cvM.a(this.cvK.afM());
            this.cvM.nb(false);
        }
    }

    public boolean aiB() {
        String fixedText;
        if (this.cvK == null || !this.cvK.isAdded() || this.cvK.getPageContext() == null) {
            return false;
        }
        i afH = this.cvK.afH();
        if (afH == null) {
            return false;
        }
        if (aw.aO(this.cvK.getPageContext().getPageActivity())) {
            AntiData qs = afH.qs();
            if (qs != null) {
                if (a(qs.getBlock_stat(), qs.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (qs.getIfpost() == 0 && !StringUtils.isNull(qs.getForbid_info())) {
                    String forbid_info = qs.getForbid_info();
                    if (al.ed(forbid_info) > 14) {
                        forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(this.cvK.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                    b.P(1.25f);
                    b.tA();
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
            b.tA();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cvK.getPageContext().getPageActivity());
        aVar.cW(al.getFixedText(string, 50, true));
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
                    at.wg().c(b.this.cvK.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cvK.getPageContext()).ts();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        if (this.bco != null) {
            final FrameLayout tabWrapper = this.bco.getTabWrapper();
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
    public void aiD() {
        if (this.bco != null) {
            final FrameLayout tabWrapper = this.bco.getTabWrapper();
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

    private int aiE() {
        if (this.cvQ == null) {
            return -1;
        }
        int u = u.u(this.cvQ.agx());
        for (int i = 0; i < u; i++) {
            if (this.cvQ.agx().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public f aeS() {
        return this.cvK;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aeT() {
        if (this.bco == null) {
            if (this.cvK instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.cvK).aeT();
            }
        } else {
            Fragment currentFragment = this.bco.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aeT();
            }
        }
        return null;
    }
}
