package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes15.dex */
public class TrapezoidButton extends LinearLayout {
    private Paint mPaint;
    private Path mPath;

    public TrapezoidButton(Context context) {
        this(context, null);
    }

    public TrapezoidButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        int height = canvas.getHeight();
        this.mPath.reset();
        this.mPath.moveTo(0.0f, 0.0f);
        this.mPath.lineTo(0.0f, height);
        this.mPath.lineTo(height * 0.45f, 0.0f);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restoreToCount(saveLayer);
    }
}
