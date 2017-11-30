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
    private final Runnable cUJ;
    private com.baidu.tieba.frs.f cXm;
    private NoPressedRelativeLayout daa;
    private TextView dau;
    private int cIg = -1;
    private int dav = 0;
    private int daw = -1;
    private final Handler das = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aqF();
                return true;
            }
            return false;
        }
    });
    private final Animation cjX = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation cjY = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.daa = noPressedRelativeLayout;
        this.cXm = fVar;
        this.cjY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dau.getParent() != null) {
                    ((ViewGroup) e.this.dau.getParent()).removeView(e.this.dau);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cUJ = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aqG();
            }
        };
        initView();
    }

    private void initView() {
        this.dau = new TextView(TbadkCoreApplication.getInst());
        this.dau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aqG();
                if (e.this.cXm != null && !e.this.cXm.alw() && e.this.cXm.ale() != null) {
                    e.this.cXm.ale().startPullRefresh();
                }
            }
        });
        this.dau.setGravity(17);
        this.dau.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cXm.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.cXm.getResources().getDimensionPixelSize(d.e.ds40);
        this.dau.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dau.setTextSize(0, this.cXm.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.j(this.dau, d.f.bg_home_float);
        aj.i(this.dau, d.C0082d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cXm.alu().getBottom() + l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dau.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cIg = i;
        this.dav = i2;
        if (this.daw < 0) {
            this.daw = this.cIg;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.cIg > 0 && this.daw >= 0 && this.cIg + this.dav < this.daw) {
                this.das.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.daw = this.cIg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqF() {
        if (this.dau.getParent() == null) {
            this.daa.addView(this.dau);
            this.dau.clearAnimation();
            this.dau.startAnimation(this.cjX);
            this.das.removeCallbacks(this.cUJ);
            this.das.postDelayed(this.cUJ, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqG() {
        if (this.dau.getParent() != null) {
            this.cIg = -1;
            this.daw = -1;
            this.das.removeCallbacks(this.cUJ);
            this.dau.clearAnimation();
            this.dau.startAnimation(this.cjY);
        }
    }

    public void onDestory() {
        this.das.removeCallbacksAndMessages(null);
    }
}
