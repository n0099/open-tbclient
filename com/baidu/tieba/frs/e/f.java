package com.baidu.tieba.frs.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.frs.e.b;
/* loaded from: classes7.dex */
public class f {
    private com.baidu.tbadk.n.a.a Bp;
    private b gIG;
    private g gIx;
    private Context mContext;
    private ViewGroup mParent;
    private b.a gIH = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Bp == null) {
                        f.this.Bp = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.Bp.aPa();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.Bp != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Bp.aPb();
                }
            } else if (i == 0) {
                f.this.bIx();
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
        this.gIx = new g(context);
        this.gIG = c.a(this.gIx, intent);
        this.gIG.a(this.gIH);
    }

    public void bIv() {
        if (this.mParent != null) {
            bIx();
            this.mParent.addView(this.gIx.mRootView);
            bIw();
            this.gIG.bIl();
        }
    }

    public void bBF() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mHideRunnable);
        if (this.gIG.getState() == 1) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.gIG.bIm();
    }

    public static boolean ak(Intent intent) {
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

    private void bIw() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIx() {
        ViewParent parent = this.gIx.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.gIx.mRootView);
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mHideRunnable);
    }
}
