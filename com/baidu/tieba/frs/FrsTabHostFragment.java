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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout blL;
    private BaseFragmentActivity dla;
    private com.baidu.tieba.ueg.d eXh;
    private FrsTabController fsU;
    private OvalActionButton ftQ;
    private ab fxm;
    private FrsFragment fxn;
    private com.baidu.tieba.tbadkCore.j fxo;
    private int fxq;
    private com.baidu.tieba.write.e fxr;
    private FRSRefreshButton fxs;
    private com.baidu.tieba.frs.profession.permission.c fxt;
    private FragmentTabHost mTabHost;
    private int fxp = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bnx();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fxo != null && FrsTabHostFragment.this.fxo.getForum() != null) {
                        str = FrsTabHostFragment.this.fxo.getForum().getId();
                    }
                    FrsTabHostFragment.this.wW(str);
                }
            }
        }
    };
    private c.a fxu = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kf(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.rI(1);
            } else if (z) {
                FrsTabHostFragment.this.rI(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.rI(-1);
            } else {
                FrsTabHostFragment.this.bny();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kg(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.fsU = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dla = (BaseFragmentActivity) getActivity();
        bnt();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.dla);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.blL = new FrameLayout(this.dla.getActivity());
            this.blL.setClipChildren(false);
            this.blL.setClipToPadding(false);
            this.blL.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bnu());
        }
        return this.blL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eXh = new com.baidu.tieba.ueg.d(this.dla.getPageContext());
        this.fxt = new com.baidu.tieba.frs.profession.permission.c(this.dla.getPageContext());
        this.fxt.a(this.fxu);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fxn = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.j jVar, ab abVar) {
        if (jVar != null && abVar != null && this.mTabHost != null) {
            this.fxo = jVar;
            this.fxm = abVar;
            this.fxm.bnL();
            if (!com.baidu.tbadk.core.util.v.aa(this.fxm.bly())) {
                List<com.baidu.tbadk.mainTab.b> bly = this.fxm.bly();
                List<FrsTabInfo> bnK = this.fxm.bnK();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.ea(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bnK.size() == bly.size()) {
                    int size = bnK.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bly.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bnK.get(i);
                            a(bVar, bVar.atS(), bVar.cP(this.dla.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bly) {
                        a(bVar2, bVar2.atS(), bVar2.cP(this.dla.getActivity()), null);
                    }
                }
                this.mTabHost.hR(2);
                this.mTabHost.setViewPagerScrollable(false);
                int rE = rE(this.fxp);
                if (rE < 0) {
                    rE = rE(this.fxo.getGameDefaultTabId());
                }
                if (rE < 0) {
                    rE = bnv();
                }
                if (rE < 0) {
                    rE = 0;
                }
                this.fxp = rE;
                this.fxq = rE;
                this.fsU.rJ(this.fxp);
                this.fsU.so(this.fxq);
                this.mTabHost.setCurrentTab(rE);
                int rG = rG(rE);
                if (rG != 1) {
                    if (this.fxn != null) {
                        this.fxn.jR(false);
                        if (rG != 4 && rG != 25) {
                            this.fxn.jQ(false);
                            this.ftQ.setVisibility(8);
                            this.fxn.bmm();
                        }
                    }
                    if (this.fxo.getForum() != null) {
                        com.baidu.tieba.frs.e.e xE = com.baidu.tieba.frs.e.d.brS().xE(this.fxo.getForum().getName());
                        if (rG == 25) {
                            if (xE == null) {
                                xE = new com.baidu.tieba.frs.e.e(null);
                            }
                            xE.kO(true);
                            com.baidu.tieba.frs.e.d.brS().a(this.fxo.getForum().getName(), xE);
                        } else if (xE != null && xE.brV()) {
                            xE.kO(false);
                            com.baidu.tieba.frs.e.d.brS().a(this.fxo.getForum().getName(), xE);
                        }
                    }
                }
                rH(rE);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bnt() {
        int bnv;
        if (this.fxn != null && (bnv = bnv()) >= 0) {
            a(this.fxn, bnv);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fxo != null && this.fxo.getForum() != null) {
            ForumData forum = this.fxo.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.bQK = cVar.cxD;
            if (bVar2.bQK.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.bQK.setArguments(bundle);
            } else {
                bVar2.bQK.getArguments().putString("fid", forum.getId());
                bVar2.bQK.getArguments().putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bVar2.bQK.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.g(this.dla, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.bWZ);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.g(this.dla.getActivity(), R.dimen.tbds40));
            if (cVar.cxJ == com.baidu.tbadk.mainTab.c.cxF && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.g(this.dla, R.dimen.ds96), com.baidu.adp.lib.util.l.g(this.dla.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.aq.ob(str) > 8) {
                    str = com.baidu.tbadk.core.util.aq.S(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.bWY);
            }
            tbFragmentTabIndicator.jc(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.cxJ != com.baidu.tbadk.mainTab.c.cxF || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.bQJ = tbFragmentTabIndicator;
            bVar2.bQL = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bnu() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int rG = FrsTabHostFragment.this.rG(i);
                if (rG != 1) {
                    FrsTabHostFragment.this.fxn.bmm();
                } else {
                    FrsTabHostFragment.this.fxn.bmn();
                }
                if (rG == 1) {
                    if (FrsTabHostFragment.this.fxn != null) {
                        FrsTabHostFragment.this.fxn.jQ(true);
                    }
                    FrsTabHostFragment.this.ftQ.setVisibility(0);
                    return;
                }
                if (rG == 4 || rG == 25) {
                    if (FrsTabHostFragment.this.ftQ.getVisibility() == 8) {
                        FrsTabHostFragment.this.ftQ.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.fxn != null) {
                        FrsTabHostFragment.this.fxn.jQ(false);
                    }
                    FrsTabHostFragment.this.ftQ.setVisibility(8);
                    FrsTabHostFragment.this.bnC();
                }
                if (FrsTabHostFragment.this.fxn != null) {
                    FrsTabHostFragment.this.fxn.jR(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo rF = FrsTabHostFragment.this.rF(i);
                if (rF == null || rF.tab_type.intValue() != 11) {
                    FragmentTabHost.b hT = FrsTabHostFragment.this.mTabHost.hT(i);
                    if (FrsTabHostFragment.this.fxo != null && FrsTabHostFragment.this.fxo.getForum() != null) {
                        str = FrsTabHostFragment.this.fxo.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(hT, str);
                    if (hT.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bd.cE(FrsTabHostFragment.this.dla.getPageContext().getPageActivity());
                        return false;
                    }
                    if (hT.bQJ != null) {
                        hT.bQJ.atT();
                    }
                    if (hT.bQJ.qP(String.valueOf(hT.mType)) != null) {
                        if (!(hT.bQJ.qP(String.valueOf(hT.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fxq == i) {
                                FrsTabHostFragment.this.b(hT);
                            }
                        } else {
                            hT.bQJ.qP(String.valueOf(hT.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(hT);
                        }
                    }
                    FrsTabHostFragment.this.fxq = i;
                    return true;
                }
                bb.ajC().a((TbPageContext<?>) FrsTabHostFragment.this.dla.getPageContext(), new String[]{rF.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dla.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.dla);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dla.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.cya = fragmentTabIndicator;
        aVar.zQ = this.dla.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fxr != null) {
            this.fxr.onChangeSkinType(i);
        }
    }

    private int rE(int i) {
        if (this.fxm == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fxm.bnK());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fxm.bnK().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo rF(int i) {
        if (this.fxm == null || i >= com.baidu.tbadk.core.util.v.Z(this.fxm.bnK())) {
            return null;
        }
        return this.fxm.bnK().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rG(int i) {
        if (this.fxm != null && i < com.baidu.tbadk.core.util.v.Z(this.fxm.bnK())) {
            return this.fxm.bnK().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aLh;
        if ((fragment instanceof ah) && this.fxo != null && this.fxo.getForum() != null && (aLh = ((ah) fragment).aLh()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fxo.getForum().getName(), 5, true, true) + this.dla.getActivity().getString(R.string.forum));
            aLh.setCenterTextTitle(sb.toString());
        }
    }

    private int bnv() {
        if (this.fxm == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fxm.bnK());
        for (int i = 0; i < Z; i++) {
            if (this.fxm.bnK().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void rH(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fxo != null && FrsTabHostFragment.this.fxo.getForum() != null) {
                        str = FrsTabHostFragment.this.fxo.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.hT(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
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
        } else if (bVar.mType == 25) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsSportsRecommendTab_25"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").P("obj_locate", c(bVar)).bT("fid", str));
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
            if (bVar.mType == 1) {
                TiebaStatic.log("c12905");
            } else if (bVar.mType == 5) {
                TiebaStatic.log("c12907");
            } else if (bVar.mType == 305) {
                TiebaStatic.log("c12906");
            }
        }
    }

    public int bnw() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.dla.getResources().getColor(R.color.cp_bg_line_d_1) : this.dla.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bnx() {
        if (bd.cF(this.dla) && !this.eXh.cte() && !bnA()) {
            if (this.fxn.blP().sZ(502) != null) {
                this.fxt.aw(this.fxn.getForumId(), this.fxn.blP().bsQ().tabId);
            } else {
                rI(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fxr == null) {
            this.fxr = new com.baidu.tieba.write.e(this.dla.getPageContext(), this.blL, "frs");
            this.fxr.GC("2");
        }
        ForumWriteData bmr = this.fxn.bmr();
        bmr.setDefaultZone(i);
        this.fxr.CM(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fxr.a(bmr);
        this.fxr.CL(bnw());
        UtilHelper.setNavigationBarBackground(this.dla, bnw());
        this.fxr.a(false, (View) null, (View) this.ftQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bny() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fxn != null && this.fxn.bmo() != null && (forum = this.fxn.bmo().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fxn.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").P("obj_locate", c(this.mTabHost.hT(this.mTabHost.getCurrentTabIndex()))).bT("fid", str));
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

    public FragmentTabHost bnz() {
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

    public boolean bnA() {
        if (this.fxn != null && this.fxn.isAdded() && this.fxn.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fxn.getPageContext(), this.fxn.bmo());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.ftQ = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fxs = fRSRefreshButton;
    }

    public boolean bnB() {
        if (this.fxr == null) {
            return false;
        }
        return this.fxr.isShowing();
    }

    public void bnC() {
        if (this.fxr != null && this.fxr.isShowing()) {
            this.fxr.sb(true);
        }
    }

    public FragmentTabHost.b hT(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.hT(i);
    }

    public void rJ(int i) {
        this.fxp = i;
    }
}
