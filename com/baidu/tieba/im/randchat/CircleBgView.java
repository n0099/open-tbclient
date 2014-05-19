package com.baidu.tieba.im.randchat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class CircleBgView extends FrameLayout {
    private int a;
    private int b;
    private Paint c;
    private RectF d;
    private int e;
    private boolean f;

    public void setHasBg(boolean z) {
        this.f = z;
    }

    public CircleBgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        a(context);
    }

    public CircleBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = true;
        a(context);
    }

    public CircleBgView(Context context) {
        super(context);
        this.f = true;
        a(context);
    }

    private void a(Context context) {
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.d = new RectF();
        this.e = context.getResources().getColor(com.baidu.tieba.o.white);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a = getWidth();
        this.b = getHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f) {
            this.c.setColor(this.e);
            this.d.set(0.0f, 0.0f, this.a, this.b);
            canvas.drawRoundRect(this.d, this.a / 2, this.a / 2, this.c);
        }
    }
}
