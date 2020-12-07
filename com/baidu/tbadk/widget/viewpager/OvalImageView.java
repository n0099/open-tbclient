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
    private static final int fTA = ap.getColor(R.color.CAM_X0306);
    private int color;
    private int endColor;
    private PorterDuffXfermode fGM;
    private PorterDuffXfermode fGN;
    private boolean fHa;
    private Paint fHd;
    private float[] fHe;
    private float[] fHf;
    private LinearGradient fHg;
    private boolean fTB;
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
        this.fHa = true;
        this.fHe = new float[4];
        this.fHf = new float[4];
        this.fTB = true;
        this.color = fTA;
        this.fGM = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.fGN = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        bHj();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.fHd = new Paint();
        this.fHd.setColor(ap.getColor(R.color.CAM_X0101));
        this.fHd.setStrokeCap(Paint.Cap.ROUND);
        this.fHd.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void bHj() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.startColor = c.sI("#2bb8ff");
            this.endColor = c.sI("#2b80ff");
        } else if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.startColor = c.sI("#249BD6");
            this.endColor = c.sI("#246CD6");
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
        H(canvas);
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
            if (this.fHa) {
                this.fHg = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                this.fHa = false;
            }
            if (this.fTB) {
                float width3 = 0.054f * canvas.getWidth();
                float width4 = canvas.getWidth() * 0.0226f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                this.mPaint.setShadowLayer(width3, (float) (width4 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * width4)), c.m(this.fHg == null ? this.color : this.endColor, 0.83f));
            }
            if (this.fHg != null) {
                this.mPaint.setShader(this.fHg);
            } else {
                this.mPaint.setColor(this.color);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            this.fHe[0] = ((3.0f * f) + width) / 4.0f;
            this.fHe[1] = ((3.0f * f2) + height) / 4.0f;
            this.fHe[2] = ((3.0f * f) + width2) / 4.0f;
            this.fHe[3] = ((3.0f * f2) + height2) / 4.0f;
            this.fHf[0] = (width2 + (3.0f * f)) / 4.0f;
            this.fHf[1] = (height + (3.0f * f2)) / 4.0f;
            this.fHf[2] = ((3.0f * f) + width) / 4.0f;
            this.fHf[3] = ((3.0f * f2) + height2) / 4.0f;
            G(canvas);
            this.fHd.setStrokeWidth(canvas.getWidth() * 0.032f);
            canvas.drawLines(this.fHe, this.fHd);
            canvas.drawLines(this.fHf, this.fHd);
        }
        if (saveCount2 >= 1 && saveCount2 <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveCount2);
        }
    }

    private void G(Canvas canvas) {
        if (this.mIcon == null) {
            this.fHd.setAlpha(255);
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
            this.fHd.setAlpha(0);
        } else {
            this.mIcon = null;
            this.fHd.setAlpha(255);
        }
        postInvalidate();
    }

    public void setCrossFade(float f) {
        if (this.mIcon != null) {
            float f2 = f > 1.0f ? -0.5f : 0.5f - f;
            int i = (int) (255.0f * f2 * 2.0f);
            if (f2 > 0.0f) {
                this.mIcon.setAlpha(i);
                this.fHd.setAlpha(0);
            } else {
                this.fHd.setAlpha(-i);
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

    private void H(Canvas canvas) {
        this.mPaint.setXfermode(this.fGM);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.fGN);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = c.sI(str);
        this.endColor = c.sI(str2);
        this.fHa = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.fHa = true;
        invalidate();
    }

    public void setNeedShadow(boolean z) {
        this.fTB = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setStringColor(String str) {
        this.color = c.sI(str);
    }
}
