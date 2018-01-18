package com.baidu.tieba.frs.f;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    private final Runnable dLK;
    private com.baidu.tieba.frs.i dRD;
    private TextView dRE;
    private NoPressedRelativeLayout dRk;
    private int dCq = -1;
    private int bXr = -1;
    private int dRH = -1;
    private final Handler dRC = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.f.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ayY();
                return true;
            }
            return false;
        }
    });
    private final Animation dRF = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dRG = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dRk = noPressedRelativeLayout;
        this.dRD = iVar;
        this.dRG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.f.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dRE.getParent() != null) {
                    ((ViewGroup) e.this.dRE.getParent()).removeView(e.this.dRE);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dLK = new Runnable() { // from class: com.baidu.tieba.frs.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ayZ();
            }
        };
        initView();
    }

    private void initView() {
        this.dRE = new TextView(TbadkCoreApplication.getInst());
        this.dRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ayZ();
                if (e.this.dRD != null && !e.this.dRD.aur() && e.this.dRD.atY() != null) {
                    e.this.dRD.atY().startPullRefresh();
                }
            }
        });
        this.dRE.setGravity(17);
        this.dRE.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dRD.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dRD.getResources().getDimensionPixelSize(d.e.ds40);
        this.dRE.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dRE.setTextSize(0, this.dRD.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.s(this.dRE, d.f.bg_home_float);
        aj.r(this.dRE, d.C0107d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.s(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dRE.setLayoutParams(layoutParams);
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.dCq = i;
        this.bXr = i2;
        if (this.dRH < 0) {
            this.dRH = this.dCq;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dCq > 0 && this.bXr > 0 && this.dRH >= 0 && this.dCq + this.bXr + 1 < this.dRH) {
                this.dRC.sendEmptyMessage(111);
            }
            this.dRH = this.dCq;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayY() {
        if (this.dRE.getParent() == null) {
            this.dRk.addView(this.dRE);
            this.dRE.clearAnimation();
            this.dRE.startAnimation(this.dRF);
            this.dRC.removeCallbacks(this.dLK);
            this.dRC.postDelayed(this.dLK, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayZ() {
        if (this.dRE.getParent() != null) {
            this.dCq = -1;
            this.dRH = -1;
            this.dRC.removeCallbacks(this.dLK);
            this.dRE.clearAnimation();
            this.dRE.startAnimation(this.dRG);
        }
    }

    public void onDestory() {
        this.dRC.removeCallbacksAndMessages(null);
    }
}
