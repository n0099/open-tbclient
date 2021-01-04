package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int fXj = 20;
    private static int fXk = 13;
    private static final int strokeWidth = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    private float fXl;
    private float fXm;
    private float fXn;
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
        fXj = l.getDimens(context, R.dimen.tbds94);
        fXk = l.getDimens(context, R.dimen.tbds94);
        this.paint = new Paint();
        this.paint.setColor(context.getResources().getColor(R.color.CAM_X0314));
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
            setMeasuredDimension(fXj, fXk);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(fXj, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, fXk);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.fXl = i / 2.0f;
        this.fXm = i2 / 2.0f;
        this.fXn = (Math.min(i, i2) / 2.0f) - strokeWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.fXl, this.fXm, this.fXn, this.paint);
    }

    public void onChangeSkinType() {
        this.paint.setColor(getContext().getResources().getColor(R.color.CAM_X0314));
        invalidate();
    }
}
