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
/* loaded from: classes16.dex */
public class ItemTableView extends LinearLayout {
    private static final int ims = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView imm;
    private ItemTableRowView imn;
    private ItemTableRowView imo;
    private ItemTableRowView imp;
    private ItemTableRowView imq;
    private SparseArray<ItemTableRowView> imr;

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
        this.imq = b(context, 0, 0);
        this.imp = b(context, 1, ims);
        this.imo = b(context, 2, ims);
        this.imn = b(context, 3, ims);
        this.imm = b(context, 4, ims);
        this.imr = new SparseArray<>();
        this.imr.put(5, this.imq);
        this.imr.put(4, this.imp);
        this.imr.put(3, this.imo);
        this.imr.put(2, this.imn);
        this.imr.put(1, this.imm);
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
                    ItemTableRowView itemTableRowView = this.imr.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.imm.clear();
        this.imn.clear();
        this.imo.clear();
        this.imp.clear();
        this.imq.clear();
    }

    public void onChangeSkinType() {
        this.imm.onChangeSkinType();
        this.imn.onChangeSkinType();
        this.imo.onChangeSkinType();
        this.imp.onChangeSkinType();
        this.imq.onChangeSkinType();
    }
}
