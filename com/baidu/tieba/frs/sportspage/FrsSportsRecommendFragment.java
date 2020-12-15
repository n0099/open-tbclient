package com.baidu.tieba.frs.sportspage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Zj;
    private View bHy;
    private FrameLayout eje;
    private NoNetworkView gpw;
    private CollapsingToolbarLayout gwM;
    private View iVV;
    private View iVw;
    private long jcl;
    private TextView jlc;
    private be jqF;
    private ImageView jtA;
    private a jtB;
    private b jtC;
    private int jtE;
    private ObservedChangeLinearLayout jtx;
    private View jty;
    private View jtz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jtD = true;
    public final View.OnClickListener iVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.iVw != null && view == FrsSportsRecommendFragment.this.iVw) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gxk = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Zj.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jbO.setSelection(0);
                    FrsSportsRecommendFragment.this.bTa();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jtF = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jtE != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gpw == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gpw.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jtE - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.zM(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.iVV != null) {
                                FrsSportsRecommendFragment.this.iVV.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.iVV != null && FrsSportsRecommendFragment.this.bHy != null) {
                            if (FrsSportsRecommendFragment.this.bHy.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.zM(0);
                            }
                            FrsSportsRecommendFragment.this.iVV.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cDA();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.jtE = i;
                        FrsSportsRecommendFragment.this.Ar(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gxk);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jbO.qx(true);
        cJG();
        this.gwM = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bHy = this.mRootView.findViewById(R.id.statebar_view);
        this.iVV = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Zj = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Zj.addOnOffsetChangedListener(this.jtF);
        Vq();
        this.jtB = new a(this, this.mRootView);
        this.jtB.h(this.jbQ);
        this.jtC = new b(this, this.mRootView);
        if (this.jbP != null) {
            this.jbP.gn(0L);
        }
        this.eje = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.iRX = currentTimeMillis + frsActivity.iRX;
            }
        }
        super.onPrimary();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.iRX = currentTimeMillis + frsActivity.iRX;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jtB != null) {
            this.jtB.onChangeSkinType();
        }
        if (this.jtC != null) {
            this.jtC.onChangeSkinType();
        }
        if (this.gpw != null) {
            this.gpw.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jty, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jtz, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bHy, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iVV, R.color.CAM_X0201);
        SvgManager.btW().a(this.jtA, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cDA();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.at
    public void bvq() {
        cJH();
        if (this.jbP != null) {
            this.jbP.gn(this.jcl);
        }
        super.bvq();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jtB != null) {
                this.jtB.setData(dVar.jcn, dVar.jco, dVar.jcp);
            }
            if (this.jtC != null && this.jbQ != null && this.jbQ.getForum() != null) {
                this.jtC.a(dVar.jcq, this.jbQ.getForum().getId());
            }
            if (this.jbP != null && this.jbP.cFz()) {
                yZ(dVar.jcm);
            }
            if (!y.isEmpty(dVar.threadList)) {
                Iterator<q> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof by) {
                        by byVar = (by) next;
                        if (byVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(byVar.getId(), 0L);
                            if (j > 0) {
                                this.jcl = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jtD = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jbO != null) {
            this.jbO.lx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cJG() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jtx == null) {
            this.jtx = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jtx.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gwM.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jty == null) {
            this.jty = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jtz == null) {
            this.jtz = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.iVw == null) {
            this.iVw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVw.setOnClickListener(this.iVJ);
            this.mBackImageView = (ImageView) this.iVw.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jtA == null) {
            this.jtA = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gpw == null) {
            this.gpw = new NoNetworkView(getContext());
            this.gpw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jtx.addView(this.gpw);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gpw.setVisibility(8);
        } else {
            this.gpw.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jbQ != null && this.jbQ.getForum() != null) {
            String name = this.jbQ.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 14) {
                name = au.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.jty != null && this.jtz != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jty.setVisibility(8);
                this.jtz.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jty.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jtz.getLayoutParams();
            if (this.jbO.cFx().getFirstCompletelyVisiblePosition() != 0) {
                this.jty.setVisibility(8);
                this.jtz.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Zj.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jty.setVisibility(0);
                this.jtz.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jty.setVisibility(8);
                this.jtz.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jty.setVisibility(0);
                this.jtz.setVisibility(8);
            }
        }
    }

    private void Vq() {
        if (this.bHy != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bHy.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHy.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHy.setLayoutParams(layoutParams);
                this.bHy.setVisibility(0);
                if (this.jtA != null && (this.jtA.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jtA.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bHy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDA() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jtA != null) {
                this.jtA.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bHy != null) {
                this.bHy.setAlpha(f);
            }
            if (this.iVV != null) {
                this.iVV.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bHy != null && this.iVV != null && this.bHy.getLayoutParams() != null && this.iVV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bHy.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bHy.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.iVV.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.iVV.setLayoutParams(layoutParams2);
        }
    }

    private void yZ(int i) {
        String string;
        if (this.jlc == null) {
            this.jlc = new TextView(getContext());
            this.jlc.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jlc.setGravity(17);
        }
        if (this.jlc != null) {
            if (this.jtD) {
                if (i > 0) {
                    string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_first_time_tip);
                } else {
                    return;
                }
            } else if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_get_new_thread), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_no_new_thread);
            }
            this.jlc.setText(string);
        }
        ap.setBackgroundResource(this.jlc, R.color.CAM_X0302);
        ap.setViewTextColor(this.jlc, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jqF == null) {
            this.jqF = new be();
        }
        this.jqF.a(this.jlc, this.eje, layoutParams, 2000);
    }

    private void cJH() {
        this.Zj.setExpanded(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.eje, str, z);
        Ar(0);
    }
}
