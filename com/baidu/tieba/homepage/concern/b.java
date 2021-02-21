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
    private View jZK;
    private LinearLayout jZL;
    private FrameLayout jZM;
    private FrameLayout jZN;
    private TBSpecificationBtn jZO;
    private TBSpecificationBtn jZP;
    private com.baidu.tbadk.core.view.commonBtn.c jZQ;
    private com.baidu.tbadk.core.view.commonBtn.c jZR;
    private PopupWindow jZT;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jZS = true;
    private float jZU = 1.0f;
    public View.OnClickListener jZV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.UX();
        }
    };
    public View.OnClickListener jZW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.UX();
            if (!b.this.jZS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jZS = true;
                b.this.cOM();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
            b.this.Bu(1);
        }
    };
    public View.OnClickListener jZX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.UX();
            if (b.this.jZS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jZS = false;
                b.this.cOM();
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
        this.jZM = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jZL = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jZK = this.rootView.findViewById(R.id.mask_view);
        this.jZN = (FrameLayout) this.rootView.findViewById(R.id.bottom_background_view);
        this.jZO = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jZP = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jZO.setTextSize(R.dimen.tbds34);
        this.jZO.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jZP.setTextSize(R.dimen.tbds34);
        this.jZP.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jZP.setOnClickListener(this.jZX);
        this.jZO.setOnClickListener(this.jZW);
        this.jZM.setOnClickListener(this.jZV);
        this.jZQ = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jZQ.pR(R.color.CAM_X0304);
        this.jZR = new com.baidu.tbadk.core.view.commonBtn.c();
        this.jZR.pT(R.color.CAM_X0108);
        this.jZS = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) != 1;
        cOM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jZT == null) {
            this.jZT = new PopupWindow(this.rootView, -1, -1, true);
            this.jZT.setContentView(this.rootView);
            this.jZT.setOutsideTouchable(true);
            this.jZT.setBackgroundDrawable(new ColorDrawable(0));
            this.jZT.setFocusable(true);
            this.jZT.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent != null && motionEvent.getAction() == 0) {
                        b.this.UX();
                        return false;
                    }
                    return false;
                }
            });
            this.jZT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jZT.setAnimationStyle(0);
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
        this.jZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jZM.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jZM.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jZT, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
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
                b.this.jZN.setAlpha(floatValue);
                if (b.this.jZN.getMeasuredHeight() > 0) {
                    b.this.jZN.setTranslationY(b.this.jZN.getMeasuredHeight() * (floatValue - 1.0f));
                }
                b.this.jZK.setAlpha(floatValue);
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
                    b.this.jZN.setAlpha(floatValue);
                    if (b.this.jZN.getMeasuredHeight() > 0) {
                        b.this.jZN.setTranslationY(b.this.jZN.getMeasuredHeight() * (floatValue - 1.0f));
                    }
                    b.this.jZK.setAlpha(floatValue);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.concern.b.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.jZT != null && b.this.jZT.isShowing()) {
                        b.this.jZT.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (b.this.jZT != null && b.this.jZT.isShowing()) {
                        b.this.jZT.dismiss();
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
    public void cOM() {
        if (this.jZO != null && this.jZP != null) {
            if (this.jZS) {
                this.jZO.setConfig(this.jZQ);
                this.jZP.setConfig(this.jZR);
                return;
            }
            this.jZO.setConfig(this.jZR);
            this.jZP.setConfig(this.jZQ);
        }
    }

    public void setBackgroundAlpha(float f) {
        this.jZU = f;
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jZO.changeSkinType(i);
            this.jZP.changeSkinType(i);
            ap.a(this.jZL, R.color.CAM_X0208, this.jZU, i);
            ap.setBackgroundColor(this.jZN, R.color.CAM_X0202);
            ap.setBackgroundColor(this.jZK, R.color.CAM_X0605);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(int i) {
        ar arVar = new ar("c14054");
        arVar.ap("obj_type", i);
        TiebaStatic.log(arVar);
    }
}
