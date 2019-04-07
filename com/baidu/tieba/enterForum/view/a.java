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
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.i;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {
    private View.OnClickListener cPW;
    private ViewGroup eGn;
    private InterfaceC0283a eGo;
    private View eGp;
    private TextView eGq;
    private TextView eGr;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0283a {
        void lH(int i);
    }

    public a(Context context) {
        super(context);
        this.cPW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.eGq) {
                    if (a.this.eGo != null) {
                        a.this.eGo.lH(1);
                    }
                } else if (view == a.this.eGr && a.this.eGo != null) {
                    a.this.eGo.lH(2);
                }
                a.this.aXr();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aXr();
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
        this.eGn = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.eGp);
        this.eGn.setOnClickListener(this.mOnClickListener);
        al.l(this.mLine, d.C0277d.cp_bg_line_a);
        al.k(this.eGp, d.f.enter_forum_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
        this.eGp = LayoutInflater.from(this.mContext).inflate(d.h.layout_sort_select, (ViewGroup) null);
        this.eGq = (TextView) this.eGp.findViewById(d.g.sort_type_level_text);
        this.mLine = this.eGp.findViewById(d.g.sort_select_line);
        this.eGr = (TextView) this.eGp.findViewById(d.g.sort_type_update_text);
        this.eGq.setOnClickListener(this.cPW);
        this.eGr.setOnClickListener(this.cPW);
    }

    public void setData(List<i> list, int i) {
        if (list != null) {
            View aXq = aXq();
            for (i iVar : list) {
                if (iVar.sortType == 1) {
                    this.eGq.setText(iVar.eBK);
                } else {
                    this.eGr.setText(iVar.eBK);
                }
                if (i == 1) {
                    al.j(this.eGq, d.C0277d.cp_link_tip_a);
                    al.j(this.eGr, d.C0277d.cp_cont_j);
                } else {
                    al.j(this.eGr, d.C0277d.cp_link_tip_a);
                    al.j(this.eGq, d.C0277d.cp_cont_j);
                }
            }
            setContentView(aXq);
        }
    }

    public void a(InterfaceC0283a interfaceC0283a) {
        this.eGo = interfaceC0283a;
    }

    public void bg(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aXt();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(d.e.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(d.e.tbds20))) {
                aXt();
            }
        }
    }

    public void pj(int i) {
        this.mStatusBarHeight = i;
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
        this.eGp.startAnimation(translateAnimation);
        this.eGn.startAnimation(alphaAnimation);
    }

    private void aXu() {
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
                a.this.aXs();
            }
        });
        this.eGp.startAnimation(translateAnimation);
        this.eGn.startAnimation(alphaAnimation);
    }
}
