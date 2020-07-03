package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.sdk.a;
@Deprecated
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aHo;
    private boolean fAa;
    private AlaFollowRemindView fUF;
    private Animation fUG;
    private Animation fUH;
    private boolean fUI;
    private com.baidu.live.liveroom.a.a fUJ;
    private Runnable fUK;
    private Runnable fUL;
    private boolean isShowing;
    private Handler mHandler;

    public void bAm() {
        this.mHandler.removeCallbacks(this.fUK);
        this.mHandler.removeCallbacks(this.fUL);
        bAn();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
        this.isShowing = false;
        this.fUI = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fUF != null) {
            this.fUF.clearAnimation();
        }
        if (this.fUG != null) {
            this.fUG.cancel();
        }
        if (this.fUH != null) {
            this.fUH.cancel();
        }
        if (this.fUF != null && (this.fUF.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.fUF.getParent();
            if (viewGroup.indexOfChild(this.fUF) > 0) {
                viewGroup.removeView(this.fUF);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fUF != null) {
            this.fUF.clearAnimation();
        }
        if (this.fUG != null) {
            this.fUG.cancel();
        }
        if (this.fUH != null) {
            this.fUH.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.aHo);
    }

    private void bAn() {
        if (this.isShowing) {
            if (this.fUJ != null) {
                this.fUJ.cH(2);
            }
            if (this.fUF != null) {
                this.fUF.getView().setEnabled(false);
            }
            this.fUH = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0176a.sdk_push_up_out);
            this.fUH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fUF != null && (a.this.fUF.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.fUF.getParent();
                                if (viewGroup.indexOfChild(a.this.fUF) > 0) {
                                    viewGroup.removeView(a.this.fUF);
                                }
                            }
                        }
                    });
                    if (a.this.fUJ != null) {
                        a.this.fUJ.cI(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.fUF != null) {
                this.fUF.clearAnimation();
                this.fUF.setAnimation(this.fUH);
                this.fUH.setDuration(300L);
                this.fUH.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void ky(boolean z) {
        this.fAa = z;
    }

    public boolean bAo() {
        return this.fAa;
    }
}
