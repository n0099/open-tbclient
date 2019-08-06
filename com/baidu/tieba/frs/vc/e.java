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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class e {
    private NoPressedRelativeLayout fRA;
    private FrsFragment fRR;
    private TextView fRS;
    private final Runnable mHideRunnable;
    private int fvX = -1;
    private int dms = -1;
    private int fRV = -1;
    private final Handler mHandelr = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bsF();
                return true;
            }
            return false;
        }
    });
    private final Animation fRT = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fRU = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fRA = noPressedRelativeLayout;
        this.fRR = frsFragment;
        this.fRU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fRS.getParent() != null) {
                    ((ViewGroup) e.this.fRS.getParent()).removeView(e.this.fRS);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bsG();
            }
        };
        initView();
    }

    private void initView() {
        this.fRS = new TextView(TbadkCoreApplication.getInst());
        this.fRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bsG();
                if (e.this.fRR != null && !e.this.fRR.bmz() && e.this.fRR.blY() != null) {
                    e.this.fRR.blY().startPullRefresh();
                }
            }
        });
        this.fRS.setGravity(17);
        this.fRS.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fRR.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fRR.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fRS.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fRS.setTextSize(0, this.fRR.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.k(this.fRS, R.drawable.bg_home_float);
        am.j(this.fRS, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fRR.aLj().getBottom() + l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fRS.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fvX = i;
        this.dms = i2;
        if (this.fRV < 0) {
            this.fRV = this.fvX;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fvX > 0 && this.dms > 0 && this.fRV >= 0 && this.fvX + this.dms + 1 < this.fRV) {
                this.mHandelr.sendEmptyMessage(111);
            }
            this.fRV = this.fvX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsF() {
        if (this.fRS.getParent() == null) {
            this.fRA.addView(this.fRS);
            this.fRS.clearAnimation();
            this.fRS.startAnimation(this.fRT);
            this.mHandelr.removeCallbacks(this.mHideRunnable);
            this.mHandelr.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        if (this.fRS.getParent() != null) {
            this.fvX = -1;
            this.fRV = -1;
            this.mHandelr.removeCallbacks(this.mHideRunnable);
            this.fRS.clearAnimation();
            this.fRS.startAnimation(this.fRU);
        }
    }

    public void onDestory() {
        this.mHandelr.removeCallbacksAndMessages(null);
    }
}
