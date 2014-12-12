package com.baidu.tbadk.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static int acg = -1;
    private int ach;
    private int aci;
    private boolean acj;
    private boolean isSelected;

    public void setIsSelected(boolean z) {
        this.isSelected = z;
        invalidate();
    }

    public a(Context context) {
        super(context);
        this.isSelected = false;
        this.ach = 0;
        this.aci = 0;
        this.acj = false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.ach = (i3 - i) - com.baidu.adp.lib.util.l.dip2px(getContext(), 5.0f);
        this.aci = (i4 - i2) - com.baidu.adp.lib.util.l.dip2px(getContext(), 5.0f);
    }

    private Bitmap getSelectIcon() {
        int i;
        if (this.isSelected) {
            i = com.baidu.tieba.v.but_posts_fit_select_s;
        } else {
            i = com.baidu.tieba.v.but_posts_fit_select_n;
        }
        return ax.bX(i);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (bitmap != null) {
            this.acj = true;
        } else {
            this.acj = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap selectIcon = getSelectIcon();
        if (selectIcon != null && this.acj) {
            canvas.drawBitmap(selectIcon, this.ach - selectIcon.getWidth(), this.aci - selectIcon.getHeight(), (Paint) null);
        }
    }
}
