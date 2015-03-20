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
    private int alK;
    public int alL;
    private int alM;
    private TextView alN;
    private int alO;
    private int alP;
    private HashMap<String, c> alQ;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.alK = 0;
        this.alQ = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alK = 0;
        this.alQ = new HashMap<>();
        init();
    }

    private void init() {
        this.alO = getResources().getDimensionPixelSize(t.ds2);
        this.alP = getResources().getDimensionPixelSize(t.ds12);
        this.alN = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.alN.setLayoutParams(layoutParams);
        this.alN.setGravity(17);
        this.alN.setDuplicateParentStateEnabled(true);
        addView(this.alN);
    }

    public void setContentTvTopMargin(int i) {
        if (this.alN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alN.getLayoutParams();
            layoutParams.topMargin = i;
            this.alN.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.alQ.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.alQ.entrySet().iterator();
        while (it.hasNext() && this.alN.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.alN.getPaint().measureText(this.alN.getText().toString());
            if (value.alR) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.vf;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.vf) - (measureText / 2);
            }
            if (this.alK == 1) {
                i5 = measuredWidth - this.alP;
                measuredHeight = this.alO;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.alK = i;
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.alQ.put(str, cVar);
        }
    }

    public c ex(String str) {
        return this.alQ.get(str);
    }

    public void setText(int i) {
        this.alN.setText(i);
    }

    public void setText(String str) {
        this.alN.setText(str);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.alM = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.alN.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.alN.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.alN.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.alL = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cu(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cu(int i) {
        ba.b(this.alN, this.alL, 1);
        if (this.alN != null) {
            this.alN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ba.getDrawable(this.alM), (Drawable) null, (Drawable) null);
        }
        for (Map.Entry<String, c> entry : this.alQ.entrySet()) {
            entry.getValue().cu(i);
        }
    }
}
