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
    private FrameLayout aht;
    private com.baidu.tieba.ueg.d fIl;
    private FrsTabController hRK;
    private OvalActionButton hSQ;
    private am hXd;
    private FrsFragment hXe;
    private com.baidu.tieba.tbadkCore.m hXf;
    private int hXh;
    private com.baidu.tieba.write.g hXi;
    private FRSRefreshButton hXj;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private BaseFragmentActivity hwQ;
    private FragmentTabHost mTabHost;
    private int hXg = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.cnP();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hXf != null && FrsTabHostFragment.this.hXf.getForum() != null) {
                        str = FrsTabHostFragment.this.hXf.getForum().getId();
                    }
                    FrsTabHostFragment.this.Ir(str);
                }
            }
        }
    };
    private c.a hXl = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ou(boolean z) {
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
                FrsTabHostFragment.this.cnQ();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ov(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hRK = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hwQ = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.hwQ);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.aht = new FrameLayout(this.hwQ.getActivity());
            this.aht.setClipChildren(false);
            this.aht.setClipToPadding(false);
            this.aht.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cnM());
        }
        return this.aht;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fIl = new com.baidu.tieba.ueg.d(this.hwQ.getPageContext());
        this.hXk = new com.baidu.tieba.frs.profession.permission.c(this.hwQ.getPageContext());
        this.hXk.a(this.hXl);
        super.onActivityCreated(bundle);
    }

    public void Z(FrsFragment frsFragment) {
        this.hXe = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, am amVar) {
        if (mVar != null && amVar != null && this.mTabHost != null) {
            this.hXf = mVar;
            this.hXd = amVar;
            this.hXd.cob();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.hXd.clx())) {
                List<com.baidu.tbadk.mainTab.b> clx = this.hXd.clx();
                List<FrsTabInfo> clw = this.hXd.clw();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (clw.size() == clx.size()) {
                    int size = clw.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = clx.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = clw.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.hwQ.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : clx) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.hwQ.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int xo = xo(this.hXg);
                if (xo < 0) {
                    xo = xo(this.hXf.getGameDefaultTabId());
                }
                if (xo < 0) {
                    xo = cnN();
                }
                if (xo < 0) {
                    xo = 0;
                }
                this.hXg = xo;
                this.hXh = xo;
                this.hRK.xs(this.hXg);
                this.hRK.ye(this.hXh);
                this.mTabHost.setCurrentTab(xo);
                int xq = xq(xo);
                if (xq != 1) {
                    if (this.hXe != null) {
                        this.hXe.oi(false);
                        if (xq != 4 && xq != 25) {
                            this.hXe.oh(false);
                            this.hSQ.setVisibility(8);
                            this.hXe.cmu();
                        }
                    }
                    if (this.hXf.getForum() != null) {
                        com.baidu.tieba.frs.e.e IV = com.baidu.tieba.frs.e.d.csG().IV(this.hXf.getForum().getName());
                        if (xq == 25) {
                            if (IV == null) {
                                IV = new com.baidu.tieba.frs.e.e(null);
                            }
                            IV.pd(true);
                            com.baidu.tieba.frs.e.d.csG().a(this.hXf.getForum().getName(), IV);
                        } else if (IV != null && IV.csJ()) {
                            IV.pd(false);
                            com.baidu.tieba.frs.e.d.csG().a(this.hXf.getForum().getName(), IV);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hXf != null && this.hXf.getForum() != null) {
            ForumData forum = this.hXf.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.hwQ, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hwQ.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.hwQ, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.hwQ.getActivity(), R.dimen.tbds12));
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
            bVar2.eiD = tbFragmentTabIndicator;
            bVar2.eiE = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cnM() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int xq = FrsTabHostFragment.this.xq(i);
                if (xq != 1) {
                    FrsTabHostFragment.this.hXe.cmu();
                } else {
                    FrsTabHostFragment.this.hXe.cmv();
                }
                if (xq == 1) {
                    if (FrsTabHostFragment.this.hXe != null) {
                        FrsTabHostFragment.this.hXe.oh(true);
                    }
                    FrsTabHostFragment.this.hSQ.setVisibility(0);
                    return;
                }
                if (xq == 4 || xq == 25) {
                    if (FrsTabHostFragment.this.hSQ.getVisibility() == 8) {
                        FrsTabHostFragment.this.hSQ.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hXe != null) {
                        FrsTabHostFragment.this.hXe.oh(false);
                    }
                    FrsTabHostFragment.this.hSQ.setVisibility(8);
                    FrsTabHostFragment.this.cnT();
                }
                if (FrsTabHostFragment.this.hXe != null) {
                    FrsTabHostFragment.this.hXe.oi(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo xp = FrsTabHostFragment.this.xp(i);
                if (xp == null || xp.tab_type.intValue() != 11) {
                    FragmentTabHost.b nL = FrsTabHostFragment.this.mTabHost.nL(i);
                    if (FrsTabHostFragment.this.hXf != null && FrsTabHostFragment.this.hXf.getForum() != null) {
                        str = FrsTabHostFragment.this.hXf.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(nL, str);
                    if (nL.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsTabHostFragment.this.hwQ.getPageContext().getPageActivity());
                        return false;
                    }
                    if (nL.eiD != null) {
                        nL.eiD.btb();
                    }
                    if (nL.eiD.Co(String.valueOf(nL.mType)) != null) {
                        if (!(nL.eiD.Co(String.valueOf(nL.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hXh == i) {
                                FrsTabHostFragment.this.b(nL);
                            }
                        } else {
                            nL.eiD.Co(String.valueOf(nL.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(nL);
                        }
                    }
                    FrsTabHostFragment.this.hXh = i;
                    return true;
                }
                com.baidu.tbadk.core.util.be.bju().a((TbPageContext<?>) FrsTabHostFragment.this.hwQ.getPageContext(), new String[]{xp.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.hwQ.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.hwQ);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.hwQ.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.ePQ = fragmentTabIndicator;
        aVar.offsetX = this.hwQ.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hXi != null) {
            this.hXi.onChangeSkinType(i);
        }
    }

    private int xo(int i) {
        if (this.hXd == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.hXd.clw());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hXd.clw().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo xp(int i) {
        if (this.hXd == null || i >= com.baidu.tbadk.core.util.y.getCount(this.hXd.clw())) {
            return null;
        }
        return this.hXd.clw().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xq(int i) {
        if (this.hXd != null && i < com.baidu.tbadk.core.util.y.getCount(this.hXd.clw())) {
            return this.hXd.clw().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cnN() {
        if (this.hXd == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.hXd.clw());
        for (int i = 0; i < count; i++) {
            if (this.hXd.clw().get(i).tab_id.intValue() == 1) {
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

    public int cnO() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.hwQ.getResources().getColor(R.color.cp_bg_line_d_1) : this.hwQ.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void cnP() {
        if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(this.hwQ) && !this.fIl.dAr() && !cnS()) {
            if (this.hXe.clQ().yV(502) != null) {
                this.hXk.aN(this.hXe.getForumId(), this.hXe.clQ().ctT().tabId);
            } else {
                xr(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.hXi == null) {
            this.hXi = new com.baidu.tieba.write.g(this.hwQ.getPageContext(), this.aht, "frs");
            this.hXi.Sy("2");
            ItemInfo itemInfo = this.hXe.cmw().itemInfo;
            this.hXi.wZ((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.at.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.hXe.cmw().getAnti() != null) {
            this.hXi.setCanGoods(this.hXe.cmw().getAnti().getCanGoods());
        }
        ForumWriteData cmA = this.hXe.cmA();
        cmA.setDefaultZone(i);
        this.hXi.Jv(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hXi.a(cmA);
        this.hXi.b(this.hXe.cmw().itemInfo);
        this.hXi.Ju(cnO());
        if (this.hXe != null && this.hXe.cmw() != null) {
            this.hXi.b(this.hXe.cmw().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.hwQ, cnO());
        this.hXi.a(false, (View) null, (View) this.hSQ);
        if (this.hXe != null && this.hXe.cmw() != null && this.hXe.cmw().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13721").dD("fid", this.hXe.getForumId()).dD("fname", this.hXe.getForumName()).dD("obj_param1", this.hXe.cmw().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
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
        if (this.hXe != null && this.hXe.cmw() != null && (forum = this.hXe.cmw().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hXe.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir(String str) {
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

    public FragmentTabHost cnR() {
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

    public boolean cnS() {
        if (this.hXe != null && this.hXe.isAdded() && this.hXe.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hXe.getPageContext(), this.hXe.cmw());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hSQ = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hXj = fRSRefreshButton;
    }

    public boolean cnD() {
        if (this.hXi == null) {
            return false;
        }
        return this.hXi.isShowing();
    }

    public void cnT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.hXi != null && this.hXi.isShowing()) {
            this.hXi.xa(true);
        }
    }

    public FragmentTabHost.b nL(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.nL(i);
    }

    public void xs(int i) {
        this.hXg = i;
    }
}
