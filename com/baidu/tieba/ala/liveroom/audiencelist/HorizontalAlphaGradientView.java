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
    private Paint bfJ;
    private int btK;
    private int bww;
    private int bwx;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.btK = 0;
        this.bwx = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btK = 0;
        this.bwx = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btK = 0;
        this.bwx = 0;
    }

    public void setColor(int i, int i2) {
        this.btK = i;
        this.bwx = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bww = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.bfJ = new Paint();
            this.bfJ.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bfJ);
            this.bfJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bfJ.setShader(new LinearGradient(0.0f, 0.0f, this.bww, 0.0f, this.btK, this.bwx, Shader.TileMode.CLAMP));
        } else {
            this.bww = 0;
            this.bfJ = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bfJ != null) {
            canvas.drawRect(0.0f, 0.0f, this.bww, getHeight(), this.bfJ);
        }
    }
}
