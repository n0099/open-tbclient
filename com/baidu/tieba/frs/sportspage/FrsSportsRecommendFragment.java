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
    private CollapsingToolbarLayout gGi;
    private NoNetworkView gyk;
    private bb jEo;
    private ObservedChangeLinearLayout jHe;
    private View jHf;
    private View jHg;
    private ImageView jHh;
    private a jHi;
    private b jHj;
    private int jHl;
    private View jiW;
    private View jjv;
    private long jpQ;
    private TextView jyP;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jHk = true;
    public final View.OnClickListener jjj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.jiW != null && view == FrsSportsRecommendFragment.this.jiW) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gGF = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.ZM.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jpr.setSelection(0);
                    FrsSportsRecommendFragment.this.bSx();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jHm = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jHl != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gyk == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gyk.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jHl - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yD(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.jjv != null) {
                                FrsSportsRecommendFragment.this.jjv.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.jjv != null && FrsSportsRecommendFragment.this.bLj != null) {
                            if (FrsSportsRecommendFragment.this.bLj.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yD(0);
                            }
                            FrsSportsRecommendFragment.this.jjv.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cDW();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.jHl = i;
                        FrsSportsRecommendFragment.this.zh(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gGF);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jpr.rb(true);
        cKj();
        this.gGi = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bLj = this.mRootView.findViewById(R.id.statebar_view);
        this.jjv = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.ZM = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.ZM.addOnOffsetChangedListener(this.jHm);
        Uh();
        this.jHi = new a(this, this.mRootView);
        this.jHi.h(this.jpt);
        this.jHj = new b(this, this.mRootView);
        if (this.jps != null) {
            this.jps.gs(0L);
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
                frsActivity.jfx = currentTimeMillis + frsActivity.jfx;
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
                frsActivity.jfx = currentTimeMillis + frsActivity.jfx;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jHi != null) {
            this.jHi.onChangeSkinType();
        }
        if (this.jHj != null) {
            this.jHj.onChangeSkinType();
        }
        if (this.gyk != null) {
            this.gyk.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jHf, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jHg, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bLj, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jjv, R.color.CAM_X0201);
        SvgManager.bsR().a(this.jHh, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cDW();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.aq
    public void bum() {
        cKk();
        if (this.jps != null) {
            this.jps.gs(this.jpQ);
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
            if (this.jHi != null) {
                this.jHi.setData(dVar.jpT, dVar.jpU, dVar.jpV);
            }
            if (this.jHj != null && this.jpt != null && this.jpt.getForum() != null) {
                this.jHj.a(dVar.jpW, this.jpt.getForum().getId());
            }
            if (this.jps != null && this.jps.cFY()) {
                xQ(dVar.jpS);
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
                                this.jpQ = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jHk = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jpr != null) {
            this.jpr.lU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cKj() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jHe == null) {
            this.jHe = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jHe.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gGi.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jHf == null) {
            this.jHf = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jHg == null) {
            this.jHg = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.jiW == null) {
            this.jiW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jiW.setOnClickListener(this.jjj);
            this.mBackImageView = (ImageView) this.jiW.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jHh == null) {
            this.jHh = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gyk == null) {
            this.gyk = new NoNetworkView(getContext());
            this.gyk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jHe.addView(this.gyk);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gyk.setVisibility(8);
        } else {
            this.gyk.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jpt != null && this.jpt.getForum() != null) {
            String name = this.jpt.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 14) {
                name = au.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.jHf != null && this.jHg != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jHf.setVisibility(8);
                this.jHg.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jHf.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jHg.getLayoutParams();
            if (this.jpr.cFV().getFirstCompletelyVisiblePosition() != 0) {
                this.jHf.setVisibility(8);
                this.jHg.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.ZM.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jHf.setVisibility(0);
                this.jHg.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jHf.setVisibility(8);
                this.jHg.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jHf.setVisibility(0);
                this.jHg.setVisibility(8);
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
                if (this.jHh != null && (this.jHh.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jHh.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bLj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDW() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jHh != null) {
                this.jHh.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bLj != null) {
                this.bLj.setAlpha(f);
            }
            if (this.jjv != null) {
                this.jjv.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bLj != null && this.jjv != null && this.bLj.getLayoutParams() != null && this.jjv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bLj.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bLj.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.jjv.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.jjv.setLayoutParams(layoutParams2);
        }
    }

    private void xQ(int i) {
        String string;
        if (this.jyP == null) {
            this.jyP = new TextView(getContext());
            this.jyP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jyP.setGravity(17);
        }
        if (this.jyP != null) {
            if (this.jHk) {
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
            this.jyP.setText(string);
        }
        ap.setBackgroundResource(this.jyP, R.color.CAM_X0302);
        ap.setViewTextColor(this.jyP, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jEo == null) {
            this.jEo = new bb();
        }
        this.jEo.a(this.jyP, this.epC, layoutParams, 2000);
    }

    private void cKk() {
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
