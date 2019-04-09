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
    private NoPressedRelativeLayout fuU;
    private FrsFragment fvm;
    private TextView fvn;
    private final Runnable mHideRunnable;
    private int fak = -1;
    private int cZV = -1;
    private int fvq = -1;
    private final Handler fvl = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.biU();
                return true;
            }
            return false;
        }
    });
    private final Animation fvo = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation fvp = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fuU = noPressedRelativeLayout;
        this.fvm = frsFragment;
        this.fvp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fvn.getParent() != null) {
                    ((ViewGroup) e.this.fvn.getParent()).removeView(e.this.fvn);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.biV();
            }
        };
        initView();
    }

    private void initView() {
        this.fvn = new TextView(TbadkCoreApplication.getInst());
        this.fvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.biV();
                if (e.this.fvm != null && !e.this.fvm.bcQ() && e.this.fvm.bcs() != null) {
                    e.this.fvm.bcs().startPullRefresh();
                }
            }
        });
        this.fvn.setGravity(17);
        this.fvn.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fvm.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.fvm.getResources().getDimensionPixelSize(d.e.ds40);
        this.fvn.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fvn.setTextSize(0, this.fvm.getResources().getDimensionPixelSize(d.e.fontsize28));
        al.k(this.fvn, d.f.bg_home_float);
        al.j(this.fvn, d.C0277d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fvm.aDm().getBottom() + l.h(TbadkCoreApplication.getInst(), d.e.ds8);
        this.fvn.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fak = i;
        this.cZV = i2;
        if (this.fvq < 0) {
            this.fvq = this.fak;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fak > 0 && this.cZV > 0 && this.fvq >= 0 && this.fak + this.cZV + 1 < this.fvq) {
                this.fvl.sendEmptyMessage(111);
            }
            this.fvq = this.fak;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biU() {
        if (this.fvn.getParent() == null) {
            this.fuU.addView(this.fvn);
            this.fvn.clearAnimation();
            this.fvn.startAnimation(this.fvo);
            this.fvl.removeCallbacks(this.mHideRunnable);
            this.fvl.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biV() {
        if (this.fvn.getParent() != null) {
            this.fak = -1;
            this.fvq = -1;
            this.fvl.removeCallbacks(this.mHideRunnable);
            this.fvn.clearAnimation();
            this.fvn.startAnimation(this.fvp);
        }
    }

    public void onDestory() {
        this.fvl.removeCallbacksAndMessages(null);
    }
}
