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
    private int aGn;
    public int aGo;
    private int aGp;
    private int aGq;
    private TextView aGr;
    private int aGs;
    private int aGt;
    private HashMap<String, e.a> aGu;
    private ImageView abB;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGn = 0;
        this.aGu = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGn = 0;
        this.aGu = new HashMap<>();
        init();
    }

    private void init() {
        this.aGs = getResources().getDimensionPixelSize(d.f.ds2);
        this.aGt = getResources().getDimensionPixelSize(d.f.ds12);
        this.aGr = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGr.setLayoutParams(layoutParams);
        this.aGr.setGravity(17);
        this.aGr.setDuplicateParentStateEnabled(true);
        addView(this.aGr);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aGr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGr.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGr.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aGu.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aGu.entrySet().iterator();
        while (it.hasNext() && this.aGr.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGr.getPaint().measureText(this.aGr.getText().toString());
            if (value.aGN) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uq;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uq) - (measureText / 2);
            }
            if (this.aGn == 1) {
                i5 = measuredWidth - this.aGt;
                measuredHeight = this.aGs;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGn = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGu.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gt(String str) {
        return this.aGu.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aGr.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aGr.setText(str);
        this.aGr.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGr.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aGr.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGr.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aGp = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGq = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aGr.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aGr.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aGr.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGo = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        aj.c(this.aGr, this.aGo, 1);
        if (this.aGr != null) {
            if (this.aGr.getText() != null && am.isEmpty(this.aGr.getText().toString())) {
                this.abB.setImageDrawable(aj.c((Resources) null, this.aGp));
            } else {
                this.aGr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aGp), aj.getDrawable(this.aGq), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aGu.entrySet()) {
            entry.getValue().dE(i);
        }
    }

    public void EB() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGr.getLayoutParams();
        layoutParams.width = -2;
        this.aGr.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aGr;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void L(int i, int i2) {
        if (this.aGr != null) {
            this.aGr.setVisibility(8);
        }
        this.abB = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.abB.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.abB.setLayoutParams(layoutParams);
        addView(this.abB);
        this.abB.setImageDrawable(aj.c((Resources) null, this.aGp));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aGM = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aGM) {
            this.aGr.getPaint().setFakeBoldText(z);
        }
    }
}
