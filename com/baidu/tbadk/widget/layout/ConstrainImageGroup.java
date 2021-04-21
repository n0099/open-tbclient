package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import d.b.c.e.k.b;
import d.b.i0.b1.j.c;
import d.b.i0.b1.j.d;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ConstrainImageGroup extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f13852e;

    /* renamed from: f  reason: collision with root package name */
    public b<ConstrainImageLayout> f13853f;

    /* renamed from: g  reason: collision with root package name */
    public b<TbImageView> f13854g;

    /* renamed from: h  reason: collision with root package name */
    public c f13855h;
    public int i;
    public boolean j;
    public double k;
    public d l;
    public View.OnClickListener m;
    public d.b.c.j.c.b n;
    public ViewGroup.OnHierarchyChangeListener o;
    public boolean p;

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof ConstrainImageLayout) || ConstrainImageGroup.this.f13853f == null) {
                return;
            }
            ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
            constrainImageLayout.i();
            ConstrainImageGroup.this.f13853f.e(constrainImageLayout);
        }
    }

    public ConstrainImageGroup(Context context) {
        super(context);
        this.f13855h = new d.b.i0.b1.j.b();
        this.j = false;
        this.o = new a();
        this.p = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.o);
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        ConstrainImageLayout b2 = this.f13853f.b();
        b2.setImagePadding(this.i);
        b2.setImageViewObjectPool(this.f13854g);
        b2.setImageMaxChildCount(-1);
        b2.setExtraCenterText(null);
        b2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        b2.setPageUniqueId(this.f13852e);
        b2.setPreloadSizeReadyCallback(this.n);
        return b2;
    }

    public void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).h();
            }
        }
    }

    public final void c(int i) {
        int b2 = this.f13855h.b(i);
        int childCount = getChildCount() - b2;
        if (childCount > 0) {
            removeViews(b2, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                addView(getConstrainImageLayout());
            }
        }
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (z) {
            return;
        }
        setImageClickListener(null);
        setChildClickListener(null);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.f13853f = bVar;
    }

    public void setFromCDN(boolean z) {
        this.j = z;
    }

    public void setImageClickListener(d dVar) {
        this.l = dVar;
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setImageClickListener(this.l);
                }
            }
        }
    }

    public void setImageMargin(int i) {
        if (i >= 0) {
            this.i = i;
        } else {
            this.i = 0;
        }
    }

    public void setImageMediaList(List<MediaData> list) {
        if (ListUtils.isEmpty(list) || this.f13853f == null) {
            return;
        }
        c(ListUtils.getCount(list));
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ConstrainImageLayout) {
                ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                constrainImageLayout.setImageClickListener(this.l);
                constrainImageLayout.setFromCDN(this.j);
                double d2 = this.k;
                if (d2 > 0.0d) {
                    constrainImageLayout.setSingleImageRatio(d2);
                }
                View.OnClickListener onClickListener = this.m;
                if (onClickListener == null) {
                    constrainImageLayout.setClickable(false);
                } else {
                    constrainImageLayout.setOnClickListener(onClickListener);
                }
                constrainImageLayout.setSinglePicUseStyleV10(this.p);
                i = this.f13855h.a(constrainImageLayout, list, i2, i);
            }
        }
    }

    public void setImageProcessor(c cVar) {
        if (cVar != null) {
            this.f13855h = cVar;
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            MediaData mediaData = new MediaData();
            mediaData.setPic(str);
            mediaData.setThumbnails_url(str);
            linkedList.add(mediaData);
        }
        setImageMediaList(linkedList);
    }

    public void setImageViewPool(b<TbImageView> bVar) {
        this.f13854g = bVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.f13852e = bdUniqueId;
    }

    public void setPreloadSizeReadyCallback(d.b.c.j.c.b bVar) {
        this.n = bVar;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ConstrainImageLayout) {
                ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
            }
        }
    }

    public void setSingleImageRatio(double d2) {
        this.k = d2;
    }

    public void setSinglePicUseStyleV10(boolean z) {
        this.p = z;
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13855h = new d.b.i0.b1.j.b();
        this.j = false;
        this.o = new a();
        this.p = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.o);
    }

    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13855h = new d.b.i0.b1.j.b();
        this.j = false;
        this.o = new a();
        this.p = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.o);
    }
}
