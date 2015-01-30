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
    private LinearLayout aZD;
    private ScaleAnimation aZE;
    private ScaleAnimation aZF;
    private boolean aZG;
    private boolean aZH;
    private com.baidu.tieba.im.floatwindow.j aZI;
    private Animation aZJ;
    private Animation aZK;
    private Runnable aZL;
    private com.baidu.adp.lib.g.e aZM;
    private ImageView deleteView;

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.im_chat_tip_view, null));
        this.aZG = false;
        this.aZH = false;
        this.aZL = new g(this);
        this.aZM = new h(this);
        this.deleteView = (ImageView) this.aYW.findViewById(com.baidu.tieba.w.im_chat_tip_view_delete);
        this.aZD = (LinearLayout) this.aYW.findViewById(com.baidu.tieba.w.im_chat_tip_holder);
        this.aZI = new com.baidu.tieba.im.floatwindow.j();
    }

    public com.baidu.tieba.im.floatwindow.j NX() {
        if (this.aZI.isEmpty()) {
            int[] iArr = new int[2];
            this.deleteView.getLocationOnScreen(iArr);
            if (iArr[0] != 0 && iArr[1] != 0) {
                int measuredHeight = (this.deleteView.getMeasuredHeight() / 2) + 15;
                this.aZI.t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
            }
        }
        return this.aZI;
    }

    public void b(Handler handler) {
        if (!NI()) {
            NJ();
            if (handler != null) {
                handler.removeCallbacks(this.aZL);
                handler.post(this.aZL);
            }
        }
    }

    public void c(Handler handler) {
        handler.removeCallbacks(this.aZL);
        this.deleteView.clearAnimation();
        this.aZH = false;
        this.aZG = false;
        if (this.aZD.getWindowToken() != null) {
            this.aZD.clearAnimation();
            this.aZD.startAnimation(Oc());
            return;
        }
        NK();
    }

    public void NY() {
        if (!this.aZH && !this.aZG) {
            this.aZG = true;
            this.deleteView.startAnimation(Oa());
        }
    }

    public void NZ() {
        if (!this.aZH && this.aZG) {
            this.aZG = false;
            this.deleteView.startAnimation(Ob());
        }
    }

    private ScaleAnimation Oa() {
        if (this.aZE == null) {
            this.aZE = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.aZE.setDuration(150L);
            this.aZE.setFillAfter(true);
            this.aZE.setAnimationListener(this.aZM);
        }
        return this.aZE;
    }

    private ScaleAnimation Ob() {
        if (this.aZF == null) {
            this.aZF = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.aZF.setDuration(150L);
            this.aZF.setFillAfter(true);
            this.aZF.setAnimationListener(this.aZM);
        }
        return this.aZF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation NW() {
        if (this.aZJ == null) {
            this.aZJ = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_tip_in_anim);
        }
        return this.aZJ;
    }

    private Animation Oc() {
        if (this.aZK == null) {
            this.aZK = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_tip_out_anim);
            this.aZK.setAnimationListener(this.aZM);
        }
        return this.aZK;
    }

    @Override // com.baidu.tieba.im.floatwindow.o
    public WindowManager.LayoutParams NH() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        layoutParams.format = -3;
        return layoutParams;
    }
}
