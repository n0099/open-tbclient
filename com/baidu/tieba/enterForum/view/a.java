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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends PopupWindow {
    private ViewGroup bkA;
    private View.OnClickListener ffU;
    private InterfaceC0620a hpF;
    private View hpG;
    private TextView hpH;
    private TextView hpI;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0620a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.ffU = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.hpH) {
                    if (a.this.hpF != null) {
                        a.this.hpF.onItemClick(1);
                    }
                } else if (view == a.this.hpI && a.this.hpF != null) {
                    a.this.hpF.onItemClick(2);
                }
                a.this.Jj();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Jj();
            }
        };
        this.mContext = context;
        setWidth(l.getDimens(context, R.dimen.tbds240));
        setHeight(l.getDimens(context, R.dimen.tbds247));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View bWD() {
        bWE();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bkA = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.hpG);
        this.bkA.setOnClickListener(this.mOnClickListener);
        ao.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_btn_a).ml(l.getDimens(this.mContext, R.dimen.tbds10)).mm(R.color.cp_shadow_a_alpha16).mn(l.getDimens(this.mContext, R.dimen.tbds21)).mo(0).mp(l.getDimens(this.mContext, R.dimen.tbds5)).aX(this.hpG);
        return frameLayout;
    }

    private void bWE() {
        this.hpG = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.hpH = (TextView) this.hpG.findViewById(R.id.sort_type_level_text);
        this.mLine = this.hpG.findViewById(R.id.sort_select_line);
        this.hpI = (TextView) this.hpG.findViewById(R.id.sort_type_update_text);
        this.hpH.setOnClickListener(this.ffU);
        this.hpI.setOnClickListener(this.ffU);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View bWD = bWD();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.hpH.setText(hVar.hhx);
                } else {
                    this.hpI.setText(hVar.hhx);
                }
                if (i == 1) {
                    ao.setViewTextColor(this.hpH, R.color.cp_link_tip_a);
                    ao.setViewTextColor(this.hpI, R.color.cp_cont_j);
                } else {
                    ao.setViewTextColor(this.hpI, R.color.cp_link_tip_a);
                    ao.setViewTextColor(this.hpH, R.color.cp_cont_j);
                }
            }
            setContentView(bWD);
        }
    }

    public void a(InterfaceC0620a interfaceC0620a) {
        this.hpF = interfaceC0620a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    Jl();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                Jl();
            }
        }
    }

    public void tX(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Jj();
    }

    public void Jj() {
        Jm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        super.dismiss();
    }

    private void Jl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.hpG.startAnimation(translateAnimation);
        this.bkA.startAnimation(alphaAnimation);
    }

    private void Jm() {
        if (!k.isFastDoubleClick()) {
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
                    a.this.Jk();
                }
            });
            this.hpG.startAnimation(translateAnimation);
            this.bkA.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.hpH, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.hpI, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_btn_a).ml(l.getDimens(this.mContext, R.dimen.tbds10)).mm(R.color.cp_shadow_a_alpha16).mn(l.getDimens(this.mContext, R.dimen.tbds21)).mo(0).mp(l.getDimens(this.mContext, R.dimen.tbds5)).aX(this.hpG);
    }
}
