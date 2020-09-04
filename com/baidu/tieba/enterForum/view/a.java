package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends PopupWindow {
    private ViewGroup bqi;
    private View.OnClickListener frt;
    private InterfaceC0671a hCC;
    private View hCD;
    private TextView hCE;
    private TextView hCF;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0671a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.frt = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.hCE) {
                    if (a.this.hCC != null) {
                        a.this.hCC.onItemClick(1);
                    }
                } else if (view == a.this.hCF && a.this.hCC != null) {
                    a.this.hCC.onItemClick(2);
                }
                a.this.Pb();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Pb();
            }
        };
        this.mContext = context;
        setWidth(l.getDimens(context, R.dimen.tbds240));
        setHeight(l.getDimens(context, R.dimen.tbds247));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View cgR() {
        cgS();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bqi = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.hCD);
        this.bqi.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(this.mContext, R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).or(l.getDimens(this.mContext, R.dimen.tbds21)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(this.hCD);
        return frameLayout;
    }

    private void cgS() {
        this.hCD = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.hCE = (TextView) this.hCD.findViewById(R.id.sort_type_level_text);
        this.mLine = this.hCD.findViewById(R.id.sort_select_line);
        this.hCF = (TextView) this.hCD.findViewById(R.id.sort_type_update_text);
        this.hCE.setOnClickListener(this.frt);
        this.hCF.setOnClickListener(this.frt);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View cgR = cgR();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.hCE.setText(hVar.huw);
                } else {
                    this.hCF.setText(hVar.huw);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.hCE, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hCF, R.color.cp_cont_j);
                } else {
                    ap.setViewTextColor(this.hCF, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hCE, R.color.cp_cont_j);
                }
            }
            setContentView(cgR);
        }
    }

    public void a(InterfaceC0671a interfaceC0671a) {
        this.hCC = interfaceC0671a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    Pd();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                Pd();
            }
        }
    }

    public void wm(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Pb();
    }

    public void Pb() {
        Pe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc() {
        super.dismiss();
    }

    private void Pd() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.hCD.startAnimation(translateAnimation);
        this.bqi.startAnimation(alphaAnimation);
    }

    private void Pe() {
        if (!k.isFastDoubleClick()) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(350L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.view.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.Pc();
                }
            });
            this.hCD.startAnimation(translateAnimation);
            this.bqi.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hCE, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.hCF, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(this.mContext, R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).or(l.getDimens(this.mContext, R.dimen.tbds21)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(this.hCD);
    }
}
