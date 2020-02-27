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
    private FrsFragment gLN;
    private TextView gLO;
    private NoPressedRelativeLayout gLv;
    private final Runnable mHideRunnable;
    private int gpO = -1;
    private int ejQ = -1;
    private int gLR = -1;
    private final Handler gLM = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bKt();
                return true;
            }
            return false;
        }
    });
    private final Animation gLP = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation gLQ = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gLv = noPressedRelativeLayout;
        this.gLN = frsFragment;
        this.gLQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.gLO.getParent() != null) {
                    ((ViewGroup) e.this.gLO.getParent()).removeView(e.this.gLO);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bKu();
            }
        };
        initView();
    }

    private void initView() {
        this.gLO = new TextView(TbadkCoreApplication.getInst());
        this.gLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bKu();
                if (e.this.gLN != null && !e.this.gLN.bEo() && e.this.gLN.bDN() != null) {
                    e.this.gLN.bDN().startPullRefresh();
                }
            }
        });
        this.gLO.setGravity(17);
        this.gLO.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.gLN.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.gLN.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.gLO.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.gLO.setTextSize(0, this.gLN.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.gLO, R.drawable.bg_home_float);
        am.setViewTextColor(this.gLO, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.gLN.beJ().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.gLO.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gpO = i;
        this.ejQ = i2;
        if (this.gLR < 0) {
            this.gLR = this.gpO;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gpO > 0 && this.ejQ > 0 && this.gLR >= 0 && this.gpO + this.ejQ + 1 < this.gLR) {
                this.gLM.sendEmptyMessage(111);
            }
            this.gLR = this.gpO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKt() {
        if (this.gLO.getParent() == null) {
            this.gLv.addView(this.gLO);
            this.gLO.clearAnimation();
            this.gLO.startAnimation(this.gLP);
            this.gLM.removeCallbacks(this.mHideRunnable);
            this.gLM.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKu() {
        if (this.gLO.getParent() != null) {
            this.gpO = -1;
            this.gLR = -1;
            this.gLM.removeCallbacks(this.mHideRunnable);
            this.gLO.clearAnimation();
            this.gLO.startAnimation(this.gLQ);
        }
    }

    public void onDestory() {
        this.gLM.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.gLO, R.drawable.bg_home_float);
        am.setViewTextColor(this.gLO, (int) R.color.cp_link_tip_a);
    }
}
