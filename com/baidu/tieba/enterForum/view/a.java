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
    private ViewGroup bJb;
    private View.OnClickListener gcS;
    private InterfaceC0733a iCF;
    private View iCG;
    private TextView iCH;
    private TextView iCI;
    private int iCJ;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0733a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.gcS = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.iCH) {
                    if (a.this.iCF != null) {
                        a.this.iCF.onItemClick(1);
                    }
                } else if (view == a.this.iCI && a.this.iCF != null) {
                    a.this.iCF.onItemClick(2);
                }
                a.this.Wd();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Wd();
            }
        };
        this.mContext = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View cxd() {
        cxe();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bJb = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.iCG);
        this.bJb.setOnClickListener(this.mOnClickListener);
        com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qs(l.getDimens(this.mContext, R.dimen.tbds10)).qt(R.color.CAM_X0804).qu(l.getDimens(this.mContext, R.dimen.tbds21)).qv(0).qw(l.getDimens(this.mContext, R.dimen.tbds4)).bq(this.iCG);
        return frameLayout;
    }

    private void cxe() {
        this.iCG = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.iCH = (TextView) this.iCG.findViewById(R.id.sort_type_level_text);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.iCH).pu(R.string.F_X01);
        this.iCI = (TextView) this.iCG.findViewById(R.id.sort_type_update_text);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.iCI).pu(R.string.F_X01);
        this.iCH.setOnClickListener(this.gcS);
        this.iCI.setOnClickListener(this.gcS);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            this.iCJ = i;
            View cxd = cxd();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.iCH.setText(hVar.iuD);
                } else {
                    this.iCI.setText(hVar.iuD);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.iCH, R.color.CAM_X0105);
                    ap.setViewTextColor(this.iCI, R.color.CAM_X0108);
                } else {
                    ap.setViewTextColor(this.iCI, R.color.CAM_X0105);
                    ap.setViewTextColor(this.iCH, R.color.CAM_X0108);
                }
            }
            setContentView(cxd);
        }
    }

    public void a(InterfaceC0733a interfaceC0733a) {
        this.iCF = interfaceC0733a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aEx();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                aEx();
            }
        }
    }

    public void za(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Wd();
    }

    public void Wd() {
        Wg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        super.dismiss();
    }

    private void aEx() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.iCG.startAnimation(translateAnimation);
        this.bJb.startAnimation(alphaAnimation);
    }

    private void Wg() {
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
                    a.this.We();
                }
            });
            this.iCG.startAnimation(translateAnimation);
            this.bJb.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        if (this.iCJ == 1) {
            ap.setViewTextColor(this.iCH, R.color.CAM_X0105);
            ap.setViewTextColor(this.iCI, R.color.CAM_X0108);
        } else {
            ap.setViewTextColor(this.iCI, R.color.CAM_X0105);
            ap.setViewTextColor(this.iCH, R.color.CAM_X0108);
        }
        com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qs(l.getDimens(this.mContext, R.dimen.tbds10)).qt(R.color.CAM_X0804).qu(l.getDimens(this.mContext, R.dimen.tbds21)).qv(0).qw(l.getDimens(this.mContext, R.dimen.tbds4)).bq(this.iCG);
    }
}
