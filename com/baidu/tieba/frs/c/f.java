package com.baidu.tieba.frs.c;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.c.b;
/* loaded from: classes2.dex */
public class f {
    private com.baidu.tbadk.n.a.a Zn;
    private b jKE;
    private g jKv;
    private Context mContext;
    private ViewGroup mParent;
    private b.a jKF = new b.a() { // from class: com.baidu.tieba.frs.c.f.1
        @Override // com.baidu.tieba.frs.c.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Zn == null) {
                        f.this.Zn = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Zn.bEv();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Zn != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Zn.bEw();
                }
            } else if (i == 0) {
                f.this.cKK();
            }
        }
    };
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.c.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    public f(Context context, ViewGroup viewGroup, Intent intent) {
        this.mContext = context;
        this.mParent = viewGroup;
        this.jKv = new g(context);
        this.jKE = c.a(this.jKv, intent);
        this.jKE.a(this.jKF);
    }

    public void cKI() {
        if (this.mParent != null) {
            cKK();
            this.mParent.addView(this.jKv.mRootView);
            cKJ();
            this.jKE.cKy();
        }
    }

    public void cBT() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHideRunnable);
        if (this.jKE.getState() == 1) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.jKE.cKz();
    }

    public static boolean U(Intent intent) {
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

    private void cKJ() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKK() {
        ViewParent parent = this.jKv.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jKv.mRootView);
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHideRunnable);
    }
}
