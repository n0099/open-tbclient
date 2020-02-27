package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int dEZ;
    private int dFa;
    private int dFb;
    private int dFc;
    private int dcQ;
    private RectF jH;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        lQ();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        lQ();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lQ();
    }

    private void lQ() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.dEZ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.dEZ, this.dEZ, this.dEZ, this.dEZ);
        this.dFc = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.dFa = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.dFb = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dcQ = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.dFa, this.dFb, this.dcQ);
        this.jH = new RectF();
    }

    public void setShadowColor(int i) {
        this.dcQ = am.getColor(i);
        aRu();
    }

    private void aRu() {
        this.paint.setShadowLayer(this.mShadowRadius, this.dFa, this.dFb, this.dcQ);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.jH.left = getPaddingLeft();
        this.jH.right = getWidth() - getPaddingRight();
        this.jH.bottom = getHeight() - getPaddingBottom();
        this.jH.top = getPaddingTop();
        canvas.drawRoundRect(this.jH, this.dFc, this.dFc, this.paint);
    }
}
