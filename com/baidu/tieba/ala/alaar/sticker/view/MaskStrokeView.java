package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class MaskStrokeView extends View {
    private int aFx;
    private int geB;
    private Bitmap gfo;
    private Canvas gfp;
    private Paint gfq;
    private int height;
    private int width;

    public MaskStrokeView(Context context) {
        this(context, null);
    }

    public MaskStrokeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskStrokeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.MaskStrokeView);
            this.width = obtainStyledAttributes.getInteger(a.j.MaskStrokeView_widthInt, 60);
            this.height = obtainStyledAttributes.getInteger(a.j.MaskStrokeView_heightInt, 60);
            obtainStyledAttributes.recycle();
        }
        try {
            this.gfo = drawableToBitmap(getResources().getDrawable(a.e.sticker_selected_bg));
            this.gfp = new Canvas(this.gfo);
            this.gfq = new Paint();
            this.gfq.setColor(-1);
            this.gfq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.gfq.setFlags(1);
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.MaskStrokeView.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    MaskStrokeView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    MaskStrokeView.this.aFx = BdUtilHelper.dip2px(MaskStrokeView.this.getContext(), MaskStrokeView.this.width);
                    MaskStrokeView.this.geB = BdUtilHelper.dip2px(MaskStrokeView.this.getContext(), MaskStrokeView.this.height);
                    MaskStrokeView.this.gfo = MaskStrokeView.this.drawableToBitmap(MaskStrokeView.this.getResources().getDrawable(a.e.sticker_selected_bg));
                    MaskStrokeView.this.gfp = new Canvas(MaskStrokeView.this.gfo);
                    MaskStrokeView.this.invalidate();
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.gfp.drawRoundRect(new RectF(e(getContext(), 3.0f), e(getContext(), 3.0f), getDefaultWidth() - e(getContext(), 3.0f), getDefaultHeight() - e(getContext(), 3.0f)), e(getContext(), 6.0f), e(getContext(), 6.0f), this.gfq);
        canvas.drawBitmap(this.gfo, 0.0f, 0.0f, (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) getDefaultWidth(), (int) getDefaultHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, (int) getDefaultWidth(), (int) getDefaultHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private float e(Context context, float f) {
        return context.getResources().getDisplayMetrics().density * f;
    }

    private float getDefaultWidth() {
        return this.aFx <= 0 ? e(getContext(), 60.0f) : this.aFx;
    }

    private float getDefaultHeight() {
        return this.geB <= 0 ? e(getContext(), 60.0f) : this.geB;
    }
}
