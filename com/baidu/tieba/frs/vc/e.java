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
/* loaded from: classes21.dex */
public class e implements q {
    private NoPressedRelativeLayout jiH;
    private FrsFragment jji;
    private TextView jjj;
    private final Runnable mHideRunnable;
    private int iKj = -1;
    private int ghD = -1;
    private int jjk = -1;
    private final Handler jjh = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cFl();
                return true;
            }
            return false;
        }
    });
    private final Animation bIh = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bIi = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jiH = noPressedRelativeLayout;
        this.jji = frsFragment;
        this.bIi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jjj.getParent() != null) {
                    ((ViewGroup) e.this.jjj.getParent()).removeView(e.this.jjj);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cFm();
            }
        };
        initView();
    }

    private void initView() {
        this.jjj = new TextView(TbadkCoreApplication.getInst());
        this.jjj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cFm();
                if (e.this.jji != null && !e.this.jji.cyt() && e.this.jji.cxO() != null) {
                    e.this.jji.cxO().startPullRefresh();
                }
            }
        });
        this.jjj.setGravity(17);
        this.jjj.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jji.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jji.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jjj.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jjj.setTextSize(0, this.jji.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jjj, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jjj, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jji.bSa().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jjj.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.iKj = i;
        this.ghD = i2;
        if (this.jjk < 0) {
            this.jjk = this.iKj;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.iKj > 0 && this.ghD > 0 && this.jjk >= 0 && this.iKj + this.ghD + 1 < this.jjk) {
                this.jjh.sendEmptyMessage(111);
            }
            this.jjk = this.iKj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFl() {
        if (this.jjj.getParent() == null) {
            this.jiH.addView(this.jjj);
            this.jjj.clearAnimation();
            this.jjj.startAnimation(this.bIh);
            this.jjh.removeCallbacks(this.mHideRunnable);
            this.jjh.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFm() {
        if (this.jjj.getParent() != null) {
            this.iKj = -1;
            this.jjk = -1;
            this.jjh.removeCallbacks(this.mHideRunnable);
            this.jjj.clearAnimation();
            this.jjj.startAnimation(this.bIi);
        }
    }

    public void onDestory() {
        this.jjh.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jjj, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jjj, R.color.CAM_X0302);
    }
}
