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
    private ItemTableRowView jSc;
    private ItemTableRowView jSd;
    private ItemTableRowView jSe;
    private ItemTableRowView jSf;
    private ItemTableRowView jSg;
    private SparseArray<ItemTableRowView> jSh;

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
        this.jSg = c(context, 0, 0);
        this.jSf = c(context, 1, fWC);
        this.jSe = c(context, 2, fWC);
        this.jSd = c(context, 3, fWC);
        this.jSc = c(context, 4, fWC);
        this.jSh = new SparseArray<>();
        this.jSh.put(5, this.jSg);
        this.jSh.put(4, this.jSf);
        this.jSh.put(3, this.jSe);
        this.jSh.put(2, this.jSd);
        this.jSh.put(1, this.jSc);
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
                    ItemTableRowView itemTableRowView = this.jSh.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jSc.clear();
        this.jSd.clear();
        this.jSe.clear();
        this.jSf.clear();
        this.jSg.clear();
    }

    public void onChangeSkinType() {
        this.jSc.onChangeSkinType();
        this.jSd.onChangeSkinType();
        this.jSe.onChangeSkinType();
        this.jSf.onChangeSkinType();
        this.jSg.onChangeSkinType();
    }
}
