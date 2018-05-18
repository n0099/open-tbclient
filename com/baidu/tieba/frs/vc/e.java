package com.baidu.tieba.frs.vc;

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e {
    private final Runnable diH;
    private NoPressedRelativeLayout dqP;
    private FrsFragment dri;
    private TextView drj;
    private int cZz = -1;
    private int bjP = -1;
    private int drm = -1;
    private final Handler drh = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.avb();
                return true;
            }
            return false;
        }
    });
    private final Animation drk = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation drl = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dqP = noPressedRelativeLayout;
        this.dri = frsFragment;
        this.drl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.drj.getParent() != null) {
                    ((ViewGroup) e.this.drj.getParent()).removeView(e.this.drj);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.diH = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.avc();
            }
        };
        initView();
    }

    private void initView() {
        this.drj = new TextView(TbadkCoreApplication.getInst());
        this.drj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.avc();
                if (e.this.dri != null && !e.this.dri.apE() && e.this.dri.apm() != null) {
                    e.this.dri.apm().startPullRefresh();
                }
            }
        });
        this.drj.setGravity(17);
        this.drj.setText(d.k.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dri.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dri.getResources().getDimensionPixelSize(d.e.ds40);
        this.drj.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.drj.setTextSize(0, this.dri.getResources().getDimensionPixelSize(d.e.fontsize28));
        ak.i(this.drj, d.f.bg_home_float);
        ak.h(this.drj, d.C0126d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = l.e(TbadkCoreApplication.getInst(), d.e.ds8);
        this.drj.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.cZz = i;
        this.bjP = i2;
        if (this.drm < 0) {
            this.drm = this.cZz;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.cZz > 0 && this.bjP > 0 && this.drm >= 0 && this.cZz + this.bjP + 1 < this.drm) {
                this.drh.sendEmptyMessage(111);
            }
            this.drm = this.cZz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avb() {
        if (this.drj.getParent() == null) {
            this.dqP.addView(this.drj);
            this.drj.clearAnimation();
            this.drj.startAnimation(this.drk);
            this.drh.removeCallbacks(this.diH);
            this.drh.postDelayed(this.diH, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avc() {
        if (this.drj.getParent() != null) {
            this.cZz = -1;
            this.drm = -1;
            this.drh.removeCallbacks(this.diH);
            this.drj.clearAnimation();
            this.drj.startAnimation(this.drl);
        }
    }

    public void onDestory() {
        this.drh.removeCallbacksAndMessages(null);
    }
}
