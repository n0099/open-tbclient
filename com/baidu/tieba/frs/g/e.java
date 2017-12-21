package com.baidu.tieba.frs.g;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private final Runnable cUY;
    private com.baidu.tieba.frs.g cXB;
    private TextView daL;
    private NoPressedRelativeLayout daq;
    private int cIt = -1;
    private int daO = 0;
    private int daP = -1;
    private final Handler daK = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aqO();
                return true;
            }
            return false;
        }
    });
    private final Animation daM = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation daN = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.daq = noPressedRelativeLayout;
        this.cXB = gVar;
        this.daN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.daL.getParent() != null) {
                    ((ViewGroup) e.this.daL.getParent()).removeView(e.this.daL);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cUY = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aqP();
            }
        };
        initView();
    }

    private void initView() {
        this.daL = new TextView(TbadkCoreApplication.getInst());
        this.daL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aqP();
                if (e.this.cXB != null && !e.this.cXB.alF() && e.this.cXB.aln() != null) {
                    e.this.cXB.aln().startPullRefresh();
                }
            }
        });
        this.daL.setGravity(17);
        this.daL.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cXB.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.cXB.getResources().getDimensionPixelSize(d.e.ds40);
        this.daL.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.daL.setTextSize(0, this.cXB.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.j(this.daL, d.f.bg_home_float);
        aj.i(this.daL, d.C0095d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cXB.alD().getBottom() + l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        this.daL.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cIt = i;
        this.daO = i2;
        if (this.daP < 0) {
            this.daP = this.cIt;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.cIt > 0 && this.daP >= 0 && this.cIt + this.daO < this.daP) {
                this.daK.sendEmptyMessage(111);
            }
            this.daP = this.cIt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqO() {
        if (this.daL.getParent() == null) {
            this.daq.addView(this.daL);
            this.daL.clearAnimation();
            this.daL.startAnimation(this.daM);
            this.daK.removeCallbacks(this.cUY);
            this.daK.postDelayed(this.cUY, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqP() {
        if (this.daL.getParent() != null) {
            this.cIt = -1;
            this.daP = -1;
            this.daK.removeCallbacks(this.cUY);
            this.daL.clearAnimation();
            this.daL.startAnimation(this.daN);
        }
    }

    public void onDestory() {
        this.daK.removeCallbacksAndMessages(null);
    }
}
