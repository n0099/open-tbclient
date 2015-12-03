package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AssortView extends View {
    private a aKe;
    private int apI;
    private Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void Hg();

        void gk(String str);
    }

    public AssortView(Context context) {
        super(context);
        this.apI = -1;
        init();
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apI = -1;
        init();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apI = -1;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
    }

    public void setOnTouchListener(a aVar) {
        this.aKe = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / c.akn.length;
        int length2 = c.akn.length;
        for (int i = 0; i < length2; i++) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            this.mPaint.setColor(as.getColor(n.c.cp_cont_c));
            this.mPaint.setTextSize(26.0f * f);
            canvas.drawText(c.akn[i], (width / 2) - (this.mPaint.measureText(c.akn[i]) / 2.0f), (length * i) + length, this.mPaint);
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
        int y = (int) ((motionEvent.getY() / getHeight()) * c.akn.length);
        if (y >= 0 && y < c.akn.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.apI = y;
                    if (this.aKe != null) {
                        this.aKe.gk(c.akn[this.apI]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.aKe != null) {
                        this.aKe.Hg();
                    }
                    this.apI = -1;
                    return true;
                case 2:
                    if (this.apI != y) {
                        this.apI = y;
                        if (this.aKe != null) {
                            this.aKe.gk(c.akn[this.apI]);
                            return true;
                        }
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
        this.apI = -1;
        if (this.aKe != null) {
            this.aKe.Hg();
            return true;
        }
        return true;
    }
}
