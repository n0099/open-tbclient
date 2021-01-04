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
    private View jWA;
    private LinearLayout jWB;
    private FrameLayout jWC;
    private FrameLayout jWD;
    private TBSpecificationBtn jWE;
    private TBSpecificationBtn jWF;
    private com.baidu.tbadk.core.view.commonBtn.c jWG;
    private com.baidu.tbadk.core.view.commonBtn.c jWH;
    private PopupWindow jWJ;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jWI = true;
    private float jWK = 1.0f;
    public View.OnClickListener jWL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Xi();
        }
    };
    public View.OnClickListener jWM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Xi();
            if (!b.this.jWI) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jWI = true;
                b.this.cQz();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.CL(1);
        }
    };
    public View.OnClickListener jWN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Xi();
            if (b.this.jWI) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jWI = false;
                b.this.cQz();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.CL(2);
        }
    };

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
        this.mRootView = (LinearLayout) this.rootView.findViewById(R.id.root_main);
        this.jWC = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jWB = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jWA = this.rootView.findViewById(R.id.mask_view);
        this.jWD = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.jWE = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jWF = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jWE.setTextSize(R.dimen.tbds34);
        this.jWE.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jWF.setTextSize(R.dimen.tbds34);
        this.jWF.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jWF.setOnClickListener(this.jWN);
        this.jWE.setOnClickListener(this.jWM);
        this.jWC.setOnClickListener(this.jWL);
        this.jWG = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jWG.rs(R.color.CAM_X0304);
        this.jWH = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jWH.ru(R.color.CAM_X0108);
        this.jWI = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_home_concern_all_status", 0) != 1;
        cQz();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jWJ == null) {
            this.jWJ = new PopupWindow(this.rootView, -1, -1, true);
            this.jWJ.setContentView(this.rootView);
            this.jWJ.setOutsideTouchable(true);
            this.jWJ.setBackgroundDrawable(new ColorDrawable(0));
            this.jWJ.setFocusable(true);
            this.jWJ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.Xi();
                        return false;
                    }
                    return false;
                }
            });
            this.jWJ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jWJ.setAnimationStyle(0);
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
                b.this.Xi();
            }
        });
        this.jWB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jWC.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jWC.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jWJ, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aFQ();
        }
    }

    private void aFQ() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.jWD.setAlpha(floatValue);
                if (b.this.jWD.getMeasuredHeight() > 0) {
                    b.this.jWD.setTranslationY(b.this.jWD.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.jWA.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi() {
        if (!k.isFastDoubleClick()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.jWD.setAlpha(floatValue);
                    if (b.this.jWD.getMeasuredHeight() > 0) {
                        b.this.jWD.setTranslationY(b.this.jWD.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.jWA.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.jWJ != null && b.this.jWJ.isShowing()) {
                        b.this.jWJ.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.jWJ != null && b.this.jWJ.isShowing()) {
                        b.this.jWJ.dismiss();
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
    public void cQz() {
        if (this.jWE != null && this.jWF != null) {
            if (this.jWI) {
                this.jWE.setConfig(this.jWG);
                this.jWF.setConfig(this.jWH);
                return;
            }
            this.jWE.setConfig(this.jWH);
            this.jWF.setConfig(this.jWG);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.jWK = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jWE.changeSkinType(i);
            this.jWF.changeSkinType(i);
            ao.a(this.jWB, R.color.CAM_X0208, this.jWK, i);
            ao.setBackgroundColor(this.jWD, R.color.CAM_X0202);
            ao.setBackgroundColor(this.jWA, R.color.CAM_X0605);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL(int i) {
        aq aqVar = new aq("c14054");
        aqVar.an("obj_type", i);
        TiebaStatic.log(aqVar);
    }
}
