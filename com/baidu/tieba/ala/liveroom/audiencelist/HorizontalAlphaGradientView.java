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
    private Paint aUc;
    private int bfp;
    private int bhV;
    private int bhW;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bfp = 0;
        this.bhW = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfp = 0;
        this.bhW = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfp = 0;
        this.bhW = 0;
    }

    public void setColor(int i, int i2) {
        this.bfp = i;
        this.bhW = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bhV = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aUc = new Paint();
            this.aUc.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.aUc);
            this.aUc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aUc.setShader(new LinearGradient(0.0f, 0.0f, this.bhV, 0.0f, this.bfp, this.bhW, Shader.TileMode.CLAMP));
        } else {
            this.bhV = 0;
            this.aUc = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aUc != null) {
            canvas.drawRect(0.0f, 0.0f, this.bhV, getHeight(), this.aUc);
        }
    }
}
