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
    private com.baidu.adp.lib.f.b<c> aGt;
    private com.baidu.adp.lib.f.b<TbImageView> aGu;
    private f aGv;
    private int aGw;
    private g aGx;
    private View.OnClickListener aGy;
    private ViewGroup.OnHierarchyChangeListener aGz;
    private boolean adX;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aGv = new a();
        this.adX = false;
        this.aGz = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGz);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGv = new a();
        this.adX = false;
        this.aGz = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGz);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGv = new a();
        this.adX = false;
        this.aGz = new b(this);
        setOrientation(1);
        setOnHierarchyChangeListener(this.aGz);
    }

    public void setFromCDN(boolean z) {
        this.adX = z;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aGy = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<c> bVar) {
        this.aGt = bVar;
    }

    public void setImageClickListener(g gVar) {
        this.aGx = gVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGu = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aGw = i;
        } else {
            this.aGw = 0;
        }
    }

    public void setImageUrls(List<String> list) {
        int i;
        if (!y.q(list) && this.aGt != null) {
            fs(y.p(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    cVar.setImageClickListener(this.aGx);
                    cVar.setFromCDN(this.adX);
                    cVar.setOnClickListener(this.aGy);
                    i = this.aGv.a(cVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fs(int i) {
        int fr = this.aGv.fr(i);
        int childCount = getChildCount() - fr;
        if (childCount > 0) {
            removeViews(fr, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private c getConstrainImageLayout() {
        c hp = this.aGt.hp();
        hp.setImagePadding(this.aGw);
        hp.setImageViewObjectPool(this.aGu);
        hp.setImageMaxChildCount(-1);
        hp.setExtraCenterText(null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aGw;
        hp.setLayoutParams(layoutParams);
        return hp;
    }

    public void uA() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                ((c) childAt).uA();
            }
        }
    }
}
