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
    private NoNetworkView gpu;
    private CollapsingToolbarLayout gwK;
    private View iVT;
    private View iVu;
    private long jcj;
    private TextView jla;
    private be jqD;
    private b jtA;
    private int jtC;
    private ObservedChangeLinearLayout jtv;
    private View jtw;
    private View jtx;
    private ImageView jty;
    private a jtz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jtB = true;
    public final View.OnClickListener iVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.iVu != null && view == FrsSportsRecommendFragment.this.iVu) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gxi = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Zj.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jbM.setSelection(0);
                    FrsSportsRecommendFragment.this.bSZ();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jtD = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jtC != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gpu == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gpu.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jtC - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.zM(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.iVT != null) {
                                FrsSportsRecommendFragment.this.iVT.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.iVT != null && FrsSportsRecommendFragment.this.bHy != null) {
                            if (FrsSportsRecommendFragment.this.bHy.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.zM(0);
                            }
                            FrsSportsRecommendFragment.this.iVT.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cDz();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.jtC = i;
                        FrsSportsRecommendFragment.this.Ar(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gxi);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jbM.qx(true);
        cJF();
        this.gwK = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bHy = this.mRootView.findViewById(R.id.statebar_view);
        this.iVT = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Zj = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Zj.addOnOffsetChangedListener(this.jtD);
        Vq();
        this.jtz = new a(this, this.mRootView);
        this.jtz.h(this.jbO);
        this.jtA = new b(this, this.mRootView);
        if (this.jbN != null) {
            this.jbN.gn(0L);
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
                frsActivity.iRV = currentTimeMillis + frsActivity.iRV;
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
                frsActivity.iRV = currentTimeMillis + frsActivity.iRV;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jtz != null) {
            this.jtz.onChangeSkinType();
        }
        if (this.jtA != null) {
            this.jtA.onChangeSkinType();
        }
        if (this.gpu != null) {
            this.gpu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jtw, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jtx, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bHy, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iVT, R.color.CAM_X0201);
        SvgManager.btW().a(this.jty, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cDz();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.at
    public void bvq() {
        cJG();
        if (this.jbN != null) {
            this.jbN.gn(this.jcj);
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
            if (this.jtz != null) {
                this.jtz.setData(dVar.jcl, dVar.jcm, dVar.jcn);
            }
            if (this.jtA != null && this.jbO != null && this.jbO.getForum() != null) {
                this.jtA.a(dVar.jco, this.jbO.getForum().getId());
            }
            if (this.jbN != null && this.jbN.cFy()) {
                yZ(dVar.jck);
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
                                this.jcj = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jtB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jbM != null) {
            this.jbM.lx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cJF() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jtv == null) {
            this.jtv = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jtv.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gwK.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jtw == null) {
            this.jtw = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jtx == null) {
            this.jtx = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.iVu == null) {
            this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVu.setOnClickListener(this.iVH);
            this.mBackImageView = (ImageView) this.iVu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jty == null) {
            this.jty = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gpu == null) {
            this.gpu = new NoNetworkView(getContext());
            this.gpu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jtv.addView(this.gpu);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gpu.setVisibility(8);
        } else {
            this.gpu.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jbO != null && this.jbO.getForum() != null) {
            String name = this.jbO.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 14) {
                name = au.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.jtw != null && this.jtx != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jtw.setVisibility(8);
                this.jtx.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jtw.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jtx.getLayoutParams();
            if (this.jbM.cFw().getFirstCompletelyVisiblePosition() != 0) {
                this.jtw.setVisibility(8);
                this.jtx.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Zj.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jtw.setVisibility(0);
                this.jtx.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jtw.setVisibility(8);
                this.jtx.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jtw.setVisibility(0);
                this.jtx.setVisibility(8);
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
                if (this.jty != null && (this.jty.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jty.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bHy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDz() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jty != null) {
                this.jty.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bHy != null) {
                this.bHy.setAlpha(f);
            }
            if (this.iVT != null) {
                this.iVT.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bHy != null && this.iVT != null && this.bHy.getLayoutParams() != null && this.iVT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bHy.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bHy.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.iVT.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.iVT.setLayoutParams(layoutParams2);
        }
    }

    private void yZ(int i) {
        String string;
        if (this.jla == null) {
            this.jla = new TextView(getContext());
            this.jla.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jla.setGravity(17);
        }
        if (this.jla != null) {
            if (this.jtB) {
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
            this.jla.setText(string);
        }
        ap.setBackgroundResource(this.jla, R.color.CAM_X0302);
        ap.setViewTextColor(this.jla, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jqD == null) {
            this.jqD = new be();
        }
        this.jqD.a(this.jla, this.eje, layoutParams, 2000);
    }

    private void cJG() {
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
