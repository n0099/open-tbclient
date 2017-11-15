package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends e {
    private int aGS;
    public int aGT;
    private int aGU;
    private int aGV;
    private TextView aGW;
    private int aGX;
    private int aGY;
    private HashMap<String, e.a> aGZ;
    private ImageView abO;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGS = 0;
        this.aGZ = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGS = 0;
        this.aGZ = new HashMap<>();
        init();
    }

    private void init() {
        this.aGX = getResources().getDimensionPixelSize(d.e.ds2);
        this.aGY = getResources().getDimensionPixelSize(d.e.ds12);
        this.aGW = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGW.setLayoutParams(layoutParams);
        this.aGW.setGravity(17);
        this.aGW.setDuplicateParentStateEnabled(true);
        addView(this.aGW);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aGW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGW.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGW.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aGZ.entrySet()) {
            e.a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
            } else {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, e.a>> it = this.aGZ.entrySet().iterator();
        while (it.hasNext() && this.aGW.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGW.getPaint().measureText(this.aGW.getText().toString());
            if (value.aHs) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.ur;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.ur) - (measureText / 2);
            }
            if (this.aGS == 1) {
                i5 = measuredWidth - this.aGY;
                measuredHeight = this.aGX;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aGX = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGS = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGZ.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gA(String str) {
        return this.aGZ.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aGW.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aGW.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aGW.setText(str);
        this.aGW.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGW.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.aGW.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGW.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aGU = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGV = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aGW.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aGW.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aGW.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGT = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dD(int i) {
        aj.c(this.aGW, this.aGT, 1);
        if (this.aGW != null) {
            if (this.aGW.getText() != null && am.isEmpty(this.aGW.getText().toString())) {
                this.abO.setImageDrawable(aj.c((Resources) null, this.aGU));
            } else {
                this.aGW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aGU), aj.getDrawable(this.aGV), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aGZ.entrySet()) {
            entry.getValue().dD(i);
        }
    }

    public void ET() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGW.getLayoutParams();
        layoutParams.width = -2;
        this.aGW.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aGW;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void L(int i, int i2) {
        if (this.aGW != null) {
            this.aGW.setVisibility(8);
        }
        this.abO = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.abO.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.abO.setLayoutParams(layoutParams);
        addView(this.abO);
        this.abO.setImageDrawable(aj.c((Resources) null, this.aGU));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aHr = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aHr) {
            this.aGW.getPaint().setFakeBoldText(z);
        }
    }
}
