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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {
    private ViewGroup arc;
    private View.OnClickListener dkW;
    private InterfaceC0402a fgc;
    private View fgd;
    private TextView fge;
    private TextView fgf;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0402a {
        void lL(int i);
    }

    public a(Context context) {
        super(context);
        this.dkW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fge) {
                    if (a.this.fgc != null) {
                        a.this.fgc.lL(1);
                    }
                } else if (view == a.this.fgf && a.this.fgc != null) {
                    a.this.fgc.lL(2);
                }
                a.this.wl();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.wl();
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
        frameLayout.addView(this.fgd);
        this.arc.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fgd, R.drawable.enter_forum_sort_select_bg);
        return frameLayout;
    }

    private void bfr() {
        this.fgd = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fge = (TextView) this.fgd.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fgd.findViewById(R.id.sort_select_line);
        this.fgf = (TextView) this.fgd.findViewById(R.id.sort_type_update_text);
        this.fge.setOnClickListener(this.dkW);
        this.fgf.setOnClickListener(this.dkW);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bfq = bfq();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fge.setText(kVar.faY);
                } else {
                    this.fgf.setText(kVar.faY);
                }
                if (i == 1) {
                    am.setViewTextColor(this.fge, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fgf, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.fgf, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fge, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bfq);
        }
    }

    public void a(InterfaceC0402a interfaceC0402a) {
        this.fgc = interfaceC0402a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    wn();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                wn();
            }
        }
    }

    public void pI(int i) {
        this.mStatusBarHeight = i;
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
        this.fgd.startAnimation(translateAnimation);
        this.arc.startAnimation(alphaAnimation);
    }

    private void wo() {
        if (!i.isFastDoubleClick()) {
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
                    a.this.wm();
                }
            });
            this.fgd.startAnimation(translateAnimation);
            this.arc.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fgd, R.drawable.enter_forum_sort_select_bg);
        am.setViewTextColor(this.fge, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.fgf, (int) R.color.cp_cont_j);
    }
}
