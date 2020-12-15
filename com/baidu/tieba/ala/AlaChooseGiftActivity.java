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
    private TextView bJO;
    private FrameLayout bNl;
    private ViewTreeObserver.OnGlobalLayoutListener baD;
    private int baE;
    private View gfO;
    private LinearLayout gfP;
    private ImageView gfQ;
    private TextView gfR;
    private FrameLayout gfS;
    private AlaLiveInputEditView gfT;
    private com.baidu.tieba.ala.c.d gfU;
    private com.baidu.tieba.ala.g.c gfV;
    private String gfW;
    private ArrayList<String> gfX;
    private int gfY;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private int mType = 1;
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    private c.a gfZ = new c.a() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.1
        @Override // com.baidu.tieba.ala.g.c.a
        public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
            if (AlaChooseGiftActivity.this.gfU != null) {
                AlaChooseGiftActivity.this.gfU.d(alaSdkGetGiftListHttpResponseMessage);
            }
        }

        @Override // com.baidu.tieba.ala.g.c.a
        public void onFail(int i, String str) {
            if (AlaChooseGiftActivity.this.gfU != null) {
                AlaChooseGiftActivity.this.gfU.aT(i, str);
            }
        }
    };
    private CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaChooseGiftActivity.this.finishSelf();
        }
    };
    private CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.3
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
            registerListener(this.aWM);
            registerListener(this.aWL);
            parserIntent();
            initView();
            this.gfV = new com.baidu.tieba.ala.g.c(getPageContext(), this.gfZ);
            KR();
            addGlobalLayoutListener();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWv) {
            this.mRootView.setVisibility(0);
            Je();
            this.aWv = true;
        }
    }

    private void Je() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
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

    private void Jf() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_bottom);
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
        Jf();
    }

    private void KR() {
        if (this.mType == 2 || this.mType == 1) {
            this.gfV.request();
        }
    }

    private void parserIntent() {
        if (getIntent() != null) {
            this.mType = getIntent().getIntExtra("key_choose_type", 1);
            this.gfW = getIntent().getStringExtra("key_chosen_gift_id");
            this.gfX = getIntent().getStringArrayListExtra("key_used_gift_list");
            this.mGiftNum = getIntent().getIntExtra("key_chosen_gift_num", 0);
            this.gfY = getIntent().getIntExtra("key_chosen_date", 0);
        }
    }

    private void initView() {
        this.mRootView = findViewById(a.f.choose_gift_root_view);
        this.gfO = findViewById(a.f.choose_gift_root_bg);
        this.gfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.gfP = (LinearLayout) findViewById(a.f.choose_gift_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gfP.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.gfP.setLayoutParams(layoutParams);
        this.gfR = (TextView) findViewById(a.f.choose_gift_title);
        this.gfQ = (ImageView) findViewById(a.f.choose_gift_return_btn);
        this.gfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.finishSelf();
            }
        });
        this.bJO = (TextView) findViewById(a.f.choose_gift_confirm_btn);
        this.bJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaChooseGiftActivity.this.gfU.confirm();
            }
        });
        this.bNl = (FrameLayout) findViewById(a.f.choose_gift_container);
        this.gfS = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.gfS.setOnClickListener(new AnonymousClass9());
        this.gfT = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        if (this.mType == 2) {
            this.gfU = new com.baidu.tieba.ala.c.c(this, this.bNl, this.gfW, this.gfX, this.mGiftNum, this.gfY);
        } else if (this.mType == 3) {
            this.gfU = new com.baidu.tieba.ala.c.a(this, this.bNl, this.gfW, this.gfX, this.mGiftNum, this.gfY);
        } else {
            this.gfU = new com.baidu.tieba.ala.c.b(this, this.bNl, this.gfW, this.gfX, this.mGiftNum, this.gfY);
        }
        this.gfU.j(this.gfR);
        this.gfU.e(this.gfT);
        this.gfU.s(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaChooseGiftActivity.this.gfV != null) {
                    AlaChooseGiftActivity.this.gfV.request();
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
                        AlaChooseGiftActivity.this.gfS.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaChooseGiftActivity.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaChooseGiftActivity.this.gfU.bOW();
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gfT.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.gfT.setLayoutParams(layoutParams);
            this.gfT.setVisibility(0);
            this.gfS.setVisibility(0);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gfT.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.gfT.setLayoutParams(layoutParams2);
            this.gfT.setVisibility(8);
            this.gfS.setVisibility(8);
        }
        if (this.gfU != null) {
            this.gfU.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gfV != null) {
            this.gfV.onDestroy();
        }
        if (this.gfU != null) {
            this.gfU.onDestroy();
        }
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        super.onDestroy();
    }
}
