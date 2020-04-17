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
    private FrameLayout cSf;
    private com.baidu.tieba.ueg.d eTz;
    private BaseFragmentActivity gCG;
    private FrsTabController gXp;
    private OvalActionButton gYr;
    private ag hbO;
    private FrsFragment hbP;
    private com.baidu.tieba.tbadkCore.m hbQ;
    private int hbS;
    private com.baidu.tieba.write.f hbT;
    private FRSRefreshButton hbU;
    private com.baidu.tieba.frs.profession.permission.c hbV;
    private FragmentTabHost mTabHost;
    private int hbR = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bQl();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hbQ != null && FrsTabHostFragment.this.hbQ.getForum() != null) {
                        str = FrsTabHostFragment.this.hbQ.getForum().getId();
                    }
                    FrsTabHostFragment.this.CS(str);
                }
            }
        }
    };
    private c.a hbW = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
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
                FrsTabHostFragment.this.bQm();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mG(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.gXp = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gCG = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.gCG);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.cSf = new FrameLayout(this.gCG.getActivity());
            this.cSf.setClipChildren(false);
            this.cSf.setClipToPadding(false);
            this.cSf.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bQi());
        }
        return this.cSf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.eTz = new com.baidu.tieba.ueg.d(this.gCG.getPageContext());
        this.hbV = new com.baidu.tieba.frs.profession.permission.c(this.gCG.getPageContext());
        this.hbV.a(this.hbW);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.hbP = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ag agVar) {
        if (mVar != null && agVar != null && this.mTabHost != null) {
            this.hbQ = mVar;
            this.hbO = agVar;
            this.hbO.bQx();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.hbO.bOc())) {
                List<com.baidu.tbadk.mainTab.b> bOc = this.hbO.bOc();
                List<FrsTabInfo> bOb = this.hbO.bOb();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bOb.size() == bOc.size()) {
                    int size = bOb.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bOc.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bOb.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.gCG.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bOc) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.gCG.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int tt = tt(this.hbR);
                if (tt < 0) {
                    tt = tt(this.hbQ.getGameDefaultTabId());
                }
                if (tt < 0) {
                    tt = bQj();
                }
                if (tt < 0) {
                    tt = 0;
                }
                this.hbR = tt;
                this.hbS = tt;
                this.gXp.tx(this.hbR);
                this.gXp.uh(this.hbS);
                this.mTabHost.setCurrentTab(tt);
                int tv2 = tv(tt);
                if (tv2 != 1) {
                    if (this.hbP != null) {
                        this.hbP.mt(false);
                        if (tv2 != 4 && tv2 != 25) {
                            this.hbP.ms(false);
                            this.gYr.setVisibility(8);
                            this.hbP.bOW();
                        }
                    }
                    if (this.hbQ.getForum() != null) {
                        com.baidu.tieba.frs.e.e Du = com.baidu.tieba.frs.e.d.bUG().Du(this.hbQ.getForum().getName());
                        if (tv2 == 25) {
                            if (Du == null) {
                                Du = new com.baidu.tieba.frs.e.e(null);
                            }
                            Du.nn(true);
                            com.baidu.tieba.frs.e.d.bUG().a(this.hbQ.getForum().getName(), Du);
                        } else if (Du != null && Du.bUJ()) {
                            Du.nn(false);
                            com.baidu.tieba.frs.e.d.bUG().a(this.hbQ.getForum().getName(), Du);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hbQ != null && this.hbQ.getForum() != null) {
            ForumData forum = this.hbQ.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.gCG, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gCG.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.gCG, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.gCG.getActivity(), R.dimen.tbds12));
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
            bVar2.dxF = tbFragmentTabIndicator;
            bVar2.dxG = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bQi() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int tv2 = FrsTabHostFragment.this.tv(i);
                if (tv2 != 1) {
                    FrsTabHostFragment.this.hbP.bOW();
                } else {
                    FrsTabHostFragment.this.hbP.bOX();
                }
                if (tv2 == 1) {
                    if (FrsTabHostFragment.this.hbP != null) {
                        FrsTabHostFragment.this.hbP.ms(true);
                    }
                    FrsTabHostFragment.this.gYr.setVisibility(0);
                    return;
                }
                if (tv2 == 4 || tv2 == 25) {
                    if (FrsTabHostFragment.this.gYr.getVisibility() == 8) {
                        FrsTabHostFragment.this.gYr.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hbP != null) {
                        FrsTabHostFragment.this.hbP.ms(false);
                    }
                    FrsTabHostFragment.this.gYr.setVisibility(8);
                    FrsTabHostFragment.this.bQp();
                }
                if (FrsTabHostFragment.this.hbP != null) {
                    FrsTabHostFragment.this.hbP.mt(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo tu = FrsTabHostFragment.this.tu(i);
                if (tu == null || tu.tab_type.intValue() != 11) {
                    FragmentTabHost.b kv = FrsTabHostFragment.this.mTabHost.kv(i);
                    if (FrsTabHostFragment.this.hbQ != null && FrsTabHostFragment.this.hbQ.getForum() != null) {
                        str = FrsTabHostFragment.this.hbQ.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(kv, str);
                    if (kv.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.gCG.getPageContext().getPageActivity());
                        return false;
                    }
                    if (kv.dxF != null) {
                        kv.dxF.aYr();
                    }
                    if (kv.dxF.wP(String.valueOf(kv.mType)) != null) {
                        if (!(kv.dxF.wP(String.valueOf(kv.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hbS == i) {
                                FrsTabHostFragment.this.b(kv);
                            }
                        } else {
                            kv.dxF.wP(String.valueOf(kv.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(kv);
                        }
                    }
                    FrsTabHostFragment.this.hbS = i;
                    return true;
                }
                ba.aOY().a((TbPageContext<?>) FrsTabHostFragment.this.gCG.getPageContext(), new String[]{tu.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.gCG.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.gCG);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.gCG.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.ebN = fragmentTabIndicator;
        aVar.offsetX = this.gCG.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hbT != null) {
            this.hbT.onChangeSkinType(i);
        }
    }

    private int tt(int i) {
        if (this.hbO == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hbO.bOb());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hbO.bOb().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo tu(int i) {
        if (this.hbO == null || i >= com.baidu.tbadk.core.util.v.getCount(this.hbO.bOb())) {
            return null;
        }
        return this.hbO.bOb().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tv(int i) {
        if (this.hbO != null && i < com.baidu.tbadk.core.util.v.getCount(this.hbO.bOb())) {
            return this.hbO.bOb().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int bQj() {
        if (this.hbO == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hbO.bOb());
        for (int i = 0; i < count; i++) {
            if (this.hbO.bOb().get(i).tab_id.intValue() == 1) {
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

    public int bQk() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.gCG.getResources().getColor(R.color.cp_bg_line_d_1) : this.gCG.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bQl() {
        if (bc.checkUpIsLogin(this.gCG) && !this.eTz.cZZ() && !bQo()) {
            if (this.hbP.bOv().uW(502) != null) {
                this.hbV.aL(this.hbP.getForumId(), this.hbP.bOv().bVR().tabId);
            } else {
                tw(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hbT == null) {
            this.hbT = new com.baidu.tieba.write.f(this.gCG.getPageContext(), this.cSf, "frs");
            this.hbT.Mr("2");
        }
        ForumWriteData bPc = this.hbP.bPc();
        bPc.setDefaultZone(i);
        this.hbT.EM(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hbT.a(bPc);
        this.hbT.EL(bQk());
        UtilHelper.setNavigationBarBackground(this.gCG, bQk());
        this.hbT.a(false, (View) null, (View) this.gYr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQm() {
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
        if (this.hbP != null && this.hbP.bOY() != null && (forum = this.hbP.bOY().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hbP.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS(String str) {
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

    public FragmentTabHost bQn() {
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

    public boolean bQo() {
        if (this.hbP != null && this.hbP.isAdded() && this.hbP.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hbP.getPageContext(), this.hbP.bOY());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gYr = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hbU = fRSRefreshButton;
    }

    public boolean bQb() {
        if (this.hbT == null) {
            return false;
        }
        return this.hbT.isShowing();
    }

    public void bQp() {
        if (this.hbT != null && this.hbT.isShowing()) {
            this.hbT.uP(true);
        }
    }

    public FragmentTabHost.b kv(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.kv(i);
    }

    public void tx(int i) {
        this.hbR = i;
    }
}
