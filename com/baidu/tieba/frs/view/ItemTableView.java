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
    private static final int fWC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);
    private ItemTableRowView jSq;
    private ItemTableRowView jSr;
    private ItemTableRowView jSs;
    private ItemTableRowView jSt;
    private ItemTableRowView jSu;
    private SparseArray<ItemTableRowView> jSv;

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
        this.jSu = c(context, 0, 0);
        this.jSt = c(context, 1, fWC);
        this.jSs = c(context, 2, fWC);
        this.jSr = c(context, 3, fWC);
        this.jSq = c(context, 4, fWC);
        this.jSv = new SparseArray<>();
        this.jSv.put(5, this.jSu);
        this.jSv.put(4, this.jSt);
        this.jSv.put(3, this.jSs);
        this.jSv.put(2, this.jSr);
        this.jSv.put(1, this.jSq);
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
                    ItemTableRowView itemTableRowView = this.jSv.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jSq.clear();
        this.jSr.clear();
        this.jSs.clear();
        this.jSt.clear();
        this.jSu.clear();
    }

    public void onChangeSkinType() {
        this.jSq.onChangeSkinType();
        this.jSr.onChangeSkinType();
        this.jSs.onChangeSkinType();
        this.jSt.onChangeSkinType();
        this.jSu.onChangeSkinType();
    }
}
