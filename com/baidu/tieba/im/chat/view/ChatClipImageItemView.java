package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.newwidget.a.h;
import com.baidu.adp.newwidget.a.j;
import com.baidu.adp.newwidget.a.k;
import com.baidu.adp.newwidget.a.n;
import com.baidu.adp.widget.a.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ChatClipImageItemView extends TbImageView implements k {
    private boolean aSU;
    public j aSV;
    private boolean aSW;
    public int position;
    private final Path rD;

    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSU = true;
        this.position = 0;
        this.rD = new Path();
        this.aSW = true;
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
            this.aSV = new h();
        } else {
            this.aSV = new n();
        }
        this.aSV.a(this);
        this.qX = this.aSV;
        this.qX.a(this.qN);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.aSV.gH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            this.aSV.gH();
        } else if (!this.aSW) {
            this.aSV.gG();
            invalidate();
        } else {
            this.aSW = false;
        }
    }

    @Override // com.baidu.adp.newwidget.a.b
    public void setDrawerType(int i) {
    }

    public void setLeft(boolean z) {
        this.aSU = z;
    }

    public void KR() {
        this.aSV.gG();
        this.aSV.y(true);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b
    public a getBdImage() {
        boolean z = false;
        a bdImage = super.getBdImage();
        boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
        boolean z3 = bdImage != null && bdImage.hm();
        j jVar = this.aSV;
        if (z3 || z2) {
            z = true;
        }
        jVar.y(z);
        return bdImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b
    public a getDefaultBdImage() {
        this.aSV.y(false);
        return super.getDefaultBdImage();
    }

    @Override // com.baidu.adp.newwidget.a.k
    public Path a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float width = rectF.width();
        float height = rectF.height();
        this.rD.reset();
        this.rD.set(a(width, height, 1.0f));
        return this.rD;
    }

    private Path a(float f, float f2, float f3) {
        int dip2px = m.dip2px(getContext(), 4.0f);
        int dip2px2 = m.dip2px(getContext(), 6.0f);
        int dip2px3 = m.dip2px(getContext(), 6.0f);
        int dip2px4 = m.dip2px(getContext(), 6.0f);
        float f4 = (f - dip2px3) - (f3 * 2.0f);
        float f5 = f2 - (f3 * 2.0f);
        Path path = new Path();
        path.offset(0.0f, 0.0f);
        if (this.aSU) {
            path.moveTo(dip2px3 + f3, dip2px + f3);
            path.quadTo(dip2px3 + f3, f3, dip2px3 + f3 + dip2px, f3);
            path.lineTo(((dip2px3 + f3) + f4) - dip2px, f3);
            path.quadTo(dip2px3 + f3 + f4, f3, dip2px3 + f3 + f4, dip2px + f3);
            path.lineTo(dip2px3 + f3 + f4, (f3 + f5) - dip2px);
            path.quadTo(dip2px3 + f3 + f4, f3 + f5, (f4 + (dip2px3 + f3)) - dip2px, f3 + f5);
            path.lineTo(dip2px3 + f3 + dip2px, f3 + f5);
            path.quadTo(dip2px3 + f3, f3 + f5, dip2px3 + f3, (f5 + f3) - dip2px);
            path.lineTo(dip2px3 + f3, dip2px2 + f3 + dip2px4);
            path.quadTo(((dip2px3 * 1) / 4) + f3, ((dip2px2 * 3) / 4) + f3 + dip2px4, f3, dip2px4 + f3);
            path.quadTo((dip2px3 / 2) + f3, (dip2px2 / 4) + dip2px4 + f3, dip2px3 + f3, dip2px4 + f3);
            path.lineTo(dip2px3 + f3, dip2px + f3);
        } else {
            path.moveTo(f3, dip2px + f3);
            path.quadTo(f3, f3, dip2px + f3, f3);
            path.lineTo((f3 + f4) - dip2px, f3);
            path.quadTo(f3 + f4, f3, f3 + f4, dip2px + f3);
            path.lineTo(f3 + f4, dip2px4 + f3);
            path.quadTo(f3 + f4 + (dip2px3 / 2), dip2px4 + f3 + (dip2px2 / 4), f3 + f4 + dip2px3, dip2px4 + f3);
            path.quadTo(((dip2px3 * 3) / 4) + f3 + f4, dip2px4 + f3 + ((dip2px2 * 3) / 4), f3 + f4, dip2px2 + dip2px4 + f3);
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
