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
    private NoPressedRelativeLayout efA;
    private FrsFragment efS;
    private TextView efT;
    private final Runnable mHideRunnable;
    private int dMj = -1;
    private int bNd = -1;
    private int efW = -1;
    private final Handler efR = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aHS();
                return true;
            }
            return false;
        }
    });
    private final Animation efU = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation efV = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.efA = noPressedRelativeLayout;
        this.efS = frsFragment;
        this.efV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.efT.getParent() != null) {
                    ((ViewGroup) e.this.efT.getParent()).removeView(e.this.efT);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aHT();
            }
        };
        initView();
    }

    private void initView() {
        this.efT = new TextView(TbadkCoreApplication.getInst());
        this.efT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aHT();
                if (e.this.efS != null && !e.this.efS.aBP() && e.this.efS.aBx() != null) {
                    e.this.efS.aBx().startPullRefresh();
                }
            }
        });
        this.efT.setGravity(17);
        this.efT.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.efS.getResources().getDimensionPixelSize(e.C0210e.ds20);
        int dimensionPixelSize2 = this.efS.getResources().getDimensionPixelSize(e.C0210e.ds40);
        this.efT.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.efT.setTextSize(0, this.efS.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.i(this.efT, e.f.bg_home_float);
        al.h(this.efT, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.efS.abW().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0210e.ds8);
        this.efT.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dMj = i;
        this.bNd = i2;
        if (this.efW < 0) {
            this.efW = this.dMj;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dMj > 0 && this.bNd > 0 && this.efW >= 0 && this.dMj + this.bNd + 1 < this.efW) {
                this.efR.sendEmptyMessage(111);
            }
            this.efW = this.dMj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHS() {
        if (this.efT.getParent() == null) {
            this.efA.addView(this.efT);
            this.efT.clearAnimation();
            this.efT.startAnimation(this.efU);
            this.efR.removeCallbacks(this.mHideRunnable);
            this.efR.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHT() {
        if (this.efT.getParent() != null) {
            this.dMj = -1;
            this.efW = -1;
            this.efR.removeCallbacks(this.mHideRunnable);
            this.efT.clearAnimation();
            this.efT.startAnimation(this.efV);
        }
    }

    public void onDestory() {
        this.efR.removeCallbacksAndMessages(null);
    }
}
