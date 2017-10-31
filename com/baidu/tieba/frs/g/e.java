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
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private final Runnable cLc;
    private com.baidu.tieba.frs.f cND;
    private NoPressedRelativeLayout cQE;
    private TextView cQX;
    private int cyI = -1;
    private int cQY = 0;
    private int cQZ = -1;
    private final Handler cQW = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aow();
                return true;
            }
            return false;
        }
    });
    private final Animation cbi = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation cbj = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cQE = noPressedRelativeLayout;
        this.cND = fVar;
        this.cbj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cQX.getParent() != null) {
                    ((ViewGroup) e.this.cQX.getParent()).removeView(e.this.cQX);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cLc = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aox();
            }
        };
        initView();
    }

    private void initView() {
        this.cQX = new TextView(TbadkCoreApplication.getInst());
        this.cQX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aox();
                if (e.this.cND != null && !e.this.cND.ajo() && e.this.cND.aiW() != null) {
                    e.this.cND.aiW().startPullRefresh();
                }
            }
        });
        this.cQX.setGravity(17);
        this.cQX.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cND.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.cND.getResources().getDimensionPixelSize(d.e.ds40);
        this.cQX.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cQX.setTextSize(0, this.cND.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.j(this.cQX, d.f.bg_home_float);
        aj.i(this.cQX, d.C0080d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cND.ajm().getBottom() + l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        this.cQX.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cyI = i;
        this.cQY = i2;
        if (this.cQZ < 0) {
            this.cQZ = this.cyI;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.cyI > 0 && this.cQZ >= 0 && this.cyI + this.cQY < this.cQZ) {
                this.cQW.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cQZ = this.cyI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aow() {
        if (this.cQX.getParent() == null) {
            this.cQE.addView(this.cQX);
            this.cQX.clearAnimation();
            this.cQX.startAnimation(this.cbi);
            this.cQW.removeCallbacks(this.cLc);
            this.cQW.postDelayed(this.cLc, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (this.cQX.getParent() != null) {
            this.cyI = -1;
            this.cQZ = -1;
            this.cQW.removeCallbacks(this.cLc);
            this.cQX.clearAnimation();
            this.cQX.startAnimation(this.cbj);
        }
    }

    public void onDestory() {
        this.cQW.removeCallbacksAndMessages(null);
    }
}
