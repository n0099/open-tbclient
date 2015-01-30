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
    private e aYK;
    private com.baidu.tieba.im.floatwindow.j aYP;
    private com.baidu.tieba.im.floatwindow.a.e aZA;
    private com.baidu.tieba.im.floatwindow.a.h aZB;
    private FrameLayout aZp;
    private HeadImageView aZq;
    private HeadImageView aZr;
    private HeadImageView aZs;
    private HeadImageView aZt;
    private TextView aZu;
    private Animation aZv;
    private com.baidu.tieba.im.floatwindow.a.g aZw;
    private com.baidu.tieba.im.floatwindow.a.f aZx;
    private Point aZy;
    private boolean aZz;
    private Runnable ali;

    public a(Context context) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.im_chat_float_window, null));
        this.aZz = false;
        this.ali = new b(this);
        this.aZA = new c(this);
        this.aZB = new d(this);
        this.aYP = new com.baidu.tieba.im.floatwindow.j();
        this.aZp = (FrameLayout) this.aYW.findViewById(com.baidu.tieba.w.chat_float_window_wrapper);
        this.aZq = (HeadImageView) this.aYW.findViewById(com.baidu.tieba.w.chat_float_window_first);
        this.aZr = (HeadImageView) this.aYW.findViewById(com.baidu.tieba.w.chat_float_window_second);
        this.aZs = (HeadImageView) this.aYW.findViewById(com.baidu.tieba.w.chat_float_window_third);
        this.aZt = (HeadImageView) this.aYW.findViewById(com.baidu.tieba.w.chat_float_window_fourth);
        d(this.aZq);
        d(this.aZr);
        d(this.aZs);
        d(this.aZt);
        this.aZu = (TextView) this.aYW.findViewById(com.baidu.tieba.w.chat_float_window_text);
        this.aZy = new Point();
    }

    private void d(HeadImageView headImageView) {
        headImageView.setAutoChangeStyle(false);
        headImageView.setIsRound(true);
        headImageView.setDefaultBgResource(0);
    }

    public boolean NT() {
        return this.aZz;
    }

    public com.baidu.tieba.im.floatwindow.j NG() {
        this.aYP.H(this.aYW);
        return this.aYP;
    }

    public void a(Handler handler, boolean z) {
        if (!NI()) {
            NJ();
            if (handler != null && z) {
                handler.post(this.ali);
            }
        }
    }

    public void a(e eVar) {
        this.aYK = eVar;
    }

    public void fN(int i) {
        int i2;
        if (i <= 0) {
            this.aZu.setVisibility(8);
            return;
        }
        this.aZu.setVisibility(0);
        if (i < 10) {
            this.aZu.setText(String.valueOf(i));
            i2 = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.aZu.setText(String.valueOf(i));
            i2 = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            this.aZu.setText("   ");
            i2 = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        this.aZu.setBackgroundResource(i2);
    }

    public void NU() {
        int i;
        int measuredWidth = this.aYW.getMeasuredWidth();
        int i2 = this.aYY.x;
        if ((measuredWidth / 2) + i2 > this.aYS / 2) {
            i = this.aYS - measuredWidth;
        } else {
            i = 0;
        }
        com.baidu.tieba.im.floatwindow.a.a.NL().a(W(i2, i));
    }

    public void b(Point point) {
        this.aZy.x = this.aYY.x;
        this.aZy.y = this.aYY.y;
        this.aZz = true;
        setTouchable(false);
        com.baidu.tieba.im.floatwindow.a.a.NL().a(c(point));
    }

    public void NV() {
        int measuredWidth = this.aYW.getMeasuredWidth();
        boolean z = this.aZy.x != 0;
        boolean z2 = this.aZy.x != this.aYS - measuredWidth;
        if (z && z2) {
            if (this.aZy.x > this.aYS / 2) {
                this.aZy.x = this.aYS - measuredWidth;
            } else {
                this.aZy.x = 0;
            }
        }
        this.aZz = true;
        setTouchable(false);
        com.baidu.tieba.im.floatwindow.a.a.NL().a(c(this.aZy));
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
                this.aZq.d(str, 12, false);
                return;
            case 1:
                this.aZr.d(str, 12, false);
                return;
            case 2:
                this.aZs.d(str, 12, false);
                return;
            case 3:
                this.aZt.d(str, 12, false);
                return;
            default:
                return;
        }
    }

    private void fO(int i) {
        this.aZq.setVisibility(i > 0 ? 0 : 8);
        this.aZr.setVisibility(i > 1 ? 0 : 8);
        this.aZs.setVisibility(i > 2 ? 0 : 8);
        this.aZt.setVisibility(i <= 3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation NW() {
        if (this.aZv == null) {
            this.aZv = AnimationUtils.loadAnimation(TbadkCoreApplication.m255getInst(), com.baidu.tieba.q.float_window_in_anim);
        }
        return this.aZv;
    }

    private com.baidu.tieba.im.floatwindow.a.g W(int i, int i2) {
        if (this.aZw == null) {
            this.aZw = new com.baidu.tieba.im.floatwindow.a.g(20);
            this.aZw.a(this.aZB);
        }
        this.aZw.setStart(i);
        this.aZw.fM(i2);
        return this.aZw;
    }

    private com.baidu.tieba.im.floatwindow.a.f c(Point point) {
        if (this.aZx == null) {
            this.aZx = new com.baidu.tieba.im.floatwindow.a.f(300L);
            this.aZx.a(this.aZA);
        }
        Point point2 = new Point();
        point2.x = this.aYY.x;
        point2.y = this.aYY.y;
        this.aZx.a(point2, point);
        return this.aZx;
    }
}
