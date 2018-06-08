package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class AssortView extends View {
    private a bnZ;
    private Paint mPaint;
    private int mPosition;

    /* loaded from: classes3.dex */
    public interface a {
        void QJ();

        void iH(String str);
    }

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
        this.bnZ = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / c.aEW.length;
        int length2 = c.aEW.length;
        for (int i = 0; i < length2; i++) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            this.mPaint.setColor(al.getColor(d.C0141d.cp_cont_c));
            this.mPaint.setTextSize(26.0f * f);
            canvas.drawText(c.aEW[i], (width / 2.0f) - (this.mPaint.measureText(c.aEW[i]) / 2.0f), (length * i) + length, this.mPaint);
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
        int y = (int) ((motionEvent.getY() / getHeight()) * c.aEW.length);
        if (y >= 0 && y < c.aEW.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mPosition = y;
                    if (this.bnZ != null) {
                        this.bnZ.iH(c.aEW[this.mPosition]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.bnZ != null) {
                        this.bnZ.QJ();
                    }
                    this.mPosition = -1;
                    return true;
                case 2:
                    if (this.mPosition != y) {
                        this.mPosition = y;
                        if (this.bnZ != null) {
                            this.bnZ.iH(c.aEW[this.mPosition]);
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
        if (this.bnZ != null) {
            this.bnZ.QJ();
            return true;
        }
        return true;
    }
}
