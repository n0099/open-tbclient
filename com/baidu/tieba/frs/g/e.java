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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private final Runnable cUU;
    private com.baidu.tieba.frs.g cXx;
    private TextView daH;
    private NoPressedRelativeLayout dam;
    private int cIp = -1;
    private int daK = 0;
    private int daL = -1;
    private final Handler daG = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aqO();
                return true;
            }
            return false;
        }
    });
    private final Animation daI = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation daJ = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dam = noPressedRelativeLayout;
        this.cXx = gVar;
        this.daJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.daH.getParent() != null) {
                    ((ViewGroup) e.this.daH.getParent()).removeView(e.this.daH);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cUU = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aqP();
            }
        };
        initView();
    }

    private void initView() {
        this.daH = new TextView(TbadkCoreApplication.getInst());
        this.daH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aqP();
                if (e.this.cXx != null && !e.this.cXx.alG() && e.this.cXx.alo() != null) {
                    e.this.cXx.alo().startPullRefresh();
                }
            }
        });
        this.daH.setGravity(17);
        this.daH.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cXx.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.cXx.getResources().getDimensionPixelSize(d.e.ds40);
        this.daH.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.daH.setTextSize(0, this.cXx.getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.j(this.daH, d.f.bg_home_float);
        aj.i(this.daH, d.C0096d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cXx.alE().getBottom() + l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        this.daH.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cIp = i;
        this.daK = i2;
        if (this.daL < 0) {
            this.daL = this.cIp;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.cIp > 0 && this.daL >= 0 && this.cIp + this.daK < this.daL) {
                this.daG.sendEmptyMessage(111);
            }
            this.daL = this.cIp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqO() {
        if (this.daH.getParent() == null) {
            this.dam.addView(this.daH);
            this.daH.clearAnimation();
            this.daH.startAnimation(this.daI);
            this.daG.removeCallbacks(this.cUU);
            this.daG.postDelayed(this.cUU, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqP() {
        if (this.daH.getParent() != null) {
            this.cIp = -1;
            this.daL = -1;
            this.daG.removeCallbacks(this.cUU);
            this.daH.clearAnimation();
            this.daH.startAnimation(this.daJ);
        }
    }

    public void onDestory() {
        this.daG.removeCallbacksAndMessages(null);
    }
}
