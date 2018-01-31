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
    private int bvH;
    public int bvI;
    private int bvJ;
    private int bvK;
    private TextView bvL;
    private int bvM;
    private int bvN;
    private HashMap<String, e.a> bvO;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bvH = 0;
        this.bvO = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvH = 0;
        this.bvO = new HashMap<>();
        init();
    }

    private void init() {
        this.bvM = getResources().getDimensionPixelSize(d.e.ds2);
        this.bvN = getResources().getDimensionPixelSize(d.e.ds12);
        this.bvL = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bvL.setLayoutParams(layoutParams);
        this.bvL.setGravity(17);
        this.bvL.setDuplicateParentStateEnabled(true);
        addView(this.bvL);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.bvL.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bvL.getLayoutParams();
            layoutParams.topMargin = i;
            this.bvL.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.bvO.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.bvO.entrySet().iterator();
        while (it.hasNext() && this.bvL.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bvL.getPaint().measureText(this.bvL.getText().toString());
            if (value.bwh) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.aiF;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.aiF) - (measureText / 2);
            }
            if (this.bvH == 1) {
                i5 = measuredWidth - this.bvN;
                measuredHeight = this.bvM;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bvM = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.bvH = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bvO.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gN(String str) {
        return this.bvO.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.bvL.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.bvL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.bvL.setText(str);
        this.bvL.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bvL.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.bvL.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bvL.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.bvJ = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bvK = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.bvL.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.bvL.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.bvL.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bvI = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gz(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gz(int i) {
        aj.e(this.bvL, this.bvI, 1);
        if (this.bvL != null) {
            if (this.bvL.getText() != null && am.isEmpty(this.bvL.getText().toString())) {
                this.mIconView.setImageDrawable(aj.c((Resources) null, this.bvJ));
            } else {
                this.bvL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.bvJ), aj.getDrawable(this.bvK), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.bvO.entrySet()) {
            entry.getValue().gz(i);
        }
    }

    public void Mq() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bvL.getLayoutParams();
        layoutParams.width = -2;
        this.bvL.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.bvL;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void aJ(int i, int i2) {
        if (this.bvL != null) {
            this.bvL.setVisibility(8);
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
        this.mIconView.setImageDrawable(aj.c((Resources) null, this.bvJ));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.bwg = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.bwg) {
            this.bvL.getPaint().setFakeBoldText(z);
        }
    }
}
