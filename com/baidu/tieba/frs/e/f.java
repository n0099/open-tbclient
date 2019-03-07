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
    private com.baidu.tbadk.o.a.a Qn;
    private g fup;
    private b fuw;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fux = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Qn == null) {
                        f.this.Qn = new com.baidu.tbadk.o.a.a("anim_switch_trans_frs");
                    }
                    f.this.Qn.apt();
                }
            } else if (i == 2) {
                f.this.biC();
                if (f.this.Qn != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Qn.apu();
                }
            } else if (i == 0) {
                f.this.biE();
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
        this.fup = new g(context);
        this.fuw = c.a(this.fup, intent);
        this.fuw.a(this.fux);
    }

    public void biB() {
        if (this.mParent != null) {
            biE();
            this.mParent.addView(this.fup.mRootView);
            biD();
            this.fuw.bis();
        }
    }

    public void bbR() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideRunnable);
        if (this.fuw.getState() == 1) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        biC();
        this.fuw.bit();
    }

    public static boolean ae(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void biD() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biE() {
        ViewParent parent = this.fup.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fup.mRootView);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideRunnable);
    }
}
