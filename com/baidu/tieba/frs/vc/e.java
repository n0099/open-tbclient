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
import com.baidu.card.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes9.dex */
public class e implements n {
    private FrsFragment gLP;
    private TextView gLQ;
    private NoPressedRelativeLayout gLx;
    private final Runnable mHideRunnable;
    private int gpQ = -1;
    private int ejR = -1;
    private int gLT = -1;
    private final Handler gLO = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bKv();
                return true;
            }
            return false;
        }
    });
    private final Animation gLR = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation gLS = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gLx = noPressedRelativeLayout;
        this.gLP = frsFragment;
        this.gLS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.gLQ.getParent() != null) {
                    ((ViewGroup) e.this.gLQ.getParent()).removeView(e.this.gLQ);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bKw();
            }
        };
        initView();
    }

    private void initView() {
        this.gLQ = new TextView(TbadkCoreApplication.getInst());
        this.gLQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bKw();
                if (e.this.gLP != null && !e.this.gLP.bEq() && e.this.gLP.bDP() != null) {
                    e.this.gLP.bDP().startPullRefresh();
                }
            }
        });
        this.gLQ.setGravity(17);
        this.gLQ.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.gLP.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.gLP.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.gLQ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.gLQ.setTextSize(0, this.gLP.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.gLQ, R.drawable.bg_home_float);
        am.setViewTextColor(this.gLQ, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.gLP.beL().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.gLQ.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gpQ = i;
        this.ejR = i2;
        if (this.gLT < 0) {
            this.gLT = this.gpQ;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gpQ > 0 && this.ejR > 0 && this.gLT >= 0 && this.gpQ + this.ejR + 1 < this.gLT) {
                this.gLO.sendEmptyMessage(111);
            }
            this.gLT = this.gpQ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKv() {
        if (this.gLQ.getParent() == null) {
            this.gLx.addView(this.gLQ);
            this.gLQ.clearAnimation();
            this.gLQ.startAnimation(this.gLR);
            this.gLO.removeCallbacks(this.mHideRunnable);
            this.gLO.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKw() {
        if (this.gLQ.getParent() != null) {
            this.gpQ = -1;
            this.gLT = -1;
            this.gLO.removeCallbacks(this.mHideRunnable);
            this.gLQ.clearAnimation();
            this.gLQ.startAnimation(this.gLS);
        }
    }

    public void onDestory() {
        this.gLO.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.gLQ, R.drawable.bg_home_float);
        am.setViewTextColor(this.gLQ, (int) R.color.cp_link_tip_a);
    }
}
