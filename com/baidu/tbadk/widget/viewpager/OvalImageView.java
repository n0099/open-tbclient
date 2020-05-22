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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class OvalImageView extends ImageView {
    private static final int eHo = am.getColor(R.color.cp_link_tip_e);
    private int color;
    private boolean eHp;
    private int endColor;
    private PorterDuffXfermode evU;
    private PorterDuffXfermode evV;
    private boolean ewi;
    private Paint ewl;
    private float[] ewm;
    private float[] ewn;
    private LinearGradient ewo;
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
        this.ewi = true;
        this.ewm = new float[4];
        this.ewn = new float[4];
        this.eHp = true;
        this.color = eHo;
        this.evU = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.evV = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        bhh();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.ewl = new Paint();
        this.ewl.setColor(am.getColor(R.color.cp_cont_a));
        this.ewl.setStrokeCap(Paint.Cap.ROUND);
        this.ewl.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void bhh() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.startColor = c.dT("#2bb8ff");
            this.endColor = c.dT("#2b80ff");
        } else if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.startColor = c.dT("#249BD6");
            this.endColor = c.dT("#246CD6");
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
            canvas.restoreToCount(saveCount);
            return;
        }
        if (getLayerType() != 1) {
            setLayerType(1, null);
        }
        int saveCount2 = canvas.getSaveCount();
        canvas.save();
        B(canvas);
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
            if (this.ewi) {
                this.ewo = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                this.ewi = false;
            }
            if (this.eHp) {
                float width3 = 0.054f * canvas.getWidth();
                float width4 = canvas.getWidth() * 0.0226f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                this.mPaint.setShadowLayer(width3, (float) (width4 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * width4)), c.l(this.ewo == null ? this.color : this.endColor, 0.83f));
            }
            if (this.ewo != null) {
                this.mPaint.setShader(this.ewo);
            } else {
                this.mPaint.setColor(this.color);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            this.ewm[0] = ((3.0f * f) + width) / 4.0f;
            this.ewm[1] = ((3.0f * f2) + height) / 4.0f;
            this.ewm[2] = ((3.0f * f) + width2) / 4.0f;
            this.ewm[3] = ((3.0f * f2) + height2) / 4.0f;
            this.ewn[0] = (width2 + (3.0f * f)) / 4.0f;
            this.ewn[1] = (height + (3.0f * f2)) / 4.0f;
            this.ewn[2] = ((3.0f * f) + width) / 4.0f;
            this.ewn[3] = ((3.0f * f2) + height2) / 4.0f;
            A(canvas);
            this.ewl.setStrokeWidth(canvas.getWidth() * 0.032f);
            canvas.drawLines(this.ewm, this.ewl);
            canvas.drawLines(this.ewn, this.ewl);
        }
        canvas.restoreToCount(saveCount2);
    }

    private void A(Canvas canvas) {
        if (this.mIcon == null) {
            this.ewl.setAlpha(255);
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
            this.mIcon = am.getDrawable(i);
            if (this.mIcon != null) {
                this.mIcon.setAlpha(255);
            }
            this.ewl.setAlpha(0);
        } else {
            this.mIcon = null;
            this.ewl.setAlpha(255);
        }
        postInvalidate();
    }

    public void setCrossFade(float f) {
        if (this.mIcon != null) {
            float f2 = f > 1.0f ? -0.5f : 0.5f - f;
            int i = (int) (255.0f * f2 * 2.0f);
            if (f2 > 0.0f) {
                this.mIcon.setAlpha(i);
                this.ewl.setAlpha(0);
            } else {
                this.ewl.setAlpha(-i);
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

    private void B(Canvas canvas) {
        this.mPaint.setXfermode(this.evU);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.evV);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = c.dT(str);
        this.endColor = c.dT(str2);
        this.ewi = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.ewi = true;
        invalidate();
    }

    public void setNeedShadow(boolean z) {
        this.eHp = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setStringColor(String str) {
        this.color = c.dT(str);
    }
}
