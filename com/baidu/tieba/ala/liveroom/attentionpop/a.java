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
    private AlaFollowRemindView eQm;
    private Animation eQn;
    private Animation eQo;
    private boolean eQp;
    private com.baidu.live.liveroom.a.a eQq;
    private Runnable eQr;
    private Runnable eQs;
    private boolean ewj;
    private boolean isShowing;
    private Handler mHandler;

    public void bif() {
        this.mHandler.removeCallbacks(this.eQr);
        this.mHandler.removeCallbacks(this.eQs);
        big();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        this.isShowing = false;
        this.eQp = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQm != null) {
            this.eQm.clearAnimation();
        }
        if (this.eQn != null) {
            this.eQn.cancel();
        }
        if (this.eQo != null) {
            this.eQo.cancel();
        }
        if (this.eQm != null && (this.eQm.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.eQm.getParent();
            if (viewGroup.indexOfChild(this.eQm) > 0) {
                viewGroup.removeView(this.eQm);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQm != null) {
            this.eQm.clearAnimation();
        }
        if (this.eQn != null) {
            this.eQn.cancel();
        }
        if (this.eQo != null) {
            this.eQo.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.agU);
    }

    private void big() {
        if (this.isShowing) {
            if (this.eQq != null) {
                this.eQq.cd(2);
            }
            if (this.eQm != null) {
                this.eQm.getView().setEnabled(false);
            }
            this.eQo = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0102a.sdk_push_up_out);
            this.eQo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eQm != null && (a.this.eQm.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.eQm.getParent();
                                if (viewGroup.indexOfChild(a.this.eQm) > 0) {
                                    viewGroup.removeView(a.this.eQm);
                                }
                            }
                        }
                    });
                    if (a.this.eQq != null) {
                        a.this.eQq.ce(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.eQm != null) {
                this.eQm.clearAnimation();
                this.eQm.setAnimation(this.eQo);
                this.eQo.setDuration(300L);
                this.eQo.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void iP(boolean z) {
        this.ewj = z;
    }

    public boolean bih() {
        return this.ewj;
    }
}
