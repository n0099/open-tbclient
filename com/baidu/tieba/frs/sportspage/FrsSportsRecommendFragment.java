package com.baidu.tieba.frs.sportspage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout ZM;
    private View bLj;
    private FrameLayout epC;
    private CollapsingToolbarLayout gFU;
    private NoNetworkView gxW;
    private bb jEa;
    private ObservedChangeLinearLayout jGQ;
    private View jGR;
    private View jGS;
    private ImageView jGT;
    private a jGU;
    private b jGV;
    private int jGX;
    private View jiI;
    private View jjh;
    private long jpC;
    private TextView jyB;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jGW = true;
    public final View.OnClickListener jiV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.jiI != null && view == FrsSportsRecommendFragment.this.jiI) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gGr = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.ZM.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jpd.setSelection(0);
                    FrsSportsRecommendFragment.this.bSq();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jGY = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jGX != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gxW == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gxW.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jGX - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yD(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.jjh != null) {
                                FrsSportsRecommendFragment.this.jjh.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.jjh != null && FrsSportsRecommendFragment.this.bLj != null) {
                            if (FrsSportsRecommendFragment.this.bLj.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yD(0);
                            }
                            FrsSportsRecommendFragment.this.jjh.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cDP();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.jGX = i;
                        FrsSportsRecommendFragment.this.zh(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gGr);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jpd.rb(true);
        cKc();
        this.gFU = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bLj = this.mRootView.findViewById(R.id.statebar_view);
        this.jjh = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.ZM = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.ZM.addOnOffsetChangedListener(this.jGY);
        Uh();
        this.jGU = new a(this, this.mRootView);
        this.jGU.h(this.jpf);
        this.jGV = new b(this, this.mRootView);
        if (this.jpe != null) {
            this.jpe.gs(0L);
        }
        this.epC = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.jfj = currentTimeMillis + frsActivity.jfj;
            }
        }
        super.onPrimary();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.jfj = currentTimeMillis + frsActivity.jfj;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jGU != null) {
            this.jGU.onChangeSkinType();
        }
        if (this.jGV != null) {
            this.jGV.onChangeSkinType();
        }
        if (this.gxW != null) {
            this.gxW.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jGR, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jGS, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bLj, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jjh, R.color.CAM_X0201);
        SvgManager.bsR().a(this.jGT, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cDP();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.aq
    public void bum() {
        cKd();
        if (this.jpe != null) {
            this.jpe.gs(this.jpC);
        }
        super.bum();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jGU != null) {
                this.jGU.setData(dVar.jpF, dVar.jpG, dVar.jpH);
            }
            if (this.jGV != null && this.jpf != null && this.jpf.getForum() != null) {
                this.jGV.a(dVar.jpI, this.jpf.getForum().getId());
            }
            if (this.jpe != null && this.jpe.cFR()) {
                xQ(dVar.jpE);
            }
            if (!y.isEmpty(dVar.threadList)) {
                Iterator<n> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next instanceof cb) {
                        cb cbVar = (cb) next;
                        if (cbVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(cbVar.getId(), 0L);
                            if (j > 0) {
                                this.jpC = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jGW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jpd != null) {
            this.jpd.lU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cKc() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jGQ == null) {
            this.jGQ = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jGQ.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gFU.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jGR == null) {
            this.jGR = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jGS == null) {
            this.jGS = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.jiI == null) {
            this.jiI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jiI.setOnClickListener(this.jiV);
            this.mBackImageView = (ImageView) this.jiI.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jGT == null) {
            this.jGT = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gxW == null) {
            this.gxW = new NoNetworkView(getContext());
            this.gxW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jGQ.addView(this.gxW);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gxW.setVisibility(8);
        } else {
            this.gxW.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jpf != null && this.jpf.getForum() != null) {
            String name = this.jpf.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 14) {
                name = au.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.jGR != null && this.jGS != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jGR.setVisibility(8);
                this.jGS.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jGR.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jGS.getLayoutParams();
            if (this.jpd.cFO().getFirstCompletelyVisiblePosition() != 0) {
                this.jGR.setVisibility(8);
                this.jGS.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.ZM.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jGR.setVisibility(0);
                this.jGS.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jGR.setVisibility(8);
                this.jGS.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jGR.setVisibility(0);
                this.jGS.setVisibility(8);
            }
        }
    }

    private void Uh() {
        if (this.bLj != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bLj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bLj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bLj.setLayoutParams(layoutParams);
                this.bLj.setVisibility(0);
                if (this.jGT != null && (this.jGT.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jGT.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bLj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDP() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jGT != null) {
                this.jGT.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bLj != null) {
                this.bLj.setAlpha(f);
            }
            if (this.jjh != null) {
                this.jjh.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bLj != null && this.jjh != null && this.bLj.getLayoutParams() != null && this.jjh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bLj.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bLj.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.jjh.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.jjh.setLayoutParams(layoutParams2);
        }
    }

    private void xQ(int i) {
        String string;
        if (this.jyB == null) {
            this.jyB = new TextView(getContext());
            this.jyB.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jyB.setGravity(17);
        }
        if (this.jyB != null) {
            if (this.jGW) {
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
            this.jyB.setText(string);
        }
        ap.setBackgroundResource(this.jyB, R.color.CAM_X0302);
        ap.setViewTextColor(this.jyB, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jEa == null) {
            this.jEa = new bb();
        }
        this.jEa.a(this.jyB, this.epC, layoutParams, 2000);
    }

    private void cKd() {
        this.ZM.setExpanded(true);
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
        super.showNetRefreshView(this.epC, str, z);
        zh(0);
    }
}
