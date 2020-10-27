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
    private g jaS;
    private b jbb;
    private Context mContext;
    private ViewGroup mParent;
    private b.a jbc = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Xa == null) {
                        f.this.Xa = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Xa.bAc();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Xa != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Xa.bAd();
                }
            } else if (i == 0) {
                f.this.cCG();
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
        this.jaS = new g(context);
        this.jbb = c.a(this.jaS, intent);
        this.jbb.a(this.jbc);
    }

    public void cCE() {
        if (this.mParent != null) {
            cCG();
            this.mParent.addView(this.jaS.mRootView);
            cCF();
            this.jbb.cCu();
        }
    }

    public void cuZ() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
        if (this.jbb.getState() == 1) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.jbb.cCv();
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

    private void cCF() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCG() {
        ViewParent parent = this.jaS.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jaS.mRootView);
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
    }
}
