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
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class HorizontalAlphaGradientView extends View {
    private Paint ahF;
    private int arM;
    private int arN;
    private int arb;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.arb = 0;
        this.arN = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arb = 0;
        this.arN = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arb = 0;
        this.arN = 0;
    }

    public void setColor(int i, int i2) {
        this.arb = i;
        this.arN = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.arM = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ahF = new Paint();
            this.ahF.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.ahF);
            this.ahF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.ahF.setShader(new LinearGradient(0.0f, 0.0f, this.arM, 0.0f, this.arb, this.arN, Shader.TileMode.CLAMP));
        } else {
            this.arM = 0;
            this.ahF = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ahF != null) {
            canvas.drawRect(0.0f, 0.0f, this.arM, getHeight(), this.ahF);
        }
    }
}
