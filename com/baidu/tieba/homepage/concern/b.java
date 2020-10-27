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
    private View jpf;
    private LinearLayout jpg;
    private FrameLayout jph;
    private TBSpecificationBtn jpi;
    private TBSpecificationBtn jpj;
    private com.baidu.tbadk.core.view.commonBtn.b jpk;
    private com.baidu.tbadk.core.view.commonBtn.b jpl;
    private PopupWindow jpn;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean jpm = true;
    public View.OnClickListener jpo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    public View.OnClickListener jpp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.jpm) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.jpm = true;
                b.this.cFX();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };
    public View.OnClickListener jpq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.jpm) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.jpm = false;
                b.this.cFX();
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
        this.jph = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.jpg = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.jpf = this.rootView.findViewById(R.id.mask_view);
        this.jpi = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.jpj = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.jpi.setTextSize(R.dimen.tbds34);
        this.jpi.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.jpj.setTextSize(R.dimen.tbds34);
        this.jpj.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.jpj.setOnClickListener(this.jpq);
        this.jpi.setOnClickListener(this.jpp);
        this.jph.setOnClickListener(this.jpo);
        this.jpk = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jpk.pY(R.color.cp_link_tip_a);
        this.jpl = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jpl.bb(R.color.cp_bg_line_j, R.color.cp_cont_c);
        this.jpm = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_home_concern_all_status", 0) != 1;
        cFX();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        int i;
        if (this.jpn == null) {
            this.jpn = new PopupWindow(this.rootView, -1, -1, true);
            this.jpn.setContentView(this.rootView);
            this.jpn.setOutsideTouchable(true);
            this.jpn.setBackgroundDrawable(new ColorDrawable(0));
            this.jpn.setFocusable(true);
            this.jpn.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.RH();
                    return false;
                }
            });
            this.jpn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.jpn.setAnimationStyle(0);
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
                b.this.RH();
            }
        });
        this.jpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jph.getLayoutParams();
        if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
            layoutParams.topMargin = i;
        }
        this.jph.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.jpn, stickyAppBarLayout, 0, dimensionPixelOffset, i)) {
            azw();
        }
    }

    private void azw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.jpg.startAnimation(translateAnimation);
        this.jpf.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RH() {
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
                    if (b.this.jpn != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                        if (b.this.jpn.isShowing()) {
                            b.this.jpn.dismiss();
                        }
                    }
                }
            });
            this.jpg.startAnimation(translateAnimation);
            this.jpf.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFX() {
        if (this.jpi != null && this.jpj != null) {
            if (this.jpm) {
                this.jpi.setConfig(this.jpk);
                this.jpj.setConfig(this.jpl);
                return;
            }
            this.jpi.setConfig(this.jpl);
            this.jpj.setConfig(this.jpk);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.jpi.changeSkinType(i);
            this.jpj.changeSkinType(i);
            ap.setBackgroundColor(this.jpg, R.color.cp_bg_line_h);
            ap.setBackgroundColor(this.jpf, R.color.cp_mask_b_alpha33);
        }
    }
}
