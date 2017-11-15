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
    private com.baidu.adp.lib.e.b<TbImageView> aPA;
    private c aPB;
    private int aPC;
    private double aPD;
    private d aPE;
    private View.OnClickListener aPF;
    private ViewGroup.OnHierarchyChangeListener aPG;
    private BdUniqueId aPy;
    private com.baidu.adp.lib.e.b<b> aPz;
    private boolean aiR;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aPB = new a();
        this.aiR = false;
        this.aPG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPz.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPB = new a();
        this.aiR = false;
        this.aPG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPz.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPB = new a();
        this.aiR = false;
        this.aPG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aPz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aPz.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aPG);
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void setSingleImageRatio(double d) {
        this.aPD = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aPF = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aPz = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aPE = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.aPE);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aPA = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aPC = i;
        } else {
            this.aPC = 0;
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
        if (!v.v(list) && this.aPz != null) {
            fG(v.u(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aPE);
                    bVar.setFromCDN(this.aiR);
                    if (this.aPD > 0.0d) {
                        bVar.setSingleImageRatio(this.aPD);
                    }
                    bVar.setOnClickListener(this.aPF);
                    i = this.aPB.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fG(int i) {
        int fF = this.aPB.fF(i);
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
        b fH = this.aPz.fH();
        fH.setImagePadding(this.aPC);
        fH.setImageViewObjectPool(this.aPA);
        fH.setImageMaxChildCount(-1);
        fH.setExtraCenterText(null);
        fH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fH.setPageUniqueId(this.aPy);
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
            this.aPB = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPy = bdUniqueId;
    }
}
