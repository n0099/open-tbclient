package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int alS;
    public int alT;
    private int alU;
    private TextView alV;
    private int alW;
    private int alX;
    private HashMap<String, c> alY;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.alS = 0;
        this.alY = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alS = 0;
        this.alY = new HashMap<>();
        init();
    }

    private void init() {
        this.alW = getResources().getDimensionPixelSize(t.ds2);
        this.alX = getResources().getDimensionPixelSize(t.ds12);
        this.alV = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.alV.setLayoutParams(layoutParams);
        this.alV.setGravity(17);
        this.alV.setDuplicateParentStateEnabled(true);
        addView(this.alV);
    }

    public void setContentTvTopMargin(int i) {
        if (this.alV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alV.getLayoutParams();
            layoutParams.topMargin = i;
            this.alV.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.alY.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.alY.entrySet().iterator();
        while (it.hasNext() && this.alV.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.alV.getPaint().measureText(this.alV.getText().toString());
            if (value.alZ) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.vf;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.vf) - (measureText / 2);
            }
            if (this.alS == 1) {
                i5 = measuredWidth - this.alX;
                measuredHeight = this.alW;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.alS = i;
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.alY.put(str, cVar);
        }
    }

    public c eA(String str) {
        return this.alY.get(str);
    }

    public void setText(int i) {
        this.alV.setText(i);
    }

    public void setText(String str) {
        this.alV.setText(str);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.alU = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.alV.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.alV.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.alV.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.alT = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cu(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cu(int i) {
        ba.b(this.alV, this.alT, 1);
        if (this.alV != null) {
            this.alV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ba.getDrawable(this.alU), (Drawable) null, (Drawable) null);
        }
        for (Map.Entry<String, c> entry : this.alY.entrySet()) {
            entry.getValue().cu(i);
        }
    }
}
