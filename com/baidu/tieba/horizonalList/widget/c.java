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
    private List<d> aLK;
    private int avP;
    private f egS;
    public final ArrayList<f> egT = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.avP = i;
        this.egS = fVar;
    }

    public void setData(List<d> list) {
        this.aLK = list;
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
        return v.F(this.aLK);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.aLK, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.f(this.aLK, i) == null) {
            return -1L;
        }
        return ((d) v.f(this.aLK, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.avP, viewGroup, false);
            f by = this.egS.by(view);
            by.setOnClickListener(this.mOnClickListener);
            view.setTag(by);
            this.egT.add(by);
        }
        f fVar = (f) view.getTag();
        if (v.f(this.aLK, i) != null) {
            a(fVar, this.aLK.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void gi(int i) {
        if (v.F(this.egT) > 0) {
            Iterator<f> it = this.egT.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
