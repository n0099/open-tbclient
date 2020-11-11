package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class AssortView extends View {
    private a fVi;
    private Paint mPaint;
    private int mPosition;

    /* loaded from: classes21.dex */
    public interface a {
        void Fs(String str);

        void bJM();
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
        this.fVi = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / c.fgy.length;
        int length2 = c.fgy.length;
        for (int i = 0; i < length2; i++) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            this.mPaint.setColor(ap.getColor(R.color.cp_cont_c));
            this.mPaint.setTextSize(26.0f * f);
            canvas.drawText(c.fgy[i], (width / 2.0f) - (this.mPaint.measureText(c.fgy[i]) / 2.0f), (length * i) + length, this.mPaint);
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
        int y = (int) ((motionEvent.getY() / getHeight()) * c.fgy.length);
        if (y >= 0 && y < c.fgy.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mPosition = y;
                    if (this.fVi != null) {
                        this.fVi.Fs(c.fgy[this.mPosition]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.fVi != null) {
                        this.fVi.bJM();
                    }
                    this.mPosition = -1;
                    return true;
                case 2:
                    if (this.mPosition != y) {
                        this.mPosition = y;
                        if (this.fVi != null) {
                            this.fVi.Fs(c.fgy[this.mPosition]);
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
        if (this.fVi != null) {
            this.fVi.bJM();
            return true;
        }
        return true;
    }
}
