package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
    private int bxR;
    public int bxS;
    private int bxT;
    private int bxU;
    private TextView bxV;
    private int bxW;
    private int bxX;
    private HashMap<String, e.a> bxY;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bxR = 0;
        this.bxY = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxR = 0;
        this.bxY = new HashMap<>();
        init();
    }

    private void init() {
        this.bxW = getResources().getDimensionPixelSize(d.e.ds2);
        this.bxX = getResources().getDimensionPixelSize(d.e.ds12);
        this.bxV = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bxV.setLayoutParams(layoutParams);
        this.bxV.setGravity(17);
        this.bxV.setDuplicateParentStateEnabled(true);
        addView(this.bxV);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.bxV.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bxV.getLayoutParams();
            layoutParams.topMargin = i;
            this.bxV.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.bxY.entrySet()) {
            e.a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
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
        Iterator<Map.Entry<String, e.a>> it = this.bxY.entrySet().iterator();
        while (it.hasNext() && this.bxV.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bxV.getPaint().measureText(this.bxV.getText().toString());
            if (value.byr) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.aiE;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.aiE) - (measureText / 2);
            }
            if (this.bxR == 1) {
                i5 = measuredWidth - this.bxX;
                measuredHeight = this.bxW;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bxW = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.bxR = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bxY.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gX(String str) {
        return this.bxY.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.bxV.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.bxV.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.bxV.setText(str);
        this.bxV.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bxV.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.bxV.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bxV.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.bxT = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bxU = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.bxV.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.bxV.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.bxV.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bxS = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gB(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gB(int i) {
        aj.e(this.bxV, this.bxS, 1);
        if (this.bxV != null) {
            if (this.bxV.getText() != null && am.isEmpty(this.bxV.getText().toString())) {
                this.mIconView.setImageDrawable(aj.c((Resources) null, this.bxT));
            } else {
                this.bxV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.bxT), aj.getDrawable(this.bxU), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.bxY.entrySet()) {
            entry.getValue().gB(i);
        }
    }

    public void MW() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bxV.getLayoutParams();
        layoutParams.width = -2;
        this.bxV.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.bxV;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void aJ(int i, int i2) {
        if (this.bxV != null) {
            this.bxV.setVisibility(8);
        }
        this.mIconView = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.mIconView.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.mIconView.setLayoutParams(layoutParams);
        addView(this.mIconView);
        this.mIconView.setImageDrawable(aj.c((Resources) null, this.bxT));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.byq = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.byq) {
            this.bxV.getPaint().setFakeBoldText(z);
        }
    }
}
