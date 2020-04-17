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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.n;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends PopupWindow {
    private ViewGroup aXw;
    private View.OnClickListener eCs;
    private InterfaceC0532a gIf;
    private View gIg;
    private TextView gIh;
    private TextView gIi;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0532a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.eCs = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.gIh) {
                    if (a.this.gIf != null) {
                        a.this.gIf.onItemClick(1);
                    }
                } else if (view == a.this.gIi && a.this.gIf != null) {
                    a.this.gIf.onItemClick(2);
                }
                a.this.FY();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.FY();
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

    private View bJM() {
        bJN();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aXw = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.gIg);
        this.aXw.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.aPt().lb(R.color.cp_btn_a).kW(l.getDimens(this.mContext, R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kY(l.getDimens(this.mContext, R.dimen.tbds21)).kZ(0).la(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gIg);
        return frameLayout;
    }

    private void bJN() {
        this.gIg = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.gIh = (TextView) this.gIg.findViewById(R.id.sort_type_level_text);
        this.mLine = this.gIg.findViewById(R.id.sort_select_line);
        this.gIi = (TextView) this.gIg.findViewById(R.id.sort_type_update_text);
        this.gIh.setOnClickListener(this.eCs);
        this.gIi.setOnClickListener(this.eCs);
    }

    public void setData(List<n> list, int i) {
        if (list != null) {
            View bJM = bJM();
            for (n nVar : list) {
                if (nVar.sortType == 1) {
                    this.gIh.setText(nVar.gAh);
                } else {
                    this.gIi.setText(nVar.gAh);
                }
                if (i == 1) {
                    am.setViewTextColor(this.gIh, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gIi, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.gIi, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gIh, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bJM);
        }
    }

    public void a(InterfaceC0532a interfaceC0532a) {
        this.gIf = interfaceC0532a;
    }

    public void T(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    Ga();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                Ga();
            }
        }
    }

    public void sx(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        FY();
    }

    public void FY() {
        Gb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FZ() {
        super.dismiss();
    }

    private void Ga() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.gIg.startAnimation(translateAnimation);
        this.aXw.startAnimation(alphaAnimation);
    }

    private void Gb() {
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
                    a.this.FZ();
                }
            });
            this.gIg.startAnimation(translateAnimation);
            this.aXw.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.gIh, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.gIi, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.aPt().lb(R.color.cp_btn_a).kW(l.getDimens(this.mContext, R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kY(l.getDimens(this.mContext, R.dimen.tbds21)).kZ(0).la(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gIg);
    }
}
