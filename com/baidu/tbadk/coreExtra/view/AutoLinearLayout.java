package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class AutoLinearLayout extends LinearLayout {
    private int asl;
    private int asm;
    private int asn;
    private int aso;
    private int asp;
    private int asq;
    private int asr;
    private Context mContext;

    public AutoLinearLayout(Context context) {
        super(context);
        this.asl = 0;
        this.asm = 0;
        this.asn = 0;
        this.asp = 0;
        this.asq = 0;
        this.asr = 0;
        this.mContext = context;
        setOrientation(0);
        this.asm = com.baidu.adp.lib.util.k.g(context, w.f.ds24);
        this.asn = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.asq = com.baidu.adp.lib.util.k.g(context, w.f.ds32);
        this.aso = com.baidu.adp.lib.util.k.ag(this.mContext) - (this.asq * 2);
        this.asr = (int) this.mContext.getResources().getDimension(w.f.ds60);
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asl = 0;
        this.asm = 0;
        this.asn = 0;
        this.asp = 0;
        this.asq = 0;
        this.asr = 0;
        this.mContext = context;
        setOrientation(0);
        this.asm = com.baidu.adp.lib.util.k.g(context, w.f.ds24);
        this.asn = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.asq = com.baidu.adp.lib.util.k.g(context, w.f.ds32);
        this.aso = com.baidu.adp.lib.util.k.ag(this.mContext) - (this.asq * 2);
        this.asr = (int) this.mContext.getResources().getDimension(w.f.ds60);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.mContext.getResources().getDimension(w.f.ds24);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i7 != 0 && i6 < measuredWidth) {
                    dimension += this.asm + measuredHeight;
                    i7 = 0;
                }
                childAt.layout(i7, dimension, i7 + measuredWidth, measuredHeight + dimension);
                i6 = (((i3 - i) - i7) - measuredWidth) - this.asn;
                i7 += this.asn + measuredWidth;
            }
            i5++;
            i7 = i7;
            i6 = i6;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.asr, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.asl != 0 && this.asp != 0) {
            ed(childCount);
        }
        if (this.asl != 0) {
            for (int i3 = 0; i3 < this.asp; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.asp = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.asl != 0) {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.asr * this.asl) + this.asm, i2));
        } else {
            setMeasuredDimension(resolveSize(0, i), resolveSize((this.asr * culumnsCount) + (this.asm * culumnsCount), i2));
        }
    }

    private void ed(int i) {
        if (this.asp <= i) {
            removeViews(this.asp, i - this.asp);
        }
    }

    private int getCulumnsCount() {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.asr, 1073741824);
        int childCount = getChildCount();
        int i4 = this.aso;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt == null) {
                int i8 = i6;
                i2 = i7;
                i3 = i8;
            } else {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (i4 < measuredWidth) {
                    i7++;
                    if (i7 == 1) {
                        this.asp = i5;
                    }
                    i = this.asn + measuredWidth + 0;
                } else {
                    i = this.asn + measuredWidth + i6;
                }
                i2 = i7;
                i3 = i;
                i4 = this.aso - i;
            }
            i5++;
            int i9 = i3;
            i7 = i2;
            i6 = i9;
        }
        return i7 + 1;
    }

    public void setShowColumns(int i) {
        this.asl = i;
    }

    public void setMarginRight(int i) {
        this.asn = i;
    }

    public void setParentWidth(int i) {
        this.aso = i;
    }

    public void setCellHeight(int i) {
        this.asr = i;
    }
}
