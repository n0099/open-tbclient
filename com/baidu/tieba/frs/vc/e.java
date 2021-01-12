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
    private FrsFragment jEB;
    private TextView jEC;
    private NoPressedRelativeLayout jEa;
    private final Runnable mHideRunnable;
    private int jcJ = -1;
    private int gwh = -1;
    private int jED = -1;
    private final Handler jEA = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cGs();
                return true;
            }
            return false;
        }
    });
    private final Animation bNq = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bNr = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jEa = noPressedRelativeLayout;
        this.jEB = frsFragment;
        this.bNr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jEC.getParent() != null) {
                    ((ViewGroup) e.this.jEC.getParent()).removeView(e.this.jEC);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cGt();
            }
        };
        initView();
    }

    private void initView() {
        this.jEC = new TextView(TbadkCoreApplication.getInst());
        this.jEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cGt();
                if (e.this.jEB != null && !e.this.jEB.cBO() && e.this.jEB.cBi() != null) {
                    e.this.jEB.cBi().startPullRefresh();
                }
            }
        });
        this.jEC.setGravity(17);
        this.jEC.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jEB.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jEB.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jEC.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jEC.setTextSize(0, this.jEB.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ao.setBackgroundResource(this.jEC, R.drawable.bg_home_float);
        ao.setViewTextColor(this.jEC, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jEB.bUz().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jEC.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.jcJ = i;
        this.gwh = i2;
        if (this.jED < 0) {
            this.jED = this.jcJ;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.jcJ > 0 && this.gwh > 0 && this.jED >= 0 && this.jcJ + this.gwh + 1 < this.jED) {
                this.jEA.sendEmptyMessage(111);
            }
            this.jED = this.jcJ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGs() {
        if (this.jEC.getParent() == null) {
            this.jEa.addView(this.jEC);
            this.jEC.clearAnimation();
            this.jEC.startAnimation(this.bNq);
            this.jEA.removeCallbacks(this.mHideRunnable);
            this.jEA.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGt() {
        if (this.jEC.getParent() != null) {
            this.jcJ = -1;
            this.jED = -1;
            this.jEA.removeCallbacks(this.mHideRunnable);
            this.jEC.clearAnimation();
            this.jEC.startAnimation(this.bNr);
        }
    }

    public void onDestory() {
        this.jEA.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundResource(this.jEC, R.drawable.bg_home_float);
        ao.setViewTextColor(this.jEC, R.color.CAM_X0302);
    }
}
