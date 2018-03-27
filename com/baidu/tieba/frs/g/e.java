package com.baidu.tieba.frs.g;

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
    private final Runnable dOX;
    private NoPressedRelativeLayout dUK;
    private com.baidu.tieba.frs.i dVe;
    private TextView dVf;
    private int dFA = -1;
    private int bZz = -1;
    private int dVi = -1;
    private final Handler dVd = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aAg();
                return true;
            }
            return false;
        }
    });
    private final Animation dVg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dVh = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUK = noPressedRelativeLayout;
        this.dVe = iVar;
        this.dVh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dVf.getParent() != null) {
                    ((ViewGroup) e.this.dVf.getParent()).removeView(e.this.dVf);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dOX = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aAh();
            }
        };
        initView();
    }

    private void initView() {
        this.dVf = new TextView(TbadkCoreApplication.getInst());
        this.dVf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aAh();
                if (e.this.dVe != null && !e.this.dVe.avm() && e.this.dVe.auT() != null) {
                    e.this.dVe.auT().startPullRefresh();
                }
            }
        });
        this.dVf.setGravity(17);
        this.dVf.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dVe.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dVe.getResources().getDimensionPixelSize(d.e.ds40);
        this.dVf.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dVf.setTextSize(0, this.dVe.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.s(this.dVf, d.f.bg_home_float);
        aj.r(this.dVf, d.C0141d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.t(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dVf.setLayoutParams(layoutParams);
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.dFA = i;
        this.bZz = i2;
        if (this.dVi < 0) {
            this.dVi = this.dFA;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dFA > 0 && this.bZz > 0 && this.dVi >= 0 && this.dFA + this.bZz + 1 < this.dVi) {
                this.dVd.sendEmptyMessage(111);
            }
            this.dVi = this.dFA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAg() {
        if (this.dVf.getParent() == null) {
            this.dUK.addView(this.dVf);
            this.dVf.clearAnimation();
            this.dVf.startAnimation(this.dVg);
            this.dVd.removeCallbacks(this.dOX);
            this.dVd.postDelayed(this.dOX, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        if (this.dVf.getParent() != null) {
            this.dFA = -1;
            this.dVi = -1;
            this.dVd.removeCallbacks(this.dOX);
            this.dVf.clearAnimation();
            this.dVf.startAnimation(this.dVh);
        }
    }

    public void onDestory() {
        this.dVd.removeCallbacksAndMessages(null);
    }
}
