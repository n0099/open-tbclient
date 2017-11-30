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
    private HashMap<String, e.a> aHB;
    private int aHu;
    public int aHv;
    private int aHw;
    private int aHx;
    private TextView aHy;
    private int aHz;
    private ImageView acj;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    private void init() {
        this.aHz = getResources().getDimensionPixelSize(d.e.ds2);
        this.aHA = getResources().getDimensionPixelSize(d.e.ds12);
        this.aHy = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHy.setLayoutParams(layoutParams);
        this.aHy.setGravity(17);
        this.aHy.setDuplicateParentStateEnabled(true);
        addView(this.aHy);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aHy.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHy.getLayoutParams();
            layoutParams.topMargin = i;
            this.aHy.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aHB.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aHB.entrySet().iterator();
        while (it.hasNext() && this.aHy.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aHy.getPaint().measureText(this.aHy.getText().toString());
            if (value.aHU) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.ur;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.ur) - (measureText / 2);
            }
            if (this.aHu == 1) {
                i5 = measuredWidth - this.aHA;
                measuredHeight = this.aHz;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aHz = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aHu = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aHB.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gD(String str) {
        return this.aHB.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aHy.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aHy.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aHy.setText(str);
        this.aHy.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aHy.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.aHy.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aHy.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aHw = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aHx = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aHy.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aHy.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aHy.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHv = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        aj.c(this.aHy, this.aHv, 1);
        if (this.aHy != null) {
            if (this.aHy.getText() != null && am.isEmpty(this.aHy.getText().toString())) {
                this.acj.setImageDrawable(aj.c((Resources) null, this.aHw));
            } else {
                this.aHy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aHw), aj.getDrawable(this.aHx), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aHB.entrySet()) {
            entry.getValue().dE(i);
        }
    }

    public void Fa() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHy.getLayoutParams();
        layoutParams.width = -2;
        this.aHy.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aHy;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void J(int i, int i2) {
        if (this.aHy != null) {
            this.aHy.setVisibility(8);
        }
        this.acj = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.acj.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.acj.setLayoutParams(layoutParams);
        addView(this.acj);
        this.acj.setImageDrawable(aj.c((Resources) null, this.aHw));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aHT = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aHT) {
            this.aHy.getPaint().setFakeBoldText(z);
        }
    }
}
