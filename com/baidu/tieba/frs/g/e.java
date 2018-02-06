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
    private final Runnable dPe;
    private NoPressedRelativeLayout dUR;
    private com.baidu.tieba.frs.i dVk;
    private TextView dVl;
    private int dFI = -1;
    private int bZI = -1;
    private int dVo = -1;
    private final Handler dVj = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aAf();
                return true;
            }
            return false;
        }
    });
    private final Animation dVm = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dVn = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dUR = noPressedRelativeLayout;
        this.dVk = iVar;
        this.dVn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dVl.getParent() != null) {
                    ((ViewGroup) e.this.dVl.getParent()).removeView(e.this.dVl);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.dPe = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aAg();
            }
        };
        initView();
    }

    private void initView() {
        this.dVl = new TextView(TbadkCoreApplication.getInst());
        this.dVl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aAg();
                if (e.this.dVk != null && !e.this.dVk.avm() && e.this.dVk.auT() != null) {
                    e.this.dVk.auT().startPullRefresh();
                }
            }
        });
        this.dVl.setGravity(17);
        this.dVl.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dVk.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dVk.getResources().getDimensionPixelSize(d.e.ds40);
        this.dVl.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dVl.setTextSize(0, this.dVk.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.s(this.dVl, d.f.bg_home_float);
        aj.r(this.dVl, d.C0140d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.t(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dVl.setLayoutParams(layoutParams);
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.dFI = i;
        this.bZI = i2;
        if (this.dVo < 0) {
            this.dVo = this.dFI;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dFI > 0 && this.bZI > 0 && this.dVo >= 0 && this.dFI + this.bZI + 1 < this.dVo) {
                this.dVj.sendEmptyMessage(111);
            }
            this.dVo = this.dFI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAf() {
        if (this.dVl.getParent() == null) {
            this.dUR.addView(this.dVl);
            this.dVl.clearAnimation();
            this.dVl.startAnimation(this.dVm);
            this.dVj.removeCallbacks(this.dPe);
            this.dVj.postDelayed(this.dPe, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAg() {
        if (this.dVl.getParent() != null) {
            this.dFI = -1;
            this.dVo = -1;
            this.dVj.removeCallbacks(this.dPe);
            this.dVl.clearAnimation();
            this.dVl.startAnimation(this.dVn);
        }
    }

    public void onDestory() {
        this.dVj.removeCallbacksAndMessages(null);
    }
}
