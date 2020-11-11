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
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import java.util.List;
/* loaded from: classes22.dex */
public class a extends PopupWindow {
    private ViewGroup bFE;
    private View.OnClickListener fUZ;
    private InterfaceC0716a iqY;
    private View iqZ;
    private TextView ira;
    private TextView irb;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0716a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.fUZ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.ira) {
                    if (a.this.iqY != null) {
                        a.this.iqY.onItemClick(1);
                    }
                } else if (view == a.this.irb && a.this.iqY != null) {
                    a.this.iqY.onItemClick(2);
                }
                a.this.Um();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Um();
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

    private View ctk() {
        ctl();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bFE = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.iqZ);
        this.bFE.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_btn_a).pv(l.getDimens(this.mContext, R.dimen.tbds10)).pw(R.color.cp_shadow_a_alpha16).px(l.getDimens(this.mContext, R.dimen.tbds21)).py(0).pz(l.getDimens(this.mContext, R.dimen.tbds5)).bk(this.iqZ);
        return frameLayout;
    }

    private void ctl() {
        this.iqZ = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.ira = (TextView) this.iqZ.findViewById(R.id.sort_type_level_text);
        this.mLine = this.iqZ.findViewById(R.id.sort_select_line);
        this.irb = (TextView) this.iqZ.findViewById(R.id.sort_type_update_text);
        this.ira.setOnClickListener(this.fUZ);
        this.irb.setOnClickListener(this.fUZ);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View ctk = ctk();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.ira.setText(hVar.iiU);
                } else {
                    this.irb.setText(hVar.iiU);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.ira, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.irb, R.color.cp_cont_j);
                } else {
                    ap.setViewTextColor(this.irb, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.ira, R.color.cp_cont_j);
                }
            }
            setContentView(ctk);
        }
    }

    public void a(InterfaceC0716a interfaceC0716a) {
        this.iqY = interfaceC0716a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    Uo();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                Uo();
            }
        }
    }

    public void xX(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Um();
    }

    public void Um() {
        Up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Un() {
        super.dismiss();
    }

    private void Uo() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iqZ.startAnimation(translateAnimation);
        this.bFE.startAnimation(alphaAnimation);
    }

    private void Up() {
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
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
                    a.this.Un();
                }
            });
            this.iqZ.startAnimation(translateAnimation);
            this.bFE.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.ira, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.irb, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_btn_a).pv(l.getDimens(this.mContext, R.dimen.tbds10)).pw(R.color.cp_shadow_a_alpha16).px(l.getDimens(this.mContext, R.dimen.tbds21)).py(0).pz(l.getDimens(this.mContext, R.dimen.tbds5)).bk(this.iqZ);
    }
}
