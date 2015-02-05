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
    private e aYJ;
    private com.baidu.tieba.im.floatwindow.j aYO;
    private com.baidu.tieba.im.floatwindow.a.h aZA;
    private FrameLayout aZo;
    private HeadImageView aZp;
    private HeadImageView aZq;
    private HeadImageView aZr;
    private HeadImageView aZs;
    private TextView aZt;
    private Animation aZu;
    private com.baidu.tieba.im.floatwindow.a.g aZv;
    private com.baidu.tieba.im.floatwindow.a.f aZw;
    private Point aZx;
    private boolean aZy;
    private com.baidu.tieba.im.floatwindow.a.e aZz;
    private Runnable alf;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.im_chat_float_window, null));
        this.aZy = false;
        this.alf = new b(this);
        this.aZz = new c(this);
        this.aZA = new d(this);
        this.aYO = new com.baidu.tieba.im.floatwindow.j();
        this.aZo = (FrameLayout) this.aYV.findViewById(com.baidu.tieba.w.chat_float_window_wrapper);
        this.aZp = (HeadImageView) this.aYV.findViewById(com.baidu.tieba.w.chat_float_window_first);
        this.aZq = (HeadImageView) this.aYV.findViewById(com.baidu.tieba.w.chat_float_window_second);
        this.aZr = (HeadImageView) this.aYV.findViewById(com.baidu.tieba.w.chat_float_window_third);
        this.aZs = (HeadImageView) this.aYV.findViewById(com.baidu.tieba.w.chat_float_window_fourth);
        d(this.aZp);
        d(this.aZq);
        d(this.aZr);
        d(this.aZs);
        this.aZt = (TextView) this.aYV.findViewById(com.baidu.tieba.w.chat_float_window_text);
        this.aZx = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean NO() {
        return this.aZy;
    }

    public com.baidu.tieba.im.floatwindow.j NB() {
        this.aYO.H(this.aYV);
        return this.aYO;
    }

    public void a(Handler handler, boolean z) {
        if (!ND()) {
            NE();
            if (handler != null && z) {
                handler.post(this.alf);
            }
        }
    }

    public void a(e eVar) {
        this.aYJ = eVar;
    }

    public void fN(int i) {
        int i2;
        if (i <= 0) {
            this.aZt.setVisibility(8);
            return;
        }
        this.aZt.setVisibility(0);
        if (i < 10) {
            this.aZt.setText(String.valueOf(i));
            i2 = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.aZt.setText(String.valueOf(i));
            i2 = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            this.aZt.setText("   ");
            i2 = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        this.aZt.setBackgroundResource(i2);
    }

    public void NP() {
        int i;
        int measuredWidth = this.aYV.getMeasuredWidth();
        int i2 = this.aYX.x;
        if ((measuredWidth / 2) + i2 > this.aYR / 2) {
            i = this.aYR - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.im.floatwindow.a.a.NG().a(X(i2, i));
    }

    public void b(Point point) {
        this.aZx.x = this.aYX.x;
        this.aZx.y = this.aYX.y;
        this.aZy = true;
        setTouchable(false);
        com.baidu.tieba.im.floatwindow.a.a.NG().a(c(point));
    }

    public void NQ() {
        int measuredWidth = this.aYV.getMeasuredWidth();
        boolean z = this.aZx.x != 0;
        boolean z2 = this.aZx.x != this.aYR - measuredWidth;
        if (z && z2) {
            if (this.aZx.x > this.aYR / 2) {
                this.aZx.x = this.aYR - measuredWidth;
            } else {
                this.aZx.x = 0;
            }
        }
        this.aZy = true;
        setTouchable(false);
        com.baidu.tieba.im.floatwindow.a.a.NG().a(c(this.aZx));
    }

    public void E(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            fO(size);
            for (int i = 0; i < size; i++) {
                v(i, arrayList.get(i));
            }
        }
    }

    private void v(int i, String str) {
        switch (i) {
            case 0:
                this.aZp.d(str, 12, false);
                return;
            case 1:
                this.aZq.d(str, 12, false);
                return;
            case 2:
                this.aZr.d(str, 12, false);
                return;
            case 3:
                this.aZs.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void fO(int i) {
        this.aZp.setVisibility(i > 0 ? 0 : 8);
        this.aZq.setVisibility(i > 1 ? 0 : 8);
        this.aZr.setVisibility(i > 2 ? 0 : 8);
        this.aZs.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation NR() {
        if (this.aZu == null) {
            this.aZu = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_in_anim);
        }
        return this.aZu;
    }

    private com.baidu.tieba.im.floatwindow.a.g X(int i, int i2) {
        if (this.aZv == null) {
            this.aZv = new com.baidu.tieba.im.floatwindow.a.g(20);
            this.aZv.a(this.aZA);
        }
        this.aZv.setStart(i);
        this.aZv.fM(i2);
        return this.aZv;
    }

    private com.baidu.tieba.im.floatwindow.a.f c(Point point) {
        if (this.aZw == null) {
            this.aZw = new com.baidu.tieba.im.floatwindow.a.f(300L);
            this.aZw.a(this.aZz);
        }
        Point point2 = new Point();
        point2.x = this.aYX.x;
        point2.y = this.aYX.y;
        this.aZw.a(point2, point);
        return this.aZw;
    }
}
