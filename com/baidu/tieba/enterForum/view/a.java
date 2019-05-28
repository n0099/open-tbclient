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
    private View.OnClickListener cYj;
    private ViewGroup eWq;
    private InterfaceC0301a eWr;
    private View eWs;
    private TextView eWt;
    private TextView eWu;
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
        this.cYj = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.eWt) {
                    if (a.this.eWr != null) {
                        a.this.eWr.mu(1);
                    }
                } else if (view == a.this.eWu && a.this.eWr != null) {
                    a.this.eWr.mu(2);
                }
                a.this.beJ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.beJ();
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
        frameLayout.addView(this.eWs);
        this.eWq.setOnClickListener(this.mOnClickListener);
        al.l(this.mLine, R.color.cp_bg_line_a);
        al.k(this.eWs, R.drawable.enter_forum_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
        this.eWs = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.eWt = (TextView) this.eWs.findViewById(R.id.sort_type_level_text);
        this.mLine = this.eWs.findViewById(R.id.sort_select_line);
        this.eWu = (TextView) this.eWs.findViewById(R.id.sort_type_update_text);
        this.eWt.setOnClickListener(this.cYj);
        this.eWu.setOnClickListener(this.cYj);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View beI = beI();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.eWt.setText(kVar.eRx);
                } else {
                    this.eWu.setText(kVar.eRx);
                }
                if (i == 1) {
                    al.j(this.eWt, R.color.cp_link_tip_a);
                    al.j(this.eWu, R.color.cp_cont_j);
                } else {
                    al.j(this.eWu, R.color.cp_link_tip_a);
                    al.j(this.eWt, R.color.cp_cont_j);
                }
            }
            setContentView(beI);
        }
    }

    public void a(InterfaceC0301a interfaceC0301a) {
        this.eWr = interfaceC0301a;
    }

    public void bm(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    beK();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                beK();
            }
        }
    }

    public void qp(int i) {
        this.mStatusBarHeight = i;
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
        this.eWs.startAnimation(translateAnimation);
        this.eWq.startAnimation(alphaAnimation);
    }

    private void beL() {
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
            this.eWs.startAnimation(translateAnimation);
            this.eWq.startAnimation(alphaAnimation);
        }
    }
}
