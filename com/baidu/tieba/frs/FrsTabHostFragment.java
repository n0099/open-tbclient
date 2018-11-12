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
    private BaseFragmentActivity bIb;
    private Pair<Integer, Integer> dBI;
    private ad dEC;
    private FrsFragment dED;
    private com.baidu.tieba.tbadkCore.i dEE;
    private int dEG;
    private com.baidu.tieba.write.c dEH;
    private ImageView dEI;
    private com.baidu.tieba.ueg.c dEJ;
    private FrameLayout mRootView;
    private FragmentTabHost mTabHost;
    private int dEF = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.aAA();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.dEE != null && FrsTabHostFragment.this.dEE.ber() != null) {
                        str = FrsTabHostFragment.this.dEE.ber().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dk(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.nC(str);
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
        this.bIb = (BaseFragmentActivity) getActivity();
        aAu();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.bIb);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(this.bIb.getSupportFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mRootView = new FrameLayout(this.bIb.getActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            this.mRootView.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(aAv());
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dEJ = new com.baidu.tieba.ueg.c(this.bIb.getPageContext());
        super.onActivityCreated(bundle);
    }

    public void C(FrsFragment frsFragment) {
        this.dED = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar, ad adVar) {
        List<TabSkin> list;
        if (iVar != null && adVar != null) {
            this.dEE = iVar;
            this.dEC = adVar;
            this.dEC.aAP();
            if (!com.baidu.tbadk.core.util.v.I(this.dEC.ayH())) {
                List<com.baidu.tbadk.mainTab.b> ayH = this.dEC.ayH();
                List<FrsTabInfo> aAO = this.dEC.aAO();
                this.dBI = null;
                if (this.dEE != null && this.dEE.bAg() != null) {
                    WorldcupSkin bAg = this.dEE.bAg();
                    List<TabSkin> list2 = bAg.tab_skin;
                    this.dBI = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.or(bAg.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.or(bAg.worldcup_top_night)));
                    int h = com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, h, 0, h);
                    this.mTabHost.setTabWidgetViewHeight(com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.bp(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds10), 0, 0);
                    this.mTabHost.bq(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.bp(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (aAO.size() == ayH.size()) {
                    int size = aAO.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = ayH.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aAO.get(i);
                            TabSkin tabSkin = null;
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.k(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.ML().bam;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dBI);
                                }
                            }
                            a(bVar, bVar.ML(), bVar.bO(this.bIb.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : ayH) {
                        a(bVar2, bVar2.ML(), bVar2.bO(this.bIb.getActivity()), null, null);
                    }
                }
                this.mTabHost.di(2);
                this.mTabHost.setViewPagerScrollable(false);
                int lT = lT(this.dEF);
                if (lT < 0) {
                    lT = lT(this.dEE.bAb());
                }
                if (lT < 0) {
                    lT = aAx();
                }
                if (lT < 0) {
                    lT = 0;
                }
                this.dEF = lT;
                this.dEG = lT;
                this.mTabHost.setCurrentTab(lT);
                if (lV(lT) != 1 && this.dED != null) {
                    this.dED.gs(false);
                }
                lW(lT);
                if (!aAy()) {
                    aAz();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aAw();
            }
        }
    }

    private void aAu() {
        int aAx;
        if (this.dED != null && (aAx = aAx()) >= 0) {
            a(this.dED, aAx);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dEE != null && this.dEE.ber() != null) {
            ForumData ber = this.dEE.ber();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.avZ = cVar.bam;
            if (bVar2.avZ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", ber.getName());
                bundle.putString("from", ber.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, ber.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, ber.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.avZ.setArguments(bundle);
            } else {
                bVar2.avZ.getArguments().putString(ImageViewerConfig.FORUM_ID, ber.getId());
                bVar2.avZ.getArguments().putString(ImageViewerConfig.FORUM_NAME, ber.getName());
                bVar2.avZ.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(e.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bIb, e.C0200e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(e.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.fontsize26));
                tbFragmentTabIndicator.aI(tabSkin.icon, tabSkin.icon_night);
                if (cVar.bat == com.baidu.tbadk.mainTab.c.bao && cVar.type == 99) {
                    int h = com.baidu.adp.lib.util.l.h(this.bIb, e.C0200e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(h, com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.tbds8));
                } else {
                    int h2 = com.baidu.adp.lib.util.l.h(this.bIb, e.C0200e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(h2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bIb, e.C0200e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aBS);
                tbFragmentTabIndicator.setTextColorResId(e.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.fontsize30));
                if (cVar.bat == com.baidu.tbadk.mainTab.c.bao && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.bIb, e.C0200e.ds96), com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aBR);
            }
            tbFragmentTabIndicator.eo(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.bat != com.baidu.tbadk.mainTab.c.bao || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.avY = tbFragmentTabIndicator;
            bVar2.awa = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a aAv() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                if (FrsTabHostFragment.this.lV(i) != 1 && FrsTabHostFragment.this.dED != null) {
                    FrsTabHostFragment.this.dED.gs(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo lU = FrsTabHostFragment.this.lU(i);
                if (lU == null || lU.tab_type.intValue() != 11) {
                    FragmentTabHost.b dk = FrsTabHostFragment.this.mTabHost.dk(i);
                    if (FrsTabHostFragment.this.dEE != null && FrsTabHostFragment.this.dEE.ber() != null) {
                        str = FrsTabHostFragment.this.dEE.ber().getId();
                    }
                    FrsTabHostFragment.this.a(dk, str);
                    if (dk.mType == 99) {
                        FrsTabHostFragment.this.aAA();
                        FrsTabHostFragment.this.nC(str);
                        return false;
                    } else if (dk.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        ba.bF(FrsTabHostFragment.this.bIb.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (dk.avY != null) {
                            dk.avY.MM();
                        }
                        if (dk.avY.hW(String.valueOf(dk.mType)) != null) {
                            if (!(dk.avY.hW(String.valueOf(dk.mType)).view.getVisibility() == 0)) {
                                if (FrsTabHostFragment.this.dEG == i) {
                                    FrsTabHostFragment.this.b(dk);
                                }
                            } else {
                                dk.avY.hW(String.valueOf(dk.mType)).view.setVisibility(8);
                                FrsTabHostFragment.this.b(dk);
                            }
                        }
                        FrsTabHostFragment.this.dEG = i;
                        return true;
                    }
                }
                ay.Db().a((TbPageContext<?>) FrsTabHostFragment.this.bIb.getPageContext(), new String[]{lU.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.bIb.getResources().getDimensionPixelSize(e.C0200e.ds12);
        ImageView imageView = new ImageView(this.bIb);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(e.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.bIb.getResources().getDimensionPixelSize(e.C0200e.ds12));
        aVar.baH = fragmentTabIndicator;
        aVar.Cd = this.bIb.getResources().getDimensionPixelSize(e.C0200e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        aAw();
        if (this.dEI != null) {
            com.baidu.tbadk.core.util.al.c(this.dEI, e.f.icon_tabbar_add_n);
            com.baidu.tbadk.core.util.al.i(this.dEI, e.f.icon_tabbar_chaticon_n);
        }
    }

    private int lT(int i) {
        if (this.dEC == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dEC.aAO());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dEC.aAO().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo lU(int i) {
        if (this.dEC == null || i >= com.baidu.tbadk.core.util.v.H(this.dEC.aAO())) {
            return null;
        }
        return this.dEC.aAO().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lV(int i) {
        if (this.dEC != null && i < com.baidu.tbadk.core.util.v.H(this.dEC.aAO())) {
            return this.dEC.aAO().get(i).tab_id.intValue();
        }
        return -1;
    }

    private void aAw() {
        if (this.dEE != null && this.dEE.bAg() != null && this.mTabHost != null) {
            WorldcupSkin bAg = this.dEE.bAg();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bAg.worldcup_bottom, bAg.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aaO;
        if ((fragment instanceof ak) && this.dEE != null && this.dEE.ber() != null && (aaO = ((ak) fragment).aaO()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dEE.ber().getName(), 5, true, true) + this.bIb.getActivity().getString(e.j.forum));
            aaO.setCenterTextTitle(sb.toString());
        }
    }

    private int aAx() {
        if (this.dEC == null) {
            return -1;
        }
        int H = com.baidu.tbadk.core.util.v.H(this.dEC.aAO());
        for (int i = 0; i < H; i++) {
            if (this.dEC.aAO().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean aAy() {
        return (this.dEE == null || this.dEE.bAg() == null) ? false : true;
    }

    private void lW(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.dEE != null && FrsTabHostFragment.this.dEE.ber() != null) {
                        str = FrsTabHostFragment.this.dEE.ber().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.dk(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private void aAz() {
        if (this.mTabHost != null && this.mTabHost.dl(99) != null) {
            if (this.dEI == null || this.dEI.getParent() == null) {
                if (this.dEI == null) {
                    this.dEI = new ImageView(this.bIb.getActivity());
                }
                int h = com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h, h);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.bIb.getActivity(), e.C0200e.ds5);
                this.dEI.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.al.c(this.dEI, e.f.icon_tabbar_add_n);
                com.baidu.tbadk.core.util.al.i(this.dEI, e.f.icon_tabbar_chaticon_n);
                this.dEI.setOnClickListener(this.mOnClickListener);
                if (this.dEI.getParent() == null && this.mRootView != null) {
                    this.mRootView.addView(this.dEI);
                }
            }
        }
    }

    public void aAA() {
        if (ba.bG(this.bIb) && !this.dEJ.bFo() && !aAD()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dEH == null) {
                this.dEH = new com.baidu.tieba.write.c(this.bIb.getPageContext(), this.mRootView, "frs");
                this.dEH.wQ("2");
            }
            this.dEH.a(this.dED.azs());
            this.dEH.wA(gG(true));
            UtilHelper.setNavigationBarBackground(this.bIb, gG(false));
            this.dEH.oq(false);
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
    public void nC(String str) {
        if (!aAC() && this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").x("obj_locate", c(this.mTabHost.dk(this.mTabHost.getCurrentTabIndex()))).ax(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (aAC()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").x("obj_locate", c(bVar)).ax(ImageViewerConfig.FORUM_ID, str));
        }
    }

    public int gG(boolean z) {
        if (z && this.dBI != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dBI.second).intValue();
            }
            return ((Integer) this.dBI.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.bIb.getResources().getColor(e.d.cp_bg_line_d_1);
        } else {
            return this.bIb.getResources().getColor(e.d.cp_bg_line_d);
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

    public boolean aAB() {
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

    private boolean aAC() {
        if (this.dEE == null || this.dEE.ber() == null) {
            return false;
        }
        return "worldcup".equals(this.dEE.ber().getSpecialForumType());
    }

    public boolean aAD() {
        if (this.dED != null && this.dED.isAdded() && this.dED.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.dED.getPageContext(), this.dED.azp());
        }
        return false;
    }

    public FragmentTabHost aAE() {
        return this.mTabHost;
    }

    public void gH(boolean z) {
        if (this.dEI != null) {
            this.dEI.setVisibility(z ? 0 : 8);
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

    public boolean aAF() {
        if (this.dEH == null) {
            return false;
        }
        return this.dEH.isShowing();
    }

    public void aAG() {
        if (this.dEH != null && this.dEH.isShowing()) {
            this.dEH.aAG();
        }
    }

    public FragmentTabHost.b dk(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.dk(i);
    }
}
