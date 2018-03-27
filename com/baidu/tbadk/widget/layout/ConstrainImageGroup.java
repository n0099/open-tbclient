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
    private boolean aQq;
    private boolean aYZ;
    private com.baidu.adp.lib.e.b<TbImageView> bIA;
    private c bIB;
    private int bIC;
    private double bID;
    private d bIE;
    private View.OnClickListener bIF;
    private ViewGroup.OnHierarchyChangeListener bIG;
    private BdUniqueId bIy;
    private com.baidu.adp.lib.e.b<b> bIz;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bIB = new a();
        this.aYZ = false;
        this.aQq = false;
        this.bIG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIz.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bIG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIB = new a();
        this.aYZ = false;
        this.aQq = false;
        this.bIG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIz.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bIG);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIB = new a();
        this.aYZ = false;
        this.aQq = false;
        this.bIG = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIz != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIz.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bIG);
    }

    public void setFromCDN(boolean z) {
        this.aYZ = z;
    }

    public void setSingleImageRatio(double d) {
        this.bID = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bIF = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.bIz = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.bIE = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.bIE);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bIA = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bIC = i;
        } else {
            this.bIC = 0;
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
        if (!v.E(list) && this.bIz != null) {
            iF(v.D(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.bIE);
                    bVar.setFromCDN(this.aYZ);
                    bVar.setGrayScaleMode(this.aQq);
                    if (this.bID > 0.0d) {
                        bVar.setSingleImageRatio(this.bID);
                    }
                    bVar.setOnClickListener(this.bIF);
                    i = this.bIB.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void iF(int i) {
        int iE = this.bIB.iE(i);
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
        b nk = this.bIz.nk();
        nk.setImagePadding(this.bIC);
        nk.setImageViewObjectPool(this.bIA);
        nk.setImageMaxChildCount(-1);
        nk.setExtraCenterText(null);
        nk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        nk.setPageUniqueId(this.bIy);
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
            this.bIB = cVar;
        }
    }

    public void setGrayScaleMode(boolean z) {
        this.aQq = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bIy = bdUniqueId;
    }
}
