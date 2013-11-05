package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.adp.widget.ImageView.e;
import com.baidu.tbadk.c;
import com.baidu.tbadk.imageManager.d;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.widget.ImageView.a {
    private static Bitmap b;
    private static int d = 0;
    private int c;
    private String e;
    private String f;
    private Animation g;
    private int h;
    private int i;
    private int j;
    private Paint k;
    private boolean l;
    private final RectF m;
    private boolean n;

    public void setIsShowGifTag(boolean z) {
        this.n = z;
    }

    public boolean getIsShowGifTag() {
        return this.n;
    }

    public TbImageView(Context context) {
        super(context);
        this.c = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = d;
        this.i = com.baidu.tbadk.b.pic_image_h_not;
        this.j = com.baidu.tbadk.b.pic_image_h_not_1;
        this.k = null;
        this.m = new RectF();
        this.n = true;
        b();
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = d;
        this.i = com.baidu.tbadk.b.pic_image_h_not;
        this.j = com.baidu.tbadk.b.pic_image_h_not_1;
        this.k = null;
        this.m = new RectF();
        this.n = true;
        b();
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = d;
        this.i = com.baidu.tbadk.b.pic_image_h_not;
        this.j = com.baidu.tbadk.b.pic_image_h_not_1;
        this.k = null;
        this.m = new RectF();
        this.n = true;
        b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.TbImageView);
        this.n = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public static void setSkinMode(int i) {
        d = i;
    }

    @Override // com.baidu.adp.widget.ImageView.a, android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        invalidate();
    }

    public void setSuffix(String str) {
        this.f = str;
    }

    public void setImageSearchUrl(String str) {
        this.e = str;
    }

    private void b() {
        if (b == null) {
            b = BitmapFactory.decodeResource(getResources(), com.baidu.tbadk.b.icon_gif);
        }
        this.k = new Paint();
        this.k.setColor(1275068416);
        setDefaultScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (d == 1) {
            setDefaultResource(this.j);
        } else {
            setDefaultResource(this.i);
        }
    }

    private void c() {
        if (d == 1) {
            setDefaultResource(this.j);
        } else {
            setDefaultResource(this.i);
        }
    }

    public void setDefaultId(int i) {
        this.i = i;
        if (this.j == 0) {
            this.j = this.i;
        }
        c();
    }

    public void setNightDefaultId(int i) {
        this.j = i;
        c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void a() {
        if (getAnimation() != null) {
            setAnimation(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.adp.widget.ImageView.a
    protected e getImage() {
        String str;
        if (this.e != null) {
            str = this.e;
        } else {
            str = (String) getTag();
            if (str != null && this.f != null) {
                str = str + this.f;
            }
        }
        if (str == null) {
            return null;
        }
        if (this.c == 0) {
            return d.a().c(str);
        }
        return d.a().b(str);
    }

    public void setDrawRoundCover(boolean z) {
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ImageView.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect bitmapRect;
        if (this.h != d) {
            this.h = d;
            c();
        }
        super.onDraw(canvas);
        if (super.getIsLoaded()) {
            if (super.getIsGif() && this.n) {
                canvas.drawBitmap(b, 0.0f, 0.0f, (Paint) null);
            }
            if (d == 1 && (bitmapRect = getBitmapRect()) != null) {
                if (this.l) {
                    this.m.set(getBitmapRect());
                    canvas.drawRoundRect(this.m, this.f554a, this.f554a, this.k);
                    return;
                }
                canvas.drawRect(bitmapRect, this.k);
            }
        }
    }
}
