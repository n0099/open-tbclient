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
    private com.baidu.tbadk.n.a.a BH;
    private g gKK;
    private b gKT;
    private Context mContext;
    private ViewGroup mParent;
    private b.a gKU = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.BH == null) {
                        f.this.BH = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.BH.aRt();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.BH != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.BH.aRu();
                }
            } else if (i == 0) {
                f.this.bKc();
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
        this.gKK = new g(context);
        this.gKT = c.a(this.gKK, intent);
        this.gKT.a(this.gKU);
    }

    public void bKa() {
        if (this.mParent != null) {
            bKc();
            this.mParent.addView(this.gKK.mRootView);
            bKb();
            this.gKT.bJQ();
        }
    }

    public void bDk() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mHideRunnable);
        if (this.gKT.getState() == 1) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.gKT.bJR();
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

    private void bKb() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        ViewParent parent = this.gKK.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.gKK.mRootView);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mHideRunnable);
    }
}
