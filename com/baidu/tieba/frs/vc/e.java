package com.baidu.tieba.frs.vc;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e implements q {
    private NoPressedRelativeLayout jLB;
    private FrsFragment jMc;
    private TextView jMd;
    private final Runnable mHideRunnable;
    private int jkn = -1;
    private int gAO = -1;
    private int jMe = -1;
    private final Handler jMb = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cHS();
                return true;
            }
            return false;
        }
    });
    private final Animation bSG = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bSH = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jLB = noPressedRelativeLayout;
        this.jMc = frsFragment;
        this.bSH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jMd.getParent() != null) {
                    ((ViewGroup) e.this.jMd.getParent()).removeView(e.this.jMd);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cHT();
            }
        };
        initView();
    }

    private void initView() {
        this.jMd = new TextView(TbadkCoreApplication.getInst());
        this.jMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cHT();
                if (e.this.jMc != null && !e.this.jMc.cDn() && e.this.jMc.cCH() != null) {
                    e.this.jMc.cCH().startPullRefresh();
                }
            }
        });
        this.jMd.setGravity(17);
        this.jMd.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jMc.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jMc.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jMd.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jMd.setTextSize(0, this.jMc.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jMd, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jMd, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jMc.bVq().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jMd.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.jkn = i;
        this.gAO = i2;
        if (this.jMe < 0) {
            this.jMe = this.jkn;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.jkn > 0 && this.gAO > 0 && this.jMe >= 0 && this.jkn + this.gAO + 1 < this.jMe) {
                this.jMb.sendEmptyMessage(111);
            }
            this.jMe = this.jkn;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHS() {
        if (this.jMd.getParent() == null) {
            this.jLB.addView(this.jMd);
            this.jMd.clearAnimation();
            this.jMd.startAnimation(this.bSG);
            this.jMb.removeCallbacks(this.mHideRunnable);
            this.jMb.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHT() {
        if (this.jMd.getParent() != null) {
            this.jkn = -1;
            this.jMe = -1;
            this.jMb.removeCallbacks(this.mHideRunnable);
            this.jMd.clearAnimation();
            this.jMd.startAnimation(this.bSH);
        }
    }

    public void onDestory() {
        this.jMb.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jMd, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jMd, R.color.CAM_X0302);
    }
}
