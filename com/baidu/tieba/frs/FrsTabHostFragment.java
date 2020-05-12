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
    private FrameLayout cSk;
    private com.baidu.tieba.ueg.d eTE;
    private BaseFragmentActivity gCM;
    private FrsTabController gXv;
    private OvalActionButton gYx;
    private ag hbU;
    private FrsFragment hbV;
    private com.baidu.tieba.tbadkCore.m hbW;
    private int hbY;
    private com.baidu.tieba.write.f hbZ;
    private FRSRefreshButton hca;
    private com.baidu.tieba.frs.profession.permission.c hcb;
    private FragmentTabHost mTabHost;
    private int hbX = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bQk();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hbW != null && FrsTabHostFragment.this.hbW.getForum() != null) {
                        str = FrsTabHostFragment.this.hbW.getForum().getId();
                    }
                    FrsTabHostFragment.this.CV(str);
                }
            }
        }
    };
    private c.a hcc = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mF(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void u(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.tw(1);
            } else if (z) {
                FrsTabHostFragment.this.tw(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.tw(-1);
            } else {
                FrsTabHostFragment.this.bQl();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mG(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.gXv = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gCM = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gCM);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.cSk = new FrameLayout(this.gCM.getActivity());
            this.cSk.setClipChildren(false);
            this.cSk.setClipToPadding(false);
            this.cSk.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bQh());
        }
        return this.cSk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eTE = new com.baidu.tieba.ueg.d(this.gCM.getPageContext());
        this.hcb = new com.baidu.tieba.frs.profession.permission.c(this.gCM.getPageContext());
        this.hcb.a(this.hcc);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.hbV = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ag agVar) {
        if (mVar != null && agVar != null && this.mTabHost != null) {
            this.hbW = mVar;
            this.hbU = agVar;
            this.hbU.bQw();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hbU.bOb())) {
                List<com.baidu.tbadk.mainTab.b> bOb = this.hbU.bOb();
                List<FrsTabInfo> bOa = this.hbU.bOa();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bOa.size() == bOb.size()) {
                    int size = bOa.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bOb.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bOa.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.gCM.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bOb) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.gCM.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int tt = tt(this.hbX);
                if (tt < 0) {
                    tt = tt(this.hbW.getGameDefaultTabId());
                }
                if (tt < 0) {
                    tt = bQi();
                }
                if (tt < 0) {
                    tt = 0;
                }
                this.hbX = tt;
                this.hbY = tt;
                this.gXv.tx(this.hbX);
                this.gXv.uh(this.hbY);
                this.mTabHost.setCurrentTab(tt);
                int tv2 = tv(tt);
                if (tv2 != 1) {
                    if (this.hbV != null) {
                        this.hbV.mt(false);
                        if (tv2 != 4 && tv2 != 25) {
                            this.hbV.ms(false);
                            this.gYx.setVisibility(8);
                            this.hbV.bOV();
                        }
                    }
                    if (this.hbW.getForum() != null) {
                        com.baidu.tieba.frs.e.e Dx = com.baidu.tieba.frs.e.d.bUF().Dx(this.hbW.getForum().getName());
                        if (tv2 == 25) {
                            if (Dx == null) {
                                Dx = new com.baidu.tieba.frs.e.e(null);
                            }
                            Dx.nn(true);
                            com.baidu.tieba.frs.e.d.bUF().a(this.hbW.getForum().getName(), Dx);
                        } else if (Dx != null && Dx.bUI()) {
                            Dx.nn(false);
                            com.baidu.tieba.frs.e.d.bUF().a(this.hbW.getForum().getName(), Dx);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hbW != null && this.hbW.getForum() != null) {
            ForumData forum = this.hbW.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gCM, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gCM.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gCM, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gCM.getActivity(), R.dimen.tbds12));
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
            bVar2.dxJ = tbFragmentTabIndicator;
            bVar2.dxK = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bQh() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int tv2 = FrsTabHostFragment.this.tv(i);
                if (tv2 != 1) {
                    FrsTabHostFragment.this.hbV.bOV();
                } else {
                    FrsTabHostFragment.this.hbV.bOW();
                }
                if (tv2 == 1) {
                    if (FrsTabHostFragment.this.hbV != null) {
                        FrsTabHostFragment.this.hbV.ms(true);
                    }
                    FrsTabHostFragment.this.gYx.setVisibility(0);
                    return;
                }
                if (tv2 == 4 || tv2 == 25) {
                    if (FrsTabHostFragment.this.gYx.getVisibility() == 8) {
                        FrsTabHostFragment.this.gYx.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hbV != null) {
                        FrsTabHostFragment.this.hbV.ms(false);
                    }
                    FrsTabHostFragment.this.gYx.setVisibility(8);
                    FrsTabHostFragment.this.bQo();
                }
                if (FrsTabHostFragment.this.hbV != null) {
                    FrsTabHostFragment.this.hbV.mt(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo tu = FrsTabHostFragment.this.tu(i);
                if (tu == null || tu.tab_type.intValue() != 11) {
                    FragmentTabHost.b kv = FrsTabHostFragment.this.mTabHost.kv(i);
                    if (FrsTabHostFragment.this.hbW != null && FrsTabHostFragment.this.hbW.getForum() != null) {
                        str = FrsTabHostFragment.this.hbW.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(kv, str);
                    if (kv.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gCM.getPageContext().getPageActivity());
                        return false;
                    }
                    if (kv.dxJ != null) {
                        kv.dxJ.aYp();
                    }
                    if (kv.dxJ.wS(String.valueOf(kv.mType)) != null) {
                        if (!(kv.dxJ.wS(String.valueOf(kv.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hbY == i) {
                                FrsTabHostFragment.this.b(kv);
                            }
                        } else {
                            kv.dxJ.wS(String.valueOf(kv.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(kv);
                        }
                    }
                    FrsTabHostFragment.this.hbY = i;
                    return true;
                }
                ba.aOV().a((TbPageContext<?>) FrsTabHostFragment.this.gCM.getPageContext(), new String[]{tu.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gCM.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gCM);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gCM.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.ebS = fragmentTabIndicator;
        aVar.offsetX = this.gCM.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hbZ != null) {
            this.hbZ.onChangeSkinType(i);
        }
    }

    private int tt(int i) {
        if (this.hbU == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hbU.bOa());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hbU.bOa().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo tu(int i) {
        if (this.hbU == null || i >= com.baidu.tbadk.core.util.v.getCount(this.hbU.bOa())) {
            return null;
        }
        return this.hbU.bOa().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tv(int i) {
        if (this.hbU != null && i < com.baidu.tbadk.core.util.v.getCount(this.hbU.bOa())) {
            return this.hbU.bOa().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int bQi() {
        if (this.hbU == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hbU.bOa());
        for (int i = 0; i < count; i++) {
            if (this.hbU.bOa().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").af("obj_locate", c(bVar)).cI("fid", str));
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

    public int bQj() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gCM.getResources().getColor(R.color.cp_bg_line_d_1) : this.gCM.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bQk() {
        if (bc.checkUpIsLogin(this.gCM) && !this.eTE.cZX() && !bQn()) {
            if (this.hbV.bOu().uW(502) != null) {
                this.hcb.aL(this.hbV.getForumId(), this.hbV.bOu().bVQ().tabId);
            } else {
                tw(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hbZ == null) {
            this.hbZ = new com.baidu.tieba.write.f(this.gCM.getPageContext(), this.cSk, "frs");
            this.hbZ.Mu("2");
        }
        ForumWriteData bPb = this.hbV.bPb();
        bPb.setDefaultZone(i);
        this.hbZ.EM(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hbZ.a(bPb);
        this.hbZ.EL(bQj());
        UtilHelper.setNavigationBarBackground(this.gCM, bQj());
        this.hbZ.a(false, (View) null, (View) this.gYx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQl() {
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
        if (this.hbV != null && this.hbV.bOX() != null && (forum = this.hbV.bOX().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hbV.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CV(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").af("obj_locate", c(this.mTabHost.kv(this.mTabHost.getCurrentTabIndex()))).cI("fid", str));
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

    public FragmentTabHost bQm() {
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

    public boolean bQn() {
        if (this.hbV != null && this.hbV.isAdded() && this.hbV.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hbV.getPageContext(), this.hbV.bOX());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gYx = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hca = fRSRefreshButton;
    }

    public boolean bQa() {
        if (this.hbZ == null) {
            return false;
        }
        return this.hbZ.isShowing();
    }

    public void bQo() {
        if (this.hbZ != null && this.hbZ.isShowing()) {
            this.hbZ.uP(true);
        }
    }

    public FragmentTabHost.b kv(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.kv(i);
    }

    public void tx(int i) {
        this.hbX = i;
    }
}
