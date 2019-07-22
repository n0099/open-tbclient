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
    private View.OnClickListener cZG;
    private ViewGroup fbr;
    private InterfaceC0298a fbs;
    private View fbt;
    private TextView fbu;
    private TextView fbv;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0298a {
        void mB(int i);
    }

    public a(Context context) {
        super(context);
        this.cZG = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fbu) {
                    if (a.this.fbs != null) {
                        a.this.fbs.mB(1);
                    }
                } else if (view == a.this.fbv && a.this.fbs != null) {
                    a.this.fbs.mB(2);
                }
                a.this.bgM();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bgM();
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

    private View bgL() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fbr = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fbt);
        this.fbr.setOnClickListener(this.mOnClickListener);
        am.l(this.mLine, R.color.cp_bg_line_a);
        am.k(this.fbt, R.drawable.enter_forum_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
        this.fbt = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fbu = (TextView) this.fbt.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fbt.findViewById(R.id.sort_select_line);
        this.fbv = (TextView) this.fbt.findViewById(R.id.sort_type_update_text);
        this.fbu.setOnClickListener(this.cZG);
        this.fbv.setOnClickListener(this.cZG);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bgL = bgL();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fbu.setText(kVar.eWx);
                } else {
                    this.fbv.setText(kVar.eWx);
                }
                if (i == 1) {
                    am.j(this.fbu, R.color.cp_link_tip_a);
                    am.j(this.fbv, R.color.cp_cont_j);
                } else {
                    am.j(this.fbv, R.color.cp_link_tip_a);
                    am.j(this.fbu, R.color.cp_cont_j);
                }
            }
            setContentView(bgL);
        }
    }

    public void a(InterfaceC0298a interfaceC0298a) {
        this.fbs = interfaceC0298a;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    bgN();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                bgN();
            }
        }
    }

    public void qH(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bgM();
    }

    public void bgM() {
        bgO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        super.dismiss();
    }

    private void bgN() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fbt.startAnimation(translateAnimation);
        this.fbr.startAnimation(alphaAnimation);
    }

    private void bgO() {
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
                    a.this.MS();
                }
            });
            this.fbt.startAnimation(translateAnimation);
            this.fbr.startAnimation(alphaAnimation);
        }
    }
}
