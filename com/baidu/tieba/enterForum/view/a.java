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
    private ViewGroup bMN;
    private View.OnClickListener gkd;
    private InterfaceC0708a iQg;
    private View iQh;
    private TextView iQi;
    private TextView iQj;
    private int iQk;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0708a {
        void dV(int i);
    }

    public a(Context context) {
        super(context);
        this.gkd = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.iQi) {
                    if (a.this.iQg != null) {
                        a.this.iQg.dV(1);
                    }
                } else if (view == a.this.iQj && a.this.iQg != null) {
                    a.this.iQg.dV(2);
                }
                a.this.UU();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.UU();
            }
        };
        this.mContext = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View cxy() {
        cxz();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bMN = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.iQh);
        this.bMN.setOnClickListener(this.mOnClickListener);
        com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pb(l.getDimens(this.mContext, R.dimen.tbds10)).pc(R.color.CAM_X0804).pd(l.getDimens(this.mContext, R.dimen.tbds21)).pe(0).pf(l.getDimens(this.mContext, R.dimen.tbds4)).bv(this.iQh);
        return frameLayout;
    }

    private void cxz() {
        this.iQh = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.iQi = (TextView) this.iQh.findViewById(R.id.sort_type_level_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iQi).oa(R.string.F_X01);
        this.iQj = (TextView) this.iQh.findViewById(R.id.sort_type_update_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.iQj).oa(R.string.F_X01);
        this.iQi.setOnClickListener(this.gkd);
        this.iQj.setOnClickListener(this.gkd);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            this.iQk = i;
            View cxy = cxy();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.iQi.setText(hVar.iIh);
                } else {
                    this.iQj.setText(hVar.iIh);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.iQi, R.color.CAM_X0105);
                    ap.setViewTextColor(this.iQj, R.color.CAM_X0108);
                } else {
                    ap.setViewTextColor(this.iQj, R.color.CAM_X0105);
                    ap.setViewTextColor(this.iQi, R.color.CAM_X0108);
                }
            }
            setContentView(cxy);
        }
    }

    public void a(InterfaceC0708a interfaceC0708a) {
        this.iQg = interfaceC0708a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aCu();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                aCu();
            }
        }
    }

    public void xR(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        UU();
    }

    public void UU() {
        UX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UV() {
        super.dismiss();
    }

    private void aCu() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iQh.startAnimation(translateAnimation);
        this.bMN.startAnimation(alphaAnimation);
    }

    private void UX() {
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
                    a.this.UV();
                }
            });
            this.iQh.startAnimation(translateAnimation);
            this.bMN.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        if (this.iQk == 1) {
            ap.setViewTextColor(this.iQi, R.color.CAM_X0105);
            ap.setViewTextColor(this.iQj, R.color.CAM_X0108);
        } else {
            ap.setViewTextColor(this.iQj, R.color.CAM_X0105);
            ap.setViewTextColor(this.iQi, R.color.CAM_X0108);
        }
        com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0901).pb(l.getDimens(this.mContext, R.dimen.tbds10)).pc(R.color.CAM_X0804).pd(l.getDimens(this.mContext, R.dimen.tbds21)).pe(0).pf(l.getDimens(this.mContext, R.dimen.tbds4)).bv(this.iQh);
    }
}
