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
    private int aDO;
    private int aEx;
    private int aEy;
    private Paint auf;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.aDO = 0;
        this.aEy = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDO = 0;
        this.aEy = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDO = 0;
        this.aEy = 0;
    }

    public void setColor(int i, int i2) {
        this.aDO = i;
        this.aEy = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.aEx = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.auf = new Paint();
            this.auf.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.auf);
            this.auf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.auf.setShader(new LinearGradient(0.0f, 0.0f, this.aEx, 0.0f, this.aDO, this.aEy, Shader.TileMode.CLAMP));
        } else {
            this.aEx = 0;
            this.auf = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.auf != null) {
            canvas.drawRect(0.0f, 0.0f, this.aEx, getHeight(), this.auf);
        }
    }
}
