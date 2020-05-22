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
    private Runnable fJA;
    private AlaFollowRemindView fJu;
    private Animation fJv;
    private Animation fJw;
    private boolean fJx;
    private com.baidu.live.liveroom.a.a fJy;
    private Runnable fJz;
    private boolean foD;
    private boolean isShowing;
    private Handler mHandler;

    public void bxx() {
        this.mHandler.removeCallbacks(this.fJz);
        this.mHandler.removeCallbacks(this.fJA);
        bxy();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        this.isShowing = false;
        this.fJx = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fJu != null) {
            this.fJu.clearAnimation();
        }
        if (this.fJv != null) {
            this.fJv.cancel();
        }
        if (this.fJw != null) {
            this.fJw.cancel();
        }
        if (this.fJu != null && (this.fJu.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.fJu.getParent();
            if (viewGroup.indexOfChild(this.fJu) > 0) {
                viewGroup.removeView(this.fJu);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fJu != null) {
            this.fJu.clearAnimation();
        }
        if (this.fJv != null) {
            this.fJv.cancel();
        }
        if (this.fJw != null) {
            this.fJw.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.aES);
    }

    private void bxy() {
        if (this.isShowing) {
            if (this.fJy != null) {
                this.fJy.cz(2);
            }
            if (this.fJu != null) {
                this.fJu.getView().setEnabled(false);
            }
            this.fJw = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0182a.sdk_push_up_out);
            this.fJw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fJu != null && (a.this.fJu.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.fJu.getParent();
                                if (viewGroup.indexOfChild(a.this.fJu) > 0) {
                                    viewGroup.removeView(a.this.fJu);
                                }
                            }
                        }
                    });
                    if (a.this.fJy != null) {
                        a.this.fJy.cA(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.fJu != null) {
                this.fJu.clearAnimation();
                this.fJu.setAnimation(this.fJw);
                this.fJw.setDuration(300L);
                this.fJw.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void kl(boolean z) {
        this.foD = z;
    }

    public boolean bxz() {
        return this.foD;
    }
}
