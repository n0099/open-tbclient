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
/* loaded from: classes22.dex */
public class FrsTabHostFragment extends BaseFragment {
    private FrameLayout aih;
    private com.baidu.tieba.ueg.d fXV;
    private BaseFragmentActivity hSW;
    private FrsTabController inR;
    private OvalActionButton ioX;
    private am itk;
    private FrsFragment itl;
    private com.baidu.tieba.tbadkCore.m itm;
    private int ito;
    private com.baidu.tieba.write.g itp;
    private FRSRefreshButton itq;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private FragmentTabHost mTabHost;
    private int itn = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                FrsTabHostFragment.this.cuB();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.itm != null && FrsTabHostFragment.this.itm.getForum() != null) {
                        str = FrsTabHostFragment.this.itm.getForum().getId();
                    }
                    FrsTabHostFragment.this.JC(str);
                }
            }
        }
    };
    private c.a its = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ph(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.yw(1);
            } else if (z) {
                FrsTabHostFragment.this.yw(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.yw(-1);
            } else {
                FrsTabHostFragment.this.cuC();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pi(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.inR = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.hSW = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.hSW);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.aih = new FrameLayout(this.hSW.getActivity());
            this.aih.setClipChildren(false);
            this.aih.setClipToPadding(false);
            this.aih.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cuy());
        }
        return this.aih;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.fXV = new com.baidu.tieba.ueg.d(this.hSW.getPageContext());
        this.itr = new com.baidu.tieba.frs.profession.permission.c(this.hSW.getPageContext());
        this.itr.a(this.its);
        super.onActivityCreated(bundle);
    }

    public void Z(FrsFragment frsFragment) {
        this.itl = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, am amVar) {
        if (mVar != null && amVar != null && this.mTabHost != null) {
            this.itm = mVar;
            this.itk = amVar;
            this.itk.cuN();
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.itk.csi())) {
                List<com.baidu.tbadk.mainTab.b> csi = this.itk.csi();
                List<FrsTabInfo> buQ = this.itk.buQ();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (buQ.size() == csi.size()) {
                    int size = buQ.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = csi.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = buQ.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.hSW.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : csi) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.hSW.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int yt = yt(this.itn);
                if (yt < 0) {
                    yt = yt(this.itm.getGameDefaultTabId());
                }
                if (yt < 0) {
                    yt = cuz();
                }
                if (yt < 0) {
                    yt = 0;
                }
                this.itn = yt;
                this.ito = yt;
                this.inR.yx(this.itn);
                this.inR.zj(this.ito);
                this.mTabHost.setCurrentTab(yt);
                int yv = yv(yt);
                if (yv != 1) {
                    if (this.itl != null) {
                        this.itl.oV(false);
                        if (yv != 4 && yv != 25) {
                            this.itl.oU(false);
                            this.ioX.setVisibility(8);
                            this.itl.ctf();
                        }
                    }
                    if (this.itm.getForum() != null) {
                        com.baidu.tieba.frs.e.e Kh = com.baidu.tieba.frs.e.d.czt().Kh(this.itm.getForum().getName());
                        if (yv == 25) {
                            if (Kh == null) {
                                Kh = new com.baidu.tieba.frs.e.e(null);
                            }
                            Kh.pQ(true);
                            com.baidu.tieba.frs.e.d.czt().a(this.itm.getForum().getName(), Kh);
                        } else if (Kh != null && Kh.czw()) {
                            Kh.pQ(false);
                            com.baidu.tieba.frs.e.d.czt().a(this.itm.getForum().getName(), Kh);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.itm != null && this.itm.getForum() != null) {
            ForumData forum = this.itm.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.hSW, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hSW.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.hSW, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.hSW.getActivity(), R.dimen.tbds12));
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
            bVar2.exe = tbFragmentTabIndicator;
            bVar2.exf = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cuy() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int yv = FrsTabHostFragment.this.yv(i);
                if (yv != 1) {
                    FrsTabHostFragment.this.itl.ctf();
                } else {
                    FrsTabHostFragment.this.itl.ctg();
                }
                if (yv == 1) {
                    if (FrsTabHostFragment.this.itl != null) {
                        FrsTabHostFragment.this.itl.oU(true);
                    }
                    FrsTabHostFragment.this.ioX.setVisibility(0);
                    return;
                }
                if (yv == 4 || yv == 25) {
                    if (FrsTabHostFragment.this.ioX.getVisibility() == 8) {
                        FrsTabHostFragment.this.ioX.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.itl != null) {
                        FrsTabHostFragment.this.itl.oU(false);
                    }
                    FrsTabHostFragment.this.ioX.setVisibility(8);
                    FrsTabHostFragment.this.cuF();
                }
                if (FrsTabHostFragment.this.itl != null) {
                    FrsTabHostFragment.this.itl.oV(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo yu = FrsTabHostFragment.this.yu(i);
                if (yu == null || yu.tab_type.intValue() != 11) {
                    FragmentTabHost.b ou = FrsTabHostFragment.this.mTabHost.ou(i);
                    if (FrsTabHostFragment.this.itm != null && FrsTabHostFragment.this.itm.getForum() != null) {
                        str = FrsTabHostFragment.this.itm.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(ou, str);
                    if (ou.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsTabHostFragment.this.hSW.getPageContext().getPageActivity());
                        return false;
                    }
                    if (ou.exe != null) {
                        ou.exe.bwQ();
                    }
                    if (ou.exe.Dx(String.valueOf(ou.mType)) != null) {
                        if (!(ou.exe.Dx(String.valueOf(ou.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.ito == i) {
                                FrsTabHostFragment.this.b(ou);
                            }
                        } else {
                            ou.exe.Dx(String.valueOf(ou.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(ou);
                        }
                    }
                    FrsTabHostFragment.this.ito = i;
                    return true;
                }
                com.baidu.tbadk.core.util.be.bmY().a((TbPageContext<?>) FrsTabHostFragment.this.hSW.getPageContext(), new String[]{yu.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.hSW.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.hSW);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.hSW.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.feT = fragmentTabIndicator;
        aVar.offsetX = this.hSW.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.itp != null) {
            this.itp.onChangeSkinType(i);
        }
    }

    private int yt(int i) {
        if (this.itk == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.itk.buQ());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.itk.buQ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo yu(int i) {
        if (this.itk == null || i >= com.baidu.tbadk.core.util.y.getCount(this.itk.buQ())) {
            return null;
        }
        return this.itk.buQ().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yv(int i) {
        if (this.itk != null && i < com.baidu.tbadk.core.util.y.getCount(this.itk.buQ())) {
            return this.itk.buQ().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cuz() {
        if (this.itk == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(this.itk.buQ());
        for (int i = 0; i < count; i++) {
            if (this.itk.buQ().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12334").aj("obj_locate", c(bVar)).dK("fid", str));
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

    public int cuA() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.hSW.getResources().getColor(R.color.cp_bg_line_d_1) : this.hSW.getResources().getColor(R.color.cp_bg_line_d);
    }

    public void cuB() {
        if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(this.hSW) && !this.fXV.dIg() && !cuE()) {
            if (this.itl.csB().zZ(502) != null) {
                this.itr.aO(this.itl.getForumId(), this.itl.csB().cAK().tabId);
            } else {
                yw(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.itp == null) {
            this.itp = new com.baidu.tieba.write.g(this.hSW.getPageContext(), this.aih, "frs");
            this.itp.TM("2");
            ItemInfo itemInfo = this.itl.cth().itemInfo;
            this.itp.xR((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.at.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.itl.cth().getAnti() != null) {
            this.itp.setCanGoods(this.itl.cth().getAnti().getCanGoods());
        }
        ForumWriteData ctl = this.itl.ctl();
        ctl.setDefaultZone(i);
        this.itp.KF(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.itp.a(ctl);
        this.itp.b(this.itl.cth().itemInfo);
        this.itp.KE(cuA());
        if (this.itl != null && this.itl.cth() != null) {
            this.itp.b(this.itl.cth().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.hSW, cuA());
        this.itp.a(false, (View) null, (View) this.ioX);
        if (this.itl != null && this.itl.cth() != null && this.itl.cth().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13721").dK("fid", this.itl.getForumId()).dK("fname", this.itl.getForumName()).dK("obj_param1", this.itl.cth().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuC() {
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
        if (this.itl != null && this.itl.cth() != null && (forum = this.itl.cth().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.itl.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JC(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12342").aj("obj_locate", c(this.mTabHost.ou(this.mTabHost.getCurrentTabIndex()))).dK("fid", str));
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

    public FragmentTabHost cuD() {
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

    public boolean cuE() {
        if (this.itl != null && this.itl.isAdded() && this.itl.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.itl.getPageContext(), this.itl.cth());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.ioX = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.itq = fRSRefreshButton;
    }

    public boolean cuo() {
        if (this.itp == null) {
            return false;
        }
        return this.itp.isShowing();
    }

    public void cuF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.itp != null && this.itp.isShowing()) {
            this.itp.xS(true);
        }
    }

    public FragmentTabHost.b ou(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.ou(i);
    }

    public void yx(int i) {
        this.itn = i;
    }
}
