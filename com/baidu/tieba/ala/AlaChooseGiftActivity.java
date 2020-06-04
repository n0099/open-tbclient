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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.tieba.ala.f.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaChooseGiftActivity extends BaseFragmentActivity {
    private ViewTreeObserver.OnGlobalLayoutListener aHH;
    private int aHI;
    private FrameLayout bWe;
    private View eTL;
    private LinearLayout eTM;
    private ImageView eTN;
    private TextView eTO;
    private TextView eTP;
    private FrameLayout eTQ;
    private AlaLiveInputEditView eTR;
    private com.baidu.tieba.ala.b.d eTS;
    private com.baidu.tieba.ala.f.b eTT;
    private String eTU;
    private ArrayList<String> eTV;
    private int eTW;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private int mType = 1;
    private boolean aEB = false;
    private boolean aHL = false;
    private boolean aHM = false;
    private b.a eTX = new b.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.f.b.a
        public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.eTS != null) {
                AlaChooseGiftActivity.this.eTS.d(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.f.b.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.eTS != null) {
                AlaChooseGiftActivity.this.eTS.aD(i, str);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.h.ala_host_wish_choose_layout);
            parserIntent();
            initView();
            this.eTT = new com.baidu.tieba.ala.f.b(getPageContext(), this.eTX);
            AC();
            addGlobalLayoutListener();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aHL = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aEB) {
            this.mRootView.setVisibility(0);
            yY();
            this.aEB = true;
        }
    }

    private void yY() {
        Animation loadAnimation;
        this.aHL = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChooseGiftActivity.this.aHL = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void yZ() {
        Animation loadAnimation;
        if (!this.aHM && !this.aHL) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.3
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
            this.aHM = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        yZ();
    }

    private void AC() {
        if (this.mType == 2 || this.mType == 1) {
            this.eTT.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.eTU = getIntent().getStringExtra("key_chosen_gift_id");
            this.eTV = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.eTW = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.g.choose_gift_root_view);
        this.eTL = findViewById(a.g.choose_gift_root_bg);
        this.eTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.eTM = (LinearLayout) findViewById(a.g.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTM.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eTM.setLayoutParams(layoutParams);
        this.eTO = (TextView) findViewById(a.g.choose_gift_title);
        this.eTN = (ImageView) findViewById(a.g.choose_gift_return_btn);
        this.eTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.eTP = (TextView) findViewById(a.g.choose_gift_confirm_btn);
        this.eTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.eTS.confirm();
            }
        });
        this.bWe = (FrameLayout) findViewById(a.g.choose_gift_container);
        this.eTQ = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.eTQ.setOnClickListener(new AnonymousClass7());
        this.eTR = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        if (this.mType == 2) {
            this.eTS = new com.baidu.tieba.ala.b.c(this, this.bWe, this.eTU, this.eTV, this.mGiftNum, this.eTW);
        } else if (this.mType == 3) {
            this.eTS = new com.baidu.tieba.ala.b.a(this, this.bWe, this.eTU, this.eTV, this.mGiftNum, this.eTW);
        } else {
            this.eTS = new com.baidu.tieba.ala.b.b(this, this.bWe, this.eTU, this.eTV, this.mGiftNum, this.eTW);
        }
        this.eTS.e(this.eTO);
        this.eTS.e(this.eTR);
        this.eTS.q(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.eTT != null) {
                    AlaChooseGiftActivity.this.eTT.request();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaChooseGiftActivity$7  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaChooseGiftActivity.this.eTQ.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaChooseGiftActivity.this.eTS.bpb();
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
        this.aHH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaChooseGiftActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                boolean z = AlaChooseGiftActivity.this.aHI != rect.bottom;
                AlaChooseGiftActivity.this.aHI = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaChooseGiftActivity.this.mIsKeyboardOpen || z)) {
                    AlaChooseGiftActivity.this.mIsKeyboardOpen = true;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaChooseGiftActivity.this.mIsKeyboardOpen) {
                    AlaChooseGiftActivity.this.mIsKeyboardOpen = false;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aHH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            Rect rect = new Rect();
            this.mRootView.getRootView().getWindowVisibleDisplayFrame(rect);
            int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds104);
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? dimensionPixelSize - UtilHelper.getStatusBarHeight() : dimensionPixelSize;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTR.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.eTR.setLayoutParams(layoutParams);
            this.eTR.setVisibility(0);
            this.eTQ.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eTR.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.eTR.setLayoutParams(layoutParams2);
            this.eTR.setVisibility(8);
            this.eTQ.setVisibility(8);
        }
        if (this.eTS != null) {
            this.eTS.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eTT != null) {
            this.eTT.onDestroy();
        }
        if (this.eTS != null) {
            this.eTS.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aHH);
        super.onDestroy();
    }
}
