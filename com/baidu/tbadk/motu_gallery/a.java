package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static int Wb = -1;
    private int Wc;
    private int Wd;
    private boolean We;
    private boolean isSelected;

    public void setIsSelected(boolean z) {
        this.isSelected = z;
        invalidate();
    }

    public a(Context context) {
        super(context);
        this.isSelected = false;
        this.Wc = 0;
        this.Wd = 0;
        this.We = false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.Wc = (i3 - i) - com.baidu.adp.lib.util.m.dip2px(getContext(), 5.0f);
        this.Wd = (i4 - i2) - com.baidu.adp.lib.util.m.dip2px(getContext(), 5.0f);
    }

    private Bitmap getSelectIcon() {
        int i;
        if (this.isSelected) {
            i = com.baidu.tieba.u.but_posts_fit_select_s;
        } else {
            i = com.baidu.tieba.u.but_posts_fit_select_n;
        }
        return aw.bA(i);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.We = true;
        } else {
            this.We = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap selectIcon = getSelectIcon();
        if (selectIcon != null && this.We) {
            canvas.drawBitmap(selectIcon, this.Wc - selectIcon.getWidth(), this.Wd - selectIcon.getHeight(), (Paint) null);
        }
    }
}
