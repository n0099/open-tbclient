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
    private boolean abS;
    CustomMessageListener agm;
    private AlaFollowRemindView dWm;
    private Animation dWn;
    private Animation dWo;
    private boolean dWp;
    private com.baidu.tieba.ala.liveroom.b dWq;
    private boolean dWr;
    private Runnable dWs;
    private Runnable dWt;
    private Handler mHandler;

    public void aOc() {
        this.mHandler.removeCallbacks(this.dWs);
        this.mHandler.removeCallbacks(this.dWt);
        aOd();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        this.abS = false;
        this.dWp = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dWm != null) {
            this.dWm.clearAnimation();
        }
        if (this.dWn != null) {
            this.dWn.cancel();
        }
        if (this.dWo != null) {
            this.dWo.cancel();
        }
        if (this.dWm != null && (this.dWm.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.dWm.getParent();
            if (viewGroup.indexOfChild(this.dWm) > 0) {
                viewGroup.removeView(this.dWm);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dWm != null) {
            this.dWm.clearAnimation();
        }
        if (this.dWn != null) {
            this.dWn.cancel();
        }
        if (this.dWo != null) {
            this.dWo.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.agm);
    }

    private void aOd() {
        if (this.abS) {
            if (this.dWq != null) {
                this.dWq.nb(2);
            }
            if (this.dWm != null) {
                this.dWm.getView().setEnabled(false);
            }
            this.dWo = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0068a.sdk_push_up_out);
            this.dWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.abS = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.dWm != null && (a.this.dWm.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.dWm.getParent();
                                if (viewGroup.indexOfChild(a.this.dWm) > 0) {
                                    viewGroup.removeView(a.this.dWm);
                                }
                            }
                        }
                    });
                    if (a.this.dWq != null) {
                        a.this.dWq.nc(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.dWm != null) {
                this.dWm.clearAnimation();
                this.dWm.setAnimation(this.dWo);
                this.dWo.setDuration(300L);
                this.dWo.start();
            }
        }
    }

    public boolean isShowing() {
        return this.abS;
    }

    public void hm(boolean z) {
        this.dWr = z;
    }

    public boolean aOe() {
        return this.dWr;
    }
}
