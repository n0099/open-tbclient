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
    private ViewGroup beV;
    private View.OnClickListener eRh;
    private InterfaceC0603a gXh;
    private View gXi;
    private TextView gXj;
    private TextView gXk;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0603a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.eRh = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.gXj) {
                    if (a.this.gXh != null) {
                        a.this.gXh.onItemClick(1);
                    }
                } else if (view == a.this.gXk && a.this.gXh != null) {
                    a.this.gXh.onItemClick(2);
                }
                a.this.HQ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.HQ();
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

    private View bQi() {
        bQj();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.beV = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.gXi);
        this.beV.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.aVv().lF(R.color.cp_btn_a).lA(l.getDimens(this.mContext, R.dimen.tbds10)).lB(R.color.cp_shadow_a_alpha16).lC(l.getDimens(this.mContext, R.dimen.tbds21)).lD(0).lE(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gXi);
        return frameLayout;
    }

    private void bQj() {
        this.gXi = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.gXj = (TextView) this.gXi.findViewById(R.id.sort_type_level_text);
        this.mLine = this.gXi.findViewById(R.id.sort_select_line);
        this.gXk = (TextView) this.gXi.findViewById(R.id.sort_type_update_text);
        this.gXj.setOnClickListener(this.eRh);
        this.gXk.setOnClickListener(this.eRh);
    }

    public void setData(List<n> list, int i) {
        if (list != null) {
            View bQi = bQi();
            for (n nVar : list) {
                if (nVar.sortType == 1) {
                    this.gXj.setText(nVar.gPi);
                } else {
                    this.gXk.setText(nVar.gPi);
                }
                if (i == 1) {
                    am.setViewTextColor(this.gXj, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gXk, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.gXk, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gXj, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bQi);
        }
    }

    public void a(InterfaceC0603a interfaceC0603a) {
        this.gXh = interfaceC0603a;
    }

    public void S(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    HS();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                HS();
            }
        }
    }

    public void te(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        HQ();
    }

    public void HQ() {
        HT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HR() {
        super.dismiss();
    }

    private void HS() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.gXi.startAnimation(translateAnimation);
        this.beV.startAnimation(alphaAnimation);
    }

    private void HT() {
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
                    a.this.HR();
                }
            });
            this.gXi.startAnimation(translateAnimation);
            this.beV.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.gXj, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.gXk, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.aVv().lF(R.color.cp_btn_a).lA(l.getDimens(this.mContext, R.dimen.tbds10)).lB(R.color.cp_shadow_a_alpha16).lC(l.getDimens(this.mContext, R.dimen.tbds21)).lD(0).lE(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gXi);
    }
}
