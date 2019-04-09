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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends PopupWindow {
    private View.OnClickListener cPX;
    private LinearLayout djr;
    private ViewGroup eGo;
    private List<v> fie;
    private a fif;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(v vVar);
    }

    public c(Context context) {
        super(context);
        this.cPX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fie != null) {
                    v vVar = (v) c.this.fie.get(view.getId());
                    if (c.this.fif != null && vVar != null) {
                        c.this.fif.a(vVar);
                    }
                    c.this.aXr();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aXr();
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

    private View aXq() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.eGo = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.djr);
        this.eGo.setOnClickListener(this.mOnClickListener);
        al.k(this.djr, d.f.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
    }

    public void j(List<v> list, int i) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            this.djr = new LinearLayout(this.mContext);
            this.djr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.djr.setClipChildren(true);
            this.djr.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(d.e.tbds280), this.mContext.getResources().getDimensionPixelOffset(d.e.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                v vVar = list.get(i2);
                if (i == vVar.fcn) {
                    this.djr.addView(d(vVar.name, i2, true), layoutParams);
                } else {
                    this.djr.addView(d(vVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(d.e.ds1)));
                    al.k(view, d.C0277d.common_color_10312);
                    this.djr.addView(view);
                }
            }
        }
    }

    private TextView d(String str, int i, boolean z) {
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, this.mContext.getResources().getDimension(d.e.tbds36));
        textView.setText(str);
        textView.setTag(str);
        textView.setId(i);
        textView.setGravity(17);
        if (z) {
            al.j(textView, d.C0277d.cp_link_tip_a);
        } else {
            al.j(textView, d.C0277d.cp_cont_j);
        }
        textView.setOnClickListener(this.cPX);
        return textView;
    }

    public void setData(List<v> list, int i) {
        if (list != null) {
            this.fie = list;
            j(list, i);
            setContentView(aXq());
        }
    }

    public void a(a aVar) {
        this.fif = aVar;
    }

    public void bg(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(d.e.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    aXt();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(d.e.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(d.e.tbds20))) {
                aXt();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        aXr();
    }

    public void aXr() {
        aXu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXs() {
        super.dismiss();
    }

    private void aXt() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.djr.startAnimation(translateAnimation);
        this.eGo.startAnimation(alphaAnimation);
    }

    private void aXu() {
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
                c.this.aXs();
            }
        });
        this.djr.startAnimation(translateAnimation);
        this.eGo.startAnimation(alphaAnimation);
    }
}
