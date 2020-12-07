package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes22.dex */
public class f {
    private com.baidu.tbadk.n.a.a Yb;
    private g jvd;
    private b jvm;
    private Context mContext;
    private ViewGroup mParent;
    private b.a jvn = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Yb == null) {
                        f.this.Yb = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Yb.bFv();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Yb != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Yb.bFw();
                }
            } else if (i == 0) {
                f.this.cJZ();
            }
        }
    };
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.e.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    public f(Context context, ViewGroup viewGroup, Intent intent) {
        this.mContext = context;
        this.mParent = viewGroup;
        this.jvd = new g(context);
        this.jvm = c.a(this.jvd, intent);
        this.jvm.a(this.jvn);
    }

    public void cJX() {
        if (this.mParent != null) {
            cJZ();
            this.mParent.addView(this.jvd.mRootView);
            cJY();
            this.jvm.cJN();
        }
    }

    public void cBs() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
        if (this.jvm.getState() == 1) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.jvm.cJO();
    }

    public static boolean T(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showContentView() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void cJY() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJZ() {
        ViewParent parent = this.jvd.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jvd.mRootView);
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
    }
}
