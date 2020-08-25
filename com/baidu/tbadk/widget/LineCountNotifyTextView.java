package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class LineCountNotifyTextView extends TextView {
    private a eWi;

    /* loaded from: classes2.dex */
    public interface a {
        void bvZ();
    }

    public LineCountNotifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setGetLineCountCallback(a aVar) {
        this.eWi = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eWi != null) {
            this.eWi.bvZ();
        }
    }
}
