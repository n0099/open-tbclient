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
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes22.dex */
public class e implements q {
    private NoPressedRelativeLayout jhV;
    private FrsFragment jix;
    private TextView jiy;
    private final Runnable mHideRunnable;
    private int iJw = -1;
    private int ghW = -1;
    private int jiz = -1;
    private final Handler jiw = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cFG();
                return true;
            }
            return false;
        }
    });
    private final Animation bJS = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bJT = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jhV = noPressedRelativeLayout;
        this.jix = frsFragment;
        this.bJT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jiy.getParent() != null) {
                    ((ViewGroup) e.this.jiy.getParent()).removeView(e.this.jiy);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cFH();
            }
        };
        initView();
    }

    private void initView() {
        this.jiy = new TextView(TbadkCoreApplication.getInst());
        this.jiy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cFH();
                if (e.this.jix != null && !e.this.jix.cyQ() && e.this.jix.cyl() != null) {
                    e.this.jix.cyl().startPullRefresh();
                }
            }
        });
        this.jiy.setGravity(17);
        this.jiy.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jix.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jix.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jiy.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jiy.setTextSize(0, this.jix.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jiy, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jiy, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jix.bSH().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jiy.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.iJw = i;
        this.ghW = i2;
        if (this.jiz < 0) {
            this.jiz = this.iJw;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.iJw > 0 && this.ghW > 0 && this.jiz >= 0 && this.iJw + this.ghW + 1 < this.jiz) {
                this.jiw.sendEmptyMessage(111);
            }
            this.jiz = this.iJw;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFG() {
        if (this.jiy.getParent() == null) {
            this.jhV.addView(this.jiy);
            this.jiy.clearAnimation();
            this.jiy.startAnimation(this.bJS);
            this.jiw.removeCallbacks(this.mHideRunnable);
            this.jiw.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFH() {
        if (this.jiy.getParent() != null) {
            this.iJw = -1;
            this.jiz = -1;
            this.jiw.removeCallbacks(this.mHideRunnable);
            this.jiy.clearAnimation();
            this.jiy.startAnimation(this.bJT);
        }
    }

    public void onDestory() {
        this.jiw.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jiy, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jiy, R.color.cp_link_tip_a);
    }
}
