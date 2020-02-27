package com.baidu.tieba.frs.entelechy.c.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.w;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends PopupWindow {
    private ViewGroup aDx;
    private View.OnClickListener ecb;
    private LinearLayout eud;
    private List<w> gyb;
    private int gyc;
    private a gyd;
    private boolean gye;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes9.dex */
    public interface a {
        void a(w wVar);
    }

    public c(Context context) {
        super(context);
        this.ecb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gyb != null) {
                    w wVar = (w) c.this.gyb.get(view.getId());
                    if (c.this.gyd != null && wVar != null) {
                        c.this.gyd.a(wVar);
                    }
                    c.this.AR();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.AR();
            }
        };
        this.mContext = context;
        setWidth(-2);
        setHeight(-2);
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
        frameLayout.addView(this.eud);
        this.aDx.setOnClickListener(this.mOnClickListener);
        am.setBackgroundResource(this.eud, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void bzo() {
    }

    public void g(List<w> list, int i) {
        if (!v.isEmpty(list)) {
            this.eud = new LinearLayout(this.mContext);
            this.eud.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.eud.setClipChildren(true);
            this.eud.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                w wVar = list.get(i2);
                if (i == wVar.grP) {
                    this.eud.addView(d(wVar.name, i2, true), layoutParams);
                } else {
                    this.eud.addView(d(wVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.setBackgroundResource(view, R.color.cp_bg_line_c);
                    this.eud.addView(view);
                }
            }
        }
    }

    public void bHq() {
        int i;
        am.setBackgroundResource(this.eud, R.drawable.frs_tab_sort_select_bg);
        int childCount = this.eud.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.gyb.size() && i2 < childCount) {
            w wVar = this.gyb.get(i3);
            View childAt = this.eud.getChildAt(i2);
            if (childAt instanceof TextView) {
                if (this.gyc == wVar.grP) {
                    am.setViewTextColor((TextView) childAt, (int) R.color.cp_link_tip_a);
                } else {
                    am.setViewTextColor((TextView) childAt, (int) R.color.cp_cont_j);
                }
                i = i3 + 1;
            } else {
                am.setBackgroundResource(childAt, R.color.cp_bg_line_c);
                i = i3;
            }
            i2++;
            i3 = i;
        }
    }

    private TextView d(String str, int i, boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.tbds36));
        textView.setText(str);
        textView.setTag(str);
        textView.setId(i);
        textView.setGravity(17);
        if (z) {
            am.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
        } else {
            am.setViewTextColor(textView, (int) R.color.cp_cont_j);
        }
        textView.setOnClickListener(this.ecb);
        return textView;
    }

    public void setData(List<w> list, int i) {
        if (list != null) {
            this.gyb = list;
            this.gyc = i;
            g(list, i);
            setContentView(bzn());
        }
    }

    public void a(a aVar) {
        this.gyd = aVar;
    }

    public void R(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    AT();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                AT();
            }
        }
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
        this.eud.startAnimation(translateAnimation);
        this.aDx.startAnimation(alphaAnimation);
    }

    private void AU() {
        if (!this.gye) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(350L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.gye = false;
                    c.this.AS();
                }
            });
            this.gye = true;
            this.eud.startAnimation(translateAnimation);
            this.aDx.startAnimation(alphaAnimation);
        }
    }
}
