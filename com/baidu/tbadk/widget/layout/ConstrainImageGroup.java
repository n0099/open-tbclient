package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private boolean ZM;
    private com.baidu.adp.lib.f.b<c> aCQ;
    private com.baidu.adp.lib.f.b<TbImageView> aCR;
    private f aCS;
    private int aCT;
    private h aCU;
    private View.OnClickListener aCV;
    private ViewGroup.OnHierarchyChangeListener aCW;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aCS = new a();
        this.ZM = false;
        this.aCW = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aCW);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCS = new a();
        this.ZM = false;
        this.aCW = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aCW);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCS = new a();
        this.ZM = false;
        this.aCW = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aCW);
    }

    public void setFromCDN(boolean z) {
        this.ZM = z;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aCV = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aCQ = bVar;
    }

    public void setImageClickListener(h hVar) {
        this.aCU = hVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aCR = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aCT = i;
        } else {
            this.aCT = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!y.t(list) && this.aCQ != null) {
            fc(y.s(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aCU);
                    cVar.setFromCDN(this.ZM);
                    cVar.setOnClickListener(this.aCV);
                    i = this.aCS.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fc(int i) {
        int fb = this.aCS.fb(i);
        int childCount = getChildCount() - fb;
        if (childCount > 0) {
            removeViews(fb, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c dE = this.aCQ.dE();
        dE.setImagePadding(this.aCT);
        dE.setImageViewObjectPool(this.aCR);
        dE.setImageMaxChildCount(-1);
        dE.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aCT;
        dE.setLayoutParams(layoutParams);
        return dE;
    }

    public void se() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).se();
            }
        }
    }
}
