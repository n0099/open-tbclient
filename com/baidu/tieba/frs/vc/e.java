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
    private FrsFragment itJ;
    private TextView itK;
    private NoPressedRelativeLayout iti;
    private final Runnable mHideRunnable;
    private int hUW = -1;
    private int fCF = -1;
    private int itN = -1;
    private final Handler itI = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ctj();
                return true;
            }
            return false;
        }
    });
    private final Animation itL = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation itM = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.iti = noPressedRelativeLayout;
        this.itJ = frsFragment;
        this.itM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.itK.getParent() != null) {
                    ((ViewGroup) e.this.itK.getParent()).removeView(e.this.itK);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ctk();
            }
        };
        initView();
    }

    private void initView() {
        this.itK = new TextView(TbadkCoreApplication.getInst());
        this.itK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ctk();
                if (e.this.itJ != null && !e.this.itJ.cmx() && e.this.itJ.clS() != null) {
                    e.this.itJ.clS().startPullRefresh();
                }
            }
        });
        this.itK.setGravity(17);
        this.itK.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.itJ.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.itJ.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.itK.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.itK.setTextSize(0, this.itJ.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.itK, R.drawable.bg_home_float);
        ap.setViewTextColor(this.itK, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.itJ.bJH().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.itK.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hUW = i;
        this.fCF = i2;
        if (this.itN < 0) {
            this.itN = this.hUW;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hUW > 0 && this.fCF > 0 && this.itN >= 0 && this.hUW + this.fCF + 1 < this.itN) {
                this.itI.sendEmptyMessage(111);
            }
            this.itN = this.hUW;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctj() {
        if (this.itK.getParent() == null) {
            this.iti.addView(this.itK);
            this.itK.clearAnimation();
            this.itK.startAnimation(this.itL);
            this.itI.removeCallbacks(this.mHideRunnable);
            this.itI.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctk() {
        if (this.itK.getParent() != null) {
            this.hUW = -1;
            this.itN = -1;
            this.itI.removeCallbacks(this.mHideRunnable);
            this.itK.clearAnimation();
            this.itK.startAnimation(this.itM);
        }
    }

    public void onDestory() {
        this.itI.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.itK, R.drawable.bg_home_float);
        ap.setViewTextColor(this.itK, R.color.cp_link_tip_a);
    }
}
