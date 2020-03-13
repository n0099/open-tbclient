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
    private AlaFollowRemindView eQA;
    private Animation eQB;
    private Animation eQC;
    private boolean eQD;
    private com.baidu.live.liveroom.a.a eQE;
    private Runnable eQF;
    private Runnable eQG;
    private boolean ewx;
    private boolean isShowing;
    private Handler mHandler;

    public void bii() {
        this.mHandler.removeCallbacks(this.eQF);
        this.mHandler.removeCallbacks(this.eQG);
        bij();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        this.isShowing = false;
        this.eQD = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQA != null) {
            this.eQA.clearAnimation();
        }
        if (this.eQB != null) {
            this.eQB.cancel();
        }
        if (this.eQC != null) {
            this.eQC.cancel();
        }
        if (this.eQA != null && (this.eQA.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.eQA.getParent();
            if (viewGroup.indexOfChild(this.eQA) > 0) {
                viewGroup.removeView(this.eQA);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eQA != null) {
            this.eQA.clearAnimation();
        }
        if (this.eQB != null) {
            this.eQB.cancel();
        }
        if (this.eQC != null) {
            this.eQC.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.agU);
    }

    private void bij() {
        if (this.isShowing) {
            if (this.eQE != null) {
                this.eQE.cd(2);
            }
            if (this.eQA != null) {
                this.eQA.getView().setEnabled(false);
            }
            this.eQC = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0102a.sdk_push_up_out);
            this.eQC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eQA != null && (a.this.eQA.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.eQA.getParent();
                                if (viewGroup.indexOfChild(a.this.eQA) > 0) {
                                    viewGroup.removeView(a.this.eQA);
                                }
                            }
                        }
                    });
                    if (a.this.eQE != null) {
                        a.this.eQE.ce(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.eQA != null) {
                this.eQA.clearAnimation();
                this.eQA.setAnimation(this.eQC);
                this.eQC.setDuration(300L);
                this.eQC.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void iP(boolean z) {
        this.ewx = z;
    }

    public boolean bik() {
        return this.ewx;
    }
}
