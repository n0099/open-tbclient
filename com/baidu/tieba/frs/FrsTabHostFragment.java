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
/* loaded from: classes16.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ahv;
    private com.baidu.tieba.ueg.d fIp;
    private FrsTabController hRQ;
    private OvalActionButton hSW;
    private am hXj;
    private FrsFragment hXk;
    private com.baidu.tieba.tbadkCore.m hXl;
    private int hXn;
    private com.baidu.tieba.write.g hXo;
    private FRSRefreshButton hXp;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private BaseFragmentActivity hwW;
    private FragmentTabHost mTabHost;
    private int hXm = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.cnQ();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hXl != null && FrsTabHostFragment.this.hXl.getForum() != null) {
                        str = FrsTabHostFragment.this.hXl.getForum().getId();
                    }
                    FrsTabHostFragment.this.Is(str);
                }
            }
        }
    };
    private c.a hXr = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ow(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.xr(1);
            } else if (z) {
                FrsTabHostFragment.this.xr(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.xr(-1);
            } else {
                FrsTabHostFragment.this.cnR();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ox(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hRQ = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hwW = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.hwW);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ahv = new FrameLayout(this.hwW.getActivity());
            this.ahv.setClipChildren(false);
            this.ahv.setClipToPadding(false);
            this.ahv.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cnN());
        }
        return this.ahv;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fIp = new com.baidu.tieba.ueg.d(this.hwW.getPageContext());
        this.hXq = new com.baidu.tieba.frs.profession.permission.c(this.hwW.getPageContext());
        this.hXq.a(this.hXr);
        super.onActivityCreated(bundle);
    }

    public void Z(FrsFragment frsFragment) {
        this.hXk = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, am amVar) {
        if (mVar != null && amVar != null && this.mTabHost != null) {
            this.hXl = mVar;
            this.hXj = amVar;
            this.hXj.coc();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hXj.cly())) {
                List<com.baidu.tbadk.mainTab.b> cly = this.hXj.cly();
                List<FrsTabInfo> clx = this.hXj.clx();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (clx.size() == cly.size()) {
                    int size = clx.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cly.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = clx.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.hwW.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cly) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.hwW.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int xo = xo(this.hXm);
                if (xo < 0) {
                    xo = xo(this.hXl.getGameDefaultTabId());
                }
                if (xo < 0) {
                    xo = cnO();
                }
                if (xo < 0) {
                    xo = 0;
                }
                this.hXm = xo;
                this.hXn = xo;
                this.hRQ.xs(this.hXm);
                this.hRQ.ye(this.hXn);
                this.mTabHost.setCurrentTab(xo);
                int xq = xq(xo);
                if (xq != 1) {
                    if (this.hXk != null) {
                        this.hXk.ok(false);
                        if (xq != 4 && xq != 25) {
                            this.hXk.oj(false);
                            this.hSW.setVisibility(8);
                            this.hXk.cmv();
                        }
                    }
                    if (this.hXl.getForum() != null) {
                        com.baidu.tieba.frs.e.e IW = com.baidu.tieba.frs.e.d.csH().IW(this.hXl.getForum().getName());
                        if (xq == 25) {
                            if (IW == null) {
                                IW = new com.baidu.tieba.frs.e.e(null);
                            }
                            IW.pf(true);
                            com.baidu.tieba.frs.e.d.csH().a(this.hXl.getForum().getName(), IW);
                        } else if (IW != null && IW.csK()) {
                            IW.pf(false);
                            com.baidu.tieba.frs.e.d.csH().a(this.hXl.getForum().getName(), IW);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hXl != null && this.hXl.getForum() != null) {
            ForumData forum = this.hXl.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.hwW, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hwW.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.hwW, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.hwW.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.at.getChineseAndEnglishLength(str) > 8) {
                    str = com.baidu.tbadk.core.util.at.subString(str, 8);
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
            bVar2.eiH = tbFragmentTabIndicator;
            bVar2.eiI = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cnN() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int xq = FrsTabHostFragment.this.xq(i);
                if (xq != 1) {
                    FrsTabHostFragment.this.hXk.cmv();
                } else {
                    FrsTabHostFragment.this.hXk.cmw();
                }
                if (xq == 1) {
                    if (FrsTabHostFragment.this.hXk != null) {
                        FrsTabHostFragment.this.hXk.oj(true);
                    }
                    FrsTabHostFragment.this.hSW.setVisibility(0);
                    return;
                }
                if (xq == 4 || xq == 25) {
                    if (FrsTabHostFragment.this.hSW.getVisibility() == 8) {
                        FrsTabHostFragment.this.hSW.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hXk != null) {
                        FrsTabHostFragment.this.hXk.oj(false);
                    }
                    FrsTabHostFragment.this.hSW.setVisibility(8);
                    FrsTabHostFragment.this.cnU();
                }
                if (FrsTabHostFragment.this.hXk != null) {
                    FrsTabHostFragment.this.hXk.ok(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo xp = FrsTabHostFragment.this.xp(i);
                if (xp == null || xp.tab_type.intValue() != 11) {
                    FragmentTabHost.b nL = FrsTabHostFragment.this.mTabHost.nL(i);
                    if (FrsTabHostFragment.this.hXl != null && FrsTabHostFragment.this.hXl.getForum() != null) {
                        str = FrsTabHostFragment.this.hXl.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(nL, str);
                    if (nL.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsTabHostFragment.this.hwW.getPageContext().getPageActivity());
                        return false;
                    }
                    if (nL.eiH != null) {
                        nL.eiH.btc();
                    }
                    if (nL.eiH.Cp(String.valueOf(nL.mType)) != null) {
                        if (!(nL.eiH.Cp(String.valueOf(nL.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hXn == i) {
                                FrsTabHostFragment.this.b(nL);
                            }
                        } else {
                            nL.eiH.Cp(String.valueOf(nL.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(nL);
                        }
                    }
                    FrsTabHostFragment.this.hXn = i;
                    return true;
                }
                com.baidu.tbadk.core.util.be.bju().a((TbPageContext<?>) FrsTabHostFragment.this.hwW.getPageContext(), new String[]{xp.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.hwW.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.hwW);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.hwW.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.ePU = fragmentTabIndicator;
        aVar.offsetX = this.hwW.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hXo != null) {
            this.hXo.onChangeSkinType(i);
        }
    }

    private int xo(int i) {
        if (this.hXj == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.hXj.clx());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hXj.clx().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo xp(int i) {
        if (this.hXj == null || i >= com.baidu.tbadk.core.util.y.getCount(this.hXj.clx())) {
            return null;
        }
        return this.hXj.clx().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xq(int i) {
        if (this.hXj != null && i < com.baidu.tbadk.core.util.y.getCount(this.hXj.clx())) {
            return this.hXj.clx().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cnO() {
        if (this.hXj == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.hXj.clx());
        for (int i = 0; i < count; i++) {
            if (this.hXj.clx().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12334").ai("obj_locate", c(bVar)).dD("fid", str));
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

    public int cnP() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.hwW.getResources().getColor(R.color.cp_bg_line_d_1) : this.hwW.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void cnQ() {
        if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(this.hwW) && !this.fIp.dAA() && !cnT()) {
            if (this.hXk.clR().yV(502) != null) {
                this.hXq.aN(this.hXk.getForumId(), this.hXk.clR().ctU().tabId);
            } else {
                xr(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.hXo == null) {
            this.hXo = new com.baidu.tieba.write.g(this.hwW.getPageContext(), this.ahv, "frs");
            this.hXo.Sy("2");
            ItemInfo itemInfo = this.hXk.cmx().itemInfo;
            this.hXo.xb((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.at.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.hXk.cmx().getAnti() != null) {
            this.hXo.setCanGoods(this.hXk.cmx().getAnti().getCanGoods());
        }
        ForumWriteData cmB = this.hXk.cmB();
        cmB.setDefaultZone(i);
        this.hXo.Jv(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hXo.a(cmB);
        this.hXo.b(this.hXk.cmx().itemInfo);
        this.hXo.Ju(cnP());
        if (this.hXk != null && this.hXk.cmx() != null) {
            this.hXo.b(this.hXk.cmx().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.hwW, cnP());
        this.hXo.a(false, (View) null, (View) this.hSW);
        if (this.hXk != null && this.hXk.cmx() != null && this.hXk.cmx().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13721").dD("fid", this.hXk.getForumId()).dD("fname", this.hXk.getForumName()).dD("obj_param1", this.hXk.cmx().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
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
        if (this.hXk != null && this.hXk.cmx() != null && (forum = this.hXk.cmx().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hXk.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Is(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12342").ai("obj_locate", c(this.mTabHost.nL(this.mTabHost.getCurrentTabIndex()))).dD("fid", str));
        }
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13604");
        if (getPageContext() != null) {
            com.baidu.tbadk.pageInfo.c.a(getPageContext().getPageActivity(), aqVar);
        }
        TiebaStatic.log(aqVar);
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

    public FragmentTabHost cnS() {
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

    public boolean cnT() {
        if (this.hXk != null && this.hXk.isAdded() && this.hXk.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hXk.getPageContext(), this.hXk.cmx());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hSW = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hXp = fRSRefreshButton;
    }

    public boolean cnE() {
        if (this.hXo == null) {
            return false;
        }
        return this.hXo.isShowing();
    }

    public void cnU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.hXo != null && this.hXo.isShowing()) {
            this.hXo.xc(true);
        }
    }

    public FragmentTabHost.b nL(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.nL(i);
    }

    public void xs(int i) {
        this.hXm = i;
    }
}
