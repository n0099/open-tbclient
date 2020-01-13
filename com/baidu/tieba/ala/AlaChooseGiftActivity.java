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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.tieba.ala.e.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaChooseGiftActivity extends BaseFragmentActivity {
    private ViewTreeObserver.OnGlobalLayoutListener ahl;
    private int ahm;
    private boolean ahn;
    private FrameLayout bkl;
    private View ecB;
    private LinearLayout ecC;
    private ImageView ecD;
    private TextView ecE;
    private TextView ecF;
    private FrameLayout ecG;
    private AlaLiveInputEditView ecH;
    private com.baidu.tieba.ala.a.d ecI;
    private com.baidu.tieba.ala.e.b ecJ;
    private String ecK;
    private ArrayList<String> ecL;
    private int ecM;
    private int mGiftNum;
    private View mRootView;
    private int mType = 1;
    private boolean aew = false;
    private boolean ahp = false;
    private boolean ahq = false;
    private b.a ecN = new b.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.e.b.a
        public void b(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.ecI != null) {
                AlaChooseGiftActivity.this.ecI.c(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.e.b.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.ecI != null) {
                AlaChooseGiftActivity.this.ecI.ai(i, str);
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
        this.ecJ = new com.baidu.tieba.ala.e.b(getPageContext(), this.ecN);
        dP();
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ahp = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aew) {
            this.mRootView.setVisibility(0);
            sc();
            this.aew = true;
        }
    }

    private void sc() {
        Animation loadAnimation;
        this.ahp = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChooseGiftActivity.this.ahp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void sd() {
        Animation loadAnimation;
        if (!this.ahq && !this.ahp) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_bottom);
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
            this.ahq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        sd();
    }

    private void dP() {
        if (this.mType == 2 || this.mType == 1) {
            this.ecJ.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.ecK = getIntent().getStringExtra("key_chosen_gift_id");
            this.ecL = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.ecM = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.g.choose_gift_root_view);
        this.ecB = findViewById(a.g.choose_gift_root_bg);
        this.ecB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.ecC = (LinearLayout) findViewById(a.g.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ecC.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ecC.setLayoutParams(layoutParams);
        this.ecE = (TextView) findViewById(a.g.choose_gift_title);
        this.ecD = (ImageView) findViewById(a.g.choose_gift_return_btn);
        this.ecD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.ecF = (TextView) findViewById(a.g.choose_gift_confirm_btn);
        this.ecF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.ecI.confirm();
            }
        });
        this.bkl = (FrameLayout) findViewById(a.g.choose_gift_container);
        this.ecG = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.ecG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaChooseGiftActivity.this.ecI.aZi();
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        this.ecH = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        if (this.mType == 2) {
            this.ecI = new com.baidu.tieba.ala.a.c(this, this.bkl, this.ecK, this.ecL, this.mGiftNum, this.ecM);
        } else if (this.mType == 3) {
            this.ecI = new com.baidu.tieba.ala.a.a(this, this.bkl, this.ecK, this.ecL, this.mGiftNum, this.ecM);
        } else {
            this.ecI = new com.baidu.tieba.ala.a.b(this, this.bkl, this.ecK, this.ecL, this.mGiftNum, this.ecM);
        }
        this.ecI.d(this.ecE);
        this.ecI.e(this.ecH);
        this.ecI.r(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.ecJ != null) {
                    AlaChooseGiftActivity.this.ecJ.request();
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
        this.ahl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaChooseGiftActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                boolean z = AlaChooseGiftActivity.this.ahm != rect.bottom;
                AlaChooseGiftActivity.this.ahm = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaChooseGiftActivity.this.ahn || z)) {
                    AlaChooseGiftActivity.this.ahn = true;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaChooseGiftActivity.this.ahn) {
                    AlaChooseGiftActivity.this.ahn = false;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.ahl);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ecH.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.ecH.setLayoutParams(layoutParams);
            this.ecH.setVisibility(0);
            this.ecG.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ecH.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.ecH.setLayoutParams(layoutParams2);
            this.ecH.setVisibility(8);
            this.ecG.setVisibility(8);
        }
        if (this.ecI != null) {
            this.ecI.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ecJ != null) {
            this.ecJ.onDestroy();
        }
        if (this.ecI != null) {
            this.ecI.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.ahl);
        super.onDestroy();
    }
}
