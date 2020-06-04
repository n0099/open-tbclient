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
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ddl;
    private com.baidu.tieba.ueg.d fgx;
    private BaseFragmentActivity gRG;
    private FrsTabController hms;
    private OvalActionButton hnu;
    private ag hqT;
    private FrsFragment hqU;
    private com.baidu.tieba.tbadkCore.m hqV;
    private int hqX;
    private com.baidu.tieba.write.g hqY;
    private FRSRefreshButton hqZ;
    private com.baidu.tieba.frs.profession.permission.c hra;
    private FragmentTabHost mTabHost;
    private int hqW = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bWI();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hqV != null && FrsTabHostFragment.this.hqV.getForum() != null) {
                        str = FrsTabHostFragment.this.hqV.getForum().getId();
                    }
                    FrsTabHostFragment.this.EE(str);
                }
            }
        }
    };
    private c.a hrb = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.ud(1);
            } else if (z) {
                FrsTabHostFragment.this.ud(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.ud(-1);
            } else {
                FrsTabHostFragment.this.bWJ();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hms = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gRG = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gRG);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ddl = new FrameLayout(this.gRG.getActivity());
            this.ddl.setClipChildren(false);
            this.ddl.setClipToPadding(false);
            this.ddl.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bWF());
        }
        return this.ddl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fgx = new com.baidu.tieba.ueg.d(this.gRG.getPageContext());
        this.hra = new com.baidu.tieba.frs.profession.permission.c(this.gRG.getPageContext());
        this.hra.a(this.hrb);
        super.onActivityCreated(bundle);
    }

    public void N(FrsFragment frsFragment) {
        this.hqU = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ag agVar) {
        if (mVar != null && agVar != null && this.mTabHost != null) {
            this.hqV = mVar;
            this.hqT = agVar;
            this.hqT.bWU();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hqT.bUy())) {
                List<com.baidu.tbadk.mainTab.b> bUy = this.hqT.bUy();
                List<FrsTabInfo> bUx = this.hqT.bUx();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bUx.size() == bUy.size()) {
                    int size = bUx.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bUy.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bUx.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.gRG.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bUy) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.gRG.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int ua = ua(this.hqW);
                if (ua < 0) {
                    ua = ua(this.hqV.getGameDefaultTabId());
                }
                if (ua < 0) {
                    ua = bWG();
                }
                if (ua < 0) {
                    ua = 0;
                }
                this.hqW = ua;
                this.hqX = ua;
                this.hms.ue(this.hqW);
                this.hms.uO(this.hqX);
                this.mTabHost.setCurrentTab(ua);
                int uc = uc(ua);
                if (uc != 1) {
                    if (this.hqU != null) {
                        this.hqU.mO(false);
                        if (uc != 4 && uc != 25) {
                            this.hqU.mN(false);
                            this.hnu.setVisibility(8);
                            this.hqU.bVs();
                        }
                    }
                    if (this.hqV.getForum() != null) {
                        com.baidu.tieba.frs.e.e Fg = com.baidu.tieba.frs.e.d.cbk().Fg(this.hqV.getForum().getName());
                        if (uc == 25) {
                            if (Fg == null) {
                                Fg = new com.baidu.tieba.frs.e.e(null);
                            }
                            Fg.nI(true);
                            com.baidu.tieba.frs.e.d.cbk().a(this.hqV.getForum().getName(), Fg);
                        } else if (Fg != null && Fg.cbn()) {
                            Fg.nI(false);
                            com.baidu.tieba.frs.e.d.cbk().a(this.hqV.getForum().getName(), Fg);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hqV != null && this.hqV.getForum() != null) {
            ForumData forum = this.hqV.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gRG, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gRG.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gRG, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gRG.getActivity(), R.dimen.tbds12));
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

    private FragmentTabHost.a bWF() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int uc = FrsTabHostFragment.this.uc(i);
                if (uc != 1) {
                    FrsTabHostFragment.this.hqU.bVs();
                } else {
                    FrsTabHostFragment.this.hqU.bVt();
                }
                if (uc == 1) {
                    if (FrsTabHostFragment.this.hqU != null) {
                        FrsTabHostFragment.this.hqU.mN(true);
                    }
                    FrsTabHostFragment.this.hnu.setVisibility(0);
                    return;
                }
                if (uc == 4 || uc == 25) {
                    if (FrsTabHostFragment.this.hnu.getVisibility() == 8) {
                        FrsTabHostFragment.this.hnu.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hqU != null) {
                        FrsTabHostFragment.this.hqU.mN(false);
                    }
                    FrsTabHostFragment.this.hnu.setVisibility(8);
                    FrsTabHostFragment.this.bWM();
                }
                if (FrsTabHostFragment.this.hqU != null) {
                    FrsTabHostFragment.this.hqU.mO(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo ub = FrsTabHostFragment.this.ub(i);
                if (ub == null || ub.tab_type.intValue() != 11) {
                    FragmentTabHost.b kX = FrsTabHostFragment.this.mTabHost.kX(i);
                    if (FrsTabHostFragment.this.hqV != null && FrsTabHostFragment.this.hqV.getForum() != null) {
                        str = FrsTabHostFragment.this.hqV.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(kX, str);
                    if (kX.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gRG.getPageContext().getPageActivity());
                        return false;
                    }
                    if (kX.dLP != null) {
                        kX.dLP.bez();
                    }
                    if (kX.dLP.yy(String.valueOf(kX.mType)) != null) {
                        if (!(kX.dLP.yy(String.valueOf(kX.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hqX == i) {
                                FrsTabHostFragment.this.b(kX);
                            }
                        } else {
                            kX.dLP.yy(String.valueOf(kX.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(kX);
                        }
                    }
                    FrsTabHostFragment.this.hqX = i;
                    return true;
                }
                ba.aVa().a((TbPageContext<?>) FrsTabHostFragment.this.gRG.getPageContext(), new String[]{ub.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gRG.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gRG);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gRG.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.eqe = fragmentTabIndicator;
        aVar.offsetX = this.gRG.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hqY != null) {
            this.hqY.onChangeSkinType(i);
        }
    }

    private int ua(int i) {
        if (this.hqT == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hqT.bUx());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hqT.bUx().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo ub(int i) {
        if (this.hqT == null || i >= com.baidu.tbadk.core.util.v.getCount(this.hqT.bUx())) {
            return null;
        }
        return this.hqT.bUx().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uc(int i) {
        if (this.hqT != null && i < com.baidu.tbadk.core.util.v.getCount(this.hqT.bUx())) {
            return this.hqT.bUx().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int bWG() {
        if (this.hqT == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hqT.bUx());
        for (int i = 0; i < count; i++) {
            if (this.hqT.bUx().get(i).tab_id.intValue() == 1) {
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

    public int bWH() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gRG.getResources().getColor(R.color.cp_bg_line_d_1) : this.gRG.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bWI() {
        if (bc.checkUpIsLogin(this.gRG) && !this.fgx.dhA() && !bWL()) {
            if (this.hqU.bUR().vE(502) != null) {
                this.hra.aM(this.hqU.getForumId(), this.hqU.bUR().ccw().tabId);
            } else {
                ud(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hqY == null) {
            this.hqY = new com.baidu.tieba.write.g(this.gRG.getPageContext(), this.ddl, "frs");
            this.hqY.Oi("2");
            ItemInfo itemInfo = this.hqU.bVu().itemInfo;
            this.hqY.vo((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.aq.isEmpty(itemInfo.name)) ? false : true);
        }
        ForumWriteData bVy = this.hqU.bVy();
        bVy.setDefaultZone(i);
        this.hqY.Fz(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hqY.a(bVy);
        this.hqY.a(this.hqU.bVu().itemInfo);
        this.hqY.Fy(bWH());
        if (this.hqU != null && this.hqU.bVu() != null) {
            this.hqY.a(this.hqU.bVu().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.gRG, bWH());
        this.hqY.a(false, (View) null, (View) this.hnu);
        if (this.hqU != null && this.hqU.bVu() != null && this.hqU.bVu().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13721").dh("fid", this.hqU.getForumId()).dh("fname", this.hqU.getForumName()).dh("obj_param1", this.hqU.bVu().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWJ() {
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
        if (this.hqU != null && this.hqU.bVu() != null && (forum = this.hqU.bVu().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hqU.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EE(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").ag("obj_locate", c(this.mTabHost.kX(this.mTabHost.getCurrentTabIndex()))).dh("fid", str));
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

    public FragmentTabHost bWK() {
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

    public boolean bWL() {
        if (this.hqU != null && this.hqU.isAdded() && this.hqU.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hqU.getPageContext(), this.hqU.bVu());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hnu = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hqZ = fRSRefreshButton;
    }

    public boolean bWy() {
        if (this.hqY == null) {
            return false;
        }
        return this.hqY.isShowing();
    }

    public void bWM() {
        if (this.hqY != null && this.hqY.isShowing()) {
            this.hqY.vp(true);
        }
    }

    public FragmentTabHost.b kX(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.kX(i);
    }

    public void ue(int i) {
        this.hqW = i;
    }
}
