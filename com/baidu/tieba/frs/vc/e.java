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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes9.dex */
public class e implements com.baidu.card.n {
    private FrsFragment hwP;
    private TextView hwQ;
    private NoPressedRelativeLayout hwo;
    private final Runnable mHideRunnable;
    private int hac = -1;
    private int eNZ = -1;
    private int hwT = -1;
    private final Handler hwO = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bVh();
                return true;
            }
            return false;
        }
    });
    private final Animation hwR = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation hwS = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hwo = noPressedRelativeLayout;
        this.hwP = frsFragment;
        this.hwS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.hwQ.getParent() != null) {
                    ((ViewGroup) e.this.hwQ.getParent()).removeView(e.this.hwQ);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bVi();
            }
        };
        initView();
    }

    private void initView() {
        this.hwQ = new TextView(TbadkCoreApplication.getInst());
        this.hwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bVi();
                if (e.this.hwP != null && !e.this.hwP.bOX() && e.this.hwP.bOv() != null) {
                    e.this.hwP.bOv().startPullRefresh();
                }
            }
        });
        this.hwQ.setGravity(17);
        this.hwQ.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.hwP.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.hwP.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.hwQ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.hwQ.setTextSize(0, this.hwP.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.hwQ, R.drawable.bg_home_float);
        am.setViewTextColor(this.hwQ, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.hwP.bof().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.hwQ.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.hac = i;
        this.eNZ = i2;
        if (this.hwT < 0) {
            this.hwT = this.hac;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.hac > 0 && this.eNZ > 0 && this.hwT >= 0 && this.hac + this.eNZ + 1 < this.hwT) {
                this.hwO.sendEmptyMessage(111);
            }
            this.hwT = this.hac;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        if (this.hwQ.getParent() == null) {
            this.hwo.addView(this.hwQ);
            this.hwQ.clearAnimation();
            this.hwQ.startAnimation(this.hwR);
            this.hwO.removeCallbacks(this.mHideRunnable);
            this.hwO.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVi() {
        if (this.hwQ.getParent() != null) {
            this.hac = -1;
            this.hwT = -1;
            this.hwO.removeCallbacks(this.mHideRunnable);
            this.hwQ.clearAnimation();
            this.hwQ.startAnimation(this.hwS);
        }
    }

    public void onDestory() {
        this.hwO.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.hwQ, R.drawable.bg_home_float);
        am.setViewTextColor(this.hwQ, (int) R.color.cp_link_tip_a);
    }
}
