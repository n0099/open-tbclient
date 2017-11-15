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
    private final Runnable cLv;
    private com.baidu.tieba.frs.f cNX;
    private NoPressedRelativeLayout cQY;
    private TextView cRr;
    private int czb = -1;
    private int cRs = 0;
    private int cRt = -1;
    private final Handler cRq = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aoL();
                return true;
            }
            return false;
        }
    });
    private final Animation cbv = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation cbw = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cQY = noPressedRelativeLayout;
        this.cNX = fVar;
        this.cbw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cRr.getParent() != null) {
                    ((ViewGroup) e.this.cRr.getParent()).removeView(e.this.cRr);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cLv = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aoM();
            }
        };
        initView();
    }

    private void initView() {
        this.cRr = new TextView(TbadkCoreApplication.getInst());
        this.cRr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aoM();
                if (e.this.cNX != null && !e.this.cNX.ajC() && e.this.cNX.ajk() != null) {
                    e.this.cNX.ajk().startPullRefresh();
                }
            }
        });
        this.cRr.setGravity(17);
        this.cRr.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cNX.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.cNX.getResources().getDimensionPixelSize(d.e.ds40);
        this.cRr.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cRr.setTextSize(0, this.cNX.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.j(this.cRr, d.f.bg_home_float);
        aj.i(this.cRr, d.C0080d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cNX.ajA().getBottom() + l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        this.cRr.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.czb = i;
        this.cRs = i2;
        if (this.cRt < 0) {
            this.cRt = this.czb;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.czb > 0 && this.cRt >= 0 && this.czb + this.cRs < this.cRt) {
                this.cRq.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cRt = this.czb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoL() {
        if (this.cRr.getParent() == null) {
            this.cQY.addView(this.cRr);
            this.cRr.clearAnimation();
            this.cRr.startAnimation(this.cbv);
            this.cRq.removeCallbacks(this.cLv);
            this.cRq.postDelayed(this.cLv, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoM() {
        if (this.cRr.getParent() != null) {
            this.czb = -1;
            this.cRt = -1;
            this.cRq.removeCallbacks(this.cLv);
            this.cRr.clearAnimation();
            this.cRr.startAnimation(this.cbw);
        }
    }

    public void onDestory() {
        this.cRq.removeCallbacksAndMessages(null);
    }
}
