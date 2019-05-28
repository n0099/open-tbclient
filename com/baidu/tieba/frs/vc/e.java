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
    private NoPressedRelativeLayout fLM;
    private FrsFragment fMe;
    private TextView fMf;
    private final Runnable mHideRunnable;
    private int fqA = -1;
    private int dkD = -1;
    private int fMi = -1;
    private final Handler fMd = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bqp();
                return true;
            }
            return false;
        }
    });
    private final Animation fMg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fMh = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fLM = noPressedRelativeLayout;
        this.fMe = frsFragment;
        this.fMh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fMf.getParent() != null) {
                    ((ViewGroup) e.this.fMf.getParent()).removeView(e.this.fMf);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bqq();
            }
        };
        initView();
    }

    private void initView() {
        this.fMf = new TextView(TbadkCoreApplication.getInst());
        this.fMf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bqq();
                if (e.this.fMe != null && !e.this.fMe.bkn() && e.this.fMe.bjP() != null) {
                    e.this.fMe.bjP().startPullRefresh();
                }
            }
        });
        this.fMf.setGravity(17);
        this.fMf.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fMe.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fMe.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fMf.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fMf.setTextSize(0, this.fMe.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        al.k(this.fMf, R.drawable.bg_home_float);
        al.j(this.fMf, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fMe.aJC().getBottom() + l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fMf.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fqA = i;
        this.dkD = i2;
        if (this.fMi < 0) {
            this.fMi = this.fqA;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fqA > 0 && this.dkD > 0 && this.fMi >= 0 && this.fqA + this.dkD + 1 < this.fMi) {
                this.fMd.sendEmptyMessage(111);
            }
            this.fMi = this.fqA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqp() {
        if (this.fMf.getParent() == null) {
            this.fLM.addView(this.fMf);
            this.fMf.clearAnimation();
            this.fMf.startAnimation(this.fMg);
            this.fMd.removeCallbacks(this.mHideRunnable);
            this.fMd.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqq() {
        if (this.fMf.getParent() != null) {
            this.fqA = -1;
            this.fMi = -1;
            this.fMd.removeCallbacks(this.mHideRunnable);
            this.fMf.clearAnimation();
            this.fMf.startAnimation(this.fMh);
        }
    }

    public void onDestory() {
        this.fMd.removeCallbacksAndMessages(null);
    }
}
