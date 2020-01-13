package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class LineCountNotifyTextView extends TextView {
    private a dDn;

    /* loaded from: classes.dex */
    public interface a {
        void aQn();
    }

    public LineCountNotifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setGetLineCountCallback(a aVar) {
        this.dDn = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dDn != null) {
            this.dDn.aQn();
        }
    }
}
