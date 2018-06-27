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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e {
    private FrsFragment dDG;
    private TextView dDH;
    private NoPressedRelativeLayout dDo;
    private final Runnable mHideRunnable;
    private int dkR = -1;
    private int btu = -1;
    private int dDK = -1;
    private final Handler dDF = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.azQ();
                return true;
            }
            return false;
        }
    });
    private final Animation dDI = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dDJ = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dDo = noPressedRelativeLayout;
        this.dDG = frsFragment;
        this.dDJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dDH.getParent() != null) {
                    ((ViewGroup) e.this.dDH.getParent()).removeView(e.this.dDH);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.azR();
            }
        };
        initView();
    }

    private void initView() {
        this.dDH = new TextView(TbadkCoreApplication.getInst());
        this.dDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.azR();
                if (e.this.dDG != null && !e.this.dDG.aua() && e.this.dDG.atI() != null) {
                    e.this.dDG.atI().startPullRefresh();
                }
            }
        });
        this.dDH.setGravity(17);
        this.dDH.setText(d.k.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dDG.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dDG.getResources().getDimensionPixelSize(d.e.ds40);
        this.dDH.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dDH.setTextSize(0, this.dDG.getResources().getDimensionPixelSize(d.e.fontsize28));
        am.i(this.dDH, d.f.bg_home_float);
        am.h(this.dDH, d.C0142d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.e(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dDH.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dkR = i;
        this.btu = i2;
        if (this.dDK < 0) {
            this.dDK = this.dkR;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dkR > 0 && this.btu > 0 && this.dDK >= 0 && this.dkR + this.btu + 1 < this.dDK) {
                this.dDF.sendEmptyMessage(111);
            }
            this.dDK = this.dkR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azQ() {
        if (this.dDH.getParent() == null) {
            this.dDo.addView(this.dDH);
            this.dDH.clearAnimation();
            this.dDH.startAnimation(this.dDI);
            this.dDF.removeCallbacks(this.mHideRunnable);
            this.dDF.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azR() {
        if (this.dDH.getParent() != null) {
            this.dkR = -1;
            this.dDK = -1;
            this.dDF.removeCallbacks(this.mHideRunnable);
            this.dDH.clearAnimation();
            this.dDH.startAnimation(this.dDJ);
        }
    }

    public void onDestory() {
        this.dDF.removeCallbacksAndMessages(null);
    }
}
