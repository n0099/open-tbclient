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
    private NoPressedRelativeLayout gLJ;
    private FrsFragment gMb;
    private TextView gMc;
    private final Runnable mHideRunnable;
    private int gqd = -1;
    private int eke = -1;
    private int gMf = -1;
    private final Handler gMa = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bKw();
                return true;
            }
            return false;
        }
    });
    private final Animation gMd = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation gMe = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gLJ = noPressedRelativeLayout;
        this.gMb = frsFragment;
        this.gMe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.gMc.getParent() != null) {
                    ((ViewGroup) e.this.gMc.getParent()).removeView(e.this.gMc);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bKx();
            }
        };
        initView();
    }

    private void initView() {
        this.gMc = new TextView(TbadkCoreApplication.getInst());
        this.gMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bKx();
                if (e.this.gMb != null && !e.this.gMb.bEr() && e.this.gMb.bDQ() != null) {
                    e.this.gMb.bDQ().startPullRefresh();
                }
            }
        });
        this.gMc.setGravity(17);
        this.gMc.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.gMb.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.gMb.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.gMc.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.gMc.setTextSize(0, this.gMb.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.gMc, R.drawable.bg_home_float);
        am.setViewTextColor(this.gMc, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.gMb.beM().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.gMc.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gqd = i;
        this.eke = i2;
        if (this.gMf < 0) {
            this.gMf = this.gqd;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gqd > 0 && this.eke > 0 && this.gMf >= 0 && this.gqd + this.eke + 1 < this.gMf) {
                this.gMa.sendEmptyMessage(111);
            }
            this.gMf = this.gqd;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKw() {
        if (this.gMc.getParent() == null) {
            this.gLJ.addView(this.gMc);
            this.gMc.clearAnimation();
            this.gMc.startAnimation(this.gMd);
            this.gMa.removeCallbacks(this.mHideRunnable);
            this.gMa.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKx() {
        if (this.gMc.getParent() != null) {
            this.gqd = -1;
            this.gMf = -1;
            this.gMa.removeCallbacks(this.mHideRunnable);
            this.gMc.clearAnimation();
            this.gMc.startAnimation(this.gMe);
        }
    }

    public void onDestory() {
        this.gMa.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.gMc, R.drawable.bg_home_float);
        am.setViewTextColor(this.gMc, (int) R.color.cp_link_tip_a);
    }
}
