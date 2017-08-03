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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tieba.frs.f csY;
    private TextView cwD;
    private final Runnable cwE;
    private NoPressedRelativeLayout cwb;
    private int ciX = -1;
    private int cwF = 0;
    private int cwG = -1;
    private final Handler cwC = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.h.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ajg();
                return true;
            }
            return false;
        }
    });
    private final Animation mInAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation mOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cwb = noPressedRelativeLayout;
        this.csY = fVar;
        this.mOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.h.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cwD.getParent() != null) {
                    ((ViewGroup) e.this.cwD.getParent()).removeView(e.this.cwD);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cwE = new Runnable() { // from class: com.baidu.tieba.frs.h.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ajh();
            }
        };
        initView();
    }

    private void initView() {
        this.cwD = new TextView(TbadkCoreApplication.getInst());
        this.cwD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ajh();
                if (e.this.csY != null && !e.this.csY.afn() && e.this.csY.aeU() != null) {
                    e.this.csY.aeU().startPullRefresh();
                }
            }
        });
        this.cwD.setGravity(17);
        this.cwD.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.csY.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.csY.getResources().getDimensionPixelSize(d.f.ds40);
        this.cwD.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cwD.setTextSize(0, this.csY.getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.j(this.cwD, d.g.bg_home_float);
        ai.i(this.cwD, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.csY.afl().getBottom() + k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        this.cwD.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.ciX = i;
        this.cwF = i2;
        if (this.cwG < 0) {
            this.cwG = this.ciX;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.ciX > 0 && this.cwG >= 0 && this.ciX + this.cwF < this.cwG) {
                this.cwC.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cwG = this.ciX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajg() {
        if (this.cwD.getParent() == null) {
            this.cwb.addView(this.cwD);
            this.cwD.clearAnimation();
            this.cwD.startAnimation(this.mInAnimation);
            this.cwC.removeCallbacks(this.cwE);
            this.cwC.postDelayed(this.cwE, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        if (this.cwD.getParent() != null) {
            this.ciX = -1;
            this.cwG = -1;
            this.cwC.removeCallbacks(this.cwE);
            this.cwD.clearAnimation();
            this.cwD.startAnimation(this.mOutAnimation);
        }
    }

    public void onDestory() {
        this.cwC.removeCallbacksAndMessages(null);
    }
}
