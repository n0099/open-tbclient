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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
/* loaded from: classes21.dex */
public class b {
    private View jvM;
    private LinearLayout jvN;
    private FrameLayout jvO;
    private FrameLayout jvP;
    private TBSpecificationBtn jvQ;
    private TBSpecificationBtn jvR;
    private com.baidu.tbadk.core.view.commonBtn.c jvS;
    private com.baidu.tbadk.core.view.commonBtn.c jvT;
    private PopupWindow jvV;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jvU = true;
    private float jvW = 1.0f;
    public View.OnClickListener jvX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    public View.OnClickListener jvY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.jvU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jvU = true;
                b.this.cId();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };
    public View.OnClickListener jvZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jvU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jvU = false;
                b.this.cId();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
        this.mRootView = (LinearLayout) this.rootView.findViewById(R.id.root_main);
        this.jvO = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jvN = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jvM = this.rootView.findViewById(R.id.mask_view);
        this.jvP = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.jvQ = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jvR = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jvQ.setTextSize(R.dimen.tbds34);
        this.jvQ.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jvR.setTextSize(R.dimen.tbds34);
        this.jvR.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jvR.setOnClickListener(this.jvZ);
        this.jvQ.setOnClickListener(this.jvY);
        this.jvO.setOnClickListener(this.jvX);
        this.jvS = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jvS.qG(R.color.CAM_X0304);
        this.jvT = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jvT.qI(R.color.CAM_X0108);
        this.jvU = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_home_concern_all_status", 0) != 1;
        cId();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jvV == null) {
            this.jvV = new PopupWindow(this.rootView, -1, -1, true);
            this.jvV.setContentView(this.rootView);
            this.jvV.setOutsideTouchable(true);
            this.jvV.setBackgroundDrawable(new ColorDrawable(0));
            this.jvV.setFocusable(true);
            this.jvV.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.TG();
                        return false;
                    }
                    return false;
                }
            });
            this.jvV.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jvV.setAnimationStyle(0);
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
                b.this.TG();
            }
        });
        this.jvN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jvO.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jvO.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jvV, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aBo();
        }
    }

    private void aBo() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.jvP.setAlpha(floatValue);
                if (b.this.jvP.getMeasuredHeight() > 0) {
                    b.this.jvP.setTranslationY(b.this.jvP.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.jvM.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TG() {
        if (!l.isFastDoubleClick()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.jvP.setAlpha(floatValue);
                    if (b.this.jvP.getMeasuredHeight() > 0) {
                        b.this.jvP.setTranslationY(b.this.jvP.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.jvM.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.jvV != null && b.this.jvV.isShowing()) {
                        b.this.jvV.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.jvV != null && b.this.jvV.isShowing()) {
                        b.this.jvV.dismiss();
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
    public void cId() {
        if (this.jvQ != null && this.jvR != null) {
            if (this.jvU) {
                this.jvQ.setConfig(this.jvS);
                this.jvR.setConfig(this.jvT);
                return;
            }
            this.jvQ.setConfig(this.jvT);
            this.jvR.setConfig(this.jvS);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.jvW = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jvQ.changeSkinType(i);
            this.jvR.changeSkinType(i);
            if (com.baidu.tbadk.a.d.bhw()) {
                ap.a((View) this.jvN, R.color.CAM_X0208, 0.0f, i);
                ap.setBackgroundColor(this.jvP, R.color.CAM_X0208);
            } else {
                ap.a(this.jvN, R.color.CAM_X0208, this.jvW, i);
                ap.setBackgroundColor(this.jvP, R.color.CAM_X0202);
            }
            ap.setBackgroundColor(this.jvM, R.color.CAM_X0605);
        }
    }
}
