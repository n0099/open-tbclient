package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    public int a;
    public int b;
    private TextView c;
    private HashMap<String, c> d;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.d = new HashMap<>();
        a();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new HashMap<>();
        a();
    }

    private void a() {
        this.c = new TextView(getContext());
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.c.setGravity(17);
        this.c.setDuplicateParentStateEnabled(true);
        addView(this.c);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.d.entrySet()) {
            entry.getValue().a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        int measuredHeight2;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.d.entrySet().iterator();
        while (it.hasNext() && this.c.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.a.getMeasuredWidth();
            int measuredHeight3 = value.a.getMeasuredHeight();
            if (value.b) {
                measuredWidth = (getMeasuredWidth() / 2) + value.c + (((int) this.c.getPaint().measureText(this.c.getText().toString())) / 2);
                measuredHeight = (getMeasuredHeight() - j.a(getContext(), 3.0f)) / 2;
                measuredHeight2 = value.a.getMeasuredHeight();
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.c) - (((int) this.c.getPaint().measureText(this.c.getText().toString())) / 2);
                measuredHeight = (getMeasuredHeight() - j.a(getContext(), 3.0f)) / 2;
                measuredHeight2 = value.a.getMeasuredHeight();
            }
            int i5 = measuredHeight - (measuredHeight2 / 2);
            value.a.layout(measuredWidth, i5, measuredWidth2 + measuredWidth, measuredHeight3 + i5);
        }
    }

    public void a(String str, c cVar) {
        if (cVar.a != null) {
            addView(cVar.a);
            this.d.put(str, cVar);
        }
    }

    public c a(String str) {
        return this.d.get(str);
    }

    public void setText(int i) {
        this.c.setText(i);
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setTextSize(float f) {
        this.c.setTextSize(f);
    }

    public void a(int i, float f) {
        this.c.setTextSize(i, f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setTextColor(getResources().getColorStateList(this.b));
        } else {
            this.c.setTextColor(getResources().getColorStateList(this.a));
        }
        for (Map.Entry<String, c> entry : this.d.entrySet()) {
            entry.getValue().a(i);
        }
    }
}
