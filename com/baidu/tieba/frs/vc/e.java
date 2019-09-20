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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class e {
    private FrsFragment fTI;
    private TextView fTJ;
    private NoPressedRelativeLayout fTr;
    private final Runnable mHideRunnable;
    private int fxK = -1;
    private int dof = -1;
    private int fTM = -1;
    private final Handler mHandelr = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bts();
                return true;
            }
            return false;
        }
    });
    private final Animation fTK = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fTL = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fTr = noPressedRelativeLayout;
        this.fTI = frsFragment;
        this.fTL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fTJ.getParent() != null) {
                    ((ViewGroup) e.this.fTJ.getParent()).removeView(e.this.fTJ);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.btt();
            }
        };
        initView();
    }

    private void initView() {
        this.fTJ = new TextView(TbadkCoreApplication.getInst());
        this.fTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.btt();
                if (e.this.fTI != null && !e.this.fTI.bnk() && e.this.fTI.bmJ() != null) {
                    e.this.fTI.bmJ().startPullRefresh();
                }
            }
        });
        this.fTJ.setGravity(17);
        this.fTJ.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fTI.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fTI.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fTJ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fTJ.setTextSize(0, this.fTI.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.k(this.fTJ, R.drawable.bg_home_float);
        am.j(this.fTJ, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fTI.aLN().getBottom() + l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fTJ.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fxK = i;
        this.dof = i2;
        if (this.fTM < 0) {
            this.fTM = this.fxK;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fxK > 0 && this.dof > 0 && this.fTM >= 0 && this.fxK + this.dof + 1 < this.fTM) {
                this.mHandelr.sendEmptyMessage(111);
            }
            this.fTM = this.fxK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bts() {
        if (this.fTJ.getParent() == null) {
            this.fTr.addView(this.fTJ);
            this.fTJ.clearAnimation();
            this.fTJ.startAnimation(this.fTK);
            this.mHandelr.removeCallbacks(this.mHideRunnable);
            this.mHandelr.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btt() {
        if (this.fTJ.getParent() != null) {
            this.fxK = -1;
            this.fTM = -1;
            this.mHandelr.removeCallbacks(this.mHideRunnable);
            this.fTJ.clearAnimation();
            this.fTJ.startAnimation(this.fTL);
        }
    }

    public void onDestory() {
        this.mHandelr.removeCallbacksAndMessages(null);
    }
}
