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
    private FrameLayout bkY;
    private BaseFragmentActivity djs;
    private com.baidu.tieba.ueg.d eSh;
    private FrsTabController fnV;
    private OvalActionButton foR;
    private ab fsq;
    private FrsFragment fsr;
    private com.baidu.tieba.tbadkCore.j fss;
    private int fsu;
    private com.baidu.tieba.write.e fsv;
    private FRSRefreshButton fsw;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    private FragmentTabHost mTabHost;
    private int fst = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.blw();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fss != null && FrsTabHostFragment.this.fss.getForum() != null) {
                        str = FrsTabHostFragment.this.fss.getForum().getId();
                    }
                    FrsTabHostFragment.this.ws(str);
                }
            }
        }
    };
    private c.a fsy = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jV(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.rq(1);
            } else if (z) {
                FrsTabHostFragment.this.rq(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.rq(-1);
            } else {
                FrsTabHostFragment.this.blx();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.fnV = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.djs = (BaseFragmentActivity) getActivity();
        bls();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.djs);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.bkY = new FrameLayout(this.djs.getActivity());
            this.bkY.setClipChildren(false);
            this.bkY.setClipToPadding(false);
            this.bkY.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(blt());
        }
        return this.bkY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eSh = new com.baidu.tieba.ueg.d(this.djs.getPageContext());
        this.fsx = new com.baidu.tieba.frs.profession.permission.c(this.djs.getPageContext());
        this.fsx.a(this.fsy);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fsr = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.j jVar, ab abVar) {
        if (jVar != null && abVar != null) {
            this.fss = jVar;
            this.fsq = abVar;
            this.fsq.blK();
            if (!com.baidu.tbadk.core.util.v.aa(this.fsq.bjw())) {
                List<com.baidu.tbadk.mainTab.b> bjw = this.fsq.bjw();
                List<FrsTabInfo> blJ = this.fsq.blJ();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.dW(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (blJ.size() == bjw.size()) {
                    int size = blJ.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bjw.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = blJ.get(i);
                            a(bVar, bVar.asK(), bVar.cO(this.djs.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bjw) {
                        a(bVar2, bVar2.asK(), bVar2.cO(this.djs.getActivity()), null);
                    }
                }
                this.mTabHost.hL(2);
                this.mTabHost.setViewPagerScrollable(false);
                int rm = rm(this.fst);
                if (rm < 0) {
                    rm = rm(this.fss.getGameDefaultTabId());
                }
                if (rm < 0) {
                    rm = blu();
                }
                if (rm < 0) {
                    rm = 0;
                }
                this.fst = rm;
                this.fsu = rm;
                this.fnV.rr(this.fst);
                this.fnV.rW(this.fsu);
                this.mTabHost.setCurrentTab(rm);
                int ro = ro(rm);
                if (ro != 1) {
                    if (this.fsr != null) {
                        this.fsr.jH(false);
                        if (ro != 4 && ro != 25) {
                            this.fsr.jG(false);
                            this.foR.setVisibility(8);
                            this.fsr.bkk();
                        }
                    }
                    if (this.fss.getForum() != null) {
                        com.baidu.tieba.frs.e.e wX = com.baidu.tieba.frs.e.d.bpP().wX(this.fss.getForum().getName());
                        if (ro == 25) {
                            if (wX == null) {
                                wX = new com.baidu.tieba.frs.e.e(null);
                            }
                            wX.kD(true);
                            com.baidu.tieba.frs.e.d.bpP().a(this.fss.getForum().getName(), wX);
                        } else if (wX != null && wX.bpS()) {
                            wX.kD(false);
                            com.baidu.tieba.frs.e.d.bpP().a(this.fss.getForum().getName(), wX);
                        }
                    }
                }
                rp(rm);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bls() {
        int blu;
        if (this.fsr != null && (blu = blu()) >= 0) {
            a(this.fsr, blu);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fss != null && this.fss.getForum() != null) {
            ForumData forum = this.fss.getForum();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.bPJ = cVar.cwn;
            if (bVar2.bPJ.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.bPJ.setArguments(bundle);
            } else {
                bVar2.bPJ.getArguments().putString("fid", forum.getId());
                bVar2.bPJ.getArguments().putString(ImageViewerConfig.FORUM_NAME, forum.getName());
                bVar2.bPJ.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.g(this.djs, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.bVW);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.g(this.djs.getActivity(), R.dimen.tbds40));
            if (cVar.cwt == com.baidu.tbadk.mainTab.c.cwp && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.g(this.djs, R.dimen.ds96), com.baidu.adp.lib.util.l.g(this.djs.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.ap.nP(str) > 8) {
                    str = com.baidu.tbadk.core.util.ap.S(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.bVV);
            }
            tbFragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.cwt != com.baidu.tbadk.mainTab.c.cwp || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.bPI = tbFragmentTabIndicator;
            bVar2.bPK = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a blt() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int ro = FrsTabHostFragment.this.ro(i);
                if (ro != 1) {
                    FrsTabHostFragment.this.fsr.bkk();
                } else {
                    FrsTabHostFragment.this.fsr.bkl();
                }
                if (ro == 1) {
                    if (FrsTabHostFragment.this.fsr != null) {
                        FrsTabHostFragment.this.fsr.jG(true);
                    }
                    FrsTabHostFragment.this.foR.setVisibility(0);
                    return;
                }
                if (ro == 4 || ro == 25) {
                    if (FrsTabHostFragment.this.foR.getVisibility() == 8) {
                        FrsTabHostFragment.this.foR.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.fsr != null) {
                        FrsTabHostFragment.this.fsr.jG(false);
                    }
                    FrsTabHostFragment.this.foR.setVisibility(8);
                    FrsTabHostFragment.this.blB();
                }
                if (FrsTabHostFragment.this.fsr != null) {
                    FrsTabHostFragment.this.fsr.jH(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo rn = FrsTabHostFragment.this.rn(i);
                if (rn == null || rn.tab_type.intValue() != 11) {
                    FragmentTabHost.b hN = FrsTabHostFragment.this.mTabHost.hN(i);
                    if (FrsTabHostFragment.this.fss != null && FrsTabHostFragment.this.fss.getForum() != null) {
                        str = FrsTabHostFragment.this.fss.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(hN, str);
                    if (hN.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.cD(FrsTabHostFragment.this.djs.getPageContext().getPageActivity());
                        return false;
                    }
                    if (hN.bPI != null) {
                        hN.bPI.asL();
                    }
                    if (hN.bPI.qz(String.valueOf(hN.mType)) != null) {
                        if (!(hN.bPI.qz(String.valueOf(hN.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fsu == i) {
                                FrsTabHostFragment.this.b(hN);
                            }
                        } else {
                            hN.bPI.qz(String.valueOf(hN.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(hN);
                        }
                    }
                    FrsTabHostFragment.this.fsu = i;
                    return true;
                }
                ba.aiz().a((TbPageContext<?>) FrsTabHostFragment.this.djs.getPageContext(), new String[]{rn.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.djs.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.djs);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.djs.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.cwK = fragmentTabIndicator;
        aVar.zL = this.djs.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fsv != null) {
            this.fsv.onChangeSkinType(i);
        }
    }

    private int rm(int i) {
        if (this.fsq == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fsq.blJ());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fsq.blJ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo rn(int i) {
        if (this.fsq == null || i >= com.baidu.tbadk.core.util.v.Z(this.fsq.blJ())) {
            return null;
        }
        return this.fsq.blJ().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ro(int i) {
        if (this.fsq != null && i < com.baidu.tbadk.core.util.v.Z(this.fsq.blJ())) {
            return this.fsq.blJ().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aJC;
        if ((fragment instanceof ah) && this.fss != null && this.fss.getForum() != null && (aJC = ((ah) fragment).aJC()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fss.getForum().getName(), 5, true, true) + this.djs.getActivity().getString(R.string.forum));
            aJC.setCenterTextTitle(sb.toString());
        }
    }

    private int blu() {
        if (this.fsq == null) {
            return -1;
        }
        int Z = com.baidu.tbadk.core.util.v.Z(this.fsq.blJ());
        for (int i = 0; i < Z; i++) {
            if (this.fsq.blJ().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void rp(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fss != null && FrsTabHostFragment.this.fss.getForum() != null) {
                        str = FrsTabHostFragment.this.fss.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.hN(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12334").P("obj_locate", c(bVar)).bT("fid", str));
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

    public int blv() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.djs.getResources().getColor(R.color.cp_bg_line_d_1) : this.djs.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void blw() {
        if (bc.cE(this.djs) && !this.eSh.cqt() && !blz()) {
            if (this.fsr.bjN().sH(502) != null) {
                this.fsx.av(this.fsr.getForumId(), this.fsr.bjN().bqN().tabId);
            } else {
                rq(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fsv == null) {
            this.fsv = new com.baidu.tieba.write.e(this.djs.getPageContext(), this.bkY, "frs");
            this.fsv.FG("2");
        }
        ForumWriteData bkp = this.fsr.bkp();
        bkp.setDefaultZone(i);
        this.fsv.Cf(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fsv.a(bkp);
        this.fsv.Ce(blv());
        UtilHelper.setNavigationBarBackground(this.djs, blv());
        this.fsv.a(false, null, this.foR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fsr != null && this.fsr.bkm() != null && (forum = this.fsr.bkm().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fsr.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12342").P("obj_locate", c(this.mTabHost.hN(this.mTabHost.getCurrentTabIndex()))).bT("fid", str));
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

    public FragmentTabHost bly() {
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

    public boolean blz() {
        if (this.fsr != null && this.fsr.isAdded() && this.fsr.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fsr.getPageContext(), this.fsr.bkm());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.foR = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fsw = fRSRefreshButton;
    }

    public boolean blA() {
        if (this.fsv == null) {
            return false;
        }
        return this.fsv.isShowing();
    }

    public void blB() {
        if (this.fsv != null && this.fsv.isShowing()) {
            this.fsv.rL(true);
        }
    }

    public FragmentTabHost.b hN(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.hN(i);
    }

    public void rr(int i) {
        this.fst = i;
    }
}
