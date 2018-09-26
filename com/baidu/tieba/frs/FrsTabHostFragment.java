package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.FrsPage.TabSkin;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout bBe;
    private BaseFragmentActivity byH;
    private Pair<Integer, Integer> dsq;
    private ad dvl;
    private FrsFragment dvm;
    private com.baidu.tieba.tbadkCore.i dvn;
    private int dvp;
    private com.baidu.tieba.write.c dvq;
    private ImageView dvr;
    private com.baidu.tieba.ueg.c dvs;
    private FragmentTabHost mTabHost;
    private int dvo = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.axH();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.dvn != null && FrsTabHostFragment.this.dvn.bbH() != null) {
                        str = FrsTabHostFragment.this.dvn.bbH().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.cM(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.mZ(str);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.byH = (BaseFragmentActivity) getActivity();
        axB();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.byH);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(this.byH.getSupportFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.bBe = new FrameLayout(this.byH.getActivity());
            this.bBe.setClipChildren(false);
            this.bBe.setClipToPadding(false);
            this.bBe.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(axC());
        } else {
            this.mTabHost.reset();
        }
        return this.bBe;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dvs = new com.baidu.tieba.ueg.c(this.byH.getPageContext());
        super.onActivityCreated(bundle);
    }

    public void C(FrsFragment frsFragment) {
        this.dvm = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar, ad adVar) {
        List<TabSkin> list;
        if (iVar != null && adVar != null) {
            this.dvn = iVar;
            this.dvl = adVar;
            this.dvl.axW();
            if (!com.baidu.tbadk.core.util.v.z(this.dvl.avN())) {
                List<com.baidu.tbadk.mainTab.b> avN = this.dvl.avN();
                List<FrsTabInfo> axV = this.dvl.axV();
                this.dsq = null;
                if (this.dvn != null && this.dvn.bxv() != null) {
                    WorldcupSkin bxv = this.dvn.bxv();
                    List<TabSkin> list2 = bxv.tab_skin;
                    this.dsq = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nM(bxv.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nM(bxv.worldcup_top_night)));
                    int h = com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, h, 0, h);
                    this.mTabHost.setTabWidgetViewHeight(com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aP(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds10), 0, 0);
                    this.mTabHost.aQ(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aP(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (axV.size() == avN.size()) {
                    int size = axV.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = avN.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = axV.get(i);
                            TabSkin tabSkin = null;
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.j(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.KE().aVa;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dsq);
                                }
                            }
                            a(bVar, bVar.KE(), bVar.bJ(this.byH.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : avN) {
                        a(bVar2, bVar2.KE(), bVar2.bJ(this.byH.getActivity()), null, null);
                    }
                }
                this.mTabHost.cK(2);
                this.mTabHost.setViewPagerScrollable(false);
                int ld = ld(this.dvo);
                if (ld < 0) {
                    ld = ld(this.dvn.bxq());
                }
                if (ld < 0) {
                    ld = axE();
                }
                if (ld < 0) {
                    ld = 0;
                }
                this.dvo = ld;
                this.dvp = ld;
                this.mTabHost.setCurrentTab(ld);
                if (lf(ld) != 1 && this.dvm != null) {
                    this.dvm.fQ(false);
                }
                lg(ld);
                if (!axF()) {
                    axG();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                axD();
            }
        }
    }

    private void axB() {
        int axE;
        if (this.dvm != null && (axE = axE()) >= 0) {
            a(this.dvm, axE);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dvn != null && this.dvn.bbH() != null) {
            ForumData bbH = this.dvn.bbH();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.aqv = cVar.aVa;
            if (bVar2.aqv.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", bbH.getName());
                bundle.putString("from", bbH.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, bbH.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, bbH.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.aqv.setArguments(bundle);
            } else {
                bVar2.aqv.getArguments().putString(ImageViewerConfig.FORUM_ID, bbH.getId());
                bVar2.aqv.getArguments().putString(ImageViewerConfig.FORUM_NAME, bbH.getName());
                bVar2.aqv.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(e.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.byH, e.C0141e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(e.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.fontsize26));
                tbFragmentTabIndicator.ax(tabSkin.icon, tabSkin.icon_night);
                if (cVar.aVg == com.baidu.tbadk.mainTab.c.aVc && cVar.type == 99) {
                    int h = com.baidu.adp.lib.util.l.h(this.byH, e.C0141e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(h, com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.tbds8));
                } else {
                    int h2 = com.baidu.adp.lib.util.l.h(this.byH, e.C0141e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(h2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.byH, e.C0141e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aws);
                tbFragmentTabIndicator.setTextColorResId(e.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.fontsize30));
                if (cVar.aVg == com.baidu.tbadk.mainTab.c.aVc && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.byH, e.C0141e.ds96), com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.awr);
            }
            tbFragmentTabIndicator.dQ(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aVg != com.baidu.tbadk.mainTab.c.aVc || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.aqu = tbFragmentTabIndicator;
            bVar2.aqw = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a axC() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                if (FrsTabHostFragment.this.lf(i) != 1 && FrsTabHostFragment.this.dvm != null) {
                    FrsTabHostFragment.this.dvm.fQ(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo le = FrsTabHostFragment.this.le(i);
                if (le == null || le.tab_type.intValue() != 11) {
                    FragmentTabHost.b cM = FrsTabHostFragment.this.mTabHost.cM(i);
                    if (FrsTabHostFragment.this.dvn != null && FrsTabHostFragment.this.dvn.bbH() != null) {
                        str = FrsTabHostFragment.this.dvn.bbH().getId();
                    }
                    FrsTabHostFragment.this.a(cM, str);
                    if (cM.mType == 99) {
                        FrsTabHostFragment.this.axH();
                        FrsTabHostFragment.this.mZ(str);
                        return false;
                    } else if (cM.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        ba.bz(FrsTabHostFragment.this.byH.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (cM.aqu != null) {
                            cM.aqu.KF();
                        }
                        if (cM.aqu.hH(String.valueOf(cM.mType)) != null) {
                            if (!(cM.aqu.hH(String.valueOf(cM.mType)).view.getVisibility() == 0)) {
                                if (FrsTabHostFragment.this.dvp == i) {
                                    FrsTabHostFragment.this.b(cM);
                                }
                            } else {
                                cM.aqu.hH(String.valueOf(cM.mType)).view.setVisibility(8);
                                FrsTabHostFragment.this.b(cM);
                            }
                        }
                        FrsTabHostFragment.this.dvp = i;
                        return true;
                    }
                }
                ay.AN().a((TbPageContext<?>) FrsTabHostFragment.this.byH.getPageContext(), new String[]{le.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.byH.getResources().getDimensionPixelSize(e.C0141e.ds12);
        ImageView imageView = new ImageView(this.byH);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(e.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.byH.getResources().getDimensionPixelSize(e.C0141e.ds12));
        aVar.aVu = fragmentTabIndicator;
        aVar.Bs = this.byH.getResources().getDimensionPixelSize(e.C0141e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        axD();
        if (this.dvr != null) {
            com.baidu.tbadk.core.util.al.c(this.dvr, e.f.icon_tabbar_add_n);
            com.baidu.tbadk.core.util.al.i(this.dvr, e.f.icon_tabbar_chaticon_n);
        }
    }

    private int ld(int i) {
        if (this.dvl == null) {
            return -1;
        }
        int y = com.baidu.tbadk.core.util.v.y(this.dvl.axV());
        for (int i2 = 0; i2 < y; i2++) {
            if (this.dvl.axV().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo le(int i) {
        if (this.dvl == null || i >= com.baidu.tbadk.core.util.v.y(this.dvl.axV())) {
            return null;
        }
        return this.dvl.axV().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lf(int i) {
        if (this.dvl != null && i < com.baidu.tbadk.core.util.v.y(this.dvl.axV())) {
            return this.dvl.axV().get(i).tab_id.intValue();
        }
        return -1;
    }

    private void axD() {
        if (this.dvn != null && this.dvn.bxv() != null && this.mTabHost != null) {
            WorldcupSkin bxv = this.dvn.bxv();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bxv.worldcup_bottom, bxv.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar WW;
        if ((fragment instanceof ak) && this.dvn != null && this.dvn.bbH() != null && (WW = ((ak) fragment).WW()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dvn.bbH().getName(), 5, true, true) + this.byH.getActivity().getString(e.j.forum));
            WW.setCenterTextTitle(sb.toString());
        }
    }

    private int axE() {
        if (this.dvl == null) {
            return -1;
        }
        int y = com.baidu.tbadk.core.util.v.y(this.dvl.axV());
        for (int i = 0; i < y; i++) {
            if (this.dvl.axV().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean axF() {
        return (this.dvn == null || this.dvn.bxv() == null) ? false : true;
    }

    private void lg(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.dvn != null && FrsTabHostFragment.this.dvn.bbH() != null) {
                        str = FrsTabHostFragment.this.dvn.bbH().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.cM(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private void axG() {
        if (this.mTabHost != null && this.mTabHost.cN(99) != null) {
            if (this.dvr == null || this.dvr.getParent() == null) {
                if (this.dvr == null) {
                    this.dvr = new ImageView(this.byH.getActivity());
                }
                int h = com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h, h);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.byH.getActivity(), e.C0141e.ds5);
                this.dvr.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.al.c(this.dvr, e.f.icon_tabbar_add_n);
                com.baidu.tbadk.core.util.al.i(this.dvr, e.f.icon_tabbar_chaticon_n);
                this.dvr.setOnClickListener(this.mOnClickListener);
                if (this.dvr.getParent() == null && this.bBe != null) {
                    this.bBe.addView(this.dvr);
                }
            }
        }
    }

    public void axH() {
        if (ba.bA(this.byH) && !this.dvs.bCB() && !axK()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dvq == null) {
                this.dvq = new com.baidu.tieba.write.c(this.byH.getPageContext(), this.bBe, "frs");
                this.dvq.wk("2");
            }
            this.dvq.a(this.dvm.awy());
            this.dvq.vK(ge(true));
            UtilHelper.setNavigationBarBackground(this.byH, ge(false));
            this.dvq.nM(false);
        }
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
    public void mZ(String str) {
        if (!axJ() && this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").w("obj_locate", c(this.mTabHost.cM(this.mTabHost.getCurrentTabIndex()))).al(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (axJ()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").w("obj_locate", c(bVar)).al(ImageViewerConfig.FORUM_ID, str));
        }
    }

    public int ge(boolean z) {
        if (z && this.dsq != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dsq.second).intValue();
            }
            return ((Integer) this.dsq.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.byH.getResources().getColor(e.d.cp_bg_line_d_1);
        } else {
            return this.byH.getResources().getColor(e.d.cp_bg_line_d);
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

    public boolean axI() {
        if (this.mTabHost == null) {
            return false;
        }
        switch (this.mTabHost.getCurrentTabType()) {
            case 12:
            case 102:
            case 103:
                return true;
            default:
                return false;
        }
    }

    private boolean axJ() {
        if (this.dvn == null || this.dvn.bbH() == null) {
            return false;
        }
        return "worldcup".equals(this.dvn.bbH().getSpecialForumType());
    }

    public boolean axK() {
        if (this.dvm != null && this.dvm.isAdded() && this.dvm.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.dvm.getPageContext(), this.dvm.awv());
        }
        return false;
    }

    public FragmentTabHost axL() {
        return this.mTabHost;
    }

    public void gf(boolean z) {
        if (this.dvr != null) {
            this.dvr.setVisibility(z ? 0 : 8);
        }
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

    public boolean axM() {
        if (this.dvq == null) {
            return false;
        }
        return this.dvq.isShowing();
    }

    public void axN() {
        if (this.dvq != null && this.dvq.isShowing()) {
            this.dvq.axN();
        }
    }

    public FragmentTabHost.b cM(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.cM(i);
    }
}
