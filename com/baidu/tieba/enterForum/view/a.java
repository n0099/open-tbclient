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
    private ViewGroup bJd;
    private View.OnClickListener ghB;
    private InterfaceC0707a iKk;
    private View iKl;
    private TextView iKm;
    private TextView iKn;
    private int iKo;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0707a {
        void dR(int i);
    }

    public a(Context context) {
        super(context);
        this.ghB = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.iKm) {
                    if (a.this.iKk != null) {
                        a.this.iKk.dR(1);
                    }
                } else if (view == a.this.iKn && a.this.iKk != null) {
                    a.this.iKk.dR(2);
                }
                a.this.Tn();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Tn();
            }
        };
        this.mContext = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View cwf() {
        cwg();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bJd = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.iKl);
        this.bJd.setOnClickListener(this.mOnClickListener);
        com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0901).oW(l.getDimens(this.mContext, R.dimen.tbds10)).oX(R.color.CAM_X0804).oY(l.getDimens(this.mContext, R.dimen.tbds21)).oZ(0).pa(l.getDimens(this.mContext, R.dimen.tbds4)).bz(this.iKl);
        return frameLayout;
    }

    private void cwg() {
        this.iKl = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.iKm = (TextView) this.iKl.findViewById(R.id.sort_type_level_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iKm).nX(R.string.F_X01);
        this.iKn = (TextView) this.iKl.findViewById(R.id.sort_type_update_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.iKn).nX(R.string.F_X01);
        this.iKm.setOnClickListener(this.ghB);
        this.iKn.setOnClickListener(this.ghB);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            this.iKo = i;
            View cwf = cwf();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.iKm.setText(hVar.iCj);
                } else {
                    this.iKn.setText(hVar.iCj);
                }
                if (i == 1) {
                    ao.setViewTextColor(this.iKm, R.color.CAM_X0105);
                    ao.setViewTextColor(this.iKn, R.color.CAM_X0108);
                } else {
                    ao.setViewTextColor(this.iKn, R.color.CAM_X0105);
                    ao.setViewTextColor(this.iKm, R.color.CAM_X0108);
                }
            }
            setContentView(cwf);
        }
    }

    public void a(InterfaceC0707a interfaceC0707a) {
        this.iKk = interfaceC0707a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aBX();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                aBX();
            }
        }
    }

    public void xH(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Tn();
    }

    public void Tn() {
        Tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To() {
        super.dismiss();
    }

    private void aBX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iKl.startAnimation(translateAnimation);
        this.bJd.startAnimation(alphaAnimation);
    }

    private void Tq() {
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
                    a.this.To();
                }
            });
            this.iKl.startAnimation(translateAnimation);
            this.bJd.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        if (this.iKo == 1) {
            ao.setViewTextColor(this.iKm, R.color.CAM_X0105);
            ao.setViewTextColor(this.iKn, R.color.CAM_X0108);
        } else {
            ao.setViewTextColor(this.iKn, R.color.CAM_X0105);
            ao.setViewTextColor(this.iKm, R.color.CAM_X0108);
        }
        com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0901).oW(l.getDimens(this.mContext, R.dimen.tbds10)).oX(R.color.CAM_X0804).oY(l.getDimens(this.mContext, R.dimen.tbds21)).oZ(0).pa(l.getDimens(this.mContext, R.dimen.tbds4)).bz(this.iKl);
    }
}
