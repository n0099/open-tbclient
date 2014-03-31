package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tbadk.n;
/* loaded from: classes.dex */
public class TbImageView extends BDImageView {
    private static Bitmap c;
    private int d;
    private String f;
    private String g;
    private Animation h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int[] m;
    private int[] n;
    private static final PorterDuffColorFilter b = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private static int e = 0;

    public TbImageView(Context context) {
        super(context);
        this.d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = com.baidu.tbadk.i.pic_image_h_not;
        this.k = com.baidu.tbadk.i.pic_image_h_not_1;
        this.l = true;
        c();
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = com.baidu.tbadk.i.pic_image_h_not;
        this.k = com.baidu.tbadk.i.pic_image_h_not_1;
        this.l = true;
        c();
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = com.baidu.tbadk.i.pic_image_h_not;
        this.k = com.baidu.tbadk.i.pic_image_h_not_1;
        this.l = true;
        c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.TbImageView);
        this.l = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public static void setSkinMode(int i) {
        e = i;
    }

    public void setGifIconSupport(boolean z) {
        this.l = z;
    }

    @Override // com.baidu.adp.widget.ImageView.BDImageView, android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        invalidate();
    }

    public void setSuffix(String str) {
        this.g = str;
    }

    public void setImageSearchUrl(String str) {
        this.f = str;
    }

    private void c() {
        if (c == null) {
            c = BitmapFactory.decodeResource(getResources(), com.baidu.tbadk.i.icon_gif);
        }
        setDefaultScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (e == 1) {
            super.setDefaultResource(this.k);
        } else {
            super.setDefaultResource(this.j);
        }
    }

    private void e() {
        if (e == 1) {
            super.setDefaultResource(this.k);
        } else {
            super.setDefaultResource(this.j);
        }
    }

    @Override // com.baidu.adp.widget.ImageView.BDImageView
    public void setDefaultResource(int i) {
        this.j = i;
        if (this.k == 0) {
            this.k = this.j;
        }
        e();
    }

    public void setNightDefaultResource(int i) {
        this.k = i;
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getAnimation() != null) {
            setAnimation(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.adp.widget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.b getImage() {
        String str;
        if (this.f != null) {
            str = this.f;
        } else {
            str = (String) getTag();
            if (str != null && this.g != null) {
                str = String.valueOf(str) + this.g;
            }
        }
        if (str == null) {
            return null;
        }
        if (this.d == 0) {
            return com.baidu.tbadk.imageManager.e.a().c(str);
        }
        return com.baidu.tbadk.imageManager.e.a().b(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.i != e) {
            this.i = e;
            e();
            if (e == 1) {
                super.setColorFilterForSkin(b);
            } else {
                super.b();
            }
        }
        super.onDraw(canvas);
        if (super.getIsLoaded() && this.l && super.getIsGif() && this.d != 1) {
            canvas.drawBitmap(c, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void setRealShowSize(int[] iArr) {
        this.m = iArr;
    }

    public int[] getRealShowSize() {
        return this.m;
    }

    public void setCurrShowSize(int[] iArr) {
        this.n = iArr;
    }

    public int[] getCurrShowSize() {
        return this.n;
    }

    public final boolean d() {
        return getImage() != null;
    }
}
