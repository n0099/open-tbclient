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
    public ItemTableRowView f15906e;

    /* renamed from: f  reason: collision with root package name */
    public ItemTableRowView f15907f;

    /* renamed from: g  reason: collision with root package name */
    public ItemTableRowView f15908g;

    /* renamed from: h  reason: collision with root package name */
    public ItemTableRowView f15909h;

    /* renamed from: i  reason: collision with root package name */
    public ItemTableRowView f15910i;
    public SparseArray<ItemTableRowView> j;

    public ItemTableView(Context context) {
        this(context, null);
    }

    public void a() {
        this.f15906e.a();
        this.f15907f.a();
        this.f15908g.a();
        this.f15909h.a();
        this.f15910i.a();
    }

    public final void b(Context context) {
        setOrientation(1);
        this.f15910i = c(context, 0, 0);
        this.f15909h = c(context, 1, k);
        this.f15908g = c(context, 2, k);
        this.f15907f = c(context, 3, k);
        this.f15906e = c(context, 4, k);
        SparseArray<ItemTableRowView> sparseArray = new SparseArray<>();
        this.j = sparseArray;
        sparseArray.put(5, this.f15910i);
        this.j.put(4, this.f15909h);
        this.j.put(3, this.f15908g);
        this.j.put(2, this.f15907f);
        this.j.put(1, this.f15906e);
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
        this.f15906e.c();
        this.f15907f.c();
        this.f15908g.c();
        this.f15909h.c();
        this.f15910i.c();
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
