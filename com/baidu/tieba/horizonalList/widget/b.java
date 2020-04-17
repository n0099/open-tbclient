package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<c> dataList;
    public final ArrayList<e> elf = new ArrayList<>();
    private e hVj;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.hVj = eVar;
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
        return v.getCount(this.dataList);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.dataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getItem(this.dataList, i) == null) {
            return -1L;
        }
        return ((c) v.getItem(this.dataList, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e bI = this.hVj.bI(view);
            bI.setOnClickListener(this.mOnClickListener);
            view.setTag(bI);
            this.elf.add(bI);
        }
        e eVar = (e) view.getTag();
        if (v.getItem(this.dataList, i) != null) {
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
        if (v.getCount(this.elf) > 0) {
            Iterator<e> it = this.elf.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
