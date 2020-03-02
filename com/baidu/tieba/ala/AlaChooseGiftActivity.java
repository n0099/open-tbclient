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
import com.baidu.tieba.ala.e.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaChooseGiftActivity extends BaseFragmentActivity {
    private ViewTreeObserver.OnGlobalLayoutListener aju;
    private int ajv;
    private boolean ajw;
    private FrameLayout bow;
    private View egF;
    private LinearLayout egG;
    private ImageView egH;
    private TextView egI;
    private TextView egJ;
    private FrameLayout egK;
    private AlaLiveInputEditView egL;
    private com.baidu.tieba.ala.a.d egM;
    private com.baidu.tieba.ala.e.b egN;
    private String egO;
    private ArrayList<String> egP;
    private int egQ;
    private int mGiftNum;
    private View mRootView;
    private int mType = 1;
    private boolean agD = false;
    private boolean ajy = false;
    private boolean ajz = false;
    private b.a egR = new b.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.e.b.a
        public void b(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.egM != null) {
                AlaChooseGiftActivity.this.egM.c(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.e.b.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.egM != null) {
                AlaChooseGiftActivity.this.egM.aj(i, str);
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
        setContentView(a.h.ala_host_wish_choose_layout);
        parserIntent();
        initView();
        this.egN = new com.baidu.tieba.ala.e.b(getPageContext(), this.egR);
        dQ();
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajy = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agD) {
            this.mRootView.setVisibility(0);
            tn();
            this.agD = true;
        }
    }

    private void tn() {
        Animation loadAnimation;
        this.ajy = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChooseGiftActivity.this.ajy = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tp() {
        Animation loadAnimation;
        if (!this.ajz && !this.ajy) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_bottom);
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
            this.ajz = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tp();
    }

    private void dQ() {
        if (this.mType == 2 || this.mType == 1) {
            this.egN.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.egO = getIntent().getStringExtra("key_chosen_gift_id");
            this.egP = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.egQ = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.g.choose_gift_root_view);
        this.egF = findViewById(a.g.choose_gift_root_bg);
        this.egF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.egG = (LinearLayout) findViewById(a.g.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egG.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.egG.setLayoutParams(layoutParams);
        this.egI = (TextView) findViewById(a.g.choose_gift_title);
        this.egH = (ImageView) findViewById(a.g.choose_gift_return_btn);
        this.egH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.egJ = (TextView) findViewById(a.g.choose_gift_confirm_btn);
        this.egJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.egM.confirm();
            }
        });
        this.bow = (FrameLayout) findViewById(a.g.choose_gift_container);
        this.egK = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.egK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaChooseGiftActivity.this.egM.bbz();
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        this.egL = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        if (this.mType == 2) {
            this.egM = new com.baidu.tieba.ala.a.c(this, this.bow, this.egO, this.egP, this.mGiftNum, this.egQ);
        } else if (this.mType == 3) {
            this.egM = new com.baidu.tieba.ala.a.a(this, this.bow, this.egO, this.egP, this.mGiftNum, this.egQ);
        } else {
            this.egM = new com.baidu.tieba.ala.a.b(this, this.bow, this.egO, this.egP, this.mGiftNum, this.egQ);
        }
        this.egM.d(this.egI);
        this.egM.e(this.egL);
        this.egM.r(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.egN != null) {
                    AlaChooseGiftActivity.this.egN.request();
                }
            }
        });
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
        this.aju = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaChooseGiftActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                boolean z = AlaChooseGiftActivity.this.ajv != rect.bottom;
                AlaChooseGiftActivity.this.ajv = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaChooseGiftActivity.this.ajw || z)) {
                    AlaChooseGiftActivity.this.ajw = true;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaChooseGiftActivity.this.ajw) {
                    AlaChooseGiftActivity.this.ajw = false;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aju);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egL.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.egL.setLayoutParams(layoutParams);
            this.egL.setVisibility(0);
            this.egK.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.egL.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.egL.setLayoutParams(layoutParams2);
            this.egL.setVisibility(8);
            this.egK.setVisibility(8);
        }
        if (this.egM != null) {
            this.egM.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.egN != null) {
            this.egN.onDestroy();
        }
        if (this.egM != null) {
            this.egM.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aju);
        super.onDestroy();
    }
}
