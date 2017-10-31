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
    private int aGK;
    public int aGL;
    private int aGM;
    private int aGN;
    private TextView aGO;
    private int aGP;
    private int aGQ;
    private HashMap<String, e.a> aGR;
    private ImageView abO;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGK = 0;
        this.aGR = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGK = 0;
        this.aGR = new HashMap<>();
        init();
    }

    private void init() {
        this.aGP = getResources().getDimensionPixelSize(d.e.ds2);
        this.aGQ = getResources().getDimensionPixelSize(d.e.ds12);
        this.aGO = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGO.setLayoutParams(layoutParams);
        this.aGO.setGravity(17);
        this.aGO.setDuplicateParentStateEnabled(true);
        addView(this.aGO);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aGO.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGO.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGO.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aGR.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aGR.entrySet().iterator();
        while (it.hasNext() && this.aGO.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGO.getPaint().measureText(this.aGO.getText().toString());
            if (value.aHk) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.ur;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.ur) - (measureText / 2);
            }
            if (this.aGK == 1) {
                i5 = measuredWidth - this.aGQ;
                measuredHeight = this.aGP;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aGP = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGK = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGR.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gz(String str) {
        return this.aGR.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aGO.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.aGO.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aGO.setText(str);
        this.aGO.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGO.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.aGO.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGO.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aGM = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGN = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aGO.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aGO.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aGO.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGL = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        aj.c(this.aGO, this.aGL, 1);
        if (this.aGO != null) {
            if (this.aGO.getText() != null && am.isEmpty(this.aGO.getText().toString())) {
                this.abO.setImageDrawable(aj.c((Resources) null, this.aGM));
            } else {
                this.aGO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aGM), aj.getDrawable(this.aGN), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aGR.entrySet()) {
            entry.getValue().dE(i);
        }
    }

    public void EH() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGO.getLayoutParams();
        layoutParams.width = -2;
        this.aGO.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aGO;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void L(int i, int i2) {
        if (this.aGO != null) {
            this.aGO.setVisibility(8);
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
        this.abO.setImageDrawable(aj.c((Resources) null, this.aGM));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aHj = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aHj) {
            this.aGO.getPaint().setFakeBoldText(z);
        }
    }
}
