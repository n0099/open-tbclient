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
    private boolean aYX;
    private double bIA;
    private d bIB;
    private View.OnClickListener bIC;
    private ViewGroup.OnHierarchyChangeListener bID;
    private BdUniqueId bIv;
    private com.baidu.adp.lib.e.b<b> bIw;
    private com.baidu.adp.lib.e.b<TbImageView> bIx;
    private c bIy;
    private int bIz;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bIy = new a();
        this.aYX = false;
        this.bID = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIw != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIw.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bID);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIy = new a();
        this.aYX = false;
        this.bID = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIw != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIw.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bID);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIy = new a();
        this.aYX = false;
        this.bID = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIw != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIw.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bID);
    }

    public void setFromCDN(boolean z) {
        this.aYX = z;
    }

    public void setSingleImageRatio(double d) {
        this.bIA = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bIC = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.bIw = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.bIB = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.bIB);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bIx = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bIz = i;
        } else {
            this.bIz = 0;
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
        if (!v.E(list) && this.bIw != null) {
            iF(v.D(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.bIB);
                    bVar.setFromCDN(this.aYX);
                    if (this.bIA > 0.0d) {
                        bVar.setSingleImageRatio(this.bIA);
                    }
                    bVar.setOnClickListener(this.bIC);
                    i = this.bIy.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void iF(int i) {
        int iE = this.bIy.iE(i);
        int childCount = getChildCount() - iE;
        if (childCount > 0) {
            removeViews(iE, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    private b getConstrainImageLayout() {
        b nk = this.bIw.nk();
        nk.setImagePadding(this.bIz);
        nk.setImageViewObjectPool(this.bIx);
        nk.setImageMaxChildCount(-1);
        nk.setExtraCenterText(null);
        nk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        nk.setPageUniqueId(this.bIv);
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
            this.bIy = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bIv = bdUniqueId;
    }
}
