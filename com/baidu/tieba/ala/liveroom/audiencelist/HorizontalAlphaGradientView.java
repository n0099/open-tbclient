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
    private Paint aNP;
    private int aXP;
    private int bat;
    private int bau;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.aXP = 0;
        this.bau = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXP = 0;
        this.bau = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXP = 0;
        this.bau = 0;
    }

    public void setColor(int i, int i2) {
        this.aXP = i;
        this.bau = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bat = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aNP = new Paint();
            this.aNP.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.aNP);
            this.aNP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aNP.setShader(new LinearGradient(0.0f, 0.0f, this.bat, 0.0f, this.aXP, this.bau, Shader.TileMode.CLAMP));
        } else {
            this.bat = 0;
            this.aNP = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aNP != null) {
            canvas.drawRect(0.0f, 0.0f, this.bat, getHeight(), this.aNP);
        }
    }
}
