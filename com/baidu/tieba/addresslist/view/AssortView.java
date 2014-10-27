package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.relationship.o;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class AssortView extends View {
    private int Uy;
    private a ahj;
    private Paint gs;

    public AssortView(Context context) {
        super(context);
        this.Uy = -1;
        init();
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Uy = -1;
        init();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Uy = -1;
        init();
    }

    private void init() {
        this.gs = new Paint();
    }

    public void setOnTouchListener(a aVar) {
        this.ahj = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / o.Mu.length;
        int length2 = o.Mu.length;
        for (int i = 0; i < length2; i++) {
            this.gs.setAntiAlias(true);
            this.gs.setTypeface(Typeface.DEFAULT_BOLD);
            this.gs.setColor(aw.getColor(s.cp_cont_c));
            this.gs.setTextSize(26.0f * f);
            canvas.drawText(o.Mu[i], (width / 2) - (this.gs.measureText(o.Mu[i]) / 2.0f), (length * i) + length, this.gs);
            this.gs.reset();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int y = (int) ((motionEvent.getY() / getHeight()) * o.Mu.length);
        if (y >= 0 && y < o.Mu.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Uy = y;
                    if (this.ahj != null) {
                        this.ahj.eg(o.Mu[this.Uy]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.ahj != null) {
                        this.ahj.xx();
                    }
                    this.Uy = -1;
                    return true;
                case 2:
                    if (this.Uy != y) {
                        this.Uy = y;
                        if (this.ahj != null) {
                            this.ahj.eg(o.Mu[this.Uy]);
                            return true;
                        }
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
        this.Uy = -1;
        if (this.ahj != null) {
            this.ahj.xx();
            return true;
        }
        return true;
    }
}
