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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.frs.profession.permission.c;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout bfK;
    private BaseFragmentActivity cYK;
    private com.baidu.tieba.ueg.c eCs;
    private FrsTabController eXN;
    private OvalActionButton eYG;
    private ab fcb;
    private FrsFragment fcc;
    private com.baidu.tieba.tbadkCore.j fcd;
    private int fcf;
    private com.baidu.tieba.write.e fcg;
    private FRSRefreshButton fch;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private FragmentTabHost mTabHost;
    private int fce = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.beb();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fcd != null && FrsTabHostFragment.this.fcd.getForum() != null) {
                        str = FrsTabHostFragment.this.fcd.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.gZ(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.uY(str);
                }
            }
        }
    };
    private c.a fcj = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.qj(1);
            } else if (z) {
                FrsTabHostFragment.this.qj(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.qj(-1);
            } else {
                FrsTabHostFragment.this.bec();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jm(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.eXN = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cYK = (BaseFragmentActivity) getActivity();
        bdX();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.cYK);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.bfK = new FrameLayout(this.cYK.getActivity());
            this.bfK.setClipChildren(false);
            this.bfK.setClipToPadding(false);
            this.bfK.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bdY());
        }
        return this.bfK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eCs = new com.baidu.tieba.ueg.c(this.cYK.getPageContext());
        this.fci = new com.baidu.tieba.frs.profession.permission.c(this.cYK.getPageContext());
        this.fci.a(this.fcj);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fcc = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.j jVar, ab abVar) {
        if (jVar != null && abVar != null) {
            this.fcd = jVar;
            this.fcb = abVar;
            this.fcb.bep();
            if (!com.baidu.tbadk.core.util.v.T(this.fcb.bca())) {
                List<com.baidu.tbadk.mainTab.b> bca = this.fcb.bca();
                List<FrsTabInfo> beo = this.fcb.beo();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.dA(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(d.C0277d.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (beo.size() == bca.size()) {
                    int size = beo.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bca.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = beo.get(i);
                            a(bVar, bVar.anH(), bVar.di(this.cYK.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bca) {
                        a(bVar2, bVar2.anH(), bVar2.di(this.cYK.getActivity()), null);
                    }
                }
                this.mTabHost.gX(2);
                this.mTabHost.setViewPagerScrollable(false);
                int qf = qf(this.fce);
                if (qf < 0) {
                    qf = qf(this.fcd.getGameDefaultTabId());
                }
                if (qf < 0) {
                    qf = bdZ();
                }
                if (qf < 0) {
                    qf = 0;
                }
                this.fce = qf;
                this.fcf = qf;
                this.eXN.qk(this.fce);
                this.eXN.qO(this.fcf);
                this.mTabHost.setCurrentTab(qf);
                int qh = qh(qf);
                if (qh != 1 && this.fcc != null) {
                    this.fcc.iX(false);
                    if (qh != 4) {
                        this.fcc.iW(false);
                        this.eYG.setVisibility(8);
                        this.fcc.bcN();
                    }
                }
                qi(qf);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bdX() {
        int bdZ;
        if (this.fcc != null && (bdZ = bdZ()) >= 0) {
            a(this.fcc, bdZ);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fcd != null && this.fcd.getForum() != null) {
            ForumData forum = this.fcd.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.bHZ = cVar.cog;
            if (bVar2.bHZ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, forum.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.bHZ.setArguments(bundle);
            } else {
                bVar2.bHZ.getArguments().putString(ImageViewerConfig.FORUM_ID, forum.getId());
                bVar2.bHZ.getArguments().putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bVar2.bHZ.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.cYK, d.e.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.bOi);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.cYK.getActivity(), d.e.tbds40));
            if (cVar.f5com == com.baidu.tbadk.mainTab.c.coi && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.cYK, d.e.ds96), com.baidu.adp.lib.util.l.h(this.cYK.getActivity(), d.e.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.bOh);
            }
            tbFragmentTabIndicator.ii(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(d.e.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(d.e.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
            tbFragmentTabIndicator.setContentDefaultTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_j));
            if (cVar.f5com != com.baidu.tbadk.mainTab.c.coi || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.bHY = tbFragmentTabIndicator;
            bVar2.bIa = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bdY() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int qh = FrsTabHostFragment.this.qh(i);
                if (qh != 1) {
                    FrsTabHostFragment.this.fcc.bcN();
                } else {
                    FrsTabHostFragment.this.fcc.bcO();
                }
                if (qh == 1) {
                    if (FrsTabHostFragment.this.fcc != null) {
                        FrsTabHostFragment.this.fcc.iW(true);
                    }
                    FrsTabHostFragment.this.eYG.setVisibility(0);
                    return;
                }
                if (qh != 4) {
                    if (FrsTabHostFragment.this.fcc != null) {
                        FrsTabHostFragment.this.fcc.iW(false);
                    }
                    FrsTabHostFragment.this.eYG.setVisibility(8);
                    FrsTabHostFragment.this.beg();
                }
                if (FrsTabHostFragment.this.fcc != null) {
                    FrsTabHostFragment.this.fcc.iX(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo qg = FrsTabHostFragment.this.qg(i);
                if (qg == null || qg.tab_type.intValue() != 11) {
                    FragmentTabHost.b gZ = FrsTabHostFragment.this.mTabHost.gZ(i);
                    if (FrsTabHostFragment.this.fcd != null && FrsTabHostFragment.this.fcd.getForum() != null) {
                        str = FrsTabHostFragment.this.fcd.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(gZ, str);
                    if (gZ.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.cY(FrsTabHostFragment.this.cYK.getPageContext().getPageActivity());
                        return false;
                    }
                    if (gZ.bHY != null) {
                        gZ.bHY.anI();
                    }
                    if (gZ.bHY.pr(String.valueOf(gZ.mType)) != null) {
                        if (!(gZ.bHY.pr(String.valueOf(gZ.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fcf == i) {
                                FrsTabHostFragment.this.b(gZ);
                            }
                        } else {
                            gZ.bHY.pr(String.valueOf(gZ.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(gZ);
                        }
                    }
                    FrsTabHostFragment.this.fcf = i;
                    return true;
                }
                ba.adA().a((TbPageContext<?>) FrsTabHostFragment.this.cYK.getPageContext(), new String[]{qg.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.cYK.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.cYK);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.cYK.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.coD = fragmentTabIndicator;
        aVar.Cc = this.cYK.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private int qf(int i) {
        if (this.fcb == null) {
            return -1;
        }
        int S = com.baidu.tbadk.core.util.v.S(this.fcb.beo());
        for (int i2 = 0; i2 < S; i2++) {
            if (this.fcb.beo().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo qg(int i) {
        if (this.fcb == null || i >= com.baidu.tbadk.core.util.v.S(this.fcb.beo())) {
            return null;
        }
        return this.fcb.beo().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qh(int i) {
        if (this.fcb != null && i < com.baidu.tbadk.core.util.v.S(this.fcb.beo())) {
            return this.fcb.beo().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aDm;
        if ((fragment instanceof ah) && this.fcd != null && this.fcd.getForum() != null && (aDm = ((ah) fragment).aDm()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fcd.getForum().getName(), 5, true, true) + this.cYK.getActivity().getString(d.j.forum));
            aDm.setCenterTextTitle(sb.toString());
        }
    }

    private int bdZ() {
        if (this.fcb == null) {
            return -1;
        }
        int S = com.baidu.tbadk.core.util.v.S(this.fcb.beo());
        for (int i = 0; i < S; i++) {
            if (this.fcb.beo().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void qi(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fcd != null && FrsTabHostFragment.this.fcd.getForum() != null) {
                        str = FrsTabHostFragment.this.fcd.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.gZ(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.b bVar) {
        if (bVar.mType == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
        } else if (bVar.mType == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
        } else if (bVar.mType == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
        } else if (bVar.mType == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
        } else if (bVar.mType == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
        } else if (bVar.mType == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
        } else if (bVar.mType == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
        } else if (bVar.mType == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
        } else if (bVar.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
        } else if (bVar.mType == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
        } else if (bVar.mType == 12) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsTalkBallTab_12"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").T("obj_locate", c(bVar)).bJ(ImageViewerConfig.FORUM_ID, str));
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.d(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
            if (bVar.mType == 1) {
                TiebaStatic.log("c12905");
            } else if (bVar.mType == 5) {
                TiebaStatic.log("c12907");
            } else if (bVar.mType == 305) {
                TiebaStatic.log("c12906");
            }
        }
    }

    public int bea() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.cYK.getResources().getColor(d.C0277d.cp_bg_line_d_1) : this.cYK.getResources().getColor(d.C0277d.cp_bg_line_d);
    }

    public void beb() {
        if (bc.cZ(this.cYK) && !this.eCs.cio() && !bee()) {
            if (this.fcc.bcq().rz(502) != null) {
                this.fci.az(this.fcc.getForumId(), this.fcc.bcq().bjs().tabId);
            } else {
                qj(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fcg == null) {
            this.fcg = new com.baidu.tieba.write.e(this.cYK.getPageContext(), this.bfK, "frs");
            this.fcg.Ek("2");
        }
        ForumWriteData bcS = this.fcc.bcS();
        bcS.setDefaultZone(i);
        this.fcg.AW(i == 1 ? d.f.btn_frs_professional_edit_n : 0);
        this.fcg.a(bcS);
        this.fcg.AV(bea());
        UtilHelper.setNavigationBarBackground(this.cYK, bea());
        this.fcg.a(false, null, this.eYG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bec() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fcc != null && this.fcc.bcP() != null && (forum = this.fcc.bcP().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str5 = themeColorInfo.day.dark_color;
                    str = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str = null;
                    str5 = null;
                    str6 = null;
                }
                if (themeColorInfo.night != null) {
                    String str8 = themeColorInfo.night.light_color;
                    str7 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str = themeColorInfo.night.pattern_image;
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    } else {
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    }
                } else {
                    str4 = str6;
                    str3 = str5;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fcc.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").T("obj_locate", c(this.mTabHost.gZ(this.mTabHost.getCurrentTabIndex()))).bJ(ImageViewerConfig.FORUM_ID, str));
        }
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
        return bVar.mType == 8 ? 10 : 1;
    }

    public FragmentTabHost bed() {
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

    public boolean bee() {
        if (this.fcc != null && this.fcc.isAdded() && this.fcc.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fcc.getPageContext(), this.fcc.bcP());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.eYG = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fch = fRSRefreshButton;
    }

    public boolean bef() {
        if (this.fcg == null) {
            return false;
        }
        return this.fcg.isShowing();
    }

    public void beg() {
        if (this.fcg != null && this.fcg.isShowing()) {
            this.fcg.qW(true);
        }
    }

    public FragmentTabHost.b gZ(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.gZ(i);
    }

    public void qk(int i) {
        this.fce = i;
    }
}
