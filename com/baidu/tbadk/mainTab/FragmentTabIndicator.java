package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int amT;
    public int amU;
    private int amV;
    private int amW;
    private TextView amX;
    private int amY;
    private int amZ;
    private HashMap<String, c> ana;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.amT = 0;
        this.ana = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amT = 0;
        this.ana = new HashMap<>();
        init();
    }

    private void init() {
        this.amY = getResources().getDimensionPixelSize(o.ds2);
        this.amZ = getResources().getDimensionPixelSize(o.ds12);
        this.amX = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.amX.setLayoutParams(layoutParams);
        this.amX.setGravity(17);
        this.amX.setDuplicateParentStateEnabled(true);
        addView(this.amX);
    }

    public void setContentTvTopMargin(int i) {
        if (this.amX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amX.getLayoutParams();
            layoutParams.topMargin = i;
            this.amX.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, c> entry : this.ana.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, c>> it = this.ana.entrySet().iterator();
        while (it.hasNext() && this.amX.getText() != null) {
            c value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.amX.getPaint().measureText(this.amX.getText().toString());
            if (value.anb) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.ur;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.ur) - (measureText / 2);
            }
            if (this.amT == 1) {
                i5 = measuredWidth - this.amZ;
                measuredHeight = this.amY;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.amT = i;
    }

    public void a(String str, c cVar) {
        if (cVar.view != null) {
            addView(cVar.view);
            this.ana.put(str, cVar);
        }
    }

    public c eR(String str) {
        return this.ana.get(str);
    }

    public void setText(int i) {
        this.amX.setText(i);
    }

    public void setText(String str) {
        this.amX.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.amX.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.amV = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.amW = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.amX.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.amX.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.amX.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.amU = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cz(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cz(int i) {
        ay.b(this.amX, this.amU, 1);
        if (this.amX != null) {
            this.amX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ay.getDrawable(this.amV), ay.getDrawable(this.amW), (Drawable) null);
        }
        for (Map.Entry<String, c> entry : this.ana.entrySet()) {
            entry.getValue().cz(i);
        }
    }
}
