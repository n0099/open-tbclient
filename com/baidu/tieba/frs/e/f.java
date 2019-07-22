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
    private g fPR;
    private b fPZ;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fQa = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Om == null) {
                        f.this.Om = new com.baidu.tbadk.p.a.a("anim_switch_trans_frs");
                    }
                    f.this.Om.avB();
                }
            } else if (i == 2) {
                f.this.brX();
                if (f.this.Om != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Om.avC();
                }
            } else if (i == 0) {
                f.this.brZ();
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
        this.fPR = new g(context);
        this.fPZ = c.a(this.fPR, intent);
        this.fPZ.a(this.fQa);
    }

    public void brW() {
        if (this.mParent != null) {
            brZ();
            this.mParent.addView(this.fPR.mRootView);
            brY();
            this.fPZ.brM();
        }
    }

    public void bln() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
        if (this.fPZ.getState() == 1) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        brX();
        this.fPZ.brN();
    }

    public static boolean ah(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brX() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void brY() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brZ() {
        ViewParent parent = this.fPR.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fPR.mRootView);
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
    }
}
