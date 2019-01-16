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
    private NoPressedRelativeLayout egg;
    private FrsFragment egy;
    private TextView egz;
    private final Runnable mHideRunnable;
    private int dMS = -1;
    private int bNP = -1;
    private int egC = -1;
    private final Handler egx = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aIp();
                return true;
            }
            return false;
        }
    });
    private final Animation egA = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_in);
    private final Animation egB = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), e.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.egg = noPressedRelativeLayout;
        this.egy = frsFragment;
        this.egB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.egz.getParent() != null) {
                    ((ViewGroup) e.this.egz.getParent()).removeView(e.this.egz);
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
        this.egz = new TextView(TbadkCoreApplication.getInst());
        this.egz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aIq();
                if (e.this.egy != null && !e.this.egy.aCm() && e.this.egy.aBU() != null) {
                    e.this.egy.aBU().startPullRefresh();
                }
            }
        });
        this.egz.setGravity(17);
        this.egz.setText(e.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.egy.getResources().getDimensionPixelSize(e.C0210e.ds20);
        int dimensionPixelSize2 = this.egy.getResources().getDimensionPixelSize(e.C0210e.ds40);
        this.egz.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.egz.setTextSize(0, this.egy.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.i(this.egz, e.f.bg_home_float);
        al.h(this.egz, e.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.egy.act().getBottom() + l.h(TbadkCoreApplication.getInst(), e.C0210e.ds8);
        this.egz.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dMS = i;
        this.bNP = i2;
        if (this.egC < 0) {
            this.egC = this.dMS;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dMS > 0 && this.bNP > 0 && this.egC >= 0 && this.dMS + this.bNP + 1 < this.egC) {
                this.egx.sendEmptyMessage(111);
            }
            this.egC = this.dMS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        if (this.egz.getParent() == null) {
            this.egg.addView(this.egz);
            this.egz.clearAnimation();
            this.egz.startAnimation(this.egA);
            this.egx.removeCallbacks(this.mHideRunnable);
            this.egx.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIq() {
        if (this.egz.getParent() != null) {
            this.dMS = -1;
            this.egC = -1;
            this.egx.removeCallbacks(this.mHideRunnable);
            this.egz.clearAnimation();
            this.egz.startAnimation(this.egB);
        }
    }

    public void onDestory() {
        this.egx.removeCallbacksAndMessages(null);
    }
}
