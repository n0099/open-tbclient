package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes9.dex */
public class f {
    private com.baidu.tbadk.n.a.a VX;
    private g hXZ;
    private b hYi;
    private Context mContext;
    private ViewGroup mParent;
    private b.a hYj = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.VX == null) {
                        f.this.VX = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.VX.bhW();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.VX != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.VX.bhX();
                }
            } else if (i == 0) {
                f.this.ceJ();
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
        this.hXZ = new g(context);
        this.hYi = c.a(this.hXZ, intent);
        this.hYi.a(this.hYj);
    }

    public void ceH() {
        if (this.mParent != null) {
            ceJ();
            this.mParent.addView(this.hXZ.mRootView);
            ceI();
            this.hYi.cex();
        }
    }

    public void bXp() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        if (this.hYi.getState() == 1) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.hYi.cey();
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

    private void ceI() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceJ() {
        ViewParent parent = this.hXZ.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.hXZ.mRootView);
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
    }
}
