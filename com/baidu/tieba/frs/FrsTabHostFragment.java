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
    private BaseFragmentActivity bLQ;
    private Pair<Integer, Integer> dIh;
    private ad dLb;
    private FrsFragment dLc;
    private com.baidu.tieba.tbadkCore.i dLd;
    private int dLf;
    private com.baidu.tieba.write.c dLg;
    private ImageView dLh;
    private com.baidu.tieba.ueg.c dLi;
    private FrameLayout mRootView;
    private FragmentTabHost mTabHost;
    private int dLe = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.aCk();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.dLd != null && FrsTabHostFragment.this.dLd.bgh() != null) {
                        str = FrsTabHostFragment.this.dLd.bgh().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dy(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.ob(str);
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
        this.bLQ = (BaseFragmentActivity) getActivity();
        aCe();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.bLQ);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mRootView = new FrameLayout(this.bLQ.getActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            this.mRootView.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(aCf());
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dLi = new com.baidu.tieba.ueg.c(this.bLQ.getPageContext());
        super.onActivityCreated(bundle);
    }

    public void D(FrsFragment frsFragment) {
        this.dLc = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar, ad adVar) {
        List<TabSkin> list;
        if (iVar != null && adVar != null) {
            this.dLd = iVar;
            this.dLb = adVar;
            this.dLb.aCz();
            if (!com.baidu.tbadk.core.util.v.I(this.dLb.aAr())) {
                List<com.baidu.tbadk.mainTab.b> aAr = this.dLb.aAr();
                List<FrsTabInfo> aCy = this.dLb.aCy();
                this.dIh = null;
                if (this.dLd != null && this.dLd.bBZ() != null) {
                    WorldcupSkin bBZ = this.dLd.bBZ();
                    List<TabSkin> list2 = bBZ.tab_skin;
                    this.dIh = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.oQ(bBZ.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.oQ(bBZ.worldcup_top_night)));
                    int h = com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, h, 0, h);
                    this.mTabHost.setTabWidgetViewHeight(com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.tbds188));
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
                if (aCy.size() == aAr.size()) {
                    int size = aCy.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = aAr.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aCy.get(i);
                            TabSkin tabSkin = null;
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.k(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.NP().bdK;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dIh);
                                }
                            }
                            a(bVar, bVar.NP(), bVar.bR(this.bLQ.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : aAr) {
                        a(bVar2, bVar2.NP(), bVar2.bR(this.bLQ.getActivity()), null, null);
                    }
                }
                this.mTabHost.dw(2);
                this.mTabHost.setViewPagerScrollable(false);
                int mj = mj(this.dLe);
                if (mj < 0) {
                    mj = mj(this.dLd.bBU());
                }
                if (mj < 0) {
                    mj = aCh();
                }
                if (mj < 0) {
                    mj = 0;
                }
                this.dLe = mj;
                this.dLf = mj;
                this.mTabHost.setCurrentTab(mj);
                if (ml(mj) != 1 && this.dLc != null) {
                    this.dLc.gt(false);
                }
                mm(mj);
                if (!aCi()) {
                    aCj();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aCg();
            }
        }
    }

    private void aCe() {
        int aCh;
        if (this.dLc != null && (aCh = aCh()) >= 0) {
            a(this.dLc, aCh);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dLd != null && this.dLd.bgh() != null) {
            ForumData bgh = this.dLd.bgh();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.azz = cVar.bdK;
            if (bVar2.azz.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", bgh.getName());
                bundle.putString("from", bgh.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, bgh.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, bgh.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.azz.setArguments(bundle);
            } else {
                bVar2.azz.getArguments().putString(ImageViewerConfig.FORUM_ID, bgh.getId());
                bVar2.azz.getArguments().putString(ImageViewerConfig.FORUM_NAME, bgh.getName());
                bVar2.azz.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(e.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bLQ, e.C0210e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(e.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.fontsize26));
                tbFragmentTabIndicator.aL(tabSkin.icon, tabSkin.icon_night);
                if (cVar.bdQ == com.baidu.tbadk.mainTab.c.bdM && cVar.type == 99) {
                    int h = com.baidu.adp.lib.util.l.h(this.bLQ, e.C0210e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(h, com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.tbds8));
                } else {
                    int h2 = com.baidu.adp.lib.util.l.h(this.bLQ, e.C0210e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(h2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bLQ, e.C0210e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aFs);
                tbFragmentTabIndicator.setTextColorResId(e.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.fontsize30));
                if (cVar.bdQ == com.baidu.tbadk.mainTab.c.bdM && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.bLQ, e.C0210e.ds96), com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aFr);
            }
            tbFragmentTabIndicator.eC(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.bdQ != com.baidu.tbadk.mainTab.c.bdM || cVar.type != 99) {
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

    private FragmentTabHost.a aCf() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                if (FrsTabHostFragment.this.ml(i) != 1 && FrsTabHostFragment.this.dLc != null) {
                    FrsTabHostFragment.this.dLc.gt(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo mk = FrsTabHostFragment.this.mk(i);
                if (mk == null || mk.tab_type.intValue() != 11) {
                    FragmentTabHost.b dy = FrsTabHostFragment.this.mTabHost.dy(i);
                    if (FrsTabHostFragment.this.dLd != null && FrsTabHostFragment.this.dLd.bgh() != null) {
                        str = FrsTabHostFragment.this.dLd.bgh().getId();
                    }
                    FrsTabHostFragment.this.a(dy, str);
                    if (dy.mType == 99) {
                        FrsTabHostFragment.this.aCk();
                        FrsTabHostFragment.this.ob(str);
                        return false;
                    } else if (dy.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        ba.bI(FrsTabHostFragment.this.bLQ.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (dy.azy != null) {
                            dy.azy.NQ();
                        }
                        if (dy.azy.io(String.valueOf(dy.mType)) != null) {
                            if (!(dy.azy.io(String.valueOf(dy.mType)).view.getVisibility() == 0)) {
                                if (FrsTabHostFragment.this.dLf == i) {
                                    FrsTabHostFragment.this.b(dy);
                                }
                            } else {
                                dy.azy.io(String.valueOf(dy.mType)).view.setVisibility(8);
                                FrsTabHostFragment.this.b(dy);
                            }
                        }
                        FrsTabHostFragment.this.dLf = i;
                        return true;
                    }
                }
                ay.Ef().a((TbPageContext<?>) FrsTabHostFragment.this.bLQ.getPageContext(), new String[]{mk.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.bLQ.getResources().getDimensionPixelSize(e.C0210e.ds12);
        ImageView imageView = new ImageView(this.bLQ);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(e.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.bLQ.getResources().getDimensionPixelSize(e.C0210e.ds12));
        aVar.bee = fragmentTabIndicator;
        aVar.Cd = this.bLQ.getResources().getDimensionPixelSize(e.C0210e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        aCg();
        if (this.dLh != null) {
            com.baidu.tbadk.core.util.al.c(this.dLh, e.f.icon_tabbar_add_n);
            com.baidu.tbadk.core.util.al.i(this.dLh, e.f.icon_tabbar_chaticon_n);
        }
    }

    private int mj(int i) {
        if (this.dLb == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dLb.aCy());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dLb.aCy().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo mk(int i) {
        if (this.dLb == null || i >= com.baidu.tbadk.core.util.v.H(this.dLb.aCy())) {
            return null;
        }
        return this.dLb.aCy().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ml(int i) {
        if (this.dLb != null && i < com.baidu.tbadk.core.util.v.H(this.dLb.aCy())) {
            return this.dLb.aCy().get(i).tab_id.intValue();
        }
        return -1;
    }

    private void aCg() {
        if (this.dLd != null && this.dLd.bBZ() != null && this.mTabHost != null) {
            WorldcupSkin bBZ = this.dLd.bBZ();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bBZ.worldcup_bottom, bBZ.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar abU;
        if ((fragment instanceof ak) && this.dLd != null && this.dLd.bgh() != null && (abU = ((ak) fragment).abU()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dLd.bgh().getName(), 5, true, true) + this.bLQ.getActivity().getString(e.j.forum));
            abU.setCenterTextTitle(sb.toString());
        }
    }

    private int aCh() {
        if (this.dLb == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dLb.aCy());
        for (int i = 0; i < H; i++) {
            if (this.dLb.aCy().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean aCi() {
        return (this.dLd == null || this.dLd.bBZ() == null) ? false : true;
    }

    private void mm(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.dLd != null && FrsTabHostFragment.this.dLd.bgh() != null) {
                        str = FrsTabHostFragment.this.dLd.bgh().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dy(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private void aCj() {
        if (this.mTabHost != null && this.mTabHost.dz(99) != null) {
            if (this.dLh == null || this.dLh.getParent() == null) {
                if (this.dLh == null) {
                    this.dLh = new ImageView(this.bLQ.getActivity());
                }
                int h = com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h, h);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.bLQ.getActivity(), e.C0210e.ds5);
                this.dLh.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.al.c(this.dLh, e.f.icon_tabbar_add_n);
                com.baidu.tbadk.core.util.al.i(this.dLh, e.f.icon_tabbar_chaticon_n);
                this.dLh.setOnClickListener(this.mOnClickListener);
                if (this.dLh.getParent() == null && this.mRootView != null) {
                    this.mRootView.addView(this.dLh);
                }
            }
        }
    }

    public void aCk() {
        if (ba.bJ(this.bLQ) && !this.dLi.bHr() && !aCn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dLg == null) {
                this.dLg = new com.baidu.tieba.write.c(this.bLQ.getPageContext(), this.mRootView, "frs");
                this.dLg.xt("2");
            }
            this.dLg.a(this.dLc.aBc());
            this.dLg.wX(gH(true));
            UtilHelper.setNavigationBarBackground(this.bLQ, gH(false));
            this.dLg.os(false);
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
    public void ob(String str) {
        if (!aCm() && this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").x("obj_locate", c(this.mTabHost.dy(this.mTabHost.getCurrentTabIndex()))).aA(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (aCm()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").x("obj_locate", c(bVar)).aA(ImageViewerConfig.FORUM_ID, str));
        }
    }

    public int gH(boolean z) {
        if (z && this.dIh != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dIh.second).intValue();
            }
            return ((Integer) this.dIh.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.bLQ.getResources().getColor(e.d.cp_bg_line_d_1);
        } else {
            return this.bLQ.getResources().getColor(e.d.cp_bg_line_d);
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

    public boolean aCl() {
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

    private boolean aCm() {
        if (this.dLd == null || this.dLd.bgh() == null) {
            return false;
        }
        return "worldcup".equals(this.dLd.bgh().getSpecialForumType());
    }

    public boolean aCn() {
        if (this.dLc != null && this.dLc.isAdded() && this.dLc.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.dLc.getPageContext(), this.dLc.aAZ());
        }
        return false;
    }

    public FragmentTabHost aCo() {
        return this.mTabHost;
    }

    public void gI(boolean z) {
        if (this.dLh != null) {
            this.dLh.setVisibility(z ? 0 : 8);
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

    public boolean aCp() {
        if (this.dLg == null) {
            return false;
        }
        return this.dLg.isShowing();
    }

    public void aCq() {
        if (this.dLg != null && this.dLg.isShowing()) {
            this.dLg.aCq();
        }
    }

    public FragmentTabHost.b dy(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.dy(i);
    }
}
