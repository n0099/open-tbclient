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
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends PopupWindow {
    private ViewGroup aDz;
    private View.OnClickListener ecp;
    private InterfaceC0496a fZo;
    private View fZp;
    private TextView fZq;
    private TextView fZr;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0496a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.ecp = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fZq) {
                    if (a.this.fZo != null) {
                        a.this.fZo.onItemClick(1);
                    }
                } else if (view == a.this.fZr && a.this.fZo != null) {
                    a.this.fZo.onItemClick(2);
                }
                a.this.AT();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.AT();
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

    private View bzq() {
        bzr();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aDz = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fZp);
        this.aDz.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.aHa().kR(R.color.cp_btn_a).kM(l.getDimens(this.mContext, R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kO(l.getDimens(this.mContext, R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mContext, R.dimen.tbds5)).aQ(this.fZp);
        return frameLayout;
    }

    private void bzr() {
        this.fZp = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fZq = (TextView) this.fZp.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fZp.findViewById(R.id.sort_select_line);
        this.fZr = (TextView) this.fZp.findViewById(R.id.sort_type_update_text);
        this.fZq.setOnClickListener(this.ecp);
        this.fZr.setOnClickListener(this.ecp);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bzq = bzq();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fZq.setText(kVar.fUG);
                } else {
                    this.fZr.setText(kVar.fUG);
                }
                if (i == 1) {
                    am.setViewTextColor(this.fZq, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fZr, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.fZr, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fZq, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bzq);
        }
    }

    public void a(InterfaceC0496a interfaceC0496a) {
        this.fZo = interfaceC0496a;
    }

    public void R(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    AV();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                AV();
            }
        }
    }

    public void rY(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        AT();
    }

    public void AT() {
        AW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        super.dismiss();
    }

    private void AV() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fZp.startAnimation(translateAnimation);
        this.aDz.startAnimation(alphaAnimation);
    }

    private void AW() {
        if (!com.baidu.tbadk.util.k.isFastDoubleClick()) {
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
                    a.this.AU();
                }
            });
            this.fZp.startAnimation(translateAnimation);
            this.aDz.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fZq, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.fZr, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.aHa().kR(R.color.cp_btn_a).kM(l.getDimens(this.mContext, R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kO(l.getDimens(this.mContext, R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mContext, R.dimen.tbds5)).aQ(this.fZp);
    }
}
