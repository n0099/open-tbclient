package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.newwidget.a.h;
import com.baidu.adp.newwidget.a.j;
import com.baidu.adp.newwidget.a.k;
import com.baidu.adp.newwidget.a.n;
import com.baidu.adp.widget.a.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.v;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ChatClipImageItemView extends TbImageView implements k {
    private boolean aUw;
    public j aUx;
    private boolean aUy;
    public int position;
    private final Path ry;

    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUw = true;
        this.position = 0;
        this.ry = new Path();
        this.aUy = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            String[] strArr = {"M040", "M045"};
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (strArr[i2].equalsIgnoreCase(trim)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        }
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
            this.aUx = new h();
        } else {
            this.aUx = new n();
        }
        this.qH.rr = true;
        this.qH.ro = getResources().getDrawable(v.icon_im_gif);
        this.aUx.a(this);
        this.qR = this.aUx;
        this.qR.a(this.qH);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.aUx.gI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            this.aUx.gI();
        } else if (!this.aUy) {
            this.aUx.gH();
            invalidate();
        } else {
            this.aUy = false;
        }
    }

    @Override // com.baidu.adp.newwidget.a.b
    public void setDrawerType(int i) {
    }

    public void setLeft(boolean z) {
        this.aUw = z;
    }

    public void KT() {
        this.aUx.gH();
        this.aUx.E(true);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b
    public a getBdImage() {
        boolean z = false;
        a bdImage = super.getBdImage();
        boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
        boolean z3 = bdImage != null && bdImage.jj();
        j jVar = this.aUx;
        if (z3 || z2) {
            z = true;
        }
        jVar.E(z);
        return bdImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b
    public a getDefaultBdImage() {
        this.aUx.E(false);
        return super.getDefaultBdImage();
    }

    @Override // com.baidu.adp.newwidget.a.k
    public Path a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float width = rectF.width();
        float height = rectF.height();
        this.ry.reset();
        this.ry.set(a(width, height, 1.0f));
        return this.ry;
    }

    private Path a(float f, float f2, float f3) {
        int dip2px = l.dip2px(getContext(), 4.0f);
        int dip2px2 = l.dip2px(getContext(), 12.0f);
        int dip2px3 = l.dip2px(getContext(), 6.0f);
        int dip2px4 = l.dip2px(getContext(), 10.0f);
        float f4 = (f - dip2px3) - (f3 * 2.0f);
        float f5 = f2 - (f3 * 2.0f);
        Path path = new Path();
        path.offset(0.0f, 0.0f);
        if (this.aUw) {
            path.moveTo(dip2px3 + f3, dip2px + f3);
            path.quadTo(dip2px3 + f3, f3, dip2px3 + f3 + dip2px, f3);
            path.lineTo(((dip2px3 + f3) + f4) - dip2px, f3);
            path.quadTo(dip2px3 + f3 + f4, f3, dip2px3 + f3 + f4, dip2px + f3);
            path.lineTo(dip2px3 + f3 + f4, (f3 + f5) - dip2px);
            path.quadTo(dip2px3 + f3 + f4, f3 + f5, (f4 + (dip2px3 + f3)) - dip2px, f3 + f5);
            path.lineTo(dip2px3 + f3 + dip2px, f3 + f5);
            path.quadTo(dip2px3 + f3, f3 + f5, dip2px3 + f3, (f5 + f3) - dip2px);
            path.lineTo(dip2px3 + f3, dip2px2 + f3 + dip2px4);
            path.lineTo(1 + f3, (dip2px2 / 2) + dip2px4 + 1);
            path.lineTo(1 + f3, ((dip2px2 / 2) + dip2px4) - 1);
            path.lineTo(dip2px3 + f3, dip2px4 + f3);
            path.lineTo(dip2px3 + f3, dip2px + f3);
        } else {
            path.moveTo(f3, dip2px + f3);
            path.quadTo(f3, f3, dip2px + f3, f3);
            path.lineTo((f3 + f4) - dip2px, f3);
            path.quadTo(f3 + f4, f3, f3 + f4, dip2px + f3);
            path.lineTo(f3 + f4, dip2px4 + f3);
            path.lineTo(((f3 + f4) + dip2px3) - 1, ((dip2px4 + f3) + (dip2px2 / 2)) - 1);
            path.lineTo((dip2px3 + (f3 + f4)) - 1, 1 + dip2px4 + f3 + (dip2px2 / 2));
            path.lineTo(f3 + f4, dip2px2 + dip2px4 + f3);
            path.lineTo(f3 + f4, (f3 + f5) - dip2px);
            path.quadTo(f3 + f4, f3 + f5, (f3 + f4) - dip2px, f3 + f5);
            path.lineTo(dip2px + f3, f3 + f5);
            path.quadTo(f3, f3 + f5, f3, (f3 + f5) - dip2px);
            path.lineTo(f3, dip2px);
        }
        path.close();
        return path;
    }

    @Override // com.baidu.adp.newwidget.a.k
    public void b(Canvas canvas) {
    }
}
