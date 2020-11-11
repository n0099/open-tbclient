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
    private com.baidu.tbadk.n.a.a Xa;
    private g jgP;
    private b jgY;
    private Context mContext;
    private ViewGroup mParent;
    private b.a jgZ = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Xa == null) {
                        f.this.Xa = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Xa.bCB();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Xa != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Xa.bCC();
                }
            } else if (i == 0) {
                f.this.cFh();
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
        this.jgP = new g(context);
        this.jgY = c.a(this.jgP, intent);
        this.jgY.a(this.jgZ);
    }

    public void cFf() {
        if (this.mParent != null) {
            cFh();
            this.mParent.addView(this.jgP.mRootView);
            cFg();
            this.jgY.cEV();
        }
    }

    public void cxA() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
        if (this.jgY.getState() == 1) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.jgY.cEW();
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

    private void cFg() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFh() {
        ViewParent parent = this.jgP.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jgP.mRootView);
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
    }
}
