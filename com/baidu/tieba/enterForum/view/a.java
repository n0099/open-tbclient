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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import java.util.List;
/* loaded from: classes22.dex */
public class a extends PopupWindow {
    private ViewGroup bxf;
    private View.OnClickListener fGO;
    private View hYA;
    private TextView hYB;
    private TextView hYC;
    private InterfaceC0686a hYz;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0686a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.fGO = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.hYB) {
                    if (a.this.hYz != null) {
                        a.this.hYz.onItemClick(1);
                    }
                } else if (view == a.this.hYC && a.this.hYz != null) {
                    a.this.hYz.onItemClick(2);
                }
                a.this.QJ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QJ();
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

    private View cnC() {
        cnD();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bxf = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.hYA);
        this.bxf.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_btn_a).oZ(l.getDimens(this.mContext, R.dimen.tbds10)).pa(R.color.cp_shadow_a_alpha16).pb(l.getDimens(this.mContext, R.dimen.tbds21)).pc(0).pd(l.getDimens(this.mContext, R.dimen.tbds5)).bf(this.hYA);
        return frameLayout;
    }

    private void cnD() {
        this.hYA = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.hYB = (TextView) this.hYA.findViewById(R.id.sort_type_level_text);
        this.mLine = this.hYA.findViewById(R.id.sort_select_line);
        this.hYC = (TextView) this.hYA.findViewById(R.id.sort_type_update_text);
        this.hYB.setOnClickListener(this.fGO);
        this.hYC.setOnClickListener(this.fGO);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View cnC = cnC();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.hYB.setText(hVar.hQw);
                } else {
                    this.hYC.setText(hVar.hQw);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.hYB, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hYC, R.color.cp_cont_j);
                } else {
                    ap.setViewTextColor(this.hYC, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hYB, R.color.cp_cont_j);
                }
            }
            setContentView(cnC);
        }
    }

    public void a(InterfaceC0686a interfaceC0686a) {
        this.hYz = interfaceC0686a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    QL();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                QL();
            }
        }
    }

    public void xr(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        QJ();
    }

    public void QJ() {
        QM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QK() {
        super.dismiss();
    }

    private void QL() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.hYA.startAnimation(translateAnimation);
        this.bxf.startAnimation(alphaAnimation);
    }

    private void QM() {
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
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
                    a.this.QK();
                }
            });
            this.hYA.startAnimation(translateAnimation);
            this.bxf.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hYB, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.hYC, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_btn_a).oZ(l.getDimens(this.mContext, R.dimen.tbds10)).pa(R.color.cp_shadow_a_alpha16).pb(l.getDimens(this.mContext, R.dimen.tbds21)).pc(0).pd(l.getDimens(this.mContext, R.dimen.tbds5)).bf(this.hYA);
    }
}
