package com.baidu.tieba.ala.liveroom.attentionpop;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aeN;
    private AlaFollowRemindView eMj;
    private Animation eMk;
    private Animation eMl;
    private boolean eMm;
    private com.baidu.tieba.ala.liveroom.b eMn;
    private Runnable eMo;
    private Runnable eMp;
    private boolean erZ;
    private boolean isShowing;
    private Handler mHandler;

    public void bfW() {
        this.mHandler.removeCallbacks(this.eMo);
        this.mHandler.removeCallbacks(this.eMp);
        bfX();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oZ() {
        super.oZ();
        this.isShowing = false;
        this.eMm = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eMj != null) {
            this.eMj.clearAnimation();
        }
        if (this.eMk != null) {
            this.eMk.cancel();
        }
        if (this.eMl != null) {
            this.eMl.cancel();
        }
        if (this.eMj != null && (this.eMj.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.eMj.getParent();
            if (viewGroup.indexOfChild(this.eMj) > 0) {
                viewGroup.removeView(this.eMj);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eMj != null) {
            this.eMj.clearAnimation();
        }
        if (this.eMk != null) {
            this.eMk.cancel();
        }
        if (this.eMl != null) {
            this.eMl.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.aeN);
    }

    private void bfX() {
        if (this.isShowing) {
            if (this.eMn != null) {
                this.eMn.ps(2);
            }
            if (this.eMj != null) {
                this.eMj.getView().setEnabled(false);
            }
            this.eMl = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0086a.sdk_push_up_out);
            this.eMl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.eMj != null && (a.this.eMj.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.eMj.getParent();
                                if (viewGroup.indexOfChild(a.this.eMj) > 0) {
                                    viewGroup.removeView(a.this.eMj);
                                }
                            }
                        }
                    });
                    if (a.this.eMn != null) {
                        a.this.eMn.pt(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.eMj != null) {
                this.eMj.clearAnimation();
                this.eMj.setAnimation(this.eMl);
                this.eMl.setDuration(300L);
                this.eMl.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void iG(boolean z) {
        this.erZ = z;
    }

    public boolean bfY() {
        return this.erZ;
    }
}
