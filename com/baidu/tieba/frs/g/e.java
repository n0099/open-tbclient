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
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tieba.frs.f cww;
    private TextView czV;
    private final Runnable czW;
    private NoPressedRelativeLayout czt;
    private int ckR = -1;
    private int czX = 0;
    private int czY = -1;
    private final Handler czU = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ajT();
                return true;
            }
            return false;
        }
    });
    private final Animation mInAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation mOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.czt = noPressedRelativeLayout;
        this.cww = fVar;
        this.mOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.czV.getParent() != null) {
                    ((ViewGroup) e.this.czV.getParent()).removeView(e.this.czV);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.czW = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ajU();
            }
        };
        initView();
    }

    private void initView() {
        this.czV = new TextView(TbadkCoreApplication.getInst());
        this.czV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ajU();
                if (e.this.cww != null && !e.this.cww.afI() && e.this.cww.afp() != null) {
                    e.this.cww.afp().startPullRefresh();
                }
            }
        });
        this.czV.setGravity(17);
        this.czV.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cww.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.cww.getResources().getDimensionPixelSize(d.f.ds40);
        this.czV.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.czV.setTextSize(0, this.cww.getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.j(this.czV, d.g.bg_home_float);
        ai.i(this.czV, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cww.afG().getBottom() + k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        this.czV.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.ckR = i;
        this.czX = i2;
        if (this.czY < 0) {
            this.czY = this.ckR;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.ckR > 0 && this.czY >= 0 && this.ckR + this.czX < this.czY) {
                this.czU.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.czY = this.ckR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajT() {
        if (this.czV.getParent() == null) {
            this.czt.addView(this.czV);
            this.czV.clearAnimation();
            this.czV.startAnimation(this.mInAnimation);
            this.czU.removeCallbacks(this.czW);
            this.czU.postDelayed(this.czW, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.czV.getParent() != null) {
            this.ckR = -1;
            this.czY = -1;
            this.czU.removeCallbacks(this.czW);
            this.czV.clearAnimation();
            this.czV.startAnimation(this.mOutAnimation);
        }
    }

    public void onDestory() {
        this.czU.removeCallbacksAndMessages(null);
    }
}
