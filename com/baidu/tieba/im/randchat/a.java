package com.baidu.tieba.im.randchat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.View;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends View {
    private Context a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String[] o;
    private Paint p;
    private RectF q;
    private RectF r;
    private int s;
    private int t;
    private c u;
    private Handler v;

    public a(Context context) {
        super(context);
        this.v = new b(this);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.d = com.baidu.adp.lib.util.h.c(context, com.baidu.tieba.p.loading_circle_radius);
        this.e = com.baidu.adp.lib.util.h.c(context, com.baidu.tieba.p.loading_circle_stroke);
        this.f = com.baidu.adp.lib.util.h.c(context, com.baidu.tieba.p.loading_small_light_circle_radius);
        this.g = com.baidu.adp.lib.util.h.c(context, com.baidu.tieba.p.loading_small_normal_circle_radius);
        this.h = com.baidu.adp.lib.util.h.c(context, com.baidu.tieba.p.loading_circle_distance);
        this.i = this.a.getResources().getColor(com.baidu.tieba.o.loading_circle_color);
        this.j = this.a.getResources().getColor(com.baidu.tieba.o.loading_stroke_color);
        this.k = this.a.getResources().getColor(com.baidu.tieba.o.loading_circle_common_color);
        this.l = this.a.getResources().getColor(com.baidu.tieba.o.loading_circle_light_color);
        this.m = this.a.getResources().getColor(com.baidu.tieba.o.white);
        this.n = com.baidu.adp.lib.util.h.c(context, com.baidu.tieba.p.fontsize40);
        this.o = new String[]{this.a.getString(com.baidu.tieba.u.loading_view_ready), TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK};
        this.p = new Paint();
        this.p.setAntiAlias(true);
        this.q = new RectF();
        this.r = new RectF();
        this.v.sendEmptyMessageDelayed(0, 800L);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b = getWidth();
        this.c = getHeight();
        this.q.set((this.b / 2) - this.d, (this.c / 2) - this.d, (this.b / 2) + this.d, (this.c / 2) + this.d);
        this.r.set(((this.b / 2) - this.d) + this.e, ((this.c / 2) - this.d) + this.e, ((this.b / 2) + this.d) - this.e, ((this.c / 2) + this.d) - this.e);
    }

    public void a(c cVar) {
        this.u = cVar;
        this.v.removeMessages(0);
        this.s = 3;
        invalidate();
        this.v.sendEmptyMessageDelayed(1, 1000L);
    }

    public void a() {
        this.v.removeMessages(0);
        this.v.removeMessages(1);
    }

    public void b() {
        this.v.removeMessages(0);
        this.v.sendEmptyMessageDelayed(0, 800L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.s != 3) {
            this.p.setColor(this.j);
            this.p.setStyle(Paint.Style.STROKE);
            this.p.setStrokeWidth(this.e);
            canvas.drawRoundRect(this.q, this.d, this.d, this.p);
            this.p.setColor(this.i);
            this.p.setStyle(Paint.Style.FILL);
            this.p.setStrokeWidth(this.e);
            canvas.drawRoundRect(this.r, this.d - this.e, this.d - this.e, this.p);
        }
        switch (this.s) {
            case 0:
                int i = (((this.b / 2) - this.g) - this.h) - this.f;
                this.p.setColor(this.l);
                canvas.drawCircle(i, this.c / 2, this.f, this.p);
                this.p.setColor(this.k);
                canvas.drawCircle(this.b / 2, this.c / 2, this.g, this.p);
                canvas.drawCircle((this.b / 2) + this.g + this.h + this.g, this.c / 2, this.g, this.p);
                return;
            case 1:
                int i2 = (((this.b / 2) - this.f) - this.h) - this.g;
                this.p.setColor(this.k);
                canvas.drawCircle(i2, this.c / 2, this.g, this.p);
                this.p.setColor(this.l);
                canvas.drawCircle(this.b / 2, this.c / 2, this.f, this.p);
                this.p.setColor(this.k);
                canvas.drawCircle((this.b / 2) + this.f + this.h + this.g, this.c / 2, this.g, this.p);
                return;
            case 2:
                int i3 = (((this.b / 2) - this.g) - this.h) - this.g;
                this.p.setColor(this.k);
                canvas.drawCircle(i3, this.c / 2, this.g, this.p);
                this.p.setColor(this.k);
                canvas.drawCircle(this.b / 2, this.c / 2, this.g, this.p);
                this.p.setColor(this.l);
                canvas.drawCircle((this.b / 2) + this.g + this.h + this.f, this.c / 2, this.f, this.p);
                return;
            case 3:
                if (this.t >= this.o.length) {
                    this.t = this.o.length - 1;
                }
                this.p.setTextAlign(Paint.Align.CENTER);
                this.p.setTypeface(Typeface.DEFAULT_BOLD);
                this.p.setTextSize(this.t == 0 ? this.n : this.n * 2);
                this.p.setColor(this.m);
                Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
                canvas.drawText(this.o[this.t], this.b / 2, (this.c - ((this.c - (fontMetrics.bottom - fontMetrics.top)) / 2.0f)) - fontMetrics.bottom, this.p);
                return;
            default:
                return;
        }
    }
}
