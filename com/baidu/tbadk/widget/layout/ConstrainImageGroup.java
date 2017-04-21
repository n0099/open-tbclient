package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private com.baidu.adp.lib.e.b<c> aLa;
    private com.baidu.adp.lib.e.b<TbImageView> aLb;
    private f aLc;
    private int aLd;
    private double aLe;
    private g aLf;
    private View.OnClickListener aLg;
    private ViewGroup.OnHierarchyChangeListener aLh;
    private boolean aid;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aLc = new a();
        this.aid = false;
        this.aLh = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLh);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLc = new a();
        this.aid = false;
        this.aLh = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLh);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLc = new a();
        this.aid = false;
        this.aLh = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aLh);
    }

    public void setFromCDN(boolean z) {
        this.aid = z;
    }

    public void setSingleImageRatio(double d) {
        this.aLe = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aLg = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<c> bVar) {
        this.aLa = bVar;
    }

    public void setImageClickListener(g gVar) {
        this.aLf = gVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aLb = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aLd = i;
        } else {
            this.aLd = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!x.q(list) && this.aLa != null) {
            fp(x.p(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aLf);
                    cVar.setFromCDN(this.aid);
                    if (this.aLe > 0.0d) {
                        cVar.setSingleImageRatio(this.aLe);
                    }
                    cVar.setOnClickListener(this.aLg);
                    i = this.aLc.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fp(int i) {
        int fo = this.aLc.fo(i);
        int childCount = getChildCount() - fo;
        if (childCount > 0) {
            removeViews(fo, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c fK = this.aLa.fK();
        fK.setImagePadding(this.aLd);
        fK.setImageViewObjectPool(this.aLb);
        fK.setImageMaxChildCount(-1);
        fK.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aLd;
        fK.setLayoutParams(layoutParams);
        return fK;
    }

    public void onChangeSkinType() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).onChangeSkinType();
            }
        }
    }
}
