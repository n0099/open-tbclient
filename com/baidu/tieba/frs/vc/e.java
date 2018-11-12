package com.baidu.tieba.frs.vc;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes6.dex */
public class e {
    private NoPressedRelativeLayout dWf;
    private FrsFragment dWx;
    private TextView dWy;
    private final Runnable mHideRunnable;
    private int dCW = -1;
    private int bJl = -1;
    private int dWB = -1;
    private final Handler dWw = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aFr();
                return true;
            }
            return false;
        }
    });
    private final Animation dWz = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation dWA = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dWf = noPressedRelativeLayout;
        this.dWx = frsFragment;
        this.dWA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dWy.getParent() != null) {
                    ((ViewGroup) e.this.dWy.getParent()).removeView(e.this.dWy);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aFs();
            }
        };
        initView();
    }

    private void initView() {
        this.dWy = new TextView(TbadkCoreApplication.getInst());
        this.dWy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aFs();
                if (e.this.dWx != null && !e.this.dWx.azq() && e.this.dWx.ayY() != null) {
                    e.this.dWx.ayY().startPullRefresh();
                }
            }
        });
        this.dWy.setGravity(17);
        this.dWy.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dWx.getResources().getDimensionPixelSize(e.C0200e.ds20);
        int dimensionPixelSize2 = this.dWx.getResources().getDimensionPixelSize(e.C0200e.ds40);
        this.dWy.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dWy.setTextSize(0, this.dWx.getResources().getDimensionPixelSize(e.C0200e.fontsize28));
        al.i(this.dWy, e.f.bg_home_float);
        al.h(this.dWy, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.dWx.aaO().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0200e.ds8);
        this.dWy.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dCW = i;
        this.bJl = i2;
        if (this.dWB < 0) {
            this.dWB = this.dCW;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dCW > 0 && this.bJl > 0 && this.dWB >= 0 && this.dCW + this.bJl + 1 < this.dWB) {
                this.dWw.sendEmptyMessage(111);
            }
            this.dWB = this.dCW;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFr() {
        if (this.dWy.getParent() == null) {
            this.dWf.addView(this.dWy);
            this.dWy.clearAnimation();
            this.dWy.startAnimation(this.dWz);
            this.dWw.removeCallbacks(this.mHideRunnable);
            this.dWw.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFs() {
        if (this.dWy.getParent() != null) {
            this.dCW = -1;
            this.dWB = -1;
            this.dWw.removeCallbacks(this.mHideRunnable);
            this.dWy.clearAnimation();
            this.dWy.startAnimation(this.dWA);
        }
    }

    public void onDestory() {
        this.dWw.removeCallbacksAndMessages(null);
    }
}
