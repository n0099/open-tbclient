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
    CustomMessageListener azu;
    private boolean faW;
    private AlaFollowRemindView fvs;
    private Animation fvt;
    private Animation fvu;
    private boolean fvv;
    private com.baidu.live.liveroom.a.a fvw;
    private Runnable fvx;
    private Runnable fvy;
    private boolean isShowing;
    private Handler mHandler;

    public void brF() {
        this.mHandler.removeCallbacks(this.fvx);
        this.mHandler.removeCallbacks(this.fvy);
        brG();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ug() {
        super.ug();
        this.isShowing = false;
        this.fvv = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fvs != null) {
            this.fvs.clearAnimation();
        }
        if (this.fvt != null) {
            this.fvt.cancel();
        }
        if (this.fvu != null) {
            this.fvu.cancel();
        }
        if (this.fvs != null && (this.fvs.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.fvs.getParent();
            if (viewGroup.indexOfChild(this.fvs) > 0) {
                viewGroup.removeView(this.fvs);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fvs != null) {
            this.fvs.clearAnimation();
        }
        if (this.fvt != null) {
            this.fvt.cancel();
        }
        if (this.fvu != null) {
            this.fvu.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.azu);
    }

    private void brG() {
        if (this.isShowing) {
            if (this.fvw != null) {
                this.fvw.cs(2);
            }
            if (this.fvs != null) {
                this.fvs.getView().setEnabled(false);
            }
            this.fvu = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), a.C0128a.sdk_push_up_out);
            this.fvu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.isShowing = false;
                    a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.fvs != null && (a.this.fvs.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup = (ViewGroup) a.this.fvs.getParent();
                                if (viewGroup.indexOfChild(a.this.fvs) > 0) {
                                    viewGroup.removeView(a.this.fvs);
                                }
                            }
                        }
                    });
                    if (a.this.fvw != null) {
                        a.this.fvw.ct(2);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.fvs != null) {
                this.fvs.clearAnimation();
                this.fvs.setAnimation(this.fvu);
                this.fvu.setDuration(300L);
                this.fvu.start();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void jS(boolean z) {
        this.faW = z;
    }

    public boolean brH() {
        return this.faW;
    }
}
