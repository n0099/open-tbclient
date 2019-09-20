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
    private View.OnClickListener dbz;
    private LinearLayout dxY;
    private List<v> fFY;
    private int fFZ;
    private a fGa;
    private boolean fGb;
    private ViewGroup fdr;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(v vVar);
    }

    public c(Context context) {
        super(context);
        this.dbz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fFY != null) {
                    v vVar = (v) c.this.fFY.get(view.getId());
                    if (c.this.fGa != null && vVar != null) {
                        c.this.fGa.a(vVar);
                    }
                    c.this.bhx();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bhx();
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

    private View bhw() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fdr = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.dxY);
        this.fdr.setOnClickListener(this.mOnClickListener);
        am.k(this.dxY, R.drawable.frs_tab_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
    }

    public void j(List<v> list, int i) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            this.dxY = new LinearLayout(this.mContext);
            this.dxY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.dxY.setClipChildren(true);
            this.dxY.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds280), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds88));
            for (int i2 = 0; i2 < list.size(); i2++) {
                v vVar = list.get(i2);
                if (i == vVar.fzK) {
                    this.dxY.addView(d(vVar.name, i2, true), layoutParams);
                } else {
                    this.dxY.addView(d(vVar.name, i2, false), layoutParams);
                }
                if (i2 != list.size() - 1) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1)));
                    am.k(view, R.color.cp_bg_line_c);
                    this.dxY.addView(view);
                }
            }
        }
    }

    public void bql() {
        int i;
        am.k(this.dxY, R.drawable.frs_tab_sort_select_bg);
        int childCount = this.dxY.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.fFY.size() && i2 < childCount) {
            v vVar = this.fFY.get(i3);
            View childAt = this.dxY.getChildAt(i2);
            if (childAt instanceof TextView) {
                if (this.fFZ == vVar.fzK) {
                    am.j((TextView) childAt, R.color.cp_link_tip_a);
                } else {
                    am.j((TextView) childAt, R.color.cp_cont_j);
                }
                i = i3 + 1;
            } else {
                am.k(childAt, R.color.cp_bg_line_c);
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
            am.j(textView, R.color.cp_link_tip_a);
        } else {
            am.j(textView, R.color.cp_cont_j);
        }
        textView.setOnClickListener(this.dbz);
        return textView;
    }

    public void setData(List<v> list, int i) {
        if (list != null) {
            this.fFY = list;
            this.fFZ = i;
            j(list, i);
            setContentView(bhw());
        }
    }

    public void a(a aVar) {
        this.fGa = aVar;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    update(iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds41), (iArr[1] + view.getHeight()) - 18, getWidth(), getHeight());
                    bhy();
                    return;
                }
                return;
            }
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr2[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                bhy();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bhx();
    }

    public void bhx() {
        bhz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        super.dismiss();
    }

    private void bhy() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.dxY.startAnimation(translateAnimation);
        this.fdr.startAnimation(alphaAnimation);
    }

    private void bhz() {
        if (!this.fGb) {
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
                    c.this.fGb = false;
                    c.this.MW();
                }
            });
            this.fGb = true;
            this.dxY.startAnimation(translateAnimation);
            this.fdr.startAnimation(alphaAnimation);
        }
    }
}
