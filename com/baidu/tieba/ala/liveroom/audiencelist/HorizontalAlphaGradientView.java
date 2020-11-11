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
    private int bGK;
    private int bLA;
    private int bLB;
    private Paint bml;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bGK = 0;
        this.bLB = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGK = 0;
        this.bLB = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGK = 0;
        this.bLB = 0;
    }

    public void setColor(int i, int i2) {
        this.bGK = i;
        this.bLB = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bLA = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.bml = new Paint();
            this.bml.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bml);
            this.bml.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bml.setShader(new LinearGradient(0.0f, 0.0f, this.bLA, 0.0f, this.bGK, this.bLB, Shader.TileMode.CLAMP));
        } else {
            this.bLA = 0;
            this.bml = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bml != null) {
            canvas.drawRect(0.0f, 0.0f, this.bLA, getHeight(), this.bml);
        }
    }
}
