package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AssortView extends View {
    private a aBz;
    private Paint mPaint;
    private int mPosition;

    public AssortView(Context context) {
        super(context);
        this.mPosition = -1;
        init();
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPosition = -1;
        init();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPosition = -1;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
    }

    public void setOnTouchListener(a aVar) {
        this.aBz = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / c.aeh.length;
        int length2 = c.aeh.length;
        for (int i = 0; i < length2; i++) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            this.mPaint.setColor(ay.getColor(n.cp_cont_c));
            this.mPaint.setTextSize(26.0f * f);
            canvas.drawText(c.aeh[i], (width / 2) - (this.mPaint.measureText(c.aeh[i]) / 2.0f), (length * i) + length, this.mPaint);
            this.mPaint.reset();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int y = (int) ((motionEvent.getY() / getHeight()) * c.aeh.length);
        if (y >= 0 && y < c.aeh.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mPosition = y;
                    if (this.aBz != null) {
                        this.aBz.fr(c.aeh[this.mPosition]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.aBz != null) {
                        this.aBz.FJ();
                    }
                    this.mPosition = -1;
                    return true;
                case 2:
                    if (this.mPosition != y) {
                        this.mPosition = y;
                        if (this.aBz != null) {
                            this.aBz.fr(c.aeh[this.mPosition]);
                            return true;
                        }
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
        this.mPosition = -1;
        if (this.aBz != null) {
            this.aBz.FJ();
            return true;
        }
        return true;
    }
}
