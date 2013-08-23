package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.c;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.widget.a.a {
    private static int d = 0;
    private Bitmap b;
    private int c;
    private boolean e;
    private String f;
    private String g;
    private Animation h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private Paint m;
    private boolean n;
    private final RectF o;

    public TbImageView(Context context) {
        super(context);
        this.b = BitmapFactory.decodeResource(getResources(), c.icon_gif);
        this.c = 0;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = d;
        this.k = c.pic_image_h_not;
        this.l = c.pic_image_h_not_1;
        this.m = null;
        this.o = new RectF();
        d();
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = BitmapFactory.decodeResource(getResources(), c.icon_gif);
        this.c = 0;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = d;
        this.k = c.pic_image_h_not;
        this.l = c.pic_image_h_not_1;
        this.m = null;
        this.o = new RectF();
        d();
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = BitmapFactory.decodeResource(getResources(), c.icon_gif);
        this.c = 0;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = d;
        this.k = c.pic_image_h_not;
        this.l = c.pic_image_h_not_1;
        this.m = null;
        this.o = new RectF();
        d();
    }

    public static void setSkinMode(int i) {
        d = i;
    }

    @Override // com.baidu.adp.widget.a.a, android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
    }

    public void setSuffix(String str) {
        this.g = str;
    }

    public void setImageSearchUrl(String str) {
        this.f = str;
    }

    private void d() {
        this.m = new Paint();
        this.m.setColor(1275068416);
        setDefaultScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (d == 1) {
            setDefaultResource(this.l);
        } else {
            setDefaultResource(this.k);
        }
    }

    private void e() {
        if (d == 1) {
            setDefaultResource(this.l);
        } else {
            setDefaultResource(this.k);
        }
    }

    public void setDefaultId(int i) {
        this.k = i;
        if (this.l == 0) {
            this.l = this.k;
        }
        e();
    }

    public void setNightDefaultId(int i) {
        this.l = i;
        e();
    }

    public void b() {
        if (this.h == null) {
            this.h = AnimationUtils.loadAnimation(getContext(), com.baidu.tbadk.b.tb_image_anim);
        }
        startAnimation(this.h);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
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

    @Override // com.baidu.adp.widget.a.a
    protected com.baidu.adp.widget.a.b getImage() {
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
        if (this.c == 0) {
            return e.a().c(str);
        }
        return e.a().b(str);
    }

    public void setDrawRoundCover(boolean z) {
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.a.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect bitmapRect;
        if (this.j != d) {
            this.j = d;
            e();
        }
        super.onDraw(canvas);
        if (super.getIsLoaded()) {
            if (!this.i) {
                this.i = true;
                if (this.e) {
                    b();
                }
            }
            if (super.getIsGif()) {
                canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
            }
            if (d == 1 && (bitmapRect = getBitmapRect()) != null) {
                if (this.n) {
                    this.o.set(getBitmapRect());
                    canvas.drawRoundRect(this.o, this.f502a, this.f502a, this.m);
                    return;
                }
                canvas.drawRect(bitmapRect, this.m);
                return;
            }
            return;
        }
        this.i = false;
    }
}
