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
/* loaded from: classes7.dex */
public class HorizontalAlphaGradientView extends View {
    private Paint bcU;
    private int bqC;
    private int btf;
    private int btg;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bqC = 0;
        this.btg = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqC = 0;
        this.btg = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqC = 0;
        this.btg = 0;
    }

    public void setColor(int i, int i2) {
        this.bqC = i;
        this.btg = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.btf = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.bcU = new Paint();
            this.bcU.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bcU);
            this.bcU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bcU.setShader(new LinearGradient(0.0f, 0.0f, this.btf, 0.0f, this.bqC, this.btg, Shader.TileMode.CLAMP));
        } else {
            this.btf = 0;
            this.bcU = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bcU != null) {
            canvas.drawRect(0.0f, 0.0f, this.btf, getHeight(), this.bcU);
        }
    }
}
