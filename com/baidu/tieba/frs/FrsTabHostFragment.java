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
    private FrameLayout ajf;
    private com.baidu.tieba.ueg.d gBY;
    private BaseFragmentActivity iEK;
    private FrsTabController iZx;
    private OvalActionButton jaC;
    private ai jeO;
    private FrsFragment jeP;
    private com.baidu.tieba.tbadkCore.m jeQ;
    private int jeS;
    private com.baidu.tieba.write.g jeT;
    private FRSRefreshButton jeU;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    private FragmentTabHost mTabHost;
    private int jeR = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null && !WriteActivityConfig.isAsyncWriting()) {
                FrsTabHostFragment.this.cDh();
                if (FrsTabHostFragment.this.mTabHost != null) {
                    if (FrsTabHostFragment.this.jeQ != null && FrsTabHostFragment.this.jeQ.getForum() != null) {
                        str = FrsTabHostFragment.this.jeQ.getForum().getId();
                    }
                    FrsTabHostFragment.this.Jx(str);
                }
            }
        }
    };
    private c.a jeW = new c.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.2
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.yL(1);
            } else if (z) {
                FrsTabHostFragment.this.yL(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.yL(-1);
            } else {
                FrsTabHostFragment.this.cDi();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qD(boolean z) {
        }
    };

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.iZx = frsTabController;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.iEK = (BaseFragmentActivity) getActivity();
        if (this.mTabHost == null) {
            this.mTabHost = new FragmentTabHost(this.iEK);
            this.mTabHost.setClipChildren(false);
            this.mTabHost.setClipToPadding(false);
            this.mTabHost.setup(getChildFragmentManager());
            this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
            this.mTabHost.setTabContainerShadowShow(true);
            this.ajf = new FrameLayout(this.iEK.getActivity());
            this.ajf.setClipChildren(false);
            this.ajf.setClipToPadding(false);
            this.ajf.addView(this.mTabHost);
            this.mTabHost.setOnTabSelectionListener(cDe());
        }
        return this.ajf;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.gBY = new com.baidu.tieba.ueg.d(this.iEK.getPageContext());
        this.jeV = new com.baidu.tieba.frs.profession.permission.c(this.iEK.getPageContext());
        this.jeV.a(this.jeW);
        super.onActivityCreated(bundle);
    }

    public void Y(FrsFragment frsFragment) {
        this.jeP = frsFragment;
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ai aiVar) {
        if (mVar != null && aiVar != null && this.mTabHost != null) {
            this.jeQ = mVar;
            this.jeO = aiVar;
            this.jeO.cDt();
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.jeO.cAM())) {
                List<com.baidu.tbadk.mainTab.b> cAM = this.jeO.cAM();
                List<FrsTabInfo> bAA = this.jeO.bAA();
                this.mTabHost.setShouldDrawDividerLine(false);
                this.mTabHost.setShouldDrawIndicatorLine(false);
                this.mTabHost.setShouldDrawTopLine(false);
                this.mTabHost.needShowTopDiver(false);
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (bAA.size() == cAM.size()) {
                    int size = bAA.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = cAM.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = bAA.get(i);
                            a(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.iEK.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : cAM) {
                        a(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.iEK.getActivity()), null);
                    }
                }
                this.mTabHost.initViewPager(2);
                this.mTabHost.setViewPagerScrollable(false);
                int yI = yI(this.jeR);
                if (yI < 0) {
                    yI = yI(this.jeQ.getGameDefaultTabId());
                }
                if (yI < 0) {
                    yI = cDf();
                }
                if (yI < 0) {
                    yI = 0;
                }
                this.jeR = yI;
                this.jeS = yI;
                this.iZx.yM(this.jeR);
                this.iZx.zH(this.jeS);
                this.mTabHost.setCurrentTab(yI);
                int yK = yK(yI);
                if (yK != 1) {
                    if (this.jeP != null) {
                        this.jeP.qp(false);
                        if (yK != 4 && yK != 25) {
                            this.jeP.qo(false);
                            this.jaC.setVisibility(8);
                            this.jeP.cBL();
                        }
                    }
                    if (this.jeQ.getForum() != null) {
                        com.baidu.tieba.frs.c.e Ku = com.baidu.tieba.frs.c.d.cJe().Ku(this.jeQ.getForum().getName());
                        if (yK == 25) {
                            if (Ku == null) {
                                Ku = new com.baidu.tieba.frs.c.e(null);
                            }
                            Ku.rp(true);
                            com.baidu.tieba.frs.c.d.cJe().a(this.jeQ.getForum().getName(), Ku);
                        } else if (Ku != null && Ku.cJh()) {
                            Ku.rp(false);
                            com.baidu.tieba.frs.c.d.cJe().a(this.jeQ.getForum().getName(), Ku);
                        }
                    }
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        boolean z = true;
        if (cVar != null && this.jeQ != null && this.jeQ.getForum() != null) {
            ForumData forum = this.jeQ.getForum();
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
            tbFragmentTabIndicator.setContentTvTopMargin(com.baidu.adp.lib.util.l.getDimens(this.iEK, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(cVar.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iEK.getActivity(), R.dimen.tbds40));
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON && cVar.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(com.baidu.adp.lib.util.l.getDimens(this.iEK, R.dimen.ds96), com.baidu.adp.lib.util.l.getDimens(this.iEK.getActivity(), R.dimen.tbds12));
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
            bVar2.eWU = tbFragmentTabIndicator;
            bVar2.eWV = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private FragmentTabHost.a cDe() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.FrsTabHostFragment.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                FrsTabHostFragment.this.mTabHost.getCurrentFragment();
                int yK = FrsTabHostFragment.this.yK(i);
                if (yK != 1) {
                    FrsTabHostFragment.this.jeP.cBL();
                } else {
                    FrsTabHostFragment.this.jeP.cBM();
                }
                if (yK == 1) {
                    if (FrsTabHostFragment.this.jeP != null) {
                        FrsTabHostFragment.this.jeP.qo(true);
                    }
                    FrsTabHostFragment.this.jaC.setVisibility(0);
                    return;
                }
                if (yK == 4 || yK == 25) {
                    if (FrsTabHostFragment.this.jaC.getVisibility() == 8) {
                        FrsTabHostFragment.this.jaC.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.jeP != null) {
                        FrsTabHostFragment.this.jeP.qo(false);
                    }
                    FrsTabHostFragment.this.jaC.setVisibility(8);
                    FrsTabHostFragment.this.cDl();
                }
                if (FrsTabHostFragment.this.jeP != null) {
                    FrsTabHostFragment.this.jeP.qp(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo yJ = FrsTabHostFragment.this.yJ(i);
                if (yJ == null || yJ.tab_type.intValue() != 11) {
                    FragmentTabHost.b oo = FrsTabHostFragment.this.mTabHost.oo(i);
                    if (FrsTabHostFragment.this.jeQ != null && FrsTabHostFragment.this.jeQ.getForum() != null) {
                        str = FrsTabHostFragment.this.jeQ.getForum().getId();
                    }
                    FrsTabHostFragment.this.a(oo, str);
                    if (oo.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bg.skipToLoginActivity(FrsTabHostFragment.this.iEK.getPageContext().getPageActivity());
                        return false;
                    }
                    if (oo.eWU != null) {
                        oo.eWU.bCC();
                    }
                    if (oo.eWU.CW(String.valueOf(oo.mType)) != null) {
                        if (!(oo.eWU.CW(String.valueOf(oo.mType)).view.getVisibility() == 0)) {
                            if (FrsTabHostFragment.this.jeS == i) {
                                FrsTabHostFragment.this.b(oo);
                            }
                        } else {
                            oo.eWU.CW(String.valueOf(oo.mType)).view.setVisibility(8);
                            FrsTabHostFragment.this.b(oo);
                        }
                    }
                    FrsTabHostFragment.this.jeS = i;
                    return true;
                }
                be.bsB().a((TbPageContext<?>) FrsTabHostFragment.this.iEK.getPageContext(), new String[]{yJ.tab_url}, true);
                return false;
            }
        };
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.iEK.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.iEK);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.iEK.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.fFj = fragmentTabIndicator;
        aVar.offsetX = this.iEK.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mTabHost != null) {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.jeT != null) {
            this.jeT.onChangeSkinType(i);
        }
    }

    private int yI(int i) {
        if (this.jeO == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(this.jeO.bAA());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.jeO.bAA().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo yJ(int i) {
        if (this.jeO == null || i >= com.baidu.tbadk.core.util.x.getCount(this.jeO.bAA())) {
            return null;
        }
        return this.jeO.bAA().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yK(int i) {
        if (this.jeO != null && i < com.baidu.tbadk.core.util.x.getCount(this.jeO.bAA())) {
            return this.jeO.bAA().get(i).tab_id.intValue();
        }
        return -1;
    }

    private int cDf() {
        if (this.jeO == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(this.jeO.bAA());
        for (int i = 0; i < count; i++) {
            if (this.jeO.bAA().get(i).tab_id.intValue() == 1) {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12334").an("obj_locate", c(bVar)).dW("fid", str));
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

    public int cDg() {
        return TbadkCoreApplication.getInst().getSkinType() == 1 ? this.iEK.getResources().getColor(R.color.CAM_X0201_1) : this.iEK.getResources().getColor(R.color.CAM_X0201);
    }

    public void cDh() {
        if (bg.checkUpIsLogin(this.iEK) && !this.gBY.dPi() && !cDk()) {
            if (this.jeP.cBg().Ax(502) != null) {
                this.jeV.aZ(this.jeP.getForumId(), this.jeP.cBg().cKz().tabId);
            } else {
                yL(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, true));
        if (this.jeT == null) {
            this.jeT = new com.baidu.tieba.write.g(this.iEK.getPageContext(), this.ajf, "frs");
            this.jeT.TY("2");
            ItemInfo itemInfo = this.jeP.cBN().itemInfo;
            this.jeT.yZ((itemInfo == null || itemInfo.id.intValue() <= 0 || com.baidu.tbadk.core.util.at.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.jeP.cBN().getAnti() != null) {
            this.jeT.zb(this.jeP.cBN().getAnti().getCanGoods());
        }
        ForumWriteData cBR = this.jeP.cBR();
        cBR.setDefaultZone(i);
        this.jeT.KL(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.jeT.a(cBR);
        this.jeT.b(this.jeP.cBN().itemInfo);
        this.jeT.KK(cDg());
        if (this.jeP != null && this.jeP.cBN() != null) {
            this.jeT.b(this.jeP.cBN().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.iEK, cDg());
        this.jeT.a(false, (View) null, (View) this.jaC);
        if (this.jeP != null && this.jeP.cBN() != null && this.jeP.cBN().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13721").dW("fid", this.jeP.getForumId()).dW("fname", this.jeP.getForumName()).dW("obj_param1", this.jeP.cBN().itemInfo.name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDi() {
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
        if (this.jeP != null && this.jeP.cBN() != null && (forum = this.jeP.cBN().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jeP.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx(String str) {
        if (this.mTabHost != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12342").an("obj_locate", c(this.mTabHost.oo(this.mTabHost.getCurrentTabIndex()))).dW("fid", str));
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

    public FragmentTabHost cDj() {
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

    public boolean cDk() {
        if (this.jeP != null && this.jeP.isAdded() && this.jeP.getPageContext() != null) {
            com.baidu.tieba.frs.gametab.d.a(this.jeP.getPageContext(), this.jeP.cBN());
        }
        return false;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jaC = ovalActionButton;
        ovalActionButton.setOnClickListener(this.mOnClickListener);
    }

    public void b(FRSRefreshButton fRSRefreshButton) {
        this.jeU = fRSRefreshButton;
    }

    public boolean cCT() {
        if (this.jeT == null) {
            return false;
        }
        return this.jeT.isShowing();
    }

    public void cDl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, false));
        if (this.jeT != null && this.jeT.isShowing()) {
            this.jeT.za(true);
        }
    }

    public FragmentTabHost.b oo(int i) {
        if (this.mTabHost == null) {
            return null;
        }
        return this.mTabHost.oo(i);
    }

    public void yM(int i) {
        this.jeR = i;
    }
}
