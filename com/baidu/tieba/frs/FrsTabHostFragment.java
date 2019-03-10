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
    private FrameLayout bfF;
    private BaseFragmentActivity cYK;
    private com.baidu.tieba.ueg.c eCK;
    private OvalActionButton eYU;
    private FrsTabController eYb;
    private ab fcp;
    private FrsFragment fcq;
    private com.baidu.tieba.tbadkCore.j fcr;
    private int fct;
    private com.baidu.tieba.write.e fcu;
    private FRSRefreshButton fcv;
    private com.baidu.tieba.frs.profession.permission.c fcw;
    private FragmentTabHost mTabHost;
    private int fcs = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bee();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fcr != null && FrsTabHostFragment.this.fcr.getForum() != null) {
                        str = FrsTabHostFragment.this.fcr.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.ha(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.vb(str);
                }
            }
        }
    };
    private c.a fcx = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.qn(1);
            } else if (z) {
                FrsTabHostFragment.this.qn(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.qn(-1);
            } else {
                FrsTabHostFragment.this.bef();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jm(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.eYb = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cYK = (BaseFragmentActivity) getActivity();
        bea();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.cYK);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.bfF = new FrameLayout(this.cYK.getActivity());
            this.bfF.setClipChildren(false);
            this.bfF.setClipToPadding(false);
            this.bfF.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(beb());
        }
        return this.bfF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eCK = new com.baidu.tieba.ueg.c(this.cYK.getPageContext());
        this.fcw = new com.baidu.tieba.frs.profession.permission.c(this.cYK.getPageContext());
        this.fcw.a(this.fcx);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fcq = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.j jVar, ab abVar) {
        if (jVar != null && abVar != null) {
            this.fcr = jVar;
            this.fcp = abVar;
            this.fcp.bes();
            if (!com.baidu.tbadk.core.util.v.T(this.fcp.bcd())) {
                List<com.baidu.tbadk.mainTab.b> bcd = this.fcp.bcd();
                List<FrsTabInfo> ber = this.fcp.ber();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.dA(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(d.C0236d.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (ber.size() == bcd.size()) {
                    int size = ber.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bcd.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = ber.get(i);
                            a(bVar, bVar.anL(), bVar.di(this.cYK.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bcd) {
                        a(bVar2, bVar2.anL(), bVar2.di(this.cYK.getActivity()), null);
                    }
                }
                this.mTabHost.gY(2);
                this.mTabHost.setViewPagerScrollable(false);
                int qj = qj(this.fcs);
                if (qj < 0) {
                    qj = qj(this.fcr.getGameDefaultTabId());
                }
                if (qj < 0) {
                    qj = bec();
                }
                if (qj < 0) {
                    qj = 0;
                }
                this.fcs = qj;
                this.fct = qj;
                this.eYb.qo(this.fcs);
                this.eYb.qS(this.fct);
                this.mTabHost.setCurrentTab(qj);
                int ql = ql(qj);
                if (ql != 1 && ql != 4 && this.fcq != null) {
                    this.fcq.iX(false);
                    this.fcq.iW(false);
                    this.eYU.setVisibility(8);
                    this.fcq.bcQ();
                }
                qm(qj);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bea() {
        int bec;
        if (this.fcq != null && (bec = bec()) >= 0) {
            a(this.fcq, bec);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fcr != null && this.fcr.getForum() != null) {
            ForumData forum = this.fcr.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.bHV = cVar.cod;
            if (bVar2.bHV.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, forum.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.bHV.setArguments(bundle);
            } else {
                bVar2.bHV.getArguments().putString(ImageViewerConfig.FORUM_ID, forum.getId());
                bVar2.bHV.getArguments().putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bVar2.bHV.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.cYK, d.e.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.bOe);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.cYK.getActivity(), d.e.tbds40));
            if (cVar.coj == com.baidu.tbadk.mainTab.c.cof && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.cYK, d.e.ds96), com.baidu.adp.lib.util.l.h(this.cYK.getActivity(), d.e.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.bOd);
            }
            tbFragmentTabIndicator.ij(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(d.e.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(d.e.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_b));
            tbFragmentTabIndicator.setContentDefaultTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_j));
            if (cVar.coj != com.baidu.tbadk.mainTab.c.cof || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.bHU = tbFragmentTabIndicator;
            bVar2.bHW = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a beb() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int ql = FrsTabHostFragment.this.ql(i);
                if (ql != 1) {
                    FrsTabHostFragment.this.fcq.bcQ();
                } else {
                    FrsTabHostFragment.this.fcq.bcR();
                }
                if (ql == 1 || ql == 4) {
                    if (FrsTabHostFragment.this.fcq != null) {
                        FrsTabHostFragment.this.fcq.iW(true);
                    }
                    FrsTabHostFragment.this.eYU.setVisibility(0);
                    return;
                }
                if (FrsTabHostFragment.this.fcq != null) {
                    FrsTabHostFragment.this.fcq.iX(false);
                    FrsTabHostFragment.this.fcq.iW(false);
                }
                FrsTabHostFragment.this.eYU.setVisibility(8);
                FrsTabHostFragment.this.bej();
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo qk = FrsTabHostFragment.this.qk(i);
                if (qk == null || qk.tab_type.intValue() != 11) {
                    FragmentTabHost.b ha = FrsTabHostFragment.this.mTabHost.ha(i);
                    if (FrsTabHostFragment.this.fcr != null && FrsTabHostFragment.this.fcr.getForum() != null) {
                        str = FrsTabHostFragment.this.fcr.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(ha, str);
                    if (ha.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.cY(FrsTabHostFragment.this.cYK.getPageContext().getPageActivity());
                        return false;
                    }
                    if (ha.bHU != null) {
                        ha.bHU.anM();
                    }
                    if (ha.bHU.pq(String.valueOf(ha.mType)) != null) {
                        if (!(ha.bHU.pq(String.valueOf(ha.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fct == i) {
                                FrsTabHostFragment.this.b(ha);
                            }
                        } else {
                            ha.bHU.pq(String.valueOf(ha.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(ha);
                        }
                    }
                    FrsTabHostFragment.this.fct = i;
                    return true;
                }
                ba.adD().a((TbPageContext<?>) FrsTabHostFragment.this.cYK.getPageContext(), new String[]{qk.tab_url}, true);
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
        aVar.coA = fragmentTabIndicator;
        aVar.Cd = this.cYK.getResources().getDimensionPixelSize(d.e.ds12);
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

    private int qj(int i) {
        if (this.fcp == null) {
            return -1;
        }
        int S = com.baidu.tbadk.core.util.v.S(this.fcp.ber());
        for (int i2 = 0; i2 < S; i2++) {
            if (this.fcp.ber().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo qk(int i) {
        if (this.fcp == null || i >= com.baidu.tbadk.core.util.v.S(this.fcp.ber())) {
            return null;
        }
        return this.fcp.ber().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ql(int i) {
        if (this.fcp != null && i < com.baidu.tbadk.core.util.v.S(this.fcp.ber())) {
            return this.fcp.ber().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aDq;
        if ((fragment instanceof ah) && this.fcr != null && this.fcr.getForum() != null && (aDq = ((ah) fragment).aDq()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fcr.getForum().getName(), 5, true, true) + this.cYK.getActivity().getString(d.j.forum));
            aDq.setCenterTextTitle(sb.toString());
        }
    }

    private int bec() {
        if (this.fcp == null) {
            return -1;
        }
        int S = com.baidu.tbadk.core.util.v.S(this.fcp.ber());
        for (int i = 0; i < S; i++) {
            if (this.fcp.ber().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void qm(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fcr != null && FrsTabHostFragment.this.fcr.getForum() != null) {
                        str = FrsTabHostFragment.this.fcr.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.ha(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").T("obj_locate", c(bVar)).bJ(ImageViewerConfig.FORUM_ID, str));
    }

    public int bed() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.cYK.getResources().getColor(d.C0236d.cp_bg_line_d_1) : this.cYK.getResources().getColor(d.C0236d.cp_bg_line_d);
    }

    public void bee() {
        if (bc.cZ(this.cYK) && !this.eCK.cin() && !beh()) {
            if (this.fcq.bct().rD(502) != null) {
                this.fcw.az(this.fcq.getForumId(), this.fcq.bct().bjv().tabId);
            } else {
                qn(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fcu == null) {
            this.fcu = new com.baidu.tieba.write.e(this.cYK.getPageContext(), this.bfF, "frs");
            this.fcu.En("2");
        }
        ForumWriteData bcV = this.fcq.bcV();
        bcV.setDefaultZone(i);
        this.fcu.Ba(i == 1 ? d.f.btn_frs_professional_edit_n : 0);
        this.fcu.a(bcV);
        this.fcu.AZ(bed());
        UtilHelper.setNavigationBarBackground(this.cYK, bed());
        this.fcu.a(false, null, this.eYU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bef() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fcq != null && this.fcq.bcS() != null && (forum = this.fcq.bcS().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fcq.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").T("obj_locate", c(this.mTabHost.ha(this.mTabHost.getCurrentTabIndex()))).bJ(ImageViewerConfig.FORUM_ID, str));
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

    public FragmentTabHost beg() {
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

    public boolean beh() {
        if (this.fcq != null && this.fcq.isAdded() && this.fcq.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fcq.getPageContext(), this.fcq.bcS());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.eYU = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fcv = fRSRefreshButton;
    }

    public boolean bei() {
        if (this.fcu == null) {
            return false;
        }
        return this.fcu.isShowing();
    }

    public void bej() {
        if (this.fcu != null && this.fcu.isShowing()) {
            this.fcu.qW(true);
        }
    }

    public FragmentTabHost.b ha(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.ha(i);
    }

    public void qo(int i) {
        this.fcs = i;
    }
}
