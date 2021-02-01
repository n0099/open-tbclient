package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LineView extends View {
    private Paint paint;
    private Path path;

    public LineView(Context context) {
        super(context);
        init();
    }

    public LineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(ap.getColor(R.color.CAM_X0203));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(l.getDimens(getContext(), R.dimen.tbds2));
        this.paint.setPathEffect(new DashPathEffect(new float[]{l.getDimens(getContext(), R.dimen.tbds8), l.getDimens(getContext(), R.dimen.tbds8)}, 0.0f));
        this.path = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.path.reset();
        this.path.moveTo(0.0f, height);
        this.path.lineTo(getWidth(), height);
        canvas.drawPath(this.path, this.paint);
    }

    public void onChangeSkinType() {
        this.paint.setColor(ap.getColor(R.color.CAM_X0203));
        invalidate();
    }
}
