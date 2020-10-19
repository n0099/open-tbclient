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
    private static int fse = 20;
    private static int fsf = 13;
    private static final int strokeWidth = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
    private float fsg;
    private float fsh;
    private float fsi;
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
        fse = l.getDimens(context, R.dimen.tbds94);
        fsf = l.getDimens(context, R.dimen.tbds94);
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
            setMeasuredDimension(fse, fsf);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(fse, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, fsf);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.fsg = i / 2.0f;
        this.fsh = i2 / 2.0f;
        this.fsi = (Math.min(i, i2) / 2.0f) - strokeWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.fsg, this.fsh, this.fsi, this.paint);
    }

    public void onChangeSkinType() {
        this.paint.setColor(getContext().getResources().getColor(R.color.cp_other_h));
        invalidate();
    }
}
