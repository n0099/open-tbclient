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
    private int aIf;
    public int aIg;
    private int aIh;
    private int aIi;
    private TextView aIj;
    private int aIk;
    private int aIl;
    private HashMap<String, TbFragmentTabIndicator.a> aIm;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aIf = 0;
        this.aIm = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIf = 0;
        this.aIm = new HashMap<>();
        init();
    }

    private void init() {
        this.aIk = getResources().getDimensionPixelSize(d.e.ds2);
        this.aIl = getResources().getDimensionPixelSize(d.e.ds12);
        this.aIj = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aIj.setLayoutParams(layoutParams);
        this.aIj.setGravity(17);
        this.aIj.setDuplicateParentStateEnabled(true);
        addView(this.aIj);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.aIj.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aIj.getLayoutParams();
            layoutParams.topMargin = i;
            this.aIj.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aIm.entrySet()) {
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.aIm.entrySet().iterator();
        while (it.hasNext() && this.aIj.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.f7view.getMeasuredWidth();
            int measuredHeight2 = value.f7view.getMeasuredHeight();
            int measureText = (int) this.aIj.getPaint().measureText(this.aIj.getText().toString());
            if (value.aIF) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.sT;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.sT) - (measureText / 2);
            }
            if (this.aIf == 1) {
                i5 = measuredWidth - this.aIl;
                measuredHeight = this.aIk;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.f7view.getMeasuredHeight() / 2);
            }
            value.f7view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aIk = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aIf = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.f7view != null) {
            addView(aVar.f7view);
            this.aIm.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a gM(String str) {
        return this.aIm.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.aIj.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aIj.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.aIj.setText(str);
        this.aIj.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aIj.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.k.talk_checked_tip) + charSequence;
        }
        this.aIj.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aIj.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.aIh = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aIi = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.aIj.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.aIj.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.aIj.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aIg = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dA(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dA(int i) {
        ak.c(this.aIj, this.aIg, 1);
        if (this.aIj != null) {
            if (this.aIj.getText() != null && an.isEmpty(this.aIj.getText().toString())) {
                this.mIconView.setImageDrawable(ak.c((Resources) null, this.aIh));
            } else {
                this.aIj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.c((Resources) null, this.aIh), ak.getDrawable(this.aIi), (Drawable) null);
            }
        }
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aIm.entrySet()) {
            entry.getValue().dA(i);
        }
    }

    public void setContentWidthWrapContent() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.width = -2;
        this.aIj.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.aIj;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        if (this.aIj != null) {
            this.aIj.setVisibility(8);
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
        this.mIconView.setImageDrawable(ak.c((Resources) null, this.aIh));
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.aIE = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aIE) {
            this.aIj.getPaint().setFakeBoldText(z);
        }
    }
}
