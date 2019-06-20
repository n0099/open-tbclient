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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class e {
    private NoPressedRelativeLayout fLO;
    private FrsFragment fMg;
    private TextView fMh;
    private final Runnable mHideRunnable;
    private int fqA = -1;
    private int dkD = -1;
    private int fMk = -1;
    private final Handler fMf = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bqr();
                return true;
            }
            return false;
        }
    });
    private final Animation fMi = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fMj = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fLO = noPressedRelativeLayout;
        this.fMg = frsFragment;
        this.fMj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fMh.getParent() != null) {
                    ((ViewGroup) e.this.fMh.getParent()).removeView(e.this.fMh);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bqs();
            }
        };
        initView();
    }

    private void initView() {
        this.fMh = new TextView(TbadkCoreApplication.getInst());
        this.fMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bqs();
                if (e.this.fMg != null && !e.this.fMg.bkn() && e.this.fMg.bjP() != null) {
                    e.this.fMg.bjP().startPullRefresh();
                }
            }
        });
        this.fMh.setGravity(17);
        this.fMh.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fMg.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fMg.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fMh.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fMh.setTextSize(0, this.fMg.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        al.k(this.fMh, R.drawable.bg_home_float);
        al.j(this.fMh, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fMg.aJC().getBottom() + l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fMh.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fqA = i;
        this.dkD = i2;
        if (this.fMk < 0) {
            this.fMk = this.fqA;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fqA > 0 && this.dkD > 0 && this.fMk >= 0 && this.fqA + this.dkD + 1 < this.fMk) {
                this.fMf.sendEmptyMessage(111);
            }
            this.fMk = this.fqA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqr() {
        if (this.fMh.getParent() == null) {
            this.fLO.addView(this.fMh);
            this.fMh.clearAnimation();
            this.fMh.startAnimation(this.fMi);
            this.fMf.removeCallbacks(this.mHideRunnable);
            this.fMf.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqs() {
        if (this.fMh.getParent() != null) {
            this.fqA = -1;
            this.fMk = -1;
            this.fMf.removeCallbacks(this.mHideRunnable);
            this.fMh.clearAnimation();
            this.fMh.startAnimation(this.fMj);
        }
    }

    public void onDestory() {
        this.fMf.removeCallbacksAndMessages(null);
    }
}
