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
    private static final int iAA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView iAu;
    private ItemTableRowView iAv;
    private ItemTableRowView iAw;
    private ItemTableRowView iAx;
    private ItemTableRowView iAy;
    private SparseArray<ItemTableRowView> iAz;

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
        this.iAy = b(context, 0, 0);
        this.iAx = b(context, 1, iAA);
        this.iAw = b(context, 2, iAA);
        this.iAv = b(context, 3, iAA);
        this.iAu = b(context, 4, iAA);
        this.iAz = new SparseArray<>();
        this.iAz.put(5, this.iAy);
        this.iAz.put(4, this.iAx);
        this.iAz.put(3, this.iAw);
        this.iAz.put(2, this.iAv);
        this.iAz.put(1, this.iAu);
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
                    ItemTableRowView itemTableRowView = this.iAz.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.iAu.clear();
        this.iAv.clear();
        this.iAw.clear();
        this.iAx.clear();
        this.iAy.clear();
    }

    public void onChangeSkinType() {
        this.iAu.onChangeSkinType();
        this.iAv.onChangeSkinType();
        this.iAw.onChangeSkinType();
        this.iAx.onChangeSkinType();
        this.iAy.onChangeSkinType();
    }
}
