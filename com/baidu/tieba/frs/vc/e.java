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
    private NoPressedRelativeLayout dUZ;
    private FrsFragment dVr;
    private TextView dVs;
    private final Runnable mHideRunnable;
    private int dBF = -1;
    private int bIA = -1;
    private int dVv = -1;
    private final Handler dVq = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aFV();
                return true;
            }
            return false;
        }
    });
    private final Animation dVt = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation dVu = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUZ = noPressedRelativeLayout;
        this.dVr = frsFragment;
        this.dVu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dVs.getParent() != null) {
                    ((ViewGroup) e.this.dVs.getParent()).removeView(e.this.dVs);
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
        this.dVs = new TextView(TbadkCoreApplication.getInst());
        this.dVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aFW();
                if (e.this.dVr != null && !e.this.dVr.azT() && e.this.dVr.azB() != null) {
                    e.this.dVr.azB().startPullRefresh();
                }
            }
        });
        this.dVs.setGravity(17);
        this.dVs.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dVr.getResources().getDimensionPixelSize(e.C0175e.ds20);
        int dimensionPixelSize2 = this.dVr.getResources().getDimensionPixelSize(e.C0175e.ds40);
        this.dVs.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dVs.setTextSize(0, this.dVr.getResources().getDimensionPixelSize(e.C0175e.fontsize28));
        al.i(this.dVs, e.f.bg_home_float);
        al.h(this.dVs, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.dVr.aaE().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0175e.ds8);
        this.dVs.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dBF = i;
        this.bIA = i2;
        if (this.dVv < 0) {
            this.dVv = this.dBF;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dBF > 0 && this.bIA > 0 && this.dVv >= 0 && this.dBF + this.bIA + 1 < this.dVv) {
                this.dVq.sendEmptyMessage(111);
            }
            this.dVv = this.dBF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFV() {
        if (this.dVs.getParent() == null) {
            this.dUZ.addView(this.dVs);
            this.dVs.clearAnimation();
            this.dVs.startAnimation(this.dVt);
            this.dVq.removeCallbacks(this.mHideRunnable);
            this.dVq.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFW() {
        if (this.dVs.getParent() != null) {
            this.dBF = -1;
            this.dVv = -1;
            this.dVq.removeCallbacks(this.mHideRunnable);
            this.dVs.clearAnimation();
            this.dVs.startAnimation(this.dVu);
        }
    }

    public void onDestory() {
        this.dVq.removeCallbacksAndMessages(null);
    }
}
