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
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tieba.frs.f cDJ;
    private NoPressedRelativeLayout cGM;
    private TextView cHf;
    private final Runnable cHi;
    private int crd = -1;
    private int cHj = 0;
    private int cHk = -1;
    private final Handler cHe = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.h.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.alM();
                return true;
            }
            return false;
        }
    });
    private final Animation cHg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation cHh = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cGM = noPressedRelativeLayout;
        this.cDJ = fVar;
        this.cHh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.h.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cHf.getParent() != null) {
                    ((ViewGroup) e.this.cHf.getParent()).removeView(e.this.cHf);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cHi = new Runnable() { // from class: com.baidu.tieba.frs.h.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.alN();
            }
        };
        initView();
    }

    private void initView() {
        this.cHf = new TextView(TbadkCoreApplication.getInst());
        this.cHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.alN();
                if (e.this.cDJ != null && !e.this.cDJ.ahr() && e.this.cDJ.agY() != null) {
                    e.this.cDJ.agY().startPullRefresh();
                }
            }
        });
        this.cHf.setGravity(17);
        this.cHf.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cDJ.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.cDJ.getResources().getDimensionPixelSize(d.f.ds40);
        this.cHf.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cHf.setTextSize(0, this.cDJ.getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.j(this.cHf, d.g.bg_home_float);
        aj.i(this.cHf, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cDJ.ahp().getBottom() + k.f(TbadkCoreApplication.getInst(), d.f.ds8);
        this.cHf.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.crd = i;
        this.cHj = i2;
        if (this.cHk < 0) {
            this.cHk = this.crd;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.crd > 0 && this.cHk >= 0 && this.crd + this.cHj < this.cHk) {
                this.cHe.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cHk = this.crd;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alM() {
        if (this.cHf.getParent() == null) {
            this.cGM.addView(this.cHf);
            this.cHf.clearAnimation();
            this.cHf.startAnimation(this.cHg);
            this.cHe.removeCallbacks(this.cHi);
            this.cHe.postDelayed(this.cHi, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alN() {
        if (this.cHf.getParent() != null) {
            this.crd = -1;
            this.cHk = -1;
            this.cHe.removeCallbacks(this.cHi);
            this.cHf.clearAnimation();
            this.cHf.startAnimation(this.cHh);
        }
    }

    public void onDestory() {
        this.cHe.removeCallbacksAndMessages(null);
    }
}
