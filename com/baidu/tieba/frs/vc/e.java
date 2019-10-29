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
    private NoPressedRelativeLayout fSK;
    private FrsFragment fTc;
    private TextView fTd;
    private final Runnable mHideRunnable;
    private int fwY = -1;
    private int dvr = -1;
    private int fTg = -1;
    private final Handler fTb = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bqv();
                return true;
            }
            return false;
        }
    });
    private final Animation fTe = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fTf = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fSK = noPressedRelativeLayout;
        this.fTc = frsFragment;
        this.fTf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fTd.getParent() != null) {
                    ((ViewGroup) e.this.fTd.getParent()).removeView(e.this.fTd);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bqw();
            }
        };
        initView();
    }

    private void initView() {
        this.fTd = new TextView(TbadkCoreApplication.getInst());
        this.fTd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bqw();
                if (e.this.fTc != null && !e.this.fTc.bkq() && e.this.fTc.bjP() != null) {
                    e.this.fTc.bjP().startPullRefresh();
                }
            }
        });
        this.fTd.setGravity(17);
        this.fTd.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fTc.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fTc.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fTd.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fTd.setTextSize(0, this.fTc.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.fTd, R.drawable.bg_home_float);
        am.setViewTextColor(this.fTd, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fTc.aKR().getBottom() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fTd.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fwY = i;
        this.dvr = i2;
        if (this.fTg < 0) {
            this.fTg = this.fwY;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fwY > 0 && this.dvr > 0 && this.fTg >= 0 && this.fwY + this.dvr + 1 < this.fTg) {
                this.fTb.sendEmptyMessage(111);
            }
            this.fTg = this.fwY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqv() {
        if (this.fTd.getParent() == null) {
            this.fSK.addView(this.fTd);
            this.fTd.clearAnimation();
            this.fTd.startAnimation(this.fTe);
            this.fTb.removeCallbacks(this.mHideRunnable);
            this.fTb.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqw() {
        if (this.fTd.getParent() != null) {
            this.fwY = -1;
            this.fTg = -1;
            this.fTb.removeCallbacks(this.mHideRunnable);
            this.fTd.clearAnimation();
            this.fTd.startAnimation(this.fTf);
        }
    }

    public void onDestory() {
        this.fTb.removeCallbacksAndMessages(null);
    }
}
