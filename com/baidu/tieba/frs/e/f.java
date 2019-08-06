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
    private com.baidu.tbadk.p.a.a Om;
    private g fQF;
    private b fQN;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fQO = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Om == null) {
                        f.this.Om = new com.baidu.tbadk.p.a.a("anim_switch_trans_frs");
                    }
                    f.this.Om.avD();
                }
            } else if (i == 2) {
                f.this.bsk();
                if (f.this.Om != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Om.avE();
                }
            } else if (i == 0) {
                f.this.bsm();
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
        this.fQF = new g(context);
        this.fQN = c.a(this.fQF, intent);
        this.fQN.a(this.fQO);
    }

    public void bsj() {
        if (this.mParent != null) {
            bsm();
            this.mParent.addView(this.fQF.mRootView);
            bsl();
            this.fQN.brZ();
        }
    }

    public void blu() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
        if (this.fQN.getState() == 1) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        bsk();
        this.fQN.bsa();
    }

    public static boolean aj(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void bsl() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        ViewParent parent = this.fQF.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fQF.mRootView);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
    }
}
