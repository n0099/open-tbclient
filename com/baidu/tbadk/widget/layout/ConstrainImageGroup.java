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
    private com.baidu.adp.lib.e.b<TbImageView> aSA;
    private c aSB;
    private int aSC;
    private double aSD;
    private d aSE;
    private View.OnClickListener aSF;
    private ViewGroup.OnHierarchyChangeListener aSG;
    private BdUniqueId aSy;
    private com.baidu.adp.lib.e.b<b> aSz;
    private boolean ajh;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.aSB = new a();
        this.ajh = false;
        this.aSG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aSz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aSz.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aSG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSB = new a();
        this.ajh = false;
        this.aSG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aSz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aSz.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aSG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSB = new a();
        this.ajh = false;
        this.aSG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.aSz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.aSz.m(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.aSG);
    }

    public void setFromCDN(boolean z) {
        this.ajh = z;
    }

    public void setSingleImageRatio(double d) {
        this.aSD = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.aSF = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.aSz = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.aSE = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.aSE);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aSA = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.aSC = i;
        } else {
            this.aSC = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.w(list)) {
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
        if (!v.w(list) && this.aSz != null) {
            fN(v.v(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.aSE);
                    bVar.setFromCDN(this.ajh);
                    if (this.aSD > 0.0d) {
                        bVar.setSingleImageRatio(this.aSD);
                    }
                    bVar.setOnClickListener(this.aSF);
                    i = this.aSB.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void fN(int i) {
        int fM = this.aSB.fM(i);
        int childCount = getChildCount() - fM;
        if (childCount > 0) {
            removeViews(fM, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b fH = this.aSz.fH();
        fH.setImagePadding(this.aSC);
        fH.setImageViewObjectPool(this.aSA);
        fH.setImageMaxChildCount(-1);
        fH.setExtraCenterText(null);
        fH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        fH.setPageUniqueId(this.aSy);
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
            this.aSB = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSy = bdUniqueId;
    }
}
