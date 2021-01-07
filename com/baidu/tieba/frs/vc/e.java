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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e implements q {
    private NoPressedRelativeLayout jIG;
    private FrsFragment jJh;
    private TextView jJi;
    private final Runnable mHideRunnable;
    private int jhq = -1;
    private int gAO = -1;
    private int jJj = -1;
    private final Handler jJg = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cKk();
                return true;
            }
            return false;
        }
    });
    private final Animation bSc = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bSd = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jIG = noPressedRelativeLayout;
        this.jJh = frsFragment;
        this.bSd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jJi.getParent() != null) {
                    ((ViewGroup) e.this.jJi.getParent()).removeView(e.this.jJi);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cKl();
            }
        };
        initView();
    }

    private void initView() {
        this.jJi = new TextView(TbadkCoreApplication.getInst());
        this.jJi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cKl();
                if (e.this.jJh != null && !e.this.jJh.cFG() && e.this.jJh.cFa() != null) {
                    e.this.jJh.cFa().startPullRefresh();
                }
            }
        });
        this.jJi.setGravity(17);
        this.jJi.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jJh.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jJh.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jJi.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jJi.setTextSize(0, this.jJh.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ao.setBackgroundResource(this.jJi, R.drawable.bg_home_float);
        ao.setViewTextColor(this.jJi, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jJh.bYr().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jJi.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.jhq = i;
        this.gAO = i2;
        if (this.jJj < 0) {
            this.jJj = this.jhq;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.jhq > 0 && this.gAO > 0 && this.jJj >= 0 && this.jhq + this.gAO + 1 < this.jJj) {
                this.jJg.sendEmptyMessage(111);
            }
            this.jJj = this.jhq;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKk() {
        if (this.jJi.getParent() == null) {
            this.jIG.addView(this.jJi);
            this.jJi.clearAnimation();
            this.jJi.startAnimation(this.bSc);
            this.jJg.removeCallbacks(this.mHideRunnable);
            this.jJg.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKl() {
        if (this.jJi.getParent() != null) {
            this.jhq = -1;
            this.jJj = -1;
            this.jJg.removeCallbacks(this.mHideRunnable);
            this.jJi.clearAnimation();
            this.jJi.startAnimation(this.bSd);
        }
    }

    public void onDestory() {
        this.jJg.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundResource(this.jJi, R.drawable.bg_home_float);
        ao.setViewTextColor(this.jJi, R.color.CAM_X0302);
    }
}
