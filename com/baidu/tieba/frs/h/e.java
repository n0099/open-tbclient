package com.baidu.tieba.frs.h;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tieba.frs.f cCR;
    private NoPressedRelativeLayout cFU;
    private TextView cGn;
    private final Runnable cGo;
    private int cqk = -1;
    private int cGp = 0;
    private int cGq = -1;
    private final Handler cGm = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.h.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.alB();
                return true;
            }
            return false;
        }
    });
    private final Animation mInAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_in);
    private final Animation mOutAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), d.a.fade_out);

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cFU = noPressedRelativeLayout;
        this.cCR = fVar;
        this.mOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.h.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cGn.getParent() != null) {
                    ((ViewGroup) e.this.cGn.getParent()).removeView(e.this.cGn);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cGo = new Runnable() { // from class: com.baidu.tieba.frs.h.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.alC();
            }
        };
        initView();
    }

    private void initView() {
        this.cGn = new TextView(TbadkCoreApplication.getInst());
        this.cGn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.alC();
                if (e.this.cCR != null && !e.this.cCR.ahg() && e.this.cCR.agN() != null) {
                    e.this.cCR.agN().startPullRefresh();
                }
            }
        });
        this.cGn.setGravity(17);
        this.cGn.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cCR.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.cCR.getResources().getDimensionPixelSize(d.f.ds40);
        this.cGn.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cGn.setTextSize(0, this.cCR.getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.j(this.cGn, d.g.bg_home_float);
        aj.i(this.cGn, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cCR.ahe().getBottom() + k.g(TbadkCoreApplication.getInst(), d.f.ds8);
        this.cGn.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cqk = i;
        this.cGp = i2;
        if (this.cGq < 0) {
            this.cGq = this.cqk;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.cqk > 0 && this.cGq >= 0 && this.cqk + this.cGp < this.cGq) {
                this.cGm.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cGq = this.cqk;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alB() {
        if (this.cGn.getParent() == null) {
            this.cFU.addView(this.cGn);
            this.cGn.clearAnimation();
            this.cGn.startAnimation(this.mInAnimation);
            this.cGm.removeCallbacks(this.cGo);
            this.cGm.postDelayed(this.cGo, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alC() {
        if (this.cGn.getParent() != null) {
            this.cqk = -1;
            this.cGq = -1;
            this.cGm.removeCallbacks(this.cGo);
            this.cGn.clearAnimation();
            this.cGn.startAnimation(this.mOutAnimation);
        }
    }

    public void onDestory() {
        this.cGm.removeCallbacksAndMessages(null);
    }
}
