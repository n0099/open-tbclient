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
import com.baidu.card.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes7.dex */
public class e implements n {
    private FrsFragment gJO;
    private TextView gJP;
    private NoPressedRelativeLayout gJw;
    private final Runnable mHideRunnable;
    private int gnN = -1;
    private int efM = -1;
    private int gJS = -1;
    private final Handler gJN = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bIR();
                return true;
            }
            return false;
        }
    });
    private final Animation gJQ = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation gJR = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.gJw = noPressedRelativeLayout;
        this.gJO = frsFragment;
        this.gJR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.gJP.getParent() != null) {
                    ((ViewGroup) e.this.gJP.getParent()).removeView(e.this.gJP);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bIS();
            }
        };
        initView();
    }

    private void initView() {
        this.gJP = new TextView(TbadkCoreApplication.getInst());
        this.gJP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bIS();
                if (e.this.gJO != null && !e.this.gJO.bCL() && e.this.gJO.bCk() != null) {
                    e.this.gJO.bCk().startPullRefresh();
                }
            }
        });
        this.gJP.setGravity(17);
        this.gJP.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.gJO.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.gJO.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.gJP.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.gJP.setTextSize(0, this.gJO.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.gJP, R.drawable.bg_home_float);
        am.setViewTextColor(this.gJP, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.gJO.bcw().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.gJP.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gnN = i;
        this.efM = i2;
        if (this.gJS < 0) {
            this.gJS = this.gnN;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gnN > 0 && this.efM > 0 && this.gJS >= 0 && this.gnN + this.efM + 1 < this.gJS) {
                this.gJN.sendEmptyMessage(111);
            }
            this.gJS = this.gnN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIR() {
        if (this.gJP.getParent() == null) {
            this.gJw.addView(this.gJP);
            this.gJP.clearAnimation();
            this.gJP.startAnimation(this.gJQ);
            this.gJN.removeCallbacks(this.mHideRunnable);
            this.gJN.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIS() {
        if (this.gJP.getParent() != null) {
            this.gnN = -1;
            this.gJS = -1;
            this.gJN.removeCallbacks(this.mHideRunnable);
            this.gJP.clearAnimation();
            this.gJP.startAnimation(this.gJR);
        }
    }

    public void onDestory() {
        this.gJN.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.gJP, R.drawable.bg_home_float);
        am.setViewTextColor(this.gJP, (int) R.color.cp_link_tip_a);
    }
}
