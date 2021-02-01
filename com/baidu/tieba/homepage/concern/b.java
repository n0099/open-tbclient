package com.baidu.tieba.homepage.concern;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
/* loaded from: classes2.dex */
public class b {
    private TBSpecificationBtn jZA;
    private TBSpecificationBtn jZB;
    private com.baidu.tbadk.core.view.commonBtn.c jZC;
    private com.baidu.tbadk.core.view.commonBtn.c jZD;
    private PopupWindow jZF;
    private View jZw;
    private LinearLayout jZx;
    private FrameLayout jZy;
    private FrameLayout jZz;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jZE = true;
    private float jZG = 1.0f;
    public View.OnClickListener jZH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.UX();
        }
    };
    public View.OnClickListener jZI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.UX();
            if (!b.this.jZE) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jZE = true;
                b.this.cOF();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Bu(1);
        }
    };
    public View.OnClickListener jZJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.UX();
            if (b.this.jZE) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jZE = false;
                b.this.cOF();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Bu(2);
        }
    };

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
        this.mRootView = (LinearLayout) this.rootView.findViewById(R.id.root_main);
        this.jZy = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jZx = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jZw = this.rootView.findViewById(R.id.mask_view);
        this.jZz = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.jZA = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jZB = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jZA.setTextSize(R.dimen.tbds34);
        this.jZA.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jZB.setTextSize(R.dimen.tbds34);
        this.jZB.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jZB.setOnClickListener(this.jZJ);
        this.jZA.setOnClickListener(this.jZI);
        this.jZy.setOnClickListener(this.jZH);
        this.jZC = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jZC.pR(R.color.CAM_X0304);
        this.jZD = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jZD.pT(R.color.CAM_X0108);
        this.jZE = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) != 1;
        cOF();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jZF == null) {
            this.jZF = new PopupWindow(this.rootView, -1, -1, true);
            this.jZF.setContentView(this.rootView);
            this.jZF.setOutsideTouchable(true);
            this.jZF.setBackgroundDrawable(new ColorDrawable(0));
            this.jZF.setFocusable(true);
            this.jZF.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.UX();
                        return false;
                    }
                    return false;
                }
            });
            this.jZF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jZF.setAnimationStyle(0);
        }
        int[] iArr = new int[2];
        stickyAppBarLayout.getLocationInWindow(iArr);
        int height = (iArr[1] + stickyAppBarLayout.getHeight()) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
        int dimensionPixelOffset = iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            i = (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) ? height - UtilHelper.getStatusBarHeight() : height;
        } else {
            i = height;
        }
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.UX();
            }
        });
        this.jZx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jZy.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jZy.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jZF, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aCu();
        }
    }

    private void aCu() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.jZz.setAlpha(floatValue);
                if (b.this.jZz.getMeasuredHeight() > 0) {
                    b.this.jZz.setTranslationY(b.this.jZz.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.jZw.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UX() {
        if (!l.isFastDoubleClick()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.jZz.setAlpha(floatValue);
                    if (b.this.jZz.getMeasuredHeight() > 0) {
                        b.this.jZz.setTranslationY(b.this.jZz.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.jZw.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.jZF != null && b.this.jZF.isShowing()) {
                        b.this.jZF.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.jZF != null && b.this.jZF.isShowing()) {
                        b.this.jZF.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOF() {
        if (this.jZA != null && this.jZB != null) {
            if (this.jZE) {
                this.jZA.setConfig(this.jZC);
                this.jZB.setConfig(this.jZD);
                return;
            }
            this.jZA.setConfig(this.jZD);
            this.jZB.setConfig(this.jZC);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.jZG = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jZA.changeSkinType(i);
            this.jZB.changeSkinType(i);
            ap.a(this.jZx, R.color.CAM_X0208, this.jZG, i);
            ap.setBackgroundColor(this.jZz, R.color.CAM_X0202);
            ap.setBackgroundColor(this.jZw, R.color.CAM_X0605);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(int i) {
        ar arVar = new ar("c14054");
        arVar.ap("obj_type", i);
        TiebaStatic.log(arVar);
    }
}
