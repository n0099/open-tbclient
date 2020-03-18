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
import com.baidu.adp.newwidget.ImageView.g;
import com.baidu.adp.newwidget.ImageView.j;
import com.baidu.adp.newwidget.ImageView.m;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ChatClipImageItemView extends TbImageView implements j.a {
    private boolean gwB;
    public j hxv;
    private a hxw;
    private boolean isLeft;
    private final Path mDefaultPath;
    public int position;

    /* loaded from: classes.dex */
    public interface a {
        void O(Canvas canvas);
    }

    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLeft = true;
        this.position = 0;
        this.mDefaultPath = new Path();
        this.gwB = true;
        this.hxw = null;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
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
            this.hxv = new g();
        } else {
            this.hxv = new m();
        }
        this.wx.isChatPage = true;
        this.hxv.a(this);
        this.wy = this.hxv;
        this.wy.a(this.wx);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.hxv.releaseMemory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            this.hxv.releaseMemory();
        } else if (!this.gwB) {
            this.hxv.onFinishComputeBounds();
            invalidate();
        } else {
            this.gwB = false;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
    }

    public void setLeft(boolean z) {
        this.isLeft = z;
    }

    public void bTd() {
        this.hxv.onFinishComputeBounds();
        this.hxv.setPathAvailable(true);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        boolean z = false;
        com.baidu.adp.widget.ImageView.a bdImage = super.getBdImage();
        boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
        boolean z3 = bdImage != null && bdImage.isValidNow();
        j jVar = this.hxv;
        if (z3 || z2) {
            z = true;
        }
        jVar.setPathAvailable(z);
        return bdImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getDefaultBdImage() {
        this.hxv.setPathAvailable(false);
        return super.getDefaultBdImage();
    }

    @Override // com.baidu.adp.newwidget.ImageView.j.a
    public Path makePath(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float width = rectF.width();
        float height = rectF.height();
        this.mDefaultPath.reset();
        this.mDefaultPath.set(f(width, height, 1.0f));
        return this.mDefaultPath;
    }

    private Path f(float f, float f2, float f3) {
        int dip2px = l.dip2px(getContext(), 4.0f);
        int dip2px2 = l.dip2px(getContext(), 12.0f);
        int dip2px3 = l.dip2px(getContext(), 6.0f);
        int dip2px4 = l.dip2px(getContext(), 10.0f);
        float f4 = (f - dip2px3) - (f3 * 2.0f);
        float f5 = f2 - (f3 * 2.0f);
        Path path = new Path();
        path.offset(0.0f, 0.0f);
        if (this.isLeft) {
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

    @Override // com.baidu.adp.newwidget.ImageView.j.a
    public void drawWhenPathAvailable(Canvas canvas) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.hxw == null) {
            am.setBackgroundColor(this, R.color.cp_bg_line_c, 0);
        } else {
            this.hxw.O(canvas);
        }
        super.onDraw(canvas);
    }

    public void setOnDrawCallback(a aVar) {
        this.hxw = aVar;
    }
}
