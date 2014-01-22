package com.baidu.tieba.im.randchat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CircleBgView extends FrameLayout {
    private Context a;
    private int b;
    private int c;
    private Paint d;
    private RectF e;
    private int f;
    private boolean g;

    public void setHasBg(boolean z) {
        this.g = z;
    }

    public CircleBgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = true;
        a(context);
    }

    public CircleBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = true;
        a(context);
    }

    public CircleBgView(Context context) {
        super(context);
        this.g = true;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.e = new RectF();
        this.f = context.getResources().getColor(R.color.white);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b = getWidth();
        this.c = getHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g) {
            this.d.setColor(this.f);
            this.e.set(0.0f, 0.0f, this.b, this.c);
            canvas.drawRoundRect(this.e, this.b / 2, this.b / 2, this.d);
        }
    }
}
