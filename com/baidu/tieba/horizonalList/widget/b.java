package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<c> dataList;
    public final ArrayList<e> far = new ArrayList<>();
    private e iWT;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.iWT = eVar;
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
        return y.getCount(this.dataList);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.dataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getItem(this.dataList, i) == null) {
            return -1L;
        }
        return ((c) y.getItem(this.dataList, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e bT = this.iWT.bT(view);
            bT.setOnClickListener(this.mOnClickListener);
            view.setTag(bT);
            this.far.add(bT);
        }
        e eVar = (e) view.getTag();
        if (y.getItem(this.dataList, i) != null) {
            a(eVar, this.dataList.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (y.getCount(this.far) > 0) {
            Iterator<e> it = this.far.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
