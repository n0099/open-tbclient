package com.baidu.tieba.frs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes2.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ajW;
    private com.baidu.tieba.ueg.d gGE;
    private BaseFragmentActivity iJr;
    private FrsTabController jee;
    private OvalActionButton jfj;
    private int jjA;
    private com.baidu.tieba.write.g jjB;
    private FRSRefreshButton jjC;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    private ai jjw;
    private FrsFragment jjx;
    private com.baidu.tieba.tbadkCore.m jjy;
    private FragmentTabHost mTabHost;
    private int jjz = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null && !WriteActivityConfig.isAsyncWriting()) {
                FrsTabHostFragment.this.cGZ();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.jjy != null && FrsTabHostFragment.this.jjy.getForum() != null) {
                        str = FrsTabHostFragment.this.jjy.getForum().getId();
                    }
                    FrsTabHostFragment.this.KI(str);
                }
            }
        }
    };
    private c.a jjE = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qG(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.Ar(1);
            } else if (z) {
                FrsTabHostFragment.this.Ar(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.Ar(-1);
            } else {
                FrsTabHostFragment.this.cHa();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qH(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.jee = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.iJr = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.iJr);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ajW = new FrameLayout(this.iJr.getActivity());
            this.ajW.setClipChildren(false);
            this.ajW.setClipToPadding(false);
            this.ajW.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cGW());
        }
        return this.ajW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.gGE = new com.baidu.tieba.ueg.d(this.iJr.getPageContext());
        this.jjD = new com.baidu.tieba.frs.profession.permission.c(this.iJr.getPageContext());
        this.jjD.a(this.jjE);
        super.onActivityCreated(bundle);
    }

    public void Y(FrsFragment frsFragment) {
        this.jjx = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ai aiVar) {
        if (mVar != null && aiVar != null && this.mTabHost != null) {
            this.jjy = mVar;
            this.jjw = aiVar;
            this.jjw.cHl();
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.jjw.cEE())) {
                List<com.baidu.tbadk.mainTab.b> cEE = this.jjw.cEE();
                List<FrsTabInfo> bEu = this.jjw.bEu();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bEu.size() == cEE.size()) {
                    int size = bEu.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cEE.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bEu.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.iJr.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cEE) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.iJr.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int Ao = Ao(this.jjz);
                if (Ao < 0) {
                    Ao = Ao(this.jjy.getGameDefaultTabId());
                }
                if (Ao < 0) {
                    Ao = cGX();
                }
                if (Ao < 0) {
                    Ao = 0;
                }
                this.jjz = Ao;
                this.jjA = Ao;
                this.jee.As(this.jjz);
                this.jee.Bn(this.jjA);
                this.mTabHost.setCurrentTab(Ao);
                int Aq = Aq(Ao);
                if (Aq != 1) {
                    if (this.jjx != null) {
                        this.jjx.qt(false);
                        if (Aq != 4 && Aq != 25) {
                            this.jjx.qs(false);
                            this.jfj.setVisibility(8);
                            this.jjx.cFD();
                        }
                    }
                    if (this.jjy.getForum() != null) {
                        com.baidu.tieba.frs.c.e LE = com.baidu.tieba.frs.c.d.cMW().LE(this.jjy.getForum().getName());
                        if (Aq == 25) {
                            if (LE == null) {
                                LE = new com.baidu.tieba.frs.c.e(null);
                            }
                            LE.rt(true);
                            com.baidu.tieba.frs.c.d.cMW().a(this.jjy.getForum().getName(), LE);
                        } else if (LE != null && LE.cMZ()) {
                            LE.rt(false);
                            com.baidu.tieba.frs.c.d.cMW().a(this.jjy.getForum().getName(), LE);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.jjy != null && this.jjy.getForum() != null) {
            ForumData forum = this.jjy.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.iJr, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iJr.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.iJr, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.iJr.getActivity(), R.dimen.tbds12));
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
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
            if (cVar.showIconType != com.baidu.tbadk.mainTab.c.SHOWICON || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.fbC = tbFragmentTabIndicator;
            bVar2.fbD = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cGW() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int Aq = FrsTabHostFragment.this.Aq(i);
                if (Aq != 1) {
                    FrsTabHostFragment.this.jjx.cFD();
                } else {
                    FrsTabHostFragment.this.jjx.cFE();
                }
                if (Aq == 1) {
                    if (FrsTabHostFragment.this.jjx != null) {
                        FrsTabHostFragment.this.jjx.qs(true);
                    }
                    FrsTabHostFragment.this.jfj.setVisibility(0);
                    return;
                }
                if (Aq == 4 || Aq == 25) {
                    if (FrsTabHostFragment.this.jfj.getVisibility() == 8) {
                        FrsTabHostFragment.this.jfj.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.jjx != null) {
                        FrsTabHostFragment.this.jjx.qs(false);
                    }
                    FrsTabHostFragment.this.jfj.setVisibility(8);
                    FrsTabHostFragment.this.cHd();
                }
                if (FrsTabHostFragment.this.jjx != null) {
                    FrsTabHostFragment.this.jjx.qt(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo Ap = FrsTabHostFragment.this.Ap(i);
                if (Ap == null || Ap.tab_type.intValue() != 11) {
                    FragmentTabHost.b pV = FrsTabHostFragment.this.mTabHost.pV(i);
                    if (FrsTabHostFragment.this.jjy != null && FrsTabHostFragment.this.jjy.getForum() != null) {
                        str = FrsTabHostFragment.this.jjy.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(pV, str);
                    if (pV.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bg.skipToLoginActivity(FrsTabHostFragment.this.iJr.getPageContext().getPageActivity());
                        return false;
                    }
                    if (pV.fbC != null) {
                        pV.fbC.bGv();
                    }
                    if (pV.fbC.Eh(String.valueOf(pV.mType)) != null) {
                        if (!(pV.fbC.Eh(String.valueOf(pV.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.jjA == i) {
                                FrsTabHostFragment.this.b(pV);
                            }
                        } else {
                            pV.fbC.Eh(String.valueOf(pV.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(pV);
                        }
                    }
                    FrsTabHostFragment.this.jjA = i;
                    return true;
                }
                be.bwv().a((TbPageContext<?>) FrsTabHostFragment.this.iJr.getPageContext(), new String[]{Ap.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.iJr.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.iJr);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.iJr.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.fJQ = fragmentTabIndicator;
        aVar.offsetX = this.iJr.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.jjB != null) {
            this.jjB.onChangeSkinType(i);
        }
    }

    private int Ao(int i) {
        if (this.jjw == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(this.jjw.bEu());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jjw.bEu().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo Ap(int i) {
        if (this.jjw == null || i >= com.baidu.tbadk.core.util.x.getCount(this.jjw.bEu())) {
            return null;
        }
        return this.jjw.bEu().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Aq(int i) {
        if (this.jjw != null && i < com.baidu.tbadk.core.util.x.getCount(this.jjw.bEu())) {
            return this.jjw.bEu().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cGX() {
        if (this.jjw == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(this.jjw.bEu());
        for (int i = 0; i < count; i++) {
            if (this.jjw.bEu().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12334").an("obj_locate", c(bVar)).dX("fid", str));
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

    public int cGY() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.iJr.getResources().getColor(R.color.CAM_X0201_1) : this.iJr.getResources().getColor(R.color.CAM_X0201);
    }

    public void cGZ() {
        if (bg.checkUpIsLogin(this.iJr) && !this.gGE.dTa() && !cHc()) {
            if (this.jjx.cEY().Cd(502) != null) {
                this.jjD.aZ(this.jjx.getForumId(), this.jjx.cEY().cOr().tabId);
            } else {
                Ar(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.jjB == null) {
            this.jjB = new com.baidu.tieba.write.g(this.iJr.getPageContext(), this.ajW, "frs");
            this.jjB.Vg("2");
            ItemInfo itemInfo = this.jjx.cFF().itemInfo;
            this.jjB.zd((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.at.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.jjx.cFF().getAnti() != null) {
            this.jjB.zf(this.jjx.cFF().getAnti().getCanGoods());
        }
        ForumWriteData cFJ = this.jjx.cFJ();
        cFJ.setDefaultZone(i);
        this.jjB.Ms(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.jjB.a(cFJ);
        this.jjB.b(this.jjx.cFF().itemInfo);
        this.jjB.Mr(cGY());
        if (this.jjx != null && this.jjx.cFF() != null) {
            this.jjB.b(this.jjx.cFF().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.iJr, cGY());
        this.jjB.a(false, (View) null, (View) this.jfj);
        if (this.jjx != null && this.jjx.cFF() != null && this.jjx.cFF().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13721").dX("fid", this.jjx.getForumId()).dX("fname", this.jjx.getForumName()).dX("obj_param1", this.jjx.cFF().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHa() {
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
        if (this.jjx != null && this.jjx.cFF() != null && (forum = this.jjx.cFF().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    String str11 = themeColorInfo.day.light_color;
                    str8 = themeColorInfo.day.dark_color;
                    if (skinType == 0) {
                        str9 = themeColorInfo.day.pattern_image;
                        str6 = str11;
                    } else {
                        str6 = str11;
                        str9 = null;
                    }
                } else {
                    str8 = null;
                    str6 = null;
                    str9 = null;
                }
                if (themeColorInfo.night != null) {
                    str4 = themeColorInfo.night.light_color;
                    String str12 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str3 = str12;
                        str10 = themeColorInfo.night.pattern_image;
                    } else {
                        str3 = str12;
                        str10 = str9;
                    }
                } else {
                    str3 = null;
                    str4 = null;
                    str10 = str9;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str13 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str13;
                        str5 = str8;
                        str7 = themeColorInfo.dark.pattern_image;
                    } else {
                        str = str13;
                        str5 = str8;
                        str7 = str10;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str5 = str8;
                    str7 = str10;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jjx.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12342").an("obj_locate", c(this.mTabHost.pV(this.mTabHost.getCurrentTabIndex()))).dX("fid", str));
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

    public FragmentTabHost cHb() {
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

    public boolean cHc() {
        if (this.jjx != null && this.jjx.isAdded() && this.jjx.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.jjx.getPageContext(), this.jjx.cFF());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jfj = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.jjC = fRSRefreshButton;
    }

    public boolean cGL() {
        if (this.jjB == null) {
            return false;
        }
        return this.jjB.isShowing();
    }

    public void cHd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.jjB != null && this.jjB.isShowing()) {
            this.jjB.ze(true);
        }
    }

    public FragmentTabHost.b pV(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.pV(i);
    }

    public void As(int i) {
        this.jjz = i;
    }
}
