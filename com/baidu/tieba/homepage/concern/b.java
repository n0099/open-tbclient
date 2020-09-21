package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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
/* loaded from: classes21.dex */
public class b {
    private View iNR;
    private LinearLayout iNS;
    private FrameLayout iNT;
    private TBSpecificationBtn iNU;
    private TBSpecificationBtn iNV;
    private com.baidu.tbadk.core.view.commonBtn.b iNW;
    private com.baidu.tbadk.core.view.commonBtn.b iNX;
    private PopupWindow iNZ;
    private Context mContext;
    private LinearLayout mRootView;
    private View rootView;
    private boolean iNY = true;
    public View.OnClickListener iOa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    public View.OnClickListener iOb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iNY) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                b.this.iNY = true;
                b.this.czt();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
        }
    };
    public View.OnClickListener iOc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iNY) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                b.this.iNY = false;
                b.this.czt();
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
        this.iNT = (FrameLayout) this.rootView.findViewById(R.id.type_container);
        this.iNS = (LinearLayout) this.rootView.findViewById(R.id.ll_btn);
        this.iNR = this.rootView.findViewById(R.id.mask_view);
        this.iNU = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_all_concern);
        this.iNV = (TBSpecificationBtn) this.rootView.findViewById(R.id.btn_person_concern);
        this.iNU.setTextSize(R.dimen.tbds34);
        this.iNU.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
        this.iNV.setTextSize(R.dimen.tbds34);
        this.iNV.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
        this.iNV.setOnClickListener(this.iOc);
        this.iNU.setOnClickListener(this.iOb);
        this.iNT.setOnClickListener(this.iOa);
        this.iNW = new com.baidu.tbadk.core.view.commonBtn.b();
        this.iNW.pp(R.color.cp_link_tip_a);
        this.iNX = new com.baidu.tbadk.core.view.commonBtn.b();
        this.iNX.bb(R.color.cp_bg_line_j, R.color.cp_cont_c);
        this.iNY = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_home_concern_all_status", 0) != 1;
        czt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(StickyAppBarLayout stickyAppBarLayout) {
        b(stickyAppBarLayout);
    }

    private void b(StickyAppBarLayout stickyAppBarLayout) {
        if (this.iNZ == null) {
            this.iNZ = new PopupWindow(this.rootView, -1, -1, true);
            this.iNZ.setContentView(this.rootView);
            this.iNZ.setOutsideTouchable(true);
            this.iNZ.setBackgroundDrawable(new ColorDrawable(0));
            this.iNZ.setFocusable(true);
            this.iNZ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.PH();
                    return false;
                }
            });
            this.iNZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.concern.b.5
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                }
            });
            this.iNZ.setAnimationStyle(0);
        }
        int[] iArr = new int[2];
        stickyAppBarLayout.getLocationInWindow(iArr);
        int height = iArr[1] + stickyAppBarLayout.getHeight();
        int dimensionPixelOffset = iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44);
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? height - UtilHelper.getStatusBarHeight() : height;
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.PH();
            }
        });
        this.iNS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iNT.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        this.iNT.setLayoutParams(layoutParams);
        if (g.showPopupWindowAtLocation(this.iNZ, stickyAppBarLayout, 0, dimensionPixelOffset, statusBarHeight)) {
            auR();
        }
    }

    private void auR() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iNS.startAnimation(translateAnimation);
        this.iNR.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PH() {
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
                    if (b.this.iNZ != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
                        if (b.this.iNZ.isShowing()) {
                            b.this.iNZ.dismiss();
                        }
                    }
                }
            });
            this.iNS.startAnimation(translateAnimation);
            this.iNR.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czt() {
        if (this.iNU != null && this.iNV != null) {
            if (this.iNY) {
                this.iNU.setConfig(this.iNW);
                this.iNV.setConfig(this.iNX);
                return;
            }
            this.iNU.setConfig(this.iNX);
            this.iNV.setConfig(this.iNW);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.rootView != null) {
            this.iNU.changeSkinType(i);
            this.iNV.changeSkinType(i);
            ap.setBackgroundColor(this.iNS, R.color.cp_bg_line_h);
            ap.setBackgroundColor(this.iNR, R.color.cp_mask_b_alpha33);
        }
    }
}
