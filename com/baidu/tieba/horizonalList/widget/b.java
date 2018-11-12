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
    private List<c> aom;
    public final ArrayList<e> bjz = new ArrayList<>();
    private e esd;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.esd = eVar;
    }

    public void setData(List<c> list) {
        this.aom = list;
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
        return v.H(this.aom);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.aom, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.d(this.aom, i) == null) {
            return -1L;
        }
        return ((c) v.d(this.aom, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e ay = this.esd.ay(view);
            ay.setOnClickListener(this.mOnClickListener);
            view.setTag(ay);
            this.bjz.add(ay);
        }
        e eVar = (e) view.getTag();
        if (v.d(this.aom, i) != null) {
            a(eVar, this.aom.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void dV(int i) {
        if (v.H(this.bjz) > 0) {
            Iterator<e> it = this.bjz.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
