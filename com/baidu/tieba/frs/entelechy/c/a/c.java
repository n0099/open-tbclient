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
/* loaded from: classes7.dex */
public class c extends PopupWindow {
    private ViewGroup azh;
    private View.OnClickListener dXX;
    private LinearLayout epS;
    private List<w> gwa;
    private int gwb;
    private a gwc;
    private boolean gwd;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes7.dex */
    public interface a {
        void a(w wVar);
    }

    public c(Context context) {
        super(context);
        this.dXX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gwa != null) {
                    w wVar = (w) c.this.gwa.get(view.getId());
                    if (c.this.gwc != null && wVar != null) {
                        c.this.gwc.a(wVar);
                    }
                    c.this.yA();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.yA();
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

    private View bxL() {
        bxM();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.azh = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.epS);
        this.azh.setOnClickListener(this.mOnClickListener);
        am.setBackgroundResource(this.epS, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void bxM() {
    }

    public void g(List<w> list, int i) {
        if (!v.isEmpty(list)) {
            this.epS = new LinearLayout(this.mContext);
            this.epS.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.epS.setClipChildren(true);
            this.epS.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                w wVar = list.get(i2);
                if (i == wVar.gpO) {
                    this.epS.addView(d(wVar.name, i2, true), layoutParams);
                } else {
                    this.epS.addView(d(wVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.setBackgroundResource(view, R.color.cp_bg_line_c);
                    this.epS.addView(view);
                }
            }
        }
    }

    public void bFO() {
        int i;
        am.setBackgroundResource(this.epS, R.drawable.frs_tab_sort_select_bg);
        int childCount = this.epS.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.gwa.size() && i2 < childCount) {
            w wVar = this.gwa.get(i3);
            View childAt = this.epS.getChildAt(i2);
            if (childAt instanceof TextView) {
                if (this.gwb == wVar.gpO) {
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
        textView.setOnClickListener(this.dXX);
        return textView;
    }

    public void setData(List<w> list, int i) {
        if (list != null) {
            this.gwa = list;
            this.gwb = i;
            g(list, i);
            setContentView(bxL());
        }
    }

    public void a(a aVar) {
        this.gwc = aVar;
    }

    public void R(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    yC();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                yC();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        yA();
    }

    public void yA() {
        yD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        super.dismiss();
    }

    private void yC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.epS.startAnimation(translateAnimation);
        this.azh.startAnimation(alphaAnimation);
    }

    private void yD() {
        if (!this.gwd) {
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
                    c.this.gwd = false;
                    c.this.yB();
                }
            });
            this.gwd = true;
            this.epS.startAnimation(translateAnimation);
            this.azh.startAnimation(alphaAnimation);
        }
    }
}
