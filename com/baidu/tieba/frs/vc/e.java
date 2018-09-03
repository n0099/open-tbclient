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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e {
    private NoPressedRelativeLayout dFW;
    private FrsFragment dGo;
    private TextView dGp;
    private final Runnable mHideRunnable;
    private int dnG = -1;
    private int buc = -1;
    private int dGs = -1;
    private final Handler dGn = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.aAu();
                return true;
            }
            return false;
        }
    });
    private final Animation dGq = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), f.a.fade_in);
    private final Animation dGr = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), f.a.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.dFW = noPressedRelativeLayout;
        this.dGo = frsFragment;
        this.dGr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.dGp.getParent() != null) {
                    ((ViewGroup) e.this.dGp.getParent()).removeView(e.this.dGp);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.aAv();
            }
        };
        initView();
    }

    private void initView() {
        this.dGp = new TextView(TbadkCoreApplication.getInst());
        this.dGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aAv();
                if (e.this.dGo != null && !e.this.dGo.auD() && e.this.dGo.aul() != null) {
                    e.this.dGo.aul().startPullRefresh();
                }
            }
        });
        this.dGp.setGravity(17);
        this.dGp.setText(f.j.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.dGo.getResources().getDimensionPixelSize(f.e.ds20);
        int dimensionPixelSize2 = this.dGo.getResources().getDimensionPixelSize(f.e.ds40);
        this.dGp.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.dGp.setTextSize(0, this.dGo.getResources().getDimensionPixelSize(f.e.fontsize28));
        am.i(this.dGp, f.C0146f.bg_home_float);
        am.h(this.dGp, f.d.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.dGo.Vj().getBottom() + l.f(TbadkCoreApplication.getInst(), f.e.ds8);
        this.dGp.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.dnG = i;
        this.buc = i2;
        if (this.dGs < 0) {
            this.dGs = this.dnG;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.dnG > 0 && this.buc > 0 && this.dGs >= 0 && this.dnG + this.buc + 1 < this.dGs) {
                this.dGn.sendEmptyMessage(111);
            }
            this.dGs = this.dnG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAu() {
        if (this.dGp.getParent() == null) {
            this.dFW.addView(this.dGp);
            this.dGp.clearAnimation();
            this.dGp.startAnimation(this.dGq);
            this.dGn.removeCallbacks(this.mHideRunnable);
            this.dGn.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAv() {
        if (this.dGp.getParent() != null) {
            this.dnG = -1;
            this.dGs = -1;
            this.dGn.removeCallbacks(this.mHideRunnable);
            this.dGp.clearAnimation();
            this.dGp.startAnimation(this.dGr);
        }
    }

    public void onDestory() {
        this.dGn.removeCallbacksAndMessages(null);
    }
}
