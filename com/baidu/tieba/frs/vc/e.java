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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes9.dex */
public class e implements o {
    private NoPressedRelativeLayout hLO;
    private FrsFragment hMp;
    private TextView hMq;
    private final Runnable mHideRunnable;
    private int hpb = -1;
    private int faR = -1;
    private int hMt = -1;
    private final Handler hMo = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cbN();
                return true;
            }
            return false;
        }
    });
    private final Animation hMr = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation hMs = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hLO = noPressedRelativeLayout;
        this.hMp = frsFragment;
        this.hMs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.hMq.getParent() != null) {
                    ((ViewGroup) e.this.hMq.getParent()).removeView(e.this.hMq);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cbO();
            }
        };
        initView();
    }

    private void initView() {
        this.hMq = new TextView(TbadkCoreApplication.getInst());
        this.hMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cbO();
                if (e.this.hMp != null && !e.this.hMp.bVv() && e.this.hMp.bUT() != null) {
                    e.this.hMp.bUT().startPullRefresh();
                }
            }
        });
        this.hMq.setGravity(17);
        this.hMq.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.hMp.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.hMp.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.hMq.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.hMq.setTextSize(0, this.hMp.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.hMq, R.drawable.bg_home_float);
        am.setViewTextColor(this.hMq, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.hMp.bua().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.hMq.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hpb = i;
        this.faR = i2;
        if (this.hMt < 0) {
            this.hMt = this.hpb;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hpb > 0 && this.faR > 0 && this.hMt >= 0 && this.hpb + this.faR + 1 < this.hMt) {
                this.hMo.sendEmptyMessage(111);
            }
            this.hMt = this.hpb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbN() {
        if (this.hMq.getParent() == null) {
            this.hLO.addView(this.hMq);
            this.hMq.clearAnimation();
            this.hMq.startAnimation(this.hMr);
            this.hMo.removeCallbacks(this.mHideRunnable);
            this.hMo.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbO() {
        if (this.hMq.getParent() != null) {
            this.hpb = -1;
            this.hMt = -1;
            this.hMo.removeCallbacks(this.mHideRunnable);
            this.hMq.clearAnimation();
            this.hMq.startAnimation(this.hMs);
        }
    }

    public void onDestory() {
        this.hMo.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.hMq, R.drawable.bg_home_float);
        am.setViewTextColor(this.hMq, (int) R.color.cp_link_tip_a);
    }
}
