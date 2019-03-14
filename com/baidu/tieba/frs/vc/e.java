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
    private FrsFragment fvA;
    private TextView fvB;
    private NoPressedRelativeLayout fvi;
    private final Runnable mHideRunnable;
    private int fax = -1;
    private int cZR = -1;
    private int fvE = -1;
    private final Handler fvz = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.biW();
                return true;
            }
            return false;
        }
    });
    private final Animation fvC = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation fvD = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fvi = noPressedRelativeLayout;
        this.fvA = frsFragment;
        this.fvD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fvB.getParent() != null) {
                    ((ViewGroup) e.this.fvB.getParent()).removeView(e.this.fvB);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.biX();
            }
        };
        initView();
    }

    private void initView() {
        this.fvB = new TextView(TbadkCoreApplication.getInst());
        this.fvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.biX();
                if (e.this.fvA != null && !e.this.fvA.bcS() && e.this.fvA.bcu() != null) {
                    e.this.fvA.bcu().startPullRefresh();
                }
            }
        });
        this.fvB.setGravity(17);
        this.fvB.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fvA.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.fvA.getResources().getDimensionPixelSize(d.e.ds40);
        this.fvB.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fvB.setTextSize(0, this.fvA.getResources().getDimensionPixelSize(d.e.fontsize28));
        al.k(this.fvB, d.f.bg_home_float);
        al.j(this.fvB, d.C0277d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fvA.aDp().getBottom() + l.h(TbadkCoreApplication.getInst(), d.e.ds8);
        this.fvB.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fax = i;
        this.cZR = i2;
        if (this.fvE < 0) {
            this.fvE = this.fax;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fax > 0 && this.cZR > 0 && this.fvE >= 0 && this.fax + this.cZR + 1 < this.fvE) {
                this.fvz.sendEmptyMessage(111);
            }
            this.fvE = this.fax;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biW() {
        if (this.fvB.getParent() == null) {
            this.fvi.addView(this.fvB);
            this.fvB.clearAnimation();
            this.fvB.startAnimation(this.fvC);
            this.fvz.removeCallbacks(this.mHideRunnable);
            this.fvz.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biX() {
        if (this.fvB.getParent() != null) {
            this.fax = -1;
            this.fvE = -1;
            this.fvz.removeCallbacks(this.mHideRunnable);
            this.fvB.clearAnimation();
            this.fvB.startAnimation(this.fvD);
        }
    }

    public void onDestory() {
        this.fvz.removeCallbacksAndMessages(null);
    }
}
