package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes6.dex */
public class f {
    private com.baidu.tbadk.n.a.a Bk;
    private g gFi;
    private b gFr;
    private Context mContext;
    private ViewGroup mParent;
    private b.a gFs = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Bk == null) {
                        f.this.Bk = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Bk.aOH();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Bk != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Bk.aOI();
                }
            } else if (i == 0) {
                f.this.bHv();
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
        this.gFi = new g(context);
        this.gFr = c.a(this.gFi, intent);
        this.gFr.a(this.gFs);
    }

    public void bHt() {
        if (this.mParent != null) {
            bHv();
            this.mParent.addView(this.gFi.mRootView);
            bHu();
            this.gFr.bHj();
        }
    }

    public void bAD() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.mHideRunnable);
        if (this.gFr.getState() == 1) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.gFr.bHk();
    }

    public static boolean ak(Intent intent) {
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

    private void bHu() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHv() {
        ViewParent parent = this.gFi.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.gFi.mRootView);
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.mHideRunnable);
    }
}
