package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener agU;
    private AlaFollowRemindView eQn;
    private Animation eQo;
    private Animation eQp;
    private boolean eQq;
    private com.baidu.live.liveroom.a.a eQr;
    private Runnable eQs;
    private Runnable eQt;
    private boolean ewk;
    private boolean isShowing;
    private Handler mHandler;

    public void bih() {
        this.mHandler.removeCallbacks(this.eQs);
        this.mHandler.removeCallbacks(this.eQt);
        bii();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        this.isShowing = false;
        this.eQq = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQn != null) {
            this.eQn.clearAnimation();
        }
        if (this.eQo != null) {
            this.eQo.cancel();
        }
        if (this.eQp != null) {
            this.eQp.cancel();
        }
        if (this.eQn != null && (this.eQn.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.eQn.getParent();
            if (viewGroup.indexOfChild(this.eQn) > 0) {
                viewGroup.removeView(this.eQn);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQn != null) {
            this.eQn.clearAnimation();
        }
        if (this.eQo != null) {
            this.eQo.cancel();
        }
        if (this.eQp != null) {
            this.eQp.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.agU);
    }

    private void bii() {
        if (this.isShowing) {
            if (this.eQr != null) {
                this.eQr.cd(2);
            }
            if (this.eQn != null) {
                this.eQn.getView().setEnabled(false);
            }
            this.eQp = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0102a.sdk_push_up_out);
            this.eQp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eQn != null && (a.this.eQn.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.eQn.getParent();
                                if (viewGroup.indexOfChild(a.this.eQn) > 0) {
                                    viewGroup.removeView(a.this.eQn);
                                }
                            }
                        }
                    });
                    if (a.this.eQr != null) {
                        a.this.eQr.ce(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.eQn != null) {
                this.eQn.clearAnimation();
                this.eQn.setAnimation(this.eQp);
                this.eQp.setDuration(300L);
                this.eQp.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void iP(boolean z) {
        this.ewk = z;
    }

    public boolean bij() {
        return this.ewk;
    }
}
