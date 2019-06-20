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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends PopupWindow {
    private View.OnClickListener cYk;
    private LinearLayout dtY;
    private ViewGroup eWq;
    private List<v> fyA;
    private a fyB;
    private boolean fyC;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(v vVar);
    }

    public c(Context context) {
        super(context);
        this.cYk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fyA != null) {
                    v vVar = (v) c.this.fyA.get(view.getId());
                    if (c.this.fyB != null && vVar != null) {
                        c.this.fyB.a(vVar);
                    }
                    c.this.beJ();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.beJ();
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

    private View beI() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.eWq = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.dtY);
        this.eWq.setOnClickListener(this.mOnClickListener);
        al.k(this.dtY, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
    }

    public void j(List<v> list, int i) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            this.dtY = new LinearLayout(this.mContext);
            this.dtY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.dtY.setClipChildren(true);
            this.dtY.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                v vVar = list.get(i2);
                if (i == vVar.fsC) {
                    this.dtY.addView(d(vVar.name, i2, true), layoutParams);
                } else {
                    this.dtY.addView(d(vVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    al.k(view, R.color.common_color_10312);
                    this.dtY.addView(view);
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
            al.j(textView, R.color.cp_link_tip_a);
        } else {
            al.j(textView, R.color.cp_cont_j);
        }
        textView.setOnClickListener(this.cYk);
        return textView;
    }

    public void setData(List<v> list, int i) {
        if (list != null) {
            this.fyA = list;
            j(list, i);
            setContentView(beI());
        }
    }

    public void a(a aVar) {
        this.fyB = aVar;
    }

    public void bm(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    beK();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                beK();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        beJ();
    }

    public void beJ() {
        beL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        super.dismiss();
    }

    private void beK() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.dtY.startAnimation(translateAnimation);
        this.eWq.startAnimation(alphaAnimation);
    }

    private void beL() {
        if (!this.fyC) {
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
                    c.this.fyC = false;
                    c.this.Me();
                }
            });
            this.fyC = true;
            this.dtY.startAnimation(translateAnimation);
            this.eWq.startAnimation(alphaAnimation);
        }
    }
}
