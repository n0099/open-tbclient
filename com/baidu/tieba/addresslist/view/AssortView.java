package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AssortView extends View {
    private a eRf;
    private Paint mPaint;
    private int mPosition;

    /* loaded from: classes8.dex */
    public interface a {
        void Ae(String str);

        void bmT();
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
        this.eRf = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / c.eeA.length;
        int length2 = c.eeA.length;
        for (int i = 0; i < length2; i++) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            this.mPaint.setColor(am.getColor(R.color.cp_cont_c));
            this.mPaint.setTextSize(26.0f * f);
            canvas.drawText(c.eeA[i], (width / 2.0f) - (this.mPaint.measureText(c.eeA[i]) / 2.0f), (length * i) + length, this.mPaint);
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
        int y = (int) ((motionEvent.getY() / getHeight()) * c.eeA.length);
        if (y >= 0 && y < c.eeA.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mPosition = y;
                    if (this.eRf != null) {
                        this.eRf.Ae(c.eeA[this.mPosition]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.eRf != null) {
                        this.eRf.bmT();
                    }
                    this.mPosition = -1;
                    return true;
                case 2:
                    if (this.mPosition != y) {
                        this.mPosition = y;
                        if (this.eRf != null) {
                            this.eRf.Ae(c.eeA[this.mPosition]);
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
        if (this.eRf != null) {
            this.eRf.bmT();
            return true;
        }
        return true;
    }
}
