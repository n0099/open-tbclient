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
    private int bvp;
    public int bvq;
    private int bvr;
    private int bvs;
    private TextView bvt;
    private int bvu;
    private int bvv;
    private HashMap<String, e.a> bvw;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bvp = 0;
        this.bvw = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvp = 0;
        this.bvw = new HashMap<>();
        init();
    }

    private void init() {
        this.bvu = getResources().getDimensionPixelSize(d.e.ds2);
        this.bvv = getResources().getDimensionPixelSize(d.e.ds12);
        this.bvt = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bvt.setLayoutParams(layoutParams);
        this.bvt.setGravity(17);
        this.bvt.setDuplicateParentStateEnabled(true);
        addView(this.bvt);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.bvt.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bvt.getLayoutParams();
            layoutParams.topMargin = i;
            this.bvt.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.bvw.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.bvw.entrySet().iterator();
        while (it.hasNext() && this.bvt.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bvt.getPaint().measureText(this.bvt.getText().toString());
            if (value.bvP) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.aiC;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.aiC) - (measureText / 2);
            }
            if (this.bvp == 1) {
                i5 = measuredWidth - this.bvv;
                measuredHeight = this.bvu;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bvu = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.bvp = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bvw.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gF(String str) {
        return this.bvw.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.bvt.setText(i);
    }

    public void setWidth(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, -2);
        layoutParams.gravity = 17;
        this.bvt.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.bvt.setText(str);
        this.bvt.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bvt.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.j.talk_checked_tip) + charSequence;
        }
        this.bvt.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bvt.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.bvr = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bvs = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.bvt.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.bvt.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.bvt.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bvq = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gC(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gC(int i) {
        aj.e(this.bvt, this.bvq, 1);
        if (this.bvt != null) {
            if (this.bvt.getText() != null && am.isEmpty(this.bvt.getText().toString())) {
                this.mIconView.setImageDrawable(aj.c((Resources) null, this.bvr));
            } else {
                this.bvt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.bvr), aj.getDrawable(this.bvs), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.bvw.entrySet()) {
            entry.getValue().gC(i);
        }
    }

    public void MA() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bvt.getLayoutParams();
        layoutParams.width = -2;
        this.bvt.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.bvt;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void aJ(int i, int i2) {
        if (this.bvt != null) {
            this.bvt.setVisibility(8);
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
        this.mIconView.setImageDrawable(aj.c((Resources) null, this.bvr));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.bvO = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.bvO) {
            this.bvt.getPaint().setFakeBoldText(z);
        }
    }
}
