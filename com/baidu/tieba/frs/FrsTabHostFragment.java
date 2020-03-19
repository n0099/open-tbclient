package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.frs.profession.permission.c;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ctk;
    private com.baidu.tieba.ueg.d eqc;
    private FrsTabController gok;
    private OvalActionButton gpk;
    private BaseFragmentActivity gsB;
    private ad gsC;
    private FrsFragment gsD;
    private com.baidu.tieba.tbadkCore.m gsE;
    private int gsG;
    private com.baidu.tieba.write.f gsH;
    private FRSRefreshButton gsI;
    private com.baidu.tieba.frs.profession.permission.c gsJ;
    private FragmentTabHost mTabHost;
    private int gsF = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bFJ();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.gsE != null && FrsTabHostFragment.this.gsE.getForum() != null) {
                        str = FrsTabHostFragment.this.gsE.getForum().getId();
                    }
                    FrsTabHostFragment.this.Bi(str);
                }
            }
        }
    };
    private c.a gsK = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.sY(1);
            } else if (z) {
                FrsTabHostFragment.this.sY(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.sY(-1);
            } else {
                FrsTabHostFragment.this.bFK();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lD(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.gok = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gsB = (BaseFragmentActivity) getActivity();
        bFF();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gsB);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ctk = new FrameLayout(this.gsB.getActivity());
            this.ctk.setClipChildren(false);
            this.ctk.setClipToPadding(false);
            this.ctk.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bFG());
        }
        return this.ctk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eqc = new com.baidu.tieba.ueg.d(this.gsB.getPageContext());
        this.gsJ = new com.baidu.tieba.frs.profession.permission.c(this.gsB.getPageContext());
        this.gsJ.a(this.gsK);
        super.onActivityCreated(bundle);
    }

    public void M(FrsFragment frsFragment) {
        this.gsD = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ad adVar) {
        if (mVar != null && adVar != null && this.mTabHost != null) {
            this.gsE = mVar;
            this.gsC = adVar;
            this.gsC.bFV();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.gsC.bDE())) {
                List<com.baidu.tbadk.mainTab.b> bDE = this.gsC.bDE();
                List<FrsTabInfo> bDD = this.gsC.bDD();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bDD.size() == bDE.size()) {
                    int size = bDD.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bDE.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bDD.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.gsB.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bDE) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.gsB.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int sU = sU(this.gsF);
                if (sU < 0) {
                    sU = sU(this.gsE.getGameDefaultTabId());
                }
                if (sU < 0) {
                    sU = bFH();
                }
                if (sU < 0) {
                    sU = 0;
                }
                this.gsF = sU;
                this.gsG = sU;
                this.gok.sZ(this.gsF);
                this.gok.tJ(this.gsG);
                this.mTabHost.setCurrentTab(sU);
                int sW = sW(sU);
                if (sW != 1) {
                    if (this.gsD != null) {
                        this.gsD.lp(false);
                        if (sW != 4 && sW != 25) {
                            this.gsD.lo(false);
                            this.gpk.setVisibility(8);
                            this.gsD.bEx();
                        }
                    }
                    if (this.gsE.getForum() != null) {
                        com.baidu.tieba.frs.e.e BM = com.baidu.tieba.frs.e.d.bKj().BM(this.gsE.getForum().getName());
                        if (sW == 25) {
                            if (BM == null) {
                                BM = new com.baidu.tieba.frs.e.e(null);
                            }
                            BM.mj(true);
                            com.baidu.tieba.frs.e.d.bKj().a(this.gsE.getForum().getName(), BM);
                        } else if (BM != null && BM.bKm()) {
                            BM.mj(false);
                            com.baidu.tieba.frs.e.d.bKj().a(this.gsE.getForum().getName(), BM);
                        }
                    }
                }
                sX(sU);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bFF() {
        int bFH;
        if (this.gsD != null && (bFH = bFH()) >= 0) {
            a(this.gsD, bFH);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.gsE != null && this.gsE.getForum() != null) {
            ForumData forum = this.gsE.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.mContentFragment = cVar.frag;
            if (bVar2.mContentFragment.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString("fname", forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.mContentFragment.setArguments(bundle);
            } else {
                bVar2.mContentFragment.getArguments().putString("fid", forum.getId());
                bVar2.mContentFragment.getArguments().putString("fname", forum.getName());
                bVar2.mContentFragment.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gsB, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gsB.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gsB, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gsB.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.aq.getChineseAndEnglishLength(str) > 8) {
                    str = com.baidu.tbadk.core.util.aq.subString(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.textResId);
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.showIconType != com.baidu.tbadk.mainTab.c.SHOWICON || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.cYv = tbFragmentTabIndicator;
            bVar2.cYw = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bFG() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int sW = FrsTabHostFragment.this.sW(i);
                if (sW != 1) {
                    FrsTabHostFragment.this.gsD.bEx();
                } else {
                    FrsTabHostFragment.this.gsD.bEy();
                }
                if (sW == 1) {
                    if (FrsTabHostFragment.this.gsD != null) {
                        FrsTabHostFragment.this.gsD.lo(true);
                    }
                    FrsTabHostFragment.this.gpk.setVisibility(0);
                    return;
                }
                if (sW == 4 || sW == 25) {
                    if (FrsTabHostFragment.this.gpk.getVisibility() == 8) {
                        FrsTabHostFragment.this.gpk.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.gsD != null) {
                        FrsTabHostFragment.this.gsD.lo(false);
                    }
                    FrsTabHostFragment.this.gpk.setVisibility(8);
                    FrsTabHostFragment.this.bFN();
                }
                if (FrsTabHostFragment.this.gsD != null) {
                    FrsTabHostFragment.this.gsD.lp(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo sV = FrsTabHostFragment.this.sV(i);
                if (sV == null || sV.tab_type.intValue() != 11) {
                    FragmentTabHost.b ko = FrsTabHostFragment.this.mTabHost.ko(i);
                    if (FrsTabHostFragment.this.gsE != null && FrsTabHostFragment.this.gsE.getForum() != null) {
                        str = FrsTabHostFragment.this.gsE.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(ko, str);
                    if (ko.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gsB.getPageContext().getPageActivity());
                        return false;
                    }
                    if (ko.cYv != null) {
                        ko.cYv.aQa();
                    }
                    if (ko.cYv.vA(String.valueOf(ko.mType)) != null) {
                        if (!(ko.cYv.vA(String.valueOf(ko.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.gsG == i) {
                                FrsTabHostFragment.this.b(ko);
                            }
                        } else {
                            ko.cYv.vA(String.valueOf(ko.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(ko);
                        }
                    }
                    FrsTabHostFragment.this.gsG = i;
                    return true;
                }
                ba.aGK().a((TbPageContext<?>) FrsTabHostFragment.this.gsB.getPageContext(), new String[]{sV.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gsB.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gsB);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gsB.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.dCc = fragmentTabIndicator;
        aVar.offsetX = this.gsB.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gsH != null) {
            this.gsH.onChangeSkinType(i);
        }
    }

    private int sU(int i) {
        if (this.gsC == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.gsC.bDD());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.gsC.bDD().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo sV(int i) {
        if (this.gsC == null || i >= com.baidu.tbadk.core.util.v.getCount(this.gsC.bDD())) {
            return null;
        }
        return this.gsC.bDD().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sW(int i) {
        if (this.gsC != null && i < com.baidu.tbadk.core.util.v.getCount(this.gsC.bDD())) {
            return this.gsC.bDD().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar beR;
        if ((fragment instanceof aj) && this.gsE != null && this.gsE.getForum() != null && (beR = ((aj) fragment).beR()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.gsE.getForum().getName(), 5, true, true) + this.gsB.getActivity().getString(R.string.forum));
            beR.setCenterTextTitle(sb.toString());
        }
    }

    private int bFH() {
        if (this.gsC == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.gsC.bDD());
        for (int i = 0; i < count; i++) {
            if (this.gsC.bDD().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void sX(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.gsE != null && FrsTabHostFragment.this.gsE.getForum() != null) {
                        str = FrsTabHostFragment.this.gsE.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.ko(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.b bVar) {
        if (bVar.mType == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_2"));
        } else if (bVar.mType == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGoodsTab_3"));
        } else if (bVar.mType == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsInfoTab_101"));
        } else if (bVar.mType == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsRankList_305"));
        } else if (bVar.mType == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsLiveLive_4"));
        } else if (bVar.mType == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_1"));
        } else if (bVar.mType == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsLivePersonal_5"));
        } else if (bVar.mType == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_8"));
        } else if (bVar.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_9"));
        } else if (bVar.mType == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameRecommend_11"));
        } else if (bVar.mType == 12) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsTalkBallTab_12"));
        } else if (bVar.mType == 25) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsSportsRecommendTab_25"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").X("obj_locate", c(bVar)).cx("fid", str));
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
            if (bVar.mType == 1) {
                TiebaStatic.log("c12905");
            } else if (bVar.mType == 5) {
                TiebaStatic.log("c12907");
            } else if (bVar.mType == 305) {
                TiebaStatic.log("c12906");
            }
        }
    }

    public int bFI() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gsB.getResources().getColor(R.color.cp_bg_line_d_1) : this.gsB.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bFJ() {
        if (bc.checkUpIsLogin(this.gsB) && !this.eqc.cPc() && !bFM()) {
            if (this.gsD.bDW().uy(502) != null) {
                this.gsJ.aB(this.gsD.getForumId(), this.gsD.bDW().bLn().tabId);
            } else {
                sY(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sY(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.gsH == null) {
            this.gsH = new com.baidu.tieba.write.f(this.gsB.getPageContext(), this.ctk, "frs");
            this.gsH.KN("2");
        }
        ForumWriteData bED = this.gsD.bED();
        bED.setDefaultZone(i);
        this.gsH.El(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.gsH.a(bED);
        this.gsH.Ek(bFI());
        UtilHelper.setNavigationBarBackground(this.gsB, bFI());
        this.gsH.a(false, (View) null, (View) this.gpk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFK() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11 = null;
        if (this.gsD != null && this.gsD.bEz() != null && (forum = this.gsD.bEz().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str7 = themeColorInfo.day.dark_color;
                    str8 = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str7 = null;
                    str6 = null;
                    str8 = null;
                }
                if (themeColorInfo.night != null) {
                    String str12 = themeColorInfo.night.light_color;
                    String str13 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str4 = str12;
                        str9 = themeColorInfo.night.pattern_image;
                        str10 = str13;
                    } else {
                        str4 = str12;
                        str9 = str8;
                        str10 = str13;
                    }
                } else {
                    str4 = null;
                    str9 = str8;
                    str10 = null;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str14 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str14;
                        str11 = themeColorInfo.dark.pattern_image;
                        str3 = str10;
                        str5 = str7;
                    } else {
                        str = str14;
                        str11 = str9;
                        str3 = str10;
                        str5 = str7;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str11 = str9;
                    str3 = str10;
                    str5 = str7;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.gsD.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").X("obj_locate", c(this.mTabHost.ko(this.mTabHost.getCurrentTabIndex()))).cx("fid", str));
        }
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13604");
        if (getPageContext() != null) {
            com.baidu.tbadk.pageInfo.c.a(getPageContext().getPageActivity(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    private int c(FragmentTabHost.b bVar) {
        if (bVar.mType == 101) {
            return 1;
        }
        if (bVar.mType == 1) {
            return 2;
        }
        if (bVar.mType == 2) {
            return 3;
        }
        if (bVar.mType == 3) {
            return 4;
        }
        if (bVar.mType == 99) {
            return 5;
        }
        if (bVar.mType == 4) {
            return 6;
        }
        if (bVar.mType == 305) {
            return 7;
        }
        if (bVar.mType == 5) {
            return 8;
        }
        if (bVar.mType == 11) {
            return 11;
        }
        if (bVar.mType == 9) {
            return 9;
        }
        if (bVar.mType == 8) {
            return 10;
        }
        if (bVar.mType == 25) {
            return 12;
        }
        if (bVar.mType == 105) {
            return 13;
        }
        return bVar.mType == 106 ? 14 : 1;
    }

    public FragmentTabHost bFL() {
        return this.mTabHost;
    }

    public Fragment getCurrentFragment() {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.getCurrentFragment();
    }

    public int getCurrentTabType() {
        if (this.mTabHost == null) {
            return -1;
        }
        return this.mTabHost.getCurrentTabType();
    }

    public void setCurrentTab(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.setCurrentTab(i);
        }
    }

    public boolean bFM() {
        if (this.gsD != null && this.gsD.isAdded() && this.gsD.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.gsD.getPageContext(), this.gsD.bEz());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gpk = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.gsI = fRSRefreshButton;
    }

    public boolean bFA() {
        if (this.gsH == null) {
            return false;
        }
        return this.gsH.isShowing();
    }

    public void bFN() {
        if (this.gsH != null && this.gsH.isShowing()) {
            this.gsH.tP(true);
        }
    }

    public FragmentTabHost.b ko(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.ko(i);
    }

    public void sZ(int i) {
        this.gsF = i;
    }
}
