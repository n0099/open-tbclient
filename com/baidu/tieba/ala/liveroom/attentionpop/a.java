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
    CustomMessageListener azA;
    private boolean fbb;
    private boolean fvA;
    private com.baidu.live.liveroom.a.a fvB;
    private Runnable fvC;
    private Runnable fvD;
    private AlaFollowRemindView fvx;
    private Animation fvy;
    private Animation fvz;
    private boolean isShowing;
    private Handler mHandler;

    public void brD() {
        this.mHandler.removeCallbacks(this.fvC);
        this.mHandler.removeCallbacks(this.fvD);
        brE();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void uf() {
        super.uf();
        this.isShowing = false;
        this.fvA = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fvx != null) {
            this.fvx.clearAnimation();
        }
        if (this.fvy != null) {
            this.fvy.cancel();
        }
        if (this.fvz != null) {
            this.fvz.cancel();
        }
        if (this.fvx != null && (this.fvx.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.fvx.getParent();
            if (viewGroup.indexOfChild(this.fvx) > 0) {
                viewGroup.removeView(this.fvx);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fvx != null) {
            this.fvx.clearAnimation();
        }
        if (this.fvy != null) {
            this.fvy.cancel();
        }
        if (this.fvz != null) {
            this.fvz.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.azA);
    }

    private void brE() {
        if (this.isShowing) {
            if (this.fvB != null) {
                this.fvB.cs(2);
            }
            if (this.fvx != null) {
                this.fvx.getView().setEnabled(false);
            }
            this.fvz = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0149a.sdk_push_up_out);
            this.fvz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fvx != null && (a.this.fvx.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.fvx.getParent();
                                if (viewGroup.indexOfChild(a.this.fvx) > 0) {
                                    viewGroup.removeView(a.this.fvx);
                                }
                            }
                        }
                    });
                    if (a.this.fvB != null) {
                        a.this.fvB.ct(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.fvx != null) {
                this.fvx.clearAnimation();
                this.fvx.setAnimation(this.fvz);
                this.fvz.setDuration(300L);
                this.fvz.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void jS(boolean z) {
        this.fbb = z;
    }

    public boolean brF() {
        return this.fbb;
    }
}
