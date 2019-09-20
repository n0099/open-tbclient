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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {
    private View.OnClickListener dbz;
    private ViewGroup fdr;
    private InterfaceC0313a fds;
    private View fdt;
    private TextView fdu;
    private TextView fdv;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* renamed from: com.baidu.tieba.enterForum.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0313a {
        void mG(int i);
    }

    public a(Context context) {
        super(context);
        this.dbz = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == a.this.fdu) {
                    if (a.this.fds != null) {
                        a.this.fds.mG(1);
                    }
                } else if (view == a.this.fdv && a.this.fds != null) {
                    a.this.fds.mG(2);
                }
                a.this.bhx();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.bhx();
            }
        };
        this.mContext = context;
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View bhw() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fdr = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fdt);
        this.fdr.setOnClickListener(this.mOnClickListener);
        am.l(this.mLine, R.color.cp_bg_line_c);
        am.k(this.fdt, R.drawable.enter_forum_sort_select_bg);
        return frameLayout;
    }

    private void createContentView() {
        this.fdt = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.fdu = (TextView) this.fdt.findViewById(R.id.sort_type_level_text);
        this.mLine = this.fdt.findViewById(R.id.sort_select_line);
        this.fdv = (TextView) this.fdt.findViewById(R.id.sort_type_update_text);
        this.fdu.setOnClickListener(this.dbz);
        this.fdv.setOnClickListener(this.dbz);
    }

    public void setData(List<k> list, int i) {
        if (list != null) {
            View bhw = bhw();
            for (k kVar : list) {
                if (kVar.sortType == 1) {
                    this.fdu.setText(kVar.eYn);
                } else {
                    this.fdv.setText(kVar.eYn);
                }
                if (i == 1) {
                    am.j(this.fdu, R.color.cp_link_tip_a);
                    am.j(this.fdv, R.color.cp_cont_j);
                } else {
                    am.j(this.fdv, R.color.cp_link_tip_a);
                    am.j(this.fdu, R.color.cp_cont_j);
                }
            }
            setContentView(bhw);
        }
    }

    public void a(InterfaceC0313a interfaceC0313a) {
        this.fds = interfaceC0313a;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                if (g.showPopupWindowAsDropDown(this, view)) {
                    bhy();
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr[0] - this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
                bhy();
            }
        }
    }

    public void qM(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bhx();
    }

    public void bhx() {
        bhz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        super.dismiss();
    }

    private void bhy() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fdt.startAnimation(translateAnimation);
        this.fdr.startAnimation(alphaAnimation);
    }

    private void bhz() {
        if (!i.isFastDoubleClick()) {
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
                    a.this.MW();
                }
            });
            this.fdt.startAnimation(translateAnimation);
            this.fdr.startAnimation(alphaAnimation);
        }
    }

    public void onChangeSkinType() {
        am.l(this.mLine, R.color.cp_bg_line_c);
        am.k(this.fdt, R.drawable.enter_forum_sort_select_bg);
        am.j(this.fdu, R.color.cp_link_tip_a);
        am.j(this.fdv, R.color.cp_cont_j);
    }
}
