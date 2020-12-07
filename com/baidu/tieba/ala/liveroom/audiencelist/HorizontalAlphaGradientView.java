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
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class HorizontalAlphaGradientView extends View {
    private int bKi;
    private int bOX;
    private int bOY;
    private Paint bpJ;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bKi = 0;
        this.bOY = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKi = 0;
        this.bOY = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKi = 0;
        this.bOY = 0;
    }

    public void setColor(int i, int i2) {
        this.bKi = i;
        this.bOY = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bOX = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.bpJ = new Paint();
            this.bpJ.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bpJ);
            this.bpJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bpJ.setShader(new LinearGradient(0.0f, 0.0f, this.bOX, 0.0f, this.bKi, this.bOY, Shader.TileMode.CLAMP));
        } else {
            this.bOX = 0;
            this.bpJ = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bpJ != null) {
            canvas.drawRect(0.0f, 0.0f, this.bOX, getHeight(), this.bpJ);
        }
    }
}
