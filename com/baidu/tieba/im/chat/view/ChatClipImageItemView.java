package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.adp.newwidget.a.g;
import com.baidu.adp.newwidget.a.i;
import com.baidu.adp.newwidget.a.j;
import com.baidu.adp.newwidget.a.l;
import com.baidu.adp.widget.a.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ChatClipImageItemView extends TbImageView implements j {
    public int d;
    public i e;
    private boolean f;
    private final Path g;
    private boolean h;

    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.d = 0;
        this.g = new Path();
        this.h = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            for (String str : new String[]{"M040", "M045"}) {
                if (str.equalsIgnoreCase(trim)) {
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
            } catch (Exception e) {
            }
        }
        if (z) {
            this.e = new g();
        } else {
            this.e = new l();
        }
        this.e.a(this);
        this.b = this.e;
        this.b.a(this.a);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.e.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            this.e.d();
        } else if (!this.h) {
            this.e.c();
            invalidate();
        } else {
            this.h = false;
        }
    }

    @Override // com.baidu.adp.newwidget.a.b
    public void setDrawerType(int i) {
    }

    public void setLeft(boolean z) {
        this.f = z;
    }

    public void g() {
        this.e.c();
        this.e.a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b
    public a getBdImage() {
        boolean z = false;
        a bdImage = super.getBdImage();
        boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
        boolean z3 = bdImage != null && bdImage.i();
        i iVar = this.e;
        if (z3 || z2) {
            z = true;
        }
        iVar.a(z);
        return bdImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b
    public a getDefaultBdImage() {
        this.e.a(false);
        return super.getDefaultBdImage();
    }

    @Override // com.baidu.adp.newwidget.a.j
    public Path a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float width = rectF.width();
        float height = rectF.height();
        this.g.reset();
        this.g.set(a(width, height, 1.0f));
        return this.g;
    }

    private Path a(float f, float f2, float f3) {
        int a = com.baidu.adp.lib.util.j.a(getContext(), 4.0f);
        int a2 = com.baidu.adp.lib.util.j.a(getContext(), 6.0f);
        int a3 = com.baidu.adp.lib.util.j.a(getContext(), 6.0f);
        int a4 = com.baidu.adp.lib.util.j.a(getContext(), 6.0f);
        float f4 = (f - a3) - (f3 * 2.0f);
        float f5 = f2 - (f3 * 2.0f);
        Path path = new Path();
        path.offset(0.0f, 0.0f);
        if (this.f) {
            path.moveTo(a3 + f3, a + f3);
            path.quadTo(a3 + f3, f3, a3 + f3 + a, f3);
            path.lineTo(((a3 + f3) + f4) - a, f3);
            path.quadTo(a3 + f3 + f4, f3, a3 + f3 + f4, a + f3);
            path.lineTo(a3 + f3 + f4, (f3 + f5) - a);
            path.quadTo(a3 + f3 + f4, f3 + f5, (f4 + (a3 + f3)) - a, f3 + f5);
            path.lineTo(a3 + f3 + a, f3 + f5);
            path.quadTo(a3 + f3, f3 + f5, a3 + f3, (f5 + f3) - a);
            path.lineTo(a3 + f3, a2 + f3 + a4);
            path.quadTo(((a3 * 1) / 4) + f3, ((a2 * 3) / 4) + f3 + a4, f3, a4 + f3);
            path.quadTo((a3 / 2) + f3, (a2 / 4) + a4 + f3, a3 + f3, a4 + f3);
            path.lineTo(a3 + f3, a + f3);
        } else {
            path.moveTo(f3, a + f3);
            path.quadTo(f3, f3, a + f3, f3);
            path.lineTo((f3 + f4) - a, f3);
            path.quadTo(f3 + f4, f3, f3 + f4, a + f3);
            path.lineTo(f3 + f4, a4 + f3);
            path.quadTo(f3 + f4 + (a3 / 2), a4 + f3 + (a2 / 4), f3 + f4 + a3, a4 + f3);
            path.quadTo(((a3 * 3) / 4) + f3 + f4, a4 + f3 + ((a2 * 3) / 4), f3 + f4, a2 + a4 + f3);
            path.lineTo(f3 + f4, (f3 + f5) - a);
            path.quadTo(f3 + f4, f3 + f5, (f3 + f4) - a, f3 + f5);
            path.lineTo(a + f3, f3 + f5);
            path.quadTo(f3, f3 + f5, f3, (f3 + f5) - a);
            path.lineTo(f3, a);
        }
        path.close();
        return path;
    }

    @Override // com.baidu.adp.newwidget.a.j
    public void a(Canvas canvas) {
    }
}
