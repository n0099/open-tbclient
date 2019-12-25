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
/* loaded from: classes6.dex */
public class c extends PopupWindow {
    private ViewGroup ayy;
    private View.OnClickListener dXO;
    private LinearLayout eoF;
    private List<w> gsR;
    private int gsS;
    private a gsT;
    private boolean gsU;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void a(w wVar);
    }

    public c(Context context) {
        super(context);
        this.dXO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gsR != null) {
                    w wVar = (w) c.this.gsR.get(view.getId());
                    if (c.this.gsT != null && wVar != null) {
                        c.this.gsT.a(wVar);
                    }
                    c.this.yk();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.yk();
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

    private View bwJ() {
        bwK();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.ayy = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.eoF);
        this.ayy.setOnClickListener(this.mOnClickListener);
        am.setBackgroundResource(this.eoF, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void bwK() {
    }

    public void g(List<w> list, int i) {
        if (!v.isEmpty(list)) {
            this.eoF = new LinearLayout(this.mContext);
            this.eoF.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.eoF.setClipChildren(true);
            this.eoF.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                w wVar = list.get(i2);
                if (i == wVar.gmF) {
                    this.eoF.addView(d(wVar.name, i2, true), layoutParams);
                } else {
                    this.eoF.addView(d(wVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.setBackgroundResource(view, R.color.cp_bg_line_c);
                    this.eoF.addView(view);
                }
            }
        }
    }

    public void bEM() {
        int i;
        am.setBackgroundResource(this.eoF, R.drawable.frs_tab_sort_select_bg);
        int childCount = this.eoF.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.gsR.size() && i2 < childCount) {
            w wVar = this.gsR.get(i3);
            View childAt = this.eoF.getChildAt(i2);
            if (childAt instanceof TextView) {
                if (this.gsS == wVar.gmF) {
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
        textView.setOnClickListener(this.dXO);
        return textView;
    }

    public void setData(List<w> list, int i) {
        if (list != null) {
            this.gsR = list;
            this.gsS = i;
            g(list, i);
            setContentView(bwJ());
        }
    }

    public void a(a aVar) {
        this.gsT = aVar;
    }

    public void P(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    ym();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                ym();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        yk();
    }

    public void yk() {
        yn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl() {
        super.dismiss();
    }

    private void ym() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.eoF.startAnimation(translateAnimation);
        this.ayy.startAnimation(alphaAnimation);
    }

    private void yn() {
        if (!this.gsU) {
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
                    c.this.gsU = false;
                    c.this.yl();
                }
            });
            this.gsU = true;
            this.eoF.startAnimation(translateAnimation);
            this.ayy.startAnimation(alphaAnimation);
        }
    }
}
