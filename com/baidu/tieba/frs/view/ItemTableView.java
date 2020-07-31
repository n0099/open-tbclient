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
    private static final int imq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView imk;
    private ItemTableRowView iml;
    private ItemTableRowView imm;
    private ItemTableRowView imn;
    private ItemTableRowView imo;
    private SparseArray<ItemTableRowView> imp;

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
        this.imo = b(context, 0, 0);
        this.imn = b(context, 1, imq);
        this.imm = b(context, 2, imq);
        this.iml = b(context, 3, imq);
        this.imk = b(context, 4, imq);
        this.imp = new SparseArray<>();
        this.imp.put(5, this.imo);
        this.imp.put(4, this.imn);
        this.imp.put(3, this.imm);
        this.imp.put(2, this.iml);
        this.imp.put(1, this.imk);
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
                    ItemTableRowView itemTableRowView = this.imp.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.imk.clear();
        this.iml.clear();
        this.imm.clear();
        this.imn.clear();
        this.imo.clear();
    }

    public void onChangeSkinType() {
        this.imk.onChangeSkinType();
        this.iml.onChangeSkinType();
        this.imm.onChangeSkinType();
        this.imn.onChangeSkinType();
        this.imo.onChangeSkinType();
    }
}
