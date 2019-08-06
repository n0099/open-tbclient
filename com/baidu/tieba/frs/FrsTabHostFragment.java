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
    private BaseFragmentActivity dlh;
    private com.baidu.tieba.ueg.d eXr;
    private FrsTabController ftt;
    private OvalActionButton fup;
    private ab fxL;
    private FrsFragment fxM;
    private com.baidu.tieba.tbadkCore.l fxN;
    private int fxP;
    private com.baidu.tieba.write.e fxQ;
    private FRSRefreshButton fxR;
    private com.baidu.tieba.frs.profession.permission.c fxS;
    private FragmentTabHost mTabHost;
    private int fxO = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bnH();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fxN != null && FrsTabHostFragment.this.fxN.getForum() != null) {
                        str = FrsTabHostFragment.this.fxN.getForum().getId();
                    }
                    FrsTabHostFragment.this.wX(str);
                }
            }
        }
    };
    private c.a fxT = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kf(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.rK(1);
            } else if (z) {
                FrsTabHostFragment.this.rK(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.rK(-1);
            } else {
                FrsTabHostFragment.this.bnI();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void kg(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.ftt = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dlh = (BaseFragmentActivity) getActivity();
        bnD();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.dlh);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.blL = new FrameLayout(this.dlh.getActivity());
            this.blL.setClipChildren(false);
            this.blL.setClipToPadding(false);
            this.blL.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bnE());
        }
        return this.blL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eXr = new com.baidu.tieba.ueg.d(this.dlh.getPageContext());
        this.fxS = new com.baidu.tieba.frs.profession.permission.c(this.dlh.getPageContext());
        this.fxS.a(this.fxT);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fxM = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ab abVar) {
        if (lVar != null && abVar != null && this.mTabHost != null) {
            this.fxN = lVar;
            this.fxL = abVar;
            this.fxL.bnV();
            if (!com.baidu.tbadk.core.util.v.aa(this.fxL.blF())) {
                List<com.baidu.tbadk.mainTab.b> blF = this.fxL.blF();
                List<FrsTabInfo> bnU = this.fxL.bnU();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.ea(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bnU.size() == blF.size()) {
                    int size = bnU.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = blF.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bnU.get(i);
                            a(bVar, bVar.atU(), bVar.cP(this.dlh.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : blF) {
                        a(bVar2, bVar2.atU(), bVar2.cP(this.dlh.getActivity()), null);
                    }
                }
                this.mTabHost.hR(2);
                this.mTabHost.setViewPagerScrollable(false);
                int rG = rG(this.fxO);
                if (rG < 0) {
                    rG = rG(this.fxN.getGameDefaultTabId());
                }
                if (rG < 0) {
                    rG = bnF();
                }
                if (rG < 0) {
                    rG = 0;
                }
                this.fxO = rG;
                this.fxP = rG;
                this.ftt.rL(this.fxO);
                this.ftt.sq(this.fxP);
                this.mTabHost.setCurrentTab(rG);
                int rI = rI(rG);
                if (rI != 1) {
                    if (this.fxM != null) {
                        this.fxM.jR(false);
                        if (rI != 4 && rI != 25) {
                            this.fxM.jQ(false);
                            this.fup.setVisibility(8);
                            this.fxM.bmw();
                        }
                    }
                    if (this.fxN.getForum() != null) {
                        com.baidu.tieba.frs.e.e xF = com.baidu.tieba.frs.e.d.bsf().xF(this.fxN.getForum().getName());
                        if (rI == 25) {
                            if (xF == null) {
                                xF = new com.baidu.tieba.frs.e.e(null);
                            }
                            xF.kO(true);
                            com.baidu.tieba.frs.e.d.bsf().a(this.fxN.getForum().getName(), xF);
                        } else if (xF != null && xF.bsi()) {
                            xF.kO(false);
                            com.baidu.tieba.frs.e.d.bsf().a(this.fxN.getForum().getName(), xF);
                        }
                    }
                }
                rJ(rG);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bnD() {
        int bnF;
        if (this.fxM != null && (bnF = bnF()) >= 0) {
            a(this.fxM, bnF);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fxN != null && this.fxN.getForum() != null) {
            ForumData forum = this.fxN.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.bQQ = cVar.cxK;
            if (bVar2.bQQ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.bQQ.setArguments(bundle);
            } else {
                bVar2.bQQ.getArguments().putString("fid", forum.getId());
                bVar2.bQQ.getArguments().putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bVar2.bQQ.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.g(this.dlh, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.bXf);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.g(this.dlh.getActivity(), R.dimen.tbds40));
            if (cVar.cxQ == com.baidu.tbadk.mainTab.c.cxM && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.g(this.dlh, R.dimen.ds96), com.baidu.adp.lib.util.l.g(this.dlh.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.aq.ob(str) > 8) {
                    str = com.baidu.tbadk.core.util.aq.S(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.bXe);
            }
            tbFragmentTabIndicator.jd(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.cxQ != com.baidu.tbadk.mainTab.c.cxM || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.bQP = tbFragmentTabIndicator;
            bVar2.bQR = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bnE() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int rI = FrsTabHostFragment.this.rI(i);
                if (rI != 1) {
                    FrsTabHostFragment.this.fxM.bmw();
                } else {
                    FrsTabHostFragment.this.fxM.bmx();
                }
                if (rI == 1) {
                    if (FrsTabHostFragment.this.fxM != null) {
                        FrsTabHostFragment.this.fxM.jQ(true);
                    }
                    FrsTabHostFragment.this.fup.setVisibility(0);
                    return;
                }
                if (rI == 4 || rI == 25) {
                    if (FrsTabHostFragment.this.fup.getVisibility() == 8) {
                        FrsTabHostFragment.this.fup.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.fxM != null) {
                        FrsTabHostFragment.this.fxM.jQ(false);
                    }
                    FrsTabHostFragment.this.fup.setVisibility(8);
                    FrsTabHostFragment.this.bnM();
                }
                if (FrsTabHostFragment.this.fxM != null) {
                    FrsTabHostFragment.this.fxM.jR(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo rH = FrsTabHostFragment.this.rH(i);
                if (rH == null || rH.tab_type.intValue() != 11) {
                    FragmentTabHost.b hT = FrsTabHostFragment.this.mTabHost.hT(i);
                    if (FrsTabHostFragment.this.fxN != null && FrsTabHostFragment.this.fxN.getForum() != null) {
                        str = FrsTabHostFragment.this.fxN.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(hT, str);
                    if (hT.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bd.cE(FrsTabHostFragment.this.dlh.getPageContext().getPageActivity());
                        return false;
                    }
                    if (hT.bQP != null) {
                        hT.bQP.atV();
                    }
                    if (hT.bQP.qP(String.valueOf(hT.mType)) != null) {
                        if (!(hT.bQP.qP(String.valueOf(hT.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fxP == i) {
                                FrsTabHostFragment.this.b(hT);
                            }
                        } else {
                            hT.bQP.qP(String.valueOf(hT.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(hT);
                        }
                    }
                    FrsTabHostFragment.this.fxP = i;
                    return true;
                }
                bb.ajE().a((TbPageContext<?>) FrsTabHostFragment.this.dlh.getPageContext(), new String[]{rH.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dlh.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.dlh);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dlh.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.cyh = fragmentTabIndicator;
        aVar.zQ = this.dlh.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fxQ != null) {
            this.fxQ.onChangeSkinType(i);
        }
    }

    private int rG(int i) {
        if (this.fxL == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fxL.bnU());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fxL.bnU().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo rH(int i) {
        if (this.fxL == null || i >= com.baidu.tbadk.core.util.v.Z(this.fxL.bnU())) {
            return null;
        }
        return this.fxL.bnU().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rI(int i) {
        if (this.fxL != null && i < com.baidu.tbadk.core.util.v.Z(this.fxL.bnU())) {
            return this.fxL.bnU().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aLj;
        if ((fragment instanceof ah) && this.fxN != null && this.fxN.getForum() != null && (aLj = ((ah) fragment).aLj()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fxN.getForum().getName(), 5, true, true) + this.dlh.getActivity().getString(R.string.forum));
            aLj.setCenterTextTitle(sb.toString());
        }
    }

    private int bnF() {
        if (this.fxL == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fxL.bnU());
        for (int i = 0; i < Z; i++) {
            if (this.fxL.bnU().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void rJ(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fxN != null && FrsTabHostFragment.this.fxN.getForum() != null) {
                        str = FrsTabHostFragment.this.fxN.getForum().getId();
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

    public int bnG() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.dlh.getResources().getColor(R.color.cp_bg_line_d_1) : this.dlh.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bnH() {
        if (bd.cF(this.dlh) && !this.eXr.ctA() && !bnK()) {
            if (this.fxM.blW().tb(502) != null) {
                this.fxS.aw(this.fxM.getForumId(), this.fxM.blW().btd().tabId);
            } else {
                rK(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fxQ == null) {
            this.fxQ = new com.baidu.tieba.write.e(this.dlh.getPageContext(), this.blL, "frs");
            this.fxQ.GD("2");
        }
        ForumWriteData bmB = this.fxM.bmB();
        bmB.setDefaultZone(i);
        this.fxQ.CO(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fxQ.a(bmB);
        this.fxQ.CN(bnG());
        UtilHelper.setNavigationBarBackground(this.dlh, bnG());
        this.fxQ.a(false, (View) null, (View) this.fup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnI() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fxM != null && this.fxM.bmy() != null && (forum = this.fxM.bmy().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fxM.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX(String str) {
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

    public FragmentTabHost bnJ() {
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

    public boolean bnK() {
        if (this.fxM != null && this.fxM.isAdded() && this.fxM.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fxM.getPageContext(), this.fxM.bmy());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fup = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fxR = fRSRefreshButton;
    }

    public boolean bnL() {
        if (this.fxQ == null) {
            return false;
        }
        return this.fxQ.isShowing();
    }

    public void bnM() {
        if (this.fxQ != null && this.fxQ.isShowing()) {
            this.fxQ.sc(true);
        }
    }

    public FragmentTabHost.b hT(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.hT(i);
    }

    public void rL(int i) {
        this.fxO = i;
    }
}
