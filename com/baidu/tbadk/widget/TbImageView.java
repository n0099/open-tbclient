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
    private boolean m;
    private int[] n;
    private int[] o;
    private static final PorterDuffColorFilter b = new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY);
    private static int e = 0;

    public TbImageView(Context context) {
        super(context);
        this.d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = com.baidu.tbadk.c.pic_image_h_not;
        this.k = com.baidu.tbadk.c.pic_image_h_not_1;
        this.m = true;
        e();
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = com.baidu.tbadk.c.pic_image_h_not;
        this.k = com.baidu.tbadk.c.pic_image_h_not_1;
        this.m = true;
        e();
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = com.baidu.tbadk.c.pic_image_h_not;
        this.k = com.baidu.tbadk.c.pic_image_h_not_1;
        this.m = true;
        e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tbadk.d.TbImageView);
        this.m = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public static void setSkinMode(int i) {
        e = i;
    }

    public void setGifIconSupport(boolean z) {
        this.m = z;
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

    private void e() {
        if (c == null) {
            c = BitmapFactory.decodeResource(getResources(), com.baidu.tbadk.c.icon_gif);
        }
        setDefaultScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (e == 1) {
            super.setDefaultResource(this.k);
        } else {
            super.setDefaultResource(this.j);
        }
    }

    private void f() {
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
        f();
    }

    public void setNightDefaultResource(int i) {
        this.k = i;
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void c() {
        if (getAnimation() != null) {
            setAnimation(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.adp.widget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.d getImage() {
        String str;
        if (this.f != null) {
            str = this.f;
        } else {
            str = (String) getTag();
            if (str != null && this.g != null) {
                str = str + this.g;
            }
        }
        if (str == null) {
            return null;
        }
        if (this.d == 0) {
            return com.baidu.tbadk.imageManager.d.a().c(str);
        }
        return com.baidu.tbadk.imageManager.d.a().b(str);
    }

    public void setDrawRoundCover(boolean z) {
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.i != e) {
            this.i = e;
            f();
            if (e == 1) {
                super.setColorFilterForSkin(b);
            } else {
                super.b();
            }
        }
        super.onDraw(canvas);
        if (super.getIsLoaded() && this.m && super.getIsGif() && this.d != 1) {
            canvas.drawBitmap(c, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void setRealShowSize(int[] iArr) {
        this.n = iArr;
    }

    public int[] getRealShowSize() {
        return this.n;
    }

    public void setCurrShowSize(int[] iArr) {
        this.o = iArr;
    }

    public int[] getCurrShowSize() {
        return this.o;
    }

    public boolean d() {
        return getImage() != null;
    }
}
