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
/* loaded from: classes22.dex */
public class b {
    private View jJp;
    private LinearLayout jJq;
    private FrameLayout jJr;
    private FrameLayout jJs;
    private TBSpecificationBtn jJt;
    private TBSpecificationBtn jJu;
    private com.baidu.tbadk.core.view.commonBtn.c jJv;
    private com.baidu.tbadk.core.view.commonBtn.c jJw;
    private PopupWindow jJy;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jJx = true;
    private float jJz = 1.0f;
    public View.OnClickListener jJA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Wg();
        }
    };
    public View.OnClickListener jJB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Wg();
            if (!b.this.jJx) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jJx = true;
                b.this.cNt();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };
    public View.OnClickListener jJC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Wg();
            if (b.this.jJx) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jJx = false;
                b.this.cNt();
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
        this.jJr = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jJq = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jJp = this.rootView.findViewById(R.id.mask_view);
        this.jJs = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.jJt = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jJu = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jJt.setTextSize(R.dimen.tbds34);
        this.jJt.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jJu.setTextSize(R.dimen.tbds34);
        this.jJu.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jJu.setOnClickListener(this.jJC);
        this.jJt.setOnClickListener(this.jJB);
        this.jJr.setOnClickListener(this.jJA);
        this.jJv = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jJv.rh(R.color.CAM_X0304);
        this.jJw = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jJw.rj(R.color.CAM_X0108);
        this.jJx = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0) != 1;
        cNt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jJy == null) {
            this.jJy = new PopupWindow(this.rootView, -1, -1, true);
            this.jJy.setContentView(this.rootView);
            this.jJy.setOutsideTouchable(true);
            this.jJy.setBackgroundDrawable(new ColorDrawable(0));
            this.jJy.setFocusable(true);
            this.jJy.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.Wg();
                        return false;
                    }
                    return false;
                }
            });
            this.jJy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jJy.setAnimationStyle(0);
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
                b.this.Wg();
            }
        });
        this.jJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jJr.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jJr.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jJy, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aEx();
        }
    }

    private void aEx() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.jJs.setAlpha(floatValue);
                if (b.this.jJs.getMeasuredHeight() > 0) {
                    b.this.jJs.setTranslationY(b.this.jJs.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.jJp.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wg() {
        if (!l.isFastDoubleClick()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.concern.b.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.jJs.setAlpha(floatValue);
                    if (b.this.jJs.getMeasuredHeight() > 0) {
                        b.this.jJs.setTranslationY(b.this.jJs.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.jJp.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.jJy != null && b.this.jJy.isShowing()) {
                        b.this.jJy.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.jJy != null && b.this.jJy.isShowing()) {
                        b.this.jJy.dismiss();
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
    public void cNt() {
        if (this.jJt != null && this.jJu != null) {
            if (this.jJx) {
                this.jJt.setConfig(this.jJv);
                this.jJu.setConfig(this.jJw);
                return;
            }
            this.jJt.setConfig(this.jJw);
            this.jJu.setConfig(this.jJv);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.jJz = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jJt.changeSkinType(i);
            this.jJu.changeSkinType(i);
            if (com.baidu.tbadk.a.d.bkA()) {
                ap.a((View) this.jJq, R.color.CAM_X0208, 0.0f, i);
                ap.setBackgroundColor(this.jJs, R.color.CAM_X0208);
            } else {
                ap.a(this.jJq, R.color.CAM_X0208, this.jJz, i);
                ap.setBackgroundColor(this.jJs, R.color.CAM_X0202);
            }
            ap.setBackgroundColor(this.jJp, R.color.CAM_X0605);
        }
    }
}
