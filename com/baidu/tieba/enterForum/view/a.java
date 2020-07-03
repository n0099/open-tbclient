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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.i;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends PopupWindow {
    private ViewGroup bkg;
    private View.OnClickListener fbs;
    private InterfaceC0611a hjX;
    private View hjY;
    private TextView hjZ;
    private TextView hka;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0611a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.fbs = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.hjZ) {
                    if (a.this.hjX != null) {
                        a.this.hjX.onItemClick(1);
                    }
                } else if (view == a.this.hka && a.this.hjX != null) {
                    a.this.hjX.onItemClick(2);
                }
                a.this.Jd();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Jd();
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

    private View bTl() {
        bTm();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bkg = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.hjY);
        this.bkg.setOnClickListener(this.mOnClickListener);
        an.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.aXp().lW(R.color.cp_btn_a).lR(l.getDimens(this.mContext, R.dimen.tbds10)).lS(R.color.cp_shadow_a_alpha16).lT(l.getDimens(this.mContext, R.dimen.tbds21)).lU(0).lV(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.hjY);
        return frameLayout;
    }

    private void bTm() {
        this.hjY = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.hjZ = (TextView) this.hjY.findViewById(R.id.sort_type_level_text);
        this.mLine = this.hjY.findViewById(R.id.sort_select_line);
        this.hka = (TextView) this.hjY.findViewById(R.id.sort_type_update_text);
        this.hjZ.setOnClickListener(this.fbs);
        this.hka.setOnClickListener(this.fbs);
    }

    public void setData(List<i> list, int i) {
        if (list != null) {
            View bTl = bTl();
            for (i iVar : list) {
                if (iVar.sortType == 1) {
                    this.hjZ.setText(iVar.hbR);
                } else {
                    this.hka.setText(iVar.hbR);
                }
                if (i == 1) {
                    an.setViewTextColor(this.hjZ, (int) R.color.cp_link_tip_a);
                    an.setViewTextColor(this.hka, (int) R.color.cp_cont_j);
                } else {
                    an.setViewTextColor(this.hka, (int) R.color.cp_link_tip_a);
                    an.setViewTextColor(this.hjZ, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bTl);
        }
    }

    public void a(InterfaceC0611a interfaceC0611a) {
        this.hjX = interfaceC0611a;
    }

    public void L(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    Jf();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                Jf();
            }
        }
    }

    public void tF(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Jd();
    }

    public void Jd() {
        Jg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Je() {
        super.dismiss();
    }

    private void Jf() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.hjY.startAnimation(translateAnimation);
        this.bkg.startAnimation(alphaAnimation);
    }

    private void Jg() {
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
                    a.this.Je();
                }
            });
            this.hjY.startAnimation(translateAnimation);
            this.bkg.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        an.setViewTextColor(this.hjZ, (int) R.color.cp_link_tip_a);
        an.setViewTextColor(this.hka, (int) R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.aXp().lW(R.color.cp_btn_a).lR(l.getDimens(this.mContext, R.dimen.tbds10)).lS(R.color.cp_shadow_a_alpha16).lT(l.getDimens(this.mContext, R.dimen.tbds21)).lU(0).lV(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.hjY);
    }
}
