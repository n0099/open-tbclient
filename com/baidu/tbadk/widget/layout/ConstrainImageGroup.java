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
    private boolean aXA;
    private BdUniqueId bGE;
    private com.baidu.adp.lib.e.b<b> bGF;
    private com.baidu.adp.lib.e.b<TbImageView> bGG;
    private c bGH;
    private int bGI;
    private double bGJ;
    private d bGK;
    private View.OnClickListener bGL;
    private ViewGroup.OnHierarchyChangeListener bGM;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bGH = new a();
        this.aXA = false;
        this.bGM = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGF != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGF.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGM);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGH = new a();
        this.aXA = false;
        this.bGM = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGF != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGF.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGM);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGH = new a();
        this.aXA = false;
        this.bGM = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bGF != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bGF.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bGM);
    }

    public void setFromCDN(boolean z) {
        this.aXA = z;
    }

    public void setSingleImageRatio(double d) {
        this.bGJ = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bGL = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.bGF = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.bGK = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.bGK);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bGG = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bGI = i;
        } else {
            this.bGI = 0;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (!v.E(list)) {
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
        if (!v.E(list) && this.bGF != null) {
            iI(v.D(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.bGK);
                    bVar.setFromCDN(this.aXA);
                    if (this.bGJ > 0.0d) {
                        bVar.setSingleImageRatio(this.bGJ);
                    }
                    bVar.setOnClickListener(this.bGL);
                    i = this.bGH.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void iI(int i) {
        int iH = this.bGH.iH(i);
        int childCount = getChildCount() - iH;
        if (childCount > 0) {
            removeViews(iH, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b nk = this.bGF.nk();
        nk.setImagePadding(this.bGI);
        nk.setImageViewObjectPool(this.bGG);
        nk.setImageMaxChildCount(-1);
        nk.setExtraCenterText(null);
        nk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        nk.setPageUniqueId(this.bGE);
        return nk;
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
            this.bGH = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bGE = bdUniqueId;
    }
}
