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
    private FrsFragment jwK;
    private TextView jwL;
    private NoPressedRelativeLayout jwj;
    private final Runnable mHideRunnable;
    private int iVc = -1;
    private int gpN = -1;
    private int jwM = -1;
    private final Handler jwJ = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cHj();
                return true;
            }
            return false;
        }
    });
    private final Animation bNp = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bNq = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jwj = noPressedRelativeLayout;
        this.jwK = frsFragment;
        this.bNq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jwL.getParent() != null) {
                    ((ViewGroup) e.this.jwL.getParent()).removeView(e.this.jwL);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cHk();
            }
        };
        initView();
    }

    private void initView() {
        this.jwL = new TextView(TbadkCoreApplication.getInst());
        this.jwL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cHk();
                if (e.this.jwK != null && !e.this.jwK.cCK() && e.this.jwK.cCe() != null) {
                    e.this.jwK.cCe().startPullRefresh();
                }
            }
        });
        this.jwL.setGravity(17);
        this.jwL.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jwK.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jwK.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jwL.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jwL.setTextSize(0, this.jwK.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jwL, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jwL, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jwK.bVK().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jwL.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.iVc = i;
        this.gpN = i2;
        if (this.jwM < 0) {
            this.jwM = this.iVc;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.iVc > 0 && this.gpN > 0 && this.jwM >= 0 && this.iVc + this.gpN + 1 < this.jwM) {
                this.jwJ.sendEmptyMessage(111);
            }
            this.jwM = this.iVc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHj() {
        if (this.jwL.getParent() == null) {
            this.jwj.addView(this.jwL);
            this.jwL.clearAnimation();
            this.jwL.startAnimation(this.bNp);
            this.jwJ.removeCallbacks(this.mHideRunnable);
            this.jwJ.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHk() {
        if (this.jwL.getParent() != null) {
            this.iVc = -1;
            this.jwM = -1;
            this.jwJ.removeCallbacks(this.mHideRunnable);
            this.jwL.clearAnimation();
            this.jwL.startAnimation(this.bNq);
        }
    }

    public void onDestory() {
        this.jwJ.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jwL, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jwL, R.color.CAM_X0302);
    }
}
