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
import com.baidu.tbadk.core.util.bf;
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
    private FrameLayout agl;
    private com.baidu.tieba.ueg.d fwT;
    private FrsTabController hEw;
    private OvalActionButton hFA;
    private ak hJE;
    private FrsFragment hJF;
    private com.baidu.tieba.tbadkCore.m hJG;
    private int hJI;
    private com.baidu.tieba.write.g hJJ;
    private FRSRefreshButton hJK;
    private com.baidu.tieba.frs.profession.permission.c hJL;
    private BaseFragmentActivity hjZ;
    private FragmentTabHost mTabHost;
    private int hJH = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.cdq();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hJG != null && FrsTabHostFragment.this.hJG.getForum() != null) {
                        str = FrsTabHostFragment.this.hJG.getForum().getId();
                    }
                    FrsTabHostFragment.this.FQ(str);
                }
            }
        }
    };
    private c.a hJM = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nQ(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.va(1);
            } else if (z) {
                FrsTabHostFragment.this.va(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.va(-1);
            } else {
                FrsTabHostFragment.this.cdr();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nR(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hEw = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hjZ = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.hjZ);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.agl = new FrameLayout(this.hjZ.getActivity());
            this.agl.setClipChildren(false);
            this.agl.setClipToPadding(false);
            this.agl.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cdn());
        }
        return this.agl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fwT = new com.baidu.tieba.ueg.d(this.hjZ.getPageContext());
        this.hJL = new com.baidu.tieba.frs.profession.permission.c(this.hjZ.getPageContext());
        this.hJL.a(this.hJM);
        super.onActivityCreated(bundle);
    }

    public void Y(FrsFragment frsFragment) {
        this.hJF = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ak akVar) {
        if (mVar != null && akVar != null && this.mTabHost != null) {
            this.hJG = mVar;
            this.hJE = akVar;
            this.hJE.cdC();
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.hJE.cbb())) {
                List<com.baidu.tbadk.mainTab.b> cbb = this.hJE.cbb();
                List<FrsTabInfo> cba = this.hJE.cba();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (cba.size() == cbb.size()) {
                    int size = cba.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cbb.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = cba.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.hjZ.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cbb) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.hjZ.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int uX = uX(this.hJH);
                if (uX < 0) {
                    uX = uX(this.hJG.getGameDefaultTabId());
                }
                if (uX < 0) {
                    uX = cdo();
                }
                if (uX < 0) {
                    uX = 0;
                }
                this.hJH = uX;
                this.hJI = uX;
                this.hEw.vb(this.hJH);
                this.hEw.vL(this.hJI);
                this.mTabHost.setCurrentTab(uX);
                int uZ = uZ(uX);
                if (uZ != 1) {
                    if (this.hJF != null) {
                        this.hJF.nE(false);
                        if (uZ != 4 && uZ != 25) {
                            this.hJF.nD(false);
                            this.hFA.setVisibility(8);
                            this.hJF.cbX();
                        }
                    }
                    if (this.hJG.getForum() != null) {
                        com.baidu.tieba.frs.e.e Gt = com.baidu.tieba.frs.e.d.cic().Gt(this.hJG.getForum().getName());
                        if (uZ == 25) {
                            if (Gt == null) {
                                Gt = new com.baidu.tieba.frs.e.e(null);
                            }
                            Gt.oz(true);
                            com.baidu.tieba.frs.e.d.cic().a(this.hJG.getForum().getName(), Gt);
                        } else if (Gt != null && Gt.cif()) {
                            Gt.oz(false);
                            com.baidu.tieba.frs.e.d.cic().a(this.hJG.getForum().getName(), Gt);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hJG != null && this.hJG.getForum() != null) {
            ForumData forum = this.hJG.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.hjZ, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hjZ.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.hjZ, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.hjZ.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.as.getChineseAndEnglishLength(str) > 8) {
                    str = com.baidu.tbadk.core.util.as.subString(str, 8);
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
            bVar2.dYX = tbFragmentTabIndicator;
            bVar2.dYY = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cdn() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int uZ = FrsTabHostFragment.this.uZ(i);
                if (uZ != 1) {
                    FrsTabHostFragment.this.hJF.cbX();
                } else {
                    FrsTabHostFragment.this.hJF.cbY();
                }
                if (uZ == 1) {
                    if (FrsTabHostFragment.this.hJF != null) {
                        FrsTabHostFragment.this.hJF.nD(true);
                    }
                    FrsTabHostFragment.this.hFA.setVisibility(0);
                    return;
                }
                if (uZ == 4 || uZ == 25) {
                    if (FrsTabHostFragment.this.hFA.getVisibility() == 8) {
                        FrsTabHostFragment.this.hFA.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hJF != null) {
                        FrsTabHostFragment.this.hJF.nD(false);
                    }
                    FrsTabHostFragment.this.hFA.setVisibility(8);
                    FrsTabHostFragment.this.cdu();
                }
                if (FrsTabHostFragment.this.hJF != null) {
                    FrsTabHostFragment.this.hJF.nE(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo uY = FrsTabHostFragment.this.uY(i);
                if (uY == null || uY.tab_type.intValue() != 11) {
                    FragmentTabHost.b lF = FrsTabHostFragment.this.mTabHost.lF(i);
                    if (FrsTabHostFragment.this.hJG != null && FrsTabHostFragment.this.hJG.getForum() != null) {
                        str = FrsTabHostFragment.this.hJG.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(lF, str);
                    if (lF.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bf.skipToLoginActivity(FrsTabHostFragment.this.hjZ.getPageContext().getPageActivity());
                        return false;
                    }
                    if (lF.dYX != null) {
                        lF.dYX.bkp();
                    }
                    if (lF.dYX.zY(String.valueOf(lF.mType)) != null) {
                        if (!(lF.dYX.zY(String.valueOf(lF.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hJI == i) {
                                FrsTabHostFragment.this.b(lF);
                            }
                        } else {
                            lF.dYX.zY(String.valueOf(lF.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(lF);
                        }
                    }
                    FrsTabHostFragment.this.hJI = i;
                    return true;
                }
                com.baidu.tbadk.core.util.bd.baV().a((TbPageContext<?>) FrsTabHostFragment.this.hjZ.getPageContext(), new String[]{uY.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.hjZ.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.hjZ);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.hjZ.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.eFm = fragmentTabIndicator;
        aVar.offsetX = this.hjZ.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hJJ != null) {
            this.hJJ.onChangeSkinType(i);
        }
    }

    private int uX(int i) {
        if (this.hJE == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(this.hJE.cba());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hJE.cba().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo uY(int i) {
        if (this.hJE == null || i >= com.baidu.tbadk.core.util.x.getCount(this.hJE.cba())) {
            return null;
        }
        return this.hJE.cba().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uZ(int i) {
        if (this.hJE != null && i < com.baidu.tbadk.core.util.x.getCount(this.hJE.cba())) {
            return this.hJE.cba().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cdo() {
        if (this.hJE == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(this.hJE.cba());
        for (int i = 0; i < count; i++) {
            if (this.hJE.cba().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12334").ah("obj_locate", c(bVar)).dn("fid", str));
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

    public int cdp() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.hjZ.getResources().getColor(R.color.cp_bg_line_d_1) : this.hjZ.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void cdq() {
        if (bf.checkUpIsLogin(this.hjZ) && !this.fwT.doV() && !cdt()) {
            if (this.hJF.cbu().wB(502) != null) {
                this.hJL.aK(this.hJF.getForumId(), this.hJF.cbu().cjp().tabId);
            } else {
                va(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.hJJ == null) {
            this.hJJ = new com.baidu.tieba.write.g(this.hjZ.getPageContext(), this.agl, "frs");
            this.hJJ.PA("2");
            ItemInfo itemInfo = this.hJF.cbZ().itemInfo;
            this.hJJ.wk((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.as.isEmpty(itemInfo.name)) ? false : true);
        }
        ForumWriteData ccd = this.hJF.ccd();
        ccd.setDefaultZone(i);
        this.hJJ.GZ(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hJJ.a(ccd);
        this.hJJ.b(this.hJF.cbZ().itemInfo);
        this.hJJ.GY(cdp());
        if (this.hJF != null && this.hJF.cbZ() != null) {
            this.hJJ.b(this.hJF.cbZ().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.hjZ, cdp());
        this.hJJ.a(false, (View) null, (View) this.hFA);
        if (this.hJF != null && this.hJF.cbZ() != null && this.hJF.cbZ().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13721").dn("fid", this.hJF.getForumId()).dn("fname", this.hJF.getForumName()).dn("obj_param1", this.hJF.cbZ().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
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
        if (this.hJF != null && this.hJF.cbZ() != null && (forum = this.hJF.cbZ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hJF.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12342").ah("obj_locate", c(this.mTabHost.lF(this.mTabHost.getCurrentTabIndex()))).dn("fid", str));
        }
        com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13604");
        if (getPageContext() != null) {
            com.baidu.tbadk.pageInfo.c.a(getPageContext().getPageActivity(), apVar);
        }
        TiebaStatic.log(apVar);
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

    public FragmentTabHost cds() {
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

    public boolean cdt() {
        if (this.hJF != null && this.hJF.isAdded() && this.hJF.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hJF.getPageContext(), this.hJF.cbZ());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hFA = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hJK = fRSRefreshButton;
    }

    public boolean cdg() {
        if (this.hJJ == null) {
            return false;
        }
        return this.hJJ.isShowing();
    }

    public void cdu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.hJJ != null && this.hJJ.isShowing()) {
            this.hJJ.wl(true);
        }
    }

    public FragmentTabHost.b lF(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.lF(i);
    }

    public void vb(int i) {
        this.hJH = i;
    }
}
