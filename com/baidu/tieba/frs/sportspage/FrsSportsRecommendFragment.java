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
    private AppBarLayout ZQ;
    private View bHz;
    private FrameLayout ent;
    private CollapsingToolbarLayout gDk;
    private NoNetworkView gvm;
    private ObservedChangeLinearLayout jBm;
    private View jBn;
    private View jBo;
    private ImageView jBp;
    private a jBq;
    private b jBr;
    private int jBt;
    private View jdA;
    private View jdb;
    private long jjV;
    private TextView jsV;
    private bb jyv;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jBs = true;
    public final View.OnClickListener jdo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.jdb != null && view == FrsSportsRecommendFragment.this.jdb) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gDH = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.ZQ.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.jjw.setSelection(0);
                    FrsSportsRecommendFragment.this.bRN();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jBu = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jBt != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gvm == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gvm.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jBt - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yt(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.jdA != null) {
                                FrsSportsRecommendFragment.this.jdA.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.jdA != null && FrsSportsRecommendFragment.this.bHz != null) {
                            if (FrsSportsRecommendFragment.this.bHz.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yt(0);
                            }
                            FrsSportsRecommendFragment.this.jdA.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cCD();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.jBt = i;
                        FrsSportsRecommendFragment.this.yX(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gDH);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.jjw.qR(true);
        cIP();
        this.gDk = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bHz = this.mRootView.findViewById(R.id.statebar_view);
        this.jdA = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.ZQ = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.ZQ.addOnOffsetChangedListener(this.jBu);
        SA();
        this.jBq = new a(this, this.mRootView);
        this.jBq.h(this.jjy);
        this.jBr = new b(this, this.mRootView);
        if (this.jjx != null) {
            this.jjx.gn(0L);
        }
        this.ent = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.iZC = currentTimeMillis + frsActivity.iZC;
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
                frsActivity.iZC = currentTimeMillis + frsActivity.iZC;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jBq != null) {
            this.jBq.onChangeSkinType();
        }
        if (this.jBr != null) {
            this.jBr.onChangeSkinType();
        }
        if (this.gvm != null) {
            this.gvm.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ao.setBackgroundResource(this.jBn, R.drawable.top_shadow);
        ao.setBackgroundResource(this.jBo, R.drawable.top_shadow);
        ao.setBackgroundColor(this.bHz, R.color.CAM_X0201);
        ao.setBackgroundColor(this.jdA, R.color.CAM_X0201);
        SvgManager.bsx().a(this.jBp, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsx().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cCD();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.aq
    public void btS() {
        cIQ();
        if (this.jjx != null) {
            this.jjx.gn(this.jjV);
        }
        super.btS();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jBq != null) {
                this.jBq.setData(dVar.jjY, dVar.jjZ, dVar.jka);
            }
            if (this.jBr != null && this.jjy != null && this.jjy.getForum() != null) {
                this.jBr.a(dVar.jkb, this.jjy.getForum().getId());
            }
            if (this.jjx != null && this.jjx.cEE()) {
                xG(dVar.jjX);
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
                        if (bzVar.boh()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bzVar.getId(), 0L);
                            if (j > 0) {
                                this.jjV = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jBs = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.jjw != null) {
            this.jjw.lQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cIP() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jBm == null) {
            this.jBm = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jBm.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gDk.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jBn == null) {
            this.jBn = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jBo == null) {
            this.jBo = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.jdb == null) {
            this.jdb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jdb.setOnClickListener(this.jdo);
            this.mBackImageView = (ImageView) this.jdb.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jBp == null) {
            this.jBp = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gvm == null) {
            this.gvm = new NoNetworkView(getContext());
            this.gvm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jBm.addView(this.gvm);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gvm.setVisibility(8);
        } else {
            this.gvm.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.jjy != null && this.jjy.getForum() != null) {
            String name = this.jjy.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.jBn != null && this.jBo != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jBn.setVisibility(8);
                this.jBo.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jBn.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jBo.getLayoutParams();
            if (this.jjw.cEB().getFirstCompletelyVisiblePosition() != 0) {
                this.jBn.setVisibility(8);
                this.jBo.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.ZQ.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jBn.setVisibility(0);
                this.jBo.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jBn.setVisibility(8);
                this.jBo.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jBn.setVisibility(0);
                this.jBo.setVisibility(8);
            }
        }
    }

    private void SA() {
        if (this.bHz != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bHz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHz.setLayoutParams(layoutParams);
                this.bHz.setVisibility(0);
                if (this.jBp != null && (this.jBp.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jBp.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bHz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCD() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jBp != null) {
                this.jBp.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bHz != null) {
                this.bHz.setAlpha(f);
            }
            if (this.jdA != null) {
                this.jdA.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bHz != null && this.jdA != null && this.bHz.getLayoutParams() != null && this.jdA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bHz.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bHz.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.jdA.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.jdA.setLayoutParams(layoutParams2);
        }
    }

    private void xG(int i) {
        String string;
        if (this.jsV == null) {
            this.jsV = new TextView(getContext());
            this.jsV.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.jsV.setGravity(17);
        }
        if (this.jsV != null) {
            if (this.jBs) {
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
            this.jsV.setText(string);
        }
        ao.setBackgroundResource(this.jsV, R.color.CAM_X0302);
        ao.setViewTextColor(this.jsV, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jyv == null) {
            this.jyv = new bb();
        }
        this.jyv.a(this.jsV, this.ent, layoutParams, 2000);
    }

    private void cIQ() {
        this.ZQ.setExpanded(true);
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
        super.showNetRefreshView(this.ent, str, z);
        yX(0);
    }
}
