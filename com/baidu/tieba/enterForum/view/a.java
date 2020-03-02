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
    private ViewGroup aDy;
    private View.OnClickListener ecc;
    private InterfaceC0496a fZb;
    private View fZc;
    private TextView fZd;
    private TextView fZe;
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
        this.ecc = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fZd) {
                    if (a.this.fZb != null) {
                        a.this.fZb.onItemClick(1);
                    }
                } else if (view == a.this.fZe && a.this.fZb != null) {
                    a.this.fZb.onItemClick(2);
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

    private View bzp() {
        bzq();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aDy = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fZc);
        this.aDy.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.f.a.aGZ().kR(R.color.cp_btn_a).kM(l.getDimens(this.mContext, R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kO(l.getDimens(this.mContext, R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mContext, R.dimen.tbds5)).aQ(this.fZc);
        return frameLayout;
    }

    private void bzq() {
        this.fZc = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fZd = (TextView) this.fZc.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fZc.findViewById(R.id.sort_select_line);
        this.fZe = (TextView) this.fZc.findViewById(R.id.sort_type_update_text);
        this.fZd.setOnClickListener(this.ecc);
        this.fZe.setOnClickListener(this.ecc);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bzp = bzp();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fZd.setText(kVar.fUt);
                } else {
                    this.fZe.setText(kVar.fUt);
                }
                if (i == 1) {
                    am.setViewTextColor(this.fZd, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fZe, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.fZe, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fZd, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bzp);
        }
    }

    public void a(InterfaceC0496a interfaceC0496a) {
        this.fZb = interfaceC0496a;
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
        this.fZc.startAnimation(translateAnimation);
        this.aDy.startAnimation(alphaAnimation);
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
            this.fZc.startAnimation(translateAnimation);
            this.aDy.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fZd, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.fZe, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.f.a.aGZ().kR(R.color.cp_btn_a).kM(l.getDimens(this.mContext, R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kO(l.getDimens(this.mContext, R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mContext, R.dimen.tbds5)).aQ(this.fZc);
    }
}
