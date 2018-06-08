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
    private List<c> agv;
    public final ArrayList<e> baa = new ArrayList<>();
    private e dTN;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.dTN = eVar;
    }

    public void setData(List<c> list) {
        this.agv = list;
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
        return w.y(this.agv);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.c(this.agv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.c(this.agv, i) == null) {
            return -1L;
        }
        return ((c) w.c(this.agv, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e ad = this.dTN.ad(view);
            ad.setOnClickListener(this.mOnClickListener);
            view.setTag(ad);
            this.baa.add(ad);
        }
        e eVar = (e) view.getTag();
        if (w.c(this.agv, i) != null) {
            a(eVar, this.agv.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void dk(int i) {
        if (w.y(this.baa) > 0) {
            Iterator<e> it = this.baa.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
