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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.frs.profession.permission.c;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout bmj;
    private BaseFragmentActivity dmS;
    private com.baidu.tieba.ueg.d eYX;
    private FrsTabController fvg;
    private OvalActionButton fwc;
    private com.baidu.tieba.tbadkCore.l fzA;
    private int fzC;
    private com.baidu.tieba.write.e fzD;
    private FRSRefreshButton fzE;
    private com.baidu.tieba.frs.profession.permission.c fzF;
    private ab fzy;
    private FrsFragment fzz;
    private FragmentTabHost mTabHost;
    private int fzB = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bos();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fzA != null && FrsTabHostFragment.this.fzA.getForum() != null) {
                        str = FrsTabHostFragment.this.fzA.getForum().getId();
                    }
                    FrsTabHostFragment.this.xw(str);
                }
            }
        }
    };
    private c.a fzG = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ki(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.rN(1);
            } else if (z) {
                FrsTabHostFragment.this.rN(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.rN(-1);
            } else {
                FrsTabHostFragment.this.bot();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kj(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.fvg = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dmS = (BaseFragmentActivity) getActivity();
        boo();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.dmS);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.bmj = new FrameLayout(this.dmS.getActivity());
            this.bmj.setClipChildren(false);
            this.bmj.setClipToPadding(false);
            this.bmj.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bop());
        }
        return this.bmj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eYX = new com.baidu.tieba.ueg.d(this.dmS.getPageContext());
        this.fzF = new com.baidu.tieba.frs.profession.permission.c(this.dmS.getPageContext());
        this.fzF.a(this.fzG);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fzz = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ab abVar) {
        if (lVar != null && abVar != null && this.mTabHost != null) {
            this.fzA = lVar;
            this.fzy = abVar;
            this.fzy.boG();
            if (!com.baidu.tbadk.core.util.v.aa(this.fzy.bmq())) {
                List<com.baidu.tbadk.mainTab.b> bmq = this.fzy.bmq();
                List<FrsTabInfo> boF = this.fzy.boF();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.ea(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (boF.size() == bmq.size()) {
                    int size = boF.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bmq.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = boF.get(i);
                            a(bVar, bVar.aug(), bVar.cP(this.dmS.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bmq) {
                        a(bVar2, bVar2.aug(), bVar2.cP(this.dmS.getActivity()), null);
                    }
                }
                this.mTabHost.hR(2);
                this.mTabHost.setViewPagerScrollable(false);
                int rJ = rJ(this.fzB);
                if (rJ < 0) {
                    rJ = rJ(this.fzA.getGameDefaultTabId());
                }
                if (rJ < 0) {
                    rJ = boq();
                }
                if (rJ < 0) {
                    rJ = 0;
                }
                this.fzB = rJ;
                this.fzC = rJ;
                this.fvg.rO(this.fzB);
                this.fvg.su(this.fzC);
                this.mTabHost.setCurrentTab(rJ);
                int rL = rL(rJ);
                if (rL != 1) {
                    if (this.fzz != null) {
                        this.fzz.jU(false);
                        if (rL != 4 && rL != 25) {
                            this.fzz.jT(false);
                            this.fwc.setVisibility(8);
                            this.fzz.bnh();
                        }
                    }
                    if (this.fzA.getForum() != null) {
                        com.baidu.tieba.frs.e.e ye = com.baidu.tieba.frs.e.d.bsS().ye(this.fzA.getForum().getName());
                        if (rL == 25) {
                            if (ye == null) {
                                ye = new com.baidu.tieba.frs.e.e(null);
                            }
                            ye.kR(true);
                            com.baidu.tieba.frs.e.d.bsS().a(this.fzA.getForum().getName(), ye);
                        } else if (ye != null && ye.bsV()) {
                            ye.kR(false);
                            com.baidu.tieba.frs.e.d.bsS().a(this.fzA.getForum().getName(), ye);
                        }
                    }
                }
                rM(rJ);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void boo() {
        int boq;
        if (this.fzz != null && (boq = boq()) >= 0) {
            a(this.fzz, boq);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fzA != null && this.fzA.getForum() != null) {
            ForumData forum = this.fzA.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.bRr = cVar.cyG;
            if (bVar2.bRr.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.bRr.setArguments(bundle);
            } else {
                bVar2.bRr.getArguments().putString("fid", forum.getId());
                bVar2.bRr.getArguments().putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bVar2.bRr.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.g(this.dmS, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.bXY);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.g(this.dmS.getActivity(), R.dimen.tbds40));
            if (cVar.cyM == com.baidu.tbadk.mainTab.c.cyI && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.g(this.dmS, R.dimen.ds96), com.baidu.adp.lib.util.l.g(this.dmS.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.aq.od(str) > 8) {
                    str = com.baidu.tbadk.core.util.aq.S(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.bXX);
            }
            tbFragmentTabIndicator.jg(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.cyM != com.baidu.tbadk.mainTab.c.cyI || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.bRq = tbFragmentTabIndicator;
            bVar2.bRs = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bop() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int rL = FrsTabHostFragment.this.rL(i);
                if (rL != 1) {
                    FrsTabHostFragment.this.fzz.bnh();
                } else {
                    FrsTabHostFragment.this.fzz.bni();
                }
                if (rL == 1) {
                    if (FrsTabHostFragment.this.fzz != null) {
                        FrsTabHostFragment.this.fzz.jT(true);
                    }
                    FrsTabHostFragment.this.fwc.setVisibility(0);
                    return;
                }
                if (rL == 4 || rL == 25) {
                    if (FrsTabHostFragment.this.fwc.getVisibility() == 8) {
                        FrsTabHostFragment.this.fwc.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.fzz != null) {
                        FrsTabHostFragment.this.fzz.jT(false);
                    }
                    FrsTabHostFragment.this.fwc.setVisibility(8);
                    FrsTabHostFragment.this.box();
                }
                if (FrsTabHostFragment.this.fzz != null) {
                    FrsTabHostFragment.this.fzz.jU(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo rK = FrsTabHostFragment.this.rK(i);
                if (rK == null || rK.tab_type.intValue() != 11) {
                    FragmentTabHost.b hT = FrsTabHostFragment.this.mTabHost.hT(i);
                    if (FrsTabHostFragment.this.fzA != null && FrsTabHostFragment.this.fzA.getForum() != null) {
                        str = FrsTabHostFragment.this.fzA.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(hT, str);
                    if (hT.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.cE(FrsTabHostFragment.this.dmS.getPageContext().getPageActivity());
                        return false;
                    }
                    if (hT.bRq != null) {
                        hT.bRq.auh();
                    }
                    if (hT.bRq.ra(String.valueOf(hT.mType)) != null) {
                        if (!(hT.bRq.ra(String.valueOf(hT.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fzC == i) {
                                FrsTabHostFragment.this.b(hT);
                            }
                        } else {
                            hT.bRq.ra(String.valueOf(hT.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(hT);
                        }
                    }
                    FrsTabHostFragment.this.fzC = i;
                    return true;
                }
                ba.ajK().a((TbPageContext<?>) FrsTabHostFragment.this.dmS.getPageContext(), new String[]{rK.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dmS.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.dmS);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dmS.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.czd = fragmentTabIndicator;
        aVar.zQ = this.dmS.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fzD != null) {
            this.fzD.onChangeSkinType(i);
        }
    }

    private int rJ(int i) {
        if (this.fzy == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fzy.boF());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fzy.boF().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo rK(int i) {
        if (this.fzy == null || i >= com.baidu.tbadk.core.util.v.Z(this.fzy.boF())) {
            return null;
        }
        return this.fzy.boF().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rL(int i) {
        if (this.fzy != null && i < com.baidu.tbadk.core.util.v.Z(this.fzy.boF())) {
            return this.fzy.boF().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aLN;
        if ((fragment instanceof ah) && this.fzA != null && this.fzA.getForum() != null && (aLN = ((ah) fragment).aLN()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fzA.getForum().getName(), 5, true, true) + this.dmS.getActivity().getString(R.string.forum));
            aLN.setCenterTextTitle(sb.toString());
        }
    }

    private int boq() {
        if (this.fzy == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fzy.boF());
        for (int i = 0; i < Z; i++) {
            if (this.fzy.boF().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void rM(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fzA != null && FrsTabHostFragment.this.fzA.getForum() != null) {
                        str = FrsTabHostFragment.this.fzA.getForum().getId();
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
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.e(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
            if (bVar.mType == 1) {
                TiebaStatic.log("c12905");
            } else if (bVar.mType == 5) {
                TiebaStatic.log("c12907");
            } else if (bVar.mType == 305) {
                TiebaStatic.log("c12906");
            }
        }
    }

    public int bor() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.dmS.getResources().getColor(R.color.cp_bg_line_d_1) : this.dmS.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bos() {
        if (bc.cF(this.dmS) && !this.eYX.cuo() && !bov()) {
            if (this.fzz.bmH().tf(502) != null) {
                this.fzF.ay(this.fzz.getForumId(), this.fzz.bmH().btR().tabId);
            } else {
                rN(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fzD == null) {
            this.fzD = new com.baidu.tieba.write.e(this.dmS.getPageContext(), this.bmj, "frs");
            this.fzD.Hd("2");
        }
        ForumWriteData bnm = this.fzz.bnm();
        bnm.setDefaultZone(i);
        this.fzD.CS(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fzD.a(bnm);
        this.fzD.CR(bor());
        UtilHelper.setNavigationBarBackground(this.dmS, bor());
        this.fzD.a(false, (View) null, (View) this.fwc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fzz != null && this.fzz.bnj() != null && (forum = this.fzz.bnj().getForum()) != null) {
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
                    if (skinType == 1 || skinType == 4) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fzz.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(String str) {
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

    public FragmentTabHost bou() {
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

    public boolean bov() {
        if (this.fzz != null && this.fzz.isAdded() && this.fzz.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fzz.getPageContext(), this.fzz.bnj());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fwc = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fzE = fRSRefreshButton;
    }

    public boolean bow() {
        if (this.fzD == null) {
            return false;
        }
        return this.fzD.isShowing();
    }

    public void box() {
        if (this.fzD != null && this.fzD.isShowing()) {
            this.fzD.sf(true);
        }
    }

    public FragmentTabHost.b hT(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.hT(i);
    }

    public void rO(int i) {
        this.fzB = i;
    }
}
