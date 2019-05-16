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
    private NoPressedRelativeLayout fLL;
    private FrsFragment fMd;
    private TextView fMe;
    private final Runnable mHideRunnable;
    private int fqz = -1;
    private int dkC = -1;
    private int fMh = -1;
    private final Handler fMc = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bqm();
                return true;
            }
            return false;
        }
    });
    private final Animation fMf = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fMg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fLL = noPressedRelativeLayout;
        this.fMd = frsFragment;
        this.fMg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fMe.getParent() != null) {
                    ((ViewGroup) e.this.fMe.getParent()).removeView(e.this.fMe);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bqn();
            }
        };
        initView();
    }

    private void initView() {
        this.fMe = new TextView(TbadkCoreApplication.getInst());
        this.fMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bqn();
                if (e.this.fMd != null && !e.this.fMd.bkk() && e.this.fMd.bjM() != null) {
                    e.this.fMd.bjM().startPullRefresh();
                }
            }
        });
        this.fMe.setGravity(17);
        this.fMe.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fMd.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fMd.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fMe.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fMe.setTextSize(0, this.fMd.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        al.k(this.fMe, R.drawable.bg_home_float);
        al.j(this.fMe, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fMd.aJz().getBottom() + l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fMe.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fqz = i;
        this.dkC = i2;
        if (this.fMh < 0) {
            this.fMh = this.fqz;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fqz > 0 && this.dkC > 0 && this.fMh >= 0 && this.fqz + this.dkC + 1 < this.fMh) {
                this.fMc.sendEmptyMessage(111);
            }
            this.fMh = this.fqz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqm() {
        if (this.fMe.getParent() == null) {
            this.fLL.addView(this.fMe);
            this.fMe.clearAnimation();
            this.fMe.startAnimation(this.fMf);
            this.fMc.removeCallbacks(this.mHideRunnable);
            this.fMc.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqn() {
        if (this.fMe.getParent() != null) {
            this.fqz = -1;
            this.fMh = -1;
            this.fMc.removeCallbacks(this.mHideRunnable);
            this.fMe.clearAnimation();
            this.fMe.startAnimation(this.fMg);
        }
    }

    public void onDestory() {
        this.fMc.removeCallbacksAndMessages(null);
    }
}
