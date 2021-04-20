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
    public int f13718e;

    /* renamed from: f  reason: collision with root package name */
    public int f13719f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f13720g;

    /* renamed from: h  reason: collision with root package name */
    public int f13721h;
    public PorterDuffXfermode i;
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
        this.f13720g.setXfermode(this.i);
        canvas.drawPaint(this.f13720g);
        this.f13720g.setXfermode(this.j);
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
        this.f13720g = paint;
        paint.setAntiAlias(true);
        this.f13720g.setStyle(Paint.Style.FILL);
        this.f13720g.setAntiAlias(true);
        this.k = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        setLayerType(1, null);
    }

    public void d(int i) {
        if (this.l == i) {
            return;
        }
        this.l = i;
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
        if (this.f13718e <= 0 || this.f13719f <= 0) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        a(canvas);
        canvas.rotate(45.0f, this.f13718e / 2, this.f13719f / 2);
        this.f13720g.setShadowLayer(16.0f, 5.0f, 5.0f, SkinManager.getColor(R.color.CAM_X0804));
        this.f13720g.setColor(SkinManager.getColor(this.f13721h));
        int i = this.f13718e;
        canvas.drawCircle(i / 2, this.f13719f / 2, (i / 2) - 20, this.f13720g);
        e(canvas);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f13718e = getMeasuredWidth();
        this.f13719f = getMeasuredHeight();
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13721h = R.color.CAM_X0211;
        this.i = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.j = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.l = 3;
        this.m = false;
        this.n = null;
        this.o = null;
        c();
    }
}
