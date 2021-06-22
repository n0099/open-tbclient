package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class LineView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f13331e;

    /* renamed from: f  reason: collision with root package name */
    public Path f13332f;

    public LineView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f13331e = paint;
        paint.setAntiAlias(true);
        this.f13331e.setColor(SkinManager.getColor(R.color.CAM_X0203));
        this.f13331e.setStyle(Paint.Style.STROKE);
        this.f13331e.setStrokeWidth(l.g(getContext(), R.dimen.tbds2));
        this.f13331e.setPathEffect(new DashPathEffect(new float[]{l.g(getContext(), R.dimen.tbds8), l.g(getContext(), R.dimen.tbds8)}, 0.0f));
        this.f13332f = new Path();
    }

    public void b() {
        this.f13331e.setColor(SkinManager.getColor(R.color.CAM_X0203));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13332f.reset();
        float height = getHeight() / 2;
        this.f13332f.moveTo(0.0f, height);
        this.f13332f.lineTo(getWidth(), height);
        canvas.drawPath(this.f13332f, this.f13331e);
    }

    public LineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LineView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
