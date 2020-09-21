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
/* loaded from: classes21.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ahP;
    private com.baidu.tieba.ueg.d fLE;
    private BaseFragmentActivity hEa;
    private FrsTabController hYQ;
    private OvalActionButton hZW;
    private am ien;
    private FrsFragment ieo;
    private com.baidu.tieba.tbadkCore.m iep;
    private int ier;
    private com.baidu.tieba.write.g ies;
    private FRSRefreshButton iet;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    private FragmentTabHost mTabHost;
    private int ieq = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.crd();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.iep != null && FrsTabHostFragment.this.iep.getForum() != null) {
                        str = FrsTabHostFragment.this.iep.getForum().getId();
                    }
                    FrsTabHostFragment.this.IP(str);
                }
            }
        }
    };
    private c.a iev = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.xQ(1);
            } else if (z) {
                FrsTabHostFragment.this.xQ(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.xQ(-1);
            } else {
                FrsTabHostFragment.this.cre();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oD(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hYQ = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hEa = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.hEa);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ahP = new FrameLayout(this.hEa.getActivity());
            this.ahP.setClipChildren(false);
            this.ahP.setClipToPadding(false);
            this.ahP.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cra());
        }
        return this.ahP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fLE = new com.baidu.tieba.ueg.d(this.hEa.getPageContext());
        this.ieu = new com.baidu.tieba.frs.profession.permission.c(this.hEa.getPageContext());
        this.ieu.a(this.iev);
        super.onActivityCreated(bundle);
    }

    public void Z(FrsFragment frsFragment) {
        this.ieo = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, am amVar) {
        if (mVar != null && amVar != null && this.mTabHost != null) {
            this.iep = mVar;
            this.ien = amVar;
            this.ien.crp();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ien.coK())) {
                List<com.baidu.tbadk.mainTab.b> coK = this.ien.coK();
                List<FrsTabInfo> bsg = this.ien.bsg();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bsg.size() == coK.size()) {
                    int size = bsg.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = coK.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bsg.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.hEa.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : coK) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.hEa.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int xN = xN(this.ieq);
                if (xN < 0) {
                    xN = xN(this.iep.getGameDefaultTabId());
                }
                if (xN < 0) {
                    xN = crb();
                }
                if (xN < 0) {
                    xN = 0;
                }
                this.ieq = xN;
                this.ier = xN;
                this.hYQ.xR(this.ieq);
                this.hYQ.yD(this.ier);
                this.mTabHost.setCurrentTab(xN);
                int xP = xP(xN);
                if (xP != 1) {
                    if (this.ieo != null) {
                        this.ieo.oq(false);
                        if (xP != 4 && xP != 25) {
                            this.ieo.op(false);
                            this.hZW.setVisibility(8);
                            this.ieo.cpH();
                        }
                    }
                    if (this.iep.getForum() != null) {
                        com.baidu.tieba.frs.e.e Ju = com.baidu.tieba.frs.e.d.cvW().Ju(this.iep.getForum().getName());
                        if (xP == 25) {
                            if (Ju == null) {
                                Ju = new com.baidu.tieba.frs.e.e(null);
                            }
                            Ju.pl(true);
                            com.baidu.tieba.frs.e.d.cvW().a(this.iep.getForum().getName(), Ju);
                        } else if (Ju != null && Ju.cvZ()) {
                            Ju.pl(false);
                            com.baidu.tieba.frs.e.d.cvW().a(this.iep.getForum().getName(), Ju);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.iep != null && this.iep.getForum() != null) {
            ForumData forum = this.iep.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.hEa, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hEa.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.hEa, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.hEa.getActivity(), R.dimen.tbds12));
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
            bVar2.ekW = tbFragmentTabIndicator;
            bVar2.ekX = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cra() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int xP = FrsTabHostFragment.this.xP(i);
                if (xP != 1) {
                    FrsTabHostFragment.this.ieo.cpH();
                } else {
                    FrsTabHostFragment.this.ieo.cpI();
                }
                if (xP == 1) {
                    if (FrsTabHostFragment.this.ieo != null) {
                        FrsTabHostFragment.this.ieo.op(true);
                    }
                    FrsTabHostFragment.this.hZW.setVisibility(0);
                    return;
                }
                if (xP == 4 || xP == 25) {
                    if (FrsTabHostFragment.this.hZW.getVisibility() == 8) {
                        FrsTabHostFragment.this.hZW.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.ieo != null) {
                        FrsTabHostFragment.this.ieo.op(false);
                    }
                    FrsTabHostFragment.this.hZW.setVisibility(8);
                    FrsTabHostFragment.this.crh();
                }
                if (FrsTabHostFragment.this.ieo != null) {
                    FrsTabHostFragment.this.ieo.oq(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo xO = FrsTabHostFragment.this.xO(i);
                if (xO == null || xO.tab_type.intValue() != 11) {
                    FragmentTabHost.b nX = FrsTabHostFragment.this.mTabHost.nX(i);
                    if (FrsTabHostFragment.this.iep != null && FrsTabHostFragment.this.iep.getForum() != null) {
                        str = FrsTabHostFragment.this.iep.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(nX, str);
                    if (nX.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsTabHostFragment.this.hEa.getPageContext().getPageActivity());
                        return false;
                    }
                    if (nX.ekW != null) {
                        nX.ekW.bug();
                    }
                    if (nX.ekW.CL(String.valueOf(nX.mType)) != null) {
                        if (!(nX.ekW.CL(String.valueOf(nX.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.ier == i) {
                                FrsTabHostFragment.this.b(nX);
                            }
                        } else {
                            nX.ekW.CL(String.valueOf(nX.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(nX);
                        }
                    }
                    FrsTabHostFragment.this.ier = i;
                    return true;
                }
                com.baidu.tbadk.core.util.be.bkp().a((TbPageContext<?>) FrsTabHostFragment.this.hEa.getPageContext(), new String[]{xO.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.hEa.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.hEa);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.hEa.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.eSL = fragmentTabIndicator;
        aVar.offsetX = this.hEa.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.ies != null) {
            this.ies.onChangeSkinType(i);
        }
    }

    private int xN(int i) {
        if (this.ien == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.ien.bsg());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.ien.bsg().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo xO(int i) {
        if (this.ien == null || i >= com.baidu.tbadk.core.util.y.getCount(this.ien.bsg())) {
            return null;
        }
        return this.ien.bsg().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xP(int i) {
        if (this.ien != null && i < com.baidu.tbadk.core.util.y.getCount(this.ien.bsg())) {
            return this.ien.bsg().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int crb() {
        if (this.ien == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.ien.bsg());
        for (int i = 0; i < count; i++) {
            if (this.ien.bsg().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12334").ai("obj_locate", c(bVar)).dF("fid", str));
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

    public int crc() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.hEa.getResources().getColor(R.color.cp_bg_line_d_1) : this.hEa.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void crd() {
        if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(this.hEa) && !this.fLE.dEu() && !crg()) {
            if (this.ieo.cpd().zt(502) != null) {
                this.ieu.aN(this.ieo.getForumId(), this.ieo.cpd().cxn().tabId);
            } else {
                xQ(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.ies == null) {
            this.ies = new com.baidu.tieba.write.g(this.hEa.getPageContext(), this.ahP, "frs");
            this.ies.SY("2");
            ItemInfo itemInfo = this.ieo.cpJ().itemInfo;
            this.ies.xk((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.at.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.ieo.cpJ().getAnti() != null) {
            this.ies.setCanGoods(this.ieo.cpJ().getAnti().getCanGoods());
        }
        ForumWriteData cpN = this.ieo.cpN();
        cpN.setDefaultZone(i);
        this.ies.JZ(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.ies.a(cpN);
        this.ies.b(this.ieo.cpJ().itemInfo);
        this.ies.JY(crc());
        if (this.ieo != null && this.ieo.cpJ() != null) {
            this.ies.b(this.ieo.cpJ().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.hEa, crc());
        this.ies.a(false, (View) null, (View) this.hZW);
        if (this.ieo != null && this.ieo.cpJ() != null && this.ieo.cpJ().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13721").dF("fid", this.ieo.getForumId()).dF("fname", this.ieo.getForumName()).dF("obj_param1", this.ieo.cpJ().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cre() {
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
        if (this.ieo != null && this.ieo.cpJ() != null && (forum = this.ieo.cpJ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.ieo.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12342").ai("obj_locate", c(this.mTabHost.nX(this.mTabHost.getCurrentTabIndex()))).dF("fid", str));
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

    public FragmentTabHost crf() {
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

    public boolean crg() {
        if (this.ieo != null && this.ieo.isAdded() && this.ieo.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.ieo.getPageContext(), this.ieo.cpJ());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hZW = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.iet = fRSRefreshButton;
    }

    public boolean cqQ() {
        if (this.ies == null) {
            return false;
        }
        return this.ies.isShowing();
    }

    public void crh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.ies != null && this.ies.isShowing()) {
            this.ies.xl(true);
        }
    }

    public FragmentTabHost.b nX(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.nX(i);
    }

    public void xR(int i) {
        this.ieq = i;
    }
}
