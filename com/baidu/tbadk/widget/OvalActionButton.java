package com.baidu.tbadk.widget;

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
/* loaded from: classes.dex */
public class OvalActionButton extends ImageView {
    private int color;
    private PorterDuffXfermode dHP;
    private PorterDuffXfermode dHQ;
    private boolean dId;
    private boolean dIe;
    private boolean dIf;
    private Paint dIg;
    private float[] dIh;
    private float[] dIi;
    private LinearGradient dIj;
    private int endColor;
    private int mHeight;
    private Drawable mIcon;
    private Paint mPaint;
    private Path mPath;
    private int mSkinType;
    private int mWidth;
    private int startColor;

    public OvalActionButton(Context context) {
        this(context, null);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dId = true;
        this.dIf = true;
        this.dIh = new float[4];
        this.dIi = new float[4];
        this.color = am.getColor(R.color.cp_link_tip_e);
        this.dHP = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.dHQ = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        aSP();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.dIg = new Paint();
        this.dIg.setColor(am.getColor(R.color.cp_cont_a));
        this.dIg.setStrokeCap(Paint.Cap.ROUND);
        this.dIg.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aSP() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.startColor = com.baidu.tieba.tbadkCore.c.cF("#2bb8ff");
            this.endColor = com.baidu.tieba.tbadkCore.c.cF("#2b80ff");
        } else if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.startColor = com.baidu.tieba.tbadkCore.c.cF("#249BD6");
            this.endColor = com.baidu.tieba.tbadkCore.c.cF("#246CD6");
        }
    }

    public void setIsCircle(boolean z) {
        this.dIe = z;
    }

    public void setHasShadow(boolean z) {
        this.dIf = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
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
        if (this.mWidth > 0 && this.mHeight > 0) {
            if (getDrawable() != null) {
                if (getLayerType() != 2) {
                    setLayerType(2, null);
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.scale(0.7f, 0.7f, this.mWidth / 2, this.mHeight / 2);
                super.onDraw(canvas);
                canvas.restoreToCount(saveCount);
                return;
            }
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            int saveCount2 = canvas.getSaveCount();
            canvas.save();
            clear(canvas);
            canvas.rotate(45.0f, this.mWidth / 2, this.mHeight / 2);
            if (this.mPath != null) {
                this.mPath.reset();
                float f = this.mWidth * 0.15f;
                float f2 = this.mWidth * 0.85f;
                float f3 = (f + f2) / 2.0f;
                float f4 = this.mHeight * 0.15f;
                float f5 = this.mHeight * 0.85f;
                float f6 = (f4 + f5) / 2.0f;
                float f7 = (((f2 - f) / 2.0f) * 51.0f) / 65.0f;
                float f8 = (((f5 - f4) / 2.0f) * 51.0f) / 65.0f;
                this.mPath.moveTo(f3, f4);
                this.mPath.cubicTo(f3 + f7, f4, f2, f6 - f8, f2, f6);
                this.mPath.cubicTo(f2, f6 + f8, f3 + f7, f5, f3, f5);
                this.mPath.cubicTo(f3 - f7, f5, f, f6 + f8, f, f6);
                this.mPath.cubicTo(f, f6 - f8, f3 - f7, f4, f3, f4);
                this.mPath.close();
                if (this.dId) {
                    this.dIj = new LinearGradient(f, 0.0f, f2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                    this.dId = false;
                }
                if (this.dIf) {
                    if (this.dIe) {
                        this.mPaint.setShadowLayer(16.0f, 5.0f, 5.0f, com.baidu.tieba.tbadkCore.c.n(this.dIj == null ? this.color : this.endColor, 0.5f));
                    } else {
                        float f9 = 0.054f * this.mWidth;
                        float f10 = this.mWidth * 0.0226f;
                        double radians = Math.toRadians(getRotation() - 45.0f);
                        this.mPaint.setShadowLayer(f9, (float) (f10 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * f10)), com.baidu.tieba.tbadkCore.c.n(this.dIj == null ? this.color : this.endColor, 0.83f));
                    }
                }
                if (this.dIj != null) {
                    this.mPaint.setShader(this.dIj);
                } else {
                    this.mPaint.setColor(this.color);
                }
                float f11 = this.mWidth * 0.032f;
                if (this.dIe) {
                    canvas.drawCircle(f3, f6, (this.mWidth / 2) - 20, this.mPaint);
                } else {
                    canvas.drawPath(this.mPath, this.mPaint);
                }
                this.dIh[0] = ((3.0f * f3) + f) / 4.0f;
                this.dIh[1] = ((3.0f * f6) + f4) / 4.0f;
                this.dIh[2] = ((3.0f * f3) + f2) / 4.0f;
                this.dIh[3] = ((3.0f * f6) + f5) / 4.0f;
                this.dIi[0] = (f2 + (3.0f * f3)) / 4.0f;
                this.dIi[1] = (f4 + (3.0f * f6)) / 4.0f;
                this.dIi[2] = ((3.0f * f3) + f) / 4.0f;
                this.dIi[3] = ((3.0f * f6) + f5) / 4.0f;
                z(canvas);
                this.dIg.setStrokeWidth(f11);
                canvas.drawLines(this.dIh, this.dIg);
                canvas.drawLines(this.dIi, this.dIg);
            }
            canvas.restoreToCount(saveCount2);
        }
    }

    private void z(Canvas canvas) {
        if (this.mIcon == null) {
            this.dIg.setAlpha(255);
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
            this.dIg.setAlpha(0);
        } else {
            this.mIcon = null;
            this.dIg.setAlpha(255);
        }
        postInvalidate();
    }

    public void aQb() {
        if (this.mIcon != null) {
            this.mIcon.setAlpha(255);
            postInvalidate();
        }
    }

    public void setCrossFade(float f) {
        if (this.mIcon != null) {
            float f2 = f > 1.0f ? -0.5f : 0.5f - f;
            int i = (int) (255.0f * f2 * 2.0f);
            if (f2 > 0.0f) {
                this.mIcon.setAlpha(i);
                this.dIg.setAlpha(0);
            } else {
                this.dIg.setAlpha(-i);
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

    private void clear(Canvas canvas) {
        this.mPaint.setXfermode(this.dHP);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.dHQ);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = com.baidu.tieba.tbadkCore.c.cF(str);
        this.endColor = com.baidu.tieba.tbadkCore.c.cF(str2);
        this.dId = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.dId = true;
        invalidate();
    }

    public void a(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            ovalActionButton.setStartAndEndColor(this.startColor, this.endColor);
            ovalActionButton.setColor(this.color);
        }
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aSP();
            this.color = am.getColor(this.mSkinType, R.color.cp_link_tip_e);
            this.dIg.setColor(am.getColor(R.color.cp_cont_a));
            this.dId = true;
            invalidate();
        }
    }
}
