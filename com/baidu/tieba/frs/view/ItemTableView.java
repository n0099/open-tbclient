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
/* loaded from: classes9.dex */
public class ItemTableView extends LinearLayout {
    private static final int igm = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15);
    private ItemTableRowView igg;
    private ItemTableRowView igh;
    private ItemTableRowView igi;
    private ItemTableRowView igj;
    private ItemTableRowView igk;
    private SparseArray<ItemTableRowView> igl;

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
        this.igk = b(context, 0, 0);
        this.igj = b(context, 1, igm);
        this.igi = b(context, 2, igm);
        this.igh = b(context, 3, igm);
        this.igg = b(context, 4, igm);
        this.igl = new SparseArray<>();
        this.igl.put(5, this.igk);
        this.igl.put(4, this.igj);
        this.igl.put(3, this.igi);
        this.igl.put(2, this.igh);
        this.igl.put(1, this.igg);
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
                    ItemTableRowView itemTableRowView = this.igl.get(intValue);
                    if (itemTableRowView != null) {
                        itemTableRowView.setData(intValue2);
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        this.igg.clear();
        this.igh.clear();
        this.igi.clear();
        this.igj.clear();
        this.igk.clear();
    }

    public void onChangeSkinType() {
        this.igg.onChangeSkinType();
        this.igh.onChangeSkinType();
        this.igi.onChangeSkinType();
        this.igj.onChangeSkinType();
        this.igk.onChangeSkinType();
    }
}
