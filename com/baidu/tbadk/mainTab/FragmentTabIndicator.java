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
    private int ack;
    public int acl;
    private int acm;
    private TextView acn;
    private int aco;
    private int acp;
    private HashMap<String, c> acq;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.ack = 0;
        this.acq = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ack = 0;
        this.acq = new HashMap<>();
        init();
    }

    private void init() {
        this.aco = getResources().getDimensionPixelSize(u.ds2);
        this.acp = getResources().getDimensionPixelSize(u.ds12);
        this.acn = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.acn.setLayoutParams(layoutParams);
        this.acn.setGravity(17);
        this.acn.setDuplicateParentStateEnabled(true);
        addView(this.acn);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.acq.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.acq.entrySet().iterator();
        while (it.hasNext() && this.acn.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.acn.getPaint().measureText(this.acn.getText().toString());
            if (value.acr) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.jO;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.jO) - (measureText / 2);
            }
            if (this.ack == 1) {
                i5 = measuredWidth - this.acp;
                measuredHeight = this.aco;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.ack = i;
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.acq.put(str, cVar);
        }
    }

    public c eq(String str) {
        return this.acq.get(str);
    }

    public void setText(int i) {
        this.acn.setText(i);
    }

    public void setText(String str) {
        this.acn.setText(str);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.acm = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.acn.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.acn.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.acn.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.acl = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ct(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void ct(int i) {
        bc.b(this.acn, this.acl, 1);
        if (this.acn != null) {
            this.acn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bc.getDrawable(this.acm), (Drawable) null, (Drawable) null);
        }
        for (Map.Entry<String, c> entry : this.acq.entrySet()) {
            entry.getValue().ct(i);
        }
    }
}
