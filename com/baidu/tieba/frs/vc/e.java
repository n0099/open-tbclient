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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e {
    private NoPressedRelativeLayout dGa;
    private FrsFragment dGs;
    private TextView dGt;
    private final Runnable mHideRunnable;
    private int dnI = -1;
    private int bua = -1;
    private int dGw = -1;
    private final Handler dGr = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aAx();
                return true;
            }
            return false;
        }
    });
    private final Animation dGu = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation dGv = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dGa = noPressedRelativeLayout;
        this.dGs = frsFragment;
        this.dGv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dGt.getParent() != null) {
                    ((ViewGroup) e.this.dGt.getParent()).removeView(e.this.dGt);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aAy();
            }
        };
        initView();
    }

    private void initView() {
        this.dGt = new TextView(TbadkCoreApplication.getInst());
        this.dGt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aAy();
                if (e.this.dGs != null && !e.this.dGs.auE() && e.this.dGs.aum() != null) {
                    e.this.dGs.aum().startPullRefresh();
                }
            }
        });
        this.dGt.setGravity(17);
        this.dGt.setText(d.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dGs.getResources().getDimensionPixelSize(d.e.ds20);
        int dimensionPixelSize2 = this.dGs.getResources().getDimensionPixelSize(d.e.ds40);
        this.dGt.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dGt.setTextSize(0, this.dGs.getResources().getDimensionPixelSize(d.e.fontsize28));
        am.i(this.dGt, d.f.bg_home_float);
        am.h(this.dGt, d.C0140d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.dGs.Vf().getBottom() + l.f(TbadkCoreApplication.getInst(), d.e.ds8);
        this.dGt.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dnI = i;
        this.bua = i2;
        if (this.dGw < 0) {
            this.dGw = this.dnI;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dnI > 0 && this.bua > 0 && this.dGw >= 0 && this.dnI + this.bua + 1 < this.dGw) {
                this.dGr.sendEmptyMessage(111);
            }
            this.dGw = this.dnI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAx() {
        if (this.dGt.getParent() == null) {
            this.dGa.addView(this.dGt);
            this.dGt.clearAnimation();
            this.dGt.startAnimation(this.dGu);
            this.dGr.removeCallbacks(this.mHideRunnable);
            this.dGr.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAy() {
        if (this.dGt.getParent() != null) {
            this.dnI = -1;
            this.dGw = -1;
            this.dGr.removeCallbacks(this.mHideRunnable);
            this.dGt.clearAnimation();
            this.dGt.startAnimation(this.dGv);
        }
    }

    public void onDestory() {
        this.dGr.removeCallbacksAndMessages(null);
    }
}
