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
    private com.baidu.tieba.frs.f cEC;
    private NoPressedRelativeLayout cHF;
    private TextView cHY;
    private final Runnable cHZ;
    private int crz = -1;
    private int cIa = 0;
    private int cIb = -1;
    private final Handler cHX = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.h.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.alQ();
                return true;
            }
            return false;
        }
    });
    private final Animation bTN = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation bTO = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cHF = noPressedRelativeLayout;
        this.cEC = fVar;
        this.bTO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.h.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cHY.getParent() != null) {
                    ((ViewGroup) e.this.cHY.getParent()).removeView(e.this.cHY);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cHZ = new Runnable() { // from class: com.baidu.tieba.frs.h.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.alR();
            }
        };
        initView();
    }

    private void initView() {
        this.cHY = new TextView(TbadkCoreApplication.getInst());
        this.cHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.alR();
                if (e.this.cEC != null && !e.this.cEC.ahl() && e.this.cEC.agU() != null) {
                    e.this.cEC.agU().startPullRefresh();
                }
            }
        });
        this.cHY.setGravity(17);
        this.cHY.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cEC.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.cEC.getResources().getDimensionPixelSize(d.f.ds40);
        this.cHY.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cHY.setTextSize(0, this.cEC.getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.j(this.cHY, d.g.bg_home_float);
        aj.i(this.cHY, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cEC.ahj().getBottom() + l.f(TbadkCoreApplication.getInst(), d.f.ds8);
        this.cHY.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.crz = i;
        this.cIa = i2;
        if (this.cIb < 0) {
            this.cIb = this.crz;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.crz > 0 && this.cIb >= 0 && this.crz + this.cIa < this.cIb) {
                this.cHX.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cIb = this.crz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alQ() {
        if (this.cHY.getParent() == null) {
            this.cHF.addView(this.cHY);
            this.cHY.clearAnimation();
            this.cHY.startAnimation(this.bTN);
            this.cHX.removeCallbacks(this.cHZ);
            this.cHX.postDelayed(this.cHZ, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alR() {
        if (this.cHY.getParent() != null) {
            this.crz = -1;
            this.cIb = -1;
            this.cHX.removeCallbacks(this.cHZ);
            this.cHY.clearAnimation();
            this.cHY.startAnimation(this.bTO);
        }
    }

    public void onDestory() {
        this.cHX.removeCallbacksAndMessages(null);
    }
}
