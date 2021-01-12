package com.baidu.tieba.ala.charm;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.r;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.charm.c;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import com.baidu.tieba.ala.charm.view.CharmRankTotalHeaderView;
import java.util.List;
/* loaded from: classes10.dex */
public class CharmRankTotalActivity extends BaseActivity implements View.OnTouchListener {
    private TextView aVl;
    private CharmRankTotalHeaderView gKR;
    private PbListView gKS;
    private com.baidu.tieba.ala.charm.view.e gKT;
    private c gKU;
    private BdListView mListView;
    private View mRootView;
    private int mScreenWidth;
    private boolean aTo = false;
    private boolean aXA = false;
    private boolean aXB = false;
    private ViewTreeObserver.OnGlobalLayoutListener aXw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.6
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(CharmRankTotalActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != CharmRankTotalActivity.this.mScreenWidth) {
                CharmRankTotalActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    CharmRankTotalActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.ae(CharmRankTotalActivity.this.mRootView);
                        }
                    }, 300L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        initView();
        setContentView(this.mRootView);
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.aXA = false;
        this.mRootView.setVisibility(4);
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            i.ae(this.mRootView);
        }
        EN();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ts();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTo) {
            this.mRootView.setVisibility(0);
            EL();
            this.aTo = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            z = true;
            if (view != this.mRootView) {
                finish();
            }
        }
        return z;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.mRootView);
                r.e(getActivity(), false);
            } else {
                i.af(this.mRootView);
                r.e(getActivity(), true);
            }
            Ts();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gKU != null) {
            this.gKU.release();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXw);
        this.aXw = null;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        EM();
    }

    private void Ts() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            this.mScreenWidth = screenDimensions[0];
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky() && screenDimensions[1] > screenDimensions[0]) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXw);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                    if (this.mRootView instanceof RoundRectRelativeLayout) {
                        ((RoundRectRelativeLayout) this.mRootView).setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
                    }
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                    if (this.mRootView instanceof RoundRectRelativeLayout) {
                        ((RoundRectRelativeLayout) this.mRootView).setCornerRadius(dimensionPixelOffset, 0.0f, 0.0f, dimensionPixelOffset);
                    }
                }
                this.mRootView.setLayoutParams(layoutParams);
            }
        }
    }

    private void EL() {
        Animation loadAnimation;
        this.aXA = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CharmRankTotalActivity.this.aXA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void EM() {
        Animation loadAnimation;
        if (!this.aXB && !this.aXA) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CharmRankTotalActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(CharmRankTotalActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aXB = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this).inflate(a.g.sdk_charm_activity_rank_total, (ViewGroup) null);
        this.mRootView.setClickable(true);
        this.gKR = new CharmRankTotalHeaderView(this.mRootView.getContext());
        this.gKR.setCallback(new CharmRankTotalHeaderView.a() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.3
            @Override // com.baidu.tieba.ala.charm.view.CharmRankTotalHeaderView.a
            public void a(ALaCharmData aLaCharmData) {
                if (CharmRankTotalActivity.this.gKU != null) {
                    CharmRankTotalActivity.this.gKU.a(aLaCharmData);
                }
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.lv);
        this.mListView.addHeaderView(this.gKR);
        BdListView bdListView = this.mListView;
        com.baidu.tieba.ala.charm.view.e eVar = new com.baidu.tieba.ala.charm.view.e();
        this.gKT = eVar;
        bdListView.setAdapter((ListAdapter) eVar);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CharmRankTotalActivity.this.gKU != null && CharmRankTotalActivity.this.gKT != null) {
                    CharmRankTotalActivity.this.gKU.a(CharmRankTotalActivity.this.gKT.getItem(i));
                }
            }
        });
        this.gKS = new PbListView(this);
        this.gKS.setTextColor(getResources().getColor(a.c.sdk_cp_cont_j));
        this.gKS.setSkinType(0);
        this.gKS.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gKS.createView();
        this.aVl = (TextView) this.mRootView.findViewById(a.f.tv_tip);
    }

    private void EN() {
        this.gKU = new b(getPageContext());
        this.gKU.a(getIntent().getStringExtra("user_id"), getIntent().getStringExtra("group_id"), getIntent().getStringExtra("live_id"), getIntent().getBooleanExtra("live_owner_flag", false), getIntent().getStringExtra("live_owner_uid"), getIntent().getStringExtra(IntentConfig.OTHER_PARAMS));
        this.gKU.a(new c.a() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.5
            @Override // com.baidu.tieba.ala.charm.c.a
            public void b(List<ALaCharmData> list, List<ALaCharmData> list2, String str) {
                if (CharmRankTotalActivity.this.gKR != null && CharmRankTotalActivity.this.gKT != null) {
                    CharmRankTotalActivity.this.gKR.setData(list);
                    CharmRankTotalActivity.this.gKT.setData(list2);
                    CharmRankTotalActivity.this.gKT.notifyDataSetChanged();
                    if (CharmRankTotalActivity.this.mListView.getEmptyView() != null) {
                        CharmRankTotalActivity.this.mListView.getEmptyView().setVisibility(8);
                    }
                    CharmRankTotalActivity.this.mListView.setVisibility(0);
                    if (!TextUtils.isEmpty(str)) {
                        CharmRankTotalActivity.this.mListView.setNextPage(CharmRankTotalActivity.this.gKS);
                        CharmRankTotalActivity.this.gKS.endLoadDataWithNoMore(str);
                        CharmRankTotalActivity.this.aVl.setVisibility(8);
                        return;
                    }
                    CharmRankTotalActivity.this.aVl.setVisibility(0);
                }
            }

            @Override // com.baidu.tieba.ala.charm.c.a
            public void tW(String str) {
                CharmRankTotalActivity.this.showToast(str);
                if (CharmRankTotalActivity.this.mListView != null && CharmRankTotalActivity.this.mListView.getEmptyView() == null) {
                    RelativeLayout relativeLayout = (RelativeLayout) CharmRankTotalActivity.this.mListView.getParent();
                    CommonEmptyView commonEmptyView = new CommonEmptyView(relativeLayout.getContext());
                    commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
                    commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.CharmRankTotalActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            CharmRankTotalActivity.this.gKU.bEv();
                        }
                    });
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        commonEmptyView.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
                    } else {
                        commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                    }
                    commonEmptyView.addToParent(relativeLayout);
                    CharmRankTotalActivity.this.mListView.setEmptyView(commonEmptyView);
                }
            }

            @Override // com.baidu.tieba.ala.charm.c.a
            public void onClose() {
                CharmRankTotalActivity.this.finish();
            }
        });
        this.gKU.bEv();
    }
}
