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
    private static final int fHF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);
    private ItemTableRowView jpH;
    private ItemTableRowView jpI;
    private ItemTableRowView jpJ;
    private ItemTableRowView jpK;
    private ItemTableRowView jpL;
    private SparseArray<ItemTableRowView> jpM;

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
        this.jpL = b(context, 0, 0);
        this.jpK = b(context, 1, fHF);
        this.jpJ = b(context, 2, fHF);
        this.jpI = b(context, 3, fHF);
        this.jpH = b(context, 4, fHF);
        this.jpM = new SparseArray<>();
        this.jpM.put(5, this.jpL);
        this.jpM.put(4, this.jpK);
        this.jpM.put(3, this.jpJ);
        this.jpM.put(2, this.jpI);
        this.jpM.put(1, this.jpH);
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
                    ItemTableRowView itemTableRowView = this.jpM.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jpH.clear();
        this.jpI.clear();
        this.jpJ.clear();
        this.jpK.clear();
        this.jpL.clear();
    }

    public void onChangeSkinType() {
        this.jpH.onChangeSkinType();
        this.jpI.onChangeSkinType();
        this.jpJ.onChangeSkinType();
        this.jpK.onChangeSkinType();
        this.jpL.onChangeSkinType();
    }
}
