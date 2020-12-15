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
    private FrsFragment jwM;
    private TextView jwN;
    private NoPressedRelativeLayout jwl;
    private final Runnable mHideRunnable;
    private int iVe = -1;
    private int gpP = -1;
    private int jwO = -1;
    private final Handler jwL = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cHk();
                return true;
            }
            return false;
        }
    });
    private final Animation bNp = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bNq = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jwl = noPressedRelativeLayout;
        this.jwM = frsFragment;
        this.bNq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jwN.getParent() != null) {
                    ((ViewGroup) e.this.jwN.getParent()).removeView(e.this.jwN);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cHl();
            }
        };
        initView();
    }

    private void initView() {
        this.jwN = new TextView(TbadkCoreApplication.getInst());
        this.jwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cHl();
                if (e.this.jwM != null && !e.this.jwM.cCL() && e.this.jwM.cCf() != null) {
                    e.this.jwM.cCf().startPullRefresh();
                }
            }
        });
        this.jwN.setGravity(17);
        this.jwN.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jwM.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jwM.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jwN.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jwN.setTextSize(0, this.jwM.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jwN, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jwN, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jwM.bVL().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jwN.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.iVe = i;
        this.gpP = i2;
        if (this.jwO < 0) {
            this.jwO = this.iVe;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.iVe > 0 && this.gpP > 0 && this.jwO >= 0 && this.iVe + this.gpP + 1 < this.jwO) {
                this.jwL.sendEmptyMessage(111);
            }
            this.jwO = this.iVe;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHk() {
        if (this.jwN.getParent() == null) {
            this.jwl.addView(this.jwN);
            this.jwN.clearAnimation();
            this.jwN.startAnimation(this.bNp);
            this.jwL.removeCallbacks(this.mHideRunnable);
            this.jwL.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHl() {
        if (this.jwN.getParent() != null) {
            this.iVe = -1;
            this.jwO = -1;
            this.jwL.removeCallbacks(this.mHideRunnable);
            this.jwN.clearAnimation();
            this.jwN.startAnimation(this.bNq);
        }
    }

    public void onDestory() {
        this.jwL.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jwN, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jwN, R.color.CAM_X0302);
    }
}
