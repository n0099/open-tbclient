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
    private NoPressedRelativeLayout fQM;
    private FrsFragment fRd;
    private TextView fRe;
    private final Runnable mHideRunnable;
    private int fvy = -1;
    private int dml = -1;
    private int fRh = -1;
    private final Handler mHandelr = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bss();
                return true;
            }
            return false;
        }
    });
    private final Animation fRf = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation fRg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.fQM = noPressedRelativeLayout;
        this.fRd = frsFragment;
        this.fRg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.fRe.getParent() != null) {
                    ((ViewGroup) e.this.fRe.getParent()).removeView(e.this.fRe);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bst();
            }
        };
        initView();
    }

    private void initView() {
        this.fRe = new TextView(TbadkCoreApplication.getInst());
        this.fRe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bst();
                if (e.this.fRd != null && !e.this.fRd.bmp() && e.this.fRd.blR() != null) {
                    e.this.fRd.blR().startPullRefresh();
                }
            }
        });
        this.fRe.setGravity(17);
        this.fRe.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.fRd.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.fRd.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.fRe.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.fRe.setTextSize(0, this.fRd.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.k(this.fRe, R.drawable.bg_home_float);
        am.j(this.fRe, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.fRd.aLh().getBottom() + l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.fRe.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.fvy = i;
        this.dml = i2;
        if (this.fRh < 0) {
            this.fRh = this.fvy;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.fvy > 0 && this.dml > 0 && this.fRh >= 0 && this.fvy + this.dml + 1 < this.fRh) {
                this.mHandelr.sendEmptyMessage(111);
            }
            this.fRh = this.fvy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bss() {
        if (this.fRe.getParent() == null) {
            this.fQM.addView(this.fRe);
            this.fRe.clearAnimation();
            this.fRe.startAnimation(this.fRf);
            this.mHandelr.removeCallbacks(this.mHideRunnable);
            this.mHandelr.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bst() {
        if (this.fRe.getParent() != null) {
            this.fvy = -1;
            this.fRh = -1;
            this.mHandelr.removeCallbacks(this.mHideRunnable);
            this.fRe.clearAnimation();
            this.fRe.startAnimation(this.fRg);
        }
    }

    public void onDestory() {
        this.mHandelr.removeCallbacksAndMessages(null);
    }
}
