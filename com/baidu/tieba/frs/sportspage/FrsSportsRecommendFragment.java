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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
    private AppBarLayout ZS;
    private View bMl;
    private FrameLayout esi;
    private CollapsingToolbarLayout gHQ;
    private NoNetworkView gzT;
    private bb jDb;
    private ObservedChangeLinearLayout jFS;
    private View jFT;
    private View jFU;
    private ImageView jFV;
    private a jFW;
    private b jFX;
    private int jFZ;
    private View jhI;
    private View jii;
    private long joC;
    private TextView jxB;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jFY = true;
    public final View.OnClickListener jhV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.jhI != null && view == FrsSportsRecommendFragment.this.jhI) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gIn = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.ZS.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jod.setSelection(0);
                    FrsSportsRecommendFragment.this.bVF();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jGa = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jFZ != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gzT == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gzT.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jFZ - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.zZ(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.jii != null) {
                                FrsSportsRecommendFragment.this.jii.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.jii != null && FrsSportsRecommendFragment.this.bMl != null) {
                            if (FrsSportsRecommendFragment.this.bMl.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.zZ(0);
                            }
                            FrsSportsRecommendFragment.this.jii.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cGv();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.jFZ = i;
                        FrsSportsRecommendFragment.this.AD(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gIn);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jod.qV(true);
        cMH();
        this.gHQ = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bMl = this.mRootView.findViewById(R.id.statebar_view);
        this.jii = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.ZS = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.ZS.addOnOffsetChangedListener(this.jGa);
        Wt();
        this.jFW = new a(this, this.mRootView);
        this.jFW.h(this.jof);
        this.jFX = new b(this, this.mRootView);
        if (this.joe != null) {
            this.joe.gn(0L);
        }
        this.esi = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.jej = currentTimeMillis + frsActivity.jej;
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
                frsActivity.jej = currentTimeMillis + frsActivity.jej;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jFW != null) {
            this.jFW.onChangeSkinType();
        }
        if (this.jFX != null) {
            this.jFX.onChangeSkinType();
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ao.setBackgroundResource(this.jFT, R.drawable.top_shadow);
        ao.setBackgroundResource(this.jFU, R.drawable.top_shadow);
        ao.setBackgroundColor(this.bMl, R.color.CAM_X0201);
        ao.setBackgroundColor(this.jii, R.color.CAM_X0201);
        SvgManager.bwr().a(this.jFV, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bwr().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cGv();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.aq
    public void bxM() {
        cMI();
        if (this.joe != null) {
            this.joe.gn(this.joC);
        }
        super.bxM();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jFW != null) {
                this.jFW.setData(dVar.joF, dVar.joG, dVar.joH);
            }
            if (this.jFX != null && this.jof != null && this.jof.getForum() != null) {
                this.jFX.a(dVar.joI, this.jof.getForum().getId());
            }
            if (this.joe != null && this.joe.cIw()) {
                zm(dVar.joE);
            }
            if (!x.isEmpty(dVar.threadList)) {
                Iterator<n> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next instanceof bz) {
                        bz bzVar = (bz) next;
                        if (bzVar.bsb()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bzVar.getId(), 0L);
                            if (j > 0) {
                                this.joC = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jFY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jod != null) {
            this.jod.lU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cMH() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jFS == null) {
            this.jFS = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jFS.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gHQ.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jFT == null) {
            this.jFT = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jFU == null) {
            this.jFU = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.jhI == null) {
            this.jhI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jhI.setOnClickListener(this.jhV);
            this.mBackImageView = (ImageView) this.jhI.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jFV == null) {
            this.jFV = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gzT == null) {
            this.gzT = new NoNetworkView(getContext());
            this.gzT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jFS.addView(this.gzT);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gzT.setVisibility(8);
        } else {
            this.gzT.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jof != null && this.jof.getForum() != null) {
            String name = this.jof.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.jFT != null && this.jFU != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jFT.setVisibility(8);
                this.jFU.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jFT.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jFU.getLayoutParams();
            if (this.jod.cIt().getFirstCompletelyVisiblePosition() != 0) {
                this.jFT.setVisibility(8);
                this.jFU.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.ZS.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jFT.setVisibility(0);
                this.jFU.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jFT.setVisibility(8);
                this.jFU.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jFT.setVisibility(0);
                this.jFU.setVisibility(8);
            }
        }
    }

    private void Wt() {
        if (this.bMl != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bMl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMl.setLayoutParams(layoutParams);
                this.bMl.setVisibility(0);
                if (this.jFV != null && (this.jFV.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jFV.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bMl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGv() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jFV != null) {
                this.jFV.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bMl != null) {
                this.bMl.setAlpha(f);
            }
            if (this.jii != null) {
                this.jii.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zZ(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bMl != null && this.jii != null && this.bMl.getLayoutParams() != null && this.jii.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bMl.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bMl.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.jii.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.jii.setLayoutParams(layoutParams2);
        }
    }

    private void zm(int i) {
        String string;
        if (this.jxB == null) {
            this.jxB = new TextView(getContext());
            this.jxB.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jxB.setGravity(17);
        }
        if (this.jxB != null) {
            if (this.jFY) {
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
            this.jxB.setText(string);
        }
        ao.setBackgroundResource(this.jxB, R.color.CAM_X0302);
        ao.setViewTextColor(this.jxB, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jDb == null) {
            this.jDb = new bb();
        }
        this.jDb.a(this.jxB, this.esi, layoutParams, 2000);
    }

    private void cMI() {
        this.ZS.setExpanded(true);
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
        super.showNetRefreshView(this.esi, str, z);
        AD(0);
    }
}
