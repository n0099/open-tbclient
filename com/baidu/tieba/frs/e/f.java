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
    private com.baidu.tbadk.p.a.a NW;
    private g fKR;
    private b fKZ;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fLa = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.NW == null) {
                        f.this.NW = new com.baidu.tbadk.p.a.a("anim_switch_trans_frs");
                    }
                    f.this.NW.aus();
                }
            } else if (i == 2) {
                f.this.bpU();
                if (f.this.NW != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.NW.aut();
                }
            } else if (i == 0) {
                f.this.bpW();
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
        this.fKR = new g(context);
        this.fKZ = c.a(this.fKR, intent);
        this.fKZ.a(this.fLa);
    }

    public void bpT() {
        if (this.mParent != null) {
            bpW();
            this.mParent.addView(this.fKR.mRootView);
            bpV();
            this.fKZ.bpJ();
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
        if (this.fKZ.getState() == 1) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        bpU();
        this.fKZ.bpK();
    }

    public static boolean ah(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpU() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void bpV() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpW() {
        ViewParent parent = this.fKR.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fKR.mRootView);
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
    }
}
