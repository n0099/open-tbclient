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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e {
    private final Runnable dhD;
    private NoPressedRelativeLayout dpK;
    private FrsFragment dqd;
    private TextView dqe;
    private int cYv = -1;
    private int bjz = -1;
    private int dqh = -1;
    private final Handler dqc = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.avc();
                return true;
            }
            return false;
        }
    });
    private final Animation dqf = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dqg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dpK = noPressedRelativeLayout;
        this.dqd = frsFragment;
        this.dqg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dqe.getParent() != null) {
                    ((ViewGroup) e.this.dqe.getParent()).removeView(e.this.dqe);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dhD = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.avd();
            }
        };
        initView();
    }

    private void initView() {
        this.dqe = new TextView(TbadkCoreApplication.getInst());
        this.dqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.avd();
                if (e.this.dqd != null && !e.this.dqd.apF() && e.this.dqd.apn() != null) {
                    e.this.dqd.apn().startPullRefresh();
                }
            }
        });
        this.dqe.setGravity(17);
        this.dqe.setText(d.k.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dqd.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dqd.getResources().getDimensionPixelSize(d.e.ds40);
        this.dqe.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dqe.setTextSize(0, this.dqd.getResources().getDimensionPixelSize(d.e.fontsize28));
        ak.i(this.dqe, d.f.bg_home_float);
        ak.h(this.dqe, d.C0126d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.e(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dqe.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.cYv = i;
        this.bjz = i2;
        if (this.dqh < 0) {
            this.dqh = this.cYv;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.cYv > 0 && this.bjz > 0 && this.dqh >= 0 && this.cYv + this.bjz + 1 < this.dqh) {
                this.dqc.sendEmptyMessage(111);
            }
            this.dqh = this.cYv;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avc() {
        if (this.dqe.getParent() == null) {
            this.dpK.addView(this.dqe);
            this.dqe.clearAnimation();
            this.dqe.startAnimation(this.dqf);
            this.dqc.removeCallbacks(this.dhD);
            this.dqc.postDelayed(this.dhD, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avd() {
        if (this.dqe.getParent() != null) {
            this.cYv = -1;
            this.dqh = -1;
            this.dqc.removeCallbacks(this.dhD);
            this.dqe.clearAnimation();
            this.dqe.startAnimation(this.dqg);
        }
    }

    public void onDestory() {
        this.dqc.removeCallbacksAndMessages(null);
    }
}
