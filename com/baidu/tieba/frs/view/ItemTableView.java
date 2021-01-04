package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.ItemPlot;
/* loaded from: classes2.dex */
public class ItemTableView extends LinearLayout {
    private static final int fYV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);
    private ItemTableRowView jPL;
    private ItemTableRowView jPM;
    private ItemTableRowView jPN;
    private ItemTableRowView jPO;
    private ItemTableRowView jPP;
    private SparseArray<ItemTableRowView> jPQ;

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
        this.jPP = c(context, 0, 0);
        this.jPO = c(context, 1, fYV);
        this.jPN = c(context, 2, fYV);
        this.jPM = c(context, 3, fYV);
        this.jPL = c(context, 4, fYV);
        this.jPQ = new SparseArray<>();
        this.jPQ.put(5, this.jPP);
        this.jPQ.put(4, this.jPO);
        this.jPQ.put(3, this.jPN);
        this.jPQ.put(2, this.jPM);
        this.jPQ.put(1, this.jPL);
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
                    ItemTableRowView itemTableRowView = this.jPQ.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jPL.clear();
        this.jPM.clear();
        this.jPN.clear();
        this.jPO.clear();
        this.jPP.clear();
    }

    public void onChangeSkinType() {
        this.jPL.onChangeSkinType();
        this.jPM.onChangeSkinType();
        this.jPN.onChangeSkinType();
        this.jPO.onChangeSkinType();
        this.jPP.onChangeSkinType();
    }
}
