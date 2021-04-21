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
import d.b.j0.v.e.d;
/* loaded from: classes4.dex */
public class VoteStatusView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f14890e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14891f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f14892g;

    /* renamed from: h  reason: collision with root package name */
    public Shader f14893h;
    public int i;
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
        this.i = SkinManager.getColor(R.color.CAM_X0303);
        this.j = SkinManager.getColor(R.color.CAM_X0302);
        Paint paint = new Paint();
        this.f14892g = paint;
        paint.setAntiAlias(true);
        this.f14892g.setStyle(Paint.Style.FILL);
        this.f14892g.setColor(this.k);
        this.l = new Path();
        this.m = new Path();
        this.n = new Path();
        this.o = new Path();
        this.p = new Path();
    }

    public void b(int i) {
        this.i = SkinManager.getColor(i, R.color.CAM_X0303);
        this.j = SkinManager.getColor(i, R.color.CAM_X0302);
        this.k = SkinManager.getColor(i, R.color.CAM_X0204);
        this.f14891f = true;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height = (canvas.getHeight() - getPaddingBottom()) - getPaddingTop();
        int width = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
        if (height * 6 >= width) {
            height = width / 6;
        }
        int i = height / 2;
        float f2 = i;
        this.l.addCircle(f2, f2, f2, Path.Direction.CW);
        float f3 = width / 2;
        this.m.addCircle(f3, f2, f2, Path.Direction.CW);
        float f4 = width - i;
        this.n.addCircle(f4, f2, f2, Path.Direction.CW);
        float f5 = (height * 9) / 26;
        float f6 = (height * 17) / 26;
        this.o.addRect(f2, f5, f3, f6, Path.Direction.CW);
        this.p.addRect(f3, f5, f4, f6, Path.Direction.CW);
        this.f14892g.setColor(this.k);
        this.f14892g.setShader(null);
        if (this.f14893h == null || this.f14891f) {
            this.f14893h = new LinearGradient(f2, 0.0f, f4, 0.0f, this.i, this.j, Shader.TileMode.CLAMP);
            this.f14891f = false;
        }
        if (this.f14890e == d.f63391c) {
            this.f14892g.setShader(this.f14893h);
        }
        canvas.drawPath(this.p, this.f14892g);
        canvas.drawPath(this.n, this.f14892g);
        if (this.f14890e == d.f63390b) {
            this.f14892g.setShader(this.f14893h);
        }
        canvas.drawPath(this.o, this.f14892g);
        canvas.drawPath(this.m, this.f14892g);
        if (this.f14890e == d.f63389a) {
            this.f14892g.setShader(this.f14893h);
        }
        canvas.drawPath(this.l, this.f14892g);
    }

    public void setStatus(int i) {
        this.f14890e = i;
        invalidate();
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14890e = -1;
        this.f14891f = true;
        a();
    }
}
