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
    private Paint aNV;
    private int aXU;
    private int bay;
    private int baz;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.aXU = 0;
        this.baz = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXU = 0;
        this.baz = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXU = 0;
        this.baz = 0;
    }

    public void setColor(int i, int i2) {
        this.aXU = i;
        this.baz = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bay = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aNV = new Paint();
            this.aNV.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.aNV);
            this.aNV.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aNV.setShader(new LinearGradient(0.0f, 0.0f, this.bay, 0.0f, this.aXU, this.baz, Shader.TileMode.CLAMP));
        } else {
            this.bay = 0;
            this.aNV = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aNV != null) {
            canvas.drawRect(0.0f, 0.0f, this.bay, getHeight(), this.aNV);
        }
    }
}
