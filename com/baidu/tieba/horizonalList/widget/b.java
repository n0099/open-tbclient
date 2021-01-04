package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<c> dataList;
    public final ArrayList<ItemViewHolder> fUL = new ArrayList<>();
    private ItemViewHolder koC;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, ItemViewHolder itemViewHolder) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.koC = itemViewHolder;
    }

    public void setData(List<c> list) {
        this.dataList = list;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.dataList);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.getItem(this.dataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.getItem(this.dataList, i) == null) {
            return -1L;
        }
        return ((c) x.getItem(this.dataList, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            ItemViewHolder cK = this.koC.cK(view);
            cK.setOnClickListener(this.mOnClickListener);
            view.setTag(cK);
            this.fUL.add(cK);
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (x.getItem(this.dataList, i) != null) {
            a(itemViewHolder, this.dataList.get(i));
        }
        return itemViewHolder.getView();
    }

    private void a(ItemViewHolder itemViewHolder, c cVar) {
        if (cVar != null && itemViewHolder != null) {
            itemViewHolder.a(cVar);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (x.getCount(this.fUL) > 0) {
            Iterator<ItemViewHolder> it = this.fUL.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
