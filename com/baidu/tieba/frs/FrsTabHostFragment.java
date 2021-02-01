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
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes2.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout aiT;
    private com.baidu.tieba.ueg.d gEI;
    private BaseFragmentActivity iKt;
    private FrsTabController jfe;
    private OvalActionButton jgi;
    private com.baidu.tieba.write.g jkA;
    private FRSRefreshButton jkB;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    private ai jkv;
    private FrsFragment jkw;
    private com.baidu.tieba.tbadkCore.m jkx;
    private int jkz;
    private FragmentTabHost mTabHost;
    private int jky = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null && !WriteActivityConfig.isAsyncWriting()) {
                FrsTabHostFragment.this.cEt();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.jkx != null && FrsTabHostFragment.this.jkx.getForum() != null) {
                        str = FrsTabHostFragment.this.jkx.getForum().getId();
                    }
                    FrsTabHostFragment.this.Ki(str);
                }
            }
        }
    };
    private c.a jkD = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.yV(1);
            } else if (z) {
                FrsTabHostFragment.this.yV(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.yV(-1);
            } else {
                FrsTabHostFragment.this.cEu();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.jfe = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.iKt = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.iKt);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.aiT = new FrameLayout(this.iKt.getActivity());
            this.aiT.setClipChildren(false);
            this.aiT.setClipToPadding(false);
            this.aiT.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cEq());
        }
        return this.aiT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.gEI = new com.baidu.tieba.ueg.d(this.iKt.getPageContext());
        this.jkC = new com.baidu.tieba.frs.profession.permission.c(this.iKt.getPageContext());
        this.jkC.a(this.jkD);
        super.onActivityCreated(bundle);
    }

    public void Y(FrsFragment frsFragment) {
        this.jkw = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ai aiVar) {
        if (mVar != null && aiVar != null && this.mTabHost != null) {
            this.jkx = mVar;
            this.jkv = aiVar;
            this.jkv.cEF();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.jkv.cBX())) {
                List<com.baidu.tbadk.mainTab.b> cBX = this.jkv.cBX();
                List<FrsTabInfo> bAS = this.jkv.bAS();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bAS.size() == cBX.size()) {
                    int size = bAS.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cBX.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bAS.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.iKt.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cBX) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.iKt.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int yS = yS(this.jky);
                if (yS < 0) {
                    yS = yS(this.jkx.getGameDefaultTabId());
                }
                if (yS < 0) {
                    yS = cEr();
                }
                if (yS < 0) {
                    yS = 0;
                }
                this.jky = yS;
                this.jkz = yS;
                this.jfe.yW(this.jky);
                this.jfe.zR(this.jkz);
                this.mTabHost.setCurrentTab(yS);
                int yU = yU(yS);
                if (yU != 1) {
                    if (this.jkw != null) {
                        this.jkw.qz(false);
                        if (yU != 4 && yU != 25) {
                            this.jkw.qy(false);
                            this.jgi.setVisibility(8);
                            this.jkw.cCX();
                        }
                    }
                    if (this.jkx.getForum() != null) {
                        com.baidu.tieba.frs.c.e Lf = com.baidu.tieba.frs.c.d.cKr().Lf(this.jkx.getForum().getName());
                        if (yU == 25) {
                            if (Lf == null) {
                                Lf = new com.baidu.tieba.frs.c.e(null);
                            }
                            Lf.rz(true);
                            com.baidu.tieba.frs.c.d.cKr().a(this.jkx.getForum().getName(), Lf);
                        } else if (Lf != null && Lf.cKu()) {
                            Lf.rz(false);
                            com.baidu.tieba.frs.c.d.cKr().a(this.jkx.getForum().getName(), Lf);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.jkx != null && this.jkx.getForum() != null) {
            ForumData forum = this.jkx.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.iKt, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iKt.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.iKt, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.iKt.getActivity(), R.dimen.tbds12));
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
            bVar2.eZk = tbFragmentTabIndicator;
            bVar2.eZl = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cEq() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int yU = FrsTabHostFragment.this.yU(i);
                if (yU != 1) {
                    FrsTabHostFragment.this.jkw.cCX();
                } else {
                    FrsTabHostFragment.this.jkw.cCY();
                }
                if (yU == 1) {
                    if (FrsTabHostFragment.this.jkw != null) {
                        FrsTabHostFragment.this.jkw.qy(true);
                    }
                    FrsTabHostFragment.this.jgi.setVisibility(0);
                    return;
                }
                if (yU == 4 || yU == 25) {
                    if (FrsTabHostFragment.this.jgi.getVisibility() == 8) {
                        FrsTabHostFragment.this.jgi.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.jkw != null) {
                        FrsTabHostFragment.this.jkw.qy(false);
                    }
                    FrsTabHostFragment.this.jgi.setVisibility(8);
                    FrsTabHostFragment.this.cEx();
                }
                if (FrsTabHostFragment.this.jkw != null) {
                    FrsTabHostFragment.this.jkw.qz(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo yT = FrsTabHostFragment.this.yT(i);
                if (yT == null || yT.tab_type.intValue() != 11) {
                    FragmentTabHost.b ot = FrsTabHostFragment.this.mTabHost.ot(i);
                    if (FrsTabHostFragment.this.jkx != null && FrsTabHostFragment.this.jkx.getForum() != null) {
                        str = FrsTabHostFragment.this.jkx.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(ot, str);
                    if (ot.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bh.skipToLoginActivity(FrsTabHostFragment.this.iKt.getPageContext().getPageActivity());
                        return false;
                    }
                    if (ot.eZk != null) {
                        ot.eZk.bCU();
                    }
                    if (ot.eZk.Dn(String.valueOf(ot.mType)) != null) {
                        if (!(ot.eZk.Dn(String.valueOf(ot.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.jkz == i) {
                                FrsTabHostFragment.this.b(ot);
                            }
                        } else {
                            ot.eZk.Dn(String.valueOf(ot.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(ot);
                        }
                    }
                    FrsTabHostFragment.this.jkz = i;
                    return true;
                }
                bf.bsV().a((TbPageContext<?>) FrsTabHostFragment.this.iKt.getPageContext(), new String[]{yT.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.iKt.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.iKt);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.iKt.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.fHv = fragmentTabIndicator;
        aVar.offsetX = this.iKt.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.jkA != null) {
            this.jkA.onChangeSkinType(i);
        }
    }

    private int yS(int i) {
        if (this.jkv == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.jkv.bAS());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jkv.bAS().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo yT(int i) {
        if (this.jkv == null || i >= com.baidu.tbadk.core.util.y.getCount(this.jkv.bAS())) {
            return null;
        }
        return this.jkv.bAS().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yU(int i) {
        if (this.jkv != null && i < com.baidu.tbadk.core.util.y.getCount(this.jkv.bAS())) {
            return this.jkv.bAS().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cEr() {
        if (this.jkv == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.jkv.bAS());
        for (int i = 0; i < count; i++) {
            if (this.jkv.bAS().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12334").ap("obj_locate", c(bVar)).dR("fid", str));
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

    public int cEs() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.iKt.getResources().getColor(R.color.CAM_X0201_1) : this.iKt.getResources().getColor(R.color.CAM_X0201);
    }

    public void cEt() {
        if (bh.checkUpIsLogin(this.iKt) && !this.gEI.dRt() && !cEw()) {
            if (this.jkw.cCs().AH(502) != null) {
                this.jkC.aZ(this.jkw.getForumId(), this.jkw.cCs().cLN().tabId);
            } else {
                yV(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.jkA == null) {
            this.jkA = new com.baidu.tieba.write.g(this.iKt.getPageContext(), this.aiT, "frs");
            this.jkA.UX("2");
            ItemInfo itemInfo = this.jkw.cCZ().itemInfo;
            this.jkA.zv((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.au.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.jkw.cCZ().getAnti() != null) {
            this.jkA.zx(this.jkw.cCZ().getAnti().getCanGoods());
        }
        ForumWriteData cDd = this.jkw.cDd();
        cDd.setDefaultZone(i);
        this.jkA.Lg(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.jkA.a(cDd);
        this.jkA.b(this.jkw.cCZ().itemInfo);
        this.jkA.Lf(cEs());
        if (this.jkw != null && this.jkw.cCZ() != null) {
            this.jkA.b(this.jkw.cCZ().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.iKt, cEs());
        this.jkA.a(false, (View) null, (View) this.jgi);
        if (this.jkw != null && this.jkw.cCZ() != null && this.jkw.cCZ().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13721").dR("fid", this.jkw.getForumId()).dR("fname", this.jkw.getForumName()).dR("obj_param1", this.jkw.cCZ().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
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
        if (this.jkw != null && this.jkw.cCZ() != null && (forum = this.jkw.cCZ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jkw.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12342").ap("obj_locate", c(this.mTabHost.ot(this.mTabHost.getCurrentTabIndex()))).dR("fid", str));
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

    public FragmentTabHost cEv() {
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

    public boolean cEw() {
        if (this.jkw != null && this.jkw.isAdded() && this.jkw.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.jkw.getPageContext(), this.jkw.cCZ());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jgi = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.jkB = fRSRefreshButton;
    }

    public boolean cEf() {
        if (this.jkA == null) {
            return false;
        }
        return this.jkA.isShowing();
    }

    public void cEx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.jkA != null && this.jkA.isShowing()) {
            this.jkA.zw(true);
        }
    }

    public FragmentTabHost.b ot(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.ot(i);
    }

    public void yW(int i) {
        this.jky = i;
    }
}
