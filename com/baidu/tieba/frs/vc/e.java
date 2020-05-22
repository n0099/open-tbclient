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
    private FrsFragment hLC;
    private TextView hLD;
    private NoPressedRelativeLayout hLb;
    private final Runnable mHideRunnable;
    private int hoQ = -1;
    private int faG = -1;
    private int hLG = -1;
    private final Handler hLB = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cbF();
                return true;
            }
            return false;
        }
    });
    private final Animation hLE = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation hLF = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hLb = noPressedRelativeLayout;
        this.hLC = frsFragment;
        this.hLF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.hLD.getParent() != null) {
                    ((ViewGroup) e.this.hLD.getParent()).removeView(e.this.hLD);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cbG();
            }
        };
        initView();
    }

    private void initView() {
        this.hLD = new TextView(TbadkCoreApplication.getInst());
        this.hLD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cbG();
                if (e.this.hLC != null && !e.this.hLC.bVt() && e.this.hLC.bUR() != null) {
                    e.this.hLC.bUR().startPullRefresh();
                }
            }
        });
        this.hLD.setGravity(17);
        this.hLD.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.hLC.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.hLC.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.hLD.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.hLD.setTextSize(0, this.hLC.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.hLD, R.drawable.bg_home_float);
        am.setViewTextColor(this.hLD, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.hLC.btY().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.hLD.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hoQ = i;
        this.faG = i2;
        if (this.hLG < 0) {
            this.hLG = this.hoQ;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hoQ > 0 && this.faG > 0 && this.hLG >= 0 && this.hoQ + this.faG + 1 < this.hLG) {
                this.hLB.sendEmptyMessage(111);
            }
            this.hLG = this.hoQ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.hLD.getParent() == null) {
            this.hLb.addView(this.hLD);
            this.hLD.clearAnimation();
            this.hLD.startAnimation(this.hLE);
            this.hLB.removeCallbacks(this.mHideRunnable);
            this.hLB.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.hLD.getParent() != null) {
            this.hoQ = -1;
            this.hLG = -1;
            this.hLB.removeCallbacks(this.mHideRunnable);
            this.hLD.clearAnimation();
            this.hLD.startAnimation(this.hLF);
        }
    }

    public void onDestory() {
        this.hLB.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.hLD, R.drawable.bg_home_float);
        am.setViewTextColor(this.hLD, (int) R.color.cp_link_tip_a);
    }
}
