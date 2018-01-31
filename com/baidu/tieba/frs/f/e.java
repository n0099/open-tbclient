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
    private final Runnable dMf;
    private NoPressedRelativeLayout dRF;
    private com.baidu.tieba.frs.i dRY;
    private TextView dRZ;
    private int dCL = -1;
    private int bXz = -1;
    private int dSc = -1;
    private final Handler dRX = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.f.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.azd();
                return true;
            }
            return false;
        }
    });
    private final Animation dSa = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dSb = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dRF = noPressedRelativeLayout;
        this.dRY = iVar;
        this.dSb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.f.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dRZ.getParent() != null) {
                    ((ViewGroup) e.this.dRZ.getParent()).removeView(e.this.dRZ);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dMf = new Runnable() { // from class: com.baidu.tieba.frs.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aze();
            }
        };
        initView();
    }

    private void initView() {
        this.dRZ = new TextView(TbadkCoreApplication.getInst());
        this.dRZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aze();
                if (e.this.dRY != null && !e.this.dRY.auw() && e.this.dRY.aud() != null) {
                    e.this.dRY.aud().startPullRefresh();
                }
            }
        });
        this.dRZ.setGravity(17);
        this.dRZ.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dRY.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dRY.getResources().getDimensionPixelSize(d.e.ds40);
        this.dRZ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dRZ.setTextSize(0, this.dRY.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.s(this.dRZ, d.f.bg_home_float);
        aj.r(this.dRZ, d.C0108d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.s(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dRZ.setLayoutParams(layoutParams);
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.dCL = i;
        this.bXz = i2;
        if (this.dSc < 0) {
            this.dSc = this.dCL;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dCL > 0 && this.bXz > 0 && this.dSc >= 0 && this.dCL + this.bXz + 1 < this.dSc) {
                this.dRX.sendEmptyMessage(111);
            }
            this.dSc = this.dCL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azd() {
        if (this.dRZ.getParent() == null) {
            this.dRF.addView(this.dRZ);
            this.dRZ.clearAnimation();
            this.dRZ.startAnimation(this.dSa);
            this.dRX.removeCallbacks(this.dMf);
            this.dRX.postDelayed(this.dMf, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aze() {
        if (this.dRZ.getParent() != null) {
            this.dCL = -1;
            this.dSc = -1;
            this.dRX.removeCallbacks(this.dMf);
            this.dRZ.clearAnimation();
            this.dRZ.startAnimation(this.dSb);
        }
    }

    public void onDestory() {
        this.dRX.removeCallbacksAndMessages(null);
    }
}
