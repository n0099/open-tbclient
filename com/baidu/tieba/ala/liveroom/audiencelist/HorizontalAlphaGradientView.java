package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class HorizontalAlphaGradientView extends View {
    private int aDP;
    private int aEy;
    private int aEz;
    private Paint aug;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.aDP = 0;
        this.aEz = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDP = 0;
        this.aEz = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDP = 0;
        this.aEz = 0;
    }

    public void setColor(int i, int i2) {
        this.aDP = i;
        this.aEz = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.aEy = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aug = new Paint();
            this.aug.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.aug);
            this.aug.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aug.setShader(new LinearGradient(0.0f, 0.0f, this.aEy, 0.0f, this.aDP, this.aEz, Shader.TileMode.CLAMP));
        } else {
            this.aEy = 0;
            this.aug = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aug != null) {
            canvas.drawRect(0.0f, 0.0f, this.aEy, getHeight(), this.aug);
        }
    }
}
