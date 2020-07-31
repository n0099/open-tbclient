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
    private FrsFragment ifD;
    private TextView ifE;
    private NoPressedRelativeLayout ifc;
    private final Runnable mHideRunnable;
    private int hHG = -1;
    private int frk = -1;
    private int ifH = -1;
    private final Handler ifC = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ciF();
                return true;
            }
            return false;
        }
    });
    private final Animation ifF = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation ifG = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ifc = noPressedRelativeLayout;
        this.ifD = frsFragment;
        this.ifG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.ifE.getParent() != null) {
                    ((ViewGroup) e.this.ifE.getParent()).removeView(e.this.ifE);
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
        this.ifE = new TextView(TbadkCoreApplication.getInst());
        this.ifE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ciG();
                if (e.this.ifD != null && !e.this.ifD.cca() && e.this.ifD.cbw() != null) {
                    e.this.ifD.cbw().startPullRefresh();
                }
            }
        });
        this.ifE.setGravity(17);
        this.ifE.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.ifD.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.ifD.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.ifE.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.ifE.setTextSize(0, this.ifD.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ao.setBackgroundResource(this.ifE, R.drawable.bg_home_float);
        ao.setViewTextColor(this.ifE, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.ifD.bAm().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.ifE.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hHG = i;
        this.frk = i2;
        if (this.ifH < 0) {
            this.ifH = this.hHG;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hHG > 0 && this.frk > 0 && this.ifH >= 0 && this.hHG + this.frk + 1 < this.ifH) {
                this.ifC.sendEmptyMessage(111);
            }
            this.ifH = this.hHG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciF() {
        if (this.ifE.getParent() == null) {
            this.ifc.addView(this.ifE);
            this.ifE.clearAnimation();
            this.ifE.startAnimation(this.ifF);
            this.ifC.removeCallbacks(this.mHideRunnable);
            this.ifC.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciG() {
        if (this.ifE.getParent() != null) {
            this.hHG = -1;
            this.ifH = -1;
            this.ifC.removeCallbacks(this.mHideRunnable);
            this.ifE.clearAnimation();
            this.ifE.startAnimation(this.ifG);
        }
    }

    public void onDestory() {
        this.ifC.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundResource(this.ifE, R.drawable.bg_home_float);
        ao.setViewTextColor(this.ifE, R.color.cp_link_tip_a);
    }
}
