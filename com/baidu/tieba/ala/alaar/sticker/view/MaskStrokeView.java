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
    private int aEz;
    private int fPq;
    private Bitmap fQd;
    private Canvas fQe;
    private Paint fQf;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.MaskStrokeView);
            this.width = obtainStyledAttributes.getInteger(a.k.MaskStrokeView_widthInt, 60);
            this.height = obtainStyledAttributes.getInteger(a.k.MaskStrokeView_heightInt, 60);
            obtainStyledAttributes.recycle();
        }
        try {
            this.fQd = drawableToBitmap(getResources().getDrawable(a.f.sticker_selected_bg));
            this.fQe = new Canvas(this.fQd);
            this.fQf = new Paint();
            this.fQf.setColor(-1);
            this.fQf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.fQf.setFlags(1);
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.MaskStrokeView.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    MaskStrokeView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    MaskStrokeView.this.aEz = BdUtilHelper.dip2px(MaskStrokeView.this.getContext(), MaskStrokeView.this.width);
                    MaskStrokeView.this.fPq = BdUtilHelper.dip2px(MaskStrokeView.this.getContext(), MaskStrokeView.this.height);
                    MaskStrokeView.this.fQd = MaskStrokeView.this.drawableToBitmap(MaskStrokeView.this.getResources().getDrawable(a.f.sticker_selected_bg));
                    MaskStrokeView.this.fQe = new Canvas(MaskStrokeView.this.fQd);
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
        this.fQe.drawRoundRect(new RectF(e(getContext(), 3.0f), e(getContext(), 3.0f), getDefaultWidth() - e(getContext(), 3.0f), getDefaultHeight() - e(getContext(), 3.0f)), e(getContext(), 6.0f), e(getContext(), 6.0f), this.fQf);
        canvas.drawBitmap(this.fQd, 0.0f, 0.0f, (Paint) null);
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
        return this.aEz <= 0 ? e(getContext(), 60.0f) : this.aEz;
    }

    private float getDefaultHeight() {
        return this.fPq <= 0 ? e(getContext(), 60.0f) : this.fPq;
    }
}
