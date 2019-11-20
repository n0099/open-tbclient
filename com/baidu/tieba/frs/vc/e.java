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
    private NoPressedRelativeLayout fRT;
    private FrsFragment fSl;
    private TextView fSm;
    private final Runnable mHideRunnable;
    private int fwh = -1;
    private int duA = -1;
    private int fSp = -1;
    private final Handler fSk = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bqt();
                return true;
            }
            return false;
        }
    });
    private final Animation fSn = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fSo = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fRT = noPressedRelativeLayout;
        this.fSl = frsFragment;
        this.fSo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fSm.getParent() != null) {
                    ((ViewGroup) e.this.fSm.getParent()).removeView(e.this.fSm);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bqu();
            }
        };
        initView();
    }

    private void initView() {
        this.fSm = new TextView(TbadkCoreApplication.getInst());
        this.fSm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bqu();
                if (e.this.fSl != null && !e.this.fSl.bko() && e.this.fSl.bjN() != null) {
                    e.this.fSl.bjN().startPullRefresh();
                }
            }
        });
        this.fSm.setGravity(17);
        this.fSm.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fSl.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fSl.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fSm.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fSm.setTextSize(0, this.fSl.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.fSm, R.drawable.bg_home_float);
        am.setViewTextColor(this.fSm, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fSl.aKP().getBottom() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fSm.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fwh = i;
        this.duA = i2;
        if (this.fSp < 0) {
            this.fSp = this.fwh;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fwh > 0 && this.duA > 0 && this.fSp >= 0 && this.fwh + this.duA + 1 < this.fSp) {
                this.fSk.sendEmptyMessage(111);
            }
            this.fSp = this.fwh;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqt() {
        if (this.fSm.getParent() == null) {
            this.fRT.addView(this.fSm);
            this.fSm.clearAnimation();
            this.fSm.startAnimation(this.fSn);
            this.fSk.removeCallbacks(this.mHideRunnable);
            this.fSk.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqu() {
        if (this.fSm.getParent() != null) {
            this.fwh = -1;
            this.fSp = -1;
            this.fSk.removeCallbacks(this.mHideRunnable);
            this.fSm.clearAnimation();
            this.fSm.startAnimation(this.fSo);
        }
    }

    public void onDestory() {
        this.fSk.removeCallbacksAndMessages(null);
    }
}
