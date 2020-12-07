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
    private static final int fPs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);
    private ItemTableRowView jDh;
    private ItemTableRowView jDi;
    private ItemTableRowView jDj;
    private ItemTableRowView jDk;
    private ItemTableRowView jDl;
    private SparseArray<ItemTableRowView> jDm;

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
        this.jDl = c(context, 0, 0);
        this.jDk = c(context, 1, fPs);
        this.jDj = c(context, 2, fPs);
        this.jDi = c(context, 3, fPs);
        this.jDh = c(context, 4, fPs);
        this.jDm = new SparseArray<>();
        this.jDm.put(5, this.jDl);
        this.jDm.put(4, this.jDk);
        this.jDm.put(3, this.jDj);
        this.jDm.put(2, this.jDi);
        this.jDm.put(1, this.jDh);
    }

    private ItemTableRowView c(Context context, int i, int i2) {
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
                    ItemTableRowView itemTableRowView = this.jDm.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jDh.clear();
        this.jDi.clear();
        this.jDj.clear();
        this.jDk.clear();
        this.jDl.clear();
    }

    public void onChangeSkinType() {
        this.jDh.onChangeSkinType();
        this.jDi.onChangeSkinType();
        this.jDj.onChangeSkinType();
        this.jDk.onChangeSkinType();
        this.jDl.onChangeSkinType();
    }
}
