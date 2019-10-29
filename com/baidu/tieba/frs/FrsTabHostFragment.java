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
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout bEW;
    private com.baidu.tieba.ueg.d fbI;
    private FrsTabController fut;
    private OvalActionButton fvp;
    private BaseFragmentActivity fyM;
    private ab fyN;
    private FrsFragment fyO;
    private com.baidu.tieba.tbadkCore.l fyP;
    private int fyR;
    private com.baidu.tieba.write.e fyS;
    private FRSRefreshButton fyT;
    private com.baidu.tieba.frs.profession.permission.c fyU;
    private FragmentTabHost mTabHost;
    private int fyQ = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.blw();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fyP != null && FrsTabHostFragment.this.fyP.getForum() != null) {
                        str = FrsTabHostFragment.this.fyP.getForum().getId();
                    }
                    FrsTabHostFragment.this.vO(str);
                }
            }
        }
    };
    private c.a fyV = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void o(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.qG(1);
            } else if (z) {
                FrsTabHostFragment.this.qG(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.qG(-1);
            } else {
                FrsTabHostFragment.this.blx();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jX(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.fut = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.fyM = (BaseFragmentActivity) getActivity();
        bls();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.fyM);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.bEW = new FrameLayout(this.fyM.getActivity());
            this.bEW.setClipChildren(false);
            this.bEW.setClipToPadding(false);
            this.bEW.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(blt());
        }
        return this.bEW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fbI = new com.baidu.tieba.ueg.d(this.fyM.getPageContext());
        this.fyU = new com.baidu.tieba.frs.profession.permission.c(this.fyM.getPageContext());
        this.fyU.a(this.fyV);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fyO = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ab abVar) {
        if (lVar != null && abVar != null && this.mTabHost != null) {
            this.fyP = lVar;
            this.fyN = abVar;
            this.fyN.blK();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fyN.bjw())) {
                List<com.baidu.tbadk.mainTab.b> bjw = this.fyN.bjw();
                List<FrsTabInfo> blJ = this.fyN.blJ();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (blJ.size() == bjw.size()) {
                    int size = blJ.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bjw.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = blJ.get(i);
                            a(bVar, bVar.avz(), bVar.cB(this.fyM.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bjw) {
                        a(bVar2, bVar2.avz(), bVar2.cB(this.fyM.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int qC = qC(this.fyQ);
                if (qC < 0) {
                    qC = qC(this.fyP.getGameDefaultTabId());
                }
                if (qC < 0) {
                    qC = blu();
                }
                if (qC < 0) {
                    qC = 0;
                }
                this.fyQ = qC;
                this.fyR = qC;
                this.fut.qH(this.fyQ);
                this.fut.rn(this.fyR);
                this.mTabHost.setCurrentTab(qC);
                int qE = qE(qC);
                if (qE != 1) {
                    if (this.fyO != null) {
                        this.fyO.jI(false);
                        if (qE != 4 && qE != 25) {
                            this.fyO.jH(false);
                            this.fvp.setVisibility(8);
                            this.fyO.bkn();
                        }
                    }
                    if (this.fyP.getForum() != null) {
                        com.baidu.tieba.frs.e.e ww = com.baidu.tieba.frs.e.d.bpW().ww(this.fyP.getForum().getName());
                        if (qE == 25) {
                            if (ww == null) {
                                ww = new com.baidu.tieba.frs.e.e(null);
                            }
                            ww.kE(true);
                            com.baidu.tieba.frs.e.d.bpW().a(this.fyP.getForum().getName(), ww);
                        } else if (ww != null && ww.bpZ()) {
                            ww.kE(false);
                            com.baidu.tieba.frs.e.d.bpW().a(this.fyP.getForum().getName(), ww);
                        }
                    }
                }
                qF(qC);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void bls() {
        int blu;
        if (this.fyO != null && (blu = blu()) >= 0) {
            a(this.fyO, blu);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fyP != null && this.fyP.getForum() != null) {
            ForumData forum = this.fyP.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.fyM, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.fyM.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.fyM, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.fyM.getActivity(), R.dimen.tbds12));
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
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.showIconType != com.baidu.tbadk.mainTab.c.SHOWICON || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.cim = tbFragmentTabIndicator;
            bVar2.cin = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a blt() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int qE = FrsTabHostFragment.this.qE(i);
                if (qE != 1) {
                    FrsTabHostFragment.this.fyO.bkn();
                } else {
                    FrsTabHostFragment.this.fyO.bko();
                }
                if (qE == 1) {
                    if (FrsTabHostFragment.this.fyO != null) {
                        FrsTabHostFragment.this.fyO.jH(true);
                    }
                    FrsTabHostFragment.this.fvp.setVisibility(0);
                    return;
                }
                if (qE == 4 || qE == 25) {
                    if (FrsTabHostFragment.this.fvp.getVisibility() == 8) {
                        FrsTabHostFragment.this.fvp.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.fyO != null) {
                        FrsTabHostFragment.this.fyO.jH(false);
                    }
                    FrsTabHostFragment.this.fvp.setVisibility(8);
                    FrsTabHostFragment.this.blB();
                }
                if (FrsTabHostFragment.this.fyO != null) {
                    FrsTabHostFragment.this.fyO.jI(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo qD = FrsTabHostFragment.this.qD(i);
                if (qD == null || qD.tab_type.intValue() != 11) {
                    FragmentTabHost.b im = FrsTabHostFragment.this.mTabHost.im(i);
                    if (FrsTabHostFragment.this.fyP != null && FrsTabHostFragment.this.fyP.getForum() != null) {
                        str = FrsTabHostFragment.this.fyP.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(im, str);
                    if (im.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.fyM.getPageContext().getPageActivity());
                        return false;
                    }
                    if (im.cim != null) {
                        im.cim.avA();
                    }
                    if (im.cim.qa(String.valueOf(im.mType)) != null) {
                        if (!(im.cim.qa(String.valueOf(im.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fyR == i) {
                                FrsTabHostFragment.this.b(im);
                            }
                        } else {
                            im.cim.qa(String.valueOf(im.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(im);
                        }
                    }
                    FrsTabHostFragment.this.fyR = i;
                    return true;
                }
                ba.amQ().a((TbPageContext<?>) FrsTabHostFragment.this.fyM.getPageContext(), new String[]{qD.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.fyM.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.fyM);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.fyM.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.cKv = fragmentTabIndicator;
        aVar.offsetX = this.fyM.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fyS != null) {
            this.fyS.onChangeSkinType(i);
        }
    }

    private int qC(int i) {
        if (this.fyN == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.fyN.blJ());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.fyN.blJ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo qD(int i) {
        if (this.fyN == null || i >= com.baidu.tbadk.core.util.v.getCount(this.fyN.blJ())) {
            return null;
        }
        return this.fyN.blJ().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qE(int i) {
        if (this.fyN != null && i < com.baidu.tbadk.core.util.v.getCount(this.fyN.blJ())) {
            return this.fyN.blJ().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aKR;
        if ((fragment instanceof ah) && this.fyP != null && this.fyP.getForum() != null && (aKR = ((ah) fragment).aKR()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fyP.getForum().getName(), 5, true, true) + this.fyM.getActivity().getString(R.string.forum));
            aKR.setCenterTextTitle(sb.toString());
        }
    }

    private int blu() {
        if (this.fyN == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.fyN.blJ());
        for (int i = 0; i < count; i++) {
            if (this.fyN.blJ().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void qF(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fyP != null && FrsTabHostFragment.this.fyP.getForum() != null) {
                        str = FrsTabHostFragment.this.fyP.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.im(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").O("obj_locate", c(bVar)).bS("fid", str));
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.toLong(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
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
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.fyM.getResources().getColor(R.color.cp_bg_line_d_1) : this.fyM.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void blw() {
        if (bc.checkUpIsLogin(this.fyM) && !this.fbI.csd() && !blz()) {
            if (this.fyO.bjN().rZ(502) != null) {
                this.fyU.at(this.fyO.getForumId(), this.fyO.bjN().bqU().tabId);
            } else {
                qG(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.fyS == null) {
            this.fyS = new com.baidu.tieba.write.e(this.fyM.getPageContext(), this.bEW, "frs");
            this.fyS.Fx("2");
        }
        ForumWriteData bks = this.fyO.bks();
        bks.setDefaultZone(i);
        this.fyS.Bw(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fyS.a(bks);
        this.fyS.Bv(blv());
        UtilHelper.setNavigationBarBackground(this.fyM, blv());
        this.fyS.a(false, (View) null, (View) this.fvp);
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
        if (this.fyO != null && this.fyO.bkp() != null && (forum = this.fyO.bkp().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fyO.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").O("obj_locate", c(this.mTabHost.im(this.mTabHost.getCurrentTabIndex()))).bS("fid", str));
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
        if (this.fyO != null && this.fyO.isAdded() && this.fyO.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fyO.getPageContext(), this.fyO.bkp());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fvp = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fyT = fRSRefreshButton;
    }

    public boolean blA() {
        if (this.fyS == null) {
            return false;
        }
        return this.fyS.isShowing();
    }

    public void blB() {
        if (this.fyS != null && this.fyS.isShowing()) {
            this.fyS.rM(true);
        }
    }

    public FragmentTabHost.b im(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.im(i);
    }

    public void qH(int i) {
        this.fyQ = i;
    }
}
