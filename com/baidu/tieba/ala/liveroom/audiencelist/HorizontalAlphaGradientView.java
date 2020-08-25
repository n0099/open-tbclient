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
    private Paint bcS;
    private int bqz;
    private int btc;
    private int btd;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bqz = 0;
        this.btd = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqz = 0;
        this.btd = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqz = 0;
        this.btd = 0;
    }

    public void setColor(int i, int i2) {
        this.bqz = i;
        this.btd = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.btc = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.bcS = new Paint();
            this.bcS.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bcS);
            this.bcS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bcS.setShader(new LinearGradient(0.0f, 0.0f, this.btc, 0.0f, this.bqz, this.btd, Shader.TileMode.CLAMP));
        } else {
            this.btc = 0;
            this.bcS = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bcS != null) {
            canvas.drawRect(0.0f, 0.0f, this.btc, getHeight(), this.bcS);
        }
    }
}
