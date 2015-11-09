package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class d extends TbImageView {
    private Drawable azz;

    public d(Context context) {
        super(context);
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(an.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.azz = drawable;
        if (this.azz != null) {
            this.azz.setBounds(0, 0, this.azz.getIntrinsicHeight(), this.azz.getMinimumWidth());
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.azz != null) {
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
            canvas.translate((i / 2) - (this.azz.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.azz.getIntrinsicHeight() / 2));
            this.azz.draw(canvas);
            canvas.restore();
        }
    }
}
