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
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class HorizontalAlphaGradientView extends View {
    private int aAg;
    private int aAh;
    private Paint aqv;
    private int azx;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.azx = 0;
        this.aAh = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azx = 0;
        this.aAh = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azx = 0;
        this.aAh = 0;
    }

    public void setColor(int i, int i2) {
        this.azx = i;
        this.aAh = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.aAg = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aqv = new Paint();
            this.aqv.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.aqv);
            this.aqv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aqv.setShader(new LinearGradient(0.0f, 0.0f, this.aAg, 0.0f, this.azx, this.aAh, Shader.TileMode.CLAMP));
        } else {
            this.aAg = 0;
            this.aqv = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aqv != null) {
            canvas.drawRect(0.0f, 0.0f, this.aAg, getHeight(), this.aqv);
        }
    }
}
