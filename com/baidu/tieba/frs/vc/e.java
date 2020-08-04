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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes16.dex */
public class e implements o {
    private FrsFragment ifF;
    private TextView ifG;
    private NoPressedRelativeLayout ife;
    private final Runnable mHideRunnable;
    private int hHG = -1;
    private int frk = -1;
    private int ifJ = -1;
    private final Handler ifE = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ciF();
                return true;
            }
            return false;
        }
    });
    private final Animation ifH = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation ifI = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ife = noPressedRelativeLayout;
        this.ifF = frsFragment;
        this.ifI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.ifG.getParent() != null) {
                    ((ViewGroup) e.this.ifG.getParent()).removeView(e.this.ifG);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ciG();
            }
        };
        initView();
    }

    private void initView() {
        this.ifG = new TextView(TbadkCoreApplication.getInst());
        this.ifG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ciG();
                if (e.this.ifF != null && !e.this.ifF.cca() && e.this.ifF.cbw() != null) {
                    e.this.ifF.cbw().startPullRefresh();
                }
            }
        });
        this.ifG.setGravity(17);
        this.ifG.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.ifF.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.ifF.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.ifG.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.ifG.setTextSize(0, this.ifF.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ao.setBackgroundResource(this.ifG, R.drawable.bg_home_float);
        ao.setViewTextColor(this.ifG, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.ifF.bAm().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.ifG.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hHG = i;
        this.frk = i2;
        if (this.ifJ < 0) {
            this.ifJ = this.hHG;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hHG > 0 && this.frk > 0 && this.ifJ >= 0 && this.hHG + this.frk + 1 < this.ifJ) {
                this.ifE.sendEmptyMessage(111);
            }
            this.ifJ = this.hHG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciF() {
        if (this.ifG.getParent() == null) {
            this.ife.addView(this.ifG);
            this.ifG.clearAnimation();
            this.ifG.startAnimation(this.ifH);
            this.ifE.removeCallbacks(this.mHideRunnable);
            this.ifE.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciG() {
        if (this.ifG.getParent() != null) {
            this.hHG = -1;
            this.ifJ = -1;
            this.ifE.removeCallbacks(this.mHideRunnable);
            this.ifG.clearAnimation();
            this.ifG.startAnimation(this.ifI);
        }
    }

    public void onDestory() {
        this.ifE.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundResource(this.ifG, R.drawable.bg_home_float);
        ao.setViewTextColor(this.ifG, R.color.cp_link_tip_a);
    }
}
