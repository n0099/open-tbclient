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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e {
    private NoPressedRelativeLayout dAc;
    private FrsFragment dAv;
    private TextView dAw;
    private final Runnable mHideRunnable;
    private int diQ = -1;
    private int brT = -1;
    private int dAz = -1;
    private final Handler dAu = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.azk();
                return true;
            }
            return false;
        }
    });
    private final Animation dAx = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dAy = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dAc = noPressedRelativeLayout;
        this.dAv = frsFragment;
        this.dAy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dAw.getParent() != null) {
                    ((ViewGroup) e.this.dAw.getParent()).removeView(e.this.dAw);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.azl();
            }
        };
        initView();
    }

    private void initView() {
        this.dAw = new TextView(TbadkCoreApplication.getInst());
        this.dAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.azl();
                if (e.this.dAv != null && !e.this.dAv.atJ() && e.this.dAv.atr() != null) {
                    e.this.dAv.atr().startPullRefresh();
                }
            }
        });
        this.dAw.setGravity(17);
        this.dAw.setText(d.k.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dAv.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dAv.getResources().getDimensionPixelSize(d.e.ds40);
        this.dAw.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dAw.setTextSize(0, this.dAv.getResources().getDimensionPixelSize(d.e.fontsize28));
        al.i(this.dAw, d.f.bg_home_float);
        al.h(this.dAw, d.C0141d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.e(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dAw.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.diQ = i;
        this.brT = i2;
        if (this.dAz < 0) {
            this.dAz = this.diQ;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.diQ > 0 && this.brT > 0 && this.dAz >= 0 && this.diQ + this.brT + 1 < this.dAz) {
                this.dAu.sendEmptyMessage(111);
            }
            this.dAz = this.diQ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        if (this.dAw.getParent() == null) {
            this.dAc.addView(this.dAw);
            this.dAw.clearAnimation();
            this.dAw.startAnimation(this.dAx);
            this.dAu.removeCallbacks(this.mHideRunnable);
            this.dAu.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azl() {
        if (this.dAw.getParent() != null) {
            this.diQ = -1;
            this.dAz = -1;
            this.dAu.removeCallbacks(this.mHideRunnable);
            this.dAw.clearAnimation();
            this.dAw.startAnimation(this.dAy);
        }
    }

    public void onDestory() {
        this.dAu.removeCallbacksAndMessages(null);
    }
}
