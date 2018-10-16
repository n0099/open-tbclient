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
    private NoPressedRelativeLayout dUY;
    private FrsFragment dVq;
    private TextView dVr;
    private final Runnable mHideRunnable;
    private int dBF = -1;
    private int bIA = -1;
    private int dVu = -1;
    private final Handler dVp = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aFV();
                return true;
            }
            return false;
        }
    });
    private final Animation dVs = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation dVt = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUY = noPressedRelativeLayout;
        this.dVq = frsFragment;
        this.dVt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dVr.getParent() != null) {
                    ((ViewGroup) e.this.dVr.getParent()).removeView(e.this.dVr);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aFW();
            }
        };
        initView();
    }

    private void initView() {
        this.dVr = new TextView(TbadkCoreApplication.getInst());
        this.dVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aFW();
                if (e.this.dVq != null && !e.this.dVq.azS() && e.this.dVq.azA() != null) {
                    e.this.dVq.azA().startPullRefresh();
                }
            }
        });
        this.dVr.setGravity(17);
        this.dVr.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dVq.getResources().getDimensionPixelSize(e.C0175e.ds20);
        int dimensionPixelSize2 = this.dVq.getResources().getDimensionPixelSize(e.C0175e.ds40);
        this.dVr.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dVr.setTextSize(0, this.dVq.getResources().getDimensionPixelSize(e.C0175e.fontsize28));
        al.i(this.dVr, e.f.bg_home_float);
        al.h(this.dVr, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.dVq.aaD().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0175e.ds8);
        this.dVr.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dBF = i;
        this.bIA = i2;
        if (this.dVu < 0) {
            this.dVu = this.dBF;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dBF > 0 && this.bIA > 0 && this.dVu >= 0 && this.dBF + this.bIA + 1 < this.dVu) {
                this.dVp.sendEmptyMessage(111);
            }
            this.dVu = this.dBF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFV() {
        if (this.dVr.getParent() == null) {
            this.dUY.addView(this.dVr);
            this.dVr.clearAnimation();
            this.dVr.startAnimation(this.dVs);
            this.dVp.removeCallbacks(this.mHideRunnable);
            this.dVp.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFW() {
        if (this.dVr.getParent() != null) {
            this.dBF = -1;
            this.dVu = -1;
            this.dVp.removeCallbacks(this.mHideRunnable);
            this.dVr.clearAnimation();
            this.dVr.startAnimation(this.dVt);
        }
    }

    public void onDestory() {
        this.dVp.removeCallbacksAndMessages(null);
    }
}
