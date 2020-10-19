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
    private int bCZ;
    private int bDa;
    private Paint bjw;
    private int bxx;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bxx = 0;
        this.bDa = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxx = 0;
        this.bDa = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxx = 0;
        this.bDa = 0;
    }

    public void setColor(int i, int i2) {
        this.bxx = i;
        this.bDa = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bCZ = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.bjw = new Paint();
            this.bjw.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bjw);
            this.bjw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bjw.setShader(new LinearGradient(0.0f, 0.0f, this.bCZ, 0.0f, this.bxx, this.bDa, Shader.TileMode.CLAMP));
        } else {
            this.bCZ = 0;
            this.bjw = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bjw != null) {
            canvas.drawRect(0.0f, 0.0f, this.bCZ, getHeight(), this.bjw);
        }
    }
}
