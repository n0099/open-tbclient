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
    private ViewGroup beV;
    private View.OnClickListener eQW;
    private InterfaceC0603a gWW;
    private View gWX;
    private TextView gWY;
    private TextView gWZ;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0603a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.eQW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.gWY) {
                    if (a.this.gWW != null) {
                        a.this.gWW.onItemClick(1);
                    }
                } else if (view == a.this.gWZ && a.this.gWW != null) {
                    a.this.gWW.onItemClick(2);
                }
                a.this.HQ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.HQ();
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

    private View bQg() {
        bQh();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.beV = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.gWX);
        this.beV.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.aVu().lD(R.color.cp_btn_a).ly(l.getDimens(this.mContext, R.dimen.tbds10)).lz(R.color.cp_shadow_a_alpha16).lA(l.getDimens(this.mContext, R.dimen.tbds21)).lB(0).lC(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gWX);
        return frameLayout;
    }

    private void bQh() {
        this.gWX = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.gWY = (TextView) this.gWX.findViewById(R.id.sort_type_level_text);
        this.mLine = this.gWX.findViewById(R.id.sort_select_line);
        this.gWZ = (TextView) this.gWX.findViewById(R.id.sort_type_update_text);
        this.gWY.setOnClickListener(this.eQW);
        this.gWZ.setOnClickListener(this.eQW);
    }

    public void setData(List<n> list, int i) {
        if (list != null) {
            View bQg = bQg();
            for (n nVar : list) {
                if (nVar.sortType == 1) {
                    this.gWY.setText(nVar.gOX);
                } else {
                    this.gWZ.setText(nVar.gOX);
                }
                if (i == 1) {
                    am.setViewTextColor(this.gWY, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gWZ, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.gWZ, (int) R.color.cp_link_tip_a);
                    am.setViewTextColor(this.gWY, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bQg);
        }
    }

    public void a(InterfaceC0603a interfaceC0603a) {
        this.gWW = interfaceC0603a;
    }

    public void S(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    HS();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                HS();
            }
        }
    }

    public void tc(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        HQ();
    }

    public void HQ() {
        HT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HR() {
        super.dismiss();
    }

    private void HS() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.gWX.startAnimation(translateAnimation);
        this.beV.startAnimation(alphaAnimation);
    }

    private void HT() {
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
                    a.this.HR();
                }
            });
            this.gWX.startAnimation(translateAnimation);
            this.beV.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.gWY, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.gWZ, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.aVu().lD(R.color.cp_btn_a).ly(l.getDimens(this.mContext, R.dimen.tbds10)).lz(R.color.cp_shadow_a_alpha16).lA(l.getDimens(this.mContext, R.dimen.tbds21)).lB(0).lC(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.gWX);
    }
}
