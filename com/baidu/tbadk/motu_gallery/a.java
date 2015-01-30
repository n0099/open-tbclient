package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static int acE = -1;
    private int acF;
    private int acG;
    private boolean acH;
    private boolean isSelected;

    public void setIsSelected(boolean z) {
        this.isSelected = z;
        invalidate();
    }

    public a(Context context) {
        super(context);
        this.isSelected = false;
        this.acF = 0;
        this.acG = 0;
        this.acH = false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.acF = (i3 - i) - com.baidu.adp.lib.util.l.dip2px(getContext(), 5.0f);
        this.acG = (i4 - i2) - com.baidu.adp.lib.util.l.dip2px(getContext(), 5.0f);
    }

    private Bitmap getSelectIcon() {
        int i;
        if (this.isSelected) {
            i = com.baidu.tieba.v.but_posts_fit_select_s;
        } else {
            i = com.baidu.tieba.v.but_posts_fit_select_n;
        }
        return bc.ce(i);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.acH = true;
        } else {
            this.acH = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap selectIcon = getSelectIcon();
        if (selectIcon != null && this.acH) {
            canvas.drawBitmap(selectIcon, this.acF - selectIcon.getWidth(), this.acG - selectIcon.getHeight(), (Paint) null);
        }
    }
}
