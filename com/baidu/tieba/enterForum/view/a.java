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
    private ViewGroup aDx;
    private View.OnClickListener ecb;
    private InterfaceC0496a fYZ;
    private View fZa;
    private TextView fZb;
    private TextView fZc;
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
        this.ecb = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fZb) {
                    if (a.this.fYZ != null) {
                        a.this.fYZ.onItemClick(1);
                    }
                } else if (view == a.this.fZc && a.this.fYZ != null) {
                    a.this.fYZ.onItemClick(2);
                }
                a.this.AR();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.AR();
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

    private View bzn() {
        bzo();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aDx = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fZa);
        this.aDx.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.f.a.aGX().kR(R.color.cp_btn_a).kM(l.getDimens(this.mContext, R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kO(l.getDimens(this.mContext, R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mContext, R.dimen.tbds5)).aQ(this.fZa);
        return frameLayout;
    }

    private void bzo() {
        this.fZa = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fZb = (TextView) this.fZa.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fZa.findViewById(R.id.sort_select_line);
        this.fZc = (TextView) this.fZa.findViewById(R.id.sort_type_update_text);
        this.fZb.setOnClickListener(this.ecb);
        this.fZc.setOnClickListener(this.ecb);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bzn = bzn();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fZb.setText(kVar.fUr);
                } else {
                    this.fZc.setText(kVar.fUr);
                }
                if (i == 1) {
                    am.setViewTextColor(this.fZb, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fZc, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.fZc, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fZb, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bzn);
        }
    }

    public void a(InterfaceC0496a interfaceC0496a) {
        this.fYZ = interfaceC0496a;
    }

    public void R(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    AT();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                AT();
            }
        }
    }

    public void rY(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        AR();
    }

    public void AR() {
        AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        super.dismiss();
    }

    private void AT() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fZa.startAnimation(translateAnimation);
        this.aDx.startAnimation(alphaAnimation);
    }

    private void AU() {
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
                    a.this.AS();
                }
            });
            this.fZa.startAnimation(translateAnimation);
            this.aDx.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fZb, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.fZc, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.f.a.aGX().kR(R.color.cp_btn_a).kM(l.getDimens(this.mContext, R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kO(l.getDimens(this.mContext, R.dimen.tbds21)).kP(0).kQ(l.getDimens(this.mContext, R.dimen.tbds5)).aQ(this.fZa);
    }
}
