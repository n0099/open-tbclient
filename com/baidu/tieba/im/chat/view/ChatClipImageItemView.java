package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.adp.b.a.h;
import com.baidu.adp.b.a.k;
import com.baidu.adp.b.a.n;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ChatClipImageItemView extends TbImageView implements k.a {
    private final Path Cs;
    private boolean cGo;
    public k cNi;
    private boolean cNj;
    private a cNk;
    public int position;

    /* loaded from: classes.dex */
    public interface a {
        void i(Canvas canvas);
    }

    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGo = true;
        this.position = 0;
        this.Cs = new Path();
        this.cNj = true;
        this.cNk = null;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
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
            this.cNi = new h();
        } else {
            this.cNi = new n();
        }
        this.BF.Cl = true;
        this.BF.Ci = getResources().getDrawable(w.g.icon_im_gif);
        this.cNi.a(this);
        this.BM = this.cNi;
        this.BM.a(this.BF);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.cNi.iJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            this.cNi.iJ();
        } else if (!this.cNj) {
            this.cNi.iI();
            invalidate();
        } else {
            this.cNj = false;
        }
    }

    @Override // com.baidu.adp.b.a.b
    public void setDrawerType(int i) {
    }

    public void setLeft(boolean z) {
        this.cGo = z;
    }

    public void alO() {
        this.cNi.iI();
        this.cNi.K(true);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getBdImage() {
        boolean z = false;
        com.baidu.adp.widget.a.a bdImage = super.getBdImage();
        boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
        boolean z3 = bdImage != null && bdImage.kS();
        k kVar = this.cNi;
        if (z3 || z2) {
            z = true;
        }
        kVar.K(z);
        return bdImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        this.cNi.K(false);
        return super.getDefaultBdImage();
    }

    @Override // com.baidu.adp.b.a.k.a
    public Path a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float width = rectF.width();
        float height = rectF.height();
        this.Cs.reset();
        this.Cs.set(b(width, height, 1.0f));
        return this.Cs;
    }

    private Path b(float f, float f2, float f3) {
        int dip2px = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
        int dip2px2 = com.baidu.adp.lib.util.k.dip2px(getContext(), 12.0f);
        int dip2px3 = com.baidu.adp.lib.util.k.dip2px(getContext(), 6.0f);
        int dip2px4 = com.baidu.adp.lib.util.k.dip2px(getContext(), 10.0f);
        float f4 = (f - dip2px3) - (f3 * 2.0f);
        float f5 = f2 - (f3 * 2.0f);
        Path path = new Path();
        path.offset(0.0f, 0.0f);
        if (this.cGo) {
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

    @Override // com.baidu.adp.b.a.k.a
    public void c(Canvas canvas) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.cNk == null) {
            aq.e(this, w.e.cp_bg_line_c, 0);
        } else {
            this.cNk.i(canvas);
        }
        super.onDraw(canvas);
    }

    public void setOnDrawCallback(a aVar) {
        this.cNk = aVar;
    }
}
