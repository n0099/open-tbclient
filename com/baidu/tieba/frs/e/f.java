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
    private com.baidu.tbadk.o.a.a Qo;
    private g fua;
    private b fuh;
    private Context mContext;
    private ViewGroup mParent;
    private b.a fui = new b.a() { // from class: com.baidu.tieba.frs.e.f.1
        @Override // com.baidu.tieba.frs.e.b.a
        public void onStateChanged(int i) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    if (f.this.Qo == null) {
                        f.this.Qo = new com.baidu.tbadk.o.a.a("anim_switch_trans_frs");
                    }
                    f.this.Qo.app();
                }
            } else if (i == 2) {
                f.this.biA();
                if (f.this.Qo != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                    f.this.Qo.apq();
                }
            } else if (i == 0) {
                f.this.biC();
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
        this.fua = new g(context);
        this.fuh = c.a(this.fua, intent);
        this.fuh.a(this.fui);
    }

    public void biz() {
        if (this.mParent != null) {
            biC();
            this.mParent.addView(this.fua.mRootView);
            biB();
            this.fuh.biq();
        }
    }

    public void bbP() {
        if (this.mParent != null) {
            hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideRunnable);
        if (this.fuh.getState() == 1) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.mHideRunnable, 10L);
            return;
        }
        biA();
        this.fuh.bir();
    }

    public static boolean ae(Intent intent) {
        return (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biA() {
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(0);
        }
        if (this.mParent != null && this.mParent.findViewById(16908290) != null) {
            this.mParent.findViewById(16908290).setVisibility(0);
        }
    }

    private void biB() {
        View findViewById;
        if (this.mParent != null && (this.mParent.getChildAt(0) instanceof SwipeBackLayout)) {
            this.mParent.getChildAt(0).setVisibility(8);
        }
        if (this.mParent != null && (findViewById = this.mParent.findViewById(16908290)) != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        ViewParent parent = this.fua.mRootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.fua.mRootView);
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideRunnable);
    }
}
