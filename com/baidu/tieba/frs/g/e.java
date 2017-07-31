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
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tieba.frs.f cus;
    private TextView cxX;
    private final Runnable cxY;
    private NoPressedRelativeLayout cxv;
    private final Animation mInAnimation;
    private final Animation mOutAnimation;
    private int cke = -1;
    private int cxZ = 0;
    private int cya = -1;
    private final Handler cxW = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.g.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.ajs();
                return true;
            }
            return false;
        }
    });

    public e(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.cxv = noPressedRelativeLayout;
        this.cus = fVar;
        this.mInAnimation = AnimationUtils.loadAnimation(fVar.getActivity(), d.a.fade_in);
        this.mOutAnimation = AnimationUtils.loadAnimation(fVar.getActivity(), d.a.fade_out);
        this.mOutAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.g.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.cxX.getParent() != null) {
                    ((ViewGroup) e.this.cxX.getParent()).removeView(e.this.cxX);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.cxY = new Runnable() { // from class: com.baidu.tieba.frs.g.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.ajt();
            }
        };
        initView();
    }

    private void initView() {
        this.cxX = new TextView(this.cus.getActivity());
        this.cxX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ajt();
                if (e.this.cus != null && !e.this.cus.afs() && e.this.cus.aeZ() != null) {
                    e.this.cus.aeZ().startPullRefresh();
                }
            }
        });
        this.cxX.setGravity(17);
        this.cxX.setText(d.l.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.cus.getResources().getDimensionPixelSize(d.f.ds20);
        int dimensionPixelSize2 = this.cus.getResources().getDimensionPixelSize(d.f.ds40);
        this.cxX.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.cxX.setTextSize(0, this.cus.getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.j(this.cxX, d.g.bg_home_float);
        ai.i(this.cxX, d.e.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.cus.afq().getBottom() + k.g(this.cus.getActivity(), d.f.ds8);
        this.cxX.setLayoutParams(layoutParams);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cke = i;
        this.cxZ = i2;
        if (this.cya < 0) {
            this.cya = this.cke;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.cke > 0 && this.cya >= 0 && this.cke + this.cxZ < this.cya) {
                this.cxW.sendEmptyMessage(SapiSafeFacade.SAPIWEBVIEW_BIND_WIDGET);
            }
            this.cya = this.cke;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        if (this.cxX.getParent() == null) {
            this.cxv.addView(this.cxX);
            this.cxX.clearAnimation();
            this.cxX.startAnimation(this.mInAnimation);
            this.cxW.removeCallbacks(this.cxY);
            this.cxW.postDelayed(this.cxY, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajt() {
        if (this.cxX.getParent() != null) {
            this.cke = -1;
            this.cya = -1;
            this.cxW.removeCallbacks(this.cxY);
            this.cxX.clearAnimation();
            this.cxX.startAnimation(this.mOutAnimation);
        }
    }

    public void onDestory() {
        this.cxW.removeCallbacksAndMessages(null);
    }
}
