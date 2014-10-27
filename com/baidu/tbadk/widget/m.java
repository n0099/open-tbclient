package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import java.io.InputStream;
/* loaded from: classes.dex */
public class m extends DynamicDrawableSpan {
    private Uri aaO;
    private int aaP;
    private n aaQ;
    private Rect dZ;
    private Context mContext;
    private Drawable tt;

    public void setDrawable(Drawable drawable) {
        this.tt = drawable;
    }

    public m(n nVar, int i, int i2) {
        super(i2);
        this.dZ = new Rect();
        this.aaP = i;
        this.aaQ = nVar;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.tt != null || this.aaQ == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.dZ.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.dZ.right;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable;
        Drawable drawable2;
        Exception e;
        InputStream openInputStream;
        Drawable drawable3 = null;
        if (this.tt != null) {
            drawable3 = this.tt;
        } else if (this.aaQ != null) {
            drawable3 = this.aaQ.a(this);
        }
        if (drawable3 != null) {
            return drawable3;
        }
        if (this.aaO != null) {
            try {
                openInputStream = this.mContext.getContentResolver().openInputStream(this.aaO);
                drawable2 = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeStream(openInputStream));
            } catch (Exception e2) {
                drawable2 = drawable3;
                e = e2;
            }
            try {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                openInputStream.close();
                return drawable2;
            } catch (Exception e3) {
                e = e3;
                Log.e("sms", "Failed to loaded content " + this.aaO, e);
                return drawable2;
            }
        }
        try {
            drawable = aw.getDrawable(this.aaP);
        } catch (Exception e4) {
            drawable = drawable3;
        }
        try {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        } catch (Exception e5) {
            Log.e("sms", "Unable to find resource: " + this.aaP);
            return drawable;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
            int i6 = i5 - drawable.getBounds().bottom;
            if (this.mVerticalAlignment != 0) {
                i5 = i4;
            }
            canvas.translate(f, i5 - (drawable.getBounds().bottom - 4));
            if (TbadkApplication.m251getInst().getSkinType() == 1) {
                drawable.setColorFilter(new PorterDuffColorFilter(-5000269, PorterDuff.Mode.MULTIPLY));
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void d(int i, int i2, int i3, int i4) {
        this.dZ.set(i, i2, i3, i4);
    }
}
