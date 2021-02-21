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
/* loaded from: classes11.dex */
public class AlaChooseGiftActivity extends BaseFragmentActivity {
    private TextView bNA;
    private FrameLayout bRc;
    private ViewTreeObserver.OnGlobalLayoutListener baD;
    private int baE;
    private View gog;
    private LinearLayout goh;
    private ImageView goi;
    private FrameLayout goj;
    private AlaLiveInputEditView gok;
    private com.baidu.tieba.ala.c.d gol;
    private com.baidu.tieba.ala.g.c gom;
    private String gon;
    private ArrayList<String> goo;
    private int gop;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTv;
    private int mType = 1;
    private boolean aWt = false;
    private boolean baH = false;
    private boolean baI = false;
    private c.a goq = new c.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.g.c.a
        public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.gol != null) {
                AlaChooseGiftActivity.this.gol.d(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.g.c.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.gol != null) {
                AlaChooseGiftActivity.this.gol.bb(i, str);
            }
        }
    };
    private CustomMessageListener aWJ = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChooseGiftActivity.this.finishSelf();
        }
    };
    private CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChooseGiftActivity.this.finishSelf();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
            registerListener(this.aWK);
            registerListener(this.aWJ);
            parserIntent();
            initView();
            this.gom = new com.baidu.tieba.ala.g.c(getPageContext(), this.goq);
            initModel();
            addGlobalLayoutListener();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWt) {
            this.mRootView.setVisibility(0);
            Gb();
            this.aWt = true;
        }
    }

    private void Gb() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChooseGiftActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gc() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
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
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gc();
    }

    private void initModel() {
        if (this.mType == 2 || this.mType == 1) {
            this.gom.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.gon = getIntent().getStringExtra("key_chosen_gift_id");
            this.goo = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.gop = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.f.choose_gift_root_view);
        this.gog = findViewById(a.f.choose_gift_root_bg);
        this.gog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.goh = (LinearLayout) findViewById(a.f.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.goh.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.goh.setLayoutParams(layoutParams);
        this.mTitleTv = (TextView) findViewById(a.f.choose_gift_title);
        this.goi = (ImageView) findViewById(a.f.choose_gift_return_btn);
        this.goi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.bNA = (TextView) findViewById(a.f.choose_gift_confirm_btn);
        this.bNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.gol.confirm();
            }
        });
        this.bRc = (FrameLayout) findViewById(a.f.choose_gift_container);
        this.goj = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.goj.setOnClickListener(new AnonymousClass9());
        this.gok = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        if (this.mType == 2) {
            this.gol = new com.baidu.tieba.ala.c.c(this, this.bRc, this.gon, this.goo, this.mGiftNum, this.gop);
        } else if (this.mType == 3) {
            this.gol = new com.baidu.tieba.ala.c.a(this, this.bRc, this.gon, this.goo, this.mGiftNum, this.gop);
        } else {
            this.gol = new com.baidu.tieba.ala.c.b(this, this.bRc, this.gon, this.goo, this.mGiftNum, this.gop);
        }
        this.gol.l(this.mTitleTv);
        this.gol.e(this.gok);
        this.gol.t(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.gom != null) {
                    AlaChooseGiftActivity.this.gom.request();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaChooseGiftActivity$9  reason: invalid class name */
    /* loaded from: classes11.dex */
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
                        AlaChooseGiftActivity.this.goj.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaChooseGiftActivity.this.gol.bOn();
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
        this.baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaChooseGiftActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaChooseGiftActivity.this.getPageContext().getPageActivity());
                boolean z = AlaChooseGiftActivity.this.baE != rect.bottom;
                AlaChooseGiftActivity.this.baE = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaChooseGiftActivity.this.mIsKeyboardOpen || z)) {
                    AlaChooseGiftActivity.this.mIsKeyboardOpen = true;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaChooseGiftActivity.this.mIsKeyboardOpen) {
                    AlaChooseGiftActivity.this.mIsKeyboardOpen = false;
                    AlaChooseGiftActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gok.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.gok.setLayoutParams(layoutParams);
            this.gok.setVisibility(0);
            this.goj.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gok.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.gok.setLayoutParams(layoutParams2);
            this.gok.setVisibility(8);
            this.goj.setVisibility(8);
        }
        if (this.gol != null) {
            this.gol.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gom != null) {
            this.gom.onDestroy();
        }
        if (this.gol != null) {
            this.gol.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        super.onDestroy();
    }
}
