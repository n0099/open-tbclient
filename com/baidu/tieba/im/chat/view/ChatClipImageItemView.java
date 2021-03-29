package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import d.b.b.e.p.l;
import d.b.b.f.a.h;
import d.b.b.f.a.k;
import d.b.b.f.a.n;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class ChatClipImageItemView extends TbImageView implements k.a {
    public a A0;
    public boolean w0;
    public k x0;
    public final Path y0;
    public boolean z0;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Canvas canvas);
    }

    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
    }

    @Override // d.b.b.f.a.k.a
    public Path a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float width = rectF.width();
        float height = rectF.height();
        this.y0.reset();
        this.y0.set(g0(width, height, 1.0f));
        return this.y0;
    }

    @Override // d.b.b.f.a.k.a
    public void b(Canvas canvas) {
    }

    public final void f0(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            String[] strArr = {"M040", "M045"};
            for (int i2 = 0; i2 < 2; i2++) {
                if (strArr[i2].equalsIgnoreCase(trim)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (Build.VERSION.SDK_INT >= 11) {
            CompatibleUtile.getInstance().closeViewGpu(this);
            try {
                Method method = getClass().getMethod("setLayerType", Integer.TYPE, Paint.class);
                if (method != null) {
                    method.invoke(this, 1, null);
                }
            } catch (Exception unused) {
            }
        }
        if (!z) {
            this.x0 = new n();
        } else {
            this.x0 = new h();
        }
        this.f2182h.n = true;
        this.x0.t(this);
        k kVar = this.x0;
        this.i = kVar;
        kVar.p(this.f2182h);
    }

    public final Path g0(float f2, float f3, float f4) {
        int e2 = l.e(getContext(), 4.0f);
        int e3 = l.e(getContext(), 12.0f);
        int e4 = l.e(getContext(), 6.0f);
        int e5 = l.e(getContext(), 10.0f);
        float f5 = e4;
        float f6 = 2.0f * f4;
        float f7 = (f2 - f5) - f6;
        float f8 = f3 - f6;
        Path path = new Path();
        path.offset(0.0f, 0.0f);
        if (this.w0) {
            float f9 = f5 + f4;
            float f10 = e2;
            float f11 = f4 + f10;
            path.moveTo(f9, f11);
            float f12 = f9 + f10;
            path.quadTo(f9, f4, f12, f4);
            float f13 = f7 + f9;
            float f14 = f13 - f10;
            path.lineTo(f14, f4);
            path.quadTo(f13, f4, f13, f11);
            float f15 = f8 + f4;
            float f16 = f15 - f10;
            path.lineTo(f13, f16);
            path.quadTo(f13, f15, f14, f15);
            path.lineTo(f12, f15);
            path.quadTo(f9, f15, f9, f16);
            float f17 = e5;
            path.lineTo(f9, e3 + f4 + f17);
            float f18 = 1 + f4;
            int i = e5 + (e3 / 2);
            path.lineTo(f18, i + 1);
            path.lineTo(f18, i - 1);
            path.lineTo(f9, f4 + f17);
            path.lineTo(f9, f11);
        } else {
            float f19 = e2;
            float f20 = f4 + f19;
            path.moveTo(f4, f20);
            path.quadTo(f4, f4, f20, f4);
            float f21 = f7 + f4;
            float f22 = f21 - f19;
            path.lineTo(f22, f4);
            path.quadTo(f21, f4, f21, f20);
            float f23 = e5 + f4;
            path.lineTo(f21, f23);
            float f24 = 1;
            float f25 = (f5 + f21) - f24;
            float f26 = (e3 / 2) + f23;
            path.lineTo(f25, f26 - f24);
            path.lineTo(f25, f26 + f24);
            path.lineTo(f21, f23 + e3);
            float f27 = f8 + f4;
            float f28 = f27 - f19;
            path.lineTo(f21, f28);
            path.quadTo(f21, f27, f22, f27);
            path.lineTo(f20, f27);
            path.quadTo(f4, f27, f4, f28);
            path.lineTo(f4, f19);
        }
        path.close();
        return path;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public d.b.b.j.d.a getBdImage() {
        d.b.b.j.d.a bdImage = super.getBdImage();
        boolean z = true;
        boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
        boolean z3 = bdImage != null && bdImage.w();
        k kVar = this.x0;
        if (!z3 && !z2) {
            z = false;
        }
        kVar.u(z);
        return bdImage;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public d.b.b.j.d.a getDefaultBdImage() {
        this.x0.u(false);
        return super.getDefaultBdImage();
    }

    public void h0() {
        this.x0.r();
        this.x0.u(true);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a aVar = this.A0;
        if (aVar == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0204);
        } else {
            aVar.a(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.x0.s();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            this.x0.s();
        } else if (!this.z0) {
            this.x0.r();
            invalidate();
        } else {
            this.z0 = false;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
    }

    public void setLeft(boolean z) {
        this.w0 = z;
    }

    public void setOnDrawCallback(a aVar) {
        this.A0 = aVar;
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w0 = true;
        this.y0 = new Path();
        this.z0 = true;
        this.A0 = null;
        f0(context, attributeSet, i);
    }
}
