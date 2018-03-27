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
    private int bxH;
    public int bxI;
    private int bxJ;
    private int bxK;
    private TextView bxL;
    private int bxM;
    private int bxN;
    private HashMap<String, e.a> bxO;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bxH = 0;
        this.bxO = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxH = 0;
        this.bxO = new HashMap<>();
        init();
    }

    private void init() {
        this.bxM = getResources().getDimensionPixelSize(d.e.ds2);
        this.bxN = getResources().getDimensionPixelSize(d.e.ds12);
        this.bxL = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bxL.setLayoutParams(layoutParams);
        this.bxL.setGravity(17);
        this.bxL.setDuplicateParentStateEnabled(true);
        addView(this.bxL);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.bxL.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bxL.getLayoutParams();
            layoutParams.topMargin = i;
            this.bxL.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.bxO.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.bxO.entrySet().iterator();
        while (it.hasNext() && this.bxL.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bxL.getPaint().measureText(this.bxL.getText().toString());
            if (value.byh) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.aiy;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.aiy) - (measureText / 2);
            }
            if (this.bxH == 1) {
                i5 = measuredWidth - this.bxN;
                measuredHeight = this.bxM;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bxM = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.bxH = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bxO.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gX(String str) {
        return this.bxO.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.bxL.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.bxL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.bxL.setText(str);
        this.bxL.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bxL.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.bxL.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bxL.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.bxJ = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bxK = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.bxL.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.bxL.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.bxL.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bxI = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gB(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gB(int i) {
        aj.e(this.bxL, this.bxI, 1);
        if (this.bxL != null) {
            if (this.bxL.getText() != null && am.isEmpty(this.bxL.getText().toString())) {
                this.mIconView.setImageDrawable(aj.c((Resources) null, this.bxJ));
            } else {
                this.bxL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.bxJ), aj.getDrawable(this.bxK), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.bxO.entrySet()) {
            entry.getValue().gB(i);
        }
    }

    public void MW() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bxL.getLayoutParams();
        layoutParams.width = -2;
        this.bxL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.bxL;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void aJ(int i, int i2) {
        if (this.bxL != null) {
            this.bxL.setVisibility(8);
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
        this.mIconView.setImageDrawable(aj.c((Resources) null, this.bxJ));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.byg = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.byg) {
            this.bxL.getPaint().setFakeBoldText(z);
        }
    }
}
