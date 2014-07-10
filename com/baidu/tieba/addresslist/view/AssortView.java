package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.relationship.n;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class AssortView extends View {
    private Paint a;
    private int b;
    private a c;

    public AssortView(Context context) {
        super(context);
        this.b = -1;
        a();
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        a();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        a();
    }

    private void a() {
        this.a = new Paint();
    }

    public void setOnTouchListener(a aVar) {
        this.c = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f = (float) (width / 48.0d);
        int length = height / n.a.length;
        int length2 = n.a.length;
        for (int i = 0; i < length2; i++) {
            this.a.setAntiAlias(true);
            this.a.setTypeface(Typeface.DEFAULT_BOLD);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.a.setColor(getResources().getColor(s.cp_cont_c_1));
            } else {
                this.a.setColor(getResources().getColor(s.cp_cont_c));
            }
            this.a.setTextSize(26.0f * f);
            canvas.drawText(n.a[i], (width / 2) - (this.a.measureText(n.a[i]) / 2.0f), (length * i) + length, this.a);
            this.a.reset();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int y = (int) ((motionEvent.getY() / getHeight()) * n.a.length);
        if (y >= 0 && y < n.a.length) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.b = y;
                    if (this.c != null) {
                        this.c.c(n.a[this.b]);
                        return true;
                    }
                    return true;
                case 1:
                    if (this.c != null) {
                        this.c.a();
                    }
                    this.b = -1;
                    return true;
                case 2:
                    if (this.b != y) {
                        this.b = y;
                        if (this.c != null) {
                            this.c.c(n.a[this.b]);
                            return true;
                        }
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
        this.b = -1;
        if (this.c != null) {
            this.c.a();
            return true;
        }
        return true;
    }
}
