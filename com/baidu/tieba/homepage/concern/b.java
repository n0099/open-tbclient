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
    private View jvc;
    private LinearLayout jvd;
    private FrameLayout jve;
    private TBSpecificationBtn jvf;
    private TBSpecificationBtn jvg;
    private com.baidu.tbadk.core.view.commonBtn.b jvh;
    private com.baidu.tbadk.core.view.commonBtn.b jvi;
    private PopupWindow jvk;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jvj = true;
    public View.OnClickListener jvl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    public View.OnClickListener jvm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.jvj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jvj = true;
                b.this.cIy();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };
    public View.OnClickListener jvn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jvj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jvj = false;
                b.this.cIy();
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
        this.jve = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jvd = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jvc = this.rootView.findViewById(R.id.mask_view);
        this.jvf = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jvg = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jvf.setTextSize(R.dimen.tbds34);
        this.jvf.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jvg.setTextSize(R.dimen.tbds34);
        this.jvg.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jvg.setOnClickListener(this.jvn);
        this.jvf.setOnClickListener(this.jvm);
        this.jve.setOnClickListener(this.jvl);
        this.jvh = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jvh.qi(R.color.cp_link_tip_a);
        this.jvi = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jvi.bb(R.color.cp_bg_line_j, R.color.cp_cont_c);
        this.jvj = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_home_concern_all_status", 0) != 1;
        cIy();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jvk == null) {
            this.jvk = new PopupWindow(this.rootView, -1, -1, true);
            this.jvk.setContentView(this.rootView);
            this.jvk.setOutsideTouchable(true);
            this.jvk.setBackgroundDrawable(new ColorDrawable(0));
            this.jvk.setFocusable(true);
            this.jvk.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.Up();
                    return false;
                }
            });
            this.jvk.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jvk.setAnimationStyle(0);
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
                b.this.Up();
            }
        });
        this.jvd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jve.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jve.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jvk, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            aBW();
        }
    }

    private void aBW() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.jvd.startAnimation(translateAnimation);
        this.jvc.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
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
                    if (b.this.jvk != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                        if (b.this.jvk.isShowing()) {
                            b.this.jvk.dismiss();
                        }
                    }
                }
            });
            this.jvd.startAnimation(translateAnimation);
            this.jvc.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIy() {
        if (this.jvf != null && this.jvg != null) {
            if (this.jvj) {
                this.jvf.setConfig(this.jvh);
                this.jvg.setConfig(this.jvi);
                return;
            }
            this.jvf.setConfig(this.jvi);
            this.jvg.setConfig(this.jvh);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jvf.changeSkinType(i);
            this.jvg.changeSkinType(i);
            ap.setBackgroundColor(this.jvd, R.color.cp_bg_line_h);
            ap.setBackgroundColor(this.jvc, R.color.cp_mask_b_alpha33);
        }
    }
}
