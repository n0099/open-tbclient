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
    private Paint ahX;
    private int art;
    private int ase;
    private int asf;

    public HorizontalAlphaGradientView(Context context) {
        super(context);
        this.art = 0;
        this.asf = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.art = 0;
        this.asf = 0;
    }

    public HorizontalAlphaGradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.art = 0;
        this.asf = 0;
    }

    public void setColor(int i, int i2) {
        this.art = i;
        this.asf = i2;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            this.ase = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ahX = new Paint();
            this.ahX.setStyle(Paint.Style.FILL_AND_STROKE);
            setLayerType(0, this.ahX);
            this.ahX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.ahX.setShader(new LinearGradient(0.0f, 0.0f, this.ase, 0.0f, this.art, this.asf, Shader.TileMode.CLAMP));
        } else {
            this.ase = 0;
            this.ahX = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ahX != null) {
            canvas.drawRect(0.0f, 0.0f, this.ase, getHeight(), this.ahX);
        }
    }
}
