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
    private static final int fUo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds5);
    private ItemTableRowView jLf;
    private ItemTableRowView jLg;
    private ItemTableRowView jLh;
    private ItemTableRowView jLi;
    private ItemTableRowView jLj;
    private SparseArray<ItemTableRowView> jLk;

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
        this.jLj = c(context, 0, 0);
        this.jLi = c(context, 1, fUo);
        this.jLh = c(context, 2, fUo);
        this.jLg = c(context, 3, fUo);
        this.jLf = c(context, 4, fUo);
        this.jLk = new SparseArray<>();
        this.jLk.put(5, this.jLj);
        this.jLk.put(4, this.jLi);
        this.jLk.put(3, this.jLh);
        this.jLk.put(2, this.jLg);
        this.jLk.put(1, this.jLf);
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
                    ItemTableRowView itemTableRowView = this.jLk.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.jLf.clear();
        this.jLg.clear();
        this.jLh.clear();
        this.jLi.clear();
        this.jLj.clear();
    }

    public void onChangeSkinType() {
        this.jLf.onChangeSkinType();
        this.jLg.onChangeSkinType();
        this.jLh.onChangeSkinType();
        this.jLi.onChangeSkinType();
        this.jLj.onChangeSkinType();
    }
}
