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
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends PopupWindow {
    private ViewGroup ayy;
    private View.OnClickListener dXO;
    private InterfaceC0485a fTP;
    private View fTQ;
    private TextView fTR;
    private TextView fTS;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0485a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.dXO = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fTR) {
                    if (a.this.fTP != null) {
                        a.this.fTP.onItemClick(1);
                    }
                } else if (view == a.this.fTS && a.this.fTP != null) {
                    a.this.fTP.onItemClick(2);
                }
                a.this.yk();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.yk();
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

    private View bwJ() {
        bwK();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.ayy = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fTQ);
        this.ayy.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.f.a.aEs().kA(R.color.cp_btn_a).kv(l.getDimens(this.mContext, R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).kx(l.getDimens(this.mContext, R.dimen.tbds21)).ky(0).kz(l.getDimens(this.mContext, R.dimen.tbds5)).aM(this.fTQ);
        return frameLayout;
    }

    private void bwK() {
        this.fTQ = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fTR = (TextView) this.fTQ.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fTQ.findViewById(R.id.sort_select_line);
        this.fTS = (TextView) this.fTQ.findViewById(R.id.sort_type_update_text);
        this.fTR.setOnClickListener(this.dXO);
        this.fTS.setOnClickListener(this.dXO);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bwJ = bwJ();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fTR.setText(kVar.fOO);
                } else {
                    this.fTS.setText(kVar.fOO);
                }
                if (i == 1) {
                    am.setViewTextColor(this.fTR, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fTS, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.fTS, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.fTR, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bwJ);
        }
    }

    public void a(InterfaceC0485a interfaceC0485a) {
        this.fTP = interfaceC0485a;
    }

    public void P(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    ym();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                ym();
            }
        }
    }

    public void rN(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        yk();
    }

    public void yk() {
        yn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl() {
        super.dismiss();
    }

    private void ym() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fTQ.startAnimation(translateAnimation);
        this.ayy.startAnimation(alphaAnimation);
    }

    private void yn() {
        if (!com.baidu.tbadk.util.k.isFastDoubleClick()) {
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
                    a.this.yl();
                }
            });
            this.fTQ.startAnimation(translateAnimation);
            this.ayy.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fTR, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.fTS, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.f.a.aEs().kA(R.color.cp_btn_a).kv(l.getDimens(this.mContext, R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).kx(l.getDimens(this.mContext, R.dimen.tbds21)).ky(0).kz(l.getDimens(this.mContext, R.dimen.tbds5)).aM(this.fTQ);
    }
}
