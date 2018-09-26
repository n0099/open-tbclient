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
/* loaded from: classes2.dex */
public class e {
    private NoPressedRelativeLayout dNd;
    private FrsFragment dNv;
    private TextView dNw;
    private final Runnable mHideRunnable;
    private int dtE = -1;
    private int bzS = -1;
    private int dNz = -1;
    private final Handler dNu = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aCD();
                return true;
            }
            return false;
        }
    });
    private final Animation dNx = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation dNy = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dNd = noPressedRelativeLayout;
        this.dNv = frsFragment;
        this.dNy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dNw.getParent() != null) {
                    ((ViewGroup) e.this.dNw.getParent()).removeView(e.this.dNw);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aCE();
            }
        };
        initView();
    }

    private void initView() {
        this.dNw = new TextView(TbadkCoreApplication.getInst());
        this.dNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aCE();
                if (e.this.dNv != null && !e.this.dNv.aww() && e.this.dNv.awe() != null) {
                    e.this.dNv.awe().startPullRefresh();
                }
            }
        });
        this.dNw.setGravity(17);
        this.dNw.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dNv.getResources().getDimensionPixelSize(e.C0141e.ds20);
        int dimensionPixelSize2 = this.dNv.getResources().getDimensionPixelSize(e.C0141e.ds40);
        this.dNw.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dNw.setTextSize(0, this.dNv.getResources().getDimensionPixelSize(e.C0141e.fontsize28));
        al.i(this.dNw, e.f.bg_home_float);
        al.h(this.dNw, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.dNv.WW().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0141e.ds8);
        this.dNw.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dtE = i;
        this.bzS = i2;
        if (this.dNz < 0) {
            this.dNz = this.dtE;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dtE > 0 && this.bzS > 0 && this.dNz >= 0 && this.dtE + this.bzS + 1 < this.dNz) {
                this.dNu.sendEmptyMessage(111);
            }
            this.dNz = this.dtE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCD() {
        if (this.dNw.getParent() == null) {
            this.dNd.addView(this.dNw);
            this.dNw.clearAnimation();
            this.dNw.startAnimation(this.dNx);
            this.dNu.removeCallbacks(this.mHideRunnable);
            this.dNu.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCE() {
        if (this.dNw.getParent() != null) {
            this.dtE = -1;
            this.dNz = -1;
            this.dNu.removeCallbacks(this.mHideRunnable);
            this.dNw.clearAnimation();
            this.dNw.startAnimation(this.dNy);
        }
    }

    public void onDestory() {
        this.dNu.removeCallbacksAndMessages(null);
    }
}
