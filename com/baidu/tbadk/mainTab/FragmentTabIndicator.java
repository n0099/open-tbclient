package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    public int VR;
    private TextView VS;
    private HashMap<String, c> VT;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.VT = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VT = new HashMap<>();
        init();
    }

    private void init() {
        this.VS = new TextView(getContext());
        this.VS.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.VS.setGravity(17);
        this.VS.setDuplicateParentStateEnabled(true);
        addView(this.VS);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.VT.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        int measuredHeight2;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.VT.entrySet().iterator();
        while (it.hasNext() && this.VS.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight3 = value.view.getMeasuredHeight();
            if (value.VU) {
                measuredWidth = (getMeasuredWidth() / 2) + value.jI + (((int) this.VS.getPaint().measureText(this.VS.getText().toString())) / 2);
                measuredHeight = getMeasuredHeight() / 2;
                measuredHeight2 = value.view.getMeasuredHeight();
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.jI) - (((int) this.VS.getPaint().measureText(this.VS.getText().toString())) / 2);
                measuredHeight = getMeasuredHeight() / 2;
                measuredHeight2 = value.view.getMeasuredHeight();
            }
            int i5 = measuredHeight - (measuredHeight2 / 2);
            value.view.layout(measuredWidth, i5, measuredWidth2 + measuredWidth, measuredHeight3 + i5);
        }
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.VT.put(str, cVar);
        }
    }

    public c dG(String str) {
        return this.VT.get(str);
    }

    public void setText(int i) {
        this.VS.setText(i);
    }

    public void setText(String str) {
        this.VS.setText(str);
    }

    public void setTextSize(float f) {
        this.VS.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.VS.setTextSize(i, f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bN(TbadkApplication.m251getInst().getSkinType());
    }

    public void bN(int i) {
        aw.b(this.VS, this.VR, 1);
        for (Map.Entry<String, c> entry : this.VT.entrySet()) {
            entry.getValue().bN(i);
        }
    }
}
