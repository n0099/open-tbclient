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
    private static final int iWL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView iWF;
    private ItemTableRowView iWG;
    private ItemTableRowView iWH;
    private ItemTableRowView iWI;
    private ItemTableRowView iWJ;
    private SparseArray<ItemTableRowView> iWK;

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
        this.iWJ = b(context, 0, 0);
        this.iWI = b(context, 1, iWL);
        this.iWH = b(context, 2, iWL);
        this.iWG = b(context, 3, iWL);
        this.iWF = b(context, 4, iWL);
        this.iWK = new SparseArray<>();
        this.iWK.put(5, this.iWJ);
        this.iWK.put(4, this.iWI);
        this.iWK.put(3, this.iWH);
        this.iWK.put(2, this.iWG);
        this.iWK.put(1, this.iWF);
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
                    ItemTableRowView itemTableRowView = this.iWK.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.iWF.clear();
        this.iWG.clear();
        this.iWH.clear();
        this.iWI.clear();
        this.iWJ.clear();
    }

    public void onChangeSkinType() {
        this.iWF.onChangeSkinType();
        this.iWG.onChangeSkinType();
        this.iWH.onChangeSkinType();
        this.iWI.onChangeSkinType();
        this.iWJ.onChangeSkinType();
    }
}
