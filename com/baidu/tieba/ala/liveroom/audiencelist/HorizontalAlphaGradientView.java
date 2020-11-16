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
    private int bEZ;
    private int bJP;
    private int bJQ;
    private Paint bkA;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.bEZ = 0;
        this.bJQ = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEZ = 0;
        this.bJQ = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEZ = 0;
        this.bJQ = 0;
    }

    public void setColor(int i, int i2) {
        this.bEZ = i;
        this.bJQ = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.bJP = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.bkA = new Paint();
            this.bkA.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.bkA);
            this.bkA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bkA.setShader(new LinearGradient(0.0f, 0.0f, this.bJP, 0.0f, this.bEZ, this.bJQ, Shader.TileMode.CLAMP));
        } else {
            this.bJP = 0;
            this.bkA = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bkA != null) {
            canvas.drawRect(0.0f, 0.0f, this.bJP, getHeight(), this.bkA);
        }
    }
}
