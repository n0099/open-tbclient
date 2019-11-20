package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private boolean abA;
    CustomMessageListener afT;
    private boolean dVA;
    private Runnable dVB;
    private Runnable dVC;
    private AlaFollowRemindView dVv;
    private Animation dVw;
    private Animation dVx;
    private boolean dVy;
    private com.baidu.tieba.ala.liveroom.b dVz;
    private Handler mHandler;

    public void aOa() {
        this.mHandler.removeCallbacks(this.dVB);
        this.mHandler.removeCallbacks(this.dVC);
        aOb();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        this.abA = false;
        this.dVy = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dVv != null) {
            this.dVv.clearAnimation();
        }
        if (this.dVw != null) {
            this.dVw.cancel();
        }
        if (this.dVx != null) {
            this.dVx.cancel();
        }
        if (this.dVv != null && (this.dVv.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.dVv.getParent();
            if (viewGroup.indexOfChild(this.dVv) > 0) {
                viewGroup.removeView(this.dVv);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dVv != null) {
            this.dVv.clearAnimation();
        }
        if (this.dVw != null) {
            this.dVw.cancel();
        }
        if (this.dVx != null) {
            this.dVx.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.afT);
    }

    private void aOb() {
        if (this.abA) {
            if (this.dVz != null) {
                this.dVz.na(2);
            }
            if (this.dVv != null) {
                this.dVv.getView().setEnabled(false);
            }
            this.dVx = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0068a.sdk_push_up_out);
            this.dVx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.abA = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.dVv != null && (a.this.dVv.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.dVv.getParent();
                                if (viewGroup.indexOfChild(a.this.dVv) > 0) {
                                    viewGroup.removeView(a.this.dVv);
                                }
                            }
                        }
                    });
                    if (a.this.dVz != null) {
                        a.this.dVz.nb(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.dVv != null) {
                this.dVv.clearAnimation();
                this.dVv.setAnimation(this.dVx);
                this.dVx.setDuration(300L);
                this.dVx.start();
            }
        }
    }

    public boolean isShowing() {
        return this.abA;
    }

    public void hm(boolean z) {
        this.dVA = z;
    }

    public boolean aOc() {
        return this.dVA;
    }
}
