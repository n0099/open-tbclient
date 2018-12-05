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
    private NoPressedRelativeLayout ecJ;
    private FrsFragment edb;
    private TextView edc;
    private final Runnable mHideRunnable;
    private int dJv = -1;
    private int bNa = -1;
    private int edf = -1;
    private final Handler eda = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aHd();
                return true;
            }
            return false;
        }
    });
    private final Animation edd = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation ede = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.ecJ = noPressedRelativeLayout;
        this.edb = frsFragment;
        this.ede.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.edc.getParent() != null) {
                    ((ViewGroup) e.this.edc.getParent()).removeView(e.this.edc);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aHe();
            }
        };
        initView();
    }

    private void initView() {
        this.edc = new TextView(TbadkCoreApplication.getInst());
        this.edc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aHe();
                if (e.this.edb != null && !e.this.edb.aBa() && e.this.edb.aAI() != null) {
                    e.this.edb.aAI().startPullRefresh();
                }
            }
        });
        this.edc.setGravity(17);
        this.edc.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.edb.getResources().getDimensionPixelSize(e.C0210e.ds20);
        int dimensionPixelSize2 = this.edb.getResources().getDimensionPixelSize(e.C0210e.ds40);
        this.edc.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.edc.setTextSize(0, this.edb.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.i(this.edc, e.f.bg_home_float);
        al.h(this.edc, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.edb.abU().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0210e.ds8);
        this.edc.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dJv = i;
        this.bNa = i2;
        if (this.edf < 0) {
            this.edf = this.dJv;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dJv > 0 && this.bNa > 0 && this.edf >= 0 && this.dJv + this.bNa + 1 < this.edf) {
                this.eda.sendEmptyMessage(111);
            }
            this.edf = this.dJv;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHd() {
        if (this.edc.getParent() == null) {
            this.ecJ.addView(this.edc);
            this.edc.clearAnimation();
            this.edc.startAnimation(this.edd);
            this.eda.removeCallbacks(this.mHideRunnable);
            this.eda.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHe() {
        if (this.edc.getParent() != null) {
            this.dJv = -1;
            this.edf = -1;
            this.eda.removeCallbacks(this.mHideRunnable);
            this.edc.clearAnimation();
            this.edc.startAnimation(this.ede);
        }
    }

    public void onDestory() {
        this.eda.removeCallbacksAndMessages(null);
    }
}
