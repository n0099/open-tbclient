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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends PopupWindow {
    private ViewGroup aqK;
    private LinearLayout dDG;
    private View.OnClickListener dkf;
    private a fEA;
    private boolean fEB;
    private List<v> fEy;
    private int fEz;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(v vVar);
    }

    public c(Context context) {
        super(context);
        this.dkf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fEy != null) {
                    v vVar = (v) c.this.fEy.get(view.getId());
                    if (c.this.fEA != null && vVar != null) {
                        c.this.fEA.a(vVar);
                    }
                    c.this.wm();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.wm();
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

    private View bfo() {
        bfp();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aqK = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.dDG);
        this.aqK.setOnClickListener(this.mOnClickListener);
        am.setBackgroundResource(this.dDG, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void bfp() {
    }

    public void g(List<v> list, int i) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            this.dDG = new LinearLayout(this.mContext);
            this.dDG.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.dDG.setClipChildren(true);
            this.dDG.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                v vVar = list.get(i2);
                if (i == vVar.fyi) {
                    this.dDG.addView(c(vVar.name, i2, true), layoutParams);
                } else {
                    this.dDG.addView(c(vVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.setBackgroundResource(view, R.color.cp_bg_line_c);
                    this.dDG.addView(view);
                }
            }
        }
    }

    public void bno() {
        int i;
        am.setBackgroundResource(this.dDG, R.drawable.frs_tab_sort_select_bg);
        int childCount = this.dDG.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.fEy.size() && i2 < childCount) {
            v vVar = this.fEy.get(i3);
            View childAt = this.dDG.getChildAt(i2);
            if (childAt instanceof TextView) {
                if (this.fEz == vVar.fyi) {
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

    private TextView c(String str, int i, boolean z) {
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
        textView.setOnClickListener(this.dkf);
        return textView;
    }

    public void setData(List<v> list, int i) {
        if (list != null) {
            this.fEy = list;
            this.fEz = i;
            g(list, i);
            setContentView(bfo());
        }
    }

    public void a(a aVar) {
        this.fEA = aVar;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    wo();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                wo();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        wm();
    }

    public void wm() {
        wp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn() {
        super.dismiss();
    }

    private void wo() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.dDG.startAnimation(translateAnimation);
        this.aqK.startAnimation(alphaAnimation);
    }

    private void wp() {
        if (!this.fEB) {
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
                    c.this.fEB = false;
                    c.this.wn();
                }
            });
            this.fEB = true;
            this.dDG.startAnimation(translateAnimation);
            this.aqK.startAnimation(alphaAnimation);
        }
    }
}
