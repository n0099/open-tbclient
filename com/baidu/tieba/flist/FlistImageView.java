package com.baidu.tieba.flist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class FlistImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f1035a;
    private Paint b;

    public FlistImageView(Context context) {
        this(context, null, 0);
    }

    public FlistImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlistImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Paint();
    }

    public void setUrl(String str) {
        this.f1035a = str;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.widget.a.b c;
        if (this.f1035a != null && (c = com.baidu.tbadk.a.e.a().c(this.f1035a)) != null) {
            c.a(canvas, getMeasuredWidth(), getMeasuredHeight(), (Paint) null);
            Log.d("FlistImageView", "width = " + getWidth() + " height = " + getHeight());
        }
    }
}
