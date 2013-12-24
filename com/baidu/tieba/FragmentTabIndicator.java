package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TextView {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public FragmentTabIndicator(Context context) {
        super(context);
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i) {
        if (i == 1) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(this.b), (Drawable) null, (Drawable) null);
            setBackgroundResource(this.d);
            setTextColor(getResources().getColorStateList(this.f));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(this.a), (Drawable) null, (Drawable) null);
        setBackgroundResource(this.c);
        setTextColor(getResources().getColorStateList(this.e));
    }
}
