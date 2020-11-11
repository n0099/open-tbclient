package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class CircleView extends View {
    private static int fGr = 20;
    private static int fGs = 13;
    private static final int strokeWidth = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    private float fGt;
    private float fGu;
    private float fGv;
    private Paint paint;

    public CircleView(Context context) {
        super(context);
        init(context);
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        fGr = l.getDimens(context, R.dimen.tbds94);
        fGs = l.getDimens(context, R.dimen.tbds94);
        this.paint = new Paint();
        this.paint.setColor(context.getResources().getColor(R.color.cp_other_h));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(strokeWidth);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(fGr, fGs);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(fGr, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, fGs);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.fGt = i / 2.0f;
        this.fGu = i2 / 2.0f;
        this.fGv = (Math.min(i, i2) / 2.0f) - strokeWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.fGt, this.fGu, this.fGv, this.paint);
    }

    public void onChangeSkinType() {
        this.paint.setColor(getContext().getResources().getColor(R.color.cp_other_h));
        invalidate();
    }
}
