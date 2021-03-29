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
import d.b.i0.b1.c.i;
/* loaded from: classes3.dex */
public class HotTopicPkView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f17638e;

    /* renamed from: f  reason: collision with root package name */
    public int f17639f;

    /* renamed from: g  reason: collision with root package name */
    public int f17640g;

    /* renamed from: h  reason: collision with root package name */
    public int f17641h;
    public int i;
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < 4; i++) {
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

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = false;
        this.x = false;
        f(context);
    }

    public final void b(Canvas canvas) {
        int i;
        int i2;
        i iVar = this.u;
        if (iVar.f52121h == 0 && iVar.j == 0) {
            this.i = (int) ((this.f17641h * 0.5d) + this.n + 50.0d);
        } else {
            i iVar2 = this.u;
            long j = iVar2.f52121h;
            this.i = (int) (((((float) j) / ((float) (j + iVar2.j))) * this.f17641h) + this.n + 50.0f);
        }
        if (this.u.k == 2) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.n / 2.0f, this.j, this.i, this.f17638e - i, this.t);
        if (this.u.k == 1) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.i, this.j, this.f17640g - (this.n / 2.0f), this.f17638e - i2, this.t);
    }

    public final void c(Canvas canvas) {
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_pic_vs);
        this.m = drawable;
        if (this.w) {
            if (this.x) {
                int i = this.i;
                int i2 = this.p;
                int i3 = this.j;
                drawable.setBounds((i - (i2 / 2)) - 3, i3, ((i - (i2 / 2)) - 3) + i2, this.q + i3);
                this.m.draw(canvas);
            } else {
                int i4 = this.i;
                int i5 = this.p;
                int i6 = this.j;
                drawable.setBounds((i4 - (i5 / 2)) + 3, i6, (i4 - (i5 / 2)) + 3 + i5, this.q + i6);
                this.m.draw(canvas);
            }
            this.x = !this.x;
            return;
        }
        int i7 = this.i;
        int i8 = this.p;
        int i9 = this.j;
        drawable.setBounds(i7 - (i8 / 2), i9, (i7 - (i8 / 2)) + i8, this.q + i9);
        this.m.draw(canvas);
    }

    public final void d(Canvas canvas) {
        g();
        this.k.setBounds(0, 0, this.n, this.o);
        this.k.draw(canvas);
        Drawable drawable = this.l;
        int i = this.f17640g;
        drawable.setBounds(i - this.n, 0, i, this.o);
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
        canvas.drawText(StringHelper.numberUniformFormat(this.u.f52121h), this.n, this.f17638e + dimensionPixelSize, this.t);
        if (this.u.k == 1) {
            this.t.setColor(SkinManager.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(StringHelper.numberUniformFormat(this.u.j), (this.f17640g - this.n) - ((int) this.t.measureText(StringHelper.numberUniformFormat(this.u.j))), this.f17638e + dimensionPixelSize, this.t);
    }

    public final void f(Context context) {
        Paint paint = new Paint();
        this.t = paint;
        paint.setAntiAlias(true);
        this.t.setDither(true);
        this.t.setFilterBitmap(true);
        this.f17639f = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
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
        int i = iVar.k;
        if (i == 1) {
            this.k = SkinManager.getDrawable(R.drawable.icon_pk_red_s);
            this.l = SkinManager.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (i == 2) {
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
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f17638e = this.o;
        int size = View.MeasureSpec.getSize(i);
        this.f17640g = size;
        setMeasuredDimension(size, this.f17638e + this.f17639f);
        this.f17641h = (this.f17640g - (this.n * 2)) - 100;
        if (this.s == null) {
            int i3 = this.f17640g;
            this.s = new RectF(i3 - this.n, 0.0f, i3, this.f17638e);
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
            iVar.f52121h++;
            iVar.k = 1;
        } else if (this.s.contains(motionEvent.getX(), motionEvent.getY())) {
            i iVar2 = this.u;
            iVar2.j++;
            iVar2.k = 2;
        }
        g();
        i iVar3 = this.u;
        if (iVar3.k != 0) {
            if (iVar3.f52121h + iVar3.j > 50) {
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
