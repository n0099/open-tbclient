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
    private NoPressedRelativeLayout jJE;
    private FrsFragment jKf;
    private TextView jKg;
    private final Runnable mHideRunnable;
    private int jiq = -1;
    private int gyR = -1;
    private int jKh = -1;
    private final Handler jKe = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cHF();
                return true;
            }
            return false;
        }
    });
    private final Animation bRg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bRh = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jJE = noPressedRelativeLayout;
        this.jKf = frsFragment;
        this.bRh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jKg.getParent() != null) {
                    ((ViewGroup) e.this.jKg.getParent()).removeView(e.this.jKg);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cHG();
            }
        };
        initView();
    }

    private void initView() {
        this.jKg = new TextView(TbadkCoreApplication.getInst());
        this.jKg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cHG();
                if (e.this.jKf != null && !e.this.jKf.cDa() && e.this.jKf.cCu() != null) {
                    e.this.jKf.cCu().startPullRefresh();
                }
            }
        });
        this.jKg.setGravity(17);
        this.jKg.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jKf.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jKf.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jKg.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jKg.setTextSize(0, this.jKf.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jKg, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jKg, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jKf.bVd().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jKg.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.jiq = i;
        this.gyR = i2;
        if (this.jKh < 0) {
            this.jKh = this.jiq;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.jiq > 0 && this.gyR > 0 && this.jKh >= 0 && this.jiq + this.gyR + 1 < this.jKh) {
                this.jKe.sendEmptyMessage(111);
            }
            this.jKh = this.jiq;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHF() {
        if (this.jKg.getParent() == null) {
            this.jJE.addView(this.jKg);
            this.jKg.clearAnimation();
            this.jKg.startAnimation(this.bRg);
            this.jKe.removeCallbacks(this.mHideRunnable);
            this.jKe.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHG() {
        if (this.jKg.getParent() != null) {
            this.jiq = -1;
            this.jKh = -1;
            this.jKe.removeCallbacks(this.mHideRunnable);
            this.jKg.clearAnimation();
            this.jKg.startAnimation(this.bRh);
        }
    }

    public void onDestory() {
        this.jKe.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jKg, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jKg, R.color.CAM_X0302);
    }
}
