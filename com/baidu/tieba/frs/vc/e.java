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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes6.dex */
public class e {
    private TextView egA;
    private NoPressedRelativeLayout egh;
    private FrsFragment egz;
    private final Runnable mHideRunnable;
    private int dMT = -1;
    private int bNQ = -1;
    private int egD = -1;
    private final Handler egy = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aIp();
                return true;
            }
            return false;
        }
    });
    private final Animation egB = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation egC = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.egh = noPressedRelativeLayout;
        this.egz = frsFragment;
        this.egC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.egA.getParent() != null) {
                    ((ViewGroup) e.this.egA.getParent()).removeView(e.this.egA);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aIq();
            }
        };
        initView();
    }

    private void initView() {
        this.egA = new TextView(TbadkCoreApplication.getInst());
        this.egA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aIq();
                if (e.this.egz != null && !e.this.egz.aCm() && e.this.egz.aBU() != null) {
                    e.this.egz.aBU().startPullRefresh();
                }
            }
        });
        this.egA.setGravity(17);
        this.egA.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.egz.getResources().getDimensionPixelSize(e.C0210e.ds20);
        int dimensionPixelSize2 = this.egz.getResources().getDimensionPixelSize(e.C0210e.ds40);
        this.egA.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.egA.setTextSize(0, this.egz.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.i(this.egA, e.f.bg_home_float);
        al.h(this.egA, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.egz.act().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0210e.ds8);
        this.egA.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dMT = i;
        this.bNQ = i2;
        if (this.egD < 0) {
            this.egD = this.dMT;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dMT > 0 && this.bNQ > 0 && this.egD >= 0 && this.dMT + this.bNQ + 1 < this.egD) {
                this.egy.sendEmptyMessage(111);
            }
            this.egD = this.dMT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        if (this.egA.getParent() == null) {
            this.egh.addView(this.egA);
            this.egA.clearAnimation();
            this.egA.startAnimation(this.egB);
            this.egy.removeCallbacks(this.mHideRunnable);
            this.egy.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIq() {
        if (this.egA.getParent() != null) {
            this.dMT = -1;
            this.egD = -1;
            this.egy.removeCallbacks(this.mHideRunnable);
            this.egA.clearAnimation();
            this.egA.startAnimation(this.egC);
        }
    }

    public void onDestory() {
        this.egy.removeCallbacksAndMessages(null);
    }
}
