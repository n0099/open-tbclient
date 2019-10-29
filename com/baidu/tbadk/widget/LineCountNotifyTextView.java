package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class LineCountNotifyTextView extends TextView {
    private a cPX;

    /* loaded from: classes.dex */
    public interface a {
        void aye();
    }

    public LineCountNotifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setGetLineCountCallback(a aVar) {
        this.cPX = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cPX != null) {
            this.cPX.aye();
        }
    }
}
