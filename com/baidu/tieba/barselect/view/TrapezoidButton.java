package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class TrapezoidButton extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Paint f14339e;

    /* renamed from: f  reason: collision with root package name */
    public Path f14340f;

    public TrapezoidButton(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f14340f = new Path();
        Paint paint = new Paint();
        this.f14339e = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f14339e.setColor(-1);
        this.f14339e.setStyle(Paint.Style.FILL);
        this.f14339e.setAntiAlias(true);
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        int height = canvas.getHeight();
        this.f14340f.reset();
        this.f14340f.moveTo(0.0f, 0.0f);
        float f2 = height;
        this.f14340f.lineTo(0.0f, f2);
        this.f14340f.lineTo(f2 * 0.45f, 0.0f);
        this.f14340f.close();
        canvas.drawPath(this.f14340f, this.f14339e);
        canvas.restoreToCount(saveLayer);
    }

    public TrapezoidButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
