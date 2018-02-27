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
    private List<d> aMR;
    private int avD;
    private f emG;
    public final ArrayList<f> emH = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.avD = i;
        this.emG = fVar;
    }

    public void setData(List<d> list) {
        this.aMR = list;
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
        return v.D(this.aMR);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.aMR, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.f(this.aMR, i) == null) {
            return -1L;
        }
        return ((d) v.f(this.aMR, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.avD, viewGroup, false);
            f bz = this.emG.bz(view);
            bz.setOnClickListener(this.mOnClickListener);
            view.setTag(bz);
            this.emH.add(bz);
        }
        f fVar = (f) view.getTag();
        if (v.f(this.aMR, i) != null) {
            a(fVar, this.aMR.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void gi(int i) {
        if (v.D(this.emH) > 0) {
            Iterator<f> it = this.emH.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
