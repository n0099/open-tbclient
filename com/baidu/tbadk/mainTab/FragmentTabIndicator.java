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
    private int aGa;
    public int aGb;
    private int aGc;
    private int aGd;
    private TextView aGe;
    private int aGf;
    private int aGg;
    private HashMap<String, e.a> aGh;
    private ImageView abo;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGa = 0;
        this.aGh = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGa = 0;
        this.aGh = new HashMap<>();
        init();
    }

    private void init() {
        this.aGf = getResources().getDimensionPixelSize(d.f.ds2);
        this.aGg = getResources().getDimensionPixelSize(d.f.ds12);
        this.aGe = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGe.setLayoutParams(layoutParams);
        this.aGe.setGravity(17);
        this.aGe.setDuplicateParentStateEnabled(true);
        addView(this.aGe);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setContentTvTopMargin(int i) {
        if (this.aGe.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGe.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGe.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, e.a> entry : this.aGh.entrySet()) {
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
        Iterator<Map.Entry<String, e.a>> it = this.aGh.entrySet().iterator();
        while (it.hasNext() && this.aGe.getText() != null) {
            e.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGe.getPaint().measureText(this.aGe.getText().toString());
            if (value.aGA) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.ur;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.ur) - (measureText / 2);
            }
            if (this.aGa == 1) {
                i5 = measuredWidth - this.aGg;
                measuredHeight = this.aGf;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGa = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGh.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gr(String str) {
        return this.aGh.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.aGe.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(String str) {
        this.aGe.setText(str);
        this.aGe.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGe.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aGe.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGe.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablesTopResId(int i) {
        this.aGc = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGd = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setCompoundDrawablePadding(int i) {
        this.aGe.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(float f) {
        this.aGe.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextSize(int i, float f) {
        this.aGe.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGb = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dD(int i) {
        aj.c(this.aGe, this.aGb, 1);
        if (this.aGe != null) {
            if (this.aGe.getText() != null && am.isEmpty(this.aGe.getText().toString())) {
                this.abo.setImageDrawable(aj.c((Resources) null, this.aGc));
            } else {
                this.aGe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.c((Resources) null, this.aGc), aj.getDrawable(this.aGd), (Drawable) null);
            }
        }
        for (Map.Entry<String, e.a> entry : this.aGh.entrySet()) {
            entry.getValue().dD(i);
        }
    }

    public void Ev() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGe.getLayoutParams();
        layoutParams.width = -2;
        this.aGe.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.aGe;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void L(int i, int i2) {
        if (this.aGe != null) {
            this.aGe.setVisibility(8);
        }
        this.abo = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.abo.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.abo.setLayoutParams(layoutParams);
        addView(this.abo);
        this.abo.setImageDrawable(aj.c((Resources) null, this.aGc));
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setIsContentSelectBold(boolean z) {
        this.aGz = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aGz) {
            this.aGe.getPaint().setFakeBoldText(z);
        }
    }
}
