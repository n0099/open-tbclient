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
    private com.baidu.tbadk.n.a.a XZ;
    private g jHA;
    private b jHJ;
    private Context mContext;
    private ViewGroup mParent;
    private b.a jHK = new b.a() { // from class: com.baidu.tieba.frs.c.f.1
        @Override // com.baidu.tieba.frs.c.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.XZ == null) {
                        f.this.XZ = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.XZ.bHQ();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.XZ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.XZ.bHR();
                }
            } else if (i == 0) {
                f.this.cNb();
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
        this.jHA = new g(context);
        this.jHJ = c.a(this.jHA, intent);
        this.jHJ.a(this.jHK);
    }

    public void cMZ() {
        if (this.mParent != null) {
            cNb();
            this.mParent.addView(this.jHA.mRootView);
            cNa();
            this.jHJ.cMP();
        }
    }

    public void cEm() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mHideRunnable);
        if (this.jHJ.getState() == 1) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.jHJ.cMQ();
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

    private void cNa() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNb() {
        ViewParent parent = this.jHA.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jHA.mRootView);
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mHideRunnable);
    }
}
