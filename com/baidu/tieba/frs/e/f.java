package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes4.dex */
public class f {
    private com.baidu.tbadk.p.a.a NV;
    private g fKT;
    private b fLb;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fLc = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.NV == null) {
                        f.this.NV = new com.baidu.tbadk.p.a.a("anim_switch_trans_frs");
                    }
                    f.this.NV.aus();
                }
            } else if (i == 2) {
                f.this.bpW();
                if (f.this.NV != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.NV.aut();
                }
            } else if (i == 0) {
                f.this.bpY();
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
        this.fKT = new g(context);
        this.fLb = c.a(this.fKT, intent);
        this.fLb.a(this.fLc);
    }

    public void bpV() {
        if (this.mParent != null) {
            bpY();
            this.mParent.addView(this.fKT.mRootView);
            bpX();
            this.fLb.bpL();
        }
    }

    public void bjl() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
        if (this.fLb.getState() == 1) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        bpW();
        this.fLb.bpM();
    }

    public static boolean ah(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpW() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void bpX() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpY() {
        ViewParent parent = this.fKT.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fKT.mRootView);
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
    }
}
