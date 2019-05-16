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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {
    private View.OnClickListener cYi;
    private ViewGroup eWp;
    private InterfaceC0301a eWq;
    private View eWr;
    private TextView eWs;
    private TextView eWt;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0301a {
        void mu(int i);
    }

    public a(Context context) {
        super(context);
        this.cYi = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.eWs) {
                    if (a.this.eWq != null) {
                        a.this.eWq.mu(1);
                    }
                } else if (view == a.this.eWt && a.this.eWq != null) {
                    a.this.eWq.mu(2);
                }
                a.this.beG();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.beG();
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

    private View beF() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.eWp = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.eWr);
        this.eWp.setOnClickListener(this.mOnClickListener);
        al.l(this.mLine, R.color.cp_bg_line_a);
        al.k(this.eWr, R.drawable.enter_forum_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
        this.eWr = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.eWs = (TextView) this.eWr.findViewById(R.id.sort_type_level_text);
        this.mLine = this.eWr.findViewById(R.id.sort_select_line);
        this.eWt = (TextView) this.eWr.findViewById(R.id.sort_type_update_text);
        this.eWs.setOnClickListener(this.cYi);
        this.eWt.setOnClickListener(this.cYi);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View beF = beF();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.eWs.setText(kVar.eRw);
                } else {
                    this.eWt.setText(kVar.eRw);
                }
                if (i == 1) {
                    al.j(this.eWs, R.color.cp_link_tip_a);
                    al.j(this.eWt, R.color.cp_cont_j);
                } else {
                    al.j(this.eWt, R.color.cp_link_tip_a);
                    al.j(this.eWs, R.color.cp_cont_j);
                }
            }
            setContentView(beF);
        }
    }

    public void a(InterfaceC0301a interfaceC0301a) {
        this.eWq = interfaceC0301a;
    }

    public void bm(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    beH();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                beH();
            }
        }
    }

    public void qp(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        beG();
    }

    public void beG() {
        beI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        super.dismiss();
    }

    private void beH() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.eWr.startAnimation(translateAnimation);
        this.eWp.startAnimation(alphaAnimation);
    }

    private void beI() {
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
                    a.this.Me();
                }
            });
            this.eWr.startAnimation(translateAnimation);
            this.eWp.startAnimation(alphaAnimation);
        }
    }
}
