package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.x.e.c;
/* loaded from: classes4.dex */
public class VoteStatusView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f14210e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14211f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f14212g;

    /* renamed from: h  reason: collision with root package name */
    public Shader f14213h;

    /* renamed from: i  reason: collision with root package name */
    public int f14214i;
    public int j;
    public int k;
    public Path l;
    public Path m;
    public Path n;
    public Path o;
    public Path p;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.k = SkinManager.getColor(R.color.CAM_X0204);
        this.f14214i = SkinManager.getColor(R.color.CAM_X0303);
        this.j = SkinManager.getColor(R.color.CAM_X0302);
        Paint paint = new Paint();
        this.f14212g = paint;
        paint.setAntiAlias(true);
        this.f14212g.setStyle(Paint.Style.FILL);
        this.f14212g.setColor(this.k);
        this.l = new Path();
        this.m = new Path();
        this.n = new Path();
        this.o = new Path();
        this.p = new Path();
    }

    public void b(int i2) {
        this.f14214i = SkinManager.getColor(i2, R.color.CAM_X0303);
        this.j = SkinManager.getColor(i2, R.color.CAM_X0302);
        this.k = SkinManager.getColor(i2, R.color.CAM_X0204);
        this.f14211f = true;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height = (canvas.getHeight() - getPaddingBottom()) - getPaddingTop();
        int width = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
        if (height * 6 >= width) {
            height = width / 6;
        }
        int i2 = height / 2;
        float f2 = i2;
        this.l.addCircle(f2, f2, f2, Path.Direction.CW);
        float f3 = width / 2;
        this.m.addCircle(f3, f2, f2, Path.Direction.CW);
        float f4 = width - i2;
        this.n.addCircle(f4, f2, f2, Path.Direction.CW);
        float f5 = (height * 9) / 26;
        float f6 = (height * 17) / 26;
        this.o.addRect(f2, f5, f3, f6, Path.Direction.CW);
        this.p.addRect(f3, f5, f4, f6, Path.Direction.CW);
        this.f14212g.setColor(this.k);
        this.f14212g.setShader(null);
        if (this.f14213h == null || this.f14211f) {
            this.f14213h = new LinearGradient(f2, 0.0f, f4, 0.0f, this.f14214i, this.j, Shader.TileMode.CLAMP);
            this.f14211f = false;
        }
        if (this.f14210e == c.f63207c) {
            this.f14212g.setShader(this.f14213h);
        }
        canvas.drawPath(this.p, this.f14212g);
        canvas.drawPath(this.n, this.f14212g);
        if (this.f14210e == c.f63206b) {
            this.f14212g.setShader(this.f14213h);
        }
        canvas.drawPath(this.o, this.f14212g);
        canvas.drawPath(this.m, this.f14212g);
        if (this.f14210e == c.f63205a) {
            this.f14212g.setShader(this.f14213h);
        }
        canvas.drawPath(this.l, this.f14212g);
    }

    public void setStatus(int i2) {
        this.f14210e = i2;
        invalidate();
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14210e = -1;
        this.f14211f = true;
        a();
    }
}
