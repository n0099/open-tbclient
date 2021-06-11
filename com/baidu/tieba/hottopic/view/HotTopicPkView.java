package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.n0.d1.c.i;
/* loaded from: classes4.dex */
public class HotTopicPkView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f16924e;

    /* renamed from: f  reason: collision with root package name */
    public int f16925f;

    /* renamed from: g  reason: collision with root package name */
    public int f16926g;

    /* renamed from: h  reason: collision with root package name */
    public int f16927h;

    /* renamed from: i  reason: collision with root package name */
    public int f16928i;
    public int j;
    public Drawable k;
    public Drawable l;
    public Drawable m;
    public int n;
    public int o;
    public int p;
    public int q;
    public RectF r;
    public RectF s;
    public Paint t;
    public i u;
    public HotTopicActivity v;
    public boolean w;
    public boolean x;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < 4; i2++) {
                HotTopicPkView.this.postInvalidate();
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
            HotTopicPkView.this.w = false;
            HotTopicPkView.this.postInvalidate();
        }
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.w = false;
        this.x = false;
        f(context);
    }

    public final void b(Canvas canvas) {
        int i2;
        int i3;
        i iVar = this.u;
        if (iVar.f56273h == 0 && iVar.j == 0) {
            this.f16928i = (int) ((this.f16927h * 0.5d) + this.n + 50.0d);
        } else {
            i iVar2 = this.u;
            long j = iVar2.f56273h;
            this.f16928i = (int) (((((float) j) / ((float) (j + iVar2.j))) * this.f16927h) + this.n + 50.0f);
        }
        if (this.u.k == 2) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.n / 2.0f, this.j, this.f16928i, this.f16924e - i2, this.t);
        if (this.u.k == 1) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.f16928i, this.j, this.f16926g - (this.n / 2.0f), this.f16924e - i3, this.t);
    }

    public final void c(Canvas canvas) {
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_pic_vs);
        this.m = drawable;
        if (this.w) {
            if (this.x) {
                int i2 = this.f16928i;
                int i3 = this.p;
                int i4 = this.j;
                drawable.setBounds((i2 - (i3 / 2)) - 3, i4, ((i2 - (i3 / 2)) - 3) + i3, this.q + i4);
                this.m.draw(canvas);
            } else {
                int i5 = this.f16928i;
                int i6 = this.p;
                int i7 = this.j;
                drawable.setBounds((i5 - (i6 / 2)) + 3, i7, (i5 - (i6 / 2)) + 3 + i6, this.q + i7);
                this.m.draw(canvas);
            }
            this.x = !this.x;
            return;
        }
        int i8 = this.f16928i;
        int i9 = this.p;
        int i10 = this.j;
        drawable.setBounds(i8 - (i9 / 2), i10, (i8 - (i9 / 2)) + i9, this.q + i10);
        this.m.draw(canvas);
    }

    public final void d(Canvas canvas) {
        g();
        this.k.setBounds(0, 0, this.n, this.o);
        this.k.draw(canvas);
        Drawable drawable = this.l;
        int i2 = this.f16926g;
        drawable.setBounds(i2 - this.n, 0, i2, this.o);
        this.l.draw(canvas);
    }

    public final void e(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.t.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.u.k == 2) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(StringHelper.numberUniformFormat(this.u.f56273h), this.n, this.f16924e + dimensionPixelSize, this.t);
        if (this.u.k == 1) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(StringHelper.numberUniformFormat(this.u.j), (this.f16926g - this.n) - ((int) this.t.measureText(StringHelper.numberUniformFormat(this.u.j))), this.f16924e + dimensionPixelSize, this.t);
    }

    public final void f(Context context) {
        Paint paint = new Paint();
        this.t = paint;
        paint.setAntiAlias(true);
        this.t.setDither(true);
        this.t.setFilterBitmap(true);
        this.f16925f = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        g();
        this.m = SkinManager.getDrawable(R.drawable.icon_pic_vs);
        this.n = this.k.getIntrinsicWidth();
        this.o = this.k.getIntrinsicHeight();
        this.p = this.m.getIntrinsicWidth();
        this.q = this.m.getIntrinsicHeight();
        this.r = new RectF(0.0f, 0.0f, this.n, this.o);
        this.j = (this.o - this.q) / 2;
    }

    public final void g() {
        i iVar = this.u;
        if (iVar == null) {
            this.k = SkinManager.getDrawable(R.drawable.icon_pk_red_n);
            this.l = SkinManager.getDrawable(R.drawable.icon_pk_blule_n);
            return;
        }
        int i2 = iVar.k;
        if (i2 == 1) {
            this.k = SkinManager.getDrawable(R.drawable.icon_pk_red_s);
            this.l = SkinManager.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (i2 == 2) {
            this.l = SkinManager.getDrawable(R.drawable.icon_pk_blule_s);
            this.k = SkinManager.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.k = SkinManager.getDrawable(R.drawable.icon_pk_red_n);
            this.l = SkinManager.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        d(canvas);
        c(canvas);
        e(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f16924e = this.o;
        int size = View.MeasureSpec.getSize(i2);
        this.f16926g = size;
        setMeasuredDimension(size, this.f16924e + this.f16925f);
        this.f16927h = (this.f16926g - (this.n * 2)) - 100;
        if (this.s == null) {
            int i4 = this.f16926g;
            this.s = new RectF(i4 - this.n, 0.0f, i4, this.f16924e);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.u.k != 0) {
            return true;
        }
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.r.contains(motionEvent.getX(), motionEvent.getY())) {
            i iVar = this.u;
            iVar.f56273h++;
            iVar.k = 1;
        } else if (this.s.contains(motionEvent.getX(), motionEvent.getY())) {
            i iVar2 = this.u;
            iVar2.j++;
            iVar2.k = 2;
        }
        g();
        i iVar3 = this.u;
        if (iVar3.k != 0) {
            if (iVar3.f56273h + iVar3.j > 50) {
                this.w = true;
                new Thread(new a()).start();
            } else {
                invalidate();
            }
            this.v.sendPkData();
        }
        return true;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar == null || hotTopicActivity == null) {
            return;
        }
        this.u = iVar;
        this.v = hotTopicActivity;
        invalidate();
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.x = false;
        f(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.w = false;
        this.x = false;
        f(context);
    }
}
