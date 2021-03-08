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
    private static final int fYc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);
    private ItemTableRowView jTZ;
    private ItemTableRowView jUa;
    private ItemTableRowView jUb;
    private ItemTableRowView jUc;
    private ItemTableRowView jUd;
    private SparseArray<ItemTableRowView> jUe;

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
        this.jUd = c(context, 0, 0);
        this.jUc = c(context, 1, fYc);
        this.jUb = c(context, 2, fYc);
        this.jUa = c(context, 3, fYc);
        this.jTZ = c(context, 4, fYc);
        this.jUe = new SparseArray<>();
        this.jUe.put(5, this.jUd);
        this.jUe.put(4, this.jUc);
        this.jUe.put(3, this.jUb);
        this.jUe.put(2, this.jUa);
        this.jUe.put(1, this.jTZ);
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
                    ItemTableRowView itemTableRowView = this.jUe.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jTZ.clear();
        this.jUa.clear();
        this.jUb.clear();
        this.jUc.clear();
        this.jUd.clear();
    }

    public void onChangeSkinType() {
        this.jTZ.onChangeSkinType();
        this.jUa.onChangeSkinType();
        this.jUb.onChangeSkinType();
        this.jUc.onChangeSkinType();
        this.jUd.onChangeSkinType();
    }
}
