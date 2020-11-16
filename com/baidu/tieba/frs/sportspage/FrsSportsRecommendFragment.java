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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Ym;
    private View bCq;
    private FrameLayout ecd;
    private NoNetworkView ghk;
    private CollapsingToolbarLayout goB;
    private View iKB;
    private View iLa;
    private long iRr;
    private TextView iXB;
    private be jda;
    private ObservedChangeLinearLayout jfS;
    private View jfT;
    private View jfU;
    private ImageView jfV;
    private a jfW;
    private b jfX;
    private int jfZ;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jfY = true;
    public final View.OnClickListener iKO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.iKB != null && view == FrsSportsRecommendFragment.this.iKB) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener goZ = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Ym.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.iQU.setSelection(0);
                    FrsSportsRecommendFragment.this.bPo();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jga = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jfZ != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.ghk == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.ghk.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jfZ - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.zh(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.iLa != null) {
                                FrsSportsRecommendFragment.this.iLa.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.iLa != null && FrsSportsRecommendFragment.this.bCq != null) {
                            if (FrsSportsRecommendFragment.this.bCq.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.zh(0);
                            }
                            FrsSportsRecommendFragment.this.iLa.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.czi();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.jfZ = i;
                        FrsSportsRecommendFragment.this.zM(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.goZ);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.iQU.qa(true);
        cEs();
        this.goB = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bCq = this.mRootView.findViewById(R.id.statebar_view);
        this.iLa = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Ym = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Ym.addOnOffsetChangedListener(this.jga);
        SQ();
        this.jfW = new a(this, this.mRootView);
        this.jfW.h(this.iQW);
        this.jfX = new b(this, this.mRootView);
        if (this.iQV != null) {
            this.iQV.fJ(0L);
        }
        this.ecd = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.iHd = currentTimeMillis + frsActivity.iHd;
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
                frsActivity.iHd = currentTimeMillis + frsActivity.iHd;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jfW != null) {
            this.jfW.onChangeSkinType();
        }
        if (this.jfX != null) {
            this.jfX.onChangeSkinType();
        }
        if (this.ghk != null) {
            this.ghk.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jfT, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jfU, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bCq, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iLa, R.color.CAM_X0201);
        SvgManager.bqB().a(this.jfV, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bqB().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        czi();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.au
    public void brR() {
        cEt();
        if (this.iQV != null) {
            this.iQV.fJ(this.iRr);
        }
        super.brR();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jfW != null) {
                this.jfW.setData(dVar.iRt, dVar.iRu, dVar.iRv);
            }
            if (this.jfX != null && this.iQW != null && this.iQW.getForum() != null) {
                this.jfX.a(dVar.iRw, this.iQW.getForum().getId());
            }
            if (this.iQV != null && this.iQV.cBi()) {
                yu(dVar.iRs);
            }
            if (!y.isEmpty(dVar.threadList)) {
                Iterator<q> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof bx) {
                        bx bxVar = (bx) next;
                        if (bxVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bxVar.getId(), 0L);
                            if (j > 0) {
                                this.iRr = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jfY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.iQU != null) {
            this.iQU.ld(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cEs() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jfS == null) {
            this.jfS = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jfS.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.goB.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jfT == null) {
            this.jfT = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jfU == null) {
            this.jfU = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.iKB == null) {
            this.iKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iKB.setOnClickListener(this.iKO);
            this.mBackImageView = (ImageView) this.iKB.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jfV == null) {
            this.jfV = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.ghk == null) {
            this.ghk = new NoNetworkView(getContext());
            this.ghk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jfS.addView(this.ghk);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.ghk.setVisibility(8);
        } else {
            this.ghk.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.iQW != null && this.iQW.getForum() != null) {
            String name = this.iQW.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 14) {
                name = au.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.jfT != null && this.jfU != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jfT.setVisibility(8);
                this.jfU.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jfT.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jfU.getLayoutParams();
            if (this.iQU.cBg().getFirstCompletelyVisiblePosition() != 0) {
                this.jfT.setVisibility(8);
                this.jfU.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Ym.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jfT.setVisibility(0);
                this.jfU.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jfT.setVisibility(8);
                this.jfU.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jfT.setVisibility(0);
                this.jfU.setVisibility(8);
            }
        }
    }

    private void SQ() {
        if (this.bCq != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bCq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bCq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bCq.setLayoutParams(layoutParams);
                this.bCq.setVisibility(0);
                if (this.jfV != null && (this.jfV.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jfV.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bCq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czi() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jfV != null) {
                this.jfV.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bCq != null) {
                this.bCq.setAlpha(f);
            }
            if (this.iLa != null) {
                this.iLa.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bCq != null && this.iLa != null && this.bCq.getLayoutParams() != null && this.iLa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bCq.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bCq.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.iLa.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.iLa.setLayoutParams(layoutParams2);
        }
    }

    private void yu(int i) {
        String string;
        if (this.iXB == null) {
            this.iXB = new TextView(getContext());
            this.iXB.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.iXB.setGravity(17);
        }
        if (this.iXB != null) {
            if (this.jfY) {
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
            this.iXB.setText(string);
        }
        ap.setBackgroundResource(this.iXB, R.color.CAM_X0302);
        ap.setViewTextColor(this.iXB, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jda == null) {
            this.jda = new be();
        }
        this.jda.a(this.iXB, this.ecd, layoutParams, 2000);
    }

    private void cEt() {
        this.Ym.setExpanded(true);
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
        super.showNetRefreshView(this.ecd, str, z);
        zM(0);
    }
}
