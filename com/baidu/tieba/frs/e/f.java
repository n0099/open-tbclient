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
    private com.baidu.tbadk.n.a.a VQ;
    private g ieb;
    private b iek;
    private Context mContext;
    private ViewGroup mParent;
    private b.a iel = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.VQ == null) {
                        f.this.VQ = new com.baidu.tbadk.n.a.a("anim_switch_trans_frs");
                    }
                    f.this.VQ.blH();
                }
            } else if (i == 2) {
                f.this.showContentView();
                if (f.this.VQ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.VQ.blI();
                }
            } else if (i == 0) {
                f.this.cii();
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
        this.ieb = new g(context);
        this.iek = c.a(this.ieb, intent);
        this.iek.a(this.iel);
    }

    public void cig() {
        if (this.mParent != null) {
            cii();
            this.mParent.addView(this.ieb.mRootView);
            cih();
            this.iek.chW();
        }
    }

    public void caK() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        if (this.iek.getState() == 1) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        showContentView();
        this.iek.chX();
    }

    public static boolean U(Intent intent) {
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

    private void cih() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cii() {
        ViewParent parent = this.ieb.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.ieb.mRootView);
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
    }
}
