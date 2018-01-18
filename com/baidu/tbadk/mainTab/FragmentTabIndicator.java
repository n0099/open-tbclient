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
    private int bvA;
    private int bvB;
    private TextView bvC;
    private int bvD;
    private int bvE;
    private HashMap<String, e.a> bvF;
    private int bvy;
    public int bvz;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bvy = 0;
        this.bvF = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvy = 0;
        this.bvF = new HashMap<>();
        init();
    }

    private void init() {
        this.bvD = getResources().getDimensionPixelSize(d.e.ds2);
        this.bvE = getResources().getDimensionPixelSize(d.e.ds12);
        this.bvC = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bvC.setLayoutParams(layoutParams);
        this.bvC.setGravity(17);
        this.bvC.setDuplicateParentStateEnabled(true);
        addView(this.bvC);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.bvC.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bvC.getLayoutParams();
            layoutParams.topMargin = i;
            this.bvC.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.bvF.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.bvF.entrySet().iterator();
        while (it.hasNext() && this.bvC.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bvC.getPaint().measureText(this.bvC.getText().toString());
            if (value.bvY) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.aiC;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.aiC) - (measureText / 2);
            }
            if (this.bvy == 1) {
                i5 = measuredWidth - this.bvE;
                measuredHeight = this.bvD;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bvD = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.bvy = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bvF.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gG(String str) {
        return this.bvF.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.bvC.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.bvC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.bvC.setText(str);
        this.bvC.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bvC.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.bvC.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bvC.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.bvA = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bvB = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.bvC.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.bvC.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.bvC.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bvz = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gz(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gz(int i) {
        aj.e(this.bvC, this.bvz, 1);
        if (this.bvC != null) {
            if (this.bvC.getText() != null && am.isEmpty(this.bvC.getText().toString())) {
                this.mIconView.setImageDrawable(aj.c((Resources) null, this.bvA));
            } else {
                this.bvC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.bvA), aj.getDrawable(this.bvB), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.bvF.entrySet()) {
            entry.getValue().gz(i);
        }
    }

    public void Mo() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bvC.getLayoutParams();
        layoutParams.width = -2;
        this.bvC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.bvC;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void aJ(int i, int i2) {
        if (this.bvC != null) {
            this.bvC.setVisibility(8);
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
        this.mIconView.setImageDrawable(aj.c((Resources) null, this.bvA));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.bvX = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.bvX) {
            this.bvC.getPaint().setFakeBoldText(z);
        }
    }
}
