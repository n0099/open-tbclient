package com.baidu.tieba.frs.h;

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
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tieba.frs.f cEq;
    private TextView cHM;
    private final Runnable cHN;
    private NoPressedRelativeLayout cHt;
    private int crn = -1;
    private int cHO = 0;
    private int cHP = -1;
    private final Handler cHL = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.h.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.alL();
                return true;
            }
            return false;
        }
    });
    private final Animation bTB = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation bTC = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cHt = noPressedRelativeLayout;
        this.cEq = fVar;
        this.bTC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.h.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cHM.getParent() != null) {
                    ((ViewGroup) e.this.cHM.getParent()).removeView(e.this.cHM);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cHN = new Runnable() { // from class: com.baidu.tieba.frs.h.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.alM();
            }
        };
        initView();
    }

    private void initView() {
        this.cHM = new TextView(TbadkCoreApplication.getInst());
        this.cHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.alM();
                if (e.this.cEq != null && !e.this.cEq.ahg() && e.this.cEq.agP() != null) {
                    e.this.cEq.agP().startPullRefresh();
                }
            }
        });
        this.cHM.setGravity(17);
        this.cHM.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cEq.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.cEq.getResources().getDimensionPixelSize(d.f.ds40);
        this.cHM.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cHM.setTextSize(0, this.cEq.getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.j(this.cHM, d.g.bg_home_float);
        aj.i(this.cHM, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cEq.ahe().getBottom() + l.f(TbadkCoreApplication.getInst(), d.f.ds8);
        this.cHM.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.crn = i;
        this.cHO = i2;
        if (this.cHP < 0) {
            this.cHP = this.crn;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.crn > 0 && this.cHP >= 0 && this.crn + this.cHO < this.cHP) {
                this.cHL.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cHP = this.crn;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alL() {
        if (this.cHM.getParent() == null) {
            this.cHt.addView(this.cHM);
            this.cHM.clearAnimation();
            this.cHM.startAnimation(this.bTB);
            this.cHL.removeCallbacks(this.cHN);
            this.cHL.postDelayed(this.cHN, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alM() {
        if (this.cHM.getParent() != null) {
            this.crn = -1;
            this.cHP = -1;
            this.cHL.removeCallbacks(this.cHN);
            this.cHM.clearAnimation();
            this.cHM.startAnimation(this.bTC);
        }
    }

    public void onDestory() {
        this.cHL.removeCallbacksAndMessages(null);
    }
}
