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
    private final Runnable dOS;
    private NoPressedRelativeLayout dUF;
    private com.baidu.tieba.frs.i dUY;
    private TextView dUZ;
    private int dFw = -1;
    private int bZw = -1;
    private int dVc = -1;
    private final Handler dUX = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aAe();
                return true;
            }
            return false;
        }
    });
    private final Animation dVa = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dVb = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUF = noPressedRelativeLayout;
        this.dUY = iVar;
        this.dVb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dUZ.getParent() != null) {
                    ((ViewGroup) e.this.dUZ.getParent()).removeView(e.this.dUZ);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dOS = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aAf();
            }
        };
        initView();
    }

    private void initView() {
        this.dUZ = new TextView(TbadkCoreApplication.getInst());
        this.dUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aAf();
                if (e.this.dUY != null && !e.this.dUY.avl() && e.this.dUY.auS() != null) {
                    e.this.dUY.auS().startPullRefresh();
                }
            }
        });
        this.dUZ.setGravity(17);
        this.dUZ.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dUY.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dUY.getResources().getDimensionPixelSize(d.e.ds40);
        this.dUZ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dUZ.setTextSize(0, this.dUY.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.s(this.dUZ, d.f.bg_home_float);
        aj.r(this.dUZ, d.C0141d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.t(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dUZ.setLayoutParams(layoutParams);
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.dFw = i;
        this.bZw = i2;
        if (this.dVc < 0) {
            this.dVc = this.dFw;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dFw > 0 && this.bZw > 0 && this.dVc >= 0 && this.dFw + this.bZw + 1 < this.dVc) {
                this.dUX.sendEmptyMessage(111);
            }
            this.dVc = this.dFw;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAe() {
        if (this.dUZ.getParent() == null) {
            this.dUF.addView(this.dUZ);
            this.dUZ.clearAnimation();
            this.dUZ.startAnimation(this.dVa);
            this.dUX.removeCallbacks(this.dOS);
            this.dUX.postDelayed(this.dOS, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAf() {
        if (this.dUZ.getParent() != null) {
            this.dFw = -1;
            this.dVc = -1;
            this.dUX.removeCallbacks(this.dOS);
            this.dUZ.clearAnimation();
            this.dUZ.startAnimation(this.dVb);
        }
    }

    public void onDestory() {
        this.dUX.removeCallbacksAndMessages(null);
    }
}
