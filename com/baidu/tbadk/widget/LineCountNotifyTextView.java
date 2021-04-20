package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class LineCountNotifyTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public a f13726e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public LineCountNotifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.f13726e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setGetLineCountCallback(a aVar) {
        this.f13726e = aVar;
    }
}
