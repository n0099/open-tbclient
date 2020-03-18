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
    CustomMessageListener ahe;
    private AlaFollowRemindView eQY;
    private Animation eQZ;
    private Animation eRa;
    private boolean eRb;
    private com.baidu.live.liveroom.a.a eRc;
    private Runnable eRd;
    private Runnable eRe;
    private boolean ewT;
    private boolean isShowing;
    private Handler mHandler;

    public void bin() {
        this.mHandler.removeCallbacks(this.eRd);
        this.mHandler.removeCallbacks(this.eRe);
        bio();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pP() {
        super.pP();
        this.isShowing = false;
        this.eRb = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQY != null) {
            this.eQY.clearAnimation();
        }
        if (this.eQZ != null) {
            this.eQZ.cancel();
        }
        if (this.eRa != null) {
            this.eRa.cancel();
        }
        if (this.eQY != null && (this.eQY.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.eQY.getParent();
            if (viewGroup.indexOfChild(this.eQY) > 0) {
                viewGroup.removeView(this.eQY);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQY != null) {
            this.eQY.clearAnimation();
        }
        if (this.eQZ != null) {
            this.eQZ.cancel();
        }
        if (this.eRa != null) {
            this.eRa.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.ahe);
    }

    private void bio() {
        if (this.isShowing) {
            if (this.eRc != null) {
                this.eRc.cd(2);
            }
            if (this.eQY != null) {
                this.eQY.getView().setEnabled(false);
            }
            this.eRa = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0102a.sdk_push_up_out);
            this.eRa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eQY != null && (a.this.eQY.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.eQY.getParent();
                                if (viewGroup.indexOfChild(a.this.eQY) > 0) {
                                    viewGroup.removeView(a.this.eQY);
                                }
                            }
                        }
                    });
                    if (a.this.eRc != null) {
                        a.this.eRc.ce(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.eQY != null) {
                this.eQY.clearAnimation();
                this.eQY.setAnimation(this.eRa);
                this.eRa.setDuration(300L);
                this.eRa.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void iR(boolean z) {
        this.ewT = z;
    }

    public boolean bip() {
        return this.ewT;
    }
}
