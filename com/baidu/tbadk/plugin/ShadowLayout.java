package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int dvd;
    private int fIO;
    private int fIP;
    private int fIQ;
    private int fIR;
    private int mShadowRadius;
    private Paint paint;
    private RectF rectF;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        sa();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        sa();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sa();
    }

    private void sa() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.fIO = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fIO, this.fIO, this.fIO, this.fIO);
        this.fIR = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fIP = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fIQ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dvd = ao.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fIP, this.fIQ, this.dvd);
        this.rectF = new RectF();
    }

    public void setShadowColor(int i) {
        this.dvd = ao.getColor(i);
        bEd();
    }

    private void bEd() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fIP, this.fIQ, this.dvd);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rectF.left = getPaddingLeft();
        this.rectF.right = getWidth() - getPaddingRight();
        this.rectF.bottom = getHeight() - getPaddingBottom();
        this.rectF.top = getPaddingTop();
        canvas.drawRoundRect(this.rectF, this.fIR, this.fIR, this.paint);
    }
}
