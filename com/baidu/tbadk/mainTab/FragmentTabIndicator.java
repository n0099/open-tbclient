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
    private int aGP;
    public int aGQ;
    private int aGR;
    private int aGS;
    private TextView aGT;
    private int aGU;
    private int aGV;
    private HashMap<String, e.a> aGW;
    private ImageView abA;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGP = 0;
        this.aGW = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGP = 0;
        this.aGW = new HashMap<>();
        init();
    }

    private void init() {
        this.aGU = getResources().getDimensionPixelSize(d.f.ds2);
        this.aGV = getResources().getDimensionPixelSize(d.f.ds12);
        this.aGT = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGT.setLayoutParams(layoutParams);
        this.aGT.setGravity(17);
        this.aGT.setDuplicateParentStateEnabled(true);
        addView(this.aGT);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aGT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGT.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGT.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aGW.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aGW.entrySet().iterator();
        while (it.hasNext() && this.aGT.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGT.getPaint().measureText(this.aGT.getText().toString());
            if (value.aHp) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uo;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uo) - (measureText / 2);
            }
            if (this.aGP == 1) {
                i5 = measuredWidth - this.aGV;
                measuredHeight = this.aGU;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGP = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGW.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gw(String str) {
        return this.aGW.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aGT.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aGT.setText(str);
        this.aGT.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGT.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aGT.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGT.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aGR = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGS = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aGT.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aGT.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aGT.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGQ = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        du(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void du(int i) {
        aj.c(this.aGT, this.aGQ, 1);
        if (this.aGT != null) {
            if (this.aGT.getText() != null && am.isEmpty(this.aGT.getText().toString())) {
                this.abA.setImageDrawable(aj.c((Resources) null, this.aGR));
            } else {
                this.aGT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aGR), aj.getDrawable(this.aGS), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aGW.entrySet()) {
            entry.getValue().du(i);
        }
    }

    public void EW() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGT.getLayoutParams();
        layoutParams.width = -2;
        this.aGT.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aGT;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void K(int i, int i2) {
        if (this.aGT != null) {
            this.aGT.setVisibility(8);
        }
        this.abA = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.abA.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.abA.setLayoutParams(layoutParams);
        addView(this.abA);
        this.abA.setImageDrawable(aj.c((Resources) null, this.aGR));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aHo = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aHo) {
            this.aGT.getPaint().setFakeBoldText(z);
        }
    }
}
