package com.baidu.tieba.ala;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.h;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.adapter.AlaRankListFragmentAdapter;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class AlaRankListActivity extends BaseActivity implements View.OnTouchListener {
    private ImageView aBA;
    private AlaLiveRoomPanelTabHost aBu;
    private int aED;
    private String aTc;
    private TextView fvB;
    private long fvC;
    private String fvD;
    private String fvE;
    private boolean fvF;
    private ImageView fvG;
    private AlaRankListFragmentAdapter fvH;
    private int fvI;
    private TextView fvJ;
    private String mPortrait;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private String mUserName;
    private String otherParams;
    private Handler mHandler = new Handler();
    private boolean aND = false;
    private boolean aQY = false;
    private boolean aQZ = false;
    private CustomMessageListener aNT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaRankListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aNU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaRankListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aQU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.7
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaRankListActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaRankListActivity.this.mScreenWidth) {
                AlaRankListActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaRankListActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaRankListActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaRankListActivity.this.mRootView != null) {
                                h.Y(AlaRankListActivity.this.mRootView);
                                q.e(AlaRankListActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (bundle != null) {
                this.aED = bundle.getInt("live_type", 1);
                this.mUserId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.mUserName = bundle.getString(TbEnum.SystemMessage.KEY_USER_NAME, "");
                this.fvE = bundle.getString("rank_list_type", "");
                this.fvF = bundle.getBoolean("rank_list_from");
                this.mPortrait = bundle.getString("portrait", "");
                this.otherParams = bundle.getString(IntentConfig.OTHER_PARAMS, "");
                this.aTc = bundle.getString("feed_id", "");
                this.fvC = bundle.getLong("cur_live_id", -1L);
                this.fvD = bundle.getString("cur_hour", "");
            } else {
                this.aED = getIntent().getIntExtra("live_type", 1);
                this.mUserId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.mUserName = getIntent().getStringExtra(TbEnum.SystemMessage.KEY_USER_NAME);
                this.fvE = getIntent().getStringExtra("rank_list_type");
                this.fvF = getIntent().getBooleanExtra("rank_list_from", false);
                this.mPortrait = getIntent().getStringExtra("portrait");
                this.aTc = getIntent().getStringExtra("feed_id");
                this.fvC = getIntent().getLongExtra("cur_live_id", -1L);
                this.fvD = getIntent().getStringExtra("cur_hour");
                this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
            }
            registerListener(this.aNU);
            registerListener(this.aNT);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aQY = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aND) {
            this.mRootView.setVisibility(0);
            FD();
            this.aND = true;
        }
    }

    private void FD() {
        Animation loadAnimation;
        this.aQY = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaRankListActivity.this.aQY = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void FE() {
        Animation loadAnimation;
        if (!this.aQZ && !this.aQY) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaRankListActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaRankListActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aQZ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        FE();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.Y(this.mRootView);
                q.e(getActivity(), false);
            } else {
                h.Z(this.mRootView);
                q.e(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_landscape_corner_bg);
            } else {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_top_corner_bg);
            }
            bDu();
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_rank_list_layout, (ViewGroup) null);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.f.ala_rank_list_landscape_corner_bg);
        } else {
            this.mRootView.setBackgroundResource(a.f.ala_rank_list_top_corner_bg);
        }
        setContentView(this.mRootView);
        this.aBA = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_back);
        this.fvJ = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_title);
        this.fvB = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_full_entrance);
        this.fvJ.setText(a.i.hkqm_rank_list_sub_panel_title);
        this.fvB.setVisibility(4);
        this.aBA.setVisibility(8);
        this.fvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.AlaRankListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.w.a.Nk().beH.aFV)) {
                    TiebaInitialize.log(new StatisticItem("c12964"));
                    UrlManager.getInstance().dealOneLink(AlaRankListActivity.this.getPageContext(), new String[]{com.baidu.live.w.a.Nk().beH.aFV}, true);
                }
            }
        });
        this.fvG = (ImageView) this.mRootView.findViewById(a.g.rule_icon);
        this.fvG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string;
                LogManager.getCommonLogger().doClickHourRankRuleIconLog(AlaRankListActivity.this.aTc, AlaRankListActivity.this.otherParams);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    string = com.baidu.live.c.AD().getString("hour_rank_rule_hk_190808", "");
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    string = com.baidu.live.c.AD().getString("hour_rank_rule_qm_190808", "");
                } else {
                    string = com.baidu.live.c.AD().getString("hour_rank_rule_default", "");
                }
                BrowserHelper.startInternalWebActivity(AlaRankListActivity.this.getPageContext().getPageActivity(), string);
            }
        });
        initTabSpec();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.Y(this.mRootView);
            q.e(getActivity(), false);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.aED);
        bundle.putString("rank_list_type", this.fvE);
        bundle.putBoolean("rank_list_from", this.fvF);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString("feed_id", this.aTc);
        bundle.putLong("cur_live_id", this.fvC);
        bundle.putString("cur_hour", this.fvD);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.aED);
        bundle.putString("rank_list_type", this.fvE);
        bundle.putBoolean("rank_list_from", this.fvF);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
        bundle.putString("feed_id", this.aTc);
        bundle.putLong("cur_live_id", this.fvC);
        bundle.putString("cur_hour", this.fvD);
        super.onRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bDu();
    }

    private void bDu() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (screenDimensions[1] > screenDimensions[0]) {
                    attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                    attributes.gravity = 80;
                } else {
                    attributes.height = screenDimensions[1];
                    attributes.gravity = 48;
                }
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aQU);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.mRootView.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view == this.mRootView) {
                return true;
            }
            setResult(0);
            finish();
            return true;
        }
        return false;
    }

    private void initTabSpec() {
        this.fvH = new AlaRankListFragmentAdapter(this, this.aED, this.mUserId, this.mUserName, this.fvF, this.mPortrait, this.otherParams, this.aTc, this.fvC, this.fvD);
        this.fvI = this.fvH.Eb(this.fvE);
        this.aBu = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aBu.setIndicatorWidthAuto(true);
        this.aBu.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.AlaRankListActivity.8
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaRankListActivity.this.fvH.sq(i);
            }
        });
        this.aBu.setData(this.fvH.getDataList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<com.baidu.live.liveroom.d.d> it = this.fvH.getDataList().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aQU);
        this.aQU = null;
    }
}
