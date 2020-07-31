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
/* loaded from: classes4.dex */
public class AlaRankListActivity extends BaseActivity implements View.OnTouchListener {
    private String aNP;
    private AlaLiveRoomPanelTabHost aws;
    private ImageView awy;
    private int azs;
    private TextView fkf;
    private long fkg;
    private String fkh;
    private String fki;
    private boolean fkj;
    private ImageView fkk;
    private AlaRankListFragmentAdapter fkl;
    private int fkm;
    private TextView fkn;
    private String mPortrait;
    private View mRootView;
    private int mScreenWidth;
    private long mUserId;
    private String mUserName;
    private String otherParams;
    private Handler mHandler = new Handler();
    private boolean aIs = false;
    private boolean aLL = false;
    private boolean aLM = false;
    private CustomMessageListener aII = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaRankListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aIJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaRankListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRankListActivity.this.closeActivity();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aLH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.7
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
                                h.X(AlaRankListActivity.this.mRootView);
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
                this.azs = bundle.getInt("live_type", 1);
                this.mUserId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.mUserName = bundle.getString(TbEnum.SystemMessage.KEY_USER_NAME, "");
                this.fki = bundle.getString("rank_list_type", "");
                this.fkj = bundle.getBoolean("rank_list_from");
                this.mPortrait = bundle.getString("portrait", "");
                this.otherParams = bundle.getString(IntentConfig.OTHER_PARAMS, "");
                this.aNP = bundle.getString("feed_id", "");
                this.fkg = bundle.getLong("cur_live_id", -1L);
                this.fkh = bundle.getString("cur_hour", "");
            } else {
                this.azs = getIntent().getIntExtra("live_type", 1);
                this.mUserId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                this.mUserName = getIntent().getStringExtra(TbEnum.SystemMessage.KEY_USER_NAME);
                this.fki = getIntent().getStringExtra("rank_list_type");
                this.fkj = getIntent().getBooleanExtra("rank_list_from", false);
                this.mPortrait = getIntent().getStringExtra("portrait");
                this.aNP = getIntent().getStringExtra("feed_id");
                this.fkg = getIntent().getLongExtra("cur_live_id", -1L);
                this.fkh = getIntent().getStringExtra("cur_hour");
                this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
            }
            registerListener(this.aIJ);
            registerListener(this.aII);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aLL = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aIs) {
            this.mRootView.setVisibility(0);
            Aa();
            this.aIs = true;
        }
    }

    private void Aa() {
        Animation loadAnimation;
        this.aLL = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaRankListActivity.this.aLL = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ab() {
        Animation loadAnimation;
        if (!this.aLM && !this.aLL) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_out_to_bottom);
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
            this.aLM = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Ab();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                h.X(this.mRootView);
                q.e(getActivity(), false);
            } else {
                h.Y(this.mRootView);
                q.e(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_landscape_corner_bg);
            } else {
                this.mRootView.setBackgroundResource(a.f.ala_rank_list_top_corner_bg);
            }
            buz();
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
        this.awy = (ImageView) this.mRootView.findViewById(a.g.ala_rank_list_back);
        this.fkn = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_title);
        this.fkf = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_full_entrance);
        this.fkn.setText(a.i.hkqm_rank_list_sub_panel_title);
        this.fkf.setVisibility(4);
        this.awy.setVisibility(8);
        this.fkf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.3
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.AlaRankListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(com.baidu.live.v.a.Hs().aZn.aAL)) {
                    TiebaInitialize.log(new StatisticItem("c12964"));
                    UrlManager.getInstance().dealOneLink(AlaRankListActivity.this.getPageContext(), new String[]{com.baidu.live.v.a.Hs().aZn.aAL}, true);
                }
            }
        });
        this.fkk = (ImageView) this.mRootView.findViewById(a.g.rule_icon);
        this.fkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRankListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string;
                LogManager.getCommonLogger().doClickHourRankRuleIconLog(AlaRankListActivity.this.aNP, AlaRankListActivity.this.otherParams);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    string = com.baidu.live.c.vf().getString("hour_rank_rule_hk_190808", "");
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    string = com.baidu.live.c.vf().getString("hour_rank_rule_qm_190808", "");
                } else {
                    string = com.baidu.live.c.vf().getString("hour_rank_rule_default", "");
                }
                BrowserHelper.startInternalWebActivity(AlaRankListActivity.this.getPageContext().getPageActivity(), string);
            }
        });
        initTabSpec();
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            h.X(this.mRootView);
            q.e(getActivity(), false);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.azs);
        bundle.putString("rank_list_type", this.fki);
        bundle.putBoolean("rank_list_from", this.fkj);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString("feed_id", this.aNP);
        bundle.putLong("cur_live_id", this.fkg);
        bundle.putString("cur_hour", this.fkh);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.mUserId);
        bundle.putInt("live_type", this.azs);
        bundle.putString("rank_list_type", this.fki);
        bundle.putBoolean("rank_list_from", this.fkj);
        bundle.putString("portrait", this.mPortrait);
        bundle.putString(IntentConfig.OTHER_PARAMS, this.otherParams);
        bundle.putString("feed_id", this.aNP);
        bundle.putLong("cur_live_id", this.fkg);
        bundle.putString("cur_hour", this.fkh);
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
        buz();
    }

    private void buz() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aLH);
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
        this.fkl = new AlaRankListFragmentAdapter(this, this.azs, this.mUserId, this.mUserName, this.fkj, this.mPortrait, this.otherParams, this.aNP, this.fkg, this.fkh);
        this.fkm = this.fkl.BH(this.fki);
        this.aws = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aws.setIndicatorWidthAuto(true);
        this.aws.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.AlaRankListActivity.8
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaRankListActivity.this.fkl.qe(i);
            }
        });
        this.aws.setData(this.fkl.getDataList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<com.baidu.live.liveroom.d.d> it = this.fkl.getDataList().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aLH);
        this.aLH = null;
    }
}
