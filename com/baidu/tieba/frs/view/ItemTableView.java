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
    private static final int iAu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView iAo;
    private ItemTableRowView iAp;
    private ItemTableRowView iAq;
    private ItemTableRowView iAr;
    private ItemTableRowView iAs;
    private SparseArray<ItemTableRowView> iAt;

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
        this.iAs = b(context, 0, 0);
        this.iAr = b(context, 1, iAu);
        this.iAq = b(context, 2, iAu);
        this.iAp = b(context, 3, iAu);
        this.iAo = b(context, 4, iAu);
        this.iAt = new SparseArray<>();
        this.iAt.put(5, this.iAs);
        this.iAt.put(4, this.iAr);
        this.iAt.put(3, this.iAq);
        this.iAt.put(2, this.iAp);
        this.iAt.put(1, this.iAo);
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
                    ItemTableRowView itemTableRowView = this.iAt.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.iAo.clear();
        this.iAp.clear();
        this.iAq.clear();
        this.iAr.clear();
        this.iAs.clear();
    }

    public void onChangeSkinType() {
        this.iAo.onChangeSkinType();
        this.iAp.onChangeSkinType();
        this.iAq.onChangeSkinType();
        this.iAr.onChangeSkinType();
        this.iAs.onChangeSkinType();
    }
}
