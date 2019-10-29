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
    private g fRP;
    private b fRX;
    private Context mContext;
    private ViewGroup mParent;
    private com.baidu.tbadk.p.a.a zg;
    private b.a fRY = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.zg == null) {
                        f.this.zg = new com.baidu.tbadk.p.a.a("anim_switch_trans_frs");
                    }
                    f.this.zg.awU();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.zg != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.zg.awV();
                }
            } else if (i == 0) {
                f.this.bqc();
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
        this.fRP = new g(context);
        this.fRX = c.a(this.fRP, intent);
        this.fRX.a(this.fRY);
    }

    public void bqa() {
        if (this.mParent != null) {
            bqc();
            this.mParent.addView(this.fRP.mRootView);
            bqb();
            this.fRX.bpQ();
        }
    }

    public void bjl() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mHideRunnable);
        if (this.fRX.getState() == 1) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.fRX.bpR();
    }

    public static boolean ar(Intent intent) {
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

    private void bqb() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqc() {
        ViewParent parent = this.fRP.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fRP.mRootView);
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mHideRunnable);
    }
}
