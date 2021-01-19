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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
/* loaded from: classes2.dex */
public class b {
    private View jRV;
    private LinearLayout jRW;
    private FrameLayout jRX;
    private FrameLayout jRY;
    private TBSpecificationBtn jRZ;
    private TBSpecificationBtn jSa;
    private com.baidu.tbadk.core.view.commonBtn.c jSb;
    private com.baidu.tbadk.core.view.commonBtn.c jSc;
    private PopupWindow jSe;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jSd = true;
    private float jSf = 1.0f;
    public View.OnClickListener jSg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Tq();
        }
    };
    public View.OnClickListener jSh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Tq();
            if (!b.this.jSd) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jSd = true;
                b.this.cMI();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Be(1);
        }
    };
    public View.OnClickListener jSi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Tq();
            if (b.this.jSd) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jSd = false;
                b.this.cMI();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Be(2);
        }
    };

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
        this.mRootView = (LinearLayout) this.rootView.findViewById(R.id.root_main);
        this.jRX = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jRW = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jRV = this.rootView.findViewById(R.id.mask_view);
        this.jRY = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.jRZ = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jSa = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jRZ.setTextSize(R.dimen.tbds34);
        this.jRZ.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jSa.setTextSize(R.dimen.tbds34);
        this.jSa.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jSa.setOnClickListener(this.jSi);
        this.jRZ.setOnClickListener(this.jSh);
        this.jRX.setOnClickListener(this.jSg);
        this.jSb = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jSb.pM(R.color.CAM_X0304);
        this.jSc = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jSc.pO(R.color.CAM_X0108);
        this.jSd = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_home_concern_all_status", 0) != 1;
        cMI();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jSe == null) {
            this.jSe = new PopupWindow(this.rootView, -1, -1, true);
            this.jSe.setContentView(this.rootView);
            this.jSe.setOutsideTouchable(true);
            this.jSe.setBackgroundDrawable(new ColorDrawable(0));
            this.jSe.setFocusable(true);
            this.jSe.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.Tq();
                        return false;
                    }
                    return false;
                }
            });
            this.jSe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jSe.setAnimationStyle(0);
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
                b.this.Tq();
            }
        });
        this.jRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jRX.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jRX.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jSe, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aBX();
        }
    }

    private void aBX() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.jRY.setAlpha(floatValue);
                if (b.this.jRY.getMeasuredHeight() > 0) {
                    b.this.jRY.setTranslationY(b.this.jRY.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.jRV.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        if (!k.isFastDoubleClick()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.jRY.setAlpha(floatValue);
                    if (b.this.jRY.getMeasuredHeight() > 0) {
                        b.this.jRY.setTranslationY(b.this.jRY.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.jRV.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.jSe != null && b.this.jSe.isShowing()) {
                        b.this.jSe.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.jSe != null && b.this.jSe.isShowing()) {
                        b.this.jSe.dismiss();
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
    public void cMI() {
        if (this.jRZ != null && this.jSa != null) {
            if (this.jSd) {
                this.jRZ.setConfig(this.jSb);
                this.jSa.setConfig(this.jSc);
                return;
            }
            this.jRZ.setConfig(this.jSc);
            this.jSa.setConfig(this.jSb);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.jSf = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jRZ.changeSkinType(i);
            this.jSa.changeSkinType(i);
            ao.a(this.jRW, R.color.CAM_X0208, this.jSf, i);
            ao.setBackgroundColor(this.jRY, R.color.CAM_X0202);
            ao.setBackgroundColor(this.jRV, R.color.CAM_X0605);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be(int i) {
        aq aqVar = new aq("c14054");
        aqVar.an("obj_type", i);
        TiebaStatic.log(aqVar);
    }
}
