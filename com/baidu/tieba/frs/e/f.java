package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes16.dex */
public class f {
    private com.baidu.tbadk.n.a.a Wr;
    private g ish;
    private b isq;
    private Context mContext;
    private ViewGroup mParent;
    private b.a isr = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Wr == null) {
                        f.this.Wr = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Wr.buu();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Wr != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Wr.buv();
                }
            } else if (i == 0) {
                f.this.csM();
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
        this.ish = new g(context);
        this.isq = c.a(this.ish, intent);
        this.isq.a(this.isr);
    }

    public void csK() {
        if (this.mParent != null) {
            csM();
            this.mParent.addView(this.ish.mRootView);
            csL();
            this.isq.csA();
        }
    }

    public void clg() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mHideRunnable);
        if (this.isq.getState() == 1) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.isq.csB();
    }

    public static boolean W(Intent intent) {
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

    private void csL() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csM() {
        ViewParent parent = this.ish.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.ish.mRootView);
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mHideRunnable);
    }
}
