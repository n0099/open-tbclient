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
import d.b.i0.v.e.d;
/* loaded from: classes4.dex */
public class VoteStatusView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f15218e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15219f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f15220g;

    /* renamed from: h  reason: collision with root package name */
    public Shader f15221h;
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
        this.f15220g = paint;
        paint.setAntiAlias(true);
        this.f15220g.setStyle(Paint.Style.FILL);
        this.f15220g.setColor(this.k);
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
        this.f15219f = true;
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
        this.f15220g.setColor(this.k);
        this.f15220g.setShader(null);
        if (this.f15221h == null || this.f15219f) {
            this.f15221h = new LinearGradient(f2, 0.0f, f4, 0.0f, this.i, this.j, Shader.TileMode.CLAMP);
            this.f15219f = false;
        }
        if (this.f15218e == d.f61960c) {
            this.f15220g.setShader(this.f15221h);
        }
        canvas.drawPath(this.p, this.f15220g);
        canvas.drawPath(this.n, this.f15220g);
        if (this.f15218e == d.f61959b) {
            this.f15220g.setShader(this.f15221h);
        }
        canvas.drawPath(this.o, this.f15220g);
        canvas.drawPath(this.m, this.f15220g);
        if (this.f15218e == d.f61958a) {
            this.f15220g.setShader(this.f15221h);
        }
        canvas.drawPath(this.l, this.f15220g);
    }

    public void setStatus(int i) {
        this.f15218e = i;
        invalidate();
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15218e = -1;
        this.f15219f = true;
        a();
    }
}
