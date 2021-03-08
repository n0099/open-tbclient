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
    private AppBarLayout abf;
    private View bMJ;
    private FrameLayout erd;
    private CollapsingToolbarLayout gHR;
    private NoNetworkView gzT;
    private TextView jAy;
    private bb jFX;
    private ObservedChangeLinearLayout jIN;
    private View jIO;
    private View jIP;
    private ImageView jIQ;
    private a jIR;
    private b jIS;
    private int jIU;
    private View jkF;
    private View jle;
    private long jrz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jIT = true;
    public final View.OnClickListener jkS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.jkF != null && view == FrsSportsRecommendFragment.this.jkF) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gIo = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.abf.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jra.setSelection(0);
                    FrsSportsRecommendFragment.this.bSD();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jIV = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jIU != i) {
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
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jIU - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yE(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.jle != null) {
                                FrsSportsRecommendFragment.this.jle.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.jle != null && FrsSportsRecommendFragment.this.bMJ != null) {
                            if (FrsSportsRecommendFragment.this.bMJ.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yE(0);
                            }
                            FrsSportsRecommendFragment.this.jle.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cEc();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.jIU = i;
                        FrsSportsRecommendFragment.this.zi(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gIo);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jra.rb(true);
        cKp();
        this.gHR = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bMJ = this.mRootView.findViewById(R.id.statebar_view);
        this.jle = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.abf = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.abf.addOnOffsetChangedListener(this.jIV);
        Uk();
        this.jIR = new a(this, this.mRootView);
        this.jIR.h(this.jrc);
        this.jIS = new b(this, this.mRootView);
        if (this.jrb != null) {
            this.jrb.gs(0L);
        }
        this.erd = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.jhg = currentTimeMillis + frsActivity.jhg;
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
                frsActivity.jhg = currentTimeMillis + frsActivity.jhg;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jIR != null) {
            this.jIR.onChangeSkinType();
        }
        if (this.jIS != null) {
            this.jIS.onChangeSkinType();
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jIO, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jIP, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bMJ, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jle, R.color.CAM_X0201);
        SvgManager.bsU().a(this.jIQ, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsU().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cEc();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.aq
    public void bup() {
        cKq();
        if (this.jrb != null) {
            this.jrb.gs(this.jrz);
        }
        super.bup();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jIR != null) {
                this.jIR.setData(dVar.jrC, dVar.jrD, dVar.jrE);
            }
            if (this.jIS != null && this.jrc != null && this.jrc.getForum() != null) {
                this.jIS.a(dVar.jrF, this.jrc.getForum().getId());
            }
            if (this.jrb != null && this.jrb.cGe()) {
                xR(dVar.jrB);
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
                                this.jrz = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jIT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jra != null) {
            this.jra.lU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cKp() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jIN == null) {
            this.jIN = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jIN.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gHR.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jIO == null) {
            this.jIO = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jIP == null) {
            this.jIP = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.jkF == null) {
            this.jkF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jkF.setOnClickListener(this.jkS);
            this.mBackImageView = (ImageView) this.jkF.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jIQ == null) {
            this.jIQ = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gzT == null) {
            this.gzT = new NoNetworkView(getContext());
            this.gzT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jIN.addView(this.gzT);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gzT.setVisibility(8);
        } else {
            this.gzT.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jrc != null && this.jrc.getForum() != null) {
            String name = this.jrc.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 14) {
                name = au.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.jIO != null && this.jIP != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jIO.setVisibility(8);
                this.jIP.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jIO.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jIP.getLayoutParams();
            if (this.jra.cGb().getFirstCompletelyVisiblePosition() != 0) {
                this.jIO.setVisibility(8);
                this.jIP.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.abf.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jIO.setVisibility(0);
                this.jIP.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jIO.setVisibility(8);
                this.jIP.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jIO.setVisibility(0);
                this.jIP.setVisibility(8);
            }
        }
    }

    private void Uk() {
        if (this.bMJ != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bMJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMJ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMJ.setLayoutParams(layoutParams);
                this.bMJ.setVisibility(0);
                if (this.jIQ != null && (this.jIQ.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jIQ.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bMJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEc() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jIQ != null) {
                this.jIQ.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bMJ != null) {
                this.bMJ.setAlpha(f);
            }
            if (this.jle != null) {
                this.jle.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bMJ != null && this.jle != null && this.bMJ.getLayoutParams() != null && this.jle.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bMJ.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bMJ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.jle.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.jle.setLayoutParams(layoutParams2);
        }
    }

    private void xR(int i) {
        String string;
        if (this.jAy == null) {
            this.jAy = new TextView(getContext());
            this.jAy.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jAy.setGravity(17);
        }
        if (this.jAy != null) {
            if (this.jIT) {
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
            this.jAy.setText(string);
        }
        ap.setBackgroundResource(this.jAy, R.color.CAM_X0302);
        ap.setViewTextColor(this.jAy, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jFX == null) {
            this.jFX = new bb();
        }
        this.jFX.a(this.jAy, this.erd, layoutParams, 2000);
    }

    private void cKq() {
        this.abf.setExpanded(true);
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
        super.showNetRefreshView(this.erd, str, z);
        zi(0);
    }
}
