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
    private ViewGroup bts;
    private View.OnClickListener fuF;
    private InterfaceC0668a hJE;
    private View hJF;
    private TextView hJG;
    private TextView hJH;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0668a {
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.fuF = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.hJG) {
                    if (a.this.hJE != null) {
                        a.this.hJE.onItemClick(1);
                    }
                } else if (view == a.this.hJH && a.this.hJE != null) {
                    a.this.hJE.onItemClick(2);
                }
                a.this.PE();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PE();
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

    private View ckg() {
        ckh();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bts = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.hJF);
        this.bts.setOnClickListener(this.mOnClickListener);
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_btn_a).oB(l.getDimens(this.mContext, R.dimen.tbds10)).oC(R.color.cp_shadow_a_alpha16).oD(l.getDimens(this.mContext, R.dimen.tbds21)).oE(0).oF(l.getDimens(this.mContext, R.dimen.tbds5)).bb(this.hJF);
        return frameLayout;
    }

    private void ckh() {
        this.hJF = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.hJG = (TextView) this.hJF.findViewById(R.id.sort_type_level_text);
        this.mLine = this.hJF.findViewById(R.id.sort_select_line);
        this.hJH = (TextView) this.hJF.findViewById(R.id.sort_type_update_text);
        this.hJG.setOnClickListener(this.fuF);
        this.hJH.setOnClickListener(this.fuF);
    }

    public void setData(List<h> list, int i) {
        if (list != null) {
            View ckg = ckg();
            for (h hVar : list) {
                if (hVar.sortType == 1) {
                    this.hJG.setText(hVar.hBB);
                } else {
                    this.hJH.setText(hVar.hBB);
                }
                if (i == 1) {
                    ap.setViewTextColor(this.hJG, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hJH, R.color.cp_cont_j);
                } else {
                    ap.setViewTextColor(this.hJH, R.color.cp_link_tip_a);
                    ap.setViewTextColor(this.hJG, R.color.cp_cont_j);
                }
            }
            setContentView(ckg);
        }
    }

    public void a(InterfaceC0668a interfaceC0668a) {
        this.hJE = interfaceC0668a;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    PG();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                PG();
            }
        }
    }

    public void wL(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        PE();
    }

    public void PE() {
        PH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        super.dismiss();
    }

    private void PG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.hJF.startAnimation(translateAnimation);
        this.bts.startAnimation(alphaAnimation);
    }

    private void PH() {
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
                    a.this.PF();
                }
            });
            this.hJF.startAnimation(translateAnimation);
            this.bts.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hJG, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.hJH, R.color.cp_cont_j);
        com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_btn_a).oB(l.getDimens(this.mContext, R.dimen.tbds10)).oC(R.color.cp_shadow_a_alpha16).oD(l.getDimens(this.mContext, R.dimen.tbds21)).oE(0).oF(l.getDimens(this.mContext, R.dimen.tbds5)).bb(this.hJF);
    }
}
