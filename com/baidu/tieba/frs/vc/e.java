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
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes9.dex */
public class e implements o {
    private FrsFragment hZB;
    private TextView hZC;
    private NoPressedRelativeLayout hZa;
    private final Runnable mHideRunnable;
    private int hBI = -1;
    private int fmb = -1;
    private int hZF = -1;
    private final Handler hZA = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cfg();
                return true;
            }
            return false;
        }
    });
    private final Animation hZD = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation hZE = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hZa = noPressedRelativeLayout;
        this.hZB = frsFragment;
        this.hZE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.hZC.getParent() != null) {
                    ((ViewGroup) e.this.hZC.getParent()).removeView(e.this.hZC);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cfh();
            }
        };
        initView();
    }

    private void initView() {
        this.hZC = new TextView(TbadkCoreApplication.getInst());
        this.hZC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cfh();
                if (e.this.hZB != null && !e.this.hZB.bYD() && e.this.hZB.bYa() != null) {
                    e.this.hZB.bYa().startPullRefresh();
                }
            }
        });
        this.hZC.setGravity(17);
        this.hZC.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.hZB.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.hZB.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.hZC.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.hZC.setTextSize(0, this.hZB.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        an.setBackgroundResource(this.hZC, R.drawable.bg_home_float);
        an.setViewTextColor(this.hZC, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.hZB.bwW().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.hZC.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hBI = i;
        this.fmb = i2;
        if (this.hZF < 0) {
            this.hZF = this.hBI;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hBI > 0 && this.fmb > 0 && this.hZF >= 0 && this.hBI + this.fmb + 1 < this.hZF) {
                this.hZA.sendEmptyMessage(111);
            }
            this.hZF = this.hBI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfg() {
        if (this.hZC.getParent() == null) {
            this.hZa.addView(this.hZC);
            this.hZC.clearAnimation();
            this.hZC.startAnimation(this.hZD);
            this.hZA.removeCallbacks(this.mHideRunnable);
            this.hZA.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        if (this.hZC.getParent() != null) {
            this.hBI = -1;
            this.hZF = -1;
            this.hZA.removeCallbacks(this.mHideRunnable);
            this.hZC.clearAnimation();
            this.hZC.startAnimation(this.hZE);
        }
    }

    public void onDestory() {
        this.hZA.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        an.setBackgroundResource(this.hZC, R.drawable.bg_home_float);
        an.setViewTextColor(this.hZC, (int) R.color.cp_link_tip_a);
    }
}
