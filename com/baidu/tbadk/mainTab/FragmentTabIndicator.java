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
    private int aHB;
    public int aHC;
    private int aHD;
    private int aHE;
    private TextView aHF;
    private int aHG;
    private int aHH;
    private HashMap<String, e.a> aHI;
    private ImageView acg;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aHB = 0;
        this.aHI = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHB = 0;
        this.aHI = new HashMap<>();
        init();
    }

    private void init() {
        this.aHG = getResources().getDimensionPixelSize(d.e.ds2);
        this.aHH = getResources().getDimensionPixelSize(d.e.ds12);
        this.aHF = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHF.setLayoutParams(layoutParams);
        this.aHF.setGravity(17);
        this.aHF.setDuplicateParentStateEnabled(true);
        addView(this.aHF);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aHF.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHF.getLayoutParams();
            layoutParams.topMargin = i;
            this.aHF.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aHI.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aHI.entrySet().iterator();
        while (it.hasNext() && this.aHF.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aHF.getPaint().measureText(this.aHF.getText().toString());
            if (value.aIb) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.up;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.up) - (measureText / 2);
            }
            if (this.aHB == 1) {
                i5 = measuredWidth - this.aHH;
                measuredHeight = this.aHG;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aHG = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aHB = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aHI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gC(String str) {
        return this.aHI.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aHF.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aHF.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aHF.setText(str);
        this.aHF.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aHF.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.aHF.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aHF.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aHD = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aHE = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aHF.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aHF.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aHF.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHC = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        aj.c(this.aHF, this.aHC, 1);
        if (this.aHF != null) {
            if (this.aHF.getText() != null && am.isEmpty(this.aHF.getText().toString())) {
                this.acg.setImageDrawable(aj.c((Resources) null, this.aHD));
            } else {
                this.aHF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aHD), aj.getDrawable(this.aHE), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aHI.entrySet()) {
            entry.getValue().dE(i);
        }
    }

    public void Fb() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHF.getLayoutParams();
        layoutParams.width = -2;
        this.aHF.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aHF;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void K(int i, int i2) {
        if (this.aHF != null) {
            this.aHF.setVisibility(8);
        }
        this.acg = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.acg.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.acg.setLayoutParams(layoutParams);
        addView(this.acg);
        this.acg.setImageDrawable(aj.c((Resources) null, this.aHD));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aIa = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aIa) {
            this.aHF.getPaint().setFakeBoldText(z);
        }
    }
}
