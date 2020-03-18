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
    private NoPressedRelativeLayout gMO;
    private FrsFragment gNg;
    private TextView gNh;
    private final Runnable mHideRunnable;
    private int gqN = -1;
    private int eku = -1;
    private int gNk = -1;
    private final Handler gNf = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bKJ();
                return true;
            }
            return false;
        }
    });
    private final Animation gNi = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation gNj = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gMO = noPressedRelativeLayout;
        this.gNg = frsFragment;
        this.gNj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.gNh.getParent() != null) {
                    ((ViewGroup) e.this.gNh.getParent()).removeView(e.this.gNh);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bKK();
            }
        };
        initView();
    }

    private void initView() {
        this.gNh = new TextView(TbadkCoreApplication.getInst());
        this.gNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bKK();
                if (e.this.gNg != null && !e.this.gNg.bEA() && e.this.gNg.bDY() != null) {
                    e.this.gNg.bDY().startPullRefresh();
                }
            }
        });
        this.gNh.setGravity(17);
        this.gNh.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.gNg.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.gNg.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.gNh.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.gNh.setTextSize(0, this.gNg.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.gNh, R.drawable.bg_home_float);
        am.setViewTextColor(this.gNh, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.gNg.beR().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.gNh.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gqN = i;
        this.eku = i2;
        if (this.gNk < 0) {
            this.gNk = this.gqN;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gqN > 0 && this.eku > 0 && this.gNk >= 0 && this.gqN + this.eku + 1 < this.gNk) {
                this.gNf.sendEmptyMessage(111);
            }
            this.gNk = this.gqN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKJ() {
        if (this.gNh.getParent() == null) {
            this.gMO.addView(this.gNh);
            this.gNh.clearAnimation();
            this.gNh.startAnimation(this.gNi);
            this.gNf.removeCallbacks(this.mHideRunnable);
            this.gNf.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKK() {
        if (this.gNh.getParent() != null) {
            this.gqN = -1;
            this.gNk = -1;
            this.gNf.removeCallbacks(this.mHideRunnable);
            this.gNh.clearAnimation();
            this.gNh.startAnimation(this.gNj);
        }
    }

    public void onDestory() {
        this.gNf.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.gNh, R.drawable.bg_home_float);
        am.setViewTextColor(this.gNh, (int) R.color.cp_link_tip_a);
    }
}
