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
    private BaseFragmentActivity bLT;
    private Pair<Integer, Integer> dKV;
    private ad dNP;
    private FrsFragment dNQ;
    private com.baidu.tieba.tbadkCore.i dNR;
    private int dNT;
    private com.baidu.tieba.write.c dNU;
    private ImageView dNV;
    private com.baidu.tieba.ueg.c dNW;
    private FrameLayout mRootView;
    private FragmentTabHost mTabHost;
    private int dNS = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.aCZ();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.dNR != null && FrsTabHostFragment.this.dNR.bgT() != null) {
                        str = FrsTabHostFragment.this.dNR.bgT().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dy(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.oe(str);
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
        this.bLT = (BaseFragmentActivity) getActivity();
        aCT();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.bLT);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mRootView = new FrameLayout(this.bLT.getActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            this.mRootView.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(aCU());
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dNW = new com.baidu.tieba.ueg.c(this.bLT.getPageContext());
        super.onActivityCreated(bundle);
    }

    public void D(FrsFragment frsFragment) {
        this.dNQ = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar, ad adVar) {
        List<TabSkin> list;
        if (iVar != null && adVar != null) {
            this.dNR = iVar;
            this.dNP = adVar;
            this.dNP.aDo();
            if (!com.baidu.tbadk.core.util.v.I(this.dNP.aBg())) {
                List<com.baidu.tbadk.mainTab.b> aBg = this.dNP.aBg();
                List<FrsTabInfo> aDn = this.dNP.aDn();
                this.dKV = null;
                if (this.dNR != null && this.dNR.bCR() != null) {
                    WorldcupSkin bCR = this.dNR.bCR();
                    List<TabSkin> list2 = bCR.tab_skin;
                    this.dKV = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.oT(bCR.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.oT(bCR.worldcup_top_night)));
                    int h = com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, h, 0, h);
                    this.mTabHost.setTabWidgetViewHeight(com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.bq(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10), 0, 0);
                    this.mTabHost.br(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.bq(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (aDn.size() == aBg.size()) {
                    int size = aDn.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aBg.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aDn.get(i);
                            TabSkin tabSkin = null;
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.k(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.NQ().bdN;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dKV);
                                }
                            }
                            a(bVar, bVar.NQ(), bVar.bR(this.bLT.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aBg) {
                        a(bVar2, bVar2.NQ(), bVar2.bR(this.bLT.getActivity()), null, null);
                    }
                }
                this.mTabHost.dw(2);
                this.mTabHost.setViewPagerScrollable(false);
                int mw = mw(this.dNS);
                if (mw < 0) {
                    mw = mw(this.dNR.bCM());
                }
                if (mw < 0) {
                    mw = aCW();
                }
                if (mw < 0) {
                    mw = 0;
                }
                this.dNS = mw;
                this.dNT = mw;
                this.mTabHost.setCurrentTab(mw);
                if (my(mw) != 1 && this.dNQ != null) {
                    this.dNQ.gw(false);
                }
                mz(mw);
                if (!aCX()) {
                    aCY();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aCV();
            }
        }
    }

    private void aCT() {
        int aCW;
        if (this.dNQ != null && (aCW = aCW()) >= 0) {
            a(this.dNQ, aCW);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dNR != null && this.dNR.bgT() != null) {
            ForumData bgT = this.dNR.bgT();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.azz = cVar.bdN;
            if (bVar2.azz.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", bgT.getName());
                bundle.putString("from", bgT.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, bgT.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, bgT.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.azz.setArguments(bundle);
            } else {
                bVar2.azz.getArguments().putString(ImageViewerConfig.FORUM_ID, bgT.getId());
                bVar2.azz.getArguments().putString(ImageViewerConfig.FORUM_NAME, bgT.getName());
                bVar2.azz.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(e.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bLT, e.C0210e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(e.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.fontsize26));
                tbFragmentTabIndicator.aL(tabSkin.icon, tabSkin.icon_night);
                if (cVar.bdT == com.baidu.tbadk.mainTab.c.bdP && cVar.type == 99) {
                    int h = com.baidu.adp.lib.util.l.h(this.bLT, e.C0210e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(h, com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.tbds8));
                } else {
                    int h2 = com.baidu.adp.lib.util.l.h(this.bLT, e.C0210e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(h2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bLT, e.C0210e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aFt);
                tbFragmentTabIndicator.setTextColorResId(e.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.fontsize30));
                if (cVar.bdT == com.baidu.tbadk.mainTab.c.bdP && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.bLT, e.C0210e.ds96), com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aFs);
            }
            tbFragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.bdT != com.baidu.tbadk.mainTab.c.bdP || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.azy = tbFragmentTabIndicator;
            bVar2.azA = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a aCU() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                if (FrsTabHostFragment.this.my(i) != 1 && FrsTabHostFragment.this.dNQ != null) {
                    FrsTabHostFragment.this.dNQ.gw(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo mx = FrsTabHostFragment.this.mx(i);
                if (mx == null || mx.tab_type.intValue() != 11) {
                    FragmentTabHost.b dy = FrsTabHostFragment.this.mTabHost.dy(i);
                    if (FrsTabHostFragment.this.dNR != null && FrsTabHostFragment.this.dNR.bgT() != null) {
                        str = FrsTabHostFragment.this.dNR.bgT().getId();
                    }
                    FrsTabHostFragment.this.a(dy, str);
                    if (dy.mType == 99) {
                        FrsTabHostFragment.this.aCZ();
                        FrsTabHostFragment.this.oe(str);
                        return false;
                    } else if (dy.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        ba.bI(FrsTabHostFragment.this.bLT.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (dy.azy != null) {
                            dy.azy.NR();
                        }
                        if (dy.azy.ip(String.valueOf(dy.mType)) != null) {
                            if (!(dy.azy.ip(String.valueOf(dy.mType)).view.getVisibility() == 0)) {
                                if (FrsTabHostFragment.this.dNT == i) {
                                    FrsTabHostFragment.this.b(dy);
                                }
                            } else {
                                dy.azy.ip(String.valueOf(dy.mType)).view.setVisibility(8);
                                FrsTabHostFragment.this.b(dy);
                            }
                        }
                        FrsTabHostFragment.this.dNT = i;
                        return true;
                    }
                }
                ay.Ef().a((TbPageContext<?>) FrsTabHostFragment.this.bLT.getPageContext(), new String[]{mx.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.bLT.getResources().getDimensionPixelSize(e.C0210e.ds12);
        ImageView imageView = new ImageView(this.bLT);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(e.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.bLT.getResources().getDimensionPixelSize(e.C0210e.ds12));
        aVar.bei = fragmentTabIndicator;
        aVar.Cd = this.bLT.getResources().getDimensionPixelSize(e.C0210e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        aCV();
        if (this.dNV != null) {
            com.baidu.tbadk.core.util.al.c(this.dNV, e.f.icon_tabbar_add_n);
            com.baidu.tbadk.core.util.al.i(this.dNV, e.f.icon_tabbar_chaticon_n);
        }
    }

    private int mw(int i) {
        if (this.dNP == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dNP.aDn());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dNP.aDn().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo mx(int i) {
        if (this.dNP == null || i >= com.baidu.tbadk.core.util.v.H(this.dNP.aDn())) {
            return null;
        }
        return this.dNP.aDn().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int my(int i) {
        if (this.dNP != null && i < com.baidu.tbadk.core.util.v.H(this.dNP.aDn())) {
            return this.dNP.aDn().get(i).tab_id.intValue();
        }
        return -1;
    }

    private void aCV() {
        if (this.dNR != null && this.dNR.bCR() != null && this.mTabHost != null) {
            WorldcupSkin bCR = this.dNR.bCR();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bCR.worldcup_bottom, bCR.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar abW;
        if ((fragment instanceof ak) && this.dNR != null && this.dNR.bgT() != null && (abW = ((ak) fragment).abW()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dNR.bgT().getName(), 5, true, true) + this.bLT.getActivity().getString(e.j.forum));
            abW.setCenterTextTitle(sb.toString());
        }
    }

    private int aCW() {
        if (this.dNP == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dNP.aDn());
        for (int i = 0; i < H; i++) {
            if (this.dNP.aDn().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean aCX() {
        return (this.dNR == null || this.dNR.bCR() == null) ? false : true;
    }

    private void mz(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.dNR != null && FrsTabHostFragment.this.dNR.bgT() != null) {
                        str = FrsTabHostFragment.this.dNR.bgT().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dy(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private void aCY() {
        if (this.mTabHost != null && this.mTabHost.dz(99) != null) {
            if (this.dNV == null || this.dNV.getParent() == null) {
                if (this.dNV == null) {
                    this.dNV = new ImageView(this.bLT.getActivity());
                }
                int h = com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h, h);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.bLT.getActivity(), e.C0210e.ds5);
                this.dNV.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.al.c(this.dNV, e.f.icon_tabbar_add_n);
                com.baidu.tbadk.core.util.al.i(this.dNV, e.f.icon_tabbar_chaticon_n);
                this.dNV.setOnClickListener(this.mOnClickListener);
                if (this.dNV.getParent() == null && this.mRootView != null) {
                    this.mRootView.addView(this.dNV);
                }
            }
        }
    }

    public void aCZ() {
        if (ba.bJ(this.bLT) && !this.dNW.bIh() && !aDc()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dNU == null) {
                this.dNU = new com.baidu.tieba.write.c(this.bLT.getPageContext(), this.mRootView, "frs");
                this.dNU.xw("2");
            }
            this.dNU.a(this.dNQ.aBR());
            this.dNU.xk(gK(true));
            UtilHelper.setNavigationBarBackground(this.bLT, gK(false));
            this.dNU.ov(false);
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
    public void oe(String str) {
        if (!aDb() && this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").x("obj_locate", c(this.mTabHost.dy(this.mTabHost.getCurrentTabIndex()))).aA(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (aDb()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").x("obj_locate", c(bVar)).aA(ImageViewerConfig.FORUM_ID, str));
        }
    }

    public int gK(boolean z) {
        if (z && this.dKV != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dKV.second).intValue();
            }
            return ((Integer) this.dKV.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.bLT.getResources().getColor(e.d.cp_bg_line_d_1);
        } else {
            return this.bLT.getResources().getColor(e.d.cp_bg_line_d);
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

    public boolean aDa() {
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

    private boolean aDb() {
        if (this.dNR == null || this.dNR.bgT() == null) {
            return false;
        }
        return "worldcup".equals(this.dNR.bgT().getSpecialForumType());
    }

    public boolean aDc() {
        if (this.dNQ != null && this.dNQ.isAdded() && this.dNQ.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.dNQ.getPageContext(), this.dNQ.aBO());
        }
        return false;
    }

    public FragmentTabHost aDd() {
        return this.mTabHost;
    }

    public void gL(boolean z) {
        if (this.dNV != null) {
            this.dNV.setVisibility(z ? 0 : 8);
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

    public boolean aDe() {
        if (this.dNU == null) {
            return false;
        }
        return this.dNU.isShowing();
    }

    public void aDf() {
        if (this.dNU != null && this.dNU.isShowing()) {
            this.dNU.aDf();
        }
    }

    public FragmentTabHost.b dy(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.dy(i);
    }
}
