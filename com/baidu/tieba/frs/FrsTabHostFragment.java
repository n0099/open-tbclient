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
    private BaseFragmentActivity bHp;
    private Pair<Integer, Integer> dAr;
    private ad dDm;
    private FrsFragment dDn;
    private com.baidu.tieba.tbadkCore.i dDo;
    private int dDq;
    private com.baidu.tieba.write.c dDr;
    private ImageView dDs;
    private com.baidu.tieba.ueg.c dDt;
    private FrameLayout mRootView;
    private FragmentTabHost mTabHost;
    private int dDp = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.aBc();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.dDo != null && FrsTabHostFragment.this.dDo.beT() != null) {
                        str = FrsTabHostFragment.this.dDo.beT().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.cW(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                    FrsTabHostFragment.this.nB(str);
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
        this.bHp = (BaseFragmentActivity) getActivity();
        aAW();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.bHp);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(this.bHp.getSupportFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mRootView = new FrameLayout(this.bHp.getActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            this.mRootView.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(aAX());
        } else {
            this.mTabHost.reset();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dDt = new com.baidu.tieba.ueg.c(this.bHp.getPageContext());
        super.onActivityCreated(bundle);
    }

    public void C(FrsFragment frsFragment) {
        this.dDn = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar, ad adVar) {
        List<TabSkin> list;
        if (iVar != null && adVar != null) {
            this.dDo = iVar;
            this.dDm = adVar;
            this.dDm.aBr();
            if (!com.baidu.tbadk.core.util.v.J(this.dDm.azj())) {
                List<com.baidu.tbadk.mainTab.b> azj = this.dDm.azj();
                List<FrsTabInfo> aBq = this.dDm.aBq();
                this.dAr = null;
                if (this.dDo != null && this.dDo.bAK() != null) {
                    WorldcupSkin bAK = this.dDo.bAK();
                    List<TabSkin> list2 = bAK.tab_skin;
                    this.dAr = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.oq(bAK.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.oq(bAK.worldcup_top_night)));
                    int h = com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, h, 0, h);
                    this.mTabHost.setTabWidgetViewHeight(com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aZ(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds10), 0, 0);
                    this.mTabHost.ba(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aZ(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (aBq.size() == azj.size()) {
                    int size = aBq.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = azj.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = aBq.get(i);
                            TabSkin tabSkin = null;
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.k(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.MC().aZz;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dAr);
                                }
                            }
                            a(bVar, bVar.MC(), bVar.bR(this.bHp.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : azj) {
                        a(bVar2, bVar2.MC(), bVar2.bR(this.bHp.getActivity()), null, null);
                    }
                }
                this.mTabHost.cU(2);
                this.mTabHost.setViewPagerScrollable(false);
                int lB = lB(this.dDp);
                if (lB < 0) {
                    lB = lB(this.dDo.bAF());
                }
                if (lB < 0) {
                    lB = aAZ();
                }
                if (lB < 0) {
                    lB = 0;
                }
                this.dDp = lB;
                this.dDq = lB;
                this.mTabHost.setCurrentTab(lB);
                if (lD(lB) != 1 && this.dDn != null) {
                    this.dDn.gi(false);
                }
                lE(lB);
                if (!aBa()) {
                    aBb();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aAY();
            }
        }
    }

    private void aAW() {
        int aAZ;
        if (this.dDn != null && (aAZ = aAZ()) >= 0) {
            a(this.dDn, aAZ);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dDo != null && this.dDo.beT() != null) {
            ForumData beT = this.dDo.beT();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.avm = cVar.aZz;
            if (bVar2.avm.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", beT.getName());
                bundle.putString("from", beT.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, beT.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, beT.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.avm.setArguments(bundle);
            } else {
                bVar2.avm.getArguments().putString(ImageViewerConfig.FORUM_ID, beT.getId());
                bVar2.avm.getArguments().putString(ImageViewerConfig.FORUM_NAME, beT.getName());
                bVar2.avm.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(e.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bHp, e.C0175e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(e.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.fontsize26));
                tbFragmentTabIndicator.aI(tabSkin.icon, tabSkin.icon_night);
                if (cVar.aZF == com.baidu.tbadk.mainTab.c.aZB && cVar.type == 99) {
                    int h = com.baidu.adp.lib.util.l.h(this.bHp, e.C0175e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(h, com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.tbds8));
                } else {
                    int h2 = com.baidu.adp.lib.util.l.h(this.bHp, e.C0175e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(e.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(h2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.h(this.bHp, e.C0175e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aBd);
                tbFragmentTabIndicator.setTextColorResId(e.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.fontsize30));
                if (cVar.aZF == com.baidu.tbadk.mainTab.c.aZB && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.h(this.bHp, e.C0175e.ds96), com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aBc);
            }
            tbFragmentTabIndicator.ea(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aZF != com.baidu.tbadk.mainTab.c.aZB || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.avl = tbFragmentTabIndicator;
            bVar2.avn = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a aAX() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                if (FrsTabHostFragment.this.lD(i) != 1 && FrsTabHostFragment.this.dDn != null) {
                    FrsTabHostFragment.this.dDn.gi(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo lC = FrsTabHostFragment.this.lC(i);
                if (lC == null || lC.tab_type.intValue() != 11) {
                    FragmentTabHost.b cW = FrsTabHostFragment.this.mTabHost.cW(i);
                    if (FrsTabHostFragment.this.dDo != null && FrsTabHostFragment.this.dDo.beT() != null) {
                        str = FrsTabHostFragment.this.dDo.beT().getId();
                    }
                    FrsTabHostFragment.this.a(cW, str);
                    if (cW.mType == 99) {
                        FrsTabHostFragment.this.aBc();
                        FrsTabHostFragment.this.nB(str);
                        return false;
                    } else if (cW.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        ba.bH(FrsTabHostFragment.this.bHp.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (cW.avl != null) {
                            cW.avl.MD();
                        }
                        if (cW.avl.hV(String.valueOf(cW.mType)) != null) {
                            if (!(cW.avl.hV(String.valueOf(cW.mType)).view.getVisibility() == 0)) {
                                if (FrsTabHostFragment.this.dDq == i) {
                                    FrsTabHostFragment.this.b(cW);
                                }
                            } else {
                                cW.avl.hV(String.valueOf(cW.mType)).view.setVisibility(8);
                                FrsTabHostFragment.this.b(cW);
                            }
                        }
                        FrsTabHostFragment.this.dDq = i;
                        return true;
                    }
                }
                ay.CU().a((TbPageContext<?>) FrsTabHostFragment.this.bHp.getPageContext(), new String[]{lC.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.bHp.getResources().getDimensionPixelSize(e.C0175e.ds12);
        ImageView imageView = new ImageView(this.bHp);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(e.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.bHp.getResources().getDimensionPixelSize(e.C0175e.ds12));
        aVar.aZT = fragmentTabIndicator;
        aVar.Ca = this.bHp.getResources().getDimensionPixelSize(e.C0175e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        aAY();
        if (this.dDs != null) {
            com.baidu.tbadk.core.util.al.c(this.dDs, e.f.icon_tabbar_add_n);
            com.baidu.tbadk.core.util.al.i(this.dDs, e.f.icon_tabbar_chaticon_n);
        }
    }

    private int lB(int i) {
        if (this.dDm == null) {
            return -1;
        }
        int I = com.baidu.tbadk.core.util.v.I(this.dDm.aBq());
        for (int i2 = 0; i2 < I; i2++) {
            if (this.dDm.aBq().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo lC(int i) {
        if (this.dDm == null || i >= com.baidu.tbadk.core.util.v.I(this.dDm.aBq())) {
            return null;
        }
        return this.dDm.aBq().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lD(int i) {
        if (this.dDm != null && i < com.baidu.tbadk.core.util.v.I(this.dDm.aBq())) {
            return this.dDm.aBq().get(i).tab_id.intValue();
        }
        return -1;
    }

    private void aAY() {
        if (this.dDo != null && this.dDo.bAK() != null && this.mTabHost != null) {
            WorldcupSkin bAK = this.dDo.bAK();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bAK.worldcup_bottom, bAK.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aaD;
        if ((fragment instanceof ak) && this.dDo != null && this.dDo.beT() != null && (aaD = ((ak) fragment).aaD()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dDo.beT().getName(), 5, true, true) + this.bHp.getActivity().getString(e.j.forum));
            aaD.setCenterTextTitle(sb.toString());
        }
    }

    private int aAZ() {
        if (this.dDm == null) {
            return -1;
        }
        int I = com.baidu.tbadk.core.util.v.I(this.dDm.aBq());
        for (int i = 0; i < I; i++) {
            if (this.dDm.aBq().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean aBa() {
        return (this.dDo == null || this.dDo.bAK() == null) ? false : true;
    }

    private void lE(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.dDo != null && FrsTabHostFragment.this.dDo.beT() != null) {
                        str = FrsTabHostFragment.this.dDo.beT().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.cW(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private void aBb() {
        if (this.mTabHost != null && this.mTabHost.cX(99) != null) {
            if (this.dDs == null || this.dDs.getParent() == null) {
                if (this.dDs == null) {
                    this.dDs = new ImageView(this.bHp.getActivity());
                }
                int h = com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h, h);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = com.baidu.adp.lib.util.l.h(this.bHp.getActivity(), e.C0175e.ds5);
                this.dDs.setLayoutParams(layoutParams);
                com.baidu.tbadk.core.util.al.c(this.dDs, e.f.icon_tabbar_add_n);
                com.baidu.tbadk.core.util.al.i(this.dDs, e.f.icon_tabbar_chaticon_n);
                this.dDs.setOnClickListener(this.mOnClickListener);
                if (this.dDs.getParent() == null && this.mRootView != null) {
                    this.mRootView.addView(this.dDs);
                }
            }
        }
    }

    public void aBc() {
        if (ba.bI(this.bHp) && !this.dDt.bFP() && !aBf()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dDr == null) {
                this.dDr = new com.baidu.tieba.write.c(this.bHp.getPageContext(), this.mRootView, "frs");
                this.dDr.wL("2");
            }
            this.dDr.a(this.dDn.azU());
            this.dDr.wh(gw(true));
            UtilHelper.setNavigationBarBackground(this.bHp, gw(false));
            this.dDr.oc(false);
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
    public void nB(String str) {
        if (!aBe() && this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").x("obj_locate", c(this.mTabHost.cW(this.mTabHost.getCurrentTabIndex()))).ax(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (aBe()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").x("obj_locate", c(bVar)).ax(ImageViewerConfig.FORUM_ID, str));
        }
    }

    public int gw(boolean z) {
        if (z && this.dAr != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dAr.second).intValue();
            }
            return ((Integer) this.dAr.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.bHp.getResources().getColor(e.d.cp_bg_line_d_1);
        } else {
            return this.bHp.getResources().getColor(e.d.cp_bg_line_d);
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

    public boolean aBd() {
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

    private boolean aBe() {
        if (this.dDo == null || this.dDo.beT() == null) {
            return false;
        }
        return "worldcup".equals(this.dDo.beT().getSpecialForumType());
    }

    public boolean aBf() {
        if (this.dDn != null && this.dDn.isAdded() && this.dDn.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.dDn.getPageContext(), this.dDn.azR());
        }
        return false;
    }

    public FragmentTabHost aBg() {
        return this.mTabHost;
    }

    public void gx(boolean z) {
        if (this.dDs != null) {
            this.dDs.setVisibility(z ? 0 : 8);
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

    public boolean aBh() {
        if (this.dDr == null) {
            return false;
        }
        return this.dDr.isShowing();
    }

    public void aBi() {
        if (this.dDr != null && this.dDr.isShowing()) {
            this.dDr.aBi();
        }
    }

    public FragmentTabHost.b cW(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.cW(i);
    }
}
