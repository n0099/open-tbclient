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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.n;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends PopupWindow {
    private ViewGroup aXB;
    private View.OnClickListener eCx;
    private InterfaceC0553a gIl;
    private View gIm;
    private TextView gIn;
    private TextView gIo;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0553a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.eCx = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.gIn) {
                    if (a.this.gIl != null) {
                        a.this.gIl.onItemClick(1);
                    }
                } else if (view == a.this.gIo && a.this.gIl != null) {
                    a.this.gIl.onItemClick(2);
                }
                a.this.FX();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.FX();
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

    private View bJL() {
        bJM();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aXB = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.gIm);
        this.aXB.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.aPq().lb(R.color.cp_btn_a).kW(l.getDimens(this.mContext, R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kY(l.getDimens(this.mContext, R.dimen.tbds21)).kZ(0).la(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gIm);
        return frameLayout;
    }

    private void bJM() {
        this.gIm = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.gIn = (TextView) this.gIm.findViewById(R.id.sort_type_level_text);
        this.mLine = this.gIm.findViewById(R.id.sort_select_line);
        this.gIo = (TextView) this.gIm.findViewById(R.id.sort_type_update_text);
        this.gIn.setOnClickListener(this.eCx);
        this.gIo.setOnClickListener(this.eCx);
    }

    public void setData(List<n> list, int i) {
        if (list != null) {
            View bJL = bJL();
            for (n nVar : list) {
                if (nVar.sortType == 1) {
                    this.gIn.setText(nVar.gAn);
                } else {
                    this.gIo.setText(nVar.gAn);
                }
                if (i == 1) {
                    am.setViewTextColor(this.gIn, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gIo, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.gIo, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gIn, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bJL);
        }
    }

    public void a(InterfaceC0553a interfaceC0553a) {
        this.gIl = interfaceC0553a;
    }

    public void T(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    FZ();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                FZ();
            }
        }
    }

    public void sx(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        FX();
    }

    public void FX() {
        Ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FY() {
        super.dismiss();
    }

    private void FZ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.gIm.startAnimation(translateAnimation);
        this.aXB.startAnimation(alphaAnimation);
    }

    private void Ga() {
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
                    a.this.FY();
                }
            });
            this.gIm.startAnimation(translateAnimation);
            this.aXB.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.gIn, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.gIo, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.aPq().lb(R.color.cp_btn_a).kW(l.getDimens(this.mContext, R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kY(l.getDimens(this.mContext, R.dimen.tbds21)).kZ(0).la(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gIm);
    }
}
