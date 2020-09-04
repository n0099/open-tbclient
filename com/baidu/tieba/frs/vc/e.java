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
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes16.dex */
public class e implements p {
    private FrsFragment itP;
    private TextView itQ;
    private NoPressedRelativeLayout ito;
    private final Runnable mHideRunnable;
    private int hVc = -1;
    private int fCJ = -1;
    private int itT = -1;
    private final Handler itO = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ctk();
                return true;
            }
            return false;
        }
    });
    private final Animation itR = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation itS = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ito = noPressedRelativeLayout;
        this.itP = frsFragment;
        this.itS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.itQ.getParent() != null) {
                    ((ViewGroup) e.this.itQ.getParent()).removeView(e.this.itQ);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ctl();
            }
        };
        initView();
    }

    private void initView() {
        this.itQ = new TextView(TbadkCoreApplication.getInst());
        this.itQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ctl();
                if (e.this.itP != null && !e.this.itP.cmy() && e.this.itP.clT() != null) {
                    e.this.itP.clT().startPullRefresh();
                }
            }
        });
        this.itQ.setGravity(17);
        this.itQ.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.itP.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.itP.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.itQ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.itQ.setTextSize(0, this.itP.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.itQ, R.drawable.bg_home_float);
        ap.setViewTextColor(this.itQ, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.itP.bJI().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.itQ.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hVc = i;
        this.fCJ = i2;
        if (this.itT < 0) {
            this.itT = this.hVc;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hVc > 0 && this.fCJ > 0 && this.itT >= 0 && this.hVc + this.fCJ + 1 < this.itT) {
                this.itO.sendEmptyMessage(111);
            }
            this.itT = this.hVc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctk() {
        if (this.itQ.getParent() == null) {
            this.ito.addView(this.itQ);
            this.itQ.clearAnimation();
            this.itQ.startAnimation(this.itR);
            this.itO.removeCallbacks(this.mHideRunnable);
            this.itO.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctl() {
        if (this.itQ.getParent() != null) {
            this.hVc = -1;
            this.itT = -1;
            this.itO.removeCallbacks(this.mHideRunnable);
            this.itQ.clearAnimation();
            this.itQ.startAnimation(this.itS);
        }
    }

    public void onDestory() {
        this.itO.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.itQ, R.drawable.bg_home_float);
        ap.setViewTextColor(this.itQ, R.color.cp_link_tip_a);
    }
}
