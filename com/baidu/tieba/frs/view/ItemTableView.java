package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.ItemPlot;
/* loaded from: classes22.dex */
public class ItemTableView extends LinearLayout {
    private static final int jpg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView jpa;
    private ItemTableRowView jpb;
    private ItemTableRowView jpc;
    private ItemTableRowView jpd;
    private ItemTableRowView jpe;
    private SparseArray<ItemTableRowView> jpf;

    public ItemTableView(Context context) {
        this(context, null);
    }

    public ItemTableView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.jpe = b(context, 0, 0);
        this.jpd = b(context, 1, jpg);
        this.jpc = b(context, 2, jpg);
        this.jpb = b(context, 3, jpg);
        this.jpa = b(context, 4, jpg);
        this.jpf = new SparseArray<>();
        this.jpf.put(5, this.jpe);
        this.jpf.put(4, this.jpd);
        this.jpf.put(3, this.jpc);
        this.jpf.put(2, this.jpb);
        this.jpf.put(1, this.jpa);
    }

    private ItemTableRowView b(Context context, int i, int i2) {
        ItemTableRowView itemTableRowView = new ItemTableRowView(context);
        itemTableRowView.setEmptyStartCount(i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i2;
        addView(itemTableRowView, layoutParams);
        return itemTableRowView;
    }

    public void setData(List<ItemPlot> list, int i) {
        clear();
        if (list != null) {
            for (ItemPlot itemPlot : list) {
                if (itemPlot != null) {
                    int intValue = itemPlot.level.intValue();
                    float intValue2 = (itemPlot.num.intValue() * 1.0f) / i;
                    ItemTableRowView itemTableRowView = this.jpf.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jpa.clear();
        this.jpb.clear();
        this.jpc.clear();
        this.jpd.clear();
        this.jpe.clear();
    }

    public void onChangeSkinType() {
        this.jpa.onChangeSkinType();
        this.jpb.onChangeSkinType();
        this.jpc.onChangeSkinType();
        this.jpd.onChangeSkinType();
        this.jpe.onChangeSkinType();
    }
}
