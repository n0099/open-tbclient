package com.baidu.tieba.ala;

import android.app.Instrumentation;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.tieba.ala.g.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaChooseGiftActivity extends BaseFragmentActivity {
    private ViewTreeObserver.OnGlobalLayoutListener aYX;
    private int aYY;
    private TextView bGr;
    private FrameLayout bJO;
    private View fXU;
    private LinearLayout fXV;
    private ImageView fXW;
    private TextView fXX;
    private FrameLayout fXY;
    private AlaLiveInputEditView fXZ;
    private com.baidu.tieba.ala.c.d fYa;
    private com.baidu.tieba.ala.g.c fYb;
    private String fYc;
    private ArrayList<String> fYd;
    private int fYe;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private int mType = 1;
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    private c.a fYf = new c.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.g.c.a
        public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.fYa != null) {
                AlaChooseGiftActivity.this.fYa.d(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.g.c.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.fYa != null) {
                AlaChooseGiftActivity.this.fYa.aV(i, str);
            }
        }
    };
    private CustomMessageListener aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChooseGiftActivity.this.finishSelf();
        }
    };
    private CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChooseGiftActivity.this.finishSelf();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.g.ala_host_wish_choose_layout);
            registerListener(this.aVt);
            registerListener(this.aVs);
            parserIntent();
            initView();
            this.fYb = new com.baidu.tieba.ala.g.c(getPageContext(), this.fYf);
            Jz();
            addGlobalLayoutListener();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aZb = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    private void HW() {
        Animation loadAnimation;
        this.aZb = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChooseGiftActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void HX() {
        Animation loadAnimation;
        if (!this.aZc && !this.aZb) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaChooseGiftActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaChooseGiftActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aZc = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        HX();
    }

    private void Jz() {
        if (this.mType == 2 || this.mType == 1) {
            this.fYb.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.fYc = getIntent().getStringExtra("key_chosen_gift_id");
            this.fYd = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.fYe = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.f.choose_gift_root_view);
        this.fXU = findViewById(a.f.choose_gift_root_bg);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.fXV = (LinearLayout) findViewById(a.f.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXV.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fXV.setLayoutParams(layoutParams);
        this.fXX = (TextView) findViewById(a.f.choose_gift_title);
        this.fXW = (ImageView) findViewById(a.f.choose_gift_return_btn);
        this.fXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.bGr = (TextView) findViewById(a.f.choose_gift_confirm_btn);
        this.bGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.fYa.confirm();
            }
        });
        this.bJO = (FrameLayout) findViewById(a.f.choose_gift_container);
        this.fXY = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.fXY.setOnClickListener(new AnonymousClass9());
        this.fXZ = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        if (this.mType == 2) {
            this.fYa = new com.baidu.tieba.ala.c.c(this, this.bJO, this.fYc, this.fYd, this.mGiftNum, this.fYe);
        } else if (this.mType == 3) {
            this.fYa = new com.baidu.tieba.ala.c.a(this, this.bJO, this.fYc, this.fYd, this.mGiftNum, this.fYe);
        } else {
            this.fYa = new com.baidu.tieba.ala.c.b(this, this.bJO, this.fYc, this.fYd, this.mGiftNum, this.fYe);
        }
        this.fYa.j(this.fXX);
        this.fYa.e(this.fXZ);
        this.fYa.s(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.fYb != null) {
                    AlaChooseGiftActivity.this.fYb.request();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaChooseGiftActivity$9  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaChooseGiftActivity.this.fXY.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaChooseGiftActivity.this.fYa.bLT();
                            }
                        });
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSelf() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aYX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaChooseGiftActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                boolean z = AlaChooseGiftActivity.this.aYY != rect.bottom;
                AlaChooseGiftActivity.this.aYY = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaChooseGiftActivity.this.mIsKeyboardOpen || z)) {
                    AlaChooseGiftActivity.this.mIsKeyboardOpen = true;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaChooseGiftActivity.this.mIsKeyboardOpen) {
                    AlaChooseGiftActivity.this.mIsKeyboardOpen = false;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aYX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            Rect rect = new Rect();
            this.mRootView.getRootView().getWindowVisibleDisplayFrame(rect);
            int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.d.sdk_ds104);
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? dimensionPixelSize - UtilHelper.getStatusBarHeight() : dimensionPixelSize;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXZ.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.fXZ.setLayoutParams(layoutParams);
            this.fXZ.setVisibility(0);
            this.fXY.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fXZ.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.fXZ.setLayoutParams(layoutParams2);
            this.fXZ.setVisibility(8);
            this.fXY.setVisibility(8);
        }
        if (this.fYa != null) {
            this.fYa.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fYb != null) {
            this.fYb.onDestroy();
        }
        if (this.fYa != null) {
            this.fYa.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aYX);
        super.onDestroy();
    }
}
