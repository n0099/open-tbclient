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
/* loaded from: classes21.dex */
public class a extends PopupWindow {
    private ViewGroup bDT;
    private View.OnClickListener fUG;
    private InterfaceC0719a irL;
    private View irM;
    private TextView irN;
    private TextView irO;
    private int irP;
    private Context mContext;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0719a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.fUG = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.irN) {
                    if (a.this.irL != null) {
                        a.this.irL.onItemClick(1);
                    }
                } else if (view == a.this.irO && a.this.irL != null) {
                    a.this.irL.onItemClick(2);
                }
                a.this.TD();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.TD();
            }
        };
        this.mContext = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View csN() {
        csO();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bDT = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.irM);
        this.bDT.setOnClickListener(this.mOnClickListener);
        com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0901).pS(l.getDimens(this.mContext, R.dimen.tbds10)).pT(R.color.CAM_X0804).pU(l.getDimens(this.mContext, R.dimen.tbds21)).pV(0).pW(l.getDimens(this.mContext, R.dimen.tbds4)).bn(this.irM);
        return frameLayout;
    }

    private void csO() {
        this.irM = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.irN = (TextView) this.irM.findViewById(R.id.sort_type_level_text);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.irN).oV(R.string.F_X01);
        this.irO = (TextView) this.irM.findViewById(R.id.sort_type_update_text);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.irO).oV(R.string.F_X01);
        this.irN.setOnClickListener(this.fUG);
        this.irO.setOnClickListener(this.fUG);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            this.irP = i;
            View csN = csN();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.irN.setText(hVar.ijI);
                } else {
                    this.irO.setText(hVar.ijI);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.irN, R.color.CAM_X0105);
                    ap.setViewTextColor(this.irO, R.color.CAM_X0108);
                } else {
                    ap.setViewTextColor(this.irO, R.color.CAM_X0105);
                    ap.setViewTextColor(this.irN, R.color.CAM_X0108);
                }
            }
            setContentView(csN);
        }
    }

    public void a(InterfaceC0719a interfaceC0719a) {
        this.irL = interfaceC0719a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    aBo();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                aBo();
            }
        }
    }

    public void yv(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        TD();
    }

    public void TD() {
        TG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TE() {
        super.dismiss();
    }

    private void aBo() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.irM.startAnimation(translateAnimation);
        this.bDT.startAnimation(alphaAnimation);
    }

    private void TG() {
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
                    a.this.TE();
                }
            });
            this.irM.startAnimation(translateAnimation);
            this.bDT.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        if (this.irP == 1) {
            ap.setViewTextColor(this.irN, R.color.CAM_X0105);
            ap.setViewTextColor(this.irO, R.color.CAM_X0108);
        } else {
            ap.setViewTextColor(this.irO, R.color.CAM_X0105);
            ap.setViewTextColor(this.irN, R.color.CAM_X0108);
        }
        com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0901).pS(l.getDimens(this.mContext, R.dimen.tbds10)).pT(R.color.CAM_X0804).pU(l.getDimens(this.mContext, R.dimen.tbds21)).pV(0).pW(l.getDimens(this.mContext, R.dimen.tbds4)).bn(this.irM);
    }
}
