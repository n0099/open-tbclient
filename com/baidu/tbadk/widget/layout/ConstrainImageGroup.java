package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ConstrainImageGroup extends LinearLayout {
    private BdUniqueId aPk;
    private com.baidu.adp.lib.e.b<b> aPl;
    private com.baidu.adp.lib.e.b<TbImageView> aPm;
    private c aPn;
    private int aPo;
    private double aPp;
    private d aPq;
    private View.OnClickListener aPr;
    private ViewGroup.OnHierarchyChangeListener aPs;
    private boolean aiu;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aPn = new a();
        this.aiu = false;
        this.aPs = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPl != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPl.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPn = new a();
        this.aiu = false;
        this.aPs = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPl != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPl.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPs);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPn = new a();
        this.aiu = false;
        this.aPs = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPl != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPl.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPs);
    }

    public void setFromCDN(boolean z) {
        this.aiu = z;
    }

    public void setSingleImageRatio(double d) {
        this.aPp = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aPr = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aPl = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aPq = dVar;
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aPm = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aPo = i;
        } else {
            this.aPo = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.u(list)) {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                MediaData mediaData = new MediaData();
                mediaData.setPic(str);
                mediaData.setThumbnails_url(str);
                linkedList.add(mediaData);
            }
            setImageMediaList(linkedList);
        }
    }

    public void setImageMediaList(List<MediaData> list) {
        int i;
        if (!v.u(list) && this.aPl != null) {
            fG(v.t(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aPq);
                    bVar.setFromCDN(this.aiu);
                    if (this.aPp > 0.0d) {
                        bVar.setSingleImageRatio(this.aPp);
                    }
                    bVar.setOnClickListener(this.aPr);
                    i = this.aPn.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fG(int i) {
        int fF = this.aPn.fF(i);
        int childCount = getChildCount() - fF;
        if (childCount > 0) {
            removeViews(fF, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b fH = this.aPl.fH();
        fH.setImagePadding(this.aPo);
        fH.setImageViewObjectPool(this.aPm);
        fH.setImageMaxChildCount(-1);
        fH.setExtraCenterText(null);
        fH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fH.setPageUniqueId(this.aPk);
        return fH;
    }

    public void onChangeSkinType() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof b) {
                ((b) childAt).onChangeSkinType();
            }
        }
    }

    public void setImageProcessor(c cVar) {
        if (cVar != null) {
            this.aPn = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPk = bdUniqueId;
    }
}
