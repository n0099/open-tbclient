package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener anV;
    private AlaFollowRemindView eKW;
    private Animation eKX;
    private Animation eKY;
    private boolean eKZ;
    private com.baidu.tieba.ala.liveroom.b eLa;
    private Runnable eLb;
    private Runnable eLc;
    private boolean eqM;
    private boolean isShowing;
    private Handler mHandler;

    public void bfw() {
        this.mHandler.removeCallbacks(this.eLb);
        this.mHandler.removeCallbacks(this.eLc);
        bfx();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oS() {
        super.oS();
        this.isShowing = false;
        this.eKZ = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eKW != null) {
            this.eKW.clearAnimation();
        }
        if (this.eKX != null) {
            this.eKX.cancel();
        }
        if (this.eKY != null) {
            this.eKY.cancel();
        }
        if (this.eKW != null && (this.eKW.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.eKW.getParent();
            if (viewGroup.indexOfChild(this.eKW) > 0) {
                viewGroup.removeView(this.eKW);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eKW != null) {
            this.eKW.clearAnimation();
        }
        if (this.eKX != null) {
            this.eKX.cancel();
        }
        if (this.eKY != null) {
            this.eKY.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.anV);
    }

    private void bfx() {
        if (this.isShowing) {
            if (this.eLa != null) {
                this.eLa.pr(2);
            }
            if (this.eKW != null) {
                this.eKW.getView().setEnabled(false);
            }
            this.eKY = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0086a.sdk_push_up_out);
            this.eKY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eKW != null && (a.this.eKW.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.eKW.getParent();
                                if (viewGroup.indexOfChild(a.this.eKW) > 0) {
                                    viewGroup.removeView(a.this.eKW);
                                }
                            }
                        }
                    });
                    if (a.this.eLa != null) {
                        a.this.eLa.ps(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.eKW != null) {
                this.eKW.clearAnimation();
                this.eKW.setAnimation(this.eKY);
                this.eKY.setDuration(300L);
                this.eKY.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void iw(boolean z) {
        this.eqM = z;
    }

    public boolean bfy() {
        return this.eqM;
    }
}
