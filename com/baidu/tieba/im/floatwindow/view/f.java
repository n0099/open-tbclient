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
    private LinearLayout aZC;
    private ScaleAnimation aZD;
    private ScaleAnimation aZE;
    private boolean aZF;
    private boolean aZG;
    private com.baidu.tieba.im.floatwindow.j aZH;
    private Animation aZI;
    private Animation aZJ;
    private Runnable aZK;
    private com.baidu.adp.lib.g.e aZL;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.im_chat_tip_view, null));
        this.aZF = false;
        this.aZG = false;
        this.aZK = new g(this);
        this.aZL = new h(this);
        this.deleteView = (ImageView) this.aYV.findViewById(com.baidu.tieba.w.im_chat_tip_view_delete);
        this.aZC = (LinearLayout) this.aYV.findViewById(com.baidu.tieba.w.im_chat_tip_holder);
        this.aZH = new com.baidu.tieba.im.floatwindow.j();
    }

    public com.baidu.tieba.im.floatwindow.j NS() {
        if (this.aZH.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.aZH.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.aZH;
    }

    public void b(Handler handler) {
        if (!ND()) {
            NE();
            if (handler != null) {
                handler.removeCallbacks(this.aZK);
                handler.post(this.aZK);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.aZK);
        this.deleteView.clearAnimation();
        this.aZG = false;
        this.aZF = false;
        if (this.aZC.getWindowToken() != null) {
            this.aZC.clearAnimation();
            this.aZC.startAnimation(NX());
            return;
        }
        NF();
    }

    public void NT() {
        if (!this.aZG && !this.aZF) {
            this.aZF = true;
            this.deleteView.startAnimation(NV());
        }
    }

    public void NU() {
        if (!this.aZG && this.aZF) {
            this.aZF = false;
            this.deleteView.startAnimation(NW());
        }
    }

    private ScaleAnimation NV() {
        if (this.aZD == null) {
            this.aZD = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.aZD.setDuration(150L);
            this.aZD.setFillAfter(true);
            this.aZD.setAnimationListener(this.aZL);
        }
        return this.aZD;
    }

    private ScaleAnimation NW() {
        if (this.aZE == null) {
            this.aZE = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.aZE.setDuration(150L);
            this.aZE.setFillAfter(true);
            this.aZE.setAnimationListener(this.aZL);
        }
        return this.aZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation NR() {
        if (this.aZI == null) {
            this.aZI = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_tip_in_anim);
        }
        return this.aZI;
    }

    private Animation NX() {
        if (this.aZJ == null) {
            this.aZJ = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_tip_out_anim);
            this.aZJ.setAnimationListener(this.aZL);
        }
        return this.aZJ;
    }

    @Override // com.baidu.tieba.im.floatwindow.o
    public WindowManager.LayoutParams NC() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
