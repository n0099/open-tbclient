package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int abQ;
    public int abR;
    private int abS;
    private TextView abT;
    private int abU;
    private int abV;
    private HashMap<String, c> abW;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.abQ = 0;
        this.abW = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abQ = 0;
        this.abW = new HashMap<>();
        init();
    }

    private void init() {
        this.abU = getResources().getDimensionPixelSize(u.ds2);
        this.abV = getResources().getDimensionPixelSize(u.ds12);
        this.abT = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.abT.setLayoutParams(layoutParams);
        this.abT.setGravity(17);
        this.abT.setDuplicateParentStateEnabled(true);
        addView(this.abT);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.abW.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.abW.entrySet().iterator();
        while (it.hasNext() && this.abT.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.abT.getPaint().measureText(this.abT.getText().toString());
            if (value.abX) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.jM;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.jM) - (measureText / 2);
            }
            if (this.abQ == 1) {
                i5 = measuredWidth - this.abV;
                measuredHeight = this.abU;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.abQ = i;
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.abW.put(str, cVar);
        }
    }

    public c et(String str) {
        return this.abW.get(str);
    }

    public void setText(int i) {
        this.abT.setText(i);
    }

    public void setText(String str) {
        this.abT.setText(str);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.abS = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.abT.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.abT.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.abT.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.abR = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cm(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void cm(int i) {
        ax.b(this.abT, this.abR, 1);
        if (this.abT != null) {
            this.abT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ax.getDrawable(this.abS), (Drawable) null, (Drawable) null);
        }
        for (Map.Entry<String, c> entry : this.abW.entrySet()) {
            entry.getValue().cm(i);
        }
    }
}
