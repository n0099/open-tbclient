package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class TurnTableLuckyArrowView extends View {
    private Paint mPaint;
    private Path mPath;

    public TurnTableLuckyArrowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mPath.reset();
        this.mPath.moveTo(i * 0.5f, i2);
        this.mPath.lineTo(0.0f, 0.0f);
        this.mPath.lineTo(i, 0.0f);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init() {
        this.mPaint = new Paint(1);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-2199);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
    }
}
