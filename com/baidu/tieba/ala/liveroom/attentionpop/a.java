package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.u.a;
@Deprecated
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aES;
    private AlaFollowRemindView fJF;
    private Animation fJG;
    private Animation fJH;
    private boolean fJI;
    private com.baidu.live.liveroom.a.a fJJ;
    private Runnable fJK;
    private Runnable fJL;
    private boolean foO;
    private boolean isShowing;
    private Handler mHandler;

    public void bxz() {
        this.mHandler.removeCallbacks(this.fJK);
        this.mHandler.removeCallbacks(this.fJL);
        bxA();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        this.isShowing = false;
        this.fJI = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fJF != null) {
            this.fJF.clearAnimation();
        }
        if (this.fJG != null) {
            this.fJG.cancel();
        }
        if (this.fJH != null) {
            this.fJH.cancel();
        }
        if (this.fJF != null && (this.fJF.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.fJF.getParent();
            if (viewGroup.indexOfChild(this.fJF) > 0) {
                viewGroup.removeView(this.fJF);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fJF != null) {
            this.fJF.clearAnimation();
        }
        if (this.fJG != null) {
            this.fJG.cancel();
        }
        if (this.fJH != null) {
            this.fJH.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.aES);
    }

    private void bxA() {
        if (this.isShowing) {
            if (this.fJJ != null) {
                this.fJJ.cB(2);
            }
            if (this.fJF != null) {
                this.fJF.getView().setEnabled(false);
            }
            this.fJH = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0182a.sdk_push_up_out);
            this.fJH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fJF != null && (a.this.fJF.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.fJF.getParent();
                                if (viewGroup.indexOfChild(a.this.fJF) > 0) {
                                    viewGroup.removeView(a.this.fJF);
                                }
                            }
                        }
                    });
                    if (a.this.fJJ != null) {
                        a.this.fJJ.cC(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.fJF != null) {
                this.fJF.clearAnimation();
                this.fJF.setAnimation(this.fJH);
                this.fJH.setDuration(300L);
                this.fJH.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void kl(boolean z) {
        this.foO = z;
    }

    public boolean bxB() {
        return this.foO;
    }
}
