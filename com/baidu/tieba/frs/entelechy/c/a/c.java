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
    private ViewGroup arc;
    private LinearLayout dEx;
    private View.OnClickListener dkW;
    private List<v> fFp;
    private int fFq;
    private a fFr;
    private boolean fFs;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(v vVar);
    }

    public c(Context context) {
        super(context);
        this.dkW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fFp != null) {
                    v vVar = (v) c.this.fFp.get(view.getId());
                    if (c.this.fFr != null && vVar != null) {
                        c.this.fFr.a(vVar);
                    }
                    c.this.wl();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.wl();
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

    private View bfq() {
        bfr();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.arc = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.dEx);
        this.arc.setOnClickListener(this.mOnClickListener);
        am.setBackgroundResource(this.dEx, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void bfr() {
    }

    public void g(List<v> list, int i) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            this.dEx = new LinearLayout(this.mContext);
            this.dEx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.dEx.setClipChildren(true);
            this.dEx.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                v vVar = list.get(i2);
                if (i == vVar.fyZ) {
                    this.dEx.addView(c(vVar.name, i2, true), layoutParams);
                } else {
                    this.dEx.addView(c(vVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.setBackgroundResource(view, R.color.cp_bg_line_c);
                    this.dEx.addView(view);
                }
            }
        }
    }

    public void bnq() {
        int i;
        am.setBackgroundResource(this.dEx, R.drawable.frs_tab_sort_select_bg);
        int childCount = this.dEx.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.fFp.size() && i2 < childCount) {
            v vVar = this.fFp.get(i3);
            View childAt = this.dEx.getChildAt(i2);
            if (childAt instanceof TextView) {
                if (this.fFq == vVar.fyZ) {
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
        textView.setOnClickListener(this.dkW);
        return textView;
    }

    public void setData(List<v> list, int i) {
        if (list != null) {
            this.fFp = list;
            this.fFq = i;
            g(list, i);
            setContentView(bfq());
        }
    }

    public void a(a aVar) {
        this.fFr = aVar;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    wn();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                wn();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        wl();
    }

    public void wl() {
        wo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm() {
        super.dismiss();
    }

    private void wn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.dEx.startAnimation(translateAnimation);
        this.arc.startAnimation(alphaAnimation);
    }

    private void wo() {
        if (!this.fFs) {
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
                    c.this.fFs = false;
                    c.this.wm();
                }
            });
            this.fFs = true;
            this.dEx.startAnimation(translateAnimation);
            this.arc.startAnimation(alphaAnimation);
        }
    }
}
