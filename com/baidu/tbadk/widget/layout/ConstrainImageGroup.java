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
    private boolean aZj;
    private BdUniqueId bII;
    private com.baidu.adp.lib.e.b<b> bIJ;
    private com.baidu.adp.lib.e.b<TbImageView> bIK;
    private c bIL;
    private int bIM;
    private double bIN;
    private d bIO;
    private View.OnClickListener bIP;
    private ViewGroup.OnHierarchyChangeListener bIQ;

    public ConstrainImageGroup(Context context) {
        super(context);
        this.bIL = new a();
        this.aZj = false;
        this.bIQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIJ != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIJ.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bIQ);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIL = new a();
        this.aZj = false;
        this.bIQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIJ != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIJ.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bIQ);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIL = new a();
        this.aZj = false;
        this.bIQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.ConstrainImageGroup.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof b) && ConstrainImageGroup.this.bIJ != null) {
                    b bVar = (b) view2;
                    bVar.reset();
                    ConstrainImageGroup.this.bIJ.ar(bVar);
                }
            }
        };
        setOrientation(1);
        setOnHierarchyChangeListener(this.bIQ);
    }

    public void setFromCDN(boolean z) {
        this.aZj = z;
    }

    public void setSingleImageRatio(double d) {
        this.bIN = d;
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.bIP = onClickListener;
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<b> bVar) {
        this.bIJ = bVar;
    }

    public void setImageClickListener(d dVar) {
        this.bIO = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof b) {
                    ((b) childAt).setImageClickListener(this.bIO);
                }
            }
        }
    }

    public void setImageViewPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.bIK = bVar;
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.bIM = i;
        } else {
            this.bIM = 0;
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
        if (!v.E(list) && this.bIJ != null) {
            iF(v.D(list));
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    bVar.setImageClickListener(this.bIO);
                    bVar.setFromCDN(this.aZj);
                    if (this.bIN > 0.0d) {
                        bVar.setSingleImageRatio(this.bIN);
                    }
                    bVar.setOnClickListener(this.bIP);
                    i = this.bIL.a(bVar, list, i2, i3);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void iF(int i) {
        int iE = this.bIL.iE(i);
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
        b nk = this.bIJ.nk();
        nk.setImagePadding(this.bIM);
        nk.setImageViewObjectPool(this.bIK);
        nk.setImageMaxChildCount(-1);
        nk.setExtraCenterText(null);
        nk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        nk.setPageUniqueId(this.bII);
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
            this.bIL = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bII = bdUniqueId;
    }
}
