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
/* loaded from: classes9.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ddl;
    private com.baidu.tieba.ueg.d fgm;
    private BaseFragmentActivity gRv;
    private FrsTabController hmh;
    private OvalActionButton hnj;
    private ag hqI;
    private FrsFragment hqJ;
    private com.baidu.tieba.tbadkCore.m hqK;
    private int hqM;
    private com.baidu.tieba.write.g hqN;
    private FRSRefreshButton hqO;
    private com.baidu.tieba.frs.profession.permission.c hqP;
    private FragmentTabHost mTabHost;
    private int hqL = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bWG();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hqK != null && FrsTabHostFragment.this.hqK.getForum() != null) {
                        str = FrsTabHostFragment.this.hqK.getForum().getId();
                    }
                    FrsTabHostFragment.this.EE(str);
                }
            }
        }
    };
    private c.a hqQ = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.ub(1);
            } else if (z) {
                FrsTabHostFragment.this.ub(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.ub(-1);
            } else {
                FrsTabHostFragment.this.bWH();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hmh = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gRv = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gRv);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ddl = new FrameLayout(this.gRv.getActivity());
            this.ddl.setClipChildren(false);
            this.ddl.setClipToPadding(false);
            this.ddl.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bWD());
        }
        return this.ddl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fgm = new com.baidu.tieba.ueg.d(this.gRv.getPageContext());
        this.hqP = new com.baidu.tieba.frs.profession.permission.c(this.gRv.getPageContext());
        this.hqP.a(this.hqQ);
        super.onActivityCreated(bundle);
    }

    public void N(FrsFragment frsFragment) {
        this.hqJ = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ag agVar) {
        if (mVar != null && agVar != null && this.mTabHost != null) {
            this.hqK = mVar;
            this.hqI = agVar;
            this.hqI.bWS();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hqI.bUw())) {
                List<com.baidu.tbadk.mainTab.b> bUw = this.hqI.bUw();
                List<FrsTabInfo> bUv = this.hqI.bUv();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bUv.size() == bUw.size()) {
                    int size = bUv.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bUw.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bUv.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.gRv.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bUw) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.gRv.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int tY = tY(this.hqL);
                if (tY < 0) {
                    tY = tY(this.hqK.getGameDefaultTabId());
                }
                if (tY < 0) {
                    tY = bWE();
                }
                if (tY < 0) {
                    tY = 0;
                }
                this.hqL = tY;
                this.hqM = tY;
                this.hmh.uc(this.hqL);
                this.hmh.uM(this.hqM);
                this.mTabHost.setCurrentTab(tY);
                int ua = ua(tY);
                if (ua != 1) {
                    if (this.hqJ != null) {
                        this.hqJ.mO(false);
                        if (ua != 4 && ua != 25) {
                            this.hqJ.mN(false);
                            this.hnj.setVisibility(8);
                            this.hqJ.bVq();
                        }
                    }
                    if (this.hqK.getForum() != null) {
                        com.baidu.tieba.frs.e.e Fg = com.baidu.tieba.frs.e.d.cbc().Fg(this.hqK.getForum().getName());
                        if (ua == 25) {
                            if (Fg == null) {
                                Fg = new com.baidu.tieba.frs.e.e(null);
                            }
                            Fg.nI(true);
                            com.baidu.tieba.frs.e.d.cbc().a(this.hqK.getForum().getName(), Fg);
                        } else if (Fg != null && Fg.cbf()) {
                            Fg.nI(false);
                            com.baidu.tieba.frs.e.d.cbc().a(this.hqK.getForum().getName(), Fg);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hqK != null && this.hqK.getForum() != null) {
            ForumData forum = this.hqK.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gRv, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gRv.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gRv, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gRv.getActivity(), R.dimen.tbds12));
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
            bVar2.dLP = tbFragmentTabIndicator;
            bVar2.dLQ = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bWD() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int ua = FrsTabHostFragment.this.ua(i);
                if (ua != 1) {
                    FrsTabHostFragment.this.hqJ.bVq();
                } else {
                    FrsTabHostFragment.this.hqJ.bVr();
                }
                if (ua == 1) {
                    if (FrsTabHostFragment.this.hqJ != null) {
                        FrsTabHostFragment.this.hqJ.mN(true);
                    }
                    FrsTabHostFragment.this.hnj.setVisibility(0);
                    return;
                }
                if (ua == 4 || ua == 25) {
                    if (FrsTabHostFragment.this.hnj.getVisibility() == 8) {
                        FrsTabHostFragment.this.hnj.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hqJ != null) {
                        FrsTabHostFragment.this.hqJ.mN(false);
                    }
                    FrsTabHostFragment.this.hnj.setVisibility(8);
                    FrsTabHostFragment.this.bWK();
                }
                if (FrsTabHostFragment.this.hqJ != null) {
                    FrsTabHostFragment.this.hqJ.mO(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo tZ = FrsTabHostFragment.this.tZ(i);
                if (tZ == null || tZ.tab_type.intValue() != 11) {
                    FragmentTabHost.b kV = FrsTabHostFragment.this.mTabHost.kV(i);
                    if (FrsTabHostFragment.this.hqK != null && FrsTabHostFragment.this.hqK.getForum() != null) {
                        str = FrsTabHostFragment.this.hqK.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(kV, str);
                    if (kV.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gRv.getPageContext().getPageActivity());
                        return false;
                    }
                    if (kV.dLP != null) {
                        kV.dLP.bey();
                    }
                    if (kV.dLP.yy(String.valueOf(kV.mType)) != null) {
                        if (!(kV.dLP.yy(String.valueOf(kV.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hqM == i) {
                                FrsTabHostFragment.this.b(kV);
                            }
                        } else {
                            kV.dLP.yy(String.valueOf(kV.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(kV);
                        }
                    }
                    FrsTabHostFragment.this.hqM = i;
                    return true;
                }
                ba.aUZ().a((TbPageContext<?>) FrsTabHostFragment.this.gRv.getPageContext(), new String[]{tZ.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gRv.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gRv);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gRv.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.eqe = fragmentTabIndicator;
        aVar.offsetX = this.gRv.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hqN != null) {
            this.hqN.onChangeSkinType(i);
        }
    }

    private int tY(int i) {
        if (this.hqI == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hqI.bUv());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hqI.bUv().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo tZ(int i) {
        if (this.hqI == null || i >= com.baidu.tbadk.core.util.v.getCount(this.hqI.bUv())) {
            return null;
        }
        return this.hqI.bUv().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ua(int i) {
        if (this.hqI != null && i < com.baidu.tbadk.core.util.v.getCount(this.hqI.bUv())) {
            return this.hqI.bUv().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int bWE() {
        if (this.hqI == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hqI.bUv());
        for (int i = 0; i < count; i++) {
            if (this.hqI.bUv().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").ag("obj_locate", c(bVar)).dh("fid", str));
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

    public int bWF() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gRv.getResources().getColor(R.color.cp_bg_line_d_1) : this.gRv.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bWG() {
        if (bc.checkUpIsLogin(this.gRv) && !this.fgm.dhl() && !bWJ()) {
            if (this.hqJ.bUP().vC(502) != null) {
                this.hqP.aM(this.hqJ.getForumId(), this.hqJ.bUP().cco().tabId);
            } else {
                ub(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hqN == null) {
            this.hqN = new com.baidu.tieba.write.g(this.gRv.getPageContext(), this.ddl, "frs");
            this.hqN.Oh("2");
        }
        ForumWriteData bVw = this.hqJ.bVw();
        bVw.setDefaultZone(i);
        this.hqN.Fx(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hqN.a(bVw);
        this.hqN.Fw(bWF());
        UtilHelper.setNavigationBarBackground(this.gRv, bWF());
        this.hqN.a(false, (View) null, (View) this.hnj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWH() {
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
        if (this.hqJ != null && this.hqJ.bVs() != null && (forum = this.hqJ.bVs().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hqJ.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EE(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").ag("obj_locate", c(this.mTabHost.kV(this.mTabHost.getCurrentTabIndex()))).dh("fid", str));
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

    public FragmentTabHost bWI() {
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

    public boolean bWJ() {
        if (this.hqJ != null && this.hqJ.isAdded() && this.hqJ.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hqJ.getPageContext(), this.hqJ.bVs());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hnj = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hqO = fRSRefreshButton;
    }

    public boolean bWw() {
        if (this.hqN == null) {
            return false;
        }
        return this.hqN.isShowing();
    }

    public void bWK() {
        if (this.hqN != null && this.hqN.isShowing()) {
            this.hqN.vn(true);
        }
    }

    public FragmentTabHost.b kV(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.kV(i);
    }

    public void uc(int i) {
        this.hqL = i;
    }
}
