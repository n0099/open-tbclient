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
/* loaded from: classes6.dex */
public class e implements n {
    private TextView gGA;
    private NoPressedRelativeLayout gGh;
    private FrsFragment gGz;
    private final Runnable mHideRunnable;
    private int gkE = -1;
    private int efC = -1;
    private int gGD = -1;
    private final Handler gGy = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bHP();
                return true;
            }
            return false;
        }
    });
    private final Animation gGB = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation gGC = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gGh = noPressedRelativeLayout;
        this.gGz = frsFragment;
        this.gGC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.gGA.getParent() != null) {
                    ((ViewGroup) e.this.gGA.getParent()).removeView(e.this.gGA);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bHQ();
            }
        };
        initView();
    }

    private void initView() {
        this.gGA = new TextView(TbadkCoreApplication.getInst());
        this.gGA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bHQ();
                if (e.this.gGz != null && !e.this.gGz.bBJ() && e.this.gGz.bBi() != null) {
                    e.this.gGz.bBi().startPullRefresh();
                }
            }
        });
        this.gGA.setGravity(17);
        this.gGA.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.gGz.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.gGz.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.gGA.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.gGA.setTextSize(0, this.gGz.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.gGA, R.drawable.bg_home_float);
        am.setViewTextColor(this.gGA, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.gGz.bcb().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.gGA.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gkE = i;
        this.efC = i2;
        if (this.gGD < 0) {
            this.gGD = this.gkE;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gkE > 0 && this.efC > 0 && this.gGD >= 0 && this.gkE + this.efC + 1 < this.gGD) {
                this.gGy.sendEmptyMessage(111);
            }
            this.gGD = this.gkE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        if (this.gGA.getParent() == null) {
            this.gGh.addView(this.gGA);
            this.gGA.clearAnimation();
            this.gGA.startAnimation(this.gGB);
            this.gGy.removeCallbacks(this.mHideRunnable);
            this.gGy.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHQ() {
        if (this.gGA.getParent() != null) {
            this.gkE = -1;
            this.gGD = -1;
            this.gGy.removeCallbacks(this.mHideRunnable);
            this.gGA.clearAnimation();
            this.gGA.startAnimation(this.gGC);
        }
    }

    public void onDestory() {
        this.gGy.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.gGA, R.drawable.bg_home_float);
        am.setViewTextColor(this.gGA, (int) R.color.cp_link_tip_a);
    }
}
