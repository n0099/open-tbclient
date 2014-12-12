package com.baidu.tieba.im.floatwindow.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.floatwindow.l {
    private FrameLayout aXT;
    private HeadImageView aXU;
    private HeadImageView aXV;
    private HeadImageView aXW;
    private HeadImageView aXX;
    private TextView aXY;
    private Animation aXZ;
    private e aXo;
    private com.baidu.tieba.im.floatwindow.j aXt;
    private com.baidu.tieba.im.floatwindow.a.g aYa;
    private com.baidu.tieba.im.floatwindow.a.f aYb;
    private Point aYc;
    private boolean aYd;
    private com.baidu.tieba.im.floatwindow.a.e aYe;
    private com.baidu.tieba.im.floatwindow.a.h aYf;
    private Runnable akA;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.im_chat_float_window, null));
        this.aYd = false;
        this.akA = new b(this);
        this.aYe = new c(this);
        this.aYf = new d(this);
        this.aXt = new com.baidu.tieba.im.floatwindow.j();
        this.aXT = (FrameLayout) this.aXA.findViewById(com.baidu.tieba.w.chat_float_window_wrapper);
        this.aXU = (HeadImageView) this.aXA.findViewById(com.baidu.tieba.w.chat_float_window_first);
        this.aXV = (HeadImageView) this.aXA.findViewById(com.baidu.tieba.w.chat_float_window_second);
        this.aXW = (HeadImageView) this.aXA.findViewById(com.baidu.tieba.w.chat_float_window_third);
        this.aXX = (HeadImageView) this.aXA.findViewById(com.baidu.tieba.w.chat_float_window_fourth);
        d(this.aXU);
        d(this.aXV);
        d(this.aXW);
        d(this.aXX);
        this.aXY = (TextView) this.aXA.findViewById(com.baidu.tieba.w.chat_float_window_text);
        this.aYc = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean Nx() {
        return this.aYd;
    }

    public com.baidu.tieba.im.floatwindow.j Nk() {
        this.aXt.F(this.aXA);
        return this.aXt;
    }

    public void a(Handler handler, boolean z) {
        if (!Nm()) {
            Nn();
            if (handler != null && z) {
                handler.post(this.akA);
            }
        }
    }

    public void a(e eVar) {
        this.aXo = eVar;
    }

    public void fI(int i) {
        int i2;
        if (i <= 0) {
            this.aXY.setVisibility(8);
            return;
        }
        this.aXY.setVisibility(0);
        if (i < 10) {
            this.aXY.setText(String.valueOf(i));
            i2 = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.aXY.setText(String.valueOf(i));
            i2 = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            this.aXY.setText("   ");
            i2 = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        this.aXY.setBackgroundResource(i2);
    }

    public void Ny() {
        int i;
        int measuredWidth = this.aXA.getMeasuredWidth();
        int i2 = this.aXC.x;
        if ((measuredWidth / 2) + i2 > this.aXw / 2) {
            i = this.aXw - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.im.floatwindow.a.a.Np().a(V(i2, i));
    }

    public void b(Point point) {
        this.aYc.x = this.aXC.x;
        this.aYc.y = this.aXC.y;
        this.aYd = true;
        setTouchable(false);
        com.baidu.tieba.im.floatwindow.a.a.Np().a(c(point));
    }

    public void Nz() {
        int measuredWidth = this.aXA.getMeasuredWidth();
        boolean z = this.aYc.x != 0;
        boolean z2 = this.aYc.x != this.aXw - measuredWidth;
        if (z && z2) {
            if (this.aYc.x > this.aXw / 2) {
                this.aYc.x = this.aXw - measuredWidth;
            } else {
                this.aYc.x = 0;
            }
        }
        this.aYd = true;
        setTouchable(false);
        com.baidu.tieba.im.floatwindow.a.a.Np().a(c(this.aYc));
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            fJ(size);
            for (int i = 0; i < size; i++) {
                v(i, arrayList.get(i));
            }
        }
    }

    private void v(int i, String str) {
        switch (i) {
            case 0:
                this.aXU.d(str, 12, false);
                return;
            case 1:
                this.aXV.d(str, 12, false);
                return;
            case 2:
                this.aXW.d(str, 12, false);
                return;
            case 3:
                this.aXX.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void fJ(int i) {
        this.aXU.setVisibility(i > 0 ? 0 : 8);
        this.aXV.setVisibility(i > 1 ? 0 : 8);
        this.aXW.setVisibility(i > 2 ? 0 : 8);
        this.aXX.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation NA() {
        if (this.aXZ == null) {
            this.aXZ = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_in_anim);
        }
        return this.aXZ;
    }

    private com.baidu.tieba.im.floatwindow.a.g V(int i, int i2) {
        if (this.aYa == null) {
            this.aYa = new com.baidu.tieba.im.floatwindow.a.g(20);
            this.aYa.a(this.aYf);
        }
        this.aYa.setStart(i);
        this.aYa.fH(i2);
        return this.aYa;
    }

    private com.baidu.tieba.im.floatwindow.a.f c(Point point) {
        if (this.aYb == null) {
            this.aYb = new com.baidu.tieba.im.floatwindow.a.f(300L);
            this.aYb.a(this.aYe);
        }
        Point point2 = new Point();
        point2.x = this.aXC.x;
        point2.y = this.aXC.y;
        this.aYb.a(point2, point);
        return this.aYb;
    }
}
