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
    private static final int jji = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView jjc;
    private ItemTableRowView jjd;
    private ItemTableRowView jje;
    private ItemTableRowView jjf;
    private ItemTableRowView jjg;
    private SparseArray<ItemTableRowView> jjh;

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
        this.jjg = b(context, 0, 0);
        this.jjf = b(context, 1, jji);
        this.jje = b(context, 2, jji);
        this.jjd = b(context, 3, jji);
        this.jjc = b(context, 4, jji);
        this.jjh = new SparseArray<>();
        this.jjh.put(5, this.jjg);
        this.jjh.put(4, this.jjf);
        this.jjh.put(3, this.jje);
        this.jjh.put(2, this.jjd);
        this.jjh.put(1, this.jjc);
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
                    ItemTableRowView itemTableRowView = this.jjh.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jjc.clear();
        this.jjd.clear();
        this.jje.clear();
        this.jjf.clear();
        this.jjg.clear();
    }

    public void onChangeSkinType() {
        this.jjc.onChangeSkinType();
        this.jjd.onChangeSkinType();
        this.jje.onChangeSkinType();
        this.jjf.onChangeSkinType();
        this.jjg.onChangeSkinType();
    }
}
