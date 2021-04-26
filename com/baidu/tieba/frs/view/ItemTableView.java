package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.List;
import tbclient.ItemPlot;
/* loaded from: classes4.dex */
public class ItemTableView extends LinearLayout {
    public static final int k = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);

    /* renamed from: e  reason: collision with root package name */
    public ItemTableRowView f16688e;

    /* renamed from: f  reason: collision with root package name */
    public ItemTableRowView f16689f;

    /* renamed from: g  reason: collision with root package name */
    public ItemTableRowView f16690g;

    /* renamed from: h  reason: collision with root package name */
    public ItemTableRowView f16691h;

    /* renamed from: i  reason: collision with root package name */
    public ItemTableRowView f16692i;
    public SparseArray<ItemTableRowView> j;

    public ItemTableView(Context context) {
        this(context, null);
    }

    public void a() {
        this.f16688e.a();
        this.f16689f.a();
        this.f16690g.a();
        this.f16691h.a();
        this.f16692i.a();
    }

    public final void b(Context context) {
        setOrientation(1);
        this.f16692i = c(context, 0, 0);
        this.f16691h = c(context, 1, k);
        this.f16690g = c(context, 2, k);
        this.f16689f = c(context, 3, k);
        this.f16688e = c(context, 4, k);
        SparseArray<ItemTableRowView> sparseArray = new SparseArray<>();
        this.j = sparseArray;
        sparseArray.put(5, this.f16692i);
        this.j.put(4, this.f16691h);
        this.j.put(3, this.f16690g);
        this.j.put(2, this.f16689f);
        this.j.put(1, this.f16688e);
    }

    public final ItemTableRowView c(Context context, int i2, int i3) {
        ItemTableRowView itemTableRowView = new ItemTableRowView(context);
        itemTableRowView.setEmptyStartCount(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i3;
        addView(itemTableRowView, layoutParams);
        return itemTableRowView;
    }

    public void d() {
        this.f16688e.c();
        this.f16689f.c();
        this.f16690g.c();
        this.f16691h.c();
        this.f16692i.c();
    }

    public void setData(List<ItemPlot> list, int i2) {
        a();
        if (list == null) {
            return;
        }
        for (ItemPlot itemPlot : list) {
            if (itemPlot != null) {
                int intValue = itemPlot.level.intValue();
                float intValue2 = (itemPlot.num.intValue() * 1.0f) / i2;
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

    public ItemTableView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context);
    }
}
