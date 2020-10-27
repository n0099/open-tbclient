package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class OvalImageView extends ImageView {
    private static final int fGw = ap.getColor(R.color.cp_link_tip_e);
    private int color;
    private int endColor;
    private boolean fGx;
    private PorterDuffXfermode ftK;
    private PorterDuffXfermode ftL;
    private boolean ftY;
    private Paint fub;
    private float[] fuc;
    private float[] fud;
    private LinearGradient fue;
    private Drawable mIcon;
    private Paint mPaint;
    private Path mPath;
    private int mSkinType;
    private int startColor;

    public OvalImageView(Context context) {
        this(context, null);
    }

    public OvalImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftY = true;
        this.fuc = new float[4];
        this.fud = new float[4];
        this.fGx = true;
        this.color = fGw;
        this.ftK = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.ftL = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        bBQ();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.fub = new Paint();
        this.fub.setColor(ap.getColor(R.color.cp_cont_a));
        this.fub.setStrokeCap(Paint.Cap.ROUND);
        this.fub.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void bBQ() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.startColor = c.fv("#2bb8ff");
            this.endColor = c.fv("#2b80ff");
        } else if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.startColor = c.fv("#249BD6");
            this.endColor = c.fv("#246CD6");
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mPath == null) {
            this.mPath = new Path();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            if (getLayerType() != 2) {
                setLayerType(2, null);
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.scale(0.7f, 0.7f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            super.onDraw(canvas);
            if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount);
                return;
            }
            return;
        }
        if (getLayerType() != 1) {
            setLayerType(1, null);
        }
        int saveCount2 = canvas.getSaveCount();
        canvas.save();
        G(canvas);
        canvas.rotate(45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        if (this.mPath != null) {
            this.mPath.reset();
            float width = canvas.getWidth() * 0.15f;
            float width2 = canvas.getWidth() * 0.85f;
            float f = (width + width2) / 2.0f;
            float height = canvas.getHeight() * 0.15f;
            float height2 = canvas.getHeight() * 0.85f;
            float f2 = (height + height2) / 2.0f;
            float f3 = (((width2 - width) / 2.0f) * 51.0f) / 65.0f;
            float f4 = (((height2 - height) / 2.0f) * 51.0f) / 65.0f;
            this.mPath.moveTo(f, height);
            this.mPath.cubicTo(f + f3, height, width2, f2 - f4, width2, f2);
            this.mPath.cubicTo(width2, f2 + f4, f + f3, height2, f, height2);
            this.mPath.cubicTo(f - f3, height2, width, f2 + f4, width, f2);
            this.mPath.cubicTo(width, f2 - f4, f - f3, height, f, height);
            this.mPath.close();
            if (this.ftY) {
                this.fue = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                this.ftY = false;
            }
            if (this.fGx) {
                float width3 = 0.054f * canvas.getWidth();
                float width4 = canvas.getWidth() * 0.0226f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                this.mPaint.setShadowLayer(width3, (float) (width4 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * width4)), c.m(this.fue == null ? this.color : this.endColor, 0.83f));
            }
            if (this.fue != null) {
                this.mPaint.setShader(this.fue);
            } else {
                this.mPaint.setColor(this.color);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            this.fuc[0] = ((3.0f * f) + width) / 4.0f;
            this.fuc[1] = ((3.0f * f2) + height) / 4.0f;
            this.fuc[2] = ((3.0f * f) + width2) / 4.0f;
            this.fuc[3] = ((3.0f * f2) + height2) / 4.0f;
            this.fud[0] = (width2 + (3.0f * f)) / 4.0f;
            this.fud[1] = (height + (3.0f * f2)) / 4.0f;
            this.fud[2] = ((3.0f * f) + width) / 4.0f;
            this.fud[3] = ((3.0f * f2) + height2) / 4.0f;
            F(canvas);
            this.fub.setStrokeWidth(canvas.getWidth() * 0.032f);
            canvas.drawLines(this.fuc, this.fub);
            canvas.drawLines(this.fud, this.fub);
        }
        if (saveCount2 >= 1 && saveCount2 <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveCount2);
        }
    }

    private void F(Canvas canvas) {
        if (this.mIcon == null) {
            this.fub.setAlpha(255);
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || this.mIcon.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.mIcon.setBounds((getWidth() / 2) - (this.mIcon.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.mIcon.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.mIcon.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.mIcon.getIntrinsicHeight() / 2));
            this.mIcon.draw(canvas);
            canvas.restore();
        }
    }

    public void setIconFade(int i) {
        if (i > 0) {
            this.mIcon = ap.getDrawable(i);
            if (this.mIcon != null) {
                this.mIcon.setAlpha(255);
            }
            this.fub.setAlpha(0);
        } else {
            this.mIcon = null;
            this.fub.setAlpha(255);
        }
        postInvalidate();
    }

    public void setCrossFade(float f) {
        if (this.mIcon != null) {
            float f2 = f > 1.0f ? -0.5f : 0.5f - f;
            int i = (int) (255.0f * f2 * 2.0f);
            if (f2 > 0.0f) {
                this.mIcon.setAlpha(i);
                this.fub.setAlpha(0);
            } else {
                this.fub.setAlpha(-i);
                this.mIcon.setAlpha(0);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void setRotation(float f) {
        super.setRotation(f);
        invalidate();
    }

    private void G(Canvas canvas) {
        this.mPaint.setXfermode(this.ftK);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.ftL);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = c.fv(str);
        this.endColor = c.fv(str2);
        this.ftY = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.ftY = true;
        invalidate();
    }

    public void setNeedShadow(boolean z) {
        this.fGx = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setStringColor(String str) {
        this.color = c.fv(str);
    }
}
