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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
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
/* loaded from: classes7.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout coW;
    private com.baidu.tieba.ueg.d fSG;
    private FrsTabController glk;
    private OvalActionButton gmk;
    private BaseFragmentActivity gpB;
    private ac gpC;
    private FrsFragment gpD;
    private com.baidu.tieba.tbadkCore.l gpE;
    private int gpG;
    private com.baidu.tieba.write.f gpH;
    private FRSRefreshButton gpI;
    private com.baidu.tieba.frs.profession.permission.c gpJ;
    private FragmentTabHost mTabHost;
    private int gpF = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bDT();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.gpE != null && FrsTabHostFragment.this.gpE.getForum() != null) {
                        str = FrsTabHostFragment.this.gpE.getForum().getId();
                    }
                    FrsTabHostFragment.this.AP(str);
                }
            }
        }
    };
    private c.a gpK = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lt(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void s(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.sQ(1);
            } else if (z) {
                FrsTabHostFragment.this.sQ(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.sQ(-1);
            } else {
                FrsTabHostFragment.this.bDU();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lu(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.glk = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gpB = (BaseFragmentActivity) getActivity();
        bDP();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gpB);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.coW = new FrameLayout(this.gpB.getActivity());
            this.coW.setClipChildren(false);
            this.coW.setClipToPadding(false);
            this.coW.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bDQ());
        }
        return this.coW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fSG = new com.baidu.tieba.ueg.d(this.gpB.getPageContext());
        this.gpJ = new com.baidu.tieba.frs.profession.permission.c(this.gpB.getPageContext());
        this.gpJ.a(this.gpK);
        super.onActivityCreated(bundle);
    }

    public void M(FrsFragment frsFragment) {
        this.gpD = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ac acVar) {
        if (lVar != null && acVar != null && this.mTabHost != null) {
            this.gpE = lVar;
            this.gpC = acVar;
            this.gpC.bEg();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.gpC.bBQ())) {
                List<com.baidu.tbadk.mainTab.b> bBQ = this.gpC.bBQ();
                List<FrsTabInfo> bEf = this.gpC.bEf();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bEf.size() == bBQ.size()) {
                    int size = bEf.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bBQ.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bEf.get(i);
                            a(bVar, bVar.aNy(), bVar.dW(this.gpB.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bBQ) {
                        a(bVar2, bVar2.aNy(), bVar2.dW(this.gpB.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int sM = sM(this.gpF);
                if (sM < 0) {
                    sM = sM(this.gpE.getGameDefaultTabId());
                }
                if (sM < 0) {
                    sM = bDR();
                }
                if (sM < 0) {
                    sM = 0;
                }
                this.gpF = sM;
                this.gpG = sM;
                this.glk.sR(this.gpF);
                this.glk.tx(this.gpG);
                this.mTabHost.setCurrentTab(sM);
                int sO = sO(sM);
                if (sO != 1) {
                    if (this.gpD != null) {
                        this.gpD.lf(false);
                        if (sO != 4 && sO != 25) {
                            this.gpD.le(false);
                            this.gmk.setVisibility(8);
                            this.gpD.bCI();
                        }
                    }
                    if (this.gpE.getForum() != null) {
                        com.baidu.tieba.frs.e.e Bv = com.baidu.tieba.frs.e.d.bIr().Bv(this.gpE.getForum().getName());
                        if (sO == 25) {
                            if (Bv == null) {
                                Bv = new com.baidu.tieba.frs.e.e(null);
                            }
                            Bv.mb(true);
                            com.baidu.tieba.frs.e.d.bIr().a(this.gpE.getForum().getName(), Bv);
                        } else if (Bv != null && Bv.bIu()) {
                            Bv.mb(false);
                            com.baidu.tieba.frs.e.d.bIr().a(this.gpE.getForum().getName(), Bv);
                        }
                    }
                }
                sP(sM);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bDP() {
        int bDR;
        if (this.gpD != null && (bDR = bDR()) >= 0) {
            a(this.gpD, bDR);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.gpE != null && this.gpE.getForum() != null) {
            ForumData forum = this.gpE.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.mContentFragment = cVar.frag;
            if (bVar2.mContentFragment.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString("fname", forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.mContentFragment.setArguments(bundle);
            } else {
                bVar2.mContentFragment.getArguments().putString("fid", forum.getId());
                bVar2.mContentFragment.getArguments().putString("fname", forum.getName());
                bVar2.mContentFragment.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gpB, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gpB.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gpB, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gpB.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.aq.getChineseAndEnglishLength(str) > 8) {
                    str = com.baidu.tbadk.core.util.aq.subString(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.textResId);
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.showIconType != com.baidu.tbadk.mainTab.c.SHOWICON || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.cUe = tbFragmentTabIndicator;
            bVar2.cUf = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bDQ() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int sO = FrsTabHostFragment.this.sO(i);
                if (sO != 1) {
                    FrsTabHostFragment.this.gpD.bCI();
                } else {
                    FrsTabHostFragment.this.gpD.bCJ();
                }
                if (sO == 1) {
                    if (FrsTabHostFragment.this.gpD != null) {
                        FrsTabHostFragment.this.gpD.le(true);
                    }
                    FrsTabHostFragment.this.gmk.setVisibility(0);
                    return;
                }
                if (sO == 4 || sO == 25) {
                    if (FrsTabHostFragment.this.gmk.getVisibility() == 8) {
                        FrsTabHostFragment.this.gmk.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.gpD != null) {
                        FrsTabHostFragment.this.gpD.le(false);
                    }
                    FrsTabHostFragment.this.gmk.setVisibility(8);
                    FrsTabHostFragment.this.bDX();
                }
                if (FrsTabHostFragment.this.gpD != null) {
                    FrsTabHostFragment.this.gpD.lf(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo sN = FrsTabHostFragment.this.sN(i);
                if (sN == null || sN.tab_type.intValue() != 11) {
                    FragmentTabHost.b jX = FrsTabHostFragment.this.mTabHost.jX(i);
                    if (FrsTabHostFragment.this.gpE != null && FrsTabHostFragment.this.gpE.getForum() != null) {
                        str = FrsTabHostFragment.this.gpE.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(jX, str);
                    if (jX.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gpB.getPageContext().getPageActivity());
                        return false;
                    }
                    if (jX.cUe != null) {
                        jX.cUe.aNz();
                    }
                    if (jX.cUe.vi(String.valueOf(jX.mType)) != null) {
                        if (!(jX.cUe.vi(String.valueOf(jX.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.gpG == i) {
                                FrsTabHostFragment.this.b(jX);
                            }
                        } else {
                            jX.cUe.vi(String.valueOf(jX.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(jX);
                        }
                    }
                    FrsTabHostFragment.this.gpG = i;
                    return true;
                }
                ba.aEt().a((TbPageContext<?>) FrsTabHostFragment.this.gpB.getPageContext(), new String[]{sN.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gpB.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gpB);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gpB.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.dxy = fragmentTabIndicator;
        aVar.offsetX = this.gpB.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gpH != null) {
            this.gpH.onChangeSkinType(i);
        }
    }

    private int sM(int i) {
        if (this.gpC == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.gpC.bEf());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.gpC.bEf().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo sN(int i) {
        if (this.gpC == null || i >= com.baidu.tbadk.core.util.v.getCount(this.gpC.bEf())) {
            return null;
        }
        return this.gpC.bEf().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sO(int i) {
        if (this.gpC != null && i < com.baidu.tbadk.core.util.v.getCount(this.gpC.bEf())) {
            return this.gpC.bEf().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar bcw;
        if ((fragment instanceof ai) && this.gpE != null && this.gpE.getForum() != null && (bcw = ((ai) fragment).bcw()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.gpE.getForum().getName(), 5, true, true) + this.gpB.getActivity().getString(R.string.forum));
            bcw.setCenterTextTitle(sb.toString());
        }
    }

    private int bDR() {
        if (this.gpC == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.gpC.bEf());
        for (int i = 0; i < count; i++) {
            if (this.gpC.bEf().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void sP(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.gpE != null && FrsTabHostFragment.this.gpE.getForum() != null) {
                        str = FrsTabHostFragment.this.gpE.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.jX(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.b bVar) {
        if (bVar.mType == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_2"));
        } else if (bVar.mType == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGoodsTab_3"));
        } else if (bVar.mType == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsInfoTab_101"));
        } else if (bVar.mType == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsRankList_305"));
        } else if (bVar.mType == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsLiveLive_4"));
        } else if (bVar.mType == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_1"));
        } else if (bVar.mType == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsLivePersonal_5"));
        } else if (bVar.mType == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_8"));
        } else if (bVar.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameLive_9"));
        } else if (bVar.mType == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsGameRecommend_11"));
        } else if (bVar.mType == 12) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsTalkBallTab_12"));
        } else if (bVar.mType == 25) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORCE_REFRESH, "FrsSportsRecommendTab_25"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").Z("obj_locate", c(bVar)).cp("fid", str));
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
            if (bVar.mType == 1) {
                TiebaStatic.log("c12905");
            } else if (bVar.mType == 5) {
                TiebaStatic.log("c12907");
            } else if (bVar.mType == 305) {
                TiebaStatic.log("c12906");
            }
        }
    }

    public int bDS() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gpB.getResources().getColor(R.color.cp_bg_line_d_1) : this.gpB.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bDT() {
        if (bc.checkUpIsLogin(this.gpB) && !this.fSG.cNk() && !bDW()) {
            if (this.gpD.bCi().ul(502) != null) {
                this.gpJ.aD(this.gpD.getForumId(), this.gpD.bCi().bJv().tabId);
            } else {
                sQ(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.gpH == null) {
            this.gpH = new com.baidu.tieba.write.f(this.gpB.getPageContext(), this.coW, "frs");
            this.gpH.Kz("2");
        }
        ForumWriteData bCO = this.gpD.bCO();
        bCO.setDefaultZone(i);
        this.gpH.DY(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.gpH.a(bCO);
        this.gpH.DX(bDS());
        UtilHelper.setNavigationBarBackground(this.gpB, bDS());
        this.gpH.a(false, (View) null, (View) this.gmk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11 = null;
        if (this.gpD != null && this.gpD.bCK() != null && (forum = this.gpD.bCK().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str7 = themeColorInfo.day.dark_color;
                    str8 = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str7 = null;
                    str6 = null;
                    str8 = null;
                }
                if (themeColorInfo.night != null) {
                    String str12 = themeColorInfo.night.light_color;
                    String str13 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str4 = str12;
                        str9 = themeColorInfo.night.pattern_image;
                        str10 = str13;
                    } else {
                        str4 = str12;
                        str9 = str8;
                        str10 = str13;
                    }
                } else {
                    str4 = null;
                    str9 = str8;
                    str10 = null;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str14 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str14;
                        str11 = themeColorInfo.dark.pattern_image;
                        str3 = str10;
                        str5 = str7;
                    } else {
                        str = str14;
                        str11 = str9;
                        str3 = str10;
                        str5 = str7;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str11 = str9;
                    str3 = str10;
                    str5 = str7;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.gpD.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").Z("obj_locate", c(this.mTabHost.jX(this.mTabHost.getCurrentTabIndex()))).cp("fid", str));
        }
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13604");
        if (getPageContext() != null) {
            com.baidu.tbadk.pageInfo.c.a(getPageContext().getPageActivity(), anVar);
        }
        TiebaStatic.log(anVar);
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

    public FragmentTabHost bDV() {
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

    public boolean bDW() {
        if (this.gpD != null && this.gpD.isAdded() && this.gpD.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.gpD.getPageContext(), this.gpD.bCK());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gmk = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.gpI = fRSRefreshButton;
    }

    public boolean bDK() {
        if (this.gpH == null) {
            return false;
        }
        return this.gpH.isShowing();
    }

    public void bDX() {
        if (this.gpH != null && this.gpH.isShowing()) {
            this.gpH.tE(true);
        }
    }

    public FragmentTabHost.b jX(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.jX(i);
    }

    public void sR(int i) {
        this.gpF = i;
    }
}
