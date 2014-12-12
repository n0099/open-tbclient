package com.baidu.tieba.im.floatwindow.view;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.floatwindow.o {
    private LinearLayout aYh;
    private ScaleAnimation aYi;
    private ScaleAnimation aYj;
    private boolean aYk;
    private boolean aYl;
    private com.baidu.tieba.im.floatwindow.j aYm;
    private Animation aYn;
    private Animation aYo;
    private Runnable aYp;
    private com.baidu.adp.lib.g.e aYq;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.im_chat_tip_view, null));
        this.aYk = false;
        this.aYl = false;
        this.aYp = new g(this);
        this.aYq = new h(this);
        this.deleteView = (ImageView) this.aXA.findViewById(com.baidu.tieba.w.im_chat_tip_view_delete);
        this.aYh = (LinearLayout) this.aXA.findViewById(com.baidu.tieba.w.im_chat_tip_holder);
        this.aYm = new com.baidu.tieba.im.floatwindow.j();
    }

    public com.baidu.tieba.im.floatwindow.j NB() {
        if (this.aYm.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.aYm.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.aYm;
    }

    public void b(Handler handler) {
        if (!Nm()) {
            Nn();
            if (handler != null) {
                handler.removeCallbacks(this.aYp);
                handler.post(this.aYp);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.aYp);
        this.deleteView.clearAnimation();
        this.aYl = false;
        this.aYk = false;
        if (this.aYh.getWindowToken() != null) {
            this.aYh.clearAnimation();
            this.aYh.startAnimation(NG());
            return;
        }
        No();
    }

    public void NC() {
        if (!this.aYl && !this.aYk) {
            this.aYk = true;
            this.deleteView.startAnimation(NE());
        }
    }

    public void ND() {
        if (!this.aYl && this.aYk) {
            this.aYk = false;
            this.deleteView.startAnimation(NF());
        }
    }

    private ScaleAnimation NE() {
        if (this.aYi == null) {
            this.aYi = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.aYi.setDuration(150L);
            this.aYi.setFillAfter(true);
            this.aYi.setAnimationListener(this.aYq);
        }
        return this.aYi;
    }

    private ScaleAnimation NF() {
        if (this.aYj == null) {
            this.aYj = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.aYj.setDuration(150L);
            this.aYj.setFillAfter(true);
            this.aYj.setAnimationListener(this.aYq);
        }
        return this.aYj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation NA() {
        if (this.aYn == null) {
            this.aYn = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_tip_in_anim);
        }
        return this.aYn;
    }

    private Animation NG() {
        if (this.aYo == null) {
            this.aYo = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_tip_out_anim);
            this.aYo.setAnimationListener(this.aYq);
        }
        return this.aYo;
    }

    @Override // com.baidu.tieba.im.floatwindow.o
    public WindowManager.LayoutParams Nl() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
