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
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private ViewGroup bNP;
    private View.OnClickListener gmj;
    private InterfaceC0724a iOR;
    private View iOS;
    private TextView iOT;
    private TextView iOU;
    private int iOV;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0724a {
        void fx(int i);
    }

    public a(Context context) {
        super(context);
        this.gmj = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.iOT) {
                    if (a.this.iOR != null) {
                        a.this.iOR.fx(1);
                    }
                } else if (view == a.this.iOU && a.this.iOR != null) {
                    a.this.iOR.fx(2);
                }
                a.this.Xg();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Xg();
            }
        };
        this.mContext = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View czX() {
        czY();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bNP = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.iOS);
        this.bNP.setOnClickListener(this.mOnClickListener);
        com.baidu.tbadk.core.util.f.a.bwU().qI(R.color.CAM_X0901).qD(l.getDimens(this.mContext, R.dimen.tbds10)).qE(R.color.CAM_X0804).qF(l.getDimens(this.mContext, R.dimen.tbds21)).qG(0).qH(l.getDimens(this.mContext, R.dimen.tbds4)).bz(this.iOS);
        return frameLayout;
    }

    private void czY() {
        this.iOS = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.iOT = (TextView) this.iOS.findViewById(R.id.sort_type_level_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iOT).pE(R.string.F_X01);
        this.iOU = (TextView) this.iOS.findViewById(R.id.sort_type_update_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iOU).pE(R.string.F_X01);
        this.iOT.setOnClickListener(this.gmj);
        this.iOU.setOnClickListener(this.gmj);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            this.iOV = i;
            View czX = czX();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.iOT.setText(hVar.iGQ);
                } else {
                    this.iOU.setText(hVar.iGQ);
                }
                if (i == 1) {
                    ao.setViewTextColor(this.iOT, R.color.CAM_X0105);
                    ao.setViewTextColor(this.iOU, R.color.CAM_X0108);
                } else {
                    ao.setViewTextColor(this.iOU, R.color.CAM_X0105);
                    ao.setViewTextColor(this.iOT, R.color.CAM_X0108);
                }
            }
            setContentView(czX);
        }
    }

    public void a(InterfaceC0724a interfaceC0724a) {
        this.iOR = interfaceC0724a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aFR();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                aFR();
            }
        }
    }

    public void zn(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Xg();
    }

    public void Xg() {
        Xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh() {
        super.dismiss();
    }

    private void aFR() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iOS.startAnimation(translateAnimation);
        this.bNP.startAnimation(alphaAnimation);
    }

    private void Xj() {
        if (!k.isFastDoubleClick()) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(350L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(240L);
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
                    a.this.Xh();
                }
            });
            this.iOS.startAnimation(translateAnimation);
            this.bNP.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        if (this.iOV == 1) {
            ao.setViewTextColor(this.iOT, R.color.CAM_X0105);
            ao.setViewTextColor(this.iOU, R.color.CAM_X0108);
        } else {
            ao.setViewTextColor(this.iOU, R.color.CAM_X0105);
            ao.setViewTextColor(this.iOT, R.color.CAM_X0108);
        }
        com.baidu.tbadk.core.util.f.a.bwU().qI(R.color.CAM_X0901).qD(l.getDimens(this.mContext, R.dimen.tbds10)).qE(R.color.CAM_X0804).qF(l.getDimens(this.mContext, R.dimen.tbds21)).qG(0).qH(l.getDimens(this.mContext, R.dimen.tbds4)).bz(this.iOS);
    }
}
