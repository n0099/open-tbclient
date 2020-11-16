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
/* loaded from: classes21.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout ail;
    private com.baidu.tieba.ueg.d gnu;
    private FrsTabController iGY;
    private OvalActionButton iIe;
    private am iMq;
    private FrsFragment iMr;
    private com.baidu.tieba.tbadkCore.m iMs;
    private int iMu;
    private com.baidu.tieba.write.g iMv;
    private FRSRefreshButton iMw;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    private BaseFragmentActivity imj;
    private FragmentTabHost mTabHost;
    private int iMt = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.czM();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.iMs != null && FrsTabHostFragment.this.iMs.getForum() != null) {
                        str = FrsTabHostFragment.this.iMs.getForum().getId();
                    }
                    FrsTabHostFragment.this.JT(str);
                }
            }
        }
    };
    private c.a iMy = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pL(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.zA(1);
            } else if (z) {
                FrsTabHostFragment.this.zA(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.zA(-1);
            } else {
                FrsTabHostFragment.this.czN();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pM(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.iGY = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.imj = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.imj);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ail = new FrameLayout(this.imj.getActivity());
            this.ail.setClipChildren(false);
            this.ail.setClipToPadding(false);
            this.ail.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(czJ());
        }
        return this.ail;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.gnu = new com.baidu.tieba.ueg.d(this.imj.getPageContext());
        this.iMx = new com.baidu.tieba.frs.profession.permission.c(this.imj.getPageContext());
        this.iMx.a(this.iMy);
        super.onActivityCreated(bundle);
    }

    public void Z(FrsFragment frsFragment) {
        this.iMr = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, am amVar) {
        if (mVar != null && amVar != null && this.mTabHost != null) {
            this.iMs = mVar;
            this.iMq = amVar;
            this.iMq.czY();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.iMq.cxt())) {
                List<com.baidu.tbadk.mainTab.b> cxt = this.iMq.cxt();
                List<FrsTabInfo> byy = this.iMq.byy();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (byy.size() == cxt.size()) {
                    int size = byy.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cxt.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = byy.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.imj.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cxt) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.imj.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int zx = zx(this.iMt);
                if (zx < 0) {
                    zx = zx(this.iMs.getGameDefaultTabId());
                }
                if (zx < 0) {
                    zx = czK();
                }
                if (zx < 0) {
                    zx = 0;
                }
                this.iMt = zx;
                this.iMu = zx;
                this.iGY.zB(this.iMt);
                this.iGY.An(this.iMu);
                this.mTabHost.setCurrentTab(zx);
                int zz = zz(zx);
                if (zz != 1) {
                    if (this.iMr != null) {
                        this.iMr.pz(false);
                        if (zz != 4 && zz != 25) {
                            this.iMr.py(false);
                            this.iIe.setVisibility(8);
                            this.iMr.cyq();
                        }
                    }
                    if (this.iMs.getForum() != null) {
                        com.baidu.tieba.frs.e.e Ky = com.baidu.tieba.frs.e.d.cEG().Ky(this.iMs.getForum().getName());
                        if (zz == 25) {
                            if (Ky == null) {
                                Ky = new com.baidu.tieba.frs.e.e(null);
                            }
                            Ky.qu(true);
                            com.baidu.tieba.frs.e.d.cEG().a(this.iMs.getForum().getName(), Ky);
                        } else if (Ky != null && Ky.cEJ()) {
                            Ky.qu(false);
                            com.baidu.tieba.frs.e.d.cEG().a(this.iMs.getForum().getName(), Ky);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.iMs != null && this.iMs.getForum() != null) {
            ForumData forum = this.iMs.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.imj, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.imj.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.imj, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.imj.getActivity(), R.dimen.tbds12));
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
            bVar2.eKr = tbFragmentTabIndicator;
            bVar2.eKs = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a czJ() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int zz = FrsTabHostFragment.this.zz(i);
                if (zz != 1) {
                    FrsTabHostFragment.this.iMr.cyq();
                } else {
                    FrsTabHostFragment.this.iMr.cyr();
                }
                if (zz == 1) {
                    if (FrsTabHostFragment.this.iMr != null) {
                        FrsTabHostFragment.this.iMr.py(true);
                    }
                    FrsTabHostFragment.this.iIe.setVisibility(0);
                    return;
                }
                if (zz == 4 || zz == 25) {
                    if (FrsTabHostFragment.this.iIe.getVisibility() == 8) {
                        FrsTabHostFragment.this.iIe.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.iMr != null) {
                        FrsTabHostFragment.this.iMr.py(false);
                    }
                    FrsTabHostFragment.this.iIe.setVisibility(8);
                    FrsTabHostFragment.this.czQ();
                }
                if (FrsTabHostFragment.this.iMr != null) {
                    FrsTabHostFragment.this.iMr.pz(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo zy = FrsTabHostFragment.this.zy(i);
                if (zy == null || zy.tab_type.intValue() != 11) {
                    FragmentTabHost.b pk = FrsTabHostFragment.this.mTabHost.pk(i);
                    if (FrsTabHostFragment.this.iMs != null && FrsTabHostFragment.this.iMs.getForum() != null) {
                        str = FrsTabHostFragment.this.iMs.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(pk, str);
                    if (pk.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bh.skipToLoginActivity(FrsTabHostFragment.this.imj.getPageContext().getPageActivity());
                        return false;
                    }
                    if (pk.eKr != null) {
                        pk.eKr.bAy();
                    }
                    if (pk.eKr.DD(String.valueOf(pk.mType)) != null) {
                        if (!(pk.eKr.DD(String.valueOf(pk.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.iMu == i) {
                                FrsTabHostFragment.this.b(pk);
                            }
                        } else {
                            pk.eKr.DD(String.valueOf(pk.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(pk);
                        }
                    }
                    FrsTabHostFragment.this.iMu = i;
                    return true;
                }
                com.baidu.tbadk.core.util.bf.bqF().a((TbPageContext<?>) FrsTabHostFragment.this.imj.getPageContext(), new String[]{zy.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.imj.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.imj);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.imj.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.fsw = fragmentTabIndicator;
        aVar.offsetX = this.imj.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.iMv != null) {
            this.iMv.onChangeSkinType(i);
        }
    }

    private int zx(int i) {
        if (this.iMq == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.iMq.byy());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.iMq.byy().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo zy(int i) {
        if (this.iMq == null || i >= com.baidu.tbadk.core.util.y.getCount(this.iMq.byy())) {
            return null;
        }
        return this.iMq.byy().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zz(int i) {
        if (this.iMq != null && i < com.baidu.tbadk.core.util.y.getCount(this.iMq.byy())) {
            return this.iMq.byy().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int czK() {
        if (this.iMq == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.iMq.byy());
        for (int i = 0; i < count; i++) {
            if (this.iMq.byy().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12334").ak("obj_locate", c(bVar)).dR("fid", str));
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

    public int czL() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.imj.getResources().getColor(R.color.CAM_X0201_1) : this.imj.getResources().getColor(R.color.CAM_X0201);
    }

    public void czM() {
        if (bh.checkUpIsLogin(this.imj) && !this.gnu.dNP() && !czP()) {
            if (this.iMr.cxM().Bd(502) != null) {
                this.iMx.aQ(this.iMr.getForumId(), this.iMr.cxM().cFX().tabId);
            } else {
                zA(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.iMv == null) {
            this.iMv = new com.baidu.tieba.write.g(this.imj.getPageContext(), this.ail, "frs");
            this.iMv.Un("2");
            ItemInfo itemInfo = this.iMr.cys().itemInfo;
            this.iMv.yy((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.au.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.iMr.cys().getAnti() != null) {
            this.iMv.setCanGoods(this.iMr.cys().getAnti().getCanGoods());
        }
        ForumWriteData cyw = this.iMr.cyw();
        cyw.setDefaultZone(i);
        this.iMv.LN(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.iMv.a(cyw);
        this.iMv.b(this.iMr.cys().itemInfo);
        this.iMv.LM(czL());
        if (this.iMr != null && this.iMr.cys() != null) {
            this.iMv.b(this.iMr.cys().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.imj, czL());
        this.iMv.a(false, (View) null, (View) this.iIe);
        if (this.iMr != null && this.iMr.cys() != null && this.iMr.cys().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13721").dR("fid", this.iMr.getForumId()).dR("fname", this.iMr.getForumName()).dR("obj_param1", this.iMr.cys().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czN() {
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
        if (this.iMr != null && this.iMr.cys() != null && (forum = this.iMr.cys().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iMr.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JT(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12342").ak("obj_locate", c(this.mTabHost.pk(this.mTabHost.getCurrentTabIndex()))).dR("fid", str));
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

    public FragmentTabHost czO() {
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

    public boolean czP() {
        if (this.iMr != null && this.iMr.isAdded() && this.iMr.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.iMr.getPageContext(), this.iMr.cys());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iIe = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.iMw = fRSRefreshButton;
    }

    public boolean czz() {
        if (this.iMv == null) {
            return false;
        }
        return this.iMv.isShowing();
    }

    public void czQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.iMv != null && this.iMv.isShowing()) {
            this.iMv.yz(true);
        }
    }

    public FragmentTabHost.b pk(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.pk(i);
    }

    public void zB(int i) {
        this.iMt = i;
    }
}
