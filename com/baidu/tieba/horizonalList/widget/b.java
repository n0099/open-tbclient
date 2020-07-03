package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<c> dataList;
    public final ArrayList<e> eJp = new ArrayList<>();
    private e iBP;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.iBP = eVar;
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
        return w.getCount(this.dataList);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.getItem(this.dataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.getItem(this.dataList, i) == null) {
            return -1L;
        }
        return ((c) w.getItem(this.dataList, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e bL = this.iBP.bL(view);
            bL.setOnClickListener(this.mOnClickListener);
            view.setTag(bL);
            this.eJp.add(bL);
        }
        e eVar = (e) view.getTag();
        if (w.getItem(this.dataList, i) != null) {
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
        if (w.getCount(this.eJp) > 0) {
            Iterator<e> it = this.eJp.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
