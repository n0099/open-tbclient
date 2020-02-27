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
    private FrameLayout csX;
    private com.baidu.tieba.ueg.d fVa;
    private FrsTabController gnl;
    private OvalActionButton gol;
    private BaseFragmentActivity grC;
    private ac grD;
    private FrsFragment grE;
    private com.baidu.tieba.tbadkCore.l grF;
    private int grH;
    private com.baidu.tieba.write.f grI;
    private FRSRefreshButton grJ;
    private com.baidu.tieba.frs.profession.permission.c grK;
    private FragmentTabHost mTabHost;
    private int grG = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bFw();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.grF != null && FrsTabHostFragment.this.grF.getForum() != null) {
                        str = FrsTabHostFragment.this.grF.getForum().getId();
                    }
                    FrsTabHostFragment.this.Bf(str);
                }
            }
        }
    };
    private c.a grL = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lw(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.sW(1);
            } else if (z) {
                FrsTabHostFragment.this.sW(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.sW(-1);
            } else {
                FrsTabHostFragment.this.bFx();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lx(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.gnl = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.grC = (BaseFragmentActivity) getActivity();
        bFs();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.grC);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.csX = new FrameLayout(this.grC.getActivity());
            this.csX.setClipChildren(false);
            this.csX.setClipToPadding(false);
            this.csX.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bFt());
        }
        return this.csX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fVa = new com.baidu.tieba.ueg.d(this.grC.getPageContext());
        this.grK = new com.baidu.tieba.frs.profession.permission.c(this.grC.getPageContext());
        this.grK.a(this.grL);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.grE = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ac acVar) {
        if (lVar != null && acVar != null && this.mTabHost != null) {
            this.grF = lVar;
            this.grD = acVar;
            this.grD.bFI();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.grD.bDt())) {
                List<com.baidu.tbadk.mainTab.b> bDt = this.grD.bDt();
                List<FrsTabInfo> bDs = this.grD.bDs();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bDs.size() == bDt.size()) {
                    int size = bDs.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bDt.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bDs.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.grC.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bDt) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.grC.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int sS = sS(this.grG);
                if (sS < 0) {
                    sS = sS(this.grF.getGameDefaultTabId());
                }
                if (sS < 0) {
                    sS = bFu();
                }
                if (sS < 0) {
                    sS = 0;
                }
                this.grG = sS;
                this.grH = sS;
                this.gnl.sX(this.grG);
                this.gnl.tD(this.grH);
                this.mTabHost.setCurrentTab(sS);
                int sU = sU(sS);
                if (sU != 1) {
                    if (this.grE != null) {
                        this.grE.lj(false);
                        if (sU != 4 && sU != 25) {
                            this.grE.li(false);
                            this.gol.setVisibility(8);
                            this.grE.bEl();
                        }
                    }
                    if (this.grF.getForum() != null) {
                        com.baidu.tieba.frs.e.e BL = com.baidu.tieba.frs.e.d.bJT().BL(this.grF.getForum().getName());
                        if (sU == 25) {
                            if (BL == null) {
                                BL = new com.baidu.tieba.frs.e.e(null);
                            }
                            BL.md(true);
                            com.baidu.tieba.frs.e.d.bJT().a(this.grF.getForum().getName(), BL);
                        } else if (BL != null && BL.bJW()) {
                            BL.md(false);
                            com.baidu.tieba.frs.e.d.bJT().a(this.grF.getForum().getName(), BL);
                        }
                    }
                }
                sV(sS);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bFs() {
        int bFu;
        if (this.grE != null && (bFu = bFu()) >= 0) {
            a(this.grE, bFu);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.grF != null && this.grF.getForum() != null) {
            ForumData forum = this.grF.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.grC, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.grC.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.grC, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.grC.getActivity(), R.dimen.tbds12));
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
            bVar2.cYg = tbFragmentTabIndicator;
            bVar2.cYh = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bFt() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int sU = FrsTabHostFragment.this.sU(i);
                if (sU != 1) {
                    FrsTabHostFragment.this.grE.bEl();
                } else {
                    FrsTabHostFragment.this.grE.bEm();
                }
                if (sU == 1) {
                    if (FrsTabHostFragment.this.grE != null) {
                        FrsTabHostFragment.this.grE.li(true);
                    }
                    FrsTabHostFragment.this.gol.setVisibility(0);
                    return;
                }
                if (sU == 4 || sU == 25) {
                    if (FrsTabHostFragment.this.gol.getVisibility() == 8) {
                        FrsTabHostFragment.this.gol.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.grE != null) {
                        FrsTabHostFragment.this.grE.li(false);
                    }
                    FrsTabHostFragment.this.gol.setVisibility(8);
                    FrsTabHostFragment.this.bFA();
                }
                if (FrsTabHostFragment.this.grE != null) {
                    FrsTabHostFragment.this.grE.lj(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo sT = FrsTabHostFragment.this.sT(i);
                if (sT == null || sT.tab_type.intValue() != 11) {
                    FragmentTabHost.b ko = FrsTabHostFragment.this.mTabHost.ko(i);
                    if (FrsTabHostFragment.this.grF != null && FrsTabHostFragment.this.grF.getForum() != null) {
                        str = FrsTabHostFragment.this.grF.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(ko, str);
                    if (ko.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.grC.getPageContext().getPageActivity());
                        return false;
                    }
                    if (ko.cYg != null) {
                        ko.cYg.aPT();
                    }
                    if (ko.cYg.vz(String.valueOf(ko.mType)) != null) {
                        if (!(ko.cYg.vz(String.valueOf(ko.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.grH == i) {
                                FrsTabHostFragment.this.b(ko);
                            }
                        } else {
                            ko.cYg.vz(String.valueOf(ko.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(ko);
                        }
                    }
                    FrsTabHostFragment.this.grH = i;
                    return true;
                }
                ba.aGE().a((TbPageContext<?>) FrsTabHostFragment.this.grC.getPageContext(), new String[]{sT.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.grC.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.grC);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.grC.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.dBB = fragmentTabIndicator;
        aVar.offsetX = this.grC.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.grI != null) {
            this.grI.onChangeSkinType(i);
        }
    }

    private int sS(int i) {
        if (this.grD == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.grD.bDs());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.grD.bDs().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo sT(int i) {
        if (this.grD == null || i >= com.baidu.tbadk.core.util.v.getCount(this.grD.bDs())) {
            return null;
        }
        return this.grD.bDs().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sU(int i) {
        if (this.grD != null && i < com.baidu.tbadk.core.util.v.getCount(this.grD.bDs())) {
            return this.grD.bDs().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar beJ;
        if ((fragment instanceof ai) && this.grF != null && this.grF.getForum() != null && (beJ = ((ai) fragment).beJ()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.grF.getForum().getName(), 5, true, true) + this.grC.getActivity().getString(R.string.forum));
            beJ.setCenterTextTitle(sb.toString());
        }
    }

    private int bFu() {
        if (this.grD == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.grD.bDs());
        for (int i = 0; i < count; i++) {
            if (this.grD.bDs().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void sV(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.grF != null && FrsTabHostFragment.this.grF.getForum() != null) {
                        str = FrsTabHostFragment.this.grF.getForum().getId();
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").X("obj_locate", c(bVar)).cy("fid", str));
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

    public int bFv() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.grC.getResources().getColor(R.color.cp_bg_line_d_1) : this.grC.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bFw() {
        if (bc.checkUpIsLogin(this.grC) && !this.fVa.cOF() && !bFz()) {
            if (this.grE.bDL().ur(502) != null) {
                this.grK.aB(this.grE.getForumId(), this.grE.bDL().bKW().tabId);
            } else {
                sW(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.grI == null) {
            this.grI = new com.baidu.tieba.write.f(this.grC.getPageContext(), this.csX, "frs");
            this.grI.KM("2");
        }
        ForumWriteData bEr = this.grE.bEr();
        bEr.setDefaultZone(i);
        this.grI.Ed(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.grI.a(bEr);
        this.grI.Ec(bFv());
        UtilHelper.setNavigationBarBackground(this.grC, bFv());
        this.grI.a(false, (View) null, (View) this.gol);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFx() {
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
        if (this.grE != null && this.grE.bEn() != null && (forum = this.grE.bEn().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.grE.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").X("obj_locate", c(this.mTabHost.ko(this.mTabHost.getCurrentTabIndex()))).cy("fid", str));
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

    public FragmentTabHost bFy() {
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

    public boolean bFz() {
        if (this.grE != null && this.grE.isAdded() && this.grE.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.grE.getPageContext(), this.grE.bEn());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gol = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.grJ = fRSRefreshButton;
    }

    public boolean bFn() {
        if (this.grI == null) {
            return false;
        }
        return this.grI.isShowing();
    }

    public void bFA() {
        if (this.grI != null && this.grI.isShowing()) {
            this.grI.tI(true);
        }
    }

    public FragmentTabHost.b ko(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.ko(i);
    }

    public void sX(int i) {
        this.grG = i;
    }
}
