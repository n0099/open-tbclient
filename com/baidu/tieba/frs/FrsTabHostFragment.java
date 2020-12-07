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
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes22.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ajk;
    private com.baidu.tieba.ueg.d gvD;
    private FrsTabController iRQ;
    private OvalActionButton iSW;
    private al iXh;
    private FrsFragment iXi;
    private com.baidu.tieba.tbadkCore.m iXj;
    private int iXl;
    private com.baidu.tieba.write.g iXm;
    private FRSRefreshButton iXn;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private BaseFragmentActivity ixc;
    private FragmentTabHost mTabHost;
    private int iXk = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.cEc();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.iXj != null && FrsTabHostFragment.this.iXj.getForum() != null) {
                        str = FrsTabHostFragment.this.iXj.getForum().getId();
                    }
                    FrsTabHostFragment.this.KK(str);
                }
            }
        }
    };
    private c.a iXp = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qi(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.Af(1);
            } else if (z) {
                FrsTabHostFragment.this.Af(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.Af(-1);
            } else {
                FrsTabHostFragment.this.cEd();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qj(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.iRQ = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.ixc = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.ixc);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ajk = new FrameLayout(this.ixc.getActivity());
            this.ajk.setClipChildren(false);
            this.ajk.setClipToPadding(false);
            this.ajk.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cDZ());
        }
        return this.ajk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.gvD = new com.baidu.tieba.ueg.d(this.ixc.getPageContext());
        this.iXo = new com.baidu.tieba.frs.profession.permission.c(this.ixc.getPageContext());
        this.iXo.a(this.iXp);
        super.onActivityCreated(bundle);
    }

    public void Y(FrsFragment frsFragment) {
        this.iXi = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, al alVar) {
        if (mVar != null && alVar != null && this.mTabHost != null) {
            this.iXj = mVar;
            this.iXh = alVar;
            this.iXh.cEo();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.iXh.cBJ())) {
                List<com.baidu.tbadk.mainTab.b> cBJ = this.iXh.cBJ();
                List<FrsTabInfo> bBY = this.iXh.bBY();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bBY.size() == cBJ.size()) {
                    int size = bBY.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cBJ.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bBY.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.ixc.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cBJ) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.ixc.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int Ac = Ac(this.iXk);
                if (Ac < 0) {
                    Ac = Ac(this.iXj.getGameDefaultTabId());
                }
                if (Ac < 0) {
                    Ac = cEa();
                }
                if (Ac < 0) {
                    Ac = 0;
                }
                this.iXk = Ac;
                this.iXl = Ac;
                this.iRQ.Ag(this.iXk);
                this.iRQ.Bb(this.iXl);
                this.mTabHost.setCurrentTab(Ac);
                int Ae = Ae(Ac);
                if (Ae != 1) {
                    if (this.iXi != null) {
                        this.iXi.pW(false);
                        if (Ae != 4 && Ae != 25) {
                            this.iXi.pV(false);
                            this.iSW.setVisibility(8);
                            this.iXi.cCH();
                        }
                    }
                    if (this.iXj.getForum() != null) {
                        com.baidu.tieba.frs.e.e LF = com.baidu.tieba.frs.e.d.cJT().LF(this.iXj.getForum().getName());
                        if (Ae == 25) {
                            if (LF == null) {
                                LF = new com.baidu.tieba.frs.e.e(null);
                            }
                            LF.qV(true);
                            com.baidu.tieba.frs.e.d.cJT().a(this.iXj.getForum().getName(), LF);
                        } else if (LF != null && LF.cJW()) {
                            LF.qV(false);
                            com.baidu.tieba.frs.e.d.cJT().a(this.iXj.getForum().getName(), LF);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.iXj != null && this.iXj.getForum() != null) {
            ForumData forum = this.iXj.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.ixc, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.ixc.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.ixc, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.ixc.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.au.getChineseAndEnglishLength(str) > 8) {
                    str = com.baidu.tbadk.core.util.au.subString(str, 8);
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
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
            if (cVar.showIconType != com.baidu.tbadk.mainTab.c.SHOWICON || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.eRD = tbFragmentTabIndicator;
            bVar2.eRE = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cDZ() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int Ae = FrsTabHostFragment.this.Ae(i);
                if (Ae != 1) {
                    FrsTabHostFragment.this.iXi.cCH();
                } else {
                    FrsTabHostFragment.this.iXi.cCI();
                }
                if (Ae == 1) {
                    if (FrsTabHostFragment.this.iXi != null) {
                        FrsTabHostFragment.this.iXi.pV(true);
                    }
                    FrsTabHostFragment.this.iSW.setVisibility(0);
                    return;
                }
                if (Ae == 4 || Ae == 25) {
                    if (FrsTabHostFragment.this.iSW.getVisibility() == 8) {
                        FrsTabHostFragment.this.iSW.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.iXi != null) {
                        FrsTabHostFragment.this.iXi.pV(false);
                    }
                    FrsTabHostFragment.this.iSW.setVisibility(8);
                    FrsTabHostFragment.this.cEg();
                }
                if (FrsTabHostFragment.this.iXi != null) {
                    FrsTabHostFragment.this.iXi.pW(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo Ad = FrsTabHostFragment.this.Ad(i);
                if (Ad == null || Ad.tab_type.intValue() != 11) {
                    FragmentTabHost.b pL = FrsTabHostFragment.this.mTabHost.pL(i);
                    if (FrsTabHostFragment.this.iXj != null && FrsTabHostFragment.this.iXj.getForum() != null) {
                        str = FrsTabHostFragment.this.iXj.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(pL, str);
                    if (pL.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bh.skipToLoginActivity(FrsTabHostFragment.this.ixc.getPageContext().getPageActivity());
                        return false;
                    }
                    if (pL.eRD != null) {
                        pL.eRD.bEa();
                    }
                    if (pL.eRD.El(String.valueOf(pL.mType)) != null) {
                        if (!(pL.eRD.El(String.valueOf(pL.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.iXl == i) {
                                FrsTabHostFragment.this.b(pL);
                            }
                        } else {
                            pL.eRD.El(String.valueOf(pL.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(pL);
                        }
                    }
                    FrsTabHostFragment.this.iXl = i;
                    return true;
                }
                com.baidu.tbadk.core.util.bf.bua().a((TbPageContext<?>) FrsTabHostFragment.this.ixc.getPageContext(), new String[]{Ad.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.ixc.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.ixc);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.ixc.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.fAk = fragmentTabIndicator;
        aVar.offsetX = this.ixc.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.iXm != null) {
            this.iXm.onChangeSkinType(i);
        }
    }

    private int Ac(int i) {
        if (this.iXh == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.iXh.bBY());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iXh.bBY().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo Ad(int i) {
        if (this.iXh == null || i >= com.baidu.tbadk.core.util.y.getCount(this.iXh.bBY())) {
            return null;
        }
        return this.iXh.bBY().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ae(int i) {
        if (this.iXh != null && i < com.baidu.tbadk.core.util.y.getCount(this.iXh.bBY())) {
            return this.iXh.bBY().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cEa() {
        if (this.iXh == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.iXh.bBY());
        for (int i = 0; i < count; i++) {
            if (this.iXh.bBY().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12334").al("obj_locate", c(bVar)).dY("fid", str));
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

    public int cEb() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.ixc.getResources().getColor(R.color.CAM_X0201_1) : this.ixc.getResources().getColor(R.color.CAM_X0201);
    }

    public void cEc() {
        if (bh.checkUpIsLogin(this.ixc) && !this.gvD.dTh() && !cEf()) {
            if (this.iXi.cCc().BR(502) != null) {
                this.iXo.aR(this.iXi.getForumId(), this.iXi.cCc().cLm().tabId);
            } else {
                Af(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Af(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.iXm == null) {
            this.iXm = new com.baidu.tieba.write.g(this.ixc.getPageContext(), this.ajk, "frs");
            this.iXm.VC("2");
            ItemInfo itemInfo = this.iXi.cCJ().itemInfo;
            this.iXm.zd((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.au.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.iXi.cCJ().getAnti() != null) {
            this.iXm.setCanGoods(this.iXi.cCJ().getAnti().getCanGoods());
        }
        ForumWriteData cCN = this.iXi.cCN();
        cCN.setDefaultZone(i);
        this.iXm.MF(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.iXm.a(cCN);
        this.iXm.b(this.iXi.cCJ().itemInfo);
        this.iXm.ME(cEb());
        if (this.iXi != null && this.iXi.cCJ() != null) {
            this.iXm.b(this.iXi.cCJ().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.ixc, cEb());
        this.iXm.a(false, (View) null, (View) this.iSW);
        if (this.iXi != null && this.iXi.cCJ() != null && this.iXi.cCJ().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13721").dY("fid", this.iXi.getForumId()).dY("fname", this.iXi.getForumName()).dY("obj_param1", this.iXi.cCJ().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEd() {
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
        if (this.iXi != null && this.iXi.cCJ() != null && (forum = this.iXi.cCJ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iXi.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12342").al("obj_locate", c(this.mTabHost.pL(this.mTabHost.getCurrentTabIndex()))).dY("fid", str));
        }
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13604");
        if (getPageContext() != null) {
            com.baidu.tbadk.pageInfo.c.a(getPageContext().getPageActivity(), arVar);
        }
        TiebaStatic.log(arVar);
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

    public FragmentTabHost cEe() {
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

    public boolean cEf() {
        if (this.iXi != null && this.iXi.isAdded() && this.iXi.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.iXi.getPageContext(), this.iXi.cCJ());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iSW = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.iXn = fRSRefreshButton;
    }

    public boolean cDP() {
        if (this.iXm == null) {
            return false;
        }
        return this.iXm.isShowing();
    }

    public void cEg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.iXm != null && this.iXm.isShowing()) {
            this.iXm.ze(true);
        }
    }

    public FragmentTabHost.b pL(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.pL(i);
    }

    public void Ag(int i) {
        this.iXk = i;
    }
}
