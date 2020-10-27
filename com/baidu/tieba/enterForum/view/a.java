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
    private ViewGroup bzt;
    private View.OnClickListener fPj;
    private InterfaceC0702a ikZ;
    private View ila;
    private TextView ilb;
    private TextView ilc;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0702a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.fPj = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.ilb) {
                    if (a.this.ikZ != null) {
                        a.this.ikZ.onItemClick(1);
                    }
                } else if (view == a.this.ilc && a.this.ikZ != null) {
                    a.this.ikZ.onItemClick(2);
                }
                a.this.RE();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RE();
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

    private View cqJ() {
        cqK();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bzt = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.ila);
        this.bzt.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_btn_a).pk(l.getDimens(this.mContext, R.dimen.tbds10)).pl(R.color.cp_shadow_a_alpha16).pm(l.getDimens(this.mContext, R.dimen.tbds21)).po(0).pp(l.getDimens(this.mContext, R.dimen.tbds5)).bg(this.ila);
        return frameLayout;
    }

    private void cqK() {
        this.ila = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.ilb = (TextView) this.ila.findViewById(R.id.sort_type_level_text);
        this.mLine = this.ila.findViewById(R.id.sort_select_line);
        this.ilc = (TextView) this.ila.findViewById(R.id.sort_type_update_text);
        this.ilb.setOnClickListener(this.fPj);
        this.ilc.setOnClickListener(this.fPj);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View cqJ = cqJ();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.ilb.setText(hVar.icT);
                } else {
                    this.ilc.setText(hVar.icT);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.ilb, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.ilc, R.color.cp_cont_j);
                } else {
                    ap.setViewTextColor(this.ilc, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.ilb, R.color.cp_cont_j);
                }
            }
            setContentView(cqJ);
        }
    }

    public void a(InterfaceC0702a interfaceC0702a) {
        this.ikZ = interfaceC0702a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    RG();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                RG();
            }
        }
    }

    public void xK(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        RE();
    }

    public void RE() {
        RH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RF() {
        super.dismiss();
    }

    private void RG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.ila.startAnimation(translateAnimation);
        this.bzt.startAnimation(alphaAnimation);
    }

    private void RH() {
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
                    a.this.RF();
                }
            });
            this.ila.startAnimation(translateAnimation);
            this.bzt.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.ilb, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.ilc, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_btn_a).pk(l.getDimens(this.mContext, R.dimen.tbds10)).pl(R.color.cp_shadow_a_alpha16).pm(l.getDimens(this.mContext, R.dimen.tbds21)).po(0).pp(l.getDimens(this.mContext, R.dimen.tbds5)).bg(this.ila);
    }
}
