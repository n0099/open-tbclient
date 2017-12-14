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
    private int aHA;
    private int aHB;
    private TextView aHC;
    private int aHD;
    private int aHE;
    private HashMap<String, e.a> aHF;
    private int aHy;
    public int aHz;
    private ImageView acd;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aHy = 0;
        this.aHF = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHy = 0;
        this.aHF = new HashMap<>();
        init();
    }

    private void init() {
        this.aHD = getResources().getDimensionPixelSize(d.e.ds2);
        this.aHE = getResources().getDimensionPixelSize(d.e.ds12);
        this.aHC = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHC.setLayoutParams(layoutParams);
        this.aHC.setGravity(17);
        this.aHC.setDuplicateParentStateEnabled(true);
        addView(this.aHC);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aHC.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHC.getLayoutParams();
            layoutParams.topMargin = i;
            this.aHC.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aHF.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aHF.entrySet().iterator();
        while (it.hasNext() && this.aHC.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aHC.getPaint().measureText(this.aHC.getText().toString());
            if (value.aHY) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uo;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uo) - (measureText / 2);
            }
            if (this.aHy == 1) {
                i5 = measuredWidth - this.aHE;
                measuredHeight = this.aHD;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aHD = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aHy = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aHF.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gC(String str) {
        return this.aHF.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aHC.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aHC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aHC.setText(str);
        this.aHC.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aHC.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.aHC.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aHC.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aHA = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aHB = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aHC.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aHC.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aHC.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHz = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        aj.c(this.aHC, this.aHz, 1);
        if (this.aHC != null) {
            if (this.aHC.getText() != null && am.isEmpty(this.aHC.getText().toString())) {
                this.acd.setImageDrawable(aj.c((Resources) null, this.aHA));
            } else {
                this.aHC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aHA), aj.getDrawable(this.aHB), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aHF.entrySet()) {
            entry.getValue().dE(i);
        }
    }

    public void Fb() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHC.getLayoutParams();
        layoutParams.width = -2;
        this.aHC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aHC;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void K(int i, int i2) {
        if (this.aHC != null) {
            this.aHC.setVisibility(8);
        }
        this.acd = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.acd.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.acd.setLayoutParams(layoutParams);
        addView(this.acd);
        this.acd.setImageDrawable(aj.c((Resources) null, this.aHA));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aHX = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aHX) {
            this.aHC.getPaint().setFakeBoldText(z);
        }
    }
}
