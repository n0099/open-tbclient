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
    private BdUniqueId aPq;
    private com.baidu.adp.lib.e.b<b> aPr;
    private com.baidu.adp.lib.e.b<TbImageView> aPs;
    private c aPt;
    private int aPu;
    private double aPv;
    private d aPw;
    private View.OnClickListener aPx;
    private ViewGroup.OnHierarchyChangeListener aPy;
    private boolean aiR;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aPt = new a();
        this.aiR = false;
        this.aPy = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPr != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPr.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPy);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPt = new a();
        this.aiR = false;
        this.aPy = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPr != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPr.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPy);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPt = new a();
        this.aiR = false;
        this.aPy = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPr != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPr.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPy);
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void setSingleImageRatio(double d) {
        this.aPv = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aPx = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aPr = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aPw = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.aPw);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aPs = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aPu = i;
        } else {
            this.aPu = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.v(list)) {
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
        if (!v.v(list) && this.aPr != null) {
            fH(v.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aPw);
                    bVar.setFromCDN(this.aiR);
                    if (this.aPv > 0.0d) {
                        bVar.setSingleImageRatio(this.aPv);
                    }
                    bVar.setOnClickListener(this.aPx);
                    i = this.aPt.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fH(int i) {
        int fG = this.aPt.fG(i);
        int childCount = getChildCount() - fG;
        if (childCount > 0) {
            removeViews(fG, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b fH = this.aPr.fH();
        fH.setImagePadding(this.aPu);
        fH.setImageViewObjectPool(this.aPs);
        fH.setImageMaxChildCount(-1);
        fH.setExtraCenterText(null);
        fH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fH.setPageUniqueId(this.aPq);
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
            this.aPt = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPq = bdUniqueId;
    }
}
