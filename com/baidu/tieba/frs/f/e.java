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
    private final Runnable dHj;
    private NoPressedRelativeLayout dMI;
    private com.baidu.tieba.frs.i dNb;
    private TextView dNc;
    private int dxP = -1;
    private int bXk = -1;
    private int dNf = -1;
    private final Handler dNa = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.f.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.axV();
                return true;
            }
            return false;
        }
    });
    private final Animation dNd = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dNe = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dMI = noPressedRelativeLayout;
        this.dNb = iVar;
        this.dNe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.f.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dNc.getParent() != null) {
                    ((ViewGroup) e.this.dNc.getParent()).removeView(e.this.dNc);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dHj = new Runnable() { // from class: com.baidu.tieba.frs.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.axW();
            }
        };
        initView();
    }

    private void initView() {
        this.dNc = new TextView(TbadkCoreApplication.getInst());
        this.dNc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.axW();
                if (e.this.dNb != null && !e.this.dNb.ato() && e.this.dNb.asV() != null) {
                    e.this.dNb.asV().startPullRefresh();
                }
            }
        });
        this.dNc.setGravity(17);
        this.dNc.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dNb.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dNb.getResources().getDimensionPixelSize(d.e.ds40);
        this.dNc.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dNc.setTextSize(0, this.dNb.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.s(this.dNc, d.f.bg_home_float);
        aj.r(this.dNc, d.C0108d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.s(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dNc.setLayoutParams(layoutParams);
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.dxP = i;
        this.bXk = i2;
        if (this.dNf < 0) {
            this.dNf = this.dxP;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dxP > 0 && this.bXk > 0 && this.dNf >= 0 && this.dxP + this.bXk + 1 < this.dNf) {
                this.dNa.sendEmptyMessage(111);
            }
            this.dNf = this.dxP;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axV() {
        if (this.dNc.getParent() == null) {
            this.dMI.addView(this.dNc);
            this.dNc.clearAnimation();
            this.dNc.startAnimation(this.dNd);
            this.dNa.removeCallbacks(this.dHj);
            this.dNa.postDelayed(this.dHj, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axW() {
        if (this.dNc.getParent() != null) {
            this.dxP = -1;
            this.dNf = -1;
            this.dNa.removeCallbacks(this.dHj);
            this.dNc.clearAnimation();
            this.dNc.startAnimation(this.dNe);
        }
    }

    public void onDestory() {
        this.dNa.removeCallbacksAndMessages(null);
    }
}
