package com.baidu.tieba.gift.giftTab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.view.BdGridView;
/* loaded from: classes4.dex */
public class TableLineGridView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public int f16209e;

    /* renamed from: f  reason: collision with root package name */
    public int f16210f;

    /* renamed from: g  reason: collision with root package name */
    public int f16211g;

    public TableLineGridView(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.f16211g);
            int width = childAt.getWidth() * this.f16210f;
            int height = childAt.getHeight() * this.f16209e;
            int width2 = childAt.getWidth();
            int height2 = childAt.getHeight();
            for (int i2 = 1; i2 < this.f16209e; i2++) {
                float f2 = height2 * i2;
                canvas.drawLine(0.0f, f2, width, f2, paint);
            }
            for (int i3 = 1; i3 < this.f16210f; i3++) {
                float f3 = width2 * i3;
                canvas.drawLine(f3, 0.0f, f3, height, paint);
            }
            super.dispatchDraw(canvas);
        }
    }

    public int getBackgroundLineResource() {
        return this.f16211g;
    }

    public int getColumnCount() {
        return this.f16210f;
    }

    public int getRowCount() {
        return this.f16209e;
    }

    public void setBackgroundLineResource(int i2) {
        this.f16211g = i2;
    }

    public void setColumnCount(int i2) {
        this.f16210f = i2;
    }

    public void setRowCount(int i2) {
        this.f16209e = i2;
    }

    public TableLineGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public TableLineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
