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
    private int aEM;
    private int aEN;
    private int aEd;
    private Paint auq;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.aEd = 0;
        this.aEN = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEd = 0;
        this.aEN = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEd = 0;
        this.aEN = 0;
    }

    public void setColor(int i, int i2) {
        this.aEd = i;
        this.aEN = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.aEM = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.auq = new Paint();
            this.auq.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.auq);
            this.auq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.auq.setShader(new LinearGradient(0.0f, 0.0f, this.aEM, 0.0f, this.aEd, this.aEN, Shader.TileMode.CLAMP));
        } else {
            this.aEM = 0;
            this.auq = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.auq != null) {
            canvas.drawRect(0.0f, 0.0f, this.aEM, getHeight(), this.auq);
        }
    }
}
