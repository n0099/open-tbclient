package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FRSRefreshButton extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f13042e;

    /* renamed from: f  reason: collision with root package name */
    public int f13043f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f13044g;

    /* renamed from: h  reason: collision with root package name */
    public int f13045h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffXfermode f13046i;
    public PorterDuffXfermode j;
    public Drawable k;
    public int l;
    public boolean m;
    public AlphaAnimation n;
    public AlphaAnimation o;

    public FRSRefreshButton(Context context) {
        this(context, null);
    }

    public final void a(Canvas canvas) {
        this.f13044g.setXfermode(this.f13046i);
        canvas.drawPaint(this.f13044g);
        this.f13044g.setXfermode(this.j);
    }

    public void b() {
        if (this.m) {
            AlphaAnimation alphaAnimation = this.n;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.n = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.n.setFillAfter(true);
            startAnimation(this.n);
            setClickable(false);
            this.m = false;
        }
    }

    public final void c() {
        Paint paint = new Paint();
        this.f13044g = paint;
        paint.setAntiAlias(true);
        this.f13044g.setStyle(Paint.Style.FILL);
        this.f13044g.setAntiAlias(true);
        this.k = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        setLayerType(1, null);
    }

    public void d(int i2) {
        if (this.l == i2) {
            return;
        }
        this.l = i2;
        this.k = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        invalidate();
    }

    public final void e(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        canvas.save();
        canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        int width = (getWidth() / 2) - (this.k.getIntrinsicWidth() / 2);
        int height = (getHeight() / 2) - (this.k.getIntrinsicHeight() / 2);
        int height2 = (getHeight() / 2) + (this.k.getIntrinsicHeight() / 2);
        this.k.setBounds(width + 3, height + 3, ((getWidth() / 2) + (this.k.getIntrinsicWidth() / 2)) - 3, height2 - 3);
        this.k.draw(canvas);
        canvas.restore();
    }

    public void f() {
        if (this.m) {
            return;
        }
        setVisibility(0);
        AlphaAnimation alphaAnimation = this.o;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.o = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.o.setFillAfter(true);
        startAnimation(this.o);
        setClickable(true);
        this.m = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13042e <= 0 || this.f13043f <= 0) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        a(canvas);
        canvas.rotate(45.0f, this.f13042e / 2, this.f13043f / 2);
        this.f13044g.setShadowLayer(16.0f, 5.0f, 5.0f, SkinManager.getColor(R.color.CAM_X0804));
        this.f13044g.setColor(SkinManager.getColor(this.f13045h));
        int i2 = this.f13042e;
        canvas.drawCircle(i2 / 2, this.f13043f / 2, (i2 / 2) - 20, this.f13044g);
        e(canvas);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f13042e = getMeasuredWidth();
        this.f13043f = getMeasuredHeight();
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13045h = R.color.CAM_X0211;
        this.f13046i = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.j = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.l = 3;
        this.m = false;
        this.n = null;
        this.o = null;
        c();
    }
}
