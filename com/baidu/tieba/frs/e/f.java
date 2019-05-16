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
    private g fKQ;
    private b fKY;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fKZ = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
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
                f.this.bpR();
                if (f.this.NW != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.NW.aut();
                }
            } else if (i == 0) {
                f.this.bpT();
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
        this.fKQ = new g(context);
        this.fKY = c.a(this.fKQ, intent);
        this.fKY.a(this.fKZ);
    }

    public void bpQ() {
        if (this.mParent != null) {
            bpT();
            this.mParent.addView(this.fKQ.mRootView);
            bpS();
            this.fKY.bpG();
        }
    }

    public void bji() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
        if (this.fKY.getState() == 1) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        bpR();
        this.fKY.bpH();
    }

    public static boolean ah(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpR() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void bpS() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpT() {
        ViewParent parent = this.fKQ.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fKQ.mRootView);
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideRunnable);
    }
}
