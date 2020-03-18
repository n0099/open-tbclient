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
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.tieba.ala.e.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaChooseGiftActivity extends BaseFragmentActivity {
    private ViewTreeObserver.OnGlobalLayoutListener ajE;
    private int ajF;
    private boolean ajG;
    private FrameLayout boJ;
    private View ehi;
    private LinearLayout ehj;
    private ImageView ehk;
    private TextView ehl;
    private TextView ehm;
    private FrameLayout ehn;
    private AlaLiveInputEditView eho;
    private com.baidu.tieba.ala.a.d ehp;
    private com.baidu.tieba.ala.e.b ehq;
    private String ehr;
    private ArrayList<String> ehs;
    private int eht;
    private int mGiftNum;
    private View mRootView;
    private int mType = 1;
    private boolean agN = false;
    private boolean ajI = false;
    private boolean ajJ = false;
    private b.a ehu = new b.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.e.b.a
        public void b(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.ehp != null) {
                AlaChooseGiftActivity.this.ehp.c(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.e.b.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.ehp != null) {
                AlaChooseGiftActivity.this.ehp.aj(i, str);
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
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        setContentView(a.h.ala_host_wish_choose_layout);
        parserIntent();
        initView();
        this.ehq = new com.baidu.tieba.ala.e.b(getPageContext(), this.ehu);
        dQ();
        addGlobalLayoutListener();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajI = false;
        this.mRootView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agN) {
            this.mRootView.setVisibility(0);
            tt();
            this.agN = true;
        }
    }

    private void tt() {
        Animation loadAnimation;
        this.ajI = true;
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
                AlaChooseGiftActivity.this.ajI = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tu() {
        Animation loadAnimation;
        if (!this.ajJ && !this.ajI) {
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
            this.ajJ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tu();
    }

    private void dQ() {
        if (this.mType == 2 || this.mType == 1) {
            this.ehq.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.ehr = getIntent().getStringExtra("key_chosen_gift_id");
            this.ehs = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.eht = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.g.choose_gift_root_view);
        this.ehi = findViewById(a.g.choose_gift_root_bg);
        this.ehi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.ehj = (LinearLayout) findViewById(a.g.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ehj.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ehj.setLayoutParams(layoutParams);
        this.ehl = (TextView) findViewById(a.g.choose_gift_title);
        this.ehk = (ImageView) findViewById(a.g.choose_gift_return_btn);
        this.ehk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.ehm = (TextView) findViewById(a.g.choose_gift_confirm_btn);
        this.ehm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.ehp.confirm();
            }
        });
        this.boJ = (FrameLayout) findViewById(a.g.choose_gift_container);
        this.ehn = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.ehn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Exception e) {
                            AlaChooseGiftActivity.this.ehp.bbE();
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        this.eho = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        if (this.mType == 2) {
            this.ehp = new com.baidu.tieba.ala.a.c(this, this.boJ, this.ehr, this.ehs, this.mGiftNum, this.eht);
        } else if (this.mType == 3) {
            this.ehp = new com.baidu.tieba.ala.a.a(this, this.boJ, this.ehr, this.ehs, this.mGiftNum, this.eht);
        } else {
            this.ehp = new com.baidu.tieba.ala.a.b(this, this.boJ, this.ehr, this.ehs, this.mGiftNum, this.eht);
        }
        this.ehp.d(this.ehl);
        this.ehp.e(this.eho);
        this.ehp.r(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.ehq != null) {
                    AlaChooseGiftActivity.this.ehq.request();
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
        this.ajE = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaChooseGiftActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                boolean z = AlaChooseGiftActivity.this.ajF != rect.bottom;
                AlaChooseGiftActivity.this.ajF = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaChooseGiftActivity.this.ajG || z)) {
                    AlaChooseGiftActivity.this.ajG = true;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaChooseGiftActivity.this.ajG) {
                    AlaChooseGiftActivity.this.ajG = false;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.ajE);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eho.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.eho.setLayoutParams(layoutParams);
            this.eho.setVisibility(0);
            this.ehn.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eho.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.eho.setLayoutParams(layoutParams2);
            this.eho.setVisibility(8);
            this.ehn.setVisibility(8);
        }
        if (this.ehp != null) {
            this.ehp.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ehq != null) {
            this.ehq.onDestroy();
        }
        if (this.ehp != null) {
            this.ehp.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.ajE);
        super.onDestroy();
    }
}
