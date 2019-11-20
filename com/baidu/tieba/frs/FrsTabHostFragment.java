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
import com.baidu.tbadk.core.view.NavigationBar;
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
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout bEf;
    private com.baidu.tieba.ueg.d faR;
    private FrsTabController ftC;
    private OvalActionButton fuy;
    private BaseFragmentActivity fxV;
    private ab fxW;
    private FrsFragment fxX;
    private com.baidu.tieba.tbadkCore.l fxY;
    private int fya;
    private com.baidu.tieba.write.e fyb;
    private FRSRefreshButton fyc;
    private com.baidu.tieba.frs.profession.permission.c fyd;
    private FragmentTabHost mTabHost;
    private int fxZ = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.blu();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.fxY != null && FrsTabHostFragment.this.fxY.getForum() != null) {
                        str = FrsTabHostFragment.this.fxY.getForum().getId();
                    }
                    FrsTabHostFragment.this.vO(str);
                }
            }
        }
    };
    private c.a fye = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void o(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.qF(1);
            } else if (z) {
                FrsTabHostFragment.this.qF(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.qF(-1);
            } else {
                FrsTabHostFragment.this.blv();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jX(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.ftC = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.fxV = (BaseFragmentActivity) getActivity();
        blq();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.fxV);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.bEf = new FrameLayout(this.fxV.getActivity());
            this.bEf.setClipChildren(false);
            this.bEf.setClipToPadding(false);
            this.bEf.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(blr());
        }
        return this.bEf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.faR = new com.baidu.tieba.ueg.d(this.fxV.getPageContext());
        this.fyd = new com.baidu.tieba.frs.profession.permission.c(this.fxV.getPageContext());
        this.fyd.a(this.fye);
        super.onActivityCreated(bundle);
    }

    public void L(FrsFragment frsFragment) {
        this.fxX = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.l lVar, ab abVar) {
        if (lVar != null && abVar != null && this.mTabHost != null) {
            this.fxY = lVar;
            this.fxW = abVar;
            this.fxW.blI();
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fxW.bju())) {
                List<com.baidu.tbadk.mainTab.b> bju = this.fxW.bju();
                List<FrsTabInfo> blH = this.fxW.blH();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_d);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (blH.size() == bju.size()) {
                    int size = blH.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = bju.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = blH.get(i);
                            a(bVar, bVar.avx(), bVar.cB(this.fxV.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : bju) {
                        a(bVar2, bVar2.avx(), bVar2.cB(this.fxV.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int qB = qB(this.fxZ);
                if (qB < 0) {
                    qB = qB(this.fxY.getGameDefaultTabId());
                }
                if (qB < 0) {
                    qB = bls();
                }
                if (qB < 0) {
                    qB = 0;
                }
                this.fxZ = qB;
                this.fya = qB;
                this.ftC.qG(this.fxZ);
                this.ftC.rm(this.fya);
                this.mTabHost.setCurrentTab(qB);
                int qD = qD(qB);
                if (qD != 1) {
                    if (this.fxX != null) {
                        this.fxX.jI(false);
                        if (qD != 4 && qD != 25) {
                            this.fxX.jH(false);
                            this.fuy.setVisibility(8);
                            this.fxX.bkl();
                        }
                    }
                    if (this.fxY.getForum() != null) {
                        com.baidu.tieba.frs.e.e ww = com.baidu.tieba.frs.e.d.bpU().ww(this.fxY.getForum().getName());
                        if (qD == 25) {
                            if (ww == null) {
                                ww = new com.baidu.tieba.frs.e.e(null);
                            }
                            ww.kE(true);
                            com.baidu.tieba.frs.e.d.bpU().a(this.fxY.getForum().getName(), ww);
                        } else if (ww != null && ww.bpX()) {
                            ww.kE(false);
                            com.baidu.tieba.frs.e.d.bpU().a(this.fxY.getForum().getName(), ww);
                        }
                    }
                }
                qE(qB);
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void blq() {
        int bls;
        if (this.fxX != null && (bls = bls()) >= 0) {
            a(this.fxX, bls);
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.fxY != null && this.fxY.getForum() != null) {
            ForumData forum = this.fxY.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.fxV, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.fxV.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.fxV, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.fxV.getActivity(), R.dimen.tbds12));
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
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds44));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds40));
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.cp_cont_b);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.cp_cont_j);
            if (cVar.showIconType != com.baidu.tbadk.mainTab.c.SHOWICON || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.chu = tbFragmentTabIndicator;
            bVar2.chv = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a blr() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                int qD = FrsTabHostFragment.this.qD(i);
                if (qD != 1) {
                    FrsTabHostFragment.this.fxX.bkl();
                } else {
                    FrsTabHostFragment.this.fxX.bkm();
                }
                if (qD == 1) {
                    if (FrsTabHostFragment.this.fxX != null) {
                        FrsTabHostFragment.this.fxX.jH(true);
                    }
                    FrsTabHostFragment.this.fuy.setVisibility(0);
                    return;
                }
                if (qD == 4 || qD == 25) {
                    if (FrsTabHostFragment.this.fuy.getVisibility() == 8) {
                        FrsTabHostFragment.this.fuy.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.fxX != null) {
                        FrsTabHostFragment.this.fxX.jH(false);
                    }
                    FrsTabHostFragment.this.fuy.setVisibility(8);
                    FrsTabHostFragment.this.blz();
                }
                if (FrsTabHostFragment.this.fxX != null) {
                    FrsTabHostFragment.this.fxX.jI(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo qC = FrsTabHostFragment.this.qC(i);
                if (qC == null || qC.tab_type.intValue() != 11) {
                    FragmentTabHost.b il = FrsTabHostFragment.this.mTabHost.il(i);
                    if (FrsTabHostFragment.this.fxY != null && FrsTabHostFragment.this.fxY.getForum() != null) {
                        str = FrsTabHostFragment.this.fxY.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(il, str);
                    if (il.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bc.skipToLoginActivity(FrsTabHostFragment.this.fxV.getPageContext().getPageActivity());
                        return false;
                    }
                    if (il.chu != null) {
                        il.chu.avy();
                    }
                    if (il.chu.qa(String.valueOf(il.mType)) != null) {
                        if (!(il.chu.qa(String.valueOf(il.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.fya == i) {
                                FrsTabHostFragment.this.b(il);
                            }
                        } else {
                            il.chu.qa(String.valueOf(il.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(il);
                        }
                    }
                    FrsTabHostFragment.this.fya = i;
                    return true;
                }
                ba.amO().a((TbPageContext<?>) FrsTabHostFragment.this.fxV.getPageContext(), new String[]{qC.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.fxV.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.fxV);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.fxV.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.cJE = fragmentTabIndicator;
        aVar.offsetX = this.fxV.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fyb != null) {
            this.fyb.onChangeSkinType(i);
        }
    }

    private int qB(int i) {
        if (this.fxW == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.fxW.blH());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.fxW.blH().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo qC(int i) {
        if (this.fxW == null || i >= com.baidu.tbadk.core.util.v.getCount(this.fxW.blH())) {
            return null;
        }
        return this.fxW.blH().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qD(int i) {
        if (this.fxW != null && i < com.baidu.tbadk.core.util.v.getCount(this.fxW.blH())) {
            return this.fxW.blH().get(i).tab_id.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar aKP;
        if ((fragment instanceof ah) && this.fxY != null && this.fxY.getForum() != null && (aKP = ((ah) fragment).aKP()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fxY.getForum().getName(), 5, true, true) + this.fxV.getActivity().getString(R.string.forum));
            aKP.setCenterTextTitle(sb.toString());
        }
    }

    private int bls() {
        if (this.fxW == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.fxW.blH());
        for (int i = 0; i < count; i++) {
            if (this.fxW.blH().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    private void qE(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (FrsTabHostFragment.this.mTabHost != null) {
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.getCurrentFragment(), i);
                    if (FrsTabHostFragment.this.fxY != null && FrsTabHostFragment.this.fxY.getForum() != null) {
                        str = FrsTabHostFragment.this.fxY.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(FrsTabHostFragment.this.mTabHost.il(FrsTabHostFragment.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12334").O("obj_locate", c(bVar)).bS("fid", str));
        if (bVar != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.toLong(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
            if (bVar.mType == 1) {
                TiebaStatic.log("c12905");
            } else if (bVar.mType == 5) {
                TiebaStatic.log("c12907");
            } else if (bVar.mType == 305) {
                TiebaStatic.log("c12906");
            }
        }
    }

    public int blt() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.fxV.getResources().getColor(R.color.cp_bg_line_d_1) : this.fxV.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void blu() {
        if (bc.checkUpIsLogin(this.fxV) && !this.faR.csb() && !blx()) {
            if (this.fxX.bjL().rY(502) != null) {
                this.fyd.at(this.fxX.getForumId(), this.fxX.bjL().bqS().tabId);
            } else {
                qF(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.fyb == null) {
            this.fyb = new com.baidu.tieba.write.e(this.fxV.getPageContext(), this.bEf, "frs");
            this.fyb.Fx("2");
        }
        ForumWriteData bkq = this.fxX.bkq();
        bkq.setDefaultZone(i);
        this.fyb.Bv(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.fyb.a(bkq);
        this.fyb.Bu(blt());
        UtilHelper.setNavigationBarBackground(this.fxV, blt());
        this.fyb.a(false, (View) null, (View) this.fuy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blv() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fxX != null && this.fxX.bkn() != null && (forum = this.fxX.bkn().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str5 = themeColorInfo.day.dark_color;
                    str = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str = null;
                    str5 = null;
                    str6 = null;
                }
                if (themeColorInfo.night != null) {
                    String str8 = themeColorInfo.night.light_color;
                    str7 = themeColorInfo.night.dark_color;
                    if (skinType == 1 || skinType == 4) {
                        str = themeColorInfo.night.pattern_image;
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    } else {
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    }
                } else {
                    str4 = str6;
                    str3 = str5;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fxX.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12342").O("obj_locate", c(this.mTabHost.il(this.mTabHost.getCurrentTabIndex()))).bS("fid", str));
        }
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

    public FragmentTabHost blw() {
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

    public boolean blx() {
        if (this.fxX != null && this.fxX.isAdded() && this.fxX.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.c.a(this.fxX.getPageContext(), this.fxX.bkn());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fuy = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.fyc = fRSRefreshButton;
    }

    public boolean bly() {
        if (this.fyb == null) {
            return false;
        }
        return this.fyb.isShowing();
    }

    public void blz() {
        if (this.fyb != null && this.fyb.isShowing()) {
            this.fyb.rM(true);
        }
    }

    public FragmentTabHost.b il(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.il(i);
    }

    public void qG(int i) {
        this.fxZ = i;
    }
}
