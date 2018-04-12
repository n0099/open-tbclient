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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private int aIe;
    public int aIf;
    private int aIg;
    private int aIh;
    private TextView aIi;
    private int aIj;
    private int aIk;
    private HashMap<String, TbFragmentTabIndicator.a> aIl;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aIe = 0;
        this.aIl = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIe = 0;
        this.aIl = new HashMap<>();
        init();
    }

    private void init() {
        this.aIj = getResources().getDimensionPixelSize(d.e.ds2);
        this.aIk = getResources().getDimensionPixelSize(d.e.ds12);
        this.aIi = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aIi.setLayoutParams(layoutParams);
        this.aIi.setGravity(17);
        this.aIi.setDuplicateParentStateEnabled(true);
        addView(this.aIi);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.aIi.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aIi.getLayoutParams();
            layoutParams.topMargin = i;
            this.aIi.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aIl.entrySet()) {
            TbFragmentTabIndicator.a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.f7view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.f7view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            } else {
                value.f7view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.aIl.entrySet().iterator();
        while (it.hasNext() && this.aIi.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.f7view.getMeasuredWidth();
            int measuredHeight2 = value.f7view.getMeasuredHeight();
            int measureText = (int) this.aIi.getPaint().measureText(this.aIi.getText().toString());
            if (value.aIE) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.sU;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.sU) - (measureText / 2);
            }
            if (this.aIe == 1) {
                i5 = measuredWidth - this.aIk;
                measuredHeight = this.aIj;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.f7view.getMeasuredHeight() / 2);
            }
            value.f7view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aIj = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aIe = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.f7view != null) {
            addView(aVar.f7view);
            this.aIl.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a gM(String str) {
        return this.aIl.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.aIi.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aIi.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.aIi.setText(str);
        this.aIi.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aIi.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.k.talk_checked_tip) + charSequence;
        }
        this.aIi.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aIi.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.aIg = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aIh = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.aIi.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.aIi.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.aIi.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aIf = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dA(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dA(int i) {
        ak.c(this.aIi, this.aIf, 1);
        if (this.aIi != null) {
            if (this.aIi.getText() != null && an.isEmpty(this.aIi.getText().toString())) {
                this.mIconView.setImageDrawable(ak.c((Resources) null, this.aIg));
            } else {
                this.aIi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.c((Resources) null, this.aIg), ak.getDrawable(this.aIh), (Drawable) null);
            }
        }
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aIl.entrySet()) {
            entry.getValue().dA(i);
        }
    }

    public void setContentWidthWrapContent() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aIi.getLayoutParams();
        layoutParams.width = -2;
        this.aIi.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.aIi;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        if (this.aIi != null) {
            this.aIi.setVisibility(8);
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
        this.mIconView.setImageDrawable(ak.c((Resources) null, this.aIg));
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.aID = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aID) {
            this.aIi.getPaint().setFakeBoldText(z);
        }
    }
}
