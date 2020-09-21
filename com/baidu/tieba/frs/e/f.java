package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes21.dex */
public class f {
    private com.baidu.tbadk.n.a.a WJ;
    private g izD;
    private b izM;
    private Context mContext;
    private ViewGroup mParent;
    private b.a izN = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.WJ == null) {
                        f.this.WJ = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.WJ.bvz();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.WJ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.WJ.bvA();
                }
            } else if (i == 0) {
                f.this.cwc();
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
        this.izD = new g(context);
        this.izM = c.a(this.izD, intent);
        this.izM.a(this.izN);
    }

    public void cwa() {
        if (this.mParent != null) {
            cwc();
            this.mParent.addView(this.izD.mRootView);
            cwb();
            this.izM.cvQ();
        }
    }

    public void cou() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mHideRunnable);
        if (this.izM.getState() == 1) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.izM.cvR();
    }

    public static boolean V(Intent intent) {
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

    private void cwb() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwc() {
        ViewParent parent = this.izD.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.izD.mRootView);
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mHideRunnable);
    }
}
