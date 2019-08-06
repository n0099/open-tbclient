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
    private View.OnClickListener cZN;
    private LinearLayout dwn;
    private List<v> fEk;
    private a fEl;
    private boolean fEm;
    private ViewGroup fbQ;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(v vVar);
    }

    public c(Context context) {
        super(context);
        this.cZN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fEk != null) {
                    v vVar = (v) c.this.fEk.get(view.getId());
                    if (c.this.fEl != null && vVar != null) {
                        c.this.fEl.a(vVar);
                    }
                    c.this.bgT();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bgT();
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

    private View bgS() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fbQ = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.dwn);
        this.fbQ.setOnClickListener(this.mOnClickListener);
        am.k(this.dwn, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
    }

    public void j(List<v> list, int i) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            this.dwn = new LinearLayout(this.mContext);
            this.dwn.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.dwn.setClipChildren(true);
            this.dwn.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                v vVar = list.get(i2);
                if (i == vVar.fxX) {
                    this.dwn.addView(d(vVar.name, i2, true), layoutParams);
                } else {
                    this.dwn.addView(d(vVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.k(view, R.color.common_color_10312);
                    this.dwn.addView(view);
                }
            }
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
            am.j(textView, R.color.cp_link_tip_a);
        } else {
            am.j(textView, R.color.cp_cont_j);
        }
        textView.setOnClickListener(this.cZN);
        return textView;
    }

    public void setData(List<v> list, int i) {
        if (list != null) {
            this.fEk = list;
            j(list, i);
            setContentView(bgS());
        }
    }

    public void a(a aVar) {
        this.fEl = aVar;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    bgU();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                bgU();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bgT();
    }

    public void bgT() {
        bgV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        super.dismiss();
    }

    private void bgU() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.dwn.startAnimation(translateAnimation);
        this.fbQ.startAnimation(alphaAnimation);
    }

    private void bgV() {
        if (!this.fEm) {
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
                    c.this.fEm = false;
                    c.this.MS();
                }
            });
            this.fEm = true;
            this.dwn.startAnimation(translateAnimation);
            this.fbQ.startAnimation(alphaAnimation);
        }
    }
}
