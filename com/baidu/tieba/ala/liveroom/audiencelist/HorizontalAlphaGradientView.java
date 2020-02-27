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
    private int aDN;
    private int aEw;
    private int aEx;
    private Paint auf;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.aDN = 0;
        this.aEx = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDN = 0;
        this.aEx = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDN = 0;
        this.aEx = 0;
    }

    public void setColor(int i, int i2) {
        this.aDN = i;
        this.aEx = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.aEw = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.auf = new Paint();
            this.auf.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.auf);
            this.auf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.auf.setShader(new LinearGradient(0.0f, 0.0f, this.aEw, 0.0f, this.aDN, this.aEx, Shader.TileMode.CLAMP));
        } else {
            this.aEw = 0;
            this.auf = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.auf != null) {
            canvas.drawRect(0.0f, 0.0f, this.aEw, getHeight(), this.auf);
        }
    }
}
