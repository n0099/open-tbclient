package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FRSRefreshButton extends ImageView {
    private static final int cEz = am.getColor(R.color.white_alpha100);
    private boolean cEA;
    private Paint cEB;
    private float[] cEC;
    private float[] cED;
    private boolean cEE;
    private LinearGradient cEF;
    private int cEG;
    private int cEH;
    private int cEI;
    private PorterDuffXfermode cEJ;
    private PorterDuffXfermode cEK;
    private int color;
    private Drawable mIcon;
    private int mIconId;
    private Paint mPaint;
    private Path mPath;
    private int mSkinType;

    public FRSRefreshButton(Context context) {
        this(context, null);
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FRSRefreshButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cEA = true;
        this.cEC = new float[4];
        this.cED = new float[4];
        this.cEE = true;
        this.color = cEz;
        this.cEJ = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.cEK = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        axk();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.cEB = new Paint();
        this.cEB.setColor(am.getColor(R.color.cp_btn_a));
        this.cEB.setStrokeCap(Paint.Cap.ROUND);
        this.cEB.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void axk() {
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
        A(canvas);
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
            if (this.cEA) {
                this.cEA = false;
            }
            if (this.cEE) {
                float width3 = canvas.getWidth() * 0.0226f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                this.mPaint.setShadowLayer(canvas.getWidth() * 0.054f, (float) (width3 * Math.cos(radians)), ((float) (Math.sin(radians) * width3)) * (-1.0f), Color.parseColor("#14000000"));
            }
            if (this.cEF != null) {
                this.mPaint.setShader(this.cEF);
            }
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_d));
            float width4 = canvas.getWidth() * 0.032f;
            canvas.drawPath(this.mPath, this.mPaint);
            this.cEC[0] = ((3.0f * f) + width) / 4.0f;
            this.cEC[1] = ((3.0f * f2) + height) / 4.0f;
            this.cEC[2] = ((3.0f * f) + width2) / 4.0f;
            this.cEC[3] = ((3.0f * f2) + height2) / 4.0f;
            this.cED[0] = (width2 + (3.0f * f)) / 4.0f;
            this.cED[1] = (height + (3.0f * f2)) / 4.0f;
            this.cED[2] = ((3.0f * f) + width) / 4.0f;
            this.cED[3] = ((3.0f * f2) + height2) / 4.0f;
            z(canvas);
        }
        canvas.restoreToCount(saveCount2);
    }

    private void z(Canvas canvas) {
        if (this.mIcon == null) {
            this.cEB.setAlpha(255);
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

    public void setShadowColor(int i) {
        this.cEI = i;
    }

    public void setIconFade(int i) {
        if (i > 0) {
            this.mIcon = am.getDrawable(i);
            if (this.mIcon != null) {
                this.mIcon.setAlpha(255);
            }
            this.cEB.setAlpha(0);
            this.mIconId = i;
        } else {
            this.mIcon = null;
            this.cEB.setAlpha(255);
        }
        postInvalidate();
    }

    public void setCrossFade(float f) {
        if (this.mIcon != null) {
            float f2 = f > 1.0f ? -0.5f : 0.5f - f;
            int i = (int) (255.0f * f2 * 2.0f);
            if (f2 > 0.0f) {
                this.mIcon.setAlpha(i);
                this.cEB.setAlpha(0);
            } else {
                this.cEB.setAlpha(-i);
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

    private void A(Canvas canvas) {
        this.mPaint.setXfermode(this.cEJ);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.cEK);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.cEG = com.baidu.tieba.lego.card.d.a.cE(str);
        this.cEH = com.baidu.tieba.lego.card.d.a.cE(str2);
        this.cEA = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.cEG = i;
        this.cEH = i2;
        this.cEA = true;
        invalidate();
    }

    public void setNeedShadow(boolean z) {
        this.cEE = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setStringColor(String str) {
        this.color = com.baidu.tieba.lego.card.d.a.cE(str);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            axk();
            this.color = am.getColor(this.mSkinType, R.color.cp_bg_line_d);
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_d));
            this.cEA = true;
            if (this.mIconId > 0) {
                this.mIcon = am.getDrawable(this.mIconId);
            }
            this.cEB.setColor(am.getColor(R.color.cp_btn_a));
            invalidate();
        }
    }
}
