package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FixLengthTextView extends TextView {
    private String Ui;

    public FixLengthTextView(Context context) {
        this(context, null, 0);
    }

    public FixLengthTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixLengthTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.fixtextview);
        this.Ui = obtainStyledAttributes.getString(obtainStyledAttributes.getIndex(0));
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!TextUtils.isEmpty(this.Ui)) {
            int desiredWidth = ((int) Layout.getDesiredWidth(this.Ui, getPaint())) + getPaddingLeft() + getPaddingRight();
            int size = View.MeasureSpec.getSize(i);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                desiredWidth = Math.max(desiredWidth, size);
            }
            i = View.MeasureSpec.makeMeasureSpec(desiredWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public String getmMeasureText() {
        return this.Ui;
    }

    public void setmMeasureText(String str) {
        this.Ui = str;
    }
}
