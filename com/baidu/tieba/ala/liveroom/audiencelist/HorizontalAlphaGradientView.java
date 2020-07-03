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
/* loaded from: classes3.dex */
public class HorizontalAlphaGradientView extends View {
    private Paint aWJ;
    private int bkz;
    private int bnc;
    private int bnd;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bkz = 0;
        this.bnd = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkz = 0;
        this.bnd = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkz = 0;
        this.bnd = 0;
    }

    public void setColor(int i, int i2) {
        this.bkz = i;
        this.bnd = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bnc = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aWJ = new Paint();
            this.aWJ.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.aWJ);
            this.aWJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aWJ.setShader(new LinearGradient(0.0f, 0.0f, this.bnc, 0.0f, this.bkz, this.bnd, Shader.TileMode.CLAMP));
        } else {
            this.bnc = 0;
            this.aWJ = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aWJ != null) {
            canvas.drawRect(0.0f, 0.0f, this.bnc, getHeight(), this.aWJ);
        }
    }
}
