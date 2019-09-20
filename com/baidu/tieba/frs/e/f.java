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
    private com.baidu.tbadk.p.a.a Ol;
    private b fSE;
    private g fSw;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fSF = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Ol == null) {
                        f.this.Ol = new com.baidu.tbadk.p.a.a("anim_switch_trans_frs");
                    }
                    f.this.Ol.avP();
                }
            } else if (i == 2) {
                f.this.bsX();
                if (f.this.Ol != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Ol.avQ();
                }
            } else if (i == 0) {
                f.this.bsZ();
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
        this.fSw = new g(context);
        this.fSE = c.a(this.fSw, intent);
        this.fSE.a(this.fSF);
    }

    public void bsW() {
        if (this.mParent != null) {
            bsZ();
            this.mParent.addView(this.fSw.mRootView);
            bsY();
            this.fSE.bsM();
        }
    }

    public void bmf() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
        if (this.fSE.getState() == 1) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        bsX();
        this.fSE.bsN();
    }

    public static boolean aj(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsX() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void bsY() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsZ() {
        ViewParent parent = this.fSw.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fSw.mRootView);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
    }
}
