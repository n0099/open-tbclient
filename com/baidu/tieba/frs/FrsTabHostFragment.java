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
/* loaded from: classes6.dex */
public class FrsTabHostFragment extends BaseFragment {
    private BaseFragmentActivity bMH;
    private Pair<Integer, Integer> dLF;
    private FrsFragment dOA;
    private com.baidu.tieba.tbadkCore.i dOB;
    private int dOD;
    private com.baidu.tieba.write.c dOE;
    private ImageView dOF;
    private com.baidu.tieba.ueg.c dOG;
    private ad dOz;
    private FrameLayout mRootView;
    private FragmentTabHost mTabHost;
    private int dOC = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.aDw();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.dOB != null && FrsTabHostFragment.this.dOB.bhx() != null) {
                        str = FrsTabHostFragment.this.dOB.bhx().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dy(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.ow(str);
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
        this.bMH = (BaseFragmentActivity) getActivity();
        aDq();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.bMH);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mRootView = new FrameLayout(this.bMH.getActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            this.mRootView.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(aDr());
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dOG = new com.baidu.tieba.ueg.c(this.bMH.getPageContext());
        super.onActivityCreated(bundle);
    }

    public void D(FrsFragment frsFragment) {
        this.dOA = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar, ad adVar) {
        List<TabSkin> list;
        if (iVar != null && adVar != null) {
            this.dOB = iVar;
            this.dOz = adVar;
            this.dOz.aDL();
            if (!com.baidu.tbadk.core.util.v.I(this.dOz.aBD())) {
                List<com.baidu.tbadk.mainTab.b> aBD = this.dOz.aBD();
                List<FrsTabInfo> aDK = this.dOz.aDK();
                this.dLF = null;
                if (this.dOB != null && this.dOB.bDA() != null) {
                    WorldcupSkin bDA = this.dOB.bDA();
                    List<TabSkin> list2 = bDA.tab_skin;
                    this.dLF = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.pj(bDA.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.pj(bDA.worldcup_top_night)));
                    int h = com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, h, 0, h);
                    this.mTabHost.setTabWidgetViewHeight(com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.br(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10), 0, 0);
                    this.mTabHost.bs(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.br(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (aDK.size() == aBD.size()) {
                    int size = aDK.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aBD.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aDK.get(i);
                            TabSkin tabSkin = null;
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.k(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.Oh().beA;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dLF);
                                }
                            }
                            a(bVar, bVar.Oh(), bVar.bR(this.bMH.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aBD) {
                        a(bVar2, bVar2.Oh(), bVar2.bR(this.bMH.getActivity()), null, null);
                    }
                }
                this.mTabHost.dw(2);
                this.mTabHost.setViewPagerScrollable(false);
                int mx = mx(this.dOC);
                if (mx < 0) {
                    mx = mx(this.dOB.bDv());
                }
                if (mx < 0) {
                    mx = aDt();
                }
                if (mx < 0) {
                    mx = 0;
                }
                this.dOC = mx;
                this.dOD = mx;
                this.mTabHost.setCurrentTab(mx);
                if (mz(mx) != 1 && this.dOA != null) {
                    this.dOA.gz(false);
                }
                mA(mx);
                if (!aDu()) {
                    aDv();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aDs();
            }
        }
    }

    private void aDq() {
        int aDt;
        if (this.dOA != null && (aDt = aDt()) >= 0) {
            a(this.dOA, aDt);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dOB != null && this.dOB.bhx() != null) {
            ForumData bhx = this.dOB.bhx();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.aAc = cVar.beA;
            if (bVar2.aAc.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", bhx.getName());
                bundle.putString("from", bhx.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, bhx.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, bhx.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.aAc.setArguments(bundle);
            } else {
                bVar2.aAc.getArguments().putString(ImageViewerConfig.FORUM_ID, bhx.getId());
                bVar2.aAc.getArguments().putString(ImageViewerConfig.FORUM_NAME, bhx.getName());
                bVar2.aAc.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(e.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bMH, e.C0210e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(e.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.fontsize26));
                tbFragmentTabIndicator.aM(tabSkin.icon, tabSkin.icon_night);
                if (cVar.beG == com.baidu.tbadk.mainTab.c.beC && cVar.type == 99) {
                    int h = com.baidu.adp.lib.util.l.h(this.bMH, e.C0210e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(h, com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.tbds8));
                } else {
                    int h2 = com.baidu.adp.lib.util.l.h(this.bMH, e.C0210e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(h2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bMH, e.C0210e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aFW);
                tbFragmentTabIndicator.setTextColorResId(e.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.fontsize30));
                if (cVar.beG == com.baidu.tbadk.mainTab.c.beC && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.bMH, e.C0210e.ds96), com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aFV);
            }
            tbFragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.beG != com.baidu.tbadk.mainTab.c.beC || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.aAb = tbFragmentTabIndicator;
            bVar2.aAd = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a aDr() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                if (FrsTabHostFragment.this.mz(i) != 1 && FrsTabHostFragment.this.dOA != null) {
                    FrsTabHostFragment.this.dOA.gz(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo my = FrsTabHostFragment.this.my(i);
                if (my == null || my.tab_type.intValue() != 11) {
                    FragmentTabHost.b dy = FrsTabHostFragment.this.mTabHost.dy(i);
                    if (FrsTabHostFragment.this.dOB != null && FrsTabHostFragment.this.dOB.bhx() != null) {
                        str = FrsTabHostFragment.this.dOB.bhx().getId();
                    }
                    FrsTabHostFragment.this.a(dy, str);
                    if (dy.mType == 99) {
                        FrsTabHostFragment.this.aDw();
                        FrsTabHostFragment.this.ow(str);
                        return false;
                    } else if (dy.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        ba.bI(FrsTabHostFragment.this.bMH.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (dy.aAb != null) {
                            dy.aAb.Oi();
                        }
                        if (dy.aAb.iD(String.valueOf(dy.mType)) != null) {
                            if (!(dy.aAb.iD(String.valueOf(dy.mType)).view.getVisibility() == 0)) {
                                if (FrsTabHostFragment.this.dOD == i) {
                                    FrsTabHostFragment.this.b(dy);
                                }
                            } else {
                                dy.aAb.iD(String.valueOf(dy.mType)).view.setVisibility(8);
                                FrsTabHostFragment.this.b(dy);
                            }
                        }
                        FrsTabHostFragment.this.dOD = i;
                        return true;
                    }
                }
                ay.Es().a((TbPageContext<?>) FrsTabHostFragment.this.bMH.getPageContext(), new String[]{my.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.bMH.getResources().getDimensionPixelSize(e.C0210e.ds12);
        ImageView imageView = new ImageView(this.bMH);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(e.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.bMH.getResources().getDimensionPixelSize(e.C0210e.ds12));
        aVar.beU = fragmentTabIndicator;
        aVar.Cd = this.bMH.getResources().getDimensionPixelSize(e.C0210e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        aDs();
        if (this.dOF != null) {
            com.baidu.tbadk.core.util.al.c(this.dOF, e.f.icon_tabbar_add_n);
            com.baidu.tbadk.core.util.al.i(this.dOF, e.f.icon_tabbar_chaticon_n);
        }
    }

    private int mx(int i) {
        if (this.dOz == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dOz.aDK());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dOz.aDK().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo my(int i) {
        if (this.dOz == null || i >= com.baidu.tbadk.core.util.v.H(this.dOz.aDK())) {
            return null;
        }
        return this.dOz.aDK().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mz(int i) {
        if (this.dOz != null && i < com.baidu.tbadk.core.util.v.H(this.dOz.aDK())) {
            return this.dOz.aDK().get(i).tab_id.intValue();
        }
        return -1;
    }

    private void aDs() {
        if (this.dOB != null && this.dOB.bDA() != null && this.mTabHost != null) {
            WorldcupSkin bDA = this.dOB.bDA();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bDA.worldcup_bottom, bDA.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar act;
        if ((fragment instanceof ak) && this.dOB != null && this.dOB.bhx() != null && (act = ((ak) fragment).act()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dOB.bhx().getName(), 5, true, true) + this.bMH.getActivity().getString(e.j.forum));
            act.setCenterTextTitle(sb.toString());
        }
    }

    private int aDt() {
        if (this.dOz == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dOz.aDK());
        for (int i = 0; i < H; i++) {
            if (this.dOz.aDK().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean aDu() {
        return (this.dOB == null || this.dOB.bDA() == null) ? false : true;
    }

    private void mA(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.dOB != null && FrsTabHostFragment.this.dOB.bhx() != null) {
                        str = FrsTabHostFragment.this.dOB.bhx().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dy(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private void aDv() {
        if (this.mTabHost != null && this.mTabHost.dz(99) != null) {
            if (this.dOF == null || this.dOF.getParent() == null) {
                if (this.dOF == null) {
                    this.dOF = new ImageView(this.bMH.getActivity());
                }
                int h = com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h, h);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.bMH.getActivity(), e.C0210e.ds5);
                this.dOF.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.al.c(this.dOF, e.f.icon_tabbar_add_n);
                com.baidu.tbadk.core.util.al.i(this.dOF, e.f.icon_tabbar_chaticon_n);
                this.dOF.setOnClickListener(this.mOnClickListener);
                if (this.dOF.getParent() == null && this.mRootView != null) {
                    this.mRootView.addView(this.dOF);
                }
            }
        }
    }

    public void aDw() {
        if (ba.bJ(this.bMH) && !this.dOG.bIQ() && !aDz()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dOE == null) {
                this.dOE = new com.baidu.tieba.write.c(this.bMH.getPageContext(), this.mRootView, "frs");
                this.dOE.xM("2");
            }
            this.dOE.a(this.dOA.aCo());
            this.dOE.xm(gN(true));
            UtilHelper.setNavigationBarBackground(this.bMH, gN(false));
            this.dOE.ow(false);
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
    public void ow(String str) {
        if (!aDy() && this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").y("obj_locate", c(this.mTabHost.dy(this.mTabHost.getCurrentTabIndex()))).aB(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (aDy()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").y("obj_locate", c(bVar)).aB(ImageViewerConfig.FORUM_ID, str));
        }
    }

    public int gN(boolean z) {
        if (z && this.dLF != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dLF.second).intValue();
            }
            return ((Integer) this.dLF.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.bMH.getResources().getColor(e.d.cp_bg_line_d_1);
        } else {
            return this.bMH.getResources().getColor(e.d.cp_bg_line_d);
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

    public boolean aDx() {
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

    private boolean aDy() {
        if (this.dOB == null || this.dOB.bhx() == null) {
            return false;
        }
        return "worldcup".equals(this.dOB.bhx().getSpecialForumType());
    }

    public boolean aDz() {
        if (this.dOA != null && this.dOA.isAdded() && this.dOA.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.dOA.getPageContext(), this.dOA.aCl());
        }
        return false;
    }

    public FragmentTabHost aDA() {
        return this.mTabHost;
    }

    public void gO(boolean z) {
        if (this.dOF != null) {
            this.dOF.setVisibility(z ? 0 : 8);
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

    public boolean aDB() {
        if (this.dOE == null) {
            return false;
        }
        return this.dOE.isShowing();
    }

    public void aDC() {
        if (this.dOE != null && this.dOE.isShowing()) {
            this.dOE.aDC();
        }
    }

    public FragmentTabHost.b dy(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.dy(i);
    }
}
