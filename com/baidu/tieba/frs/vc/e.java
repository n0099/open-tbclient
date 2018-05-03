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
    private final Runnable dhA;
    private NoPressedRelativeLayout dpH;
    private FrsFragment dqa;
    private TextView dqb;
    private int cYs = -1;
    private int bjz = -1;
    private int dqe = -1;
    private final Handler dpZ = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.avc();
                return true;
            }
            return false;
        }
    });
    private final Animation dqc = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dqd = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dpH = noPressedRelativeLayout;
        this.dqa = frsFragment;
        this.dqd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dqb.getParent() != null) {
                    ((ViewGroup) e.this.dqb.getParent()).removeView(e.this.dqb);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dhA = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.avd();
            }
        };
        initView();
    }

    private void initView() {
        this.dqb = new TextView(TbadkCoreApplication.getInst());
        this.dqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.avd();
                if (e.this.dqa != null && !e.this.dqa.apF() && e.this.dqa.apn() != null) {
                    e.this.dqa.apn().startPullRefresh();
                }
            }
        });
        this.dqb.setGravity(17);
        this.dqb.setText(d.k.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dqa.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dqa.getResources().getDimensionPixelSize(d.e.ds40);
        this.dqb.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dqb.setTextSize(0, this.dqa.getResources().getDimensionPixelSize(d.e.fontsize28));
        ak.i(this.dqb, d.f.bg_home_float);
        ak.h(this.dqb, d.C0126d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.e(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dqb.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.cYs = i;
        this.bjz = i2;
        if (this.dqe < 0) {
            this.dqe = this.cYs;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.cYs > 0 && this.bjz > 0 && this.dqe >= 0 && this.cYs + this.bjz + 1 < this.dqe) {
                this.dpZ.sendEmptyMessage(111);
            }
            this.dqe = this.cYs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avc() {
        if (this.dqb.getParent() == null) {
            this.dpH.addView(this.dqb);
            this.dqb.clearAnimation();
            this.dqb.startAnimation(this.dqc);
            this.dpZ.removeCallbacks(this.dhA);
            this.dpZ.postDelayed(this.dhA, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avd() {
        if (this.dqb.getParent() != null) {
            this.cYs = -1;
            this.dqe = -1;
            this.dpZ.removeCallbacks(this.dhA);
            this.dqb.clearAnimation();
            this.dqb.startAnimation(this.dqd);
        }
    }

    public void onDestory() {
        this.dpZ.removeCallbacksAndMessages(null);
    }
}
