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
/* loaded from: classes4.dex */
public class e {
    private FrsFragment fvB;
    private TextView fvC;
    private NoPressedRelativeLayout fvj;
    private final Runnable mHideRunnable;
    private int fay = -1;
    private int cZV = -1;
    private int fvF = -1;
    private final Handler fvA = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.biX();
                return true;
            }
            return false;
        }
    });
    private final Animation fvD = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation fvE = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fvj = noPressedRelativeLayout;
        this.fvB = frsFragment;
        this.fvE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fvC.getParent() != null) {
                    ((ViewGroup) e.this.fvC.getParent()).removeView(e.this.fvC);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.biY();
            }
        };
        initView();
    }

    private void initView() {
        this.fvC = new TextView(TbadkCoreApplication.getInst());
        this.fvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.biY();
                if (e.this.fvB != null && !e.this.fvB.bcT() && e.this.fvB.bcv() != null) {
                    e.this.fvB.bcv().startPullRefresh();
                }
            }
        });
        this.fvC.setGravity(17);
        this.fvC.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fvB.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.fvB.getResources().getDimensionPixelSize(d.e.ds40);
        this.fvC.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fvC.setTextSize(0, this.fvB.getResources().getDimensionPixelSize(d.e.fontsize28));
        al.k(this.fvC, d.f.bg_home_float);
        al.j(this.fvC, d.C0236d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fvB.aDq().getBottom() + l.h(TbadkCoreApplication.getInst(), d.e.ds8);
        this.fvC.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fay = i;
        this.cZV = i2;
        if (this.fvF < 0) {
            this.fvF = this.fay;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fay > 0 && this.cZV > 0 && this.fvF >= 0 && this.fay + this.cZV + 1 < this.fvF) {
                this.fvA.sendEmptyMessage(111);
            }
            this.fvF = this.fay;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biX() {
        if (this.fvC.getParent() == null) {
            this.fvj.addView(this.fvC);
            this.fvC.clearAnimation();
            this.fvC.startAnimation(this.fvD);
            this.fvA.removeCallbacks(this.mHideRunnable);
            this.fvA.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biY() {
        if (this.fvC.getParent() != null) {
            this.fay = -1;
            this.fvF = -1;
            this.fvA.removeCallbacks(this.mHideRunnable);
            this.fvC.clearAnimation();
            this.fvC.startAnimation(this.fvE);
        }
    }

    public void onDestory() {
        this.fvA.removeCallbacksAndMessages(null);
    }
}
