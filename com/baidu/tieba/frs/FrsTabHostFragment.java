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
/* loaded from: classes9.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout agu;
    private com.baidu.tieba.ueg.d frL;
    private ak hDG;
    private FrsFragment hDH;
    private com.baidu.tieba.tbadkCore.m hDI;
    private int hDK;
    private com.baidu.tieba.write.g hDL;
    private FRSRefreshButton hDM;
    private com.baidu.tieba.frs.profession.permission.c hDN;
    private BaseFragmentActivity hep;
    private FrsTabController hyI;
    private OvalActionButton hzL;
    private FragmentTabHost mTabHost;
    private int hDJ = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.bZS();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.hDI != null && FrsTabHostFragment.this.hDI.getForum() != null) {
                        str = FrsTabHostFragment.this.hDI.getForum().getId();
                    }
                    FrsTabHostFragment.this.Ff(str);
                }
            }
        }
    };
    private c.a hDO = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.uI(1);
            } else if (z) {
                FrsTabHostFragment.this.uI(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.uI(-1);
            } else {
                FrsTabHostFragment.this.bZT();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nm(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.hyI = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hep = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.hep);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.agu = new FrameLayout(this.hep.getActivity());
            this.agu.setClipChildren(false);
            this.agu.setClipToPadding(false);
            this.agu.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(bZP());
        }
        return this.agu;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.frL = new com.baidu.tieba.ueg.d(this.hep.getPageContext());
        this.hDN = new com.baidu.tieba.frs.profession.permission.c(this.hep.getPageContext());
        this.hDN.a(this.hDO);
        super.onActivityCreated(bundle);
    }

    public void U(FrsFragment frsFragment) {
        this.hDH = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ak akVar) {
        if (mVar != null && akVar != null && this.mTabHost != null) {
            this.hDI = mVar;
            this.hDG = akVar;
            this.hDG.cae();
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.hDG.bXE())) {
                List<com.baidu.tbadk.mainTab.b> bXE = this.hDG.bXE();
                List<FrsTabInfo> bXD = this.hDG.bXD();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bXD.size() == bXE.size()) {
                    int size = bXD.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bXE.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bXD.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.hep.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bXE) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.hep.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int uF = uF(this.hDJ);
                if (uF < 0) {
                    uF = uF(this.hDI.getGameDefaultTabId());
                }
                if (uF < 0) {
                    uF = bZQ();
                }
                if (uF < 0) {
                    uF = 0;
                }
                this.hDJ = uF;
                this.hDK = uF;
                this.hyI.uJ(this.hDJ);
                this.hyI.vt(this.hDK);
                this.mTabHost.setCurrentTab(uF);
                int uH = uH(uF);
                if (uH != 1) {
                    if (this.hDH != null) {
                        this.hDH.mZ(false);
                        if (uH != 4 && uH != 25) {
                            this.hDH.mY(false);
                            this.hzL.setVisibility(8);
                            this.hDH.bYz();
                        }
                    }
                    if (this.hDI.getForum() != null) {
                        com.baidu.tieba.frs.e.e FH = com.baidu.tieba.frs.e.d.ceC().FH(this.hDI.getForum().getName());
                        if (uH == 25) {
                            if (FH == null) {
                                FH = new com.baidu.tieba.frs.e.e(null);
                            }
                            FH.nU(true);
                            com.baidu.tieba.frs.e.d.ceC().a(this.hDI.getForum().getName(), FH);
                        } else if (FH != null && FH.ceF()) {
                            FH.nU(false);
                            com.baidu.tieba.frs.e.d.ceC().a(this.hDI.getForum().getName(), FH);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.hDI != null && this.hDI.getForum() != null) {
            ForumData forum = this.hDI.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.hep, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hep.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.hep, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.hep.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.tbadk.core.util.ar.getChineseAndEnglishLength(str) > 8) {
                    str = com.baidu.tbadk.core.util.ar.subString(str, 8);
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
            bVar2.dSF = tbFragmentTabIndicator;
            bVar2.dSG = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a bZP() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int uH = FrsTabHostFragment.this.uH(i);
                if (uH != 1) {
                    FrsTabHostFragment.this.hDH.bYz();
                } else {
                    FrsTabHostFragment.this.hDH.bYA();
                }
                if (uH == 1) {
                    if (FrsTabHostFragment.this.hDH != null) {
                        FrsTabHostFragment.this.hDH.mY(true);
                    }
                    FrsTabHostFragment.this.hzL.setVisibility(0);
                    return;
                }
                if (uH == 4 || uH == 25) {
                    if (FrsTabHostFragment.this.hzL.getVisibility() == 8) {
                        FrsTabHostFragment.this.hzL.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.hDH != null) {
                        FrsTabHostFragment.this.hDH.mY(false);
                    }
                    FrsTabHostFragment.this.hzL.setVisibility(8);
                    FrsTabHostFragment.this.bZW();
                }
                if (FrsTabHostFragment.this.hDH != null) {
                    FrsTabHostFragment.this.hDH.mZ(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo uG = FrsTabHostFragment.this.uG(i);
                if (uG == null || uG.tab_type.intValue() != 11) {
                    FragmentTabHost.b ll = FrsTabHostFragment.this.mTabHost.ll(i);
                    if (FrsTabHostFragment.this.hDI != null && FrsTabHostFragment.this.hDI.getForum() != null) {
                        str = FrsTabHostFragment.this.hDI.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(ll, str);
                    if (ll.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        com.baidu.tbadk.core.util.be.skipToLoginActivity(FrsTabHostFragment.this.hep.getPageContext().getPageActivity());
                        return false;
                    }
                    if (ll.dSF != null) {
                        ll.dSF.bgE();
                    }
                    if (ll.dSF.yR(String.valueOf(ll.mType)) != null) {
                        if (!(ll.dSF.yR(String.valueOf(ll.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.hDK == i) {
                                FrsTabHostFragment.this.b(ll);
                            }
                        } else {
                            ll.dSF.yR(String.valueOf(ll.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(ll);
                        }
                    }
                    FrsTabHostFragment.this.hDK = i;
                    return true;
                }
                com.baidu.tbadk.core.util.bc.aWU().a((TbPageContext<?>) FrsTabHostFragment.this.hep.getPageContext(), new String[]{uG.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.hep.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.hep);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.hep.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.eyW = fragmentTabIndicator;
        aVar.offsetX = this.hep.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hDL != null) {
            this.hDL.onChangeSkinType(i);
        }
    }

    private int uF(int i) {
        if (this.hDG == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.w.getCount(this.hDG.bXD());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hDG.bXD().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo uG(int i) {
        if (this.hDG == null || i >= com.baidu.tbadk.core.util.w.getCount(this.hDG.bXD())) {
            return null;
        }
        return this.hDG.bXD().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uH(int i) {
        if (this.hDG != null && i < com.baidu.tbadk.core.util.w.getCount(this.hDG.bXD())) {
            return this.hDG.bXD().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int bZQ() {
        if (this.hDG == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.w.getCount(this.hDG.bXD());
        for (int i = 0; i < count; i++) {
            if (this.hDG.bXD().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12334").ag("obj_locate", c(bVar)).dk("fid", str));
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

    public int bZR() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.hep.getResources().getColor(R.color.cp_bg_line_d_1) : this.hep.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void bZS() {
        if (com.baidu.tbadk.core.util.be.checkUpIsLogin(this.hep) && !this.frL.dlI() && !bZV()) {
            if (this.hDH.bXX().wj(502) != null) {
                this.hDN.aL(this.hDH.getForumId(), this.hDH.bXX().cfP().tabId);
            } else {
                uI(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hDL == null) {
            this.hDL = new com.baidu.tieba.write.g(this.hep.getPageContext(), this.agu, "frs");
            this.hDL.OO("2");
            ItemInfo itemInfo = this.hDH.bYB().itemInfo;
            this.hDL.vG((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.ar.isEmpty(itemInfo.name)) ? false : true);
        }
        ForumWriteData bYF = this.hDH.bYF();
        bYF.setDefaultZone(i);
        this.hDL.GD(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hDL.a(bYF);
        this.hDL.b(this.hDH.bYB().itemInfo);
        this.hDL.GC(bZR());
        if (this.hDH != null && this.hDH.bYB() != null) {
            this.hDL.b(this.hDH.bYB().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.hep, bZR());
        this.hDL.a(false, (View) null, (View) this.hzL);
        if (this.hDH != null && this.hDH.bYB() != null && this.hDH.bYB().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13721").dk("fid", this.hDH.getForumId()).dk("fname", this.hDH.getForumName()).dk("obj_param1", this.hDH.bYB().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZT() {
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
        if (this.hDH != null && this.hDH.bYB() != null && (forum = this.hDH.bYB().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hDH.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ff(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12342").ag("obj_locate", c(this.mTabHost.ll(this.mTabHost.getCurrentTabIndex()))).dk("fid", str));
        }
        com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13604");
        if (getPageContext() != null) {
            com.baidu.tbadk.pageInfo.c.a(getPageContext().getPageActivity(), aoVar);
        }
        TiebaStatic.log(aoVar);
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

    public FragmentTabHost bZU() {
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

    public boolean bZV() {
        if (this.hDH != null && this.hDH.isAdded() && this.hDH.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.hDH.getPageContext(), this.hDH.bYB());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hzL = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.hDM = fRSRefreshButton;
    }

    public boolean bZI() {
        if (this.hDL == null) {
            return false;
        }
        return this.hDL.isShowing();
    }

    public void bZW() {
        if (this.hDL != null && this.hDL.isShowing()) {
            this.hDL.vH(true);
        }
    }

    public FragmentTabHost.b ll(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.ll(i);
    }

    public void uJ(int i) {
        this.hDJ = i;
    }
}
