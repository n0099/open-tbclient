package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class FixedTextView extends View {
    private int hMD;
    private float hME;
    private TextPaint hMF;
    private String mText;
    private int mTextColor;

    public FixedTextView(Context context) {
        super(context);
        init(context, null);
    }

    public FixedTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public FixedTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_FixedTextView);
        this.hMD = obtainStyledAttributes.getInt(a.j.sdk_FixedTextView_sdk_ftvMaxLine, 1);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.sdk_FixedTextView_sdk_ftvTextColor, Color.parseColor("#333333"));
        this.hME = obtainStyledAttributes.getDimension(a.j.sdk_FixedTextView_sdk_ftvMinTextSize, -1.0f);
        this.mText = obtainStyledAttributes.getString(a.j.sdk_FixedTextView_sdk_ftvText);
        obtainStyledAttributes.recycle();
        this.hMF = new TextPaint(1);
        this.hMF.setColor(this.mTextColor);
        this.hMF.setTextSize(this.hME);
        this.hMF.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        float f;
        int i;
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int floor = (int) Math.floor((width - getPaddingLeft()) - getPaddingRight());
        int floor2 = (int) Math.floor((height - getPaddingTop()) - getPaddingBottom());
        float floor3 = (float) Math.floor(floor2 / this.hMD);
        float max = Math.max(this.hME, floor2);
        while (true) {
            this.hMF.setTextSize(max);
            staticLayout = new StaticLayout(this.mText, this.hMF, floor, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            f = max - 0.1f;
            if ((this.hME == -1.0f || f > this.hME) && staticLayout.getLineCount() > this.hMD) {
                max = f;
            }
        }
        if (this.hME != -1.0f && f <= this.hME && staticLayout.getLineCount() > this.hMD) {
            staticLayout.getLineCount();
            int lineForVertical = staticLayout.getLineForVertical(floor2);
            int length = this.mText.length();
            while (true) {
                i = length - 1;
                if (new StaticLayout(this.mText.substring(0, i), this.hMF, floor, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= lineForVertical) {
                    break;
                }
                length = i;
            }
            staticLayout = new StaticLayout(this.mText.substring(0, i - 1) + "…", this.hMF, floor, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        float paddingLeft = getPaddingLeft();
        Rect rect = new Rect();
        String charSequence = staticLayout.getText().toString();
        this.hMF.getTextBounds(charSequence, 0, charSequence.length(), rect);
        if (rect.width() < floor) {
            paddingLeft = getPaddingLeft();
        }
        canvas.translate(paddingLeft, getPaddingTop() + ((floor2 - staticLayout.getHeight()) / 2.0f));
        staticLayout.draw(canvas);
    }

    public void setText(String str) {
        this.mText = str;
        invalidate();
    }
}
