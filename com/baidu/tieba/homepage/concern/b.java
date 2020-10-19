package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
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
    private View jcJ;
    private LinearLayout jcK;
    private FrameLayout jcL;
    private TBSpecificationBtn jcM;
    private TBSpecificationBtn jcN;
    private com.baidu.tbadk.core.view.commonBtn.b jcO;
    private com.baidu.tbadk.core.view.commonBtn.b jcP;
    private PopupWindow jcR;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jcQ = true;
    public View.OnClickListener jcS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    public View.OnClickListener jcT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.jcQ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jcQ = true;
                b.this.cCQ();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };
    public View.OnClickListener jcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jcQ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jcQ = false;
                b.this.cCQ();
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
        this.jcL = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jcK = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jcJ = this.rootView.findViewById(R.id.mask_view);
        this.jcM = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jcN = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jcM.setTextSize(R.dimen.tbds34);
        this.jcM.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jcN.setTextSize(R.dimen.tbds34);
        this.jcN.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jcN.setOnClickListener(this.jcU);
        this.jcM.setOnClickListener(this.jcT);
        this.jcL.setOnClickListener(this.jcS);
        this.jcO = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jcO.pN(R.color.cp_link_tip_a);
        this.jcP = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jcP.ba(R.color.cp_bg_line_j, R.color.cp_cont_c);
        this.jcQ = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_home_concern_all_status", 0) != 1;
        cCQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jcR == null) {
            this.jcR = new PopupWindow(this.rootView, -1, -1, true);
            this.jcR.setContentView(this.rootView);
            this.jcR.setOutsideTouchable(true);
            this.jcR.setBackgroundDrawable(new ColorDrawable(0));
            this.jcR.setFocusable(true);
            this.jcR.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.QM();
                    return false;
                }
            });
            this.jcR.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jcR.setAnimationStyle(0);
        }
        int[] iArr = new int[2];
        stickyAppBarLayout.getLocationInWindow(iArr);
        int height = iArr[1] + stickyAppBarLayout.getHeight();
        int dimensionPixelOffset = iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            i = (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) ? height - UtilHelper.getStatusBarHeight() : height;
        } else {
            i = height;
        }
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.QM();
            }
        });
        this.jcK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jcL.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jcL.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jcR, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            axC();
        }
    }

    private void axC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.jcK.startAnimation(translateAnimation);
        this.jcJ.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        if (!l.isFastDoubleClick()) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.concern.b.8
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jcR != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                        if (b.this.jcR.isShowing()) {
                            b.this.jcR.dismiss();
                        }
                    }
                }
            });
            this.jcK.startAnimation(translateAnimation);
            this.jcJ.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCQ() {
        if (this.jcM != null && this.jcN != null) {
            if (this.jcQ) {
                this.jcM.setConfig(this.jcO);
                this.jcN.setConfig(this.jcP);
                return;
            }
            this.jcM.setConfig(this.jcP);
            this.jcN.setConfig(this.jcO);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jcM.changeSkinType(i);
            this.jcN.changeSkinType(i);
            ap.setBackgroundColor(this.jcK, R.color.cp_bg_line_h);
            ap.setBackgroundColor(this.jcJ, R.color.cp_mask_b_alpha33);
        }
    }
}
