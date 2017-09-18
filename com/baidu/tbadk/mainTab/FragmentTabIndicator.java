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
    private int aGM;
    public int aGN;
    private int aGO;
    private int aGP;
    private TextView aGQ;
    private int aGR;
    private int aGS;
    private HashMap<String, e.a> aGT;
    private ImageView abA;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGM = 0;
        this.aGT = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGM = 0;
        this.aGT = new HashMap<>();
        init();
    }

    private void init() {
        this.aGR = getResources().getDimensionPixelSize(d.f.ds2);
        this.aGS = getResources().getDimensionPixelSize(d.f.ds12);
        this.aGQ = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGQ.setLayoutParams(layoutParams);
        this.aGQ.setGravity(17);
        this.aGQ.setDuplicateParentStateEnabled(true);
        addView(this.aGQ);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aGQ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGQ.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGQ.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aGT.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aGT.entrySet().iterator();
        while (it.hasNext() && this.aGQ.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGQ.getPaint().measureText(this.aGQ.getText().toString());
            if (value.aHm) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uo;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uo) - (measureText / 2);
            }
            if (this.aGM == 1) {
                i5 = measuredWidth - this.aGS;
                measuredHeight = this.aGR;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGM = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGT.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gw(String str) {
        return this.aGT.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aGQ.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aGQ.setText(str);
        this.aGQ.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGQ.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aGQ.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGQ.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aGO = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGP = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aGQ.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aGQ.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aGQ.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGN = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        du(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void du(int i) {
        aj.c(this.aGQ, this.aGN, 1);
        if (this.aGQ != null) {
            if (this.aGQ.getText() != null && am.isEmpty(this.aGQ.getText().toString())) {
                this.abA.setImageDrawable(aj.c((Resources) null, this.aGO));
            } else {
                this.aGQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aGO), aj.getDrawable(this.aGP), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aGT.entrySet()) {
            entry.getValue().du(i);
        }
    }

    public void EW() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGQ.getLayoutParams();
        layoutParams.width = -2;
        this.aGQ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aGQ;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void K(int i, int i2) {
        if (this.aGQ != null) {
            this.aGQ.setVisibility(8);
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
        this.abA.setImageDrawable(aj.c((Resources) null, this.aGO));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aHl = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aHl) {
            this.aGQ.getPaint().setFakeBoldText(z);
        }
    }
}
