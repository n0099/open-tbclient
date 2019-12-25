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
/* loaded from: classes6.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout coJ;
    private com.baidu.tieba.ueg.d fPx;
    private FrsTabController gia;
    private OvalActionButton gjb;
    private com.baidu.tieba.frs.profession.permission.c gmA;
    private BaseFragmentActivity gms;
    private ac gmt;
    private FrsFragment gmu;
    private com.baidu.tieba.tbadkCore.l gmv;
    private int gmx;
    private com.baidu.tieba.write.f gmy;
    private FRSRefreshButton gmz;
    private FragmentTabHost mTabHost;
    private int gmw = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bCR();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.gmv != null && FrsTabHostFragment.this.gmv.getForum() != null) {
                        str = FrsTabHostFragment.this.gmv.getForum().getId();
                    }
                    FrsTabHostFragment.this.AF(str);
                }
            }
        }
    };
    private c.a gmB = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void li(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void r(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.sL(1);
            } else if (z) {
                FrsTabHostFragment.this.sL(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.sL(-1);
            } else {
                FrsTabHostFragment.this.bCS();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lj(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.gia = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gms = (BaseFragmentActivity) getActivity();
        bCN();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gms);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.coJ = new FrameLayout(this.gms.getActivity());
            this.coJ.setClipChildren(false);
            this.coJ.setClipToPadding(false);
            this.coJ.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bCO());
        }
        return this.coJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fPx = new com.baidu.tieba.ueg.d(this.gms.getPageContext());
        this.gmA = new com.baidu.tieba.frs.profession.permission.c(this.gms.getPageContext());
        this.gmA.a(this.gmB);
        super.onActivityCreated(bundle);
    }

    public void N(FrsFragment frsFragment) {
        this.gmu = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ac acVar) {
        if (lVar != null && acVar != null && this.mTabHost != null) {
            this.gmv = lVar;
            this.gmt = acVar;
            this.gmt.bDe();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.gmt.bAO())) {
                List<com.baidu.tbadk.mainTab.b> bAO = this.gmt.bAO();
                List<FrsTabInfo> bDd = this.gmt.bDd();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bDd.size() == bAO.size()) {
                    int size = bDd.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bAO.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bDd.get(i);
                            a(bVar, bVar.aNf(), bVar.dW(this.gms.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bAO) {
                        a(bVar2, bVar2.aNf(), bVar2.dW(this.gms.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int sH = sH(this.gmw);
                if (sH < 0) {
                    sH = sH(this.gmv.getGameDefaultTabId());
                }
                if (sH < 0) {
                    sH = bCP();
                }
                if (sH < 0) {
                    sH = 0;
                }
                this.gmw = sH;
                this.gmx = sH;
                this.gia.sM(this.gmw);
                this.gia.ts(this.gmx);
                this.mTabHost.setCurrentTab(sH);
                int sJ = sJ(sH);
                if (sJ != 1) {
                    if (this.gmu != null) {
                        this.gmu.kU(false);
                        if (sJ != 4 && sJ != 25) {
                            this.gmu.kT(false);
                            this.gjb.setVisibility(8);
                            this.gmu.bBG();
                        }
                    }
                    if (this.gmv.getForum() != null) {
                        com.baidu.tieba.frs.e.e Bl = com.baidu.tieba.frs.e.d.bHp().Bl(this.gmv.getForum().getName());
                        if (sJ == 25) {
                            if (Bl == null) {
                                Bl = new com.baidu.tieba.frs.e.e(null);
                            }
                            Bl.lQ(true);
                            com.baidu.tieba.frs.e.d.bHp().a(this.gmv.getForum().getName(), Bl);
                        } else if (Bl != null && Bl.bHs()) {
                            Bl.lQ(false);
                            com.baidu.tieba.frs.e.d.bHp().a(this.gmv.getForum().getName(), Bl);
                        }
                    }
                }
                sK(sH);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bCN() {
        int bCP;
        if (this.gmu != null && (bCP = bCP()) >= 0) {
            a(this.gmu, bCP);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.gmv != null && this.gmv.getForum() != null) {
            ForumData forum = this.gmv.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gms, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gms.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gms, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gms.getActivity(), R.dimen.tbds12));
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
            bVar2.cTU = tbFragmentTabIndicator;
            bVar2.cTV = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bCO() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int sJ = FrsTabHostFragment.this.sJ(i);
                if (sJ != 1) {
                    FrsTabHostFragment.this.gmu.bBG();
                } else {
                    FrsTabHostFragment.this.gmu.bBH();
                }
                if (sJ == 1) {
                    if (FrsTabHostFragment.this.gmu != null) {
                        FrsTabHostFragment.this.gmu.kT(true);
                    }
                    FrsTabHostFragment.this.gjb.setVisibility(0);
                    return;
                }
                if (sJ == 4 || sJ == 25) {
                    if (FrsTabHostFragment.this.gjb.getVisibility() == 8) {
                        FrsTabHostFragment.this.gjb.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.gmu != null) {
                        FrsTabHostFragment.this.gmu.kT(false);
                    }
                    FrsTabHostFragment.this.gjb.setVisibility(8);
                    FrsTabHostFragment.this.bCV();
                }
                if (FrsTabHostFragment.this.gmu != null) {
                    FrsTabHostFragment.this.gmu.kU(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo sI = FrsTabHostFragment.this.sI(i);
                if (sI == null || sI.tab_type.intValue() != 11) {
                    FragmentTabHost.b jX = FrsTabHostFragment.this.mTabHost.jX(i);
                    if (FrsTabHostFragment.this.gmv != null && FrsTabHostFragment.this.gmv.getForum() != null) {
                        str = FrsTabHostFragment.this.gmv.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(jX, str);
                    if (jX.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gms.getPageContext().getPageActivity());
                        return false;
                    }
                    if (jX.cTU != null) {
                        jX.cTU.aNg();
                    }
                    if (jX.cTU.vd(String.valueOf(jX.mType)) != null) {
                        if (!(jX.cTU.vd(String.valueOf(jX.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.gmx == i) {
                                FrsTabHostFragment.this.b(jX);
                            }
                        } else {
                            jX.cTU.vd(String.valueOf(jX.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(jX);
                        }
                    }
                    FrsTabHostFragment.this.gmx = i;
                    return true;
                }
                ba.aEa().a((TbPageContext<?>) FrsTabHostFragment.this.gms.getPageContext(), new String[]{sI.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gms.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gms);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gms.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.dxq = fragmentTabIndicator;
        aVar.offsetX = this.gms.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gmy != null) {
            this.gmy.onChangeSkinType(i);
        }
    }

    private int sH(int i) {
        if (this.gmt == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.gmt.bDd());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.gmt.bDd().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo sI(int i) {
        if (this.gmt == null || i >= com.baidu.tbadk.core.util.v.getCount(this.gmt.bDd())) {
            return null;
        }
        return this.gmt.bDd().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sJ(int i) {
        if (this.gmt != null && i < com.baidu.tbadk.core.util.v.getCount(this.gmt.bDd())) {
            return this.gmt.bDd().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar bcb;
        if ((fragment instanceof ai) && this.gmv != null && this.gmv.getForum() != null && (bcb = ((ai) fragment).bcb()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.gmv.getForum().getName(), 5, true, true) + this.gms.getActivity().getString(R.string.forum));
            bcb.setCenterTextTitle(sb.toString());
        }
    }

    private int bCP() {
        if (this.gmt == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.gmt.bDd());
        for (int i = 0; i < count; i++) {
            if (this.gmt.bDd().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void sK(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.gmv != null && FrsTabHostFragment.this.gmv.getForum() != null) {
                        str = FrsTabHostFragment.this.gmv.getForum().getId();
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

    public int bCQ() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gms.getResources().getColor(R.color.cp_bg_line_d_1) : this.gms.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bCR() {
        if (bc.checkUpIsLogin(this.gms) && !this.fPx.cMd() && !bCU()) {
            if (this.gmu.bBg().ug(502) != null) {
                this.gmA.aC(this.gmu.getForumId(), this.gmu.bBg().bIt().tabId);
            } else {
                sL(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.gmy == null) {
            this.gmy = new com.baidu.tieba.write.f(this.gms.getPageContext(), this.coJ, "frs");
            this.gmy.Kp("2");
        }
        ForumWriteData bBM = this.gmu.bBM();
        bBM.setDefaultZone(i);
        this.gmy.DS(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.gmy.a(bBM);
        this.gmy.DR(bCQ());
        UtilHelper.setNavigationBarBackground(this.gms, bCQ());
        this.gmy.a(false, (View) null, (View) this.gjb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCS() {
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
        if (this.gmu != null && this.gmu.bBI() != null && (forum = this.gmu.bBI().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.gmu.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF(String str) {
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

    public FragmentTabHost bCT() {
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

    public boolean bCU() {
        if (this.gmu != null && this.gmu.isAdded() && this.gmu.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.gmu.getPageContext(), this.gmu.bBI());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gjb = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.gmz = fRSRefreshButton;
    }

    public boolean bCI() {
        if (this.gmy == null) {
            return false;
        }
        return this.gmy.isShowing();
    }

    public void bCV() {
        if (this.gmy != null && this.gmy.isShowing()) {
            this.gmy.ts(true);
        }
    }

    public FragmentTabHost.b jX(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.jX(i);
    }

    public void sM(int i) {
        this.gmw = i;
    }
}
