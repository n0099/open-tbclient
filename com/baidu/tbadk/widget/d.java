package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class d extends TbImageView {
    private Drawable aAA;

    public d(Context context) {
        super(context);
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(am.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aAA = drawable;
        if (this.aAA != null) {
            this.aAA.setBounds(0, 0, this.aAA.getIntrinsicHeight(), this.aAA.getMinimumWidth());
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aAA != null) {
            canvas.save();
            ViewParent parent = getParent();
            if (!(parent instanceof View)) {
                i = 0;
            } else {
                i = ((View) parent).getMeasuredWidth();
            }
            int width = getWidth();
            if (width <= i) {
                i = width;
            }
            canvas.translate((i / 2) - (this.aAA.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.aAA.getIntrinsicHeight() / 2));
            this.aAA.draw(canvas);
            canvas.restore();
        }
    }
}
