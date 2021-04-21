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
    public int f16599e;

    /* renamed from: f  reason: collision with root package name */
    public int f16600f;

    /* renamed from: g  reason: collision with root package name */
    public int f16601g;

    public TableLineGridView(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.f16601g);
            int width = childAt.getWidth() * this.f16600f;
            int height = childAt.getHeight() * this.f16599e;
            int width2 = childAt.getWidth();
            int height2 = childAt.getHeight();
            for (int i = 1; i < this.f16599e; i++) {
                float f2 = height2 * i;
                canvas.drawLine(0.0f, f2, width, f2, paint);
            }
            for (int i2 = 1; i2 < this.f16600f; i2++) {
                float f3 = width2 * i2;
                canvas.drawLine(f3, 0.0f, f3, height, paint);
            }
            super.dispatchDraw(canvas);
        }
    }

    public int getBackgroundLineResource() {
        return this.f16601g;
    }

    public int getColumnCount() {
        return this.f16600f;
    }

    public int getRowCount() {
        return this.f16599e;
    }

    public void setBackgroundLineResource(int i) {
        this.f16601g = i;
    }

    public void setColumnCount(int i) {
        this.f16600f = i;
    }

    public void setRowCount(int i) {
        this.f16599e = i;
    }

    public TableLineGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TableLineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
