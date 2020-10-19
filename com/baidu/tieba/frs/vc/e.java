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
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes22.dex */
public class e implements q {
    private NoPressedRelativeLayout iPC;
    private FrsFragment iQd;
    private TextView iQe;
    private final Runnable mHideRunnable;
    private int ird = -1;
    private int fSe = -1;
    private int iQf = -1;
    private final Handler iQc = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.czY();
                return true;
            }
            return false;
        }
    });
    private final Animation bBp = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bBq = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.iPC = noPressedRelativeLayout;
        this.iQd = frsFragment;
        this.bBq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.iQe.getParent() != null) {
                    ((ViewGroup) e.this.iQe.getParent()).removeView(e.this.iQe);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.czZ();
            }
        };
        initView();
    }

    private void initView() {
        this.iQe = new TextView(TbadkCoreApplication.getInst());
        this.iQe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.czZ();
                if (e.this.iQd != null && !e.this.iQd.cti() && e.this.iQd.csD() != null) {
                    e.this.iQd.csD().startPullRefresh();
                }
            }
        });
        this.iQe.setGravity(17);
        this.iQe.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.iQd.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.iQd.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.iQe.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.iQe.setTextSize(0, this.iQd.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.iQe, R.drawable.bg_home_float);
        ap.setViewTextColor(this.iQe, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.iQd.bNC().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.iQe.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.ird = i;
        this.fSe = i2;
        if (this.iQf < 0) {
            this.iQf = this.ird;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.ird > 0 && this.fSe > 0 && this.iQf >= 0 && this.ird + this.fSe + 1 < this.iQf) {
                this.iQc.sendEmptyMessage(111);
            }
            this.iQf = this.ird;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czY() {
        if (this.iQe.getParent() == null) {
            this.iPC.addView(this.iQe);
            this.iQe.clearAnimation();
            this.iQe.startAnimation(this.bBp);
            this.iQc.removeCallbacks(this.mHideRunnable);
            this.iQc.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czZ() {
        if (this.iQe.getParent() != null) {
            this.ird = -1;
            this.iQf = -1;
            this.iQc.removeCallbacks(this.mHideRunnable);
            this.iQe.clearAnimation();
            this.iQe.startAnimation(this.bBq);
        }
    }

    public void onDestory() {
        this.iQc.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.iQe, R.drawable.bg_home_float);
        ap.setViewTextColor(this.iQe, R.color.cp_link_tip_a);
    }
}
