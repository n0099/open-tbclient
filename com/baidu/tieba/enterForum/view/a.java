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
    private ViewGroup bqf;
    private View.OnClickListener fro;
    private InterfaceC0671a hCw;
    private View hCx;
    private TextView hCy;
    private TextView hCz;
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
        this.fro = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.hCy) {
                    if (a.this.hCw != null) {
                        a.this.hCw.onItemClick(1);
                    }
                } else if (view == a.this.hCz && a.this.hCw != null) {
                    a.this.hCw.onItemClick(2);
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

    private View cgQ() {
        cgR();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bqf = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.hCx);
        this.bqf.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(this.mContext, R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).or(l.getDimens(this.mContext, R.dimen.tbds21)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(this.hCx);
        return frameLayout;
    }

    private void cgR() {
        this.hCx = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.hCy = (TextView) this.hCx.findViewById(R.id.sort_type_level_text);
        this.mLine = this.hCx.findViewById(R.id.sort_select_line);
        this.hCz = (TextView) this.hCx.findViewById(R.id.sort_type_update_text);
        this.hCy.setOnClickListener(this.fro);
        this.hCz.setOnClickListener(this.fro);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View cgQ = cgQ();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.hCy.setText(hVar.huq);
                } else {
                    this.hCz.setText(hVar.huq);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.hCy, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hCz, R.color.cp_cont_j);
                } else {
                    ap.setViewTextColor(this.hCz, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hCy, R.color.cp_cont_j);
                }
            }
            setContentView(cgQ);
        }
    }

    public void a(InterfaceC0671a interfaceC0671a) {
        this.hCw = interfaceC0671a;
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
        this.hCx.startAnimation(translateAnimation);
        this.bqf.startAnimation(alphaAnimation);
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
            this.hCx.startAnimation(translateAnimation);
            this.bqf.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hCy, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.hCz, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).op(l.getDimens(this.mContext, R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).or(l.getDimens(this.mContext, R.dimen.tbds21)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(this.hCx);
    }
}
