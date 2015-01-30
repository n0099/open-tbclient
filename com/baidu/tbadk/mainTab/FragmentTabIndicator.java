package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int acn;
    public int aco;
    private int acp;
    private TextView acq;
    private int acr;
    private int acs;
    private HashMap<String, c> acu;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.acn = 0;
        this.acu = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acn = 0;
        this.acu = new HashMap<>();
        init();
    }

    private void init() {
        this.acr = getResources().getDimensionPixelSize(u.ds2);
        this.acs = getResources().getDimensionPixelSize(u.ds12);
        this.acq = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.acq.setLayoutParams(layoutParams);
        this.acq.setGravity(17);
        this.acq.setDuplicateParentStateEnabled(true);
        addView(this.acq);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.acu.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.acu.entrySet().iterator();
        while (it.hasNext() && this.acq.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.acq.getPaint().measureText(this.acq.getText().toString());
            if (value.acv) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.jO;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.jO) - (measureText / 2);
            }
            if (this.acn == 1) {
                i5 = measuredWidth - this.acs;
                measuredHeight = this.acr;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.acn = i;
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.acu.put(str, cVar);
        }
    }

    public c et(String str) {
        return this.acu.get(str);
    }

    public void setText(int i) {
        this.acq.setText(i);
    }

    public void setText(String str) {
        this.acq.setText(str);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.acp = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.acq.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.acq.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.acq.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aco = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ct(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void ct(int i) {
        bc.b(this.acq, this.aco, 1);
        if (this.acq != null) {
            this.acq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bc.getDrawable(this.acp), (Drawable) null, (Drawable) null);
        }
        for (Map.Entry<String, c> entry : this.acu.entrySet()) {
            entry.getValue().ct(i);
        }
    }
}
