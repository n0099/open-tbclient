package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class d extends TbImageView {
    private Drawable aCd;

    public d(Context context) {
        super(context);
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(al.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aCd = drawable;
        if (this.aCd != null) {
            this.aCd.setBounds(0, 0, this.aCd.getIntrinsicHeight(), this.aCd.getMinimumWidth());
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aCd != null) {
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
            canvas.translate((i / 2) - (this.aCd.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.aCd.getIntrinsicHeight() / 2));
            this.aCd.draw(canvas);
            canvas.restore();
        }
    }
}
