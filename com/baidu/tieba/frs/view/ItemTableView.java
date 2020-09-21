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
/* loaded from: classes21.dex */
public class ItemTableView extends LinearLayout {
    private static final int iHV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView iHP;
    private ItemTableRowView iHQ;
    private ItemTableRowView iHR;
    private ItemTableRowView iHS;
    private ItemTableRowView iHT;
    private SparseArray<ItemTableRowView> iHU;

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
        this.iHT = b(context, 0, 0);
        this.iHS = b(context, 1, iHV);
        this.iHR = b(context, 2, iHV);
        this.iHQ = b(context, 3, iHV);
        this.iHP = b(context, 4, iHV);
        this.iHU = new SparseArray<>();
        this.iHU.put(5, this.iHT);
        this.iHU.put(4, this.iHS);
        this.iHU.put(3, this.iHR);
        this.iHU.put(2, this.iHQ);
        this.iHU.put(1, this.iHP);
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
                    ItemTableRowView itemTableRowView = this.iHU.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.iHP.clear();
        this.iHQ.clear();
        this.iHR.clear();
        this.iHS.clear();
        this.iHT.clear();
    }

    public void onChangeSkinType() {
        this.iHP.onChangeSkinType();
        this.iHQ.onChangeSkinType();
        this.iHR.onChangeSkinType();
        this.iHS.onChangeSkinType();
        this.iHT.onChangeSkinType();
    }
}
