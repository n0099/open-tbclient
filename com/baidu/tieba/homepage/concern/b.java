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
    private View kbM;
    private LinearLayout kbN;
    private FrameLayout kbO;
    private FrameLayout kbP;
    private TBSpecificationBtn kbQ;
    private TBSpecificationBtn kbR;
    private com.baidu.tbadk.core.view.commonBtn.c kbS;
    private com.baidu.tbadk.core.view.commonBtn.c kbT;
    private PopupWindow kbV;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean kbU = true;
    private float kbW = 1.0f;
    public View.OnClickListener kbX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Va();
        }
    };
    public View.OnClickListener kbY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Va();
            if (!b.this.kbU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.kbU = true;
                b.this.cOT();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Bx(1);
        }
    };
    public View.OnClickListener kbZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Va();
            if (b.this.kbU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.kbU = false;
                b.this.cOT();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Bx(2);
        }
    };

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
        this.mRootView = (LinearLayout) this.rootView.findViewById(R.id.root_main);
        this.kbO = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.kbN = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.kbM = this.rootView.findViewById(R.id.mask_view);
        this.kbP = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.kbQ = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.kbR = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.kbQ.setTextSize(R.dimen.tbds34);
        this.kbQ.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.kbR.setTextSize(R.dimen.tbds34);
        this.kbR.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.kbR.setOnClickListener(this.kbZ);
        this.kbQ.setOnClickListener(this.kbY);
        this.kbO.setOnClickListener(this.kbX);
        this.kbS = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kbS.pS(R.color.CAM_X0304);
        this.kbT = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kbT.pU(R.color.CAM_X0108);
        this.kbU = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_home_concern_all_status", 0) != 1;
        cOT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.kbV == null) {
            this.kbV = new PopupWindow(this.rootView, -1, -1, true);
            this.kbV.setContentView(this.rootView);
            this.kbV.setOutsideTouchable(true);
            this.kbV.setBackgroundDrawable(new ColorDrawable(0));
            this.kbV.setFocusable(true);
            this.kbV.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.Va();
                        return false;
                    }
                    return false;
                }
            });
            this.kbV.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.kbV.setAnimationStyle(0);
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
                b.this.Va();
            }
        });
        this.kbN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kbO.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.kbO.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.kbV, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aCx();
        }
    }

    private void aCx() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.kbP.setAlpha(floatValue);
                if (b.this.kbP.getMeasuredHeight() > 0) {
                    b.this.kbP.setTranslationY(b.this.kbP.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.kbM.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Va() {
        if (!l.isFastDoubleClick()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.kbP.setAlpha(floatValue);
                    if (b.this.kbP.getMeasuredHeight() > 0) {
                        b.this.kbP.setTranslationY(b.this.kbP.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.kbM.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.kbV != null && b.this.kbV.isShowing()) {
                        b.this.kbV.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.kbV != null && b.this.kbV.isShowing()) {
                        b.this.kbV.dismiss();
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
    public void cOT() {
        if (this.kbQ != null && this.kbR != null) {
            if (this.kbU) {
                this.kbQ.setConfig(this.kbS);
                this.kbR.setConfig(this.kbT);
                return;
            }
            this.kbQ.setConfig(this.kbT);
            this.kbR.setConfig(this.kbS);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.kbW = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.kbQ.changeSkinType(i);
            this.kbR.changeSkinType(i);
            ap.a(this.kbN, R.color.CAM_X0208, this.kbW, i);
            ap.setBackgroundColor(this.kbP, R.color.CAM_X0202);
            ap.setBackgroundColor(this.kbM, R.color.CAM_X0605);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bx(int i) {
        ar arVar = new ar("c14054");
        arVar.aq("obj_type", i);
        TiebaStatic.log(arVar);
    }
}
