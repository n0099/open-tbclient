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
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private ViewGroup bOn;
    private View.OnClickListener glG;
    private InterfaceC0714a iRP;
    private View iRQ;
    private TextView iRR;
    private TextView iRS;
    private int iRT;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0714a {
        void dW(int i);
    }

    public a(Context context) {
        super(context);
        this.glG = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.iRR) {
                    if (a.this.iRP != null) {
                        a.this.iRP.dW(1);
                    }
                } else if (view == a.this.iRS && a.this.iRP != null) {
                    a.this.iRP.dW(2);
                }
                a.this.UX();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.UX();
            }
        };
        this.mContext = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View cxE() {
        cxF();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bOn = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.iRQ);
        this.bOn.setOnClickListener(this.mOnClickListener);
        com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0901).pc(l.getDimens(this.mContext, R.dimen.tbds10)).pd(R.color.CAM_X0804).pe(l.getDimens(this.mContext, R.dimen.tbds21)).pf(0).pg(l.getDimens(this.mContext, R.dimen.tbds4)).bv(this.iRQ);
        return frameLayout;
    }

    private void cxF() {
        this.iRQ = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.iRR = (TextView) this.iRQ.findViewById(R.id.sort_type_level_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iRR).ob(R.string.F_X01);
        this.iRS = (TextView) this.iRQ.findViewById(R.id.sort_type_update_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iRS).ob(R.string.F_X01);
        this.iRR.setOnClickListener(this.glG);
        this.iRS.setOnClickListener(this.glG);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            this.iRT = i;
            View cxE = cxE();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.iRR.setText(hVar.iJQ);
                } else {
                    this.iRS.setText(hVar.iJQ);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.iRR, R.color.CAM_X0105);
                    ap.setViewTextColor(this.iRS, R.color.CAM_X0108);
                } else {
                    ap.setViewTextColor(this.iRS, R.color.CAM_X0105);
                    ap.setViewTextColor(this.iRR, R.color.CAM_X0108);
                }
            }
            setContentView(cxE);
        }
    }

    public void a(InterfaceC0714a interfaceC0714a) {
        this.iRP = interfaceC0714a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aCx();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                aCx();
            }
        }
    }

    public void xS(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        UX();
    }

    public void UX() {
        Va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UY() {
        super.dismiss();
    }

    private void aCx() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iRQ.startAnimation(translateAnimation);
        this.bOn.startAnimation(alphaAnimation);
    }

    private void Va() {
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
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
                    a.this.UY();
                }
            });
            this.iRQ.startAnimation(translateAnimation);
            this.bOn.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        if (this.iRT == 1) {
            ap.setViewTextColor(this.iRR, R.color.CAM_X0105);
            ap.setViewTextColor(this.iRS, R.color.CAM_X0108);
        } else {
            ap.setViewTextColor(this.iRS, R.color.CAM_X0105);
            ap.setViewTextColor(this.iRR, R.color.CAM_X0108);
        }
        com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0901).pc(l.getDimens(this.mContext, R.dimen.tbds10)).pd(R.color.CAM_X0804).pe(l.getDimens(this.mContext, R.dimen.tbds21)).pf(0).pg(l.getDimens(this.mContext, R.dimen.tbds4)).bv(this.iRQ);
    }
}
