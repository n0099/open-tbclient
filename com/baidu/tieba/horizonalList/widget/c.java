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
public class c extends BaseAdapter {
    private List<d> aMS;
    private int avE;
    private f emW;
    public final ArrayList<f> emX = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.avE = i;
        this.emW = fVar;
    }

    public void setData(List<d> list) {
        this.aMS = list;
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
        return v.D(this.aMS);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.aMS, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.f(this.aMS, i) == null) {
            return -1L;
        }
        return ((d) v.f(this.aMS, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.avE, viewGroup, false);
            f bz = this.emW.bz(view);
            bz.setOnClickListener(this.mOnClickListener);
            view.setTag(bz);
            this.emX.add(bz);
        }
        f fVar = (f) view.getTag();
        if (v.f(this.aMS, i) != null) {
            a(fVar, this.aMS.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void gi(int i) {
        if (v.D(this.emX) > 0) {
            Iterator<f> it = this.emX.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
