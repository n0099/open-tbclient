package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import java.util.List;
import tbclient.ItemPlot;
/* loaded from: classes4.dex */
public class ItemTableView extends LinearLayout {
    public static final int k = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);

    /* renamed from: e  reason: collision with root package name */
    public ItemTableRowView f16783e;

    /* renamed from: f  reason: collision with root package name */
    public ItemTableRowView f16784f;

    /* renamed from: g  reason: collision with root package name */
    public ItemTableRowView f16785g;

    /* renamed from: h  reason: collision with root package name */
    public ItemTableRowView f16786h;
    public ItemTableRowView i;
    public SparseArray<ItemTableRowView> j;

    public ItemTableView(Context context) {
        this(context, null);
    }

    public void a() {
        this.f16783e.a();
        this.f16784f.a();
        this.f16785g.a();
        this.f16786h.a();
        this.i.a();
    }

    public final void b(Context context) {
        setOrientation(1);
        this.i = c(context, 0, 0);
        this.f16786h = c(context, 1, k);
        this.f16785g = c(context, 2, k);
        this.f16784f = c(context, 3, k);
        this.f16783e = c(context, 4, k);
        SparseArray<ItemTableRowView> sparseArray = new SparseArray<>();
        this.j = sparseArray;
        sparseArray.put(5, this.i);
        this.j.put(4, this.f16786h);
        this.j.put(3, this.f16785g);
        this.j.put(2, this.f16784f);
        this.j.put(1, this.f16783e);
    }

    public final ItemTableRowView c(Context context, int i, int i2) {
        ItemTableRowView itemTableRowView = new ItemTableRowView(context);
        itemTableRowView.setEmptyStartCount(i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i2;
        addView(itemTableRowView, layoutParams);
        return itemTableRowView;
    }

    public void d() {
        this.f16783e.c();
        this.f16784f.c();
        this.f16785g.c();
        this.f16786h.c();
        this.i.c();
    }

    public void setData(List<ItemPlot> list, int i) {
        a();
        if (list == null) {
            return;
        }
        for (ItemPlot itemPlot : list) {
            if (itemPlot != null) {
                int intValue = itemPlot.level.intValue();
                float intValue2 = (itemPlot.num.intValue() * 1.0f) / i;
                ItemTableRowView itemTableRowView = this.j.get(intValue);
                if (itemTableRowView != null) {
                    itemTableRowView.setData(intValue2);
                }
            }
        }
        invalidate();
    }

    public ItemTableView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }
}
