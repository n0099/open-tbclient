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
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class HorizontalAlphaGradientView extends View {
    private Paint apJ;
    private int ayM;
    private int azw;
    private int azx;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.ayM = 0;
        this.azx = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayM = 0;
        this.azx = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayM = 0;
        this.azx = 0;
    }

    public void setColor(int i, int i2) {
        this.ayM = i;
        this.azx = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.azw = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.apJ = new Paint();
            this.apJ.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.apJ);
            this.apJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.apJ.setShader(new LinearGradient(0.0f, 0.0f, this.azw, 0.0f, this.ayM, this.azx, Shader.TileMode.CLAMP));
        } else {
            this.azw = 0;
            this.apJ = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.apJ != null) {
            canvas.drawRect(0.0f, 0.0f, this.azw, getHeight(), this.apJ);
        }
    }
}
